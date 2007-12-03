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
 *   E.D.Willink - refactored to separate from OCLAnalyzer and OCLParser
 *
 * </copyright>
 *
 * $Id: AbstractAnalyzer.java,v 1.2 2007/12/03 18:44:41 cdamus Exp $
 */
package org.eclipse.ocl.lpg;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.internal.OCLPlugin;
import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.CallingASTNode;
import org.eclipse.ocl.utilities.TypedASTNode;

/**
 * The <code>AbstractAnalyzer</code> supports semantic analysis of a CST produced by
 * an <code>AbstractParser</code> to create a corresponding AST. It is necessary that
 * syntactic parsing and semantic analysis are performed in two steps
 * because LPG is a bottom up parser and cannot provide enough contextual
 * information to create the AST on the first pass.
 * 
 * Derived classes should extend the abstract support for AST from CST from tokens from text
 * parsing and analysis to support the AST and CST classes appropriate to a particular language.
 */
public abstract class AbstractAnalyzer
{	 
	private final AbstractParser parser;		// The parser that provides CST and source text
	private final BasicEnvironment environment;	// The symbol lookup, problem handling context 
	private FormattingHelper formatter = null;	// The message formatting assistant
	private boolean traceflag = false;			// Optional AST tracing for debug
	private int charOffset = 0;					// Optional offset applied to reported text to hide
												//  extra surrounding context
	
	protected AbstractAnalyzer(AbstractParser parser) {
		this.parser = parser;				
		this.environment = parser.getEnvironment();				
	}
	
	/**
	 * Obtains the text from which the specified CST <code>node</code> was parsed.
	 * 
	 * @param node a concrete syntax node
	 * 
	 * @return its text
	 */
	public String computeInputString(CSTNode node) {
		return getParser().computeInputString(node.getStartOffset(), node.getEndOffset());
	}

	public void dumpTokens() {
		parser.dumpTokens();		
	}

	public String formatClass(Object object) {
		return getFormatter().formatClass(object);
	}

	public String formatEClassName(EObject object) {
		return getFormatter().formatEClassName(object);
	}

	public String formatName(Object object) {
		return getFormatter().formatName(object);
	}

    public String formatQualifiedName(Object object) {
        return getFormatter().formatQualifiedName(object);
    }

	public String formatPath(List<String> pathName) {
		return getFormatter().formatPath(pathName);
	}

	public String formatPath(List<String> pathName, String name) {
		return getFormatter().formatPath(pathName, name);
	}

	public String formatString(String string) {
		return getFormatter().formatString(string);
	}
	
	public String formatType(Object object) {
		return getFormatter().formatType(object);
	}
	
	public int getCharOffset() {
		return charOffset;
	}

	public BasicEnvironment getEnvironment() {
		return environment;
	}

	/**
	 * Get the message formatting assistant, returning the value set by setFormatter,
	 * if non-null, else that provided by the enbvironment, if non-null, else
	 * AbstractFormattingHelper.INSTANCE.
	 * 
	 * @return A non-null message formatting helper
	 */
	public FormattingHelper getFormatter() {
		if (formatter == null) {
			BasicEnvironment environment = getEnvironment();
			if (environment != null) {
                formatter = environment.getFormatter();
            }
			if (formatter == null) {
                formatter = AbstractFormattingHelper.INSTANCE;
            }
		}
		return formatter;
	}

    public AbstractLexer getLexer() {
    	return getParser().getLexer();
    }

	public AbstractParser getParser() {
		return parser;
	}
	
	public boolean getTraceFlag() {
		return traceflag;
	}

	/**
	 * Initializes the start and end positions of the property name in the
	 * specified calling AST node.
	 *
	 * @param callingASTNode a calling AST node
	 * @param cstNode a CST node
	 */
	protected void initPropertyPositions(CallingASTNode callingASTNode, CSTNode cstNode) {
		callingASTNode.setPropertyStartPosition(cstNode.getStartOffset() + charOffset);
		callingASTNode.setPropertyEndPosition(cstNode.getEndOffset() + charOffset + 1);
		// +1 because end offset is exclusive
	}

	/**
	 * Initializes the start and end positions of the specified AST node
	 * from the given CST node
	 *
	 * @param astNode an AST node
	 * @param cstNode a CST node
	 */
	protected void initStartEndPositions(ASTNode astNode, CSTNode cstNode) {
		if ((astNode != null) && (cstNode != null)) {
//			initASTMapping(astNode, cstNode);
			astNode.setStartPosition(cstNode.getStartOffset() + charOffset);
			astNode.setEndPosition(cstNode.getEndOffset() + charOffset + 1);
			// +1 because end offset is exclusive
		}
	}

	/**
	 * Initializes the type start and end positions of the specified typed AST node
	 * from the given CST node
	 *
	 * @param typedASTNode a typed AST node
	 * @param cstNode a CST node
	 */
	protected void initTypePositions(TypedASTNode typedASTNode, CSTNode cstNode) {
		if ((typedASTNode != null) && (cstNode != null)) {
//			if (typedASTNode instanceof TypedElement)
//				initASTMapping(((TypedElement)typedASTNode).getType(), cstNode);
//			else if (typedASTNode instanceof CollectionType)
//				initASTMapping(((CollectionType)typedASTNode).getElementType(), cstNode);
			typedASTNode.setTypeStartPosition(cstNode.getStartOffset() + charOffset);
			typedASTNode.setTypeEndPosition(cstNode.getEndOffset() + charOffset + 1);
			// +1 because end offset is exclusive
		}
	}

	/**
	 * Creates a string by joining the given string list elements
	 * with ::.
	 * 
	 * @param namelist list of names to make string out of
	 * @return the qualified name comprising the list of name elements
	 */
	protected String makeName(EList<String> namelist) {
		StringBuffer msg = new StringBuffer();
		for (int i = 0; i < namelist.size(); i++) {
			if (i > 0) {
                msg.append("::");//$NON-NLS-1$
            }
			msg.append(namelist.get(i));
		}
		return msg.toString();
	}

	/**
	 * Creates a string by joining the given string list elements
	 * with spaces.
	 * 
	 * @param namelist list of names to make string out of
	 * @return string representation of the list of string elements
	 */
	protected String makeString(EList<String> namelist) {
		String msg = "";//$NON-NLS-1$
		for (int i = 0; i < namelist.size(); i++) {
			msg += " " + namelist.get(i);//$NON-NLS-1$
		}
		return msg;
	}
	
	/**
	 * Sets the character index offset of the input.
	 * 
	 * @param offset
	 */
	public void setCharacterOffset(int offset) {
		charOffset = offset;
	}

    public void setFileName(String filename) {
    	getLexer().setFileName(filename);
    } 

    /**
	 * Define the input text as a given array of characters.
     * @param buffer the characters
     */
    public void initialize(char[] buffer) {
    	getLexer().initialize(buffer); 
    } 

	/**
	 * Define the input text by reading from a reader.
     * @param reader providing the source text
     * @throws IOException if reading fails
     */
    public void initialize(Reader reader) throws IOException {
    	getLexer().initialize(reader); 
    }

    public void setTab(int tab) {
    	getLexer().setTab(tab);
    }

	public void setTraceFlag(boolean flag) {
		traceflag = flag;
	}
	
	public void ERROR(String problemMessage) {
		getEnvironment().utilityError(problemMessage, null, null);
	}
	
	public void ERROR(Object problemObject, String rule, String problemMessage) {
		getEnvironment().analyzerError(problemMessage, rule, problemObject);
	}
	
	public void ERROR(List<?> problemObjects, String rule, String problemMessage) {
		getEnvironment().analyzerError(problemMessage, rule, problemObjects);
	}
	
	protected void TRACE( String rule, String message) {
		if (traceflag) {
			OCLPlugin.trace(rule + ": " + message);//$NON-NLS-1$
		}
	}
			
	protected void TRACE(String rule, String message, EList<String> namelist) {		  			
		TRACE(rule, message + makeString(namelist)); 
	}
}
