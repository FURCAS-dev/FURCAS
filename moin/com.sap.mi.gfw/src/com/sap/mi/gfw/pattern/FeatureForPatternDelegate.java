package com.sap.mi.gfw.pattern;

/**
 * The Class FeatureForPatternDelegate.
 */
public class FeatureForPatternDelegate implements IFeatureForPattern {

	private IPattern pattern;

	/**
	 * Instantiates a new feature for pattern delegate.
	 * 
	 * @param pattern
	 *            the pattern
	 */
	public FeatureForPatternDelegate(IPattern pattern) {
		super();
		setPattern(pattern);
	}

	/**
	 * Gets the pattern.
	 * 
	 * @return Returns the pattern.
	 */
	public IPattern getPattern() {
		return pattern;
	}

	/**
	 * @param pattern
	 *            The pattern to set.
	 */
	private void setPattern(IPattern pattern) {
		this.pattern = pattern;
	}

}
