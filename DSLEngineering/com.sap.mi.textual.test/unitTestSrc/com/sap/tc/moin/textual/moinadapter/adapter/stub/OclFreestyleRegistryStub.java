package com.sap.tc.moin.textual.moinadapter.adapter.stub;

import java.util.Set;

import junit.framework.Assert;

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
	public OclExpressionRegistration createExpressionRegistration(String name,
	       String oclExpression, OclRegistrationSeverity severity,
	       String[] categories, RefObject contextMetaClass,
	       MofPackage[] typesPackages) throws OclManagerException {
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
