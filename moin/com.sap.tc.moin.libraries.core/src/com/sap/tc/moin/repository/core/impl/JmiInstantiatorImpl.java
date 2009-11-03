package com.sap.tc.moin.repository.core.impl;

import java.lang.reflect.InvocationTargetException;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.Extent;
import com.sap.tc.moin.repository.core.JmiInstantiationException;
import com.sap.tc.moin.repository.core.JmiInstantiator;
import com.sap.tc.moin.repository.core.MetamodelWorkspace;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.jmi.extension.RefObjectExtension;
import com.sap.tc.moin.repository.core.jmi.extension.RefPackageExtension;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.spi.core.SpiModelPartition;

public class JmiInstantiatorImpl implements JmiInstantiator {

    private static final Class[] NO_PARAMETERS_TYPE = new Class[] {};

    private static final Object[] EMPTY_PARAMETER_LIST = new Object[] {};

    /***************************************************************************
     * mandatory attributes which need to be set
     **************************************************************************/

    private Workspace workspace;

    /***************************************************************************
     * constructors
     **************************************************************************/

    public JmiInstantiatorImpl( Workspace workspace ) {

        this.workspace = workspace;
    }

    /***************************************************************************
     * other methods
     **************************************************************************/

    public RefPackage createRefPackage( String mofId, RefPackage immediatePackage, MofPackage mofPackage ) {

        Class jc;
        try {
            jc = workspace.getWorkspaceSet( ).getMoin( ).getJmiClassResolver( ).getClass( mofPackage );
        } catch ( ClassNotFoundException e ) {
            throw new JmiInstantiationException( e );
        }
        assertClassNotNull( jc, mofPackage );
        RefPackageExtension rp = (RefPackageExtension) createInstance( jc );
        rp.set___MofId( mofId );
        rp.set___Workspace( workspace );
        rp.set___PartitionAssignment( workspace.getPartitionManager( ).getExtentPartition( ) );
        ( (MetamodelWorkspace) workspace ).getInstanceManager( ).injectInstance( rp );
        rp.set___MetaObject( mofPackage );
        rp.set___ImmediatePackage( immediatePackage );
        ( (RefObjectExtension) mofPackage ).set___Extent( (Extent) rp );
        return rp;
    }

    /**
     * Asserts that the clazz handed in is not null. Throws RuntimeException if
     * clazz is null. Used in the various createRefXXX operation to avoid
     * NullPointerException and improve error tracing.
     * 
     * @param clazz clazz to be checked for null
     * @param element element for which the class must not be null. Used for
     * error report details
     */
    private void assertClassNotNull( Class clazz, Object element ) {

        if ( clazz == null ) {
            throw new MoinLocalizedBaseRuntimeException( CoreImplMessages.NOJAVACLASSFOUNDFORELEMENT, element.toString( ) );
        }
    }

    public RefObject createRefObject( Connection connection, String mofId, RefPackage immediatePackage, MofClass mofClass, RefClass refClass, SpiModelPartition partition ) {

        Class jc;
        try {
            jc = workspace.getWorkspaceSet( ).getMoin( ).getJmiClassResolver( ).getClass( mofClass );
        } catch ( ClassNotFoundException e ) {
            throw new JmiInstantiationException( e );
        }
        assertClassNotNull( jc, mofClass );
        RefObjectExtension ro = (RefObjectExtension) createInstance( jc );
        ro.set___MofId( mofId );
        ro.set___RefClass( refClass );
        if ( partition != null ) {
            ( (CorePartitionable) ro ).set___PartitionAssignment( (CoreModelPartition) partition );
        }
        ro.set___Workspace( workspace );
        workspace.getInstanceManager( ).injectInstance( (CoreConnection) connection, ro );
        ro.set___MetaObject( mofClass );
        ro.set___ImmediatePackage( immediatePackage );
        return ro;
    }

    /***************************************************************************
     * private methods
     **************************************************************************/

    private Object createInstance( Class javaClass ) throws JmiInstantiationException {

        try {
            return javaClass.getConstructor( NO_PARAMETERS_TYPE ).newInstance( EMPTY_PARAMETER_LIST );
        } catch ( SecurityException e ) {
            throw new JmiInstantiationException( e );
        } catch ( IllegalArgumentException e ) {
            throw new JmiInstantiationException( e );
        } catch ( NoSuchMethodException e ) {
            throw new JmiInstantiationException( e );
        } catch ( InstantiationException e ) {
            throw new JmiInstantiationException( e );
        } catch ( IllegalAccessException e ) {
            throw new JmiInstantiationException( e );
        } catch ( InvocationTargetException e ) {
            throw new JmiInstantiationException( e );
        }
    }
}
