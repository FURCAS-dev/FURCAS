package com.sap.tc.moin.repository.runtimehost.deployment;

import com.sap.tc.moin.repository.metamodels.MetaModelVersion;

/**
 * Wraps the version of a meta-model. Instances of this class are immutable.
 */
public final class MetaModelVersionImpl implements MetaModelVersion {

    // Meta-model version
    private final String version;


    public MetaModelVersionImpl( String version ) {

        this.version = version;
    }

    /**
     * Returns the meta-model version (as string).
     */
    public String getVersionString( ) {

        return this.version;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString( ) {

        return this.version;
    }
}
