/**
 * <copyright>
 *
 * Copyright (c) 2008 Open Canarias S.L. and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Adolfo Sanchez-Barbudo Herrera (Open Canarias)- Initial API and implementation
 *
 * </copyright>
 *
 * $Id: DerivedLexStream.java,v 1.2 2010/05/03 09:32:32 ewillink Exp $
 */
package org.eclipse.ocl.lpg;

import lpg.runtime.LpgLexStream;


/**
 * This DerivedLexStream will be used in favour of the LpgLexStream for the 
 * OCLLexer, so that some customization are introduced and exploited by the 
 * generated OCLLexer 
 * 
 * @since 3.0
 */
public abstract class DerivedLexStream extends LpgLexStream {
	
	protected final static int ECLIPSE_TAB_VALUE = 4;	
	private BasicEnvironment environment;
	
    public DerivedLexStream(BasicEnvironment environment, String filename, int tab) throws java.io.IOException 
    {
        super(filename, tab);
        this.environment = environment;
    }

    public DerivedLexStream(BasicEnvironment environment, char[] input_chars, String filename, int tab)
    {
        super(input_chars, filename, tab);
        this.environment = environment;
    }

    public DerivedLexStream() {
    	super();
    	setTab(ECLIPSE_TAB_VALUE);
    }
    
	protected int computeErrorCode(int leftToken, int rightToken) {
		if (rightToken >= getStreamLength())
		    return EOF_CODE;
		else if (leftToken == rightToken)
		    return LEX_ERROR_CODE;
		else
			return INVALID_TOKEN_CODE;
	}
	
    /**
	 * Define the input text as a given array of characters.
     * @param inputChars the characters
     */
	public void initialize(char[] inputChars) {	
		setInputChars(inputChars);
        setStreamLength(inputChars.length);
        computeLineOffsets();
	}
	
	/**
	 * Errors generated within the lexer are redirected to the error handler if there is one.
	 * 
	 * Note that other variants of reportLexicalError and reportError either feed this one, are fed from a default implementation
	 * of this one or originate in the parser, where a ParserErrorHandler can intercept them.
	 * @since 3.0
	 */
	@Override
	public void reportLexicalError(int errorCode, int leftLoc, int rightLoc,
			int errorLeftLoc, int errorRightLoc, String[] errorInfo) {
		BasicEnvironment environment = this.environment;
		if (environment != null)
			environment.lexerError(errorCode, leftLoc, rightLoc);
		else
			super.reportLexicalError(errorCode, leftLoc, rightLoc, errorLeftLoc,
			errorRightLoc, errorInfo);
	}

}
