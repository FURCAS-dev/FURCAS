package com.sap.tc.moin.repository.jmigenerator.template;

import java.util.List;

/**
 * The Package implementation template
 */
public interface JmiGeneratorPackageImplTemplate extends JmiGeneratorImplTemplate {

    /**
     * @return the (nested) packages
     */
    public List<JmiGeneratorPackageFeature> getRefPackages( );

    /**
     * @return the classes
     */
    public List<JmiGeneratorPackageFeature> getRefClasses( );

    /**
     * @return the associations
     */
    public List<JmiGeneratorPackageFeature> getRefAssociations( );

    /**
     * @return the structure types
     */
    public List<JmiGeneratorClassOperation> getStructureTypes( );

    /**
     * @return the enumerations
     */
    public List<JmiGeneratorParameter> getEnums( );

    /**
     * @return the structures (for internal methods)
     */
    public List<JmiGeneratorParameter> getStructs( );

    /**
     * @return the features
     */
    public List<JmiGeneratorPackageFeature> getFeatures( );

    /**
     * @return the feature IDs
     */
    public List<String> getFeatureIds( );

    /**
     * @return the feature map capacity (calculated)
     */
    public int getFeatureIdsMapCapacity( );

    /**
     * @return the wrapper template
     */
    public JmiGeneratorBaseTemplate getWrapper( );
}
