package com.sap.mi.fwk;

import java.util.Set;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.PRI;

/**
 * Resolving of IProject into Partition sets
 * 
 * @deprecated use {@link PartitionService}
 */
@Deprecated
public final class PartitionSetService {

	/**
	 * @deprecated use {@link PartitionService#getPartitionScopes()}
	 */
	@Deprecated
	public static IPartitionScopes getStatelessPartitionResolver() {
		return PartitionService.getInstance().getPartitionScopes();
	}

	/**
	 * @deprecated use {@link PartitionService#getPartitionScopes()} and
	 *             {@link IPartitionScopes#getVisiblePartitions(Connection)}
	 */
	@Deprecated
	public static PRI[] partitionSetVisible(Connection co) {
		Set<PRI> pris = PartitionService.getInstance().getPartitionScopes().getVisiblePartitions(co);
		return pris.toArray(new PRI[pris.size()]);
	}

}
