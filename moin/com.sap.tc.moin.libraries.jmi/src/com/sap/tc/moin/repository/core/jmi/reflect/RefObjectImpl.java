package com.sap.tc.moin.repository.core.jmi.reflect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.__impl.MofClassImpl;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.core.CompoundClientSpecWorkspace;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreOclRegistryService;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.EndAndMetaObject;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.Extent;
import com.sap.tc.moin.repository.core.MemoryLinkManager;
import com.sap.tc.moin.repository.core.MoinReference;
import com.sap.tc.moin.repository.core.MriReference;
import com.sap.tc.moin.repository.core.SessionWorkspace;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.jmi.extension.RefClassExtension;
import com.sap.tc.moin.repository.core.jmi.extension.RefObjectExtension;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.metamodels.DeploymentExtension;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.repository.spi.ps.SpiAssociation;
import com.sap.tc.moin.repository.spi.ps.SpiClass;
import com.sap.tc.moin.repository.spi.ps.SpiValueTypeEnum;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiElement;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiLink;
import com.sap.tc.moin.repository.transactions.microtransactionables.InstanceDeleteMicroTransactionable;
import com.sap.tc.moin.repository.transactions.microtransactionables.SingleInstanceDeleteMicroTransactionable;

/**
 * The (abstract) {@link RefObject} implementation
 */
public abstract class RefObjectImpl extends RefFeaturedImpl implements RefObject, RefObjectExtension, SpiElement {

    /**
     * Marker link for distinguishing 'null' from 'not yet retrieved'. Used by
     * the {@link #__compositeParentLink} field.
     */
    public static final EndStorageLink NOT_YET_RETRIEVED = new EndStorageLink( ) {

        public boolean canHaveDuplicates( ) {

            throw new MoinIllegalStateException( JmiReflectMessages.NOTYETRETRIEVEDLINKMETHOD );
        }

        public int getComponentEnd( ) {

            throw new MoinIllegalStateException( JmiReflectMessages.NOTYETRETRIEVEDLINKMETHOD );
        }

        public int getCompositeEnd( ) {

            throw new MoinIllegalStateException( JmiReflectMessages.NOTYETRETRIEVEDLINKMETHOD );
        }

        public MoinReference getEnd( int endNumber ) {

            throw new MoinIllegalStateException( JmiReflectMessages.NOTYETRETRIEVEDLINKMETHOD );
        }

        public MemoryLinkManager getMemoryLinkManager( CoreConnection connection ) {

            throw new MoinIllegalStateException( JmiReflectMessages.NOTYETRETRIEVEDLINKMETHOD );
        }

        public RefObject getMetaObject( ) {

            throw new MoinIllegalStateException( JmiReflectMessages.NOTYETRETRIEVEDLINKMETHOD );
        }

        public int getOrderedEnd( ) {

            throw new MoinIllegalStateException( JmiReflectMessages.NOTYETRETRIEVEDLINKMETHOD );
        }

        public MoinReference getOtherEnd( ) {

            throw new MoinIllegalStateException( JmiReflectMessages.NOTYETRETRIEVEDLINKMETHOD );
        }

        public MriReference getStorageEnd( ) {

            throw new MoinIllegalStateException( JmiReflectMessages.NOTYETRETRIEVEDLINKMETHOD );
        }

        public int getUpperBound( CoreSession session, int end ) {

            throw new MoinIllegalStateException( JmiReflectMessages.NOTYETRETRIEVEDLINKMETHOD );
        }

        public boolean isOtherEnd( int endNumber ) {

            throw new MoinIllegalStateException( JmiReflectMessages.NOTYETRETRIEVEDLINKMETHOD );
        }

        public boolean isStorageEnd( int endNumber ) {

            throw new MoinIllegalStateException( JmiReflectMessages.NOTYETRETRIEVEDLINKMETHOD );
        }

        public boolean isUpperMultiplicityOne( CoreSession session, int end ) {

            throw new MoinIllegalStateException( JmiReflectMessages.NOTYETRETRIEVEDLINKMETHOD );
        }

        public boolean logicalEquals( Object o ) {

            throw new MoinIllegalStateException( JmiReflectMessages.NOTYETRETRIEVEDLINKMETHOD );
        }

        public int getEndNumberOfOtherEnd( ) {

            throw new MoinIllegalStateException( JmiReflectMessages.NOTYETRETRIEVEDLINKMETHOD );
        }

        public int getEndNumberOfStorageEnd( ) {

            throw new MoinIllegalStateException( JmiReflectMessages.NOTYETRETRIEVEDLINKMETHOD );
        }

        public CorePartitionable getElementAtEnd( CoreSession session, int endNumber ) {

            throw new MoinIllegalStateException( JmiReflectMessages.NOTYETRETRIEVEDLINKMETHOD );
        }

        public MRI getMetaObjectMri( ) {

            throw new MoinIllegalStateException( JmiReflectMessages.NOTYETRETRIEVEDLINKMETHOD );
        }

        public MRI getStorageEndMri( ) {

            throw new MoinIllegalStateException( JmiReflectMessages.NOTYETRETRIEVEDLINKMETHOD );
        }

        public LRI getOtherEndLri( ) {

            throw new MoinIllegalStateException( JmiReflectMessages.NOTYETRETRIEVEDLINKMETHOD );
        }
    };

    /***************************************************************************
     * mandatory attributes which need to be set
     **************************************************************************/

    private RefClassImpl ___refClass = null;

    private boolean ___deleted;

    private Extent ___extent;

    /**
     * The reference to the composite parent.
     */
    private EndStorageLink __compositeParentLink = NOT_YET_RETRIEVED;

    /***************************************************************************
     * other attributes (optionally to be set)
     **************************************************************************/

    /***************************************************************************
     * constructors
     **************************************************************************/

    public RefObjectImpl( ) {

        super( );
        this.___deleted = false;
    }

    /**
     * Used by the generated JMI classes
     * 
     * @param workspace
     * @param mofId
     * @param immediatePackage
     * @param metaObject
     * @param refClass
     */
    public RefObjectImpl( Object workspace, String mofId, RefPackage immediatePackage, RefObject metaObject, RefClass refClass ) {

        super( workspace, mofId, immediatePackage, metaObject );
        set___RefClass( refClass );
        this.___deleted = false;
    }

    /***************************************************************************
     * getters and setters
     **************************************************************************/

    public final void set___RefClass( RefClass refClass ) {

        if ( refClass == null ) {
            throw new MoinIllegalArgumentException( "refClass" ); //$NON-NLS-1$
        }
        this.___refClass = (RefClassImpl) refClass;
    }

    /***************************************************************************
     * other methods
     **************************************************************************/

    /**
     * Returns either the Attribute or the Reference specified by its name
     * 
     * @param name the name of the Attribute or Reference
     * @return the Attribute or Reference specified by name
     */
    @Override
    protected final RefObject get___AttributeOrReferenceByName( String name ) {

        return ( (RefClassExtension) refClass( ) ).get___AttributeOrReferenceByName( name );
    }

    public final void set___Extent( Extent extent ) {

        this.___extent = extent;
    }

    public Extent get___Extent( ) {

        return this.___extent;
    }

    /**
     * Returns either the Attribute or the AssociationEnd specified by either
     * the Attribute's name or the name of the Reference referencing the
     * AssociationEnd.
     * 
     * @param name the name of the Attribute or Reference
     * @return the Attribute or AssociationEnd specified by name
     */
    @Override
    protected final RefObject get___AttributeOrAssociationEndByName( String name ) {

        return ( (RefClassExtension) refClass( ) ).get___AttributeOrAssociationEndByName( name );
    }

    @Override
    public final boolean is___Alive( ) {

        boolean result = false;
        if ( is___Deleted( ) ) {
            result = false;
        } else {
            Workspace workspace = get___Workspace( );
            if ( workspace != null ) {
                if ( workspace.isAlive( ) ) {
                    result = true;
                }
            }
        }
        return result;
    }

    @Override
    public final boolean is___Deleted( ) {

        return this.___deleted;
    }

    /***************************************************************************
     * ref methods
     **************************************************************************/

    @SuppressWarnings( "unchecked" )
    public boolean refIsInstanceOf( RefObject objType, boolean considerSubtypes ) {

        return refIsInstanceOf( get___CurrentConnection( ).getSession( ), objType, considerSubtypes );
    }

    /**
     * Internal version
     * 
     * @param connection
     * @param objType
     * @param considerSubtypes
     * @return <code>true</code> if this is an instance of the object type
     * provided
     */
    public boolean refIsInstanceOf( CoreSession session, RefObject objType, boolean considerSubtypes ) {

        boolean result = false;

        MofClass refMetaObject = (MofClass) refMetaObject( );
        MofClass mcObjType;
        MRI mriRefMetaObject = ( (Partitionable) refMetaObject ).get___Mri( );
        mcObjType = (MofClass) objType;
        MRI mriObjType = ( (Partitionable) mcObjType ).get___Mri( );
        result = mriRefMetaObject.equals( mriObjType );

        if ( !result && considerSubtypes ) {
            DeploymentExtension depl = ( (RefBaseObjectImpl) refMetaObject ).get___DeploymentExtension( );

            result = depl.getTypeToSupertypeMapping( ).get( refMetaObject.refMofId( ) ).contains( objType.refMofId( ) );
//                List<GeneralizableElement> allSupertypes = ( (MofClassImpl) refMetaObject ).allSupertypes( connection );
//                for ( int i = 0; !result && i < allSupertypes.size( ); i++ ) {
//                    result = ( (Partitionable) allSupertypes.get( i ) ).get___Mri( ).equals( mriObjType );
//                }
        }

        //FIXME HACK!!!
        CoreConnection connection = session != null ? session.getConnections( ).iterator( ).next( ) : null;
        if ( !result && mcObjType.getName( ).equals( "Element" ) ) { //$NON-NLS-1$
            // this is cheap!
            List<String> qn = ( (MofClassImpl) mcObjType ).getQualifiedName( connection );
            if ( qn.size( ) == 2 && qn.get( 0 ).equals( "Reflect" ) ) { //$NON-NLS-1$
                result = true;
            }
        }
        return result;
    }

    public final RefClass refClass( ) {

        return this.___refClass;
    }

    @Deprecated
    public final RefFeatured refImmediateComposite( ) {

        return refImmediateComposite( get___CurrentConnection( ).getSession( ) );
    }


    public final RefFeatured refImmediateComposite( CoreSession session ) {

        //TODO change signature to session

        RefFeatured result = null;

        if ( session != null && get___Workspace( ) instanceof CompoundClientSpecWorkspace && session.getWorkspace( ).hasPrivateCopies( ) ) {

            // __compositeParentLink must not be used if this element is in the CompoundClientSpecWorkspace and private copies exist!
            EndStorageLink link = get___Workspace( ).getWorkspaceSet( ).getLogicalLinkManager( ).getCompositeParentLink( session, this );
            if ( link != null ) {
                MoinReference refToCompositeEnd = link.getEnd( link.getCompositeEnd( ) );
                result = (RefFeatured) refToCompositeEnd.getWithoutException( session );
                if ( result == null ) {
                    session.getConsistencyViolationRegistry( ).notifyDanglingLinkInconsistency( refToCompositeEnd.getLri( ), link );
                }
            }
        } else {
            if ( __compositeParentLink == NOT_YET_RETRIEVED ) {
                EndStorageLink link = get___Workspace( ).getWorkspaceSet( ).getLogicalLinkManager( ).getCompositeParentLink( session, this );
                if ( link == null ) {
                    __compositeParentLink = null;
                } else {
                    __compositeParentLink = link;
                }
            }
            if ( __compositeParentLink != null ) {
                MoinReference refToCompositeEnd = __compositeParentLink.getEnd( __compositeParentLink.getCompositeEnd( ) );
                result = (RefFeatured) refToCompositeEnd.getWithoutException( session );
                if ( result == null ) {
                    session.getConsistencyViolationRegistry( ).notifyDanglingLinkInconsistency( refToCompositeEnd.getLri( ), __compositeParentLink );
                }
            }
        }
        return result;
    }



    protected final CorePartitionable get___CompositeParentForEndAndMetaObject( CoreConnection connection, EndAndMetaObject endAndMetaObject ) {

        return get___CompositeParentForEndAndMetaObject( connection, this, endAndMetaObject );
    }

    @Deprecated
    public final RefFeatured refOutermostComposite( ) {

        return refOutermostComposite( get___CurrentConnection( ).getSession( ) );
    }

    @Override
    protected Collection<JmiException> refVerifyConstraints( CoreConnection connection, boolean deepVerify ) {

        CoreOclRegistryService srv = connection.getSession( ).getCoreOclRegistryService( );
        Collection<JmiException> result = srv.refVerifyConstraints( connection, this, deepVerify );
        if ( result.isEmpty( ) ) {
            return null;
        }
        return result;
    }

    /**
     * @param connection
     * @return the outermost composite, or null
     */
    public final RefFeatured refOutermostComposite( CoreSession session ) {

        RefFeatured rf = refImmediateComposite( session );
        RefFeatured rfTemp = rf;
        while ( rfTemp != null ) {
            if ( rfTemp instanceof RefObject ) {
                rfTemp = ( (RefObjectImpl) rfTemp ).refImmediateComposite( session );
                if ( rfTemp != null ) {
                    rf = rfTemp;
                }
            } else {
                rfTemp = null;
            }
        }
        if ( rf == null ) {
            rf = this;
        }
        return rf;
    }

    @Deprecated
    public final void refDelete( ) {

        refDelete( get___CurrentConnection( ) );
    }

    /**
     * Internal version
     * 
     * @param connection
     */
    public final void refDelete( CoreConnection connection ) {

        InstanceDeleteMicroTransactionable idmtx = get___MicroTransactionableFactory( ).createInstanceDeleteMicroTransactionable( connection, this );
        connection.getSession( ).getTransactionManager( ).runInMicroTransaction( idmtx );
    }

    @Override
    public final void delete___Isolated( CoreConnection connection ) {

        SingleInstanceDeleteMicroTransactionable mtx = get___MicroTransactionableFactory( ).createIsolatedInstanceDeleteMicroTransactionable( connection, this );
        connection.getSession( ).getTransactionManager( ).runInMicroTransaction( mtx );
    }

    @Override
    public final void ___delete( ) {

        this.___deleted = true;
        set___Workspace( null );
    }

    /***************************************************************************
     * java.lang.Object level methods
     **************************************************************************/

    @Override
    public String toString( ) {

        StringBuilder result = new StringBuilder( );
        result.append( "{" ); //$NON-NLS-1$
        if ( refMetaObject( ) != null ) {
            result.append( getClass( ).getName( ) );
            result.append( " " ); //$NON-NLS-1$
            if ( this instanceof ModelElement ) {
                // M2
                result.append( "\"" ); //$NON-NLS-1$
                result.append( ( (ModelElement) this ).getName( ) );
                result.append( "\"" ); //$NON-NLS-1$
                result.append( " " ); //$NON-NLS-1$
            } else {
                // M1
                // do not what to print in this case, a name attribute?
                // print nothing
                // result.append("");
            }

            // to be resused later, once we have the special MofRom classes!
            // ModelElement refMetaObject = (ModelElement) refMetaObject();
            // for (Iterator i = refMetaObject.getQualifiedName()
            // .iterator(); i.hasNext();) {
            // String name = (String) i.next();
            // result.append(name + (i.hasNext() ? "::" : ""));
            // }
            // result.append(" ");
            // if (this instanceof ModelElement) {
            // // M2
            // result.append("\"");
            // for (Iterator i = ((ModelElement) this).getQualifiedName()
            // .iterator(); i.hasNext();) {
            // String name = (String) i.next();
            // result.append(name + (i.hasNext() ? "::" : ""));
            // }
            // result.append("\"");
            // result.append(" ");
            // } else {
            // // M1
            // // do not what to print in this case, a name attribute?
            // result.append("\"<M1 instance>\"");
            // }
        } else {
            result.append( "<?>" ); //$NON-NLS-1$
        }
        result.append( this.___mri );
        result.append( "}" ); //$NON-NLS-1$
        return result.toString( );
    }

    public void set___CompositeParentLink( EndStorageLink linkToCompositeParent ) {

        __compositeParentLink = linkToCompositeParent;
    }

    public EndStorageLink get___CompositeParentLink( ) {

        return __compositeParentLink;
    }

    @Override
    public java.util.List<com.sap.tc.moin.repository.core.EndStorageLink> clear___AllLinks( ) {

        // meaningful implementation in subclasses
        reset___CompositeParentLink( );
        return null;
    }

    public final void reset___CompositeParentLink( ) {

        __compositeParentLink = NOT_YET_RETRIEVED;
    }

    //
    // Custom Parser / Serializer methods
    //

    @SuppressWarnings( "unchecked" )
    public Object get___AttributeValue( String attributeName ) {

        SpiValueTypeEnum attributeType = ___refClass.get___AttributeTypeAsEnum( attributeName );
        if ( attributeType == SpiValueTypeEnum.OBJECT_TYPED ) {
            String attributeMofId = ___refClass.get___AttributeMofId( attributeName );
            if ( ___refClass.is___MultiValuedAttribute( attributeName ) ) {
                Collection<EndStorageLink> linkCollection = get___AttributeLinks( attributeMofId );
                if ( linkCollection != null ) {
                    List newCollection = new ArrayList( linkCollection.size( ) );
                    for ( EndStorageLink link : linkCollection ) {
                        newCollection.add( getOtherLinkEndValue( link ) );
                    }
                    return newCollection;
                }
            } else {
                // Special handling of multiplicity-one object-valued attributes to be able to cope with dangling links.
                // => refGetValue() cannot be used here, we have to look at the link itself.
                EndStorageLink attributeLink = get___AttributeLink( attributeMofId );
                if ( attributeLink != null ) {
                    return getOtherLinkEndValue( attributeLink );
                }
            }
        } else {
            // Passing 'null' for the connection works since we are only retrieving attribute values (and not references) !
            Object value = refGetValue( null /* connection */, attributeName );
            if ( value != null ) {
                if ( attributeType != SpiValueTypeEnum.STRUCTURE_TYPE ) {
                    // Must be either a PrimitiveType'd or EnumerationType'd attribute.
                    if ( !___refClass.is___MultiValuedAttribute( attributeName ) ) {
                        return value.toString( );
                    } else {
                        if ( attributeType != SpiValueTypeEnum.PRIMITIVE_TYPE_STRING ) {
                            Collection coll = (Collection) value;
                            ArrayList<String> result = new ArrayList( coll.size( ) );
                            for ( Object o : coll ) {
                                result.add( o.toString( ) );
                            }
                            return result;
                        } else {
                            return value;
                        }
                    }
                }
                return value;
            }
        }
        return null;
    }

    private Object getOtherLinkEndValue( EndStorageLink link ) {

        Object result = null;
        MoinReference otherEnd = link.getOtherEnd( );
        if ( otherEnd.isCached( ) ) {
            CorePartitionable partitionable = otherEnd.get( null /* session */);
            if ( partitionable.get___Partition( ).getPri( ).equals( get___Mri( ).getPri( ) ) ) {
                result = partitionable;
            }
        } else {
            CorePartitionable instance = get___Partition( ).getWorkspace( ).getInstanceManager( ).getInstance( null /* session */, otherEnd.getLri( ) );
            if ( instance != null ) {
                if ( instance.get___Partition( ).getPri( ).equals( get___Mri( ).getPri( ) ) ) {
                    result = instance;
                }
            }
        }
        if ( result == null ) {
            result = otherEnd.getLri( );
        }
        return result;
    }

    public Map<SpiAssociation, List<SpiLink>> get___LinksByAssociation( ) {

        Map<SpiAssociation, List<SpiLink>> result = null;
        List<EndStorageLink> allLinks = get___AllStoredAssociationLinks( );
        if ( allLinks != null ) {
            Comparator mofIdComparator = get___Workspace( ).getWorkspaceSet( ).getMoin( ).getByMofIdComparator( );
            result = new TreeMap<SpiAssociation, List<SpiLink>>( mofIdComparator );
            SpiJmiHelper jmiHelper = get___JmiHelper( );
            for ( int i = 0, n = allLinks.size( ); i < n; i++ ) {
                EndStorageLink link = allLinks.get( i );
                SpiAssociation association = (SpiAssociation) jmiHelper.getRefAssociationForAssociation( (Session) null /* session */, (Association) link.getMetaObject( ) );
                List<SpiLink> links = result.get( association );
                if ( links == null ) {
                    result.put( association, links = new ArrayList<SpiLink>( ) );
                }
                links.add( (SpiLink) link );
            }
        }
        if ( result != null ) {
            return result;
        }
        return Collections.emptyMap( );
    }

    public String get___MofId( ) {

        return refMofId( );
    }

    public SpiClass get___Type( ) {

        return ___refClass;
    }

    public static boolean isCachingOfCompositeParentLinkAllowed( CorePartitionable compositeElement, CorePartitionable childElement ) {

        Workspace workspaceOfParentElement = compositeElement.get___Workspace( );
        Workspace workspaceOfChildElement = childElement.get___Workspace( );
        boolean result = false;
        if ( workspaceOfParentElement == workspaceOfChildElement ) {
            result = true;
        } else if ( workspaceOfChildElement instanceof SessionWorkspace ) {
            result = true;
        } else if ( workspaceOfChildElement instanceof CompoundClientSpecWorkspace ) {
            result = workspaceOfParentElement.isShared( );
        } else if ( workspaceOfChildElement.isShared( ) ) {
            result = false;
        }
        return result;
    }

}