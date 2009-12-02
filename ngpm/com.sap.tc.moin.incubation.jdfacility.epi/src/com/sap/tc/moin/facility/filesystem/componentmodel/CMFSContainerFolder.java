/**
 * 
 */
package com.sap.tc.moin.facility.filesystem.componentmodel;

import java.util.Map;

import org.w3c.dom.Element;

import com.sap.tc.moin.facility.componentmodel.CMName;
import com.sap.tc.moin.facility.componentmodel.CMServices;
import com.sap.tc.moin.facility.componentmodel.CMUsageMode;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement.ResourceFoldersRecord;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement.ResourceRecord;
import com.sap.tc.moin.repository.CRI;

@CMName( "FSFolder" )
public class CMFSContainerFolder extends CMFSContainer {

    private final Map<String, String> resourceFolderPathsToRootPaths;

    public CMFSContainerFolder( CRI cri, boolean readonly, Map<CRI, CMUsageMode> children, String publicNamePattern, String config ) {

        super( cri, readonly, children, publicNamePattern );
        this.resourceFolderPathsToRootPaths = CMServices.deserializeStringToHashMap( config, CMServices.DefaultListSeparator, CMServices.DefaultKeySeparator );
    }


    @Override
    public ResourceRecord getRessourceRecord( ) {

        ResourceFoldersRecord rr = new ResourceFoldersRecord( );
        rr.resourceFolderPathsToRootPaths = resourceFolderPathsToRootPaths;
        return rr;
    }

//    @Override
//    public boolean equals( Object obj ) {
//
//        if ( !super.equals( obj ) ) {
//            return false;
//        }
//        if ( obj instanceof CMFSContainerFolder ) {
//            CMFSContainerFolder buddy = (CMFSContainerFolder) obj;
//            return resourceFolderPathsToRootPaths.equals( buddy.resourceFolderPathsToRootPaths );
//        }
//        return false;
//    }


    private static final String Name_resourceFolderPathsToRootPaths = "resourceFolderPathsToRootPaths"; //$NON-NLS-1$

    @Override
    public void serializeData( Element element ) {

        super.serializeData( element );
        element.setAttribute( Name_resourceFolderPathsToRootPaths, CMServices.serializeHashMapToString( resourceFolderPathsToRootPaths, CMServices.DefaultListSeparator, CMServices.DefaultKeySeparator ) );
    }

    public CMFSContainerFolder( CMServices.CMRestoreInfo ri ) {

        super( ri );
        this.resourceFolderPathsToRootPaths = CMServices.deserializeStringToHashMap( CMServices.getAttribute( ri.element, Name_resourceFolderPathsToRootPaths ), CMServices.DefaultListSeparator, CMServices.DefaultKeySeparator );

    }
}