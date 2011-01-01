/*******************************************************************************
 * Copyright (c) 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.ide.cts.editor.prettyprint.imported;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.Alternative;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;

/**
 * A simple interface with callback methods which are called by the
 * {@link TCSExtractorStreamPrinter} during serializing and printing.
 * 
 * This class is meant to allow other classes to observe the pretty printing
 * process.
 * 
 * @author Stephan Erb (d049157)
 * 
 */
public interface PrettyPrintingTracer {

    public void notifyStartedClassTemplateForObject(int handle, EObject object, Template template);

    public void notifyEndedClassTemplate(int handle);

    public void notifyEnteredSequenceElement(SequenceElement e);

    public void notifyExitedSequenceElement();

    public void notifyEnteredAlternative(Alternative alt);

    public void notifyBeganAlternativeChoice(int choiceIndexInAlternative);

    public void notifyExitedAlternative();

    public void notifyAboutToPrintToken();

    public void notifyPrintedToken();

    public void notifyAboutToPrintWhiteSpace();

    public void notifyPrintedWhiteSpace(String ws);

    public void notifySafePointCreated(int handle);

    public void notifyResettedToSafePoint(int handle);

}