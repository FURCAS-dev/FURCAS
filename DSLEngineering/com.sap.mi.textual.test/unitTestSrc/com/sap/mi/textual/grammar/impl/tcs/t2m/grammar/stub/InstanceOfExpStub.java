/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub;

import java.util.List;

import junit.framework.Assert;
import tcs.AndExp;
import tcs.InstanceOfExp;

/**
 *
 */
public class InstanceOfExpStub extends AtomExpStub implements
        InstanceOfExp {

    public List<String> supertype;
    



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
        Assert.fail("not implemented.");
    }


    /* (non-Javadoc)
     * @see TCS.InstanceOfExp#getSupertype()
     */
    public List<String> getSupertype() {
        return supertype;
    }


}
