package de.hpi.sam.bp2009.moin.impactAnalyzer.instancescope;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.ocl.ecore.OCLExpression;
import org.omg.ocl.expressions.__impl.OclExpressionInternal;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.shared.util.Tuple.Pair;

public class RefImmediateCompositeNavigationStep extends AbstractNavigationStep {

    public RefImmediateCompositeNavigationStep(EClass sourceType, EClass targetType, OCLExpression debugInfo) {
	super(sourceType, targetType, debugInfo);
    }

    @Override
    protected Set<EObjectImpl> navigate(EObjectImpl fromObject, Map<Map<NavigationStep, EObjectImpl>, Set<EObjectImpl>> cache) {
	Set<EObjectImpl> result = Collections.singleton((EObjectImpl) fromObject.refImmediateComposite());
	return result;
    }

}
