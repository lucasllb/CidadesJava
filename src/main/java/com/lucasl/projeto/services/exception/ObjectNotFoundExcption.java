package com.lucasl.projeto.services.exception;

public class ObjectNotFoundExcption extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundExcption(String msg) {
		super(msg);
	}
}
