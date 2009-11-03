package com.sap.tc.moin.facility.primary.query.index.memory;

/**
 * This class creates the {@link IndexMofId}s (index representation of MofIds)
 * and ensures the existence of only one instance of IndexMofId per MofId
 * string. Therefore it uses a {@link IndexHashSetDuplicates} table as cache
 * which already provides methods for the lookup. The IndexHashSetDuplicates
 * table is chosen to be the cache, since it already represents a mapping of
 * IndexMofIds to IndexModelElements and therefore contains most of the MofIds.
 * 
 * <pre>
 * Using unique IndexMofIds throughout the index has following advantages:
 * 
 *    - It reduces the memory consumption since there are no duplicates
 *    - It enables identity comparison that increases performance
 *    - Negative answers of queries can be speeded up since lookups in the index 
 *      tables is not necessary if an IndexMofId could not be found in the cache.
 * </pre>
 * 
 * Since all 40-char MofIds that enter the index need to be encoded (in case of
 * {@link IndexMofIdPrimary}), a new {@link IndexMofId} instance has to be
 * created for each MofId. But the index relies on uniqueness of IndexMofId
 * instances. Therefore, the newly created instance is used to look up an
 * eventually existing {@link IndexMofId} instance - representing the same MofId
 * - in the cache. If an already existing instance is found, the newly created
 * instance is thrown away. Especially in the queries where no new IndexMofIds
 * are added to the cache, instantiating a new IndexMofId instance for each
 * MofId encoding would produce a lot garbage.<br>
 * Therefore the IndexMofIdFactory holds one instance of IndexMofId that is
 * replaced if it is added to the cache and reinitialized if not. There are
 * following disadvantage of this approach:
 * 
 * <pre>
 *    - The methods creating the IndexMofIds instances need to be synchronized. 
 *      But since the <code>init()</code> method of IndexMofId needs to be 
 *      synchronized too (it makes use of a global buffer), the synchronization
 *      of factory methods and IndexMofId initialization can be put together 
 *      and is partially even combined with the synchronization of writing
 *      methods of {@link IndexImpl}(e.g. indexPartition()).
 *    - Member variables of IndexMofId cannot be final. Although it should not be
 *      possible to change the content of a IndexMofId, the public <code>init()</code>
 *      method would still allow it.
 * </pre>
 * 
 * The creation of IndexMofIds in the IndexDumplHandler is not done by the
 * Factory for performance reasons. They are directly instantiated there.<br>
 * <br>
 * <b>NOTE: All methods that modify the {@link IndexHashSetDuplicates} table
 * need to have index write lock. The same holds good for reading methods, which
 * require index read lock (see {@link IndexImpl#rwLock}).</b>
 * 
 * @author D048997
 */
public class IndexMofIdFactory {

    // the cache table for IndexMofId instances
    private IndexHashSetDuplicates<IndexModelElement, IndexMofId> idTable = null;

    // hold one instance used for lookup in cache (String MofIds must be encoded to compare)
    // holding an instance and reinitialize it avoids instantiation of IndexMofId for each lookup
    // in the cache table -> less garbage production.
    private IndexMofIdPrimary next = null;

    /**
     * @param idTable Cache table
     */
    public IndexMofIdFactory( IndexHashSetDuplicates<IndexModelElement, IndexMofId> idTable ) {

        assert idTable != null : IndexMessages.PARAMETER_MUST_NOT_BE_NULL;

        this.next = new IndexMofIdPrimary( );
        this.idTable = idTable;
    }

    /**
     * Creates a new MofId instances and checks if an equal MofId is already in
     * the cache. If it is not, it adds the new MofId and returns this instance.
     * If the MofId is already in the cache, the instance in the cache is
     * returned.<br>
     * <br>
     * Caution: This method is NOT synchronized and is intended to be used in
     * the non-concurrent indexing methods!
     * 
     * @param mofId
     * @return {@link IndexMofId} representation for the MOF-ID string
     */
    public IndexMofId createAndCacheMofId( String mofId ) {

        // encode the MofId string (needed for lookup!) but avoid possibly unnecessary instantiation of IndexMofId
        this.next.init( mofId );
        // cache lookup: return another IndexMofId instance of 'mofId' or put 'next' into the cache and return it
        IndexMofId ret = this.idTable.putOrGetExistingKey( this.next, true );
        // if 'next' is put into cache...
        if ( ret == this.next ) {
            // ... create a new instance to hold
            this.next = new IndexMofIdPrimary( );
        }
        return ret;
    }

    /**
     * Creates a new MofId instances and checks if an equal MofId is already in
     * the cache. If it is not, a new MofId is returned and <b>NOT</b> added to
     * the cache. If the MofId is already in the cache, the instance in the
     * cache is returned.<br>
     * <br>
     * Caution: This method is NOT synchronized and is intended to be used in
     * the non-concurrent indexing methods!<br>
     * <br>
     * This method can be called if a new IndexModelElement is to be created.
     * Not putting the new IndexMofId into the cache avoids creating a
     * WeakHashReference that would be deleted in the second where the new
     * IndexModelElement is added to the IndexHashSetDuplicates table.<br>
     * Calling this method and adding the IndexModelElement to the
     * IndexHashSetDuplicates table must be done within the same index write
     * lock!
     * 
     * @param mofId
     * @return {@link IndexMofId} representation for the MOF-ID string
     */
    public IndexMofId createMofId( String mofId ) {

        // almost the same as in createAndCacheMofId()
        this.next.init( mofId );
        IndexMofId ret = this.idTable.putOrGetExistingKey( this.next, false );
        if ( ret == null ) {
            ret = this.next;
            this.next = new IndexMofIdPrimary( );
        }
        return ret;
    }

    /**
     * Tries to retrieve the {@link IndexMofId} instance for the MOF-ID string
     * from the cache, but does not add it to the cache like
     * {@link IndexMofIdFactory#createAndCacheMofId(String)}.<br>
     * <br>
     * Caution: This method IS synchronized and intended to be used in
     * concurrent query methods!
     * 
     * @param mofId
     * @return The {@link IndexMofId} instance or NULL if the MOF-ID is not in
     * the cache.
     */
    public synchronized IndexMofId getMofId( String mofId ) {

        this.next.init( mofId );
        return this.idTable.putOrGetExistingKey( this.next, false );
    }

    /*
     * ##################################################################
     * ########## IndexMofId Implemenations ############
     * #################################################
     */

    /**
     * The {@link IndexMofIdPrimary} is the internal representation of a Primary
     * Facility MofId in the index. It encodes the 40-char hexadecimal string
     * (with upper-case letters) into primitive decimal types without loss. The
     * format of the input MofId is not checked. If it contains other characters
     * than hexadecimal once, the encoding will finish, but produce a corrupt
     * encoded MofId.<br>
     * <br>
     * IndexMofIds are created in the {@link IndexMofIdFactory} and during read
     * of the index dump (see {@link IndexDumpHandler}). <br>
     * <br> {@link IndexMofIdPrimary} must be an inner class of
     * {@link IndexMofIdFactory} to facilitate immutability of the content after
     * it leaves the factory and the opportunity to reinitialize an instance in
     * the factory. The last feature is used in the "next-concept" introduced
     * for garbage avoidance (see {@link IndexMofIdFactory}).
     * 
     * <pre>
     * The encoding and decoding of MofIds has following background:
     *    
     *    The hexadecimal characters are represented in in the ASCII table as follows:
     *    
     *       char   DEC       HEX       BIN
     *       0-9    48-57     30-39     0110000-0111001
     *       A-F    65-70     41-46     1000001-1000110
     *    
     *    If you mask the binary representation to the last 5 digits, following table 
     *    results (left side from "---->"):
     *     
     *       char    BINx5   DEC              DEC   BINx4
     *       0       10000   16      ---->    0     0000
     *       1       10001   17      ---->    1     0001
     *       ...     ...     ...     ...      ...   ...
     *       9       11001   25      ---->    9     1001
     *       A       00001   1       ---->    10    1010
     *       ...     ...     ...     ...      ...   ...
     *       F       00110   6       ---->    15    1111
     *    
     *    And if you now map each of the decimals to another decimal value between 0 and
     *    15 (as shown above) you can create a lookup table (array) with the length of 32
     *    (i.e. 2^5) that encodes one char in a lower-byte (4bit). Sure, you could also
     *    create an array of 256 as lookup table, but this way is negligible slower 
     *    (already measured) and much more elegant ;). (see ENCODE_TABLE)
     *    
     *    Decoding is much easier. With an lookup table with length 16 you can map the
     *    numbers dec(0-15) to hex(0-F) (see DECODE_TABLE).
     * </pre>
     * 
     * @author D048997
     */
    public static final class IndexMofIdPrimary implements IndexMofId {

        private static final char[] DECODE_TABLE = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

        // encoding table: invalid array entries are set to -1 to break the encoding in init()
        private static final byte[] ENCODE_TABLE = new byte[] { -1, 10, 11, 12, 13, 14, 15, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1 };

        private static final byte ENCODE_MASK = 31;

        private static final byte DECODE_MASK = 15;

        // buffer for decoding
        private static final char[] outBuffer = new char[40];

        // buffer for encoding
        private static final char[] inBuffer = new char[40];

        // synchronization object for decoding of the MofId
        private static final Object lock = new Object( );

        private static final int HASH_MASK = Integer.MAX_VALUE;

        /*
         * ###### Parts of the MofId
         * #########################################################
         */

        // not final since re-initialized!
        private long first; // first 16 characters

        private int second; // 8 characters in the middle

        private long third; // last 16 characters

        /*
         * ###### Parts of the MofId
         * #########################################################
         */

        // not final since re-initialized!
        private int hashCode;

        /**
         * Constructor used in index dump.
         * 
         * @param first First part of encoded MofId
         * @param second Second part of encoded MofId
         * @param third Thrid part of encoded MofId
         */
        public IndexMofIdPrimary( long first, int second, long third ) {

            this.first = first;
            this.second = second;
            this.third = third;

            /*
             * first == -1 (i.e. 32 times 1) would mean that we are at the end
             * of time, since MofId prefix is a timestamp. Exceptions are
             * calculated MofIds, but there it is still unlikely to hit the -1.
             */
            if ( first == -1 ) { // flag for non-exisistent mof-id (see IndexDumpHandler)
                this.hashCode = -1;
            } else {
                this.hashCode = this.calcHashCode( );
            }
        }

        /**
         * Standard constructor. Initialization/encoding of MofId is done in
         * <code>init()</code>-method.
         */
        public IndexMofIdPrimary( ) {

        }

        /**
         * Caution: Unchecked type cast to {@link IndexMofIdPrimary}!<br>
         * This methods is only used for retrieving an possibly existing
         * {@link IndexMofIdPrimary} instance of the MofId in the cache and does
         * not perform an identity check, because this can never happen.
         */
        @Override
        public boolean equals( Object mId ) {

            IndexMofIdPrimary mofId = (IndexMofIdPrimary) mId;
            return mofId.second == this.second && mofId.first == this.first && mofId.third == this.third;
        }

        /**
         * The string representation is the 40-char hexadecimal string that is
         * encoded into primitive types in the init() method.<br>
         * This method is synchronized since it uses the static
         * <code>outBuffer</code> variable as buffer for decoding the MofId.
         * Doing so avoids the numerous instantiation and garbage collection of
         * buffer arrays.<br>
         * 
         * @return The 40-char hexadecimal string representation of the MofId.
         * It is not interned!
         */
        @Override
        public String toString( ) {

            // Synchronization on the static lock object since outBuffer is static too!
            synchronized ( IndexMofIdPrimary.lock ) {
                long f = this.first;
                int s = this.second;
                long t = this.third;

                char[] ret = IndexMofIdPrimary.outBuffer;
                for ( byte i = 39; i > 23; i-- ) {
                    ret[i] = DECODE_TABLE[(int) ( t & DECODE_MASK )];
                    t >>= 4;
                }
                for ( byte i = 23; i > 15; i-- ) {
                    ret[i] = DECODE_TABLE[( s & DECODE_MASK )];
                    s >>= 4;
                }
                for ( byte i = 15; i > -1; i-- ) {
                    ret[i] = DECODE_TABLE[(int) ( f & DECODE_MASK )];
                    f >>= 4;
                }
                // the string is not interned since it is usually used to create a MRI that interns the MofId itself.
                return new String( ret );
            }
        }

        @Override
        public int hashCode( ) {

            return this.hashCode;
        }

        private int calcHashCode( ) {

            int h = (int) ( this.first ^ ( this.first >>> 32 ) ^ this.second ^ this.third ^ ( this.third >>> 32 ) );
            // following hash algorithm is taken from HashMap (JDK 1.6)
            h ^= ( h >>> 20 ) ^ ( h >>> 12 );
            h ^= ( h >>> 7 ) ^ ( h >>> 4 );

//            // HashMap algorithm from JDK 1.5        
//            h += ~( h << 9 );
//            h ^= ( h >>> 14 );
//            h += ( h << 4 );
//            h ^= ( h >>> 10 );

            // make sure hashCode is always positive, negative hashCode is reserved (e.g. for non-existent MofIds)
            h &= HASH_MASK;

            return h;
        }

        /**
         * <b>Caution:</b> <code>init()</code> must only be called in the
         * {@link IndexMofIdFactory}. It must not be called at a later time,
         * where the MofId is already in the cache!<br>
         * This methods encodes the string representation of the MofId. It must
         * be synchronized in the calling method since it uses the static
         * <code>inBuffer</code> variable.
         * 
         * @param mofId
         */
        private void init( String mofId ) {

            char[] chs = IndexMofIdPrimary.inBuffer;
            mofId.getChars( 0, 40, chs, 0 );

            long f = 0;
            int s = 0;
            long t = 0;

            // no character check -> ENCODE_TABLE['X'] == -1 => destroys index MofId representation
            for ( byte i = 0; i < 16; i++ ) {
                f <<= 4;
                f |= ENCODE_TABLE[chs[i] & ENCODE_MASK];
            }
            for ( byte i = 16; i < 24; i++ ) {
                s <<= 4;
                s |= ENCODE_TABLE[chs[i] & ENCODE_MASK];
            }
            for ( byte i = 24; i < 40; i++ ) {
                t <<= 4;
                t |= ENCODE_TABLE[chs[i] & ENCODE_MASK];
            }

            this.first = f;
            this.second = s;
            this.third = t;

            this.hashCode = this.calcHashCode( );
        }

        public long getFirst( ) {

            return this.first;
        }

        public int getSecond( ) {

            return this.second;
        }

        public long getThird( ) {

            return this.third;
        }
    }
}
