package com.roy.rpc.common.exception;

/**
 * 
 * @author Roy
 *
 */
public class RpcException extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3971523755958046765L;

	protected RpcException(final String errorMessage, final Object... args) {
        super(String.format(errorMessage, args));
    }

    protected RpcException(final String errorMessage, final Exception cause, final Object... args) {
        super(String.format(errorMessage, args), cause);
    }

    protected RpcException(final Exception cause) {
        super(cause.getMessage(), cause);
    }
}
