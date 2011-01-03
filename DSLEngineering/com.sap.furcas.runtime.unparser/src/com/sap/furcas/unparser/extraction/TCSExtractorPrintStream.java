/*******************************************************************************
 * Copyright (c) 2007-2011 INRIA and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     INRIA - initial API and implementation
 *     SAP AG - API and implementation enhancements
 ******************************************************************************/
package com.sap.furcas.unparser.extraction;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.Alternative;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;

/**
 * Basic {@link TCSExtractorStream} that prints everything into a given {@link OutputStream}. 
 * 
 * @author Frederic Jouault
 * @author Philipp Meier
 * @author Stephan Erb
 */
public class TCSExtractorPrintStream implements TCSExtractorStream {

    private final PrintStream out;
    private StringBuffer current = new StringBuffer();
    private final Map<Integer, StringBuffer> backup = new HashMap<Integer, StringBuffer>();
    private int curBackupHandle = 0;

    public TCSExtractorPrintStream(OutputStream target) {
	out = new PrintStream(target);
    }

    @Override
    public void close() {
	// no more backtracking after this point
	// print all to output stream
	out.print(current.toString());
	out.close();
    }

    @Override
    public void debug(String string) {
	current.append(string);
    }

    @Override
    public void printBoolean(boolean v) {
	current.append(v);
    }

    @Override
    public void printComment(String c) {
	current.append(c);
    }

    @Override
    public void printEscapedIdentifier(String identEscStart, String ident, String identEscEnd) {
	current.append(identEscStart);
	current.append(ident);
	current.append(identEscEnd);
    }

    @Override
    public void printIdentifier(String ident) {
	current.append(ident);
    }

    @Override
    public void printInteger(int v) {
	current.append(v);
    }

    @Override
    public void printKeyword(String keyword) {
	current.append(keyword);
    }

    @Override
    public void printReal(String string) {
	current.append(string);
    }

    @Override
    public void printString(String stringDelim, String v) {
	current.append(stringDelim);
	current.append(v);
	current.append(stringDelim);
    }

    @Override
    public void printSymbol(String symbol) {
	current.append(symbol);
    }

    @Override
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
    public void printDefault(String value) {
	current.append(value);
    }

    @Override
    public void enterAlternative(Alternative alt) {
	// do nothing
    }

    @Override
    public void beginAlternativeChoice(int choiceIndexInAlternative) {
	// do nothing
    }

    @Override
    public void exitAlternative() {
	// do nothing
    }

}
