package com.sap.tc.moin.repository.jmigenerator.template.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.core.jmi.reflect.RefPackageWrapperImpl;
import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorBaseTemplate;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassOperation;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorInterfaceTemplate;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorPackageWrapper;

/**
 * The Package wrapper
 */
public class JmiGeneratorPackageWrapperTemplateImpl extends JmiGeneratorBaseWrapperTemplateImpl {

    private final JmiGeneratorPackageWrapper myPackageWrapper;

    /**
     * @param wrapper
     */
    public JmiGeneratorPackageWrapperTemplateImpl( JmiGeneratorPackageWrapper wrapper ) {

        super( wrapper, JmiGenerationKind.WRAPPER );
        this.myPackageWrapper = wrapper;
    }

    public JmiGeneratorInterfaceTemplate getInterface( ) {

        return (JmiGeneratorPackageInterfaceTemplateImpl) this.myPackageWrapper.getJavaTemplate( JmiGenerationKind.INTERFACE, "PackageInterface" ); //$NON-NLS-1$
    }

    @Override
    public List<String> getImplements( ) {

        String interfaceType = getInterfaceType( );

        List<String> result = new ArrayList<String>( );
        result.add( interfaceType );
        result.add( "com.sap.tc.moin.repository.Partitionable" ); //$NON-NLS-1$

        return result;
    }

    public List<JmiGeneratorClassOperation> getInternalModeledOperations( ) {

        // not relevat for package wrapper
        return null;
    }

    public List<JmiGeneratorClassOperation> getOperations( ) {

        // not relevat for package wrapper
        return null;
    }

    public List<String> getOperationIds( ) {

        // not relevat for package wrapper
        return null;
    }

    @Override
    public List<String> getExtends( ) {

        List<String> result = new ArrayList<String>( );
        String implementationType = getImplementation( ).getPackageName( ) + "." + getImplementation( ).getJavaName( ); //$NON-NLS-1$
        result.add( RefPackageWrapperImpl.class.getName( ) + "<" + implementationType + ">" ); //$NON-NLS-1$  //$NON-NLS-2$
        return result;
    }

    public JmiGeneratorBaseTemplate getImplementation( ) {

        return this.myPackageWrapper.getJavaTemplate( JmiGenerationKind.CLASS, "PackageClass" ); //$NON-NLS-1$
    }

    public String getMetaObjectToString( ) {

        return myPackageWrapper.getJavaClassName( JmiGenerationKind.INTERFACE, true ) + " (Java Type)\\n" + myPackageWrapper.getQualifiedNameDotSeparated( ) + " (MOF Type)"; //$NON-NLS-1$  //$NON-NLS-2$
    }
}
