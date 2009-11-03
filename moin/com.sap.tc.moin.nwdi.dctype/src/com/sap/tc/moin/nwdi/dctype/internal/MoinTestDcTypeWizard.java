package com.sap.tc.moin.nwdi.dctype.internal;

import com.sap.mi.fwk.dcfwk.ui.NewMoinDcWizard;
import com.sap.tc.moin.nwdi.dctype.MoinTestDcType;

/** 
 * A new wizard for the test DC type
 * 
 * @author d031150
 */
public class MoinTestDcTypeWizard extends NewMoinDcWizard {

	public MoinTestDcTypeWizard() {
		super();
	}

	protected String getDcTypeId() {
		return MoinTestDcType.DC_TYPE_ID;
	}

	protected String getWizardTitle() {
		return Messages.MoinTestDcTypeWizard_0;
	}

}
