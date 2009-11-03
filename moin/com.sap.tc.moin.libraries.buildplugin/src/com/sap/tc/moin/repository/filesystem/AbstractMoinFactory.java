package com.sap.tc.moin.repository.filesystem;

import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.runtimehost.filesystem.FileSystemRuntimeHostImpl;
import com.sap.tc.moin.repository.spi.cdam.SpiCompoundDataAreaManagerFactory;
import com.sap.tc.moin.repository.spi.facility.SpiFacilityFactory;

/**
 * AbstractFactory implementation for file system scenarios.
 * <p>
 * Clients get access to MOIN through the static {@link #getMoinInstance()}
 * method.
 */
public abstract class AbstractMoinFactory {

    /**
     * Returns the running MOIN instance.
     * <p>
     * The method returns the currently running MOIN instance. If MOIN is not
     * running, an exception is thrown.
     * 
     * @return running MOIN instance.
     */
    public static Moin getMoinInstance( ) {

        return getRuntimeHost( ).getMoinInstance( );
    }

    public static boolean isRunning( ) {

        return getRuntimeHost( ).isRunning( );
    }


    /**
     * Initializes a new MOIN instance.
     * <p>
     * The method initializes a new MOIN instance. If MOIN is already running,
     * an exception is thrown.
     * 
     * @param metamodelJars the list of jars that contains the definition of
     * MOIN metamodels.
     * @return running MOIN instance.
     */
    protected static Moin startup( String[] metamodelJars, SpiFacilityFactory facilityFactory, SpiCompoundDataAreaManagerFactory cdamFactory ) {

        return getRuntimeHost( ).startMoin( metamodelJars, facilityFactory, cdamFactory );
    }

    private static FileSystemRuntimeHostImpl _moinRuntimeHost = null;

    private static synchronized FileSystemRuntimeHostImpl getRuntimeHost( ) {

        if ( _moinRuntimeHost == null ) {
            _moinRuntimeHost = new FileSystemRuntimeHostImpl( );
        }
        return _moinRuntimeHost;
    }

    public static synchronized void shutDown( ) {

        if ( _moinRuntimeHost != null ) {
            _moinRuntimeHost.shutDown( );
            _moinRuntimeHost = null;
        }
    }

    protected static FileSystemRuntimeHost createRTH( ) {

        return new FileSystemRuntimeHostImpl( );
    }

    protected static Moin startup( FileSystemRuntimeHost rth, String[] metamodelJars, SpiFacilityFactory facilityFactory, SpiCompoundDataAreaManagerFactory cdamFactory ) {

        return ( (FileSystemRuntimeHostImpl) rth ).startMoin( metamodelJars, facilityFactory, cdamFactory );
    }
}
