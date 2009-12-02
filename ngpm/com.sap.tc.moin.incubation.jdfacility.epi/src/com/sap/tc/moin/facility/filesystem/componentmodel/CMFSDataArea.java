package com.sap.tc.moin.facility.filesystem.componentmodel;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.facility.componentmodel.CMContainer;
import com.sap.tc.moin.facility.componentmodel.CMDataArea;
import com.sap.tc.moin.facility.componentmodel.CMName;
import com.sap.tc.moin.facility.componentmodel.CMServices;
import com.sap.tc.moin.facility.filesystem.FileSystemFacility;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement.ContainerResourceRecord;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.Facility;


@CMName( "FSDataArea" )
public class CMFSDataArea extends CMDataArea {

    public CMFSDataArea( DataAreaDescriptor descriptor, boolean readonly, Facility facility ) {

        super( descriptor, readonly, facility );
    }

    public CMFSDataArea( CMServices.CMRestoreInfo ri ) {

        super( ri );
    }

    @Override
    public FileSystemFacility getFacility( ) {

        return (FileSystemFacility) super.getFacility( );
    }

    @Override
    protected void remove( ) {

        getFacility( ).removeDataAreaByName( getDataAreaDescriptor( ).getDataAreaName( ) );
        super.remove( );
    }

    @Override
    protected DataAreaDescriptor grantDescriptor( String name ) {

        return getFacility( ).grantDataArea( name ).getDescriptor( );
    }

    @Override
    public void updateDataArea( ) {

        List<ContainerResourceRecord> containerResourceRecords = new ArrayList<ContainerResourceRecord>( getContainers( ).size( ) );
        for ( CRI containerCRI : getContainers( ) ) {
            CMContainer container = getCMManager( ).getContainer( containerCRI );
            if ( container != null && container instanceof CMFSContainer ) {
                CMFSContainer fsContainer = (CMFSContainer) container;
                containerResourceRecords.add( fsContainer.getContainerResourceRecord( ) );
            }
        }
        getFacility( ).getResourceManagement( ).updateDataArea( getDataAreaDescriptor( ), containerResourceRecords );

        for ( CRI containerCRI : getContainers( ) ) {
            CMContainer container = getCMManager( ).getContainer( containerCRI );
            if ( container != null && container instanceof CMFSContainer ) {
                container.setInitialized( );
            }
        }
    }

}
