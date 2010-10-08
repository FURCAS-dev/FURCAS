/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub;

import java.util.ArrayList;
import java.util.List;

import com.sap.furcas.metamodel.TCS.Associativity;
import com.sap.furcas.metamodel.TCS.OperatorList;
import com.sap.furcas.metamodel.TCS.Priority;

/**
 *
 */
public class PriorityStub extends LocatedElementStub implements Priority {

    public int value;
    public OperatorList list;
    public Associativity associativity;
    public List<Operator> operators = new ArrayList<Operator>();
    
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public OperatorList getList() {
        return list;
    }
    public void setList(OperatorList list) {
        this.list = list;
    }
    public Associativity getAssociativity() {
        return associativity;
    }
    public void setAssociativity(Associativity associativity) {
        this.associativity = associativity;
    }
    /* (non-Javadoc)
     * @see TCS.Priority#getOperators()
     */
    public List<Operator> getOperators() {
        return operators;
    }
    

}
