/**
 * <copyright>
 *
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: OCLInput.java,v 1.1 2007/01/25 18:24:37 cdamus Exp $
 */
package org.eclipse.ocl;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

import org.eclipse.ocl.internal.l10n.OCLMessages;

/**
 * Encapsulation of an OCL document, which may be obtained from a string or from
 * a stream.  The content of the OCL document consists of one or more context
 * declarations (including constraints) with optional package declarations.
 * 
 * @author Christian W. Damus (cdamus)
 */
public final class OCLInput {
	private String textString;
	private Reader textReader;
	
    /**
     * Creates an OCL document from a string.
     * 
     * @param oclText the string containing the OCL document
     */
	public OCLInput(String oclText) {
		this.textString = oclText;
	}
	
    /**
     * Creates an OCL document from an input stream, using the default character
     * set to decode it.
     * 
     * @param oclStream the input stream providing the OCL document
     */
	public OCLInput(InputStream oclStream) {
		this.textReader = new InputStreamReader(oclStream, Charset.defaultCharset());
	}
	
    /**
     * Creates an OCL document from an input stream in the specified encoding.
     * 
     * @param oclStream the input stream providing the OCL document
     * @param encoding the stream's character encoding
     * 
     * @throws UnsupportedEncodingException if the specified encoding is not
     *     supported in this virtual machine
     */
	public OCLInput(InputStream oclStream, String encoding)
			throws UnsupportedEncodingException {
		this.textReader = new InputStreamReader(oclStream, encoding);
	}
	
    /**
     * Creates an OCL document from a character stream.
     * 
     * @param oclReader the stream providing the OCL document
     */
	public OCLInput(Reader oclReader) {
		this.textReader = oclReader;
	}
	
    /**
     * The contents of the OCL document as a character array, suitable for
     * consumption by the OCL parser.
     * 
     * @return the OCL document contents
     * 
     * @throws ParserException on an I/O failure in reading the content
     */
	public char[] getContent() throws ParserException {
		if (textString != null) {
			return textString.toCharArray();
		}
		
		StringBuilder builder = buildStringFromReader();
		
		char[] result = new char[builder.length()];
		builder.getChars(0, result.length, result, 0);
		return result;
	}
    
    /**
     * The contents of the OCL document as a character array, suitable for
     * consumption by the OCL parser.
     * 
     * @return the OCL document contents
     * 
     * @throws ParserException on an I/O failure in reading the content
     */
    public String getContentAsString() throws ParserException {
        if (textString != null) {
            return textString;
        }
        
        StringBuilder builder = buildStringFromReader();
        
        return builder.toString();
    }
    
    private StringBuilder buildStringFromReader() throws ParserException {
        StringBuilder result = new StringBuilder();
        CharBuffer cbuf = CharBuffer.allocate(2048);
        
        try {
            try {
                for (;;) {
                    int read = textReader.read(cbuf);
                    
                    if (read < 0) {
                        break;
                    }
                    
                    cbuf.flip();
                    result.append(cbuf);
                }
            } finally {
                textReader.close();
            }
        } catch (IOException e) {
            throw new ParserException(
                OCLMessages.bind(OCLMessages.Input_ERROR_, e.getLocalizedMessage()),
                e);
        }
        
        return result;
    }
    
    /**
     * The contents of the OCL document as a character stream, suitable for
     * consumption by the OCL parser.
     * 
     * @return the OCL document contents
     */
    public Reader getContentAsStream() {
        if (textReader != null) {
            return textReader;
        }
        
        return new StringReader(textString);
    }
}
