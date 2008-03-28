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
 * $Id: TupleLiteralExp.java,v 1.5 2008/03/28 20:33:35 cdamus Exp $
 */
package org.eclipse.ocl.expressions;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tuple Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.TupleLiteralExp#getPart <em>Part</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getTupleLiteralExp()
 * @model
 * @generated
 */
public interface TupleLiteralExp<C, P> extends LiteralExp<C> {
	/**
     * Returns the value of the '<em><b>Part</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.ocl.expressions.TupleLiteralPart}&lt;C, P>.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Part</em>' containment reference list.
     * @see org.eclipse.ocl.expressions.ExpressionsPackage#getTupleLiteralExp_Part()
     * @model containment="true"
     * @generated
     */
	EList<TupleLiteralPart<C, P>> getPart();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * type.oclIsKindOf (TupleType)
     * and
     * part->forAll (tlep |
     * type.oclAsType (TupleType).allProperties()->exists (tp | tlep.attribute = tp))
     * and
     * part->size() = type.oclAsType (TupleType).allProperties()->size()
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @model
     * @generated
     */
    boolean checkTupleType(DiagnosticChain diagnostics, Map<Object, Object> context);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * part->isUnique (attribute.name)
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @model
     * @generated
     */
    boolean checkPartsUnique(DiagnosticChain diagnostics, Map<Object, Object> context);

} // TupleLiteralExp
