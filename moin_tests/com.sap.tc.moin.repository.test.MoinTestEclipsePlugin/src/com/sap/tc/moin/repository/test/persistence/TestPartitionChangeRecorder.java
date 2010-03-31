package com.sap.tc.moin.repository.test.persistence;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Constant;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Parameter;
import com.sap.tc.moin.repository.mmi.model.Tag;
import com.sap.tc.moin.repository.mmi.model.VisibilityKind;
import com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.moin.mm.gfw.datatypes.Point;
import com.sap.moin.mm.gfw.graphics.GraphicsPackage;
import com.sap.moin.mm.gfw.pictograms.Polygon;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.CommandStack;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.PartitionChangeRecorder;
import com.sap.tc.moin.repository.mmi.reflect.RefClassCalculatedMofId;
import com.sap.tc.moin.repository.spi.core.SpiEndAndMetaObject;
import com.sap.tc.moin.repository.spi.core.SpiLink;
import com.sap.tc.moin.repository.spi.facility.SpiPartitionDelta;
import com.sap.tc.moin.repository.test.core.CoreMoinTest;
import com.sap.tc.moin.test.fw.TestMetaModels;
import com.sap.tc.moin.toplevel1.Toplevel1Package;

public class TestPartitionChangeRecorder extends CoreMoinTest {

    private ModelPackage modelPackage;

    private GraphicsPackage graphicsPackage;

    /**
     * Lives in getPartitionOne().
     */
    private MofPackage mofPackage;

    /**
     * Lives in getPartitionOne().
     */
    private MofPackage nestedPackage1;

    /**
     * Lives in getPartitionOne().
     */
    private MofPackage nestedPackage2;

    /**
     * Lives in getPartitionOne().
     */
    private Attribute mofAttribute;

    /**
     * Lives in getPartitionTwo().
     */
    private MofClass mofClass;

    /**
     * Lives in getPartitionTwo().
     */
    private Polygon polygon;

    /**
     * Lives in getPartitionThree().
     */
    private Tag tag;

    /**
     * Lives in getPartitionThree().
     */
    private Constant constant;

    /**
     * Lives in getPartitionThree().
     */
    private EnumerationType enumerationType;

    /**
     * Lives in getPartitionThree().
     */
    private Point point;

    private PartitionChangeRecorder changeRecorder;

    private CommandStack commandStack;

    private SpiPartitionDelta delta1, delta2, delta3;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        Connection connection = getMOINConnection( );
        CoreConnection coreConnection = getTestHelper( ).getCoreConnection( connection );
        modelPackage = (ModelPackage) connection.getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );
        mofPackage = (MofPackage) modelPackage.getMofPackage( ).refCreateInstance( );
        getPartitionOne( ).assignElement( mofPackage );
        nestedPackage1 = (MofPackage) modelPackage.getMofPackage( ).refCreateInstance( );
        nestedPackage1.setName( "nestedPackage1" );
        nestedPackage1.setContainer( mofPackage );
        nestedPackage2 = (MofPackage) modelPackage.getMofPackage( ).refCreateInstance( );
        nestedPackage2.setName( "nestedPackage2" );
        nestedPackage2.setContainer( mofPackage );
        mofAttribute = (Attribute) modelPackage.getAttribute( ).refCreateInstance( );
        mofAttribute.setMultiplicity( coreConnection.getCoreJmiHelper( ).createMultiplicityType( coreConnection, 0, 1, false, false ) );
        getPartitionOne( ).assignElement( mofAttribute );
        mofClass = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        getPartitionTwo( ).assignElement( mofClass );
        graphicsPackage = (GraphicsPackage) connection.getPackage( TestMetaModels.GFW_CN, TestMetaModels.GFW_TPE );
        polygon = getPartitionTwo( ).createElement( Polygon.class );
        tag = (Tag) modelPackage.getTag( ).refCreateInstance( );
        getPartitionThree( ).assignElement( tag );
        constant = (Constant) modelPackage.getConstant( ).refCreateInstance( );
        getPartitionThree( ).assignElement( constant );
        tag.getElements( ).add( constant );
        enumerationType = (EnumerationType) modelPackage.getEnumerationType( ).refCreateInstance( );
        enumerationType.getLabels( ).add( "label1" );
        enumerationType.getLabels( ).add( "label2" );
        getPartitionThree( ).assignElement( enumerationType );
        point = getPartitionThree( ).createElement( Point.class );
        connection.save( );
        changeRecorder = getTestHelper( ).getCoreConnection( connection ).getPartitionChangeRecorder( );
        commandStack = getMOINConnection( ).getCommandStack( );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        modelPackage = null;
        graphicsPackage = null;
        mofPackage = null;
        mofClass = null;
        polygon = null;
        tag = null;
        point = null;
        mofAttribute = null;
        delta1 = null;
        delta2 = null;
        delta3 = null;
        changeRecorder = null;
        commandStack = null;
        super.afterTestMethod( );
    }

    @Test
    public void testLinkOrderUsingIterators( ) throws Exception {

        try {
            beginCommand( );
            List<ModelElement> contents = mofPackage.getContents( );
            // Change the link order twice, resulting in the original order.
            ListIterator<ModelElement> listIterator = contents.listIterator( );
            ModelElement modelElement = listIterator.next( );
            listIterator.remove( );
            contents.add( modelElement );
            listIterator = contents.listIterator( );
            modelElement = listIterator.next( );
            listIterator.remove( );
            contents.add( modelElement );
            computeDeltas( );
            assertTrue( delta1.isEmpty( ) );
            assertTrue( delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
            endCommandAndUndo( );
        } finally {
            revert( );
        }
    }

    @Test
    public void testAttributeChanges( ) throws Exception {

        try {
            beginCommand( );
            String oldValueAttribute1 = mofPackage.getName( );
            VisibilityKind oldValueAttribute2 = mofPackage.getVisibility( );
            mofPackage.setName( "newName" );
            mofPackage.setVisibility( VisibilityKindEnum.PROTECTED_VIS );
            computeDeltas( );
            assertTrue( !delta1.isEmpty( ) );
            assertTrue( delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
            assertTrue( delta1.getCreatedElements( ).isEmpty( ) );
            assertTrue( delta1.getDeletedElements( ).isEmpty( ) );
            assertTrue( delta1.getAddedLinks( ).isEmpty( ) );
            assertTrue( delta1.getRemovedLinks( ).isEmpty( ) );
            assertTrue( delta1.getAssignedElements( ).isEmpty( ) );
            assertTrue( delta1.getUnassignedElements( ).isEmpty( ) );
            assertTrue( delta1.getAssignedLinks( ).isEmpty( ) );
            assertTrue( delta1.getUnassignedLinks( ).isEmpty( ) );
            assertTrue( delta1.getModifiedOrderedLinkCollections( ).isEmpty( ) );
            Map<Partitionable, Map<Attribute, Object>> changedAttributes = delta1.getChangedAttributes( );
            assertTrue( changedAttributes.size( ) == 1 );
            Partitionable element = changedAttributes.keySet( ).iterator( ).next( );
            assertTrue( element.equals( getTestHelper( ).getCorePartitionable( mofPackage ) ) );
            Attribute[] attrs = changedAttributes.values( ).iterator( ).next( ).keySet( ).toArray( new Attribute[0] );
            Collection<Object> oldValuesCollection = changedAttributes.values( ).iterator( ).next( ).values( );
            assertTrue( attrs.length == 2 );
            assertEquals( 2, oldValuesCollection.size( ) );
            Object[] oldValues = oldValuesCollection.toArray( new Object[oldValuesCollection.size( )] );
            assertTrue( attrs[0].getName( ).equals( "name" ) );
            assertTrue( attrs[1].getName( ).equals( "visibility" ) );
            assertEquals( oldValueAttribute1, oldValues[0] );
            assertEquals( oldValueAttribute2, oldValues[1] );
            endCommandAndUndo( );
        } finally {
            revert( );
        }
    }

    @Test
    public void testMultiValuedAttributes1( ) throws Exception {

        try {
            beginCommand( );
            enumerationType.getLabels( ).add( "label3" );
            computeDeltas( );
            assertTrue( delta1.isEmpty( ) );
            assertTrue( delta2.isEmpty( ) );
            assertTrue( !delta3.isEmpty( ) );
            assertTrue( delta3.getCreatedElements( ).isEmpty( ) );
            assertTrue( delta3.getDeletedElements( ).isEmpty( ) );
            assertTrue( delta3.getAddedLinks( ).isEmpty( ) );
            assertTrue( delta3.getRemovedLinks( ).isEmpty( ) );
            assertTrue( delta3.getAssignedElements( ).isEmpty( ) );
            assertTrue( delta3.getUnassignedElements( ).isEmpty( ) );
            assertTrue( delta3.getAssignedLinks( ).isEmpty( ) );
            assertTrue( delta3.getUnassignedLinks( ).isEmpty( ) );
            assertTrue( delta3.getModifiedOrderedLinkCollections( ).isEmpty( ) );
            Map<Partitionable, Map<Attribute, Object>> changedAttributes = delta3.getChangedAttributes( );
            assertTrue( changedAttributes.size( ) == 1 );
            Partitionable element = changedAttributes.keySet( ).iterator( ).next( );
            assertTrue( element.equals( getTestHelper( ).getCorePartitionable( enumerationType ) ) );
            Attribute[] attrs = changedAttributes.values( ).iterator( ).next( ).keySet( ).toArray( new Attribute[0] );
            assertTrue( attrs.length == 1 );
            assertTrue( attrs[0].getName( ).equals( "labels" ) );
            endCommandAndUndo( );
        } finally {
            revert( );
        }
    }

    @Test
    public void testMultiValuedAttributes2( ) throws Exception {

        try {
            beginCommand( );
            enumerationType.getLabels( ).remove( "label1" );
            computeDeltas( );
            assertTrue( delta1.isEmpty( ) );
            assertTrue( delta2.isEmpty( ) );
            assertTrue( !delta3.isEmpty( ) );
            assertTrue( delta3.getCreatedElements( ).isEmpty( ) );
            assertTrue( delta3.getDeletedElements( ).isEmpty( ) );
            assertTrue( delta3.getAddedLinks( ).isEmpty( ) );
            assertTrue( delta3.getRemovedLinks( ).isEmpty( ) );
            assertTrue( delta3.getAssignedElements( ).isEmpty( ) );
            assertTrue( delta3.getUnassignedElements( ).isEmpty( ) );
            assertTrue( delta3.getAssignedLinks( ).isEmpty( ) );
            assertTrue( delta3.getUnassignedLinks( ).isEmpty( ) );
            assertTrue( delta3.getModifiedOrderedLinkCollections( ).isEmpty( ) );
            Map<Partitionable, Map<Attribute, Object>> changedAttributes = delta3.getChangedAttributes( );
            assertTrue( changedAttributes.size( ) == 1 );
            Partitionable element = changedAttributes.keySet( ).iterator( ).next( );
            assertTrue( element.equals( getTestHelper( ).getCorePartitionable( enumerationType ) ) );
            Attribute[] attrs = changedAttributes.values( ).iterator( ).next( ).keySet( ).toArray( new Attribute[0] );
            assertTrue( attrs.length == 1 );
            assertTrue( attrs[0].getName( ).equals( "labels" ) );
            endCommandAndUndo( );
        } finally {
            revert( );
        }
    }

    @Test
    public void testMultiValuedAttributes3( ) throws Exception {

        try {
            beginCommand( );
            enumerationType.getLabels( ).set( 1, "label3" );
            computeDeltas( );
            assertTrue( delta1.isEmpty( ) );
            assertTrue( delta2.isEmpty( ) );
            assertTrue( !delta3.isEmpty( ) );
            assertTrue( delta3.getCreatedElements( ).isEmpty( ) );
            assertTrue( delta3.getDeletedElements( ).isEmpty( ) );
            assertTrue( delta3.getAddedLinks( ).isEmpty( ) );
            assertTrue( delta3.getRemovedLinks( ).isEmpty( ) );
            assertTrue( delta3.getAssignedElements( ).isEmpty( ) );
            assertTrue( delta3.getUnassignedElements( ).isEmpty( ) );
            assertTrue( delta3.getAssignedLinks( ).isEmpty( ) );
            assertTrue( delta3.getUnassignedLinks( ).isEmpty( ) );
            assertTrue( delta3.getModifiedOrderedLinkCollections( ).isEmpty( ) );
            Map<Partitionable, Map<Attribute, Object>> changedAttributes = delta3.getChangedAttributes( );
            assertTrue( changedAttributes.size( ) == 1 );
            Partitionable element = changedAttributes.keySet( ).iterator( ).next( );
            assertTrue( element.equals( getTestHelper( ).getCorePartitionable( enumerationType ) ) );
            Attribute[] attrs = changedAttributes.values( ).iterator( ).next( ).keySet( ).toArray( new Attribute[0] );
            assertTrue( attrs.length == 1 );
            assertTrue( attrs[0].getName( ).equals( "labels" ) );
            endCommandAndUndo( );
        } finally {
            revert( );
        }
    }

    @Test
    public void testObjectValuedAttributes1( ) throws Exception {

        try {
            beginCommand( );
            Point p = getMOINConnection( ).createElementInPartition( Point.class, null );
            p.setX( -1 );
            p.setY( 3 );
            polygon.getPoints( ).add( p );
            computeDeltas( );
            assertTrue( delta1.isEmpty( ) );
            assertTrue( !delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
            assertTrue( delta2.getDeletedElements( ).isEmpty( ) );
            assertTrue( delta2.getRemovedLinks( ).isEmpty( ) );
            assertTrue( delta2.getAssignedElements( ).isEmpty( ) );
            assertTrue( delta2.getUnassignedElements( ).isEmpty( ) );
            assertTrue( delta2.getAssignedLinks( ).isEmpty( ) );
            assertTrue( delta2.getUnassignedLinks( ).isEmpty( ) );
            assertTrue( delta2.getCreatedElements( ).size( ) == 1 );
            assertTrue( delta2.getCreatedElements( ).contains( getTestHelper( ).getCorePartitionable( p ) ) );
            assertTrue( delta2.getChangedAttributes( ).isEmpty( ) );
            assertTrue( delta2.getAddedLinks( ).size( ) == 1 );
            delta2.getAddedLinks( ).iterator( ).next( ).toString( ); // code coverage: call toString() of AttributeEndStorageLink
            assertTrue( delta2.getModifiedOrderedLinkCollections( ).size( ) == 1 );
            Map<MRI, Map<SpiEndAndMetaObject, List<SpiLink>>> modifiedOrderedLinkCollections = delta2.getModifiedOrderedLinkCollections( );
            assertTrue( modifiedOrderedLinkCollections.keySet( ).iterator( ).next( ).equals( ( (Partitionable) polygon ).get___Mri( ) ) );
            assertTrue( modifiedOrderedLinkCollections.values( ).iterator( ).next( ).size( ) == 1 );
            getMOINConnection( ).save( );
            computeDeltas( );
            assertTrue( delta1.isEmpty( ) );
            assertTrue( delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
            beginCommand( );
            polygon.getPoints( ).clear( );
            computeDeltas( );
            assertTrue( delta1.isEmpty( ) );
            assertTrue( !delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
            assertTrue( delta2.getAssignedElements( ).isEmpty( ) );
            assertTrue( delta2.getUnassignedElements( ).isEmpty( ) );
            assertTrue( delta2.getAssignedLinks( ).isEmpty( ) );
            assertTrue( delta2.getUnassignedLinks( ).isEmpty( ) );
            assertTrue( delta2.getCreatedElements( ).isEmpty( ) );
            assertTrue( delta2.getChangedAttributes( ).isEmpty( ) );
            assertTrue( delta2.getAddedLinks( ).isEmpty( ) );
            assertTrue( delta2.getDeletedElements( ).size( ) == 1 );
            assertTrue( delta2.getDeletedElements( ).contains( ( (Partitionable) p ).get___Mri( ) ) );
            assertTrue( delta2.getRemovedLinks( ).size( ) == 1 );
            assertTrue( delta2.getModifiedOrderedLinkCollections( ).size( ) == 1 );
            modifiedOrderedLinkCollections = delta2.getModifiedOrderedLinkCollections( );
            assertTrue( modifiedOrderedLinkCollections.keySet( ).iterator( ).next( ).equals( ( (Partitionable) polygon ).get___Mri( ) ) );
            assertTrue( modifiedOrderedLinkCollections.values( ).iterator( ).next( ).size( ) == 1 );
            endCommandAndUndo( );
        } finally {
            revert( );
        }
    }

    @Test
    public void testObjectValuedAttributes2( ) throws Exception {

        try {
            beginCommand( );
            polygon.getPoints( ).add( point );
            computeDeltas( );
            assertTrue( delta1.isEmpty( ) );
            assertTrue( !delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
            assertTrue( delta2.getChangedAttributes( ).isEmpty( ) );
            assertTrue( delta2.getCreatedElements( ).isEmpty( ) );
            assertTrue( delta2.getDeletedElements( ).isEmpty( ) );
            assertTrue( delta2.getRemovedLinks( ).isEmpty( ) );
            assertTrue( delta2.getAssignedElements( ).isEmpty( ) );
            assertTrue( delta2.getUnassignedElements( ).isEmpty( ) );
            assertTrue( delta2.getAssignedLinks( ).isEmpty( ) );
            assertTrue( delta2.getUnassignedLinks( ).isEmpty( ) );
            assertTrue( delta2.getAddedLinks( ).size( ) == 1 );
            assertTrue( delta2.getModifiedOrderedLinkCollections( ).size( ) == 1 );
            Map<MRI, Map<SpiEndAndMetaObject, List<SpiLink>>> modifiedOrderedLinkCollections = delta2.getModifiedOrderedLinkCollections( );
            assertTrue( modifiedOrderedLinkCollections.keySet( ).iterator( ).next( ).equals( ( (Partitionable) polygon ).get___Mri( ) ) );
            assertTrue( modifiedOrderedLinkCollections.values( ).iterator( ).next( ).size( ) == 1 );
            endCommandAndUndo( );
        } finally {
            revert( );
        }
    }

    @Test
    public void testObjectValuedAttributes3( ) throws Exception {

        try {
            beginCommand( );
            Point p = getMOINConnection( ).createElementInPartition( Point.class, null );
            p.setX( 10 );
            p.setY( 30 );
            CoreConnection conn = getTestHelper( ).getCoreConnection( getMOINConnection( ) );
            CoreModelPartition coreTransientPartition = conn.getOrCreateTransientPartitionNonTransactional( "TestPartitionChangeRecorder" );
            ModelPartition transientPartition = getMOINConnection( ).getPartition( coreTransientPartition.getPri( ) );
            transientPartition.assignElement( p );
            polygon.getPoints( ).add( p );
            computeDeltas( );
            assertTrue( delta1.isEmpty( ) );
            assertTrue( !delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
            // There is no automatic repartitioning from (non-null-partition) transient partitions!
            assertTrue( delta2.getChangedAttributes( ).isEmpty( ) );
            assertTrue( delta2.getDeletedElements( ).isEmpty( ) );
            assertTrue( delta2.getAddedLinks( ).size( ) == 1 );
            assertTrue( delta2.getRemovedLinks( ).isEmpty( ) );
            assertTrue( delta2.getAssignedElements( ).isEmpty( ) );
            assertTrue( delta2.getUnassignedElements( ).isEmpty( ) );
            assertTrue( delta2.getAssignedLinks( ).isEmpty( ) );
            assertTrue( delta2.getUnassignedLinks( ).isEmpty( ) );
            assertTrue( delta2.getCreatedElements( ).isEmpty( ) );
            assertTrue( delta2.getModifiedOrderedLinkCollections( ).size( ) == 1 );
            Map<MRI, Map<SpiEndAndMetaObject, List<SpiLink>>> modifiedOrderedLinkCollections = delta2.getModifiedOrderedLinkCollections( );
            assertTrue( modifiedOrderedLinkCollections.keySet( ).iterator( ).next( ).equals( ( (Partitionable) polygon ).get___Mri( ) ) );
            assertTrue( modifiedOrderedLinkCollections.values( ).iterator( ).next( ).size( ) == 1 );
            endCommandAndUndo( );
        } finally {
            revert( );
        }
    }

    @Test
    public void testAttributeChangeOfNewElement( ) throws Exception {

        try {
            beginCommand( );
            Association association = (Association) modelPackage.getAssociation( ).refCreateInstance( );
            association.setName( "newName" );
            getPartitionOne( ).assignElement( association );
            computeDeltas( );
            assertTrue( !delta1.isEmpty( ) );
            assertTrue( delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
            assertTrue( delta1.getDeletedElements( ).isEmpty( ) );
            assertTrue( delta1.getAddedLinks( ).isEmpty( ) );
            assertTrue( delta1.getRemovedLinks( ).isEmpty( ) );
            assertTrue( delta1.getAssignedElements( ).isEmpty( ) );
            assertTrue( delta1.getUnassignedElements( ).isEmpty( ) );
            assertTrue( delta1.getAssignedLinks( ).isEmpty( ) );
            assertTrue( delta1.getUnassignedLinks( ).isEmpty( ) );
            assertTrue( delta1.getCreatedElements( ).size( ) == 1 );
            assertTrue( delta1.getChangedAttributes( ).isEmpty( ) );
            assertTrue( delta1.getModifiedOrderedLinkCollections( ).isEmpty( ) );
            endCommandAndUndo( );
        } finally {
            revert( );
        }
    }

    @Test
    public void testCreationAndAssignmentOfNewModelElement( ) throws Exception {

        try {
            beginCommand( );
            Association association = (Association) modelPackage.getAssociation( ).refCreateInstance( );
            getPartitionOne( ).assignElement( association );
            computeDeltas( );
            assertTrue( !delta1.isEmpty( ) );
            assertTrue( delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
            assertTrue( delta1.getChangedAttributes( ).isEmpty( ) );
            assertTrue( delta1.getDeletedElements( ).isEmpty( ) );
            assertTrue( delta1.getAddedLinks( ).isEmpty( ) );
            assertTrue( delta1.getRemovedLinks( ).isEmpty( ) );
            assertTrue( delta1.getAssignedElements( ).isEmpty( ) );
            assertTrue( delta1.getUnassignedElements( ).isEmpty( ) );
            assertTrue( delta1.getAssignedLinks( ).isEmpty( ) );
            assertTrue( delta1.getUnassignedLinks( ).isEmpty( ) );
            assertTrue( delta1.getCreatedElements( ).contains( getTestHelper( ).getCorePartitionable( association ) ) );
            assertTrue( delta1.getModifiedOrderedLinkCollections( ).isEmpty( ) );
            endCommandAndUndo( );
        } finally {
            revert( );
        }
    }

    @Test
    public void testCreationOfCompositionTree1( ) throws Exception {

        try {
            beginCommand( );
            Operation operation = (Operation) modelPackage.getOperation( ).refCreateInstance( );
            Parameter param = (Parameter) modelPackage.getParameter( ).refCreateInstance( );
            operation.getContents( ).add( param );
            mofClass.getContents( ).add( operation );
            computeDeltas( );
            assertTrue( delta1.isEmpty( ) );
            assertTrue( !delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
            assertTrue( delta2.getChangedAttributes( ).isEmpty( ) );
            assertTrue( delta2.getDeletedElements( ).isEmpty( ) );
            assertTrue( delta2.getRemovedLinks( ).isEmpty( ) );
            assertTrue( delta2.getAssignedElements( ).isEmpty( ) );
            assertTrue( delta2.getUnassignedElements( ).isEmpty( ) );
            assertTrue( delta2.getAssignedLinks( ).isEmpty( ) );
            assertTrue( delta2.getUnassignedLinks( ).isEmpty( ) );
            assertTrue( delta2.getCreatedElements( ).size( ) == 2 );
            assertTrue( delta2.getAddedLinks( ).size( ) == 2 );
            assertTrue( delta2.getModifiedOrderedLinkCollections( ).size( ) == 2 );
            Map<MRI, Map<SpiEndAndMetaObject, List<SpiLink>>> modifiedOrderedLinkCollections = delta2.getModifiedOrderedLinkCollections( );
            assertTrue( modifiedOrderedLinkCollections.keySet( ).contains( ( (Partitionable) operation ).get___Mri( ) ) );
            assertTrue( modifiedOrderedLinkCollections.keySet( ).contains( ( (Partitionable) mofClass ).get___Mri( ) ) );
            endCommandAndUndo( );
        } finally {
            revert( );
        }
    }

    @Test
    public void testCreationOfCompositionTree2( ) throws Exception {

        try {
            beginCommand( );
            Operation operation = (Operation) modelPackage.getOperation( ).refCreateInstance( );
            Parameter param = (Parameter) modelPackage.getParameter( ).refCreateInstance( );
            operation.getContents( ).add( param );
            getMOINConnection( ).getNullPartition( ).assignElement( mofClass );
            mofClass.getContents( ).add( operation );
            getPartitionTwo( ).assignElementIncludingChildren( mofClass );
            computeDeltas( );
            assertTrue( delta1.isEmpty( ) );
            assertTrue( !delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
            assertTrue( delta2.getChangedAttributes( ).isEmpty( ) );
            assertTrue( delta2.getDeletedElements( ).isEmpty( ) );
            assertTrue( delta2.getRemovedLinks( ).isEmpty( ) );
            assertTrue( delta2.getAssignedElements( ).isEmpty( ) );
            assertTrue( delta2.getUnassignedElements( ).isEmpty( ) );
            assertTrue( delta2.getAssignedLinks( ).isEmpty( ) );
            assertTrue( delta2.getUnassignedLinks( ).isEmpty( ) );
            assertTrue( delta2.getCreatedElements( ).size( ) == 2 );
            assertTrue( delta2.getAddedLinks( ).size( ) == 2 );
            assertTrue( delta2.getModifiedOrderedLinkCollections( ).size( ) == 2 );
            Map<MRI, Map<SpiEndAndMetaObject, List<SpiLink>>> modifiedOrderedLinkCollections = delta2.getModifiedOrderedLinkCollections( );
            assertTrue( modifiedOrderedLinkCollections.keySet( ).contains( ( (Partitionable) operation ).get___Mri( ) ) );
            assertTrue( modifiedOrderedLinkCollections.keySet( ).contains( ( (Partitionable) mofClass ).get___Mri( ) ) );
            endCommandAndUndo( );
        } finally {
            revert( );
        }
    }

    @Test
    public void testUndoOfCreatedAssignedAndDeletedModelElement( ) throws Exception {

        try {
            beginCommand( );
            Association association = (Association) modelPackage.getAssociation( ).refCreateInstance( );
            getPartitionOne( ).assignElement( association );
            this.commandStack.closeGroup( );
            this.commandStack.openGroup( "testUndoOfCreatedAssignedAndDeletedModelElement" );
            association.refDelete( );
            this.commandStack.closeGroup( );
            this.commandStack.undo( );
            computeDeltas( );
            assertTrue( !delta1.isEmpty( ) );
            assertTrue( delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
            assertTrue( delta1.getChangedAttributes( ).isEmpty( ) );
            assertTrue( delta1.getDeletedElements( ).isEmpty( ) );
            assertTrue( delta1.getRemovedLinks( ).isEmpty( ) );
            assertTrue( delta1.getAssignedElements( ).isEmpty( ) );
            assertTrue( delta1.getUnassignedElements( ).isEmpty( ) );
            assertTrue( delta1.getAssignedLinks( ).isEmpty( ) );
            assertTrue( delta1.getUnassignedLinks( ).isEmpty( ) );
            assertTrue( delta1.getCreatedElements( ).size( ) == 1 );
            assertTrue( delta1.getAddedLinks( ).isEmpty( ) );
            assertTrue( delta1.getModifiedOrderedLinkCollections( ).isEmpty( ) );
        } finally {
            revert( );
        }
    }

    @Test
    public void testRecreateCalculatedMofIdElement( ) throws Exception {

        try {
            Toplevel1Package tl1pkg = (Toplevel1Package) getMOINConnection( ).getPackage( TestMetaModels.TESTCASES_CN, new String[] { "toplevel1" } );

            RefClass class1 = tl1pkg.getNested1( ).getClass1( );
            RefClassCalculatedMofId rcxp = (RefClassCalculatedMofId) class1;
            String locality = "ABC";
            String[] logicalKey = new String[] { "XY", "Z" };
            RefObject ro001 = rcxp.refCreateInstanceInPartition( null, logicalKey );
            getPartitionOne( ).assignElement( ro001 );
            this.getMOINConnection( ).save( );

            ro001.refDelete( );

            RefObject ro002 = rcxp.refCreateInstanceInPartition( null, logicalKey );
            getPartitionOne( ).assignElement( ro002 ); // move to partition 1, where the deleted element resided
            computeDeltas( );
            assertTrue( delta1.isEmpty( ) );
            assertTrue( delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
        } finally {
            revert( );
        }
    }

    @Test
    public void testRecreateCalculatedMofIdElementMutlipleMovesPersisted( ) throws Exception {

        try {
            Toplevel1Package tl1pkg = (Toplevel1Package) getMOINConnection( ).getPackage( TestMetaModels.TESTCASES_CN, new String[] { "toplevel1" } );

            RefClass class1 = tl1pkg.getNested1( ).getClass1( );
            RefClassCalculatedMofId rcxp = (RefClassCalculatedMofId) class1;
            String locality = "ABC";
            String[] logicalKey = new String[] { "XY", "Z" };
            RefObject ro001 = rcxp.refCreateInstanceInPartition( null, logicalKey );
            getPartitionOne( ).assignElement( ro001 );
            this.getMOINConnection( ).save( );

            ro001.refDelete( );

            RefObject ro002 = rcxp.refCreateInstanceInPartition( null, logicalKey );
            getPartitionTwo( ).assignElement( ro002 ); // move to any other PERSISTED partition than partition 1
            getMOINConnection( ).getNullPartition( ).assignElement( ro002 ); // move to null partition
            getPartitionOne( ).assignElement( ro002 ); // move to partition 1, where the deleted element resided
            computeDeltas( );
            assertTrue( delta1.isEmpty( ) );
            assertTrue( delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
        } finally {
            revert( );
        }
    }

    @Test
    public void testRecreateCalculatedMofIdElementMutlipleMovesTransient( ) throws Exception {

        try {
            Toplevel1Package tl1pkg = (Toplevel1Package) getMOINConnection( ).getPackage( TestMetaModels.TESTCASES_CN, new String[] { "toplevel1" } );

            RefClass class1 = tl1pkg.getNested1( ).getClass1( );
            RefClassCalculatedMofId rcxp = (RefClassCalculatedMofId) class1;
            String locality = "ABC";
            String[] logicalKey = new String[] { "XY", "Z" };
            RefObject ro001 = rcxp.refCreateInstanceInPartition( null, logicalKey );
            getPartitionOne( ).assignElement( ro001 );
            this.getMOINConnection( ).save( );

            ro001.refDelete( );

            RefObject ro002 = rcxp.refCreateInstanceInPartition( null, logicalKey );
            ModelPartition mp = this.getMOINConnection( ).getOrCreateTransientPartition( "TransP" );
            assertTrue( mp.getPri( ).isVolatilePartition( ) );
            mp.assignElement( ro002 ); // move to TRANSIENT partition
            getMOINConnection( ).getNullPartition( ).assignElement( ro002 ); // move to null partition
            getPartitionOne( ).assignElement( ro002 ); // move to partition 1, where the deleted element resided
            computeDeltas( );
            assertTrue( delta1.isEmpty( ) );
            assertTrue( delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
        } finally {
            revert( );
        }
    }

    @Test
    public void testCreateMoveToTransientAndBackToNullPartition( ) {

        try {
            beginCommand( );
            Association association = (Association) modelPackage.getAssociation( ).refCreateInstance( );
            getPartitionOne( ).assignElement( association );
            this.getMOINConnection( ).getNullPartition( ).assignElement( association );
            computeDeltas( );
            assertTrue( delta1.isEmpty( ) );
            assertTrue( delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
            endCommandAndUndo( );
        } finally {
            revert( );
        }
    }

    @Test
    public void testDeletionOfCreatedModelElementInNullPartition( ) throws Exception {

        try {
            beginCommand( );
            Operation operation = (Operation) modelPackage.getOperation( ).refCreateInstance( );
            Parameter param = (Parameter) modelPackage.getParameter( ).refCreateInstance( );
            operation.getContents( ).add( param );
            operation.refDelete( );
            computeDeltas( );
            assertTrue( delta1.isEmpty( ) );
            assertTrue( delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
            endCommandAndUndo( );
        } finally {
            revert( );
        }
    }

    @Test
    public void testDeletionOfCreatedAndAssignedModelElement( ) throws Exception {

        try {
            beginCommand( );
            Association association = (Association) modelPackage.getAssociation( ).refCreateInstance( );
            getPartitionOne( ).assignElement( association );
            association.refDelete( );
            computeDeltas( );
            assertTrue( delta1.isEmpty( ) );
            assertTrue( delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
            endCommandAndUndo( );
        } finally {
            revert( );
        }
    }

    @Test
    public void testDeletionOfTransientModelElement( ) throws Exception {

        try {
            beginCommand( );
            CoreConnection conn = getTestHelper( ).getCoreConnection( getMOINConnection( ) );
            CoreModelPartition coreTransientPartition = conn.getOrCreateTransientPartitionNonTransactional( "TestPartitionChangeRecorder" );
            ModelPartition transientPartition = getMOINConnection( ).getPartition( coreTransientPartition.getPri( ) );
            Association association = (Association) modelPackage.getAssociation( ).refCreateInstance( );
            transientPartition.assignElement( association );
            computeDeltas( );
            assertTrue( delta1.isEmpty( ) );
            assertTrue( delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
            getMOINConnection( ).save( ); // resets the PartitionChangeRecorder
            association.refDelete( );
            computeDeltas( );
            assertTrue( delta1.isEmpty( ) );
            assertTrue( delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
            endCommandAndUndo( );
        } finally {
            revert( );
        }
    }

    @Test
    public void testDeletionOfCompositionTree1( ) throws Exception {

        try {
            beginCommand( );
            Association association = (Association) modelPackage.getAssociation( ).refCreateInstance( );
            mofPackage.getContents( ).add( association );
            mofPackage.refDelete( );
            computeDeltas( );
            assertTrue( !delta1.isEmpty( ) );
            assertTrue( delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
            assertTrue( delta1.getChangedAttributes( ).isEmpty( ) );
            assertTrue( delta1.getCreatedElements( ).isEmpty( ) );
            assertTrue( delta1.getAddedLinks( ).isEmpty( ) );
            assertTrue( delta1.getRemovedLinks( ).size( ) == 2 );
            assertTrue( delta1.getAssignedElements( ).isEmpty( ) );
            assertTrue( delta1.getUnassignedElements( ).isEmpty( ) );
            assertTrue( delta1.getAssignedLinks( ).isEmpty( ) );
            assertTrue( delta1.getUnassignedLinks( ).isEmpty( ) );
            assertTrue( delta1.getDeletedElements( ).size( ) == 3 );
            assertTrue( delta1.getModifiedOrderedLinkCollections( ).size( ) == 1 );
            Map<MRI, Map<SpiEndAndMetaObject, List<SpiLink>>> modifiedOrderedLinkCollections = delta1.getModifiedOrderedLinkCollections( );
            assertTrue( modifiedOrderedLinkCollections.keySet( ).contains( ( (Partitionable) mofPackage ).get___Mri( ) ) );
            endCommandAndUndo( );
        } finally {
            revert( );
        }
    }

    @Test
    public void testDeletionOfCompositionTree2( ) throws Exception {

        try {
            Operation operation = (Operation) modelPackage.getOperation( ).refCreateInstance( );
            Parameter param = (Parameter) modelPackage.getParameter( ).refCreateInstance( );
            operation.getContents( ).add( param );
            mofClass.getContents( ).add( operation );
            getMOINConnection( ).save( );
            beginCommand( );
            mofClass.refDelete( );
            computeDeltas( );
            assertTrue( delta1.isEmpty( ) );
            assertTrue( !delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
            assertTrue( delta2.getChangedAttributes( ).isEmpty( ) );
            assertTrue( delta2.getCreatedElements( ).isEmpty( ) );
            assertTrue( delta2.getAddedLinks( ).isEmpty( ) );
            assertTrue( delta2.getAssignedElements( ).isEmpty( ) );
            assertTrue( delta2.getUnassignedElements( ).isEmpty( ) );
            assertTrue( delta2.getAssignedLinks( ).isEmpty( ) );
            assertTrue( delta2.getUnassignedLinks( ).isEmpty( ) );
            assertTrue( delta2.getDeletedElements( ).size( ) == 3 );
            assertTrue( delta2.getRemovedLinks( ).size( ) == 2 );
            assertTrue( delta2.getModifiedOrderedLinkCollections( ).size( ) == 2 );
            Map<MRI, Map<SpiEndAndMetaObject, List<SpiLink>>> modifiedOrderedLinkCollections = delta2.getModifiedOrderedLinkCollections( );
            assertTrue( modifiedOrderedLinkCollections.keySet( ).contains( ( (Partitionable) mofClass ).get___Mri( ) ) );
            assertTrue( modifiedOrderedLinkCollections.keySet( ).contains( ( (Partitionable) operation ).get___Mri( ) ) );
            endCommandAndUndo( );
        } finally {
            revert( );
        }
    }

    @Test
    public void testDeletionOfCompositionTree3( ) throws Exception {

        try {
            beginCommand( );
            mofPackage.getContents( ).add( mofClass );
            mofPackage.refDelete( );
            computeDeltas( );
            assertTrue( !delta1.isEmpty( ) );
            assertTrue( !delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
            assertTrue( delta1.getChangedAttributes( ).isEmpty( ) );
            assertTrue( delta1.getCreatedElements( ).isEmpty( ) );
            assertTrue( delta1.getAddedLinks( ).isEmpty( ) );
            assertTrue( delta1.getRemovedLinks( ).size( ) == 2 );
            assertTrue( delta1.getAssignedElements( ).isEmpty( ) );
            assertTrue( delta1.getUnassignedElements( ).isEmpty( ) );
            assertTrue( delta1.getAssignedLinks( ).isEmpty( ) );
            assertTrue( delta1.getUnassignedLinks( ).isEmpty( ) );
            assertTrue( delta1.getDeletedElements( ).size( ) == 3 );
            assertTrue( delta1.getModifiedOrderedLinkCollections( ).size( ) == 1 );
            Map<MRI, Map<SpiEndAndMetaObject, List<SpiLink>>> modifiedOrderedLinkCollections = delta1.getModifiedOrderedLinkCollections( );
            assertTrue( modifiedOrderedLinkCollections.keySet( ).contains( ( (Partitionable) mofPackage ).get___Mri( ) ) );
            assertTrue( delta2.getChangedAttributes( ).isEmpty( ) );
            assertTrue( delta2.getCreatedElements( ).isEmpty( ) );
            assertTrue( delta2.getAddedLinks( ).isEmpty( ) );
            assertTrue( delta2.getRemovedLinks( ).isEmpty( ) );
            assertTrue( delta2.getAssignedElements( ).isEmpty( ) );
            assertTrue( delta2.getUnassignedElements( ).isEmpty( ) );
            assertTrue( delta2.getAssignedLinks( ).isEmpty( ) );
            assertTrue( delta2.getUnassignedLinks( ).isEmpty( ) );
            assertTrue( delta2.getDeletedElements( ).size( ) == 1 );
            endCommandAndUndo( );
        } finally {
            revert( );
        }
    }

    @Test
    public void testUndoOfOrderedLinkDeletion1( ) throws Exception {

        try {
            MofPackage mofPkg = getPartitionOne( ).createElement( MofPackage.class );
            MofClass[] mofClasses = new MofClass[6];
            for ( int i = 0; i < 6; i++ ) {
                MofClass mc = getPartitionOne( ).createElement( MofClass.class );
                mc.setName( "mofClass" + ( i + 1 ) );
                mc.setContainer( mofPkg );
                mofClasses[i] = mc;
            }

            List<ModelElement> contents = mofPkg.getContents( );
            assertTrue( contents.size( ) == 6 );
            for ( int i = 0; i < 6; i++ ) {
                assertEquals( mofClasses[i].getName( ), contents.get( i ).getName( ) );
            }

            beginCommand( );
            mofClasses[5].refDelete( );
            mofClasses[3].refDelete( );
            mofClasses[1].refDelete( );
            mofClasses[4].refDelete( );
            mofClasses[2].refDelete( );
            mofClasses[0].refDelete( );
            commandStack.closeGroup( );
            commandStack.undo( );

            contents = mofPkg.getContents( );
            assertTrue( contents.size( ) == 6 );
            for ( int i = 0; i < 6; i++ ) {
                assertEquals( mofClasses[i].getName( ), contents.get( i ).getName( ) );
            }
        } finally {
            revert( );
        }
    }

    @Test
    public void testUndoOfOrderedLinkDeletion2( ) throws Exception {

        try {
            MofPackage mofPkg = getPartitionOne( ).createElement( MofPackage.class );
            MofClass[] mofClasses = new MofClass[6];
            for ( int i = 0; i < 6; i++ ) {
                MofClass mc = getPartitionOne( ).createElement( MofClass.class );
                mc.setName( "mofClass" + i );
                mc.setContainer( mofPkg );
                mofClasses[i] = mc;
            }

            List<ModelElement> contents = mofPkg.getContents( );
            assertTrue( contents.size( ) == 6 );
            for ( int i = 0; i < 6; i++ ) {
                assertEquals( mofClasses[i].getName( ), contents.get( i ).getName( ) );
            }

            beginCommand( );

            List<ModelElement> subList = contents.subList( 1, 4 );
            assertTrue( subList.size( ) == 3 );

            contents.retainAll( subList );

            assertSame( 3, contents.size( ) );
            assertEquals( mofClasses[1].getName( ), contents.get( 0 ).getName( ) );
            assertEquals( mofClasses[2].getName( ), contents.get( 1 ).getName( ) );
            assertEquals( mofClasses[3].getName( ), contents.get( 2 ).getName( ) );

            commandStack.closeGroup( );
            commandStack.undo( );

            contents = mofPkg.getContents( );
            assertTrue( contents.size( ) == 6 );
            for ( int i = 0; i < 6; i++ ) {
                assertEquals( mofClasses[i].getName( ), contents.get( i ).getName( ) );
            }
        } finally {
            revert( );
        }
    }

    @Test
    public void testUndoOfOrderedLinkDeletion3( ) throws Exception {

        try {
            MofPackage mofPkg = getPartitionOne( ).createElement( MofPackage.class );
            MofClass[] mofClasses = new MofClass[6];
            for ( int i = 0; i < 6; i++ ) {
                MofClass mc = getPartitionOne( ).createElement( MofClass.class );
                mc.setName( "mofClass" + i );
                mc.setContainer( mofPkg );
                mofClasses[i] = mc;
            }

            List<ModelElement> contents = mofPkg.getContents( );
            assertTrue( contents.size( ) == 6 );
            for ( int i = 0; i < 6; i++ ) {
                assertEquals( mofClasses[i].getName( ), contents.get( i ).getName( ) );
            }

            beginCommand( );

            List<ModelElement> subList = contents.subList( 1, 4 );
            assertTrue( subList.size( ) == 3 );

            contents.removeAll( subList );

            assertSame( 3, contents.size( ) );
            assertEquals( mofClasses[0].getName( ), contents.get( 0 ).getName( ) );
            assertEquals( mofClasses[4].getName( ), contents.get( 1 ).getName( ) );
            assertEquals( mofClasses[5].getName( ), contents.get( 2 ).getName( ) );

            commandStack.closeGroup( );
            commandStack.undo( );

            contents = mofPkg.getContents( );
            assertTrue( contents.size( ) == 6 );
            for ( int i = 0; i < 6; i++ ) {
                assertEquals( mofClasses[i].getName( ), contents.get( i ).getName( ) );
            }
        } finally {
            revert( );
        }
    }

    @Test
    public void testUndoOfOrderedLinkDeletion4( ) throws Exception {

        try {
            MofPackage mofPkg = getPartitionOne( ).createElement( MofPackage.class );
            MofClass[] mofClasses = new MofClass[6];
            for ( int i = 0; i < 6; i++ ) {
                MofClass mc = getPartitionOne( ).createElement( MofClass.class );
                mc.setName( "mofClass" + i );
                mc.setContainer( mofPkg );
                mofClasses[i] = mc;
            }

            List<ModelElement> contents = mofPkg.getContents( );
            assertTrue( contents.size( ) == 6 );
            for ( int i = 0; i < 6; i++ ) {
                assertEquals( mofClasses[i], contents.get( i ) );
            }

            beginCommand( );

            List<ModelElement> subList = contents.subList( 1, 4 );
            assertTrue( subList.size( ) == 3 );

            subList.clear( );

            assertSame( 3, contents.size( ) );
            assertEquals( mofClasses[0].getName( ), contents.get( 0 ).getName( ) );
            assertEquals( mofClasses[4].getName( ), contents.get( 1 ).getName( ) );
            assertEquals( mofClasses[5].getName( ), contents.get( 2 ).getName( ) );

            commandStack.closeGroup( );
            commandStack.undo( );

            contents = mofPkg.getContents( );
            assertTrue( contents.size( ) == 6 );
            for ( int i = 0; i < 6; i++ ) {
                assertEquals( mofClasses[i], contents.get( i ) );
            }
        } finally {
            revert( );
        }
    }

    @Test
    public void testUndoOfOrderedLinkDeletion5( ) throws Exception {

        try {
            MofPackage mofPkg = getPartitionOne( ).createElement( MofPackage.class );
            MofClass[] mofClasses = new MofClass[6];
            for ( int i = 0; i < 6; i++ ) {
                MofClass mc = getPartitionOne( ).createElement( MofClass.class );
                mc.setName( "mofClass" + ( i + 1 ) );
                mc.setContainer( mofPkg );
                mofClasses[i] = mc;
            }

            List<ModelElement> contents = mofPkg.getContents( );
            assertTrue( contents.size( ) == 6 );
            for ( int i = 0; i < 6; i++ ) {
                assertEquals( mofClasses[i], contents.get( i ) );
            }

            beginCommand( );

            contents.clear( );

            assertSame( 0, contents.size( ) );

            commandStack.closeGroup( );
            commandStack.undo( );

            contents = mofPkg.getContents( );
            assertTrue( contents.size( ) == 6 );
            for ( int i = 0; i < 6; i++ ) {
                assertEquals( mofClasses[i], contents.get( i ) );
            }
        } finally {
            revert( );
        }
    }

    @Test
    public void testDeleteAfterChainedAssignmentsBetweenPersistedPartitions( ) throws Exception {

        try {
            beginCommand( );
            getPartitionThree( ).assignElement( mofClass );
            getPartitionOne( ).assignElement( mofClass );
            mofClass.refDelete( );
            computeDeltas( );
            assertTrue( delta1.isEmpty( ) );
            assertTrue( !delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
            assertTrue( delta2.getChangedAttributes( ).isEmpty( ) );
            assertTrue( delta2.getCreatedElements( ).isEmpty( ) );
            assertTrue( delta2.getAddedLinks( ).isEmpty( ) );
            assertTrue( delta2.getRemovedLinks( ).isEmpty( ) );
            assertTrue( delta2.getAssignedElements( ).isEmpty( ) );
            assertTrue( delta2.getUnassignedElements( ).isEmpty( ) );
            assertTrue( delta2.getAssignedLinks( ).isEmpty( ) );
            assertTrue( delta2.getUnassignedLinks( ).isEmpty( ) );
            assertTrue( delta2.getDeletedElements( ).size( ) == 1 );
            assertTrue( delta2.getDeletedElements( ).iterator( ).next( ).equals( ( (Partitionable) mofClass ).get___Mri( ) ) );
            assertTrue( delta2.getModifiedOrderedLinkCollections( ).isEmpty( ) );
            endCommandAndUndo( );
        } finally {
            revert( );
        }
    }

    @Test
    public void testDeleteAfterAttributeChanges( ) throws Exception {

        try {
            beginCommand( );
            mofClass.setName( "mofClassA" );
            mofClass.setVisibility( VisibilityKindEnum.PRIVATE_VIS );
            mofClass.refDelete( );
            computeDeltas( );
            assertTrue( delta1.isEmpty( ) );
            assertTrue( !delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
            assertTrue( delta2.getCreatedElements( ).isEmpty( ) );
            assertTrue( delta2.getAddedLinks( ).isEmpty( ) );
            assertTrue( delta2.getRemovedLinks( ).isEmpty( ) );
            assertTrue( delta2.getAssignedElements( ).isEmpty( ) );
            assertTrue( delta2.getUnassignedElements( ).isEmpty( ) );
            assertTrue( delta2.getAssignedLinks( ).isEmpty( ) );
            assertTrue( delta2.getUnassignedLinks( ).isEmpty( ) );
            assertTrue( delta2.getChangedAttributes( ).isEmpty( ) );
            assertTrue( delta2.getDeletedElements( ).size( ) == 1 );
            assertTrue( delta2.getDeletedElements( ).iterator( ).next( ).equals( ( (Partitionable) mofClass ).get___Mri( ) ) );
            assertTrue( delta2.getModifiedOrderedLinkCollections( ).isEmpty( ) );
            endCommandAndUndo( );
        } finally {
            revert( );
        }
    }

    @Test
    public void testDeleteAfterLinkAddition( ) throws Exception {

        try {
            beginCommand( );
            mofClass.setContainer( mofPackage );
            mofClass.refDelete( );
            computeDeltas( );
            assertTrue( delta1.isEmpty( ) );
            assertTrue( !delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
            assertTrue( delta2.getChangedAttributes( ).isEmpty( ) );
            assertTrue( delta2.getCreatedElements( ).isEmpty( ) );
            assertTrue( delta2.getAddedLinks( ).isEmpty( ) );
            assertTrue( delta2.getRemovedLinks( ).isEmpty( ) );
            assertTrue( delta2.getAssignedElements( ).isEmpty( ) );
            assertTrue( delta2.getUnassignedElements( ).isEmpty( ) );
            assertTrue( delta2.getAssignedLinks( ).isEmpty( ) );
            assertTrue( delta2.getUnassignedLinks( ).isEmpty( ) );
            assertTrue( delta2.getDeletedElements( ).size( ) == 1 );
            assertTrue( delta2.getDeletedElements( ).iterator( ).next( ).equals( ( (Partitionable) mofClass ).get___Mri( ) ) );
            assertTrue( delta2.getModifiedOrderedLinkCollections( ).isEmpty( ) );
            endCommandAndUndo( );
        } finally {
            revert( );
        }
    }

    @Test
    public void testDeleteAfterAssignmentToNonPersistentPartition( ) throws Exception {

        try {
            beginCommand( );
            getPartitionOne( ).assignElement( mofClass );
            getPartitionTwo( ).assignElement( mofClass );
            getMOINConnection( ).getNullPartition( ).assignElement( mofClass );
            mofClass.refDelete( );
            computeDeltas( );
            assertTrue( delta1.isEmpty( ) );
            assertTrue( !delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
            assertTrue( delta2.getChangedAttributes( ).isEmpty( ) );
            assertTrue( delta2.getCreatedElements( ).isEmpty( ) );
            assertTrue( delta2.getAddedLinks( ).isEmpty( ) );
            assertTrue( delta2.getRemovedLinks( ).isEmpty( ) );
            assertTrue( delta2.getAssignedElements( ).isEmpty( ) );
            assertTrue( delta2.getUnassignedElements( ).isEmpty( ) );
            assertTrue( delta2.getAssignedLinks( ).isEmpty( ) );
            assertTrue( delta2.getUnassignedLinks( ).isEmpty( ) );
            assertTrue( delta2.getDeletedElements( ).size( ) == 1 );
            assertTrue( delta2.getDeletedElements( ).iterator( ).next( ).equals( ( (Partitionable) mofClass ).get___Mri( ) ) );
            assertTrue( delta2.getModifiedOrderedLinkCollections( ).isEmpty( ) );
            endCommandAndUndo( );
        } finally {
            revert( );
        }
    }

    @Test
    public void testDeletionOfDirtyCreatedPartition( ) throws Exception {

        ModelPartition partition = _testClient1.getOrCreatePartition( "testDeletionOfDirtyCreatedPartition_" + System.currentTimeMillis( ) );
        assertFalse( getTestHelper( ).getCoreModelPartition( partition ).isPersisted( ) );
        partition.delete( );
        computeDeltas( );
        assertTrue( delta1.isEmpty( ) );
        assertTrue( delta2.isEmpty( ) );
        assertTrue( delta3.isEmpty( ) );
    }

    @Test
    public void testDeletePartitionAfterModifications1( ) throws Exception {

        try {
            beginCommand( );
            mofPackage.setName( "mofPackageA" );
            MofClass mc = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
            Operation op = (Operation) modelPackage.getOperation( ).refCreateInstance( );
            mc.getContents( ).add( op );
            mc.setContainer( mofPackage );

            CoreModelPartition p1 = getTestHelper( ).getCoreModelPartition( getPartitionOne( ) );
            getPartitionOne( ).delete( );

            // Cannot call computeDeltas() here, otherwise getPartitionOne() cannot be unwrapped any more!
            delta1 = changeRecorder.getDeltaForPartition( getTestHelper( ).getCoreModelPartition( p1 ) );
            delta2 = changeRecorder.getDeltaForPartition( getTestHelper( ).getCoreModelPartition( getPartitionTwo( ) ) );
            delta3 = changeRecorder.getDeltaForPartition( getTestHelper( ).getCoreModelPartition( getPartitionThree( ) ) );

            assertTrue( !delta1.isEmpty( ) );
            assertTrue( delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
            assertTrue( delta1.getChangedAttributes( ).isEmpty( ) );
            assertTrue( delta1.getCreatedElements( ).isEmpty( ) );
            assertTrue( delta1.getAddedLinks( ).isEmpty( ) );
            assertTrue( delta1.getRemovedLinks( ).size( ) == 2 );
            assertTrue( delta1.getAssignedElements( ).isEmpty( ) );
            assertTrue( delta1.getUnassignedElements( ).isEmpty( ) );
            assertTrue( delta1.getAssignedLinks( ).isEmpty( ) );
            assertTrue( delta1.getUnassignedLinks( ).isEmpty( ) );
            assertTrue( delta1.getDeletedElements( ).size( ) == 4 );
            assertTrue( delta1.getDeletedElements( ).contains( ( (Partitionable) mofPackage ).get___Mri( ) ) );
            assertTrue( delta1.getDeletedElements( ).contains( ( (Partitionable) nestedPackage1 ).get___Mri( ) ) );
            assertTrue( delta1.getDeletedElements( ).contains( ( (Partitionable) nestedPackage2 ).get___Mri( ) ) );
            assertTrue( delta1.getDeletedElements( ).contains( ( (Partitionable) mofAttribute ).get___Mri( ) ) );
            assertTrue( delta1.getModifiedOrderedLinkCollections( ).size( ) == 1 );
            Map<MRI, Map<SpiEndAndMetaObject, List<SpiLink>>> modifiedOrderedLinkCollections = delta1.getModifiedOrderedLinkCollections( );
            assertTrue( modifiedOrderedLinkCollections.keySet( ).contains( ( (Partitionable) mofPackage ).get___Mri( ) ) );
            commandStack.closeGroup( );
            commandStack.undo( );
            List<ModelElement> contents = mofPackage.getContents( );
            assertTrue( contents.get( 0 ).equals( nestedPackage1 ) );
            assertTrue( contents.get( 1 ).equals( nestedPackage2 ) );
            computeDeltas( );
            assertTrue( delta1.isEmpty( ) );
            assertTrue( delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
        } finally {
            revert( );
        }
    }

    @Test
    public void testDeletePartitionAfterModifications2( ) throws Exception {

        try {
            beginCommand( );
            mofPackage.setName( "mofPackageA" );
            mofPackage.getContents( ).add( mofClass );
            getPartitionThree( ).assignElement( mofPackage );

            CoreModelPartition p1 = getTestHelper( ).getCoreModelPartition( getPartitionOne( ) );
            getPartitionOne( ).delete( );

            // Cannot call computeDeltas() here, otherwise getPartitionOne() cannot be unwrapped any more!
            delta1 = changeRecorder.getDeltaForPartition( getTestHelper( ).getCoreModelPartition( p1 ) );
            delta2 = changeRecorder.getDeltaForPartition( getTestHelper( ).getCoreModelPartition( getPartitionTwo( ) ) );
            delta3 = changeRecorder.getDeltaForPartition( getTestHelper( ).getCoreModelPartition( getPartitionThree( ) ) );

            assertTrue( !delta1.isEmpty( ) );
            assertTrue( delta2.isEmpty( ) );
            assertTrue( !delta3.isEmpty( ) );
            assertTrue( delta1.getChangedAttributes( ).isEmpty( ) );
            assertTrue( delta1.getCreatedElements( ).isEmpty( ) );
            assertTrue( delta1.getAddedLinks( ).isEmpty( ) );
            assertTrue( delta1.getRemovedLinks( ).size( ) == 2 );
            assertTrue( delta1.getAssignedElements( ).isEmpty( ) );
            assertTrue( delta1.getUnassignedElements( ).size( ) == 1 );
            assertTrue( delta1.getUnassignedElements( ).containsKey( getTestHelper( ).getCorePartitionable( mofPackage ) ) );
            assertTrue( delta1.getAssignedLinks( ).isEmpty( ) );
            assertTrue( delta1.getUnassignedLinks( ).size( ) == 1 );
            assertTrue( delta1.getDeletedElements( ).size( ) == 3 );
            assertTrue( delta1.getDeletedElements( ).contains( ( (Partitionable) mofAttribute ).get___Mri( ) ) );
            assertTrue( delta1.getDeletedElements( ).contains( ( (Partitionable) nestedPackage1 ).get___Mri( ) ) );
            assertTrue( delta1.getDeletedElements( ).contains( ( (Partitionable) nestedPackage2 ).get___Mri( ) ) );
            assertTrue( delta1.getModifiedOrderedLinkCollections( ).isEmpty( ) );
            assertTrue( delta2.getChangedAttributes( ).isEmpty( ) );
            assertTrue( delta2.getCreatedElements( ).isEmpty( ) );
            assertTrue( delta2.getDeletedElements( ).isEmpty( ) );
            assertTrue( delta2.getRemovedLinks( ).isEmpty( ) );
            assertTrue( delta2.getAssignedElements( ).isEmpty( ) );
            assertTrue( delta2.getUnassignedElements( ).isEmpty( ) );
            assertTrue( delta2.getAssignedLinks( ).isEmpty( ) );
            assertTrue( delta2.getUnassignedLinks( ).isEmpty( ) );
            assertTrue( delta2.getAddedLinks( ).isEmpty( ) );
            assertTrue( delta2.getModifiedOrderedLinkCollections( ).isEmpty( ) );
            assertTrue( delta3.getCreatedElements( ).isEmpty( ) );
            assertTrue( delta3.getDeletedElements( ).isEmpty( ) );
            assertTrue( delta3.getRemovedLinks( ).isEmpty( ) );
            assertTrue( delta3.getUnassignedElements( ).isEmpty( ) );
            assertTrue( delta3.getAssignedElements( ).size( ) == 1 );
            assertTrue( delta3.getAssignedElements( ).containsKey( getTestHelper( ).getCorePartitionable( mofPackage ) ) );
            assertTrue( delta3.getAssignedLinks( ).size( ) == 1 );
            assertTrue( delta3.getUnassignedLinks( ).isEmpty( ) );
            assertTrue( delta3.getAddedLinks( ).size( ) == 1 );
            assertTrue( delta3.getModifiedOrderedLinkCollections( ).size( ) == 1 );
            Map<MRI, Map<SpiEndAndMetaObject, List<SpiLink>>> modifiedOrderedLinkCollections = delta3.getModifiedOrderedLinkCollections( );
            assertTrue( modifiedOrderedLinkCollections.keySet( ).contains( ( mofPackage ).get___Mri( ) ) );
            Map<Partitionable, Map<Attribute, Object>> changedAttributes = delta3.getChangedAttributes( );
            Attribute[] attrs = changedAttributes.values( ).iterator( ).next( ).keySet( ).toArray( new Attribute[0] );
            assertTrue( attrs.length == 1 );
            assertTrue( attrs[0].getName( ).equals( "name" ) );
            Partitionable element = changedAttributes.keySet( ).iterator( ).next( );
            assertTrue( element.equals( getTestHelper( ).getCorePartitionable( mofPackage ) ) );
            endCommandAndUndo( );
        } finally {
            revert( );
        }
    }

    @Test
    public void testDeletePartitionAfterModifications3( ) throws Exception {

        try {
            beginCommand( );
            mofPackage.refDelete( );
            mofAttribute.refDelete( );

            CoreModelPartition p1 = getTestHelper( ).getCoreModelPartition( getPartitionOne( ) );
            getPartitionOne( ).delete( );

            // Cannot call computeDeltas() here, otherwise getPartitionOne() cannot be unwrapped any more!
            delta1 = changeRecorder.getDeltaForPartition( getTestHelper( ).getCoreModelPartition( p1 ) );
            delta2 = changeRecorder.getDeltaForPartition( getTestHelper( ).getCoreModelPartition( getPartitionTwo( ) ) );
            delta3 = changeRecorder.getDeltaForPartition( getTestHelper( ).getCoreModelPartition( getPartitionThree( ) ) );

            assertTrue( !delta1.isEmpty( ) );
            assertTrue( delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
            assertTrue( delta1.getChangedAttributes( ).isEmpty( ) );
            assertTrue( delta1.getCreatedElements( ).isEmpty( ) );
            assertTrue( delta1.getAddedLinks( ).isEmpty( ) );
            assertTrue( delta1.getRemovedLinks( ).size( ) == 2 );
            assertTrue( delta1.getAssignedElements( ).isEmpty( ) );
            assertTrue( delta1.getUnassignedElements( ).isEmpty( ) );
            assertTrue( delta1.getAssignedLinks( ).isEmpty( ) );
            assertTrue( delta1.getUnassignedLinks( ).isEmpty( ) );
            assertTrue( delta1.getDeletedElements( ).size( ) == 4 );
            assertTrue( delta1.getDeletedElements( ).contains( ( (Partitionable) mofPackage ).get___Mri( ) ) );
            assertTrue( delta1.getDeletedElements( ).contains( ( (Partitionable) mofAttribute ).get___Mri( ) ) );
            assertTrue( delta1.getDeletedElements( ).contains( ( (Partitionable) nestedPackage1 ).get___Mri( ) ) );
            assertTrue( delta1.getDeletedElements( ).contains( ( (Partitionable) nestedPackage2 ).get___Mri( ) ) );
            assertTrue( delta1.getModifiedOrderedLinkCollections( ).size( ) == 1 );
            Map<MRI, Map<SpiEndAndMetaObject, List<SpiLink>>> modifiedOrderedLinkCollections = delta1.getModifiedOrderedLinkCollections( );
            assertTrue( modifiedOrderedLinkCollections.keySet( ).contains( ( (Partitionable) mofPackage ).get___Mri( ) ) );
            endCommandAndUndo( );
        } finally {
            revert( );
        }
    }

    @Test
    public void testDeletePartitionAfterModifications4( ) throws Exception {

        try {
            beginCommand( );
            CoreConnection conn = getTestHelper( ).getCoreConnection( getMOINConnection( ) );
            CoreModelPartition coreTransientPartition = conn.getOrCreateTransientPartitionNonTransactional( "TestPartitionChangeRecorder" );
            ModelPartition transientPartition = getMOINConnection( ).getPartition( coreTransientPartition.getPri( ) );
            transientPartition.assignElement( mofAttribute );

            CoreModelPartition p1 = getTestHelper( ).getCoreModelPartition( getPartitionOne( ) );
            getPartitionOne( ).delete( );

            // Cannot call computeDeltas() here, otherwise getPartitionOne() cannot be unwrapped any more!
            delta1 = changeRecorder.getDeltaForPartition( getTestHelper( ).getCoreModelPartition( p1 ) );
            delta2 = changeRecorder.getDeltaForPartition( getTestHelper( ).getCoreModelPartition( getPartitionTwo( ) ) );
            delta3 = changeRecorder.getDeltaForPartition( getTestHelper( ).getCoreModelPartition( getPartitionThree( ) ) );

            assertTrue( !delta1.isEmpty( ) );
            assertTrue( delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
            assertTrue( delta1.getChangedAttributes( ).isEmpty( ) );
            assertTrue( delta1.getCreatedElements( ).isEmpty( ) );
            assertTrue( delta1.getAddedLinks( ).isEmpty( ) );
            assertTrue( delta1.getRemovedLinks( ).size( ) == 2 );
            assertTrue( delta1.getAssignedElements( ).isEmpty( ) );
            assertTrue( delta1.getUnassignedElements( ).isEmpty( ) );
            assertTrue( delta1.getAssignedLinks( ).isEmpty( ) );
            assertTrue( delta1.getUnassignedLinks( ).isEmpty( ) );
            assertTrue( delta1.getDeletedElements( ).size( ) == 4 );
            assertTrue( delta1.getDeletedElements( ).contains( ( (Partitionable) mofPackage ).get___Mri( ) ) );
            assertTrue( delta1.getDeletedElements( ).contains( ( (Partitionable) mofAttribute ).get___Mri( ) ) );
            assertTrue( delta1.getDeletedElements( ).contains( ( (Partitionable) nestedPackage1 ).get___Mri( ) ) );
            assertTrue( delta1.getDeletedElements( ).contains( ( (Partitionable) nestedPackage2 ).get___Mri( ) ) );
            assertTrue( delta1.getModifiedOrderedLinkCollections( ).size( ) == 1 );
            Map<MRI, Map<SpiEndAndMetaObject, List<SpiLink>>> modifiedOrderedLinkCollections = delta1.getModifiedOrderedLinkCollections( );
            assertTrue( modifiedOrderedLinkCollections.keySet( ).contains( ( (Partitionable) mofPackage ).get___Mri( ) ) );
            endCommandAndUndo( );
        } finally {
            revert( );
        }
    }

    @Test
    public void testDeletePartitionAfterModifications5( ) throws Exception {

        try {
            beginCommand( );
            mofPackage.refDelete( );
            commandStack.closeGroup( );
            commandStack.undo( );
            List<ModelElement> contents = mofPackage.getContents( );
            assertTrue( contents.get( 0 ).equals( nestedPackage1 ) );
            assertTrue( contents.get( 1 ).equals( nestedPackage2 ) );
        } finally {
            revert( );
        }
    }

    @Test
    public void testCyclicPartitionAssignmentsBetweenPersistentPartitions( ) throws Exception {

        try {
            beginCommand( );
            // Cyclic assignment between persisted partitions should not produce a delta.
            getPartitionOne( ).assignElement( tag );
            getPartitionTwo( ).assignElement( tag );
            getPartitionThree( ).assignElement( tag );
            computeDeltas( );
            assertTrue( delta1.isEmpty( ) );
            assertTrue( delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
            endCommandAndUndo( );
        } finally {
            revert( );
        }
    }

    @Test
    public void testAssignmentBetweenPersistentPartitions( ) throws Exception {

        try {
            beginCommand( );
            getPartitionOne( ).assignElement( tag );
            computeDeltas( );
            assertTrue( !delta1.isEmpty( ) );
            assertTrue( delta2.isEmpty( ) );
            assertTrue( !delta3.isEmpty( ) );
            // Assigning a persistent model element to a different persistent partition produces unassignment deltas 
            // for the source partition (for model elements as well as links) and assignment deltas for the target partition.
            assertTrue( delta1.getChangedAttributes( ).isEmpty( ) );
            assertTrue( delta1.getCreatedElements( ).isEmpty( ) );
            assertTrue( delta1.getDeletedElements( ).isEmpty( ) );
            assertTrue( delta1.getAddedLinks( ).isEmpty( ) );
            assertTrue( delta1.getRemovedLinks( ).isEmpty( ) );
            assertTrue( delta1.getUnassignedElements( ).isEmpty( ) );
            assertTrue( delta1.getAssignedElements( ).size( ) == 1 );
            assertTrue( delta1.getAssignedElements( ).containsKey( getTestHelper( ).getCorePartitionable( tag ) ) );
            assertTrue( delta1.getAssignedLinks( ).size( ) == 1 );
            assertTrue( delta1.getUnassignedLinks( ).isEmpty( ) );
            assertTrue( delta1.getModifiedOrderedLinkCollections( ).isEmpty( ) );
            assertTrue( delta3.getChangedAttributes( ).isEmpty( ) );
            assertTrue( delta3.getCreatedElements( ).isEmpty( ) );
            assertTrue( delta3.getDeletedElements( ).isEmpty( ) );
            assertTrue( delta3.getAddedLinks( ).isEmpty( ) );
            assertTrue( delta3.getRemovedLinks( ).isEmpty( ) );
            assertTrue( delta3.getAssignedElements( ).isEmpty( ) );
            assertTrue( delta3.getUnassignedElements( ).size( ) == 1 );
            assertTrue( delta3.getUnassignedElements( ).containsKey( getTestHelper( ).getCorePartitionable( tag ) ) );
            assertTrue( delta3.getAssignedLinks( ).isEmpty( ) );
            assertTrue( delta3.getUnassignedLinks( ).size( ) == 1 );
            assertTrue( delta3.getModifiedOrderedLinkCollections( ).isEmpty( ) );
            endCommandAndUndo( );
        } finally {
            revert( );
        }
    }

    /**
     * This test checks if a renaming of a persisted partition is done
     * correctly.
     * 
     * @throws Exception
     */
    @Test
    public void testAssignmentBetweenPersistentPartitionsSourceDeleted( ) throws Exception {

        ModelPartition mpOldName = this._testClient1.getOrCreatePartition( "renametest.oldName" );
        mpOldName.deleteElements( );

        MofPackage mp1 = (MofPackage) this.modelPackage.getMofPackage( ).refCreateInstance( );
        MofPackage mp2 = (MofPackage) this.modelPackage.getMofPackage( ).refCreateInstance( );
        mpOldName.assignElement( mp1 );
        mpOldName.assignElement( mp2 );
        mp1.setContainer( mp2 );

        this.getMOINConnection( ).save( );

        ModelPartition mpNewName = this._testClient1.createPartition( "renametest.newName" );

        Collection<Partitionable> elements = mpOldName.getElements( );
        for ( Partitionable elem : elements ) {
            mpNewName.assignElement( elem );
        }

        CoreModelPartition mpOldBeforeDelete = getTestHelper( ).getCoreModelPartition( mpOldName );
        mpOldName.delete( );

        SpiPartitionDelta deltaOld = changeRecorder.getDeltaForPartition( mpOldBeforeDelete );
        assertTrue( deltaOld.getUnassignedElements( ).size( ) == 2 );
        assertTrue( deltaOld.getCreatedElements( ).isEmpty( ) );
        assertTrue( deltaOld.getAssignedElements( ).isEmpty( ) );
        assertTrue( deltaOld.getDeletedElements( ).isEmpty( ) );
        assertTrue( deltaOld.getAddedLinks( ).isEmpty( ) );
        assertTrue( deltaOld.getUnassignedLinks( ).size( ) == 1 );
        assertTrue( deltaOld.getAssignedLinks( ).isEmpty( ) );
        assertTrue( deltaOld.getRemovedLinks( ).isEmpty( ) );

        SpiPartitionDelta deltaNew = changeRecorder.getDeltaForPartition( getTestHelper( ).getCoreModelPartition( mpNewName ) );
        assertTrue( deltaNew.getAssignedElements( ).size( ) == 2 );
        assertTrue( deltaNew.getCreatedElements( ).isEmpty( ) );
        assertTrue( deltaNew.getUnassignedElements( ).isEmpty( ) );
        assertTrue( deltaNew.getDeletedElements( ).isEmpty( ) );
        assertTrue( deltaNew.getAddedLinks( ).isEmpty( ) );
        assertTrue( deltaNew.getAssignedLinks( ).size( ) == 1 );
        assertTrue( deltaNew.getUnassignedLinks( ).isEmpty( ) );
        assertTrue( deltaNew.getRemovedLinks( ).isEmpty( ) );

        mpNewName.delete( );
        this.getMOINConnection( ).save( );
    }

    @Test
    public void testAssignmentFromPersistentToTransientPartition( ) throws Exception {

        try {
            Tag tag2 = (Tag) modelPackage.getTag( ).refCreateInstance( );
            getPartitionThree( ).assignElement( tag2 );
            tag.getElements( ).add( tag2 );
            getMOINConnection( ).save( );
            beginCommand( );
            CoreConnection conn = getTestHelper( ).getCoreConnection( getMOINConnection( ) );
            CoreModelPartition coreTransientPartition = conn.getOrCreateTransientPartitionNonTransactional( "TestPartitionChangeRecorder" );
            ModelPartition transientPartition = getMOINConnection( ).getPartition( coreTransientPartition.getPri( ) );
            transientPartition.assignElement( tag );
            transientPartition.assignElement( tag2 );
            computeDeltas( );
            assertTrue( delta1.isEmpty( ) );
            assertTrue( delta2.isEmpty( ) );
            assertTrue( !delta3.isEmpty( ) );
            // Assigning a persistent model element to a transient partition
            // effectively deletes it from the persistence (including connected
            // links) !
            assertTrue( delta3.getChangedAttributes( ).isEmpty( ) );
            assertTrue( delta3.getCreatedElements( ).isEmpty( ) );
            assertTrue( delta3.getAddedLinks( ).isEmpty( ) );
            assertTrue( delta3.getAssignedElements( ).isEmpty( ) );
            assertTrue( delta3.getUnassignedElements( ).isEmpty( ) );
            assertTrue( delta3.getAssignedLinks( ).isEmpty( ) );
            assertTrue( delta3.getUnassignedLinks( ).isEmpty( ) );
            assertTrue( delta3.getDeletedElements( ).size( ) == 2 );
            assertTrue( delta3.getDeletedElements( ).contains( ( (Partitionable) tag ).get___Mri( ) ) );
            assertTrue( delta3.getDeletedElements( ).contains( ( (Partitionable) tag2 ).get___Mri( ) ) );
            assertTrue( delta3.getRemovedLinks( ).size( ) == 2 );
            assertTrue( delta3.getModifiedOrderedLinkCollections( ).isEmpty( ) );
            endCommandAndUndo( );
        } finally {
            revert( );
        }
    }

    @Test
    public void testAssignmentFromTransientToPersistentPartition( ) throws Exception {

        try {
            CoreConnection conn = getTestHelper( ).getCoreConnection( getMOINConnection( ) );
            CoreModelPartition coreTransientPartition = conn.getOrCreateTransientPartitionNonTransactional( "TestPartitionChangeRecorder" );
            ModelPartition transientPartition = getMOINConnection( ).getPartition( coreTransientPartition.getPri( ) );
            Tag tag2 = (Tag) modelPackage.getTag( ).refCreateInstance( );
            Tag tag3 = (Tag) modelPackage.getTag( ).refCreateInstance( );
            tag2.getElements( ).add( tag3 );
            transientPartition.assignElement( tag2 );
            transientPartition.assignElement( tag3 );
            getMOINConnection( ).save( ); // resets the PartitionChangeRecorder
            beginCommand( );
            getPartitionThree( ).assignElement( tag2 );
            getPartitionThree( ).assignElement( tag3 );
            computeDeltas( );
            assertTrue( delta1.isEmpty( ) );
            assertTrue( delta2.isEmpty( ) );
            assertTrue( !delta3.isEmpty( ) );
            // Assigning a transient model element to a persistent partition
            // effectively adds it to the persistence (including connected
            // links) !
            assertTrue( delta3.getChangedAttributes( ).isEmpty( ) );
            assertTrue( delta3.getDeletedElements( ).isEmpty( ) );
            assertTrue( delta3.getRemovedLinks( ).isEmpty( ) );
            assertTrue( delta3.getAssignedElements( ).isEmpty( ) );
            assertTrue( delta3.getUnassignedElements( ).isEmpty( ) );
            assertTrue( delta3.getAssignedLinks( ).isEmpty( ) );
            assertTrue( delta3.getUnassignedLinks( ).isEmpty( ) );
            assertTrue( delta3.getCreatedElements( ).size( ) == 2 );
            assertTrue( delta3.getCreatedElements( ).contains( getTestHelper( ).getCorePartitionable( tag2 ) ) );
            assertTrue( delta3.getCreatedElements( ).contains( getTestHelper( ).getCorePartitionable( tag3 ) ) );
            assertTrue( delta3.getAddedLinks( ).size( ) == 1 );
            assertTrue( delta3.getModifiedOrderedLinkCollections( ).isEmpty( ) );
            endCommandAndUndo( );
        } finally {
            revert( );
        }
    }

    @Test
    public void testAssignmentOfCompositionTreeFromNullPartitionToPersistentPartition( ) throws Exception {

        try {
            beginCommand( );
            Operation operation = (Operation) modelPackage.getOperation( ).refCreateInstance( );
            Parameter param = (Parameter) modelPackage.getParameter( ).refCreateInstance( );
            operation.getContents( ).add( param );
            getPartitionTwo( ).assignElementIncludingChildren( operation );
            computeDeltas( );
            assertTrue( delta1.isEmpty( ) );
            assertTrue( !delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
            assertTrue( delta2.getChangedAttributes( ).isEmpty( ) );
            assertTrue( delta2.getDeletedElements( ).isEmpty( ) );
            assertTrue( delta2.getRemovedLinks( ).isEmpty( ) );
            assertTrue( delta2.getAssignedElements( ).isEmpty( ) );
            assertTrue( delta2.getUnassignedElements( ).isEmpty( ) );
            assertTrue( delta2.getAssignedLinks( ).isEmpty( ) );
            assertTrue( delta2.getUnassignedLinks( ).isEmpty( ) );
            assertTrue( delta2.getCreatedElements( ).size( ) == 2 );
            assertTrue( delta2.getAddedLinks( ).size( ) == 1 );
            assertTrue( delta2.getModifiedOrderedLinkCollections( ).size( ) == 1 );
            Map<MRI, Map<SpiEndAndMetaObject, List<SpiLink>>> modifiedOrderedLinkCollections = delta2.getModifiedOrderedLinkCollections( );
            assertTrue( modifiedOrderedLinkCollections.keySet( ).contains( ( (Partitionable) operation ).get___Mri( ) ) );
            endCommandAndUndo( );
        } finally {
            revert( );
        }
    }

    @Test
    public void testInverseActions1( ) throws Exception {

        try {
            beginCommand( );
            tag.getElements( ).add( mofPackage );
            tag.getElements( ).remove( mofPackage );
            computeDeltas( );
            assertTrue( delta1.isEmpty( ) );
            assertTrue( delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
            endCommandAndUndo( );
        } finally {
            revert( );
        }
    }

    @Test
    public void testInverseActions2( ) throws Exception {

        try {
            beginCommand( );
            tag.getElements( ).add( mofPackage );
            tag.getElements( ).remove( mofPackage );
            tag.getElements( ).add( mofPackage );
            tag.getElements( ).remove( mofPackage );
            tag.getElements( ).add( mofPackage );
            computeDeltas( );
            assertTrue( delta1.isEmpty( ) );
            assertTrue( delta2.isEmpty( ) );
            assertTrue( !delta3.isEmpty( ) );
            assertTrue( delta3.getChangedAttributes( ).isEmpty( ) );
            assertTrue( delta3.getCreatedElements( ).isEmpty( ) );
            assertTrue( delta3.getDeletedElements( ).isEmpty( ) );
            assertTrue( delta3.getRemovedLinks( ).isEmpty( ) );
            assertTrue( delta3.getAssignedElements( ).isEmpty( ) );
            assertTrue( delta3.getUnassignedElements( ).isEmpty( ) );
            assertTrue( delta3.getAssignedLinks( ).isEmpty( ) );
            assertTrue( delta3.getUnassignedLinks( ).isEmpty( ) );
            assertTrue( delta3.getAddedLinks( ).size( ) == 1 );
            assertTrue( delta3.getModifiedOrderedLinkCollections( ).isEmpty( ) );
            endCommandAndUndo( );
        } finally {
            revert( );
        }
    }

    @Test
    public void testInverseActions3( ) throws Exception {

        try {
            beginCommand( );
            tag.getElements( ).add( mofPackage );
            tag.getElements( ).add( mofPackage );
            tag.getElements( ).add( mofPackage );
            tag.getElements( ).remove( mofPackage );
            tag.getElements( ).remove( mofPackage );
            computeDeltas( );
            assertTrue( delta1.isEmpty( ) );
            assertTrue( delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
            endCommandAndUndo( );
        } finally {
            revert( );
        }
    }

    @Test
    public void testInverseActions4( ) throws Exception {

        try {
            beginCommand( );
            CoreConnection conn = getTestHelper( ).getCoreConnection( getMOINConnection( ) );
            String oldName = mofPackage.getName( );
            VisibilityKind oldVisibility = mofPackage.getVisibility( );
            MultiplicityType oldMultiplicity = mofAttribute.getMultiplicity( );
            mofPackage.setName( "newName" );
            mofPackage.setVisibility( VisibilityKindEnum.PROTECTED_VIS );
            mofPackage.setName( oldName );
            mofPackage.setVisibility( oldVisibility );
            mofAttribute.setMultiplicity( conn.getCoreJmiHelper( ).createMultiplicityType( conn, 0, -1, true, true ) );
            mofAttribute.setMultiplicity( conn.getCoreJmiHelper( ).createMultiplicityType( conn, oldMultiplicity.getLower( ), oldMultiplicity.getUpper( ), oldMultiplicity.isOrdered( ), oldMultiplicity.isUnique( ) ) );
            computeDeltas( );
            assertTrue( delta1.isEmpty( ) );
            assertTrue( delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
            endCommandAndUndo( );
        } finally {
            revert( );
        }
    }

    @Test
    public void testEvictPartitionForced( ) throws Exception {

        try {
            mofClass.setContainer( mofPackage );
            computeDeltas( );
            assertTrue( !delta1.isEmpty( ) );
            assertTrue( delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
            assertTrue( delta1.getChangedAttributes( ).isEmpty( ) );
            assertTrue( delta1.getCreatedElements( ).isEmpty( ) );
            assertTrue( delta1.getDeletedElements( ).isEmpty( ) );
            assertTrue( delta1.getRemovedLinks( ).isEmpty( ) );
            assertTrue( delta1.getAssignedElements( ).isEmpty( ) );
            assertTrue( delta1.getUnassignedElements( ).isEmpty( ) );
            assertTrue( delta1.getAssignedLinks( ).isEmpty( ) );
            assertTrue( delta1.getUnassignedLinks( ).isEmpty( ) );
            assertTrue( delta1.getAddedLinks( ).size( ) == 1 );
            assertTrue( delta1.getModifiedOrderedLinkCollections( ).size( ) == 1 );
            Map<MRI, Map<SpiEndAndMetaObject, List<SpiLink>>> modifiedOrderedLinkCollections = delta1.getModifiedOrderedLinkCollections( );
            assertTrue( modifiedOrderedLinkCollections.keySet( ).contains( ( (Partitionable) mofPackage ).get___Mri( ) ) );
            assertTrue( delta2.getChangedAttributes( ).isEmpty( ) );
            assertTrue( delta2.getCreatedElements( ).isEmpty( ) );
            assertTrue( delta2.getDeletedElements( ).isEmpty( ) );
            assertTrue( delta2.getRemovedLinks( ).isEmpty( ) );
            assertTrue( delta2.getAssignedElements( ).isEmpty( ) );
            assertTrue( delta2.getUnassignedElements( ).isEmpty( ) );
            assertTrue( delta2.getAssignedLinks( ).isEmpty( ) );
            assertTrue( delta2.getUnassignedLinks( ).isEmpty( ) );
            assertTrue( delta2.getAddedLinks( ).isEmpty( ) );
            assertTrue( delta2.getModifiedOrderedLinkCollections( ).isEmpty( ) );
            CoreModelPartition partitionOne = getTestHelper( ).getCoreModelPartition( getPartitionOne( ) );
            CoreModelPartition partitionTwo = getTestHelper( ).getCoreModelPartition( getPartitionTwo( ) );
            CoreConnection conn = getTestHelper( ).getCoreConnection( getMOINConnection( ) );
            conn.getSession( ).getWorkspace( ).getPartitionManager( ).evictPartitionForced( partitionOne );
            conn.getSession( ).getWorkspace( ).getPartitionManager( ).evictPartitionForced( partitionTwo );
            computeDeltas( );
            assertTrue( delta1.isEmpty( ) );
            assertTrue( delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
        } finally {
            revert( );
        }
    }

    @Test
    public void testCleanupOfPersistentHomePartitionMapAfterSaveRevert( ) throws Exception {

        try {
            getPartitionOne( ).assignElement( mofClass );
            computeDeltas( );
            assertTrue( !delta1.isEmpty( ) );
            assertTrue( !delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
            assertTrue( delta1.getChangedAttributes( ).isEmpty( ) );
            assertTrue( delta1.getCreatedElements( ).isEmpty( ) );
            assertTrue( delta1.getDeletedElements( ).isEmpty( ) );
            assertTrue( delta1.getAddedLinks( ).isEmpty( ) );
            assertTrue( delta1.getRemovedLinks( ).isEmpty( ) );
            assertTrue( delta1.getAssignedElements( ).size( ) == 1 );
            assertTrue( delta1.getUnassignedElements( ).isEmpty( ) );
            assertTrue( delta1.getAssignedLinks( ).isEmpty( ) );
            assertTrue( delta1.getUnassignedLinks( ).isEmpty( ) );
            assertTrue( delta1.getModifiedOrderedLinkCollections( ).isEmpty( ) );
            assertTrue( delta2.getChangedAttributes( ).isEmpty( ) );
            assertTrue( delta2.getCreatedElements( ).isEmpty( ) );
            assertTrue( delta2.getDeletedElements( ).isEmpty( ) );
            assertTrue( delta2.getAddedLinks( ).isEmpty( ) );
            assertTrue( delta2.getRemovedLinks( ).isEmpty( ) );
            assertTrue( delta2.getAssignedElements( ).isEmpty( ) );
            assertTrue( delta2.getUnassignedElements( ).size( ) == 1 );
            assertTrue( delta2.getAssignedLinks( ).isEmpty( ) );
            assertTrue( delta2.getUnassignedLinks( ).isEmpty( ) );
            assertTrue( delta2.getModifiedOrderedLinkCollections( ).isEmpty( ) );
            getMOINConnection( ).save( );
            beginCommand( );
            getPartitionTwo( ).assignElement( mofClass );
            mofClass.refDelete( );
            computeDeltas( );
            assertTrue( !delta1.isEmpty( ) );
            assertTrue( delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
            assertTrue( !delta1.getDeletedElements( ).isEmpty( ) );
            assertTrue( delta1.getChangedAttributes( ).isEmpty( ) );
            assertTrue( delta1.getCreatedElements( ).isEmpty( ) );
            assertTrue( delta1.getAddedLinks( ).isEmpty( ) );
            assertTrue( delta1.getRemovedLinks( ).isEmpty( ) );
            assertTrue( delta1.getAssignedElements( ).isEmpty( ) );
            assertTrue( delta1.getUnassignedElements( ).isEmpty( ) );
            assertTrue( delta1.getAssignedLinks( ).isEmpty( ) );
            assertTrue( delta1.getUnassignedLinks( ).isEmpty( ) );
            assertTrue( delta1.getModifiedOrderedLinkCollections( ).isEmpty( ) );
            endCommandAndUndo( );
        } finally {
            revert( );
        }
    }

    @Test
    public void testLinkOrder1( ) throws Exception {

        try {
            beginCommand( );
            List<ModelElement> contents = mofPackage.getContents( );
            // Change the link order twice, resulting in the original order.
            contents.add( contents.remove( 0 ) );
            contents.add( contents.remove( 0 ) );
            computeDeltas( );
            assertTrue( delta1.isEmpty( ) );
            assertTrue( delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
            endCommandAndUndo( );
        } finally {
            revert( );
        }
    }

    @Test
    public void testLinkOrder2( ) throws Exception {

        try {
            beginCommand( );
            List<ModelElement> contents = mofPackage.getContents( );
            contents.add( contents.remove( 0 ) ); // swap the links at positions 0 and 1
            computeDeltas( );
            assertTrue( !delta1.isEmpty( ) );
            assertTrue( delta2.isEmpty( ) );
            assertTrue( delta3.isEmpty( ) );
            assertTrue( delta1.getChangedAttributes( ).isEmpty( ) );
            assertTrue( delta1.getCreatedElements( ).isEmpty( ) );
            assertTrue( delta1.getDeletedElements( ).isEmpty( ) );
            assertTrue( delta1.getAddedLinks( ).isEmpty( ) );
            assertTrue( delta1.getRemovedLinks( ).isEmpty( ) );
            assertTrue( delta1.getAssignedElements( ).isEmpty( ) );
            assertTrue( delta1.getUnassignedElements( ).isEmpty( ) );
            assertTrue( delta1.getAssignedLinks( ).isEmpty( ) );
            assertTrue( delta1.getUnassignedLinks( ).isEmpty( ) );
            assertTrue( delta1.getModifiedOrderedLinkCollections( ).size( ) == 1 );
            Map<MRI, Map<SpiEndAndMetaObject, List<SpiLink>>> modifiedOrderedLinkCollections = delta1.getModifiedOrderedLinkCollections( );
            assertTrue( modifiedOrderedLinkCollections.keySet( ).iterator( ).next( ).equals( ( (Partitionable) mofPackage ).get___Mri( ) ) );
            assertTrue( modifiedOrderedLinkCollections.values( ).iterator( ).next( ).values( ).iterator( ).next( ).size( ) == 2 );
            endCommandAndUndo( );
        } finally {
            revert( );
        }
    }

    private void beginCommand( ) {

        commandStack.openGroup( "TestPartitionChangeRecorder" );
    }

    private void endCommandAndUndo( ) {

        commandStack.closeGroup( );
        commandStack.undo( );
        computeDeltas( );
        assertTrue( delta1.isEmpty( ) );
        assertTrue( delta2.isEmpty( ) );
        assertTrue( delta3.isEmpty( ) );
    }

    private void revert( ) {

        getMOINConnection( ).revert( );
        computeDeltas( );
        assertTrue( delta1.isEmpty( ) );
        assertTrue( delta2.isEmpty( ) );
        assertTrue( delta3.isEmpty( ) );
    }

    private void computeDeltas( ) {

        delta1 = changeRecorder.getDeltaForPartition( getTestHelper( ).getCoreModelPartition( getPartitionOne( ) ) );
        delta2 = changeRecorder.getDeltaForPartition( getTestHelper( ).getCoreModelPartition( getPartitionTwo( ) ) );
        delta3 = changeRecorder.getDeltaForPartition( getTestHelper( ).getCoreModelPartition( getPartitionThree( ) ) );
    }
}