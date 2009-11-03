package com.sap.tc.moin.repository.jmigenerator.template.impl;

import java.util.List;

import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorAttributeDeclaration;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassOperation;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorFeature;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorInterfaceTemplate;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorStructureTypeImplTemplate;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorTypedElementInitialization;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorStructureTypeWrapper;

/**
 * The Structure type implementation
 */
public class JmiGeneratorStructureTypeImplTemplateImpl extends JmiGeneratorBaseTemplateImpl implements JmiGeneratorStructureTypeImplTemplate {

    private final JmiGeneratorStructureTypeWrapper myStructypeWrapper;

    /**
     * @param wrapper
     */
    public JmiGeneratorStructureTypeImplTemplateImpl( JmiGeneratorStructureTypeWrapper wrapper ) {

        super( wrapper, JmiGenerationKind.CLASS );
        this.myStructypeWrapper = wrapper;
    }

    public JmiGeneratorInterfaceTemplate getInterface( ) {

        return (JmiGeneratorInterfaceTemplate) this.myStructypeWrapper.getJavaTemplate( JmiGenerationKind.INTERFACE, "dummy" ); //$NON-NLS-1$
    }

    public List<JmiGeneratorClassOperation> getFields( ) {

        return this.myStructypeWrapper.getFields( this.genKind );
    }

    public List<JmiGeneratorFeature> getFeatures( ) {

        return this.myStructypeWrapper.getFeatures( this.genKind );
    }

    public List<JmiGeneratorAttributeDeclaration> getAttributeDeclarations( ) {

        return this.myStructypeWrapper.getAttributeDeclarations( this.genKind );
    }

    public List<JmiGeneratorTypedElementInitialization> getFieldInitializations( ) {

        return this.myStructypeWrapper.getFieldInitializations( this.genKind );
    }

    public List<String> getFeatureIds( ) {

        return this.myStructypeWrapper.getFeatureIds( this.genKind );
    }

    public String getQualifiedNameForStringArrayInitializer( ) {

        return this.myStructypeWrapper.getQualifiedNameForStringArrayInitializer( );
    }

    public List<String> getQualifiedName( ) {

        return this.myStructypeWrapper.getQualifiedName( );
    }

    public String getFieldNamesForStringArrayInitializer( ) {

        return this.myStructypeWrapper.getFieldNamesForStringArrayInitializer( );
    }

    public boolean isTranslatableText( ) {

        return this.myStructypeWrapper.isTranslatableText( );
    }
}
