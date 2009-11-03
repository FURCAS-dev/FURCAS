/**
 * 
 */
package com.sap.tc.moin.facility.primary.query.index.memory;

import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;

/**
 * The IndexNamedModelElement is the index-internal representation of a model
 * element. It extends IndexModelElement and adds a new member attribute 'name'.
 * Named model elements are only used for top-level packages. The name of other
 * model elements is not required and would consume unnecessary memory. That's
 * why {@link IndexModelElement} is sub-classed.
 * 
 * <pre>
 * Following tables refer to IndexNamedModelElements with the specified attribute 
 * as key:
 * 
 *  - topLevelPackage: super().mofId
 * </pre>
 * 
 * @author D048997
 */
public class IndexNamedModelElement extends IndexModelElement {

    public String name; // name of the element

    public IndexNamedModelElement( IndexMofId mofId, IndexMofId mmri, IndexPri pri, String name ) {

        super( mofId, mmri, pri );
        this.name = name;
    }

    public void setName( String name ) {

        this.name = name;
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
        if ( !( obj instanceof IndexNamedModelElement ) ) {
            return false;
        }
        return ( super.equals( obj ) && ( (IndexNamedModelElement) obj ).name.equals( this.name ) );
    }

    /**
     * Caution: hash code not designed!
     */
    @Override
    public int hashCode( ) {

        throw new MoinUnsupportedOperationException( IndexMessages.HASH_CODE_NOT_DESIGNED );
    }

    @Override
    public String toString( ) {

        return super.toString( ) + "\nName=" + this.name; //$NON-NLS-1$
    }
}
