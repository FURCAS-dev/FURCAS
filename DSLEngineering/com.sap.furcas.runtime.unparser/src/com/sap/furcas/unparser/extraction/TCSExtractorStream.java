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

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.Alternative;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.ide.cts.editor.prettyprint.imported.PrettyPrinter;

/**
 * This class serves as the result object of the {@link PrettyPrinter}.
 * 
 * A stream records actions performed by the {@link PrettyPrinter} and can serialize those
 * into a concrete textual representation of the model.
 * 
 * @author Frederic Jouault
 * @author Philipp Meier
 * @author Stephan Erb
 */
public interface TCSExtractorStream {

    void close();

    void debug(String string);

    void printWhiteSpace(String ws);

    void printKeyword(String keyword);

    void printSymbol(String symbol);

    void printIdentifier(String ident);

    void printEscapedIdentifier(String identEscStart, String ident, String identEscEnd);

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

    // to allow tracking of chosen alternatives
    void enterAlternative(Alternative alt);

    void beginAlternativeChoice(int choiceIndexInAlternative);

    void exitAlternative();

}
