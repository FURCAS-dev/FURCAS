package com.sap.mi.fwk;

import java.util.Set;

import com.sap.tc.moin.repository.PRI;

/**
 * Protocol for different partition compution strategies. In opposition to
 * {@link IPartitionScopes} implementors of this interface already known which
 * scope they have to provide partitions for.
 * <p>
 * Not intended to be implemented by clients. Use the accessor methods in
 * {@link PartitionService} that offer different implementations.
 * </p>
 * 
 * @author d031150
 */
public interface IPartitionScopeProvider {

	/**
	 * Identifies a distinct partition scope
	 */
	public enum PartitionScope {
		/**
		 * All partitions within one project/DC plus all transient partitions
		 * including the null partition.
		 */
		INNER,
		/**
		 * The exposed partitions of all referenced DCs/public parts.
		 */
		OUTER,
		/**
		 * All {@link #INNER inner} plus {@link #OUTER outer} partitions.
		 */
		VISIBLE
	}

	/**
	 * Computes the partition set suitable for the {@link PartitionScope scope}
	 * this provider was instantiated with
	 * 
	 * @return the partitions as a snapshot at the moment of the invocation. Is
	 *         not a live list, do not modify.
	 */
	Set<PRI> getPartitions();

}
