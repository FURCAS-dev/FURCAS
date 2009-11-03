package com.sap.tc.moin.repository.test.core;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

import com.sap.tc.moin.repository.core.jmi.util.MetaModelExtensionRecord;
import com.sap.tc.moin.repository.core.jmi.util.MetaModelExtensionRecordReaderWriter;
import com.sap.tc.moin.test.testcase.MoinTestCase;

/**
 * Tests for the extension generator.
 * 
 * @author D046220
 */
public class TestMetaModelExtensionGenerator extends MoinTestCase {

    @Test
    public void testExtensionGenerator( ) throws IOException {

        MetaModelExtensionRecord rec = new MetaModelExtensionRecord( 5, 7, 2, 3, 2 );

        rec.getMofIdClassNameMap( ).put( "a", "b" );
        rec.getMofIdClassNameMap( ).put( "cc", "dd" );
        rec.getMofIdClassNameMap( ).put( "eee", "fff" );

        rec.getNameClassNameMap( ).put( "yyy", "xxx" );
        rec.getNameClassNameMap( ).put( "zz", "uu" );
        rec.getNameClassNameMap( ).put( "v", "k" );

        rec.getJmiClasses( ).add( "test" );
        rec.getJmiClasses( ).add( "test.myclass" );

        rec.getMofIdToQualifiedNameMapping( ).put( "eee", Arrays.asList( new String[] { "test", "classes" } ) );
        rec.getMofIdToQualifiedNameMapping( ).put( "fff", Arrays.asList( new String[] { "test" } ) );
        rec.getMofIdToQualifiedNameMapping( ).put( "v", Arrays.asList( new String[] { "test", "other" } ) );

        rec.getTypeMofIdToSuperTypesMapping( ).put( "xx", new HashSet<String>( Arrays.asList( new String[] { "a", "bb" } ) ) );
        rec.getTypeMofIdToSuperTypesMapping( ).put( "yy", new HashSet<String>( Arrays.asList( new String[] { "cc", "d", "eee" } ) ) );

        File file = File.createTempFile( "testfile", null );

        FileOutputStream os = new FileOutputStream( file );
        MetaModelExtensionRecordReaderWriter.writeExtensionRecord( os, rec );
        os.flush( );
        os.close( );

        FileInputStream stream = null;
        try {
            stream = new FileInputStream( file );
            MetaModelExtensionRecord rec2 = MetaModelExtensionRecordReaderWriter.readMetaModelExtensionRecord( stream );
            stream.close( );

            assertTrue( rec.getMofIdClassNameMap( ).equals( rec2.getMofIdClassNameMap( ) ) );
            assertTrue( rec.getNameClassNameMap( ).equals( rec2.getNameClassNameMap( ) ) );
            assertTrue( rec.getJmiClasses( ).equals( rec2.getJmiClasses( ) ) );
            assertTrue( rec.getMofIdToQualifiedNameMapping( ).equals( rec2.getMofIdToQualifiedNameMapping( ) ) );
            assertTrue( rec.getTypeMofIdToSuperTypesMapping( ).equals( rec2.getTypeMofIdToSuperTypesMapping( ) ) );
        } finally {
            if ( stream != null ) {
                stream.close( );
            }
        }
    }

    @Test
    public void testIndexVersionForMetaModelExtensionIndex( ) throws IOException {

        FileOutputStream os = null;
        InputStream is = null;

        try {
            File file = File.createTempFile( "testfile" + System.currentTimeMillis( ), null );
            os = new FileOutputStream( file );

            byte[] b = new byte[4];

            MetaModelExtensionRecordReaderWriter.toByteArray( b, MetaModelExtensionRecordReaderWriter.INDEX_VERSION + 1 );

            os.write( b );
            os.flush( );
            os.close( );

            is = new FileInputStream( file );

            // should fail reading, regardless of what comes next.
            try {
                MetaModelExtensionRecordReaderWriter.readMetaModelExtensionRecord( is );

                fail( "Wrong index version not detected." );
            } catch ( RuntimeException e ) {
                // expected behaviour
                assertTrue( true );
            }

        } finally {
            if ( os != null ) {
                os.close( );
            }

            if ( is != null ) {
                is.close( );
            }
        }
    }

    @Test
    public void testModelElementNamesIndex( ) throws Exception {

        List<String> strings1 = Arrays.asList( new String[] { "a", "longstr", "a.b", "a.c", "1231", "d", "longstr2" } );

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream( );

        MetaModelExtensionRecordReaderWriter.writeElementNames( byteArrayOutputStream, strings1 );

        List<String> readElementNames = MetaModelExtensionRecordReaderWriter.readElementNames( new ByteArrayInputStream( byteArrayOutputStream.toByteArray( ) ) );


        assertEquals( new HashSet<String>( strings1 ), new HashSet<String>( readElementNames ) );
    }
}
