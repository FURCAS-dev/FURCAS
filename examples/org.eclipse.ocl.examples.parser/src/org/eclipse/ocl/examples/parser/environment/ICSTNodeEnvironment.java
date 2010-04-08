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
 * $Id: ICSTNodeEnvironment.java,v 1.2 2010/04/08 06:26:25 ewillink Exp $
 */
package org.eclipse.ocl.examples.parser.environment;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.examples.parser.utils.CSTFormattingHelper;
import org.eclipse.ocl.expressions.InvalidLiteralExp;
import org.eclipse.ocl.expressions.OCLExpression;

public interface ICSTNodeEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
extends ICSTEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
{

	public boolean checkFeatureCompatibility(CSTNode cstNode, C featureType, OCLExpression<C> oclExpression);
	
	/**
	 * Create and return an InvalidLiteralExp mapped to cstNode.
	 * 
	 * @param cstNode that provoked the invalid literal.
	 * @return the InvalidLiteralExp
	 */
	public InvalidLiteralExp<C> createInvalidLiteralExp(CSTNode cstNode);
	
	/**
	 * Create and return a nested environment for the cstNode, typically to
	 * avoid the need to invoke setCSTNode to change and restore an outer OCL
	 * expression environment.
	 */
	public ICSTNodeEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> createNestedEnvironment(CSTNode cstNode);

	/**
	 * Return the error message for a LookupException, typically by appending details
	 * of the ambiguities to the standard exception message.
	 * 
	 * @param e lookup exception
	 * @return full message
	 */
	public String formatLookupException(LookupException e);

	public Object getASTNode();	

	public CSTNode getCSTNode();	

	/**
	 * Return the enhanced functionality formatting helper.
	 */
	public CSTFormattingHelper getFormatter();

	/**
     * Generates a new, unique name for an implicit iterator variable.
	 */
//	public String generateImplicitName();   // FIXME Workaround for bug 246469
	
	public ICSTRootEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> getRootEnvironment();

	/**
	 * Return the environment that supervises definitions for unresolved references.
	 */
	public UnresolvedEnvironment getUnresolvedEnvironment();

	/**
	 * Return false if eObject was created to resolve an unresolved reference.
	 */
	public boolean isResolved(EObject eObject);
}
