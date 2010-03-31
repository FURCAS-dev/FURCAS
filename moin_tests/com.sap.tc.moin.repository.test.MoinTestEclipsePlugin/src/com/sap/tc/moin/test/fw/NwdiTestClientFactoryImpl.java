package com.sap.tc.moin.test.fw;

import com.sap.tc.moin.facility.primary.ipi.IpiPrimaryFacility;
import com.sap.tc.moin.test.testcase.MoinTestCase;

@SuppressWarnings( "nls" )
public class NwdiTestClientFactoryImpl extends AbstractTestClientFactory implements TestClientFactory {

    /**
     * Default constructor is required by the framework.
     */
    public NwdiTestClientFactoryImpl( ) {

        super( );
    }

    @Override
    protected TestClient createTestClient( int userIndex, int clientSpecIndex ) {

        // get the NWDI facility
        IpiPrimaryFacility nwdiFacility = (IpiPrimaryFacility) MoinTestCase.getTestHelper( ).getFacility( "PF" );

        // get the user properties for this user
        //        TestConfigurationImpl.PropertyGroupImpl userPropertyGroup = getTestConfiguration().getPropertyGroupList(
        //            BASENAME_USER).get(userIndex);
        // String password = userPropertyGroup.getSubProperties().getProperty(SUBPROPERTY_PW);
        String password = USERPASSWORD;

        //        TestConfigurationImpl.PropertyGroupImpl clientSpecPropertyGroup = getTestConfiguration().getPropertyGroupList(
        //            BASENAME_CLIENTSPEC).get(clientSpecIndex);
        String clientSpecId = CLIENTSPECTEMPLATE + clientSpecIndex;
        String dataAreaName = DEFAULTDATAAREA;

        //        String clientSpecId = clientSpecPropertyGroup.getSubProperties().getProperty(SUBPROPERTY_ID);
        //        String dataAreaName = clientSpecPropertyGroup.getSubProperties().getProperty(SUBPROPERTY_DATA_AREA); // this one can be null

        return new NwdiTestClientImpl( nwdiFacility.getId( ), password, clientSpecId, dataAreaName, this, userIndex, clientSpecIndex );
    }

}
