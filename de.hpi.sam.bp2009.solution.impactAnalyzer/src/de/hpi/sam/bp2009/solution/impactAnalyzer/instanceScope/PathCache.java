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
public class PathCache implements HashCodeChangeListener {
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
     * Contains all distinct steps contained in {@link #subexpressionToPath}. Can be used to look up
     * semantically equal steps in order not to create redundant steps. Values are identical to keys per entry.
     */
    private final Map<NavigationStep, NavigationStep> allNavigationSteps = new HashMap<NavigationStep, NavigationStep>();

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

    /**
     * Also adds <code>path</code> to {@link #allNavigationSteps}. If the source type is <code>null</code>
     * and the step is not absolute, this path cache registers as a listener on the step (see
     * {@link NavigationStep#addSourceTypeChangeListener(SourceTypeChangeListener)}. If the target
     * type is <code>null</code>, this path cache registers as target type listener on the step
     * (see {@link NavigationStep#addTargetTypeChangeListener(TargetTypeChangeListener)}. If the
     * step is not marked as always empty, this path cache registers as listener for a change in
     * the step's always-empty setting. If any of these change events are received, the respective step
     * is re-hashed into {@link #allNavigationSteps}.
     */
    private void put(OCLExpression subexpression, String[] tupleLiteralPartNamesToLookFor, NavigationStep path) {
        List<String> tupleLiteralPartNamesToLookForAsList = getTupleLiteralPartNamesToLookForAsList(tupleLiteralPartNamesToLookFor);
        subexpressionToPath.put(new Pair<OCLExpression, List<String>>(subexpression, tupleLiteralPartNamesToLookForAsList), path);
        if (!allNavigationSteps.containsKey(path)) {
            allNavigationSteps.put(path, path);
            path.addHashCodeChangeListener(this);
        }
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

    public NavigationStep getOrCreateNavigationPath(OCLExpression sourceExpression, EClass context,
            FilterSynthesisImpl filterSynthesizer, String[] tupleLiteralNamesToLookFor) {
        NavigationStep result = getPathForNode(sourceExpression, tupleLiteralNamesToLookFor);
        if (result == null) {
            result = InstanceScopeAnalysis.createTracer(sourceExpression, tupleLiteralNamesToLookFor).traceback(context, this, filterSynthesizer);
            NavigationStep existingEqualStep = allNavigationSteps.get(result);
            if (existingEqualStep != null) {
                result = existingEqualStep;
                result.addExpressionForWhichThisIsNavigationStep(sourceExpression);
            }
            put(sourceExpression, tupleLiteralNamesToLookFor, result);
        }
        return result;
    }

    /**
     * A factory method for {@link NavigationStep}s that combines a sequence of navigation steps into a single new one. In doing
     * so, shortcuts may be taken. For example, if the last step is an absolute step, it is returned as the result because all
     * prior navigations are irrelevant. Also, if there is only one step in <code>steps</code>, that step is simply used.<p>
     * 
     * The method first performs a cache lookup. Callers must make sure that the expression returned by this method
     * will be used as the resulting step for <code>expression</code>. In particular, they must not create an
     * {@link IndirectingStep} as the resulting step for <code>expression</code> in which the step produced by this
     * method is only plugged in as an actual step. This would lead to the {@link IndirectingStep} being found in the
     * cache instead of a {@link NavigationStepSequence} being constructed.
     *
     * @param expression
     *            Additionally, this is used to tell a debugging user to which OCL (sub-)expression the navigation step to create
     *            belong (see {@link AbstractNavigationStep#getDebugInfo()}). The step constructed here must be used as the
     *            resulting navigation step for <tt>expression</tt>. Callers therefore should ensure that in case this operation
     *            is called multiple times on the same object for the same expression, then the steps have to have equal semantics
     *            because subsequent calls will pull the result from the cache if available instead of creating a new one.
     */
    protected NavigationStep navigationStepFromSequence(OCLExpression expression, String[] tupleLiteralPartNamesToLookFor, NavigationStep... steps) {
        // caching here is not harmful because all known usages so far don't create an IndirectingStep for the same expression
        // but immediately return the NavigationStepSequence step returned by this operation
        NavigationStep result = getPathForNode(expression, tupleLiteralPartNamesToLookFor);
        if (result == null) {
            if (steps.length == 1) {
                // only one step; don't bother to wrap a sequence around it
                result = steps[0];
            } else {
                // find first absolute step; can skip all prior steps as their results don't matter for the absolute step
                int firstAbsoluteStep = 0;
                for (int i = 0; i < steps.length; i++) {
                    if (steps[i].isAbsolute()) {
                        firstAbsoluteStep = i;
                        break;
                    }
                }
                if (firstAbsoluteStep == steps.length - 1) {
                    // only one step remains; return it and don't construct a NavigationStepSequence:
                    result = steps[steps.length - 1];
                } else {
                    NavigationStep[] tail;
                    if (firstAbsoluteStep > 0) {
                        tail = new NavigationStep[steps.length - firstAbsoluteStep];
                        System.arraycopy(steps, firstAbsoluteStep, tail, 0, steps.length - firstAbsoluteStep);
                    } else {
                        tail = steps;
                    }
                    result = new NavigationStepSequence(expression, tail);
                }
            }
            put(expression, tupleLiteralPartNamesToLookFor, result);
        }
        return result;
    }

    /**
     * A non-caching, no-cache-lookup factory operation for a branching step for <code>steps</code>. If <code>steps</code>
     * contains only one step, that step is returned without constructing a {@link BranchingNavigationStep} around it.
     */
    protected NavigationStep navigationStepForBranch(EClass sourceType, EClass targetType,
            OCLExpression expression, String[] tupleLiteralPartNamesToLookFor, NavigationStep... steps) {
        NavigationStep result;
        if (steps.length == 1) {
            result = steps[0];
        } else {
            result = new BranchingNavigationStep(sourceType, targetType, expression, steps);
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

    @Override
    public void beforeHashCodeChange(NavigationStep step, int token) {
        allNavigationSteps.remove(step);
    }

    @Override
    public void afterHashCodeChange(NavigationStep step, int token) {
        allNavigationSteps.put(step, step);
    }

}
