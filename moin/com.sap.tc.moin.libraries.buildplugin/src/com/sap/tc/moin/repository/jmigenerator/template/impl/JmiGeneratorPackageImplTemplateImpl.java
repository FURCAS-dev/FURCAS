package com.sap.tc.moin.repository.jmigenerator.template.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorBaseTemplate;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassOperation;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorFeature;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorPackageFeature;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorPackageImplTemplate;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorPackageInterfaceTemplate;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorParameter;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorPackageWrapper;
import com.sap.tc.moin.repository.shared.util.Utilities;

/**
 * The Package implementation
 */
public class JmiGeneratorPackageImplTemplateImpl extends JmiGeneratorBaseTemplateImpl implements JmiGeneratorPackageImplTemplate {

    private final JmiGeneratorPackageWrapper myPackageWrapper;

    /**
     * @param proxy
     */
    public JmiGeneratorPackageImplTemplateImpl( JmiGeneratorPackageWrapper proxy ) {

        super( proxy, JmiGenerationKind.CLASS );
        this.myPackageWrapper = proxy;
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

    public List<String> getFeatureIds( ) {

        List<String> result = new ArrayList<String>( );
        for ( JmiGeneratorFeature feature : this.getFeatures( ) ) {
            result.add( feature.getName( ) );
        }
        return result;
    }

    public int getFeatureIdsMapCapacity( ) {

        return Utilities.calcInitialCapacity( getFeatureIds( ).size( ) );
    }

    public List<JmiGeneratorPackageFeature> getFeatures( ) {

        return this.myPackageWrapper.getFeatures( this.genKind );
    }

    public JmiGeneratorPackageInterfaceTemplate getInterface( ) {

        return (JmiGeneratorPackageInterfaceTemplate) this.myPackageWrapper.getJavaTemplate( JmiGenerationKind.INTERFACE, "" ); //$NON-NLS-1$
    }

    public List<JmiGeneratorClassOperation> getStructureTypes( ) {

        return this.myPackageWrapper.getStructureTypes( this.genKind );
    }

    public List<JmiGeneratorParameter> getEnums( ) {

        return this.myPackageWrapper.getEnums( this.genKind );
    }

    public List<JmiGeneratorParameter> getStructs( ) {

        return this.myPackageWrapper.getStructs( this.genKind );
    }

    public JmiGeneratorBaseTemplate getWrapper( ) {

        return this.myPackageWrapper.getJavaTemplate( JmiGenerationKind.WRAPPER, "PackageWrapper" ); //$NON-NLS-1$
    }
}
