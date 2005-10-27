/******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/


package org.eclipse.emf.ocl.internal.parser;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;


/**
 * An adapter that is attached to {@link EObject}s to record the tokens from
 * which they were parsed.  This is used particularly to retain positional
 * information for type names (as {@link org.eclipse.emf.ecore.EClassifier}s).
 *
 * @author Christian W. Damus (cdamus)
 */
public class OclTokenAdapter
	extends AdapterImpl {

	/**
	 * Special token indicating the absence of a token.  Its token type
	 * is invalid, its text is an empty string, and it starts and ends at
	 * position -1 in the input.
	 */
	static final OclToken NULL_TOKEN = new OclToken(0, ""); //$NON-NLS-1$
	
	private OclToken token;
	
	/**
	 * Initializes me with the token that I attach.
	 * 
	 * @param token the token
	 */
	private OclTokenAdapter(OclToken token) {
		super();
		this.token = token;
	}

	private void setToken(OclToken token) {
		this.token = token;
	}
	
	OclToken getToken() {
		return token;
	}
	
	/**
	 * Attaches the specified <code>token</code> to an {@link EObject} via a
	 * new or existing adapter.
	 * 
	 * @param eObject the object to attach to
	 * @param token the token to attach
	 */
	static void attach(EObject eObject, OclToken token) {
		if (eObject != null) {
			OclTokenAdapter adapter = (OclTokenAdapter) EcoreUtil.getExistingAdapter(
				eObject, OclToken.class);
			
			if (adapter == null) {
				// create a new adapter
				eObject.eAdapters().add(new OclTokenAdapter(token));
			} else {
				adapter.setToken(token);
			}
		}
	}
	
	/**
	 * Obtains the token attached to the specifie {@link EObject}, if any.
	 * <b>Note</b> that, as a side-effect, the resulting token is detached
	 * from the object.
	 * 
	 * @param eObject the object to get the associated token from
	 * 
	 * @return the token, or the {@linkplain #NULL_TOKEN null token}
	 *      if none was attached
	 * 
	 * @see #NULL_TOKEN
	 */
	static OclToken getToken(EObject eObject) {
		OclToken result = NULL_TOKEN;
		
		if (eObject != null) {
			OclTokenAdapter adapter = (OclTokenAdapter) EcoreUtil.getExistingAdapter(
				eObject, OclToken.class);
			
			if (adapter != null) {
				result = adapter.getToken();
				eObject.eAdapters().remove(adapter);
			}
		}
		
		return result;
	}
	
	public boolean isAdapterForType(Object type) {
		return type == OclToken.class;
	}
}
