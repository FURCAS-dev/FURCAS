package com.sap.mi.tools.cockpit.editor.model;

/**
 * @author d003456
 * 
 */
public class AttributeValue {

	private Object value = null;

	/**
	 * Creates {@link AttributeValue}.
	 */
	public AttributeValue() {

		super();
	}

	/**
	 * @return the value
	 */
	public final Object getValue() {

		return this.value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public final void setValue(Object value) {

		this.value = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.value == null) ? 0 : this.value.hashCode());
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final AttributeValue other = (AttributeValue) obj;
		if (this.value == null) {
			if (other.value != null)
				return false;
		}
		else if (!this.value.equals(other.value))
			return false;
		return true;
	}
}
