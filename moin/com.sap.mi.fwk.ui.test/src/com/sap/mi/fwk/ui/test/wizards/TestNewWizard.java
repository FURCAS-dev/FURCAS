package com.sap.mi.fwk.ui.test.wizards;

import com.sap.mi.fwk.dcfwk.ui.NewMoinDcWizard;

public class TestNewWizard extends NewMoinDcWizard {
    
    public static final String WIZARD_TITLE = "Create a Test Moin project";
    public static final String DC_TYPE_ID = "com.sap.mi.fwk.test.TestDcType";

	public TestNewWizard() {
    }
    
    @Override
    protected String getDcTypeId() {
    	return DC_TYPE_ID;
    }
    
    @Override
    protected String getWizardTitle() {
        return WIZARD_TITLE;
    }

}
