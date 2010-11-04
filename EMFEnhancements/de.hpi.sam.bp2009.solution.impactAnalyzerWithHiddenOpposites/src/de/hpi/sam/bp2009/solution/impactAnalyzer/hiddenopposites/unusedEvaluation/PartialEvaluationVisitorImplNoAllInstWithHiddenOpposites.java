package de.hpi.sam.bp2009.solution.impactAnalyzer.hiddenopposites.unusedEvaluation;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.PropertyCallExp;

import com.sap.emf.ocl.oclwithhiddenopposites.expressions.OppositePropertyCallExp;
import com.sap.emf.ocl.oclwithhiddenopposites.utilities.VisitorWithHiddenOpposite;

import de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation.ValueNotFoundException;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.NoAllInstancesDuringEvaluationForUnusedCheck;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.PartialEvaluationVisitorImplNoAllInstances;

/**
 * In addition to throwing a {@link ValueNotFoundException} as already done by the superclass,
 * this implementation also throws a {@link NoAllInstancesDuringEvaluationForUnusedCheck} exception
 * in case an <code>allInstances()</code> call is to be evaluated.
 * 
 * @author Axel Uhl
 * 
 */
public class PartialEvaluationVisitorImplNoAllInstWithHiddenOpposites extends PartialEvaluationVisitorImplNoAllInstances
implements VisitorWithHiddenOpposite<Object> {
    /**
     * @param atPre
     *            a {@link Notification} object such that an evaluation will be based on the state *before* the notification. For
     *            example, if the notification indicates the removal of a reference from an element <tt>e1</tt> to an element
     *            <tt>e2</tt> across reference <tt>r</tt> then when during partial evaluation <tt>r</tt> is traversed starting
     *            from <tt>e1</tt> then <tt>e2</tt> will show in the results although in the current version of the model it would
     *            not. If <tt>null</tt>, the evaluator will evaluate expressions on the model as is.
     */
    public PartialEvaluationVisitorImplNoAllInstWithHiddenOpposites(
            Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
            EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> evalEnv,
            Map<? extends EClass, ? extends Set<? extends EObject>> extentMap,
            org.eclipse.ocl.ecore.OCLExpression sourceExpression, Object valueOfSourceExpression, Notification atPre) {
        super(env, evalEnv, extentMap, sourceExpression, valueOfSourceExpression, atPre);
    }

    /**
     * Visits the property-call source and then its qualifiers (if any). Returns the result of
     * {@link #handlePropertyCallExp(PropertyCallExp, Object, List)}.
     */
    public Object visitOppositePropertyCallExp(OppositePropertyCallExp callExp) {
        if (callExp == getSourceExpression()) {
            setSourceExpression(null);
            return getValueOfSourceExpression();
        } else {
            // source is null when the property call expression is an
            // association class navigation qualifier
            safeVisit(callExp.getSource());
            return result;
        }
    }
}
