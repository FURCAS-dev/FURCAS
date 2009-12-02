package com.sap.tc.moin.facility.filesystem.componentmodel;

import java.util.List;
import java.util.Map;

import org.w3c.dom.Element;

import com.sap.tc.moin.facility.componentmodel.CMName;
import com.sap.tc.moin.facility.componentmodel.CMServices;
import com.sap.tc.moin.facility.componentmodel.CMUsageMode;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement.ResourceArchiveFoldersRecord;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement.ResourceRecord;
import com.sap.tc.moin.repository.CRI;

@CMName( "FSArchiveFolders" )
public class CMFSContainerArchiveFolders extends CMFSContainer {

    private final List<String> archiveFoldersPaths;

    private static final String NAME_archiveFoldersPaths = "archiveFoldersPaths"; //$NON-NLS-1$

    private final List<String> resourceFoldersPaths;

    private static final String NAME_resourceFoldersPaths = "resourceFoldersPaths"; //$NON-NLS-1$

    public CMFSContainerArchiveFolders( CRI cri, boolean readonly, Map<CRI, CMUsageMode> children, String publicNamePattern, List<String> archiveFoldersPaths, List<String> resourceFoldersPaths ) {

        super( cri, readonly, children, publicNamePattern );

        this.archiveFoldersPaths = archiveFoldersPaths;
        this.resourceFoldersPaths = resourceFoldersPaths;
    }

    @Override
    public ResourceRecord getRessourceRecord( ) {

        ResourceArchiveFoldersRecord rr = new ResourceArchiveFoldersRecord( );
        rr.archiveFoldersPaths = archiveFoldersPaths;
        rr.resourceFoldersPaths = resourceFoldersPaths;
        return rr;

    }

//    @Override
//    public boolean equals( Object obj ) {
//
//        if ( !super.equals( obj ) ) {
//            return false;
//        }
//        if ( obj instanceof CMFSContainerArchiveFolders ) {
//            CMFSContainerArchiveFolders buddy = (CMFSContainerArchiveFolders) obj;
//
//            return archiveFoldersPaths.equals( buddy.archiveFoldersPaths ) && //
//                   resourceFoldersPaths.equals( buddy.resourceFoldersPaths );
//        }
//        return false;
//    }


    @Override
    public void serializeData( Element element ) {

        super.serializeData( element );
        element.setAttribute( NAME_archiveFoldersPaths, CMServices.serializeToString( archiveFoldersPaths, CMServices.DefaultListSeparator ) );
        element.setAttribute( NAME_resourceFoldersPaths, CMServices.serializeToString( resourceFoldersPaths, CMServices.DefaultListSeparator ) );
    }

    public CMFSContainerArchiveFolders( CMServices.CMRestoreInfo ri ) {

        super( ri );
        this.archiveFoldersPaths = CMServices.deserializeStringToList( CMServices.getAttribute( ri.element, NAME_archiveFoldersPaths ), CMServices.DefaultListSeparator );
        this.resourceFoldersPaths = CMServices.deserializeStringToList( CMServices.getAttribute( ri.element, NAME_resourceFoldersPaths ), CMServices.DefaultListSeparator );

    }
}
