package com.sap.tc.moin.repository.ide.metamodels;

/**
 * The MOIN metamodel deployment status:
 * <p>
 * UKNOWN - the metamodel deployment status can not be determined, e.g. some
 * MOIN problems prevent the metamodel deployment check.
 * <p>
 * VERSION_DIFFER - the metamodel is already deployed in MOIN repository but its
 * version is differ form the metamodel definition in the Eclipse plug-in (see
 * the version in the MOIN metamodel description file - metamodel.properties).
 * <p>
 * ERROR_NOT_DEPLOYABLE - the metamodel not deployable in MOIN repository, e.g.
 * wrong metamodel description, etc. For more information see the MOIN error
 * log.
 * <p>
 * NOT_DEPLOYED - the metamodel already not deployed.
 * <p>
 * DEPLOYED - the metamodel already deployed.
 * 
 * @author d029324
 */
public enum MmDeploymentStatus {
	/**
	 * UKNOWN - the metamodel deployment status can not be determined, e.g. some
	 * MOIN problems prevent the metamodel deployment check.
	 */
    UNKNOWN,
    /**
     * VERSION_DIFFER - the metamodel is already deployed in MOIN repository but its
     * version is differ form the metamodel definition in the Eclipse plug-in (see
     * the version in the MOIN metamodel description file - metamodel.properties).
     */
    VERSION_DIFFER, 
    /**
     * ERROR_NOT_DEPLOYABLE - the metamodel not deployable in MOIN repository, e.g.
     * wrong metamodel description, etc. For more information see the MOIN error
 	 * log.
     */
    ERROR_NOT_DEPLOYABLE, 
    /**
     * NOT_DEPLOYED - the metamodel already not deployed.
     */
    NOT_DEPLOYED,
    /**
     * DEPLOYED - the metamodel already deployed.
     */
    DEPLOYED;
}
