package com.sap.tc.moin.repository.metamodels;

import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * The DeploymentExtension interface defines an entry-point to MOIN metamodel
 * archives.
 * <p>
 * The MOIN metamodel is registered during the MOIN startup in MOIN Runtime
 * Host. The registration is using a scenario-dependent registration mechanism,
 * e.g. in the Eclipse scenario using the Eclipse extension mechanism. The
 * DeploymentExtension interface defines the methods that has to be implemented
 * by all MOIN metamodel extension classes - classes that are used to
 * communicate between MOIN (e.g. Runtime Host) and particular MOIN metamodel.
 * This provided by DeploymnetExtension functionality is used during MOIN
 * startup by the Moin Runtime Host to obtain the list of registered Moin
 * metamodels, check the metamodel version, deploy automatically metamodels in
 * MOIN repository and obtain the provided JMI classes.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface DeploymentExtension {

    /**
     * Returns the mapping between MOF ID and full qualified JMI class name.
     * 
     * @return Map<String, String> - the mapping between MOF ID and JMI class
     * name.
     */
    public Map<String, String> getMofIDClassNameMapping( );

    /**
     * Returns the mapping between model element name and full qualified JMI
     * class name.
     * 
     * @return Map<String, String> - the mapping between model element name and
     * JMI class name.
     */
    public Map<String, String> getNameClassNameMapping( );

    /**
     * Returns the mapping between types and their super types.
     * 
     * @return Map<String, String> - mapping between types and their super
     * types.
     */
    public Map<String, Set<String>> getTypeToSupertypeMapping( );


    /**
     * Returns a list of contained model element's MOF IDs.
     * 
     * @return List<String> - the list containing the MOF ID of particular model
     * elements.
     */
    public java.util.List<java.lang.String> getMofIdsOfContainedModelElements( );

    /**
     * Returns the class object of the requested JMI class.
     * 
     * @param className name of JMI class.
     * @return instance of JMI class.
     * @throws ClassNotFoundException is thrown if the metamodel archive is
     * available but the JMI class can not be instantiated.
     */
    @SuppressWarnings( "unchecked" )
    public Class getJmiClass( String className ) throws ClassNotFoundException;

    /**
     * Returns the current version of the MOIN metamodel.
     * 
     * @return metamodel version
     */
    public String getVersion( );

    /**
     * Returns the MOIN core version.
     * <p>
     * This version is the version of the MOIN core that was used generate
     * particular metamodel (generation of the JMI classes). The MOIN metamodel
     * can only be deployed in MOIN repository if the metamodel MOIN core
     * version is identical (the major part of the version) with the MOIN core
     * version of the currently running MOIN repository.
     * 
     * @return MOIN core version.
     */
    public com.sap.tc.moin.repository.Version getCoreRuntimeVersion( );

    /**
     * Returns the mapping between MOF ID and full qualified name.
     * 
     * @return Map<String, List<String>> - mapping between MOF ID and full
     * qualified name.
     */
    public Map<String, List<String>> getMofIdQualifiedNameMapping( );
}
