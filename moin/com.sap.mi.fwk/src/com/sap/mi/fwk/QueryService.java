package com.sap.mi.fwk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.eclipse.core.resources.IProject;

import com.sap.mi.fwk.IPartitionScopeProvider.PartitionScope;
import com.sap.mi.fwk.internal.MiFwkPlugin;
import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.util.IExceptionHandler;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mql.FromEntry;
import com.sap.tc.moin.repository.mql.FromType;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.mql.MQLQuery;
import com.sap.tc.moin.repository.mql.MQLResultSet;
import com.sap.tc.moin.repository.mql.QueryScopeProvider;
import com.sap.tc.moin.repository.mql.SelectAlias;
import com.sap.tc.moin.repository.mql.SelectEntry;

/**
 * Provides convenience utilities for defining and executing MQL-based queries.
 * 
 * @author d031150
 * @author D020964
 */
public class QueryService {

	private static final Logger sTracer = Logger.getLogger(MiLocations.MI_MODELHANDLING);
	private static QueryService sInstance;
	private IExceptionHandler mExceptionHandler;

	/**
	 * @return the instance of this service
	 */
	public static synchronized QueryService getInstance() {
		if (sInstance == null)
			sInstance = new QueryService();
		return sInstance;
	}

	/**
	 * Retrieves all objects of a given type in a given project, including the
	 * connection's null partition but without referenced Dcs. Can be used for
	 * the typical "show all of type" scenario in project-based explorers. For
	 * querying with different scopes use
	 * {@link #queryInstances(Connection, IPartitionScopeProvider, String, String...)}
	 * .
	 * 
	 * @param project
	 *            the project
	 * @param connection
	 *            the connection to be used
	 * @param containerNameOfMetamodel
	 *            id of metamodel, can be <code>null</code>
	 * @param qualifiedNameOfType
	 *            qualified name of type, e.g.
	 *            <code>WebDynpro, component, Component</code>
	 * @return the retrieved objects
	 * 
	 * @see #queryInstances(Connection, IPartitionScopeProvider, String,
	 *      String...)
	 */
	// ATTENTION WITH API CHANGES!!! - Called via reflection from
	// com.sap.tc.webdynpro.metamodel.test.InvocationHelper
	public <T extends RefBaseObject> List<T> queryInstances(IProject project, Connection connection,
			String containerNameOfMetamodel, String... qualifiedNameOfType) {
		IPartitionScopeProvider scopeProvider = PartitionService.getInstance().getPartitionScopeProvider(connection,
				PartitionScope.INNER);
		return queryInstances(connection, scopeProvider, containerNameOfMetamodel, qualifiedNameOfType);
	}

	/**
	 * Retrieves all objects of a given type in a given scope. Can be used for
	 * the typical "show all of type" scenario in project-based explorers.
	 * 
	 * @param connection
	 *            the connection to be used
	 * @param partitionScopeProvider
	 *            the provider defining the scope to search in
	 * @param containerNameOfMetamodel
	 *            id of metamodel, can be <code>null</code>
	 * @param qualifiedNameOfType
	 *            qualified name of type, e.g.
	 *            <code>WebDynpro, component, Component</code>
	 * @return the retrieved objects
	 * 
	 * @see PartitionService#getPartitionScopeProvider(Connection,
	 *      PartitionScope)
	 */
	@SuppressWarnings("unchecked")
	public <T extends RefBaseObject> List<T> queryInstances(Connection connection,
			IPartitionScopeProvider partitionScopeProvider, String containerNameOfMetamodel,
			String... qualifiedNameOfType) {
		MiFwkPlugin.assertConnectionAlive(connection);
		if (qualifiedNameOfType == null || qualifiedNameOfType.length == 0) {
			throw new IllegalArgumentException("qualifiedNameOfType must not be empty: " //$NON-NLS-1$
					+ String.valueOf(qualifiedNameOfType));
		}

		final Set<PRI> partitionScope = partitionScopeProvider.getPartitions();
		final Set<CRI> containerScope = Collections.emptySet();

		FromType metaclassFT = new FromType("instance", // alias name //$NON-NLS-1$
				qualifiedNameOfType, containerNameOfMetamodel, true); // without
		// subtypes
		FromEntry[] fromEntries = new FromEntry[] { metaclassFT };
		SelectAlias selectAlias = new SelectAlias("instance"); //$NON-NLS-1$
		SelectEntry[] selectEntries = new SelectEntry[] { selectAlias };
		MQLQuery query = new MQLQuery(selectEntries, fromEntries);
		try {
			MQLProcessor processor = connection.getMQLProcessor();
			QueryScopeProvider scopeProvider = processor.getQueryScopeProvider(true, partitionScope, containerScope);
			MQLResultSet resultSet = processor.execute(query, scopeProvider);
			List<T> result = new ArrayList<T>(resultSet.getSize());
			for (int i = 0; i < resultSet.getSize(); i++) {
				MRI mri = resultSet.getMri(i, "instance"); //$NON-NLS-1$
				RefBaseObject object = connection.getElement(mri);
				if (object == null) {
					MiFwkPlugin.logError("Ignoring unresolvable MRI " + mri + " with connection " + connection, null, //$NON-NLS-1$ //$NON-NLS-2$
							sTracer);
				} else {
					// no chance to check in advance at runtime if object is an
					// instance of T :(
					result.add((T) object);
				}
			}
			return result;
		} catch (RuntimeException e) { // $JL-EXC$
			if (mExceptionHandler == null)
				MiFwkPlugin.logError("Query execution failed: " + e.getMessage(), e, sTracer); //$NON-NLS-1$
			else
				mExceptionHandler.handleException(e); // for testing purposes
			return Collections.emptyList();
		}
	}

	/**
	 * Converts a given {@link IPartitionScopeProvider partition scope provider}
	 * to an MQL {@link QueryScopeProvider}.
	 * 
	 * @param partitionScopeProvider
	 *            the provider the backing scope provider
	 * @return the MQL scope provider
	 */
	public QueryScopeProvider getQueryScopeProvider(final IPartitionScopeProvider partitionScopeProvider) {
		if (partitionScopeProvider == null)
			throw new IllegalArgumentException("Partition scope provider must not be null"); //$NON-NLS-1$

		// We do not use MQLProcessor#getQueryScopeProvider(PRI[]) here since
		// - a connection is needed to call this rather static method
		// - resolving of PRIs would be preponed unnecessarily.
		return new QueryScopeProvider() {
			public PRI[] getPartitionScope() {
				Set<PRI> partitions = partitionScopeProvider.getPartitions();
				return partitions.toArray(new PRI[partitions.size()]);
			}

			public CRI[] getContainerScope() {
				return new CRI[0];
			}

			public boolean isInclusiveScope() {
				return true;
			}

			@Override
			public String toString() {
				return partitionScopeProvider.toString();
			}
		};
	}

	/*
	 * Called reflectively by tests, be careful when changing.
	 */
	private QueryService() {
	}

	/*
	 * Called reflectively by tests, be careful when changing.
	 */
	@SuppressWarnings("unused")
	private synchronized void setExceptionHandler(IExceptionHandler exceptionHandler) {
		mExceptionHandler = exceptionHandler;
	}

}
