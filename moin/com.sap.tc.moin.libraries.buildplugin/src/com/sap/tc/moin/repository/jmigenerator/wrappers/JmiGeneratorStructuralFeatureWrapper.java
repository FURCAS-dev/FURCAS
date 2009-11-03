package com.sap.tc.moin.repository.jmigenerator.wrappers;

import java.util.List;

import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.model.__impl.StructuralFeatureInternal;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorImpl;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorBaseTemplate;

/**
 * The abstract base wrapper for structural features
 */
public abstract class JmiGeneratorStructuralFeatureWrapper extends JmiGeneratorBaseWrapper {

    private final StructuralFeatureInternal wrappedFeature;

    private final Boolean isChangeable;

    private final Boolean isMultiple;

    /**
     * @param feature
     * @param parent
     * @param generator
     */
    public JmiGeneratorStructuralFeatureWrapper( CoreConnection connection, String metamodelName, StructuralFeature feature, JmiGeneratorBaseWrapper parent, JmiGeneratorImpl generator ) {

        super( connection, metamodelName, feature, parent, generator );
        this.wrappedFeature = (StructuralFeatureInternal) feature;
        this.isChangeable = true;
        boolean multiple = this.wrappedFeature.getMultiplicity( ).getUpper( ) != 1;
        this.isMultiple = Boolean.valueOf( multiple );
    }

    /**
     * @return the Java type
     */
    public abstract String getJavaType( );

    /**
     * @return the fully qualified generic Java type parameter
     */
    public String getJavaTypeParameter( ) {

        return getStructuralFeatureTypeParameter( wrappedFeature );
    }

    /**
     * @return true if the feature is changeable
     */
    public Boolean isChangeable( ) {

        return this.isChangeable;
    }

    /**
     * @return true if the feature is multi-valued
     */
    public Boolean isMultiple( ) {

        return this.isMultiple;
    }

    @Override
    public List<String> getExtends( JmiGenerationKind genKind, boolean qualified ) {

        return null;
    }

    @Override
    public List<String> getImplements( JmiGenerationKind genKind, boolean qualified ) {

        return null;
    }

    @Override
    public JmiGeneratorBaseTemplate getJavaTemplate( JmiGenerationKind genKind, String templateName ) {

        return null;
    }

    @Override
    public List<String> getTemplateNames( JmiGenerationKind genKind ) {

        return null;
    }

    @Override
    protected void initChildren( ) {

        // nothing
    }

}
