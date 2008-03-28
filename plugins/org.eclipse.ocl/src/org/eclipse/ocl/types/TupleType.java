/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 * 
 * </copyright>
 *
 * $Id: TupleType.java,v 1.5 2008/03/28 20:33:34 cdamus Exp $
 */
package org.eclipse.ocl.types;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.utilities.PredefinedType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tuple Type</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.ocl.types.TypesPackage#getTupleType()
 * @model
 * @generated
 */
public interface TupleType<O, P> extends PredefinedType<O> {
	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * name =
     * 'Tuple('.concat (
     * Sequence{1..allProperties()->size()}->iterate (pn; s: String = '' |
     * let p: Property = allProperties()->at (pn) in (
     * s.concat (
     * (if (pn>1) then ',' else '' endif)
     * .concat (p.name).concat (': ')
     * .concat (p.type.name)
     * )
     * )
     * )
     * ).concat (')')
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @model
     * @generated
     */
    boolean checkTupleTypeName(DiagnosticChain diagnostics, Map<Object, Object> context);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * true
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @model
     * @generated
     */
    boolean checkPartNamesUnique(DiagnosticChain diagnostics, Map<Object, Object> context);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * feature->forAll (f | f.oclIsTypeOf(Property))
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @model
     * @generated
     */
    boolean checkFeaturesOnlyProperties(DiagnosticChain diagnostics, Map<Object, Object> context);

    String SINGLETON_NAME = "Tuple"; //$NON-NLS-1$

	/**
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @model
     * @generated
     */
	EList<P> oclProperties();

} // TupleType
