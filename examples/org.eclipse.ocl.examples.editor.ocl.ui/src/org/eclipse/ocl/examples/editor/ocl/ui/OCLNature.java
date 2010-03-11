/**
 * <copyright>
 * 
 * Copyright (c) 2007,2010 Eclipse Modeling Project and others.
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
 * $Id: OCLNature.java,v 1.1 2010/03/11 14:52:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ocl.ui;

import org.eclipse.ocl.examples.editor.ui.builder.CommonNature;

public class OCLNature extends CommonNature
{
	public OCLNature() {
		super(OCLCreationFactory.INSTANCE);
	}
}
