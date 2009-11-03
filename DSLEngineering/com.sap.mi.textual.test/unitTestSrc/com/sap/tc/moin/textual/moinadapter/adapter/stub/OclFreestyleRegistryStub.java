package com.sap.tc.moin.textual.moinadapter.adapter.stub;

import java.util.Set;

import junit.framework.Assert;

import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.ocl.freestyle.OclExpressionRegistration;
import com.sap.tc.moin.repository.ocl.freestyle.OclFreestyleRegistry;
import com.sap.tc.moin.repository.ocl.freestyle.OclInvariantRegistration;
import com.sap.tc.moin.repository.ocl.freestyle.OclRegistration;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationListener;
import com.sap.tc.moin.repository.ocl.notification.ImmediateConstraintViolationListener;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationSeverity;

public class OclFreestyleRegistryStub implements OclFreestyleRegistry {
	
	public OclExpressionRegistration expresssionReg;
	public String expectedQuery;

	@Override
	public OclExpressionRegistration createExpressionRegistration(String name,
			String oclExpression, OclRegistrationSeverity severity,
			String[] categories, RefClass parsingContext,
			RefPackage[] typesPackages) throws OclManagerException {
		Assert.assertEquals(expectedQuery, oclExpression);
		return expresssionReg;
	}
	
	@Override
	public OclExpressionRegistration createExpressionRegistration(String name,
			String oclExpression, OclRegistrationSeverity severity,
			String[] categories, RefObject parsingContext,
			RefPackage[] typesPackages) throws OclManagerException {
		Assert.assertEquals(expectedQuery, oclExpression);
		return expresssionReg;
	}

	@Override
	public OclInvariantRegistration createInvariantRegistration(String name,
			String oclExpression, OclRegistrationSeverity severity,
			String[] categories, RefClass parsingContext,
			RefPackage[] typesPackages) throws OclManagerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteRegistration(String name) throws OclManagerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OclRegistration getRegistration(String name) {
		return expresssionReg;
	}

	@Override
	public Set<String> getRegistrationNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean registerDeferredConstraintViolationListenerForEvents(
			String category, DeferredConstraintViolationListener listener)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerDeferredConstraintViolationListenerForPartitions(
			String category, DeferredConstraintViolationListener listener) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerImmediateConstraintViolationListener(
			String category, ImmediateConstraintViolationListener listener)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unregisterDeferredConstraintViolationListener(
			DeferredConstraintViolationListener listener) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unregisterImmediateConstraintViolationListener(
			ImmediateConstraintViolationListener listener) {
		// TODO Auto-generated method stub
		return false;
	}

}
