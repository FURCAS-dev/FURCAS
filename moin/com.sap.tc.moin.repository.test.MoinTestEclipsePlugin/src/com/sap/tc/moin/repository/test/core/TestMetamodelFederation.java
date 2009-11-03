package com.sap.tc.moin.repository.test.core;

import org.junit.Test;

import com.sap.tc.moin.testcases.case018.A18;
import com.sap.tc.moin.testcases.case018.B18;
import com.sap.tc.moin.testcasesfoundation.TestcasesfoundationPackage;
import com.sap.tc.moin.testcasesfoundation.case001f.A1f;
import com.sap.tc.moin.testcasesfoundation.case003f.B3f;
import com.sap.tc.moin.textverticalization.TextverticalizationPackage;
import com.sap.tc.moin.textverticalization.TranslatableText;

public class TestMetamodelFederation extends CoreMoinTest {

    @Test
    public void testcasesUsesTestcasesFoundation( ) {

        A1f a1f = getMOINConnection( ).createElementInPartition( A1f.class, null );
        A18 a18 = getMOINConnection( ).createElementInPartition( A18.class, null );
        a18.setFoundationAttributeA1f( a1f );
        assertEquals( a1f, a18.getFoundationAttributeA1f( ) );
    }

    @Test
    public void testcasesFoundationUsesTextverticalization( ) {

        TextverticalizationPackage textverticalizationPackage = getMOINConnection( ).getPackage( TextverticalizationPackage.PACKAGE_DESCRIPTOR );
        TranslatableText translatableText = textverticalizationPackage.createTranslatableText( null );
        A1f a1f = getMOINConnection( ).createElementInPartition( A1f.class, null );
        a1f.setTranslatableText( translatableText );
        assertEquals( translatableText, a1f.getTranslatableText( ) );
    }

    @Test
    public void testcasesFoundationUsesTextverticalizationWithPersistence( ) throws Exception {

        TextverticalizationPackage textverticalizationPackage = getMOINConnection( ).getPackage( TextverticalizationPackage.PACKAGE_DESCRIPTOR );
        TranslatableText translatableText = textverticalizationPackage.createTranslatableText( null );
        A1f a1f = getMOINConnection( ).createElementInPartition( A1f.class, null );
        getPartitionOne( ).assignElement( a1f );
        a1f.setTranslatableText( translatableText );
        getMOINConnection( ).save( );
        getMOINConnection( ).getPartition( getPartitionOne( ).getPri( ) );
        assertEquals( translatableText, a1f.getTranslatableText( ) );

        // add cleanup action for partition one
        getPartitionOne( ).delete( );
        getMOINConnection( ).save( );
    }

    @Test
    public void testcasesInheritsFromTestcasesFoundation( ) {

        B18 b18 = getMOINConnection( ).createElementInPartition( B18.class, null );

    }

    @Test
    public void testcasesFoundationInheritsFromTextverticalization( ) {

        B3f a3f = getMOINConnection( ).getPackage( TestcasesfoundationPackage.PACKAGE_DESCRIPTOR ).getCase003f( ).createB3f( null );
    }
}
