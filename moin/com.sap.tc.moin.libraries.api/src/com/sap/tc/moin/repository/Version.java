package com.sap.tc.moin.repository;

/**
 * Represents a version which consists of a major and a minor version number.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @author D044711
 */
public interface Version {

    /**
     * Returns the major version number.
     * 
     * @return the major version number.
     */
    public int getMajor( );

    /**
     * Returns the minor version number.
     * 
     * @return the minor version number.
     */
    public int getMinor( );

    /**
     * Returns the string representation of this version. <br>
     * The format is:<br>
     * <code>major.minor</code>
     * 
     * @return the string representation.
     */
    public String toString( );
}
