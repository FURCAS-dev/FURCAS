package com.sap.tc.moin.ocl.ia.instancescope;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.omg.ocl.expressions.__impl.OclExpressionInternal;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;

public class EmptyResultNavigationStep extends AbsoluteNavigationStep {

    public EmptyResultNavigationStep(OclExpressionInternal debugInfo) {
	super(null, debugInfo);
	setAlwaysEmpty();
    }
    
    @Override
    protected Collection<RefObjectImpl> navigate(CoreConnection conn, RefObjectImpl fromObject) {
	return Collections.emptySet();
    }
    
    @Override
    protected String contentToString(Map<NavigationStep, Integer> visited, int[] maxId, int indent) {
	return "<empty>";
    }

}
