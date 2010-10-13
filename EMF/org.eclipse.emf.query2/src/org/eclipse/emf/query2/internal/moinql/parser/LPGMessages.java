/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query2.internal.moinql.parser;

import java.util.Locale;

import org.eclipse.emf.query2.exception.LocalizedString;
import org.eclipse.emf.query2.internal.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>
 * Localized Messages in alphabetical order:
 * <ol>
 * <li>LPG_AST_BUILDER_JMIEXCEPTION_XMSG: A JMI Exception was reported by the
 * AST Builder, error message: {0}</li>
 * <li>LPG_AST_BUILDER_ERROR_XMSG: An internal error was reported by the AST
 * Builder, error message: {0}</li>
 * <li>LPG_BAD_SYMFILE_XMSG: Bad Parser Symbol File "{0}". Regenerate "{1}".</li>
 * <li>LPG_BUG_UNKNOWN_ESCAPE_XMSG: Bug in OCL parser: Unknown Escape in
 * identifier definition</li>
 * <li>LPG_INVALID_ERRORCODE_XMSG: LPG Bug: invalid error code {0}, token {1}</li>
 * <li>LPG_LEXBUG_WRONG_REPORTERR_XMSG: Lexer bug: wrong reportError call</li>
 * <li>LPG_AST_NO_VISITOR_XMSG: No visistor implemented for method {0}</li>
 * <li>LPG_PARSERBUG_WRONG_REPORTERR_XMSG: Parser bug: wrong reportError call</li>
 * <li>LPG_ERROR_CODE_XMSG: Parsing terminated at token {0}</li>
 * <li>LPG_REGENERATE_NOBACKTRACK_XMSG: Regenerate {0} with -NOBACKTRACK option</li>
 * <li>LPG_LEXSTREAM_NOT_INITIALIZED_XMSG: The LexStream was not initialized</li>
 * <li>LPG_LEX_DOESNTIMPLEMENT_EOF_XMSG: The Lexer does not implement the Eof
 * symbol {0}</li>
 * <li>LPG_WILL_NOT_SCAN_XMSG: The Lexer will not scan the following token(s):
 * {0}</li>
 * <li>LPG_NONEXISTING_DOWN_PROPERTY_XMSG: Trying to access non-existing down
 * property "{0}" for node "{1}"</li>
 * <li>LPG_NONEXISTING_UP_PROPERTY_XMSG: Trying to access non-existing up
 * property "{0}" for node "{1}"</li>
 * <li>LPG_GET_DEFAULT_NOT_ALLOWED_XMSG: Trying to get the default property for
 * node "{0}" where this is not allowed</li>
 * <li>LPG_DEFAULT_NOT_EXPLICIT_XMSG: Trying to set the default property for
 * node "{0}" explicitly, this is forbidden</li>
 * <li>LPG_EOF_CODE_XMSG: Unexpected end-of-file reached</li>
 * <li>LPG_DELETION_CODE_XMSG: Unexpected token(s) {0} ignored</li>
 * <li>LPG_MISPLACED_CODE_XMSG: {0} : misplaced construct(s)</li>
 * <li>LPG_INSERTION_CODE_XMSG: {0} expected after this token</li>
 * <li>LPG_SUBSTITUTION_SECONDARY_CODE_XMSG: {0} expected instead of this input</li>
 * <li>LPG_MERGE_CODE_XMSG: {0} formed from merged tokens</li>
 * <li>LPG_BEFORE_CODE_XMSG: {0} inserted before this token</li>
 * <li>LPG_SCOPE_CODE_XMSG: {0} inserted to complete scope</li>
 * <li>LPG_INVALID_TOKEN_CODE_XMSG: {0}: found invalid token</li>
 * <li>LPG_LEX_ERROR_CODE_XMSG: {0}: unexpected character ignored</li>
 * <li>LPG_INVALID_CODE_XMSG: {0}: unexpected input discarded</li>
 * </ol>
 * <p>
 * <p>
 * Message Constants generated from LPGMessages.properties
 */

public enum LPGMessages implements LocalizedString {

	/**
	 * Message:
	 * "An internal error was reported by the AST Builder, error message: {0}"
	 */
	LPG_AST_BUILDER_ERROR("LPG_AST_BUILDER_ERROR_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "A JMI Exception was reported by the AST Builder, error message: {0}"
	 */
	LPG_AST_BUILDER_JMIEXCEPTION("LPG_AST_BUILDER_JMIEXCEPTION_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "No visistor implemented for method {0}"
	 */
	LPG_AST_NO_VISITOR("LPG_AST_NO_VISITOR_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Bad Parser Symbol File "{0}". Regenerate "{1}"."
	 */
	LPG_BAD_SYMFILE("LPG_BAD_SYMFILE_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "{0} inserted before this token"
	 */
	LPG_BEFORE_CODE("LPG_BEFORE_CODE_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Bug in OCL parser: Unknown Escape in identifier definition"
	 */
	LPG_BUG_UNKNOWN_ESCAPE("LPG_BUG_UNKNOWN_ESCAPE_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Trying to set the default property for node "{0}
	 * " explicitly, this is forbidden"
	 */
	LPG_DEFAULT_NOT_EXPLICIT("LPG_DEFAULT_NOT_EXPLICIT_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Unexpected token(s) {0} ignored"
	 */
	LPG_DELETION_CODE("LPG_DELETION_CODE_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Unexpected end-of-file reached"
	 */
	LPG_EOF_CODE("LPG_EOF_CODE_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Parsing terminated at token {0}"
	 */
	LPG_ERROR_CODE("LPG_ERROR_CODE_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Trying to get the default property for node "{0}
	 * " where this is not allowed"
	 */
	LPG_GET_DEFAULT_NOT_ALLOWED("LPG_GET_DEFAULT_NOT_ALLOWED_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "{0} expected after this token"
	 */
	LPG_INSERTION_CODE("LPG_INSERTION_CODE_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "{0}: unexpected input discarded"
	 */
	LPG_INVALID_CODE("LPG_INVALID_CODE_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "LPG Bug: invalid error code {0}, token {1}"
	 */
	LPG_INVALID_ERRORCODE("LPG_INVALID_ERRORCODE_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "{0}: found invalid token"
	 */
	LPG_INVALID_TOKEN_CODE("LPG_INVALID_TOKEN_CODE_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Lexer bug: wrong reportError call"
	 */
	LPG_LEXBUG_WRONG_REPORTERR("LPG_LEXBUG_WRONG_REPORTERR_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "The LexStream was not initialized"
	 */
	LPG_LEXSTREAM_NOT_INITIALIZED("LPG_LEXSTREAM_NOT_INITIALIZED_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "The Lexer does not implement the Eof symbol {0}"
	 */
	LPG_LEX_DOESNTIMPLEMENT_EOF("LPG_LEX_DOESNTIMPLEMENT_EOF_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "{0}: unexpected character ignored"
	 */
	LPG_LEX_ERROR_CODE("LPG_LEX_ERROR_CODE_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "{0} formed from merged tokens"
	 */
	LPG_MERGE_CODE("LPG_MERGE_CODE_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "{0} : misplaced construct(s)"
	 */
	LPG_MISPLACED_CODE("LPG_MISPLACED_CODE_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "Trying to access non-existing down property "{0}" for node "{1}""
	 */
	LPG_NONEXISTING_DOWN_PROPERTY("LPG_NONEXISTING_DOWN_PROPERTY_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Trying to access non-existing up property "{0}" for node "{1}""
	 */
	LPG_NONEXISTING_UP_PROPERTY("LPG_NONEXISTING_UP_PROPERTY_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Parser bug: wrong reportError call"
	 */
	LPG_PARSERBUG_WRONG_REPORTERR("LPG_PARSERBUG_WRONG_REPORTERR_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Regenerate {0} with -NOBACKTRACK option"
	 */
	LPG_REGENERATE_NOBACKTRACK("LPG_REGENERATE_NOBACKTRACK_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "{0} inserted to complete scope"
	 */
	LPG_SCOPE_CODE("LPG_SCOPE_CODE_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "{0} expected instead of this input"
	 */
	LPG_SUBSTITUTION_SECONDARY_CODE("LPG_SUBSTITUTION_SECONDARY_CODE_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "The Lexer will not scan the following token(s): {0}"
	 */
	LPG_TOKEN_IGNORED("LPG_TOKEN_IGNORED_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "The Lexer will not scan the following token(s): {0}"
	 */
	LPG_WILL_NOT_SCAN("LPG_WILL_NOT_SCAN_XMSG"); //$NON-NLS-1$

	private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor(LPGMessages.class);

	private final String myKey;

	private LPGMessages(String bundleKey) {

		this.myKey = bundleKey;
	}

	public String format(Object... args) {

		return ACCESSOR.format(this.myKey, args);
	}

	public String getLocalizedMessage(Locale locale) {

		try {
			return ACCESSOR.getMessageText(locale, this.myKey);
		} catch (RuntimeException e) {
			return "Localization failed for ResourceBundle " + LPGMessages.class.getName() + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
		}
	}

}