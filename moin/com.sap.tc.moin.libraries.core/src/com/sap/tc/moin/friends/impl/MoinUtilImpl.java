package com.sap.tc.moin.friends.impl;

import java.lang.reflect.Field;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Namespace;

import com.sap.tc.moin.friends.MoinUtil;
import com.sap.tc.moin.repository.core.AbstractConnectionAwareWrapper;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor;
import com.sap.tc.moin.repository.shared.util.Utilities;

/**
 * @see MoinUtil
 */
public class MoinUtilImpl implements MoinUtil {

    /**
     * @see MoinUtil#isCalculatedMofId(String)
     */
    public boolean isCalculatedMofId( String mofId ) {

        return Utilities.isExternallyCalculatedMofId( mofId );
    }

    public ClassDescriptor<?, ?> getClassDescriptor( MofClass mofClass ) {

        AbstractConnectionAwareWrapper<MofClass> wrapper = (AbstractConnectionAwareWrapper<MofClass>) mofClass;
        CoreConnection connection = wrapper.getCoreConnection( );
        MofClass unwrappedMofClass = wrapper.unwrap( );
        Class clazz;
        try {
            clazz = connection.getSession( ).getMoin( ).getJmiClassResolver( ).getClass( unwrappedMofClass );
        } catch ( ClassNotFoundException e ) {
            throw new RuntimeException( e );
        }

        Field fld = null;
        ClassDescriptor classDescriptor = null;
        if ( clazz != null ) {
            try {
                fld = clazz.getField( "CLASS_DESCRIPTOR" ); //$NON-NLS-1$
                classDescriptor = (ClassDescriptor) fld.get( null );
            } catch ( Exception e ) {
                throw new RuntimeException( e );
            }
        }

        return classDescriptor;
    }

    public String getJmiInterfaceName( Namespace namespace ) {

        AbstractConnectionAwareWrapper<Namespace> wrapper = (AbstractConnectionAwareWrapper<Namespace>) namespace;
        CoreConnection connection = wrapper.getCoreConnection( );
        Namespace unwrappedNamespace = wrapper.unwrap( );
        return connection.getCoreJmiHelper( ).getJmiInterfaceName( connection, unwrappedNamespace );
    }

    public String getJmiPackageName( MofPackage mofPackage ) {

        AbstractConnectionAwareWrapper<MofPackage> wrapper = (AbstractConnectionAwareWrapper<MofPackage>) mofPackage;
        CoreConnection connection = wrapper.getCoreConnection( );
        MofPackage unwrappedPackage = wrapper.unwrap( );
        return connection.getCoreJmiHelper( ).getJmiPackageName( connection, unwrappedPackage );
    }
}
