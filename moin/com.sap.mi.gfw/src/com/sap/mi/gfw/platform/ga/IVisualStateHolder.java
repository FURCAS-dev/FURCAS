package com.sap.mi.gfw.platform.ga;

/**
 * This interface provides access to an {@link IVisualState}.
 */
public interface IVisualStateHolder {

	// TODO
	// The visual state must be inherited from the parent, like the colors
	// => getVisualState() and getOwnVisualState()

	/**
	 * Returns the {@link IVisualState}. Must not be null.
	 * 
	 * @return The {@link IVisualState}. Must not be null.
	 */
	IVisualState getVisualState();
}
