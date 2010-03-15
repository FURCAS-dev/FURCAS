package com.sap.tc.moin.ocl.ia.instancescope;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.omg.ocl.expressions.__impl.OclExpressionInternal;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.shared.util.Tuple.Pair;

public class RefImmediateCompositeNavigationStep extends AbstractNavigationStep {

    public RefImmediateCompositeNavigationStep(MofClass sourceType, MofClass targetType, OclExpressionInternal debugInfo) {
	super(sourceType, targetType, debugInfo);
    }

    @Override
    protected Set<AnnotatedRefObjectImpl> navigate(CoreConnection conn, AnnotatedRefObjectImpl fromObject, Map<Pair<NavigationStep, RefObjectImpl>, Set<AnnotatedRefObjectImpl>> cache) {
	Set<AnnotatedRefObjectImpl> result = Collections.singleton(
		annotateRefObject(conn, fromObject, 
		((RefObjectImpl) fromObject.getElement().refImmediateComposite(conn.getSession()))));
	return result;
    }

}
