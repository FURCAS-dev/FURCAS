package com.sap.mi.tools.cockpit.editor.model;

/**
 * @author d003456
 * 
 */
public class NameValuePair extends AttributeValue {

	private String name = null;

	/**
	 * Create {@link NameValuePair}.
	 * 
	 * @param attribute
	 * @param value
	 */
	public NameValuePair(String name, Object value) {

		this.name = name;
		setValue(value);
	}

	public String getName() {

		return this.name;
	}

	public void setName(String name) {

		this.name = name;
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
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
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
		if (!(obj instanceof NameValuePair))
			return false;
		final NameValuePair other = (NameValuePair) obj;
		if (this.name == null) {
			if (other.name != null)
				return false;
		}
		else if (!this.name.equals(other.name))
			return false;
		return true;
	}
}
