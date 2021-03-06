/**
 * 
 */
package com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub;

import java.util.ArrayList;
import java.util.List;

import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.LocatedElementStub;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.RuleBodyStringBuffer;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.constraints.RuleBodyPropertyConstraint;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;

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
