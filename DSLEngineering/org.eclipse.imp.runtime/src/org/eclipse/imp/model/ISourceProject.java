/*******************************************************************************
* Copyright (c) 2007 IBM Corporation.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Robert Fuhrer (rfuhrer@watson.ibm.com) - initial API and implementation
*******************************************************************************/

package org.eclipse.imp.model;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;

public interface ISourceProject extends ISourceContainer {
    /**
     * @return the build path, a List of IPathEntry's
     */
    List<IPathEntry> getBuildPath();

    /**
     * @param buildPath the new build path for this project; entries are copied into the project's
     * build path list
     */
    void setBuildPath(List<IPathEntry> buildPath);

    /**
     * @return the underlying IProject
     */
    IProject getRawProject();

    /**
     * @return the resolved and possibly filesystem-absolute path corresponding to the given IPath
     */
    IPath resolvePath(IPath path);

    /**
     * @return an array of <code>ISourceFolder</code> corresponding to the configured source folders
     * for this project
     */
    ISourceFolder[] getSourceRoots();

    /**
     * @return an array of the direct children of this <code>ISourceEntity</code>; returns an empty
     * list (not null) if this entity has no children
     */
    ISourceEntity[] getChildren();
}
