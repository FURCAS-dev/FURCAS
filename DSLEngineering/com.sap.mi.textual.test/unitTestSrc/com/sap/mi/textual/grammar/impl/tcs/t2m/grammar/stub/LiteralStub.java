/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub;

import java.util.List;

import tcs.Literal;
import tcs.LiteralRef;
import tcs.Operator;
import tcs.SpaceKind;
import tcs.Symbol;

/**
 *
 */
public class LiteralStub extends LiteralRefStub implements Literal, Symbol {

    public String value, name;
    public List<Operator> operators;
    
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /* (non-Javadoc)
     * @see TCS.Literal#getLiteralRefs()
     */
    public List<LiteralRef> getLiteralRefs() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see TCS.Literal#getOperators()
     */
    public List<Operator> getOperators() {
        return operators;
    }

    /* (non-Javadoc)
     * @see TCS.Symbol#getSpaces()
     */
    public List<SpaceKind> getSpaces() {
        // TODO Auto-generated method stub
        return null;
    }

  

  

}
