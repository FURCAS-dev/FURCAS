package com.sap.tc.moin.repository.jmigenerator.template;

import java.util.List;

/**
 * The StructureType implementation template
 */
public interface JmiGeneratorStructureTypeImplTemplate extends JmiGeneratorImplTemplate {

    /**
     * @return the features
     */
    public List<JmiGeneratorFeature> getFeatures( );

    /**
     * @return the feature IDs
     */
    public List<String> getFeatureIds( );

    /**
     * @return the attribute declarations
     */
    public List<JmiGeneratorAttributeDeclaration> getAttributeDeclarations( );

    /**
     * @return the field initializations
     */
    public List<JmiGeneratorTypedElementInitialization> getFieldInitializations( );

    /**
     * @return the fields
     */
    public List<JmiGeneratorClassOperation> getFields( );

    public String getQualifiedNameForStringArrayInitializer( );

    public List<String> getQualifiedName( );

    public String getFieldNamesForStringArrayInitializer( );

    public boolean isTranslatableText( );
}
