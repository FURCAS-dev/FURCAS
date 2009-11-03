package com.sap.mi.gfw.internal.util;

import com.sap.mi.gfw.util.ILook;

/**
 * The Class LookManager.
 */
public class LookManager {

	private static ILook currentLook;

	private static ILook defaultLook;

	private static ILook dynamicLook;

	/**
	 * Gets the look.
	 * 
	 * @return the look
	 */
	public static ILook getLook() {
		if (currentLook == null) {
			currentLook = getDefaultLook();
		}
		return currentLook;
	}

	public static void setDynamicLook(boolean dynamic) {
		if (dynamic) {
			currentLook = getDynamicLook();
		} else {
			currentLook = getDefaultLook();
		}
	}

	private static ILook getDefaultLook() {
		if (defaultLook == null) {
			defaultLook = new DefaultLook();
		}
		return defaultLook;
	}

	private static ILook getDynamicLook() {
		if (dynamicLook == null) {
			dynamicLook = new DynamicLook();
		}
		return dynamicLook;
	}
}
