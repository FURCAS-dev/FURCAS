package com.sap.tc.moin.textual.moinadapter.adapter.stub;

import java.util.Set;

public class OCLRegistryServiceStub implements OclRegistryService {
	
	public OclFreestyleRegistry freeStyleRegistry;

	@Override
	public boolean analyzeCollectedEvents(String category)
			throws OclManagerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean analyzeModelPartitions(String category, Set<PRI> partitions)
			throws OclManagerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OclFreestyleRegistry getFreestyleRegistry() {
		return freeStyleRegistry;
	}

	@Override
	public OclMetamodelConstraintRegistry getMetamodelConstraintRegistry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OclMofConstraintRegistry getMofConstraintRegistry()
			throws OclManagerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void resetEvents(String category) throws OclManagerException {
		// TODO Auto-generated method stub

	}

	@Override
	public DeferredConstraintViolationStatus verifyConstraints(RefObject object)
			throws OclManagerException {
		// TODO Auto-generated method stub
		return null;
	}

}
