package com.sap.mi.tools.cockpit.editor.model;

import com.sap.tc.moin.repository.mmi.model.Attribute;

/**
 * @author d003456
 * 
 */
public final class AttributeValuePair extends AttributeValue {

	private Attribute attribute = null;

	/**
	 * Creates {@link AttributeValuePair}.
	 * 
	 * @param attribute
	 * @param value
	 */
	public AttributeValuePair(Attribute attribute, Object value) {

		this.attribute = attribute;
		this.setValue(value);
	}

	public Attribute getAttribute() {

		return this.attribute;
	}

	public void setAttribute(Attribute attribute) {

		this.attribute = attribute;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {

		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((this.attribute == null) ? 0 : this.attribute.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof AttributeValuePair))
			return false;
		final AttributeValuePair other = (AttributeValuePair) obj;
		if (this.attribute == null) {
			if (other.attribute != null)
				return false;
		}
		else if (!this.attribute.equals(other.attribute))
			return false;
		return true;
	}

}
