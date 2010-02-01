package com.sap.tc.moin.ocl.ia.instancescope;

import java.util.HashMap;
import java.util.Map;

import org.omg.ocl.expressions.AssociationEndCallExp;
import org.omg.ocl.expressions.AttributeCallExp;
import org.omg.ocl.expressions.OclExpression;
import org.omg.ocl.expressions.__impl.OclExpressionInternal;

import com.sap.tc.moin.ocl.ia.ClassScopeAnalyzer;
import com.sap.tc.moin.ocl.ia.relevance.NavigationPath;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.mmi.model.MofClass;

/**
 * The instance scope analysis's goal is to compute {@link NavigationStep} objects for each
 * {@link AttributeCallExp} and {@link AssociationEndCallExp} subexpression in an OCL expression's
 * expression tree. These {@link NavigationStep}s can each be a graph, referring to other
 * potentially composite navigation steps. The graph can even be cyclic, as in the case for
 * recursive operation calls.<p>
 * 
 * During the analysis of the traceback paths, for each subexpression visited, the
 * {@link NavigationPath} for that node is stored in this cache.
 * 
 * @author Axel Uhl D043530
 *
 */
public class PathCache {
    private Map<OclExpression, NavigationStep> subexpressionToPath = new HashMap<OclExpression, NavigationStep>();
    
    public NavigationStep getPathForNode(OclExpression subexpression) {
	return subexpressionToPath.get(subexpression);
    }
    
    public void put(OclExpression subexpression, NavigationStep path) {
	subexpressionToPath.put(subexpression, path);
    }

    NavigationStep getOrCreateNavigationPath(CoreConnection conn, OclExpression sourceExpression, MofClass context, ClassScopeAnalyzer classScopeAnalyzer) {
	NavigationStep result = getPathForNode(sourceExpression);
	if (result == null) {
	    result = InstanceScopeAnalysis.getTracer(conn, sourceExpression).traceback(context, this, classScopeAnalyzer);
	    put(sourceExpression, result);
	}
	return result;
    }

    /**
     * A factory method for {@link NavigationStep}s that combines a sequence of navigation steps into a single new one.
     * In doing so, shortcuts may be taken. For example, if the last step is an absolute step, it is returned as the
     * result because all prior navigations are irrelevant.
     * @param connection TODO
     * @param debugInfo
     *            may be <tt>null</tt>; optionally, use this to tell a debugging user to which OCL (sub-)expression the
     *            navigation step to create belongs
     */
    protected NavigationStep navigationStepFromSequence(CoreConnection connection, OclExpressionInternal debugInfo, NavigationStep... steps) {
	NavigationStep result;
	if (steps[steps.length-1].isAbsolute()) {
	    result = steps[steps.length-1];
	} else {
	    result = new NavigationStepSequence(connection, debugInfo, steps);
	}
	return result;
    }

    /**
     * Creates a navigation step of type {@link IndirectingStep} which can be filled in later
     * by the cliend and enters the placeholder step into this cache for <tt>expr</tt>. This
     * mechanism can be used to create cyclic step graphs without running into an endless
     * recursion. When a lookup happens for <tt>expr</tt>, the indirection step returned by this
     * method will be found in this cache and therefore will not lead to an endless-recursive
     * step creation procedure.
     * 
     * TODO remove debugInfo argument and always use expr instead
     */
    public IndirectingStep createIndirectingStepFor(OclExpression expr, OclExpressionInternal debugInfo) {
	IndirectingStep result = new IndirectingStep(debugInfo);
	put(expr, result);
	return result;
    }
    
}
