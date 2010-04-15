package de.hpi.sam.bp2009.moin.impactAnalyzer.instancescope;

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
    protected Set<RefObjectImpl> navigate(CoreConnection conn, RefObjectImpl fromObject, Map<Pair<NavigationStep, RefObjectImpl>, Set<RefObjectImpl>> cache) {
	Set<RefObjectImpl> result = Collections.singleton((RefObjectImpl) fromObject.refImmediateComposite(conn.getSession()));
	return result;
    }

}
