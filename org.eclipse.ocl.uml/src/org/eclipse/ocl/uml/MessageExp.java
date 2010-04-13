/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 207365
 * 
 * </copyright>
 *
 * $Id: MessageExp.java,v 1.4 2009/12/22 18:59:37 ewillink Exp $
 */
package org.eclipse.ocl.uml;

import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.SendSignalAction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.ocl.uml.UMLPackage#getMessageExp()
 * @model
 * @generated
 */
public interface MessageExp
		extends
		OCLExpression,
		org.eclipse.ocl.expressions.MessageExp<Classifier, CallOperationAction, SendSignalAction> {
} // MessageExp
