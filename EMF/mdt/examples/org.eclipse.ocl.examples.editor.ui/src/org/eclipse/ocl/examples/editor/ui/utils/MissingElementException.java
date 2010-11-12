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

/**
 * Abstract Exception thrown by EcoreUpdater on encountering invalid content.
 */
@SuppressWarnings("serial")
public abstract class MissingElementException extends Exception
{
	protected final EObject object;
	
	protected MissingElementException(EObject object) {
		this.object = object;
	}
}