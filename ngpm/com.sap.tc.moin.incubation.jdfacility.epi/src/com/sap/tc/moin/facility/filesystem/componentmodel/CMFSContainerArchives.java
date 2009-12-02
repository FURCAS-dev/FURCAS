package com.sap.tc.moin.facility.filesystem.componentmodel;

import java.util.List;
import java.util.Map;

import org.w3c.dom.Element;

import com.sap.tc.moin.facility.componentmodel.CMName;
import com.sap.tc.moin.facility.componentmodel.CMServices;
import com.sap.tc.moin.facility.componentmodel.CMUsageMode;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement.ResourceArchivesRecord;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement.ResourceRecord;
import com.sap.tc.moin.repository.CRI;

@CMName( "FSArchives" )
public class CMFSContainerArchives extends CMFSContainer {

    private final List<String> archivePaths;

    private final List<String> resourceFoldersPaths;

    public CMFSContainerArchives( CRI cri, boolean readonly, Map<CRI, CMUsageMode> children, String publicNamePattern, List<String> archivePaths, List<String> resourceFoldersPaths ) {

        super( cri, readonly, children, publicNamePattern );
        this.archivePaths = archivePaths;
        this.resourceFoldersPaths = resourceFoldersPaths;
    }

    @Override
    public ResourceRecord getRessourceRecord( ) {

        ResourceArchivesRecord rr = new ResourceArchivesRecord( );
        rr.archivePaths = archivePaths;
        rr.resourceFoldersPaths = resourceFoldersPaths;
        return rr;
    }

//    @Override
//    public boolean equals( Object obj ) {
//
//        if ( !super.equals( obj ) ) {
//            return false;
//        }
//        if ( obj instanceof CMFSContainerArchives ) {
//            CMFSContainerArchives buddy = (CMFSContainerArchives) obj;
//
//            return archivePaths.equals( buddy.archivePaths ) && //
//                   resourceFoldersPaths.equals( buddy.resourceFoldersPaths );
//        }
//        return false;
//    }

    private static final String Name_archivePaths = "archivePaths"; //$NON-NLS-1$

    private static final String Name_resourceFoldersPaths = "resourceFoldersPaths"; //$NON-NLS-1$

    @Override
    public void serializeData( Element element ) {

        super.serializeData( element );
        element.setAttribute( Name_archivePaths, CMServices.serializeToString( archivePaths, CMServices.DefaultListSeparator ) );
        element.setAttribute( Name_resourceFoldersPaths, CMServices.serializeToString( resourceFoldersPaths, CMServices.DefaultListSeparator ) );
    }

    public CMFSContainerArchives( CMServices.CMRestoreInfo ri ) {

        super( ri );
        this.archivePaths = CMServices.deserializeStringToList( CMServices.getAttribute( ri.element, Name_archivePaths ), CMServices.DefaultListSeparator );
        this.resourceFoldersPaths = CMServices.deserializeStringToList( CMServices.getAttribute( ri.element, Name_resourceFoldersPaths ), CMServices.DefaultListSeparator );

    }
}
