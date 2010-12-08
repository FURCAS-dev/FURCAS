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
 * $Id: OCLSyntaxHelper.java,v 1.18 2010/01/22 18:38:12 asanchez Exp $
 */
package org.eclipse.ocl.helper;

import java.util.List;

import org.eclipse.ocl.Environment;

import com.google.inject.ImplementedBy;

/**
 * @since 3.1
 */
public interface OCLSyntaxHelper
{
	/**
	 * The OCLSyntaxHelper Provider orchestrates creation of OCLSyntaxHelper instances. An
	 * alternate OCLSyntaxHelper implementation may be used by configuring the
	 * environment's injector with a module configured with the alternate bindings.
	 * 
	 * @since 3.1
	 */
	@ImplementedBy(org.eclipse.ocl.internal.helper.OCLSyntaxHelper.Provider.class)
	public interface IProvider<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	{
		OCLSyntaxHelper createOCLSyntaxHelper(Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env);
	}

	List<Choice> getSyntaxHelp(ConstraintKind constraintType, String txt);
}
