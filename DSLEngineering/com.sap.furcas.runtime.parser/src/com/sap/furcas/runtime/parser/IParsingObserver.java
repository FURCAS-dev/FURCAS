/**
 * 
 */
package com.sap.furcas.runtime.parser;

import java.util.List;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;

import com.sap.furcas.runtime.parser.impl.DelayedReference;


/**
 * observes ParsingEvents with respect to a given Syntax definition used by a parser.
 * This is a stateful interface, such that call sequence has meaning.
 * EnterRule, EnterRule, Error, ExitRule, ExitRule
 * EnterRule, EnterRule, ExitRule, Error, ExitRule
 * The first sequence means the error happened in the inner Rule, while 
 * the second sequence means the error happened in the outer rule.
 * 
 * Syntax definitions refer to TCS templates.
 * Is not a true Observer as in the Observer Pattern, as it is not called asynchronously.
 */
public interface IParsingObserver {

    /**
     * notifies a template rule has completed parsing in ok or error state
     * 
     * The method is called synchronously, so if it makes long running operations, 
     * the whole Injection process will be delayed.
     * @param createdElementType should match the type on enter (else bug)
     */
    void notifyExitRule(List<String> createdElementType);

    /**
     * notifies a template rule has started parsing in ok or error state. These calls may be called recursively, 
     * but not overlapping. Not: (Enter A, Enter B, Leave A, Leave B).
     * @param createdElement the qualified name of the type of the element about to be parsed
     * The method is called synchronously, so if it makes long running operations, 
     * the whole Injection process will be delayed.
     * @param mode several templates may exist for a type as long as they have different modes. May be null in the default case.
     */
    void notifyEnterRule(List<String> createdElement, String mode);

    /**
     * notifies a template rule has encountered an unexpected token
     * @param re
     * The method is called synchronously, so if it makes long running operations, 
     * the whole Injection process will be delayed.
     */
    void notifyErrorInRule(RecognitionException re);

    /**
     * notifies the given token was parsed without errors in the current template rule
     * @param token 
     * The method is called synchronously, so if it makes long running operations, 
     * the whole Injection process will be delayed.
     * 
     */
    void notifyTokenConsume(Token token);

    /**
     * notifies the given token was parsed with error in the current template rule
     * @param token 
     * The method is called synchronously, so if it makes long running operations, 
     * the whole Injection process will be delayed.
     */
    void notifyTokenConsumeWithError(Token token);

    /**
     * Notifies that in the current template rule we enter a given sequence alternative with decision index x.
     * These calls may be called recursively, 
     * but not overlapping. Not: (Enter A, Enter B, Leave A, Leave B).
     * @param choice
     * The method is called synchronously, so if it makes long running operations, 
     * the whole Injection process will be delayed.
     */
    void notifyEnterSequenceAlternative(int choice);

    /**
     * Notifies that in the current template rule we leave a given sequence alternative 
     * The method is called synchronously, so if it makes long running operations, 
     * the whole Injection process will be delayed.
     */
    void notifyExitSequenceAlternative();

    /**
     * Notifies the Observer that the given Modelelement has been resolved during injection of text
     * (Meaning it has been created or found as existing). 
     * 
     * The method is called synchronously, so if it makes long running operations, 
     * the whole Injection process will be delayed.
     * @param newModelElement
     * @param contextModelElement may be null
     */
    void notifyCommittedModelElementCreation(Object newModelElement);

    /**
     * notifies that out of the <code>element</code> was added to the current context.
     * @param element
     * @param contextElement
     */
    void notifyElementAddedToContext(Object element);

    /**
     * notifies that out of the enter/exit context, a modelElement has been
     * resolved for the given token.
     * 
     * @param modelElement the model element that was resolved
     * @param contextModelElement if given the context element from which the element was resolved.
     * @param referenceLocation the last token at which's position the element was resolved from.
     * @param reference
     *            The {@link DelayedReference} that was just resolved
     */
    void notifyModelElementResolvedOutOfContext(Object modelElement,
            Object contextModelElement, Token referenceLocation,
            DelayedReference reference);

    /**
     * called after a sequenceElement is entered
     */
    void notifyExitSequenceElement();

    /**
     * called before a sequenceElement is entered
     */
    void notifyEnterSequenceElement();
    
	/**
	 * Same as {@link #notifyEnterSequenceElement()} but additionally giving the mofid of the 
	 * entered sequence element.
	 * @param mofid
	 */
	void notifyEnterSequenceElement(String mofid);

    /**
     * notifies the Observer that for the current Template, resolution of the corresponding model element has failed.
     */
    void notifyCommitModelElementFailed();

    /**
     * When within a property Sequence, notifies that the separator sequence is being entered by the parser
     */
    void notifyEnterSeparatorSequence();

    /**
     * notify a separator sequence is being left
     */
    void notifyExitSeparatorSequence();

    /**
     * notifies the parser entered the virtual sequence of "'(' template ')'" which does not exist explicitly in the TCS model, but is still part of the generated language. 
     */
    void notifyEnterOperatoredBrackettedSequence();

    /**
     * notifies virtual bracketed sequence was left by parser.
     */
    void notifyExitOperatoredBrackettedSequence();

    /**
     * notifies the parser created a new delayed reference for resolving in a second iteration.
     * @param ref
     */
    void notifyDelayedReferenceCreated(DelayedReference ref);
    
    /**
     * notifies that the parser entered a new InjectorAction
     * @param injectorAction
     */
    void notifyEnterInjectorAction();
    
    /**
     * notifies that the parser exited InjectorAction
     */
    void notifyExitInjectorAction();
    
    /**
     *
     * notifies parser enters the virtual sequence for a given operator symbol with operator arity.
     * This sequence is entered after the first operand has been parsed for binary operators, so the 
     * next event to be expected would be for the operator token.
     * 
     *
     * @param operator
     * @param arity
     * @param isUnaryPostfix
     */
    void notifyEnterOperatorSequence(String operator, int arity,
            boolean isUnaryPostfix);

    /**
     * 
     */
    void notifyExitOperatorSequence();

    void reset();

}
