/**
 * 
 */
package com.sap.tc.moin.repository.test.runtimehost;

import java.util.Locale;

import org.junit.Test;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.ResourceIdentifierFactory;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;
import com.sap.tc.moin.repository.spi.runtimehost.mm.SpiMetamodelRegistry;
import com.sap.tc.moin.test.fw.MoinTestHelper;
import com.sap.tc.moin.test.fw.TestMetaModels;
import com.sap.tc.moin.test.testcase.MoinTestCase;


/**
 * Test for the {@link SpiMetamodelRegistry} functionality.
 */
public class TestMetamodelRegistry extends MoinTestCase {

    @Test
    public void testGetLocalizedString( ) throws Exception {

        // we use the company meta-model for our test - we only need the CRI...
        MoinTestHelper testHelper = getTestHelper( );
        SpiFacility primaryFacility = (SpiFacility) testHelper.getDefaultFacility( );
        ResourceIdentifierFactory riFactory = primaryFacility.getRIFactory( );
        CRI cri = riFactory.createCri( primaryFacility.getMetamodelDataArea( ).getName( ), TestMetaModels.COMPANY_CN );

        // get the mm registry
        SpiMetamodelRegistry metamodelRegistry = testHelper.getCoreMoin( ).getMetaModelRegistry( );

        metamodelRegistry.getLocalizedString( cri, Locale.ENGLISH, "resourceKey1" );
    }
}
