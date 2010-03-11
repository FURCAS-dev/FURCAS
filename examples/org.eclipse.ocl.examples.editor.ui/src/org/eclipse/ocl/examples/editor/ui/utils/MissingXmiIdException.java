/*******************************************************************************
 * Copyright (c) 2007,2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.editor.ui.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.common.utils.EcoreUtils;

/**
 * MissingXmiIdException is thrown by EcoreUpdater on encountering an element without an xmi:id.
 */
public class MissingXmiIdException extends MissingElementException
{
	private static final long serialVersionUID = 2688292183385191887L;
	
	public MissingXmiIdException(EObject object) {
		super(object);
	}

	@Override
	public String toString() {
		return super.toString() + " name='" + EcoreUtils.qualifiedNameFor(object) + "'";
	}
}