/**
 * 
 */
package com.sap.mi.gfw.features.impl;

import com.sap.mi.gfw.features.IReason;

/**
 * The Class Reason.
 */
public class Reason implements IReason {
	private static final String FALSE_REASON_TEXT = ""; //$NON-NLS-1$

	private static final String TRUE_REASON_TEXT = ""; //$NON-NLS-1$

	/**
	 * Creates the false reason.
	 * 
	 * @return the i reason
	 */
	public static IReason createFalseReason() {
		return createFalseReason(FALSE_REASON_TEXT);
	}

	/**
	 * Creates the false reason.
	 * 
	 * @param string
	 *            the string
	 * @return the i reason
	 */
	public static IReason createFalseReason(String string) {
		return new Reason(false, string);
	}

	/**
	 * Creates the true reason.
	 * 
	 * @return the i reason
	 */
	public static IReason createTrueReason() {
		return createTrueReason(TRUE_REASON_TEXT);
	}

	/**
	 * Creates the true reason.
	 * 
	 * @param string
	 *            the string
	 * @return the i reason
	 */
	public static IReason createTrueReason(String string) {
		return new Reason(true, string);
	}

	private boolean bool;

	private String text;

	/**
	 * Instantiates a new reason.
	 * 
	 * @param b
	 *            the b
	 */
	public Reason(boolean b) {
		super();
		setBool(b);
	}

	/**
	 * Instantiates a new reason.
	 * 
	 * @param b
	 *            the b
	 * @param reasonText
	 *            the reason text
	 */
	public Reason(boolean b, String reasonText) {
		this(b);
		setText(reasonText);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IReason#getText()
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the bool.
	 * 
	 * @param bool
	 *            the new bool
	 */
	public void setBool(boolean bool) {
		this.bool = bool;
	}

	/**
	 * Sets the text.
	 * 
	 * @param reasonText
	 *            the new text
	 */
	public void setText(String reasonText) {
		text = reasonText;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IReason#toBoolean()
	 */
	public boolean toBoolean() {
		return bool;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + " bool: " + bool + "; text: " + text; //$NON-NLS-1$ //$NON-NLS-2$
	}
}
