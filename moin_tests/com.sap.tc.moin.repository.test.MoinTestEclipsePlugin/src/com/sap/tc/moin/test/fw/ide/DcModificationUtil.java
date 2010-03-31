package com.sap.tc.moin.test.fw.ide;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;

import com.sap.ide.dii05.lib.api.modeledit.IMeEntity;
import com.sap.ide.dii05.lib.api.util.DiiLibraryException;
import com.sap.ide.dii05.model.api.IComponentType;
import com.sap.ide.dii05.model.api.IDevelopmentComponent;
import com.sap.ide.dii05.model.api.IDevelopmentConfiguration;
import com.sap.ide.dii05.model.api.ISoftwareComponent;
import com.sap.ide.dii05.model.api.Purpose;
import com.sap.ide.dii05.repository.api.IChangelistProvider;
import com.sap.tc.moin.repository.Connection;


@SuppressWarnings( "nls" )
public interface DcModificationUtil {

    static final String NAME_OF_LOCAL_SC = "MyComponents"; //$NON-NLS-1$

    static final String VENDOR_OF_LOCAL_SC = "demo.sap.com"; //$NON-NLS-1$

    /** ************************ Creation of DCs and Projects *************** */

    static final String NAME_OF_PP_PURPOSE_COMPILATION_FOR_MM_DC = "def_cmp"; //$NON-NLS-1$

    static final String NAME_OF_PP_PURPOSE_ASSEMBLY_FOR_MM_DC = "def_assembl"; //$NON-NLS-1$

    static final String NAME_OF_PP_PURPOSE_COMPILATION_FOR_MODEL_DC = "def_cmp"; //$NON-NLS-1$

    static final String NAME_OF_PP_PURPOSE_ASSEMBLY_FOR_MODEL_DC = "def_assembl"; //$NON-NLS-1$

    IProject getOrCreateLocalMoinDCProject( IComponentType dii05ComponentType, String dcVendor, String dcName, boolean doInitialize ) throws Exception;

    IProject getOrCreateMoinDcProject( IDevelopmentConfiguration devConfig, String scName, String scVendor, IComponentType dii05ComponentType, String dcVendor, String dcName, boolean doInitialize ) throws Exception;

    IProject getOrCreateMoinDcProject( IDevelopmentConfiguration devConfig, String scName, String scVendor, IComponentType dii05ComponentType, String dcVendor, String dcName, IChangelistProvider changelistProvider, boolean doInitialize, boolean doCheckIn ) throws Exception;

    /**
     * The DC is not build after creation, independently if the project already
     * existed or not.
     */
    IProject getOrCreateProjectForExistingDc( IDevelopmentComponent dc ) throws Exception;

    /**
     * For an existing DC the parameter <code>build</code> is ignored. For a
     * newly created DC project the behavior concerning syncing used DCs and
     * performing DC-build is controlled via parameter <code>build</code>.
     */
    IProject getOrCreateProjectForExistingDc( IDevelopmentComponent dc, boolean build ) throws Exception;

    /** *********** DC modification ***************************************** */

    void addDcDependencies( IDevelopmentComponent srcDc, List<IDevelopmentComponent> destDcs, String ppName ) throws DiiLibraryException;

    void removePublicPartFromDc( IDevelopmentComponent dc, String ppName ) throws CoreException;

    void addMoinRelevantPublicPartToMmDc( IDevelopmentComponent dc, String ppName ) throws CoreException;

    void addPublicPartToDc( IDevelopmentComponent dc, String ppName, Purpose purpose, ArrayList<IMeEntity> ppEntities ) throws CoreException;

    void removeMoinRelevantEntitiesFromPublicPartOfModelDc( IDevelopmentComponent dc ) throws CoreException;

    /**
     * Removes all entities with one of the given <code>entityTypes</code> from
     * the given public part <code>ppName</code> of the DC.
     */
    void removeEntitiesFromPublicPart( IDevelopmentComponent dc, String ppName, List<String> entityTypes ) throws CoreException;

    void setDcLocale( IDevelopmentComponent dc, String dcLocale ) throws Exception;

    void setDcAttribute( IDevelopmentComponent dc, String dcAttributeName, String dcVendor, String value ) throws Exception;

    /** *********** Refresh after DC modifications ************************** */

    /**
     * The method scans the local disc for the DCs of the local SC which is
     * mentioned for user defined DCs. It refreshes the DCs of the SC, but does
     * not fully initialize the Dii05 DC-objects (
     * dc.getLocalState().getAttributes().size == 0) ), i.e. those DCs are not
     * recognized as MOIN-relevant (this effect is just needed in test case
     * TestRefreshClientSpec).
     */

    void refreshDii05DcHandlingForNewOrDeletedDCs( ) throws Exception;

    void refreshDii05DcHandlingForChangedDc( String dcVendor, String dcName ) throws Exception;

    /** ***************** Deletion of DCs and projects ********************** */

    /**
     * Deletes the given Dc Project, including the dc-definition and files, but
     * does not delete the respective partitions in MOIN index.
     */
    void deleteLocalMoinDCProject( String dcVendor, String dcName ) throws Exception;

    /**
     * Deletes the given Dc project, including the dc-definition and files and
     * the respective partitions in MOIN index.
     */
    void deleteLocalMoinDCProjectAndPartitions( String dcVendor, String dcName, Connection connection ) throws Exception;

    // Scenario 2:
    // DCs currently can only be deleted in Scenario 2, because Dii05 and Nwdi do not yet support a 'test deletion' in the current track ...
    // Remark: Scenario 3: only remove DC is possible (delete DC is not supported)
    boolean deleteDcs( IDevelopmentComponent[] developmentComponents ) throws Exception;

    /** ***************** Retrieval / Creation of SCs *********************** */

    /**
     * Returns the instance for first found local software component in the
     * first found local development configuration (this is realized the same
     * way in MIE Dc-Framework).
     */
    ISoftwareComponent getLocalSc( ) throws CoreException;

    /**
     * Caution: scName MUST be in upper case !!!
     */
    ISoftwareComponent getOrCreateSc( IDevelopmentConfiguration devConfig, String scName, String scVendor ) throws Exception;

}
