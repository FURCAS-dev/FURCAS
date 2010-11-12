/**
 * <copyright>
 * 
 * Copyright (c) 2008,2010 Eclipse Modeling Project and others.
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
 * $Id: OCLSourcePositionLocator.java,v 1.1 2010/03/11 14:52:54 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ocl.ui.imp;

import org.eclipse.ocl.examples.editor.ui.imp.CommonSourcePositionLocator;
import org.eclipse.ocl.lpg.BasicEnvironment;

public class OCLSourcePositionLocator extends CommonSourcePositionLocator
{
	public OCLSourcePositionLocator(BasicEnvironment environment) {
		super(environment);
	}
}