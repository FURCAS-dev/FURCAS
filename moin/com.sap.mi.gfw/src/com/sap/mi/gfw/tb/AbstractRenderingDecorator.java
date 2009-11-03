package com.sap.mi.gfw.tb;

/**
 * The Class AbstractRenderingDecorator.
 */
public abstract class AbstractRenderingDecorator implements IRenderingDecorator {

	private String message;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.IRenderingDecorator#getMessage()
	 */
	public String getMessage() {
		return message;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.IRenderingDecorator#setMessage(java.lang.String)
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
