package com.sap.tc.moin.ocl.ia.instancescope;

import org.omg.ocl.expressions.__impl.OclExpressionInternal;

import com.sap.tc.moin.repository.mmi.model.MofClass;

public abstract class AbsoluteNavigationStep extends AbstractNavigationStep {

    public AbsoluteNavigationStep(MofClass targetType, OclExpressionInternal debugInfo) {
	super(null, targetType, debugInfo);
    }

    @Override
    public boolean isAbsolute() {
	return true;
    }

}
