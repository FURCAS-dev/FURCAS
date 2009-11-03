package com.sap.tc.moin.facility.primary.diservice.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiDcDefinitionProvider;
import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiDcToPpDependencyProvider;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;

public abstract class BaseDiDcDefinitionAdaptorImpl implements IpiDiDcDefinitionProvider {

    /** ******************** Internals ************************************** */

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_PRIMARY_FACILITY, MoinLocationEnum.MOIN_FACILITIES_DI_SERVICE, BaseDiDcDefinitionAdaptorImpl.class );

    private String _dcVendor;

    private String _dcName;

    private String _fullDcName;

    private DcSourceState _dcSourceState;

    private DcSyncMode _dcSyncMode;

    private String _dcRootPath;

    private List<String> _dcArchivePaths;


    /** **************************** Construction *************************** */

    protected BaseDiDcDefinitionAdaptorImpl( String dcVendor, String dcName ) {

        // Check preconditions:
        if ( dcVendor == null || dcVendor.length( ) == 0 ) {
            MoinIllegalArgumentException e = new MoinIllegalArgumentException( "BaseDiDcDefinitionAdaptorImpl", "dcVendor", dcVendor ); //$NON-NLS-1$ //$NON-NLS-2$
            LOGGER.trace( e, MoinSeverity.DEBUG, e.getMessage( ) );
            throw e;
        }
        if ( dcName == null || dcName.length( ) == 0 ) {
            MoinIllegalArgumentException e = new MoinIllegalArgumentException( "BaseDiDcDefinitionAdaptorImpl", "dcName", dcName ); //$NON-NLS-1$ //$NON-NLS-2$
            LOGGER.trace( e, MoinSeverity.DEBUG, e.getMessage( ) );
            throw e;
        }

        _dcVendor = dcVendor;
        _dcName = dcName;
        _fullDcName = dcVendor + "/" + dcName; //$NON-NLS-1$
    }

    protected void setDcRootPath( String dcRootPath ) {

        if ( dcRootPath == null || dcRootPath.length( ) == 0 ) {
            MoinIllegalArgumentException e = new MoinIllegalArgumentException( "BaseDiDcDefinitionAdaptorImpl", "dcRootPath", dcRootPath ); //$NON-NLS-1$ //$NON-NLS-2$
            LOGGER.trace( e, MoinSeverity.DEBUG, e.getMessage( ) );
            throw e;
        }
        _dcRootPath = dcRootPath;
        _dcSourceState = DcSourceState.SOURCE;
        // DcSyncMode local-only should fit for most use cases of adaptors
        // (stand-alone-scenario, DcBuild for MMs in Japro, ...)
        _dcSyncMode = DcSyncMode.LOCAL_ONLY;
    }

    protected void setDcArchivePaths( List<String> dcArchivePaths ) {

        if ( dcArchivePaths == null || dcArchivePaths.size( ) == 0 ) {
            MoinIllegalArgumentException e = new MoinIllegalArgumentException( "BaseDiDcDefinitionAdaptorImpl", "dcArchivePaths", dcArchivePaths ); //$NON-NLS-1$ //$NON-NLS-2$
            LOGGER.trace( e, MoinSeverity.DEBUG, e.getMessage( ) );
            throw e;
        }
        _dcArchivePaths = dcArchivePaths;
        _dcSourceState = IpiDiDcDefinitionProvider.DcSourceState.ARCHIVE;
        _dcSyncMode = DcSyncMode.SYNCED_AS_ARCHIVE;
    }

    /** ************************ IpiDiDcDefinitionProvider ****************** */

    public String getDcName( ) {

        return _dcName;
    }

    public String getDcVendor( ) {

        return _dcVendor;
    }

    public String getFullDcName( ) {

        return _fullDcName;
    }

    // to be implemented by concrete adaptor:
    public abstract String getDcTypeName( );

    public abstract String getDcTypeVendor( );

    public boolean isMoinRelevantDc( ) {

        return true;
    }

    // to be implemented by concrete adaptor:
    public IpiDiDcDefinitionProvider.DcSourceState getDcSourceState( ) {

        return _dcSourceState;
    }

    public DcSyncMode getDcSyncMode( ) {

        return _dcSyncMode;
    }

    public boolean isVisibleAsSources( ) {

        // Simulation
        return _dcSourceState == DcSourceState.SOURCE;
    }

    public boolean isVisibleAsArchives( ) {

        // Simulation
        return _dcSyncMode == DcSyncMode.SYNCED_AS_ARCHIVE;
    }


    public String getDcRootPath( ) {

        return isVisibleAsSources( ) ? _dcRootPath : null;
    }

    public String getGenerationRootLocation( ) {

        return getDcRootPath( );
    }

    // to be implemented by concrete adaptor:
    public abstract IpiDiDcDefinitionProvider.PropertyProvider getMoinProperty( );

    // to be implemented by concrete adaptor:
    public abstract List<String> getDiDcFolderDefinitions( );

    // to be implemented by concrete adaptor:
    public abstract Map<String, String> getAdditionalMoinFolders( );

    public List<String> getDcArchivePaths( ) {

        return _dcArchivePaths;
    }

    public List<String> getDcArchiveFolderPaths( ) {

        return Collections.emptyList( ); // Up to now we do not need to handle this case because we already handle getDcArchivePaths
    }

    public abstract List<IpiDiDcToPpDependencyProvider> getReferencesToPublicParts( );


    /** *********** IpiDiDcDefinitionProvider.PropertyProvider ************ */

    public static class PropertyBaseAdaptorImpl implements IpiDiDcDefinitionProvider.PropertyProvider {

        // A property has:
        // - a name:
        private String _name;

        // - and namespace:
        // (is optional because it can be derived from parent property)
        private String _namespace;

        // - attributes:
        // map: attribute name --> attribute object
        private List<IpiDiDcDefinitionProvider.AttributeProvider> _attributes;

        // - and inner properties:
        // list of properties, which can have several properties with same name
        private List<IpiDiDcDefinitionProvider.PropertyProvider> _childProperties;

        public PropertyBaseAdaptorImpl( String name, String namespace ) {

            _name = name;
            _namespace = namespace;
        }

        protected void setAttributes( List<IpiDiDcDefinitionProvider.AttributeProvider> attributes ) {

            _attributes = attributes;
        }

        public void setChildProperties( List<IpiDiDcDefinitionProvider.PropertyProvider> childProperties ) {

            _childProperties = childProperties;
        }

        /** *********** API: IpiDiDcDefinitionProvider.Property ************* */

        public String getName( ) {

            return _name;
        }

        public String getNamespace( ) {

            return _namespace;
        }

        public List<IpiDiDcDefinitionProvider.AttributeProvider> getAttributes( ) {

            return Collections.unmodifiableList( _attributes );
        }

        public IpiDiDcDefinitionProvider.AttributeProvider getAttribute( String attributeName ) {

            List<IpiDiDcDefinitionProvider.AttributeProvider> attributes = getAttributes( );
            for ( int i = 0; i < attributes.size( ); i++ ) {
                IpiDiDcDefinitionProvider.AttributeProvider attribute = attributes.get( i );
                if ( attribute.getName( ).equals( attributeName ) ) {
                    return attribute;
                }
            }
            return null;
        }

        public List<IpiDiDcDefinitionProvider.PropertyProvider> getChildProperties( ) {

            return Collections.unmodifiableList( _childProperties );
        }

    }


    /** *********** IpiDiDcDefinitionProvider.AttributeProvider ************ */

    public static class AttributeBaseAdaptorImpl implements IpiDiDcDefinitionProvider.AttributeProvider {

        private String _vendor;

        private String _name;

        private String _value;

        public AttributeBaseAdaptorImpl( String vendor, String name, String value ) {

            _vendor = vendor;
            _name = name;
            _value = value;
        }

        /** **************** API: IpiDiConfiguration.Attribute ************** */

        public String getVendor( ) {

            return _vendor;
        }

        public String getName( ) {

            return _name;
        }

        public String getValue( ) {

            return _value;
        }
    }

}
