package com.sap.tc.moin.facility.primary.ipi.diservice.build;

import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiConfigurationProvider;
import com.sap.tc.moin.repository.ClientSpec;


/**
 * @author d021091
 */

public interface IpiBuildDiService {

    ClientSpec getClientSpec( IpiDiConfigurationProvider diConfigurationProvider );
}
