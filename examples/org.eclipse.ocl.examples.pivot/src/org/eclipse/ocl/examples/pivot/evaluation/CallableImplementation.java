/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: CallableImplementation.java,v 1.2 2011/01/24 20:47:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.evaluation;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.values.Value;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Callable Implementation</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCallableImplementation()
 * @model interface="true" abstract="true"
 * @extends PivotObject
 * @generated NOT
 */
public interface CallableImplementation
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.eclipse.ocl.examples.pivot.Object" required="true" ordered="false" contextRequired="true" contextOrdered="false" callRequired="true" callOrdered="false"
	 * @generated
	 */
	Value evaluate(EvaluationVisitor evaluationVisitor, Value sourceValue, CallExp call);

	Diagnostic validate(TypeManager typeManager, CallExp callExp);
} // CallableImplementation
