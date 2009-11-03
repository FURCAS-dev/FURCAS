package com.sap.tc.moin.facility.primary.diservice.impl;

import java.util.List;

import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiDcDefinitionProvider;


// Remark:
// This adaptor does not provide more functionality than
// BaseFiConfigurationAdaptorImpl,
// but it has to be used together with MetaModelDiDcDefinitionAdaptorImpl, which
// adds a lot of functionality ... .
public class MetaModelDiConfigurationAdaptorImpl extends BaseDiConfigurationAdaptorImpl {

    /** **************************** Construction *************************** */

    private MetaModelDiConfigurationAdaptorImpl( Scenario scenario, String configurationName, List<IpiDiDcDefinitionProvider> moinDiDcDefinitions ) {

        super( scenario, configurationName, moinDiDcDefinitions );
    }


    static public MetaModelDiConfigurationAdaptorImpl getInstance( Scenario scenario, String configurationName, List<IpiDiDcDefinitionProvider> dcs ) {

        return new MetaModelDiConfigurationAdaptorImpl( scenario, configurationName, dcs );
    }

}
