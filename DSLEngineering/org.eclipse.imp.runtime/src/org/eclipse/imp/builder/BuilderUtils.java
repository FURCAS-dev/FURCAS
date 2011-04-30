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

package org.eclipse.imp.builder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.imp.utils.StreamUtils;


public class BuilderUtils {


    /**
     * Operates on a file with contents that have a textual representation
     * and returns the contents in the form of a String.
     * 
     * @param inFileName  Name of a file that contains some content suitable
     *                    for a String representation.  Used as given (whether
     *                    absolute or relative)
     */
    static public String extractContentsToString(String inFileName)
    {
        // Check the given file name
        if ((inFileName == null) || (inFileName.length() == 0)) {
            throw new IllegalArgumentException(
                "BuilderUtils.extractContentsToString(): file name is null or empty");
        }

        // Check that the inFile exists and can be read
        File inFile= new File(inFileName);

        if (!inFile.exists() || !inFile.canRead()) {
            throw new IllegalArgumentException(
                "BuilderUtils.extractContentsToString(): file does not exist or cannot be read " +
                "(name = " + inFileName + ")");
        }
        return getFileContents(inFile);

    }

    /**
     * @return the text contents of the given file as a String, without
     * translating line terminating characters.
     */
    public static String getFileContents(IFile file) {
    	try {
    		return StreamUtils.readStreamContents(file.getContents());
    	} catch (CoreException e) {
            System.err.println(e.getMessage());
            return "";
    	}
    }

    public static String getFileContents(File file) {
    	InputStream fileStream = null;
        try {
        	fileStream = new FileInputStream(file);
        } catch(FileNotFoundException fnf) {
            System.err.println(fnf.getMessage());
            return "";
        }
    	return StreamUtils.readStreamContents(fileStream);
    }

    /**
     * @return the text contents of the given Reader, without translating
     * line terminating characters.
     */
    public static String getFileContents(Reader reader) {

    	
    	
	// In this case we don't know the length in advance, so we have to
	// accumulate the reader's contents one buffer at a time.
	StringBuilder sb= new StringBuilder(4096);
	char[] buff= new char[4096];
	int len;

	while(true) {
	    try {
		len= reader.read(buff);
	    } catch (IOException e) {
		break;
	    }
	    if (len < 0)
		break;
	    sb.append(buff, 0, len);
	}
	return sb.toString();
    }
}
