package com.sap.tc.moin.facility.componentmodel.adapter;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.osgi.service.resolver.BundleDescription;
import org.eclipse.pde.core.plugin.IPluginAttribute;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.IPluginObject;
import org.eclipse.pde.core.plugin.PluginRegistry;

import com.sap.tc.moin.facility.componentmodel.CMContainer;
import com.sap.tc.moin.facility.componentmodel.CMDataArea;
import com.sap.tc.moin.facility.filesystem.componentmodel.CMFSContainer;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.ResourceIdentifierFactory;

public class PDEContentTypeRegistry extends ProjectContentTypeRegistry {

    private IPluginModelBase[] pluginModels;

    final ResourceIdentifierFactory riFactory;

    final String DAName;

//  private Map<String, BundleDescription> PluginID_PluginModelMap = new HashMap<String, BundleDescription>( );


    //
    public PDEContentTypeRegistry( CMDataArea targetDataArea ) {

        super( targetDataArea );

        this.riFactory = targetDataArea.getFacility( ).getRIFactory( );
        this.DAName = targetDataArea.getDataAreaDescriptor( ).getDataAreaName( );

        pluginModels = PluginRegistry.getActiveModels( false );
//        for ( IPluginModelBase m : pluginModels ) {
//            BundleDescription desc = m.getBundleDescription( );
//            PluginID_PluginModelMap.put( desc.getName( ), desc );
//        }

        getRegisteredNatures_PDE( );

        for ( IPluginModelBase model : pluginModels ) {
            BundleState bs = getParsePlugin_PDE( model );
            if ( bs != null ) {
                putBundleState( bs );
            }
        }
//        getMoinMetamodelPlugins_PDE( pluginModels, targetDataArea );
//        getMoinContentPlugins_PDE( pluginModels, targetDataArea );

        for ( IProject project : ResourcesPlugin.getWorkspace( ).getRoot( ).getProjects( ) ) {
            IPluginModelBase model = PluginRegistry.findModel( project );
            if ( model != null ) {
                BundleDescription bundleDesc = model.getBundleDescription( );
                BundleState bs = getBundleState( bundleDesc );

                String[] natures = getNatures( project );
                if ( bs != null ) {
                    bs.setProject( project );
                    addFolderByProjectNatures( bs.getFolders( ), natures );
                }
            } else {
                CRI cri = riFactory.createCri( DAName, getModelContainerName( project ) );
                CMContainer container = createContainerByProject( cri, project );
                if ( container != null ) {
                    targetDataArea.getCMManager( ).putContainer( container );
                }
            }
        }

        for ( BundleState bs : pluginsByPluginID.values( ) ) {
            CMFSContainer container = createConfiguration( bs );
            targetDataArea.getCMManager( ).putContainer( container );
        }
    }

    ////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////
    private static String getAttibuteValue_PDE( IPluginElement element, String attName ) {

        IPluginAttribute att = element.getAttribute( attName );
        return att != null ? att.getValue( ) : null;
    }

    private boolean addFolderByPath_PDE( Set<CMFSFolder> folders, IPluginElement configElement ) {

        if ( CE_PATH.equals( configElement.getName( ) ) ) {
            String path = getAttibuteValue_PDE( configElement, CE_PATH_VALUE );
            if ( path != null && path.length( ) > 0 ) {
                boolean versioned = !FALSE.equals( getAttibuteValue_PDE( configElement, CE_PATH_VERSIONED ) );
                CMFSFolder res = new CMFSFolder( path, versioned );
                folders.add( res );
            }
            return true;
        }
        return false;
    }

//    private boolean addAutodependantPlugins_PDE( Set<String> dependantPlugins, IPluginElement configElement ) {
//
//        if ( CE_AUTODEPENDENCY.equals( configElement.getName( ) ) ) {
//            String path = getAttibuteValue_PDE( configElement, CE_AUTODEPENDENCY_VALUE );
//            if ( path != null && path.length( ) > 0 ) {
//                dependantPlugins.add( path );
//            }
//            return true;
//        }
//        return false;
//    }

    private boolean addFolderByNature_PDE( Set<CMFSFolder> folders, IPluginElement element ) {

        if ( CE_NATURE.equals( element.getName( ) ) ) {
            String natureName = getAttibuteValue_PDE( element, CE_NATURE_NATURE_NAME );

            addFolderByContentNatureName( folders, natureName );
            return true;
        }
        return false;
    }

//    private boolean addFolderByPluginModel_PDE( Set<CMFSFolder> folders, IProject eclipseProject ) {
//
//        boolean result = false;
//        IPluginModelBase model = PluginRegistry.findModel( eclipseProject );
//        if ( model != null ) {
//            for ( IPluginExtension ext : model.getPluginBase( ).getExtensions( ) ) {
//                if ( !EX_POINT_CONTENT.equals( ext.getPoint( ) ) ) {
//                    continue;
//                }
//
//                for ( IPluginObject child : ext.getChildren( ) ) {
//                    if ( CE_CONTENT_DEFINITION.equals( child.getName( ) ) ) {
//                        for ( IPluginObject cdef : ( (IPluginElement) child ).getChildren( ) ) {
//                            if ( cdef instanceof IPluginElement ) {
//
//                                if ( addFolderByNature_PDE( folders, (IPluginElement) cdef ) ) {
//                                    result = true;
//                                    continue;
//                                }
//                                if ( addFolderByPath_PDE( folders, (IPluginElement) cdef ) ) {
//                                    result = true;
//                                    continue;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return result;
//    }
//
//    private boolean addUsedContainer_PDE( Map<CRI, CMUsageMode> container, IProject project ) {
//
//        IPluginModelBase model = PluginRegistry.findModel( project );
//        if ( model == null ) {
//            return false;
//        }
//
//        boolean res = false;
//        IPluginImport[] imports = model.getPluginBase( ).getImports( );
//        for ( IPluginImport importElement : imports ) {
//            BundleState requiredBundleState = pluginsByPluginID.get( importElement.getId( ) );
//            if ( requiredBundleState != null ) {
//                CMUsageMode usageMode = importElement.isReexported( ) ? CMUsageMode.REEXPORT : CMUsageMode.USE;
//                container.put( requiredBundleState.getCRI( ), usageMode );
//                res = true;
//            }
//        }
//        return res;
//    }

    private void getRegisteredNatures_PDE( ) {

        for ( IPluginModelBase model : pluginModels ) {
            for ( IPluginExtension ext : model.getPluginBase( ).getExtensions( ) ) {
                if ( !EX_POINT_NATUREDEFINITION.equals( ext.getPoint( ) ) ) {
                    continue;
                }

                for ( IPluginObject childObject : ext.getChildren( ) ) {
                    if ( !( childObject instanceof IPluginElement ) ) {
                        continue;
                    }
                    IPluginElement configElement = (IPluginElement) childObject;

                    if ( CE_NATURE_DEFINITION.equals( configElement.getName( ) ) ) {
                        String name = getAttibuteValue_PDE( configElement, CE_NATURE_NATURENAME );
                        String eclipseNature = getAttibuteValue_PDE( configElement, CE_NATURE_ECLIPSENATURE );

                        Set<CMFSFolder> folderDef = new HashSet<CMFSFolder>( );
                        Set<String> dependantPlugins = new HashSet<String>( );

                        for ( IPluginObject ceChild : configElement.getChildren( ) ) {
                            if ( !( ceChild instanceof IPluginElement ) ) {
                                continue;
                            }
                            if ( addFolderByPath_PDE( folderDef, (IPluginElement) ceChild ) ) {
                                continue;
                            }
//                            if ( addAutodependantPlugins_PDE( dependantPlugins, (IPluginElement) ceChild ) ) {
//                                continue;
//                            }
                        }

                        registerNatureDefinition( name, eclipseNature, folderDef, dependantPlugins );
                    }
                }
            }
        }
    }

    private BundleState getParsePlugin_PDE( IPluginModelBase model ) {

        MoinContentNatureDefinition m2Content = moinContentNatures.get( METAMODEL_M2CONTENT );


        BundleState bs = null;

        Set<CMFSFolder> folders = null;
        BundleDescription bundleDesc = model.getBundleDescription( );

        for ( IPluginExtension ext : model.getPluginBase( ).getExtensions( ) ) {
            if ( EX_POINT_METAMODEL.equals( ext.getPoint( ) ) ) {

                for ( IPluginObject childObject : ext.getChildren( ) ) {
                    if ( !( childObject instanceof IPluginElement ) ) {
                        continue;
                    }
                    IPluginElement configElement = (IPluginElement) childObject;

                    if ( CE_METAMODEL.equals( configElement.getName( ) ) ) {

                        if ( bundleDesc != null && m2Content != null && !m2Content.folderDef.isEmpty( ) ) {
                            if ( folders == null ) {
                                folders = new HashSet<CMFSFolder>( );
                            }
                            folders.addAll( m2Content.folderDef );
                            // CRI cri = riFactory.createCri( DAName, bundleDesc.getName( ) );
                            // putBundleState( new BundleState( bundleDesc, folders, bundleDeclaring, cri ) );
                        }
                    }
                }
            }


            if ( EX_POINT_CONTENT.equals( ext.getPoint( ) ) ) {

                for ( IPluginObject childObject : ext.getChildren( ) ) {
                    if ( !( childObject instanceof IPluginElement ) ) {
                        continue;
                    }
                    IPluginElement configElement = (IPluginElement) childObject;

                    if ( CE_CONTENT_DEFINITION.equals( configElement.getName( ) ) ) {

                        bundleDesc = model.getBundleDescription( );

//                    String bundleAlias = getAttibuteValue_PDE( configElement, CE_PLUGIN_ALIAS );
//                    if ( bundleAlias != null && bundleAlias.length( ) > 0 ) {
//
//                        BundleDescription desc = PluginID_PluginModelMap.get( bundleAlias );
//                        if ( desc == null ) {
//                            // report potential Problem
//                        }
//                        bundleDesc = desc;
//                    }

                        if ( bundleDesc != null ) {
                            if ( folders == null ) {
                                folders = new HashSet<CMFSFolder>( );
                            }

                            for ( IPluginObject ceChild : configElement.getChildren( ) ) {
                                if ( !( ceChild instanceof IPluginElement ) ) {
                                    continue;
                                }

                                IPluginElement localConfig = (IPluginElement) ceChild;
                                if ( addFolderByNature_PDE( folders, localConfig ) ) {
                                    continue;
                                }
                                if ( addFolderByPath_PDE( folders, localConfig ) ) {
                                    continue;
                                }
                            }

                        }
                    }

                }
            }
        }
        if ( folders != null ) {
            CRI cri = riFactory.createCri( DAName, bundleDesc.getName( ) );
            bs = new BundleState( bundleDesc, folders, cri );
        }
        return bs;

    }

//
//    private void getMoinMetamodelPlugins_PDE( IPluginModelBase[] pluginModels, CMDataArea targetDataArea ) {
//
//        final ResourceIdentifierFactory riFactory = targetDataArea.getFacility( ).getRIFactory( );
//        final String DAName = targetDataArea.getDataAreaDescriptor( ).getDataAreaName( );
//
//        MoinContentNatureDefinition m2Content = moinContentNatures.get( METAMODEL_M2CONTENT );
//        if ( m2Content == null || m2Content.folderDef.isEmpty( ) ) {
//            return;
//        }
//
//        for ( IPluginModelBase model : pluginModels ) {
//            for ( IPluginExtension ext : model.getPluginBase( ).getExtensions( ) ) {
//                if ( !EX_POINT_METAMODEL.equals( ext.getPoint( ) ) ) {
//                    continue;
//                }
//
//                for ( IPluginObject childObject : ext.getChildren( ) ) {
//                    if ( !( childObject instanceof IPluginElement ) ) {
//                        continue;
//                    }
//                    IPluginElement configElement = (IPluginElement) childObject;
//
//                    if ( CE_METAMODEL.equals( configElement.getName( ) ) ) {
//                        BundleDescription bundleDesc = model.getBundleDescription( );
//
//                        if ( bundleDesc != null ) {
//                            String bundleDeclaring = bundleDesc.getName( );
//
//                            Set<CMFSFolder> folders = new HashSet<CMFSFolder>( m2Content.folderDef );
//                            CRI cri = riFactory.createCri( DAName, bundleDesc.getName( ) );
//                            putBundleState( new BundleState( bundleDesc, folders, bundleDeclaring, cri ) );
//                        }
//
//                    }
//                }
//            }
//        }
//    }
//
//    private void getMoinContentPlugins_PDE( IPluginModelBase[] pluginModels, CMDataArea targetDataArea ) {
//
//        final ResourceIdentifierFactory riFactory = targetDataArea.getFacility( ).getRIFactory( );
//        final String DAName = targetDataArea.getDataAreaDescriptor( ).getDataAreaName( );
//
//        for ( IPluginModelBase model : pluginModels ) {
//            for ( IPluginExtension ext : model.getPluginBase( ).getExtensions( ) ) {
//                if ( !EX_POINT_CONTENT.equals( ext.getPoint( ) ) ) {
//                    continue;
//                }
//
//                for ( IPluginObject childObject : ext.getChildren( ) ) {
//                    if ( !( childObject instanceof IPluginElement ) ) {
//                        continue;
//                    }
//                    IPluginElement configElement = (IPluginElement) childObject;
//
//                    if ( CE_CONTENT_DEFINITION.equals( configElement.getName( ) ) ) {
//
//                        BundleDescription bundleDesc = model.getBundleDescription( );
//                        String bundleDeclaring = bundleDesc.getName( );
//                        String bundleAlias = getAttibuteValue_PDE( configElement, CE_PLUGIN_ALIAS );
//
//                        if ( bundleAlias != null && bundleAlias.length( ) > 0 ) {
//                            BundleDescription desc = PluginID_PluginModelMap.get( bundleAlias );
//                            if ( desc == null ) {
//                                // report potential Problem
//                            }
//                            bundleDesc = desc;
//                        }
//
//                        if ( bundleDesc != null ) {
//                            Set<CMFSFolder> folders = new HashSet<CMFSFolder>( );
//                            for ( IPluginObject ceChild : configElement.getChildren( ) ) {
//                                if ( !( ceChild instanceof IPluginElement ) ) {
//                                    continue;
//                                }
//
//                                IPluginElement localConfig = (IPluginElement) ceChild;
//                                if ( addFolderByNature_PDE( folders, localConfig ) ) {
//                                    continue;
//                                }
//                                if ( addFolderByPath_PDE( folders, localConfig ) ) {
//                                    continue;
//                                }
//                            }
//
//                            CRI cri = riFactory.createCri( DAName, bundleDesc.getName( ) );
//                            putBundleState( new BundleState( bundleDesc, folders, bundleDeclaring, cri ) );
//                        }
//                    }
//                }
//            }
//        }
//    }
//

    @Override
    protected CMContainer createContainerByProject( CRI cri, IProject eclipseProject ) {

        IPluginModelBase model = PluginRegistry.findModel( eclipseProject );
        if ( model != null ) {
            BundleState bs = getParsePlugin_PDE( model );
            if ( bs != null ) {
                bs.setProject( eclipseProject );
                putBundleState( bs );
                return createConfiguration( bs );
            }
        }
        return null;
    }


    @Override
    public String getModelContainerName( IProject project ) {

        IPluginModelBase model = PluginRegistry.findModel( project );
        if ( model != null ) {
            return model.getBundleDescription( ).getName( );
        }
        return super.getModelContainerName( project );
    }


}
