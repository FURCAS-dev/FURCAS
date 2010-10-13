/*******************************************************************************
 * Copyright (c) 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query.index.query;

/**
 * 
 * @author Martin Strenge
 * 
 */
public abstract class QueryCommandWithResult<T> implements QueryCommand {

	private T _result;

	protected void setResult(T result) {
		this._result = result;
	}

	public T getResult() {
		return this._result;
	}

}
