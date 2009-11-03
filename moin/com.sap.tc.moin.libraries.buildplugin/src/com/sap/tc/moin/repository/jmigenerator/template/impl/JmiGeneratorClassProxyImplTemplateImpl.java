package com.sap.tc.moin.repository.jmigenerator.template.impl;

import java.util.List;

import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorAttributeDeclaration;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorBaseTemplate;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassImplTemplate;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassOperation;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassProxyImplTemplate;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassProxyInterfaceTemplate;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorFeature;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorParameter;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorTypedElementInitialization;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorClassWrapper;
import com.sap.tc.moin.repository.shared.util.Utilities;

/**
 * The Class Proxy implementation
 */
public class JmiGeneratorClassProxyImplTemplateImpl extends JmiGeneratorBaseTemplateImpl implements JmiGeneratorClassProxyImplTemplate {

    private final JmiGeneratorClassWrapper myClassWrapper;

    /**
     * @param wrapper
     */
    public JmiGeneratorClassProxyImplTemplateImpl( JmiGeneratorClassWrapper wrapper ) {

        super( wrapper, JmiGenerationKind.CLASS );
        this.myClassWrapper = wrapper;
    }

    @Override
    public String getJavaName( ) {

        return this.myClassWrapper.getJavaProxyClassName( this.genKind, false );
    }

    public List<JmiGeneratorAttributeDeclaration> getAttributeDeclarations( ) {

        return this.myClassWrapper.getAttributeDeclarations( this.genKind, true );
    }

    public List<JmiGeneratorTypedElementInitialization> getAttributeInitializations( ) {

        return this.myClassWrapper.getAttributeInitializations( this.genKind, true );
    }

    public List<JmiGeneratorClassOperation> getConstructors( ) {

        return this.myClassWrapper.getClassConstructors( this.genKind );
    }

    public JmiGeneratorClassImplTemplate getClassImpl( ) {

        return (JmiGeneratorClassImplTemplate) this.myClassWrapper.getJavaTemplate( JmiGenerationKind.CLASS, "ClassImpl" ); //$NON-NLS-1$
    }

    public JmiGeneratorClassProxyInterfaceTemplate getInterface( ) {

        return (JmiGeneratorClassProxyInterfaceTemplateImpl) this.myClassWrapper.getJavaTemplate( JmiGenerationKind.INTERFACE, "ClassProxyInterface" ); //$NON-NLS-1$
    }

    @Override
    public List<String> getExtends( ) {

        return this.myClassWrapper.getExtends( this.genKind, true, true );
    }

    @Override
    public List<String> getImplements( ) {

        return this.myClassWrapper.getImplements( this.genKind, true, true );
    }

    public List<JmiGeneratorFeature> getFeatures( ) {

        return this.myClassWrapper.getFeatures( JmiGenerationKind.CLASS, true );
    }

    public List<JmiGeneratorFeature> getInternalSetterFeatures( ) {

        return this.myClassWrapper.getInternalSetterFeatures( this.genKind, true );
    }

    public List<JmiGeneratorClassOperation> getInternalModeledOperations( ) {

        return this.myClassWrapper.getInternalModeledOperations( this.genKind, true );
    }

    public List<String> getFeatureIds( ) {

        return this.myClassWrapper.getFeatureIds( this.genKind, true );
    }

    public List<String> getOperationIds( ) {

        return this.myClassWrapper.getOperationIds( this.genKind, true );
    }

    public int getFeatureIdsMapCapacity( ) {

        return Utilities.calcInitialCapacity( getFeatureIds( ).size( ) );
    }

    public List<JmiGeneratorClassOperation> getAttributeOperations( ) {

        return this.myClassWrapper.getAttributeOperations( this.genKind, true );
    }

    public List<JmiGeneratorClassOperation> getOperations( ) {

        return this.myClassWrapper.getOperations( this.genKind, true );
    }

    public List<JmiGeneratorClassOperation> getStructureTypes( ) {

        return this.myClassWrapper.getStructureTypes( this.genKind );
    }

    public List<JmiGeneratorParameter> getStructs( ) {

        return this.myClassWrapper.getStructs( this.genKind );
    }

    public List<JmiGeneratorParameter> getEnums( ) {

        return this.myClassWrapper.getEnums( this.genKind );
    }

    public Boolean isSingleton( ) {

        return this.myClassWrapper.isSingleton( );
    }

    public Boolean isAbstract( ) {

        return this.myClassWrapper.isAbstract( );
    }

    public JmiGeneratorBaseTemplate getWrapper( ) {

        return this.myClassWrapper.getJavaTemplate( JmiGenerationKind.WRAPPER, "ClassProxyWrapper" ); //$NON-NLS-1$
    }

}
