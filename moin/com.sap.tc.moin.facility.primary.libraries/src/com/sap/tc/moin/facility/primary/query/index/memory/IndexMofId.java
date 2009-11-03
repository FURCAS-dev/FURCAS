package com.sap.tc.moin.facility.primary.query.index.memory;

/**
 * The interface for implementations representing MofIds in the index. Since the
 * index relies on uniqueness of IndexMofIds, this interface only requires
 * methods for hashing and the <code>toString()</code> method for returning
 * the string representation of the MofId.
 * 
 * @author D048997
 */
public interface IndexMofId {

    public boolean equals( Object mId );

    public String toString( );

    public int hashCode( );

    public long getFirst( );

    public int getSecond( );

    public long getThird( );
}
