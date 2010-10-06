/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.handlerStub;

import java.util.ArrayList;
import java.util.List;

import tcs.Sequence;
import tcs.SequenceElement;

import com.sap.furcas.textual.common.exceptions.MetaModelLookupException;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.RuleBodyStringBuffer;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.constraints.RuleBodyPropertyConstraint;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.LocatedElementStub;

/**
 *
 */
public class RuleBodyStringBufferStub extends RuleBodyStringBuffer {

    StringBuilder builder = new StringBuilder();
    public List<RuleBodyPropertyConstraint> removedConstraints = new ArrayList<RuleBodyPropertyConstraint>();
    public List<RuleBodyPropertyConstraint> addedconstraints = new ArrayList<RuleBodyPropertyConstraint>();
    public List<RuleBodyPropertyConstraint> currentConstraints = new ArrayList<RuleBodyPropertyConstraint>();
    
    /**
     * @param newAlternativeHandler
     * @param blockHandler
     * @param conElHandler
     * @param propertyHandler
     * @param syntaxLookup
     */
    public RuleBodyStringBufferStub() {
        super(null, null, null, null, null, null, null, null);
    }

    @Override
    public void append(char character) {
        builder.append(character);
    }

    @Override
    public void append(Object... objectArr) {
        if (objectArr != null) {
            for (int i = 0; i < objectArr.length; i++) {
                Object object = objectArr[i];
                builder.append(object);    
            }
        }
    }

    @Override
    public void append(Object object) {
        builder.append(object);
    }

    @Override
    public String getResult() {
        return String.valueOf(builder);
    }

    @Override
    public String toString() {
        return String.valueOf(builder);
    }

    @Override
    protected void addToRuleFragment(SequenceElement element)
            throws MetaModelLookupException {
        LocatedElementStub stub = (LocatedElementStub) element; 
        builder.append(stub.representation);
    }
    
    @Override
    protected void addToRuleFragment(Sequence element)
            throws MetaModelLookupException {
        LocatedElementStub stub = (LocatedElementStub) element; 
        builder.append(stub.representation);
    }

    @Override
    public List<RuleBodyPropertyConstraint> getCurrentConstraints() {
        return currentConstraints;
    }

    @Override
    public void removeConstraint(RuleBodyPropertyConstraint constraint) {
        removedConstraints.add(constraint);
    }

    @Override
    public RuleBodyPropertyConstraint setPropertyConstraint(
            RuleBodyPropertyConstraint constraint) {
        addedconstraints.add(constraint);
        return constraint;
    }


}
