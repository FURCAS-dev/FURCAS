/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.query;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.emfindex.EReferenceDescriptor;
import org.eclipse.emf.emfindex.ResourceDescriptor;

/**
 * @author koehnlein
 */
public class EReferenceDescriptorQuery extends AbstractBaseDescriptorQuery<EReferenceDescriptor> {

	private String sourceFragmentEquals;
	private Query<ResourceDescriptor> sourceResourceQuery;

	private String targetFragmentEquals;
	private Query<ResourceDescriptor> targetResourceQuery;

	private EReference eReferenceEquals;
	
	private URI targetResourceURIEquals;
	
	public void setTargetResourceURIEquals(URI targetResourceURIEquals) {
		this.targetResourceURIEquals = targetResourceURIEquals;
	}
	
	public URI getTargetResourceURIEquals() {
		return targetResourceURIEquals;
	}

	/**
	 * @return the sourceFragmentEqaals
	 */
	public String getSourceFragmentEquals() {
		return sourceFragmentEquals;
	}

	/**
	 * @param sourceFragmentEqaals the sourceFragmentEqaals to set
	 */
	public void setSourceFragmentEquals(String sourceFragmentEquals) {
		this.sourceFragmentEquals = sourceFragmentEquals;
	}

	/**
	 * @return the sourceResourceQuery
	 */
	public Query<ResourceDescriptor> getSourceResourceQuery() {
		return sourceResourceQuery;
	}

	/**
	 * @param sourceResourceQuery the sourceResourceQuery to set
	 */
	public void setSourceResourceQuery(Query<ResourceDescriptor> sourceResourceQuery) {
		this.sourceResourceQuery = sourceResourceQuery;
	}

	/**
	 * @return the targetFragmentEquals
	 */
	public String getTargetFragmentEquals() {
		return targetFragmentEquals;
	}

	/**
	 * @param targetFragmentEquals the targetFragmentEquals to set
	 */
	public void setTargetFragmentEquals(String targetFragmentEquals) {
		this.targetFragmentEquals = targetFragmentEquals;
	}

	/**
	 * @return the targetResourceQuery
	 */
	public Query<ResourceDescriptor> getTargetResourceQuery() {
		return targetResourceQuery;
	}

	/**
	 * @param targetResourceQuery the targetResourceQuery to set
	 */
	public void setTargetResourceQuery(Query<ResourceDescriptor> targetResourceQuery) {
		this.targetResourceQuery = targetResourceQuery;
	}

	/**
	 * @return the eReferenceEquals
	 */
	public EReference getEReferenceEquals() {
		return eReferenceEquals;
	}

	/**
	 * @param eReferenceEquals the eReferenceEquals to set
	 */
	public void setEReferenceEquals(EReference eReferenceEquals) {
		this.eReferenceEquals = eReferenceEquals;
	}

}
