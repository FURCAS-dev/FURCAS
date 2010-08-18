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
 * $Id: TCSExtractorStream.java,v 1.2 2008/06/25 12:48:34 fjouault Exp $
 */
package com.sap.ide.cts.editor.prettyprint.imported;

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
public interface TCSExtractorStream {

	void close();

	void debug(String string);

	void printWhiteSpace(String ws);

	void printKeyword(String keyword);

	void printSymbol(String symbol);

	void printIdentifier(String ident);

	void printEscapedIdentifier(String identEscStart, String ident,
			String identEscEnd);

	void printBoolean(boolean v);

	void printInteger(int v);

	void printReal(String string);

	void printString(String stringDelim, String v);

	void printComment(String c);

	int startClassTemplateForObject(EObject object, Template template);

	void endClassTemplate(int handle);

	void enterSequenceElement(SequenceElement e);

	void exitSequenceElement();

	// to allow backtracking
	int createSafePoint();

	void resetToSafePoint(int handle);

	void printDefault(String value);

}
