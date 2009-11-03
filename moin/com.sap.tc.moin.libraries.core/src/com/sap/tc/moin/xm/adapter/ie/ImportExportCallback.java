package com.sap.tc.moin.xm.adapter.ie;

import java.util.HashMap;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.reflect.InvalidNameException;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.AmbiguousPackageNameException;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor;
import com.sap.tc.moin.repository.mmi.reflect.RefClassCalculatedMofId;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.xm.kernel.XmCallback;

/** Import/Export implementation of the interface XmCallBack. */
abstract class ImportExportCallback implements XmCallback<RefObject, RefClass, RefAssociation> {


    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_XM, MoinLocationEnum.MOIN_XM_RT, ImportExportCallback.class );

    private final Connection connection;

    private PRI pri;

    /** Cache for the RefPackages. */
    private final Map<String, Map<String, RefPackage>> container2RefPackageMap = new HashMap<String, Map<String, RefPackage>>( );


    /**
     * Constructor.
     * 
     * @param aConnection
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    ImportExportCallback( final Connection aConnection ) {

        if ( aConnection == null ) {
            throw new MoinNullPointerException( "aConnection" ); //$NON-NLS-1$
        }
        this.connection = aConnection;
    }

    /**
     * Sets the PRI.
     * 
     * @param aPri
     * @throws NullPointerException if <tt>aPri</tt> is <code>null</code>
     * @throws IllegalArgumentException if the model partition for the given PRI
     */
    void setPri( final PRI aPri ) {

        if ( aPri == null ) {
            throw new MoinNullPointerException( "aPri" ); //$NON-NLS-1$
        }
        this.pri = aPri;
        if ( !this.connection.partitionExists( this.pri ) ) {
            final MoinIllegalArgumentException e = new MoinIllegalArgumentException( XmIeMessages.PARTITIONNOTEXISTING, this.pri );
            LOGGER.logAndTrace( e, MoinSeverity.ERROR, XmIeMessages.PARTITIONNOTEXISTING, this.pri );
            throw e;
        }
    }

    /** Returns the MOIN connection. */
    public Connection getConnection( ) {

        return this.connection;
    }

    /**
     * Returns the PRI.
     * 
     * @return PRI
     * @throws IllegalStateException if the PRI is not set
     */
    public final PRI getPri( ) {

        if ( this.pri == null ) {
            throw new MoinIllegalStateException( XmIeMessages.PRINOTSET );
        }
        return this.pri;
    }

    public final String getInstanceMofId( final RefObject refObject ) {

        return refObject.refMofId( );
    }

    @SuppressWarnings( "unchecked" )
    public ClassDescriptor<? extends RefClass, ? extends RefObject> getType( final RefObject modelElement ) {

        if ( modelElement == null ) {
            throw new MoinNullPointerException( "modelElement" ); //$NON-NLS-1$
        }
        try {
            return (ClassDescriptor) modelElement.getClass( ).getField( "CLASS_DESCRIPTOR" ).get( modelElement ); //$NON-NLS-1$
        } catch ( final NoSuchFieldException e ) {
            LOGGER.trace( e, MoinSeverity.FATAL, XmIeMessages.FIELDMISSING, new Object[] { "CLASS_DESCRIPTOR", modelElement.getClass( ).getName( ) } ); //$NON-NLS-1$
            throw new IllegalStateException( e );
        } catch ( final IllegalAccessException e ) {
            LOGGER.trace( e, MoinSeverity.FATAL, XmIeMessages.FIELDMISSING, new Object[] { "CLASS_DESCRIPTOR", modelElement.getClass( ).getName( ) } ); //$NON-NLS-1$
            throw new IllegalStateException( e );
        }
    }


    public String calculateElementMofId( final RefClass clazz, final String[] logicalKey ) {

        return ( (RefClassCalculatedMofId) clazz ).calculateMofId( logicalKey );
    }

    public RefClass getClass( final String container, final String dotSeparatedQName ) {

        final int index = dotSeparatedQName.lastIndexOf( '.' );
        if ( index < 0 ) {
            final MoinIllegalStateException e = new MoinIllegalStateException( XmIeMessages.QUALIFIEDNAMEWITHOUTPACKAGE, dotSeparatedQName );
            LOGGER.logAndTrace( e, MoinSeverity.ERROR, XmIeMessages.QUALIFIEDNAMEWITHOUTPACKAGE, dotSeparatedQName );
            throw e;
        }
        final String className = dotSeparatedQName.substring( index + 1, dotSeparatedQName.length( ) );
        final String packagePath = dotSeparatedQName.substring( 0, index );

        try {
            final RefPackage refPackage = this.getRefPackage( container, packagePath );
            if ( refPackage == null ) {
                LOGGER.traceWithStack( MoinSeverity.ERROR, XmIeMessages.QUALIFIEDNAMEWITHOUTPACKAGE, dotSeparatedQName );
                throw new MoinIllegalStateException( XmIeMessages.NOPACKAGEFOR, new Object[] { packagePath, container } );
            }
            return refPackage.refClass( className );
        } catch ( final InvalidNameException e ) {
            if ( LOGGER.isTraced( MoinSeverity.WARNING ) ) {
                LOGGER.trace( e, MoinSeverity.WARNING, "No class with qualified name {0} found in meta-model container {1}", new Object[] { dotSeparatedQName, container } ); //$NON-NLS-1$
            }
            return null; // according to interface description null must be returned
        }
    }

    public RefAssociation getAssociation( final String container, final String dotSeparatedQName ) {

        final int index = dotSeparatedQName.lastIndexOf( '.' );
        if ( index < 0 ) {
            throw new MoinIllegalStateException( XmIeMessages.QUALIFIEDNAMEWITHOUTPACKAGE, dotSeparatedQName );
        }
        final String assName = dotSeparatedQName.substring( index + 1, dotSeparatedQName.length( ) );
        final String packagePath = dotSeparatedQName.substring( 0, index );

        try {
            final RefPackage refPackage = this.getRefPackage( container, packagePath );
            return refPackage.refAssociation( assName );
        } catch ( final InvalidNameException e ) {
            if ( LOGGER.isTraced( MoinSeverity.WARNING ) ) {
                LOGGER.trace( e, MoinSeverity.WARNING, "No association with qualified name {0} found in meta-model container {1}", new Object[] { dotSeparatedQName, container } ); //$NON-NLS-1$
            }
            return null; // according to interface description null must be returned
        }
    }

//    public String getMetamodelContainerName( final RefClass clazz ) {
//
//        if ( clazz == null ) {
//            throw new MoinNullPointerException( "clazz" ); //$NON-NLS-1$
//        }
//        return ( (Partitionable) clazz.refMetaObject( ) ).get___Partition( ).getPri( ).getContainerName( );
//    }


//    /**
//     * Transforms a qualified name given as a list into a dot separated string.
//     * 
//     * @param qualifiedName
//     * @return dot separated qualified name
//     * @throws NullPointerException if the parameter is <code>null</code>
//     */
//    String getDotSeparatedQualifiedName( final List<String> qualifiedName ) {
//
//        final StringBuilder sb = new StringBuilder( );
//        // only up to the 
//        final int lengthMinus1 = qualifiedName.size( ) - 1;
//        int counter = 0;
//        for ( final String part : qualifiedName ) {
//            sb.append( part );
//            if ( counter < lengthMinus1 ) {
//                sb.append( '.' );
//            }
//            counter++;
//        }
//        return sb.toString( );
//    }


    /**
     * Determines the RefPackage.
     * 
     * @param container meta-model container
     * @param dotSeparatedPackages package names separated by dot
     * @return RefPackage or <code>null</code> if the package cannot be found
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    private RefPackage getRefPackage( final String container, final String dotSeparatedPackages ) {

        RefPackage result;
        Map<String, RefPackage> map = this.container2RefPackageMap.get( container );
        if ( map == null ) {
            map = new HashMap<String, RefPackage>( );
            result = this.getRefPackageFromConnectionAndAddToMap( container, dotSeparatedPackages, map );
        } else {
            result = map.get( dotSeparatedPackages );
            if ( result == null ) {
                result = this.getRefPackageFromConnectionAndAddToMap( container, dotSeparatedPackages, map );
            }
        }
        return result;
    }

    /**
     * Searches a MOF package with the specified qualified name and returns the
     * according package extent for it. Only those MOF packages are considered,
     * which are hosted in in the specified model container. The model container
     * is specified by its name.
     * <p>
     * If the resulting package is not <code>null</code>, then it is additional
     * added to the specified map.
     * 
     * @param modelContainerName The name of the model container, in which the
     * MOF package is searched. May be null. This triggers a search among all
     * model containers. This may result in a
     * {@link AmbiguousPackageNameException}.
     * @param qualifiedName The qualified name of the to be searched MOF package
     * @return The package extent or <code>null</code> if nothing has been found
     */
    private RefPackage getRefPackageFromConnectionAndAddToMap( final String container, final String dotSeparatedPackages, final Map<String, RefPackage> package2RefPackage ) {

        final RefPackage result = connection.getPackage( container, dotSeparatedPackages.split( "\\." ) ); //$NON-NLS-1$
        if ( result != null ) {
            package2RefPackage.put( dotSeparatedPackages, result );
            this.container2RefPackageMap.put( container, package2RefPackage );
        }
        return result;
    }

}
