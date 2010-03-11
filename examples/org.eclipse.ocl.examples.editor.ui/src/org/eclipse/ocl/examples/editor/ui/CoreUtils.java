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
package org.eclipse.ocl.examples.editor.ui;

import org.eclipse.core.runtime.IAdaptable;

public class CoreUtils
{	
	@SuppressWarnings("unchecked")
	public static <T> T getAdapter(IAdaptable adaptable, Class<T> key) {
		if (adaptable == null)
			return null;
		return (T) adaptable.getAdapter(key);
	}
}
