package com.sap.tc.moin.ocl.ia.instancescope;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.omg.ocl.expressions.__impl.OclExpressionInternal;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.mmi.model.MofClass;

public class RefImmediateCompositeNavigationStep extends AbstractNavigationStep {

    public RefImmediateCompositeNavigationStep(MofClass sourceType, MofClass targetType, OclExpressionInternal debugInfo) {
	super(sourceType, targetType, debugInfo);
    }

    @Override
    protected Collection<RefObjectImpl> navigate(CoreConnection conn, RefObjectImpl fromObject) {
	Set<RefObjectImpl> result = Collections.singleton((RefObjectImpl) fromObject.refImmediateComposite(conn.getSession()));
	return result;
    }

}
