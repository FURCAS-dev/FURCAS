/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub;

import java.util.List;

import com.sap.furcas.metamodel.TCS.PropertyArg;
import com.sap.furcas.metamodel.TCS.PropertyReference;

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
