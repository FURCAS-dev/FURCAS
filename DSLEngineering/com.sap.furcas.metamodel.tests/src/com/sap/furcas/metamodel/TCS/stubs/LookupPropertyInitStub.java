/**
 * 
 */
package com.sap.furcas.metamodel.TCS.stubs;

import junit.framework.Assert;

import com.sap.furcas.metamodel.TCS.InjectorActionsBlock;
import com.sap.furcas.metamodel.TCS.LookupPropertyInit;
import com.sap.furcas.metamodel.TCS.PropertyReference;

/**
 *
 */
public class LookupPropertyInitStub extends LocatedElementStub implements LookupPropertyInit {

    public PropertyReference reference;
    public String value;
    public Boolean isDefault;

    /*
     * (non-Javadoc)
     * 
     * @see tcs.PropertyInit#getPropertyReference()
     */
    @Override
    public PropertyReference getPropertyReference() {
	return reference;
    }

    /*
     * (non-Javadoc)
     * 
     * @see tcs.PropertyInit#getValue()
     */
    @Override
    public String getValue() {
	return value;
    }

    /*
     * (non-Javadoc)
     * 
     * @see tcs.PropertyInit#setPropertyReference(tcs.PropertyReference)
     */
    @Override
    public void setPropertyReference(PropertyReference newValue) {
	Assert.fail("not implemented.");
    }

    /*
     * (non-Javadoc)
     * 
     * @see tcs.PropertyInit#setValue(java.lang.String)
     */
    @Override
    public void setValue(String newValue) {
	Assert.fail("not implemented.");
    }

    @Override
    public InjectorActionsBlock getInjectorActionsBlock() {
	Assert.fail("not implemented.");
	return null;
    }

    @Override
    public void setInjectorActionsBlock(InjectorActionsBlock value) {
	Assert.fail("not implemented.");
    }

}