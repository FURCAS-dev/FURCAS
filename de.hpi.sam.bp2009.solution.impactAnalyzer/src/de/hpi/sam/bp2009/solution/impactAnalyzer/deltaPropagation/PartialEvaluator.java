package de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.query2.EcoreHelper;
import org.eclipse.ocl.ecore.CallExp;
import org.eclipse.ocl.ecore.IfExp;
import org.eclipse.ocl.ecore.IteratorExp;
import org.eclipse.ocl.ecore.LoopExp;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.utilities.PredefinedType;

import de.hpi.sam.bp2009.solution.impactAnalyzer.OperationBodyToCallMapper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.Tuple.Pair;

/**
 * Can evaluate a {@link CallExp} expression, given the evaluation result of its {@link CallExp#getSource() source}
 * expression. For this, it uses an adapted OCL evaluation environment.
 * 
 * @author Axel Uhl
 *
 */
public class PartialEvaluator {
    private OCL ocl;
    private Helper helper;
    private PartialEcoreEnvironmentFactory factory;
    
    public PartialEvaluator() {
        factory = new PartialEcoreEnvironmentFactory();
        initOcl();
    }

    private void initOcl() {
        ocl = OCL.newInstance(factory);
        helper = ocl.createOCLHelper();
    }
    
    /**
     * Taking a {@link Notification} object such that an evaluation will be based on the state *before* the notification.
     * For example, if the notification indicates the removal of a reference from an element <tt>e1</tt> to an element <tt>e2</tt>
     * across reference <tt>r</tt> then when during partial evaluation <tt>r</tt> is traversed starting from <tt>e1</tt>
     * then <tt>e2</tt> will show in the results although in the current version of the model it would not.
     */
    public PartialEvaluator(Notification atPre) {
        factory = new PartialEcoreEnvironmentFactory(atPre);
        initOcl();
    }
    
    public OCL getOcl() {
        return ocl;
    }

    public Helper getHelper() {
        return helper;
    }

    /**
     * Evaluates <tt>e</tt>, assuming <tt>valueOfSourceExpression</tt> is the value to which
     * {@link CallExp#getSource() e's source expression} evaluates. This means that during <tt>e</tt>'s
     * evaluation the evaluator won't attempt to evaluate the source expression but uses the
     * value provided in <tt>valueOfSourceExpression</tt> instead.<p>
     * 
     * @param context a value for <tt>self</tt> can optionally be provided here. If <tt>null</tt> is
     * specified, a {@link ValueNotFoundException} will be thrown upon trying to fetch the <tt>self</tt>
     * value.
     * @throws ValueNotFoundException in case a variable is accessed that hasn't previously been defined. This
     * can happen during partial evaluation when a variable would have been defined by a superior expression
     * of which <tt>e</tt> is only a subexpression.
     */
    public Object evaluate(Object context, CallExp e, Object valueOfSourceExpression) {
        factory.setExpressionValue((OCLExpression) e.getSource(), valueOfSourceExpression);
        return ocl.evaluate(context, e);
    }
    
    /**
     * Determines the operation of which <tt>bodyExpression</tt> is the body. If <tt>bodyOperation</tt>
     * is not the body of an operation in the scope of <tt>mapper</tt>, then <tt>null</tt> is returned.
     */
    private EOperation getOperationFromBody(OCLExpression bodyExpression, OperationBodyToCallMapper mapper) {
        EOperation result = null;
        Set<OperationCallExp> calls = mapper.getCallsOf(bodyExpression);
        if (!calls.isEmpty()) {
            result = calls.iterator().next().getReferredOperation();
        }
        return result;
    }

    /**
     * Determines if a change of <tt>callExp</tt>'s source expression's value from <tt>oldSourceValue</tt> to
     * <tt>newSourceValue</tt> may or may not have an effect on the overall expression by which <tt>callExp</tt> is used. If this
     * methods returns <tt>true</tt> then this guarantees that the change has no effect. If it returns <tt>false</tt> this only
     * means that the absence of an effect could not be proven and that it is still possible that the change had no effect.
     * <p>
     * 
     * The method first applies partial evaluation along chains of {@link CallExp} and operation calls. If the computation of the
     * full value based on old and new source value reaches the end of such a chain of {@link CallExp} and operation
     * body/operation call constructs, {@link #transitivelyPropagateDelta(OCLExpression, Collection)} tries to
     * propagate the delta between old and new value further. If the result of this delta propagation is empty for all
     * expressions to which it propagates then this proves that the original change indicated by <tt>oldSourceValue</tt>
     * and <tt>newSourceValue</tt> has no effect on the overall expression.
     * 
     * @param mapper
     *            needs to be able to map an operation body in which <tt>callExp</tt> is used to the calls of that operation, as
     *            well as all operation calls in which those calls appear (transitively) to the calls of those operations, and so
     *            on, for the overall expression for which the effect of the change is to be analyzed.
     */
    public boolean hasNoEffectOnOverallExpression(CallExp callExp, Object oldSourceValue, Object newSourceValue,
            OperationBodyToCallMapper mapper) {
        boolean result;
        boolean oldEqualsNew = (oldSourceValue == null && newSourceValue == null) ||
                               (oldSourceValue != null && oldSourceValue.equals(newSourceValue));
        if (oldEqualsNew) {
            result = true;
        } else {
            try {
                Object oldCallExpValue = evaluate(/* self context */null, callExp, oldSourceValue);
                Object newCallExpValue = evaluate(/* self context */null, callExp, newSourceValue);
                boolean oldCallExpValueEqualsNewCallExpValue = (oldCallExpValue == null && newCallExpValue == null)
                        || (oldCallExpValue != null && oldCallExpValue.equals(newCallExpValue));
                if (oldCallExpValueEqualsNewCallExpValue) {
                    result = true;
                } else {
                    // Is callExp source of another CallExp?
                    ResourceSet rs = callExp.eResource().getResourceSet();
                    if (rs == null) {
                        rs = new ResourceSetImpl();
                    }
                    EcoreHelper helper = EcoreHelper.getInstance();
                    Collection<EObject> appliedElement = helper.reverseNavigate(callExp, ExpressionsPackage.eINSTANCE.getCallExp_Source(),
                            helper.getQueryContext(rs), rs);
                    if (!appliedElement.isEmpty()) {
                        // yes, it's source of another CallExp; recurse:
                        CallExp callExpCallingCallExp = (CallExp) appliedElement.iterator().next();
                        result = hasNoEffectOnOverallExpression(callExpCallingCallExp, oldCallExpValue, newCallExpValue, mapper);
                    } else {
                        // not source of another CallExp; check if it's an operation body
                        EOperation op = getOperationFromBody(callExp, mapper);
                        if (op != null) {
                            result = true;
                            for (OperationCallExp call : mapper.getCallsOf(callExp)) {
                                Collection<EObject> appliedElementOfOperationCall = helper.reverseNavigate(call,
                                        ExpressionsPackage.eINSTANCE.getCallExp_Source(), helper.getQueryContext(rs),
                                        rs);
                                if (appliedElementOfOperationCall.isEmpty()) {
                                    result = false; // operation call not source of another CallExp
                                    break;
                                } else {
                                    result = hasNoEffectOnOverallExpression(call, oldCallExpValue, newCallExpValue, mapper);
                                    if (!result) {
                                        // if one operation call may have an effect then so may the original change
                                        break;
                                    }
                                }
                            }
                        } else {
                            // not an operation body either; try delta propagation:
                            Collection<Object> delta = symmetricDifference(oldSourceValue, newSourceValue);
                            result = transitivelyPropagateDelta(callExp, delta, mapper).isEmpty();
                        }
                    }
                }
            } catch (ValueNotFoundException e) {
                // can't perform the partial evaluation due to access to undefined variable
                result = false; // we don't know, so we have to answer conservatively
            }
        }
        return result;
    }
    
    @SuppressWarnings("unchecked")
    private Collection<Object> symmetricDifference(Object oldSourceValue, Object newSourceValue) {
        Collection<Object> result;
        Collection<Object> oldSourceValueAsCollection = ((oldSourceValue instanceof Collection<?> ? (Collection<Object>) oldSourceValue
                : Collections.singleton(oldSourceValue)));
        Collection<Object> newSourceValueAsCollection = ((newSourceValue instanceof Collection<?> ? (Collection<Object>) newSourceValue
                : Collections.singleton(newSourceValue)));
        result = new HashSet<Object>();
        result.addAll(oldSourceValueAsCollection);
        result.removeAll(newSourceValueAsCollection);
        Collection<Object> newSourceValueMinusOldSourceValue = new HashSet<Object>();
        newSourceValueMinusOldSourceValue.addAll(newSourceValueAsCollection);
        newSourceValueMinusOldSourceValue.removeAll(oldSourceValueAsCollection);
        result.addAll(newSourceValueMinusOldSourceValue);
        return result;
    }

    /**
     * Determines a strategy that can propagate a delta for <tt>e</tt>'s value to a superset of the
     * delta for another expression using <tt>e</tt>. For example, the delta of the source expression
     * of an <tt>asSet()</tt> call propagates to the <tt>asSet()</tt> call expression unchanged.
     * 
     * @return a propagation strategy if the expression using <tt>e</tt> is monotonic in <tt>e</tt> such
     * that mapping <tt>e</tt>'s delta is possible at all, or <tt>null</tt> if no propagation strategy is
     * defined or possible to define for the use of <tt>e</tt>.
     */
    private DeltaPropagationStrategy getDeltaPropagationStrategy(OCLExpression e, OperationBodyToCallMapper mapper) {
        DeltaPropagationStrategy result = null;
        ResourceSet rs = e.eResource().getResourceSet();
        if (rs == null) {
            rs = new ResourceSetImpl();
        }
        EcoreHelper helper = EcoreHelper.getInstance();
        Collection<EObject> appliedElements = helper.reverseNavigate(e, ExpressionsPackage.eINSTANCE.getCallExp_Source(),
                helper.getQueryContext(rs), rs);
        if (!appliedElements.isEmpty()) {
            OCLExpression appliedElement = (OCLExpression) appliedElements.iterator().next();
            if (appliedElement instanceof IteratorExp) {
                IteratorExp loopExp = (IteratorExp) appliedElement;
                switch (OCLStandardLibraryUtil.getOperationCode(loopExp.getName())) {
                case PredefinedType.COLLECT:
                case PredefinedType.SELECT:
                case PredefinedType.REJECT:
                    result = new IteratorSourcePropagationStrategy(loopExp, this);
                    break;
                }
            } else if (appliedElement instanceof OperationCallExp) {
                switch (OCLStandardLibraryUtil.getOperationCode(((OperationCallExp) appliedElement).getReferredOperation().getName())) {
                case PredefinedType.UNION:
                case PredefinedType.INTERSECTION:
                case PredefinedType.MINUS:
                case PredefinedType.INCLUDING:
                case PredefinedType.EXCLUDING:
                case PredefinedType.APPEND:
                case PredefinedType.PREPEND:
                case PredefinedType.INSERT_AT:
                case PredefinedType.AS_BAG:
                case PredefinedType.AS_ORDERED_SET:
                case PredefinedType.AS_SEQUENCE:
                case PredefinedType.AS_SET:
                case PredefinedType.FLATTEN:
                // case PredefinedType.REVERSE  // not supported as of now
                    result = new IdentityPropagationStrategy(appliedElement);
                    break;
                }
            }
        } else {
            // Not the source of a CallExp.
            // Check if e is the last parameter expression of a call to any of the stdlib operations
            // that are monotonic in their last parameter:
            Collection<EObject> operationCallOfParameters = helper.reverseNavigate(e, ExpressionsPackage.eINSTANCE.getOperationCallExp_Argument(),
                    helper.getQueryContext(rs), rs);
            if (!operationCallOfParameters.isEmpty()) {
                OperationCallExp operationCall = (OperationCallExp) operationCallOfParameters.iterator().next();
                if (e == operationCall.getArgument().get(operationCall.getArgument().size() - 1)) { // last parameter?
                    switch (OCLStandardLibraryUtil.getOperationCode(operationCall.getReferredOperation().getName())) {
                    case PredefinedType.UNION:
                    case PredefinedType.INTERSECTION:
                    case PredefinedType.INCLUDING:
                    case PredefinedType.APPEND:
                    case PredefinedType.PREPEND:
                    case PredefinedType.INSERT_AT:
                        result = new IdentityPropagationStrategy(operationCall);
                        break;
                    }
                }
            } else {
                // not a parameter of an operation; check if e is the thenExpression or elseExpression of an IfExp
                Collection<EObject> thenExpForIfExp = helper.reverseNavigate(e, ExpressionsPackage.eINSTANCE.getIfExp_ThenExpression(),
                        helper.getQueryContext(rs), rs);
                Collection<EObject> elseExpForIfExp = helper.reverseNavigate(e, ExpressionsPackage.eINSTANCE.getIfExp_ElseExpression(),
                        helper.getQueryContext(rs), rs);
                if (!thenExpForIfExp.isEmpty()) {
                    result = new IdentityPropagationStrategy((IfExp) thenExpForIfExp.iterator().next());
                } else if (!elseExpForIfExp.isEmpty()) { 
                    result = new IdentityPropagationStrategy((IfExp) elseExpForIfExp.iterator().next());
                } else {
                    // no then or else expression of an IfExp
                    // Check if e is the body of an operation:
                    Set<OperationCallExp> callsOfOperationBody = mapper.getCallsOf(e);
                    if (!callsOfOperationBody.isEmpty()) {
                        result = new OperationBodyPropagationStrategy(mapper);
                    } else {
                        // Not an operation body whose operation is called anywhere in the scope of the overall expression.
                        // Check is e is the body of a ->collect expression
                        Collection<EObject> bodyOfLoopExp = helper.reverseNavigate(e, ExpressionsPackage.eINSTANCE.getLoopExp_Body(),
                                helper.getQueryContext(rs), rs);
                        if (!bodyOfLoopExp.isEmpty()) {
                            LoopExp loopExp = (LoopExp) bodyOfLoopExp.iterator().next();
                            if (OCLStandardLibraryUtil.getOperationCode(loopExp.getName()) == PredefinedType.COLLECT) {
                                result = new IdentityPropagationStrategy(loopExp);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * Tries to find a {@link DeltaPropagationStrategy propagation strategy} for the combination of the OCL expression <tt>e</tt>
     * and a given <tt>delta</tt> for its evaluation result. If no such strategy is found, the pair of <tt>e</tt> and
     * <tt>delta</tt> is returned. Otherwise, the strategy is applied, and the <tt>delta</tt> is mapped to a delta for another
     * expression using <tt>e</tt>. The result of this step is recursively passed to this method so that propagation terminates
     * when no propagation strategy can be found for an expression.
     * <p>
     * 
     * When the object collection returned in the {@link Pair#getB b} component of the result is empty then this means that the
     * overall expression in which <tt>e</tt> occurs will not be affected by the <tt>delta</tt> of <tt>e</tt>'s value.
     * <p>
     * 
     * <b>Postcondition</b>:
     * <tt>this.{@link #getDeltaPropagationStrategy(OCLExpression) getDeltaPropagationStrategy}(result.getA()) == null</tt>
     * 
     * @param delta
     *            may be null, empty or a valid non-empty collection specifying a delta in <tt>e</tt>'s evaluation result
     * @param mapper
     *            needs to be able to map an operation body in which <tt>callExp</tt> is used to the calls of that operation, as
     *            well as all operation calls in which those calls appear (transitively) to the calls of those operations, and so
     *            on, for the overall expression for which the effect of the change is to be analyzed.
     * @return zero or more pairs with a non-<tt>null</tt>, non-empty {@link Pair#getB b} component which is a collection
     *         specifying the delta to which <tt>delta</tt> maps for the expression returned as the {@link Pair#getA a} component
     *         of the pair contained in the collection returned. If the collection returned is empty this means that
     *         the <tt>delta</tt> of <tt>e</tt>'s value has no effect on the overall expression in which <tt>e</tt> appears.
     */
    private Collection<Pair<OCLExpression, Collection<Object>>> transitivelyPropagateDelta(OCLExpression e, Collection<Object> delta,
            OperationBodyToCallMapper mapper) {
        DeltaPropagationStrategy propagationStrategy = getDeltaPropagationStrategy(e, mapper);
        Collection<Pair<OCLExpression, Collection<Object>>> result;
        if (propagationStrategy == null) {
            result = getResultCollectionFromSingleDelta(e, delta);
        } else {
            Collection<Pair<OCLExpression, Collection<Object>>> propagated = propagationStrategy.mapDelta(e, delta);
            if (propagated == null) {
                result = getResultCollectionFromSingleDelta(e, delta);
            } else {
                result = new HashSet<Pair<OCLExpression, Collection<Object>>>();
                for (Pair<OCLExpression, Collection<Object>> singlePropagationResult : propagated) {
                    Collection<Pair<OCLExpression, Collection<Object>>> singleResult = transitivelyPropagateDelta(
                            singlePropagationResult.getA(), singlePropagationResult.getB(), mapper);
                    result.addAll(singleResult);
                }
            }
        }
        return result;
    }

    static Collection<Pair<OCLExpression, Collection<Object>>> getResultCollectionFromSingleDelta(OCLExpression e,
            Collection<Object> delta) {
        Collection<Pair<OCLExpression, Collection<Object>>> result;
        // no (further) propagation possible
        if (delta == null || delta.isEmpty()) {
            // no change anyhow
            result = Collections.emptySet();
        } else {
            result = Collections.singleton(new Pair<OCLExpression, Collection<Object>>(e, delta));
        }
        return result;
    }
}
