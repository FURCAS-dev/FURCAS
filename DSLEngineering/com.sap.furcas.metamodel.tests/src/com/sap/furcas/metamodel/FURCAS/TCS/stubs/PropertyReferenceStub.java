/**
 * 
 */
package com.sap.furcas.metamodel.FURCAS.TCS.stubs;

import junit.framework.Assert;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.sap.furcas.emf.stubs.EcoreAnyStub;
import com.sap.furcas.metamodel.FURCAS.TCS.PropertyReference;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

/**
 *
 */
public class PropertyReferenceStub extends LocatedElementStub implements
        PropertyReference {

    public String name;
    public EStructuralFeature strucFeature = new EcoreAnyStub();
	public boolean isOppositeEnd = false;
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    /* (non-Javadoc)
     * @see tcs.Property#getStrucfeature()
     */
    @Override
    public EStructuralFeature getStrucfeature() {
        return strucFeature;
    }

    /* (non-Javadoc)
     * @see tcs.Property#setStrucfeature(com.sap.tc.moin.repository.mmi.model.TypedElement)
     */
    @Override
    public void setStrucfeature(EStructuralFeature value) {
        Assert.fail("not implemented.");
    }

    @Override
    public EClass eClass() {
        return TCSPackage.eINSTANCE.getPropertyReference();
    }

}
