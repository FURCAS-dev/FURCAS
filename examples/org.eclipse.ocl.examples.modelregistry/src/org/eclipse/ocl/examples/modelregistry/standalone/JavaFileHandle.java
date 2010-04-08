/**
 * <copyright>
 *
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
 * $Id: JavaFileHandle.java,v 1.2 2010/04/08 06:24:04 ewillink Exp $
 */
package org.eclipse.ocl.examples.modelregistry.standalone;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ocl.examples.modelregistry.environment.FileHandle;
import org.eclipse.ocl.examples.modelregistry.environment.ProjectHandle;

public class JavaFileHandle extends PlatformObject implements FileHandle
{	
	public static String createCanonicalFileName(File file) throws IOException {
		if (file == null)
			return null;
		return file.getCanonicalPath();
	}
	
	protected final JavaProjectHandle projectHandle;
	protected final File file;
	
	protected JavaFileHandle(File projectFile) throws IOException {
		this.projectHandle = (JavaProjectHandle) this;
		this.file = projectFile != null ? new File(createCanonicalFileName(projectFile)) : null;
	}

	public JavaFileHandle(JavaProjectHandle projectHandle, File file) throws IOException {
		this.projectHandle = projectHandle;
		this.file = file != null ? new File(createCanonicalFileName(file)) : null;
	}

	public boolean exists() {
		return file.exists();
	}
	
	public String getAbsoluteName() {
		return file.getAbsolutePath();
	}

	public InputStream getContents() throws FileNotFoundException {
		return new FileInputStream(file);
	}
	
	public File getFile() {
		return file;
	}

	public String getName() {
		return file.getName();
	}
	
	public JavaFileHandle getParentFileHandle() {
		String parent = file.getParent();
		File file = parent != null ? new File(parent) : null;
		try {
			return file != null ? projectHandle.getFileHandle(file) : null;
		} catch (IOException e) {
			return null;
		}
	}
	
	public ProjectHandle getProjectHandle() {
		return projectHandle;
	}
	
	public String getProjectRelativeName() {
		return getProjectRelativePath().toString();
	}
	
	public IPath getProjectRelativePath() {
		IPath filePath = new Path(getAbsoluteName());
		IPath projectPath = new Path(getProjectHandle().getAbsoluteName());
		int matchingSegements = filePath.matchingFirstSegments(projectPath);
		return filePath.removeFirstSegments(matchingSegements).setDevice(null);
	}

	public URI getURI() {
		return URI.createFileURI(getFile().toString());
	}

	public File isFile() { return file.isFile() ? file : null; }
	public File isFolder() { return file.isDirectory() ? file : null; }
	public File isProject() { return projectHandle == this ? file : null; }
	
	@Override public String toString() { return getAbsoluteName(); }
}
