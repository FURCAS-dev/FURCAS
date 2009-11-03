package com.sap.tc.moin.repository.core.jmi.util;


public class VersionImpl implements com.sap.tc.moin.repository.Version {

    private int major;

    private int minor;

    public VersionImpl( int major, int minor ) {

        this.major = major;
        this.minor = minor;
    }

    public int getMajor( ) {

        return major;
    }

    public int getMinor( ) {

        return minor;
    }

    @Override
    public String toString( ) {

        return major + "." + minor; //$NON-NLS-1$
    }

}
