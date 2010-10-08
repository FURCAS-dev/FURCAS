/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub;

import com.sap.furcas.metamodel.TCS.AndExp;
import com.sap.furcas.metamodel.TCS.EqualsExp;

/**
 *
 */
public class EqualsExpStub extends AtomExpStub implements
        EqualsExp {

    public Value value;




    /* (non-Javadoc)
     * @see TCS.AtomExp#getAndExp()
     */
    public AndExp getAndExp() {
        // TODO Auto-generated method stub
        return null;
    }


    /* (non-Javadoc)
     * @see TCS.AtomExp#setAndExp(TCS.AndExp)
     */
    public void setAndExp(AndExp value) {
        // TODO Auto-generated method stub

    }
    
    /* (non-Javadoc)
     * @see TCS.EqualsExp#getValue()
     */
    public Value getValue() {
        return value;
    }


    /* (non-Javadoc)
     * @see TCS.EqualsExp#setValue(TCS.Value)
     */
    public void setValue(Value value) {
        this.value = value;
    }


}
