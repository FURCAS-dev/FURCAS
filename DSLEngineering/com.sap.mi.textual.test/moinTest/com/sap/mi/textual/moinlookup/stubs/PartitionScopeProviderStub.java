package com.sap.mi.textual.moinlookup.stubs;

import java.util.HashSet;
import java.util.Set;

public class PartitionScopeProviderStub implements IPartitionScopeProvider {

	private Set<PRI> pris = new HashSet<PRI>();
	
	public void addPri(PRI pri) {
		pris.add(pri);
	}

	public Set<PRI> getPartitions() {
		return pris;
	}

}
