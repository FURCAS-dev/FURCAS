package com.sap.tc.moin.facility.componentmodel.adapter;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.osgi.service.resolver.BundleDescription;
import org.eclipse.osgi.service.resolver.BundleSpecification;

import com.sap.tc.moin.facility.componentmodel.CMUsageMode;
import com.sap.tc.moin.facility.filesystem.componentmodel.CMFSContainer;
import com.sap.tc.moin.facility.filesystem.componentmodel.CMFSContainerArchives;
import com.sap.tc.moin.facility.filesystem.componentmodel.CMFSContainerFolder;
import com.sap.tc.moin.repository.CRI;


public abstract class ContentTypeRegistry {

    public static final String EX_POINT_METAMODEL = "com.sap.tc.moin.runtime.MoinMetaModel"; //$NON-NLS-1$

    public static final String CE_METAMODEL = "metamodel"; //$NON-NLS-1$

    public static final String METAMODEL_M2CONTENT = "M2Content"; //$NON-NLS-1$

    //
    public static final String EX_POINT_NATUREDEFINITION = "com.sap.tc.moin.incubation.contentprovider.NatureDefinition"; //$NON-NLS-1$

    public static final String CE_NATURE_DEFINITION = "NatureDefinition"; //$NON-NLS-1$

    public static final String CE_NATURE_NATURENAME = "NatureName"; //$NON-NLS-1$

    public static final String CE_NATURE_ECLIPSENATURE = "EclipseNature"; //$NON-NLS-1$

    //
    public static final String EX_POINT_CONTENT = "com.sap.tc.moin.incubation.contentprovider.Content"; //$NON-NLS-1$

    public static final String CE_CONTENT_DEFINITION = "ContentDefinition"; //$NON-NLS-1$

//    public static final String CE_AUTODEPENDENCY = "AutoDependency"; //$NON-NLS-1$

//    public static final String CE_AUTODEPENDENCY_VALUE = "Value";//$NON-NLS-1$

    //
    public static final String CE_PATH = "Path"; //$NON-NLS-1$

    public static final String CE_PATH_VALUE = "Value"; //$NON-NLS-1$

    public static final String CE_PATH_VERSIONED = "Versioned"; //$NON-NLS-1$

    public static final String FALSE = "false"; //$NON-NLS-1$

    //
    public static final String CE_NATURE = "Nature"; //$NON-NLS-1$

    public static final String CE_NATURE_NATURE_NAME = "NatureName"; //$NON-NLS-1$

//    public static final String CE_PLUGIN_ALIAS = "ForPluginID"; //$NON-NLS-1$


    protected Map<String, MoinContentNatureDefinition> moinContentNatures = new HashMap<String, MoinContentNatureDefinition>( );

    protected Map<String, MoinContentNatureDefinition> eclipseNatures = new HashMap<String, MoinContentNatureDefinition>( );

    protected Map<String, BundleState> pluginsByPluginID = new HashMap<String, BundleState>( );

//    private WeakHashMap<IProject, BundleState> projectToBundleMap = new WeakHashMap<IProject, BundleState>( );
//
//    protected void setBundelStateProject( BundleState bs, IProject project ) {
//
//        projectToBundleMap.put( project, bs );
//        bs.__setProject( project );
//
//    }
//
//    public CRI getCriByProject( IProject project ) {
//
//        BundleState bs = projectToBundleMap.get( project );
//        return bs == null ? null : bs.getCRI( );
//    }

    public void registerNatureDefinition( String natureName, String eclipseNature, Set<CMFSFolder> folderDef, Set<String> dependantPlugins ) {

        MoinContentNatureDefinition mnd = new MoinContentNatureDefinition( natureName, eclipseNature, folderDef, dependantPlugins );

        if ( isNotEmpty( natureName ) ) {
            moinContentNatures.put( natureName.trim( ), mnd );
        }

        if ( isNotEmpty( eclipseNature ) ) {
            eclipseNatures.put( eclipseNature.trim( ), mnd );
        }
    }

    public static final boolean isEmpty( String data ) {

        return data == null || data.length( ) == 0 || data.trim( ).length( ) == 0;
    }

    public static final boolean isNotEmpty( String data ) {

        return !isEmpty( data );
    }

    protected void putBundleState( BundleState bundleState ) {

        pluginsByPluginID.put( bundleState.getPluginID( ), bundleState );
    }

    protected BundleState getBundleState( BundleDescription desc ) {

        return pluginsByPluginID.get( desc.getName( ) );
    }

    private boolean addUsedContainer( Map<CRI, CMUsageMode> container, BundleState bundle ) {

        boolean res = false;
        for ( BundleSpecification requiredSpec : bundle.getDescription( ).getRequiredBundles( ) ) {
            if ( !requiredSpec.isResolved( ) ) {
                continue;
            }

            BundleDescription required = requiredSpec.getSupplier( ).getSupplier( );
            if ( required.equals( bundle.getDescription( ) ) ) {
                continue;
            }

            BundleState requiredBundleState = getBundleState( required );
            if ( requiredBundleState != null ) {
                CMUsageMode usageMode = requiredSpec.isExported( ) ? CMUsageMode.REEXPORT : CMUsageMode.USE;
                container.put( requiredBundleState.getCRI( ), usageMode );
                res = true;
            }
        }
        return res;
    }

    protected boolean addFolderByContentNatureName( Set<CMFSFolder> res, String natureName ) {

        MoinContentNatureDefinition cnd = moinContentNatures.get( natureName );
        if ( cnd != null && !cnd.folderDef.isEmpty( ) ) {
            res.addAll( cnd.folderDef );
            return true;
        }
        return false;
    }


    public CMFSContainer createConfiguration( BundleState bs ) {

        // CMDataArea targetDataArea, boolean updateContainer ) {

        // for ( BundleState bs : pluginsByPluginID.values( ) ) {

        Map<CRI, CMUsageMode> usedContainer = new HashMap<CRI, CMUsageMode>( );
        addUsedContainer( usedContainer, bs );

        CMFSContainer container = null;
        File location;
        String pathName;

        IProject project = bs.getProject( );
        if ( project != null ) {
            location = new File( project.getLocation( ).toOSString( ) );
            pathName = project.getFullPath( ).toOSString( );
        } else {
            location = getBundleFileLocation( bs.getDescription( ).getLocation( ) );
            pathName = location.getAbsolutePath( );
        }

        if ( location.isDirectory( ) ) {
            String config = CMFSFolder.serializeFolderConfigString( bs.getFolders( ), pathName );
            container = new CMFSContainerFolder( bs.getCRI( ), project == null, usedContainer, null, config );
        } else {
            List<String> prefixes = new ArrayList<String>( bs.getFolders( ).size( ) );
            for ( CMFSFolder folder : bs.getFolders( ) ) {
                prefixes.add( folder.folder );
            }
            container = new CMFSContainerArchives( bs.getCRI( ), true, usedContainer, null, Collections.singletonList( pathName ), prefixes );
        }

        return container;
//        targetDataArea.getCMManager( ).putContainer( container, updateContainer );
        // }
    }

    private static File getBundleFileLocation( String bundleLocation ) {

        StringBuilder sb = new StringBuilder( bundleLocation );
        if ( sb.charAt( sb.length( ) - 1 ) == '/' ) {
            sb.setLength( sb.length( ) - 1 );
        }

        int idx = sb.indexOf( "file:" ); //$NON-NLS-1$
        if ( idx < 0 ) {
            File file = new File( sb.toString( ) );
            if ( file.exists( ) ) {
                return file.getAbsoluteFile( );
            }
            return null;
        }
        sb.delete( 0, idx );

        try {
            URL url = new URL( sb.toString( ) );
            File file = new File( url.getFile( ) );
            if ( file.exists( ) ) {
                return file.getAbsoluteFile( );
            }
        } catch ( MalformedURLException mue ) {
            // in Equinox the URL is not wellformed, which is taken care of by the code below
        }

        if ( idx >= 0 ) {
            sb.delete( 0, 5 );
            sb.insert( 0, System.getProperty( "osgi.install.area" ) ); //$NON-NLS-1$
            try {
                URL u = new URL( sb.toString( ) );
                File f = new File( u.getFile( ) );
                return f.getAbsoluteFile( );
            } catch ( MalformedURLException e ) {
                return null;
            }
        }
        return null;
    }

}
