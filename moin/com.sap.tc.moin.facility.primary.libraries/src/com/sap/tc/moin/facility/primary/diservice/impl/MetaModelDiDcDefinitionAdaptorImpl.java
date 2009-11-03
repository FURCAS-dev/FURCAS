package com.sap.tc.moin.facility.primary.diservice.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiDcDefinitionProvider;
import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiDcToPpDependencyProvider;

// hot_todo: additional constructor for MM
// which is available not with sources but with zips.
// hot_todo: whole handling for zips ...
public class MetaModelDiDcDefinitionAdaptorImpl extends BaseDiDcDefinitionAdaptorImpl {

    /** ******************** Internals ************************************** */

    private static final String MOIN_META_MODEL_RESOURCE_FOLDER = "moin/meta"; //$NON-NLS-1$

    private static final String MOIN_META_MODEL_SOURCE_FOLDER = "diagrams"; //$NON-NLS-1$

    private static String _dcTypeName = MOIN_META_MODEL_DCTYPE_ID;

    private static String _dcTypeVendor = MOIN_META_MODEL_DCTYPE_VENDOR;

    private static IpiDiDcDefinitionProvider.PropertyProvider _moinProperty;
    static {
        // Create MOIN-property:
        PropertyBaseAdaptorImpl moinProperty = new PropertyBaseAdaptorImpl( IpiDiDcDefinitionProvider.MOIN_PROPERTY, IpiDiDcDefinitionProvider.MOIN_PROPERTY_NAMESPACE );
        _moinProperty = moinProperty;

        // Create the moin-resource-folder-property and put it as child-property
        // into the moin-property::
        PropertyBaseAdaptorImpl resourceFolderProperty = new PropertyBaseAdaptorImpl( DiDevelopmentComponentImpl.MOIN_RESOURCE_FOLDERS_PROPERTY, IpiDiDcDefinitionProvider.MOIN_PROPERTY_NAMESPACE );
        List<PropertyProvider> childProperties = new ArrayList<PropertyProvider>( 1 );
        childProperties.add( resourceFolderProperty );
        moinProperty.setChildProperties( childProperties );

        // Create the folder-path-property for the MM-resource-folder
        // and put it as child-property into the moin-resource-folder-property:
        PropertyBaseAdaptorImpl folderPathProperty = new PropertyBaseAdaptorImpl( DiDevelopmentComponentImpl.MOIN_FOLDER_PATH_PROPERTY, IpiDiDcDefinitionProvider.MOIN_PROPERTY_NAMESPACE );
        int numberOfChildProperties = 2;
        childProperties = new ArrayList<PropertyProvider>( numberOfChildProperties );
        childProperties.add( folderPathProperty );
        resourceFolderProperty.setChildProperties( childProperties );

        // Create the folder-path-attribute and set it as attribute for the
        // folder-path-property:
        AttributeBaseAdaptorImpl folderPathAttribute = new AttributeBaseAdaptorImpl( IpiDiDcDefinitionProvider.MOIN_VENDOR, DiDevelopmentComponentImpl.MOIN_FOLDER_PATH_ATTRIBUTE, MOIN_META_MODEL_RESOURCE_FOLDER );
        List<IpiDiDcDefinitionProvider.AttributeProvider> attributes = new ArrayList<IpiDiDcDefinitionProvider.AttributeProvider>( 1 );
        attributes.add( folderPathAttribute );
        folderPathProperty.setAttributes( attributes );

        // Create the folder-path-property for the MM-resource-folder
        // and put it as child-property into the moin-resource-folder-property:
        folderPathProperty = new PropertyBaseAdaptorImpl( DiDevelopmentComponentImpl.MOIN_FOLDER_PATH_PROPERTY, IpiDiDcDefinitionProvider.MOIN_PROPERTY_NAMESPACE );
        childProperties.add( folderPathProperty );
        resourceFolderProperty.setChildProperties( childProperties );

        // Create the folder-path-attribute and set it as attribute for the
        // folder-path-property:
        folderPathAttribute = new AttributeBaseAdaptorImpl( IpiDiDcDefinitionProvider.MOIN_VENDOR, DiDevelopmentComponentImpl.MOIN_FOLDER_PATH_ATTRIBUTE, MOIN_META_MODEL_SOURCE_FOLDER );
        attributes = new ArrayList<IpiDiDcDefinitionProvider.AttributeProvider>( 1 );
        attributes.add( folderPathAttribute );
        folderPathProperty.setAttributes( attributes );

    }

    private static List<String> _dcFolderDefinitions = new ArrayList<String>( 1 );
    static {
        _dcFolderDefinitions.add( MOIN_META_MODEL_RESOURCE_FOLDER );
    }

    /** **************************** Construction *************************** */

    private MetaModelDiDcDefinitionAdaptorImpl( String dcVendor, String dcName ) {

        super( dcVendor, dcName );
    }

    /**
     * For a meta model which is available as sources, e.g. the meta model which
     * is build in Japro-Build.
     */
    static public MetaModelDiDcDefinitionAdaptorImpl getInstance( String dcVendor, String dcName, String dcRootPath ) {

        // Remark:
        // The dcRootPath plays in Japro-Build for MMs also the role of an
        // output-folder. --> no registration of additionalMoinFolders needed.
        MetaModelDiDcDefinitionAdaptorImpl mmAdaptor = new MetaModelDiDcDefinitionAdaptorImpl( dcVendor, dcName );
        mmAdaptor.setDcRootPath( dcRootPath );
        return mmAdaptor;
    }

    /**
     * For a meta model which is available as archives, e.g. a meta model which
     * is used by the meta model which is build in Japro-Build.
     */
    static public MetaModelDiDcDefinitionAdaptorImpl getInstance( String dcVendor, String dcName, List<String> dcArchivePaths ) {

        MetaModelDiDcDefinitionAdaptorImpl mmAdaptor = new MetaModelDiDcDefinitionAdaptorImpl( dcVendor, dcName );
        mmAdaptor.setDcArchivePaths( dcArchivePaths );
        return mmAdaptor;
    }

    /** ************************ IpiDiDcDefinitionProvider ****************** */

    @Override
    public String getDcTypeName( ) {

        return _dcTypeName;
    }

    @Override
    public String getDcTypeVendor( ) {

        return _dcTypeVendor;
    }

    @Override
    public IpiDiDcDefinitionProvider.PropertyProvider getMoinProperty( ) {

        return _moinProperty;
    }

    @Override
    public List<String> getDiDcFolderDefinitions( ) {

        return _dcFolderDefinitions;
    }

    @Override
    public Map<String, String> getAdditionalMoinFolders( ) {

        // hot_todo: how to handle ?
        return null;
    }

    @Override
    public List<IpiDiDcToPpDependencyProvider> getReferencesToPublicParts( ) {

        // hot_todo: how to handle ?
        return null;
    }

}
