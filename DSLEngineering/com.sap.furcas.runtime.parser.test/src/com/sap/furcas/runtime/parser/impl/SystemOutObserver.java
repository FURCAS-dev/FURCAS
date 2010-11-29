/**
 * 
 */
package com.sap.furcas.runtime.parser.impl;

import java.util.List;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;

import com.sap.furcas.runtime.parser.IParsingObserver;

/**
 *
 */
public class SystemOutObserver extends ConsistencyChecksObserver implements IParsingObserver {

    @Override
    public void notifyEnterSequenceElement() {
        super.notifyEnterSequenceElement();
        outWithPrefix("notifyBeforeSequenceElement");
        depth++;
    }

    @Override
    public void notifyExitSequenceElement() {
        super.notifyExitSequenceElement();
        depth--;
        outWithPrefix("notifyAfterSequenceElement");
    }

    private int depth = 0;
    
    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.IParsingObserver#notifyEnterRule(java.util.List)
     */
    @Override
    public void notifyEnterRule(List<String> createdElement, String mode) {
        super.notifyEnterRule(createdElement, mode);
        outWithPrefix("notifyEnterRule " + createdElement);
        depth++;
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.IParsingObserver#notifyEnterSequenceAlternative(int)
     */
    @Override
    public void notifyEnterSequenceAlternative(int choice) {
        super.notifyEnterSequenceAlternative(choice);
        outWithPrefix("notifyEnterSequenceRule " + choice);
        depth++;
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.IParsingObserver#notifyErrorInRule(org.antlr.runtime.RecognitionException)
     */
    @Override
    public void notifyErrorInRule(RecognitionException re) {
        super.notifyErrorInRule(re);
        outWithPrefix("notifyErrorInRule " + re);
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.IParsingObserver#notifyExitRule()
     */
    @Override
    public void notifyExitRule(List<String> type) {
        super.notifyExitRule(type);
        depth--;
        outWithPrefix("notifyExitRule " +type);
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.IParsingObserver#notifyExitSequenceAlternative()
     */
    @Override
    public void notifyExitSequenceAlternative() {
        super.notifyExitSequenceAlternative();
        depth--;
        outWithPrefix("notifyExitSequence ");
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.IParsingObserver#notifyModelElementResolved(java.lang.Object)
     */
    @Override
    public void notifyCommittedModelElementCreation(Object newModelElement) {
        super.notifyCommittedModelElementCreation(newModelElement);
        outWithPrefix("notifyElementResolved " + newModelElement);
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.IParsingObserver#notifyTokenConsume(org.antlr.runtime.Token)
     */
    @Override
    public void notifyTokenConsume(Token token) {
        super.notifyTokenConsume(token);
        outWithPrefix("notifyTokenConsumed " + token);
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.IParsingObserver#notifyTokenConsumeWithError(org.antlr.runtime.Token)
     */
    @Override
    public void notifyTokenConsumeWithError(Token token) {
        super.notifyTokenConsumeWithError(token);
        outWithPrefix("notifyMismatchedTokenConsumed " + token);
    }

    
    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.IParsingObserver#notifyModelElementResolvedOutOfContext(java.lang.Object, java.lang.Object, org.antlr.runtime.Token)
     */
    @Override
    public void notifyModelElementResolvedOutOfContext(Object modelElement,
            Object contextModelElement, Token referenceLocation, DelayedReference reference) {
	super.notifyModelElementResolvedOutOfContext(modelElement, contextModelElement, referenceLocation, reference);
        System.out.println( "Resolved " + modelElement + " in " + contextModelElement + " at " + referenceLocation +
                "; ReferenceType: " + reference);
    }

    
    
    @Override
    public void notifyDelayedReferenceCreated(DelayedReference ref) {
	super.notifyDelayedReferenceCreated(ref);
	System.out.println( "Delayed Reference created:" + ref);
    }

    @Override
    public void notifyEnterInjectorAction() {
	super.notifyEnterInjectorAction();
	outWithPrefix("notifyEnterInjectorAction");
        depth++;
    }

    @Override
    public void notifyExitInjectorAction() {
	super.notifyExitInjectorAction();
	outWithPrefix("notifyEnterInjectorAction");
        depth--;
    }

    private void outWithPrefix(String string) {
        depthPrefix();
        System.out.println( string);
    }
    
    private void depthPrefix() {
        for (int i = 0; i < depth; i++) {
            System.out.print("- ");
        }
    }


    
    
}
