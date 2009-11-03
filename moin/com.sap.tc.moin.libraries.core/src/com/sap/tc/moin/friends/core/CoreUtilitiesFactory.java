package com.sap.tc.moin.friends.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.sap.tc.moin.friends.ConnectionUtil;
import com.sap.tc.moin.friends.MetaModelChecker;
import com.sap.tc.moin.friends.ModelElementNameGenerator;
import com.sap.tc.moin.friends.MoinUtil;
import com.sap.tc.moin.friends.RefObjectUtil;
import com.sap.tc.moin.repository.exception.MoinBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

public class CoreUtilitiesFactory {

    /*
     * MetaModelChecker
     */
    private static MetaModelChecker metaModelChecker = null;

    synchronized public static MetaModelChecker getMetaModelChecker( ) throws MoinBaseRuntimeException {

        if ( metaModelChecker == null ) {
            metaModelChecker = (MetaModelChecker) getImpl( "com.sap.tc.moin.friends.impl.MetaModelCheckerImpl" ); //$NON-NLS-1$
        }
        return metaModelChecker;
    }

    /*
     * ModelElementNameGenerator
     */
    private static ModelElementNameGenerator modelElementNameGenerator = null;

    synchronized public static ModelElementNameGenerator getModelElementNameGenerator( ) throws MoinBaseRuntimeException {

        if ( modelElementNameGenerator == null ) {
            modelElementNameGenerator = (ModelElementNameGenerator) getImpl( "com.sap.tc.moin.friends.impl.ModelElementNameGeneratorImpl" ); //$NON-NLS-1$
        }
        return modelElementNameGenerator;
    }

    /*
     * ConnectionUtil
     */
    private static ConnectionUtil connectionUtil = null;

    synchronized public static ConnectionUtil getConnectionUtil( ) throws MoinBaseRuntimeException {

        if ( connectionUtil == null ) {
            connectionUtil = (ConnectionUtil) getImpl( "com.sap.tc.moin.friends.impl.ConnectionUtilImpl" ); //$NON-NLS-1$
        }
        return connectionUtil;
    }

    /*
     * RefObjectUtil
     */
    private static RefObjectUtil refObjectUtil = null;

    public static RefObjectUtil getRefObjectUtil( ) throws MoinBaseRuntimeException {

        if ( refObjectUtil == null ) {
            refObjectUtil = (RefObjectUtil) getImpl( "com.sap.tc.moin.friends.impl.RefObjectUtilImpl" ); //$NON-NLS-1$
        }
        return refObjectUtil;
    }

    /*
     * MoinUtil
     */
    private static MoinUtil moinUtil = null;

    public static MoinUtil getMoinUtil( ) throws MoinBaseRuntimeException {

        if ( moinUtil == null ) {
            moinUtil = (MoinUtil) getImpl( "com.sap.tc.moin.friends.impl.MoinUtilImpl" ); //$NON-NLS-1$
        }
        return moinUtil;
    }

    /*
     * INTERNAL HELPER METHODS
     */
    private static Object getImpl( String implClass ) throws MoinBaseRuntimeException {

        MoinLocalizedString message = CoreUtilitiesFactoryMessages.FAILEDGETIMPLEMENTATION;
        try {
            Class<?> clazz = Class.forName( implClass );
            Constructor<?> myConstructor = clazz.getConstructor( );
            Object myInstance = myConstructor.newInstance( );
            return myInstance;
        } catch ( SecurityException e ) {
            throw new MoinLocalizedBaseRuntimeException( e, message );
        } catch ( IllegalArgumentException e ) {
            throw new MoinLocalizedBaseRuntimeException( e, message );
        } catch ( ClassNotFoundException e ) {
            throw new MoinLocalizedBaseRuntimeException( e, message );
        } catch ( NoSuchMethodException e ) {
            throw new MoinLocalizedBaseRuntimeException( e, message );
        } catch ( InstantiationException e ) {
            throw new MoinLocalizedBaseRuntimeException( e, message );
        } catch ( IllegalAccessException e ) {
            throw new MoinLocalizedBaseRuntimeException( e, message );
        } catch ( InvocationTargetException e ) {
            throw new MoinLocalizedBaseRuntimeException( e, message );
        }
    }

}
