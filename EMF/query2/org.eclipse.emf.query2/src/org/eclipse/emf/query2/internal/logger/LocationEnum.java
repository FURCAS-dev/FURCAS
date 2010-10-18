/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query2.internal.logger;

/**
 * The names of logical-defined MOIN Locations.
 * <p>
 * The MOIN Logging and Tracing solution allows you the usage of package-related
 * and logical-defined location names. The logical-defined locations are defined
 * in the com.sap.tc.moin.repository.shared.logger.MoinLocationEnum class.
 * 
 * @author d029324
 */
public enum LocationEnum {
	/**
	 * The MOIN parent Location - com.sap.moin. This Location is the entry-point
	 * to the Modeling Infrastructure solution.
	 */
	MOIN("com.sap.moin", "Modeling Infrastructure"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * Location name for shared utility classes.
	 */
	MOIN_UTIL(MOIN + ".util", "Utilities"), //$NON-NLS-1$  //$NON-NLS-2$

	/**
	 * Location name for shared database utility classes.
	 */
	MOIN_UTIL_DB(MOIN_UTIL + ".db", "Database Utilities"), //$NON-NLS-1$  //$NON-NLS-2$

	/**
	 * The Location used to trace the MOIN core. The Location name -
	 * com.sap.moin.core
	 */
	MOIN_CORE(MOIN + ".core", "Core"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used to trace the MOIN MicroTransactions. The Location name
	 * - com.sap.moin.core.microtransactions
	 */
	MOIN_CORE_MICROTRANSACTIONS(MOIN_CORE + ".microtransactions", "MicroTransactions"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used to trace the MOIN command functionality. The Location
	 * name - com.sap.moin.core.commands
	 */
	MOIN_COMMANDS(MOIN_CORE + ".commands", "Commands"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used to trace the MOIN connection functionality. The
	 * Location name - com.sap.moin.core.connections
	 */
	MOIN_CONNECTIONS_SESSIONS(MOIN_CORE + ".connections_sessions", "Connections / Sessions"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used to trace the MOIN partition functionality. The Location
	 * name - com.sap.moin.core.partitions
	 */
	MOIN_PARTITIONS(MOIN_CORE + ".partitions", "Partitions"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used to trace the MOIN-specific cache eviction mechanism.
	 * The Location name - com.sap.moin.core.eviction
	 */
	MOIN_CORE_EVICTION(MOIN_CORE + ".eviction", "Eviction"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used for the MOIN-specific locking functionality. The
	 * Location name - com.sap.moin.core.locking
	 */
	MOIN_LOCKING(MOIN_CORE + ".locking", "Locking"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used for the MOIN consistency functionality. The Location
	 * name - com.sap.moin.core.consistency
	 */
	MOIN_CONSISTENCY(MOIN_CORE + ".consistency", "Consistency"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used for the MOIN eventing functionality. The Location name
	 * - com.sap.moin.core.events
	 */
	MOIN_EVENTS(MOIN_CORE + ".events", "Events"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used for the MOIN JMI handling functionality. The Location
	 * name - com.sap.moin.core.jmi
	 */
	MOIN_JMI(MOIN_CORE + ".jmi", "JMI Handling"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used for the MOIN JMI class loading functionality. The
	 * Location name - com.sap.moin.core.jmi.classloading
	 */
	MOIN_JMI_CLASSLOADING(MOIN_JMI + ".classloading", "JMI Class Loading"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used for OCL. The Location name is com.sap.moin.ocl
	 */
	MOIN_CORE_OCL(MOIN + ".ocl", "OCL"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used for the OCL Parser. The Location name is
	 * com.sap.moin.ocl.parser
	 */
	MOIN_CORE_OCL_PARSER(MOIN_CORE_OCL + ".parser", "OCL Parser"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used for the OCL Evaluator. The Location name is
	 * com.sap.moin.ocl.evaluator
	 */
	MOIN_CORE_OCL_EVALUATOR(MOIN_CORE_OCL + ".evaluator", "OCL Evaluator"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used for the OCL Impact Analyzer. The Location name is
	 * com.sap.moin.ocl.impactanalyzer
	 */
	MOIN_CORE_OCL_IA(MOIN_CORE_OCL + ".impactanalzer", "OCL Impact Analyzer"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used to trace the MOIN build functionality. The Location
	 * name - com.sap.moin.build
	 */
	MOIN_BUILD(MOIN + ".build", "Build"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used to trace the MOIN JMI class generation functionality.
	 * The Location name - com.sap.moin.build.jmi_generator
	 */
	MOIN_BUILD_JMI_GENERATOR(MOIN_BUILD + ".jmi_generator", "JMI Generator"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used for facilities. The Location name -
	 * com.sap.moin.facilities
	 */
	MOIN_FACILITIES(MOIN + ".facility", "Facility"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used for the primary facility. The Location name -
	 * com.sap.moin.fct.primary
	 */
	MOIN_FACILITIES_PRIMARY(MOIN_FACILITIES + ".primary", "Primary Facility"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used for MOIN primary DI service. The Location name -
	 * com.sap.moin.fct.primary.diservice
	 */
	MOIN_FACILITIES_DI_SERVICE(MOIN_FACILITIES_PRIMARY + ".diservice", "DI Service"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used for MOIN primary version service. The Location name -
	 * com.sap.moin.fct.primary.versionservice
	 */
	MOIN_FACILITIES_VERSION_SERVICE(MOIN_FACILITIES_PRIMARY + ".versionservice", "Version Service"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used for MOIN primary DI service. The Location name -
	 * com.sap.moin.fct.primary.dataareamanagement
	 */
	MOIN_FACILITIES_DATA_AREA_MANAGEMENT(MOIN_FACILITIES_PRIMARY + ".dataareamanagement", "Data Area Management"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used for MOIN Slim Index The Location name -
	 * com.sap.moin.fct.primary.index
	 */
	MOIN_FACILITIES_PRIMARY_INDEX(MOIN_FACILITIES_PRIMARY + ".index", "Index"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used for the MOIN-specific J2EE notification functionality
	 * (J2EE cluster notification). The Location name -
	 * com.sap.moin.fct.primary.notification
	 */
	MOIN_FACILITIES_NOTIFICATION(MOIN_FACILITIES_PRIMARY + ".notification", "Notification"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * Entry-point to MOIN persistence hierarchy in the trace configuration. The
	 * Location name - com.sap.moin.fct.primary.persistence
	 */
	MOIN_FACILITIES_PRIMARY_PERSISTENCE(MOIN_FACILITIES_PRIMARY + ".persistence", "Persistence"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * Entry-point to MOIN persistence hierarchy in the trace configuration. The
	 * Location name - com.sap.moin.fct.primary.events
	 */
	MOIN_FACILITIES_PRIMARY_EVENTS(MOIN_FACILITIES_PRIMARY + ".events", "Events"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * Entry-point to MOIN persistence hierarchy in the trace configuration. The
	 * Location name - com.sap.moin.fct.primary.events.dcs
	 */
	MOIN_FACILITIES_PRIMARY_EVENTS_DCS(MOIN_FACILITIES_PRIMARY_EVENTS + ".dcs", "DC-Changes"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * Entry-point to MOIN persistence hierarchy in the trace configuration. The
	 * Location name - com.sap.moin.fct.primary.events.partitions
	 */
	MOIN_FACILITIES_PRIMARY_EVENTS_PARTITIONS(MOIN_FACILITIES_PRIMARY_EVENTS + ".partitions", "Partition-Changes"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * Entry-point to MOIN DB-persistence hierarchy in the trace configuration.
	 * The Location name - com.sap.moin.fct.primary.persistence.db
	 */
	//MOIN_PERSISTENCE_DB( MOIN_PERSISTENCE + ".db", "Database" ),
	/**
	 * The Location used for the MOIN-specific db persistence factory
	 * functionality. The Location name -
	 * com.sap.moin.fct.primary.persistence.db.factory
	 */
	//MOIN_PERSISTENCE_DB_FACTORY( MOIN_PERSISTENCE_DB + ".factory", "Factory" ),
	/**
	 * The Location used for the MOIN-specific db persistence connection pool
	 * functionality. The Location name -
	 * com.sap.moin.fct.primary.persistence.db.connectionpool
	 */
	//MOIN_PERSISTENCE_DB_CONNECTIONPOOL( MOIN_PERSISTENCE_DB + ".connectionpool", "Connection Pool" ),
	/**
	 * The Location used for the MOIN-specific db persistence adapter. The
	 * Location name - com.sap.moin.fct.primary.persistence.db.adapter
	 */
	//MOIN_PERSISTENCE_DB_ADAPTER( MOIN_PERSISTENCE_DB + ".adapter", "Adapter" ),
	/**
	 * The Location used for the MOIN-specific filesystem persistence. The
	 * Location name - com.sap.moin.fct.primary.persistence.fs
	 */
	MOIN_FACILITIES_PRIMARY_PERSISTENCE_FS(MOIN_FACILITIES_PRIMARY_PERSISTENCE + ".fs", "File System"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used for the Development Infrastructure Store of the
	 * facility
	 */
	MOIN_FACILITIES_PRIMARY_DISTORE(MOIN_FACILITIES_PRIMARY + ".distore", "Development Infrastructure Store"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used for the facilities' job controller and its jobs
	 */
	MOIN_FACILITIES_PRIMARY_JOBS(MOIN_FACILITIES_PRIMARY + ".jobs", "Jobs"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used for MTI. The Location name - com.sap.moin.mti
	 */
	MOIN_MTI(MOIN + ".mti", "Transformations"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used for MTI Parser. The Location name -
	 * com.sap.moin.mti.parser
	 */
	MOIN_MTI_PARSER(MOIN_MTI + ".parser", "Parser"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used for MTI Kernel. The Location name -
	 * com.sap.moin.mti.m2m
	 */
	MOIN_MTI_KERNEL(MOIN_MTI + ".kernel", "Kernel"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used for MTI M2M. The Location name - com.sap.moin.mti.m2m
	 */
	MOIN_MTI_M2M(MOIN_MTI + ".m2m", "Model-To-Model"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used for MQL. The Location name - com.sap.moin.query
	 */
	MOIN_QUERY(MOIN + ".query", "Model Query Language"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used for MQL-based querying. The Location name -
	 * com.sap.moin.query.mql
	 */
	MOIN_QUERY_MQL(MOIN_QUERY + ".mql", "MQL"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used for BQL-based memory querying. The Location name -
	 * com.sap.moin.query.bql_mem
	 */
	MOIN_QUERY_FQL_MEMORY(MOIN_QUERY + ".fql.mem", "Memory"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used for BQL-based PF querying. The Location name -
	 * com.sap.moin.query.bql_pf
	 */
	MOIN_QUERY_FQL(MOIN_QUERY + ".fql", "FQL"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used for the MOIN-specific runtime host functionality. The
	 * Location name - com.sap.moin.runtimehost
	 */
	MOIN_RUNTIMHOST(MOIN + ".runtimehost", "Runtime Host"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used for the MOIN-specific meta-model handling, e.g.
	 * meta-model deployment, etc. The Location name - com.sap.moin.metamodels
	 */
	MOIN_METAMODELS(MOIN + ".metamodels", "Metamodel Handling"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used for the MOIN-specific deployment functionality. The
	 * Location name - com.sap.moin.metamodels
	 */
	MOIN_DATA_AREA(MOIN + ".data_areas", "Data Areas"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used for MOIN test. The Location name - com.sap.moin.test
	 */
	MOIN_TEST(MOIN + ".test", "Test"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used for the Custom Parser / Serializer functionality. The
	 * Location name - com.sap.moin.cps
	 */
	MOIN_CPS(MOIN + ".cps", "Custom Parser / Serializer"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used for the MOIN Java Server DI-Adapter. The Location name
	 * - com.sap.moin.js.diadapter
	 */
	MOIN_JS_DI_ADAPTER(MOIN + ".js.diadapter", "DI Adapter"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used for the MOIN Java Server Administration. The Location
	 * name - com.sap.moin..js.admin
	 */
	MOIN_JS_ADMIN(MOIN + ".js.admin", "Java Server Administration"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used for the MOIN Java Server Job Administration. The
	 * Location name - com.sap.moin..js.admin.jobs
	 */
	MOIN_JS_ADMIN_JOBS(MOIN + ".js.admin.jobs", "Java Server Job Administration"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used for the MOIN XML Mapping. The Location name -
	 * com.sap.moin.xm
	 */
	MOIN_XM(MOIN + ".xm", "XML Mapping"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used for the MOIN XML Mapping Generation. The Location name
	 * - com.sap.moin.xm.gen
	 */
	MOIN_XM_GEN(MOIN_XM + ".gen", "Generation"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used for the MOIN XML Mapping Runtime. The Location name -
	 * com.sap.moin.xm.rt
	 */
	MOIN_XM_RT(MOIN_XM + ".rt", "Runtime"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The Location used for the MOIN S2X Serializer. The Location name -
	 * com.sap.moin.s2x
	 */
	MOIN_S2X(MOIN + ".s2x", "S2X Serialization"); //$NON-NLS-1$ //$NON-NLS-2$

	private final String locationName;

	private final String locationDescription;

	private LocationEnum(String locationName, String locationDescription) {

		this.locationName = locationName;
		this.locationDescription = locationDescription;
	}

	public String getLocationName() {

		return this.locationName;
	}

	public String getLocationDescription() {

		return this.locationDescription;
	}

	@Override
	public String toString() {

		return this.locationName;
	}
}