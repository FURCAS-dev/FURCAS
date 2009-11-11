package com.sap.ide.moftool.editor.core.commands;

public class InternalErrorException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InternalErrorException(String message) {
		super(message);
	}

	public InternalErrorException(Throwable cause) {
		super(cause);
	}
}
