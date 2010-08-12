package com.sap.tc.moin.ocl.ia;

import java.util.Collections;
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

public class StatisticsStub extends Statistics {
    @Override
    public void receivedEvent(OclExpressionRegistration oclExpressionRegistration, ModelChangeEvent event) {}
    @Override
    public void allInstancesCalled(List<String> classQname) {}
    @Override
    public String toString() { return "<empty>"; }
    @Override
    public void setCurrentObjectForSelf(Object elementForSelf) {}
    @Override
    public String toString(OclExpressionRegistration registration, Connection conn) { return "<empty>"; }
    @Override
    public String toCsv(OclExpressionRegistration registration, Connection conn) { return "<empty>"; }
    @Override
    public void instanceScopeAnalysisPerformed(OclExpressionRegistration registration, ModelChangeEvent mce, long timeInNanoseconds, int numberOfAffectedElements) {}
    @Override
    public void classScopeAnalysisPerformed(OclExpressionRegistration registration, long timeInNanoseconds) {}
    @Override
    public void evaluated(OclExpressionRegistrationImpl registration, long l) {}
    @Override
    public String getCsvHeader() { return "<empty>"; }
    @Override
    public void doneWithEvent(OclExpressionRegistrationImpl oclExpressionRegistrationImpl, ModelChangeEvent mce) {}
    @Override
    public void stepPerformed(NavigationStep step) {}
    @Override
    public Map<NavigationStep, Integer> getStepsInfo() { return Collections.emptyMap(); }
    @Override
    public void instanceScopeNavigationStepComputed(InstanceScopeAnalysis instanceScopeAnalyzer, OclExpression exp, NavigationStep step, long timeInNanoseconds) {}
    @Override
    public void haveIntersectingSubclassTreeCalled(MofClass a, MofClass b) {}
    @Override
    public void checkingIfParameterlessOperationCallIsEmpty(OperationCallExp opCall, ModelChangeEvent event, RefObject on) {}
    @Override
    public List<Pair<String, Integer>> getParameterlessOperationCallEmptyCheckInfo(CoreConnection conn) { return Collections.emptyList(); }
    @Override
    public void affectedElementComputedForSourceOfParameterlessOperation(ModelPropertyCallExp attributeOrAssociationEndCall) {}
    @Override
    public List<Pair<String, Integer>> getAffectedElementComputedForSourceOfParameterlessOperationInfo(CoreConnection conn) { return Collections.emptyList(); }
    @Override
    public String getLeadsToEmptySetPerformancesAsCsv() { return "<empty>"; }
    @Override
    public void leadsToEmptySetPerformed(OclRegistration forRegistration, long time, LeadsToEmptySetResult result) {}
}
