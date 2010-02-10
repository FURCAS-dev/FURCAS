package com.sap.tc.moin.textual.moinadapter.adapter.stub;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.omg.ocl.expressions.OclExpression;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.ocl.debugger.OclDebuggerNode;
import com.sap.tc.moin.repository.ocl.freestyle.ExpressionInvalidationListener;
import com.sap.tc.moin.repository.ocl.freestyle.OclExpressionRegistration;
import com.sap.tc.moin.repository.ocl.freestyle.OclRegistrationType;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationSeverity;

public class OclExpressionRegistrationStub implements OclExpressionRegistration {

	public RefObject result;
	
	@Override
	public OclDebuggerNode debugExpression(RefObject context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object evaluateExpression(RefObject context) {
		return result;
	}

	@Override
	public boolean registerEventBasedInvalidationListener(
			ExpressionInvalidationListener listener, boolean immediate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerPartitionBasedInvalidationListener(String category,
			ExpressionInvalidationListener listener)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unregisterInvalidationListener(
			ExpressionInvalidationListener listener) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<String> getCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOclExpression() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OclRegistrationSeverity getSeverity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OclRegistrationType getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OclDebuggerNode debugExpression(MRI context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object evaluateExpression(MRI context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean registerEventBasedInvalidationListener(
			ExpressionInvalidationListener listener,
			Collection<MRI> objectFilter, boolean immediate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerPartitionBasedInvalidationListener(String category,
			ExpressionInvalidationListener listener,
			Collection<MRI> objectFilter) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<MRI> getAffectedModelElements(ModelChangeEvent mce, Connection con) {
	    // TODO Auto-generated method stub
	    return null;
	}

	@Override
	public EventFilter getEventFilter(boolean notifyNewContextElement) {
	    // TODO Auto-generated method stub
	    return null;
	}

	@Override
	public RefObject getContext() {
	    // TODO Auto-generated method stub
	    return null;
	}

	@Override
	public OclExpression getExpression() {
	    // TODO Auto-generated method stub
	    return null;
	}

	@Override
	public Set<MRI> getAffectedModelElements(EventChain events, Connection conn) {
	    // TODO Auto-generated method stub
	    return null;
	}

	@Override
	public boolean isUnaffectedDueToPrimitiveAttributeValueComparisonWithLiteralOnly(List<ChangeEvent> events,
		String replacementFor__TEMP__) {
	    // TODO Auto-generated method stub
	    return false;
	}

}
