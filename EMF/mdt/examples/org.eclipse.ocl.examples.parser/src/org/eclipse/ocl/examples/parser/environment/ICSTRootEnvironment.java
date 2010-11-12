/**
 * <copyright>
 *
 * Copyright (c) 2008,2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: ICSTRootEnvironment.java,v 1.2 2010/04/08 06:26:22 ewillink Exp $
 */
package org.eclipse.ocl.examples.parser.environment;

import org.eclipse.emf.ecore.xmi.XMIResource;

public interface ICSTRootEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
extends ICSTNodeEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
{
	/**
	 * Diagnose and AST nodes not mapped to CST nodes and vice-versa.
	 * <br>
	 * This is a debug facility, so output to to System.out.
	 */
	public void checkMappings();

	public XMIResource getASTNode();

	public int getCSTErrorTokens();
	
	public void postParse();

	public void validate();
}
