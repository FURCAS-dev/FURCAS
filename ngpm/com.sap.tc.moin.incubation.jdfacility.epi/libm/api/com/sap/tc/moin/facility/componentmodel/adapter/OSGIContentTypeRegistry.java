package com.sap.tc.moin.facility.componentmodel.adapter;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.osgi.service.resolver.BundleDescription;
import org.eclipse.osgi.service.resolver.State;

import com.sap.tc.moin.facility.componentmodel.CMDataArea;
import com.sap.tc.moin.facility.filesystem.componentmodel.CMFSContainer;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.ResourceIdentifierFactory;

public class OSGIContentTypeRegistry extends ContentTypeRegistry {

    public OSGIContentTypeRegistry( CMDataArea targetDataArea ) {

        getRegisteredNatures( );
        getMoinMetamodelPlugins( targetDataArea );
        getMoinContentPlugins( targetDataArea );

        for ( BundleState bs : pluginsByPluginID.values( ) ) {
            CMFSContainer container = createConfiguration( bs );
            targetDataArea.getCMManager( ).putContainer( container );
        }
    }


    private boolean addFolderByPath( Set<CMFSFolder> folders, IConfigurationElement configElement ) {

        if ( CE_PATH.equals( configElement.getName( ) ) ) {
            String path = configElement.getAttribute( CE_PATH_VALUE );
            if ( path != null && path.length( ) > 0 ) {
                boolean versioned = !FALSE.equals( configElement.getAttribute( CE_PATH_VERSIONED ) );
                CMFSFolder res = new CMFSFolder( path, versioned );
                folders.add( res );
                return true;
            }
        }
        return false;
    }

    private boolean addFolderByNature( Set<CMFSFolder> folders, IConfigurationElement element ) {

        if ( CE_NATURE.equals( element.getName( ) ) ) {
            String natureName = element.getAttribute( CE_NATURE_NATURE_NAME );
            addFolderByContentNatureName( folders, natureName );
            return true;
        }
        return false;
    }

    private void getRegisteredNatures( ) {

        IExtensionPoint extPoint = Platform.getExtensionRegistry( ).getExtensionPoint( EX_POINT_NATUREDEFINITION );

        if ( extPoint != null ) {
            for ( IConfigurationElement registeredExtensions : extPoint.getConfigurationElements( ) ) {
//                String bundleID = registeredExtensions.getNamespaceIdentifier( );

                String name = registeredExtensions.getAttribute( CE_NATURE_NATURENAME );
                String eclipseNature = registeredExtensions.getAttribute( CE_NATURE_ECLIPSENATURE );

                Set<CMFSFolder> folderDef = new HashSet<CMFSFolder>( );

                for ( IConfigurationElement configElement : registeredExtensions.getChildren( ) ) {
                    addFolderByPath( folderDef, configElement );
                }

                registerNatureDefinition( name, eclipseNature, folderDef, null );

            }
        }
    }

    private void getMoinMetamodelPlugins( CMDataArea targetDataArea ) {

        IExtensionPoint mmExtPoint = Platform.getExtensionRegistry( ).getExtensionPoint( EX_POINT_METAMODEL );
        MoinContentNatureDefinition m2Content = moinContentNatures.get( METAMODEL_M2CONTENT );
        if ( m2Content == null || m2Content.folderDef.isEmpty( ) ) {
            return;
        }

        if ( mmExtPoint != null ) {

            final ResourceIdentifierFactory riFactory = targetDataArea.getFacility( ).getRIFactory( );
            final String DAName = targetDataArea.getDataAreaDescriptor( ).getDataAreaName( );

            State state = Platform.getPlatformAdmin( ).getState( false );

            for ( IExtension configElement : mmExtPoint.getExtensions( ) ) {

                String bundleDeclaring = configElement.getNamespaceIdentifier( );
                BundleDescription bundleDesc = state.getBundle( bundleDeclaring, null );

                Set<CMFSFolder> folders = new HashSet<CMFSFolder>( m2Content.folderDef );
                CRI cri = riFactory.createCri( DAName, bundleDesc.getName( ) );
                putBundleState( new BundleState( bundleDesc, folders, cri ) );
            }
        }
    }

    private void getMoinContentPlugins( CMDataArea targetDataArea ) {

        IExtensionPoint mmExtPoint = Platform.getExtensionRegistry( ).getExtensionPoint( EX_POINT_CONTENT );

        if ( mmExtPoint != null ) {

            final ResourceIdentifierFactory riFactory = targetDataArea.getFacility( ).getRIFactory( );
            final String DAName = targetDataArea.getDataAreaDescriptor( ).getDataAreaName( );

            IConfigurationElement[] configElements = mmExtPoint.getConfigurationElements( );
            State state = Platform.getPlatformAdmin( ).getState( false );

            for ( IConfigurationElement configElement : configElements ) {
                if ( CE_CONTENT_DEFINITION.equals( configElement.getName( ) ) ) {

                    String bundleDeclaring = configElement.getNamespaceIdentifier( );
                    BundleDescription bundleDesc = state.getBundle( bundleDeclaring, null );

                    if ( bundleDesc != null ) {
                        Set<CMFSFolder> folders = new HashSet<CMFSFolder>( );
                        for ( IConfigurationElement localConfig : configElement.getChildren( ) ) {
                            if ( addFolderByNature( folders, localConfig ) ) {
                                continue;
                            }
                            if ( addFolderByPath( folders, localConfig ) ) {
                                continue;
                            }
                        }
                        CRI cri = riFactory.createCri( DAName, bundleDesc.getName( ) );

                        putBundleState( new BundleState( bundleDesc, folders, cri ) );
                    }
                }
            }
        }
    }
}
