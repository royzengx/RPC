package com.roy.rpc.common.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 
 * @author Roy
 *
 */
public class RpcRequest {

	// request Id
	private String traceId;

	// for Authentication validate.
	private String appName;

	private String token;

	private String userId;

	// call class name.
	private String className;

	// call method name.
	private String methodName;

	// parameter type.
	private Class<?>[] parameterTypes;

	// parameter value.
	private Object[] parameters;

	public RpcRequest() {
	}

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Class<?>[] getParameterTypes() {
		return parameterTypes;
	}

	public void setParameterTypes(Class<?>[] parameterTypes) {
		this.parameterTypes = parameterTypes;
	}

	public Object[] getParameters() {
		return parameters;
	}

	public void setParameters(Object[] parameters) {
		this.parameters = parameters;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
