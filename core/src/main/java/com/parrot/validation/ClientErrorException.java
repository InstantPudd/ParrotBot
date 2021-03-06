package com.parrot.validation;

public class ClientErrorException extends RuntimeException{

	private ClientErrorStatusCode statusCode;

	public ClientErrorStatusCode getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(ClientErrorStatusCode statusCode) {
		this.statusCode = statusCode;
	}

	public ClientErrorException(ClientErrorStatusCode statusCode) {
		this.statusCode = statusCode;
	}

	public ClientErrorException(ClientErrorStatusCode statusCode, String errorMessage) {
		super(errorMessage);
		this.statusCode = statusCode;
	}
}
