package com.sap.tc.moin.ocl.ia;

import java.util.List;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.core.ocl.service.impl.OclExpressionRegistrationImpl;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.ocl.freestyle.OclExpressionRegistration;

/**
 * To gather statistics about the OCL Impact Analysis, set the system property
 * <tt>com.sap.tc.moin.ocl.ia.statistics</tt> to <tt>true</tt>.
 *
 */
public abstract class Statistics {
    private static Statistics instance;
    
    public static Statistics getInstance() {
	if (instance == null) {
	    String sysProp = System.getProperty("com.sap.tc.moin.ocl.ia.statistics");
	    if (sysProp != null && (sysProp.toLowerCase().equals("true") ||
		    sysProp.toLowerCase().equals("yes"))) {
		instance = new StatisticsImpl();
	    } else {
		instance = new StatisticsStub();
	    }
	}
	return instance;
    }
    
    public abstract void receivedEvent(OclExpressionRegistration oclExpressionRegistration, ModelChangeEvent event);
    public abstract void allInstancesCalled(List<String> classQname);
    public abstract String toString();
    public abstract void setCurrentObjectForSelf(Object elementForSelf);
    public abstract String toString(OclExpressionRegistration registration, Connection conn);
    public abstract String toCsv(OclExpressionRegistration registration, Connection conn);
    public abstract void instanceScopeAnalysisPerformed(OclExpressionRegistration registration, ModelChangeEvent mce, long timeInNanoseconds, int numberOfAffectedElements);
    public abstract void classScopeAnalysisPerformed(OclExpressionRegistration registration, long timeInNanoseconds);
    public abstract void evaluated(OclExpressionRegistrationImpl registration, long l);
    public abstract String getCsvHeader();
    public abstract void doneWithEvent(OclExpressionRegistrationImpl oclExpressionRegistrationImpl, ModelChangeEvent mce);
}
