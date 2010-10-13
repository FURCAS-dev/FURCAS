/**
 * 
 */
package com.sap.furcas.metamodel.TCS.stubs;

import com.sap.furcas.metamodel.TCS.AndExp;
import com.sap.furcas.metamodel.TCS.EqualsExp;
import com.sap.furcas.metamodel.TCS.Value;

/**
 *
 */
public class EqualsExpStub extends AtomExpStub implements EqualsExp {

    public Value value;

    /*
     * (non-Javadoc)
     * 
     * @see TCS.AtomExp#getAndExp()
     */
    @Override
    public AndExp getAndExp() {
	// TODO Auto-generated method stub
	return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see TCS.AtomExp#setAndExp(TCS.AndExp)
     */
    @Override
    public void setAndExp(AndExp value) {
	// TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see TCS.EqualsExp#getValue()
     */
    @Override
    public Value getValue() {
	return value;
    }

    /*
     * (non-Javadoc)
     * 
     * @see TCS.EqualsExp#setValue(TCS.Value)
     */
    @Override
    public void setValue(Value value) {
	this.value = value;
    }

}
