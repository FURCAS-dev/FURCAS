/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.query.newimpl;


/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class QueryImpl<T> {
	private Class<T> clazz;
	private AbstractPredicate<T> where;

	protected QueryImpl(Class<T> clazz) {
		this.clazz = clazz;
	}

	public QueryImpl<T> where(AbstractPredicate<T> where) {
		this.where = where;
		return this;
	}
	
	public Class<T> getClazz() {
		return clazz;
	}
	
	public AbstractPredicate<T> getWhere() {
		return where;
	}
}


/*
 * 
 * 
 * Query(EObjectDesc.class).where(and(not(EObjectDesc.resourceDesc.in(Query(ResourceDesc.class).where),EObjectDesc.name.startsWith("foo")))
 * 
 * 
 */
