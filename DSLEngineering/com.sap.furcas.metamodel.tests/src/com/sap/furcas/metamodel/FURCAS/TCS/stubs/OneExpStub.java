/**
 * 
 */
package com.sap.furcas.metamodel.FURCAS.TCS.stubs;

import org.eclipse.emf.ecore.EClass;

import junit.framework.Assert;

import com.sap.furcas.metamodel.FURCAS.TCS.AndExp;
import com.sap.furcas.metamodel.FURCAS.TCS.OneExp;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

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

    @Override
    public EClass eClass() {
        return TCSPackage.eINSTANCE.getOneExp();
    }

}
