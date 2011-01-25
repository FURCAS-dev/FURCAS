/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: ParameterableElementOperations.java,v 1.2 2011/01/24 20:42:33 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.internal.operations;

import org.eclipse.ocl.examples.pivot.ParameterableElement;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Parameterable Element</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.ParameterableElement#isTemplateParameter() <em>Is Template Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParameterableElementOperations
		extends MonikeredElementOperations {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterableElementOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query isTemplateParameter() determines if this parameterable element is exposed as a formal template parameter.
	 * result = templateParameter->notEmpty()
	 * @param parameterableElement The receiving '<em><b>Parameterable Element</b></em>' model object.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean isTemplateParameter(
			ParameterableElement parameterableElement) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

} // ParameterableElementOperations