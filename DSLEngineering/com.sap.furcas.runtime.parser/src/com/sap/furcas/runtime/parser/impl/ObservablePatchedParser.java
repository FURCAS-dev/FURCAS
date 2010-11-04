/**
 * 
 */
package com.sap.furcas.runtime.parser.impl;

import java.util.List;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.Parser;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.runtime.parser.ANTLR3LocationToken;
import com.sap.furcas.runtime.parser.IParsingObserver;

/**
 * A parser suppressing the ANTLR3.0.1 system.err messages and allowing an observer for the parsing process.
 * Made abstract since implementing does not make sense without a generated parser subclass, really.
 * Also handles awareness of exceptions in observers, makes sure that the exitTemplateRule is not called if an 
 * exception has happened, so that the exception does not get swallowed by finallys.
 */
public abstract class ObservablePatchedParser 
//extends DebugParser 
extends Parser
{

    /**
     * @param input
     * @param state 
     */
    public ObservablePatchedParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }
    
    /**
     * @param input
     * @param state 
     */
    public ObservablePatchedParser(TokenStream input) {
        super(input);
    }
    
    protected IParsingObserver observer;
    private boolean exceptionThrown = false;
    
    /**
     * Returns the UUID of the {@link ConcreteSyntax} for which the parser was generated.
     * 
     * @return the UUID of the syntax model element.
     */
    public String getSyntaxUUID() {
	    return null;
    }
    
    
    public void setObserver(IParsingObserver newObserver) {
        this.observer = newObserver;
    }
    
    protected void onEnterTemplateRule(List<String> createdElement) {
        setExceptionThrown(false);
        if (observer == null || getBacktrackingLevel() > 0) {
		return;
	} 
        // in observer: create textBlock in TB context (or root) and link to Template using SyntaxLookup
        // enter TB context
        observer.notifyEnterRule(createdElement, null);
    }
    
    protected void onEnterTemplateRule(List<String> createdElement, String mode) {
        if (observer == null || getBacktrackingLevel() > 0) {
		return;
	} 
        // in observer: create textBlock in TB context (or root) and link to Template using SyntaxLookup
        // enter TB context
        observer.notifyEnterRule(createdElement, mode);
    }
    
    protected void onElementAddedToContext(Object element) {
        if (observer == null || getBacktrackingLevel() > 0) {
		return;
	} 
        observer.notifyElementAddedToContext(element);
    }
    
    protected void onRuleElementCreationCommited(Object modelElement) {
        if (observer == null || getBacktrackingLevel() > 0) {
		return;
	}
        if (modelElement != null) {
            observer.notifyCommittedModelElementCreation(modelElement);
        } else {
            // TODO notify of failure
            observer.notifyCommitModelElementFailed();
        }
    }
    
    /**
     * notifies observer that after parsing, an element has been created for a reference in the text. 
     * @param modelElement
     */
    public void onRuleElementResolvedOutOfContext(Object modelElement, Object contextModelElement, 
            ANTLR3LocationToken referenceLocation, DelayedReference reference) {
        if (observer == null || getBacktrackingLevel() > 0) {
		return;
	}
        observer.notifyModelElementResolvedOutOfContext(modelElement, contextModelElement, referenceLocation, reference);
    }
    
    /**
     * notifies observer whenever a new {@link DelayedReference} is created. 
     * @param ref
     */
    protected void onDelayedReferenceCreated(DelayedReference ref) {
        if (observer == null || getBacktrackingLevel() > 0) {
		return;
	}
        	observer.notifyDelayedReferenceCreated(ref);
        
    }
    
    /**
     * notifies observer whenever the parser enters a new InjectorAction element.
     * @param ref
     */
    protected void _enterInjectorAction() {
        if (observer == null || getBacktrackingLevel() > 0) {
		return;
	}
        	observer.notifyEnterInjectorAction();
        
    }
    
    /**
     * notifies observer whenever the parser enters a new InjectorAction element.
     * @param ref
     */
    protected void _exitInjectorAction() {
        if (observer == null || getBacktrackingLevel() > 0) {
		return;
	}
        	observer.notifyExitInjectorAction();
        
    }
    
    protected void onErrorInTemplateRule(RecognitionException re) {
       
        if (observer != null || getBacktrackingLevel() > 0) {
            // in Observer: leave TB Context
            observer.notifyErrorInRule(re);
        }
    }
    
    /**
     * notifies leaving of current creation /resolution context, symmetrical to EnterTemplateRule
     * @param createdModelElementOrNull may be null on parsing errors
     */
    protected void onExitTemplateRule(List<String> createdElement) {
        if (observer == null || getBacktrackingLevel() > 0) {
		return;
	}
        if (! isExceptionThrown()) { // if we had an exception, do not call notifyExit to prevent consequent exceptions
            // in Observer: leave TB Context
            observer.notifyExitRule(createdElement);
        }
    }
    
    /**
     * called before parsing any sequence element of a TCS sequence
     */
    protected void _beforeSeqEl() {
        if (observer == null || getBacktrackingLevel() > 0) {
		return;
	}
        observer.notifyEnterSequenceElement();
    }
    
    /**
     * called before parsing any sequence element of a TCS sequence
     * with the given MOFID
     */
    protected void _beforeSeqEl(String mri) {
        if (observer == null || getBacktrackingLevel() > 0) {
		return;
	}
        	observer.notifyEnterSequenceElement(mri);
    }
    
    /**
     * called after parsing any sequence element of a TCS sequence
     */
    protected void _afterSeqEl() {
        if (observer == null || getBacktrackingLevel() > 0) {
		return;
	}
        observer.notifyExitSequenceElement();
    }
        
    /**
     * called before parsing one of several alternative elements of a TCS sequence
     */
    protected void _enterAlt(int choice) {
        if (observer == null || getBacktrackingLevel() > 0) {
		return;
	}
        observer.notifyEnterSequenceAlternative(choice);
    }
    
    protected void _exitAlt() {
        if (observer == null || getBacktrackingLevel() > 0) {
		return;
	}
        observer.notifyExitSequenceAlternative();
    }
    
    /**
     * called before parsing a separator sequence element  of a multivalued property 
     */
    protected void _enterSepSeq() {
        if (observer == null || getBacktrackingLevel() > 0) {
		return;
	}
        observer.notifyEnterSeparatorSequence();
    }
    
    protected void _exitSepSeq() {
        if (observer == null || getBacktrackingLevel() > 0) {
		return;
	}
        observer.notifyExitSeparatorSequence();
    }
    
    /**
     * called before the bit of an operatored template which allows recursive brackets "((((...))))" 
     */
    protected void _enterOpdBrackSeq() {
        if (observer == null || getBacktrackingLevel() > 0) {
		return;
	}
        observer.notifyEnterOperatoredBrackettedSequence();
    }
    
    protected void _exitOpdBrackSeq() {
        if (observer == null || getBacktrackingLevel() > 0) {
		return;
	}
        observer.notifyExitOperatoredBrackettedSequence();
    }
    
    /**
     * notifies entering of a certain operator sequence, meaning e.g. for 3+4 that next should be an integer, a "+" and another integer.
     * @param operator symbol used for this sequence
     * @param arity 1 or 2
     * @param unaryPostfix only for 1-ary operators, allow putting the operator behind the operand
     */
    protected void _enterOpSeq(String operator, int arity, boolean isUnaryPostfix) {
        if (observer == null || getBacktrackingLevel() > 0) {
		return;
	}
        observer.notifyEnterOperatorSequence(operator, arity, isUnaryPostfix);
    }
    
    protected void _exitOpSeq() {
        if (observer == null || getBacktrackingLevel() > 0) {
		return;
	}
        observer.notifyExitOperatorSequence();
    }
    
    // copied from ANTLR, added observer code only
    /** Match current input symbol against ttype.  Upon error, do one token
     *  insertion or deletion if possible.  You can override to not recover
     *  here and bail out of the current production to the normal error
     *  exception catch (at the end of the method) by just throwing
     *  MismatchedTokenException upon input.LA(1)!=ttype.
     */
    @Override
public Object match(IntStream input, int ttype, BitSet follow)
        throws RecognitionException
    {
    	//System.out.println("match "+((TokenStream)input).LT(1));
		Object matchedSymbol = getCurrentInputSymbol(input);
		if ( input.LA(1)==ttype ) {
			input.consume();
			if (observer != null && getBacktrackingLevel() == 0) {
                observer.notifyTokenConsume((Token) matchedSymbol);
            }
			state.errorRecovery = false;
			state.failed = false;
			return matchedSymbol;
		}
		if ( state.backtracking>0 ) {
			state.failed = true;
			return matchedSymbol;
		}
		if (observer != null && getBacktrackingLevel() == 0) {
            observer.notifyTokenConsumeWithError((Token) matchedSymbol);
        }
		matchedSymbol = recoverFromMismatchedToken(input, ttype, follow);
		return matchedSymbol;
    }
    

    public boolean isExceptionThrown() {
        return exceptionThrown;
    }

    public void setExceptionThrown(boolean exceptionThrown) {
        this.exceptionThrown = exceptionThrown;
    }

    @Override
    public void reset() {
	super.reset();
	if (this.observer != null) {
	    this.observer.reset();
	}
    }
}
