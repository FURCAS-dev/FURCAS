package com.sap.runlet.abstractinterpreter.util;

/**
 * Implements a BASE64 encoder and decoder. Class <code>Base64</code> provides
 * static encoding- and decoding-methods for describing binary data through
 * printable characters. The implementation is compliant to RFC 1521.
 * 
 * @copyright @version $Revision: #1 $.
 * @author Stefan Kusterer, Last modified by $Author: d038253 $, Change list
 * $Change: 156641 $.
 */
public class Base64 {

    protected static final char[] CHAR_LOOKUP_ARRAY = {
    /* 0 */'A', /* 1 */'B', /* 2 */'C', /* 3 */'D',
    /* 4 */'E', /* 5 */'F', /* 6 */'G', /* 7 */'H',
    /* 8 */'I', /* 9 */'J', /* 10 */'K', /* 11 */'L',
    /* 12 */'M', /* 13 */'N', /* 14 */'O', /* 15 */'P',
    /* 16 */'Q', /* 17 */'R', /* 18 */'S', /* 19 */'T',
    /* 20 */'U', /* 21 */'V', /* 22 */'W', /* 23 */'X',
    /* 24 */'Y', /* 25 */'Z',
    /* 26 */'a', /* 27 */'b', /* 28 */'c', /* 29 */'d',
    /* 30 */'e', /* 31 */'f', /* 32 */'g', /* 33 */'h',
    /* 34 */'i', /* 35 */'j', /* 36 */'k', /* 37 */'l',
    /* 38 */'m', /* 39 */'n', /* 40 */'o', /* 41 */'p',
    /* 42 */'q', /* 43 */'r', /* 44 */'s', /* 45 */'t',
    /* 46 */'u', /* 47 */'v', /* 48 */'w', /* 49 */'x',
    /* 50 */'y', /* 51 */'z',
    /* 52 */'0', /* 53 */'1', /* 54 */'2', /* 55 */'3',
    /* 56 */'4', /* 57 */'5', /* 58 */'6', /* 59 */'7',
    /* 60 */'8', /* 61 */'9',
    /* 62 */'+', /* 63 */'/',
    /* pad */'=' };

    protected static final int[] VALUE_LOOKUP_ARRAY = new int[128];

    static // Initializer
    {
        for ( char i = 0; i < VALUE_LOOKUP_ARRAY.length; i++ ) {
            if ( CHAR_LOOKUP_ARRAY[0] <= i && i <= CHAR_LOOKUP_ARRAY[25] ) {
                VALUE_LOOKUP_ARRAY[i] = ( i - CHAR_LOOKUP_ARRAY[0] );
            } else if ( CHAR_LOOKUP_ARRAY[26] <= i && i <= CHAR_LOOKUP_ARRAY[51] ) {
                VALUE_LOOKUP_ARRAY[i] = ( i - CHAR_LOOKUP_ARRAY[26] ) + 26;
            } else if ( CHAR_LOOKUP_ARRAY[52] <= i && i <= CHAR_LOOKUP_ARRAY[61] ) {
                VALUE_LOOKUP_ARRAY[i] = ( i - CHAR_LOOKUP_ARRAY[52] ) + 52;
            } else if ( i == CHAR_LOOKUP_ARRAY[62] ) {
                VALUE_LOOKUP_ARRAY[i] = 62;
            } else if ( i == CHAR_LOOKUP_ARRAY[63] ) {
                VALUE_LOOKUP_ARRAY[i] = 63;
            } else if ( i == CHAR_LOOKUP_ARRAY[64] ) {
                VALUE_LOOKUP_ARRAY[i] = -1;
            } else {
                VALUE_LOOKUP_ARRAY[i] = -2;
            }
        }
    }

    // do not allow to instantiate this class
    protected Base64( ) {
        // only static methods
    }

    public final static byte[] decode(String in) {
	char[] c = new char[in.length()];
	in.getChars(0, in.length(), c, 0);
	return decode(c);
    }
    
    /**
     * <code>decode</code> a given array of characters.
     * 
     * @param in The input array of characters
     * @return The array of bytes
     */
    public final static byte[] decode( char[] in ) {

        if ( in == null || in.length == 0 ) {
            return new byte[0];
        }

        int index_in;
        int index_out;
        int helper_1 = 0;
        int helper_2 = 0;
        int mod = 0;
        int in_length = in.length;
        int chr;

        // Determine number of used characters: Ignore linebreaks etc. and count
        // trailing =-signes
        for ( index_in = 0; index_in < in.length; index_in++ ) {
            chr = in[index_in];
            if ( chr >= 128 ) {
                in_length--;
            } else if (VALUE_LOOKUP_ARRAY[chr] < 0) {
                in_length--;
            }
        }

        // Allocate out-buffer
        byte out[] = new byte[( in_length >>> 2 ) * 3 + ( ( in_length & 0x03 ) > 0 ? ( in_length & 0x03 ) - 1 : 0 )];

        // Do the real decoding
        for ( index_in = 0, index_out = 0; index_in < in.length && index_out < out.length; index_in++ ) {
            chr = in[index_in];
            if ( chr > 127 || VALUE_LOOKUP_ARRAY[chr] == -2 ) {
                continue;
            }

            helper_1 = helper_2;
            helper_2 = VALUE_LOOKUP_ARRAY[chr] > 0 ? VALUE_LOOKUP_ARRAY[chr] : 0;

            switch ( mod ) {
                case 0:
                    // no operation
                    break;
                case 1:
                    out[index_out++] = (byte) ( ( helper_1 << 2 ) & 0xFC | ( helper_2 >>> 4 ) & 0x03 );
                    break;
                case 2:
                    out[index_out++] = (byte) ( ( helper_1 << 4 ) & 0xF0 | ( helper_2 >>> 2 ) & 0x0F );
                    break;
                case 3:
                    out[index_out++] = (byte) ( ( helper_1 << 6 ) & 0xC0 | helper_2 & 0x3F );
                    break;
            }

            mod = ( mod < 3 ? mod + 1 : 0 );
        }

        return out;
    }

    /**
     * Add a charcter to an array of chars and insert linebreas if necessary
     */
    private final static int writeToCharArray( char[] out, int idx, char chr ) {
        out[idx++] = chr;
        return idx;
    }
    
    /**
     * <code>encode</code> a given array.
     * 
     * @param in the input array of binary data
     * @return The array of characters
     */
    public final static String encode( byte[] in ) {

        if ( in == null ) {
            return null;
        }

        int index_in;
        int index_out;
        char chr;

        // Allocate buffer for result: Consider chars for trailing =-signs
        // and linebreaks.
        char out[] = new char[( ( ( in.length + 2 ) / 3 ) << 2 )];

        for ( index_in = 0, index_out = 0; index_in < in.length - 2; index_in += 3 ) {
            // compute first byte: highest six bits of first byte
            chr = CHAR_LOOKUP_ARRAY[( in[index_in] >>> 2 ) & 0x3F];
            index_out = writeToCharArray( out, index_out, chr );

            // compute second byte: lowest two bits of first byte
            chr = CHAR_LOOKUP_ARRAY[( in[index_in] << 4 ) & 0x30 |
            // and highest four bits of second byte
                                    ( in[index_in + 1] >>> 4 ) & 0x0F];
            index_out = writeToCharArray( out, index_out, chr );

            // compute third byte: lowest four bits of second byte
            chr = CHAR_LOOKUP_ARRAY[( in[index_in + 1] << 2 ) & 0x3C |
            // and higest two bits of third byte
                                    ( in[index_in + 2] >>> 6 ) & 0x03];
            index_out = writeToCharArray( out, index_out, chr );

            // compute fourth byte: lowest six bits of third byte
            chr = CHAR_LOOKUP_ARRAY[in[index_in + 2] & 0x3F];
            index_out = writeToCharArray( out, index_out, chr );
        }

        // take care of the last bytes (one or two)
        if ( index_in < in.length ) {
            chr = CHAR_LOOKUP_ARRAY[( in[index_in] >>> 2 ) & 0x3F];
            index_out = writeToCharArray( out, index_out, chr );

            if ( index_in < in.length - 1 ) {
                // there are two remaining bytes
                chr = CHAR_LOOKUP_ARRAY[( in[index_in] << 4 ) & 0x30 | ( in[index_in + 1] >>> 4 ) & 0x0F];
                index_out = writeToCharArray( out, index_out, chr );

                chr = CHAR_LOOKUP_ARRAY[( in[index_in + 1] << 2 ) & 0x3F];
                index_out = writeToCharArray( out, index_out, chr );
            } else {
                // there is only one remaining byte
                chr = CHAR_LOOKUP_ARRAY[( in[index_in] << 4 ) & 0x30];
                index_out = writeToCharArray( out, index_out, chr );
            }
        }

        // add padding =-signs if required
        while ( index_out < out.length ) {
            index_out = writeToCharArray( out, index_out, CHAR_LOOKUP_ARRAY[64] );
        }

        return new String(out);
    }
}
