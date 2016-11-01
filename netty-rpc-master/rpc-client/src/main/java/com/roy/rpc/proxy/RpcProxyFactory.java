package com.roy.rpc.proxy;

import com.roy.rpc.client.NettyClient;
import com.roy.rpc.client.NettyClientFactory;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author Roy
 *
 */
@Component
public class RpcProxyFactory {

	@SuppressWarnings("unchecked")
	public <T> T proxyBean(Class<?> targetInterface, long timeoutInMillis) {
		NettyClient client = NettyClientFactory.get(targetInterface);
		return (T) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[] { targetInterface },
				new RpcProxy(client, Pair.of(timeoutInMillis, TimeUnit.MILLISECONDS)));
	}
}
