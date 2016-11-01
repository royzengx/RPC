package com.roy.rpc.common.exception;

/**
 * 
 * @author Roy
 *
 */
public class ClientCloseException extends RpcException{

    /**
	 * 
	 */
	private static final long serialVersionUID = 7555601160189925136L;
	private static final String MESSAGE = "Can't close this client, beacuse the client didn't connect a server.";

    public ClientCloseException() {
        super(MESSAGE);
    }
}
