package com.roy.rpc.common.exception;

/**
 * 
 * @author Roy
 *
 */
public class ServerException extends RpcException{

    /**
	 * 
	 */
	private static final long serialVersionUID = 5726936121168975326L;
	private String traceId;

    public ServerException(String traceId, final Exception cause) {
        super(cause);
        this.traceId = traceId;
    }

    public String getTraceId() {
        return traceId;
    }
}
