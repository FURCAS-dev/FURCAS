package com.sap.tc.moin.repository.core.jmi.reflect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.model.__impl.StructureTypeImpl;
import com.sap.tc.moin.repository.mmi.reflect.ConstraintViolationException;
import com.sap.tc.moin.repository.mmi.reflect.InvalidCallException;
import com.sap.tc.moin.repository.mmi.reflect.InvalidNameException;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefEnum;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefStruct;
import com.sap.tc.moin.repository.mmi.reflect.TypeMismatchException;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CompoundClientSpecWorkspace;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.EndAndMetaObject;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.MetamodelWorkspace;
import com.sap.tc.moin.repository.core.QueryLinkManager;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.core.checks.MoinAndMofConstraints;
import com.sap.tc.moin.repository.core.jmi.extension.RefBaseObjectExtension;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;
import com.sap.tc.moin.repository.messages.jmi.impl.JmiBase;
import com.sap.tc.moin.repository.metamodels.DeploymentExtension;
import com.sap.tc.moin.repository.metamodels.MetaModelVersion;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatusItem;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationCategory;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.repository.spi.runtimehost.mm.SpiMetamodelRegistry;

/**
 * The (abstract) {@link RefBaseObject} implementation
 */
public abstract class RefBaseObjectImpl extends PartitionableImpl implements RefBaseObjectExtension {

    /***************************************************************************
     * mandatory attributes which need to be set
     **************************************************************************/

    /**
     * A model element is assigned to a workspace. The corresponding link is
     * stored on both ends, in the {@link Workspace} as well as in this
     * attribute. If this attribute's value is <tt>null</tt>, the assignment has
     * not been made yet. It will be made either during construction in the
     * corresponding class proxy, or during loading of the hosting model
     * partition into a workspace via
     * {@link SpiPersistence#loadPartition(Workspace, MRI)}.
     */

    private static final class ConstraintStatusItemWrapper implements MoinLocalizedString {

        private final DeferredConstraintViolationStatusItem myItem;

        public ConstraintStatusItemWrapper( DeferredConstraintViolationStatusItem item ) {

            this.myItem = item;
        }

        public String getLocalizedMessage( Locale locale ) {

            return this.myItem.getConstraintViolationMessage( locale );
        }

        public String format( Object... args ) {

            return this.myItem.getConstraintViolationMessage( );
        }
    }

    protected Workspace ___workspace;

    private String ___mofId;

    private RefPackage ___immediatePackage;

    private RefObject ___metaObject;

    /***************************************************************************
     * constructors
     **************************************************************************/

    public RefBaseObjectImpl( ) {

        super( );
    }

    public RefBaseObjectImpl( Object workspace, String mofId, RefPackage immediatePackage, RefObject metaObject ) {

        this( );
        ___init( (Workspace) workspace, mofId, immediatePackage, metaObject, null );
    }

    public RefBaseObjectImpl( Workspace workspace, String mofId, RefPackage immediatePackage, RefObject metaObject, CoreModelPartition modelPartition ) {

        this( );
        ___init( workspace, mofId, immediatePackage, metaObject, modelPartition );
    }

    private void ___init( Workspace workspace, String mofId, RefPackage immediatePackage, RefObject metaObject, CoreModelPartition modelPartition ) {

        /*
         * The following sequence of calls is absolutely crucial for the
         * initialization process to work. Be careful with changes here!
         */
        set___MofId( mofId );
        set___Workspace( workspace );
        if ( modelPartition != null ) {
            set___PartitionAssignment( modelPartition );
        }
        workspace.getInstanceManager( ).injectInstance( null, this );
        set___MetaObject( metaObject );
        set___ImmediatePackage( immediatePackage );
    }

    /***************************************************************************
     * getters and setters
     **************************************************************************/

    @Override
    public Workspace get___Workspace( ) {

        return this.___workspace;
    }

    public void ___delete( ) {

        // do nothing here, meaningful implementation is in the sub classes
        // RefObjectImpl and RefPackageImpl
    }

    /**
     * Assigns this model element to the given workspace.
     * 
     * @param workspace the workspace to which to assign this model element.
     */
    public final void set___Workspace( Workspace workspace ) {

        if ( this.___workspace != workspace ) {
            if ( ( this.___workspace != null ) && ( workspace != null ) ) {
                // TODO proper Exception
                throw new MoinLocalizedBaseRuntimeException( JmiReflectMessages.WORKSAPCEALREADYSET );
            }
            this.___workspace = workspace;
        }
    }

    public final void set___MofId( String mofId ) {

        // mof id can only be set once
        if ( this.___mofId != null ) {
            JmiBaseRuntimeException e = new JmiBaseRuntimeException( JmiBase.JMI_BASE_0003, new Object[] { this.___mofId, mofId } );
            throw e;
        }
        this.___mofId = mofId.intern( );
    }

    public final void set___MetaObject( RefObject metaObject ) {

        if ( get___Workspace( ) != null && metaObject != null ) {
            this.___metaObject = metaObject;
        } else {
            JmiBaseRuntimeException e = new JmiBaseRuntimeException( JmiBase.JMI_BASE_0004 );
            throw e;
        }
    }

    public final void set___ImmediatePackage( RefPackage immediatePackage ) {

        this.___immediatePackage = immediatePackage;
    }

    /***************************************************************************
     * other methods
     **************************************************************************/

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.core.Partitionable#get___Uri()
     */
    public final MRI get___Mri( ) {

        if ( this.___mri == null ) {
            CoreModelPartition partition = get___Partition( );
            if ( partition != null ) {
                PRI pri = partition.getPri( );
                if ( pri != null ) {
                    // take my partition's MRI and append my MOF-ID as a
                    // fragment
                    this.___mri = pri.createMri( refMofId( ) );
                }
            }
        }
        return this.___mri;
    }

    public RefObject refMetaObject( ) {

        return this.___metaObject;
    }

    public final RefPackage refImmediatePackage( ) {

        return this.___immediatePackage;
    }

    public final RefPackage refOutermostPackage( ) {

        RefPackage rp = refImmediatePackage( );
        if ( rp == null && this instanceof RefPackage ) {
            return (RefPackage) this;
        }
        if ( rp != null && !( rp.equals( this ) ) ) {
            RefPackage rpTemp = rp.refOutermostPackage( );
            if ( rpTemp != null ) {
                rp = rpTemp;
            }
        }
        return rp;
    }

    public final String refMofId( ) {

        return this.___mofId;
    }

    @Deprecated
    public Collection<JmiException> refVerifyConstraints( boolean deepVerify ) {

        Collection<JmiException> result = refVerifyConstraints( get___CurrentConnection( ), deepVerify );
        if ( result.isEmpty( ) ) {
            return null;
        }
        return result;
    }

    protected Collection<JmiException> refVerifyConstraints( CoreConnection connection, @SuppressWarnings( "unused" ) boolean deepVerify ) {

        List<JmiException> exceptions = new ArrayList<JmiException>( );
        MoinAndMofConstraints checker = new MoinAndMofConstraints( connection );
        Map<StructuralFeature, Set<RefBaseObject>> alreadyChecked = new HashMap<StructuralFeature, Set<RefBaseObject>>( );
        List<DeferredConstraintViolationStatusItem> result = checker.checkManualConstraints( this, alreadyChecked, OclRegistrationCategory.immediate, OclRegistrationCategory.deferred );
        for ( DeferredConstraintViolationStatusItem item : result ) {
            RefBaseObject o = connection.getElement( item.getOffendingMRI( ) );
            ConstraintStatusItemWrapper wrapper = new ConstraintStatusItemWrapper( item );
            JmiException ex = new ConstraintViolationException( o, null, wrapper, item.getConstraintRegistration( ).getName( ) );
            exceptions.add( ex );
        }
        if ( result.isEmpty( ) ) {
            return null;
        }
        return exceptions;
    }

    protected final boolean is___LocatedInSingleIsolatedWorkspace( ) {

        return get___Workspace( ).isMetamodelWorkspace( );
    }

    public final DeploymentExtension get___DeploymentExtension( ) {

        if ( is___LocatedInSingleIsolatedWorkspace( ) ) {
            CRI cri = get___Mri( ).getPri( ).getCri( );
            WorkspaceSet workspaceSet = get___Workspace( ).getWorkspaceSet( );
            DeploymentExtension deploymentExtension = workspaceSet.getMoin( ).getMetaModelRegistry( ).getDeploymentExtension( cri );
            return deploymentExtension;
        }
        return null;
    }

    public String get___MetamodelVersion( ) {

        CoreModelPartition partition = ( (CorePartitionable) refMetaObject( ) ).get___Partition( );
        SpiMetamodelRegistry metamodelRegistry = partition.getWorkspace( ).getWorkspaceSet( ).getMoin( ).getMetaModelRegistry( );
        CRI metaObjectCri = partition.getPri( ).getCri( );
        MetaModelVersion deployedMetaModelVersion = metamodelRegistry.getMetaModelVersion( metaObjectCri );
        if ( deployedMetaModelVersion != null ) {
            return deployedMetaModelVersion.getVersionString( );
        }

        return null;
    }

    public final CorePartitionable get___MetamodelElement( String mofId ) {

        MetamodelWorkspace metamodelWorkspace = get___Workspace( ).getWorkspaceSet( ).getMoin( ).getMetamodelWorkspace( );
        CorePartitionable metamodelElement = metamodelWorkspace.getMetamodelElement( mofId );
        return metamodelElement;
    }

    /**
     * The hash code is computed based on this object's MOF ID
     * 
     * @see #refMofId()
     */
    @Override
    public final int hashCode( ) {

        return this.___mofId.hashCode( );
    }

    /**
     * Equality is based on the MOF ID of this model element
     * 
     * @param other If a {@link RefBaseObject}, the comparison is carried out
     * using <tt>other</tt>'s {@link #refMofId()}.
     * @see #refMofId()
     */
    @Override
    public final boolean equals( Object other ) {

        if ( this == other ) {
            return true;
        }
        if ( other instanceof RefBaseObjectImpl ) {
            // $JL-STRING$
            return this.___mofId == ( (RefBaseObjectImpl) other ).___mofId;
        }
        return false;
    }

    @Override
    public String toString( ) {

        return "{" + refMofId( ) + "}"; //$NON-NLS-1$ //$NON-NLS-2$
    }

    protected final boolean is___Initialized( ) {

        return this.___workspace != null && this.___mofId != null && this.___metaObject != null;
    }

    protected RefStruct ref___CreateStruct( CoreConnection connection, RefObject struct, List params ) {

        if ( struct instanceof StructureType ) {
            return ref___CreateStruct( connection, ( (StructureType) struct ).getName( ), params );
        }
        throw new InvalidCallException( struct, null, "refCreateStruct()" ); //$NON-NLS-1$
    }

    @SuppressWarnings( "unchecked" )
    @Deprecated
    protected RefStruct ref___CreateStruct( String structName, List params ) {

        return ref___CreateStruct( get___CurrentConnection( ), structName, params );
    }

    protected RefStruct ref___CreateStruct( CoreConnection connection, String structName, List<? extends Object> params ) {

        CoreSession session = ( connection != null ? connection.getSession( ) : null );
        ModelElement me;
        try {
            me = get___JmiHelper( ).getAllContentMap( session, (Namespace) refMetaObject( ) ).get( structName );
        } catch ( Exception e ) {
            throw new InvalidCallException( structName, null, "refCreateStruct(String, List)" ); //$NON-NLS-1$
        }
        StructureType structureType = null;
        if ( me instanceof StructureType ) {
            structureType = (StructureTypeImpl) me;
        } else {
            throw new InvalidCallException( structName, null, "refCreateStruct(String, List)" ); //$NON-NLS-1$
        }
        RefStructImpl result = (RefStructImpl) create___RefStruct( this.___workspace, structureType );
        List<StructureField> structureFields = get___JmiHelper( ).getStructureFields( session, structureType, true /* includeSupertypes */);
        if ( structureFields.size( ) == params.size( ) ) {
            for ( int i = 0, n = structureFields.size( ); i < n; i++ ) {
                StructureField structureField = structureFields.get( i );
                Object parameterToSet = params.get( i );
                if ( parameterToSet != null && !get___JmiHelper( ).checkTypeCompatibility( connection, structureField.getType( ), parameterToSet ) ) {
                    throw new TypeMismatchException( structureField.getType( ).getClass( ), parameterToSet, this.refMetaObject( ) );
                }
                result.set___Value( structureField.getName( ), parameterToSet );
            }
        } else {
            throw new JmiException( JmiBase.JMI_BASE_0005, structName, Integer.valueOf( params.size( ) ), Integer.valueOf( structureFields.size( ) ) );
        }
        return result;
    }

    /*
     * Designed to be overwritten by generated classes: cannot be abstract
     */
    protected RefStruct create___RefStruct( Object workspace, StructureType structureType ) {

        throw new UnsupportedOperationException( );
    }

    @Deprecated
    protected RefEnum ref___GetEnum( RefObject enumType, String name ) {

        return ref___GetEnum( get___CurrentConnection( ), enumType, name );
    }

    protected RefEnum ref___GetEnum( CoreConnection connection, RefObject enumType, String name ) {

        if ( enumType instanceof EnumerationType ) {
            // createRefEnum();
            return ref___GetEnum( connection, ( (EnumerationType) enumType ).getName( ), name );
        }
        throw new InvalidCallException( enumType, null, "refGetEnum(RefObject, String)" ); //$NON-NLS-1$
    }

    @Deprecated
    protected RefEnum ref___GetEnum( String enumName, String name ) {

        return ref___GetEnum( get___CurrentConnection( ), enumName, name );
    }

    protected RefEnum ref___GetEnum( CoreConnection connection, String enumName, String name ) {

        //TODO change signature to Session
        CoreSession session = connection != null ? connection.getSession( ) : null;
        ModelElement me;
        try {
            me = get___JmiHelper( ).getAllContentMap( session, (Namespace) refMetaObject( ) ).get( enumName );
        } catch ( Exception e ) {
            throw new InvalidCallException( enumName, null, "refGetEnum(String, String)" ); //$NON-NLS-1$
        }
        EnumerationType enumerationType = null;
        if ( me instanceof EnumerationType ) {
            enumerationType = (EnumerationType) me;
        } else {
            throw new InvalidCallException( enumName, null, JmiBase.OBJECTNOTENUM, enumName );
        }
        if ( !( enumerationType.getLabels( ).contains( name ) ) ) {
            throw new InvalidNameException( name, JmiBase.LABELNOTINENUM, enumName, name );
        }
        RefEnum result = create___RefEnum( enumerationType, name );
        return result;
    }

    /*
     * Designed to be overwritten by generated classes: cannot be abstract
     */
    protected RefEnum create___RefEnum( EnumerationType enumerationType, String literalName ) {

        throw new JmiBaseRuntimeException( JmiBase.JMI_BASE_0006, new Object[] { "create___RefEnum" } ); //$NON-NLS-1$
    }

    /**
     * To be overridden by concrete subclasses
     * 
     * @param conn the current connection
     * @param synchronize <code>true</code> if the wrapper is to be synchronized
     * TODO remove synchronize parameter, no longer needed
     * @return the wrapper
     */
    public abstract Wrapper<? extends RefBaseObject> createWrapper( CoreConnection conn, boolean synchronize );

    public final EndAndMetaObject get___EndAndMetaObject( String metaObjectMofId, int endNumberOfToEnd ) {

        int fromEnd = 1 - endNumberOfToEnd;
        return this.get___Workspace( ).getWorkspaceSet( ).getEndAndMetaObjectPool( ).getEndAndMetaObject( fromEnd, metaObjectMofId );
    }

    protected static final CorePartitionable get___CompositeParentForEndAndMetaObject( CoreConnection connection, RefBaseObject child, EndAndMetaObject endAndMetaObject ) {

        RefObjectImpl childImpl = (RefObjectImpl) child;
        com.sap.tc.moin.repository.core.EndStorageLink compositeParentLink = childImpl.get___CompositeParentLink( );
        if ( compositeParentLink != RefObjectImpl.NOT_YET_RETRIEVED && !( childImpl.get___Workspace( ) instanceof CompoundClientSpecWorkspace && connection.getSession( ).getWorkspace( ).hasPrivateCopies( ) ) ) {
            if ( compositeParentLink == null ) {
                return null;
            }
            if ( compositeParentLink.getMetaObject( ).refMofId( ) == endAndMetaObject.getMetaObjectMofId( ) ) {
                return (CorePartitionable) childImpl.refImmediateComposite( connection != null ? connection.getSession( ) : null );
            } //$JL-STRING$
            return null;
        }
        return ___queryElementAtOtherLinkEnd( connection, childImpl, endAndMetaObject );
    }

    public static final CorePartitionable ___getElementAtOtherLinkEnd( CoreConnection connection, EndStorageLink link ) {

        //TODO change signature to session
        CoreSession session = connection != null ? connection.getSession( ) : null;
        CorePartitionable result = null;
        if ( link != null ) { // otherwise, the link is not set => nothing to do
            result = link.getOtherEnd( ).getWithoutException( session );
            if ( result == null && ( session != null ) ) {
                session.getConsistencyViolationRegistry( ).notifyDanglingLinkInconsistency( link.getOtherEnd( ).getLri( ), link );
            }
        }
        return result;
    }

    protected static final CorePartitionable ___queryElementAtOtherLinkEnd( CoreConnection connection, CorePartitionable elementAtEnd, EndAndMetaObject endAndMetaObject ) {

        //TODO change signature to session
        CoreSession session = connection != null ? connection.getSession( ) : null;
        QueryLinkManager linkManager;
        if ( session != null ) {
            linkManager = session.getWorkspace( ).getQueryLinkManager( );
        } else {
            if ( elementAtEnd.get___Partition( ).getPri( ).isMetaModelPartition( ) ) {
                linkManager = ( (MetamodelWorkspace) elementAtEnd.get___Workspace( ) ).getQueryLinkManager( );
            } else {
                throw new MoinUnsupportedOperationException( JmiReflectMessages.SESSIONISNULLBUTELEMENTISNOTINMETAMODELPARTITION, elementAtEnd );
            }
        }

        return linkManager.getSingleElementForEndAndMetaObject( session, endAndMetaObject, elementAtEnd );
    }

    protected final Collection ___getElementsAtOtherLinkEnd( CoreConnection connection, CorePartitionable elementAtEnd, EndAndMetaObject endAndMetaObject ) {

        return elementAtEnd.get___Workspace( ).getMemoryLinkManager( ).getElementsForEndAndMetaobject( connection, endAndMetaObject, elementAtEnd );
    }

    protected final Collection ___queryElementsAtOtherLinkEnd( CoreConnection connection, CorePartitionable elementAtEnd, EndAndMetaObject endAndMetaObject ) {

        //TODO change signature to session
        CoreSession session = connection != null ? connection.getSession( ) : null;
        if ( session != null ) {
            return session.getWorkspace( ).getQueryLinkManager( ).getElementsForEndAndMetaobject( connection, endAndMetaObject, elementAtEnd );
        } else {
            if ( elementAtEnd.get___Partition( ).getPri( ).isMetaModelPartition( ) ) {
                return ( (MetamodelWorkspace) elementAtEnd.get___Workspace( ) ).getQueryLinkManager( ).getElementsForEndAndMetaobject( connection, endAndMetaObject, elementAtEnd );
            } else {
                throw new MoinUnsupportedOperationException( JmiReflectMessages.SESSIONISNULLBUTELEMENTISNOTINMETAMODELPARTITION, elementAtEnd );
            }

        }
    }
}
