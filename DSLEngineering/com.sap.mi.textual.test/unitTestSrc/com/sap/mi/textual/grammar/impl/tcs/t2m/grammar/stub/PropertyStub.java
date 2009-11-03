/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub;

import java.util.List;

import tcs.Property;
import tcs.PropertyArg;
import tcs.PropertyReference;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

/**
 *
 */
public class PropertyStub extends SequenceElementStub implements Property {


    public List<PropertyArg> args;
    public PropertyReferenceStub propRef = new PropertyReferenceStub();

    /* (non-Javadoc)
     * @see TCS.Property#getPropertyArgs()
     */
    public List<PropertyArg> getPropertyArgs() {
        return args;
    }



    /* (non-Javadoc)
     * @see tcs.Property#getPropertyReference()
     */
    @Override
    public PropertyReference getPropertyReference() throws JmiException {
        return propRef;
    }

    /* (non-Javadoc)
     * @see tcs.Property#setPropertyReference(tcs.PropertyReference)
     */
    @Override
    public void setPropertyReference(PropertyReference newValue)
            throws JmiException {
        // TODO Auto-generated method stub
        
    }


}
