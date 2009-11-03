package com.sap.tc.moin.repository.jmigenerator.template;

import java.util.List;
import java.util.Map;

/**
 * The Metamodel Information Provider template
 */
public interface JmiGeneratorDeploymentExtensionTemplate extends JmiGeneratorImplTemplate {

    /**
     * @return the Generator Version
     */
    public String getVersion( );

    /**
     * @return the implementation classes in this meta model
     */
    public List<String> getImplementations( );

    /**
     * @return maps MOFIDs to fully qualified implementation class names
     */
    public Map<String, String> getMofIdImplementationMap( );

    /**
     * @return maps fully qualified ModelElement names to fully qualified
     * implementation class names
     */
    public Map<String, String> getNameImplementationMap( );

    /**
     * @return the coding for the MOFID-to-QualifiedName mapping
     */
    public String getMofIdQualifiedNameMapping( );

    /**
     * @return the coding for the MOFID-to-ImmediateCompositeMOFID mapping
     */
    public String getMofIdImmediateCompositeMofIdMapping( );
}
