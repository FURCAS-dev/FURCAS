package com.sap.tc.moin.repository.shared.util;

import static com.sap.tc.moin.repository.shared.util.SunSystemPropertyKeys.LINE_SEPARATOR;
import static com.sap.tc.moin.repository.shared.util.SunSystemPropertyKeys.PATH_SEPARATOR;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Set;

import com.sap.guid.GUIDGeneratorFactory;
import com.sap.guid.IGUID;
import com.sap.guid.IGUIDGenerator;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;

/**
 * This class provides convenient methods for various purposes like converting
 * types etc.
 */
public class Utilities {

    /** System line separator */
    public final static String SystemLineSeparator = System.getProperty( LINE_SEPARATOR );

    /** System path separator */
    public final static String SystemPathSeparator = System.getProperty( PATH_SEPARATOR );

    /** 32 */
    public static final int GUID_LENGTH = 32;

    /** 40 */
    public static final int MOFID_LENGTH = 40;

    public static final int SEGMENTED_PREFIX_BYTE_ARRAY_LENGTH = ( MOFID_LENGTH - GUID_LENGTH ) >> 1;

    /** 24 */
    public static final int BINARY_ID_LENGTH = 24;

    /** 20 */
    public static final int DIGEST_HASH_LENGTH = 20;

    private static final float INVERSE_HASHMAP_LOAD_FACTOR = 4f / 3f;

    private static Utilities utilities;

    private static IdLocalizer idLocalizer = new IdLocalizer( );

    private IGUIDGenerator guidGenerator;

    private MessageDigest md;

    /** com.sap.tc.moin */
    public static final String MOIN_PACKAGE = "com.sap.tc.moin"; //$NON-NLS-1$

    /** package */
    public static final String PACKAGE_PREFIX_METAMODELID = "package"; //$NON-NLS-1$

    /** . */
    public static final char JAVA_PACKAGE_DELIMITER = '.';


    /**
     * Enum that helps to differentiate between callers of the
     * mof-id-calculation. MOIN_INTERNAL MofIds start with 00, MTI Mofids start
     * with 01, others start with 3F
     */
    public static enum CalculatedMofIdAppl {
        /** internal */
        MOIN_INTERNAL( 0x00 ),
        /** MTI */
        MTI( 0x01 ),
        /** External */
        EXTERNAL( 0x3F ),
        /** Segmented */
        SEGMENTED( 0xE0 ),

        /** reserved */
        NO_NOT_USE( 0xFF );

        private byte id;

        private String idString;

        CalculatedMofIdAppl( int id ) {

            this.id = (byte) id;
            byte low = (byte) ( id & 0x0F );
            byte high = (byte) ( ( id & 0xF0 ) >> 4 );
            this.idString = new String( new char[] { Utilities.convertByteToHex( high ), Utilities.convertByteToHex( low ) } );
        }

        /**
         * @return the id
         */
        public byte getId( ) {

            return this.id;
        }

        /**
         * @return the id as String
         */
        public String getIdString( ) {

            return this.idString;
        }
    }

    /**
     * Checks if the given String has the {@link CalculatedMofIdAppl#EXTERNAL
     * "external"} prefix. It does NOT check if the String is a valid MOF id.
     * 
     * @param mofId the MOF id to check.
     * @return <code>true</code> if the given String has the
     * {@link CalculatedMofIdAppl#EXTERNAL "external"} prefix,
     * <code>false</code> otherwise.
     */
    public static boolean isExternallyCalculatedMofId( String mofId ) {

        if ( mofId.startsWith( CalculatedMofIdAppl.EXTERNAL.getIdString( ) ) ) {
            return true;
        }

        return false;
    }

    /**
     * Helper class that is used to add the localization prefix to the plain
     * guid. The class is optimized for minimal object creation.
     */
    static private final class IdLocalizer {

        private char[] charArray = new char[8];

        private StringBuilder strBuilder = new StringBuilder( Utilities.MOFID_LENGTH );

        IdLocalizer( ) {

            // nothing
        }

        /**
         * Fill this.charArray with the prefix data based on the current time.
         */
        private void setCharArrayFromCurrentTime( ) {

            long currentTimeSeconds = System.currentTimeMillis( ) / 1000;
            long auxVal = currentTimeSeconds;
            for ( int i = 0; i < 4; i++ ) {
                byte currentByte = (byte) auxVal;
                auxVal = auxVal >> 8;
                byte low = (byte) ( currentByte & 0x0F );
                byte high = (byte) ( ( currentByte & 0xF0 ) >> 4 );
                this.charArray[7 - 2 * i] = Utilities.convertByteToHex( low );
                this.charArray[6 - 2 * i] = Utilities.convertByteToHex( high );
            }
        }

        /**
         * Fill this.charArray[0-7] with the prefix data. this.charArray[0-1] is
         * filled based on the given appl id. this.charArray[2-7] is filled
         * based on the given prefix. The method splits the input String
         * (logically) into three parts, adds the chars of each part, and uses
         * the hex representation of the sum.
         */
        private void setCharArrayFromPrefix( byte appl, String actPrefix ) {

            // split the appl in low and high
            String prefix = actPrefix;
            byte low = (byte) ( appl & 0x0F );
            byte high = (byte) ( ( appl & 0xF0 ) >> 4 );
            this.charArray[0] = Utilities.convertByteToHex( high );
            this.charArray[1] = Utilities.convertByteToHex( low );

            if ( prefix.length( ) < 3 ) {
                // "alu" has no meaning, just for padding
                prefix = prefix.concat( "alu".substring( prefix.length( ) ) ); //$NON-NLS-1$
            }
            int split = prefix.length( ) / 3;

            byte sum;
            for ( int i = 0; i < 3; i++ ) {
                sum = 0;
                // sum chars of each portion
                for ( int j = 0; j < split; j++ ) {
                    int idx = i * split + j;
                    sum += prefix.charAt( idx );
                }
                if ( i == 2 ) {
                    for ( int idx = 3 * split; idx < prefix.length( ); idx++ ) {
                        sum += prefix.charAt( idx );
                    }
                }

                // split the sum in low and high
                low = (byte) ( sum & 0x0F );
                high = (byte) ( ( sum & 0xF0 ) >> 4 );
                this.charArray[2 * i + 2] = Utilities.convertByteToHex( high );
                this.charArray[2 * i + 3] = Utilities.convertByteToHex( low );
            }
        }

        /**
         * The method must be synchronized because it uses the members charArray
         * and strBuilder in a non-thread-safe way.
         * 
         * @param input
         * @return the information
         */
        synchronized String addTimeLocalizedInformation( String input ) {

            this.setCharArrayFromCurrentTime( );
            this.strBuilder.delete( 0, this.strBuilder.length( ) );
            this.strBuilder.append( this.charArray );
            this.strBuilder.append( input );
            return this.strBuilder.toString( );
        }

        String removeTimeLocalizedInformation( String input ) {

            this.strBuilder.delete( 0, this.strBuilder.length( ) );
            this.strBuilder.append( input.substring( this.charArray.length ) );
            return this.strBuilder.toString( );
        }

        synchronized String addPrefixLocalizedInformation( String input, byte appl, String prefix ) {

            this.setCharArrayFromPrefix( appl, prefix );
            this.strBuilder.delete( 0, this.strBuilder.length( ) );
            this.strBuilder.append( this.charArray );
            this.strBuilder.append( input );
            return this.strBuilder.toString( );
        }
    }

    /**
     * Get the Utilities instance
     * 
     * @return the Utilities
     */
    public static Utilities getUtilities( ) {

        if ( utilities == null ) {
            utilities = new Utilities( );
        }
        return utilities;
    }

    private Utilities( ) {

        synchronized ( Utilities.class ) {
            if ( this.guidGenerator == null ) {
                this.guidGenerator = GUIDGeneratorFactory.getInstance( ).createGUIDGenerator( );
            }
            if ( this.md == null ) {
                try {
                    this.md = MessageDigest.getInstance( "SHA1" ); //$NON-NLS-1$
                } catch ( NoSuchAlgorithmException e ) {
                    throw new RuntimeException( e );
                }
            }
        }
    }

    /**
     * Returns a valid globally unique MOF ID
     * 
     * @return The globally unique MOF ID
     */
    public String createMofId( ) {

        String mofId = this.createMofIdImpl( );
        if ( mofId.length( ) != MOFID_LENGTH ) {
            throw new MoinLocalizedBaseRuntimeException( UtilitiesMessages.UNEXPECTEDMOFIDLENGTH, mofId );
        }
        return mofId;
    }

    public String createSegmentedMofId( byte[] prefix ) {

        if ( prefix.length != SEGMENTED_PREFIX_BYTE_ARRAY_LENGTH ) {
            throw new MoinLocalizedBaseRuntimeException( UtilitiesMessages.UNEXPECTEDPREFIXLENGTH, prefix.length );
        }

        // generate mof id
        String guidPart = this.guidGenerator.createGUID( ).toHexString( ).toUpperCase( Locale.ENGLISH );

        // append mof id to prefix 
        String mofId = this.concatByteArrayAndString( prefix, guidPart );

        if ( mofId.length( ) != MOFID_LENGTH ) {
            throw new MoinLocalizedBaseRuntimeException( UtilitiesMessages.UNEXPECTEDMOFIDLENGTH, mofId );
        }
        return mofId;
    }

    public byte[] calculatePrefixForSegmentedMofId( String... prefix ) {

//        byte[] prefixBytes = this.guidGenerator.createGUID( StringUtils.combine( prefix ) ).toBytes( );
        byte[] prefixBytes = this.calculateSHA1HashUtf8( StringUtils.combine( prefix ) );

        int partsToFold = prefixBytes.length / 4;

        // fold hash into 4 bytes
        byte[] prefixBytesCompacted = new byte[4];
        for ( int i = 0; i < prefixBytesCompacted.length; i++ ) {
            for ( int j = 0; j < partsToFold; j++ ) {
                prefixBytesCompacted[i] ^= (byte) ( prefixBytes[i + ( j * 4 )] );
            }
        }

        // fold to append MofId category identifier
        for ( int i = 0; i < 3; i++ ) {
            prefixBytesCompacted[i + 1] ^= prefixBytesCompacted[0];
        }
        prefixBytesCompacted[0] = CalculatedMofIdAppl.SEGMENTED.getId( );
        return prefixBytesCompacted;
    }

    public static final String extractGuidFromMofId( String mofId ) {

        return ( mofId.length( ) == GUID_LENGTH ) ? mofId : idLocalizer.removeTimeLocalizedInformation( mofId );
    }

    /**
     * Returns a valid MOF ID which is calculated from the given input
     * parameters.
     * <p>
     * Repeated calls with the same input value return the same output value.
     * The CalculatedMofIdAppl defines the first byte (the first two chars in
     * hex String representation). The prefix is used for calculating the next
     * three bytes (six chars in hex String representation). The remaining 16
     * bytes (32 chars in hex string representation) are filled with the real
     * GUID, which is calculated from the input String[].
     * 
     * @param appl application
     * @param prefix prefix
     * @param input input
     * @return The computed MOF ID in hex string representation
     */
    public String calculateMofId( CalculatedMofIdAppl appl, String prefix, String[] input ) {

        String mofId = this.calculateMofIdImpl( appl, prefix, input );
        if ( mofId.length( ) != MOFID_LENGTH ) {
            throw new MoinLocalizedBaseRuntimeException( UtilitiesMessages.UNEXPECTEDMOFIDLENGTH, mofId );
        }
        return mofId;
    }

    /**
     * @param prefix
     * @param semanticKey
     * @return
     */
    private String calculateMofIdImpl( CalculatedMofIdAppl appl, String prefix, String[] semanticKey ) {

        // String of length GUID_LENGTH (32)
        String guid = calculateGUID( StringUtils.combine( semanticKey ) );
        return idLocalizer.addPrefixLocalizedInformation( guid, appl.getId( ), prefix );
    }

    /**
     * Calculates a message digest from input
     * 
     * @param input the String to convert
     * @return the message digest
     */
    public byte[] calculateSHA1HashUtf8( String input ) {

        try {
            return this.md.digest( input.getBytes( "UTF-8" ) ); //$NON-NLS-1$
        } catch ( UnsupportedEncodingException e ) {
            throw new MoinLocalizedBaseRuntimeException( e, UtilitiesMessages.UNSUPPORTEDENCODING );
        }
    }

    /**
     * Calculates a message digest with a localization prefix. The localization
     * prefix helps database indices by ensuring that related hashes are close
     * together in a sorted list.
     * 
     * @param sortInputArray String[] of length 2 which serves to define the
     * localization prefix
     * @param strValue the real message digest.
     * @return the message digest
     */
//    public byte[] calculateSHA1HashUtf8( String[] sortInputArray, String strValue ) {
//
//        if ( sortInputArray.length != 2 ) {
//            throw new MoinLocalizedBaseRuntimeException( UtilitiesMessages.ILLEGALARGUMENT );
//        }
//
//        try {
//            byte[] byteArray = new byte[BINARY_ID_LENGTH];
//            byte[] digestHash = this.md.digest( strValue.getBytes( "UTF-8" ) ); //$NON-NLS-1$
//            if ( digestHash.length != DIGEST_HASH_LENGTH ) {
//                throw new MoinLocalizedBaseRuntimeException( UtilitiesMessages.UNEXPECTEDARRAYLENGTH );
//            }
//            for ( int i = 0; i < 2; i++ ) {
//                int currentIntHash = sortInputArray[i].hashCode( );
//                byte b1 = (byte) currentIntHash;
//                byte b2 = (byte) ( currentIntHash / 256 );
//                byteArray[2 * i] = b1;
//                byteArray[2 * i + 1] = b2;
//            }
//            System.arraycopy( digestHash, 0, byteArray, BINARY_ID_LENGTH - DIGEST_HASH_LENGTH, DIGEST_HASH_LENGTH );
//            return byteArray;
//        } catch ( UnsupportedEncodingException e ) {
//            throw new MoinLocalizedBaseRuntimeException( e, UtilitiesMessages.UNSUPPORTEDENCODING );
//        }
//    }
    /**
     * Creates a GUID. Repeated calls will produce different results.
     * 
     * @return The GUID value represented as an upper case Hex-String of length
     * GUID_LENGTH (= 32)
     */
    public String createGUID( ) {

        IGUID g = this.guidGenerator.createGUID( );
        return g.toHexString( ).toUpperCase( Locale.ENGLISH );
    }

    /**
     * Calculates a GUID (represented as 32 character String) from an arbitrary
     * input String. Repeated calls with the same input produce the same output.
     * 
     * @param semanticKey
     * @return The GUID value represented by a String of length GUID_LENGTH (=
     * 32)
     */
    private String calculateGUID( String semanticKey ) {

        IGUID g = this.guidGenerator.createGUID( semanticKey );
        return g.toHexString( ).toUpperCase( Locale.ENGLISH );
    }

    /*
     * creates a localized MofID GUID
     */
    private String createMofIdImpl( ) {

        String guid = this.createGUID( );
        if ( guid.length( ) != GUID_LENGTH ) {
            throw new MoinLocalizedBaseRuntimeException( UtilitiesMessages.UNEXPECTEDGUIDLENGTH, guid );
        }
        String timeLocalizedString = idLocalizer.addTimeLocalizedInformation( guid );
        return timeLocalizedString;
    }

    /**
     * Converts the first 8 characters (ideally of a mofID), which represent a
     * Hex number to a byte array.
     * 
     * @param str
     * @return
     */
//    private byte[] convertHexToByteArray( String str ) {
//
//        byte[] byteArray = new byte[4];
//        for ( int i = 0; i < byteArray.length; i++ ) {
//            int currentVal = convertHexToInt( str.charAt( 2 * i ), true );
//            currentVal = currentVal << 4;
//            currentVal += convertHexToInt( str.charAt( 2 * i + 1 ), true );
//            byteArray[i] = (byte) currentVal;
//        }
//        return byteArray;
//    }
    /**
     * Convert a qualified name to a List
     * 
     * @param qualifiedName the name (with '.' as separator)
     * @return a List containing the name's components
     */
    public List<String> decodeQualifiedName( String qualifiedName ) {

        List<String> list = new ArrayList<String>( );
        if ( qualifiedName == null || qualifiedName.length( ) < 1 ) {
            return list;
        }
        int n = 0;
        int m = 0;
        while ( n >= 0 ) {
            n = qualifiedName.indexOf( '.', m );
            if ( n > 0 ) {
                list.add( qualifiedName.substring( m, n ) );
            } else {
                list.add( qualifiedName.substring( m ) );
            }
            m = n + 1;
        }
        return list;
    }

    /**
     * Computes a Java string literal that can be used in generated Java code to
     * represent the string <tt>s</tt>. This includes prepending and appending a
     * double-quote character and escaping line separators, backspaces and
     * double-quotes, as well as other non-printable characters. Other
     * characters are represented as Unicode escapes.
     * 
     * @param s the String to wrap
     * @return the wrapped representation
     */
    public String javaStringLiteral( String s ) {

        final String padding = "0000"; //$NON-NLS-1$
        StringBuffer result = new StringBuffer( s.length( ) * 6 );
        result.append( '\"' );
        for ( int i = 0; i < s.length( ); i++ ) {
            char c = s.charAt( i );
            // escape line terminators
            if ( c == '\n' ) {
                result.append( "\\n" ); //$NON-NLS-1$
            } else if ( c == '\r' ) {
                result.append( "\\r" ); //$NON-NLS-1$
            } else if ( c == '\\' || c == '\"' ) {
                // escape backslash and double-quote
                result.append( '\\' );
                result.append( c );
            } else if ( ( c >= ' ' && c <= '@' ) || Character.isJavaIdentifierPart( c ) ) {
                // printable character
                result.append( c );
            } else {
                // need Unicode escape
                String hex = Integer.toString( c, 16 );
                result.append( "\\u" ); //$NON-NLS-1$
                result.append( padding.substring( hex.length( ) ) );
                result.append( hex );
            }
        }
        result.append( '\"' );
        return result.toString( );
    }

    /**
     * @param array
     * @return the String
     */
    public String byteArrayToString( byte[] array ) {

        if ( array == null ) {
            return "null"; //$NON-NLS-1$
        }

        StringBuffer strBuf = new StringBuffer( 2 + array.length * 2 );
        strBuf.append( "0x" ); //$NON-NLS-1$
        for ( int i = 0; i < array.length; i++ ) {
            int currentValue = array[i];
            if ( currentValue < 0 ) {
                currentValue += 256;
            }
            appendHexOctet( strBuf, currentValue, null );
        }
        return strBuf.toString( );
    }

    private String concatByteArrayAndString( byte[] array, String string ) {

        StringBuffer strBuf = new StringBuffer( );
        for ( int i = 0; i < array.length; i++ ) {
            int currentValue = array[i];
            if ( currentValue < 0 ) {
                currentValue += 256;
            }
            appendHexOctet( strBuf, currentValue, null );
        }
        return strBuf.append( string ).toString( );
    }

    static char convertByteToHex( byte byteVal ) {

        switch ( byteVal ) {
            case 0:
                return '0';
            case 1:
                return '1';
            case 2:
                return '2';
            case 3:
                return '3';
            case 4:
                return '4';
            case 5:
                return '5';
            case 6:
                return '6';
            case 7:
                return '7';
            case 8:
                return '8';
            case 9:
                return '9';
            case 10:
                return 'A';
            case 11:
                return 'B';
            case 12:
                return 'C';
            case 13:
                return 'D';
            case 14:
                return 'E';
            case 15:
                return 'F';
            default:
                throw new MoinLocalizedBaseRuntimeException( UtilitiesMessages.UNEXPECTEDBYTEVALUE, byteVal );
        }
    }

//    private int convertHexToInt( char c, boolean beingTolerant ) {
//
//        switch ( c ) {
//            case '0':
//                return 0;
//            case '1':
//                return 1;
//            case '2':
//                return 2;
//            case '3':
//                return 3;
//            case '4':
//                return 4;
//            case '5':
//                return 5;
//            case '6':
//                return 6;
//            case '7':
//                return 7;
//            case '8':
//                return 8;
//            case '9':
//                return 9;
//            case 'A':
//                return 10;
//            case 'B':
//                return 11;
//            case 'C':
//                return 12;
//            case 'D':
//                return 13;
//            case 'E':
//                return 14;
//            case 'F':
//                return 15;
//
//            default:
//                if ( !beingTolerant ) {
//                    throw new MoinLocalizedBaseRuntimeException( UtilitiesMessages.UNEXPECTEDCHARVALUE, c );
//                }
//                return c % 16;
//        }
//    }

    /**
     * Appends the Hex representation of the specifed byte to the specified
     * string buffer.
     * 
     * @param sb the stringbuffer to append
     * @param value the non-negative byte value (i.e. 0x00 <= value <= 0xFF)
     * @param an optional escape string that is used as prefix (e.g. % for URL
     * encoding)
     */
    private void appendHexOctet( StringBuffer sb, int value, String escapeString ) {

        if ( escapeString != null ) {
            sb.append( escapeString );
        }

        int hexDigit = value / 16;
        sb.append( convertByteToHex( (byte) hexDigit ) );

        hexDigit = value % 16;
        sb.append( convertByteToHex( (byte) hexDigit ) );
    }

    /**
     * Encodes the specified string to a valid URL string as defined in RFC
     * 2396, using the UTF-8 character encoding. It keeps all allowed characters
     * unchanged and only encodes unallowed characters - this means that this
     * method cannot be used to encode parts or parameters of an URL. If the
     * provided String is already encoded, this method is idempotent.
     * <p>
     * See <a href="http://www.faqs.org/rfcs/rfc2396.html">RFC 2396</a> and <a
     * href="http://www.faqs.org/rfcs/rfc3629.html">RFC 3629</a> for details.
     * 
     * @param unencodedUrlString
     * @return encodedUrlString
     */
    public String encodeAsURI( String unencodedUrlString ) {

        if ( unencodedUrlString == null ) {
            return null;
        }

        final String allowedChars = ";/?:@&=+$,-_.!~*'()%"; //$NON-NLS-1$

        // we expect a little bit longer results than inputs (if most characters
        // are alphanum or at least ascii)
        StringBuffer sb = new StringBuffer( (int) Math.ceil( unencodedUrlString.length( ) * 1.2 ) );

        for ( int i = 0; i < unencodedUrlString.length( ); i++ ) {
            char c = unencodedUrlString.charAt( i );

            if ( ( c >= 'a' && c <= 'z' ) || ( c >= 'A' && c <= 'Z' ) || ( c >= '0' && c <= '9' ) || ( allowedChars.indexOf( c ) >= 0 ) ) {
                // append allowed characters unchannged
                sb.append( c );
            } else if ( c <= 0x007f ) {
                // other ASCII -> UTF-8 encoding keeps single byte
                appendHexOctet( sb, c, "%" ); //$NON-NLS-1$
            } else if ( c <= 0x07FF ) {
                // non-ASCII <= 0x7FF -> UTF-8 encoding creates 2-bytes
                // representation of the form 110xxxxx 10xxxxxx
                // where the x bits are filled with the bits of the character
                // the character has max. 11 bits set, and we have 5 open slots
                // in the 1st octet;
                // so we right-shift 6 and bitwise or with 1100 0000 to compute
                // the first octet;
                // for the second octed, we have to fill in the last 6 bits (by
                // bitwise AND with 0011 1111)
                appendHexOctet( sb, 0xc0 | ( c >> 6 ), "%" ); //$NON-NLS-1$
                appendHexOctet( sb, 0x80 | ( c & 0x3F ), "%" ); //$NON-NLS-1$
            } else {
                // 0x7FF < c <= 0xFFFF -> UTF-8 encoding creates 3-bytes
                // representation of the form
                // 1110xxxx 10xxxxxx 10xxxxxx
                // the character has max. 16 bits set, and we have 4 open slots
                // in the first octed (-> right-shift 12)
                // the second octed has 6 open slots, so we right-shift 6 and
                // ensure that only the last 6 bits are set
                // same for the 3rd octed
                appendHexOctet( sb, 0xe0 | ( c >> 12 ), "%" ); //$NON-NLS-1$
                appendHexOctet( sb, 0x80 | ( ( c >> 6 ) & 0x3F ), "%" ); //$NON-NLS-1$
                appendHexOctet( sb, 0x80 | ( c & 0x3F ), "%" ); //$NON-NLS-1$
            }
        }

        return sb.toString( );
    }

    /**
     * Computes the minimum initial capacity of a {@link HashMap},
     * {@link WeakHashMap}, {@link LinkedHashMap}, {@link HashSet} or
     * {@link LinkedHashSet} if the maximum number of elements in the map is
     * known in advance. Using the exact capacity completely avoids expensive
     * re-hashing.
     * 
     * @param expectedMaxSize
     * @return the initial capacity
     */
    public static final int calcInitialCapacity( int expectedMaxSize ) {

        return (int) Math.ceil( expectedMaxSize * INVERSE_HASHMAP_LOAD_FACTOR );
    }

    /**
     * Calculates the meta-model extension package name. !!! ATTENTION !!! Due
     * to technical reasons this method is called REFLECTIVELY by the
     * "MOF-Editor" tool. If you need to refactor this method, please contact
     * Michael Wenz.
     * 
     * @param metamodelName meta-model's id
     * @return meta-model extension package name
     */
    public static String getMMPackageQualified( String metamodelName ) {

        if ( metamodelName == null || metamodelName.length( ) == 0 ) {
            return MOIN_PACKAGE;
        }
        // calculate the MM ID
        Utilities sha1Utilities = Utilities.getUtilities( );
        String mmId = sha1Utilities.byteArrayToString( sha1Utilities.calculateSHA1HashUtf8( metamodelName ) ).substring( 2 );
        return MOIN_PACKAGE + JAVA_PACKAGE_DELIMITER + PACKAGE_PREFIX_METAMODELID + mmId;

    }

    /**
     * Obtains a snapshot of the given collection, returned as a list.
     * Concurrent modifications are taken into account by catching
     * ConcurrentModificationException and retrying until a snapshot was
     * obtained.
     * 
     * @param collection
     * @param <T>
     * @return the snapshot
     */
    public static <T> List<T> getSnapshotOfCollectionAsList( Collection<T> collection ) {

        // We want to create a snapshot of the given collection, taking concurrent modifications into account. 
        // Since we cannot synchronize every call to the given collection, we catch any ConcurrentModificationException 
        // and retry until a snapshot has been obtained successfully.
        List<T> result = null;
        if ( !collection.isEmpty( ) ) {
            while ( result == null ) {
                result = new ArrayList<T>( collection.size( ) );
                Iterator<T> iterator = collection.iterator( );
                try {
                    while ( iterator.hasNext( ) ) {
                        result.add( iterator.next( ) );
                    }
                } catch ( ConcurrentModificationException ex ) {
                    // Can happen. We retry until we get a snapshot.
                    result = null;
                    continue;
                } catch ( NoSuchElementException ex ) {
                    // Can happen. We return what we have collected until now.
                    continue;
                }
            }
        } else {
            result = Collections.emptyList( );
        }
        return result;
    }

    /**
     * Obtains a snapshot of the given collection, returned as a set. Concurrent
     * modifications are taken into account by catching
     * ConcurrentModificationException and retrying until a snapshot was
     * obtained.
     * 
     * @param collection
     * @param <T>
     * @return the snapshot
     */
    public static <T> Set<T> getSnapshotOfCollectionAsSet( Collection<T> collection ) {

        // We want to create a snapshot of the given collection, taking concurrent modifications into account. 
        // Since we cannot synchronize every call to the given collection, we catch any ConcurrentModificationException 
        // and retry until a snapshot has been obtained successfully.
        Set<T> result = null;
        if ( !collection.isEmpty( ) ) {
            while ( result == null ) {
                result = new LinkedHashSet<T>( collection.size( ) );
                Iterator<T> iterator = collection.iterator( );
                try {
                    while ( iterator.hasNext( ) ) {
                        result.add( iterator.next( ) );
                    }
                } catch ( ConcurrentModificationException ex ) {
                    // Can happen. We retry until we get a snapshot.
                    result = null;
                    continue;
                } catch ( NoSuchElementException ex ) {
                    // Can happen. We return what we have collected until now.
                    continue;
                }
            }
        } else {
            result = Collections.emptySet( );
        }
        return result;
    }
}