/**
 * <copyright>
 *
 * Copyright (c) 2007, 2009 IBM Corporation, Zeligsoft Inc., Borland Software Corp., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Lexer and Parser refactoring to support extensibility and flexible error handling
 *             - Bugs 243976, 242236, 283509
 *   Zeligsoft - Bugs 245760, 243976, 242236
 *   Borland - Bug 266320
 *   
 * </copyright>
 *
 * $Id: AbstractBasicEnvironment.java,v 1.10 2010/01/22 18:37:57 asanchez Exp $
 */
package org.eclipse.ocl.lpg;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lpg.runtime.IToken;
import lpg.runtime.ParseErrorCodes;

import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.internal.OCLDebugOptions;
import org.eclipse.ocl.internal.OCLPlugin;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.lpg.ProblemHandler.Phase;
import org.eclipse.ocl.lpg.ProblemHandler.Severity;
import org.eclipse.ocl.options.Option;
import org.eclipse.ocl.parser.OCLProblemHandler;

/**
 * Partial implementation of the {@link BasicEnvironment} interface, providing
 * default behaviours for most features.
 * 
 * @since 1.2
 */
public abstract class AbstractBasicEnvironment implements BasicEnvironment2 {
	private BasicEnvironment parent;					// parent in environment hierarchy
	private ProblemHandler problemHandler = null;			// handler for problem reports
	private FormattingHelper formatter = null;				// message formatting helper
	private Map<Object, CSTNode> astNodeToCSTNodeMap = null; // map of AST nodes to their originating CST nodes
	private AbstractParser parser = null;					// parser providing source character context
	
	private final Map<Option<?>, Object> options =
	    new java.util.HashMap<Option<?>, Object>();
	
    /**
     * Initializes me with the specified parent environment, which should be
     * of the same type as me.
     * 
     * @param parent an environment of the same type as me (or <code>null</code>)
     */
	protected AbstractBasicEnvironment(BasicEnvironment parent) {	
		this.parent = parent;
	}

	/**
	 * The abstract environment implementation is adaptable.  The default
	 * implementation adapts to and interface actually implemented by the
	 * receiver in addition to the {@link ProblemHandler} interface.
	 * <p>
	 * Subclasses may override or extend this implementation.
	 * </p>
	 */
	@SuppressWarnings("unchecked")
	public <T> T getAdapter(Class<T> adapterType) {
		T result;
		
		if (adapterType.isAssignableFrom(getClass())) {
			result = (T) this;
		} else if (adapterType == ProblemHandler.class) {
			result = (T) getProblemHandler();
		} else {
			result = null;
		}
		
		return result;
	}
	
	public void analyzerError(String problemMessage, String problemContext, Object problemObject) {
		CSTNode cstNode = getASTMapping(problemObject);
		int startOffset = cstNode != null ? cstNode.getStartOffset() : -1;
		int endOffset = cstNode != null ? cstNode.getEndOffset() : -1;
		analyzerError(problemMessage, problemContext, startOffset, endOffset);
	}
	
	public void analyzerError(String problemMessage, String problemContext, List<?> problemObjects) {
		int startOffset = -1;
		int endOffset = -1;
		if ((problemObjects != null) && !problemObjects.isEmpty()) {
			CSTNode startNode = getASTMapping(problemObjects.get(0));
			CSTNode endNode = getASTMapping(problemObjects.get(problemObjects.size()-1));
			startOffset = startNode != null ? startNode.getStartOffset() : -1;
			endOffset = endNode != null ? endNode.getEndOffset() : -1;
		}
		analyzerError(problemMessage, problemContext, startOffset, endOffset);
	}
	
	public void analyzerError(String problemMessage, String problemContext, int startOffset, int endOffset) {
		ProblemHandler problemHandler = getProblemHandler();
		if (problemHandler != null) {
			problemHandler.analyzerProblem(Severity.ERROR,
				problemMessage, problemContext, startOffset, endOffset);
		}
	}
	
	public void analyzerWarning(String problemMessage, String problemContext, Object problemObject) {
		ProblemHandler problemHandler = getProblemHandler();
		if (problemHandler != null) {
			CSTNode cstNode = getASTMapping(problemObject);
			int startOffset = cstNode != null ? cstNode.getStartOffset() : -1;
			int endOffset = cstNode != null ? cstNode.getEndOffset() : -1;
			problemHandler.analyzerProblem(Severity.WARNING,
				problemMessage, problemContext, startOffset, endOffset);
		}
	}

	protected ProblemHandler createDefaultProblemHandler(AbstractParser parser) {
		return new OCLProblemHandler(parser);
	}

    // implements the interface method
	public BasicEnvironment getParent() {
		return parent;
	}
	
	public AbstractParser getParser() {
		return parser;
	}	

	public Map<Object, CSTNode> getASTNodeToCSTNodeMap() {
		if (astNodeToCSTNodeMap == null) {
            astNodeToCSTNodeMap = new HashMap<Object, CSTNode>();
        }
		return astNodeToCSTNodeMap;
	}

	public CSTNode getASTMapping(Object object) {
		if (object instanceof CSTNode) {
            return (CSTNode) object;
        } else if (astNodeToCSTNodeMap != null) {
            return astNodeToCSTNodeMap.get(object);
        } else {
            return null;
        }
	}

	public FormattingHelper getFormatter() {
		if (formatter == null) {
            formatter = createFormattingHelper();
        }
		return formatter;
	}
	
	/**
	 * Obtains the new or existing formatting-helper for this environment
	 * to use.  This default implementation returns the shared
	 * {@link AbstractFormattingHelper}; subclasses may override.
	 * 
	 * @return a new formatting helper
	 * 
	 * @since 1.3
	 */
	protected FormattingHelper createFormattingHelper() {
		return AbstractFormattingHelper.INSTANCE;
	}

	public ProblemHandler getProblemHandler() {
		if (problemHandler == null) {
			BasicEnvironment parent = getParent();
			if ((parser == null) && (parent != null)) {
				return parent.getProblemHandler();
			}
			
			problemHandler = createDefaultProblemHandler(parser);
		}
		return problemHandler;
	}

	public void initASTMapping(Object astNode, CSTNode cstNode) {
		initASTMapping(astNode, cstNode, astNode);
	}

	/**
	 * @since 1.3
	 */
	public void initASTMapping(Object fromAstNode, CSTNode cstNode,
			Object toAstNode) {
		if (cstNode != null) {
			if (fromAstNode != null) {
				Map<Object, CSTNode> nodeToCSTNodeMap = getASTNodeToCSTNodeMap();
				CSTNode oldCSTNode = nodeToCSTNodeMap.get(fromAstNode);
				if (oldCSTNode == null) {
					nodeToCSTNodeMap.put(fromAstNode, cstNode);
				} else if (oldCSTNode != cstNode) {
					if (OCLPlugin.shouldTrace(OCLDebugOptions.PARSING)) {
						OCLPlugin
							.trace("Preserved AST mapping of " + fromAstNode.getClass().getSimpleName() + " to " + oldCSTNode.getClass().getSimpleName() + " rather than " + cstNode.getClass().getSimpleName()); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					}
				}
			}
			
			if (toAstNode != null) {
				Object oldAstNode = cstNode.getAst();
				if (oldAstNode == null) {
					cstNode.setAst(toAstNode);
				} else if (oldAstNode != toAstNode) {
					if (OCLPlugin.shouldTrace(OCLDebugOptions.PARSING)) {
						OCLPlugin
							.trace("Preserved CST mapping of " + cstNode.getClass().getSimpleName() + " to " + oldAstNode.getClass().getSimpleName() + " rather than " + toAstNode.getClass().getSimpleName()); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					}
				}
			}
		}
	}

	public void lexerError(int errorCode, int startOffset, int endOffset) {
		ProblemHandler problemHandler = getProblemHandler();
		if (problemHandler != null) {
			String inputText = '"' + parser.computeInputString(startOffset, endOffset) + '"';
	        int tokenIndex = parser.getIPrsStream().getTokenIndexAtCharacter(startOffset);
	        if (tokenIndex < 0) {
	        	tokenIndex = -tokenIndex;
	        }
			String locInfo = parser.getIPrsStream().getEndLineNumberOfTokenAt(tokenIndex)
				+ ":" + parser.getIPrsStream().getEndColumnOfTokenAt(tokenIndex); //$NON-NLS-1$
			String messageTemplate = ProblemHandler.ERROR_MESSAGES[errorCode];
			String message = OCLMessages.bind(messageTemplate, locInfo, inputText);
			problemHandler.lexerProblem(Severity.ERROR, message, null, startOffset, endOffset);
		}
	}

	public void parserError(int errorCode, int leftToken, int rightToken, String tokenText) {
		ProblemHandler problemHandler = getProblemHandler();
		if (problemHandler == null) {
            return;
        }
		int leftTokenLoc = (leftToken > rightToken ? rightToken : leftToken);
		int rightTokenLoc = rightToken;
		int startOffset = parser.getIPrsStream().getStartOffset(leftTokenLoc);
		int endOffset = parser.getIPrsStream().getEndOffset(rightTokenLoc);
		int line = leftTokenLoc >= 0 ? parser.getIPrsStream().getLine(leftTokenLoc) : -1;
		String message;
        if (line <= 0) {
        	message = OCLMessages.InvalidOCL_ERROR_;
		} else {
			String locInfo = ""; //$NON-NLS-1$
			String messageTemplate = ProblemHandler.ERROR_MESSAGES[errorCode].substring(4);
			String inputText = '"' + parser.computeInputString(startOffset, endOffset) + '"';
			switch (errorCode) {
				case ParseErrorCodes.EOF_CODE:
				case ParseErrorCodes.MISPLACED_CODE:
				case ParseErrorCodes.DELETION_CODE:
				case ParseErrorCodes.INVALID_TOKEN_CODE:
					message = OCLMessages.bind(
						messageTemplate,
						locInfo,
						inputText);
					break;
	
				case ParseErrorCodes.MERGE_CODE:
				case ParseErrorCodes.BEFORE_CODE:
				case ParseErrorCodes.INSERTION_CODE:
				case ParseErrorCodes.SUBSTITUTION_CODE: // includes SECONDARY_CODE
					message = OCLMessages.bind(
						messageTemplate,
						new Object[]{
							locInfo,
							tokenText,
							inputText
						});
					break;
	
				default:
					message = OCLMessages.bind(messageTemplate, locInfo, tokenText);
					break;
			}
		}
		problemHandler.parserProblem(Severity.ERROR, message, null, startOffset, endOffset);
		
	}

	public void setASTNodeToCSTNodeMap(Map<Object, CSTNode> astNodeToCstNodeMap) {
		this.astNodeToCSTNodeMap = astNodeToCstNodeMap;
	}

    /**
     * Assigns me a parent environment after construction.  It is not advisable
     * to set the parent to <code>null</code> if I previously had one.
     * 
     * @param parent my new parent
     */
	protected void setParent(BasicEnvironment parent) {
		this.parent = parent;
	}
	
	public void setParser(AbstractParser parser) {
		this.parser = parser;
		if (problemHandler != null) {
			problemHandler.setParser(parser);
		}
	}

	public ProblemHandler setProblemHandler(ProblemHandler newProblemHandler) {
		ProblemHandler oldProblemHandler = problemHandler;
		this.problemHandler = newProblemHandler;
		return oldProblemHandler;
	}

	public void utilityError(String problemMessage, String problemContext, Object problemObject) {
		ProblemHandler problemHandler = getProblemHandler();
		if (problemHandler != null) {
			CSTNode cstNode = getASTMapping(problemObject);
			int startOffset = cstNode != null ? cstNode.getStartOffset() : -1;
			int endOffset = cstNode != null ? cstNode.getEndOffset() : -1;
			problemHandler.utilityProblem(Severity.ERROR,
				problemMessage, problemContext, startOffset, endOffset);
		}
	}
	
	public void validatorError(String problemMessage, String problemContext, Object problemObject) {
		ProblemHandler problemHandler = getProblemHandler();
		if (problemHandler != null) {
			CSTNode cstNode = getASTMapping(problemObject);
			int startOffset = cstNode != null ? cstNode.getStartOffset() : -1;
			int endOffset = cstNode != null ? cstNode.getEndOffset() : -1;
			problemHandler.validatorProblem(Severity.ERROR,
				problemMessage, problemContext, startOffset, endOffset);
		}
	}

	public void problem(Severity severity, Phase phase, String problemMessage,
			String problemContext, Object problemObject) {
		ProblemHandler problemHandler = getProblemHandler();
		if (problemHandler != null) {
			int startOffset = -1;
			int endOffset = -1;
			CSTNode cstNode = getASTMapping(problemObject);
			if (cstNode != null) {
				startOffset = cstNode.getStartOffset();
				endOffset = cstNode.getEndOffset();
			} else if (problemObject instanceof IToken) {
				IToken token = (IToken) problemObject;
				startOffset = token.getStartOffset();
				endOffset = token.getEndOffset();
			}
			problemHandler.handleProblem(severity, phase,
				problemMessage, problemContext, startOffset, endOffset);
		}
	}
	
	protected Map<Option<?>, Object> basicGetOptions() {
	    return options;
	}
	
	public Map<Option<?>, Object> getOptions() {
		Map<Option<?>, Object> result = (getParent() != null)
			? new java.util.HashMap<Option<?>, Object>(getParent().getOptions())
		    : new java.util.HashMap<Option<?>, Object>();
		
		result.putAll(basicGetOptions());
		
		return result;
	}
	
	public <T> void setOption(Option<T> option, T value) {
		basicGetOptions().put(option, value);
	}
	
	public <T> void putOptions(Map<? extends Option<T>, ? extends T> options) {
		Map<Option<?>, Object> myOptions = basicGetOptions();
		
		myOptions.clear();
		myOptions.putAll(options);
	}
	
	public <T> T removeOption(Option<T> option) {
		T result = getValue(option);
		
		basicGetOptions().remove(option);
		
		return result;
	}
	
	public <T> Map<Option<T>, T> removeOptions(Collection<Option<T>> options) {
		Map<Option<T>, T> result = new java.util.HashMap<Option<T>, T>();
		
		Map<Option<?>, Object> myOptions = basicGetOptions();
		
		for (Option<T> next : options) {
			result.put(next, getValue(next));
			myOptions.remove(next);
		}
		
		return result;
	}
	
	public Map<Option<?>, Object> clearOptions() {
		Map<Option<?>, Object> myOptions = basicGetOptions();
		
		Map<Option<?>, Object> result = new java.util.HashMap<Option<?>, Object>(
				myOptions);
		
		myOptions.clear();
		
		return result;
	}
	
	public boolean isEnabled(Option<Boolean> option) {
		Boolean result = getValue(option);
		return (result == null)? false : result.booleanValue();
	}
	
	public <T> T getValue(Option<T> option) {
		@SuppressWarnings("unchecked")
		T result = (T) getOptions().get(option);
		
		if (result == null) {
		    result = (getParent() != null)? getParent().getValue(option)
		        : option.getDefaultValue();
		}
		
		return result;
	}
}