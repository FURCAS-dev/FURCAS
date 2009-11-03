package com.sap.tc.moin.repository.core.jmi.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.shared.util.Utilities;

/**
 * Reads and writes a MetaModelExtensionRecord. There are two indexes, the names
 * and the full index. The names index contains only names and mofids of
 * meta-model's model elements. The full index contains all the information
 * required, to deploy the meta-model in the MOIN runtime host.
 * 
 * @author D046220
 */
public class MetaModelExtensionRecordReaderWriter {

    // Java spec requires for UTF-8 to be available on all supported platforms
    private static final String STRING_ENCODING = "UTF-8"; //$NON-NLS-1$

    public static final int INDEX_VERSION = 3;

    public static final int EHP1_LEGACY_VERSION = 2;

    public static final String EXTENSION_INDEX_NAME = "extension.idxb"; //$NON-NLS-1$

    public static final String EXTENSION_INDEX_LOG_NAME = "extension.idxh"; //$NON-NLS-1$

    public static final String NAMES_INDEX_NAME = "names.idxb"; //$NON-NLS-1$

    /**
     * Writes an extension record to the given output stream.
     * 
     * <pre>
     * File format:
     *  1) Header (starts at offset 0)
     *      - dump algorithm version 4bytes (ver)
     *      - number of mofid -> classname mappings 4 bytes (nmn)
     *      - number of name -> classname mappings 4 bytes (nnc)
     *      - number of known class names 4 bytes (acn)
     *      - number of mofid -> qname mappings 4 bytes (mqn)
     *      - number of type to super type mappings 4 bytes (tst)
     *  2) String pool (starts at offset 24)
     *      - see string pool format at writeStringPool(..)
     *  3) mofid -> classname mapping 2 * 4 bytes * nmn 
     *  4) name -> classname mapping 2 * 4bytes * nnc
     *  5) known class names -> 4bytes * acn
     *  6) mofid -> qname mappings mqn * ( 4bytes source idx + 4bytes <number of list elements> + nle * 4bytes)
     *  7) mofid to immediate composite mappings -> mic * 2 * 4 bytes
     *  8) type mofid to supertype mofids -> tst*2*4bytes
     * </pre>
     */
    public static void writeExtensionRecord( OutputStream os, MetaModelExtensionRecord rec ) throws IOException {

        int nmn = rec.getMofIdClassNameMap( ).size( );
        int nnc = rec.getNameClassNameMap( ).size( );
        int acn = rec.getJmiClasses( ).size( );
        int mqn = rec.getMofIdToQualifiedNameMapping( ).size( );
        int tst = rec.getTypeMofIdToSuperTypesMapping( ).size( );

        // prealloced byte array
        byte[] b = new byte[4];

        // header
        os.write( toByteArray( b, INDEX_VERSION ) );
        os.write( toByteArray( b, nmn ) );
        os.write( toByteArray( b, nnc ) );
        os.write( toByteArray( b, acn ) );
        os.write( toByteArray( b, mqn ) );
        os.write( toByteArray( b, tst ) );

        List<String> strings = mergeStrings( rec );

        Map<String, Integer> stringPool = writeStringPool( os, strings );

        // 1. mofid -> class name mappings

        for ( Entry<String, String> entry : rec.getMofIdClassNameMap( ).entrySet( ) ) {
            os.write( toByteArray( b, stringPool.get( entry.getKey( ) ) ) );
            os.write( toByteArray( b, stringPool.get( entry.getValue( ) ) ) );
        }

        // 2. name -> class name mappings
        for ( Entry<String, String> entry : rec.getNameClassNameMap( ).entrySet( ) ) {
            os.write( toByteArray( b, stringPool.get( entry.getKey( ) ) ) );
            os.write( toByteArray( b, stringPool.get( entry.getValue( ) ) ) );
        }

        // 3. all known class names
        for ( String str : rec.getJmiClasses( ) ) {
            os.write( toByteArray( b, stringPool.get( str ) ) );
        }

        // 4. mofid -> qname mappings
        for ( Entry<String, List<String>> entry : rec.getMofIdToQualifiedNameMapping( ).entrySet( ) ) {
            os.write( toByteArray( b, stringPool.get( entry.getKey( ) ) ) );

            os.write( toByteArray( b, entry.getValue( ).size( ) ) );

            for ( String str : entry.getValue( ) ) {
                os.write( toByteArray( b, stringPool.get( str ) ) );
            }
        }

        // 5. type -> supertype mappings
        for ( Entry<String, Set<String>> entry : rec.getTypeMofIdToSuperTypesMapping( ).entrySet( ) ) {
            os.write( toByteArray( b, stringPool.get( entry.getKey( ) ) ) );

            os.write( toByteArray( b, entry.getValue( ).size( ) ) );

            for ( String str : entry.getValue( ) ) {
                os.write( toByteArray( b, stringPool.get( str ) ) );
            }
        }

    }

    private static List<String> mergeStrings( MetaModelExtensionRecord rec ) {

        List<String> ret = new ArrayList<String>( );

        // iterate over the record's maps and generate the stringpool

        // 1. mofid -> class name
        for ( Entry<String, String> entry : rec.getMofIdClassNameMap( ).entrySet( ) ) {
            ret.add( entry.getKey( ) );
            ret.add( entry.getValue( ) );
        }

        // 2. name -> class name
        for ( Entry<String, String> entry : rec.getNameClassNameMap( ).entrySet( ) ) {
            ret.add( entry.getKey( ) );
            ret.add( entry.getValue( ) );
        }

        // 3. all known class names
        for ( String str : rec.getJmiClasses( ) ) {
            ret.add( str );
        }

        // 4. mofid -> qname mappings
        for ( Entry<String, List<String>> entry : rec.getMofIdToQualifiedNameMapping( ).entrySet( ) ) {
            ret.add( entry.getKey( ) );

            for ( String str : entry.getValue( ) ) {
                ret.add( str );
            }
        }

        // 5.type->super type mappings
        for ( Entry<String, Set<String>> entry : rec.getTypeMofIdToSuperTypesMapping( ).entrySet( ) ) {
            ret.add( entry.getKey( ) );

            for ( String value : entry.getValue( ) ) {
                ret.add( value );
            }
        }

        return ret;
    }

    @SuppressWarnings( "nls" )
    public static void writeHumanReadableRecordLog( OutputStream os, MetaModelExtensionRecord rec ) {

        PrintStream ps = new PrintStream( os );

        // 1. mofid -> class name
        ps.println( "mofid -> class name mapping" );

        for ( Entry<String, String> entry : rec.getMofIdClassNameMap( ).entrySet( ) ) {
            ps.println( entry.getKey( ) + " -> " + entry.getValue( ) );
        }

        // 2. name -> class name
        ps.println( "MOF name -> class name mapping" );

        for ( Entry<String, String> entry : rec.getNameClassNameMap( ).entrySet( ) ) {
            ps.println( entry.getKey( ) + " -> " + entry.getValue( ) );
        }

        // 3. all known class names
        ps.println( "All contained JMI class names" );

        for ( String name : rec.getJmiClasses( ) ) {
            ps.println( name );
        }

        // 4. mofid -> qname mappings
        ps.println( "mofid -> qname mapping" );

        for ( Entry<String, List<String>> entry : rec.getMofIdToQualifiedNameMapping( ).entrySet( ) ) {
            ps.print( entry.getKey( ) + " -> [" );

            for ( Iterator<String> i = entry.getValue( ).iterator( ); i.hasNext( ); ) {
                ps.print( i.next( ) + ( i.hasNext( ) ? "," : "" ) ); //$NON-NLS-1$
            }

            ps.println( "]" ); //$NON-NLS-1$
        }

        // 5. type mofid -> super type mofids
        ps.println( "type mofid -> super type mofids mapping" );

        for ( Entry<String, Set<String>> entry : rec.getTypeMofIdToSuperTypesMapping( ).entrySet( ) ) {
            ps.print( entry.getKey( ) + " -> [" );

            for ( Iterator<String> i = entry.getValue( ).iterator( ); i.hasNext( ); ) {
                ps.print( i.next( ) + ( i.hasNext( ) ? "," : "" ) ); //$NON-NLS-1$
            }

            ps.println( "]" ); //$NON-NLS-1$
        }

        ps.flush( );
    }

    public static MetaModelExtensionRecord readMetaModelExtensionRecord( InputStream is ) throws IOException {

        byte[] fba = new byte[4];

        // read header
        Integer ver = fromByteArray( readBytes( is, fba, 4 ) );

        if ( EHP1_LEGACY_VERSION != ver && INDEX_VERSION != ver ) {
            throw new MoinLocalizedBaseRuntimeException( JmiUtilMessages.WRONGINDEXVERSION, INDEX_VERSION, ver );
        }

        Integer nmn = fromByteArray( readBytes( is, fba, 4 ) );
        Integer nnc = fromByteArray( readBytes( is, fba, 4 ) );
        Integer acn = fromByteArray( readBytes( is, fba, 4 ) );
        Integer mqn = fromByteArray( readBytes( is, fba, 4 ) );

        Integer tst = 0;

        if ( INDEX_VERSION == ver ) {
            tst = fromByteArray( readBytes( is, fba, 4 ) );
        }

        Integer mic = null;

        // read string pool
        String[] strings = readStringPool( is );

        // decode maps
        MetaModelExtensionRecord ret = new MetaModelExtensionRecord( nmn, nnc, acn, mqn, tst );

        // 1. mofid -> class name
        byte[] nmnBytes = new byte[nmn * 8];

        readBytes( is, nmnBytes, nmnBytes.length );

        Map<String, String> mofIdClassNameMap = ret.getMofIdClassNameMap( );

        for ( int i = 0; i < nmn; i++ ) {
            int off = i * 8;

            mofIdClassNameMap.put( strings[fromByteArray( nmnBytes, off )], strings[fromByteArray( nmnBytes, off + 4 )] );
        }

        nmnBytes = null;

        // 2. name -> class name
        byte[] nncBytes = new byte[nnc * 8];
        readBytes( is, nncBytes, nncBytes.length );

        Map<String, String> nameClassNameMap = ret.getNameClassNameMap( );

        for ( int i = 0; i < nnc; i++ ) {
            int off = i * 8;

            nameClassNameMap.put( strings[fromByteArray( nncBytes, off )], strings[fromByteArray( nncBytes, off + 4 )] );
        }

        nncBytes = null;

        // 3. all known class names
        byte[] acnBytes = new byte[acn * 4];
        readBytes( is, acnBytes, acnBytes.length );

        List<String> jmiClasses = ret.getJmiClasses( );
        for ( int i = 0; i < acn; i++ ) {
            int off = i * 4;

            jmiClasses.add( strings[fromByteArray( acnBytes, off )] );
        }

        acnBytes = null;

        // 4. mofid -> qname mappings
        Map<String, List<String>> qNamesMap = ret.getMofIdToQualifiedNameMapping( );
        for ( int i = 0; i < mqn; i++ ) {
            int key = fromByteArray( readBytes( is, fba, 4 ) );
            int nf = fromByteArray( readBytes( is, fba, 4 ) );

            List<String> qName = new ArrayList<String>( nf );

            for ( int j = 0; j < nf; j++ ) {
                qName.add( strings[fromByteArray( readBytes( is, fba, 4 ) )] );
            }

            qNamesMap.put( strings[key], Collections.unmodifiableList( qName ) );
        }

        // 5. type -> super type
        Map<String, Set<String>> superTypeMap = ret.getTypeMofIdToSuperTypesMapping( );

        for ( int i = 0; i < tst; i++ ) {
            int key = fromByteArray( readBytes( is, fba, 4 ) );
            int nf = fromByteArray( readBytes( is, fba, 4 ) );

            Set<String> superTypesSet = new HashSet<String>( Utilities.calcInitialCapacity( nf ) );

            for ( int j = 0; j < nf; j++ ) {
                superTypesSet.add( strings[fromByteArray( readBytes( is, fba, 4 ) )] );
            }

            superTypeMap.put( strings[key], superTypesSet );
        }

        return ret;
    }

    public static List<String> readElementNames( InputStream is ) throws IOException {

        // read header
        int ver = fromByteArray( readBytes( is, new byte[4], 4 ) );

        assertIndexVersion( ver );

        return Arrays.asList( readStringPool( is ) );
    }

    private static void assertIndexVersion( int ver ) {

        if ( ver != EHP1_LEGACY_VERSION && ver != INDEX_VERSION ) {
            throw new MoinLocalizedBaseRuntimeException( JmiUtilMessages.WRONGINDEXVERSION, INDEX_VERSION, ver );
        }
    }

    /**
     * Writes the names index to the given output stream. Assumptions is, that
     * qualified names are highly correlated on their prefix
     * 
     * <pre>
     * File format:
     *  * header:
     *      - version : 4 bytes
     *  * string pool (see format at writeStringPool(...))
     *    
     * </pre>
     */
    public static void writeElementNames( OutputStream os, List<String> in ) throws IOException {

        // avoid input of duplicate strings and non O(1) access lists
        // this function runs at build time of meta-models, so the performance is less critical, than 
        // at load time
        os.write( toByteArray( new byte[4], INDEX_VERSION ) );

        writeStringPool( os, in );
    }

    private static String[] readStringPool( InputStream is ) throws IOException {

        byte[] fba = new byte[4];

        int nos = fromByteArray( readBytes( is, fba, 4 ) );
        int len = fromByteArray( readBytes( is, fba, 4 ) );

        byte[] offsetAndResetBytes = new byte[nos * 8];

        int[] offsetAndReset = new int[nos * 2];

        readBytes( is, offsetAndResetBytes, offsetAndResetBytes.length );

        for ( int i = 0; i < nos; i++ ) {
            offsetAndReset[2 * i] = fromByteArray( offsetAndResetBytes, i * 8 );
            offsetAndReset[2 * i + 1] = fromByteArray( offsetAndResetBytes, i * 8 + 4 );
        }

        byte[] stringBuffer = new byte[len];

        String[] ret = new String[nos];

        for ( int i = 0; i < nos; i++ ) {
            int reset = offsetAndReset[i * 2 + 1];
            int offset = offsetAndReset[i * 2];

            readBytes( is, stringBuffer, reset, offset );

            ret[i] = new String( stringBuffer, 0, reset + offset, STRING_ENCODING );
        }

        return ret;
    }

    /**
     * writes string pool. string order will not be maintained. For ordering
     * information refer to the return value.
     * 
     * <pre>
     * This format is optimized for fast reading, because the writing happens at the build time.
     * 
     * Example:
     *  strings "a" and "ab" will be written as ab with index, carrying the information 
     *  about buffer reset. Thus, the index will contain the following information:
     *  - string0 starts at 0, has length 1 and reset index 0
     *  - string1 starts at 1, has length 1 and reset index 1
     *  
     *  The reading will happen according to the following algorithm:
     *  - fill buffer at offset 0 with 1 byte from stream. create string: offset 0, length 1 (a)
     *  - fill buffer at offset 1 with 1 byte from stream. create string: offset 0, length 2 (buffer reset +stream length) (ab)
     * </pre>
     * 
     * <pre>
     * Format:
     *      Header
     *          - number of strings (nos): 4 bytes
     *          - longest string (len) : 4 bytes 
     *          - string length 4bytes + bytebuffer reset index
     *      String pool format is as follows: 
     *          buf =   { bytes from last read, length bytes at offset} the border for last read
     *          is the reset index.
     *          String s = String.getBytes( buf, "UTF-8" );
     *          This construct helps to reduce read time 
     * </pre>
     * 
     * @return Map of strings with their index in the pool as value
     */
    private static Map<String, Integer> writeStringPool( OutputStream os, Collection<String> in ) throws IOException {

        List<String> l = new ArrayList<String>( new HashSet<String>( in ) );

        byte[] buf = new byte[4];

        os.write( toByteArray( buf, l.size( ) ) );

        // sort the collection in ascending order
        Collections.sort( l );

        Map<String, Integer> ret = new HashMap<String, Integer>( l.size( ) );

        int[] offsetAndReset = new int[l.size( ) * 2];

        // compute offset and reset index
        String prevString = ""; //$NON-NLS-1$
        int longestString = 0;
        for ( int i = 0; i < l.size( ); i++ ) {
            String s = l.get( i );

            ret.put( s, i );

            // don't need overflow checks, the strings are unique
            int resetIndexChars = commonPrefixAt( prevString, s );

            int resetIndexBytes = s.substring( 0, resetIndexChars ).getBytes( STRING_ENCODING ).length;

            // for now, the offset is just the number of chars after reset. the byte offsets are computed later
            offsetAndReset[i * 2 + 1] = resetIndexBytes;
            offsetAndReset[i * 2] = s.getBytes( STRING_ENCODING ).length - resetIndexBytes;

            longestString = Math.max( offsetAndReset[i * 2 + 1] + offsetAndReset[i * 2], longestString );

            prevString = s;
        }

        os.write( toByteArray( buf, longestString ) );

        for ( int i = 0; i < offsetAndReset.length; i++ ) {
            os.write( toByteArray( buf, offsetAndReset[i] ) );
        }

        // write strings
        for ( int i = 0; i < l.size( ); i++ ) {
            String s = l.get( i );
            String tail = s.substring( offsetAndReset[i * 2 + 1], s.length( ) );

            os.write( tail.getBytes( STRING_ENCODING ) );
        }

        return ret;
    }

    private static int commonPrefixAt( String s1, String s2 ) {

        int l1 = s1.length( );
        int l2 = s2.length( );

        int i = 0;
        for ( i = 0; i < l1 && i < l2; i++ ) {
            if ( s1.charAt( i ) != s2.charAt( i ) ) {
                break;
            }
        }

        return i;
    }

    private static final byte[] readBytes( InputStream s, byte[] b, int length ) throws IOException {

        return readBytes( s, b, 0, length );
    }

    private static final byte[] readBytes( InputStream s, byte[] b, int offset, int length ) throws IOException {

        int alreadyRead = 0;

        for ( ; alreadyRead != length; ) {
            int readBytes = s.read( b, offset + alreadyRead, length - alreadyRead );

            if ( readBytes == -1 ) {
                throw new MoinIllegalStateException( JmiUtilMessages.COULDNOTREADBYTES );
            }

            alreadyRead += readBytes;
        }

        return b;
    }

    public static final int fromByteArray( byte[] b ) {

        return b[0] << 24 | ( b[1] & 0xff ) << 16 | ( b[2] & 0xff ) << 8 | ( b[3] & 0xff );
    }

    public static final int fromByteArray( byte[] b, int offset ) {

        return b[0 + offset] << 24 | ( b[1 + offset] & 0xff ) << 16 | ( b[2 + offset] & 0xff ) << 8 | ( b[3 + offset] & 0xff );
    }

    public static final byte[] toByteArray( byte[] b, int i ) {

        b[0] = (byte) ( i >> 24 );
        b[1] = (byte) ( i >> 16 );
        b[2] = (byte) ( i >> 8 );
        b[3] = (byte) i;

        return b;
    }
}
