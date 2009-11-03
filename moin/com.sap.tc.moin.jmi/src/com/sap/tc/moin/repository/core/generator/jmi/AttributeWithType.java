package com.sap.tc.moin.repository.core.generator.jmi;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;

public class AttributeWithType implements Comparable {

	private String name;
	private Attribute attribute;
	private String type;
	private Classifier classifier;
	private MultiplicityType multiplicity;


	/**
	 *  Constructor for the AttributeWithType object
	 *
	 *@param  name  Description of the Parameter
	 *@param  type  Description of the Parameter
	 */
	public AttributeWithType(String name, String type) {
		setName(name);
		setType(type);
	}

	public AttributeWithType(String name, String type, Attribute attribute) {
		setName(name);
		setType(type);
		setAttribute(attribute);
	}

	/**
	 *  Gets the name attribute of the AttributeWithType object
	 *
	 *@return    The name value
	 */
	public String getName() {
		return name;
	}

	/**
	 *  Sets the name attribute of the AttributeWithType object
	 *
	 *@param  name  The new name value
	 */
	final public void setName(String name) {
		this.name = name;
	}

	/**
	 *  Sets the type attribute of the AttributeWithType object
	 *
	 *@param  type  The new type value
	 */
	final public void setType(String type) {
		this.type = type;
	}

	/**
	 *  Gets the type attribute of the AttributeWithType object
	 *
	 *@return    The type value
	 */
	public String getType() {
		return type;
	}

	/**
	 *  Description of the Method
	 *
	 *@param  o  Description of the Parameter
	 *@return    Description of the Return Value
	 */
	public int compareTo(java.lang.Object o) {
		int res = 0;
		if (o instanceof AttributeWithType) {
			AttributeWithType a = (AttributeWithType) o;
			res = name.compareTo(a.getName());
			if (res == 0) {
				res = type.compareTo(a.getType());
			}
		}
		return res;
	}
	/**
	 * Returns the classifier.
	 * @return Classifier
	 */
	public Classifier getClassifier() {
		return classifier;
	}

	/**
	 * Sets the classifier.
	 * @param classifier The classifier to set
	 */
	public void setClassifier(Classifier classifier) {
		this.classifier = classifier;
	}

	/**
	 * @return
	 */
	public MultiplicityType getMultiplicity() {
		if (attribute != null) {
			return attribute.getMultiplicity();
		}
		return multiplicity;
	}

	/**
	 * @param type
	 */
	public void setMultiplicity(MultiplicityType type) {
		multiplicity = type;
	}

	/**
	 * @return
	 */
	public Attribute getAttribute() {
		return attribute;
	}

	/**
	 * @param attribute
	 */
	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

}
