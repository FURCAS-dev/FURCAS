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

package org.eclipse.imp.language;

import java.io.DataInputStream;
import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.imp.core.ErrorHandler;

/*
 * Licensed Materials - Property of IBM,
 * (c) Copyright IBM Corp. 2005  All Rights Reserved
 */

/**
 * @author Claffra
 *
 * The interface to be implemented by contributors of the org.eclipse.imp.runtime.languageDescription extension point.
 */
public abstract class LanguageValidator {
    
    /**
     * Validate a given file in a given project whether it implements the programming language 
     * defined in this extension point contribution. For most languages, a quick check to the
     * project nature would be sufficient. For others, the file may have to be opened to verify
     * its contents. 
     * 
     * @param file the file to be opened
     * @return whether the file actually contains text for this programming language 
     */
    public abstract boolean validate(IFile file);
    
    /**
     * Validate a given text buffer whether it implements the programming language 
     * defined in this extension point contribution. 
     * 
     * @param buffer the contents to be verified
     * @return whether the text actually matches this programming language 
     */
    public abstract boolean validate(String buffer);

    /**
     * See if this file contains a given search string. Warning: may cause
     * excessive reading if files are large.
     * @param file the file to check
     * @param searchString the unique string to search for
     * @return whether the file contains the given search string
     */
    protected boolean contains(IFile file, String searchString) {
        try {
			DataInputStream is = new DataInputStream(file.getContents());
			byte bytes[] = new byte[is.available()];
			is.readFully(bytes);
			String contents = new String(bytes);
			return contents.indexOf(searchString) != -1;
        }
        catch (CoreException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
    }
    
    /**
     * See if the project has a given nature added to it.
     * @param project the project to check
     * @param natureId the id of the nature
     * @return whether the project has the nature added to it
     */
     protected boolean hasNature(IProject project, String natureId) {
        try {
            return project.getNature(natureId) != null;
        }
        catch (CoreException e) {
            ErrorHandler.reportError("LanguageValidator Error", e);
            return false;
        }
    }
    
    /**
     * Get the natures for this project
     * @param project the project to inspect
     * @return the list of nature ids for this project
     */
    protected String[] getNatures(IProject project) {
        try {
            return project.getDescription().getNatureIds();
        }
        catch (CoreException e) {
            ErrorHandler.reportError("LanguageValidator Error", e);
            return new String[0];
        }
    }
}
