/**
 * <copyright>
 *
 * Copyright (c) 2005, 2006 IBM Corporation and others.
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
 * $Id: OCLMessageExp.java,v 1.2 2006/03/01 17:15:48 cdamus Exp $
 */

package org.eclipse.emf.ocl.expressions;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ocl.uml.CallAction;
import org.eclipse.emf.ocl.uml.SendAction;


/**
 * @author Edith Schonberg (edith)
 * @author Christian W. Damus (cdamus)
 */
public interface OCLMessageExp  extends OCLExpression {
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
	

	/*****ordered***/
	/**
	 * @model type="OCLMessageArg" lowerBound=0
	 */
	public EList getArguments();
	
	/**
	 * @model lowerBound="0"
	 */
	public CallAction getCalledOperation();

	void setCalledOperation(CallAction value);
	

	/**
	 * @model lowerBound="0"
	 */
	public SendAction getSentSignal();

	void setSentSignal(SendAction value);

}
