package com.sap.mi.gfw.pattern;

import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * The Interface IFeatureProviderWithPatterns.
 */
public interface IFeatureProviderWithPatterns extends IPatternContainer {

	/**
	 * Activate direct editing for patterns.
	 * 
	 * @param mainPictogramElement
	 *            the main pictogram element
	 * @param bo
	 *            the bo
	 */
	void activateDirectEditingForPatterns(PictogramElement mainPictogramElement, Object bo);

	/**
	 * Activate direct editing for patterns.
	 * 
	 * @param mainPictogramElement
	 *            the main pictogram element
	 * @param bo
	 *            the bo
	 * @param keyProperty
	 *            the key property
	 */
	void activateDirectEditingForPatterns(PictogramElement mainPictogramElement, Object bo, String keyProperty);

	/**
	 * Gets the pattern for pictogram element.
	 * 
	 * @param pictogramElement
	 *            the pictogram element
	 * 
	 * @return the pattern for pictogram element
	 */
	IPattern getPatternForPictogramElement(PictogramElement pictogramElement);
}
