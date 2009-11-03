package com.sap.tc.moin.facility.primary.query.index.memory;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;

/**
 * The IndexPri is the index-internal representation of a {@link PRI}. It wraps
 * the PRI and extends the information provided by PRI with a last modification
 * timestamp of the corresponding partition on the disk.<br>
 * IndexPri is sub-classed by {@link IndexDumpedPri}.
 * 
 * <pre>
 * Following tables refer IndexPri instances with mentioned keys:
 * 
 *  - daToDcsToIndexPris: data area name, container name
 *  - priToIndexPri: PRI string representation
 * </pre>
 * 
 * Furthermore, IndexPris are used in {@link IndexModelElement} and
 * {@link IndexLinkRecord}.
 * 
 * @author d048997
 */
public class IndexPri implements IndexHashSetElement {

    private static final String INACTIVE_DATA_AREA_NAME = "*inactive*"; //$NON-NLS-1$

    private static final byte INACTIVE = 126;

    private static final byte ACTIVE = 1;

    private static final byte DIFFERENT_CONTENT = 2;

    /* ###### Key Constants ###### */

    public static final int PRI = 0;

    public static final int DA = 1;

    public static final int DC = 2;

    /* ####### PRI content ####### */

    private long timestamp = -1; // last modification timestamp from partition file

    // held to prevent frequent calls to cachedPri.toString() (matter of taste, may be removed to save memory...)
    private final String priString; // interned string representation of PRI

    private final PRI cachedPRI;

    private byte states;

    /* ####### Methods ####### */

    public IndexPri( PRI pri, long timestamp, byte _states ) {

        this.cachedPRI = pri;
        this.priString = pri.toString( ); // no need to intern, coz done in PRI 
        this.timestamp = timestamp;
        this.states = _states;
    }

    public IndexPri( PRI pri, long timestamp ) {

        this( pri, timestamp, ACTIVE );
    }

    public byte getStates( ) {

        return this.states;
    }

    public void activate( ) {

        this.states |= ACTIVE;
    }

    public void deactivate( ) {

        this.states &= INACTIVE;
    }

    public PRI getCachedPri( ) {

        return this.cachedPRI;
    }

    public boolean isMetaModelPartition( ) {

        return this.cachedPRI.isMetaModelPartition( );
    }

    public boolean isActive( ) {

        return ( this.states & ACTIVE ) == ACTIVE;
    }

    public String getPriString( ) {

        return this.priString;
    }

    public String getDataAreaName( ) {

        return ( this.isActive( ) ) ? this.getRealDataAreaName( ) : INACTIVE_DATA_AREA_NAME;
    }

    public String getRealDataAreaName( ) {

        return this.cachedPRI.getDataAreaDescriptor( ).getDataAreaName( ); // already interned
    }

    public String getContainerName( ) {

        return this.cachedPRI.getContainerName( ); // already interned
    }

    public MRI createMri( IndexMofId idxMofId ) {

        return this.cachedPRI.createMri( idxMofId.toString( ) );
    }

    /*
     * Explicit getter and setter for timestamp since it is not final
     */
    public long getTimestamp( ) {

        return this.timestamp;
    }

    public void setTimestamp( long value ) {

        this.timestamp = value;
    }

    public void setDiffersFromPersistence( ) {

        this.states |= DIFFERENT_CONTENT;
    }

    public boolean isDifferentFromPersistence( ) {

        return ( this.states & DIFFERENT_CONTENT ) == DIFFERENT_CONTENT;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.facility.primary.query.index.memory.IndexHashSetElement
     * #getKeyElement(int)
     */
    public Object getKeyElement( int keyNr ) {

        switch ( keyNr ) {
            case PRI:
                return this.priString;
            case DC:
                return this.getContainerName( );
            case DA:
                return this.getRealDataAreaName( );
        }
        throw new IndexBugException( IndexMessages.UNKNOWN_KEY_ELEMENT_NUMBER, keyNr );
    }

    @Override
    public String toString( ) {

        return this.cachedPRI.toString( );
    }

    /**
     * Caution: hash code is not designed!
     */
    @Override
    public int hashCode( ) {

        return this.priString.hashCode( );
    }

    /**
     * Should not be used in index to compare instances! Use '==', since
     * instances must be unique.
     */
    @Override
    public boolean equals( Object obj ) {

        if ( obj == this ) {
            return true;
        }
        if ( !( obj instanceof IndexPri ) ) {
            return false;
        }
        IndexPri other = (IndexPri) obj;
        if ( this.timestamp == other.timestamp && this.priString == other.priString && this.states == other.states ) { //$JL-STRING$
            return true;
        }
        return false;
    }
}