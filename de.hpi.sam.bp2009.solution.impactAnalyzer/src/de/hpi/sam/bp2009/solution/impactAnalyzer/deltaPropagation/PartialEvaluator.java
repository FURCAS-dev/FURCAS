package de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation;

import java.util.Collection;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.query2.EcoreHelper;
import org.eclipse.ocl.ecore.CallExp;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.expressions.ExpressionsPackage;

import de.hpi.sam.bp2009.solution.impactAnalyzer.OperationBodyToCallMapper;

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
    private PartialEcoreEnvironmentFactory factory = new PartialEcoreEnvironmentFactory();
    
    public PartialEvaluator() {
        ocl = OCL.newInstance(factory);
        helper = ocl.createOCLHelper();
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
                    ResourceSet rs = callExp.eResource().getResourceSet();
                    if (rs == null) {
                        rs = new ResourceSetImpl();
                    }
                    EcoreHelper helper = EcoreHelper.getInstance();
                    Collection<EObject> appliedElement = helper.reverseNavigate(callExp, ExpressionsPackage.eINSTANCE.getCallExp_Source(),
                            helper.getQueryContext(rs), rs);
                    if (!appliedElement.isEmpty()) {
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
                            // not an operation body
                            result = false;
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
}
