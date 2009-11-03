package com.sap.mi.fwk;

import java.util.Set;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.PRI;

/**
 * Protocol for different partition scopes. In opposition to
 * {@link IPartitionScopeProvider} the client may chose between the different
 * scopes.
 * <p>
 * Not intended to be implemented by clients. Use the accessor methods in
 * {@link PartitionService} that offer different implementations.
 * 
 * @author d031150
 */
public interface IPartitionScopes {

	/**
	 * Computes all partitions within one project/DC plus all transient
	 * partitions including the null partition.
	 * 
	 * @param connection
	 *            the connection defining the project scope. Only works with
	 *            connections created using
	 *            {@link ConnectionManager#createConnection(org.eclipse.core.resources.IProject) project scope}.
	 * @return the partitions as a snapshot at the moment of the invocation. Is
	 *         not a live list, do not modify.
	 */
	Set<PRI> getInnerPartitions(Connection connection);

	/**
	 * Computes the exposed partitions of all referenced projects/public parts.
	 * 
	 * @param connection
	 *            the connection defining the project scope. Only works with
	 *            connections created using
	 *            {@link ConnectionManager#createConnection(org.eclipse.core.resources.IProject) project scope}.
	 * @return the partitions as a snapshot at the moment of the invocation. Is
	 *         not a live list, do not modify.
	 */
	Set<PRI> getOuterPartitions(Connection connection);

	/**
	 * Computes the <em>visible</em> partition set, defined as sum of
	 * {@link #getInnerPartitions(Connection) inner} and
	 * {@link #getOuterPartitions(Connection) outer} partitions.
	 * 
	 * @param connection
	 *            the connection defining the project scope. Only works with
	 *            connections created using
	 *            {@link ConnectionManager#createConnection(org.eclipse.core.resources.IProject) project scope}.
	 * @return the partitions as a snapshot at the moment of the invocation. Is
	 *         not a live list, do not modify.
	 */
	Set<PRI> getVisiblePartitions(Connection connection);

	/**
	 * To be used to simulate public parts as long as the underlying repository
	 * does not support "real" cross-project referencing. The MOF Editor e.g.
	 * adds the MOF-ROM partitions to it's value-help scope in this manner. <p/>
	 * Will be deprecated in the future.
	 * 
	 * @param partitions
	 *            to partitions to set as visible partitions.
	 * 
	 * @deprecated Will be removed soon
	 */
	@Deprecated
	void setFixedVisiblePartitions(Set<PRI> partitions);

}
