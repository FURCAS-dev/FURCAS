/**
 * 
 */
package com.sap.tc.moin.facility.componentmodel.adapter;

import java.lang.ref.WeakReference;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.osgi.service.resolver.BundleDescription;

import com.sap.tc.moin.repository.CRI;

class BundleState {

    private Set<CMFSFolder> folders;

    private BundleDescription bundleDesc;

    private CRI cri;

    private WeakReference<IProject> projectRef = new WeakReference<IProject>( null );

    public BundleState( BundleDescription bundleDesc, Set<CMFSFolder> folders, CRI cri ) {

        this.bundleDesc = bundleDesc;
        this.folders = folders;
        this.cri = cri;
    }

    public BundleDescription getDescription( ) {

        return bundleDesc;
    }

    public Set<CMFSFolder> getFolders( ) {

        return folders;
    }

    public CRI getCRI( ) {

        return cri;
    }

    public String getPluginID( ) {

        return bundleDesc != null ? bundleDesc.getName( ) : ""; //$NON-NLS-1$
    }

    public IProject getProject( ) {

        return projectRef.get( );
    }

    public void setProject( IProject project ) {

        projectRef = new WeakReference<IProject>( project );
    }
}