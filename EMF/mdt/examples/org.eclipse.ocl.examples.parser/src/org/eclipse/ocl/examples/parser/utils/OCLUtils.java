/**
 * <copyright>
 *
 * Copyright (c) 2007,2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: OCLUtils.java,v 1.2 2010/04/08 06:26:13 ewillink Exp $
 */
package org.eclipse.ocl.examples.parser.utils;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.examples.parser.unresolved.UnresolvedPackage;
import org.eclipse.ocl.expressions.CollectionKind;

public class OCLUtils
{		
	public static final String OCL_ORPHANS_PACKAGE_NAME = "oclOrphans";

    public static CollectionKind commonCollectionKind(CollectionKind kind1, CollectionKind kind2) {
		if ((kind1 == null) && (kind2 == null))
			return null;
		assert (kind1 != null) && (kind2 != null);
		boolean isOrdered = isOrdered(kind1) || isOrdered(kind2);
		boolean isUnique = isUnique(kind1) || isUnique(kind2);
		return isOrdered
				? isUnique
						? CollectionKind.ORDERED_SET_LITERAL
						: CollectionKind.SEQUENCE_LITERAL
				: isUnique
						? CollectionKind.SET_LITERAL
						: CollectionKind.BAG_LITERAL;
	}

	public static String getKindName(CollectionKind collectionKind) {
		if (collectionKind == null)
			return "scalar";
		else
			return collectionKind.getName();
	}

    /**
	 * Obtains the appropriate OCL collection type for an {@link EClassifier}, 
	 * according to the collection's orderedness and uniqueness.  The mapping is
	 * as follows:
	 * <ul>
	 *   <li>ordered, unique: ordered set type</li>
	 *   <li>ordered, non-unique: sequence type</li>
	 *   <li>non-ordered, unique: set type</li>
	 *   <li>non-ordered, non-unique: bag type</li>
	 * </ul>
	 * <p>
	 * Note that the collection's element <code>type</code> is mapped to an
	 * OCL primitive type where possible.
	 * </p>
	 * 
	 * @param type the type to get the corresponding OCL collection type for
	 * @param isOrdered whether the OCL type should be ordered
	 * @param isUnique whether the OCL type should be unique
	 * 
	 * @return the corresponding OCL type
	 */	
	public static EClassifier getOCLCollectionType(EClassifier type,
			boolean isOrdered, boolean isUnique) {
		EClassifier resultType = type;
	
//		if (resultType instanceof EDataType) {
//			resultType = getOCLTypeFor((EDataType) resultType);
//		}
		
		if (isOrdered) {
			if (isUnique) {
				resultType = EcoreFactory.eINSTANCE.createOrderedSetType();
			} else {
				resultType = EcoreFactory.eINSTANCE.createSequenceType();
			}
		} else {
			if (isUnique) {
				resultType = EcoreFactory.eINSTANCE.createSetType();
			} else {
				resultType = EcoreFactory.eINSTANCE.createBagType();
			}
		}
		
		return resultType;
	}

	public static boolean isOrdered(CollectionKind collectionKind) {
		assert collectionKind != null;
		return (collectionKind == CollectionKind.ORDERED_SET_LITERAL) || (collectionKind == CollectionKind.SEQUENCE_LITERAL);
	}

	@Deprecated			// Use UnresolvedEnvironment to create and check unresolved elements
	public static boolean isUnresolved(EClassifier eClassifier) {
		return eClassifier.getEPackage() == UnresolvedPackage.eINSTANCE;
	}

	public static boolean isUnique(CollectionKind collectionKind) {
		assert collectionKind != null;
		return (collectionKind == CollectionKind.SET_LITERAL) || (collectionKind == CollectionKind.SEQUENCE_LITERAL);
	}
}
