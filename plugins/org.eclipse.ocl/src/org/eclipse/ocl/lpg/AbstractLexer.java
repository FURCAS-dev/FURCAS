/**
* <copyright>
*
* Copyright (c) 2005, 2007 IBM Corporation and others.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   IBM - Initial API and implementation
*   E.D.Willink - Lexer and Parser refactoring to support extensibility and flexible error handling 
*
* </copyright>
*
* $Id: AbstractLexer.java,v 1.1 2007/10/11 23:04:53 cdamus Exp $
*/

package org.eclipse.ocl.lpg;

import java.io.IOException;
import java.io.Reader;

import lpg.lpgjavaruntime.LpgLexStream;
import lpg.lpgjavaruntime.Monitor;
import lpg.lpgjavaruntime.RuleAction;


/**
 * The <code>AbstractLexer</code> supports lexical analysis of keyword tokens produced by
 * a keyword lexer to create syntactic tokens for an <code>AbstractLexer</code> that
 * creates a corresponding CST, that may in turn be
 * exploited by an <code>AbstractAnalyzer</code> to create an AST.
 * 
 * Derived classes should extend the abstract support for AST from CST from tokens from text
 * parsing and analysis to support the AST and CST classes appropriate to a particular language.
 */
public abstract class AbstractLexer extends LpgLexStream implements RuleAction
{
    protected final static int ECLIPSE_TAB_VALUE = 4;
    
    /**
 	 * Read all input characters from a reader.
     * @param reader providing the source text
     * @return the input characters
     * @throws IOException if reading fails
     */
    public static char[] getInputChars(Reader reader) throws IOException {
		char[] buffer = new char[16384];
    	int nextIndex = 0;
    	while (reader.ready()) {
    		if (nextIndex >= buffer.length) {
    			char[] newBuffer = new char[2 * buffer.length];
    			System.arraycopy(buffer, 0, newBuffer, 0, buffer.length);
    			buffer = newBuffer;
    		}
        	int moreChars = reader.read(buffer, nextIndex, buffer.length - nextIndex);
        	if (moreChars > 0)
        		nextIndex += moreChars;
        	else if (moreChars < 0)
        		break;
    	}
    	if (nextIndex != buffer.length) {
			char[] newBuffer = new char[nextIndex];
			System.arraycopy(buffer, 0, newBuffer, 0, nextIndex);
			buffer = newBuffer;
    	}
		return buffer;
	}  
    
	private final BasicEnvironment environment;
	
    public AbstractLexer(BasicEnvironment environment, String filename, int tab) throws java.io.IOException 
    {
        super(filename, tab);
        this.environment = environment;
    }

    public AbstractLexer(BasicEnvironment environment, char[] input_chars, String filename, int tab)
    {
        super(input_chars, filename, tab);
        this.environment = environment;
    }

    public AbstractLexer(BasicEnvironment environment) {
    	setTab(ECLIPSE_TAB_VALUE);
        this.environment = environment;
    }

	protected int computeErrorCode(int leftToken, int rightToken) {
		if (rightToken >= getStreamLength())
		    return EOF_CODE;
		else if (leftToken == rightToken)
		    return LEX_ERROR_CODE;
		else
			return INVALID_TOKEN_CODE;
	}

	public BasicEnvironment getEnvironment() {
		return environment;
	}

	public void lexToTokens(AbstractParser parser) {
		lexToTokens(null, parser);
	}
	
	public abstract void lexToTokens(Monitor monitor, AbstractParser parser);

	/**
	 * Errors generated within the lexer are redirected to the error handler if there is one.
	 * 
	 * Note that other variants of reportError either feed this one, are fed from a default implementation
	 * of this one or originate in the parser, where a ParserErrorHandler can intercept them.
	 */
	@Override public void reportError(int leftToken, int rightToken) {
		BasicEnvironment environment = getEnvironment();
		if (environment != null)
			environment.lexerError(computeErrorCode(leftToken, rightToken), leftToken, rightToken);
		else
			super.reportError(leftToken, rightToken);
	}

    /**
	 * Define the input text as a given array of characters.
     * @param buffer the characters
     */
	public void initialize(char[] inputChars) {
		setInputChars(inputChars);
        setStreamLength(inputChars.length);
        computeLineOffsets();        
	}

	/**
	 * Define the input text by reading from a reader.
     * @param reader providing the source text
     * @throws IOException if reading fails
     */
	public void initialize(Reader reader) throws IOException {
    	char[] buffer = getInputChars(reader);
    	initialize(buffer);
    }
}

