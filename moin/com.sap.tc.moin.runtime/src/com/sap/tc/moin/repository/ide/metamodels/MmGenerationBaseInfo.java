package com.sap.tc.moin.repository.ide.metamodels;


public class MmGenerationBaseInfo {

    private String containerName;

    private String sourcePath;



    public MmGenerationBaseInfo( String sourcePath, String containerName ) {

        this.containerName = containerName;
        this.sourcePath = sourcePath;
    }

    public final String getContainerName( ) {

        return this.containerName;
    }


    public final String getSourcePath( ) {

        return sourcePath;
    }
}
