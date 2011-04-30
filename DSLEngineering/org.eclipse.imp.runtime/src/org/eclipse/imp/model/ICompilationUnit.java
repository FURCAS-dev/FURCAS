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

/*
 * Created on Mar 13, 2007
 */
package org.eclipse.imp.model;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.imp.parser.IMessageHandler;

public interface ICompilationUnit extends ISourceEntity {
    ISourceProject getProject();

    IPath getPath();

    /**
     * @return the file corresponding to the receiver, if possible, or null if not.
     */
    IFile getFile();

    String getSource();

    Object getAST(IMessageHandler msgHandler, IProgressMonitor monitor);
}
