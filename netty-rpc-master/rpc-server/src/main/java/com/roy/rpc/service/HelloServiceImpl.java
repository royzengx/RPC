package com.roy.rpc.service;

import com.roy.rpc.common.annotation.ServiceExporter;
import com.roy.rpc.service.demo.HelloService;

/**
 * 
 * @author Roy
 *
 */
@ServiceExporter(value = "demoSvr", targetInterface = HelloService.class, debugAddress = "127.0.0.1:9090")
public class HelloServiceImpl implements HelloService {
	public String say(String name) {
		return "hi:" + name;
	}
}
