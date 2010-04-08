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
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: ICSTNodeEcoreEnvironment.java,v 1.2 2010/04/08 06:26:21 ewillink Exp $
 */
package org.eclipse.ocl.examples.parser.environment.ecore;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.InvalidLiteralExp;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.examples.parser.environment.ICSTNodeEnvironment;

public interface ICSTNodeEcoreEnvironment extends ICSTNodeEnvironment<
EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter,
EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject>, ICSTEcoreEnvironment
{
	public InvalidLiteralExp createInvalidLiteralExp(CSTNode cstNode);
}
