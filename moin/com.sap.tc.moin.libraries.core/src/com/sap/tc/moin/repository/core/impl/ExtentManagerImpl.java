package com.sap.tc.moin.repository.core.impl;

import java.io.Serializable;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.__impl.ModelElementInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.MofPackageInternal;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.InvalidResourceIdentifierException;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CoreMoin;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.Extent;
import com.sap.tc.moin.repository.core.ExtentManager;
import com.sap.tc.moin.repository.core.MetamodelWorkspace;
import com.sap.tc.moin.repository.core.jmi.extension.RefObjectExtension;
import com.sap.tc.moin.repository.core.jmi.model.proxies.RefPackageProxyFactory;
import com.sap.tc.moin.repository.core.jmi.reflect.RefPackageImpl;
import com.sap.tc.moin.repository.core.mofrom.MoinMofRomServicesImpl;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.metamodels.DeploymentExtension;
import com.sap.tc.moin.repository.shared.util.StringUtils;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.repository.spi.core.serialization.SpiPartitionReader;
import com.sap.tc.moin.repository.spi.facility.SpiCoreQueryService;
import com.sap.tc.moin.repository.spi.facility.SpiFacilityException;

/**
 * The ExtentManager provides information to create extents
 */
public class ExtentManagerImpl implements ExtentManager {

    private static final String EXTENT_HIERARCHY_KEY = "000"; //$NON-NLS-1$

    private static final NameMriBasedSorter NAME_MRI_BASED_SORTER = new NameMriBasedSorter( );

    private static final Extent[] EMPTY_EXTENT_ARRAY = new Extent[0];

    private static final RefPackage[] EMPTY_REFPACKAGE_ARRAY = new RefPackage[0];

    private static final ModelElement[] EMPTY_MODELELEMENT_ARRAY = new ModelElement[0];

    /**
     * The Workspace which the extents have to be loaded into
     */
    private MetamodelWorkspace extentsWorkspace;

    /**
     * query per known facility
     */
    private List<SpiCoreQueryService> queries;

    /**
     * Maps the MRI of a metaObject to its Extent. If an extent is referenced
     * multiple times caused by clustered imports, this Map helps to reuse the
     * already instantiated instance.
     */
    private Map<String /* MOF-ID */, Extent> mofIdOfExtentsMetaObjectToExtent;

    /**
     * Maps top level packages names to lists of extents. The names are sorted
     * lexicographically and the extents are sorted by their MRI. This list
     * should be the single place where the root extents are hard-referenced.
     */
    private Map<String, ArrayList<Extent>> topLevelPackagesExtentsByName;

    ExtentManagerImpl( MetamodelWorkspace extentsWorkspace, List<SpiCoreQueryService> queries ) {

        this.extentsWorkspace = extentsWorkspace;
        this.queries = queries;
        this.mofIdOfExtentsMetaObjectToExtent = new IdentityHashMap<String, Extent>( 2048 );
    }

    public RefPackage[] selectRefPackages( String[] qualifiedName ) {

        //delegates to a synchronized method
        return selectRefPackages( qualifiedName, null );
    }

    public Extent[] selectExtents( String[] qualifiedName ) {

        synchronized ( extentsWorkspace.getPartitionManager( ) ) {
            synchronized ( this ) {
                return selectExtents( qualifiedName, null );
            }
        }
    }

    public ModelElement[] selectModelElements( CoreSession session, String[] qualifiedName ) {

        //delegates to a synchronized method
        return selectModelElements( session, qualifiedName, null );
    }

    @SuppressWarnings( "unchecked" )
    public RefPackage[] getTopLevelPackageExtents( ) {

        synchronized ( extentsWorkspace.getPartitionManager( ) ) {
            synchronized ( this ) {
//                getTopLevelPackageExtentsInternal( );
                List<RefPackage> packages = new ArrayList<RefPackage>( topLevelPackagesExtentsByName.size( ) );
                for ( List refPackages : topLevelPackagesExtentsByName.values( ) ) {
                    packages.addAll( refPackages );
                }
                List<RefPackage> extents = replaceProxiesWithRealElements( packages );
                int size = extents.size( );
                if ( size > 0 ) {
                    return extents.toArray( new RefPackage[size] );
                }
                return EMPTY_REFPACKAGE_ARRAY;
            }
        }
    }

    public RefPackage[] selectRefPackages( String[] qualifiedName, String[] modelContainerNames ) {

        synchronized ( extentsWorkspace.getPartitionManager( ) ) {
            synchronized ( this ) {
                List<Extent> extents = selectExtents( qualifiedName, true /* onlyRefPackages */, modelContainerNames );
                int size = extents.size( );
                if ( size > 0 ) {
                    return extents.toArray( new RefPackage[size] );
                }
                return EMPTY_REFPACKAGE_ARRAY;
            }
        }
    }

    public ModelElement[] selectModelElements( CoreSession session, String[] qualifiedName, String[] modelContainerNames ) {

        synchronized ( extentsWorkspace.getPartitionManager( ) ) {
            synchronized ( this ) {
                List<ModelElement> modelElements = new ArrayList<ModelElement>( );
                List<Extent> refPackages = selectExtents( new String[] { qualifiedName[0] }, true /* onlyRefPackages */, modelContainerNames );
                SpiJmiHelper jmiHelper = extentsWorkspace.getWorkspaceSet( ).getMoin( ).getJmiHelper( );
                for ( int i = 0; i < refPackages.size( ); i++ ) {
                    Extent refPackage = refPackages.get( i );
                    ModelElement modelElement = jmiHelper.findElementByQualifiedName( session, qualifiedName, (RefPackage) refPackage );
                    if ( modelElement != null ) {
                        modelElements.add( modelElement );
                    }
                }
                int size = modelElements.size( );
                if ( size > 0 ) {
                    return modelElements.toArray( new ModelElement[size] );
                }
                return EMPTY_MODELELEMENT_ARRAY;
            }
        }
    }

    /**
     * This method may be called by the {@link SpiPartitionReader} only!!!
     * <p>
     * For efficiency reasons, the qualified name is not given as a string
     * array, but as a dot-separated string, as it is found in the partition
     * file. This string is only split if no extent can be found for the given
     * MOF-ID.
     * <p>
     * The {@link SpiPartitionReader} never requests package extents. Therefore,
     * no call to {@link #replaceProxyWithRealElement(CoreConnection, Extent)}
     * is ever made for performance reasons (which would be required for package
     * extents).
     */
    public Extent selectExtentForPartitionReader( String mofIdOfMetaObject, String dotSeparatedQualifiedName, String modelContainerName ) {

        synchronized ( extentsWorkspace.getPartitionManager( ) ) {
            synchronized ( this ) {
                Extent result = mofIdOfExtentsMetaObjectToExtent.get( mofIdOfMetaObject.intern( ) );
                if ( result == null ) {
                    CoreMoin moin = extentsWorkspace.getWorkspaceSet( ).getMoin( );
                    DataAreaDescriptor dataAreaDescriptor = extentsWorkspace.getMetamodelDataArea( ).getDescriptor( );
                    CRI cri = moin.createCri( dataAreaDescriptor.getFacilityId( ), dataAreaDescriptor.getDataAreaName( ), modelContainerName );
                    DeploymentExtension deploymentExtension = moin.getMetaModelRegistry( ).getDeploymentExtension( cri );
                    if ( deploymentExtension == null ) {
                        return null; // metamodel not available => we cannot resolve the extent
                    }
                    String[] qualifiedName;
                    List<String> qualifiedNameAsList = deploymentExtension.getMofIdQualifiedNameMapping( ).get( mofIdOfMetaObject );
                    if ( qualifiedNameAsList == null ) {
                        // The metamodel exists, but the given 'mofIdOfMetaObject' is unknown. If we have the situation that
                        // the MOF-ID was changed but the qualified name is still the same, we can try to resolve the given
                        // 'dotSeparatedQualifiedName'.
                        qualifiedName = StringUtils.split( dotSeparatedQualifiedName, '.' );
                    } else {
                        // The metamodel exists and we were able to determine the qualified name of the given 'mofIdOfMetaObject'.
                        // We use this qualified name for the resolving.
                        qualifiedName = qualifiedNameAsList.toArray( new String[qualifiedNameAsList.size( )] );
                    }
                    // Not found by MOF-ID. Now try to find the extent through its qualified name. Note that the resolve process
                    // puts the resulting extent into the 'mofIdOfExtentsMetaObjectToExtent' map.
                    Extent[] extents = selectExtents( qualifiedName, new String[] { modelContainerName } );
                    if ( extents.length == 1 ) {
                        result = extents[0];
                    }
                }
                // Intentionally NO call to replaceProxyWithRealElement() for performance reasons, because package extents 
                // are never requested by the PartitionReader!!!
                return result;
            }
        }
    }

    public Extent selectExtent( String mofIdOfMetaObject, String[] qualifiedName, String modelContainerName ) {

        synchronized ( extentsWorkspace.getPartitionManager( ) ) {
            synchronized ( this ) {
                Extent originalExtent = mofIdOfExtentsMetaObjectToExtent.get( mofIdOfMetaObject.intern( ) );
                Extent result = null;
                if ( originalExtent == null ) {
                    // Not found by MOF-ID. Now try to find the extent through its qualified name.

                    Extent[] extents = selectExtents( qualifiedName, new String[] { modelContainerName } );
                    if ( extents.length == 1 ) {
                        result = extents[0];
                    }
                } else {
                    // Could still be an unresolved package proxy.
                    result = replaceProxyWithRealElement( originalExtent );
                }
                return result;
            }
        }
    }

    public RefBaseObject getDefaultExtentForMetaObject( GeneralizableElement metaObject ) {

        synchronized ( extentsWorkspace.getPartitionManager( ) ) {
            synchronized ( this ) {
                String mofId = metaObject.refMofId( );
                // look, if the extent has been created already
                Extent result = getExtentInternal( mofId );
                if ( result == null ) {
                    /*
                     * has not been created. Trigger to find the extents with
                     * the qualified name. After this call they should be
                     * accessible by their MRI.
                     */
                    @SuppressWarnings( "unchecked" )
                    List<String> qname = ( (ModelElementInternal) metaObject ).getQualifiedName( null );
                    selectExtents( qname.toArray( new String[qname.size( )] ), null );
                    result = getExtentInternal( mofId );
                }
                if ( result != null ) {
                    result = replaceProxyWithRealElement( result );
                }
                return result;
            }
        }
    }

    public String convertToExtentMofId( String metaObjectMofId ) {

        return metaObjectMofId + "~" + EXTENT_HIERARCHY_KEY; //$NON-NLS-1$
    }

    public String convertToMetamodelElementMofId( String extentMofId ) {

        return extentMofId.substring( 0, extentMofId.lastIndexOf( '~' ) );
    }

    /**
     * Adds an extent to the Map of extents which are keyed by their metaObjects
     * MOF id. If this Extent already exists a RuntimeException is thrown,
     * because it has previously to be checked, if such an Extent already exists
     * and if so, it has to be reused
     */
    public synchronized void addExtent( Extent extent ) {

        if ( this.topLevelPackagesExtentsByName == null ) {
            this.topLevelPackagesExtentsByName = new LinkedHashMap<String, ArrayList<Extent>>( );
        }

        //doesn't need to synchronize on the MetamodelPartitionManager because no load can be triggered
        Extent oldExtent = addExtentInternal( extent );
        if ( oldExtent == null ) {
            if ( extent instanceof RefPackage ) {
                MofPackageInternal mofPackage = (MofPackageInternal) ( (RefPackage) extent ).refMetaObject( );
                if ( mofPackage.getContainer( null ) == null ) {
                    // new top level package found
                    this.addToTopLevelPackagesExtentsByName( (RefPackage) extent, null );
                }
            }
        } else {
            addExtentInternal( oldExtent );
        }
    }



    /**
     * Returns an Extent for the specified extent's metaObject, if this Extent
     * has been created already, otherwise null
     */
    public Extent getExtent( MRI mriOfExtentsMetaObject ) {

        synchronized ( extentsWorkspace.getPartitionManager( ) ) {
            synchronized ( this ) {
                return getExtentInternal( mriOfExtentsMetaObject );
            }
        }
    }

    private Extent getExtentInternal( MRI mriOfExtentsMetaObject ) {

        Extent result = getExtentInternal( mriOfExtentsMetaObject.getMofId( ) );
        return replaceProxyWithRealElement( result );
    }


    /**
     * Adds an extent to the Map of extents which are keyed by their metaObjects
     * MOF id. If this Extent already exists a RuntimeException is thrown,
     * because it has previously to be checked, if such an Extent already exists
     * and if so, it has to be reused
     */
    private Extent addExtentInternal( Extent extent ) {

        Extent result = null;
        RefObject metaObject = ( (RefBaseObject) extent ).refMetaObject( );
        result = mofIdOfExtentsMetaObjectToExtent.put( metaObject.refMofId( ), extent );
        return result;
    }

    public void signalMetamodelsDeployed( ) {

        this.getTopLevelPackageExtentsInternal( );
    }

    @SuppressWarnings( "unchecked" )
    private void getTopLevelPackageExtentsInternal( ) {

//        if ( topLevelPackagesExtentsByName == null ) {
        try {
//                topLevelPackagesExtentsByName = new LinkedHashMap<String, ArrayList<Extent>>( );
            List<MofPackage> temp = new ArrayList<MofPackage>( );
//                temp.addAll( getTopLevelMofPackagesMofRom( ) );
//                temp = sortAndDeleteDuplicateMofPackages( temp );
//
//                /*
//                 * Loop the MOF ROM extents
//                 */
//                for ( int i = 0; i < temp.size( ); i++ ) {
//                    MofPackage mofPackage = temp.get( i );
//                    RefPackage refPackage = (RefPackage) mofIdOfExtentsMetaObjectToExtent.get( mofPackage.refMofId( ) );
//                    addToTopLevelPackagesExtentsByName( refPackage, null /* oldRefPackageProxyToBeReplaced */);
//                }
//
//                /*
//                 * get additional MOF packages. Calling this will lead to have
//                 * the MOF ROM extents to be requested (by Eckart!)
//                 */
            temp.addAll( getTopLevelMofPackagesModelContainerService( ) );
            /*
             * sort the top level packages according to their qualified name and
             * MRI Delete adjacent duplicates from the list
             */
            temp = sortAndDeleteDuplicateMofPackages( temp );
            /*
             * Delete the hierarchy in order to mixin the others as well
             */
//            topLevelPackagesExtentsByName = new LinkedHashMap<String, ArrayList<Extent>>( );
            /*
             * Loop them all and create the RefPackage, if missing
             */
            for ( int i = 0; i < temp.size( ); i++ ) {
                MofPackage mofPackage = temp.get( i );
                RefPackage refPackage = (RefPackage) mofIdOfExtentsMetaObjectToExtent.get( mofPackage.refMofId( ) );
                if ( refPackage == null ) {
                    refPackage = new RefPackageProxyFactory( ).create( mofPackage );
                    addExtentInternal( (Extent) refPackage );
                    addToTopLevelPackagesExtentsByName( refPackage, null /* oldRefPackageProxyToBeReplaced */);
                }
            }
        } catch ( InvalidResourceIdentifierException e ) {
            throw new RuntimeException( e );
        } catch ( SpiFacilityException e ) {
            throw new RuntimeException( e );
        }
//        }
    }

    private Extent[] selectExtents( String[] qualifiedName, String[] modelContainerNames ) {

        List<Extent> extents = selectExtents( qualifiedName, false /* onlyRefPackages */, modelContainerNames );
        int size = extents.size( );
        if ( size > 0 ) {
            return extents.toArray( new Extent[size] );
        }
        return EMPTY_EXTENT_ARRAY;
    }

    /**
     * Returns an Extent for the specified extent's metaObject, if this Extent
     * has been created already, otherwise null
     */
    private Extent getExtentInternal( String mofIdOfExtentsMetaObject ) {

        return mofIdOfExtentsMetaObjectToExtent.get( mofIdOfExtentsMetaObject );
    }

    /**
     * 
     */
    private List<Extent> selectExtents( String[] qname, boolean onlyRefPackages, String[] modelContainerNames ) {

        List<Extent> tlpbn = getTopLevelPackagesExtentsByName( qname[0] );
        if ( qname.length == 1 ) {
            return replaceProxiesWithRealElements( filterByModelContainerNames( tlpbn, modelContainerNames ) );
        }
        List<Extent> result = null;
        if ( tlpbn.size( ) > 0 ) {
            for ( int i = 0; i < tlpbn.size( ); i++ ) {
                Extent tlrp = tlpbn.get( i );
                tlrp = replaceProxyWithRealElement( tlrp );
                RefBaseObject extent = extentsWorkspace.getWorkspaceSet( ).getMoin( ).getJmiHelper( ).matchQNameInExtent( qname, 1, tlrp );
                if ( extent != null ) {
                    if ( !onlyRefPackages || extent instanceof RefPackage ) {
                        if ( result == null ) {
                            result = new ArrayList<Extent>( );
                        }
                        result.add( (Extent) extent );
                    }
                }
            }
            if ( result != null ) {
                result = filterByModelContainerNames( result, modelContainerNames );
            }
        }
        if ( result == null ) {
            return Collections.emptyList( );
        }
        return result;
    }

    /**
     * This method creates a real RefPackage, if the passed element is just a
     * Java proxy for a RefPackage. It replaces also the Java proxy in all data
     * structures, which host the RefPackage
     * 
     * @param proxies the Extents which might be to be converted
     * @return the converted Extents, the real object or just the object which
     * has been passed in case it was already the real element
     * @throws ClassNotFoundException
     */
    @SuppressWarnings( "unchecked" )
    private <T> List<T> replaceProxiesWithRealElements( List<T> proxies ) {

        List<T> result = new ArrayList<T>( proxies.size( ) );
        for ( int i = 0; i < proxies.size( ); i++ ) {
            result.add( (T) replaceProxyWithRealElement( (Extent) proxies.get( i ) ) );
        }
        return result;
    }

    /**
     * This method creates a real RefPackage, if the passed element is just a
     * Java proxy for a RefPackage. It replaces also the Java proxy in all data
     * structures, which host the RefPackage
     * 
     * @param extent the Extent which might be to be converted
     * @return the converted Extent, the real object or just the object which
     * has been passed in case it was already the real element
     * @throws ClassNotFoundException
     */
    private Extent replaceProxyWithRealElement( Extent extent ) {

        Extent result;
        // check if it is a Java proxy
        if ( extent instanceof RefPackage && ( extent instanceof Proxy ) ) {
            RefPackage refPackage = null;

            MofPackage mofPackage = (MofPackage) extent.refMetaObject( );
            if ( mofPackage instanceof MofPackageProvider ) {
                // triggers the partition loading
                mofPackage = ( (MofPackageProvider) mofPackage ).resolveMofPackage( );
            }
            refPackage = createRefPackage( mofPackage );
            // replaces the old one and adds the new one
            RefPackage oldRefPackage = (RefPackage) addExtentInternal( (Extent) refPackage );
            if ( extent != oldRefPackage ) {
                throw new MoinLocalizedBaseRuntimeException( CoreImplMessages.UNEXPECTEDOLDREFPACKAGEJAVAPROXYELEMENTFOUND );
            }
            // replaces the old one and adds the new one
            addToTopLevelPackagesExtentsByName( refPackage, oldRefPackage );
            result = (Extent) refPackage;
        } else {
            result = extent;
        }
        return result;
    }

    /**
     * Creates an extent
     */
    private RefPackage createRefPackage( MofPackage mofPackage ) {

        RefPackage result = null;
        String extentMofId = convertToExtentMofId( ( (Partitionable) mofPackage ).get___Mri( ).getMofId( ) );
        result = extentsWorkspace.getJmiInstantiator( ).createRefPackage( extentMofId, null, mofPackage );
        // the RefPackage has to be created
        CoreModelPartition extentPartition = extentsWorkspace.getPartitionManager( ).getExtentPartition( );
        ( (CorePartitionable) result ).set___PartitionAssignment( extentPartition );
        return result;
    }

    private List<Extent> filterByModelContainerNames( List<Extent> extents, String[] modelContainerNames ) {

        List<Extent> result = null;
        if ( modelContainerNames != null && modelContainerNames.length > 0 ) {
            for ( int i = 0; i < extents.size( ); i++ ) {
                Extent extent = extents.get( i );
                Extent filteredExtent = null;
                MRI mri = ( (Partitionable) extent.refMetaObject( ) ).get___Mri( );
                String containerName = mri.getContainerName( );
                if ( containerName != null ) {
                    for ( int j = 0; j < modelContainerNames.length; j++ ) {
                        if ( modelContainerNames[j].equals( containerName ) ) {
                            filteredExtent = extent;
                            break;
                        }
                    }
                    if ( filteredExtent != null ) {
                        if ( result == null ) {
                            result = new ArrayList<Extent>( 1 );
                        }
                        result.add( filteredExtent );
                    }
                }
            }
        } else {
            result = extents;
        }
        if ( result != null ) {
            return result;
        }
        return Collections.emptyList( );
    }

//    /**
//     * Returns all top level MofPackages, which have been created by the MofRom
//     */
//    private List<MofPackage> getTopLevelMofPackagesMofRom( ) {
//
//        List<MofPackage> result = new ArrayList<MofPackage>( );
//        for ( Entry<String, Extent> entry : mofIdOfExtentsMetaObjectToExtent.entrySet( ) ) {
//            Extent extent = entry.getValue( );
//            if ( extent instanceof RefPackage ) {
//                MofPackage mofPackage = (MofPackage) ( (RefPackage) extent ).refMetaObject( );
//                if ( mofPackage.getContainer( ) == null ) {
//                    // top level package found
//                    result.add( mofPackage );
//                }
//            }
//        }
//        return result;
//    }

    /**
     * Returns all top level MofPackages, which have been created by the MofRom
     * 
     * @throws SpiFacilityException
     */
    @SuppressWarnings( "unchecked" )
    private List<MofPackage> getTopLevelMofPackagesModelContainerService( ) throws SpiFacilityException {

        List<MofPackage> result = new ArrayList<MofPackage>( );

        if ( queries != null ) {
            try {
                for ( SpiCoreQueryService query : queries ) {

                    Map<MRI, String> topLevelPackageMrisToNames = query.getTopLevelPackages( );
                    for ( Entry<MRI, String> mapEntry : topLevelPackageMrisToNames.entrySet( ) ) {
                        MofPackageProxy mpp = new MofPackageProxyImpl( mapEntry.getKey( ), mapEntry.getValue( ), this.extentsWorkspace );

                        // in case MOF is persisted, we have to exclude it from
                        // the query result as we take it from the
                        // MOF ROM
                        if ( MoinMofRomServicesImpl.TOPLEVEL_PACKAGE_NAMES_MOF14.contains( mpp.getName( ) ) ) {
                            // we have a candidate detected, with the MRI we
                            // check to be sure. By doing this, the proxy
                            // is resolved. But that does not hurt as the
                            // partition is anyway loaded already
                            PRI priMofPackage = mpp.getMofPackageMri( ).getPri( );
                            String containerName = priMofPackage.getContainerName( );
                            if ( !MoinMofRomServicesImpl.MOFROM_MODELPARTITION_CONTAINER_NAME.equals( containerName ) ) {
                                // this is not a package of the MOIN metamodel
                                // (currently equal to MOF)
                                result.add( mpp.getPackage( ) );
                            }
                        } else {
                            result.add( mpp.getPackage( ) );
                        }
                    }
                }
            } catch ( UnsupportedOperationException e ) {
                // $JL-EXC$ it's fine!
            }
        }

        return result;
    }

    /**
     * Returns the sorted and condensed list of MofPackages
     * 
     * @param mofPackages the list of unsorted MofPackages (with potential
     * duplicates)
     */
    private List<MofPackage> sortAndDeleteDuplicateMofPackages( List<MofPackage> mofPackages ) {

        List<MofPackage> temp = new ArrayList<MofPackage>( mofPackages );
        /*
         * sort the top level packages according to their qualified name and MRI
         */
        Collections.sort( temp, NAME_MRI_BASED_SORTER );
        /*
         * Delete adjacent duplicates from the list
         */
        List<MofPackage> result = new ArrayList<MofPackage>( );
        MRI oldMri = null; // remember the previous item of the list
        for ( int i = 0; i < temp.size( ); i++ ) {
            MofPackage mofPackage = temp.get( i );
            MRI currentMri = ( (Partitionable) mofPackage ).get___Mri( );
            if ( !currentMri.equals( oldMri ) ) {
                result.add( mofPackage );
            }
            oldMri = currentMri;
        }
        return result;
    }

    private void addToTopLevelPackagesExtentsByName( RefPackage refPackage, RefPackage oldRefPackageProxyToBeReplaced ) {

        String name = ( (ModelElement) refPackage.refMetaObject( ) ).getName( );
        ArrayList<Extent> extentsWithSameName = topLevelPackagesExtentsByName.get( name );
        if ( extentsWithSameName == null ) {
            topLevelPackagesExtentsByName.put( name, extentsWithSameName = new ArrayList<Extent>( ) );
        }
        if ( oldRefPackageProxyToBeReplaced != null ) {
            for ( int i = 0; i < extentsWithSameName.size( ); i++ ) {
                if ( extentsWithSameName.get( i ) == oldRefPackageProxyToBeReplaced ) {
                    extentsWithSameName.set( i, (Extent) refPackage );
                    break;
                }
            }
        } else {
            extentsWithSameName.add( (Extent) refPackage );
        }
        extentsWithSameName.trimToSize( );
    }

    public synchronized void resetTopLevelExtents( ) {

        throw new UnsupportedOperationException( );
//        //doesn't need to synchronize on the MetamodelPartitionManager because no load is triggered
//        if ( topLevelPackagesExtentsByName == null ) {
//            getTopLevelPackageExtentsInternal( );
//        }
//
//        for ( Partitionable part : extentsWorkspace.getInstanceManager( ).getInstances( ) ) {
//            if ( part instanceof MofPackage ) {
//                MofPackage mofPackage = (MofPackage) part;
//
//                if ( mofPackage.getContainer( ) == null ) {
//                    if ( !topLevelPackagesExtentsByName.containsKey( mofPackage.getName( ) ) ) {
//                        RefPackage refPackage = (RefPackage) mofIdOfExtentsMetaObjectToExtent.get( mofPackage.refMofId( ) );
//
//                        if ( refPackage == null ) {
//                            refPackage = new RefPackageProxyFactory( ).create( mofPackage );
//                        }
//
//                        addToTopLevelPackagesExtentsByName( refPackage, null );
//                    }
//                }
//            }
//        }

    }

    private List<Extent> getTopLevelPackagesExtentsByName( String name ) {

//        if ( topLevelPackagesExtentsByName == null ) {
//            getTopLevelPackageExtentsInternal( );
//        }
        List<Extent> result = topLevelPackagesExtentsByName.get( name );
        if ( result != null ) {
            return result;
        }
        return Collections.emptyList( );
    }

    public boolean isExtentMofId( String mofId ) {

        int lastPos = mofId.lastIndexOf( '~' );
        return lastPos == mofId.length( ) - 4;
    }

    static final class NameMriBasedSorter implements Comparator<ModelElement>, Serializable {

        private static final long serialVersionUID = 6260614731169720731L;

        public int compare( ModelElement m1, ModelElement m2 ) {

            int result = m1.getName( ).compareTo( m2.getName( ) );
            if ( result == 0 ) {
                // compare the MRIs, in case the qualified names are equal
                try {
                    result = ( (Partitionable) m1 ).get___Mri( ).toString( ).compareTo( ( (Partitionable) m2 ).get___Mri( ).toString( ) );
                } catch ( Exception e ) {
                    throw new RuntimeException( e );
                }
            }
            return result;
        }
    }

    public Extent createExtent( RefPackage myRefPackage, RefObject refMetaObject ) {

        synchronized ( extentsWorkspace.getPartitionManager( ) ) {
            synchronized ( this ) {
                RefPackageImpl refPackage = (RefPackageImpl) myRefPackage;
                MRI mriOfExtentsMetaObject = ( (Partitionable) refMetaObject ).get___Mri( );
                Extent extent = getExtentInternal( mriOfExtentsMetaObject );
                MetamodelWorkspace workspace = refPackage.get___Workspace( );
                if ( extent == null ) {
                    // not yet in the extent manager, but maybe already existing
                    String mofId = convertToExtentMofId( refMetaObject.refMofId( ) );
                    extent = (Extent) workspace.getInstanceManager( ).getInstance( mofId );
                    if ( extent == null ) {
                        extent = (Extent) refPackage.create___ExtentForExtentManager( workspace, mofId, refPackage, refMetaObject );
                        ( (RefObjectExtension) refMetaObject ).set___Extent( extent );
                    }
                    addExtentInternal( extent );
                }

                return extent;
            }
        }
    }
}
