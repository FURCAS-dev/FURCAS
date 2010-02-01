package com.sap.tc.moin.standalone;

import com.sap.tc.moin.facility.primary.build.BuildPrimaryFacilityImpl;
import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiConfigurationProvider;
import com.sap.tc.moin.facility.primary.ipi.diservice.build.IpiBuildDiService;
import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.Facility;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.cdam.CompoundClientSpec;
import com.sap.tc.moin.repository.runtimehost.build.MoinFactory;
import com.sap.tc.moin.repository.spi.cdam.SpiCompoundDataAreaManager;
import com.sap.tc.moin.standalone.util.MoinArgumentsToolkit;

/**
 * Starts standalone moin. With the moinlet given by the -moinlet argument.
 * <p>
 * Arguments:
 * <li>-moinlet [Full qualified name of a Moinlet interface implementor]</li>
 * <li>-metaModelJars [Semicolon separated list of meta-model XMI jars to be
 * registered as meta-models]</li>
 * </p>
 * 
 * @author D046220
 */
public class StartMoin {

	
    public static void main( String[] args ) {

     //   Moin moin = MoinFactory.getMoinInstance( "facility.nwdi.standalone.fs.properties", getMetaModelJars( args ) );
        Moin moin = MoinFactory.getMoinInstance(  getMetaModelJars( args ) );

        Facility facility = moin.getFacilityById( "PF" );

        //FIXME this should not use the Build Facility, instead, it should use Standalone Facility
        IpiBuildDiService nwdiService = ( (BuildPrimaryFacilityImpl) facility ).getBuildDiService( );

        Moinlet moinlet = getMoinlet( args );

        IpiDiConfigurationProvider configurationProvider = moinlet.getDiConfigurationProvider( args );

        ClientSpec clientSpec = nwdiService.getClientSpec( configurationProvider );

        CompoundClientSpec compoundClientSpec = null;

        try {
            compoundClientSpec = ( (SpiCompoundDataAreaManager) moin.getCompoundDataAreaManager( ) ).getDefaultCompoundClientSpec( clientSpec );
        } catch ( Exception ex ) {
            throw new RuntimeException( "Could not create Client Spec: ", ex );
        }

        moinlet.execute( moin, compoundClientSpec );

    }

    private static Moinlet getMoinlet( String[] args ) {

        Moinlet ret = null;

        String moinletClass = MoinArgumentsToolkit.getArgumentValue( "-moinlet", args, "moinlet argument is required" );

        try {
            ret = (Moinlet) StartMoin.class.getClassLoader( ).loadClass( moinletClass ).newInstance( );
        } catch ( Exception e ) {
            throw new RuntimeException( e );
        }

        return ret;
    }

    private static String[] getMetaModelJars( String[] args ) {

        String argumentValue = MoinArgumentsToolkit.getArgumentValue( "-metaModelJars", args, "-metaModelJars argument has to provide a semicolon separated list of meta-model pathes.", false );
        return argumentValue == null ? null : argumentValue.split( ";" );
    }

}
