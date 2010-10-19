/**
 * 
 */
package com.sap.furcas.metamodel.FURCAS.TCS.stubs;

import org.eclipse.emf.common.util.EList;

import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.TCS.PropertyArg;
import com.sap.furcas.metamodel.FURCAS.TCS.PropertyReference;

/**
 *
 */
public class PropertyStub extends SequenceElementStub implements Property {


    public EList<PropertyArg> args;
    public PropertyReferenceStub propRef = new PropertyReferenceStub();

    /* (non-Javadoc)
     * @see TCS.Property#getPropertyArgs()
     */
    @Override
    public EList<PropertyArg> getPropertyArgs() {
        return args;
    }

    /* (non-Javadoc)
     * @see tcs.Property#getPropertyReference()
     */
    @Override
    public PropertyReference getPropertyReference() {
        return propRef;
    }

    /* (non-Javadoc)
     * @see tcs.Property#setPropertyReference(tcs.PropertyReference)
     */
    @Override
    public void setPropertyReference(PropertyReference newValue) {
        // TODO Auto-generated method stub
    }


}
