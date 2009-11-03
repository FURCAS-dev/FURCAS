package com.sap.tc.moin.repository.core.mofrom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;
import com.sap.tc.moin.repository.mmi.model.__impl.MultiplicityTypeImpl;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.ResourceIdentifierFactory;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.Extent;
import com.sap.tc.moin.repository.core.ExtentManager;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.jmi.extension.AssociationEndExtension;
import com.sap.tc.moin.repository.core.jmi.extension.AssociationExtension;
import com.sap.tc.moin.repository.core.jmi.extension.RefAssociationExtension;
import com.sap.tc.moin.repository.core.jmi.extension.RefBaseObjectExtension;
import com.sap.tc.moin.repository.core.jmi.extension.RefClassExtension;
import com.sap.tc.moin.repository.core.jmi.extension.RefFeaturedExtension;
import com.sap.tc.moin.repository.core.jmi.extension.RefObjectExtension;
import com.sap.tc.moin.repository.core.jmi.extension.RefPackageExtension;
import com.sap.tc.moin.repository.core.jmi.extension.RefStructExtension;
import com.sap.tc.moin.repository.metamodels.DeploymentExtension;
import com.sap.tc.moin.repository.metamodels.MetaModelCatalog;
import com.sap.tc.moin.repository.spi.core.SpiStage;
import com.sap.tc.moin.repository.spi.core.SpiWorkspace;

/**
 * This class is responsible to instantiate the MOF ROM by calling the generated
 * MOF ROM class. The generated MOF ROM calls back in here in order to perform
 * certain tasks and to keep the generated part as small as possible.
 * 
 * @author d024227
 */
public class MoinMofRomServicesImpl {

    /**
     * The MOF toplevel package names
     */
    public static final Set<String> TOPLEVEL_PACKAGE_NAMES_MOF14 = new HashSet<String>( Arrays.asList( new String[] { "Model", "OCL", "PrimitiveTypes", "CorbaIdlTypes", "MOIN" } ) ); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$//$NON-NLS-5$

    /**
     * MOIN metamodel partition name prefix
     */
    public static final String MOFROM_MODELPARTITION_NAME_PREFIX = "moin/meta/"; //$NON-NLS-1$

    /**
     * OCL partition name
     */
    public static final String OCL_PARTITION_NAME = MOFROM_MODELPARTITION_NAME_PREFIX + "OCL.moinmm"; //$NON-NLS-1$

    /**
     * The string representation of the OCL partition identifier
     */
    public static final String OCL_PRI_STRING = "PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/OCL.moinmm"; //$NON-NLS-1$

    /**
     * MOF ROM Partition Container Name
     */
    public static final String MOFROM_MODELPARTITION_CONTAINER_NAME = "sap.com/tc/moin/mof_1.4"; //$NON-NLS-1$

    /**
     * prefix for MRI of MOF ROM Model Elements: TODO subject to be changed
     */
    public static final String MOFROM_MODELPARTITIONS_PREFIX = "DCs/" + MOFROM_MODELPARTITION_CONTAINER_NAME + "/_comp/" + MOFROM_MODELPARTITION_NAME_PREFIX; //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * This Map contains all instances keyed by their mof id
     */
    private Map<String, RefBaseObject> instances;

    private RefBaseObject[] instancesArray;

    /**
     * The Workspace MOF ROM created model elements are injected to
     */
    private Workspace modelElementWorkspace;

    private Workspace extentWorkspace;

    private ResourceIdentifierFactory riFactory;

    private DataAreaDescriptor dataAreaDescriptor;

    private Map<String, CoreModelPartition> /* of partitionName -> partition */modelPartitions;

    private List<Object[]>/*
                           * of Object[] { RefBaseObject object, RefBaseObject
                           * metaObject }
                           */objectsAndTheirMetaObjects;

    private List<Extent> /* of extents */extents;

    /**
     * @param modelElementWorkspace
     * @param extentWorkspace
     * @param riFactory
     * @param dataAreaDescriptor
     */
    public MoinMofRomServicesImpl( SpiWorkspace modelElementWorkspace, SpiWorkspace extentWorkspace, ResourceIdentifierFactory riFactory, DataAreaDescriptor dataAreaDescriptor ) {

        this.instances = new HashMap<String, RefBaseObject>( );
        this.modelElementWorkspace = (Workspace) modelElementWorkspace;
        this.extentWorkspace = (Workspace) extentWorkspace;
        this.riFactory = riFactory;
        this.dataAreaDescriptor = dataAreaDescriptor;
        this.modelPartitions = new HashMap<String, CoreModelPartition>( );
        this.objectsAndTheirMetaObjects = new ArrayList<Object[]>( );
        this.extents = new ArrayList<Extent>( );

//        MoinMofRom mofRom = new MoinMofRom( this );
//        mofRom.createInstances( );
//        mofRom.setAttributes( );
//        setMetaObjects( );
//        mofRom.loadLinks( );
//        buildUpExtentHierarchy( );

    }

    public void injectMofRomPhase( MofRomPhase phase ) {

        phase.setMoinMofRomServicesImpl( this );
        phase.createInstances( );
        phase.setAttributes( );
        setMetaObjects( );
        phase.loadLinks( );
        buildUpExtentHierarchy( );
    }

    /**
     * @return the instances
     */
    public Map<String, RefBaseObject> getInstances( ) {

        return this.instances;
    }

    public RefBaseObject[] getInstancesArray( int size ) {

        if ( this.instancesArray == null ) {
            this.instancesArray = new RefBaseObject[size];
        } else {
            RefBaseObject[] newArray = new RefBaseObject[instancesArray.length + size];

            System.arraycopy( instancesArray, 0, newArray, 0, instancesArray.length );

            instancesArray = newArray;
        }

        return instancesArray;
    }

    private void initRefBaseObjectExtension( int refBaseObjectMofid, int refMetaObjectMofId, Integer refImmediatePackageMofId, String[] qualifiedName ) {

        RefBaseObjectExtension rboe = (RefBaseObjectExtension) this.instancesArray[refBaseObjectMofid];
        RefObject rmo = (RefObject) this.instancesArray[refMetaObjectMofId];
        RefPackage rip = refImmediatePackageMofId == null ? null : (RefPackage) this.instancesArray[refImmediatePackageMofId];

        CoreModelPartition mp = getModelPartition( rboe, qualifiedName );
        rboe.set___PartitionAssignment( mp );
        rboe.set___ImmediatePackage( rip );
        if ( rboe instanceof Extent ) {
            rboe.set___Workspace( this.extentWorkspace );
            this.extentWorkspace.getInstanceManager( ).injectInstance( null /* connection */, rboe );
            ( (RefObjectExtension) rmo ).set___Extent( (Extent) rboe );
        } else {
            rboe.set___Workspace( this.modelElementWorkspace );
            this.modelElementWorkspace.getInstanceManager( ).injectInstance( null /* connection */, rboe );
        }
        mp.clearDirty( null /* connection */);
        this.objectsAndTheirMetaObjects.add( new Object[] { rboe, rmo } );

    }



    /**
     * @param refPackageMofid
     * @param refMetaObjectMofId
     * @param refImmediatePackageMofId
     * @param qualifiedName
     */
    public void initRefPackageExtension( int refPackageMofid, int refMetaObjectMofId, Integer refImmediatePackageMofId, String[] qualifiedName ) {

        initRefBaseObjectExtension( refPackageMofid, refMetaObjectMofId, refImmediatePackageMofId, qualifiedName );
        this.extents.add( (Extent) this.instancesArray[refPackageMofid] );
    }



    public void initRefAssociationExtension( int refAssociationMofid, int refMetaObjectMofId, int refImmediatePackageMofId, String[] qualifiedName ) {

        initRefBaseObjectExtension( refAssociationMofid, refMetaObjectMofId, refImmediatePackageMofId, qualifiedName );
        this.extents.add( (Extent) this.instancesArray[refAssociationMofid] );
    }



    public void initRefFeaturedExtension( int refFeaturedMofid, int refMetaObjectMofId, int refImmediatePackageMofId, String[] qualifiedName ) {

        initRefBaseObjectExtension( refFeaturedMofid, refMetaObjectMofId, refImmediatePackageMofId, qualifiedName );
    }



    public void initRefClassExtension( int refClassMofid, int refMetaObjectMofId, int refImmediatePackageMofId, String[] qualifiedName ) {

        initRefFeaturedExtension( refClassMofid, refMetaObjectMofId, refImmediatePackageMofId, qualifiedName );
        this.extents.add( (Extent) this.instancesArray[refClassMofid] );
    }



    public void initRefObjectExtension( int refObjectMofid, int refMetaObjectMofId, int refImmediatePackageMofId, int refClassMofId, String[] qualifiedName ) {

        initRefFeaturedExtension( refObjectMofid, refMetaObjectMofId, refImmediatePackageMofId, qualifiedName );
        RefObjectExtension roe = (RefObjectExtension) this.instancesArray[refObjectMofid];
        RefClass rc = (RefClass) this.instancesArray[refClassMofId];
        try {
            roe.set___RefClass( rc );
        } catch ( Exception e ) {
            throw new RuntimeException( e );
        }
    }



    public void initAssociationImplExtension( int associationMofId, int[] associationEndMofIds ) {

        AssociationExtension aie = (AssociationExtension) this.instancesArray[associationMofId];
        AssociationEnd[] aes = new AssociationEnd[associationEndMofIds.length];
        for ( int i = 0; i < associationEndMofIds.length; i++ ) {
            AssociationEnd ae = (AssociationEnd) this.instancesArray[associationEndMofIds[i]];
            aes[i] = ae;
        }
        aie.set___AssociationEnds( aes );
    }



    public void initAssociationEndImplExtension( int associationEndMofId, int associationMofId, int endNumber, boolean composite, boolean ordered, boolean stored ) {

        AssociationEndExtension aeie = (AssociationEndExtension) this.instancesArray[associationEndMofId];
        Association a = (Association) this.instancesArray[associationMofId];
        aeie.set___ExtensionInfo( a, (byte) endNumber, composite, ordered, stored );
    }

    /**
     * 
     */
    private void setMetaObjects( ) {

        for ( Iterator<Object[]> i = this.objectsAndTheirMetaObjects.iterator( ); i.hasNext( ); ) {
            Object[] pair = i.next( );
            if ( pair[0] instanceof RefPackageExtension ) {
                RefPackageExtension rpe = (RefPackageExtension) pair[0];
                rpe.set___MetaObject( (RefObject) pair[1] );
            } else if ( pair[0] instanceof RefClassExtension ) {
                RefClassExtension rce = (RefClassExtension) pair[0];
                rce.set___MetaObject( (RefObject) pair[1] );
            } else if ( pair[0] instanceof RefAssociationExtension ) {
                RefAssociationExtension rae = (RefAssociationExtension) pair[0];
                rae.set___MetaObject( (RefObject) pair[1] );
            } else if ( pair[0] instanceof RefObjectExtension ) {
                RefObjectExtension roe = (RefObjectExtension) pair[0];
                roe.set___MetaObject( (RefObject) pair[1] );
            } else if ( pair[0] instanceof RefStructExtension ) {
                RefStructExtension rse = (RefStructExtension) pair[0];
                rse.set___MetaObject( (RefObject) pair[1] );
            } else {
                throw new RuntimeException( "PANIC -> invalid object/metaobject pair" ); //$NON-NLS-1$
            }
        }
    }



    public void loadLink( int refMetaObjectMofId, int mofId0, int mofId1 ) {

        RefObject metaObject = (RefObject) this.instancesArray[refMetaObjectMofId];
        if ( metaObject instanceof Association ) {
            try {
                Association association = (Association) metaObject;
                CorePartitionable p0 = (CorePartitionable) this.instancesArray[mofId0];
                CorePartitionable p1 = (CorePartitionable) this.instancesArray[mofId1];
                this.modelElementWorkspace.getLinkManager( ).loadLink( (CoreSession) null, p0, p1, association );
            } catch ( Exception e ) {
                throw new RuntimeException( e );
            }
        }
    }



    public void setValues( int refMofId, Object[][] values ) {

        RefFeaturedExtension rfe = null;
        RefStructExtension rse = null;
        RefBaseObjectExtension rboe = (RefBaseObjectExtension) this.instancesArray[refMofId];
        if ( rboe instanceof RefFeaturedExtension ) {
            rfe = (RefFeaturedExtension) rboe;
        } else if ( rboe instanceof RefStructExtension ) {
            rse = (RefStructExtension) rboe;
        }
        for ( int i = 0; i < values.length; i++ ) {
            Object[] nameValue = values[i];
            String name = (String) nameValue[0];
            Object value = nameValue[1];
            if ( rfe != null ) {
                rfe.set___Value( (CoreSession) null, name, value );
            } else if ( rse != null ) {
                rse.set___Value( name, value );
            }
        }
    }



    public MultiplicityType createMultiplicityType( int refMetaObjectMofId, int lower, int upper, boolean isOrdered, boolean isUnique ) {

        MultiplicityType result = new MultiplicityTypeImpl( );
        RefStructExtension rse = (RefStructExtension) result;
        RefObject metaObject = (RefObject) this.instancesArray[refMetaObjectMofId];
        this.objectsAndTheirMetaObjects.add( new Object[] { rse, metaObject } );
        rse.set___Value( "lower", Integer.valueOf( lower ) ); //$NON-NLS-1$
        rse.set___Value( "upper", Integer.valueOf( upper ) ); //$NON-NLS-1$
        rse.set___Value( "isOrdered", isOrdered == true ? Boolean.TRUE : Boolean.FALSE ); //$NON-NLS-1$
        rse.set___Value( "isUnique", isUnique == true ? Boolean.TRUE : Boolean.FALSE ); //$NON-NLS-1$
        return result;
    }

    /**
     * 
     */
    private void buildUpExtentHierarchy( ) {

        // alternative approach...
        ExtentManager extentManager = this.extentWorkspace.getWorkspaceSet( ).getMoin( ).getExtentManager( );
        for ( Iterator<Extent> i = this.extents.iterator( ); i.hasNext( ); ) {
            extentManager.addExtent( i.next( ) );
        }
    }

    /*
     * private methods
     */

    private CoreModelPartition getModelPartition( Partitionable partitionable, String[] qualifiedName ) {

        CoreModelPartition modelPartition = null;
        if ( partitionable instanceof ModelElement ) {
            // TODO change to toString of DataAreaDescriptor
            StringBuilder partitionName = new StringBuilder( );
            partitionName.append( this.dataAreaDescriptor.getFacilityId( ) );
            partitionName.append( '.' );
            partitionName.append( this.dataAreaDescriptor.getDataAreaName( ) );
            partitionName.append( ':' );
            partitionName.append( MOFROM_MODELPARTITIONS_PREFIX );
            partitionName.append( qualifiedName[0] );
            partitionName.append( MetaModelCatalog.META_MODEL_EXTENSION );
            modelPartition = this.getModelPartition( partitionName.toString( ) );
        } else if ( partitionable instanceof RefPackage || partitionable instanceof RefClass || partitionable instanceof RefAssociation ) {
            modelPartition = this.extentWorkspace.getPartitionManager( ).getExtentPartition( );
        } else {
            throw new RuntimeException( "PANIC -> invalid partitionable: " + partitionable ); //$NON-NLS-1$
        }

        return modelPartition;
    }

    private CoreModelPartition getModelPartition( String modelPartitionName ) {

        if ( !this.modelPartitions.containsKey( modelPartitionName ) ) {
            PRI pri = this.riFactory.createPri( modelPartitionName );
            SpiStage stage = modelElementWorkspace.getStage( pri.getDataAreaDescriptor( ) );
            CoreModelPartition modelPartition = this.modelElementWorkspace.getPartitionFactory( ).___createModelPartition( (CoreConnection) null, pri, stage, this.modelElementWorkspace );
            modelPartition.markPersisted( );
            this.modelPartitions.put( modelPartitionName, modelPartition );
        }
        CoreModelPartition result = this.modelPartitions.get( modelPartitionName );
        return result;
    }

    public static DeploymentExtension createMofDeploymentExtension( ) {

        //ATTENTION: if you change this package, you also have to adjust the exported packages in the MANIFEST.MF!!! 
        return new com.sap.tc.moin.packageC0393E0B1229E70CBCF5B6FCADF0FFD94D1DE683.MetamodelExtension( );
    }

}
