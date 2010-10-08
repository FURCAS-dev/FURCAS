/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub;

import junit.framework.Assert;

import com.sap.furcas.metamodel.TCS.InjectorActionsBlock;
import com.sap.furcas.metamodel.TCS.LookupPropertyInit;
import com.sap.furcas.metamodel.TCS.PropertyReference;

/**
 *
 */
public class LookupPropertyInitStub extends LocatedElementStub implements
		LookupPropertyInit {

	public PropertyReference reference;
	public String value;
	public Boolean isDefault;

	/*
	 * (non-Javadoc)
	 * 
	 * @see tcs.PropertyInit#getPropertyReference()
	 */
	@Override
	public PropertyReference getPropertyReference() throws JmiException {
		return reference;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tcs.PropertyInit#getValue()
	 */
	@Override
	public String getValue() throws JmiException {
		return value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tcs.PropertyInit#setPropertyReference(tcs.PropertyReference)
	 */
	@Override
	public void setPropertyReference(PropertyReference newValue)
			throws JmiException {
		Assert.fail("not implemented.");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tcs.PropertyInit#setValue(java.lang.String)
	 */
	@Override
	public void setValue(String newValue) throws JmiException {
		Assert.fail("not implemented.");
	}

	@Override
	public boolean isDefault() throws JmiException {
		return isDefault;
	}

	@Override
	public void setDefault(boolean newValue) throws JmiException {
		Assert.fail("not implemented.");
	}

	@Override
	public InjectorActionsBlock getInjectorActionsBlockReference()
			throws JmiException {
		Assert.fail("not implemented.");
		return null;
	}

	@Override
	public void setInjectorActionsBlockReference(InjectorActionsBlock newValue)
			throws JmiException {
		Assert.fail("not implemented.");
		
	}
}
