package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.TupleLiteralExp;

import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.impactAnalyzer.filterSynthesis.FilterSynthesisImpl;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.Tuple.Pair;

/**
 * The instance scope analysis's goal is to compute {@link NavigationStep} objects for each {@link AttributeCallExp} and
 * {@link AssociationEndCallExp} subexpression in an OCL expression's expression tree. These {@link NavigationStep}s can each be a
 * graph, referring to other potentially composite navigation steps. The graph can even be cyclic, as in the case for recursive
 * operation calls.
 * <p>
 *
 * During the analysis of the <em>traceback</em> paths, for each subexpression visited, the {@link NavigationPath} for that node
 * is stored in this cache.
 * <p>
 *
 * Don't re-use an instance of this class for analyzing more than one expression when those expressions are dynamically parsed
 * because in those cases, new operation calls are created dynamically which turn existing entries in the {@link PathCache} for
 * <tt>self</tt> and parameter expressions of the operation called invalid. Additionally, all dependent paths would become invalid
 * too. Identifying and removing those entries from a {@link PathCache} seems to cause more effort than using a new
 * {@link PathCache} object for each expression analyzed, particularly given the fact that the {@link NavigationPath} assembly
 * only has to happen once per life-time of an {@link OCLExpression<EClassifier>} during a session.
 *
 */
public class PathCache {
    /**
     * Keys are OCL expressions for which a navigation path is cached, together with a list of tuple part names to be collected
     * during construction of that step. Only if this list is equal during construction then the step can be re-used. Example:
     * <p>
     *
     * <pre>
     *     let a:Tuple{x1:X=self.myX1, x2:X=self.myX2} in
     *     Set{a.x1, a.x2}->collect(x | x.name)
     * </pre>
     *
     * If this expression is analyzed for an attribute change event of an <tt>X.name</tt>, the iterator variable <tt>x</tt> is
     * traced back to the collect's source expression which is the collection literal. A branching step is created with one branch
     * for each of its literal parts. Both parts access a tuple part, one the <tt>x1</tt> part, the other the <tt>x2</tt> part of
     * the same tuple. For <tt>a.x1</tt> the tracer pushes "x1" onto the "stack" and constructs a tracer for the <tt>a</tt> source
     * expression. The {@link VariableExpTracer} finds the let expression and constructs the navigation path for the variable's
     * init expression. This, however, is the same {@link TupleLiteralExp} that will be found when tracing back the <tt>a</tt> in
     * <tt>a.x2</tt>. However, the first time the {@link TupleLiteralExpTracer} is constructed, it needs to descend into the
     * <tt>x1</tt> part's init expression whereas for the <tt>a.x2</tt> it needs to descend into <tt>x2</tt>'s init expression.
     * <p>
     *
     * This shows that a navigation path can only be re-used if the request for its construction has an equal list of tuple
     * literal part names on the "stack" as the one cached.<p>
     *
     * The <tt>List<String></tt> element of the key pair may be <tt>null</tt>. It <em>must</em> be <tt>null</tt>
     * instead of passing an empty list to avoid ambiguities.
     */
    private final Map<Pair<OCLExpression, List<String>>, NavigationStep> subexpressionToPath = new HashMap<Pair<OCLExpression, List<String>>, NavigationStep>();

    /**
     * Can be used for certain metamodel queries such as finding all subclasses, but as well during an
     * <code>allInstances</code> query.
     */
    private final OppositeEndFinder oppositeEndFinder;

    public PathCache(OppositeEndFinder oppositeEndFinder) {
        this.oppositeEndFinder = oppositeEndFinder;
    }

    public OppositeEndFinder getOppositeEndFinder() {
        return oppositeEndFinder;
    }

    public NavigationStep getPathForNode(OCLExpression subexpression, String[] tupleLiteralPartNamesToLookFor) {
        return subexpressionToPath.get(new Pair<OCLExpression, List<String>>(subexpression,
                getTupleLiteralPartNamesToLookForAsList(tupleLiteralPartNamesToLookFor)));
    }

    private void put(OCLExpression subexpression, String[] tupleLiteralPartNamesToLookFor, NavigationStep path) {
        List<String> tupleLiteralPartNamesToLookForAsList = getTupleLiteralPartNamesToLookForAsList(tupleLiteralPartNamesToLookFor);
        subexpressionToPath.put(new Pair<OCLExpression, List<String>>(subexpression, tupleLiteralPartNamesToLookForAsList), path);
    }

    private static List<String> getTupleLiteralPartNamesToLookForAsList(String[] tupleLiteralPartNamesToLookFor) {
        List<String> tupleLiteralPartNamesToLookForAsList;
        if (tupleLiteralPartNamesToLookFor == null || tupleLiteralPartNamesToLookFor.length == 0) {
            tupleLiteralPartNamesToLookForAsList = null;
        } else {
            tupleLiteralPartNamesToLookForAsList = Arrays.asList(tupleLiteralPartNamesToLookFor);
        }
        return tupleLiteralPartNamesToLookForAsList;
    }

    NavigationStep getOrCreateNavigationPath(OCLExpression sourceExpression, EClass context,
            FilterSynthesisImpl filterSynthesizer, String[] tupleLiteralNamesToLookFor) {
        NavigationStep result = getPathForNode(sourceExpression, tupleLiteralNamesToLookFor);
        if (result == null) {
            result = InstanceScopeAnalysis.createTracer(sourceExpression, tupleLiteralNamesToLookFor).traceback(context, this, filterSynthesizer);
            put(sourceExpression, tupleLiteralNamesToLookFor, result);
        }
        return result;
    }

    /**
     * A factory method for {@link NavigationStep}s that combines a sequence of navigation steps into a single new one. In doing
     * so, shortcuts may be taken. For example, if the last step is an absolute step, it is returned as the result because all
     * prior navigations are irrelevant.
     *
     * @param expression
     *            Additionally, this is used to tell a debugging user to which OCL (sub-)expression the navigation step to create
     *            belong (see {@link AbstractNavigationStep#getDebugInfo()}). The step constructed here must be used as the
     *            resulting navigation step for <tt>expression</tt>. Callers therefore should ensure that in case this operation
     *            is called multiple times on the same object for the same expression, then the steps have to have equal semantics
     *            because subsequent calls will pull the result from the cache if available instead of creating a new one.
     * @param tupleLiteralPartNamesToLookFor TODO
     */
    protected NavigationStep navigationStepFromSequence(OCLExpression expression, String[] tupleLiteralPartNamesToLookFor, NavigationStep... steps) {
        NavigationStep result = getPathForNode(expression, tupleLiteralPartNamesToLookFor);
        if (result == null) {
            if (steps[steps.length - 1].isAbsolute()) {
                result = steps[steps.length - 1];
            } else {
                result = new NavigationStepSequence(expression, steps);
            }
            put(expression, tupleLiteralPartNamesToLookFor, result);
        }
        return result;
    }

    /**
     * Creates a navigation step of type {@link IndirectingStep} which can be filled in later by the cliend and enters the
     * placeholder step into this cache for <tt>expr</tt>. This mechanism can be used to create cyclic step graphs without running
     * into an endless recursion. When a lookup happens for <tt>expr</tt>, the indirection step returned by this method will be
     * found in this cache and therefore will not lead to an endless-recursive step creation procedure.
     * @param tupleLiteralPartNamesToLookFor TODO
     */
    public IndirectingStep createIndirectingStepFor(OCLExpression expr, String[] tupleLiteralPartNamesToLookFor) {
        IndirectingStep result = new IndirectingStep(expr);
        put(expr, tupleLiteralPartNamesToLookFor, result);
        return result;
    }



}
