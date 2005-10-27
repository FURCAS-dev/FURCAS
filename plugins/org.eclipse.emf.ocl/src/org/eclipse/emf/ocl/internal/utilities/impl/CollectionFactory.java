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

package org.eclipse.emf.ocl.internal.utilities.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;

import org.eclipse.emf.ocl.expressions.CollectionKind;
import org.eclipse.emf.ocl.internal.OclEnginePlugin;
import org.eclipse.emf.ocl.internal.l10n.OclMessages;
import org.eclipse.osgi.util.NLS;

/**
 * A factory for creating java collection types from their OCL equivalents.
 * 
 * @author tklinger
 */
public class CollectionFactory {

	private static final String OCLCollectionKindNotImpl_ERROR_ =
		OclMessages.OCLCollectionKindNotImpl_ERROR_;

	private static CollectionFactory instance = null;

	// singleton
	public static CollectionFactory getInstance() {
		if (instance == null)
			instance = new CollectionFactory();
		return instance;
	}

	// ******************************************************************
	// Note: If you make a change of implementation for a collection type
	// make sure you change it in both of the methods below!!!!
	// ******************************************************************

	/**
	 * Creates a java collection from a supplied collection kind.
	 * @param kind the OCL collection kind to use in constructing a java equivalent
	 * @return the java collection
	 */
	public Collection createCollection(int kind) {
		switch (kind) {
			case CollectionKind.SET:
				return new HashSet();
			case CollectionKind.SEQUENCE:
				return new ArrayList();
			case CollectionKind.ORDERED_SET:
				return new LinkedHashSet();
			case CollectionKind.BAG:
				return new Bag();
			default: {
				String message = NLS.bind(
					OCLCollectionKindNotImpl_ERROR_, new Object[] {new Integer(
						kind) });
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OclEnginePlugin.throwing(getClass(), "typeCompare", error);//$NON-NLS-1$
				throw error;

			}
		}
	}

	/**
	 * Creates a java collection from a supplied collection kind, initialized to
	 * the supplied collection.
	 * @param kind the OCL collection kind to use in constructing a java equivalent
	 * @param c a collection with which to initialize the constructed collection
	 * @return the java collection
	 */
	public Collection createCollection(int kind, Collection c) {
		switch (kind) {
			case CollectionKind.SET:
				return new HashSet(c);
			case CollectionKind.SEQUENCE:
				return new ArrayList(c);
			case CollectionKind.BAG:
				return new Bag(c);
			case CollectionKind.ORDERED_SET:
				return new LinkedHashSet(c);
			default: {
				String message = NLS.bind(
					OCLCollectionKindNotImpl_ERROR_, new Object[] {new Integer(
						kind) });
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OclEnginePlugin.throwing(getClass(), "typeCompare", error);//$NON-NLS-1$
				throw error;
			}
		}
	}
}