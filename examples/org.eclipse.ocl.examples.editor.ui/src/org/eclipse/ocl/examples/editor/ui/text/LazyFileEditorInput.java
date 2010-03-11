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
package org.eclipse.ocl.examples.editor.ui.text;

import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.part.FileEditorInput;

/**
 * A LazyFileEditorInput maintains the temporary file that provides the textual input
 * for a text page of a paged editor.
 * 
 * The IFileEditorInput and IFile are created when the editor page is created, but populating
 * the file content is deferred until the editor page is activated.
 */
public final class LazyFileEditorInput extends FileEditorInput
{
	private boolean hasContents = false;
	
	public LazyFileEditorInput(IFile file) {
		super(file);
	}
	
	public LazyFileEditorInput(IFolder tmpdir, String name, String fileExtension) {
        this(tmpdir.getFile(name + "$" + fileExtension)); // FIXME ensure unique name
	}

	public boolean hasContents() {
		return hasContents;
	}

	public void setContents(InputStream inputStream, IProgressMonitor monitor) throws CoreException {
		IFile file = getFile();
		if (!file.exists())
			file.create(inputStream, true, monitor);
		else {
			file.refreshLocal(IFile.DEPTH_INFINITE, monitor);
			file.setContents(inputStream, true, false, monitor);	
		}
		hasContents = true;
	}
}