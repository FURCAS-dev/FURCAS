/**
 * 
 */
package com.sap.tc.moin.facility.primary.query.index.memory;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;

/**
 * The IndexModelElement is the index-internal representation of a model
 * element.
 * 
 * <pre>
 * Following tables refer to IndexModelElements with the named attribute as key:
 * 
 *  - mofIdToElements: mofId
 *  - typeToInstances: typeMofId
 *  - priToElements: pri
 * </pre>
 * 
 * @author D048997
 */
public class IndexModelElement implements IndexHashSetElement {

    /* ######## Key Constants ######## */

    public static final int MOF_ID = 0;

    public static final int TYPE_MOF_ID = 1;

    public static final int PRI = 2;

    /* ######## Model Element Content ###### */

    public final IndexMofId typeMofId;

    public final IndexMofId mofId;

    public final IndexPri pri;

    /* ######## Methods ########## */

    public IndexModelElement( IndexMofId mofId, IndexMofId mmri, IndexPri pri ) {

        this.mofId = mofId;
        this.typeMofId = mmri;
        this.pri = pri;
    }

    /**
     * Returns the MRI for that model element
     * 
     * @return
     */
    public final MRI getMri( ) {

        return this.pri.createMri( this.mofId );
    }

    /**
     * Returns the name of the DataArea where the model elements resides.
     * 
     * @return
     */
    public final String getDataAreaName( ) {

        return this.pri.getDataAreaName( );
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.facility.primary.query.index.memory.IndexHashSetElement
     * #getKeyElement(int)
     */
    public Object getKeyElement( int keyNr ) {

        switch ( keyNr ) {
            case MOF_ID:
                return this.mofId;
            case TYPE_MOF_ID:
                return this.typeMofId;
            case PRI:
                return this.pri;
        }
        throw new IndexBugException( IndexMessages.UNKNOWN_KEY_ELEMENT_NUMBER, keyNr );
    }

    /**
     * Caution: hash code not designed!
     */
    @Override
    public int hashCode( ) {

        throw new MoinUnsupportedOperationException( IndexMessages.HASH_CODE_NOT_DESIGNED );
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
        if ( !( obj instanceof IndexModelElement ) ) {
            return false;
        }
        IndexModelElement other = (IndexModelElement) obj;
        return ( this.mofId.equals( other.mofId ) && this.pri.equals( other.pri ) && this.typeMofId.equals( other.typeMofId ) );
    }

    @Override
    public String toString( ) {

        return "MofId=" + this.mofId.toString( ) + "\nTypeMofId=" + this.typeMofId.toString( ) + "\nPRI=" + this.pri.toString( ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    }
}
