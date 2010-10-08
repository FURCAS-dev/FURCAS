package com.sap.tc.moin.textual.moinadapter.adapter.stub;

import java.util.Collection;

import org.eclipse.core.internal.jobs.LockManager;

public class SessionSub implements Session {

	@Override
	public Connection createConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection createConnection(String label) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompoundClientSpec getCompoundClientSpec() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EventRegistry getEventRegistry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<PRI> getInnerPartitions(CRI cri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LockManager getLockManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Moin getMoin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<PRI> getOuterPartitions(CRI cri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<CRI> getReferencedContainers(CRI cri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasCrossPartitionLinks(PRI priOne, PRI... otherPris) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isContainerModifiable(CRI cri) {
		// TODO Auto-generated method stub
		return false;
	}

}
