package com.sap.tc.moin.repository.test.core;

import java.util.Collection;

import org.junit.Test;

import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;
import com.sap.tc.moin.testcases.case008.A8;
import com.sap.tc.moin.testcases.case008.Case008Package;
import com.sap.tc.moin.testcases.case008.S8;
import com.sap.tc.moin.testcases.case008.T8;
import com.sap.tc.moin.testcases.case008.U8;
import com.sap.tc.moin.testcases.case008.V8;
import com.sap.tc.moin.testcases.case008.inheritance.A8Inheritance;
import com.sap.tc.moin.testcases.case008.inheritance.InheritancePackage;
import com.sap.tc.moin.testcases.case008.inheritance.SubStructure1;
import com.sap.tc.moin.testcases.case008.inheritance.SubStructure2;
import com.sap.tc.moin.testcases.case008.inheritance.SuperStructure1;
import com.sap.tc.moin.testcases.case019.B19;
import com.sap.tc.moin.testcasesfoundation.case003f.B3f;
import com.sap.tc.moin.testcasesfoundation.case003f.Case003fPackage;
import com.sap.tc.moin.testcasesfoundation.case004f.ButtonTextF;
import com.sap.tc.moin.testcasesfoundation.case004f.Case004fPackage;
import com.sap.tc.moin.testcasesfoundation.case004f.ShortTranslatableTextF;
import com.sap.tc.moin.testcasesfoundation.case004f.VeryShortTranslatableTextF;
import com.sap.tc.moin.textverticalization.TextverticalizationPackage;
import com.sap.tc.moin.textverticalization.TranslatableText;
import com.sap.tc.moin.textverticalization.TranslatableText.Descriptors;

@SuppressWarnings( "nls" )
public class TestStructureTypeInheritance extends CoreMoinTest {

    @Test
    public void testSaveAndLoad( ) throws Exception {

        Case008Package case008Package = getMOINConnection( ).getPackage( Case008Package.PACKAGE_DESCRIPTOR );
        Case004fPackage case004fPackage = getMOINConnection( ).getPackage( Case004fPackage.PACKAGE_DESCRIPTOR );
        InheritancePackage inheritancePackage = getMOINConnection( ).getPackage( InheritancePackage.PACKAGE_DESCRIPTOR );
        StructureFieldContainer<TranslatableText> contTranslatableText = new StructureFieldContainer<TranslatableText>( );

        StructureFieldContainer<SuperStructure1> contSuperStruct1 = new StructureFieldContainer<SuperStructure1>( );
        StructureFieldContainer<SubStructure1> contSubStruct1 = new StructureFieldContainer<SubStructure1>( );
        StructureFieldContainer<SubStructure2> contSubStruct2 = new StructureFieldContainer<SubStructure2>( );
        StructureFieldContainer<S8> contS8 = new StructureFieldContainer<S8>( );
        StructureFieldContainer<T8> contT8 = new StructureFieldContainer<T8>( );
        StructureFieldContainer<U8> contU8 = new StructureFieldContainer<U8>( );
        StructureFieldContainer<V8> contV8 = new StructureFieldContainer<V8>( );

        // B19
        Descriptors desc = TranslatableText.DESCRIPTORS;
        B19 b19 = getPartitionOne( ).createElement( B19.class );

        contTranslatableText.put( desc.MAX_WIDTH( ), 101 ).put( desc.ORIGINAL_TEXT( ), "originalText" ).put( desc.RES_TYPE( ), "button" ).put( desc.TRANS_UNIT_ID( ), "transUnitId" ).put( desc.RES_NAME( ), "resName" ).put( desc.TRANSLATE( ), true );
        ButtonTextF buttonTextF1 = case004fPackage.createButtonTextF( contTranslatableText );
        contTranslatableText.put( desc.MAX_WIDTH( ), 102 ).put( desc.ORIGINAL_TEXT( ), "originalText2" ).put( desc.RES_TYPE( ), "button" ).put( desc.TRANS_UNIT_ID( ), "transUnitId2" ).put( desc.RES_NAME( ), "resName2" ).put( desc.TRANSLATE( ), false );
        ButtonTextF buttonTextF2 = case004fPackage.createButtonTextF( contTranslatableText );
        b19.getTranslatableButtons( ).add( buttonTextF1 );
        b19.getTranslatableButtons( ).add( buttonTextF2 );

        contTranslatableText.put( desc.MAX_WIDTH( ), 103 ).put( desc.ORIGINAL_TEXT( ), "originalText3" ).put( desc.RES_TYPE( ), "button" ).put( desc.TRANS_UNIT_ID( ), "transUnitId3" ).put( desc.RES_NAME( ), "resName3" ).put( desc.TRANSLATE( ), true );
        ShortTranslatableTextF shortTranslatableTextF = case004fPackage.createShortTranslatableTextF( contTranslatableText );
        b19.setTranslatableTextShort1( shortTranslatableTextF );

        contTranslatableText.put( desc.MAX_WIDTH( ), 104 ).put( desc.ORIGINAL_TEXT( ), "originalText4" ).put( desc.RES_TYPE( ), "button" ).put( desc.TRANS_UNIT_ID( ), "transUnitId4" ).put( desc.RES_NAME( ), "resName4" ).put( desc.TRANSLATE( ), true );
        VeryShortTranslatableTextF veryShortTranslatableTextF = case004fPackage.createVeryShortTranslatableTextF( contTranslatableText );
        b19.setTranslatableTextVeryShort1( veryShortTranslatableTextF );

        // A8Inheritance
        A8Inheritance a8Inheritance = getPartitionOne( ).createElement( A8Inheritance.class );
        contSuperStruct1.put( SuperStructure1.DESCRIPTORS.SUPER_FIELD1_FROM1( ), 1 ).put( SuperStructure1.DESCRIPTORS.SUPER_FIELD2_FROM1( ), 2 );
        SuperStructure1 superStructure1 = inheritancePackage.createSuperStructure1( contSuperStruct1 );
        a8Inheritance.setOneSuperStructure1( superStructure1 );
        contSubStruct1.put( SubStructure1.DESCRIPTORS.SUPER_FIELD1_FROM1( ), 1 ).put( SubStructure1.DESCRIPTORS.SUPER_FIELD2_FROM1( ), 2 ).put( SubStructure1.DESCRIPTORS.SUB_FIELD1( ), 3.0f );
        SubStructure1 subStructure1 = inheritancePackage.createSubStructure1( contSubStruct1 );
        a8Inheritance.setOneSubStructure1( subStructure1 );
        contSubStruct2.put( SubStructure2.DESCRIPTORS.SUPER_FIELD1_FROM1( ), 1 ).put( SubStructure2.DESCRIPTORS.SUPER_FIELD2_FROM1( ), 2 ).put( SubStructure2.DESCRIPTORS.SUPER_FIELD1_FROM2( ), "3" );
        contSubStruct2.put( SubStructure2.DESCRIPTORS.SUB_FIELD1( ), 4.0d ).put( SubStructure2.DESCRIPTORS.SUB_FIELD2( ), "5" ).put( SubStructure2.DESCRIPTORS.SUB_FIELD3( ), "6" ).put( SubStructure2.DESCRIPTORS.SUB_FIELD4( ), "7" ).put( SubStructure2.DESCRIPTORS.SUB_FIELD5( ), "8" );
        SubStructure2 subStructure2 = inheritancePackage.createSubStructure2( contSubStruct2 );
        a8Inheritance.setOneSubStructure2( subStructure2 );
        Collection<SuperStructure1> manySuperStructure1 = a8Inheritance.getManySuperStructure1( );
        for ( int i = 0; i < 3; i++ ) {
            contSuperStruct1.put( SuperStructure1.DESCRIPTORS.SUPER_FIELD1_FROM1( ), i ).put( SuperStructure1.DESCRIPTORS.SUPER_FIELD2_FROM1( ), 3 * i + 1 );
            SuperStructure1 superStructure = inheritancePackage.createSuperStructure1( contSuperStruct1 );
            manySuperStructure1.add( superStructure );
        }
        // set a sub structure of SuperStructure2 to that field
        // TODO enable the following line when the model persistence is able to handle sub structure instances as attribute values
        // the type check in com.sap.tc.moin.repository.core.transactions.AbstractTransactionObject.checkTypeCompatibility() has also to be enabled
        // check see below
        // MM
//        a8Inheritance.setOneSuperStructure2( subStructure2 );

        // A8
        A8 a8 = getPartitionOne( ).createElement( A8.class );
        contU8.put( U8.DESCRIPTORS.SUB_FIELD1( ), true );
        U8 u8 = case008Package.createU8( contU8 );
        contS8.put( S8.DESCRIPTORS.STRUCTURE1( ), u8 ); // put a sub structure (U8) of T8 into that field instead of T8
        S8 s8 = case008Package.createS8( contS8 );
        a8.setOneStructureS( s8 );
        contV8.put( V8.DESCRIPTORS.STRUCTURE1( ), null ); // V8 contains only another V8 -> cool, isn't it?
        V8 v8 = case008Package.createV8( contV8 );
        // TODO enable the following line when the model persistence is able to handle empty structures
        // after this is done complete this test case, i.e. check the (empty) structure content below
        // check see below
        // MM
//        a8.setOneStructureV( v8 );

        // save the partition
        getMOINConnection( ).save( );
        // COW Check correctness of test
        getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ).getWorkspace( ).getPartitionManager( ).evictPartitionForced( getTestHelper( ).getCoreModelPartition( getPartitionOne( ) ) );

        // check the partition after load
        B19 b19_loaded = null;
        A8Inheritance a8Inheritance_loaded = null;
        A8 a8_loaded = null;
        for ( Partitionable element : getPartitionOne( ).getElements( ) ) {
            if ( element instanceof B19 ) {
                b19_loaded = (B19) element;
            }
            if ( element instanceof A8Inheritance ) {
                a8Inheritance_loaded = (A8Inheritance) element;
            }
            if ( element instanceof A8 ) {
                a8_loaded = (A8) element;
            }
        }

        // check B19
        Collection<ButtonTextF> translatableButtons_loaded = b19_loaded.getTranslatableButtons( );
        assertEquals( 2, translatableButtons_loaded.size( ) );
        assertTrue( translatableButtons_loaded.contains( buttonTextF1 ) );
        assertTrue( translatableButtons_loaded.contains( buttonTextF2 ) );

        assertEquals( shortTranslatableTextF, b19_loaded.getTranslatableTextShort1( ) );
        assertEquals( veryShortTranslatableTextF, b19_loaded.getTranslatableTextVeryShort1( ) );

        // A8Inheritance
        assertEquals( subStructure1, a8Inheritance_loaded.getOneSubStructure1( ) );
        assertEquals( subStructure2, a8Inheritance_loaded.getOneSubStructure2( ) );
        assertEquals( superStructure1, a8Inheritance_loaded.getOneSuperStructure1( ) );
        // TODO enable the following line when the model persistence is able to handle sub structure instances as attribute values
        // see above
        // MM
//        assertEquals( subStructure2, a8Inheritance_loaded.getOneSuperStructure2( ) );
        assertEquals( manySuperStructure1, a8Inheritance_loaded.getManySuperStructure1( ) );

        // A8
        // TODO enable the following line when the model persistence is able to handle empty structures
        // after this is done complete this test case, i.e. check the (empty) structure content below
        // see above
        // MM
//        assertEquals( s8, a8_loaded.getOneStructureS( ) );
    }

    @Test
    public void testStructureCloning( ) throws Exception {

        Descriptors desc = TranslatableText.DESCRIPTORS;
        TextverticalizationPackage textPackage = getMOINConnection( ).getPackage( TextverticalizationPackage.PACKAGE_DESCRIPTOR );

        StructureFieldContainer<TranslatableText> textContainer = new StructureFieldContainer<TranslatableText>( );
        textContainer.put( desc.MAX_WIDTH( ), 101 ).put( desc.ORIGINAL_TEXT( ), "originalText" ).put( desc.RES_TYPE( ), "button" ).put( desc.TRANS_UNIT_ID( ), "transUnitId" ).put( desc.RES_NAME( ), "resName" ).put( desc.TRANSLATE( ), true );
        TranslatableText text = textPackage.createTranslatableText( textContainer );

        TranslatableText textClone = getMOINConnection( ).getJmiHelper( ).cloneStruct( text, null );

        assertEquals( textClone, text );
        assertTrue( textClone.refIsInstanceOf( text.refMetaObjectMri( ), false ) );
        assertEquals( textClone.getMaxWidth( ), text.getMaxWidth( ) );
        assertEquals( textClone.getOriginalText( ), text.getOriginalText( ) );
        assertEquals( textClone.getResType( ), text.getResType( ) );
        assertEquals( textClone.getTransUnitId( ), text.getTransUnitId( ) );
        assertEquals( textClone.getResName( ), text.getResName( ) );
        assertEquals( textClone.isTranslate( ), text.isTranslate( ) );
    }

    @Test
    public void testStructureCloningWithFieldOverwriting( ) throws Exception {

        Descriptors desc = TranslatableText.DESCRIPTORS;
        TextverticalizationPackage textPackage = getMOINConnection( ).getPackage( TextverticalizationPackage.PACKAGE_DESCRIPTOR );

        StructureFieldContainer<TranslatableText> textContainer = new StructureFieldContainer<TranslatableText>( );
        textContainer.put( desc.MAX_WIDTH( ), 101 ).put( desc.ORIGINAL_TEXT( ), "originalText" ).put( desc.RES_TYPE( ), "button" ).put( desc.TRANS_UNIT_ID( ), "transUnitId" ).put( desc.RES_NAME( ), "resName" ).put( desc.TRANSLATE( ), true );
        TranslatableText text = textPackage.createTranslatableText( textContainer );

        StructureFieldContainer<TranslatableText> textContainerClone = new StructureFieldContainer<TranslatableText>( );
        textContainerClone.put( desc.ORIGINAL_TEXT( ), "originalTextCloned" );
        TranslatableText textClone = getMOINConnection( ).getJmiHelper( ).cloneStruct( text, textContainerClone );

        assertTrue( textClone.refIsInstanceOf( text.refMetaObjectMri( ), false ) );
        assertEquals( textClone.getMaxWidth( ), text.getMaxWidth( ) );
        assertEquals( textClone.getOriginalText( ), "originalTextCloned" );
        assertEquals( textClone.getResType( ), text.getResType( ) );
        assertEquals( textClone.getTransUnitId( ), text.getTransUnitId( ) );
        assertEquals( textClone.getResName( ), text.getResName( ) );
        assertEquals( textClone.isTranslate( ), text.isTranslate( ) );
    }

    @Test
    public void testFieldContainerCloning( ) throws Exception {

        Descriptors desc = TranslatableText.DESCRIPTORS;
        Case004fPackage case004fPackage = getMOINConnection( ).getPackage( Case004fPackage.PACKAGE_DESCRIPTOR );

        StructureFieldContainer<ButtonTextF> containerButtonTextF = new StructureFieldContainer<ButtonTextF>( );
        containerButtonTextF.put( desc.MAX_WIDTH( ), 101 ).put( desc.ORIGINAL_TEXT( ), "originalText" ).put( desc.RES_TYPE( ), "button" ).put( desc.TRANS_UNIT_ID( ), "transUnitId" ).put( desc.RES_NAME( ), "resName" ).put( desc.TRANSLATE( ), true );
        ButtonTextF buttonTextF1 = case004fPackage.createButtonTextF( containerButtonTextF );

        StructureFieldContainer<ButtonTextF> containerClone = new StructureFieldContainer<ButtonTextF>( );
        containerClone.put( buttonTextF1 );
        ButtonTextF buttonTextF1Clone = case004fPackage.createButtonTextF( containerClone );

        assertEquals( buttonTextF1Clone, buttonTextF1 );
        assertEquals( buttonTextF1Clone.getMaxWidth( ), buttonTextF1.getMaxWidth( ) );
        assertEquals( buttonTextF1Clone.getOriginalText( ), buttonTextF1.getOriginalText( ) );
        assertEquals( buttonTextF1Clone.getResType( ), buttonTextF1.getResType( ) );
        assertEquals( buttonTextF1Clone.getTransUnitId( ), buttonTextF1.getTransUnitId( ) );
        assertEquals( buttonTextF1Clone.getResName( ), buttonTextF1.getResName( ) );
        assertEquals( buttonTextF1Clone.isTranslate( ), buttonTextF1.isTranslate( ) );
    }

    @Test
    public void testFieldContainerCloningWithBaseContainer( ) throws Exception {

        Descriptors desc = TranslatableText.DESCRIPTORS;
        Case003fPackage case003fPackage = getMOINConnection( ).getPackage( Case003fPackage.PACKAGE_DESCRIPTOR );
        TextverticalizationPackage textPackage = getMOINConnection( ).getPackage( TextverticalizationPackage.PACKAGE_DESCRIPTOR );

        StructureFieldContainer<B3f> b3fContainer = new StructureFieldContainer<B3f>( );
        b3fContainer.put( desc.MAX_WIDTH( ), 101 ).put( desc.ORIGINAL_TEXT( ), "originalText" ).put( desc.RES_TYPE( ), "button" ).put( desc.TRANS_UNIT_ID( ), "transUnitId" ).put( desc.RES_NAME( ), "resName" ).put( desc.TRANSLATE( ), true );
        B3f b3f = case003fPackage.createB3f( b3fContainer );

        StructureFieldContainer<TranslatableText> containerClone = new StructureFieldContainer<TranslatableText>( );
        containerClone.put( b3f );
        TranslatableText text = textPackage.createTranslatableText( containerClone );

        assertEquals( text.getMaxWidth( ), b3f.getMaxWidth( ) );
        assertEquals( text.getOriginalText( ), b3f.getOriginalText( ) );
        assertEquals( text.getResType( ), b3f.getResType( ) );
        assertEquals( text.getTransUnitId( ), b3f.getTransUnitId( ) );
        assertEquals( text.getResName( ), b3f.getResName( ) );
        assertEquals( text.isTranslate( ), b3f.isTranslate( ) );
    }

    @Test
    public void testStructureRefIsInstanceOf( ) throws Exception {

        InheritancePackage inheritancePackage = getMOINConnection( ).getPackage( InheritancePackage.PACKAGE_DESCRIPTOR );
        StructureFieldContainer<SuperStructure1> contSuperStruct1 = new StructureFieldContainer<SuperStructure1>( );
        StructureFieldContainer<SubStructure1> contSubStruct1 = new StructureFieldContainer<SubStructure1>( );

        contSuperStruct1.put( SuperStructure1.DESCRIPTORS.SUPER_FIELD1_FROM1( ), 1 ).put( SuperStructure1.DESCRIPTORS.SUPER_FIELD2_FROM1( ), 2 );
        SuperStructure1 superStructure1 = inheritancePackage.createSuperStructure1( contSuperStruct1 );

        contSubStruct1.put( SubStructure1.DESCRIPTORS.SUPER_FIELD1_FROM1( ), 1 ).put( SubStructure1.DESCRIPTORS.SUPER_FIELD2_FROM1( ), 2 ).put( SubStructure1.DESCRIPTORS.SUB_FIELD1( ), 3.0f );
        SubStructure1 subStructure1 = inheritancePackage.createSubStructure1( contSubStruct1 );

        boolean isInstanceOf = false;
        isInstanceOf = superStructure1.refIsInstanceOf( superStructure1.refMetaObjectMri( ), true );
        assertTrue( "The structure \"" + superStructure1 + "\" should be an instance of \"SuperStructure1\", but it isn't.", isInstanceOf );
        isInstanceOf = subStructure1.refIsInstanceOf( superStructure1.refMetaObjectMri( ), true );
        assertTrue( "The structure \"" + subStructure1 + "\" should be an instance of \"SuperStructure1\", but it isn't.", isInstanceOf );
    }
}