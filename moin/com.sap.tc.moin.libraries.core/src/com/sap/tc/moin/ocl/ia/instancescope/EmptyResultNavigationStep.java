package com.sap.tc.moin.ocl.ia.instancescope;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.omg.ocl.expressions.__impl.OclExpressionInternal;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.shared.util.Tuple.Pair;

public class EmptyResultNavigationStep extends AbsoluteNavigationStep {

    public EmptyResultNavigationStep(OclExpressionInternal debugInfo) {
	super(null, debugInfo);
	setAlwaysEmpty();
    }
    
    @Override
    protected Set<RefObjectImpl> navigate(CoreConnection conn, RefObjectImpl fromObject, Map<Pair<NavigationStep, RefObjectImpl>, Set<RefObjectImpl>> cache) {
	return Collections.emptySet();
    }
    
    @Override
    protected String contentToString(Map<NavigationStep, Integer> visited, int indent) {
	return "<empty>";
    }

}
