/**
 * Copyright (c) 2007 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     INRIA - initial API and implementation
 *
 * $Id: TCSExtractorPrintStream.java,v 1.2 2008/06/25 12:48:35 fjouault Exp $
 */
package com.sap.ide.cts.editor.prettyprint.imported;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.TCS.SequenceElement;
import com.sap.furcas.metamodel.TCS.Template;

/**
 * 
 * @author Fr�d�ric Jouault
 * 
 *         modified by Philipp Meier in 2009
 * 
 */
public class TCSExtractorPrintStream implements TCSExtractorStream {

	private PrintStream out;
	private StringBuffer current;
	private Map<Integer, StringBuffer> backup = new HashMap<Integer, StringBuffer>();
	private int curBackupHandle = 0;

	public TCSExtractorPrintStream(OutputStream target) {
		out = new PrintStream(target);
		current = new StringBuffer();

	}

	public void close() {
		// no more backtracking after this point
		// print all to output stream
		out.print(current.toString());
		out.close();
	}

	public void debug(String string) {
		current.append(string);
	}

	public void printBoolean(boolean v) {
		current.append(v);
	}

	public void printComment(String c) {
		current.append(c);
	}

	public void printEscapedIdentifier(String identEscStart, String ident,
			String identEscEnd) {
		current.append(identEscStart);
		current.append(ident);
		current.append(identEscEnd);
	}

	public void printIdentifier(String ident) {
		current.append(ident);
	}

	public void printInteger(int v) {
		current.append(v);
	}

	public void printKeyword(String keyword) {
		current.append(keyword);
	}

	public void printReal(String string) {
		current.append(string);
	}

	public void printString(String stringDelim, String v) {
		current.append(stringDelim);
		current.append(v);
		current.append(stringDelim);
	}

	public void printSymbol(String symbol) {
		current.append(symbol);
	}

	public void printWhiteSpace(String ws) {
		current.append(ws);
	}

	@Override
	public void endClassTemplate(int handle) {
		// do nothing

	}

	@Override
	public int startClassTemplateForObject(EObject object, Template t) {
		// do nothing
		return 0;

	}

	@Override
	public int createSafePoint() {
		StringBuffer store = new StringBuffer(current.toString());
		curBackupHandle++;
		backup.put(curBackupHandle, store);
		return curBackupHandle;
	}

	@Override
	public void resetToSafePoint(int handle) {
		current = backup.get(new Integer(handle));
	}

	@Override
	public void enterSequenceElement(SequenceElement e) {
		// do nothing

	}

	@Override
	public void exitSequenceElement() {
		// do nothing

	}

	@Override
	public void printDefault(String value)
	{
		current.append(value);
	}

}
