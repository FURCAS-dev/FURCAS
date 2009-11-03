package com.sap.tc.moin.facility.componentmodel.adapter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;

import com.sap.tc.moin.facility.componentmodel.CMContainer;
import com.sap.tc.moin.facility.componentmodel.CMDataArea;
import com.sap.tc.moin.facility.componentmodel.CMUsageMode;
import com.sap.tc.moin.facility.filesystem.componentmodel.CMFSContainerFolder;
import com.sap.tc.moin.facility.pde.BidirectionalMap;
import com.sap.tc.moin.repository.CRI;


public class ProjectContentTypeRegistry extends ContentTypeRegistry {

    protected final CMDataArea targetDataArea;

    public ProjectContentTypeRegistry( CMDataArea targetDataArea ) {

        this.targetDataArea = targetDataArea;
    }

    protected boolean addUsedContainerByProjectNatures( Map<CRI, CMUsageMode> usedContainer, String[] natures ) {

        boolean result = false;
        for ( String natureName : natures ) {
            MoinContentNatureDefinition mcnDef = eclipseNatures.get( natureName );
            if ( mcnDef != null ) {
                for ( String depPIs : mcnDef.dependantPluginIDs ) {
                    BundleState used = pluginsByPluginID.get( depPIs );
                    if ( used != null ) {
                        usedContainer.put( used.getCRI( ), CMUsageMode.USE );
                        result = true;
                    }
                }
            }
        }
        return result;
    }

    protected boolean addFolderByProjectNatures( Set<CMFSFolder> res, String[] natures ) {

        boolean result = false;
        for ( String natureName : natures ) {
            MoinContentNatureDefinition cnd = eclipseNatures.get( natureName );
            if ( cnd != null && !cnd.folderDef.isEmpty( ) ) {
                res.addAll( cnd.folderDef );
                result = true;
            }
        }
        return result;
    }

    public String getModelContainerName( IProject project ) {

        String name = project.getName( );

        int pos1, pos2;
        pos1 = name.indexOf( '~', name.indexOf( '~' ) + 1 );
        pos2 = name.lastIndexOf( '~' );
        if ( pos1 > 0 && pos2 > pos1 ) {
            // (2F == '/' all other chars should be handled. But it's good enough for now.
            String res = name.substring( pos2 + 1 ) + "/" + name.substring( pos1 + 1, pos2 ).replace( "(2f", "/" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            return res;
        }

        return name;
    }

    protected static String[] getNatures( IProject eclipseProject ) {

        String[] natures;
        try {
            natures = eclipseProject.getDescription( ).getNatureIds( );
        } catch ( CoreException e ) {
            natures = new String[0];
        }
        return natures;
    }

    protected CMContainer createContainerByProject( CRI cri, IProject eclipseProject ) {

        String[] natures = getNatures( eclipseProject );

        Map<CRI, CMUsageMode> usedContainer = new HashMap<CRI, CMUsageMode>( );
        addUsedContainerByProjectNatures( usedContainer, natures );

        String folder = eclipseProject.getFullPath( ).toOSString( );

        Set<CMFSFolder> folders = new HashSet<CMFSFolder>( );
        addFolderByProjectNatures( folders, natures );

        if ( folders.isEmpty( ) && System.getProperty( "moin.test.configuration" ) != null ) { //$NON-NLS-1$
            folders.add( new CMFSFolder( "src/", true ) ); //$NON-NLS-1$
            folders.add( new CMFSFolder( "diagrams/", true ) ); //$NON-NLS-1$
            folders.add( new CMFSFolder( "moin/meta/", true ) ); //$NON-NLS-1$
        }

        String config = CMFSFolder.serializeFolderConfigString( folders, folder );
        return new CMFSContainerFolder( cri, false, usedContainer, null, config );

    }

    protected final BidirectionalMap<IProject, CRI> projectMap = new BidirectionalMap<IProject, CRI>( );

//    protected CMContainer getContainerForProject( IProject eclipseProject, CRI cri ) {
//
//        return createContainerByProject( cri, eclipseProject );
//    }

    public final CMContainer createProjectContainer( IProject eclipseProject ) {

        projectMap.removeK1( eclipseProject );

        if ( !eclipseProject.isAccessible( ) ) {
            return null;
        }

        String containerName = getModelContainerName( eclipseProject );
        if ( containerName == null ) {
            return null;
        }

        CRI cri = targetDataArea.createCri( containerName );
        CMContainer container = createContainerByProject( cri, eclipseProject );

        if ( container != null ) {
            targetDataArea.getCMManager( ).putContainer( container );
            projectMap.put( eclipseProject, container.getCri( ) );
            container.setResponsible( eclipseProject );
        }
        return container;
    }

    public final void initialize( ) {

        projectMap.clear( );
        for ( IProject project : ResourcesPlugin.getWorkspace( ).getRoot( ).getProjects( ) ) {
            createProjectContainer( project );
        }

        targetDataArea.updateDataArea( );
    }


    public CMContainer getContainer( IProject project ) {

        CRI cri = projectMap.getK1( project );
        return targetDataArea.getCMManager( ).getContainer( cri );
    }

    public CRI getContainerCri( IProject project ) {

        CMContainer container = getContainer( project );
        return container == null ? null : container.getCri( );
    }


    public IProject getProject( CRI cri ) {

        return projectMap.getK2( cri );
    }

}
