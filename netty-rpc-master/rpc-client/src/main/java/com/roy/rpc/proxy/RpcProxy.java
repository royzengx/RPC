package com.roy.rpc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.roy.rpc.client.NettyClient;
import com.roy.rpc.common.dto.RpcRequest;
import com.roy.rpc.common.dto.RpcResponse;

/**
 * 利用代理优化远程调用
 * 使之像本地调用一样
 */
public class RpcProxy implements InvocationHandler {
	
	private final static Logger log = LoggerFactory.getLogger(RpcProxy.class);

    private NettyClient nettyClient;
    private Pair<Long,TimeUnit> timeout;

    public RpcProxy() {
    }

    public RpcProxy(NettyClient nettyClient, Pair<Long, TimeUnit> timeout) {
        this.nettyClient = nettyClient;
        this.timeout = timeout;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    	// Create and initialize a RPC request.
        RpcRequest request = new RpcRequest();
        request.setTraceId(UUID.randomUUID().toString());
        request.setClassName(method.getDeclaringClass().getName());
        request.setMethodName(method.getName());
        request.setParameterTypes(method.getParameterTypes());
        request.setParameters(args);
        
        log.info("Current parameter of request is: <TraceId=" 
        		+ request.getTraceId() + ", ClassName="
        		+ request.getClassName() + ", MethodName="
        		+ request.getMethodName() + ", ParameterTypes="
        		+ request.getParameterTypes() + ", Parameters="
        		+ request.getParameters().toString());

		RpcResponse response = null;
		if (timeout == null) {
			response = nettyClient.syncSend(request);
		} else {
			response = nettyClient.asyncSend(request, timeout);
		}

		if (response.isError()) {
			throw response.getError();
		} else {
			return response.getResult();
		}
    }
}
