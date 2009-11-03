package com.sap.tc.moin.versioning.di.impl;

public class PreparationExeption extends RuntimeException {

	private static final long serialVersionUID = -8651895194728009767L;
	private String localizedMessage;
	
	PreparationExeption(String message, String localizedMessage) {
		super(message);
		this.localizedMessage = localizedMessage;
	}

	@Override
	public String getLocalizedMessage() {
		return localizedMessage;
	}
	
	
}
