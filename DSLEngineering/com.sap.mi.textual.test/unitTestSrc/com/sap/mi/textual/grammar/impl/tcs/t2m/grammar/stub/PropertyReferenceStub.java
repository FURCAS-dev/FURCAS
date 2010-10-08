/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub;

import junit.framework.Assert;

import org.eclipse.ocl.utilities.TypedElement;

import com.sap.furcas.metamodel.TCS.PropertyReference;
import com.sap.mi.textual.parsing.MofAnyStub;

/**
 *
 */
public class PropertyReferenceStub extends LocatedElementStub implements
        PropertyReference {

    public String name;
    public StructuralFeature strucFeature = new MofAnyStub();
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /* (non-Javadoc)
     * @see tcs.Property#getStrucfeature()
     */
    @Override
    public StructuralFeature getStrucfeature() throws JmiException {

        return strucFeature;
    }

    /* (non-Javadoc)
     * @see tcs.Property#setStrucfeature(com.sap.tc.moin.repository.mmi.model.TypedElement)
     */
    @Override
    public void setStrucfeature(TypedElement newValue) throws JmiException {
        Assert.fail("not implemented.");
    }


}
