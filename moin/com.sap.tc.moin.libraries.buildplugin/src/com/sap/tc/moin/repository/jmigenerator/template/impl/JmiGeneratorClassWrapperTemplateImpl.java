package com.sap.tc.moin.repository.jmigenerator.template.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectWrapperImpl;
import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorBaseTemplate;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassInterfaceTemplate;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassOperation;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorInterfaceTemplate;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorClassWrapper;

/**
 * The Class wrapper
 */
public class JmiGeneratorClassWrapperTemplateImpl extends JmiGeneratorBaseWrapperTemplateImpl {

    private final JmiGeneratorClassWrapper myClassWrapper;

    /**
     * @param wrapper
     */
    public JmiGeneratorClassWrapperTemplateImpl( JmiGeneratorClassWrapper wrapper ) {

        super( wrapper, JmiGenerationKind.WRAPPER );
        this.myClassWrapper = wrapper;
    }

    public JmiGeneratorInterfaceTemplate getInterface( ) {

        return (JmiGeneratorClassInterfaceTemplate) this.myClassWrapper.getJavaTemplate( JmiGenerationKind.INTERFACE, "ClassInterface" ); //$NON-NLS-1$
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
        result.add( RefObjectWrapperImpl.class.getName( ) + "<" + implementationType + ">" ); //$NON-NLS-1$  //$NON-NLS-2$
        return result;
    }

    public JmiGeneratorBaseTemplate getImplementation( ) {

        return this.myClassWrapper.getJavaTemplate( JmiGenerationKind.CLASS, "ClassImpl" ); //$NON-NLS-1$
    }

    public List<JmiGeneratorClassOperation> getInternalModeledOperations( ) {

        return this.myClassWrapper.getInternalModeledOperations( this.genKind, false );
    }

    public List<JmiGeneratorClassOperation> getOperations( ) {

        return this.myClassWrapper.getOperations( this.genKind, false );
    }

    public List<String> getOperationIds( ) {

        return this.myClassWrapper.getOperationIds( this.genKind, false );
    }

    public String getMetaObjectToString( ) {

        return myClassWrapper.getJavaClassName( JmiGenerationKind.INTERFACE, true ) + " (Java Type)\\n" + myClassWrapper.getQualifiedNameDotSeparated( ) + " (MOF Type)"; //$NON-NLS-1$  //$NON-NLS-2$
    }
}
