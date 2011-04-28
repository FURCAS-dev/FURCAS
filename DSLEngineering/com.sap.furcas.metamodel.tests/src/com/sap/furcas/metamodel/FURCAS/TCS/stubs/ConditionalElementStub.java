/**
 * 
 */
package com.sap.furcas.metamodel.FURCAS.TCS.stubs;

import org.eclipse.emf.ecore.EClass;

import com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement;
import com.sap.furcas.metamodel.FURCAS.TCS.Expression;
import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

/**
 *
 */
public class ConditionalElementStub extends SequenceElementStub implements ConditionalElement {

    public Sequence thenSequence, elseSequence;
    public Expression condition;

    @Override
    public Sequence getThenSequence() {
        return thenSequence;
    }

    @Override
    public void setThenSequence(Sequence thenSequence) {
        this.thenSequence = thenSequence;
    }

    @Override
    public Sequence getElseSequence() {
        return elseSequence;
    }

    @Override
    public void setElseSequence(Sequence elseSequence) {
        this.elseSequence = elseSequence;
    }

    @Override
    public Expression getCondition() {
        return condition;
    }

    @Override
    public void setCondition(Expression condition) {
        this.condition = condition;
    }
    
    
    @Override
    public EClass eClass() {
        return TCSPackage.eINSTANCE.getConditionalElement();
    }
}
