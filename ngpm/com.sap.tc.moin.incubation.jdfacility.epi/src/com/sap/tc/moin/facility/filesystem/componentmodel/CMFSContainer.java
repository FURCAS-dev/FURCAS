package com.sap.tc.moin.facility.filesystem.componentmodel;

import java.util.Collection;
import java.util.Map;

import com.sap.tc.moin.facility.componentmodel.CMContainer;
import com.sap.tc.moin.facility.componentmodel.CMServices;
import com.sap.tc.moin.facility.componentmodel.CMUsageMode;
import com.sap.tc.moin.facility.filesystem.FileSystemFacility;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement.ContainerResourceRecord;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement.ResourceRecord;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.PRI;


public abstract class CMFSContainer extends CMContainer {

    static {
        CMFSServices.init( );
    }

    public CMFSContainer( CRI cri, boolean readonly, Map<CRI, CMUsageMode> children, String publicNamePattern ) {

        super( cri, readonly, children, publicNamePattern );
    }

    @Override
    protected FileSystemFacility getFacility( ) {

        return (FileSystemFacility) super.getFacility( );
    }

    public final ContainerResourceRecord getContainerResourceRecord( ) {

        ContainerResourceRecord crr = new ContainerResourceRecord( );
        crr.cri = getCri( );
        crr.resourceRecord = getRessourceRecord( );
        return crr;
    }

    public abstract ResourceRecord getRessourceRecord( );

    @Override
    public void updateContainer( boolean forced ) {

        ResourceRecord rr = getRessourceRecord( );
        getFacility( ).getResourceManagement( ).updateContainer( getCri( ), rr, forced );
        setInitialized( );
    }

    @Override
    public Collection<PRI> getPartitionsInContainer( ) {

        return getFacility( ).getQuery( ).getPartitionsInContainer( getCri( ) );
    }


    public CMFSContainer( CMServices.CMRestoreInfo ri ) {

        super( ri );
    }

}
