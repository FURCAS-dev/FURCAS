package com.sap.tc.moin.repository.jmigenerator.template;

import java.util.List;

/**
 * The class proxy implementation template
 */
public interface JmiGeneratorClassProxyImplTemplate extends JmiGeneratorImplTemplate {

    /**
     * @return the constructors
     */
    public List<JmiGeneratorClassOperation> getConstructors( );

    /**
     * @return the attribute declarations
     */
    public List<JmiGeneratorAttributeDeclaration> getAttributeDeclarations( );

    /**
     * @return the attribute initializations
     */
    public List<JmiGeneratorTypedElementInitialization> getAttributeInitializations( );

    /**
     * @return the operations
     */
    public List<JmiGeneratorClassOperation> getOperations( );

    /**
     * @return the attributes
     */
    public List<JmiGeneratorClassOperation> getAttributeOperations( );

    /**
     * @return the structure types
     */
    public List<JmiGeneratorClassOperation> getStructureTypes( );

    /**
     * @return for internal create__RefStruct constructors
     */
    public List<JmiGeneratorParameter> getStructs( );

    /**
     * @return the Enumerations
     */
    public List<JmiGeneratorParameter> getEnums( );

    /**
     * @return <code>true</code> if the class is a singleton
     */
    public Boolean isSingleton( );

    /**
     * @return <code>true</code> if the class is abstract
     */
    public Boolean isAbstract( );

    /**
     * @return the implementation template
     */
    public JmiGeneratorClassImplTemplate getClassImpl( );

    /**
     * @return the features
     */
    public List<JmiGeneratorFeature> getFeatures( );

    /**
     * @return the feature IDs
     */
    public List<String> getFeatureIds( );

    /**
     * @return the operation IDs
     */
    public List<String> getOperationIds( );

    /**
     * @return the features for which to generate internal setters
     */
    public List<JmiGeneratorFeature> getInternalSetterFeatures( );

    /**
     * @return the internal modeled operations
     */
    public List<JmiGeneratorClassOperation> getInternalModeledOperations( );

    /**
     * @return the wrapper template
     */
    public JmiGeneratorBaseTemplate getWrapper( );

    /**
     * @return the feature map size (calculate from the number of features)
     */
    public int getFeatureIdsMapCapacity( );
}
