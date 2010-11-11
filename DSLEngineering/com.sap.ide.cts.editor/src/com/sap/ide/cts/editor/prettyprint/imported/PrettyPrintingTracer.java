package com.sap.ide.cts.editor.prettyprint.imported;

import tcs.Alternative;
import tcs.SequenceElement;
import tcs.Template;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

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

    public void notifyStartedClassTemplateForObject(int handle, RefObject object, Template template);

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