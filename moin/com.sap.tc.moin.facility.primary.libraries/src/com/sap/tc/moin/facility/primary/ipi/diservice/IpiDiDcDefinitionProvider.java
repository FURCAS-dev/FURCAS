package com.sap.tc.moin.facility.primary.ipi.diservice;

import java.util.List;
import java.util.Map;

/**
 * This interface builds an abstraction layer to the real environment-specific
 * API from DevelopmentInfrastructure area for the access of a DC-definition.
 * <p>
 * This allows environment-independent implementations of flows which are equal
 * in different environments, although the respective DevelopmentInfrastructure
 * interfaces are different for the different environments.
 * <p>
 * The currently available APIs from DevelopmentInfrastructure are: Dii05 for
 * IDE, Sdic for JEE, DiBuildInfrastructure-Framework for DcBuild.
 * <p>
 * Caution:
 * <p>
 * The interface <code>IpiDiDcDefinitionProvider</code> - including the internal
 * interfaces - are not intended to be implemented by consumers, instead the
 * consumers should extend the corresponding basic adaptor
 * <code>IpiDiDcDefinitionBasicAdaptorImpl</code> - including the internal
 * classes, so that extensions of the interface do not syntactically break the
 * consumers.
 * </p>
 * 
 * @author d021091
 */

public interface IpiDiDcDefinitionProvider {

    // Structured property with all MOIN-relevant information, e.g. MOIN
    // resource-folders:
    static final String MOIN_PROPERTY_NAMESPACE = "http://xml.sap.com/2007/05/MoinModel"; //$NON-NLS-1$

    static final String MOIN_PROPERTY = "moin"; //$NON-NLS-1$

    // DC-attribute which defines the application component (CSN component):
    static final String SAP_VENDOR = "sap.com"; //$NON-NLS-1$

    static final String APPLICATION_COMPONENT = "ACHAssignment"; //$NON-NLS-1$

    // DC-attribute which marks a DC as MOIN-relevant:
    static final String MOIN_VENDOR = SAP_VENDOR;

    static final String MOIN_DC_ATTRIBUTE = "is_moin_dc"; //$NON-NLS-1$

    static final String IS_MOIN_DC_ATTRIBUTE = "true"; //$NON-NLS-1$


    // MOIN meta model DcType: (is defined by MIE)
    // moin-ide\mi.dcfwk\FrwkDev_stream\src\_com.sap.tc.moin.nwdi.dctype.mm
    static final String MOIN_META_MODEL_DCTYPE_ID = "com.sap.tc.moin.nwdi.dctype.mm"; //$NON-NLS-1$

    static final String MOIN_META_MODEL_DCTYPE_VENDOR = "sap.com"; //$NON-NLS-1$


    enum DcSyncMode {
        LOCAL_ONLY, NOT_SYNCED, SYNCED_AS_INACTIVE_SOURCE, SYNCED_AS_ACTIVE_SOURCE, SYNCED_AS_ARCHIVE
    }


    enum DcSourceState {
        SOURCE, ARCHIVE
    }

    /**
     * Returns the vendor of the DC.
     * <p>
     * Example: "demo.sap.com"
     */
    String getDcVendor( );

    /**
     * Returns the name of the DC.
     * <p>
     * Example: "tc/moin/repository/test"
     */
    String getDcName( );

    /**
     * Returns the full name of the DC, i.e. DC vendor concatenated with DC
     * name.
     * <p>
     * Example: "demo.sap.com/tc/moin/repository/test"
     */
    String getFullDcName( );

    String getDcTypeName( );

    String getDcTypeVendor( );

    /**
     * A MOIN-relevant DC is marked with a DC-attribute with:
     * <p>
     * vendor <code>MOIN_VENDOR</code>, name <code>MOIN_DC_ATTRIBUTE</code>,
     * value <code>IS_MOIN_DC_ATTRIBUTE</code>.
     * <p>
     * Background:
     * <p>
     * It was decided to use an attribute instead of a property because
     * DC-attributes can be stored in DB by DevelopmentInfrastructure (e.g. in
     * CBS), whereas DC-properties cannot. This builds the basis to later get
     * support for query&indexing-functionality (which will be provided by
     * DevelopmentInfrastructure in the future) for MOIN-relevant DCs.
     * </p>
     * Additionally custom DCs can be made MOIN-relevant via CPS registration
     * (Custom Parser Serializer registration in the MOIN deployment archive
     * e.g. for a meta model).
     */
    boolean isMoinRelevantDc( );

    /**
     * The methods determines if the development component is visible for MOIN
     * based on its sources.
     * <p>
     * This is the case when it has a DC project which is open.
     * </p>
     */
    boolean isVisibleAsSources( );

    /**
     * The methods determines if the development component is visible for MOIN
     * based on its public part archives.
     * <p>
     * This is the case when the following conditions are fulfilled:
     * <p>
     * (1) it has no DC project which is open
     * <p>
     * (2) and
     * <p>
     * (2.1) the development component is synced as archive (centrally build)
     * <p>
     * (2.2) or the development component was locally successfully build.
     * </p>
     */
    boolean isVisibleAsArchives( );

    /**
     * The DC-source-state reflects if the development component is available as
     * sources or as archives.
     */
    DcSourceState getDcSourceState( );

    /**
     * The DC-sync-mode reflects how the development component is synced, e.g.
     * as active source, as inactive source, as archive, ... .
     * 
     * @return
     */
    DcSyncMode getDcSyncMode( );

    /**
     * In case the development component is available on file system as sources
     * the method returns the path under which the sources of the development
     * component are stored. The sources are never distributed under several
     * locations.
     * <p>
     * Else the method returns null (persistence is based on DB, development
     * component is available as archives, ...).
     * <p>
     * The DC-definition-provider is responsible to deliver the appropriate path
     * format, e.g. in DcBuild an absolute java.io-path, in IDE an
     * IResource-path.
     * </p>
     */
    String getDcRootPath( );

    /**
     * Structured custom-property for MOIN which e.g. contains the definition of
     * MOIN-resource-folders, ... .
     * <p>
     * The custom-property for MOIN has namespace
     * <code>MOIN_PROPERTY_NAMESPACE</code> and name <code>MOIN_PROPERTY</code>.
     * </p>
     * Remark:
     * <p>
     * The property is only available for native MOIN DCs, but not for custom
     * MOIN DCs. In this case null is returned.
     */
    PropertyProvider getMoinProperty( );

    /**
     * DC-folder definitions:
     * <p>
     * source-folders, package-folders
     * <p>
     * Remark:
     * <p>
     * Up to now there are no general property based access interfaces available
     * from DevelopmentInfrastructure, but this handling will be extended by
     * DevelopmentInfrastructure in a general way (general DC-folder definitions
     * with e.g. custom-properties, ...) in the future. --> Later we can
     * introduce here an interface DiDcFolderProvider.
     * <p>
     * Remark:
     * <p>
     * The folder definitions are only available for native MOIN DCs, but not
     * for custom MOIN DCs. In this case an empty list is returned.
     */
    List<String> getDiDcFolderDefinitions( );

    /**
     * Additional MOIN-relevant folders are only considered in case the
     * development component is available on file system as sources
     * (DcSourceState.SOURCE).
     * <p>
     * Additional MOIN-relevant folders for the DC are:
     * <p>
     * MOIN-relevant folders in the MOIN-output-folder during DcBuild (other use
     * cases are not known so far). Those folders must not overlap with the
     * MOIN-relevant folders defined in the DC-definition (e.g. "moin/meta" for
     * meta model DCs).
     * <p>
     * The method returns a map:
     * <p>
     * MOIN-relevant folder --> folder path (with trailing file-separator)
     * <p>
     * Background:
     * <p>
     * This is the format which is required for the registration of the
     * MOIN-folders on FsPersistence.
     */
    Map<String, String> getAdditionalMoinFolders( );

    /**
     * The generation root location is the path under which the generation root
     * folder/s is/are located.
     * <p>
     * Example:
     * <p>
     * In IDE: the project root folder
     * <p>
     * In Build: the MOIN build output tmp-folder. This is necessary because the
     * packer cannot access MOIN, but only DiBuildFramework. And
     * DiBuildFramework only knows the DiResource-folders from DC def and packs
     * them and additionally the content under the specific MOIN build output
     * tmp-folder.
     * </p>
     */
    String getGenerationRootLocation( );

    /**
     * DC-archives are only considered in case the development component is
     * available on file system as archives (DcSourceState.ARCHIVE).
     * <p>
     * DC-archives are the archives (actually zips) for the public parts of the
     * DC where the DC is available as archive and not as source (e.g. synced in
     * IDE as archives).
     * <p>
     * The method returns the absolute path of the archives. In cases where
     * those paths can be determined the method
     * {@link #getDcArchiveFolderPaths()} returns null. In cases where those
     * paths cannot be determined the method returns an empty result (e.g. in
     * IDE-scenario). In those cases the method
     * {@link #getDcArchiveFolderPaths()} can be used.
     * <p>
     * Remark:
     * <p>
     * Only those partitions inside the archives are visible for MOIN which are
     * located in one of the defined MOIN-relevant folders (defined in the
     * MOIN-property, see getMoinProperty() in the DC-definition).
     * <p>
     * todo: In scenarios which are not file-system-based (e.g. JEE) we might
     * need an additional method, e.g. getDcArchiveNames().
     */
    List<String> getDcArchivePaths( );

    /**
     * Analogous to {@link #getDcArchivePaths}.
     * <p>
     * This method returns the path of the folder where the DC archives are
     * located, but only in those scenarios where the single DC archive paths
     * cannot be determined (e.g. in IDE scenario). In this case the method
     * {@link #getDcArchivePaths} returns an empty result.
     */
    List<String> getDcArchiveFolderPaths( );

    /**
     * The method returns all references (usage relations) from the current DC
     * as source DC to public parts of destination DCs.
     * <p>
     * Only those references are returned which are locally available, i.e. for
     * which the destination DC is locally available.
     * </p>
     */
    List<IpiDiDcToPpDependencyProvider> getReferencesToPublicParts( );


    /**
     * This interface builds an abstraction layer to the real
     * environment-specific API from DevelopmentInfrastructure area for the
     * access of DC-properties.
     * <p>
     * The currently available APIs from DevelopmentInfrastructure are: Dii05
     * for IDE, Sdic for JEE, DiBuildinfrastructure-Framework for DcBuild.
     * </p>
     */
    interface PropertyProvider {

        String getName( );

        String getNamespace( );

        List<AttributeProvider> getAttributes( );

        AttributeProvider getAttribute( String attributeName );

        List<PropertyProvider> getChildProperties( );
    }


    /**
     * This interface builds an abstraction layer to the real
     * environment-specific API from DevelopmentInfrastructure area for the
     * access of DC-property attributes.
     * <p>
     * The currently available APIs from DevelopmentInfrastructure are: Dii05
     * for IDE, Sdic for JEE, DiBuildinfrastructure-Framework for DcBuild.
     * </p>
     */
    interface AttributeProvider {

        // Remark: Vendor for attributes is not yet supported by DI (e.g. Dii05)

        String getName( );

        String getValue( );
    }

}
