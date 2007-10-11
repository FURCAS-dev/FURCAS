/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
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
 * $Id: MessageExp.java,v 1.3 2007/10/11 23:05:15 cdamus Exp $
 */

package org.eclipse.emf.ocl.expressions;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ocl.uml.CallOperationAction;
import org.eclipse.emf.ocl.uml.SendSignalAction;
import org.eclipse.emf.ocl.utilities.CallingASTNode;

/**
 * @deprecated Use the {@link org.eclipse.ocl.expressions.MessageExp} interface,
 * instead.
 * 
 * @author Edith Schonberg (edith)
 * @author Christian W. Damus (cdamus)
 */
@Deprecated
public interface MessageExp  extends OCLExpression, CallingASTNode {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = ""; //$NON-NLS-1$

	/**
	 *
	 */
	public OCLExpression getTarget();
	
	void setTarget(OCLExpression value);
	

	/**
	 * Returns the value of the '<em><b>Argument</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ocl.expressions.OCLExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Argument</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Argument</em>' containment reference list.
	 * @see org.eclipse.emf.ocl.expressions.ExpressionsPackage#getMessageExp_Argument()
	 * @model type="org.eclipse.emf.ocl.expressions.OCLExpression" containment="true"
	 * @generated
	 */
	EList getArgument();

	/**
	 * @model lowerBound="0"
	 */
	public CallOperationAction getCalledOperation();

	void setCalledOperation(CallOperationAction value);
	

	/**
	 * @model lowerBound="0"
	 */
	public SendSignalAction getSentSignal();

	void setSentSignal(SendSignalAction value);

}
