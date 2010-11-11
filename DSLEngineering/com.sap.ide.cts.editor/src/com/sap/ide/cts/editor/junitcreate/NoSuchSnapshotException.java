package com.sap.ide.cts.editor.junitcreate;

public class NoSuchSnapshotException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoSuchSnapshotException() {
	}

	public NoSuchSnapshotException(String message) {
		super(message);
	}

	public NoSuchSnapshotException(Throwable cause) {
		super(cause);
	}

	public NoSuchSnapshotException(String message, Throwable cause) {
		super(message, cause);
	}

}
