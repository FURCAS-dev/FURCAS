package com.sap.tc.moin.repository.core.jmi.reflect;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndImpl;
import com.sap.tc.moin.repository.mmi.reflect.InvalidCallException;
import com.sap.tc.moin.repository.mmi.reflect.InvalidNameException;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.mmi.reflect.TypeMismatchException;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.AssociationExtent;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.EndAndMetaObject;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.EndStorageLinkManager;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.MetamodelWorkspace;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.jmi.extension.RefAssociationExtension;
import com.sap.tc.moin.repository.core.jmi.extension.RefFeaturedExtension;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinIllegalNullArgumentException;
import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;
import com.sap.tc.moin.repository.metamodels.DeploymentExtension;
import com.sap.tc.moin.repository.shared.util.QualifiedName;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.repository.spi.ps.SpiAssociation;
import com.sap.tc.moin.repository.spi.ps.SpiClass;
import com.sap.tc.moin.repository.spi.ps.SpiType;
import com.sap.tc.moin.repository.transactions.microtransactionables.LinkAddElementMicroTransactionable;
import com.sap.tc.moin.repository.transactions.microtransactionables.LinkRemoveElementMicroTransactionable;
import com.sap.tc.moin.repository.transactions.microtransactionables.ReferenceChangeMicroTransactionable;

/**
 * The (abstract) {@link RefAssociation} implementation
 */
public abstract class RefAssociationImpl extends RefBaseObjectImpl implements AssociationExtent, RefAssociation, RefAssociationExtension, SpiAssociation {

    /***************************************************************************
     * Caches for M2 information; called by Jmihelper
     **************************************************************************/

    /**
     * Cache for the ends of this association.
     */
    private List<AssociationEnd> associationEnds;

    /**
     * Cache for the information which association end has storage defined.
     */
    private byte storedEnd = Byte.MIN_VALUE;

    /**
     * Cache for the information which association end is composite.
     */
    private byte compositeEnd = Byte.MIN_VALUE;

    /**
     * Cache for the information which association end is ordered.
     */
    private byte orderedEnd = Byte.MIN_VALUE;

    /**
     * Caches the qualified name in dot-separated String notation.
     */
    private String dotSeparatedQualifiedName;

    /***************************************************************************
     * constructors
     **************************************************************************/
    public RefAssociationImpl( ) {

        super( );
    }

    /**
     * To be used by the generated JMI classes
     * 
     * @param workspace
     * @param mofId
     * @param immediatePackage
     * @param metaObject
     */
    public RefAssociationImpl( Object workspace, String mofId, RefPackage immediatePackage, RefObject metaObject ) {

        super( (Workspace) workspace, mofId, immediatePackage, metaObject, ( (Workspace) workspace ).getPartitionManager( ).getExtentPartition( ) );
    }

    @Override
    public final Association refMetaObject( ) {

        return (Association) super.refMetaObject( );
    }

    /***************************************************************************
     * AssociationExtent methods
     **************************************************************************/

    public List<AssociationEnd> get___AssociationEnds( ) {

        return associationEnds;
    }

    public void set___AssociationEnds( List<AssociationEnd> ends ) {

        associationEnds = ends;
    }

    public byte get___StoredEnd( ) {

        return storedEnd;
    }

    public void set___StoredEnd( byte end ) {

        storedEnd = end;
    }

    public byte get___CompositeEnd( ) {

        return compositeEnd;
    }

    public void set___CompositeEnd( byte end ) {

        compositeEnd = end;
    }

    public byte get___OrderedEnd( ) {

        return orderedEnd;
    }

    public void set___OrderedEnd( byte end ) {

        orderedEnd = end;
    }

    /***************************************************************************
     * ref methods
     **************************************************************************/


    @Deprecated
    public final boolean refLinkExists( RefObject firstEnd, RefObject secondEnd ) {

        return refLinkExists( get___CurrentConnection( ), firstEnd, secondEnd );
    }

    public boolean refLinkExists( CoreConnection connection, RefObject firstEnd, RefObject secondEnd ) {

        if ( firstEnd == null || secondEnd == null ) {
            // TODO throw JmiException
            return false;
        }
        checkTypesForRefLinkExists( connection, firstEnd, secondEnd );
        return ___exists( connection, firstEnd, secondEnd );
    }

    @Deprecated
    public final Collection<RefObject> refQuery( RefObject queryEnd, RefObject queryObject ) {

        throw new MoinUnsupportedOperationException( JmiReflectMessages.REFQUERYWITHOUTCONNECTIONISNOTSUPPORTED );
    }

    public final JmiList<RefObject> refQuery( CoreConnection connection, RefObject queryEnd, RefObject queryObject ) {

        Association association = refMetaObject( );
        List<AssociationEnd> ends = this.get___JmiHelper( ).getAssociationEnds( connection.getSession( ), association );
        if ( !ends.get( 0 ).equals( queryEnd ) && !ends.get( 1 ).equals( queryEnd ) ) {
            // query end does not designate an association end for this
            // association object
            throw new InvalidCallException( queryEnd, queryEnd.refMetaObject( ) );
        }
        if ( ends.get( 0 ).equals( queryEnd ) && !( (RefObjectImpl) queryObject ).refIsInstanceOf( connection.getSession( ), ( (AssociationEndImpl) ends.get( 0 ) ).getType( connection ), true ) ) {
            // query end number is 0 but query object is not an instance object
            // with the same type as query end 0
            throw new TypeMismatchException( ( (AssociationEndImpl) ends.get( 0 ) ).getType( connection ).getClass( ), queryObject, queryObject.refMetaObject( ) );
        }
        if ( ends.get( 1 ).equals( queryEnd ) && !( (RefObjectImpl) queryObject ).refIsInstanceOf( connection.getSession( ), ( (AssociationEndImpl) ends.get( 1 ) ).getType( connection ), true ) ) {
            // query end number is 1 but query object is not an instance object
            // with the same type as query end 1
            throw new TypeMismatchException( ( (AssociationEndImpl) ends.get( 1 ) ).getType( connection ).getClass( ), queryObject, queryObject.refMetaObject( ) );
        }
        try {
            return refQuery( connection, ( (AssociationEnd) queryEnd ).getName( ), queryObject );
        } catch ( InvalidNameException e ) {
            throw new InvalidCallException( queryEnd, queryEnd.refMetaObject( ) );
        }
    }

    @Deprecated
    public final Collection<RefObject> refQuery( String queryEndName, RefObject queryObject ) {

        throw new MoinUnsupportedOperationException( JmiReflectMessages.REFQUERYWITHOUTCONNECTIONISNOTSUPPORTED );
    }

    public final JmiList<RefObject> refQuery( CoreConnection connection, String queryEndName, RefObject queryObject ) {

        Association association = refMetaObject( );
        List<AssociationEnd> ends = this.get___JmiHelper( ).getAssociationEnds( connection.getSession( ), association );
        if ( !ends.get( 0 ).getName( ).equals( queryEndName ) && !ends.get( 1 ).getName( ).equals( queryEndName ) ) {
            // query end does not designate an association end for this
            // association object
            throw new InvalidCallException( queryEndName, null );
        }
        if ( ends.get( 0 ).getName( ).equals( queryEndName ) && !( (RefObjectImpl) queryObject ).refIsInstanceOf( connection.getSession( ), ( (AssociationEndImpl) ends.get( 0 ) ).getType( connection ), true ) ) {
            // query end number is 0 but query object is not an instance object
            // with the same type as query end 0
            throw new TypeMismatchException( ( (AssociationEndImpl) ends.get( 0 ) ).getType( connection ).getClass( ), queryObject, queryObject.refMetaObject( ) );
        }
        if ( ends.get( 1 ).getName( ).equals( queryEndName ) && !( (RefObjectImpl) queryObject ).refIsInstanceOf( connection.getSession( ), ( (AssociationEndImpl) ends.get( 1 ) ).getType( connection ), true ) ) {
            // query end number is 1 but query object is not an instance object
            // with the same type as query end 1
            throw new TypeMismatchException( ( (AssociationEndImpl) ends.get( 1 ) ).getType( connection ).getClass( ), queryObject, queryObject.refMetaObject( ) );
        }

        return ___refQuery( connection, queryEndName, queryObject );
    }

    @Deprecated
    public final boolean refAddLink( RefObject firstEnd, RefObject secondEnd ) {

        return refAddLink( get___CurrentConnection( ), firstEnd, secondEnd );
    }

    public final boolean refAddLink( CoreConnection connection, RefObject firstEnd, RefObject secondEnd ) {

        /*
         * Don't set the composite here to avoid recursion in MOF 1.4 M3 layer
         * // set the composite variable if
         * (AggregationKindEnum.COMPOSITE.equals(___aeFirst.getAggregation())) {
         * ((IMMRInstance) secondEnd).set___ImmediateComposite(firstEnd); } if
         * (AggregationKindEnum.COMPOSITE.equals(___aeSecond.getAggregation()))
         * { ((IMMRInstance) firstEnd).set___ImmediateComposite(secondEnd); }
         */
        return add___AssociationEnds( connection, firstEnd, secondEnd, null /* addedViaReference */);
    }

    @Deprecated
    public final boolean refRemoveLink( RefObject firstEnd, RefObject secondEnd ) {

        return refRemoveLink( get___CurrentConnection( ), firstEnd, secondEnd );
    }

    public final boolean refRemoveLink( CoreConnection connection, RefObject firstEnd, RefObject secondEnd ) {

        return ___remove( connection, firstEnd, secondEnd );
    }

    /***************************************************************************
     * java.lang.Object level methods
     **************************************************************************/

    @Override
    public String toString( ) {

        StringBuffer result = new StringBuffer( );
        result.append( "{RefAssociation" ); //$NON-NLS-1$
        result.append( " " ); //$NON-NLS-1$
        if ( refMetaObject( ) != null ) {
            List<String> qn = refMetaObject( ).getQualifiedName( );
            result.append( "\"" ); //$NON-NLS-1$
            for ( Iterator<String> i = qn.iterator( ); i.hasNext( ); ) {
                String name = i.next( );
                result.append( name + ( i.hasNext( ) ? "::" : "" ) ); //$NON-NLS-1$ //$NON-NLS-2$
            }
            result.append( "\"" ); //$NON-NLS-1$
        } else {
            result.append( "\"<?>\"" ); //$NON-NLS-1$
        }
        result.append( " " ); //$NON-NLS-1$
        result.append( refMofId( ) );
        result.append( "}" ); //$NON-NLS-1$
        return result.toString( );
    }

    /***************************************************************************
     * private methods
     **************************************************************************/

    protected final EndAndMetaObject get___EndAndMetaObject( int endNumber ) {

        Association association = refMetaObject( );
        return this.get___Workspace( ).getWorkspaceSet( ).getEndAndMetaObjectPool( ).getEndAndMetaObject( endNumber, association );
    }

    /**
     * This method checks the existence of a link. It has to be overwritten by
     * implementations of derived associations. These implementations then
     * usually delegate to their implementation of the exists method.
     */
    protected boolean ___exists( CoreConnection connection, RefObject firstEnd, RefObject secondEnd ) {

        AssociationEnd end = null;
        RefFeaturedExtension elementToAsk = null;
        LRI elementToSearch = null;
        if ( this.storedEnd == SpiJmiHelper.STORED_END_0 ) {
            end = get___AssociationEnds( ).get( 1 );
            elementToAsk = (RefFeaturedExtension) firstEnd;
            elementToSearch = ( (CorePartitionable) secondEnd ).get___Mri( ).getLri( );
        } else {
            end = get___AssociationEnds( ).get( 0 );
            elementToAsk = (RefFeaturedExtension) secondEnd;
            elementToSearch = ( (CorePartitionable) firstEnd ).get___Mri( ).getLri( );
        }
        if ( end.getMultiplicity( ).getUpper( ) == 1 ) {
            return ( elementToAsk.get___AssociationLink( end.refMofId( ) ) != null );
        }
        Collection<EndStorageLink> links = elementToAsk.get___AssociationLinks( end.refMofId( ) );
        if ( links == null ) {
            return false;
        }
        for ( EndStorageLink endStorageLink : links ) {
            if ( endStorageLink.getOtherEnd( ).getLri( ).equals( elementToSearch ) ) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public boolean add___AssociationEnds( RefObject firstEnd, RefObject secondEnd, com.sap.tc.moin.repository.mmi.model.Reference addedViaReference ) {

        return add___AssociationEnds( get___CurrentConnection( ), firstEnd, secondEnd, addedViaReference );
    }

    public boolean add___AssociationEnds( CoreConnection connection, RefObject firstEnd, RefObject secondEnd, com.sap.tc.moin.repository.mmi.model.Reference addedViaReference ) {

        byte addedViaReferenceOnEnd = ( addedViaReference == null ) ? Workspace.LINK_NOT_ADDED_VIA_REFERENCE : this.get___JmiHelper( ).getAssociationEndNumber( connection.getSession( ), addedViaReference.getReferencedEnd( ) );
        Association association = refMetaObject( );
        boolean returnValue = true;
        if ( addedViaReference == null ) {
            LinkAddElementMicroTransactionable mtx = get___MicroTransactionableFactory( ).createLinkAddElementMicroTransactionable( connection, association, firstEnd, secondEnd );
            connection.getSession( ).getTransactionManager( ).runInMicroTransaction( mtx );
            returnValue = mtx.linkSetChanged( );
        } else {
            ReferenceChangeMicroTransactionable mtx = get___MicroTransactionableFactory( ).createReferenceChangeMicroTransactionable( connection, firstEnd, addedViaReference, association, secondEnd, addedViaReferenceOnEnd );
            connection.getSession( ).getTransactionManager( ).runInMicroTransaction( mtx );
            returnValue = mtx.referenceChanged( );
        }
        return returnValue;
    }

    /**
     * This method removes a link to the workspace. It has to be overwritten by
     * implementations of derived associations. These implementations then
     * usually delegate to their implementation of the remove method.
     */
    protected boolean ___remove( CoreConnection connection, RefObject firstEnd, RefObject secondEnd ) {

        Association association = refMetaObject( );
        LinkRemoveElementMicroTransactionable mtx = null;
        if ( connection.getCoreJmiHelper( ).isEndStored( connection.getSession( ), 0, association ) ) {
            mtx = get___MicroTransactionableFactory( ).createLinkRemoveElementMicroTransactionable( connection, association, firstEnd, (byte) 0, secondEnd );
        } else {
            mtx = get___MicroTransactionableFactory( ).createLinkRemoveElementMicroTransactionable( connection, association, secondEnd, (byte) 1, firstEnd );
        }
        connection.getSession( ).getTransactionManager( ).runInMicroTransaction( mtx );
        boolean returnValue = mtx.linkSetChanged( );
        return returnValue;
    }

    /**
     * This method returns a collection of instance objects from the link
     * container that are linked to the supplied queryObject where the links all
     * have the queryObject at the end with the queryEndName. The query starts
     * from object queryObject. It has to be overwritten by implementations of
     * derived associations. These implementations then usually delegate to
     * their implementation of the appropriate accessor methods.
     * 
     * @param connection
     */
    private JmiList ___refQuery( CoreConnection connection, String queryEndName, RefObject queryObject ) {

        ___assertValidQueryObject( queryObject );
        final Association association = refMetaObject( );
        if ( association.isDerived( ) ) {
            final Collection derivedResult = ___query( connection, queryEndName, queryObject );
            return new IterableOnlyJmiList( association, this.___workspace, derivedResult );
        }

        SpiJmiHelper jmiHelper = this.get___JmiHelper( );
        List<AssociationEnd> ends = jmiHelper.getAssociationEnds( connection.getSession( ), association );
        AssociationEnd assocEnd0 = ends.get( 0 );
        AssociationEnd assocEnd1 = ends.get( 1 );
        if ( assocEnd0.getName( ).equals( queryEndName ) ) {
            try {
                if ( jmiHelper.isEndStored( connection.getSession( ), assocEnd0 ) ) {
                    return (JmiList) ___getElementsAtOtherLinkEnd( connection, (CorePartitionable) queryObject, get___EndAndMetaObject( 0 ) );
                }
                return (JmiList) ___queryElementsAtOtherLinkEnd( connection, (CorePartitionable) queryObject, get___EndAndMetaObject( 0 ) );
            } catch ( com.sap.tc.moin.repository.mmi.reflect.JmiException e ) {
                throw new JmiException( e );
            }
        } else if ( assocEnd1.getName( ).equals( queryEndName ) ) {
            try {
                if ( jmiHelper.isEndStored( connection.getSession( ), assocEnd1 ) ) {
                    return (JmiList) ___getElementsAtOtherLinkEnd( connection, (CorePartitionable) queryObject, get___EndAndMetaObject( 1 ) );
                }
                return (JmiList) ___queryElementsAtOtherLinkEnd( connection, (CorePartitionable) queryObject, get___EndAndMetaObject( 1 ) );
            } catch ( com.sap.tc.moin.repository.mmi.reflect.JmiException e ) {
                throw new JmiException( e );
            }
        } else {
            throw new InvalidCallException( queryEndName, null );
        }
    }

    protected java.util.Collection ___query( com.sap.tc.moin.repository.core.CoreConnection connection, java.lang.String queryEndName, com.sap.tc.moin.repository.mmi.reflect.RefObject queryObject ) throws com.sap.tc.moin.repository.mmi.reflect.JmiException {

        //meaningful implementation is in generated subclasses
        //only needed for derived associations
        throw new MoinUnsupportedOperationException( JmiReflectMessages.IMPLEMENTATIONCLASSDOESNOTOVERRIDETHISMETHOD );
    }

    @Override
    public final MetamodelWorkspace get___Workspace( ) {

        // an extent is always in the metamodel workspace
        return (MetamodelWorkspace) this.___workspace;
    }

    private void ___assertValidQueryObject( RefObject queryObject ) {

        if ( queryObject == null ) {
            throw new MoinIllegalNullArgumentException( "queryObject" ); //$NON-NLS-1$
        }
    }

    protected final boolean ___existsMult1( CoreConnection connection, RefBaseObject fromElement, RefBaseObject toElement, String associationEndMofId ) {

        if ( fromElement == null || toElement == null ) {
            return false;
        }
        EndStorageLink link = ( (RefFeaturedExtension) fromElement ).get___AssociationLink( associationEndMofId );
        return ___getElementAtOtherLinkEnd( connection, link ) == toElement;
    }

    protected final boolean ___existsMultN( CoreConnection connection, RefBaseObject fromElement, RefBaseObject toElement, String associationEndMofId ) {

        if ( fromElement == null || toElement == null ) {
            return false;
        }
        Collection<EndStorageLink> links = ( (RefFeaturedExtension) fromElement ).get___AssociationLinks( associationEndMofId );
        if ( links != null ) {
            for ( EndStorageLink link : links ) {
                if ( ___getElementAtOtherLinkEnd( connection, link ) == toElement ) {
                    return true;
                }
            }
        }
        return false;
    }

    protected final void checkTypesForRefLinkExists( CoreConnection connection, RefObject firstEnd, RefObject secondEnd ) {

        Association association = refMetaObject( );
        List<AssociationEnd> ends = this.get___JmiHelper( ).getAssociationEnds( connection.getSession( ), association );
        if ( !( (RefObjectImpl) firstEnd ).refIsInstanceOf( connection.getSession( ), ( (AssociationEndImpl) ends.get( 0 ) ).getType( connection ), true ) ) {
            throw new TypeMismatchException( ( (AssociationEndImpl) ends.get( 0 ) ).getType( connection ).getClass( ), firstEnd, firstEnd.refMetaObject( ) );
        }
        if ( !( (RefObjectImpl) secondEnd ).refIsInstanceOf( connection.getSession( ), ( (AssociationEndImpl) ends.get( 1 ) ).getType( connection ), true ) ) {
            throw new TypeMismatchException( ( (AssociationEndImpl) ends.get( 1 ) ).getType( connection ).getClass( ), secondEnd, secondEnd.refMetaObject( ) );
        }
    }

    protected final CorePartitionable ___getElementAtOtherLinkEnd( CoreConnection connection, CorePartitionable elementAtEnd, String associationEndMofId ) {

        ___assertValidQueryObject( (RefObject) elementAtEnd );
        EndStorageLink link = ( (RefFeaturedExtension) elementAtEnd ).get___AssociationLink( associationEndMofId );
        return ___getElementAtOtherLinkEnd( connection, link );
    }

    //
    // Custom Parser / Serializer methods 
    // 

    public String get___MofId( ) {

        return refMetaObject( ).refMofId( );
    }

    public String get___QualifiedName( ) {

        if ( dotSeparatedQualifiedName == null ) {
            RefObjectImpl refObj = (RefObjectImpl) refMetaObject( );
            DeploymentExtension deploymentExtension = refObj.get___DeploymentExtension( );
            List<String> qNameAsList = deploymentExtension.getMofIdQualifiedNameMapping( ).get( refObj.refMofId( ) );
            dotSeparatedQualifiedName = QualifiedName.toDotSeparatedString( qNameAsList );
        }
        return dotSeparatedQualifiedName;
    }

    public String get___MetamodelContainer( ) {

        return ( (Partitionable) refMetaObject( ) ).get___Partition( ).getPri( ).getContainerName( );
    }

    @SuppressWarnings( "unchecked" )
    public List<SpiType> get___AllSuperTypes( ) {

        return Collections.emptyList( ); // no inheritance for associations
    }

    public int get___CompositeEndNumber( ) {

        return get___JmiHelper( ).getCompositeEnd( null /* session */, refMetaObject( ) );
    }

    public int get___OrderedEndNumber( ) {

        return get___JmiHelper( ).getOrderedEnd( null /* session */, refMetaObject( ) );
    }

    public int get___StoredEndNumber( ) {

        return get___JmiHelper( ).getStoredEnd( null /* session */, refMetaObject( ) );
    }

    public int get___EndNumber( String nameOfAssociationEnd ) {

        if ( nameOfAssociationEnd != null ) {
            List<AssociationEnd> ends = get___JmiHelper( ).getAssociationEnds( null /* session */, refMetaObject( ) );
            for ( int i = 0; i < 2; i++ ) {
                if ( ends.get( i ).getName( ).equals( nameOfAssociationEnd ) ) {
                    return i;
                }
            }
        }
        return -1;
    }

    public SpiClass get___EndType( int endNumber ) {

        if ( endNumber != 0 && endNumber != 1 ) {
            throw new MoinIllegalArgumentException( JmiReflectMessages.ENDNUMBERMUSTBEZEROORONE );
        }
        SpiJmiHelper jmiHelper = get___JmiHelper( );
        AssociationEnd end = jmiHelper.getAssociationEnds( null /* session */, refMetaObject( ) ).get( endNumber );
        return (SpiClass) jmiHelper.getRefClassForMofClass( null /* session */, (MofClass) jmiHelper.getType( null /* session */, end ) );
    }

    public static final class IterableOnlyJmiList extends AbstractList implements JmiList {

        private Association association;

        private Collection<RefObject> backingCollection;

        private Workspace workspace;

        public IterableOnlyJmiList( Association association, Workspace workspace, Collection<RefObject> backingCollection ) {

            super( );
            this.workspace = workspace;
            this.association = association;
            this.backingCollection = backingCollection;
        }

        public void add( CoreConnection connection, int index, Object element ) {

            throw new MoinUnsupportedOperationException( JmiReflectMessages.METHODNOTSUPPORTEDFORDERIVEDASSOCATION, association );
        }

        public boolean add( CoreConnection connection, Object element ) {

            throw new MoinUnsupportedOperationException( JmiReflectMessages.METHODNOTSUPPORTEDFORDERIVEDASSOCATION, association );
        }

        public boolean addAll( CoreConnection connection, int index, Collection elements ) {

            throw new MoinUnsupportedOperationException( JmiReflectMessages.METHODNOTSUPPORTEDFORDERIVEDASSOCATION, association );
        }

        public boolean addAll( CoreConnection connection, Collection elements ) {

            throw new MoinUnsupportedOperationException( JmiReflectMessages.METHODNOTSUPPORTEDFORDERIVEDASSOCATION, association );
        }

        public void clear( CoreConnection connection ) {

            throw new MoinUnsupportedOperationException( JmiReflectMessages.METHODNOTSUPPORTEDFORDERIVEDASSOCATION, association );

        }

        public boolean contains( CoreConnection connection, Object o ) {

            return backingCollection.contains( o );
        }

        public boolean containsAll( CoreConnection connection, Collection c ) {

            return backingCollection.containsAll( c );
        }

        public boolean equals( CoreConnection connection, Object obj ) {

            return backingCollection.equals( obj );
        }

        public Object get( CoreSession session, int index ) {

            throw new MoinUnsupportedOperationException( JmiReflectMessages.METHODNOTSUPPORTEDFORDERIVEDASSOCATION, association );
        }

        public EndAndMetaObject getEndAndMetaObject( ) {

            throw new MoinUnsupportedOperationException( JmiReflectMessages.METHODNOTSUPPORTEDFORDERIVEDASSOCATION, association );
        }

        public MRI getFromEnd( ) {

            throw new MoinUnsupportedOperationException( JmiReflectMessages.METHODNOTSUPPORTEDFORDERIVEDASSOCATION, association );
        }

        public Object getIdentity( ) {

            throw new MoinUnsupportedOperationException( JmiReflectMessages.METHODNOTSUPPORTEDFORDERIVEDASSOCATION, association );
        }

        public Collection getLinkCollection( ) {

            throw new MoinUnsupportedOperationException( JmiReflectMessages.METHODNOTSUPPORTEDFORDERIVEDASSOCATION, association );
        }

        public EndStorageLinkManager getLinkManager( CoreConnection connection ) {

            throw new MoinUnsupportedOperationException( JmiReflectMessages.METHODNOTSUPPORTEDFORDERIVEDASSOCATION, association );
        }

        public Workspace getWorkspace( ) {

            return workspace;
        }

        public int hashCode( CoreConnection connection ) {

            return backingCollection.hashCode( );
        }

        public int indexOf( CoreConnection connection, Object o ) {

            throw new MoinUnsupportedOperationException( JmiReflectMessages.METHODNOTSUPPORTEDFORDERIVEDASSOCATION, association );
        }

        public void invalidate( ) {

            throw new MoinUnsupportedOperationException( JmiReflectMessages.METHODNOTSUPPORTEDFORDERIVEDASSOCATION, association );

        }

        public boolean isEmpty( CoreSession session ) {

            return backingCollection.isEmpty( );
        }

        public boolean isOrdered( ) {

            return false;
        }

        public boolean isValid( ) {

            return true;
        }

        public Iterator iterator( CoreConnection connection ) {

            return backingCollection.iterator( );
        }

        public Iterator iteratorReadOnly( CoreSession session ) {

            return backingCollection.iterator( );
        }

        public int lastIndexOf( CoreConnection connection, Object o ) {

            throw new MoinUnsupportedOperationException( JmiReflectMessages.METHODNOTSUPPORTEDFORDERIVEDASSOCATION, association );
        }

        public ListIterator listIterator( CoreConnection connection ) {

            throw new MoinUnsupportedOperationException( JmiReflectMessages.METHODNOTSUPPORTEDFORDERIVEDASSOCATION, association );
        }

        public ListIterator listIterator( CoreConnection connection, int index ) {

            throw new MoinUnsupportedOperationException( JmiReflectMessages.METHODNOTSUPPORTEDFORDERIVEDASSOCATION, association );
        }

        public boolean remove( CoreConnection connection, Object element ) {

            throw new MoinUnsupportedOperationException( JmiReflectMessages.METHODNOTSUPPORTEDFORDERIVEDASSOCATION, association );
        }

        public Object remove( CoreConnection connection, int index ) {

            throw new MoinUnsupportedOperationException( JmiReflectMessages.METHODNOTSUPPORTEDFORDERIVEDASSOCATION, association );
        }

        public boolean removeAll( CoreConnection connection, Collection elements ) {

            throw new MoinUnsupportedOperationException( JmiReflectMessages.METHODNOTSUPPORTEDFORDERIVEDASSOCATION, association );
        }

        public boolean retainAll( CoreConnection connection, Collection elements ) {

            throw new MoinUnsupportedOperationException( JmiReflectMessages.METHODNOTSUPPORTEDFORDERIVEDASSOCATION, association );
        }

        public Object set( CoreConnection connection, int index, Object element ) {

            throw new MoinUnsupportedOperationException( JmiReflectMessages.METHODNOTSUPPORTEDFORDERIVEDASSOCATION, association );
        }

        public void setLinkCollection( Collection linkCollection ) {

            throw new MoinUnsupportedOperationException( JmiReflectMessages.METHODNOTSUPPORTEDFORDERIVEDASSOCATION, association );

        }

        public int size( CoreSession session ) {

            return backingCollection.size( );
        }

        public JmiList subList( CoreConnection connection, int fromIndex, int toIndex ) {

            throw new MoinUnsupportedOperationException( JmiReflectMessages.METHODNOTSUPPORTEDFORDERIVEDASSOCATION, association );
        }

        public Object[] toArray( CoreConnection connection ) {

            return backingCollection.toArray( );
        }

        public Object[] toArray( CoreConnection connection, Object[] a ) {

            return backingCollection.toArray( a );
        }

        @Override
        public Object get( int index ) {

            throw new MoinUnsupportedOperationException( JmiReflectMessages.METHODNOTSUPPORTEDFORDERIVEDASSOCATION, association );
        }

        @Override
        public int size( ) {

            return backingCollection.size( );
        }

        public boolean isDistributed( ) {

            return false;
        }
    }
}