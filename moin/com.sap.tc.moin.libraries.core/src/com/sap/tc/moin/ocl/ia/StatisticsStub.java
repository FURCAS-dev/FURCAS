package com.sap.tc.moin.ocl.ia;

import java.util.List;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.core.ocl.service.impl.OclExpressionRegistrationImpl;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.ocl.freestyle.OclExpressionRegistration;

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
}
