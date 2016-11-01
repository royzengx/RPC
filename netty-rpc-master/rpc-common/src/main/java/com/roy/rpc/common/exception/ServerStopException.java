package com.roy.rpc.common.exception;

/**
 * 
 * @author Roy
 *
 */
public class ServerStopException extends RpcException{

    /**
	 * 
	 */
	private static final long serialVersionUID = 7985141418651841555L;
	private static final String MESSAGE = "Can't stop this server, because the server didn't start yet.";

    public ServerStopException() {
        super(MESSAGE);
    }
}
