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
 * $Id: OCLEnvironment.java,v 1.2 2010/04/08 06:26:34 ewillink Exp $
 */
package org.eclipse.ocl.examples.parser.ocl.environment;

import java.util.List;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.examples.parser.environment.ecore.CSTChildEcoreEnvironment;
import org.eclipse.ocl.expressions.Variable;

public class OCLEnvironment<P extends IOCLEnvironment, AST extends Notifier, CST extends CSTNode> extends CSTChildEcoreEnvironment<OCLEnvironment<?,?,?>, P, AST, CST> implements IOCLEnvironment
{
	protected OCLEnvironment(P parent, AST ast, CST cst) {
		super(parent, ast, cst);
	}

	@Override
	protected void addedVariable(String name, Variable<EClassifier, EParameter> variable, boolean isExplicit) {
		// The Variable is not needed in the resource. Separate variables are created for contexts as required.
	}

	public OCLEnvironment<?,?,?> createNestedEnvironment(CSTNode cstNode) {
		return new OCLEnvironment<OCLEnvironment<?,?,?>,Notifier,CSTNode>(this, null, cstNode);
	}

	@Override public EClassifier tryLookupClassifier(List<String> names) throws LookupException {
		EPackage contextPackage = getContextPackage();
		if (contextPackage != null) {
			EClassifier eClassifier = super.tryLookupClassifier(names);
			if (eClassifier != null)
				return eClassifier;
		}
		IOCLEnvironment parent = getParentEnvironment();
		if (parent != null)
			return parent.tryLookupClassifier(names);
		return null;
	}

	@Override public EPackage tryLookupPackage(List<String> path) throws LookupException {
		IOCLEnvironment parent = getParentEnvironment();
		if (parent == null)
			return super.tryLookupPackage(path);
		else
			return parent.tryLookupPackage(path);
	}
}
