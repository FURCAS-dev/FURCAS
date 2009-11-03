/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub;

import tcs.PropertyReference;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

/**
 *
 */
public class AtomExpStub extends LocatedElementStub implements
        tcs.AtomExp {

    public PropertyReferenceStub propertyRef = new PropertyReferenceStub();
    



    /* (non-Javadoc)
     * @see tcs.AtomExp#getPropertyReference()
     */
    @Override
    public PropertyReference getPropertyReference() throws JmiException {
        return propertyRef;
    }


    /* (non-Javadoc)
     * @see tcs.AtomExp#setPropertyReference(tcs.PropertyReference)
     */
    @Override
    public void setPropertyReference(PropertyReference newValue)
            throws JmiException {
        // TODO Auto-generated method stub
        
    }



}
