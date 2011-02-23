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

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.query2.exception.LocalizedBaseException;
import org.eclipse.emf.query2.exception.LocalizedBaseRuntimeException;
import org.eclipse.emf.query2.exception.LocalizedString;
import org.eclipse.emf.query2.internal.report.ProcessErrorImpl;
import org.eclipse.emf.query2.internal.report.ProcessWarningImpl;
import org.eclipse.emf.query2.report.LocalizedProcessException;
import org.eclipse.emf.query2.report.ProcessError;
import org.eclipse.emf.query2.report.ProcessMessage;
import org.eclipse.emf.query2.report.ProcessReport;
import org.eclipse.emf.query2.report.ProcessWarning;


/**
 *
 */
abstract public class AbstractAstBuilder {

	protected static final String DEFAULTPROPERTY = "default"; //$NON-NLS-1$

	/* These two hashmaps communicate the synthesized and inherited attributes. */
	/*
	 * This is more efficient than explicitly using the
	 * ResultAndArgumentVisitor.
	 */
	private Map<CstNode, Map<String, Object>> down;

	private Map<CstNode, Map<String, Object>> up;

	private Map<EObject, Map<Object, CstNode>> reverseErrorLookupMap;

	protected ProcessReport report;

	/**
	 * Constructor
	 */
	public AbstractAstBuilder() {

		this.down = new IdentityHashMap<CstNode, Map<String, Object>>();
		this.up = new IdentityHashMap<CstNode, Map<String, Object>>();
		this.reverseErrorLookupMap = new HashMap<EObject, Map<Object, CstNode>>();
	}

	/**
	 * @param methodName
	 */
	public void unimplementedVisitor(String methodName) {

		AstException ex = new AstException(LPGMessages.LPG_AST_NO_VISITOR, methodName);
		ProcessError error = new ProcessErrorImpl(ex);
		this.report.reportFatalError(error);
		throw ex;
	}

	/*
	 * Internal table handling
	 */
	protected void setDownProperty(CstNode n, String propertyName, Object value, boolean defaultAllowed) {

		Map<String, Object> nodeProperties = this.down.get(n);

		// don't use the default property
		if (!defaultAllowed && propertyName.equals(DEFAULTPROPERTY)) {
			this.reportInternalError(n, LPGMessages.LPG_DEFAULT_NOT_EXPLICIT, n.toString());
		}

		// check if the node does not yet have a properties map
		if (nodeProperties == null) {
			nodeProperties = new HashMap<String, Object>();
			this.down.put(n, nodeProperties);
		}

		// set the property
		nodeProperties.put(propertyName, value);
	}

	/**
	 * This kind of property allows the attachment of an arbitrary value
	 */
	protected void setDownProperty(CstNode n, String propertyName, Object value) {

		this.setDownProperty(n, propertyName, value, false);
	}

	/**
	 * This kind of property is used for existence usage
	 */
	protected void makeDownProperty(CstNode n, String propertyName) {

		this.setDownProperty(n, propertyName, Boolean.TRUE, false);
	}

	/**
	 * Used as the default property mechanism
	 */
	protected void setDownProperty(CstNode n, Object value) {

		this.setDownProperty(n, DEFAULTPROPERTY, value, true);
	}

	protected Object getDownProperty(CstNode n, String propertyName, boolean defaultAllowed) {

		Object result = null;

		// don't use the default property
		if (!defaultAllowed && propertyName.equals(DEFAULTPROPERTY)) {
			this.reportInternalError(n, LPGMessages.LPG_GET_DEFAULT_NOT_ALLOWED, n.toString());
		}

		Map<String, Object> nodeProperties = this.down.get(n);
		if (nodeProperties == null || !nodeProperties.containsKey(propertyName)) {
			this.reportInternalError(n, LPGMessages.LPG_NONEXISTING_DOWN_PROPERTY, propertyName, n.toString());
		} else {
			result = nodeProperties.get(propertyName);
		}

		return result;
	}

	/**
	 * Retrieves the attached value to a property of a node
	 */
	protected Object getDownProperty(CstNode n, String propertyName) {

		return this.getDownProperty(n, propertyName, false);
	}

	/**
	 * Gets the default property
	 */
	protected Object getDownProperty(CstNode n) {

		return this.getDownProperty(n, DEFAULTPROPERTY, true);
	}

	/**
	 * Simply verifies if the property exists at all
	 */
	protected boolean hasDownProperty(CstNode n, String propertyName) {

		boolean result = false;

		Map<String, Object> nodeProperties = this.down.get(n);
		if (nodeProperties != null) {
			result = nodeProperties.get(propertyName) != null;
		}

		return result;
	}

	protected void setUpProperty(CstNode n, String propertyName, Object value, boolean defaultAllowed) {

		Map<String, Object> nodeProperties = this.up.get(n);

		// don't use the default property
		if (!defaultAllowed && propertyName.equals(DEFAULTPROPERTY)) {
			this.reportInternalError(n, LPGMessages.LPG_DEFAULT_NOT_EXPLICIT, n.toString());
		}

		// check if the node does not yet have a properties map
		if (nodeProperties == null) {
			nodeProperties = new HashMap<String, Object>();
			this.up.put(n, nodeProperties);
		}

		// set the property
		nodeProperties.put(propertyName, value);
	}

	/**
	 * This kind of property allows the attachment of an arbitrary value
	 */
	protected void setUpProperty(CstNode n, String propertyName, Object value) {

		this.setUpProperty(n, propertyName, value, false);
	}

	/**
	 * This kind of property is used for existence usage
	 */
	protected void makeUpProperty(CstNode n, String propertyName) {

		this.setUpProperty(n, propertyName, Boolean.TRUE, false);
	}

	/**
	 * Used as the default property mechanism
	 */
	protected void setUpProperty(CstNode n, Object value) {

		this.setUpProperty(n, DEFAULTPROPERTY, value, true);
	}

	protected Object getUpProperty(CstNode n, String propertyName, boolean defaultAllowed) {

		Object result = null;

		// don't use the default property
		if (!defaultAllowed && propertyName.equals(DEFAULTPROPERTY)) {
			this.reportInternalError(n, LPGMessages.LPG_GET_DEFAULT_NOT_ALLOWED, n.toString());
		}

		Map<String, Object> nodeProperties = this.up.get(n);
		if (nodeProperties == null || !nodeProperties.containsKey(propertyName)) {
			this.reportInternalError(n, LPGMessages.LPG_NONEXISTING_UP_PROPERTY, propertyName, n.toString());
		} else {
			result = nodeProperties.get(propertyName);
		}

		return result;
	}

	/**
	 * Retrieves the attached value to a property of a node
	 */
	protected Object getUpProperty(CstNode n, String propertyName) {

		return this.getUpProperty(n, propertyName, false);
	}

	/**
	 * Gets the default property
	 */
	protected Object getUpProperty(CstNode n) {

		return this.getUpProperty(n, DEFAULTPROPERTY, true);
	}

	/**
	 * Simply verifies if the property exists at all
	 */
	protected boolean hasUpProperty(CstNode n, String propertyName) {

		boolean result = false;

		Map<String, Object> nodeProperties = this.up.get(n);
		if (nodeProperties != null) {
			result = nodeProperties.get(propertyName) != null;
		}

		return result;
	}

	protected void addReverseLookup(EObject obj, Object detail, CstNode n) {

		Map<Object, CstNode> map = this.reverseErrorLookupMap.get(obj);

		if (map == null) {
			map = new HashMap<Object, CstNode>();
			this.reverseErrorLookupMap.put(obj, map);
		}

		map.put(detail, n);
	}

	protected CstNode lookupReverseNode(EObject obj, Object detail) {

		Map<Object, CstNode> tmpMap = this.reverseErrorLookupMap.get(obj);

		if (tmpMap == null) {
			return null;
		}

		CstNode ret = tmpMap.get(detail);

		if (ret == null) {
			ret = tmpMap.get(null);
		}

		return ret;
	}

	protected boolean hasReverseNode(EObject obj, Object detail) {

		Map<Object, CstNode> map = this.reverseErrorLookupMap.get(obj);

		if (map == null) {
			return false;
		}

		return map.containsKey(detail);
	}

	protected void reportInternalError(LocalizedBaseException errExn, CstNode n) {

		this.reportFatalError(errExn, n);
		throw new AstException(errExn);
	}

	/**
	 * This method reports an internal error. Internal errors are bugs in the
	 * parser.
	 */
	protected void reportInternalError(CstNode n, LocalizedString message, Object... args) {

		LocalizedBaseRuntimeException exn = new LocalizedBaseRuntimeException(message, args);
		this.reportMessage(exn, n, MessageType.FATAL);
		throw exn;
	}

	protected enum MessageType {
		ERROR, FATAL, WARNING
	}

	protected ProcessMessage reportMessage(LocalizedBaseRuntimeException e, CstNode n, MessageType mt) {

		int beginPos = n.getStartOffset();
		int beginLine = n.getLine();
		int beginColumn = n.getColumn();
		int endPos = n.getEndOffset();
		int endLine = n.getEndLine();
		int endColumn = n.getEndColumn();

		// TODO react on localized exceptions here

		switch (mt) {
		case ERROR:
			ProcessError error = new ProcessErrorImpl(e, beginLine, beginColumn, endLine, endColumn, beginPos, endPos);
			this.report.reportError(error);
			return error;
		case FATAL:
			ProcessError fatalError = new ProcessErrorImpl(e, beginLine, beginColumn, endLine, endColumn, beginPos, endPos);
			this.report.reportFatalError(fatalError);
			return fatalError;
		case WARNING:
			ProcessWarning warning = new ProcessWarningImpl(e, beginLine, beginColumn, endLine, endColumn, beginPos, endPos);
			this.report.reportWarning(warning);
			return warning;
		default:
			return null;
		}
	}

	protected ProcessMessage reportMessage(LocalizedBaseException e, CstNode n, MessageType mt) {

		int beginPos = n.getStartOffset();
		int beginLine = n.getLine();
		int beginColumn = n.getColumn();
		int endPos = n.getEndOffset();
		int endLine = n.getEndLine();
		int endColumn = n.getEndColumn();

		// TODO react on localized exceptions here

		switch (mt) {
		case ERROR:
			ProcessError error = new ProcessErrorImpl(e, beginLine, beginColumn, endLine, endColumn, beginPos, endPos);
			this.report.reportError(error);
			return error;

		case FATAL:
			ProcessError fatalError = new ProcessErrorImpl(e, beginLine, beginColumn, endLine, endColumn, beginPos, endPos);
			this.report.reportFatalError(fatalError);
			return fatalError;
		case WARNING:
			ProcessWarning warning = new ProcessWarningImpl(e, beginLine, beginColumn, endLine, endColumn, beginPos, endPos);
			this.report.reportWarning(warning);
			return warning;
		default:
			return null;
		}
	}

	protected ProcessMessage reportError(LocalizedBaseException e, CstNode n) {

		return this.reportMessage(e, n, MessageType.ERROR);
	}

	protected ProcessMessage reportWarning(LocalizedBaseException e, CstNode n) {

		return this.reportMessage(e, n, MessageType.WARNING);
	}

	protected ProcessMessage reportFatalError(LocalizedBaseException e, CstNode n) {

		return this.reportMessage(e, n, MessageType.FATAL);
	}

	protected ProcessMessage reportFatalError(LocalizedBaseRuntimeException e, CstNode n) {

		return this.reportMessage(e, n, MessageType.FATAL);
	}

	/*
	 * Shared parser functionality
	 */

	private String removeEscapes(String token) {

		StringBuilder result = new StringBuilder(token);
		int lastPos = token.length() - 1;

		// remove beginning and last element of the buffer
		result.deleteCharAt(lastPos);
		result.deleteCharAt(0);

		// remove escapes on the inside
		lastPos = lastPos - 2;
		for (int i = 0; i < lastPos; i++) {
			if (result.charAt(i) == '\\') {
				// we delete the escape
				result.deleteCharAt(i);
				// reset the lastpos
				lastPos--;

				// fetch the next character
				char nextChar = result.charAt(i);

				// we expect an escaped character
				switch (nextChar) {
				case '\\':
					result.setCharAt(i, '\\');
					break;
				case '\'':
					result.setCharAt(i, '\'');
					break;
				case '"':
					result.setCharAt(i, '"');
					break;
				case '`':
					result.setCharAt(i, '`');
					break;
				case 'b':
					result.setCharAt(i, '\b');
					break;
				case 'n':
					result.setCharAt(i, '\n');
					break;
				case 'r':
					result.setCharAt(i, '\r');
					break;
				case 't':
					result.setCharAt(i, '\t');
					break;
				case 'f':
					result.setCharAt(i, '\f');
					break;
				case 'u':
					// Unicode, catch 4 hex numbers
					result.deleteCharAt(i);
					char uc1 = result.charAt(i);
					result.deleteCharAt(i);
					char uc2 = result.charAt(i);
					result.deleteCharAt(i);
					char uc3 = result.charAt(i);
					result.deleteCharAt(i);
					char uc4 = result.charAt(i);
					// set true value
					char unicode = (char) Integer.parseInt(new String(new char[] { uc1, uc2, uc3, uc4 }), 16);
					result.setCharAt(i, unicode);
					lastPos = lastPos - 4;

					break;
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
					// Latin-1 encoding, catch 2 remaining octal numbers
					result.deleteCharAt(i);
					char lat1 = result.charAt(i);
					result.deleteCharAt(i);
					char lat2 = result.charAt(i);
					// set true value
					int latin = Integer.parseInt(new String(new char[] { nextChar, lat1, lat2 }), 8);
					result.setCharAt(i, (char) latin);
					lastPos = lastPos - 2;

					break;
				default:
					throw new LocalizedProcessException(LPGMessages.LPG_BUG_UNKNOWN_ESCAPE);
				}
			}
		}

		return result.toString();
	}

	/**
	 * Removes escapes inside an identifier
	 */
	protected String processIdentifier(String identifier) {

		// we need the first char for the first decision
		char firstChar = identifier.charAt(0);

		// keyword escape
		if (firstChar == '%') {
			return identifier.substring(1);
		}

		// see if we have a more general escape
		if (firstChar == '"') {
			return this.removeEscapes(identifier);
		}

		// otherwise, regular case
		return identifier;
	}

	/**
	 * Removes escapes inside a string
	 */
	protected String processString(String string) {

		return this.removeEscapes(string);
	}

}
