package com.sap.tc.moin.repository.test.jmigenerator.tool;

import org.junit.Test;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.test.core.CoreMoinTest;
import com.sap.tc.moin.test.fw.TestMetaModels;

public class TestGenerateMoinMetamodelsTool extends CoreMoinTest {

    private static final String ROOT_FOLDER = System.getProperty( "com.sap.tc.moin.jmigenerator.rootFolder" );

    private static final String[] metamodelInfos = new String[] {
        TestMetaModels.JMI_TCK_CN,
        TestMetaModels.COMPANY_CN,
        TestMetaModels.SERVICE_INTERACTIONS_CN,
        TestMetaModels.TESTCASES_CN,
        TestMetaModels.TESTCASES_FOUNDATION_CN,
        TestMetaModels.TEXT_VERTICALIZATION_CN,
        TestMetaModels.GFW_CN,
        TestMetaModels.MOIN_MOF_CN,
        "sap.com/com.sap.tc.composition.metamodel",
        "sap.com/com.sap.tc.mm.mofa",
        "sap.com/com.sap.tc.mm.tgmodel",
        "sap.com/com.sap.tc.tdmodel.metamodel",
        "sap.com/tc/moin/webdynpro/webdynpro",
        "sap.com/com/sap/mi/gfw/mm",
        "sap.com/tc/esmp/model/xsd1",
        "sap.com/tc/esmp/model/wsdl2",
        "sap.com/glx/ide",
        "sap.com/glx/tnet" };

    @Test
    public void generate( ) throws Exception {

        generate( metamodelInfos );
        //generateAllAvailableMetamodels();
    }

    private void generate( String[] metamodelContainerNames ) throws Exception {

        if ( ROOT_FOLDER == null ) {
            throw new IllegalArgumentException( "No root output folder specified! Please set the folder path via -Dcom.sap.tc.moin.jmigenerator.rootFolder" );
        }
        CoreConnection conn = getTestHelper( ).getCoreConnection( getMOINConnection( ) );

        final MoinMetamodelGeneration mmGeneration = new MoinMetamodelGeneration( metamodelContainerNames, ROOT_FOLDER );
        mmGeneration.setConnection( getTestHelper( ).getCoreConnection( getMOINConnection( ) ) );
        mmGeneration.setRootFolder( ROOT_FOLDER );
        Thread thread = MoinMetamodelGeneration.runAsync( mmGeneration );
        thread.join( );
    }
}