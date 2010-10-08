/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub;

import junit.framework.Assert;

import com.sap.furcas.metamodel.TCS.AndExp;
import com.sap.furcas.metamodel.TCS.OneExp;

/**
 *
 */
public class OneExpStub extends AtomExpStub implements
        OneExp {

   


    /* (non-Javadoc)
     * @see TCS.AtomExp#getAndExp()
     */
    public AndExp getAndExp() {
        Assert.fail("not implemented.");
        return null;
    }


    /* (non-Javadoc)
     * @see TCS.AtomExp#setAndExp(TCS.AndExp)
     */
    public void setAndExp(AndExp value) {
        Assert.fail("not implemented.");
    }


}
