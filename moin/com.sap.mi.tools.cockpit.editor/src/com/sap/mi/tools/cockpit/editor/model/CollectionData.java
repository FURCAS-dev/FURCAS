/**
 * 
 */
package com.sap.mi.tools.cockpit.editor.model;

import java.util.Collection;

import org.eclipse.core.runtime.Assert;

/**
 * @author d003456
 * 
 */
public class CollectionData {

	private final Collection<?> collection;

	private final String name;

	/**
	 * Creates {@link CollectionData}.
	 * 
	 * @param collection
	 * @param name
	 */
	public CollectionData(Collection<?> collection, String name) {

		super();
		Assert.isNotNull(collection);
		Assert.isNotNull(name);
		this.collection = collection;
		this.name = name;
	}

	/**
	 * @return the collection
	 */
	public final Collection<?> getCollection() {

		return this.collection;
	}

	/**
	 * @return the name
	 */
	public final String getName() {

		return this.name;
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
		result = prime * result + ((this.collection == null) ? 0 : this.collection.hashCode());
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
		if (obj == null)
			return false;
		if (!(obj instanceof CollectionData))
			return false;
		final CollectionData other = (CollectionData) obj;
		if (this.collection == null) {
			if (other.collection != null)
				return false;
		}
		else if (!this.collection.equals(other.collection))
			return false;
		if (this.name == null) {
			if (other.name != null)
				return false;
		}
		else if (!this.name.equals(other.name))
			return false;
		return true;
	}

}
