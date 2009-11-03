package com.sap.mi.textual.moinlookup.stubs;

import java.util.HashSet;
import java.util.Set;

import com.sap.mi.fwk.IPartitionScopeProvider;
import com.sap.tc.moin.repository.PRI;

public class PartitionScopeProviderStub implements IPartitionScopeProvider {

	private Set<PRI> pris = new HashSet<PRI>();
	
	public void addPri(PRI pri) {
		pris.add(pri);
	}

	public Set<PRI> getPartitions() {
		return pris;
	}

}
