package com.sap.mi.gfw.eclipse.internal.contextbuttons;

/**
 * This transparency provider interface can be implemented to provide the 'current transparency'. The 'current transparency' value is
 * multiplied with any other transparency/opacity values of a figure before painting. It is basically a central adjustment of the
 * transparency value(s) of a figure.
 * <p>
 * The idea is, that a transparency provider could increase/decrease the current transparency in a loop, which would result in a fade in/out
 * effect of the figure.
 * 
 */
interface ITransparencyProvider {

	// TODO: enhance this interface
	// If this should become a globally used interface, then we need a set-method instead of a get-method, because otherwise the
	// figures do not know when the current transparency changes.

	/**
	 * Returns the current transparency as described above.
	 * 
	 * @return The current transparency as described above.
	 */
	double getCurrentTransparency();
}
