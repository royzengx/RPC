package com.roy.rpc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.roy.rpc.service.demo.HelloService;

/**
 * User CommandLineRunner method to run the test.
 * @author Roy
 *
 */
@Component
public class DemoTestRunner implements CommandLineRunner{
	
	private Logger log = LoggerFactory.getLogger(DemoTestRunner.class);

    @Autowired
    HelloService helloService;

    @Override
    public void run(String... strings) throws Exception {
    	log.info(helloService.say("The demo applications"));
    }
}
