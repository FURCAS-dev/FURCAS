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

package org.eclipse.imp.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import org.eclipse.compare.IEncodedStreamContentAccessor;
import org.eclipse.compare.IStreamContentAccessor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;

public class StreamUtils {
    private StreamUtils() { }

    /**
     * Given an IStreamContentAccessor, determines the appropriate encoding to use
     * and reads the stream's contents as a String. Specifically, if the IStreamContentAccessor
     * is also an IEncodedStreamContentAccessor, that encoding is used. Otherwise, the
     * platform default encoding is used.
     */
    public static String readStreamContents(IStreamContentAccessor sca) throws CoreException {
        InputStream is= sca.getContents();
        if (is != null) {
            String encoding= null;
            if (sca instanceof IEncodedStreamContentAccessor) {
                try {
                    encoding= ((IEncodedStreamContentAccessor) sca).getCharset();
                } catch (Exception e) {
                }
            }
            if (encoding == null)
                encoding= ResourcesPlugin.getEncoding();
            return readStreamContents(is, encoding);
        }
        return null;
    }

    /**
     * Reads the contents of the given reader into a string using the encoding
     * associated with the reader. Returns null if an error occurred.
     */
    public static String readReaderContents(Reader r) {
        BufferedReader reader= null;
        try {
            StringBuffer buffer= new StringBuffer();
            char[] part= new char[2048];
            int read= 0;
            reader= new BufferedReader(r);
    
            while ((read= reader.read(part)) != -1)
                buffer.append(part, 0, read);
    
            return buffer.toString();
        } catch (IOException ex) {
            System.err.println("I/O Exception: " + ex.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    // silently ignored
                }
            }
        }
        return null;
    }

    /**
     * Reads the contents of the given input stream into a string using the given encoding.
     * Returns null if an error occurred.
     */
    public static String readStreamContents(InputStream is, String encoding) {
    	try {
			return readReaderContents(new InputStreamReader(is, encoding));
		} catch (UnsupportedEncodingException e) {
			return null;
		}
    }

    public static String readStreamContents(InputStream is) {
    	return readStreamContents(is, ResourcesPlugin.getEncoding());
    }
}
