/**
 * <copyright>
 *
 * Copyright (c) 2008, 2009 Eclipse.org, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *   Zeligsoft - Bug 259818 (add doc comment)
 *   
 * </copyright>
 *
 * $Id: OCLParserErrors.java,v 1.1 2009/01/13 20:31:30 cdamus Exp $
 */

package org.eclipse.ocl.parser.backtracking;

/**
 * An enumeration of error tokens to fill in gaps in the concrete syntax.
 * 
 * @since 1.3
 */
public class OCLParserErrors {

	public static final String EXTRA_TOKENS = "\"\""; //$NON-NLS-1$

	public static final String MISSING_AT_PRE = "\"@pre\" or \"(\""; //$NON-NLS-1$

	public static final String MISSING_COLON = "\":\""; //$NON-NLS-1$

	public static final String MISSING_CONTEXT = "\"context\""; //$NON-NLS-1$

	public static final String MISSING_ELSE_ENDIF = "\"else <expr> endif\""; //$NON-NLS-1$

	public static final String MISSING_ENDIF = "\"endif\""; //$NON-NLS-1$

	public static final String MISSING_ENDPACKAGE = "\"endpackage\""; //$NON-NLS-1$

	public static final String MISSING_EQUALS = "\"=\""; //$NON-NLS-1$

	public static final String MISSING_EXPR = "\"<expr>\""; //$NON-NLS-1$

	public static final String MISSING_IDENTIFIER = "\"<identifier>\""; //$NON-NLS-1$

	public static final String MISSING_INV_OR_DEF = "\"inv\" or \"def\""; //$NON-NLS-1$

	public static final String MISSING_LBRACE = "\"{\""; //$NON-NLS-1$

	public static final String MISSING_LPAREN = "\"(\""; //$NON-NLS-1$

	public static final String MISSING_MESSAGE_ARGUMENTS = "\"( <comma separated message arguments> )\""; //$NON-NLS-1$

	public static final String MISSING_PARAMETER = "\"<parameter>\""; //$NON-NLS-1$

	public static final String MISSING_PARAMETERS = "\"<variable>\""; //$NON-NLS-1$

	public static final String MISSING_PATH_NAME = "\"<pathName>\""; //$NON-NLS-1$

	public static final String MISSING_RBRACK = "\"]\""; //$NON-NLS-1$

	public static final String MISSING_RPAREN = "\")\""; //$NON-NLS-1$

	public static final String MISSING_SIMPLE_NAME = "\"<simpleName>\""; //$NON-NLS-1$

	public static final String MISSING_SIMPLE_NAME_OPT = "\"<simpleName>\" or \"<empty>\""; //$NON-NLS-1$

	public static final String MISSING_THEN_ELSE = "\"then <expr> else <expr>\""; //$NON-NLS-1$

	public static final String MISSING_THEN_ELSE_ENDIF = "\"then <expr> else <expr> endif\""; //$NON-NLS-1$

	public static final String MISSING_VARIABLE_TYPE = "\": <type>\""; //$NON-NLS-1$

	public static final String MISSING_VARIABLES = "\"<comma separated variables>\""; //$NON-NLS-1$
}
