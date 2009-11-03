package com.sap.tc.moin.repository.ide.metamodels;


public class MmExecutableInfo extends MmGenerationBaseInfo {

    private boolean mofCase;

    private boolean ignoreChecks;


    public MmExecutableInfo( String sourcePath, String containerName, boolean mofCase, boolean ignoreChecks ) {

        super( sourcePath, containerName );
        init( ignoreChecks, mofCase );

    }

    private void init( boolean ignoreChecks, boolean mofCase ) {

        this.mofCase = mofCase;
        this.ignoreChecks = ignoreChecks;
    }

    public final boolean isMofCase( ) {

        return mofCase;
    }

    public final boolean ignoreChecks( ) {

        return ignoreChecks;
    }
}
