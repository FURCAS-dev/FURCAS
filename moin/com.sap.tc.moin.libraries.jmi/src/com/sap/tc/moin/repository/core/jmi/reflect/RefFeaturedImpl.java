package com.sap.tc.moin.repository.core.jmi.reflect;

import static com.sap.tc.moin.repository.JmiHelper.MULTIPLICITY_BOUND_INFINITE;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.model.__impl.AttributeImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.EnumerationTypeImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.ReferenceImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.StructureTypeImpl;
import com.sap.tc.moin.repository.mmi.reflect.InvalidCallException;
import com.sap.tc.moin.repository.mmi.reflect.InvalidNameException;
import com.sap.tc.moin.repository.mmi.reflect.InvalidObjectException;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefEnum;
import com.sap.tc.moin.repository.mmi.reflect.RefException;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefStruct;
import com.sap.tc.moin.repository.mmi.reflect.TypeMismatchException;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.MultiValuedAttributesList;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.jmi.extension.RefFeaturedExtension;
import com.sap.tc.moin.repository.exception.MoinIndexOutOfBoundsException;
import com.sap.tc.moin.repository.messages.jmi.impl.JmiBase;
import com.sap.tc.moin.repository.transactions.MicroTransactionable;
import com.sap.tc.moin.repository.transactions.Transactionable;
import com.sap.tc.moin.repository.transactions.microtransactionables.DataTypeAttributeAddElementMicroTransactionable;
import com.sap.tc.moin.repository.transactions.microtransactionables.DataTypeAttributeRemoveElementMicroTransactionable;
import com.sap.tc.moin.repository.transactions.transactionables.ModeledOperationInvokeTransactionable;

/**
 * This is the abstract base class for RefObjectImpl and RefClassImpl and
 * implements the interface RefFeatured as defined in JMI 1.0.
 */
public abstract class RefFeaturedImpl extends RefBaseObjectImpl implements RefFeatured, RefFeaturedExtension {

    /***************************************************************************
     * constructors
     **************************************************************************/
    /**
     * Instantiates a {@link RefFeatured} instance. As this class is abstract,
     * this constructor is only called as <code>super()</code> from the derived
     * classes, either {@link RefClassImpl} or {@link RefObjectImpl}.
     */
    public RefFeaturedImpl( ) {

        super( );
    }

    /**
     * Instantiates a {@link RefFeatured} instance. As this class is abstract,
     * this constructor is only called as <code>super()</code> from the derived
     * classes, either {@link RefClassImpl} or {@link RefObjectImpl}.
     * 
     * @param workspace The Workspace this {@link RefFeatured} is hosted in
     * @param mofId The MOF id of the instance
     * @param immediatePackage The immediate package of this {@link RefFeatured}
     * @param metaObject The {@link RefObject metaObject} of this
     * {@link RefFeatured}
     */
    public RefFeaturedImpl( Object workspace, String mofId, RefPackage immediatePackage, RefObject metaObject ) {

        super( workspace, mofId, immediatePackage, metaObject );
    }

    public RefFeaturedImpl( Workspace workspace, String mofId, RefPackage immediatePackage, RefObject metaObject, CoreModelPartition partition ) {

        super( workspace, mofId, immediatePackage, metaObject, partition );
    }

    /**
     * (non-Javadoc)
     * 
     * @see com.sap.tc.moin.repository.mmi.reflect.RefFeatured#refGetValue(com.sap.tc.moin.repository.mmi.reflect.RefObject)
     */
    @Deprecated
    public final Object refGetValue( RefObject feature ) {

        return refGetValue( get___CurrentConnection( ), feature );
    }

    public final Object refGetValue( CoreConnection connection, RefObject feature ) {

        if ( feature == null ) {
            throw new InvalidCallException( feature, null );
        }
        return refGetValue( connection, ( (ModelElement) feature ).getName( ) );
    }

    /**
     * (non-Javadoc)
     * 
     * @see com.sap.tc.moin.repository.mmi.reflect.RefFeatured#refGetValue(java.lang.String)
     */
    @Deprecated
    public Object refGetValue( String featureName ) {

        return refGetValue( get___CurrentConnection( ), featureName );
    }

    public Object refGetValue( CoreConnection connection, String featureName ) {

        // meaningful implementation in subclasses
        if ( featureName == null ) {
            throw new InvalidNameException( featureName, JmiBase.CANNOTACCESSVALUEOFFEATUREWITHNAMENULL );
        }
        throw new InvalidCallException( featureName, refMetaObject( ), JmiBase.CANNOTACCESSVALUEOFNONEXISTINGFEATURE, ( (MofClass) refMetaObject( ) ).getName( ), featureName );
    }

    /**
     * (non-Javadoc)
     * 
     * @see com.sap.tc.moin.repository.mmi.reflect.RefFeatured#refSetValue(com.sap.tc.moin.repository.mmi.reflect.RefObject,
     * java.lang.Object)
     */
    @Deprecated
    public void refSetValue( RefObject feature, Object value ) {

        refSetValue( get___CurrentConnection( ), feature, value );
    }

    public void refSetValue( CoreConnection connection, RefObject feature, Object value ) {

        if ( feature == null ) {
            throw new InvalidCallException( value, feature );
        }
        refSetValue( connection, ( (ModelElement) feature ).getName( ), value );
    }

    /**
     * (non-Javadoc)
     * 
     * @see com.sap.tc.moin.repository.mmi.reflect.RefFeatured#refSetValue(java.lang.String,
     * java.lang.Object)
     */
    @Deprecated
    public void refSetValue( String featureName, Object value ) {

        refSetValue( get___CurrentConnection( ), featureName, value );
    }

    public void refSetValue( CoreConnection connection, String featureName, Object value ) {

        // meaningful implementation in subclasses
        if ( featureName == null ) {
            throw new InvalidNameException( featureName, JmiBase.CANNOTACCESSVALUEOFFEATUREWITHNAMENULL );
        }
        throw new InvalidCallException( featureName, refMetaObject( ), JmiBase.CANNOTACCESSVALUEOFNONEXISTINGFEATURE, ( (MofClass) refMetaObject( ) ).getName( ), featureName );
    }

    @Deprecated
    public Object refInvokeOperation( RefObject requestedOperation, List<? extends Object> args ) throws RefException {

        return refInvokeOperation( get___CurrentConnection( ), requestedOperation, args );
    }

    public Object refInvokeOperation( CoreConnection connection, RefObject requestedOperation, List<? extends Object> args ) throws RefException {

        if ( requestedOperation instanceof ModelElement ) {
            return refInvokeOperation( connection, ( (ModelElement) requestedOperation ).getName( ), args );
        }
        return null;
    }

    @Deprecated
    public Object refInvokeOperation( String requestedOperation, List<? extends Object> args ) throws RefException {

        return refInvokeOperation( get___CurrentConnection( ), requestedOperation, args );
    }

    public Object refInvokeOperation( CoreConnection connection, String requestedOperation, List<? extends Object> args ) throws RefException {

        // meaningful implementation in subclasses
        if ( requestedOperation == null ) {
            throw new InvalidNameException( requestedOperation, JmiBase.CANNOTINVOKEOPERATIONNULL );
        }
        throw new InvalidNameException( requestedOperation, JmiBase.UNKNOWNOPERATION );
    }

    /***************************************************************************
     * other methods
     **************************************************************************/
    /**
     * Returns either the {@link Attribute} or Reference of this
     * {@link RefFeatured} specified by its name
     * 
     * @param name the name of the {@link Attribute} or {@link Reference}
     * @return the {@link Attribute} or {@link Reference} specified by name
     */
    protected abstract RefObject get___AttributeOrReferenceByName( String name );

    /**
     * Returns either the Attribute or the AssociationEnd specified by either
     * the Attribute's name or the name of the Reference referencing the
     * AssociationEnd.
     * 
     * @param name the name of the {@link Attribute} or {@link Reference}
     * @return the {@link Attribute} or {@link AssociationEnd} specified by the
     * {@link Attribute Attribute's} name or the name of the {@link Reference}
     * referencing the {@link AssociationEnd}
     */
    protected abstract RefObject get___AttributeOrAssociationEndByName( String name );

    protected final CorePartitionable get___MetamodelElementByMofId( CoreConnection connection, String mofId ) {

        //FIXME remove method and adjust callers to use the delegate directly
        return get___MetamodelElement( mofId );

    }

    /**
     * Loads links according to the MetaObject specified by metaObjectMofId. The
     * link is specified with having this RefFeatured at one and value at the
     * other end.
     * 
     * @param metaObjectMofId the mofId specifying the MetaObject, either an
     * Attribute or Association
     * @param value the value which represents an instance at the specified "to"
     * end
     */
    protected final void ___loadLinks( CoreSession session, String metaObjectMofId, Object value, int endNumberOfToEnd ) {

        if ( value != null ) {
            RefObject metaObject = (RefObject) get___MetamodelElement( metaObjectMofId );
            assert metaObject instanceof Attribute : "Unexpected call to ___loadLinks() where the metaobject is not an attribute"; //$NON-NLS-1$
            boolean done = false;
            for ( Iterator i = value instanceof Collection ? ( (Collection) value ).iterator( ) : null; i != null ? i.hasNext( ) : !done; ) {
                Object singleValue = ( i != null ? i.next( ) : value );
                Object[] linkEnds = new Object[2];
                // endNumber of "this" is 1 - endNumber of the "toEnd"
                linkEnds[1 - endNumberOfToEnd] = this;
                linkEnds[endNumberOfToEnd] = singleValue != null ? singleValue : null;
                if ( singleValue instanceof CorePartitionable ) {
                    get___Workspace( ).getMemoryLinkManager( ).loadLink( session, (CorePartitionable) linkEnds[0], (CorePartitionable) linkEnds[1], (Attribute) metaObject );
                } else {
                    // Must be a LRI from an object-valued attribute link.
                    assert singleValue != null && singleValue instanceof LRI : "Expected instance of LRI"; //$NON-NLS-1$
                    get___Workspace( ).getMemoryLinkManager( ).loadLink( session, this, (LRI) singleValue, (Attribute) metaObject );
                }
                done = true;
            }
        }
    }

    protected final void ___changeAttributeDerived( CoreConnection connection, int attributeId, String attributeMofId, Object newValue ) {

        connection.getSession( ).getTransactionManager( ).runInTransaction( new DerivedAttributeChangeTransaction( connection, attributeId, attributeMofId, newValue ) );
    }

    protected final void ___changeReferenceDerived( CoreConnection connection, int referenceId, String referenceMofId, Object newValue ) {

        connection.getSession( ).getTransactionManager( ).runInTransaction( new DerivedReferenceChangeTransaction( connection, referenceId, referenceMofId, newValue ) );
    }

    protected final void ___changeDataTypeAttribute( CoreConnection connection, int attributeId, String attributeMofId, Object oldValue, Object newValue ) {

        Attribute attribute = (Attribute) get___MetamodelElementByMofId( connection, attributeMofId );
        MicroTransactionable pacmtx = get___MicroTransactionableFactory( ).createDataTypeAttributeChangeMicroTransactionable( connection, this, attribute, attributeId, oldValue, newValue );
        connection.getSession( ).getTransactionManager( ).runInMicroTransaction( pacmtx );
    }

    protected final void ___changeObjectAttribute( CoreConnection connection, String attributeMofId, Object newValue ) {

        Attribute attribute = (Attribute) get___MetamodelElementByMofId( connection, attributeMofId );
        MicroTransactionable acmtx = get___MicroTransactionableFactory( ).createObjectAttributeChangeMicroTransactionable( connection, this, attribute, newValue );
        connection.getSession( ).getTransactionManager( ).runInMicroTransaction( acmtx );
    }

    protected final void ___changeReference( CoreConnection connection, String associationMofId, String referenceMofId, Object newValue, int toEndNumber ) {

        Association association = (Association) get___MetamodelElementByMofId( connection, associationMofId );
        Reference reference = (Reference) get___MetamodelElementByMofId( connection, referenceMofId );
        MicroTransactionable acmtx = get___MicroTransactionableFactory( ).createReferenceChangeMicroTransactionable( connection, this, reference, association, newValue, (byte) toEndNumber );
        connection.getSession( ).getTransactionManager( ).runInMicroTransaction( acmtx );
    }

    protected final Object ___invokeOperation( CoreConnection connection, int operationId, String operationMofId, List<? extends Object> args ) throws RefException {

        Operation operation = (Operation) get___MetamodelElementByMofId( connection, operationMofId );
        ModeledOperationInvokeTransactionable moitx = get___TransactionableFactory( ).createModeledOperationInvokeTransactionable( connection, false, this, operation, operationId, args );
        try {
            if ( !operation.isQuery( ) ) {
                // changing operations run in transactions
                connection.getSession( ).getTransactionManager( ).runInTransaction( moitx );
            } else {
                moitx.runInTransaction( );
            }
        } catch ( JmiException jmiException ) {
            Throwable cause = jmiException.getCause( );
            if ( cause != null && cause instanceof RefException ) {
                throw (RefException) cause;
            }
            throw jmiException;
        }
        return moitx.getReturnValue( );
    }

    private class DerivedAttributeChangeTransaction implements Transactionable {

        private int attributeId = -1;

        private String attributeMofId = null;

        private MRI newValueMri = null;

        private Object newValue = null;

        private CoreConnection connection;

        DerivedAttributeChangeTransaction( CoreConnection connection, int anAttributeId, String attributeMofId, Object aNewValue ) {

            this.connection = connection;
            this.attributeId = anAttributeId;
            this.newValue = aNewValue;
            this.attributeMofId = attributeMofId;
        }

        public void runInTransaction( ) throws JmiException {

            assertPreConstraints( );
            execute( );
        }

        private void assertPreConstraints( ) throws InvalidObjectException, InvalidCallException, TypeMismatchException {

            AttributeImpl attribute = (AttributeImpl) get___MetamodelElementByMofId( connection, attributeMofId );
            int attributeUpperBound = attribute.getMultiplicity( ).getUpper( );
            if ( !attribute.isChangeable( ) ) {
                // attribute has to be changeable, if not throw an
                // InvalidCallException (reasonable according to JMI
                // Spec, 4.2.6 (page 45), 4.8.5 (page 66), 5.2.2 (page 83))
                throw new InvalidCallException( this, attribute, JmiReflectMessages.FEATUREOFCLASSNOTCHANGEABLE, attribute.getName( ), ( (MofClass) refMetaObject( ) ).getName( ) );
            }
            if ( attributeUpperBound == MULTIPLICITY_BOUND_INFINITE || attributeUpperBound > 1 ) {
                // attribute is multi-valued, so setting the value as a whole
                // results in an InvalidCallException (JMI
                // Spec, page 83)
                throw new InvalidCallException( this, attribute, JmiReflectMessages.MULTIVALUEDATTRIBUTENOTSETTABLE, attribute.getName( ), ( (MofClass) refMetaObject( ) ).getName( ) );
            }
            if ( newValue != null ) {
                Classifier classifier = attribute.getType( connection );
                if ( classifier instanceof PrimitiveType && !( get___JmiHelper( ).getJavaWrapperType( connection, classifier ).isInstance( newValue ) ) || classifier instanceof MofClass
                     && !( newValue instanceof RefObject && ( (RefObjectImpl) newValue ).refIsInstanceOf( connection.getSession( ), classifier, true ) ) || classifier instanceof EnumerationType
                     && !( newValue instanceof RefEnum && ( (RefEnum) newValue ).refTypeName( ).equals( ( (EnumerationTypeImpl) classifier ).getQualifiedName( connection ) ) ) || classifier instanceof StructureType
                     && !( newValue instanceof RefStruct && ( (RefStruct) newValue ).refTypeName( ).equals( ( (StructureTypeImpl) classifier ).getQualifiedName( connection ) ) ) ) {
                    // newValue is not of the correct attribute type
                    throw new TypeMismatchException( classifier.getClass( ), newValue, refMetaObject( ), JmiReflectMessages.FEATURETYPEMISMATCH, attribute.getName( ), ( (MofClass) refMetaObject( ) ).getName( ), classifier.getName( ), newValue.getClass( ) );
                }
            }
            if ( newValue != null && newValue instanceof RefObject ) {
                newValueMri = ( (Partitionable) newValue ).get___Mri( );
                // null-out the before stored element, only the MRIs are stored
                newValue = null;
            }
        }

        private void execute( ) {

            Object value = newValueMri == null ? newValue : connection.getElement( newValueMri );
            set___Value( connection.getSession( ), attributeId, value );
        }

        public CoreConnection getConnection( ) {

            return connection;
        }
    }

    private class DerivedReferenceChangeTransaction implements Transactionable {

        private int referenceId = -1;

        private String referenceMofId = null;

        private MRI newValueMri = null;

        private Object newValue = null;

        private final CoreConnection connection;

        DerivedReferenceChangeTransaction( CoreConnection aConnection, int aReferenceId, String referenceMofId, Object aNewValue ) {

            this.connection = aConnection;
            this.referenceId = aReferenceId;
            this.newValue = aNewValue;
            this.referenceMofId = referenceMofId;
        }

        public void runInTransaction( ) {

            assertPreConstraints( );
            execute( );
        }

        private void assertPreConstraints( ) throws InvalidObjectException, InvalidCallException, TypeMismatchException {

            // Note: isNavigable does not need to be checked, because in MOIN all ends are navigable
            ReferenceImpl reference = (ReferenceImpl) get___MetamodelElementByMofId( connection, referenceMofId );
            int referenceUpperBound = reference.getMultiplicity( ).getUpper( );
            if ( !reference.isChangeable( ) ) {
                // reference has to be changeable, if not throw an
                // InvalidCallException (reasonable according to JMI
                // Spec, 4.8.6 (page 69), 5.2.3 (page 86))
                throw new InvalidCallException( this, reference, JmiReflectMessages.FEATUREOFCLASSNOTCHANGEABLE, reference.getName( ), ( (MofClass) refMetaObject( ) ).getName( ) );
            }
            if ( referenceUpperBound == MULTIPLICITY_BOUND_INFINITE || referenceUpperBound > 1 ) {
                // reference is multi-valued, so setting the value as a whole
                // results in an InvalidCallException
                // (analogous to multi-valued attributes, JMI Spec, 5.2.2 (page
                // 83), although there is no statement for
                // references)
                throw new InvalidCallException( this, reference, JmiReflectMessages.MULTIVALUEDREFERENCENOTSETTABLE, reference.getName( ), ( (MofClass) refMetaObject( ) ).getName( ) );
            }
            Classifier type = reference.getType( connection );
            if ( ( newValue != null ) && !( newValue instanceof RefObject && ( (RefObjectImpl) newValue ).refIsInstanceOf( connection.getSession( ), type, true ) ) ) {
                // newValue is not equals to null, it is also neither a
                // RefObject nor is it of the correct reference
                // type
                throw new TypeMismatchException( type.getClass( ), newValue, refMetaObject( ), JmiReflectMessages.FEATURETYPEEXPECTED, reference.getName( ), ( (MofClass) refMetaObject( ) ).getName( ), type.getName( ) );
            }
            if ( newValue != null ) {
                newValueMri = ( (Partitionable) newValue ).get___Mri( );
                // null-out the before stored element, only the MRIs are stored
                newValue = null;
            }
        }

        private void execute( ) {

            Partitionable value = newValueMri == null ? null : (Partitionable) connection.getElement( newValueMri );
            set___Value( connection.getSession( ), referenceId, value );
        }

        public CoreConnection getConnection( ) {

            return connection;
        }
    }

    protected final <E> MultiValuedAttributesList<E> create___MultiValuedAttributesList( Attribute attribute ) {

        return new MultiValuedAttributesListImpl<E>( attribute );
    }

    /**
     * This {@link List} implementation is to be used by JMI objects for
     * non-object-valued attributes with multiplicity greater one. Object-valued
     * attributes are handled as
     * {@link com.sap.tc.moin.repository.core.impl.AttributeLinkImpl links}
     * based on attributes. <br>
     * The MultiValuedAttributesList is used within JMI implementations and is
     * also transaction aware. This means that the methods do not change any
     * repository content if an exception occurs or if an event listener vetoes
     * a change. The list has even special methods for internal changes. <br>
     * Internally the attribute values are stored in a {@link List} if the
     * attribute is ordered and they are stored in a TreeSet with a
     * type-dependent Comparator if the attribute is unordered. This mechanism
     * guarantees a stable order also in the unordered case.
     * <p>
     */
    @SuppressWarnings( "unchecked" )
    private class MultiValuedAttributesListImpl<E> extends AbstractList<E> implements MultiValuedAttributesList<E>, Cloneable {

        private static final long serialVersionUID = 1L;

        private ArrayList<E> attributeValueList = new ArrayList<E>( );

        private Attribute attribute = null;

        public MultiValuedAttributesListImpl( Attribute anAttribute ) {

            this.attribute = anAttribute;
        }

        /*
         * (non-Javadoc)
         * @see
         * com.sap.tc.moin.repository.core.jmi.reflect.IMultiValuedAttributesList
         * #getRefReatured()
         */
        public RefFeaturedImpl getRefFeatured( ) {

            return RefFeaturedImpl.this;
        }

        public String getAttributeMofId( ) {

            return attribute.refMofId( );
        }

        /*
         * (non-Javadoc)
         * @see
         * com.sap.tc.moin.repository.core.jmi.reflect.IMultiValuedAttributesList
         * #add(com.sap.tc.moin.repository.core.CoreConnection, E)
         */
        public boolean add( CoreConnection connection, E anElement ) {

            DataTypeAttributeAddElementMicroTransactionable daamtx = get___MicroTransactionableFactory( ).createDataTypeAttributeAddElementMicroTransactionable( connection, RefFeaturedImpl.this, attribute, anElement );
            connection.getSession( ).getTransactionManager( ).runInMicroTransaction( daamtx );
            return daamtx.attributeChanged( );
        }

        /*
         * (non-Javadoc)
         * @see
         * com.sap.tc.moin.repository.core.jmi.reflect.IMultiValuedAttributesList
         * #add(com.sap.tc.moin.repository.core.CoreConnection, int, E)
         */
        public void add( CoreConnection connection, int anIndex, E anElement ) {

            MicroTransactionable daamtx = get___MicroTransactionableFactory( ).createDataTypeAttributeAddElementMicroTransactionable( connection, RefFeaturedImpl.this, attribute, anIndex, anElement );
            connection.getSession( ).getTransactionManager( ).runInMicroTransaction( daamtx );
        }

        /*
         * (non-Javadoc)
         * @see
         * com.sap.tc.moin.repository.core.jmi.reflect.IMultiValuedAttributesList
         * #addAll(com.sap.tc.moin.repository.core.CoreConnection,
         * java.util.Collection)
         */
        public boolean addAll( CoreConnection connection, Collection<? extends E> theElements ) {

            DataTypeAttributeAddElementMicroTransactionable daamtx = get___MicroTransactionableFactory( ).createDataTypeAttributeAddAllElementMicroTransactionable( connection, RefFeaturedImpl.this, attribute, theElements );
            connection.getSession( ).getTransactionManager( ).runInMicroTransaction( daamtx );
            return daamtx.attributeChanged( );
        }

        /*
         * (non-Javadoc)
         * @see
         * com.sap.tc.moin.repository.core.jmi.reflect.IMultiValuedAttributesList
         * #addAll(com.sap.tc.moin.repository.core.CoreConnection, int,
         * java.util.Collection)
         */
        public boolean addAll( CoreConnection connection, int anIndex, Collection<? extends E> theElements ) {

            DataTypeAttributeAddElementMicroTransactionable daamtx = get___MicroTransactionableFactory( ).createDataTypeAttributeAddAllElementMicroTransactionable( connection, RefFeaturedImpl.this, attribute, anIndex, theElements );
            connection.getSession( ).getTransactionManager( ).runInMicroTransaction( daamtx );
            return daamtx.attributeChanged( );
        }

        /*
         * (non-Javadoc)
         * @see
         * com.sap.tc.moin.repository.core.jmi.reflect.IMultiValuedAttributesList
         * #clear(com.sap.tc.moin.repository.core.CoreConnection)
         */
        public void clear( CoreConnection connection ) {

            retainAll( connection, Collections.emptyList( ) );
        }

        /*
         * (non-Javadoc)
         * @see
         * com.sap.tc.moin.repository.core.jmi.reflect.IMultiValuedAttributesList
         * #remove(com.sap.tc.moin.repository.core.CoreConnection,
         * java.lang.Object)
         */
        public boolean remove( CoreConnection connection, Object anElement ) {

            DataTypeAttributeRemoveElementMicroTransactionable darmtx = get___MicroTransactionableFactory( ).createDataTypeAttributeRemoveElementMicroTransactionable( connection, RefFeaturedImpl.this, attribute, anElement, false );
            connection.getSession( ).getTransactionManager( ).runInMicroTransaction( darmtx );
            return darmtx.attributeChanged( );
        }

        /*
         * (non-Javadoc)
         * @see
         * com.sap.tc.moin.repository.core.jmi.reflect.IMultiValuedAttributesList
         * #remove(com.sap.tc.moin.repository.core.CoreConnection, int)
         */
        public E remove( CoreConnection connection, int anIndex ) {

            DataTypeAttributeRemoveElementMicroTransactionable darmtx = get___MicroTransactionableFactory( ).createDataTypeAttributeRemoveElementMicroTransactionable( connection, RefFeaturedImpl.this, attribute, anIndex );
            connection.getSession( ).getTransactionManager( ).runInMicroTransaction( darmtx );
            return ( (List<E>) darmtx.getElementsWithIndexRemoved( ).get( 0 ) ).get( 0 );
        }

        /*
         * (non-Javadoc)
         * @see
         * com.sap.tc.moin.repository.core.jmi.reflect.IMultiValuedAttributesList
         * #removeAll(com.sap.tc.moin.repository.core.CoreConnection,
         * java.util.Collection)
         */
        public boolean removeAll( CoreConnection connection, Collection<?> theElements ) {

            DataTypeAttributeRemoveElementMicroTransactionable darmtx = get___MicroTransactionableFactory( ).createDataTypeAttributeRemoveAllElementMicroTransactionable( connection, RefFeaturedImpl.this, attribute, theElements, true );
            connection.getSession( ).getTransactionManager( ).runInMicroTransaction( darmtx );
            return darmtx.attributeChanged( );
        }

        /*
         * (non-Javadoc)
         * @see
         * com.sap.tc.moin.repository.core.jmi.reflect.IMultiValuedAttributesList
         * #retainAll(com.sap.tc.moin.repository.core.CoreConnection,
         * java.util.Collection)
         */
        public boolean retainAll( CoreConnection connection, Collection<?> elements ) {

            Collection elementsToRemove = new HashSet( );
            for ( Iterator iter = iterator( ); iter.hasNext( ); ) {
                Object element = iter.next( );
                if ( !elements.contains( element ) ) {
                    elementsToRemove.add( element );
                }
            }
            DataTypeAttributeRemoveElementMicroTransactionable darmtx = get___MicroTransactionableFactory( ).createDataTypeAttributeRemoveAllElementMicroTransactionable( connection, RefFeaturedImpl.this, attribute, elementsToRemove, true );
            connection.getSession( ).getTransactionManager( ).runInMicroTransaction( darmtx );
            return darmtx.attributeChanged( );
        }

        /*
         * (non-Javadoc)
         * @see
         * com.sap.tc.moin.repository.core.jmi.reflect.IMultiValuedAttributesList
         * #set(com.sap.tc.moin.repository.core.CoreConnection, int, E)
         */
        public E set( CoreConnection connection, int anIndex, E anElement ) {

            E oldElement = get( anIndex );
            MicroTransactionable pacmtx = get___MicroTransactionableFactory( ).createDataTypeAttributeSetElementMicroTransactionable( connection, RefFeaturedImpl.this, attribute, anIndex, anElement );
            connection.getSession( ).getTransactionManager( ).runInMicroTransaction( pacmtx );
            return oldElement;
        }

        /*
         * (non-Javadoc)
         * @see
         * com.sap.tc.moin.repository.core.jmi.reflect.IMultiValuedAttributesList
         * #get(int)
         */
        @Override
        public E get( int anIndex ) {

            return attributeValueList.get( anIndex );
        }

        /*
         * (non-Javadoc)
         * @see
         * com.sap.tc.moin.repository.core.jmi.reflect.IMultiValuedAttributesList
         * #size()
         */
        @Override
        public int size( ) {

            return attributeValueList.size( );
        }

        /*
         * (non-Javadoc)
         * @see
         * com.sap.tc.moin.repository.core.jmi.reflect.IMultiValuedAttributesList
         * #iterator(com.sap.tc.moin.repository.core.CoreConnection)
         */
        public Iterator<E> iterator( CoreConnection connection ) {

            return new Itr( connection );
        }

        /*
         * (non-Javadoc)
         * @see
         * com.sap.tc.moin.repository.core.jmi.reflect.IMultiValuedAttributesList
         * #listIterator(com.sap.tc.moin.repository.core.CoreConnection, int)
         */
        public ListIterator<E> listIterator( CoreConnection connection, int index ) {

            if ( index < 0 || index > size( ) ) {
                throw new MoinIndexOutOfBoundsException( JmiReflectMessages.INDEX, index );
            }
            return new ListItr( connection, index );
        }

        /*
         * (non-Javadoc)
         * @see
         * com.sap.tc.moin.repository.core.jmi.reflect.IMultiValuedAttributesList
         * #subList(int, int)
         */
        @Override
        public List<E> subList( int fromIndex, int toIndex ) {

            return new SubList( this, attribute, fromIndex, toIndex );
        }

        /*
         * (non-Javadoc)
         * @see
         * com.sap.tc.moin.repository.core.jmi.reflect.IMultiValuedAttributesList
         * #clone()
         */
        @Override
        public Object clone( ) {

            return attributeValueList.clone( );
        }

        /*
         * (non-Javadoc)
         * @see
         * com.sap.tc.moin.repository.core.jmi.reflect.IMultiValuedAttributesList
         * #replace(java.util.Collection)
         */
        public void replace( Collection<? extends E> theElements ) {

            clear( );
            addAll( theElements );
        }

        /*
         * (non-Javadoc)
         * @see
         * com.sap.tc.moin.repository.core.jmi.reflect.IMultiValuedAttributesList
         * #___add(int, E)
         */
        public void ___add( int anIndex, E anElement ) {

            attributeValueList.add( anIndex, anElement );
        }

        /*
         * (non-Javadoc)
         * @see
         * com.sap.tc.moin.repository.core.jmi.reflect.IMultiValuedAttributesList
         * #___add(E)
         */
        public void ___add( E anElement ) {

            attributeValueList.add( anElement );
        }

        /*
         * (non-Javadoc)
         * @see
         * com.sap.tc.moin.repository.core.jmi.reflect.IMultiValuedAttributesList
         * #___remove(int)
         */
        public E ___remove( int anIndex ) {

            return attributeValueList.remove( anIndex );
        }

        /*
         * (non-Javadoc)
         * @see
         * com.sap.tc.moin.repository.core.jmi.reflect.IMultiValuedAttributesList
         * #___remove(java.lang.Object)
         */
        public boolean ___remove( Object anElement ) {

            return attributeValueList.remove( anElement );
        }

        /*
         * (non-Javadoc)
         * @see
         * com.sap.tc.moin.repository.core.jmi.reflect.IMultiValuedAttributesList
         * #___replace(java.util.Collection)
         */
        public void ___replace( Collection<? extends E> theElements ) {

            attributeValueList.clear( );
            attributeValueList.addAll( theElements );
        }

        /*
         * (non-Javadoc)
         * @see
         * com.sap.tc.moin.repository.core.jmi.reflect.IMultiValuedAttributesList
         * #___set(int, E)
         */
        public E ___set( int anIndex, E anElement ) {

            return attributeValueList.set( anIndex, anElement );
        }

        private class Itr implements Iterator<E> {

            int cursor = 0;

            int lastRet = -1;

            int expectedModCount = modCount;

            final CoreConnection connection;

            Itr( CoreConnection connection ) {

                this.connection = connection;
            }

            public boolean hasNext( ) {

                return cursor != size( );
            }

            public E next( ) {

                checkForComodification( );
                try {
                    E next = get( cursor );
                    lastRet = cursor++;
                    return next;
                } catch ( IndexOutOfBoundsException e ) {
                    checkForComodification( );
                    throw new NoSuchElementException( );
                }
            }

            public void remove( ) {

                if ( lastRet == -1 ) {
                    throw new IllegalStateException( );
                }
                checkForComodification( );
                try {
                    MultiValuedAttributesListImpl.this.remove( connection, lastRet );
                    if ( lastRet < cursor ) {
                        cursor--;
                    }
                    lastRet = -1;
                    expectedModCount = modCount;
                } catch ( IndexOutOfBoundsException e ) {
                    throw new ConcurrentModificationException( );
                }
            }

            final void checkForComodification( ) {

                if ( modCount != expectedModCount ) {
                    throw new ConcurrentModificationException( );
                }
            }
        }

        private class ListItr extends Itr implements ListIterator<E> {

            ListItr( CoreConnection connection, int index ) {

                super( connection );
                cursor = index;
            }

            public boolean hasPrevious( ) {

                return cursor != 0;
            }

            public E previous( ) {

                checkForComodification( );
                try {
                    int i = cursor - 1;
                    E previous = get( i );
                    lastRet = cursor = i;
                    return previous;
                } catch ( IndexOutOfBoundsException e ) {
                    checkForComodification( );
                    throw new NoSuchElementException( );
                }
            }

            public int nextIndex( ) {

                return cursor;
            }

            public int previousIndex( ) {

                return cursor - 1;
            }

            public void set( E o ) {

                if ( lastRet == -1 ) {
                    throw new IllegalStateException( );
                }
                checkForComodification( );
                try {
                    MultiValuedAttributesListImpl.this.set( connection, lastRet, o );
                    expectedModCount = modCount;
                } catch ( IndexOutOfBoundsException e ) {
                    throw new ConcurrentModificationException( );
                }
            }

            public void add( E o ) {

                checkForComodification( );
                try {
                    MultiValuedAttributesListImpl.this.add( connection, cursor++, o );
                    lastRet = -1;
                    expectedModCount = modCount;
                } catch ( IndexOutOfBoundsException e ) {
                    throw new ConcurrentModificationException( );
                }
            }
        }

        private final class SubList extends MultiValuedAttributesListImpl<E> {

            private MultiValuedAttributesListImpl<E> l;

            private int offset;

            private int size;

            private int expectedModCount;

            public SubList( MultiValuedAttributesListImpl<E> list, Attribute anAttribute, int fromIndex, int toIndex ) {

                super( anAttribute );
                l = list;
                if ( fromIndex < 0 ) {
                    throw new IndexOutOfBoundsException( "fromIndex = " + fromIndex ); //$NON-NLS-1$
                }
                if ( toIndex > l.size( ) ) {
                    throw new IndexOutOfBoundsException( "toIndex = " + toIndex ); //$NON-NLS-1$
                }
                if ( fromIndex > toIndex ) {
                    throw new IllegalArgumentException( "fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                }
                offset = fromIndex;
                size = toIndex - fromIndex;
                expectedModCount = l.modCount;
            }

            @Override
            public E set( CoreConnection connection, int index, E element ) {

                rangeCheck( index );
                checkForComodification( );
                return l.set( connection, index + offset, element );
            }

            @Override
            public E get( int index ) {

                rangeCheck( index );
                checkForComodification( );
                return l.get( index + offset );
            }

            @Override
            public void clear( CoreConnection connection ) {

                checkForComodification( );
                int oldSize = size;
                for ( int index = 0; index < oldSize; index++ ) {
                    l.remove( connection, offset );
                    expectedModCount = l.modCount;
                    size--;
                    modCount++;
                }
            }

            @Override
            public void add( CoreConnection connection, int index, E element ) {

                if ( index < 0 || index > size ) {
                    throw new IndexOutOfBoundsException( );
                }
                checkForComodification( );
                l.add( connection, index + offset, element );
                expectedModCount = l.modCount;
                size++;
                modCount++;
            }

            @Override
            public E remove( CoreConnection connection, int index ) {

                rangeCheck( index );
                checkForComodification( );
                E result = l.remove( connection, index + offset );
                expectedModCount = l.modCount;
                size--;
                modCount++;
                return result;
            }

            @Override
            public boolean addAll( CoreConnection connection, Collection<? extends E> c ) {

                return addAll( connection, size, c );
            }

            @Override
            public boolean addAll( CoreConnection connection, int index, Collection<? extends E> c ) {

                if ( index < 0 || index > size ) {
                    throw new MoinIndexOutOfBoundsException( index, size );
                }
                int cSize = c.size( );
                if ( cSize == 0 ) {
                    return false;
                }
                checkForComodification( );
                l.addAll( connection, offset + index, c );
                expectedModCount = l.modCount;
                size += cSize;
                modCount++;
                return true;
            }

            @Override
            public Iterator<E> iterator( CoreConnection connection ) {

                return listIterator( connection, 0 );
            }

            @Override
            public ListIterator<E> listIterator( final CoreConnection connection, final int index ) {

                checkForComodification( );
                if ( index < 0 || index > size ) {
                    throw new MoinIndexOutOfBoundsException( index, size );
                }
                return new ListIterator<E>( ) {

                    private ListIterator<E> i = l.listIterator( connection, index + offset );

                    public boolean hasNext( ) {

                        return nextIndex( ) < size;
                    }

                    public E next( ) {

                        if ( hasNext( ) ) {
                            return i.next( );
                        }
                        throw new NoSuchElementException( );
                    }

                    public boolean hasPrevious( ) {

                        return previousIndex( ) >= 0;
                    }

                    public E previous( ) {

                        if ( hasPrevious( ) ) {
                            return i.previous( );
                        }
                        throw new NoSuchElementException( );
                    }

                    public int nextIndex( ) {

                        return i.nextIndex( ) - offset;
                    }

                    public int previousIndex( ) {

                        return i.previousIndex( ) - offset;
                    }

                    public void remove( ) {

                        i.remove( );
                        expectedModCount = l.modCount;
                        size--;
                        modCount++;
                    }

                    public void set( E o ) {

                        i.set( o );
                    }

                    public void add( E o ) {

                        i.add( o );
                        expectedModCount = l.modCount;
                        size++;
                        modCount++;
                    }
                };
            }

            @Override
            public List<E> subList( int fromIndex, int toIndex ) {

                return new SubList( MultiValuedAttributesListImpl.this, attribute, fromIndex, toIndex );
            }

            private void rangeCheck( int index ) {

                if ( index < 0 || index >= size ) {
                    throw new MoinIndexOutOfBoundsException( index, size );
                }
            }

            private void checkForComodification( ) {

                if ( l.modCount != expectedModCount ) {
                    throw new ConcurrentModificationException( );
                }
            }
        }
    }

    @Override
    public <T extends RefBaseObject> Class<T> get___JmiInterface( ) {

        // meaningful implementation in subclasses
        return null;
    }

    public void set___Value( Session session, String featureName, Object value ) {

        set___Value( (CoreSession) session, featureName, value );
    }

    public void set___Value( CoreSession session, String featureName, Object value ) {

        // meaningful implementation in subclasses
        throw new com.sap.tc.moin.repository.mmi.reflect.InvalidCallException( featureName, refMetaObject( ), JmiReflectMessages.UNABLE_TO_SET_VALUE_OF_FEATURE_WITH_NAME.format( ( (com.sap.tc.moin.repository.mmi.model.MofClass) refMetaObject( ) ).getName( ), featureName ) );
    }

    public void set___Value( Session session, int featureNumber, Object value ) {

        set___Value( (CoreSession) session, featureNumber, value );
    }

    public void set___Value( CoreSession session, int featureNumber, Object value ) {

        // meaningful implementation in subclasses
        throw new com.sap.tc.moin.repository.mmi.reflect.InvalidCallException( featureNumber, refMetaObject( ), JmiReflectMessages.UNABLE_TO_SET_VALUE_OF_FEATURE_WITH_ID.format( ( (com.sap.tc.moin.repository.mmi.model.MofClass) refMetaObject( ) ).getName( ), featureNumber ) );
    }

    public void set___AssociationLink( String associationEndMofId, EndStorageLink value ) {

    }

    public void set___AttributeLink( String attributeMofId, EndStorageLink value ) {

    }

    public EndStorageLink get___AssociationLink( String associationEndMofId ) {

        return null;
    }

    public EndStorageLink get___AttributeLink( String attributeMofId ) {

        return null;
    }

    public List<EndStorageLink> get___AllStoredLinks( ) {

        return null;
    }

    public List<EndStorageLink> get___AllStoredAssociationLinks( ) {

        // compatibility code; can be changed to "return null;" too, as soon as the method is generated into all metamodels
        List<EndStorageLink> result = null;
        List<EndStorageLink> allStoredLinks = get___AllStoredLinks( );
        if ( allStoredLinks != null ) {
            for ( int i = 0, n = allStoredLinks.size( ); i < n; i++ ) {
                EndStorageLink link = allStoredLinks.get( i );
                if ( link.getMetaObject( ) instanceof Association ) {
                    if ( result == null ) {
                        result = new ArrayList<EndStorageLink>( );
                    }
                    result.add( link );
                }
            }
        }
        if ( result != null ) {
            return result;
        }
        return Collections.emptyList( );
    }

    public Collection<EndStorageLink> get___AssociationLinks( String associationEndMofId ) {

        return null;
    }

    public Collection<EndStorageLink> get___AttributeLinks( String attributeMofId ) {

        return null;
    }

    public void set___AssociationLinks( Collection<EndStorageLink> links, String associationEndMofId ) {

    }

    public void set___AttributeLinks( Collection<EndStorageLink> links, String attributeMofId ) {

    }

    public List<EndStorageLink> clear___AllLinks( ) {

        return null;
    }

    public final EndStorageLink get___EndStorageLink( CoreConnection connection, CorePartitionable linkedElement, RefObject attributeOrAssociation, int endNumberOfLinkedElement ) {

        EndStorageLink result = null;
        if ( attributeOrAssociation instanceof Association ) {
            AssociationEnd endOfLinkedElement = get___JmiHelper( ).getAssociationEnds( connection.getSession( ), (Association) attributeOrAssociation ).get( endNumberOfLinkedElement );
            if ( endOfLinkedElement.getMultiplicity( ).getUpper( ) == 1 ) {
                result = get___AssociationLink( endOfLinkedElement.refMofId( ) );
            } else {
                Collection<EndStorageLink> links = get___AssociationLinks( endOfLinkedElement.refMofId( ) );
                if ( links != null ) {
                    for ( EndStorageLink link : links ) {
                        if ( link.getOtherEnd( ).getLri( ).equals( linkedElement.get___Mri( ).getLri( ) ) ) {
                            result = link;
                            break;
                        }
                    }
                }
            }
        } else {
            Attribute attribute = (Attribute) attributeOrAssociation;
            if ( attribute.getMultiplicity( ).getUpper( ) == 1 ) {
                result = get___AttributeLink( attribute.refMofId( ) );
            } else {
                Collection<EndStorageLink> links = get___AttributeLinks( attribute.refMofId( ) );
                if ( links != null ) {
                    for ( EndStorageLink link : links ) {
                        if ( link.getOtherEnd( ).getLri( ).equals( linkedElement.get___Mri( ).getLri( ) ) ) {
                            result = link;
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }

    public Object invoke___Operation( Connection connection, int operationNumber, List<? extends Object> args ) throws RefException {

        return invoke___Operation( (CoreConnection) connection, operationNumber, args );
    }

    public Object invoke___Operation( CoreConnection connection, int operationNumber, List<? extends Object> args ) throws RefException {

        // meaningful implementation in subclasses
        throw new InvalidCallException( operationNumber, refMetaObject( ), JmiReflectMessages.UNABLE_TO_INVOKE_OPERATION_WITH_ID.format( ( (MofClass) refMetaObject( ) ).getName( ), operationNumber ) );
    }

    public void initialize___Values( Connection connection ) {

        initialize___Values( (CoreConnection) connection );
    }

    public void initialize___Values( CoreConnection connection ) {

        // meaningful implementation in subclasses
    }

    public void addOrSet___Value( CoreSession session, String featureName, Object value ) {

        // TODO Remove as soon as the method is generated into all metamodels
        set___Value( session, featureName, value ); // temporary hack, does not work for :n attributes
    }
}
