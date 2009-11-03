package com.sap.tc.moin.repository.jmigenerator.template.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.core.jmi.reflect.RefClassWrapperImpl;
import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorBaseTemplate;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassOperation;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorInterfaceTemplate;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorClassWrapper;

/**
 * The Class proxy wrapper
 */
public class JmiGeneratorClassProxyWrapperTemplateImpl extends JmiGeneratorBaseWrapperTemplateImpl {

    private final JmiGeneratorClassWrapper myClassWrapper;

    /**
     * @param wrapper
     */
    public JmiGeneratorClassProxyWrapperTemplateImpl( JmiGeneratorClassWrapper wrapper ) {

        super( wrapper, JmiGenerationKind.WRAPPER );
        this.myClassWrapper = wrapper;
    }

    @Override
    public String getJavaName( ) {

        return this.myClassWrapper.getJavaProxyClassName( this.genKind, false );
    }

    public JmiGeneratorInterfaceTemplate getInterface( ) {

        return (JmiGeneratorClassProxyInterfaceTemplateImpl) this.myClassWrapper.getJavaTemplate( JmiGenerationKind.INTERFACE, "ClassProxyInterface" ); //$NON-NLS-1$
    }

    @Override
    public List<String> getImplements( ) {

        String interfaceType = getInterfaceType( );

        List<String> result = new ArrayList<String>( );
        result.add( interfaceType );
        result.add( "com.sap.tc.moin.repository.Partitionable" ); //$NON-NLS-1$

        return result;
    }

    @Override
    public List<String> getExtends( ) {

        List<String> result = new ArrayList<String>( );
        String implementationType = getImplementation( ).getPackageName( ) + "." + getImplementation( ).getJavaName( ); //$NON-NLS-1$
        result.add( RefClassWrapperImpl.class.getName( ) + "<" + implementationType + ">" ); //$NON-NLS-1$  //$NON-NLS-2$
        return result;
    }

    public JmiGeneratorBaseTemplate getImplementation( ) {

        return this.myClassWrapper.getJavaTemplate( JmiGenerationKind.CLASS, "ClassProxyImpl" ); //$NON-NLS-1$
    }

    public List<JmiGeneratorClassOperation> getInternalModeledOperations( ) {

        return this.myClassWrapper.getInternalModeledOperations( this.genKind, true );
    }

    public List<JmiGeneratorClassOperation> getOperations( ) {

        return this.myClassWrapper.getOperations( this.genKind, true );
    }

    public List<String> getOperationIds( ) {

        return this.myClassWrapper.getOperationIds( this.genKind, true );
    }

    public String getMetaObjectToString( ) {

        return myClassWrapper.getJavaProxyClassName( JmiGenerationKind.INTERFACE, true ) + " (Java Type)\\n" + myClassWrapper.getQualifiedNameDotSeparated( ) + " (MOF Type)"; //$NON-NLS-1$  //$NON-NLS-2$
    }
}
