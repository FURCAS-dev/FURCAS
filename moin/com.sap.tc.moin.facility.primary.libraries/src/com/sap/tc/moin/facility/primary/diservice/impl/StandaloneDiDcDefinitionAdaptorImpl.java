package com.sap.tc.moin.facility.primary.diservice.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiDcDefinitionProvider;
import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiDcToPpDependencyProvider;

/**
 * The stand-alone DC-definition adaptor provides DC-definitions for DCs with
 * the test-model-DC-type "com.sap.tc.moin.nwdi.dctype" (defined in MIE DC-type-
 * framework moin-ide/mi.dcfwk). This adaptor can only be used in connection
 * with the StandaloneDiConfigurationAdaptorImpl (responsible for
 * path-handling).
 * 
 * @author d021091
 */
public class StandaloneDiDcDefinitionAdaptorImpl extends BaseDiDcDefinitionAdaptorImpl {

    /** ******************** Internals ************************************** */

    private static final String MOIN_TEST_MODEL_DCTYPE_ID = "com.sap.tc.moin.nwdi.dctype"; //$NON-NLS-1$

    private static final String MOIN_TEST_MODEL_DCTYPE_VENDOR = "sap.com"; //$NON-NLS-1$

    private static final String FIXED_MOIN_TEST_RESOURCE_FOLDER = "src"; //$NON-NLS-1$

    private static String _dcTypeName = MOIN_TEST_MODEL_DCTYPE_ID;

    private static String _dcTypeVendor = MOIN_TEST_MODEL_DCTYPE_VENDOR;

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

        // Create the folder-path-property and put it as child-property into the
        // moin-resource-folder-property::
        PropertyBaseAdaptorImpl folderPathProperty = new PropertyBaseAdaptorImpl( DiDevelopmentComponentImpl.MOIN_FOLDER_PATH_PROPERTY, IpiDiDcDefinitionProvider.MOIN_PROPERTY_NAMESPACE );
        childProperties = new ArrayList<PropertyProvider>( 1 );
        childProperties.add( folderPathProperty );
        resourceFolderProperty.setChildProperties( childProperties );

        // Create the folder-path-attribute and set it as attribute for the
        // folder-path-property:
        AttributeBaseAdaptorImpl folderPathAttribute = new AttributeBaseAdaptorImpl( IpiDiDcDefinitionProvider.MOIN_VENDOR, DiDevelopmentComponentImpl.MOIN_FOLDER_PATH_ATTRIBUTE, FIXED_MOIN_TEST_RESOURCE_FOLDER );
        List<IpiDiDcDefinitionProvider.AttributeProvider> attributes = new ArrayList<IpiDiDcDefinitionProvider.AttributeProvider>( 1 );
        attributes.add( folderPathAttribute );
        folderPathProperty.setAttributes( attributes );
    }

    private static List<String> _dcFolderDefinitions = new ArrayList<String>( 1 );
    static {
        _dcFolderDefinitions.add( FIXED_MOIN_TEST_RESOURCE_FOLDER );
    }

    /** **************************** Construction *************************** */

    private StandaloneDiDcDefinitionAdaptorImpl( String dcVendor, String dcName ) {

        super( dcVendor, dcName );
    }

    static public StandaloneDiDcDefinitionAdaptorImpl getInstance( String dcVendor, String dcName ) {

        // Remark:
        // Assumption is that the DC is available as source, local-only
        // (see StandaloneDiConfigurationAdaptorImpl and
        // BaseDiDcDefinitionAdaptorImpl). This should be sufficient for the
        // stand-alone-scenario.
        // todo:
        // If there come up additional use cases with additional requirements
        // than we have to provide additional constructors here, analogous to
        // those for meta models (see MetaModelDiDcDefinitionAdaptorImpl).
        return new StandaloneDiDcDefinitionAdaptorImpl( dcVendor, dcName );
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
    public DcSyncMode getDcSyncMode( ) {

        return DcSyncMode.LOCAL_ONLY;
    }

    @Override
    public IpiDiDcDefinitionProvider.PropertyProvider getMoinProperty( ) {

        return _moinProperty;
    }

    @Override
    public List<String> getDiDcFolderDefinitions( ) {

        return _dcFolderDefinitions;
    }

    // In Stand-alone-scenario not needed:
    @Override
    public Map<String, String> getAdditionalMoinFolders( ) {

        return null;
    }

    @Override
    public List<IpiDiDcToPpDependencyProvider> getReferencesToPublicParts( ) {

        // hot_todo: how to handle ?
        return null;
    }

}
