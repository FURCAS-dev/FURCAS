/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.query;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.emfindex.EObjectDescriptor;
import org.eclipse.emf.emfindex.ResourceDescriptor;

/**
 * @author koehnlein
 */
public class EObjectDescriptorQuery extends AbstractBaseDescriptorQuery<EObjectDescriptor> {

	private Query<ResourceDescriptor> resourceQuery;
	
	private EClass isInstanceOf;
	
	private String name;
	private String nameContains;
	private String nameStartsWith;
	private String nameEndsWith;
	
	private String fragment;

	/**
	 * @return the resourceQuery
	 */
	public Query<ResourceDescriptor> getResourceQuery() {
		return resourceQuery;
	}

	/**
	 * @param resourceQuery the resourceQuery to set
	 */
	public void setResourceQuery(Query<ResourceDescriptor> resourceQuery) {
		this.resourceQuery = resourceQuery;
	}

	/**
	 * @return the eClass
	 */
	public EClass getIsInstanceOf() {
		return isInstanceOf;
	}

	/**
	 * @param eClass the eClass to set
	 */
	public void setIsInstanceOf(EClass eClass) {
		this.isInstanceOf = eClass;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setNameEquals(String name) {
		this.name = name;
	}

	/**
	 * @return the nameContains
	 */
	public String getNameContains() {
		return nameContains;
	}

	/**
	 * @param nameContains the nameContains to set
	 */
	public void setNameContains(String nameContains) {
		this.nameContains = nameContains;
	}

	/**
	 * @return the nameStartsWith
	 */
	public String getNameStartsWith() {
		return nameStartsWith;
	}

	/**
	 * @param nameStartsWith the nameStartsWith to set
	 */
	public void setNameStartsWith(String nameStartsWith) {
		this.nameStartsWith = nameStartsWith;
	}

	/**
	 * @return the nameEndsWith
	 */
	public String getNameEndsWith() {
		return nameEndsWith;
	}

	/**
	 * @param nameEndsWith the nameEndsWith to set
	 */
	public void setNameEndsWith(String nameEndsWith) {
		this.nameEndsWith = nameEndsWith;
	}

	/**
	 * @return the fragment
	 */
	public String getFragment() {
		return fragment;
	}

	/**
	 * @param fragment the fragment to set
	 */
	public void setFragment(String fragment) {
		this.fragment = fragment;
	}
	
	
}
