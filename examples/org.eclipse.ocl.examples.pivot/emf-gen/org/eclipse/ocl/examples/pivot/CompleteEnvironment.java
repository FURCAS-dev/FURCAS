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
 * $Id: CompleteEnvironment.java,v 1.2 2011/01/24 20:49:36 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complete Environment</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCompleteEnvironment()
 * @model
 * @generated
 */
public interface CompleteEnvironment
		extends org.eclipse.ocl.examples.pivot.Package {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" modelRequired="true" modelOrdered="false"
	 * @generated
	 */
	CompleteIteration getCompleteIteration(Iteration model);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" modelRequired="true" modelOrdered="false"
	 * @generated
	 */
	CompleteType getCompleteType(Type model);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" modelRequired="true" modelOrdered="false"
	 * @generated
	 */
	CompleteOperation getCompleteOperation(Operation model);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" modelRequired="true" modelOrdered="false"
	 * @generated
	 */
	CompletePackage getCompletePackage(
			org.eclipse.ocl.examples.pivot.Package model);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" modelRequired="true" modelOrdered="false"
	 * @generated
	 */
	CompleteProperty getCompleteProperty(Property model);

} // CompleteEnvironment
