package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.OCLExpression;

import com.sap.emf.oppositeendfinder.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.impactAnalyzer.OCLFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.SemanticIdentity;

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
public class PathCache extends AbstractPathCache<NavigationStep> implements HashCodeChangeListener {
    /**
     * Contains all distinct steps contained in {@link #subexpressionToPath}. Can be used to look up semantically equal steps in
     * order not to create redundant steps. Values are identical to keys per entry.
     */
    private final Map<SemanticIdentity, NavigationStep> allNavigationSteps = new HashMap<SemanticIdentity, NavigationStep>();
    /**
     * @param instanceScopeAnalysis for special cases, e.g., when callers need to invoke this constructor in a super(...)
     * initializer of InstanceScopeAnalysis or its descendents, it may not be possible to pass a readily-initialized
     * object. Therefore, it is permissible to pass <code>null</code> here and immediately after the constructor call invoke
     * the protected {@link #setInstanceScopeAnalysis} operation with the now initialized object.
     */
    public PathCache(OppositeEndFinder oppositeEndFinder, InstanceScopeAnalysis instanceScopeAnalysis) {
        super(oppositeEndFinder, instanceScopeAnalysis);
    }
    
    /**
     * Also adds <code>path</code> to {@link #allNavigationSteps}. If the source type is <code>null</code> and the step is not
     * absolute, this path cache registers as a listener on the step (see
     * {@link NavigationStep#addSourceTypeChangeListener(SourceTypeChangeListener)}. If the target type is <code>null</code>, this
     * path cache registers as target type listener on the step (see
     * {@link NavigationStep#addTargetTypeChangeListener(TargetTypeChangeListener)}. If the step is not marked as always empty,
     * this path cache registers as listener for a change in the step's always-empty setting. If any of these change events are
     * received, the respective step is re-hashed into {@link #allNavigationSteps}.
     */
    public void put(OCLExpression subexpression, Stack<String> tupleLiteralPartNamesToLookFor, NavigationStep path) {
        super.put(subexpression, tupleLiteralPartNamesToLookFor, path);
        if (!allNavigationSteps.containsKey(path.getSemanticIdentity())) {
            allNavigationSteps.put(path.getSemanticIdentity(), path);
            path.addHashCodeChangeListener(this);
        }
    }

    /**
     * A factory method for {@link NavigationStep}s that combines a sequence of navigation steps into a single new one. In doing
     * so, shortcuts may be taken. For example, if the last step is an absolute step, it is returned as the result because all
     * prior navigations are irrelevant. Also, if there is only one step in <code>steps</code>, that step is simply used.
     * <p>
     * 
     * The method first performs a cache lookup. Callers must make sure that the expression returned by this method will be used
     * as the resulting step for <code>expression</code>. In particular, they must not create an {@link IndirectingStep} as the
     * resulting step for <code>expression</code> in which the step produced by this method is only plugged in as an actual step.
     * This would lead to the {@link IndirectingStep} being found in the cache instead of a {@link NavigationStepSequence} being
     * constructed.
     * 
     * @param expression
     *            Additionally, this is used to tell a debugging user to which OCL (sub-)expression the navigation step to create
     *            belong (see {@link AbstractNavigationStep#getDebugInfo()}). The step constructed here must be used as the
     *            resulting navigation step for <tt>expression</tt>. Callers therefore should ensure that in case this operation
     *            is called multiple times on the same object for the same expression, then the steps have to have equal semantics
     *            because subsequent calls will pull the result from the cache if available instead of creating a new one.
     */
    protected NavigationStep navigationStepFromSequence(OCLExpression expression, Stack<String> tupleLiteralPartNamesToLookFor,
            NavigationStep... steps) {
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
    protected NavigationStep navigationStepForBranch(EClass sourceType, EClass targetType, OCLExpression expression,
            Stack<String> tupleLiteralPartNamesToLookFor, NavigationStep... steps) {
        NavigationStep result;
        if (steps.length == 1) {
            result = steps[0];
        } else {
            result = new BranchingNavigationStep(sourceType, targetType, expression, steps);
        }
        return result;
    }

    @SuppressWarnings("unused")
    private boolean incrementallyReduceSteps(List<NavigationStep> steps, EClass sourceType, EClass targetType) {
        boolean somethingHasChanged = false;

        // TODO: Change to Set
        List<SemanticIdentity> newStepListIdentities = getSemanticIdentities(steps);
        List<BranchingNavigationStep> subSetBranches = new ArrayList<BranchingNavigationStep>();

        for (SemanticIdentity identity : allNavigationSteps.keySet()) {
            if (identity.getStep() instanceof BranchingNavigationStep) {
                BranchingNavigationStep oldStep = (BranchingNavigationStep) identity.getStep();
                List<SemanticIdentity> oldStepListIdentities = getSemanticIdentities(Arrays.asList(oldStep.getSteps()));

                if (sourceType != null && oldStep.getSourceType() != null && sourceType.equals(oldStep.getSourceType())
                        && targetType != null && oldStep.getTargetType() != null && targetType.equals(oldStep.getTargetType())) {
                    if (newStepListIdentities.containsAll(oldStepListIdentities)) {
                        subSetBranches.add(oldStep);
                    }
                }
            }
        }

        if (subSetBranches.size() > 0) {
            BranchingNavigationStep replacementStep = getBranchingStepWithHighestNumberOfSteps(subSetBranches);
            List<NavigationStep> stepsToDelete = Arrays.asList(replacementStep.getSteps());
            if (steps.removeAll(stepsToDelete)) {
                steps.add(replacementStep);
                somethingHasChanged = true;
            }
        }

        return somethingHasChanged;
    }

    public BranchingNavigationStep getBranchingStepWithHighestNumberOfSteps(List<BranchingNavigationStep> list) {
        BranchingNavigationStep biggestStep = list.get(0);

        for (BranchingNavigationStep step : list) {
            if (step.getSteps().length > biggestStep.getSteps().length) {
                biggestStep = step;
            }
        }

        return biggestStep;
    }

    public List<SemanticIdentity> getSemanticIdentities(List<NavigationStep> steps) {
        List<SemanticIdentity> result = new ArrayList<SemanticIdentity>(steps.size());

        for (NavigationStep step : steps) {
            result.add(step.getSemanticIdentity());
        }

        return result;
    }

    // TODO: Rename
    // TODO: Add doc
    public NavigationStep reduceToCachedStep(NavigationStep step) {
        if (allNavigationSteps.containsKey(step.getSemanticIdentity())) {
            return allNavigationSteps.get(step.getSemanticIdentity());
        }

        allNavigationSteps.put(step.getSemanticIdentity(), step);

        return step;
    }

    /**
     * Creates a navigation step of type {@link IndirectingStep} which can be filled in later by the cliend and enters the
     * placeholder step into this cache for <tt>expr</tt>. This mechanism can be used to create cyclic step graphs without running
     * into an endless recursion. When a lookup happens for <tt>expr</tt>, the indirection step returned by this method will be
     * found in this cache and therefore will not lead to an endless-recursive step creation procedure.
     */
    public IndirectingStep createIndirectingStepFor(OCLExpression expr, Stack<String> tupleLiteralPartNamesToLookFor) {
        IndirectingStep result = new IndirectingStep(expr);
        put(expr, tupleLiteralPartNamesToLookFor, result);
        return result;
    }

    public void beforeHashCodeChange(NavigationStep step, int token) {
        allNavigationSteps.remove(step.getSemanticIdentity());
    }

    public void afterHashCodeChange(NavigationStep step, int token) {
        allNavigationSteps.put(step.getSemanticIdentity(), step);
    }

    @Override
    protected NavigationStep createStep(OCLExpression sourceExpression, EClass context,
            OperationBodyToCallMapper operationBodyToCallMapper, Stack<String> tupleLiteralNamesToLookFor, OCLFactory oclFactory) {
        NavigationStep result = getInstanceScopeAnalysis().createTracer(sourceExpression, tupleLiteralNamesToLookFor, oclFactory).traceback(context, this,
                operationBodyToCallMapper);
        NavigationStep existingEqualStep = allNavigationSteps.get(result);
        if (existingEqualStep != null) {
            result = existingEqualStep;
            result.addExpressionForWhichThisIsNavigationStep(sourceExpression);
        }
        return result;
    }
    
}
