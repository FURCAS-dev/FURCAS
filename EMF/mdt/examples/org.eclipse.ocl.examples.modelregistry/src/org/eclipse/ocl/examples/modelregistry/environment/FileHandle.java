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
 * $Id: FileHandle.java,v 1.2 2010/04/08 06:23:58 ewillink Exp $
 */
package org.eclipse.ocl.examples.modelregistry.environment;

import java.io.FileNotFoundException;
import java.io.InputStream;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;

/**
 * A FileHandle provides access to a physical model storage medium. Handles are
 * associated with an ProjectHandle that denotes a resource location of special
 * significance. Relative access paths are resolved with respect to the ProjectHandle.
 * 
 * Derived classes such as JavaFileHandle and EclipseFileHandle use java.io.File or
 * org.eclipse.core.resources.IResource as the handler implementation.
 * 
 * The JavaFileHandle is suitable for use in standalone applications. 
 * The EclipseFileHandle is suitable for use in Eclipse projects. 
 */
public interface FileHandle extends IAdaptable
{
	/**
	 * Return true if file exists.
	 * 
	 * @return true if exists.
	 */
	public boolean exists();
	
	/**
	 * Return a name that can access the physical storage without reference to any
	 * other context.
	 * 
	 * @return the absolute name.
	 */
	public String getAbsoluteName();

	/**
	 * Return a stream from which the contents can be read.
	 * 
	 * @return the stream
	 * @throws CoreException if Eclipse resource access problem
	 * @throws FileNotFoundException if File access problem
	 */
	public InputStream getContents() throws CoreException, FileNotFoundException;
	
	/**
	 * Return a name that can access the physical storage with respect to its parent.
	 * e.g the file name and extension without any devuice or directories.
	 * 
	 * @return the name.
	 */
	public String getName();
	
	/**
	 * Return the handle of the parent of this handle.
	 * 
	 * @return the parent handle, null for the parent of the project.
	 */
	public FileHandle getParentFileHandle();
	
	/**
	 * Return the handle of the project.
	 * 
	 * @return the project handle.
	 */
	public ProjectHandle getProjectHandle();
	
	/**
	 * Return a name that can access the physical storage with respect to the project.
	 * 
	 * @return the project relative name.
	 */
	public String getProjectRelativeName();
	
	/**
	 * Get the URI of the file.
	 * 
	 * @return the file URI
	 */
	public URI getURI();
	
	/**
	 * Return a non-null file object if this Handle applies to a file.
	 * 
	 * @return non-null file object.
	 */
	public Object isFile();
	
	/**
	 * Return a non-null folder object if this Handle applies to a folder or directory.
	 * 
	 * @return non-null folder object.
	 */
	public Object isFolder();
	
	/**
	 * Return a non-null project object if this Handle applies to a project.
	 * 
	 * @return non-null project object.
	 */
	public Object isProject();
}
