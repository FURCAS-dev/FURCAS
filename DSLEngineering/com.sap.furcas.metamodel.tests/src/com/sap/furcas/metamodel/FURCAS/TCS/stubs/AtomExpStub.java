/**
 * 
 */
package com.sap.furcas.metamodel.FURCAS.TCS.stubs;

import org.eclipse.emf.ecore.EClass;

import com.sap.furcas.metamodel.FURCAS.TCS.AndExp;
import com.sap.furcas.metamodel.FURCAS.TCS.AtomExp;
import com.sap.furcas.metamodel.FURCAS.TCS.PropertyReference;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

/**
 *
 */
public class AtomExpStub extends LocatedElementStub implements AtomExp {

    public PropertyReferenceStub propertyRef = new PropertyReferenceStub();

    /*
     * (non-Javadoc)
     * 
     * @see tcs.AtomExp#getPropertyReference()
     */
    @Override
    public PropertyReference getPropertyReference() {
	return propertyRef;
    }

    /*
     * (non-Javadoc)
     * 
     * @see tcs.AtomExp#setPropertyReference(tcs.PropertyReference)
     */
    @Override
    public void setPropertyReference(PropertyReference newValue) {
	// TODO Auto-generated method stub

    }

    @Override
    public AndExp getAndExp() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void setAndExp(AndExp value) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public String getPropertyName() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void setPropertyName(String value) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public EClass eClass() {
        return TCSPackage.eINSTANCE.getAtomExp();
    }

}
