package com.sap.furcas.runtime.parser.impl;

/** this class is used to store the same values as the model element
 * does. Since that is a Model generated interface it is not implemented here. 
 * This class is needed to transport the data to the actual parser.
 * @author C5127705
 *
 */
public class PredicateSemantic {

	private final String when;
	private final String as;
	public PredicateSemantic(String when, String as) {
		super();
		this.when = when;
		this.as = as;
	}
	public String getWhen() {
		return when;
	}
	public String getAs() {
		return as;
	}
	
	
}
