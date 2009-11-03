package com.sap.tc.moin.repository.runtimehost.build;

import com.sap.tc.moin.facility.primary.build.BuildPrimaryFacilityImpl;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.cdam.CompoundDataAreaManagerImpl;
import com.sap.tc.moin.repository.filesystem.AbstractMoinFactory;
import com.sap.tc.moin.repository.filesystem.FileSystemRuntimeHost;
import com.sap.tc.moin.repository.spi.cdam.SpiCompoundDataAreaManager;
import com.sap.tc.moin.repository.spi.cdam.SpiCompoundDataAreaManagerFactory;
import com.sap.tc.moin.repository.spi.core.SpiCore;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;
import com.sap.tc.moin.repository.spi.facility.SpiFacilityFactory;
import com.sap.tc.moin.repository.spi.runtimehost.context.SpiRuntimeContext;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;

/**
 * Factory implementation for the build scenario.
 * <p>
 * Clients get access to MOIN through the one of static
 * {@link #getMoinInstance()} method.
 */
public class MoinFactory extends AbstractMoinFactory {

    private MoinFactory( ) {

        // singleton
    }

//
//    private static BuildRuntimeHostImpl _moinRuntimeHost = null;
//
//    /**
//     * Returns the running MOIN instance.
//     * <p>
//     * The method returns the currently running MOIN instance. If MOIN is not
//     * running, a new MOIN instance is started.
//     * 
//     * @return running MOIN instance.
//     */
//    public static Moin getMoinInstance( ) {
//
//        return getRuntimeHost( ).getMoinInstance( null );
//    }

    /**
     * Returns the running MOIN instance.
     * <p>
     * The method returns the currently running MOIN instance. If MOIN is not
     * running, a new MOIN instance is started.
     * 
     * @param metamodelJars the list of jars that contains the definition of
     * MOIN metamodels.
     * @return running MOIN instance.
     */
    public static Moin getMoinInstance( String[] metamodelJars ) {

        return AbstractMoinFactory.startup( //
                                            metamodelJars, new SpiFacilityFactory( ) {

                                                public SpiFacility getFacility( SpiCore core, SpiPartitionSerializationManager serializationManager, SpiRuntimeContext runtimeContext ) {

                                                    return new BuildPrimaryFacilityImpl( core, serializationManager, runtimeContext );
                                                }
                                            }, new SpiCompoundDataAreaManagerFactory( ) {

                                                public SpiCompoundDataAreaManager getCompoundDataAreaManager( SpiCore moin ) {

                                                    return new CompoundDataAreaManagerImpl( );
                                                }

                                            } );
    }

    // API for ant plugin
    public static FileSystemRuntimeHost createRTH( ) {

        return AbstractMoinFactory.createRTH( );
    }

    public static Moin getMoinInstance( FileSystemRuntimeHost rth, String[] metamodelJars ) {

        return AbstractMoinFactory.startup( rth, metamodelJars, new SpiFacilityFactory( ) {

            public SpiFacility getFacility( SpiCore core, SpiPartitionSerializationManager serializationManager, SpiRuntimeContext runtimeContext ) {

                return new BuildPrimaryFacilityImpl( core, serializationManager, runtimeContext );
            }
        }, new SpiCompoundDataAreaManagerFactory( ) {

            public SpiCompoundDataAreaManager getCompoundDataAreaManager( SpiCore moin ) {

                return new CompoundDataAreaManagerImpl( );
            }
        } );
    }

}
