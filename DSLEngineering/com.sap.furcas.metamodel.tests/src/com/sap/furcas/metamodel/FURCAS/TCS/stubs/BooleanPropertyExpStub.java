/**
 * 
 */
package com.sap.furcas.metamodel.FURCAS.TCS.stubs;

import org.eclipse.emf.ecore.EClass;

import com.sap.furcas.metamodel.FURCAS.TCS.AndExp;
import com.sap.furcas.metamodel.FURCAS.TCS.BooleanPropertyExp;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

/**
 *
 */
public class BooleanPropertyExpStub extends AtomExpStub implements
        BooleanPropertyExp {

    


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

    @Override
    public EClass eClass() {
        return TCSPackage.eINSTANCE.getBooleanPropertyExp();
    }


}
