package com.sap.tc.moin.repository.core.impl;

import com.sap.tc.moin.repository.Version;

public class VersionImpl implements Version {

    private int major;

    private int minor;

    public VersionImpl( int major, int minor ) {

        super( );
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
