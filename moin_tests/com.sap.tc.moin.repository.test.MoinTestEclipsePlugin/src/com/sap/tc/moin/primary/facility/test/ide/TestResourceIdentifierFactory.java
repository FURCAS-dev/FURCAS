package com.sap.tc.moin.primary.facility.test.ide;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.facility.primary.ipi.IpiPrimaryFacility;
import com.sap.tc.moin.facility.primary.riservice.DiResourceIdentifierConstants;
import com.sap.tc.moin.facility.primary.riservice.DiResourceIdentifierScannerImpl;
import com.sap.tc.moin.facility.primary.riservice.ResourceIdentifierScanner.ResourceIdentifierTokens;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.InvalidResourceIdentifierException;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.ResourceIdentifierFactory;
import com.sap.tc.moin.repository.spi.facility.SpiResourceIdentifierFactory;


public class TestResourceIdentifierFactory extends FacilityIdeMoinTest {

    private static final String regularPrefix = "src"; //$NON-NLS-1$

    private static final String mofId = "ABCDEF0123456789ABCDEF0123456789ABCDEF01"; //$NON-NLS-1$

    private static final String volatilePrefix = DiResourceIdentifierConstants.FIXED_VOLATILE_PARTITION_FOLDER;

    private static final String unknownPrefix = "unknownPrefix"; //$NON-NLS-1$

    private static final String mmDaName = IpiPrimaryFacility.META_MODEL_DATA_AREA_ID;

    private String daName;

    private String contName;

    private static final String partitionNamePrefixRegularSuffixRegular = regularPrefix + "/PartitionSuffixAllowed.mointest"; //$NON-NLS-1$

    private static final String partitionNamePrefixRegualSuffixIllegal = regularPrefix + "/PartitionSuffixNotAllowed.dumdidum"; //$NON-NLS-1$

    private static final String partitionNamePrefixRegularSuffixMissing = regularPrefix + "/PartitionSuffixNotAllowed"; //$NON-NLS-1$

    private static final String partitionNamePrefixRegularSuffixVolatile = regularPrefix + "/PartitionSuffixVolatile.volatile"; //$NON-NLS-1$

    private static final String partitionNamePrefixVolatileSuffixRegular = volatilePrefix + "/PartitionSuffixVolatile.mointest"; //$NON-NLS-1$

    private static final String partitionNamePrefixVolatileSuffixIllegal = volatilePrefix + "PartitionVolatilePrefix.dingens"; //$NON-NLS-1$

    private static final String partitionNamePrefixVolatileSuffixVolatile = volatilePrefix + "PartitionMalVolatilePrefix.volatile"; //$NON-NLS-1$

    private static final String partitionNamePrefixUnknownSuffixRegular = unknownPrefix + "/PartitionUnknownPrefix.mointest"; //$NON-NLS-1$

    private static final String partitionNameOnlySuffix = ".mointest"; //$NON-NLS-1$

    private static final String partitionNameEmptyPrefixRegularSuffixRegular = regularPrefix + "/" + partitionNameOnlySuffix; //$NON-NLS-1$

    ResourceIdentifierFactory riFac;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        this.daName = getPartitionOne( ).getPri( ).getDataAreaDescriptor( ).getDataAreaName( );
        this.contName = getPartitionOne( ).getPri( ).getContainerName( );
        this.riFac = getResourceIdentifierFactory( );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        this.daName = null;
        this.contName = null;
        this.riFac = null;
        super.afterTestMethod( );
    }

    @Test
    public void testCreatePriFromString( ) {

        String priString = this.getPartitionOne( ).getPri( ).toString( );
        PRI pri = riFac.createPri( priString );
        assertTrue( "Duplicated PRIs!!!", pri == this.getPartitionOne( ).getPri( ) ); //$NON-NLS-1$
    }

    @Test
    public void testCreatePriFrom3String( ) {

        String daName = this.getPartitionOne( ).getPri( ).getDataAreaDescriptor( ).getDataAreaName( );
        String container = this.getPartitionOne( ).getPri( ).getContainerName( );
        String partition = this.getPartitionOne( ).getPri( ).getPartitionName( );
        PRI pri = riFac.createPri( daName, container, partition );
        assertTrue( "Duplicated PRIs!!!", pri == this.getPartitionOne( ).getPri( ) ); //$NON-NLS-1$
    }

    @Test
    public void testCreateCriFromString( ) {

        String criString = this.getPartitionOne( ).getPri( ).getCri( ).toString( );
        CRI cri = riFac.createCri( criString );
        assertTrue( "Duplicated CRIs!!!", cri == this.getPartitionOne( ).getPri( ).getCri( ) ); //$NON-NLS-1$
    }

    @Test
    public void testCreateCriFrom2String( ) {

        String daName = this.getPartitionOne( ).getPri( ).getDataAreaDescriptor( ).getDataAreaName( );
        String container = this.getPartitionOne( ).getPri( ).getContainerName( );
        CRI cri = riFac.createCri( daName, container );
        assertTrue( "Duplicated CRIs!!!", cri == this.getPartitionOne( ).getPri( ).getCri( ) ); //$NON-NLS-1$
    }

    @Test
    public void testCreateMriFromString( ) {

        MRI oldMri = this.getPartitionOne( ).getPri( ).createMri( mofId );
        String mriString = oldMri.toString( );
        MRI mri = riFac.createMri( mriString );
        assertTrue( "Duplicated MRIs!!!", mri == oldMri ); //$NON-NLS-1$
    }

    @Test
    public void testCreateMriFrom4String( ) {

        MRI oldMri = this.getPartitionOne( ).getPri( ).createMri( mofId );
        String daName = this.getPartitionOne( ).getPri( ).getDataAreaDescriptor( ).getDataAreaName( );
        String container = this.getPartitionOne( ).getPri( ).getContainerName( );
        String partition = this.getPartitionOne( ).getPri( ).getPartitionName( );
        MRI mri = riFac.createMri( daName, container, partition, mofId );
        assertTrue( "Duplicated MRIs!!!", mri == oldMri ); //$NON-NLS-1$
    }

    @Test
    public void testCreateLriFromString( ) {

        LRI oldLri = this.getPartitionOne( ).getPri( ).createMri( mofId ).getLri( );
        String lriString = oldLri.toString( );
        LRI lri = riFac.createLri( lriString );
        assertTrue( "Duplicated LRIs!!!", lri == oldLri ); //$NON-NLS-1$
    }

    @Test
    public void testCreateLriFrom2String( ) {

        LRI oldLri = this.getPartitionOne( ).getPri( ).createMri( mofId ).getLri( );
        String daName = oldLri.getDataAreaDescriptor( ).getDataAreaName( );
        LRI lri = riFac.createLri( daName, mofId );
        assertTrue( "Duplicated MRIs!!!", lri == oldLri ); //$NON-NLS-1$

    }

    @Test
    public void testCreatePriAllowedSuffix( ) {

        try {
            riFac.createPri( daName, contName, partitionNamePrefixRegularSuffixRegular );
        } catch ( InvalidResourceIdentifierException irie ) {
            fail( "Unexpected Exception while creating partition with allowed suffix: " + irie.toString( ) ); //$NON-NLS-1$
        }
    }

    @Test
    public void testCreatePriUnallowedSuffix( ) {

        try {
            riFac.createPri( daName, contName, partitionNamePrefixRegualSuffixIllegal );
            fail( "Expected exception while creating partition with not allowed suffix" ); //$NON-NLS-1$
        } catch ( InvalidResourceIdentifierException irie ) {
        }
    }

    @Test
    public void testCreatePriWithoutSuffix( ) {

        try {
            riFac.createPri( daName, contName, partitionNamePrefixRegularSuffixMissing );
            fail( "Expected exception while creating partition with no suffix" ); //$NON-NLS-1$
        } catch ( InvalidResourceIdentifierException irie ) {
        }
    }

    @Test
    public void testCreatePriVolatileSuffixRegularPrefix( ) {

        try {
            riFac.createPri( daName, contName, partitionNamePrefixRegularSuffixVolatile );
            fail( "Expected exception while creating partition with '.volatile' suffix and non volatile prefix" ); //$NON-NLS-1$
        } catch ( InvalidResourceIdentifierException irie ) {
        }
    }

    @Test
    public void testCreatePriVolatilePrefixRegularSuffix( ) {

        try {
            riFac.createPri( daName, contName, partitionNamePrefixVolatileSuffixRegular );
            fail( "Expected exception while creating partition with volatile prefix" ); //$NON-NLS-1$
        } catch ( InvalidResourceIdentifierException irie ) {
        }
    }

    @Test
    public void testCreatePriVolatileSuffixInMetamodelDA( ) {

        try {
            riFac.createPri( mmDaName, contName, partitionNamePrefixRegularSuffixVolatile );
            fail( "Expected exception while creating partition with volatile suffix and non volatile suffix in metamodel data area" ); //$NON-NLS-1$
        } catch ( InvalidResourceIdentifierException irie ) {
        }
    }

    @Test
    public void testCreatePriVolatilePrefixAndSuffixInMetamodelDA( ) {

        try {
            riFac.createPri( mmDaName, contName, partitionNamePrefixVolatileSuffixVolatile );
        } catch ( InvalidResourceIdentifierException irie ) {
            fail( "Unexpected exception while creating partition with volatile prefix and suffix in metamodel data area" ); //$NON-NLS-1$
        }
    }

    @Test
    public void testCreatePriVolatilePrefixNonVolatileSuffixInMetamodelDA( ) {

        try {
            riFac.createPri( mmDaName, contName, partitionNamePrefixVolatileSuffixRegular );
            fail( "Expected exception while creating partition with volatile prefix and regular suffix in metamodel data area" ); //$NON-NLS-1$
        } catch ( InvalidResourceIdentifierException irie ) {
        }
    }

    @Test
    public void testCreatePriUnknownPrefix( ) {

        try {
            riFac.createPri( daName, contName, partitionNamePrefixUnknownSuffixRegular );
            fail( "Expected exception while creating partition with unknwon prefix" ); //$NON-NLS-1$
        } catch ( InvalidResourceIdentifierException irie ) {
        }
    }

    @Test
    public void testCreatePriWithoutVolatilePrefixAllowedSuffix( ) {

        try {
            riFac.createPri( daName, contName, partitionNamePrefixVolatileSuffixVolatile );
        } catch ( InvalidResourceIdentifierException irie ) {
            fail( "Unexpected exception occured while creating partition with volatile prefix and volatile suffix" ); //$NON-NLS-1$
        }
    }

    @Test
    public void testCreatePriVolatilePrefixAndVolatileSuffix( ) {

        PRI createdPri = null;
        try {
            createdPri = riFac.createPri( daName, contName, partitionNamePrefixVolatileSuffixVolatile );
        } catch ( InvalidResourceIdentifierException irie ) {
            fail( "Unexpected exception occured while creating partition with volatile prefix and volatile suffix" ); //$NON-NLS-1$
        }

        assertNotNull( "PRI should have been created. Expected reference != null.", createdPri ); //$NON-NLS-1$
        assertTrue( "Expected", createdPri.isVolatilePartition( ) ); //$NON-NLS-1$
    }

    @Test
    public void testCreatePriVolatilePrefixUnallowedSuffix( ) {

        try {
            riFac.createPri( daName, contName, partitionNamePrefixVolatileSuffixIllegal );
            fail( "Expected exception while creating partition with volatile prefix and non volatile suffix" ); //$NON-NLS-1$
        } catch ( InvalidResourceIdentifierException irie ) {
        }
    }

    @Test
    public void testCreatePriRegularPrefixVolatileSuffix( ) {

        try {
            riFac.createPri( daName, contName, partitionNamePrefixRegularSuffixVolatile );
            fail( "Expected exception while creating partition with non volatile prefix and volatile suffix" ); //$NON-NLS-1$
        } catch ( InvalidResourceIdentifierException irie ) {
        }
    }

    @Test
    public void testCreatePriUnallowedSuffixInMetamodelDA( ) {

        try {
            riFac.createPri( mmDaName, contName, partitionNamePrefixRegualSuffixIllegal );
            fail( "Unexpected exception while creating partition with not allowed suffix in metamodel data area" ); //$NON-NLS-1$
        } catch ( InvalidResourceIdentifierException irie ) {
        }
    }

    @Test
    public void testCreatePriLastPathSegmentOnlySuffix( ) {

        try {
            riFac.createPri( daName, contName, partitionNameEmptyPrefixRegularSuffixRegular );
            fail( "Expected exception while creating partition with last path segment being only the suffix" ); //$NON-NLS-1$
        } catch ( InvalidResourceIdentifierException irie ) {
        }
    }

    @Test
    public void testCreatePriOnlySuffix( ) {

        try {
            riFac.createPri( daName, contName, partitionNameOnlySuffix );
            fail( "Expected exception while creating partition with partition name being only the suffix" ); //$NON-NLS-1$
        } catch ( InvalidResourceIdentifierException irie ) {
        }
    }

    @Test
    public void testParsePriString( ) {

        DiResourceIdentifierScannerImpl p = new DiResourceIdentifierScannerImpl( );
        PRI pri = this.getAPri( );

        ResourceIdentifierTokens tokens = p.scanPriString( pri.toString( ) );
        assertTrue( pri.getDataAreaDescriptor( ).getFacilityId( ).equals( tokens.facilityId ) );
        assertTrue( pri.getDataAreaDescriptor( ).getDataAreaName( ).equals( tokens.dataAreaName ) );
        assertTrue( pri.getContainerName( ).equals( tokens.containerName ) );
        assertTrue( pri.getPartitionName( ).equals( tokens.partitionName ) );
        assertNull( tokens.mofId );

        try {
            p.scanPriString( this.getALri( ).toString( ) );
            fail( );
        } catch ( Exception e ) {
            // expected
        }

        try {
            p.scanPriString( this.getAMri( ).toString( ) );
            fail( );
        } catch ( Exception e ) {
            // expected
        }

        try {
            p.scanPriString( this.getACri( ).toString( ) );
            fail( );
        } catch ( Exception e ) {
            // expected
        }

        // test DC prefix before DA sep
        String dcPrefDaSep = "PF.DataAreaDCs/:test.sap.com/container/_comp/partition.mointest"; //$NON-NLS-1$
        try {
            p.scanPriString( dcPrefDaSep );
            fail( );
        } catch ( Exception e ) {
            // expected
        }

        // test DC suffix before DC prefix
        String dcSuffDcPref = "PF.DataArea:test.sap.com/container/_comp/DCs/partition.mointest"; //$NON-NLS-1$
        try {
            p.scanPriString( dcSuffDcPref );
            fail( );
        } catch ( Exception e ) {
            // expected
        }
    }

    @Test
    public void testParseCriString( ) {

        DiResourceIdentifierScannerImpl p = new DiResourceIdentifierScannerImpl( );
        CRI cri = this.getACri( );

        ResourceIdentifierTokens tokens = p.scanCriString( cri.toString( ) );
        assertTrue( cri.getDataAreaDescriptor( ).getFacilityId( ).equals( tokens.facilityId ) );
        assertTrue( cri.getDataAreaDescriptor( ).getDataAreaName( ).equals( tokens.dataAreaName ) );
        assertTrue( cri.getContainerName( ).equals( tokens.containerName ) );
        assertNull( tokens.partitionName );
        assertNull( tokens.mofId );

        try {
            p.scanCriString( this.getALri( ).toString( ) );
            fail( );
        } catch ( InvalidResourceIdentifierException e ) {
            // expected
        }

        try {
            p.scanCriString( this.getAMri( ).toString( ) );
            fail( );
        } catch ( InvalidResourceIdentifierException e ) {
            // expected
        }

        try {
            p.scanCriString( this.getAPri( ).toString( ) );
            fail( );
        } catch ( InvalidResourceIdentifierException e ) {
            // expected
        }

        // test invalid CRI with MofId
        String invCri = "PF.DataArea:DCs/test.sap.com/container#ABCDEF0123456789ABCDEF0123456789ABCDEF01"; //$NON-NLS-1$
        try {
            p.scanCriString( invCri );
            fail( );
        } catch ( InvalidResourceIdentifierException e ) {
            // expected
        }

        // test container name prefix before data area sep.
        invCri = "PF.DataAreaDCs/:test.sap.com/container/_comp/partition.mointest#ABCDEF0123456789ABCDEF0123456789ABCDEF01"; //$NON-NLS-1$
        try {
            p.scanCriString( invCri );
            fail( );
        } catch ( InvalidResourceIdentifierException e ) {
            // expected
        }
    }

    @Test
    public void testParseMriString( ) {

        DiResourceIdentifierScannerImpl p = new DiResourceIdentifierScannerImpl( );
        MRI mri = this.getAMri( );

        ResourceIdentifierTokens tokens = p.scanMriString( mri.toString( ) );
        assertTrue( mri.getDataAreaDescriptor( ).getFacilityId( ).equals( tokens.facilityId ) );
        assertTrue( mri.getDataAreaDescriptor( ).getDataAreaName( ).equals( tokens.dataAreaName ) );
        assertTrue( mri.getContainerName( ).equals( tokens.containerName ) );
        assertTrue( mri.getPartitionName( ).equals( tokens.partitionName ) );
        assertTrue( mri.getMofId( ).equals( tokens.mofId ) );

        try {
            p.scanMriString( this.getALri( ).toString( ) );
            fail( );
        } catch ( Exception e ) {
            // expected
        }

        try {
            p.scanMriString( this.getACri( ).toString( ) );
            fail( );
        } catch ( Exception e ) {
            // expected
        }

        try {
            p.scanMriString( this.getAPri( ).toString( ) );
            fail( );
        } catch ( Exception e ) {
            // expected
        }

        // test DC prefix before DA sep
        String dcPrefDaSep = "PF.DataAreaDCs/:test.sap.com/container/_comp/partition.mointest#ABCDEF0123456789ABCDEF0123456789ABCDEF01"; //$NON-NLS-1$
        try {
            p.scanMriString( dcPrefDaSep );
            fail( );
        } catch ( Exception e ) {
            // expected
        }

        // test DC suffix before DC prefix
        String dcSuffDcPref = "PF.DataArea:test.sap.com/container/_comp/DCs/partition.mointest#ABCDEF0123456789ABCDEF0123456789ABCDEF01"; //$NON-NLS-1$
        try {
            p.scanMriString( dcSuffDcPref );
            fail( );
        } catch ( Exception e ) {
            // expected
        }

        // test mof id sep. before DC suffix
        String mofDcSuf = "PF.DataArea:DCs/test.sap.com/container#partition.mointest/_comp/ABCDEF0123456789ABCDEF0123456789ABCDEF01"; //$NON-NLS-1$
        try {
            p.scanMriString( mofDcSuf );
            fail( );
        } catch ( Exception e ) {
            // expected
        }
    }

    @Test
    public void testParseLriString( ) {

        DiResourceIdentifierScannerImpl p = new DiResourceIdentifierScannerImpl( );
        LRI lri = this.getALri( );

        ResourceIdentifierTokens tokens = p.scanLriString( lri.toString( ) );
        assertTrue( lri.getDataAreaDescriptor( ).getFacilityId( ).equals( tokens.facilityId ) );
        assertTrue( lri.getDataAreaDescriptor( ).getDataAreaName( ).equals( tokens.dataAreaName ) );
        assertNull( tokens.containerName );
        assertNull( tokens.partitionName );
        assertTrue( lri.getMofId( ).equals( tokens.mofId ) );

        try {
            p.scanLriString( this.getAMri( ).toString( ) );
            fail( );
        } catch ( Exception e ) {
            // expected
        }

        try {
            p.scanLriString( this.getACri( ).toString( ) );
            fail( );
        } catch ( Exception e ) {
            // expected
        }

        try {
            p.scanLriString( this.getAPri( ).toString( ) );
            fail( );
        } catch ( Exception e ) {
            // expected
        }

        // test LRI with partition name
        String dcSuffDcPref = "PF.DataArea:/_comp/partition.mointest#ABCDEF0123456789ABCDEF0123456789ABCDEF01"; //$NON-NLS-1$
        try {
            p.scanLriString( dcSuffDcPref );
            fail( );
        } catch ( Exception e ) {
            // expected
        }

        // test LRI with mof id separator
        String mofDcSuf = "PF.DataArea:#ABCDEF0123456789ABCDEF0123456789ABCDEF01"; //$NON-NLS-1$
        try {
            p.scanLriString( mofDcSuf );
            fail( );
        } catch ( Exception e ) {
            // expected
        }
    }

    @Test
    public void testParseSeparatorPositionsExceptions( ) {

        // MRI String: PF.DataArea:DCs/test.sap.com/container/_comp/partition.mointest#ABCDEF0123456789ABCDEF0123456789ABCDEF01

        DiResourceIdentifierScannerImpl p = new DiResourceIdentifierScannerImpl( );

        // no facility separator
        String noFacSep = "PFDataArea:DCs/testsapcom/container/_comp/partitionmointest#ABCDEF0123456789ABCDEF0123456789ABCDEF01"; //$NON-NLS-1$
        try {
            p.scanMriString( noFacSep );
            fail( );
        } catch ( InvalidResourceIdentifierException e ) {
            // expected
        }

        // no data area name sep
        String noDaSep = "PF.DataAreaDCs/test.sap.com/container/_comp/partition.mointest#ABCDEF0123456789ABCDEF0123456789ABCDEF01"; //$NON-NLS-1$
        try {
            p.scanMriString( noDaSep );
            fail( );
        } catch ( InvalidResourceIdentifierException e ) {
            // expected
        }

        // data area name sep before facility separator
        String daFacSep = "PFDataArea:.DCs/test.sap.com/container/_comp/partition.mointest#ABCDEF0123456789ABCDEF0123456789ABCDEF01"; //$NON-NLS-1$
        try {
            p.scanMriString( daFacSep );
            fail( );
        } catch ( InvalidResourceIdentifierException e ) {
            // expected
        }

        // no container name prefix
        String noCnPre = "PF.DataArea:s/test.sap.com/container/_comp/partition.mointest#ABCDEF0123456789ABCDEF0123456789ABCDEF01"; //$NON-NLS-1$
        try {
            p.scanMriString( noCnPre );
            fail( );
        } catch ( InvalidResourceIdentifierException e ) {
            // expected
        }

        // no container name suffix
        String noCnSuf = "PF.DataArea:DCs/test.sap.com/container/_co/partition.mointest#ABCDEF0123456789ABCDEF0123456789ABCDEF01"; //$NON-NLS-1$
        try {
            p.scanMriString( noCnSuf );
            fail( );
        } catch ( InvalidResourceIdentifierException e ) {
            // expected
        }

        // no mof id separator
        String noMofSep = "PF.DataArea:DCs/test.sap.com/container/_comp/partition.mointest+ABCDEF0123456789ABCDEF0123456789ABCDEF01"; //$NON-NLS-1$
        try {
            p.scanMriString( noMofSep );
            fail( );
        } catch ( InvalidResourceIdentifierException e ) {
            // expected
        }

        // not the right facility id
        String wrFacId = "WF.DataArea:DCs/test.sap.com/container/_comp/partition.mointest#ABCDEF0123456789ABCDEF0123456789ABCDEF01"; //$NON-NLS-1$
        try {
            p.scanMriString( wrFacId );
            fail( );
        } catch ( InvalidResourceIdentifierException e ) {
            // expected
        }
    }

    @Test
    public void testCheckRecordExceptions( ) {

        // MRI String: PF.DataArea:DCs/test.sap.com/container/_comp/partition.mointest#ABCDEF0123456789ABCDEF0123456789ABCDEF01

        DiResourceIdentifierScannerImpl p = new DiResourceIdentifierScannerImpl( );

        // no data area name
        String noDa = "PF.:DCs/test.sap.com/container/_comp/partition.mointest#ABCDEF0123456789ABCDEF0123456789ABCDEF01"; //$NON-NLS-1$
        try {
            p.scanMriString( noDa );
            fail( );
        } catch ( InvalidResourceIdentifierException e ) {
            // expected
        }

        // no container name
        String noCn = "PF.DataArea:DCs//_comp/partition.mointest#ABCDEF0123456789ABCDEF0123456789ABCDEF01"; //$NON-NLS-1$
        try {
            p.scanMriString( noCn );
            fail( );
        } catch ( InvalidResourceIdentifierException e ) {
            // expected
        }

        // no partition name
        String noPa = "PF.DataArea:DCs/test.sap.com/container/_comp/#ABCDEF0123456789ABCDEF0123456789ABCDEF01"; //$NON-NLS-1$
        try {
            p.scanMriString( noPa );
            fail( );
        } catch ( InvalidResourceIdentifierException e ) {
            // expected
        }

        // no mof id
        String noMo = "PF.DataArea:DCs/test.sap.com/container/_comp/partition.mointest#"; //$NON-NLS-1$
        try {
            p.scanMriString( noMo );
            fail( );
        } catch ( InvalidResourceIdentifierException e ) {
            // expected
        }
    }

    @Test
    public void testIllegalDataAreaDescriptorExceptions( ) {

        // create illegal descriptor
        DataAreaDescriptor illegalDescriptor = this.createIllegalDataAreaDescriptor( );

        try {
            ( (SpiResourceIdentifierFactory) riFac ).createVolatilePri( illegalDescriptor, TestResourceIdentifierFactory.partitionNamePrefixRegularSuffixRegular );
            fail( "Expected exception during volatile PRI creaion because of illegal descriptor, but PRI was created." ); //$NON-NLS-1$
        } catch ( IllegalArgumentException e ) {
            // expected
        }

        try {
            ( (SpiResourceIdentifierFactory) riFac ).createNullPri( illegalDescriptor, TestResourceIdentifierFactory.partitionNamePrefixRegularSuffixRegular );
            fail( "Expected exception during null PRI creation because of illegal descriptor, but PRI was created." ); //$NON-NLS-1$
        } catch ( IllegalArgumentException e ) {
            // expected
        }
    }

    // ################################

    private LRI getALri( ) {

        return this.getPartitionOne( ).getPri( ).createMri( mofId ).getLri( );
    }

    private MRI getAMri( ) {

        return this.getPartitionOne( ).getPri( ).createMri( mofId );
    }

    private PRI getAPri( ) {

        return this.getPartitionOne( ).getPri( );
    }

    private CRI getACri( ) {

        return this.getPartitionOne( ).getPri( ).getCri( );
    }

    private DataAreaDescriptor createIllegalDataAreaDescriptor( ) {

        return new DataAreaDescriptor( ) {

            public String getDataAreaName( ) {

                return "TestDaName"; //$NON-NLS-1$
            }

            public String getFacilityId( ) {

                return "SomeFacilityNotKnownToMoin"; //$NON-NLS-1$
            }

            public boolean isMetamodelDataArea( ) {

                return false;
            }
        };
    }
}
