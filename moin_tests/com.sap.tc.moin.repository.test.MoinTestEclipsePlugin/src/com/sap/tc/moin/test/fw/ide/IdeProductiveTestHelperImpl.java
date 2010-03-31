package com.sap.tc.moin.test.fw.ide;

import org.eclipse.core.resources.IProject;

import com.sap.ide.dii05.model.api.IComponentType;
import com.sap.ide.dii05.ui.api.typefw.DiiDcTypeService;
import com.sap.tc.moin.nwdi.dctype.MoinTestDcType;
import com.sap.tc.moin.nwdi.dctype.mm.MoinMetaModelDcType;


@SuppressWarnings( "nls" )
public class IdeProductiveTestHelperImpl extends AbstractIdeRuntimeTestHelper {

    /** *********** Internals *********************************************** */

    private MoinConnectionUtil _moinConnectionUtil;

    private FileUtil _fileUtil;

    private DevConfUtil _devConfUtil;

    private DcModificationUtil _dcModificationUtil;

    private DcBuildUtil _dcBuildUtil;

    private DiTrackUtil _diTrackUtil;

    private S2XUtil _s2xUtil;

    private ScExportImportUtil _scExportImportUtil;

    /** ********************** Utilities ************************************ */

    public MoinConnectionUtil getMoinConnectionUtil( ) {

        if ( _moinConnectionUtil == null ) {
            _moinConnectionUtil = new MoinConnectionUtilImpl( );
        }
        return _moinConnectionUtil;
    }

    public FileUtil getFileUtil( ) {

        if ( _fileUtil == null ) {
            _fileUtil = new FileUtilImpl( );
        }
        return _fileUtil;
    }

    public DevConfUtil getDevConfUtil( ) {

        if ( _devConfUtil == null ) {
            _devConfUtil = new DevConfUtilImpl( this );
        }
        return _devConfUtil;
    }

    public DcModificationUtil getDcModificationUtil( ) {

        if ( _dcModificationUtil == null ) {
            _dcModificationUtil = new DcModificationUtilImpl( this );
        }
        return _dcModificationUtil;
    }

    public DcBuildUtil getDcBuildUtil( ) {

        if ( _dcBuildUtil == null ) {
            _dcBuildUtil = new DcBuildUtilImpl( this );
        }
        return _dcBuildUtil;
    }

    public DiTrackUtil getDiTrackUtil( ) {

        if ( _diTrackUtil == null ) {
            _diTrackUtil = new DiTrackUtilImpl( this );
        }
        return _diTrackUtil;
    }

    public S2XUtil getS2XUtil( ) {

        if ( _s2xUtil == null ) {
            _s2xUtil = new S2XUtilImpl( this );
        }
        return _s2xUtil;
    }

    public ScExportImportUtil getScExportImportUtil( ) {

        if ( _scExportImportUtil == null ) {
            _scExportImportUtil = new ScExportImportUtilImpl( this );
        }
        return _scExportImportUtil;
    }

    /** *********** Creation and Deletion of DCs and Projects *************** */

    /**
     * Creates a DC project with a test DC type and a test nature. If the DC
     * project already exists, this is a nop.
     * 
     * @param dcName the name of the DC. Note that this differs from the
     * corresponding project name.
     * @return The Eclipse project
     */
    public IProject getOrCreateLocalMoinDCProject( String dcVendor, String dcName ) throws Exception {

        return getDcModificationUtil( ).getOrCreateLocalMoinDCProject( MoinTestDcType.getDcType( ), dcVendor, dcName, DO_INITIALIZE );
    }

    public IProject getOrCreateLocalMoinMetaModelDCProject( String dcVendor, String dcName ) throws Exception {

        return getDcModificationUtil( ).getOrCreateLocalMoinDCProject( MoinMetaModelDcType.getDcType( ), dcVendor, dcName, DO_INITIALIZE );
    }

    public IProject getOrCreateLocalJavaDCProject( String dcVendor, String dcName ) throws Exception {

        IComponentType javaDcType = DiiDcTypeService.createDcType( DcModificationUtilImpl.JAVA_DC_TYPE_NAME, DcModificationUtilImpl.NO_DC_SUBTYPE, DcModificationUtilImpl.JAVA_DC_TYPE_VENDOR );
        return getDcModificationUtil( ).getOrCreateLocalMoinDCProject( javaDcType, dcVendor, dcName, DONT_INITIALIZE );
    }

    public IProject getOrCreateLocalDictionaryDCProject( String dcVendor, String dcName ) throws Exception {

        IComponentType javaDcType = DiiDcTypeService.createDcType( DcModificationUtilImpl.DICTIONARY_DC_TYPE_NAME, DcModificationUtilImpl.NO_DC_SUBTYPE, DcModificationUtilImpl.DICTIONARY_DC_TYPE_VENDOR );
        return getDcModificationUtil( ).getOrCreateLocalMoinDCProject( javaDcType, dcVendor, dcName, DONT_INITIALIZE );
    }

    public IProject getOrCreateLocalDummyDCProject( String dcVendor, String dcName ) throws Exception {

        IComponentType dummyDcType = DiiDcTypeService.createDcType( DcModificationUtilImpl.MOIN_DUMMY_DC_TYPE_NAME, DcModificationUtilImpl.NO_DC_SUBTYPE, DcModificationUtilImpl.MOIN_DUMMY_DC_TYPE_VENDOR );
        return getDcModificationUtil( ).getOrCreateLocalMoinDCProject( dummyDcType, dcVendor, dcName, DONT_INITIALIZE );
    }

    public IProject getOrCreateLocalDummyMoinDCProject( String dcVendor, String dcName ) throws Exception {

        IComponentType dummyDcType = DiiDcTypeService.createDcType( DcModificationUtilImpl.MOIN_DUMMY_MOIN_DC_TYPE_NAME, DcModificationUtilImpl.NO_DC_SUBTYPE, DcModificationUtilImpl.MOIN_DUMMY_DC_TYPE_VENDOR );
        return getDcModificationUtil( ).getOrCreateLocalMoinDCProject( dummyDcType, dcVendor, dcName, DONT_INITIALIZE );
    }

}
