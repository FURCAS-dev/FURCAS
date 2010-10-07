package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation;

import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.AbstractEvaluationVisitor;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.EvaluationHaltedException;
import org.eclipse.ocl.ecore.CallExp;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.utilities.PredefinedType;

import de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation.PartialEvaluationVisitorImpl;
import de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation.ValueNotFoundException;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerPlugin;

/**
 * When a {@link ValueNotFoundException} occurs during evaluating an expression, it is not caught, logged and swallowed but
 * forwarded to the caller.
 * <p>
 * 
 * All <tt>visit...</tt> operations check if the expression to evaluate is the {@link #sourceExpression} passed to the
 * constructor. If so, instead of actually evaluating the expression, the {@link #valueOfSourceExpression} object is returned
 * which was also passed to the constructor. This allows for partial evaluation of any {@link CallExp} with a given value for the
 * source expression.
 * <p>
 * 
 * When the {@link #sourceExpression} has once been evaluated it is nulled out so that when due to recursion it is
 * evaluated again, evaluation is based on the current environment and not on the cached {@link #valueOfSourceExpression}.
 * Without this it could happen that, e.g., the value for a <tt>self</tt> {@link org.eclipse.ocl.ecore.VariableExp} is
 * cached but would have to have a different value upon recursive evaluation.
 * 
 * @author Axel Uhl
 * 
 */
public class PartialEvaluationVisitorImplNoAllInstances extends PartialEvaluationVisitorImpl {
    /**
     * @param atPre
     *            a {@link Notification} object such that an evaluation will be based on the state *before* the notification. For
     *            example, if the notification indicates the removal of a reference from an element <tt>e1</tt> to an element
     *            <tt>e2</tt> across reference <tt>r</tt> then when during partial evaluation <tt>r</tt> is traversed starting
     *            from <tt>e1</tt> then <tt>e2</tt> will show in the results although in the current version of the model it would
     *            not. If <tt>null</tt>, the evaluator will evaluate expressions on the model as is.
     */
    public PartialEvaluationVisitorImplNoAllInstances(
            Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
            EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> evalEnv,
            Map<? extends EClass, ? extends Set<? extends EObject>> extentMap,
            org.eclipse.ocl.ecore.OCLExpression sourceExpression, Object valueOfSourceExpression, Notification atPre) {
        super(env, evalEnv, extentMap, sourceExpression, valueOfSourceExpression, atPre);
    }

    @Override
    public Object visitOperationCallExp(OperationCallExp<EClassifier, EOperation> oc) {
        if (oc == getSourceExpression()) {
            setSourceExpression(null);
            return getValueOfSourceExpression();
        } else {
            int opCode = oc.getOperationCode();
            if (opCode == PredefinedType.ALL_INSTANCES) {
                throw new NoAllInstancesDuringEvaluationForUnusedCheck();
            }
        }
        return super.visitOperationCallExp(oc);
    }

    /**
     * Does the same as the {@link AbstractEvaluationVisitor} implementation but additionally catches the
     * {@link ValueNotFoundException} and in that case passes on the exception instead of turning it into an <tt>OclInvalid</tt>
     * value.
     * 
     * @param expression
     *            an OCL expression to evaluate
     * 
     * @return the result of the evaluation
     */
    @Override
    public Object visitExpression(OCLExpression<EClassifier> expression) {
        try {
            return expression.accept(getVisitor());
        } catch (EvaluationHaltedException e) {
            // evaluation stopped on demand, propagate further
            throw e;
        } catch (ValueNotFoundException e) {
            throw e;
        } catch (NoAllInstancesDuringEvaluationForUnusedCheck e2) {
            throw e2;
        } catch (RuntimeException e) {
            String msg = e.getLocalizedMessage();
            if (msg == null) {
                msg = "(no message)";
            }
            ImpactAnalyzerPlugin.log(Diagnostic.ERROR, ImpactAnalyzerPlugin.IGNORED_EXCEPTION_WARNING,
                    "Evaluation failed with an exception: " + msg, e);

            // failure to evaluate results in invalid
            return getInvalid();
        }
    }
}
