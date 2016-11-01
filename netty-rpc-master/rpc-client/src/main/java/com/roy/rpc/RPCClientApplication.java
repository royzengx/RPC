package com.roy.rpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.roy.rpc.proxy.RpcProxyFactory;
import com.roy.rpc.service.demo.HelloService;

/**
 * 
 * @author Roy
 *
 */
@SpringBootApplication
public class RPCClientApplication {

    public static void main(String[] args){
        SpringApplication app = new SpringApplication(RPCClientApplication.class);
        app.setWebEnvironment(false);
        app.run(args);
    }
    
    @Bean
    public RpcProxyFactory rpcProxyFactory(){
        return new RpcProxyFactory();
    }

    /**
     * @param rpcProxyFactory
     * @return
     */
    @Bean
    public HelloService buildHelloService(RpcProxyFactory rpcProxyFactory){
    	return rpcProxyFactory.proxyBean(HelloService.class, 10000);
    }

}
