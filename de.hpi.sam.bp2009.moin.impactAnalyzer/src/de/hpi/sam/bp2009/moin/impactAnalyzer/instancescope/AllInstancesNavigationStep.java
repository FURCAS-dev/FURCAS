package de.hpi.sam.bp2009.moin.impactAnalyzer.instancescope;

import java.util.Map;
import java.util.Set;

import org.omg.ocl.expressions.__impl.OclExpressionInternal;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.shared.util.Tuple.Pair;

public class AllInstancesNavigationStep extends AbstractNavigationStep {
    private final boolean absolute;
    
    /**
     * Constructs an {@link NavigationStep#isAbsolute() absolute} navigation step that
     * without consideration of the <tt>fromObject</tt>'s type always computes all
     * instances of the {@link NavigationStep#getTargetType() target type} and all
     * its direct and indirect subtypes.
     * @param debugInfo TODO
     */
    public AllInstancesNavigationStep(MofClass targetType, OclExpressionInternal debugInfo) {
	super(null, targetType, debugInfo);
	absolute = true;
    }
    
    /**
     * Constructs a non-{@link NavigationStep#isAbsolute() absolute} navigation step that
     * computes all instances of <tt>targetType</tt> and all its direct and indirect subtypes,
     * if the <tt>fromObject</tt> passed to {@link #navigate(CoreConnection, RefObjectImpl, Map)}
     * conforms to the <tt>sourceType</tt>. Otherwise, an empty set is returned. The
     * consideration of the <tt>fromObject</tt> is the reason why if constructed with this
     * constructor an object of this class is not absolute.
     * @param debugInfo TODO
     */
    public AllInstancesNavigationStep(MofClass sourceType, MofClass targetType, OclExpressionInternal debugInfo) {
	super(sourceType, targetType, debugInfo);
	absolute = false;
    }
    
    @Override
    public boolean isAbsolute() {
	return absolute;
    }

    @Override
    protected Set<RefObjectImpl> navigate(CoreConnection conn, RefObjectImpl fromObject, Map<Pair<NavigationStep, RefObjectImpl>, Set<RefObjectImpl>> cache) {
	return InstanceScopeAnalysis.getAllPossibleContextInstances(conn, getTargetType());
    }

    @Override
    protected String contentToString(Map<NavigationStep, Integer> visited, int indent) {
	return "allInstances("+getTargetType().getName()+")";
    }
}
