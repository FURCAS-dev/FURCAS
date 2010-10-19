/**
 * 
 */
package com.sap.furcas.metamodel.FURCAS.TCS.stubs;

import junit.framework.Assert;

import org.eclipse.emf.common.util.EList;

import com.sap.furcas.metamodel.FURCAS.TCS.AndExp;
import com.sap.furcas.metamodel.FURCAS.TCS.InstanceOfExp;

/**
 *
 */
public class InstanceOfExpStub extends AtomExpStub implements InstanceOfExp {

    public EList<String> supertype;

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
	Assert.fail("not implemented.");
    }

    /*
     * (non-Javadoc)
     * 
     * @see TCS.InstanceOfExp#getSupertype()
     */
    @Override
    public EList<String> getSupertype() {
	return supertype;
    }

}
