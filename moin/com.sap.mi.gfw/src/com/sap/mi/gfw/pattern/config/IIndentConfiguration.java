package com.sap.mi.gfw.pattern.config;

/**
 * The Interface IIndentConfiguration.
 */
public interface IIndentConfiguration extends IPatternConfiguration {

	/**
	 * Gets the outer indent bottom.
	 * 
	 * @return the outer indent bottom
	 */
	int getOuterIndentBottom();

	/**
	 * Gets the outer indent left.
	 * 
	 * @return the outer indent left
	 */
	int getOuterIndentLeft();

	/**
	 * Gets the outer indent right.
	 * 
	 * @return the outer indent right
	 */
	int getOuterIndentRight();

	/**
	 * Gets the outer indent top.
	 * 
	 * @return the outer indent top
	 */
	int getOuterIndentTop();

	/**
	 * Sets the outer indent bottom.
	 * 
	 * @param outerIndentBottom
	 *            the new outer indent bottom
	 */
	void setOuterIndentBottom(int outerIndentBottom);

	/**
	 * Sets the outer indent left.
	 * 
	 * @param outerIndentLeft
	 *            the new outer indent left
	 */
	void setOuterIndentLeft(int outerIndentLeft);

	/**
	 * Sets the outer indent right.
	 * 
	 * @param outerIndentRight
	 *            the new outer indent right
	 */
	void setOuterIndentRight(int outerIndentRight);

	/**
	 * Sets the outer indent top.
	 * 
	 * @param outerIndentTop
	 *            the new outer indent top
	 */
	void setOuterIndentTop(int outerIndentTop);

}
