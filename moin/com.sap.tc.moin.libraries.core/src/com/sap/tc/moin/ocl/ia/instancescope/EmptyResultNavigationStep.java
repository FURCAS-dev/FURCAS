package com.sap.tc.moin.ocl.ia.instancescope;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.omg.ocl.expressions.__impl.OclExpressionInternal;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.shared.util.Tuple.Pair;

public class EmptyResultNavigationStep extends AbsoluteNavigationStep {

    public EmptyResultNavigationStep(OclExpressionInternal debugInfo) {
	super(null, debugInfo);
	setAlwaysEmpty();
    }
    
    @Override
    protected Set<AnnotatedRefObjectImpl> navigate(CoreConnection conn, AnnotatedRefObjectImpl fromObject, Map<Pair<NavigationStep, RefObjectImpl>, Set<AnnotatedRefObjectImpl>> cache, Set<Pair<RefFeatured, RefObject>> throwExceptionWhenVisiting) {
	return Collections.emptySet();
    }
    
    @Override
    protected String contentToString(Map<NavigationStep, Integer> visited, int indent) {
	return "<empty>";
    }

}
