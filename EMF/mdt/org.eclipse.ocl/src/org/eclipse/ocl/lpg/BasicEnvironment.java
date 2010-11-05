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
 *   E.D.Willink - Lexer and Parser refactoring to support extensibility and flexible error handling 
 *
 * </copyright>
 *
 * $Id: BasicEnvironment.java,v 1.2 2007/11/06 19:47:11 cdamus Exp $
 */
package org.eclipse.ocl.lpg;

import java.util.List;

import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.options.Customizable;
import org.eclipse.ocl.util.Adaptable;

/**
 * A <code>BasicEnvironment</code> provides input token and output problem support for a text analysis
 * comprising an <code>AbstractAnalyzer</code> for semantic analysis,
 * <code>AbstractParser</code> for syntactic analysis
 * (parsing), and an <code>AbstractLexer</code> for lexical analysis.
 */
public interface BasicEnvironment extends Adaptable, Customizable
{	
	/**
	 * Return the mapping of an astNode to its originating cstNode, so that
	 * AST-based analysis may report error messages exploiting the CST context, or
	 * to support incremental AST/CST update.
	 * 
	 * @param astNode
	 * @return cstNode
	 */
	CSTNode getASTMapping(Object astNode);
	
	/**
	 * Initialize the mapping of an object (typically an astNode) to its originating cstNode,
	 * so that AST-based analysis may report error messages exploiting the CST context, or
	 * to support incremental AST/CST update.
	 * 
	 * @param astNode
	 * @param cstNode
	 */
	void initASTMapping(Object astNode, CSTNode cstNode);

	/**
	 * Return the message formatter that may be used to format object-related contributions
	 * to problem messages.
	 * @return non-null message formatter
	 */
	FormattingHelper getFormatter();

	/**
	 * Define the syntactic parser from which source tokens and text amy be obtained.
	 * @param parser
	 */
	void setParser(AbstractParser parser);

	/**
	 * Return the syntactic parser from which source tokens and text amy be obtained.
	 * @return parser
	 */
	AbstractParser getParser();
	
	/**
	 * Define the handler for any problem reports.
	 * @param problemHandler
	 * @return the previous problem handler
	 */
	ProblemHandler setProblemHandler(ProblemHandler problemHandler);

	/**
	 * Obtains a problem handler to service lexer, parser, analyzer, validator, ... errors.
	 * 
	 * @return the problem handler.
	 */
	ProblemHandler getProblemHandler();

	/**
	 * Generically reports a problem about some object.
	 * 
	 * @param severity the severity of the problem
	 * @param phase the phase in which the problem was encountered
	 * @param problemMessage  message describing the problem
	 * @param problemContext optional message describing the reporting context
	 * @param problemObject optional object associated with the problem
	 */
	void problem(ProblemHandler.Severity severity, ProblemHandler.Phase phase,
			String problemMessage, String problemContext, Object problemObject);
	
	/**
	 * Convenience method invoking <code>getProblemHandler().analyzerProblem</code>
	 * with a <code>ProblemHandler.errorSeverity</code>.
	 * @param problemMessage message describing the problem
	 * @param problemContext optional message describing the reporting context
	 * @param problemObject optional object associated with the problem
	 */
	void analyzerError(String problemMessage, String problemContext, Object problemObject);

	/**
	 * Convenience method invoking <code>getProblemHandler().analyzerProblem</code>
	 * with a <code>ProblemHandler.errorSeverity</code>.
	 * @param problemMessage message describing the problem
	 * @param problemContext optional message describing the reporting context
	 * @param problemObjects optional sequence of objects associated with the problem
	 */
	void analyzerError(String problemMessage, String problemContext, List<?> problemObjects);

	/**
	 * Convenience method invoking <code>getProblemHandler().analyzerProblem</code>
	 * with a <code>ProblemHandler.errorSeverity</code>.
	 * @param problemMessage message describing the problem
	 * @param problemContext optional message describing the reporting context
	 * @param startOffset character index at the start of the error
	 * @param endOffset character index beyond the end of the error
	 */
	void analyzerError(String problemMessage, String problemContext, int startOffset, int endOffset);

	/**
	 * Convenience method invoking <code>getProblemHandler().analyzerProblem</code>
	 * with a <code>ProblemHandler.warningSeverity</code>.
	 * @param problemMessage message describing the problem
	 * @param problemContext optional message describing the reporting context
	 * @param problemObject optional object associated with the problem
	 */
	void analyzerWarning(String problemMessage, String problemContext, Object problemObject);
	
	/**
	 * Convenience method invoking <code>getProblemHandler().lexerProblem</code>
	 * with a <code>ProblemHandler.errorSeverity</code>.
	 * @param errorCode the ParserErrorCodes value identifying the error
	 * @param startOffset character index at the start of the error
	 * @param endOffset character index beyond the end of the error
	 */
	void lexerError(int errorCode, int startOffset, int endOffset);

	/**
	 * Convenience method invoking <code>getProblemHandler().parserProblem</code>
	 * with a <code>ProblemHandler.errorSeverity</code>.
	 * @param errorCode the ParserErrorCodes value identifying the error
	 * @param leftToken the lexical token index at the left hand edge of the error
	 * @param rightToken the lexical token index at the right hand edge of the error
	 * @param tokenText additional text apprropriate to the ParserErrorCodes value.
	 */
	void parserError(int errorCode, int leftToken, int rightToken, String tokenText);

	/**
	 * Convenience method invoking <code>getProblemHandler().utilityProblem</code>
	 * with a <code>ProblemHandler.errorSeverity</code>.
	 * @param problemMessage message describing the problem
	 * @param problemContext optional message describing the reporting context
	 * @param problemObject optional object associated with the problem
	 */
	void utilityError(String problemMessage, String problemContext, Object problemObject);

	/**
	 * Convenience method invoking <code>getProblemHandler().validatorProblem</code>
	 * with a <code>ProblemHandler.errorSeverity</code>.
	 * @param problemMessage message describing the problem
	 * @param problemContext optional message describing the reporting context
	 * @param problemObject optional object associated with the problem
	 */
	void validatorError(String problemMessage, String problemContext, Object problemObject);
}
