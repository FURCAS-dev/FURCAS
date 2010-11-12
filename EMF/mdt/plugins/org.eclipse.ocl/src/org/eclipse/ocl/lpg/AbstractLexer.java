/**
* <copyright>
*
* Copyright (c) 2005, 2008 IBM Corporation, Zeligsoft Inc., and others.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   IBM - Initial API and implementation
*   E.D.Willink - Lexer and Parser refactoring to support extensibility and flexible error handling
*             - Bug 243976
*   Zeligsoft - Bug 243976 
*
* </copyright>
*
* $Id: AbstractLexer.java,v 1.6 2010/05/03 09:32:32 ewillink Exp $
*/

package org.eclipse.ocl.lpg;

import java.io.IOException;
import java.io.Reader;

import lpg.runtime.ILexStream;
import lpg.runtime.LexParser;
import lpg.runtime.Monitor;
import lpg.runtime.ParseTable;


/**
 * The <code>AbstractLexer</code> supports lexical analysis of keyword tokens produced by
 * a keyword lexer to create syntactic tokens for an <code>AbstractLexer</code> that
 * creates a corresponding CST, that may in turn be
 * exploited by an <code>AbstractAnalyzer</code> to create an AST.
 * 
 * Derived classes should extend the abstract support for AST from CST from tokens from text
 * parsing and analysis to support the AST and CST classes appropriate to a particular language.
 */
public abstract class AbstractLexer
{
    
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
	
    public AbstractLexer(BasicEnvironment environment)
    {
        this.environment = environment;
    }

	public BasicEnvironment getEnvironment() {
		return environment;
	}

    /**
	 * Define the input text as a given array of characters.
     * @param inputChars the characters
     * @deprecated clients should use {@link #reset(char[], String)}
     */
	@Deprecated
	public void initialize(char[] inputChars) {
		reset(inputChars, null);
	}

	/**
	 * Define the input text by reading from a reader.
     * @param reader providing the source text
     * @throws IOException if reading fails
     * 
     * @deprecated clients should invoke {@link #reset(Reader, String)}
     */
	@Deprecated
	public void initialize(Reader reader) throws IOException {
    	char[] buffer = getInputChars(reader);
    	reset(buffer, null);
    }

	/**
	 * @param parser the {@link AbstractParser} instance
	 * @deprecated clients should invoke {@link #lexer(DerivedPrsStream)}
	 */
	@Deprecated
	public void lexToTokens(AbstractParser parser) {
		lexToTokens(null, parser);
	}

	/**
	 * @param parser the {@link AbstractParser} instance
	 * @deprecated clients should invoke {@link #lexer(Monitor, DerivedPrsStream)}
	 */
	@Deprecated
	public void lexToTokens(Monitor monitor, AbstractParser parser) {
        lexer(monitor, parser.getIPrsStream());
    }
    
    // Some methods which will be implemented by the generated lexer
	/**
	 * Queries the token kinds, as defined by my keyword lexer, of tokens that
	 * are keywords in by grammar.
	 * 
	 * @return my keyword lexer's token kinds
	 * 
	 * @since 1.3
	 */
    public abstract int [] getKeywordKinds();

	/**
	 * @return the lexers's {@link ILexStream lexStream}
	 * 
	 * @since 3.0
	 */
	public abstract DerivedLexStream getILexStream();	

    /**
     * Resets the lexer's input with the given char's array.
     * 
     * @param input_chars the new lexer's input
     * @param filename a file name used for logging when encountering errors/warnings
     *  
	 * @since 3.0
     */
    public abstract void reset(char[] input_chars, String filename);
  
    /**
     * Resets the lexer's input with the given char's array.
     * 
     * @param input_chars the new lexer's input
     * @param filename a file name used for logging when encountering errors/warnings
     * @param tab lexer's tab length.
     *  
	 * @since 3.0
     */
    public abstract void reset(char[] input_chars, String filename, int tab);

    /**
     * Resets the lexer's input with the given Reader
     * 
     * @param reader the new lexer's input
     * @param filename a file name used for logging when encountering errors/warnings
     * @throws java.io.IOException
     * 
     * @since 3.0
     */
    public abstract void reset(Reader reader, String filename) throws java.io.IOException;
	

    /**
     * Runs the lexer's  with the provided {@link DerivedPrsStream parseStream}  
     * 
     * @param prsStream the associated {@link DerivedPrsStream parseStream}
     * @since 3.0
     */
    public abstract void lexer(DerivedPrsStream prsStream);
    
    /**
     * Runs the lexer's  with the provided {@link DerivedPrsStream parseStream} and
     * the given monitor.
     * 
     * @param monitor the {@link Monitor} 
     * @param prsStream the associated {@link DerivedPrsStream parseStream}
     * 
     * @since 3.0
     */
    public abstract void lexer(Monitor monitor, DerivedPrsStream prsStream);

    /**
     * Runs the lexer's  with the provided {@link DerivedPrsStream parseStream}
     * in specific offset of the input
     * 
     * @param prsStream the associated {@link DerivedPrsStream parseStream}
     * @param start_offset the start offset
     * @param end_offset the end offset
     * 
     * @since 3.0
     */
    public abstract void lexer(DerivedPrsStream prsStream, int start_offset, int end_offset);

    /**
     * Runs the lexer's  with the provided {@link DerivedPrsStream parseStream}
     * in specific offset of the input
     * 
     * @param prsStream the associated {@link DerivedPrsStream parseStream}
     * @param start_offset the start offset
     * @param end_offset the end offset
     * 
     * @since 3.0
     */
    public abstract void lexer(Monitor monitor, DerivedPrsStream prsStream, int start_offset, int end_offset);

    /**
     * @return the lexer's {@link ParseTable}
	 * @since 3.0
	 */
    public abstract ParseTable getParseTable();
    
    /**
     * @return the lexer's {@link LexParser} 
	 * @since 3.0
	 */
    public abstract LexParser getParser();
    

    /**
     * Rsets the lexer's keywordLexer
     * @since 3.0
     */
    public abstract void resetKeywordLexer();
    
    /**
     * @return the lexer's {@link ILexStream lexStream}
	 * @since 3.0
	 */
	public abstract ILexStream getLexStream();

	/**
	 * Report a lexical error in the given localization (start and end offset)
	 * 
	 * @param startLoc the offset the error starts
	 * @param endLoc the offset the error ends.
	 * 
	 * @since 3.0
	 */
	public abstract void reportLexicalError(int startLoc, int endLoc);
}

