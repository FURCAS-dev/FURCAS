/******************************************************************************
 * Copyright (c) 2007,2010 E.D.Willink and others.
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
 * $Id: CSTEnvironment.java,v 1.2 2010/04/08 06:26:21 ewillink Exp $
 */
package org.eclipse.ocl.examples.parser.environment;

import org.eclipse.ocl.AbstractEnvironment;
import org.eclipse.ocl.examples.parser.utils.CSTFormattingHelper;

public abstract class CSTEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E, V extends ICSTEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>>
extends AbstractEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
implements ICSTEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
{
//	protected CSTEnvironment(EPackage.Registry reg) {
//	super(reg);
//}

//	public CSTEnvironment(EPackage.Registry reg, Resource resource) {
//		super(reg, resource);
//	}

	public CSTEnvironment(ICSTEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> parent) {
		super(parent);
	}

	@Override
	protected CSTFormattingHelper createFormattingHelper() {
		return CSTFormattingHelper.INSTANCE;
	}
	
	@Override
	public CSTFormattingHelper getFormatter() {
		return (CSTFormattingHelper) super.getFormatter();
	}
}
