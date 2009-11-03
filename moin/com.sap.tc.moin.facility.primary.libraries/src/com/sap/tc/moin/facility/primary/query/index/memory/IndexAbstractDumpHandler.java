package com.sap.tc.moin.facility.primary.query.index.memory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

import com.sap.tc.moin.facility.primary.query.index.memory.IndexMofIdFactory.IndexMofIdPrimary;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.ResourceIdentifierFactory;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;

public abstract class IndexAbstractDumpHandler implements IndexDumpHandler {

    private static final int VERSION = 3;

    // dump handler version: needed to decide if dump can be read with this dump handler
    private final int versionId;

    private ResourceIdentifierFactory riFactory;

    protected IndexImpl index = null;

    // ################ Constructors ###################
    public IndexAbstractDumpHandler( int versionId, ResourceIdentifierFactory riFactory, IndexImpl index ) {

        assert index != null;
        assert riFactory != null;

        this.versionId = ( VERSION << 16 ) | versionId;
        this.riFactory = riFactory;
        this.index = index;
    }

    // ###############################################################
    // ################# Index Dump Buffer Interfaces ################
    // ###############################################################
    private static final int INT_SIZE = Integer.SIZE / 8;

    private static final int LONG_SIZE = Long.SIZE / 8;

    private static final int BYTE_SIZE = Byte.SIZE / 8;

    protected final static class DumpReadBuffer {

        private ByteBuffer buffer = null;

        private ReadableByteChannel fc = null;

        private byte[] stringBuffer;

        /**
         * @param input
         * @param size Size of the channel content
         * @param bufMaxSize maximum buffer size
         * @throws IOException
         */
        public DumpReadBuffer( ReadableByteChannel input, int size, int bufMaxSize, boolean direct ) throws IOException {

            this( input, ( size < bufMaxSize ) ? size : bufMaxSize, direct );
        }

        /**
         * @param input
         * @param bufSize fixed buffer size
         * @throws IOException
         */
        public DumpReadBuffer( ReadableByteChannel input, int bufSize, boolean direct ) throws IOException {

            this.fc = input;
            if ( direct ) {
                this.buffer = ByteBuffer.allocateDirect( bufSize );
            } else {
                this.buffer = ByteBuffer.allocate( bufSize );
            }
            this.stringBuffer = new byte[bufSize];
            this.fc.read( this.buffer );
            this.buffer.flip( );
        }

        public int getInt( ) throws IOException {

            if ( this.buffer.limit( ) - this.buffer.position( ) < INT_SIZE ) {
                this.adjustBuffer( );
            }
            return this.buffer.getInt( );
        }

        public byte getByte( ) throws IOException {

            if ( this.buffer.limit( ) - this.buffer.position( ) < BYTE_SIZE ) {
                this.adjustBuffer( );
            }
            return this.buffer.get( );
        }

        public long getLong( ) throws IOException {

            if ( this.buffer.limit( ) - this.buffer.position( ) < LONG_SIZE ) {
                this.adjustBuffer( );
            }
            return this.buffer.getLong( );
        }

        public String getString( ) throws IOException {

            int length = this.getInt( );

            if ( this.buffer.limit( ) - this.buffer.position( ) < length ) {
                this.adjustBuffer( );
            }
            this.buffer.get( this.stringBuffer, 0, length );
            return new String( this.stringBuffer, 0, length, IndexConstants.ENCODING );
        }

        private void adjustBuffer( ) throws IOException {

            this.buffer.compact( );
            this.fc.read( this.buffer );
            this.buffer.flip( );
        }

    }

    protected final static class DumpWriteBuffer {

        private ByteBuffer buffer = null;

        private WritableByteChannel fc = null;

        public DumpWriteBuffer( WritableByteChannel output, int bufMaxSize, boolean direct ) {

            this.fc = output;
            if ( direct ) {
                this.buffer = ByteBuffer.allocateDirect( bufMaxSize );
            } else {
                this.buffer = ByteBuffer.allocate( bufMaxSize );
            }
        }

        public void put( int value ) throws IOException {

            if ( this.buffer.limit( ) - this.buffer.position( ) < INT_SIZE ) {
                this.flushBuffer( INT_SIZE );
            }
            this.buffer.putInt( value );
        }

        public void put( String value ) throws IOException {

            byte[] bytes = value.getBytes( IndexConstants.ENCODING );

            this.put( bytes.length );

            if ( this.buffer.limit( ) - this.buffer.position( ) < bytes.length ) {
                this.flushBuffer( bytes.length );
            }
            this.buffer.put( bytes );
        }

        public void put( long value ) throws IOException {

            if ( this.buffer.limit( ) - this.buffer.position( ) < LONG_SIZE ) {
                this.flushBuffer( LONG_SIZE );
            }
            this.buffer.putLong( value );
        }

        public void put( byte value ) throws IOException {

            if ( this.buffer.limit( ) - this.buffer.position( ) < BYTE_SIZE ) {
                this.flushBuffer( BYTE_SIZE );
            }
            this.buffer.put( value );
        }

        private void flushBuffer( int nextInputSize ) throws IOException {

            // set limit to position and position to 0
            this.buffer.flip( );
            // write buffer content to file channel
            this.fc.write( this.buffer );
            // check if buffer is big enough to handle next input
            if ( this.buffer.capacity( ) < nextInputSize ) {
                throw new BufferOverflowException( );
            }
            // set limit to capacity and position to 0
            this.buffer.clear( );
        }

        public void flushBuffer( ) throws IOException {

            this.flushBuffer( 0 );
        }
    }

    // ###############################################################
    // ####################### Index Dump Section ####################
    // ###############################################################

    public abstract boolean dump( );

    /**
     * Fills the buffer with the dumper version info and the index content.
     * 
     * @param dumpBuf
     * @throws IOException
     * @throws FileNotFoundException
     */
    protected void dumpInternal( DumpWriteBuffer dumpBuf ) throws IOException, FileNotFoundException {

        dumpBuf.put( versionId );
        this.dumpPriToIndexPri( dumpBuf );
        this.dumpMofIdToElements( dumpBuf );
        this.dumpPriToElements( dumpBuf );
        this.dumpTypeToInstances( dumpBuf );
        this.dumpLocMofIdToLinkRecords( dumpBuf );
        this.dumpExtToLinkRecords( dumpBuf );
        this.dumpPriToLinkRecords( dumpBuf );
        this.dumpTopLevelPkg( dumpBuf );
        this.dumpDaDCToPri( dumpBuf );
    }

    private void dumpPriToIndexPri( DumpWriteBuffer dumpBuf ) throws IOException {

        IndexHashSetSingle<IndexPri> priToIndexPri = this.index.getPriToIndexPri( );
        Object[] table = priToIndexPri.table;
        int len = table.length;

        // write size information
        this.writeArraySize( dumpBuf, len );
        dumpBuf.put( priToIndexPri.size( ) );

        // write entries
        int counter = 0;
        IndexPri idxPri = null;
        for ( int i = 0; i < len; ++i ) {
            if ( table[i] != null ) {
                dumpBuf.put( i );
                idxPri = (IndexPri) table[i];
                this.dumpIndexPri( dumpBuf, idxPri );
                ++counter;
            }
        }
        if ( counter != priToIndexPri.size( ) ) {
            throw new IndexBugException( IndexAbstractDumpedConstants.ENTRY_NUMBERS_INCORRECT, "PriToIndexPri", priToIndexPri.size( ), counter ); //$NON-NLS-1$
        }
    }

    protected void dumpIndexPri( DumpWriteBuffer dumpBuf, IndexPri idxPri ) throws IOException {

        String priString = idxPri.getPriString( );
        dumpBuf.put( priString );
        dumpBuf.put( idxPri.getTimestamp( ) );
        dumpBuf.put( idxPri.getStates( ) );
    }

    private static final byte TYPE_MOFID = 0;

    private static final byte TYPE_ELEMENT = 1;

    private static final byte TYPE_ARRAY = 2;

    private static final byte TYPE_NAMED_ELEM = 3;

    private void dumpMofIdToElements( DumpWriteBuffer dumpBuf ) throws IOException {

        IndexHashSetSingle<IndexPri> priToIndexPri = this.index.getPriToIndexPri( );
        IndexHashSetDuplicates<IndexModelElement, IndexMofId> mofIdToElements = this.index.getMofIdToElements( );
        Object[] table = mofIdToElements.table;
        int len = table.length;

        // write size information
        this.writeArraySize( dumpBuf, len );
        dumpBuf.put( mofIdToElements.size( ) );

        // write entries
        int counter = 0;
        Object item = null;
        IndexMofId mofId = null;
        IndexMofId typeMofId = null;
        Object[] array = null;
        IndexNamedModelElement namedElem = null;
        IndexModelElement elem = null;
        for ( int i = 0; i < len; ++i ) {
            if ( table[i] != null ) {
                dumpBuf.put( i );
                item = table[i];
                if ( item instanceof IndexHashSetElement ) {
                    if ( item instanceof IndexNamedModelElement ) {
                        dumpBuf.put( TYPE_NAMED_ELEM );
                        namedElem = (IndexNamedModelElement) item;
                        // write mofId
                        mofId = namedElem.mofId;
                        this.writeIndexMofId( dumpBuf, mofId );
                        // write TYPE mofId
                        typeMofId = namedElem.typeMofId;
                        int pos = mofIdToElements.getPositionInTable( typeMofId );
                        dumpBuf.put( pos );
                        if ( pos >= i ) { // dump if mofid may not be in table
                            this.writeIndexMofId( dumpBuf, typeMofId );
                        }
                        // write pri
                        dumpBuf.put( priToIndexPri.getPositionInTable( namedElem.pri ) );
                        // write name
                        dumpBuf.put( namedElem.name );
                    } else {
                        dumpBuf.put( TYPE_ELEMENT );
                        elem = (IndexModelElement) item;
                        // write Mofid
                        mofId = elem.mofId;
                        this.writeIndexMofId( dumpBuf, mofId );
                        // write TYPE mofId
                        typeMofId = elem.typeMofId;
                        int pos = mofIdToElements.getPositionInTable( typeMofId );
                        dumpBuf.put( pos );
                        if ( pos >= i ) { // dump if mofid may not be in table
                            this.writeIndexMofId( dumpBuf, typeMofId );
                        }
                        // write pri
                        dumpBuf.put( priToIndexPri.getPositionInTable( elem.pri ) );
                    }
                } else if ( item instanceof Object[] ) {
                    dumpBuf.put( TYPE_ARRAY );
                    array = (Object[]) item;
                    // write mofId
                    mofId = ( (IndexModelElement) array[0] ).mofId;
                    this.writeIndexMofId( dumpBuf, mofId );
                    // write array size
                    this.writeArraySize( dumpBuf, array.length );
                    // write entries
                    for ( int j = 0; j < array.length; ++j ) {
                        if ( array[j] instanceof IndexNamedModelElement ) {
                            dumpBuf.put( TYPE_NAMED_ELEM );
                            namedElem = (IndexNamedModelElement) array[j];
                            // write TYPE mofid
                            typeMofId = namedElem.typeMofId;
                            int pos = mofIdToElements.getPositionInTable( typeMofId );
                            dumpBuf.put( pos );
                            if ( pos >= i ) { // dump if mofid may not be in table
                                this.writeIndexMofId( dumpBuf, typeMofId );
                            }
                            // write pri
                            dumpBuf.put( priToIndexPri.getPositionInTable( namedElem.pri ) );
                            // write name
                            dumpBuf.put( namedElem.name );
                        } else {
                            dumpBuf.put( TYPE_ELEMENT );
                            elem = (IndexModelElement) array[j];
                            // write TYPE mofId
                            typeMofId = elem.typeMofId;
                            int pos = mofIdToElements.getPositionInTable( typeMofId );
                            dumpBuf.put( pos );
                            if ( pos >= i ) { // dump if mofid may not be in table
                                this.writeIndexMofId( dumpBuf, typeMofId );
                            }
                            // write pri
                            dumpBuf.put( priToIndexPri.getPositionInTable( elem.pri ) );
                        }
                    }
                } else { // MOFID
                    dumpBuf.put( TYPE_MOFID );
                    mofId = ( (IndexWeakHashReference<IndexMofId>) item ).get( );
                    if ( mofId != null ) {
                        this.writeIndexMofId( dumpBuf, mofId );
                    } else { // fake mof id (may occur when garbage collector is active during dump)
                        dumpBuf.put( (long) -1 );
                        dumpBuf.put( -1 );
                        dumpBuf.put( (long) -1 );
                    }
                }
                ++counter;
            }
        }

        if ( counter != mofIdToElements.size( ) ) {
            throw new IndexBugException( IndexAbstractDumpedConstants.ENTRY_NUMBERS_INCORRECT, "MofIdToElements", mofIdToElements.size( ), counter ); //$NON-NLS-1$
        }
    }

    private void dumpPriToElements( DumpWriteBuffer dumpBuf ) throws IOException {

        IndexHashSetDuplicates<IndexModelElement, IndexMofId> mofIdToElements = this.index.getMofIdToElements( );
        IndexHashSetLists<IndexModelElement> priToElements = this.index.getPriToElements( );
        Object[] table = priToElements.table;
        int len = table.length;

        // write size information
        this.writeArraySize( dumpBuf, len );
        dumpBuf.put( priToElements.size( ) );

        // write entries
        int counter = 0;
        Object[] entry = null;
        for ( int i = 0; i < len; ++i ) {
            if ( table[i] != null ) {
                dumpBuf.put( i );
                entry = (Object[]) table[i];
                int l = entry.length;
                this.writeArraySize( dumpBuf, l );
                for ( int j = 0; j < l; ++j ) {
                    dumpBuf.put( mofIdToElements.getCorrectElementPosition( (IndexModelElement) entry[j] ) );
                }
                ++counter;
            }
        }

        if ( counter != priToElements.size( ) ) {
            throw new IndexBugException( IndexAbstractDumpedConstants.ENTRY_NUMBERS_INCORRECT, "priToElements", priToElements.size( ), counter ); //$NON-NLS-1$
        }
    }

    private void dumpTypeToInstances( DumpWriteBuffer dumpBuf ) throws IOException {

        IndexHashSetDuplicates<IndexModelElement, IndexMofId> mofIdToElements = this.index.getMofIdToElements( );
        IndexHashSetFastLists<IndexModelElement> typeToInstances = this.index.getTypeToInstances( );
        Object[] table = typeToInstances.table;
        int len = table.length;

        // write size information
        this.writeArraySize( dumpBuf, len );
        dumpBuf.put( typeToInstances.size( ) );

        // write entries
        int counter = 0;
        Object[][] entry = null;
        int entryLen = 0;
        for ( int i = 0; i < len; ++i ) {
            if ( table[i] != null ) {
                dumpBuf.put( i );
                entry = (Object[][]) table[i];
                entryLen = typeToInstances.sizeOfEntryAtPos( i );
                this.writeArraySize( dumpBuf, entryLen );
                for ( int j = 0; j < entryLen; ++j ) {
                    dumpBuf.put( mofIdToElements.getCorrectElementPosition( (IndexModelElement) entry[j >> IndexHashSetFastLists.X_SHIFT][j & IndexHashSetFastLists.X_MASK] ) );
                }
                ++counter;
            }
        }

        if ( counter != typeToInstances.size( ) ) {
            throw new IndexBugException( IndexAbstractDumpedConstants.ENTRY_NUMBERS_INCORRECT, "typeToInstances", typeToInstances.size( ), counter ); //$NON-NLS-1$
        }

    }

    private void dumpLocMofIdToLinkRecords( DumpWriteBuffer dumpBuf ) throws IOException {

        IndexHashSetDuplicates<IndexModelElement, IndexMofId> mofIdToElements = this.index.getMofIdToElements( );
        IndexHashSetSingle<IndexPri> priToIndexPri = this.index.getPriToIndexPri( );
        IndexHashSetTwoKey<IndexLinkRecord> locMofIdToLr = this.index.getLocalMofIdToLinkRecords( );
        Object[] table = locMofIdToLr.table;
        int len = table.length;

        // write size information
        this.writeArraySize( dumpBuf, len );
        dumpBuf.put( locMofIdToLr.size( ) );

        // write entries
        Object[][] entry = null;
        Object[] array = null;
        IndexLinkRecord lr = null;
        int counter = 0;
        for ( int i = 0; i < len; ++i ) {
            if ( table[i] != null ) {
                dumpBuf.put( i );
                entry = (Object[][]) table[i];
                // write mofId
                dumpBuf.put( mofIdToElements.getPositionInTable( ( (IndexLinkRecord) entry[0][0] ).mofIdOfLocalEnd ) );
                this.writeArraySize( dumpBuf, entry.length );
                for ( int j = 0; j < entry.length; ++j ) {
                    // write link type mofid
                    array = entry[j];
                    dumpBuf.put( mofIdToElements.getPositionInTable( ( (IndexLinkRecord) array[0] ).typeMofId ) );
                    this.writeArraySize( dumpBuf, array.length );
                    for ( int k = 0; k < array.length; ++k ) {
                        lr = (IndexLinkRecord) array[k];
                        dumpBuf.put( mofIdToElements.getPositionInTable( lr.mofIdOfExternalEnd ) );
                        dumpBuf.put( lr.numOfAssocEndOfLocalEnd );
                        dumpBuf.put( lr.dataAreaOfExternalEnd );
                        dumpBuf.put( priToIndexPri.getPositionInTable( lr.idxPri ) );
                    }
                }
                ++counter;
            }
        }

        if ( counter != locMofIdToLr.size( ) ) {
            throw new IndexBugException( IndexAbstractDumpedConstants.ENTRY_NUMBERS_INCORRECT, "locMofIdToLr", locMofIdToLr.size( ), counter ); //$NON-NLS-1$
        }
    }

    private void dumpExtToLinkRecords( DumpWriteBuffer dumpBuf ) throws IOException {

        IndexHashSetTwoKey<IndexLinkRecord> locMofIdToLr = this.index.getLocalMofIdToLinkRecords( );
        IndexHashSetTwoKey<IndexLinkRecord> extMofIdToLr = this.index.getExtMofIdToLinkRecords( );
        Object[] table = extMofIdToLr.table;
        int len = table.length;

        // write size info
        this.writeArraySize( dumpBuf, len );
        dumpBuf.put( extMofIdToLr.size( ) );

        // write entries
        Object[][] entry = null;
        int[] posArray = new int[3];
        int counter = 0;
        for ( int i = 0; i < len; ++i ) {
            if ( table[i] != null ) {
                dumpBuf.put( i );
                entry = (Object[][]) table[i];
                this.writeArraySize( dumpBuf, entry.length );
                for ( int j = 0; j < entry.length; ++j ) {
                    this.writeArraySize( dumpBuf, entry[j].length );
                    for ( int k = 0; k < entry[j].length; ++k ) {
                        if ( !locMofIdToLr.getCorrectElementPosition( (IndexLinkRecord) entry[j][k], posArray ) ) {
                            throw new IndexBugException( IndexAbstractDumpedConstants.POSITION_NOT_FOUND, (IndexLinkRecord) entry[j][k] );
                        }
                        dumpBuf.put( posArray[0] );
                        dumpBuf.put( posArray[1] );
                        dumpBuf.put( posArray[2] );
                    }
                }
                ++counter;
            }
        }
        if ( counter != extMofIdToLr.size( ) ) {
            throw new IndexBugException( IndexAbstractDumpedConstants.ENTRY_NUMBERS_INCORRECT, "extMofIdToLr", extMofIdToLr.size( ), counter ); //$NON-NLS-1$
        }
    }

    private void dumpPriToLinkRecords( DumpWriteBuffer dumpBuf ) throws IOException {

        IndexHashSetTwoKey<IndexLinkRecord> locMofIdToLr = this.index.getLocalMofIdToLinkRecords( );
        IndexHashSetLists<IndexLinkRecord> priToLr = this.index.getPriToLinkRecords( );
        Object[] table = priToLr.table;
        int len = table.length;

        // write size info
        this.writeArraySize( dumpBuf, len );
        dumpBuf.put( priToLr.size( ) );

        // write entries
        Object[] item = null;
        int[] posArray = new int[3];
        int counter = 0;
        for ( int i = 0; i < len; ++i ) {
            if ( table[i] != null ) {
                dumpBuf.put( i );
                item = (Object[]) table[i];
                int itemLen = item.length;
                this.writeArraySize( dumpBuf, itemLen );
                for ( int j = 0; j < itemLen; ++j ) {
                    if ( !locMofIdToLr.getCorrectElementPosition( (IndexLinkRecord) item[j], posArray ) ) {
                        throw new IndexBugException( IndexAbstractDumpedConstants.POSITION_NOT_FOUND, (IndexLinkRecord) item[j] );
                    }
                    dumpBuf.put( posArray[0] );
                    dumpBuf.put( posArray[1] );
                    dumpBuf.put( posArray[2] );
                }
                ++counter;
            }
        }
        if ( counter != priToLr.size( ) ) {
            throw new IndexBugException( IndexAbstractDumpedConstants.ENTRY_NUMBERS_INCORRECT, "priToLr", priToLr.size( ), counter ); //$NON-NLS-1$
        }
    }

    private void dumpTopLevelPkg( DumpWriteBuffer dumpBuf ) throws IOException {

        IndexHashSetDuplicates<IndexModelElement, IndexMofId> mofIdToElements = this.index.getMofIdToElements( );
        IndexHashSetSingle<IndexNamedModelElement> topLevelPkg = this.index.getTopLevelPackages_( );
        Object[] table = topLevelPkg.table;
        int len = table.length;

        // write size info
        this.writeArraySize( dumpBuf, len );
        dumpBuf.put( topLevelPkg.size( ) );

        // write entries
        int counter = 0;
        for ( int i = 0; i < len; ++i ) {
            if ( table[i] != null ) {
                dumpBuf.put( i );
                dumpBuf.put( mofIdToElements.getCorrectElementPosition( (IndexModelElement) table[i] ) );
                ++counter;
            }
        }
        if ( counter != topLevelPkg.size( ) ) {
            throw new IndexBugException( IndexAbstractDumpedConstants.ENTRY_NUMBERS_INCORRECT, "topLevelPkg", topLevelPkg.size( ), counter ); //$NON-NLS-1$
        }
    }

    private void dumpDaDCToPri( DumpWriteBuffer dumpBuf ) throws IOException {

        IndexHashSetSingle<IndexPri> priToIndexPri = this.index.getPriToIndexPri( );
        IndexHashSetTwoKey<IndexPri> daToPri = this.index.getDaToDcToIndexPris( );
        Object[] table = daToPri.table;
        int len = table.length;

        // write size information
        this.writeArraySize( dumpBuf, len );
        dumpBuf.put( daToPri.size( ) );

        // write entries
        int counter = 0;
        Object[][] item = null;
        for ( int i = 0; i < len; i++ ) {
            if ( table[i] != null ) {
                dumpBuf.put( i );
                item = (Object[][]) table[i];
                this.writeArraySize( dumpBuf, item.length );
                for ( int j = 0; j < item.length; ++j ) {
                    this.writeArraySize( dumpBuf, item[j].length );
                    for ( int k = 0; k < item[j].length; ++k ) {
                        dumpBuf.put( priToIndexPri.getPositionInTable( item[j][k] ) );
                    }
                }
                ++counter;
            }
        }
        if ( counter != daToPri.size( ) ) {
            throw new IndexBugException( IndexAbstractDumpedConstants.ENTRY_NUMBERS_INCORRECT, "daToPri", daToPri.size( ), counter ); //$NON-NLS-1$
        }
    }

    // ###############################################################
    // ###################### Index Read Section #####################
    // ###############################################################

    public abstract boolean load( );

    protected void loadInternal( DumpReadBuffer dumpBuf ) throws IOException, FileNotFoundException {

        int dumpVersion = dumpBuf.getInt( );
        if ( dumpVersion != versionId ) {
            throw new MoinLocalizedBaseRuntimeException( IndexAbstractDumpedConstants.DUMP_VERSION_INCOMPATIBLE, versionId, dumpVersion );
        }

        IndexHashSetSingle<IndexPri> priToIndexPri = this.loadPriToIndexPri( dumpBuf );
        IndexHashSetDuplicates<IndexModelElement, IndexMofId> mofIdToElements = this.loadMofIdToElements( dumpBuf, priToIndexPri.table );
        IndexHashSetLists<IndexModelElement> priToElements = this.loadPriToElements( dumpBuf, mofIdToElements.table );
        IndexHashSetFastLists<IndexModelElement> typeToElements = this.loadTypeToInstances( dumpBuf, mofIdToElements.table );
        IndexHashSetTwoKey<IndexLinkRecord> locMofIdToLinkRecords = this.loadLocMofIdToLinkRecords( dumpBuf, mofIdToElements.table, priToIndexPri.table );
        IndexHashSetTwoKey<IndexLinkRecord> extMofIdToLinkRecords = this.loadExtToLinkRecords( dumpBuf, locMofIdToLinkRecords.table );
        IndexHashSetLists<IndexLinkRecord> priToLinkRecords = this.loadPriToLinkRecords( dumpBuf, locMofIdToLinkRecords.table );
        IndexHashSetSingle<IndexNamedModelElement> topLevelPkg = this.loadTopLevelPkg( dumpBuf, mofIdToElements.table );
        IndexHashSetTwoKey<IndexPri> daToDcToIndexPris = this.loadDaDcToPri( dumpBuf, priToIndexPri.table );
        this.convertMofIdToWeakReferences( mofIdToElements.table, mofIdToElements.getReferenceQueue( ) );

        index.priToIndexPri = priToIndexPri;
        index.mofIdToElements = mofIdToElements;
        index.priToElements = priToElements;
        index.typeToInstances = typeToElements;
        index.localMofIdToLinkRecords = locMofIdToLinkRecords;
        index.extMofIdToLinkRecords = extMofIdToLinkRecords;
        index.priToLinkRecords = priToLinkRecords;
        index.topLevelPackages = topLevelPkg;
        index.daToDcsToIndexPris = daToDcToIndexPris;
    }

    private IndexHashSetSingle<IndexPri> loadPriToIndexPri( DumpReadBuffer dumpBuf ) throws IOException {

        int len = this.readArraySize( dumpBuf );
        int count = dumpBuf.getInt( );

        Object[] table = new Object[len];

        int pos;
        String priString = null;
        IndexPri idxPri = null;
        long timestamp;
        byte states;
        for ( int i = 0; i < count; i++ ) {
            pos = dumpBuf.getInt( );
            priString = dumpBuf.getString( );
            timestamp = dumpBuf.getLong( );
            states = dumpBuf.getByte( );
            PRI pri = this.riFactory.createPri( priString );
            idxPri = this.createIndexPri( pri, timestamp, states, dumpBuf );
            table[pos] = idxPri;
        }

        return new IndexHashSetSingle<IndexPri>( IndexPri.PRI, table, count );
    }

    protected IndexPri createIndexPri( PRI pri, long timestamp, byte states, DumpReadBuffer dumpBuf ) throws IOException {

        return new IndexPri( pri, timestamp, states );
    }

    private IndexHashSetDuplicates<IndexModelElement, IndexMofId> loadMofIdToElements( DumpReadBuffer dumpBuf, Object[] priToIndexPri ) throws IOException {

        final Object[] pris = priToIndexPri;

        int len = this.readArraySize( dumpBuf );
        int count = dumpBuf.getInt( );

        Object[] table = new Object[len];

        int pos;
        byte type;
        byte typeInArray;
        IndexMofId mofId = null;
        IndexMofId typeMofId = null;
        IndexPri idxPri = null;
        Object tableItem = null;
        IndexModelElement ime = null;
        String name;
        int arraySize;
        IndexHashSetElement[] array = null;
        int typePos;
        for ( int i = 0; i < count; i++ ) {
            pos = dumpBuf.getInt( );
            type = dumpBuf.getByte( );
            mofId = this.readIndexMofId( dumpBuf );

            switch ( type ) {
                case TYPE_MOFID: {
                    if ( table[pos] == null ) {
                        table[pos] = mofId; // NO WeakReference since there may be no other referrers yet
                    }
                    continue;
                }
                case TYPE_ELEMENT: {
                    typePos = dumpBuf.getInt( );

                    // get type MofId
                    if ( typePos >= pos ) { // type id not yet in table?
                        typeMofId = this.readIndexMofId( dumpBuf );

                        if ( table[typePos] == null ) {
                            table[typePos] = typeMofId;
                        } else {
                            tableItem = table[typePos];
                            if ( tableItem instanceof IndexModelElement ) {
                                typeMofId = ( (IndexModelElement) tableItem ).mofId;
                            } else if ( tableItem instanceof Object[] ) {
                                typeMofId = ( (IndexModelElement) ( (Object[]) tableItem )[0] ).mofId;
                            } else {
                                typeMofId = (IndexMofId) tableItem;
                            }
                        }
                    } else { // get typeMofId from the table
                        tableItem = table[typePos];
                        if ( tableItem instanceof IndexModelElement ) {
                            typeMofId = ( (IndexModelElement) tableItem ).mofId;
                        } else if ( tableItem instanceof Object[] ) {
                            typeMofId = ( (IndexModelElement) ( (Object[]) tableItem )[0] ).mofId;
                        } else {
                            typeMofId = (IndexMofId) tableItem;
                        }
                    }

                    idxPri = (IndexPri) pris[dumpBuf.getInt( )];
                    if ( table[pos] != null ) {
                        mofId = (IndexMofId) table[pos];
                    }
                    if ( typePos == pos ) {
                        typeMofId = mofId;
                    }

                    ime = new IndexModelElement( mofId, typeMofId, idxPri );
                    table[pos] = ime;
                    continue;
                }
                case TYPE_NAMED_ELEM: {
                    typePos = dumpBuf.getInt( );

                    // get type MofId
                    if ( typePos >= pos ) { // type id not yet in table?
                        typeMofId = this.readIndexMofId( dumpBuf );

                        if ( table[typePos] == null ) {
                            table[typePos] = typeMofId;
                        } else {
                            tableItem = table[typePos];
                            if ( tableItem instanceof IndexModelElement ) {
                                typeMofId = ( (IndexModelElement) tableItem ).mofId;
                            } else if ( tableItem instanceof Object[] ) {
                                typeMofId = ( (IndexModelElement) ( (Object[]) tableItem )[0] ).mofId;
                            } else {
                                typeMofId = (IndexMofId) tableItem;
                            }
                        }
                    } else { // get typeMofId from the table
                        tableItem = table[typePos];
                        if ( tableItem instanceof IndexModelElement ) {
                            typeMofId = ( (IndexModelElement) tableItem ).mofId;
                        } else if ( tableItem instanceof Object[] ) {
                            typeMofId = ( (IndexModelElement) ( (Object[]) tableItem )[0] ).mofId;
                        } else {
                            typeMofId = (IndexMofId) tableItem;
                        }
                    }

                    idxPri = (IndexPri) pris[dumpBuf.getInt( )];
                    name = dumpBuf.getString( );

                    if ( table[pos] != null ) {
                        mofId = (IndexMofId) table[pos];
                    }
                    if ( typePos == pos ) {
                        typeMofId = mofId;
                    }

                    ime = new IndexNamedModelElement( mofId, typeMofId, idxPri, name );
                    table[pos] = ime;
                    continue;
                }
                case TYPE_ARRAY: {

                    // It may be that an entry is its own type. If the first entry is of another type
                    // it is saved with this mofId instance. If the second is the type of itself, it
                    // adds a new mofId instance to the table, so there would be two mofid instances.
                    // Therefore the mofId is first added for type requests to the table.
                    if ( table[pos] != null ) {
                        mofId = (IndexMofId) table[pos];
                    } else {
                        table[pos] = mofId;
                    }

                    arraySize = this.readArraySize( dumpBuf );
                    array = new IndexHashSetElement[arraySize];
                    for ( int j = 0; j < arraySize; j++ ) {
                        typeInArray = dumpBuf.getByte( );
                        typePos = dumpBuf.getInt( );
                        switch ( typeInArray ) {
                            case TYPE_ELEMENT: {
                                // get type MofId
                                if ( typePos >= pos ) { // type id not yet in table?
                                    typeMofId = this.readIndexMofId( dumpBuf );

                                    if ( table[typePos] == null ) {
                                        table[typePos] = typeMofId;
                                    } else {
                                        tableItem = table[typePos];
                                        if ( tableItem instanceof IndexModelElement ) {
                                            typeMofId = ( (IndexModelElement) tableItem ).mofId;
                                        } else if ( tableItem instanceof Object[] ) {
                                            typeMofId = ( (IndexModelElement) ( (Object[]) tableItem )[0] ).mofId;
                                        } else {
                                            typeMofId = (IndexMofId) tableItem;
                                        }
                                    }
                                } else { // get typeMofId from the table
                                    tableItem = table[typePos];
                                    if ( tableItem instanceof IndexModelElement ) {
                                        typeMofId = ( (IndexModelElement) tableItem ).mofId;
                                    } else if ( tableItem instanceof Object[] ) {
                                        typeMofId = ( (IndexModelElement) ( (Object[]) tableItem )[0] ).mofId;
                                    } else {
                                        typeMofId = (IndexMofId) tableItem;
                                    }
                                }

                                idxPri = (IndexPri) pris[dumpBuf.getInt( )];
                                ime = new IndexModelElement( mofId, typeMofId, idxPri );
                                array[j] = ime;
                                continue;
                            }
                            case TYPE_NAMED_ELEM: {
                                // get type MofId
                                if ( typePos >= pos ) { // type id not yet in table?
                                    typeMofId = this.readIndexMofId( dumpBuf );

                                    if ( table[typePos] == null ) {
                                        table[typePos] = typeMofId;
                                    } else {
                                        tableItem = table[typePos];
                                        if ( tableItem instanceof IndexModelElement ) {
                                            typeMofId = ( (IndexModelElement) tableItem ).mofId;
                                        } else if ( tableItem instanceof Object[] ) {
                                            typeMofId = ( (IndexModelElement) ( (Object[]) tableItem )[0] ).mofId;
                                        } else {
                                            typeMofId = (IndexMofId) tableItem;
                                        }
                                    }
                                } else { // get typeMofId from the table
                                    tableItem = table[typePos];
                                    if ( tableItem instanceof IndexModelElement ) {
                                        typeMofId = ( (IndexModelElement) tableItem ).mofId;
                                    } else if ( tableItem instanceof Object[] ) {
                                        typeMofId = ( (IndexModelElement) ( (Object[]) tableItem )[0] ).mofId;
                                    } else {
                                        typeMofId = (IndexMofId) tableItem;
                                    }
                                }

                                idxPri = (IndexPri) pris[dumpBuf.getInt( )];
                                name = dumpBuf.getString( );

                                ime = new IndexNamedModelElement( mofId, typeMofId, idxPri, name );
                                array[j] = ime;
                                continue;
                            }
                            default:
                                throw new IndexBugException( IndexAbstractDumpedConstants.UNKNOWN_ELEMENT_TYPE, typeInArray );
                        }
                    }
                    table[pos] = array;
                    continue;
                }
                default:
                    throw new IndexBugException( IndexAbstractDumpedConstants.UNKNOWN_ELEMENT_TYPE, type );
            }
        }

        return new IndexHashSetDuplicates<IndexModelElement, IndexMofId>( IndexModelElement.MOF_ID, table, count );
        // remember: MofIds need to be converted to WeakHashReferences when all is loaded!
    }

    private IndexHashSetLists<IndexModelElement> loadPriToElements( DumpReadBuffer dumpBuf, Object[] mofIdToElements ) throws IOException {

        final Object[] elements = mofIdToElements;

        int len = this.readArraySize( dumpBuf );
        int count = dumpBuf.getInt( );

        Object[] table = new Object[len];

        int pos;
        int arraySize;
        int posInElementsTable1;
        int posInElementsTable2;
        Object tableItem = null;
        IndexHashSetElement[] array;
        IndexModelElement ime = null;
        for ( int i = 0; i < count; i++ ) {
            pos = dumpBuf.getInt( );
            arraySize = this.readArraySize( dumpBuf );
            array = new IndexHashSetElement[arraySize];

            for ( int j = 0; j < arraySize; j++ ) {
                posInElementsTable1 = dumpBuf.getInt( );
                posInElementsTable2 = dumpBuf.getInt( );
                tableItem = elements[posInElementsTable1];
                if ( tableItem instanceof IndexModelElement ) {
                    ime = (IndexModelElement) tableItem;
                } else {
                    ime = (IndexModelElement) ( (Object[]) tableItem )[posInElementsTable2];
                }
                array[j] = ime;
            }
            table[pos] = array;
        }

        return new IndexHashSetLists<IndexModelElement>( IndexModelElement.PRI, table, count );
    }

    private IndexHashSetFastLists<IndexModelElement> loadTypeToInstances( DumpReadBuffer dumpBuf, Object[] mofIdToElements ) throws IOException {

        final Object[] elements = mofIdToElements;

        int len = this.readArraySize( dumpBuf );
        int count = dumpBuf.getInt( );

        Object[] table = new Object[len];

        int pos;
        int arraySize;
        int posInElementsTable1;
        int posInElementsTable2;
        Object tableItem = null;
        IndexModelElement ime = null;
        IndexHashSetElement[][] array;
        for ( int i = 0; i < count; i++ ) {
            pos = dumpBuf.getInt( );
            arraySize = this.readArraySize( dumpBuf );
            array = new IndexHashSetElement[( ( arraySize - 1 ) >> IndexHashSetFastLists.X_SHIFT ) + 1][];
            for ( int j = 0; j < array.length; ++j ) {
                if ( j != array.length - 1 ) {
                    array[j] = new IndexHashSetElement[IndexHashSetFastLists.DEFAULT_X_SIZE];
                } else {
                    array[j] = new IndexHashSetElement[( arraySize - 1 & IndexHashSetFastLists.X_MASK ) + 1];
                }
            }

            for ( int j = 0; j < arraySize; j++ ) {
                posInElementsTable1 = dumpBuf.getInt( );
                posInElementsTable2 = dumpBuf.getInt( );
                tableItem = elements[posInElementsTable1];
                if ( tableItem instanceof IndexModelElement ) {
                    ime = (IndexModelElement) tableItem;
                } else {
                    ime = (IndexModelElement) ( (Object[]) tableItem )[posInElementsTable2];
                }
                array[j >> IndexHashSetFastLists.X_SHIFT][j & IndexHashSetFastLists.X_MASK] = ime;
            }
            table[pos] = array;
        }

        return new IndexHashSetFastLists<IndexModelElement>( IndexModelElement.TYPE_MOF_ID, table, count );
    }

    private IndexHashSetTwoKey<IndexLinkRecord> loadLocMofIdToLinkRecords( DumpReadBuffer dumpBuf, Object[] mofIdToElements, Object[] priToIndexPri ) throws IOException {

        final Object[] mofIds = mofIdToElements;
        final Object[] pris = priToIndexPri;

        int len = this.readArraySize( dumpBuf );
        int count = dumpBuf.getInt( );

        Object[] table = new Object[len];

        int pos;
        int typeLen;
        int lrLen;
        Object tableItem = null;
        IndexHashSetElement[][] arrays = null;
        IndexMofId mofId = null;
        IndexMofId typeMofId = null;
        IndexMofId extMofId = null;
        IndexPri idxPri = null;
        String daName = null;
        byte storageEnd;
        for ( int i = 0; i < count; i++ ) {
            pos = dumpBuf.getInt( );

            // get MofId
            tableItem = mofIds[dumpBuf.getInt( )];
            if ( tableItem instanceof IndexModelElement ) {
                mofId = ( (IndexModelElement) tableItem ).mofId;
            } else if ( tableItem instanceof Object[] ) {
                mofId = ( (IndexModelElement) ( (Object[]) tableItem )[0] ).mofId;
            } else {
                mofId = (IndexMofId) tableItem;
            }

            typeLen = this.readArraySize( dumpBuf );
            arrays = new IndexHashSetElement[typeLen][];

            for ( int j = 0; j < typeLen; j++ ) {
                // get TypeMofId
                tableItem = mofIds[dumpBuf.getInt( )];
                if ( tableItem instanceof IndexModelElement ) {
                    typeMofId = ( (IndexModelElement) tableItem ).mofId;
                } else if ( tableItem instanceof Object[] ) {
                    typeMofId = ( (IndexModelElement) ( (Object[]) tableItem )[0] ).mofId;
                } else {
                    typeMofId = (IndexMofId) tableItem;
                }

                lrLen = this.readArraySize( dumpBuf );
                arrays[j] = new IndexHashSetElement[lrLen];

                for ( int j2 = 0; j2 < lrLen; j2++ ) {
                    // get ExtMofId
                    tableItem = mofIds[dumpBuf.getInt( )];
                    if ( tableItem instanceof IndexModelElement ) {
                        extMofId = ( (IndexModelElement) tableItem ).mofId;
                    } else if ( tableItem instanceof Object[] ) {
                        extMofId = ( (IndexModelElement) ( (Object[]) tableItem )[0] ).mofId;
                    } else {
                        extMofId = (IndexMofId) tableItem;
                    }

                    storageEnd = dumpBuf.getByte( );
                    daName = dumpBuf.getString( ).intern( );
                    idxPri = (IndexPri) pris[dumpBuf.getInt( )];

                    arrays[j][j2] = new IndexLinkRecord( idxPri, mofId, typeMofId, storageEnd, extMofId, daName );
                }
            }
            table[pos] = arrays;
        }

        return new IndexHashSetTwoKey<IndexLinkRecord>( IndexLinkRecord.LOCAL_MOF_ID, IndexLinkRecord.TYPE_MOF_ID, table, count );
    }

    private IndexHashSetTwoKey<IndexLinkRecord> loadExtToLinkRecords( DumpReadBuffer dumpBuf, Object[] locMofIdToLinkRecords ) throws IOException {

        final Object[] linkRecords = locMofIdToLinkRecords;

        int len = this.readArraySize( dumpBuf );
        int count = dumpBuf.getInt( );

        Object[] table = new Object[len];

        int pos;
        int typeLen;
        int lrLen;
        int lrPos1;
        int lrPos2;
        int lrPos3;
        IndexHashSetElement[][] arrays = null;
        for ( int i = 0; i < count; i++ ) {
            pos = dumpBuf.getInt( );
            typeLen = this.readArraySize( dumpBuf );

            arrays = new IndexHashSetElement[typeLen][];

            for ( int j = 0; j < typeLen; j++ ) {
                lrLen = this.readArraySize( dumpBuf );
                arrays[j] = new IndexHashSetElement[lrLen];

                for ( int j2 = 0; j2 < lrLen; j2++ ) {
                    lrPos1 = dumpBuf.getInt( );
                    lrPos2 = dumpBuf.getInt( );
                    lrPos3 = dumpBuf.getInt( );
                    arrays[j][j2] = (IndexLinkRecord) ( (Object[][]) linkRecords[lrPos1] )[lrPos2][lrPos3];
                }
            }
            table[pos] = arrays;
        }

        return new IndexHashSetTwoKey<IndexLinkRecord>( IndexLinkRecord.EXT_MOF_ID, IndexLinkRecord.TYPE_MOF_ID, table, count );
    }

    private IndexHashSetLists<IndexLinkRecord> loadPriToLinkRecords( DumpReadBuffer dumpBuf, Object[] locMofIdToLinkRecords ) throws IOException {

        final Object[] linkRecords = locMofIdToLinkRecords;

        int len = this.readArraySize( dumpBuf );
        int count = dumpBuf.getInt( );

        Object[] table = new Object[len];

        int pos;
        int lrLen;
        int lrPos1;
        int lrPos2;
        int lrPos3;
        IndexHashSetElement[] array = null;
        for ( int i = 0; i < count; i++ ) {
            pos = dumpBuf.getInt( );

            lrLen = this.readArraySize( dumpBuf );
            array = new IndexHashSetElement[lrLen];

            for ( int j = 0; j < lrLen; j++ ) {
                lrPos1 = dumpBuf.getInt( );
                lrPos2 = dumpBuf.getInt( );
                lrPos3 = dumpBuf.getInt( );
                array[j] = (IndexLinkRecord) ( (Object[][]) linkRecords[lrPos1] )[lrPos2][lrPos3];
            }

            table[pos] = array;
        }

        return new IndexHashSetLists<IndexLinkRecord>( IndexLinkRecord.PRI, table, count );
    }

    private IndexHashSetSingle<IndexNamedModelElement> loadTopLevelPkg( DumpReadBuffer dumpBuf, Object[] mofIdToElements ) throws IOException {

        final Object[] elements = mofIdToElements;

        int len = this.readArraySize( dumpBuf );
        int count = dumpBuf.getInt( );

        Object[] table = new Object[len];

        int pos;
        int elemPos1;
        int elemPos2;
        Object tableItem = null;
        for ( int i = 0; i < count; i++ ) {
            pos = dumpBuf.getInt( );
            elemPos1 = dumpBuf.getInt( );
            elemPos2 = dumpBuf.getInt( );

            tableItem = elements[elemPos1];
            if ( tableItem instanceof IndexNamedModelElement ) {
                table[pos] = tableItem;
            } else { // array
                table[pos] = ( (Object[]) elements[elemPos1] )[elemPos2];
            }
        }

        return new IndexHashSetSingle<IndexNamedModelElement>( IndexNamedModelElement.MOF_ID, table, count );
    }

    private IndexHashSetTwoKey<IndexPri> loadDaDcToPri( DumpReadBuffer dumpBuf, Object[] priToIndexPri ) throws IOException {

        final Object[] pris = priToIndexPri;

        int len = this.readArraySize( dumpBuf );
        int count = dumpBuf.getInt( );

        Object[] table = new Object[len];

        int pos;
        int dcLen;
        int priLen;
        IndexHashSetElement[][] arrays = null;
        for ( int i = 0; i < count; i++ ) {
            pos = dumpBuf.getInt( );
            dcLen = this.readArraySize( dumpBuf );

            arrays = new IndexHashSetElement[dcLen][];

            for ( int j = 0; j < dcLen; j++ ) {
                priLen = this.readArraySize( dumpBuf );
                arrays[j] = new IndexHashSetElement[priLen];

                for ( int j2 = 0; j2 < priLen; j2++ ) {
                    arrays[j][j2] = (IndexPri) pris[dumpBuf.getInt( )];
                }
            }
            table[pos] = arrays;
        }

        return new IndexHashSetTwoKey<IndexPri>( IndexPri.DA, IndexPri.DC, table, count );
    }

    private void convertMofIdToWeakReferences( Object[] mofIdToElements, ReferenceQueue<IndexMofId> refQueue ) {

        final Object[] elements = mofIdToElements;
        int len = elements.length;

        for ( int i = 0; i < len; i++ ) {
            if ( elements[i] != null ) {
                if ( elements[i] instanceof IndexMofId ) {
                    elements[i] = new IndexWeakHashReference<IndexMofId>( (IndexMofId) elements[i], refQueue, i );
                }
            }
        }
    }

    private void writeIndexMofId( DumpWriteBuffer dumpBuf, IndexMofId mId ) throws IOException {

        IndexMofIdPrimary mIdP = (IndexMofIdPrimary) mId;
        dumpBuf.put( mIdP.getFirst( ) );
        dumpBuf.put( mIdP.getSecond( ) );
        dumpBuf.put( mIdP.getThird( ) );
    }

    private IndexMofId readIndexMofId( DumpReadBuffer dumpBuf ) throws IOException {

        long f = dumpBuf.getLong( );
        int s = dumpBuf.getInt( );
        long t = dumpBuf.getLong( );
        return new IndexMofIdPrimary( f, s, t );
    }

    protected void writeArraySize( DumpWriteBuffer dumpBuf, int size ) throws IOException {

        dumpBuf.put( IndexAbstractDumpedConstants.ARRAY_SIZE_START );
        dumpBuf.put( size );
        dumpBuf.put( IndexAbstractDumpedConstants.ARRAY_SIZE_END );
    }

    protected int readArraySize( DumpReadBuffer dumpBuf ) throws IOException {

        int sign;
        if ( ( sign = dumpBuf.getInt( ) ) != IndexAbstractDumpedConstants.ARRAY_SIZE_START ) {
            throw new IndexBugException( IndexAbstractDumpedConstants.ARRAY_SIZE_START_ERROR, IndexAbstractDumpedConstants.ARRAY_SIZE_START, sign );
        }
        int result = dumpBuf.getInt( );
        if ( ( sign = dumpBuf.getInt( ) ) != IndexAbstractDumpedConstants.ARRAY_SIZE_END ) {
            throw new IndexBugException( IndexAbstractDumpedConstants.ARRAY_SIZE_END_ERROR, IndexAbstractDumpedConstants.ARRAY_SIZE_END, sign );
        }
        return result;
    }
}
