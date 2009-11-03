/**
 * 
 */
package com.sap.tc.moin.facility.primary.query.index.memory;

/**
 * An IndexLinkRecord represents a link. A link between model elements may have
 * one or two link records depending on if it is single or double stored. That's
 * the same way as it is stored in the partition files.
 * 
 * <pre>
 * Each IndexLinkRecord instance is referenced in the following hash tables. Each 
 * table uses the content of different member variables as key:
 * 
 *  - priToLinkRecords: idxPri
 *  - localMofIdToLinkRecords: mofIdOfLocalEnd, typeMofId
 *  - extMofIdToLinkRecords: mofIdOfExtEnd, typeMofId
 * </pre>
 * 
 * @author D048997
 */
public final class IndexLinkRecord implements IndexHashSetElement {

    /* ###### Key Constants ###### */

    public static final int PRI = 0;

    public static final int LOCAL_MOF_ID = 1;

    public static final int TYPE_MOF_ID = 2;

    public static final int EXT_MOF_ID = 3;

    /* ###### Member Variables ###### */

    public final IndexPri idxPri; // the partition where the link is stored

    public final IndexMofId mofIdOfLocalEnd; // the MofId of the participating element that is stored in the same partition as the link

    public final IndexMofId typeMofId; // the MofId of the association; the type of the link

    public final byte numOfAssocEndOfLocalEnd; // the number (0 or 1) of the association end that is typed with the element referenced by 'mofIdLocalEnd'  

    public final IndexMofId mofIdOfExternalEnd; // MofId of the element not stored with the link (in case of a cross link)

    public final String dataAreaOfExternalEnd; // The DataArea where the element lies that is referenced by 'mofIdOfExternalEnd'


    public IndexLinkRecord( IndexPri idxPri, IndexMofId mofIdOfLocalEnd, IndexMofId typeMofId, byte numOfAssocEndOfLocalEnd, IndexMofId mofIdOfExternalEnd, String dataAreaOfExternalEnd ) {

        this.idxPri = idxPri;
        this.mofIdOfLocalEnd = mofIdOfLocalEnd;
        this.typeMofId = typeMofId;
        this.numOfAssocEndOfLocalEnd = numOfAssocEndOfLocalEnd;
        this.mofIdOfExternalEnd = mofIdOfExternalEnd;
        this.dataAreaOfExternalEnd = dataAreaOfExternalEnd;
    }

    @Override
    public String toString( ) {

        return getClass( ).getName( ) + "\n localMofId=" + this.mofIdOfLocalEnd.toString( ) + "\n PRI=" + this.idxPri.getPriString( ) + "\n typeMofId=" + this.typeMofId.toString( ) + "\n storageEnd=" + this.numOfAssocEndOfLocalEnd + "\n extMofId=" + this.mofIdOfExternalEnd.toString( ) + "\n extDA=" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
               + this.dataAreaOfExternalEnd;
    }

    /**
     * Caution: Hash code is not designed!
     */
    @Override
    public int hashCode( ) {

        assert false : IndexMessages.HASH_CODE_NOT_DESIGNED;
        return -1;
    }

    /**
     * Should not be used in index to compare instances! Use '==', since
     * instances must be unique.
     */
    @Override
    public boolean equals( Object lr ) {

        if ( lr == this ) {
            return true;
        }
        if ( !( lr instanceof IndexLinkRecord ) ) {
            return false;
        }
        IndexLinkRecord ilr = (IndexLinkRecord) lr;
        return ( this.idxPri.equals( ilr.idxPri ) && this.mofIdOfLocalEnd.equals( ilr.mofIdOfLocalEnd ) && this.typeMofId.equals( ilr.typeMofId ) && this.numOfAssocEndOfLocalEnd == ilr.numOfAssocEndOfLocalEnd && this.mofIdOfExternalEnd.equals( ilr.mofIdOfExternalEnd ) && this.dataAreaOfExternalEnd == ilr.dataAreaOfExternalEnd ); //$JL-STRING$
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
                return this.idxPri;
            case LOCAL_MOF_ID:
                return this.mofIdOfLocalEnd;
            case TYPE_MOF_ID:
                return this.typeMofId;
            case EXT_MOF_ID:
                return this.mofIdOfExternalEnd;
        }
        throw new IndexBugException( IndexMessages.UNKNOWN_KEY_ELEMENT_NUMBER, keyNr );
    }
}