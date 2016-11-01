package com.roy.rpc.spring;

import com.roy.rpc.proxy.RpcProxy;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.lang.reflect.Proxy;

/**
 * 
 * @author Roy
 *
 * @param <T>
 */
public class SpringProxyFactoryBean<T> implements InitializingBean, FactoryBean<T> {

	private String innerClassName;

	@SuppressWarnings("unused")
	private int timeoutInMillis;

	public void setInnerClassName(String innerClassName) {
		this.innerClassName = innerClassName;
	}

	@SuppressWarnings("unchecked")
	public T getObject() throws Exception {
		Class<?> innerClass = Class.forName(innerClassName);
		// if (innerClass.isInterface()) {
		// return (T) InterfaceProxy.newInstance(innerClass);
		// } else {
		// Enhancer enhancer = new Enhancer();
		// enhancer.setSuperclass(innerClass);
		// enhancer.setNamingPolicy(SpringNamingPolicy.INSTANCE);
		// enhancer.setCallback(new MethodInterceptorImpl());
		// return (T) enhancer.create();
		// }
		return (T) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[] { innerClass }, new RpcProxy());
	}

	public Class<?> getObjectType() {
		try {
			return Class.forName(innerClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean isSingleton() {
		return true;
	}

	public void afterPropertiesSet() throws Exception {

	}
}
