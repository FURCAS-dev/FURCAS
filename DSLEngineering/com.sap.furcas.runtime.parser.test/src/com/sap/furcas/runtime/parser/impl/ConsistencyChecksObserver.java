/**
 * 
 */
package com.sap.furcas.runtime.parser.impl;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;

import com.sap.furcas.runtime.parser.IParsingObserver;

/**
 * checks we leave only contexts we entered before. Test Util.
 */
public class ConsistencyChecksObserver implements IParsingObserver {

    public Stack<List<String>> ruleContextStack = new Stack<List<String>>();
    public Stack<Integer> sequenceContextStack = new Stack<Integer>();
    public List<RecognitionException> errorsInRule = new ArrayList<RecognitionException>();
    public List<Object> elementsResolved = new ArrayList<Object>();
    public List<Token> tokensConsumed = new ArrayList<Token>();
    public List<Token> errorTokensConsumed = new ArrayList<Token>();
    public List<Object> outOfContextResolved = new ArrayList<Object>();
    public int nextSequenceElementEvents;
    public int sequenceElementsEnteredNotLeft;
    public int unresolvedElements;
    public int separatorSequenceEnteredNotLeft;
    public int operatoredSequenceEnteredNotLeft;
    public int operatorSequenceEnteredNotleft;
    public List<Object> elementsAddedToContext = new ArrayList<Object>();
    public List<DelayedReference> referencesCreated = new ArrayList<DelayedReference>();
    public int injectorActionsEnteredNotleft;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sap.mi.textual.grammar.impl.IParsingObserver#notifyEnterRule(java
     * .util.List)
     */
    @Override
    public void notifyEnterRule(List<String> createdElement, String mode) {
        assertNotNull(createdElement);
        ruleContextStack.push(createdElement);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sap.mi.textual.grammar.impl.IParsingObserver#notifyErrorInRule(org
     * .antlr.runtime.RecognitionException)
     */
    @Override
    public void notifyErrorInRule(RecognitionException re) {
        assertNotNull(re);
        errorsInRule.add(re);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.impl.IParsingObserver#
     * notifyEnterSequenceAlternative(int)
     */
    @Override
    public void notifyEnterSequenceAlternative(int choice) {
        sequenceContextStack.push(choice);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.impl.IParsingObserver#notifyExitRule()
     */
    @Override
    public void notifyExitRule(List<String> type) {
        List<String> top = ruleContextStack.pop();
        assertNotNull(type);
        assertNotNull(top);
        assertEquals(type, top);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.impl.IParsingObserver#
     * notifyExitSequenceAlternative()
     */
    @Override
    public void notifyExitSequenceAlternative() {
        sequenceContextStack.pop();

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sap.mi.textual.grammar.impl.IParsingObserver#notifyModelElementResolved
     * (java.lang.Object)
     */
    @Override
    public void notifyCommittedModelElementCreation(Object newModelElement) {
        elementsResolved.add(newModelElement);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sap.mi.textual.grammar.impl.IParsingObserver#notifyTokenConsume(org
     * .antlr.runtime.Token)
     */
    @Override
    public void notifyTokenConsume(Token token) {
        if (!tokensConsumed.contains(token)) {
            tokensConsumed.add(token);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sap.mi.textual.grammar.impl.IParsingObserver#notifyTokenConsumeWithError
     * (org.antlr.runtime.Token)
     */
    @Override
    public void notifyTokenConsumeWithError(Token token) {
        if (tokensConsumed.contains(token)) {
            tokensConsumed.remove(token);
        }
        errorTokensConsumed.add(token);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.impl.IParsingObserver#
     * notifyModelElementResolvedOutOfContext(java.lang.Object,
     * java.lang.Object, org.antlr.runtime.Token)
     */
    @Override
    public void notifyModelElementResolvedOutOfContext(Object modelElement,
            Object contextModelElement, Token referenceLocation,
            DelayedReference reference) {
        outOfContextResolved.add(modelElement);

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sap.mi.textual.grammar.impl.IParsingObserver#notifyEnterSequenceElement
     * ()
     */
    @Override
    public void notifyEnterSequenceElement() {
        sequenceElementsEnteredNotLeft++;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sap.mi.textual.grammar.impl.IParsingObserver#notifyEnterSequenceElement
     * (String)
     */
    @Override
    public void notifyEnterSequenceElement(String mri) {
        sequenceElementsEnteredNotLeft++;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sap.mi.textual.grammar.impl.IParsingObserver#notifyExitSequenceElement
     * ()
     */
    @Override
    public void notifyExitSequenceElement() {
        sequenceElementsEnteredNotLeft--;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.impl.IParsingObserver#
     * notifyModelElementResolutionFailed()
     */
    @Override
    public void notifyCommitModelElementFailed() {
        unresolvedElements++;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sap.mi.textual.grammar.impl.IParsingObserver#notifyEnterSeparatorSequence
     * ()
     */
    @Override
    public void notifyEnterSeparatorSequence() {
        separatorSequenceEnteredNotLeft++;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sap.mi.textual.grammar.impl.IParsingObserver#notifyExitSeparatorSequence
     * ()
     */
    @Override
    public void notifyExitSeparatorSequence() {
        separatorSequenceEnteredNotLeft--;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.impl.IParsingObserver#
     * notifyEnterOperatoredBrackettedSequence()
     */
    @Override
    public void notifyEnterOperatoredBrackettedSequence() {
        operatoredSequenceEnteredNotLeft++;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.impl.IParsingObserver#
     * notifyExitOperatoredBrackettedSequence()
     */
    @Override
    public void notifyExitOperatoredBrackettedSequence() {
        operatoredSequenceEnteredNotLeft--;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sap.mi.textual.grammar.impl.IParsingObserver#notifyEnterOperatorSequence
     * (java.lang.String, int, boolean)
     */
    @Override
    public void notifyEnterOperatorSequence(String operator, int arity,
            boolean isUnaryPostfix) {
        operatorSequenceEnteredNotleft++;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sap.mi.textual.grammar.impl.IParsingObserver#notifyExitOperatorSequence
     * ()
     */
    @Override
    public void notifyExitOperatorSequence() {
        operatorSequenceEnteredNotleft--;
    }

    @Override
    public void notifyElementAddedToContext(Object element) {
        elementsAddedToContext.add(element);
    }

    @Override
    public void notifyDelayedReferenceCreated(DelayedReference ref) {
        referencesCreated.add(ref);
    }

    @Override
    public void notifyEnterInjectorAction() {
        injectorActionsEnteredNotleft++;

    }

    @Override
    public void notifyExitInjectorAction() {
        injectorActionsEnteredNotleft--;
    }

    @Override
    public void reset() {
        ruleContextStack = new Stack<List<String>>();
        sequenceContextStack = new Stack<Integer>();
        errorsInRule = new ArrayList<RecognitionException>();
        elementsResolved = new ArrayList<Object>();
        tokensConsumed = new ArrayList<Token>();
        errorTokensConsumed = new ArrayList<Token>();
        outOfContextResolved = new ArrayList<Object>();
        nextSequenceElementEvents = 0;
        sequenceElementsEnteredNotLeft = 0;
        unresolvedElements = 0;
        separatorSequenceEnteredNotLeft = 0;
        operatoredSequenceEnteredNotLeft = 0;
        operatorSequenceEnteredNotleft = 0;
        elementsAddedToContext = new ArrayList<Object>();
        referencesCreated = new ArrayList<DelayedReference>();
        injectorActionsEnteredNotleft = 0;
    }

}
