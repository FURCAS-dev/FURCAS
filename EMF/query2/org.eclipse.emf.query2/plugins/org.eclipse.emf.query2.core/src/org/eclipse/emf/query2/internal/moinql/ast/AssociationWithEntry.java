/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query2.internal.moinql.ast;

import org.eclipse.emf.common.util.URI;

/**
 * This class embodies associative with entries, currently the Association
 * Predicate and the links predicate. It records all properties with regard to
 * associations, except the information of the toType.
 */
public abstract class AssociationWithEntry extends WithEntry {

	protected URI assocMRI;

	//    protected SpiFqlAssociationCategory assocCategory;

	protected String assocName;

	//    protected int toAssocEnd;
	//
	//    protected boolean toStorage;
	//
	//    protected String toAssocEndName;
	//
	protected AtomicEntryReference fromType;

	//
	//    protected boolean fromStorage;
	//
	//    protected int fromAssocEnd;
	//
	//    protected String fromAssocEndName;

	//    public int getToAssocEnd( ) {
	//
	//        return this.toAssocEnd;
	//    }

	public URI getAssocMRI() {

		return this.assocMRI;
	}

	public AtomicEntryReference getFromType() {

		return this.fromType;
	}

	//
	//    public String getToAssocEndName( ) {
	//
	//        return this.toAssocEndName;
	//    }

	public String getAssocName() {

		return this.assocName;
	}

	//    public boolean hasStorageAtFromEnd( ) {
	//
	//        return this.fromStorage;
	//    }
	//
	//    public String getFromAssocEndName( ) {
	//
	//        return this.fromAssocEndName;
	//    }
	//
	//    public int getFromAssocEnd( ) {
	//
	//        return this.fromAssocEnd;
	//    }
	//
	//    public boolean hasStorageAtToEnd( ) {
	//
	//        return this.toStorage;
	//    }
	//
	//    public SpiFqlAssociationCategory getAssocCategory( ) {
	//
	//        return this.assocCategory;
	//    }
	//
	//    public void setToAssocEnd( int assocEnd ) {
	//
	//        this.toAssocEnd = assocEnd;
	//    }
	//
	//    public void setToAssocEndName( String assocEndName ) {
	//
	//        this.toAssocEndName = assocEndName;
	//    }

	public void setAssocMRI(URI assocMRI) {

		this.assocMRI = assocMRI;
	}

	public void setAssocName(String assocName) {

		this.assocName = assocName;
	}

	public void setFromType(AtomicEntryReference linkedTo) {

		this.fromType = linkedTo;
	}
	//
	//    public void setFromStorage( boolean linkedToStored ) {
	//
	//        this.fromStorage = linkedToStored;
	//    }
	//
	//    public void setToStorage( boolean stored ) {
	//
	//        this.toStorage = stored;
	//    }

	/*
	 * FQL
	 */

	//    public SpiFqlQueryEntry getFromEndEntry( ) {
	//
	//        return this.getFromType( ).getAtomicEntry( );
	//    }
}
