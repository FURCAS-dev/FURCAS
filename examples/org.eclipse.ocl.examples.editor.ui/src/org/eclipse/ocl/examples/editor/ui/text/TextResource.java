/*******************************************************************************
 * Copyright (c) 2008,2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.editor.ui.text;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

/**
 * A TextResource is created to give the text input a presence the ResourceSet.
 * This ensures that resource deletion/renaming works.
 */
public class TextResource extends ResourceImpl
{
	// FIXME Exploit introduction of this class to make the CST visible
	// FIXME Exploit this class to simplify the master/text logic
	
	private boolean saveInProgress = false;

	public TextResource(URI uri) {
		super(uri);
	}
	
	public boolean isSaveInProgress() {
		return saveInProgress;
	}

	public void setSaveInProgress(boolean saveInProgress) {
		this.saveInProgress = saveInProgress;
	}
}
