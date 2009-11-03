/*
 * Created on 22.06.2005
 */
package com.sap.tc.moin.repository.test.core;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.friends.MoinUtil;
import com.sap.tc.moin.friends.factory.UtilitiesFactory;
import com.sap.tc.moin.repository.InconsistentModelException;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor;
import com.sap.tc.moin.repository.mmi.reflect.RefClassCalculatedMofId;
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.repository.shared.util.Utilities.CalculatedMofIdAppl;
import com.sap.tc.moin.test.fw.TestMetaModels;
import com.sap.tc.moin.testcases.case001.A1;
import com.sap.tc.moin.testcases.case001.Super;
import com.sap.tc.moin.testcases.case013.C13Abstract;
import com.sap.tc.moin.testcases.case013.C13Sub;
import com.sap.tc.moin.toplevel1.Toplevel1Package;
import com.sap.tc.moin.toplevel3.Toplevel3Package;

/**
 * @author D024227
 */
public class TestCalculatedMofIds extends CoreMoinTest {

    Toplevel1Package toplevel1Ref;

    Toplevel3Package toplevel3Ref;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        toplevel1Ref = (Toplevel1Package) getMOINConnection( ).getPackage( TestMetaModels.TESTCASES_CN, new String[] { "toplevel1" } );
        toplevel3Ref = (Toplevel3Package) getMOINConnection( ).getPackage( TestMetaModels.TESTCASES_CN, new String[] { "toplevel3" } );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
        toplevel1Ref = null;
    }

    @Test
    public void testUtilities( ) {

        String mofId001 = Utilities.getUtilities( ).calculateMofId( CalculatedMofIdAppl.EXTERNAL, "A", new String[] { "B&", "D" } );
        String mofId002 = Utilities.getUtilities( ).calculateMofId( CalculatedMofIdAppl.EXTERNAL, "A", new String[] { "B", "&D" } );
        assertTrue( "logical keys B& D and B &D create the same MOF id", !mofId001.equals( mofId002 ) );
        String mofId003 = Utilities.getUtilities( ).calculateMofId( CalculatedMofIdAppl.EXTERNAL, "B", new String[] { "B", "&D" } );
        assertTrue( "a difference only in the locality input does not create different MOF ids", !mofId002.equals( mofId003 ) );
    }

    @Test
    public void testDuplicateMofId( ) {

        RefClass class1 = toplevel1Ref.getNested1( ).getClass1( );
        RefClassCalculatedMofId rcxp = (RefClassCalculatedMofId) class1;
        String locality = "ABC";
        String[] logicalKey = new String[] { "XY", "Z" };
        rcxp.refCreateInstanceInPartition( null, logicalKey );
        try {
            rcxp.refCreateInstanceInPartition( null, logicalKey );
            fail( "Instance with same logical key and herewith MOF id could be created" );
        } catch ( InconsistentModelException e ) {
        }
    }

    @Test
    public void testMofIdOnDifferentClassProxies( ) {

        RefClassCalculatedMofId class1 = (RefClassCalculatedMofId) toplevel1Ref.getNested1( ).getClass1( );
        RefClassCalculatedMofId class3 = (RefClassCalculatedMofId) toplevel3Ref.getNested3( ).getClass3( );
        String locality = null;
        String[] logicalKey = null;
        RefObject ro001 = class1.refCreateInstanceInPartition( null, logicalKey );
        RefObject ro003 = class3.refCreateInstanceInPartition( null, logicalKey );
        assertTrue( "Model elements created with different class proxies have same MOF id", !ro001.refMofId( ).equals( ro003 ) );
    }

    @Test
    public void testCalculateMofId( ) {

        RefClass class1 = toplevel1Ref.getNested1( ).getClass1( );
        RefClassCalculatedMofId rcxp = (RefClassCalculatedMofId) class1;
        String[] logicalKey = new String[] { "XY", "Z" };
        RefObject ro001 = rcxp.refCreateInstanceInPartition( null, logicalKey );
        String mofId = rcxp.calculateMofId( logicalKey );
        LRI lriCreated = ( (Partitionable) ro001 ).get___Partition( ).getPri( ).createMri( mofId ).getLri( );
        LRI lriOfObject = ( (Partitionable) ro001 ).get___Mri( ).getLri( );
        assertEquals( "LRI of Object must match calculated LRI", lriOfObject, lriCreated );
        RefBaseObject elementInConnection = getMOINConnection( ).getElement( lriCreated );
        assertNotNull( elementInConnection );
        MoinUtil moinUtil = UtilitiesFactory.getMoinUtil( );
        assertTrue( moinUtil.isCalculatedMofId( lriCreated.getMofId( ) ) );
        assertTrue( moinUtil.isCalculatedMofId( elementInConnection.refMofId( ) ) );

        MofClass regularElement = getPartitionOne( ).createElement( MofClass.class );
        assertFalse( moinUtil.isCalculatedMofId( regularElement.refMofId( ) ) );
        try {
            moinUtil.isCalculatedMofId( null );
            fail( "Expected exception" );
        } catch ( NullPointerException e ) {
            //expected
        }
    }



    @Test
    public void testCreateInPartition( ) {

        RefClass class1 = toplevel1Ref.getNested1( ).getClass1( );
        RefClassCalculatedMofId rcxp = (RefClassCalculatedMofId) class1;
        String locality = "ABC";
        String[] logicalKey = new String[] { "XY", "Z" };

        // this call once failed because the Wrapper forgot to unwrap the partition
        rcxp.refCreateInstanceInPartition( getPartitionOne( ), logicalKey );

    }

    @Test
    public void testCreateWithSuperClassMofId( ) {

        RefClass class1 = getMOINConnection( ).getClass( C13Sub.CLASS_DESCRIPTOR );
        RefClassCalculatedMofId rcxp = (RefClassCalculatedMofId) class1;
        String[] logicalKey = new String[] { "XY", "Z" };

        // First try the mofIds without object creation
        String mofId1 = rcxp.calculateMofId( C13Abstract.CLASS_DESCRIPTOR, logicalKey );
        String mofId2 = rcxp.calculateMofId( logicalKey );

        assertFalse( mofId1.equals( mofId2 ) );

        RefObject refObject1 = rcxp.refCreateInstanceInPartition( getPartitionOne( ), C13Abstract.CLASS_DESCRIPTOR, logicalKey );
        assertTrue( refObject1.refMofId( ).equals( mofId1 ) );
    }


    @Test
    public void testCreateWithSameSuperClassMofId( ) {

        RefClass class1 = getMOINConnection( ).getClass( C13Sub.CLASS_DESCRIPTOR );
        RefClassCalculatedMofId rcxp = (RefClassCalculatedMofId) class1;
        String[] logicalKey = new String[] { "XY", "Z" };

        // First try the mofIds without object creation
        String mofId1 = rcxp.calculateMofId( C13Sub.CLASS_DESCRIPTOR, logicalKey );
        String mofId2 = rcxp.calculateMofId( logicalKey );

        assertEquals( mofId1, mofId2 );

        RefObject refObject1 = rcxp.refCreateInstanceInPartition( getPartitionOne( ), C13Sub.CLASS_DESCRIPTOR, logicalKey );
        assertTrue( refObject1.refMofId( ).equals( mofId1 ) );
    }


    @Test
    public void testCreateWithNullSuperClassMofId( ) {

        RefClass class1 = getMOINConnection( ).getClass( C13Sub.CLASS_DESCRIPTOR );
        RefClassCalculatedMofId rcxp = (RefClassCalculatedMofId) class1;
        String[] logicalKey = new String[] { "XY", "Z" };

        // First try the mofIds without object creation
        String mofId1 = rcxp.calculateMofId( null, logicalKey );
        String mofId2 = rcxp.calculateMofId( logicalKey );

        assertEquals( mofId1, mofId2 );

        RefObject refObject1 = rcxp.refCreateInstanceInPartition( getPartitionOne( ), null, logicalKey );
        assertTrue( refObject1.refMofId( ).equals( mofId1 ) );
    }


    @Test
    public void testCreateWithSuperClassDescriptorMofId( ) {

        RefClass class1 = getMOINConnection( ).getClass( C13Sub.CLASS_DESCRIPTOR );
        RefClassCalculatedMofId rcxp = (RefClassCalculatedMofId) class1;
        String[] logicalKey = new String[] { "XY", "Z" };

        // First try the mofIds without object creation
        String mofId1 = rcxp.calculateMofId( C13Abstract.CLASS_DESCRIPTOR, logicalKey );
        String mofId2 = rcxp.calculateMofId( logicalKey );

        assertFalse( mofId1.equals( mofId2 ) );

        RefObject refObject1 = rcxp.refCreateInstanceInPartition( getPartitionOne( ), C13Abstract.CLASS_DESCRIPTOR, logicalKey );
        assertTrue( refObject1.refMofId( ).equals( mofId1 ) );
    }


    @Test
    public void testCreateWithSameSuperClassDescriptorMofId( ) {

        RefClass class1 = getMOINConnection( ).getClass( C13Sub.CLASS_DESCRIPTOR );
        RefClassCalculatedMofId rcxp = (RefClassCalculatedMofId) class1;
        String[] logicalKey = new String[] { "XY", "Z" };

        // First try the mofIds without object creation
        String mofId1 = rcxp.calculateMofId( C13Sub.CLASS_DESCRIPTOR, logicalKey );
        String mofId2 = rcxp.calculateMofId( logicalKey );

        assertEquals( mofId1, mofId2 );

        RefObject refObject1 = rcxp.refCreateInstanceInPartition( getPartitionOne( ), C13Sub.CLASS_DESCRIPTOR, logicalKey );
        assertTrue( refObject1.refMofId( ).equals( mofId1 ) );
    }


    @Test
    public void testCreateWithNullSuperClassDescriptorMofId( ) {

        RefClass class1 = getMOINConnection( ).getClass( C13Sub.CLASS_DESCRIPTOR );
        RefClassCalculatedMofId rcxp = (RefClassCalculatedMofId) class1;
        String[] logicalKey = new String[] { "XY", "Z" };

        // First try the mofIds without object creation
        String mofId1 = rcxp.calculateMofId( null, logicalKey );
        String mofId2 = rcxp.calculateMofId( logicalKey );

        assertEquals( mofId1, mofId2 );

        RefObject refObject1 = rcxp.refCreateInstanceInPartition( getPartitionOne( ), null, logicalKey );
        assertTrue( refObject1.refMofId( ).equals( mofId1 ) );
    }



    @Test
    public void testSuperClassMofIdIsSame( ) {

        RefClassCalculatedMofId superClass = (RefClassCalculatedMofId) getMOINConnection( ).getClass( Super.CLASS_DESCRIPTOR );
        RefClassCalculatedMofId A1Class = (RefClassCalculatedMofId) getMOINConnection( ).getClass( A1.CLASS_DESCRIPTOR );

        String[] logicalKey = new String[] { "XY", "Z" };

        // try the mofIds without object creation
        String mofId1 = superClass.calculateMofId( logicalKey );
        String mofId2 = A1Class.calculateMofId( Super.CLASS_DESCRIPTOR, logicalKey );

        assertTrue( mofId1.equals( mofId2 ) );

        superClass.refCreateInstanceInPartition( null, logicalKey );
        try {
            // Creation with affinity to super-class must fail
            A1Class.refCreateInstanceInPartition( null, Super.CLASS_DESCRIPTOR, logicalKey );
            fail( "Instance with same logical key and herewith MOF id could be created" );
        } catch ( InconsistentModelException e ) {
        }

        // Creation with affinity to A1 must succeed
        A1Class.refCreateInstanceInPartition( null, logicalKey );
    }

    @Test
    public void testSuperClassDescriptorMofIdIsSame( ) {

        RefClassCalculatedMofId superClass = (RefClassCalculatedMofId) getMOINConnection( ).getClass( Super.CLASS_DESCRIPTOR );
        RefClassCalculatedMofId A1Class = (RefClassCalculatedMofId) getMOINConnection( ).getClass( A1.CLASS_DESCRIPTOR );

        String[] logicalKey = new String[] { "XY", "Z" };

        // try the mofIds without object creation
        String mofId1 = superClass.calculateMofId( logicalKey );
        String mofId2 = A1Class.calculateMofId( Super.CLASS_DESCRIPTOR, logicalKey );

        assertTrue( mofId1.equals( mofId2 ) );

        superClass.refCreateInstanceInPartition( null, logicalKey );
        try {
            // Creation with affinity to super-class must fail
            A1Class.refCreateInstanceInPartition( null, Super.CLASS_DESCRIPTOR, logicalKey );
            fail( "Instance with same logical key and herewith MOF id could be created" );
        } catch ( InconsistentModelException e ) {
        }

        // Creation with affinity to A1 must succeed
        A1Class.refCreateInstanceInPartition( null, logicalKey );
    }

    @Test
    public void testWithWrongSuperClass( ) {

        RefClassCalculatedMofId A1Class = (RefClassCalculatedMofId) getMOINConnection( ).getClass( A1.CLASS_DESCRIPTOR );

        String locality = "ABC";
        String[] logicalKey = new String[] { "XY", "Z" };

        try {
            A1Class.refCreateInstanceInPartition( null, MofClass.CLASS_DESCRIPTOR, logicalKey );
            fail( "Must fail because MofClass is not a superclass of A1" );
        } catch ( IllegalArgumentException e ) {

        }
    }

    @Test
    public void testWithWrongSuperClassDescriptor( ) {

        RefClassCalculatedMofId A1Class = (RefClassCalculatedMofId) getMOINConnection( ).getClass( A1.CLASS_DESCRIPTOR );

        String locality = "ABC";
        String[] logicalKey = new String[] { "XY", "Z" };

        try {
            A1Class.refCreateInstanceInPartition( null, MofClass.CLASS_DESCRIPTOR, logicalKey );
            fail( "Must fail because MofClass is not a superclass of A1" );
        } catch ( IllegalArgumentException e ) {

        }
    }

    @Test
    public void testGetClassDescriptor( ) {

        MoinUtil moinUtil = UtilitiesFactory.getMoinUtil( );
        MofClass mofClassAssociation = getMOINConnection( ).getClass( Association.CLASS_DESCRIPTOR ).refMetaObject( );

        ClassDescriptor classDescriptorViaApi = moinUtil.getClassDescriptor( mofClassAssociation );

        assertEquals( Association.CLASS_DESCRIPTOR, classDescriptorViaApi );

    }
}
