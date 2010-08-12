package com.sap.tc.moin.ocl.ia;

import java.util.List;
import java.util.Map;

import org.omg.ocl.expressions.ModelPropertyCallExp;
import org.omg.ocl.expressions.OclExpression;
import org.omg.ocl.expressions.OperationCallExp;

import com.sap.tc.moin.ocl.ia.instancescope.InstanceScopeAnalysis;
import com.sap.tc.moin.ocl.ia.instancescope.InstanceScopeAnalysis.LeadsToEmptySetResult;
import com.sap.tc.moin.ocl.ia.instancescope.NavigationStep;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.ocl.service.impl.OclExpressionRegistrationImpl;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.ocl.freestyle.OclExpressionRegistration;
import com.sap.tc.moin.repository.ocl.freestyle.OclRegistration;
import com.sap.tc.moin.repository.shared.util.Tuple.Pair;

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
    @Override
    public abstract String toString();
    public abstract void setCurrentObjectForSelf(Object elementForSelf);
    public abstract String toString(OclExpressionRegistration registration, Connection conn);
    public abstract String toCsv(OclExpressionRegistration registration, Connection conn);
    public abstract void instanceScopeNavigationStepComputed(InstanceScopeAnalysis instanceScopeAnalyzer, OclExpression exp, NavigationStep step, long timeInNanoseconds);
    public abstract void instanceScopeAnalysisPerformed(OclExpressionRegistration registration, ModelChangeEvent mce, long timeInNanoseconds, int numberOfAffectedElements);
    public abstract void classScopeAnalysisPerformed(OclExpressionRegistration registration, long timeInNanoseconds);
    public abstract void evaluated(OclExpressionRegistrationImpl registration, long l);
    public abstract String getCsvHeader();
    public abstract void doneWithEvent(OclExpressionRegistrationImpl oclExpressionRegistrationImpl, ModelChangeEvent mce);
    public abstract void stepPerformed(NavigationStep step);
    public abstract Map<NavigationStep, Integer> getStepsInfo();
    public abstract void haveIntersectingSubclassTreeCalled(MofClass a, MofClass b);
    public abstract void checkingIfParameterlessOperationCallIsEmpty(OperationCallExp opCall, ModelChangeEvent event, RefObject on);
    public abstract List<Pair<String, Integer>> getParameterlessOperationCallEmptyCheckInfo(CoreConnection conn);
    public abstract void affectedElementComputedForSourceOfParameterlessOperation(ModelPropertyCallExp attributeOrAssociationEndCall);
    public abstract List<Pair<String, Integer>> getAffectedElementComputedForSourceOfParameterlessOperationInfo(CoreConnection conn);
    public abstract void leadsToEmptySetPerformed(OclRegistration forRegistration, long time, LeadsToEmptySetResult result);
    public abstract String getLeadsToEmptySetPerformancesAsCsv();
}
