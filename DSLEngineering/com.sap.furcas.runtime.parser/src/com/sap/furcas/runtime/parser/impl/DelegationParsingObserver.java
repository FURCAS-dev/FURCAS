package com.sap.furcas.runtime.parser.impl;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;

import com.sap.furcas.runtime.parser.IParsingObserver;

/**
 * Helper class to allow multiple classes implementing IParsingObserver to
 * listen to one PatchedObservableParser.
 * 
 * Parsing observers can be added and removed. When added, they will receive all
 * calls, as if they were attached to the PatchedObservableParser directly.
 * 
 * Sends all caught exceptions to console.
 * 
 * @author D052602
 * 
 */
public class DelegationParsingObserver implements IParsingObserver {

    private List<IParsingObserver> observers = new ArrayList<IParsingObserver>();

    public void addParsingObserver(IParsingObserver observer) {
        observers.add(observer);
    }

    public void removeParsingObserver(IParsingObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyEnterRule(List<String> createdElement, String mode) {

        for (IParsingObserver observer : observers) {
            observer.notifyEnterRule(createdElement, mode);
        }


    }

    @Override
    public void notifyEnterSequenceAlternative(int choice) {

        for (IParsingObserver observer : observers) {
            observer.notifyEnterSequenceAlternative(choice);
        }

    }

    @Override
    public void notifyEnterSequenceElement() {

        for (IParsingObserver observer : observers) {
            observer.notifyEnterSequenceElement();
        }


    }

    @Override
    public void notifyErrorInRule(RecognitionException re) {

        for (IParsingObserver observer : observers) {
            observer.notifyErrorInRule(re);
        }


    }

    @Override
    public void notifyExitRule(List<String> createdElementType) {

        for (IParsingObserver observer : observers) {
            observer.notifyExitRule(createdElementType);
        }

    }

    @Override
    public void notifyExitSequenceAlternative() {

        for (IParsingObserver observer : observers) {
            observer.notifyExitSequenceAlternative();
        }


    }

    @Override
    public void notifyExitSequenceElement() {

        for (IParsingObserver observer : observers) {
            observer.notifyExitSequenceElement();
        }


    }

    @Override
    public void notifyCommittedModelElementCreation(Object newModelElement) {

        for (IParsingObserver observer : observers) {
            observer.notifyCommittedModelElementCreation(newModelElement);
        }
    }

    @Override
    public void notifyModelElementResolvedOutOfContext(Object modelElement,
            Object contextModelElement, Token referenceLocation, DelayedReference reference) {

        for (IParsingObserver observer : observers) {
            observer.notifyModelElementResolvedOutOfContext(modelElement,
                    contextModelElement, referenceLocation, reference);
        }
    }

    @Override
    public void notifyTokenConsume(Token token) {
        for (IParsingObserver observer : observers) {
            observer.notifyTokenConsume(token);
        }

    }

    @Override
    public void notifyTokenConsumeWithError(Token token) {
        for (IParsingObserver observer : observers) {
            observer.notifyTokenConsumeWithError(token);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.impl.IParsingObserver#notifyModelElementResolutionFailed()
     */
    @Override
    public void notifyCommitModelElementFailed() {
        for (IParsingObserver observer : observers) {
            observer.notifyCommitModelElementFailed();
        }
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.IParsingObserver#notifyEnterSeparatorSequence()
     */
    @Override
    public void notifyEnterSeparatorSequence() {
        for (IParsingObserver observer : observers) {
            observer.notifyEnterSeparatorSequence();
        }
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.IParsingObserver#notifyExitSeparatorSequence()
     */
    @Override
    public void notifyExitSeparatorSequence() {
        for (IParsingObserver observer : observers) {
            observer.notifyExitSeparatorSequence();
        }
    }
    
	@Override
	public void notifyEnterSequenceElement(String mri) {
		for (IParsingObserver observer : observers) {
            observer.notifyEnterSequenceElement(mri);
        }
	}

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.IParsingObserver#notifyEnterOperatoredBrackettedSequence()
     */
    @Override
    public void notifyEnterOperatoredBrackettedSequence() {
        for (IParsingObserver observer : observers) {
            observer.notifyEnterOperatoredBrackettedSequence();
        }
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.IParsingObserver#notifyExitOperatoredBrackettedSequence()
     */
    @Override
    public void notifyExitOperatoredBrackettedSequence() {
        for (IParsingObserver observer : observers) {
            observer.notifyExitOperatoredBrackettedSequence();
        }
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.IParsingObserver#notifyEnterOperatorSequence(java.lang.String, int, boolean)
     */
    @Override
    public void notifyEnterOperatorSequence(String operator, int arity,
            boolean isUnaryPostfix) {
        for (IParsingObserver observer : observers) {
            observer.notifyEnterOperatorSequence(operator, arity, isUnaryPostfix);
        }
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.IParsingObserver#notifyExitOperatorSequence()
     */
    @Override
    public void notifyExitOperatorSequence() {
        for (IParsingObserver observer : observers) {
            observer.notifyExitOperatorSequence();
        }
    }

    @Override
    public void notifyElementAddedToContext(Object element) {
	 for (IParsingObserver observer : observers) {
	     observer.notifyElementAddedToContext(element);
	 }
    }

    @Override
    public void notifyDelayedReferenceCreated(DelayedReference ref) {
	for (IParsingObserver observer : observers) {
	     observer.notifyDelayedReferenceCreated(ref);
	 }
    }

    @Override
    public void notifyEnterInjectorAction() {
	for (IParsingObserver observer : observers) {
	     observer.notifyEnterInjectorAction();
	 }
    }

    @Override
    public void notifyExitInjectorAction() {
	for (IParsingObserver observer : observers) {
	     observer.notifyExitInjectorAction();
	 }
    }

    @Override
    public void reset() {
	for (IParsingObserver observer : observers) {
	     observer.reset();
	 }
    }


}
