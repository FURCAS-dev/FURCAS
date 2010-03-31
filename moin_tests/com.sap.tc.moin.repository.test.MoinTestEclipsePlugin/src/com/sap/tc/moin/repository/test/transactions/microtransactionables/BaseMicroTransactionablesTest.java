package com.sap.tc.moin.repository.test.transactions.microtransactionables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.junit.After;
import org.junit.Before;

import com.sap.tc.moin.MoinPackage;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.LockManager;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.LogicalLinkManager;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.WrapperManager;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.filter.EventTypeFilter;
import com.sap.tc.moin.repository.events.type.AttributeValueAddEvent;
import com.sap.tc.moin.repository.events.type.AttributeValueChangeEvent;
import com.sap.tc.moin.repository.events.type.AttributeValueEvent;
import com.sap.tc.moin.repository.events.type.AttributeValueRemoveEvent;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ElementChangeEvent;
import com.sap.tc.moin.repository.events.type.ElementCreateEvent;
import com.sap.tc.moin.repository.events.type.ElementDeleteEvent;
import com.sap.tc.moin.repository.events.type.LinkAddEvent;
import com.sap.tc.moin.repository.events.type.LinkChangeEvent;
import com.sap.tc.moin.repository.events.type.LinkRemoveEvent;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.events.type.PartitionChangeEvent;
import com.sap.tc.moin.repository.events.type.PartitionMembershipChangeEvent;
import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;
import com.sap.tc.moin.repository.test.core.CoreMoinTest;
import com.sap.tc.moin.repository.transactions.TransactionManager;
import com.sap.tc.moin.testcases.TestcasesPackage;
import com.sap.tc.moin.testcases.case004.A4;
import com.sap.tc.moin.testcases.case004.B4;
import com.sap.tc.moin.testcases.case004.C4;
import com.sap.tc.moin.testcases.case004.Case004Package;
import com.sap.tc.moin.testcases.case004.ComposesCsOrdered;
import com.sap.tc.moin.testcases.case004.D4;
import com.sap.tc.moin.testcases.case004.F4;
import com.sap.tc.moin.testcases.case006.B6;
import com.sap.tc.moin.testcases.case006.C6;
import com.sap.tc.moin.testcases.case006.D6;
import com.sap.tc.moin.testcases.case008.A8;
import com.sap.tc.moin.testcases.case008.Case008Package;
import com.sap.tc.moin.testcases.case008.E8;
import com.sap.tc.moin.testcases.case008.E8Enum;
import com.sap.tc.moin.testcases.case008.S8;
import com.sap.tc.moin.testcases.case008.T8;
import com.sap.tc.moin.testcases.case010.A10;
import com.sap.tc.moin.testcases.case010.B10;
import com.sap.tc.moin.testcases.case010.Case010Package;
import com.sap.tc.moin.testcases.case010.OneToManyChangeable;
import com.sap.tc.moin.testcases.case010.OneToManyOrdered;
import com.sap.tc.moin.testcases.case011.Case011Package;
import com.sap.tc.moin.testcases.case012.Case012Package;
import com.sap.tc.moin.testcases.case013.B13;
import com.sap.tc.moin.testcases.case013.Case013Package;
import com.sap.tc.moin.testcases.case017.A17;
import com.sap.tc.moin.testcases.case017.Case017Package;
import com.sap.tc.moin.testcases.case020.Case020Package;
import com.sap.tc.moin.testcases.case021.Case021Package;

// TODO do we have to check preconditions before Undo?
// TODO ensure editing allowed actions do currently have no "inverse" actions,
// if revert of those actions is implemented, that must also taken into
// consideration for undo,
// see for example the calls of
// addNecessaryEnsureEditingAllowedActionsToDoActions
// TODO don't create a new MOF ID and MRI in the case of a ReDo!
// TODO what about add/remove on derived associations?
// TODO check all Exceptions in the JMI Spec whether they are standard JDK
// Exceptions, wrap them
// TODO should we change the storage of a MRI in all MTxables to the storage of
// only the LRI?
// the point is that after a repartitioning the MRIs change and the post step as
// well as the undo step will fail if they still use MRIs
// see LinkAddElementMicroTransactionableImpl.assertDoPostConstraints
// see ReferenceChangeMicroTransactionableImpl.assertDoPostConstraints
// the same point has to be considered for the reverts of actions, also there we
// use MRIs
// TODO check the correctness of the constructor parameters "objectInError" and
// "elementInError" for all JMI exceptions thrown
// TODO remove set partition assignment logic from instance manager inject
// partitionable method,
// TODO InstanceDeleteMicroTransactionableImpl: compute the index of the links
// that should be deleted,
// this is currently a ugly job because the link action manager does not know
// the index, one has to query the association ends
// and get the correct index out of the query result by calling indexOf(<element
// to delete>)
// due to that fact, -1 is used there as index for the deleted links

@SuppressWarnings( "nls" )
public abstract class BaseMicroTransactionablesTest extends CoreMoinTest {

    private ChangeListenerImpl listener = null;

    protected LockManager lockManager = null;

    protected MoinPackage moinPackage = null;

    protected ModelPartition nullPartition = null;

    protected TestcasesPackage testcasesPackage = null;

    Case004Package case004Package = null;

    Case008Package case008Package = null;

    Case010Package case010Package = null;

    Case020Package case020Package = null;

    protected RefClass a4Class = null;

    protected RefClass a8Class = null;

    protected RefClass a10Class = null;

    protected RefClass a11Class = null;

    protected RefClass a12Class = null;

    protected RefClass a17Class = null;

    protected RefClass a21AbstractClass = null;

    protected RefClass b4Class = null;

    protected RefClass b10Class = null;

    protected RefClass b13Class = null;

    protected RefClass c4Class = null;

    protected RefClass d12Class = null;

    protected RefClass d4Class = null;

    protected RefClass f4Class = null;

    protected TransactionManager transactionManager = null;

    protected LogicalLinkManager linkManager = null;

    protected WrapperManager wrapperManager = null;

    protected CoreSession coreSession = null;

    protected CoreConnection coreConnection = null;

    protected Workspace clientSpecificWorkspace = null;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        coreConnection = getTestHelper( ).getCoreConnection( getMOINConnection( ) );
        coreSession = coreConnection.getSession( );
        nullPartition = getMOINConnection( ).getNullPartition( );
        clientSpecificWorkspace = coreSession.getWorkspace( );
        transactionManager = coreSession.getTransactionManager( );
        linkManager = coreSession.getWorkspaceSet( ).getLogicalLinkManager( );
        wrapperManager = clientSpecificWorkspace.getWorkspaceSet( ).getWrapperManager( );
        lockManager = getMOINConnection( ).getSession( ).getLockManager( );
        testcasesPackage = (TestcasesPackage) getMOINConnection( ).getPackage( null, new String[] { "testcases" } );
        moinPackage = (MoinPackage) getMOINConnection( ).getPackage( null, new String[] { "MOIN" } );
        case004Package = testcasesPackage.getCase004( );
        case008Package = testcasesPackage.getCase008( );
        case010Package = testcasesPackage.getCase010( );
        Case011Package case011Package = testcasesPackage.getCase011( );
        Case012Package case012Package = testcasesPackage.getCase012( );
        Case013Package case013Package = testcasesPackage.getCase013( );
        Case017Package case017Package = testcasesPackage.getCase017( );
        case020Package = testcasesPackage.getCase020( );
        Case021Package case021Package = testcasesPackage.getCase021( );
        a4Class = case004Package.getA4( );
        a8Class = case008Package.getA8( );
        a10Class = case010Package.getA10( );
        a11Class = case011Package.getA11( );
        a12Class = case012Package.getA12( );
        a17Class = case017Package.getA17( );
        a21AbstractClass = case021Package.getA21Abstract( );
        b4Class = case004Package.getB4( );
        b10Class = case010Package.getB10( );
        b13Class = case013Package.getB13( );
        d4Class = case004Package.getD4( );
        c4Class = case004Package.getC4( );
        d12Class = case012Package.getD12( );
        f4Class = case004Package.getF4( );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
        coreSession = null;
        lockManager = null;
    }

    protected A4 createA4( ) {

        A4 a4 = (A4) a4Class.refCreateInstance( );
        a4.setOnePrimitive( "initial" ); // onePrimitive
        a4.setOnePrimitiveNotChangeable( "initial" ); // onePrimitiveNotChangeable
        a4.getManyPrimitive( ).addAll( Arrays.asList( new String[] { "initial0", "initial1", "initial2", "initial3", "initial4" } ) ); // manyPrimitive
        a4.getManyPrimitiveUnique( ).addAll( Arrays.asList( new String[] { "initial0", "initial1", "initial2", "initial3", "initial4" } ) ); // manyPrimitiveUnique
        a4.getManyPrimitiveNotChangeable( ).addAll( Arrays.asList( new String[] { "initial0", "initial1", "initial2", "initial3", "initial4" } ) ); // manyPrimitiveNotChangeable
        a4.getManyPrimitiveOrdered( ).addAll( Arrays.asList( new String[] { "initial0", "initial1", "initial2", "initial3", "initial4" } ) ); // manyPrimitiveOrdered
        a4.getManyPrimitiveOrderedUnique( ).addAll( Arrays.asList( new String[] { "initial0", "initial1", "initial2", "initial3", "initial4" } ) ); // manyPrimitiveOrderedUnique
        a4.setOneBchangeable( (B4) b4Class.refCreateInstance( ) ); // oneBChangeable
        a4.setOneBoptional( (B4) b4Class.refCreateInstance( ) ); // oneBOptional
        a4.getManyBs( ).addAll( Arrays.asList( createB4( ), createB4( ), createB4( ), createB4( ), createB4( ) ) ); // manyBs
        a4.getManyBsUnique( ).addAll( Arrays.asList( createB4( ), createB4( ), createB4( ), createB4( ), createB4( ) ) ); // manyBsUnique
        a4.getManyBsOrdered( ).addAll( Arrays.asList( createB4( ), createB4( ), createB4( ), createB4( ), createB4( ) ) ); // manyBsOrdered
        a4.getManyBsOrderedUnique( ).addAll( Arrays.asList( createB4( ), createB4( ), createB4( ), createB4( ), createB4( ) ) ); // manyBsOrderedUnique
        return a4;
    }

    protected A8 createA8( ) {

        E8 e8 = E8Enum.LABEL1;
        StructureFieldContainer<S8> contS8 = new StructureFieldContainer<S8>( );
        contS8.put( S8.DESCRIPTORS.FIELD1( ), 0 ).put( S8.DESCRIPTORS.FIELD2( ), "initial" );
        S8 s8 = case008Package.createS8( contS8 );
        StructureFieldContainer<T8> contT8 = new StructureFieldContainer<T8>( );
        contT8.put( T8.DESCRIPTORS.FIELD1( ), 0 ).put( T8.DESCRIPTORS.FIELD2( ), "0" );
        T8 t8 = case008Package.createT8( contT8 );
        A8 a8 = (A8) a8Class.refCreateInstance( );
        a8.setOneEnumerationE( e8 );
        a8.setOneStructureS( s8 );
        a8.setOneStructureT( t8 );
        a8.getManyEnumerationE( ).addAll( Arrays.asList( e8 ) );
        a8.getManyStructureS( ).addAll( Arrays.asList( s8 ) );
        return a8;
    }

    protected A10 createA10( ) {

        A10 a10 = (A10) a10Class.refCreateInstance( );
        a10.setNavigable( (B10) b10Class.refCreateInstance( ) );
        Collection<B10> manyBsChangeable = a10.getManyBsChangeable( );
        List<B10> manyBsOrdered = a10.getManyBsOrdered( );
        manyBsChangeable.clear( );
        manyBsOrdered.clear( );
        manyBsChangeable.addAll( Arrays.asList( createB10( ), createB10( ), createB10( ), createB10( ) ) );
        manyBsOrdered.addAll( Arrays.asList( createB10( ), createB10( ), createB10( ), createB10( ) ) );
        return a10;
    }

    protected A17 createA17( ) {

        return getMOINConnection( ).createElementInPartition( A17.class, null );
    }

    protected B4 createB4( ) {

        return getMOINConnection( ).createElementInPartition( B4.class, null );
    }

    protected B4 createB4( String value ) {

        B4 b4 = getMOINConnection( ).createElementInPartition( B4.class, null );
        b4.setOnePrimitive( value );
        return b4;
    }

    protected B6 createB6( ModelPartition partition ) {

        return getMOINConnection( ).createElementInPartition( B6.class, partition );
    }

    protected B10 createB10( ) {

        return getMOINConnection( ).createElementInPartition( B10.class, null );
    }

    protected B13 createB13( ) {

        return getMOINConnection( ).createElementInPartition( B13.class, null );
    }

    protected C4 createC4( ) {

        C4 c4 = getMOINConnection( ).createElementInPartition( C4.class, null );
        B4 b4 = getMOINConnection( ).createElementInPartition( B4.class, null );
        b4.setOnePrimitive( "initial" );

        c4.setPrimitive( "initial" );
        c4.setComplex( b4 );
        return c4;
    }

    protected C6 createC6( ModelPartition partition ) {

        B6 b6 = getMOINConnection( ).createElementInPartition( B6.class, partition );
        C6 c6 = getMOINConnection( ).createElementInPartition( C6.class, partition );
        D6 d6 = getMOINConnection( ).createElementInPartition( D6.class, partition );
        c6.setW( d6 );
        c6.setX( b6 );
        return c6;
    }

    protected D4 createD4( ) {

        D4 d4 = (D4) d4Class.refCreateInstance( );
        d4.setAttributeString( "initial" );
        return d4;
    }

    protected D6 createD6( ModelPartition partition ) {

        return getMOINConnection( ).createElementInPartition( D6.class, partition );
    }

    protected F4 createF4( ) {

        F4 f4 = (F4) f4Class.refCreateInstance( );
        f4.setOneC( createC4( ) );
        f4.getManyCs( ).addAll( Arrays.asList( getMOINConnection( ).createElementInPartition( C4.class, null ), getMOINConnection( ).createElementInPartition( C4.class, null ), getMOINConnection( ).createElementInPartition( C4.class, null ) ) );
        f4.getManyCsOrdered( ).addAll( Arrays.asList( getMOINConnection( ).createElementInPartition( C4.class, null ), getMOINConnection( ).createElementInPartition( C4.class, null ), getMOINConnection( ).createElementInPartition( C4.class, null ) ) );
        return f4;
    }

    protected void initializeOneToManyChangeable( A10 oneChangeable ) {

        OneToManyChangeable oneToManyChangeable = case010Package.getOneToManyChangeable( );
        oneToManyChangeable.refQuery( "oneChangeable", oneChangeable ).clear( );
        oneToManyChangeable.refAddLink( oneChangeable, createB10( ) );
        oneToManyChangeable.refAddLink( oneChangeable, createB10( ) );
        oneToManyChangeable.refAddLink( oneChangeable, createB10( ) );
        oneToManyChangeable.refAddLink( oneChangeable, createB10( ) );
    }

    protected void initializeOneToManyOrdered( A10 one ) {

        OneToManyOrdered oneToManyOrdered = case010Package.getOneToManyOrdered( );
        oneToManyOrdered.refQuery( "one", one ).clear( );
        oneToManyOrdered.refAddLink( createB10( ), one );
        oneToManyOrdered.refAddLink( createB10( ), one );
        oneToManyOrdered.refAddLink( createB10( ), one );
        oneToManyOrdered.refAddLink( createB10( ), one );
    }

    protected void initializeComposesCsOrdered( F4 myF4 ) {

        ComposesCsOrdered composesCsOrdered = case004Package.getComposesCsOrdered( );
        composesCsOrdered.refQuery( "myF", myF4 ).clear( );
        composesCsOrdered.add( myF4, getMOINConnection( ).createElementInPartition( C4.class, null ) );
        composesCsOrdered.add( myF4, getMOINConnection( ).createElementInPartition( C4.class, null ) );
        composesCsOrdered.add( myF4, getMOINConnection( ).createElementInPartition( C4.class, null ) );
        composesCsOrdered.add( myF4, getMOINConnection( ).createElementInPartition( C4.class, null ) );
    }

    protected List<CorePartitionable> getAllComponentChildrenRecursive( CorePartitionable parent ) {

        List<CorePartitionable> result = new ArrayList<CorePartitionable>( );
        Collection<CorePartitionable> componentChildren = linkManager.getComponentChildren( coreConnection.getSession( ), parent );
        for ( CorePartitionable componentChild : componentChildren ) {
            result.add( componentChild );
            result.addAll( getAllComponentChildrenRecursive( componentChild ) );
        }
        return result;
    }

    protected EndStorageLink getCompositeParentLink( CorePartitionable child ) {

        return linkManager.getCompositeParentLink( coreConnection.getSession( ), child );
    }

    protected Collection<EndStorageLink> getAssociationLinksForElement( CorePartitionable element ) {

        Collection<EndStorageLink> result = new ArrayList<EndStorageLink>( );
        List<EndStorageLink> allLinks = linkManager.getLinksForElement( coreConnection.getSession( ), element );
        for ( int i = 0, n = allLinks.size( ); i < n; i++ ) {
            EndStorageLink link = allLinks.get( i );
            if ( link.getMetaObject( ) instanceof Association ) {
                result.add( link );
            }
        }
        return result;
    }

    protected Collection getValues( RefFeatured featured, String featureName ) {

        Collection values = null;
        StructuralFeature feature = getFeatureByName( (MofClass) featured.refMetaObject( ), featureName );
        if ( feature.getMultiplicity( ).isOrdered( ) ) {
            if ( feature.getMultiplicity( ).isUnique( ) ) {
                values = new MyUniqueList( (List) featured.refGetValue( featureName ) );
            } else {
                values = new ArrayList( (List) featured.refGetValue( featureName ) );
            }
        } else {
            if ( feature.getMultiplicity( ).isUnique( ) ) {
                values = new MyUniqueCollection( (Collection) featured.refGetValue( featureName ) );
            } else {
                values = new MyCollection( (Collection) featured.refGetValue( featureName ) );
            }
        }
        return values;
    }

    protected List<Collection>[] queryLinksAtEnds( RefAssociation association, List[] objectsAtEnds ) {

        List<AssociationEnd> ends = getMOINConnection( ).getJmiHelper( ).getAssociationEnds( association.refMetaObject( ) );
        List<Collection>[] linksAtEnds = new List[] { new ArrayList<Collection>( ), new ArrayList<Collection>( ) };
        for ( int i = 0; i <= 1; i++ ) {
            for ( int j = 0; j < objectsAtEnds[1 - i].size( ); j++ ) {
                if ( !( objectsAtEnds[1 - i].get( j ) instanceof RefObject ) ) {
                    linksAtEnds[i].add( j, new MyUniqueList( ) );
                    continue;
                }
                if ( ends.get( i ).getMultiplicity( ).isOrdered( ) ) {
                    linksAtEnds[i].add( j, new MyUniqueList( association.refQuery( ends.get( 1 - i ), (RefObject) objectsAtEnds[1 - i].get( j ) ) ) );
                } else {
                    linksAtEnds[i].add( j, new MyUniqueCollection( association.refQuery( ends.get( 1 - i ), (RefObject) objectsAtEnds[1 - i].get( j ) ) ) );
                }
            }
        }
        return linksAtEnds;
    }

    protected StructuralFeature getFeatureByName( MofClass mofClass, String featureName ) {

        StructuralFeature feature = getMOINConnection( ).getJmiHelper( ).getAttributeByName( mofClass, featureName, true );
        if ( feature == null ) {
            // ok, we do have a reference here
            feature = getMOINConnection( ).getJmiHelper( ).getReferenceByName( mofClass, featureName, true );
        }
        return feature;
    }

    protected List<Attribute> getNonDerivedAttributes( MofClass mofClass ) {

        List<Attribute> nonDerivedAttributes = new ArrayList<Attribute>( );
        for ( Attribute attribute : getMOINConnection( ).getJmiHelper( ).getAttributes( mofClass, true ) ) {
            if ( !attribute.isDerived( ) ) {
                nonDerivedAttributes.add( attribute );
            }
        }
        return nonDerivedAttributes;
    }

    protected List<Attribute> getNonDerivedDataTypeAttributes( MofClass mofClass ) {

        List<Attribute> nonDerivedAttributes = new ArrayList<Attribute>( );
        for ( Attribute attribute : getMOINConnection( ).getJmiHelper( ).getAttributes( mofClass, true ) ) {
            if ( !attribute.isDerived( ) && !( attribute.getType( ) instanceof MofClass ) ) {
                nonDerivedAttributes.add( attribute );
            }
        }
        return nonDerivedAttributes;
    }

    protected List<Attribute> getNonDerivedClassAttributes( MofClass mofClass ) {

        List<Attribute> nonDerivedAttributes = new ArrayList<Attribute>( );
        for ( Attribute attribute : getMOINConnection( ).getJmiHelper( ).getAttributes( mofClass, true ) ) {
            if ( !attribute.isDerived( ) && attribute.getType( ) instanceof MofClass ) {
                nonDerivedAttributes.add( attribute );
            }
        }
        return nonDerivedAttributes;
    }

    protected class MyCollection extends ArrayList {

        private static final long serialVersionUID = 1L;

        public MyCollection( ) {

            super( );
        }

        public MyCollection( Collection aCollection ) {

            super( aCollection );
        }

        @Override
        public boolean equals( Object o ) {

            Collection collection = (Collection) o;
            return ( containsAll( collection ) ) && ( size( ) == collection.size( ) );
        }
    }

    protected class MyUniqueCollection extends MyUniqueList {

        private static final long serialVersionUID = 1L;

        public MyUniqueCollection( Collection aCollection ) {

            super( aCollection );
        }

        @Override
        public boolean equals( Object o ) {

            Collection collection = (Collection) o;
            return ( containsAll( collection ) ) && ( size( ) == collection.size( ) );
        }
    }

    protected class MyUniqueList<E> extends ArrayList {

        private static final long serialVersionUID = 1L;

        public MyUniqueList( ) {

            super( );
        }

        public MyUniqueList( Collection aCollection ) {

            super( aCollection );
            eliminateDuplicates( );
        }

        @Override
        public boolean add( Object element ) {

            if ( !contains( element ) ) {
                return super.add( element );
            } else {
                return false;
            }
        }

        @Override
        public void add( int index, Object element ) {

            if ( !contains( element ) ) {
                super.add( index, element );
            }
        }

        @Override
        public boolean addAll( Collection elements ) {

            boolean result = false;
            for ( Iterator iter = elements.iterator( ); iter.hasNext( ); ) {
                Object element = iter.next( );
                if ( !contains( element ) ) {
                    super.add( element );
                    result = true;
                }
            }
            return result;
        }

        @Override
        public boolean addAll( int index, Collection elements ) {

            boolean result = false;
            for ( Iterator iter = elements.iterator( ); iter.hasNext( ); ) {
                Object element = iter.next( );
                if ( !contains( element ) ) {
                    super.add( index++, element );
                    result = true;
                }
            }
            return result;
        }

        @Override
        public Object set( int index, Object element ) {

            if ( !contains( element ) || get( index ).equals( element ) ) {
                // if the list contains the element, only a replace is possible
                return super.set( index, element );
            } else {
                return null;
            }
        }

        private void eliminateDuplicates( ) {

            List tempList = new ArrayList( );
            for ( Iterator iter = iterator( ); iter.hasNext( ); ) {
                Object element = iter.next( );
                if ( !tempList.contains( element ) ) {
                    tempList.add( element );
                }
            }
            clear( );
            addAll( tempList );
        }

        private List eliminateDuplicates( Collection collection ) {

            List tempList = new ArrayList( );
            for ( Iterator iter = collection.iterator( ); iter.hasNext( ); ) {
                Object element = iter.next( );
                if ( !tempList.contains( element ) ) {
                    tempList.add( element );
                }
            }
            return tempList;
        }
    }

    protected void initEventsCheck( EventTypeFilter eventTypeFilter ) {

        listener = new ChangeListenerImpl( );
        coreSession.getEventRegistry( ).registerListener( listener, eventTypeFilter );
    }

    protected void initEventsCheck( ) {

        listener = new ChangeListenerImpl( );
        coreSession.getEventRegistry( ).registerListener( listener, new EventTypeFilter( ModelChangeEvent.class ) );
        coreSession.getEventRegistry( ).registerListener( listener, new EventTypeFilter( PartitionChangeEvent.class ) );
    }

    protected void testEventsCheck( List<ChangeEvent> expected ) {

        coreSession.getEventRegistry( ).deregister( listener );
        checkEvents( expected, listener.getCollectedEvents( ) );
        listener = null;
    }

    protected void testPartitionsLockedAndDirty( Collection<ModelPartition> partitionsLockedAndDirty ) {

        for ( ModelPartition partitionLockedAndDirty : partitionsLockedAndDirty ) {
            if ( !partitionLockedAndDirty.getPri( ).isNullPartition( ) && !partitionLockedAndDirty.getPri( ).isVolatilePartition( ) ) {
                assertLocked( lockManager, partitionLockedAndDirty.getPri( ), getMOINConnection( ) );
                assertDirty( partitionLockedAndDirty );
            }
        }
    }

    protected void testPartitionsUnlockedAndNotDirty( Collection<ModelPartition> partitionsUnlockedAndNotDirty ) {

        for ( ModelPartition partitionUnlockedAndNotDirty : partitionsUnlockedAndNotDirty ) {
            if ( !partitionUnlockedAndNotDirty.getPri( ).isNullPartition( ) && !partitionUnlockedAndNotDirty.getPri( ).isVolatilePartition( ) ) {
                assertNotLocked( lockManager, partitionUnlockedAndNotDirty.getPri( ) );
                assertNotDirty( partitionUnlockedAndNotDirty );
            }
        }
    }

    private class ChangeListenerImpl implements ChangeListener {

        List<ChangeEvent> collectedEvents = new ArrayList<ChangeEvent>( );

        public void notify( ChangeEvent event ) {

            collectedEvents.add( event );
        }

        public List<ChangeEvent> getCollectedEvents( ) {

            return collectedEvents;
        }
    }

    protected void checkEvents( List<? extends ChangeEvent> expectedEvs, List<? extends ChangeEvent> gotEvs ) {

        // Check that both lists of events are equivalent, this means equivalent elements in the same order.
        assertEquals( "number of events differ:", expectedEvs.size( ), gotEvs.size( ) );
        int i = 0;
        for ( ChangeEvent exp : expectedEvs ) {
            compareEvents( exp, gotEvs.get( i++ ) );
        }
    }

    private void compareEvents( ChangeEvent expected, ChangeEvent got ) {

        // assertEquals(expected.getClass(), got.getClass());
        if ( expected instanceof ElementChangeEvent ) {
            ElementChangeEvent e2 = (ElementChangeEvent) expected;
            ElementChangeEvent g2 = (ElementChangeEvent) got;
            assertNullOrEquals( e2.getAffectedElementMri( ), g2.getAffectedElementMri( ) );
            if ( expected instanceof AttributeValueEvent ) {
                AttributeValueEvent e1 = (AttributeValueEvent) expected;
                AttributeValueEvent g1 = (AttributeValueEvent) got;
                assertNullOrEquals( e1.getAffectedMetaObjectMri( ), g1.getAffectedMetaObjectMri( ) );
                if ( expected instanceof AttributeValueChangeEvent ) {
                    AttributeValueChangeEvent e = (AttributeValueChangeEvent) expected;
                    AttributeValueChangeEvent g = (AttributeValueChangeEvent) got;
                    assertNullOrEquals( e.getOldValue( ), g.getOldValue( ) );
                    assertNullOrEquals( e.getNewValue( ), g.getNewValue( ) );
                } else if ( expected instanceof AttributeValueAddEvent ) {
                    AttributeValueAddEvent e = (AttributeValueAddEvent) expected;
                    AttributeValueAddEvent g = (AttributeValueAddEvent) got;
                    assertNullOrEquals( e.getValue( ), g.getValue( ) );
                    assertNullOrEquals( e.getPosition( ), g.getPosition( ) );
                } else if ( expected instanceof AttributeValueRemoveEvent ) {
                    AttributeValueRemoveEvent e = (AttributeValueRemoveEvent) expected;
                    AttributeValueRemoveEvent g = (AttributeValueRemoveEvent) got;
                    assertNullOrEquals( e.getValue( ), g.getValue( ) );
                    assertNullOrEquals( e.getPosition( ), g.getPosition( ) );
                }
            } else if ( expected instanceof ElementCreateEvent ) {
                ElementCreateEvent e = (ElementCreateEvent) expected;
                ElementCreateEvent g = (ElementCreateEvent) got;
            } else if ( expected instanceof ElementDeleteEvent ) {
                ElementDeleteEvent e1 = (ElementDeleteEvent) expected;
                ElementDeleteEvent g1 = (ElementDeleteEvent) got;
                assertNullOrEquals( e1.getMetaObjectMri( ), g1.getMetaObjectMri( ) );
            }
        } else if ( expected instanceof LinkChangeEvent ) {
            LinkChangeEvent e2 = (LinkChangeEvent) expected;
            LinkChangeEvent g2 = (LinkChangeEvent) got;
            assertNullOrEquals( e2.getAffectedMetaObjectMri( ), g2.getAffectedMetaObjectMri( ) );
            assertNullOrEquals( e2.getNonStoredLinkEndLri( ), g2.getNonStoredLinkEndLri( ) );
            assertNullOrEquals( e2.getStoredLinkEndMri( ), g2.getStoredLinkEndMri( ) );
            // Nothing to compare by LinkAddEvent and LinkRemoveEvent
            if ( expected instanceof LinkAddEvent ) {
                LinkAddEvent e1 = (LinkAddEvent) expected;
                LinkAddEvent g1 = (LinkAddEvent) got;
            } else if ( expected instanceof LinkRemoveEvent ) {
                LinkRemoveEvent e1 = (LinkRemoveEvent) expected;
                LinkRemoveEvent g1 = (LinkRemoveEvent) got;
            }
        } else if ( expected instanceof PartitionMembershipChangeEvent ) {
            PartitionMembershipChangeEvent e2 = (PartitionMembershipChangeEvent) expected;
            PartitionMembershipChangeEvent g2 = (PartitionMembershipChangeEvent) got;
            assertNullOrEquals( e2.getAffectedElementNewMri( ), g2.getAffectedElementNewMri( ) );
            assertNullOrEquals( e2.getAffectedElementOldMri( ), g2.getAffectedElementOldMri( ) );
            assertNullOrEquals( e2.getNewPartitionPri( ), g2.getNewPartitionPri( ) );
            assertNullOrEquals( e2.getOldPartitionPri( ), g2.getOldPartitionPri( ) );
        } else if ( expected instanceof PartitionChangeEvent ) {
            PartitionChangeEvent e2 = (PartitionChangeEvent) expected;
            PartitionChangeEvent g2 = (PartitionChangeEvent) got;
            assertNullOrEquals( e2.getAffectedPartitionPri( ), g2.getAffectedPartitionPri( ) );
        }
    }

    protected boolean containsElementWithMri( CoreConnection connection, JmiList collectionToCheck, MRI mri ) {

        for ( Iterator it = collectionToCheck.iterator( connection ); it.hasNext( ); ) {
            Partitionable refObject = (Partitionable) it.next( );
            if ( refObject.get___Mri( ).equals( mri ) ) {
                return true;
            }
        }
        return false;
    }

    private void assertNullOrEquals( Object expected, Object actual ) {

        if ( ( expected == null ) || ( expected instanceof Integer && expected.equals( new Integer( -99 ) ) ) ) {
            return;
        }
        // TODO: This should not be necessary!
        if ( expected instanceof Partitionable && actual instanceof Partitionable ) {
            if ( ( (Partitionable) expected ).is___Alive( ) && ( (Partitionable) actual ).is___Alive( ) ) {
                // both are alive, i.e. not deleted, so I can check them
                MRI expectedMri = ( (Partitionable) expected ).get___Mri( );
                MRI actualMri = ( (Partitionable) actual ).get___Mri( );
                assertEquals( expectedMri, actualMri );
            }
        } else if ( expected instanceof MRI && actual instanceof MRI ) {
            if ( !expected.equals( actual ) ) {
                assertEquals( expected, actual );
            }
        } else {
            assertEquals( expected, actual );
        }
    }

    protected void assertInstanceParameters( RefObject instance, Map<Attribute, Object> parameters ) {

        for ( Attribute attribute : parameters.keySet( ) ) {
            Object parameter = parameters.get( attribute );
            Object attributeValue = instance.refGetValue( attribute.getName( ) );
            assertEquals( parameter, attributeValue );
        }
    }

    protected static void assertLocked( LockManager manager, PRI pri, Connection owner ) {

        Connection currentOwner = manager.getLockOwner( pri );
        assertEquals( "Expected other lock owner", owner, currentOwner );
    }

    protected static void assertNotLocked( LockManager manager, PRI pri ) {

        // Make sure the pri is not locked
        Connection currentOwner = manager.getLockOwner( pri );
        assertNull( "Expected no lock owner", currentOwner );
    }

    protected static void assertDirty( ModelPartition partition ) {

        assertTrue( "partition should be dirty: " + partition.getPri( ), partition.isDirty( ) );
    }

    protected static void assertNotDirty( ModelPartition partition ) {

        assertFalse( "partition should not be dirty: " + partition.getPri( ), partition.isDirty( ) );
    }

    protected class TestLinkAddEvent implements LinkAddEvent {

        public TestLinkAddEvent( RefAssociation assoc, RefObject firstLinkEnd, int index, MRI secondLinkEndMri ) {

            _affectedMetaObjectMri = ( (Partitionable) assoc.refMetaObject( ) ).get___Mri( );
            _firstLinkEndMri = ( (Partitionable) firstLinkEnd ).get___Mri( );
            _secondLinkEndMri = secondLinkEndMri;
            if ( index == 1 ) {
                MRI tmp = _firstLinkEndMri;
                _firstLinkEndMri = _secondLinkEndMri;
                _secondLinkEndMri = tmp;
            }
            // TODO
            _linkPosition = -99;
        }

        public TestLinkAddEvent( RefAssociation assoc, RefObject firstLinkEnd, int index, RefObject secondLinkEnd ) {

            _affectedMetaObjectMri = ( (Partitionable) assoc.refMetaObject( ) ).get___Mri( );
            _firstLinkEndMri = ( (Partitionable) firstLinkEnd ).get___Mri( );
            _secondLinkEndMri = ( (Partitionable) secondLinkEnd ).get___Mri( );
            if ( index == 1 ) {
                MRI tmp = _firstLinkEndMri;
                _firstLinkEndMri = _secondLinkEndMri;
                _secondLinkEndMri = tmp;
            }
            // TODO
            _linkPosition = -99;
        }

        public TestLinkAddEvent( Reference ref, RefObject featured, RefObject value ) {

            Association assoc = (Association) ref.getReferencedEnd( ).getContainer( );
            _affectedMetaObjectMri = ( (Partitionable) assoc ).get___Mri( );
            _firstLinkEndMri = ( (Partitionable) featured ).get___Mri( );
            _secondLinkEndMri = ( (Partitionable) value ).get___Mri( );
            if ( assoc.getContents( ).get( 0 ).equals( ref.getReferencedEnd( ) ) ) {
                MRI tmp = _firstLinkEndMri;
                _firstLinkEndMri = _secondLinkEndMri;
                _secondLinkEndMri = tmp;
            }
            // TODO
            _linkPosition = -99;
        }

        public RefFeatured getAffectedMetaObject( Connection resolvingConnection ) {

            return null;
        }

        MRI _affectedMetaObjectMri;

        public MRI getAffectedMetaObjectMri( ) {

            return _affectedMetaObjectMri;
        }

        public RefObject getFirstLinkEnd( Connection resolvingConnection ) {

            return null;
        }

        MRI _firstLinkEndMri;

        public MRI getFirstLinkEndMri( ) {

            return _firstLinkEndMri;
        }

        int _linkPosition = -1;

        public int getPosition( ) {

            return _linkPosition;
        }

        public RefObject getSecondLinkEnd( Connection resolvingConnection ) {

            return null;
        }

        MRI _secondLinkEndMri;

        public MRI getSecondLinkEndMri( ) {

            return _secondLinkEndMri;
        }

        public Connection getEventTriggerConnection( ) {

            return null;
        }

        public void veto( String reason ) {

        }

        public LRI getNonStoredLinkEndLri( ) {

            // TODO Auto-generated method stub
            return null;
        }

        public MRI getStoredLinkEndMri( ) {

            // TODO Auto-generated method stub
            return null;
        }
    }

    protected class TestLinkRemoveEvent implements LinkRemoveEvent {

        public TestLinkRemoveEvent( RefAssociation assoc, RefObject firstLinkEnd, int index, MRI secondLinkEndMri ) {

            _affectedMetaObjectMri = ( (Partitionable) assoc.refMetaObject( ) ).get___Mri( );
            _firstLinkEndMri = ( (Partitionable) firstLinkEnd ).get___Mri( );
            _secondLinkEndMri = secondLinkEndMri;
            if ( index == 1 ) {
                MRI tmp = _firstLinkEndMri;
                _firstLinkEndMri = _secondLinkEndMri;
                _secondLinkEndMri = tmp;
            }
            // TODO
            _linkPosition = -99;
        }

        public TestLinkRemoveEvent( RefAssociation assoc, RefObject firstLinkEnd, int index, RefObject secondLinkEnd ) {

            _affectedMetaObjectMri = ( (Partitionable) assoc.refMetaObject( ) ).get___Mri( );
            _firstLinkEndMri = ( (Partitionable) firstLinkEnd ).get___Mri( );
            _secondLinkEndMri = ( (Partitionable) secondLinkEnd ).get___Mri( );
            if ( index == 1 ) {
                MRI tmp = _firstLinkEndMri;
                _firstLinkEndMri = _secondLinkEndMri;
                _secondLinkEndMri = tmp;
            }
            // TODO
            _linkPosition = -99;
        }

        public TestLinkRemoveEvent( Reference ref, RefObject featured, RefObject value ) {

            Association assoc = (Association) ref.getReferencedEnd( ).getContainer( );
            _affectedMetaObjectMri = ( (Partitionable) assoc ).get___Mri( );
            _firstLinkEndMri = ( (Partitionable) featured ).get___Mri( );
            _secondLinkEndMri = ( (Partitionable) value ).get___Mri( );
            if ( assoc.getContents( ).get( 0 ).equals( ref.getReferencedEnd( ) ) ) {
                MRI tmp = _firstLinkEndMri;
                _firstLinkEndMri = _secondLinkEndMri;
                _secondLinkEndMri = tmp;
            }
            // TODO
            _linkPosition = -99;
        }

        public TestLinkRemoveEvent( Attribute attr, RefObject featured, RefObject value ) {

            _affectedMetaObjectMri = ( (Partitionable) attr ).get___Mri( );
            _firstLinkEndMri = ( (Partitionable) featured ).get___Mri( );
            _secondLinkEndMri = ( (Partitionable) value ).get___Mri( );
            // TODO
            _linkPosition = -99;
        }

        public RefFeatured getAffectedMetaObject( Connection resolvingConnection ) {

            return null;
        }

        MRI _affectedMetaObjectMri;

        public MRI getAffectedMetaObjectMri( ) {

            return _affectedMetaObjectMri;
        }

        public RefObject getFirstLinkEnd( Connection resolvingConnection ) {

            return null;
        }

        MRI _firstLinkEndMri;

        public MRI getFirstLinkEndMri( ) {

            return _firstLinkEndMri;
        }

        int _linkPosition = -1;

        public int getPosition( ) {

            return _linkPosition;
        }

        public RefObject getSecondLinkEnd( Connection resolvingConnection ) {

            return null;
        }

        MRI _secondLinkEndMri;

        public MRI getSecondLinkEndMri( ) {

            return _secondLinkEndMri;
        }

        public Connection getEventTriggerConnection( ) {

            return null;
        }

        public void veto( String reason ) {

        }

        public LRI getNonStoredLinkEndLri( ) {

            // TODO Auto-generated method stub
            return null;
        }

        public MRI getStoredLinkEndMri( ) {

            // TODO Auto-generated method stub
            return null;
        }
    }

    protected class TestPartitionMembershipChangeEvent implements PartitionMembershipChangeEvent {

        PRI oldPartitionPri = null;

        PRI newPartitionPri = null;

        String affectedElementMofId = null;

        protected TestPartitionMembershipChangeEvent( String anAffectedElementMofId, PRI anOldPartitionPri, PRI aNewPartitionPri ) {

            oldPartitionPri = anOldPartitionPri;
            newPartitionPri = aNewPartitionPri;
            affectedElementMofId = anAffectedElementMofId;
        }

        public MRI getAffectedElementOldMri( ) {

            return oldPartitionPri.createMri( affectedElementMofId );
        }

        public MRI getAffectedElementNewMri( ) {

            return newPartitionPri.createMri( affectedElementMofId );
        }

        public RefObject getAffectedElement( Connection connection ) {

            return null;
        }

        public PRI getNewPartitionPri( ) {

            return newPartitionPri;
        }

        public ModelPartition getNewPartition( Connection connection ) {

            return connection.getPartition( newPartitionPri );
        }

        public PRI getOldPartitionPri( ) {

            return oldPartitionPri;
        }

        public ModelPartition getOldPartition( Connection connection ) {

            return connection.getPartition( oldPartitionPri );
        }

        public Connection getEventTriggerConnection( ) {

            return null;
        }

        public void veto( String reason ) {

        }
    }
}
