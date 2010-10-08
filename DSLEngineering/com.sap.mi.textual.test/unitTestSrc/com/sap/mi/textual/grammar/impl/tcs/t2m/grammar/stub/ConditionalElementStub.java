/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub;

import com.sap.furcas.metamodel.TCS.ConditionalElement;

/**
 *
 */
public class ConditionalElementStub extends SequenceElementStub implements ConditionalElement {

    public Sequence thenSequence, elseSequence;
    public Expression condition;

    public Sequence getThenSequence() {
        return thenSequence;
    }

    public void setThenSequence(Sequence thenSequence) {
        this.thenSequence = thenSequence;
    }

    public Sequence getElseSequence() {
        return elseSequence;
    }

    public void setElseSequence(Sequence elseSequence) {
        this.elseSequence = elseSequence;
    }

    public Expression getCondition() {
        return condition;
    }

    public void setCondition(Expression condition) {
        this.condition = condition;
    }
    
    
    
}
