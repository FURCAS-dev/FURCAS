package com.sap.tc.moin.repository.jmigenerator.template.impl;

import java.util.List;

import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassOperation;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorConstant;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorDescriptorConstant;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorPackageFeature;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorPackageInterfaceTemplate;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorPackageWrapper;

/**
 * The package interface
 */
public class JmiGeneratorPackageInterfaceTemplateImpl extends JmiGeneratorBaseTemplateImpl implements JmiGeneratorPackageInterfaceTemplate {

    protected final JmiGeneratorPackageWrapper myPackageWrapper;

    /**
     * @param wrapper
     */
    public JmiGeneratorPackageInterfaceTemplateImpl( JmiGeneratorPackageWrapper wrapper ) {

        super( wrapper, JmiGenerationKind.INTERFACE );
        this.myPackageWrapper = wrapper;
    }

    public JmiGeneratorDescriptorConstant getPackageExtentDescriptorConstant( ) {

        return this.myPackageWrapper.getPackageExtentDescriptorConstant( );
    }

    public List<JmiGeneratorConstant> getConstants( ) {

        return this.myPackageWrapper.getConstants( this.genKind );
    }

    public List<JmiGeneratorPackageFeature> getRefAssociations( ) {

        return this.myPackageWrapper.getRefAssociations( );
    }

    public List<JmiGeneratorPackageFeature> getRefClasses( ) {

        return this.myPackageWrapper.getRefClasses( this.genKind );
    }

    public List<JmiGeneratorPackageFeature> getRefPackages( ) {

        return this.myPackageWrapper.getRefPackages( );
    }

    public List<JmiGeneratorClassOperation> getStructureTypes( ) {

        return this.myPackageWrapper.getStructureTypes( this.genKind );
    }

    public boolean isInterface( ) {

        return true;
    }
}
