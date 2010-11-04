package de.hpi.sam.bp2009.solution.impactAnalyzer.hiddenopposites.deltapropagation;

import java.util.Collection;
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
import org.eclipse.ocl.ecore.CallExp;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.util.CollectionUtil;

import com.sap.emf.ocl.hiddenopposites.EvaluationEnvironmentWithHiddenOpposites;
import com.sap.emf.ocl.hiddenopposites.EvaluationVisitorWithHiddenOpposites;
import com.sap.emf.ocl.oclwithhiddenopposites.expressions.OppositePropertyCallExp;

import de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation.PartialEvaluationVisitorImpl;
import de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation.ValueNotFoundException;

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
public class PartialEvaluationVisitorWithHiddenOppositesImpl
        extends
        PartialEvaluationVisitorImpl implements EvaluationVisitorWithHiddenOpposites {

    public PartialEvaluationVisitorWithHiddenOppositesImpl(
            Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
            EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> evalEnv,
            Map<? extends EClass, ? extends Set<? extends EObject>> extentMap,
            org.eclipse.ocl.ecore.OCLExpression sourceExpression, Object valueOfSourceExpression, Notification atPre) {
        super(env, evalEnv, extentMap, sourceExpression, valueOfSourceExpression, atPre);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object visitOppositePropertyCallExp(OppositePropertyCallExp pc) {
        if (pc == getSourceExpression()) {
            setSourceExpression(null);
            return getValueOfSourceExpression();
        }
        /*
         * These are the sources of the super implementation copied here which is ugly. We only want to get access to the value of
         * the source expression because it may be needed for the comparison with the atPre event later.
         * 
         * TODO evaluate source expression here and cache the result before delegating to super.visitPropertyCallExp; when then
         * super.visitPropertyCallExp asks the visitor to evaluate the source expression, the result is taken from the cache
         */
        EStructuralFeature property = pc.getReferredOppositeProperty();
        OCLExpression<EClassifier> source = pc.getSource();
        // evaluate source
        Object context = source.accept(getVisitor());
        Object localResult;
        // if source is undefined, result is OclInvalid
        if (isUndefined(context)) {
            localResult = getInvalid();
        } else {
            // TODO consider introduction of derivation expressions also for opposite property; for now it's not supported
            /* OCLExpression<EClassifier> derivation = getPropertyBody(property);
            if (derivation != null) {
                // this is an additional property
                localResult = navigate(property, derivation, context);
            } else {
            */
                localResult = ((EvaluationEnvironmentWithHiddenOpposites) getEvaluationEnvironment()).navigateOppositeProperty(property, context);
                if ((pc.getType() instanceof CollectionType<?, ?>) && !(localResult instanceof Collection<?>)) {
                    // this was an XSD "unspecified multiplicity". Now that we know what
                    // the multiplicity is, we can coerce it to a collection value
                    CollectionKind kind = ((CollectionType<EClassifier, EOperation>) pc.getType()).getKind();
                    Collection<Object> collection = CollectionUtil.createNewCollection(kind);
                    collection.add(localResult);
                    localResult = collection;
                }
            // }
        }
        
        // for @pre with opposite properties there can't be any ordering
        if (getAtPre() != null
                // the source of the opposite property call expression is the target of a normal EMF notification
                // because the notification talks about a forward reference; the old and new value described by the
                // event may be a collection of elements or a single element. Check if the source appears somewhere
                // in the notification's old or new value:
                && ((getAtPre().getOldValue() != null && ((getAtPre().getOldValue() instanceof Collection<?> &&
                        ((Collection<?>) getAtPre().getOldValue()).contains(context)) || getAtPre().getOldValue() == context))
                        || (getAtPre().getNewValue() != null && ((getAtPre().getNewValue() instanceof Collection<?> &&
                                ((Collection<?>) getAtPre().getNewValue()).contains(context)) || getAtPre().getNewValue() == context)))
                && pc.getReferredOppositeProperty() == getAtPre().getFeature()) {
            // evaluate property call based on the model state that existed before the change
            // described by the atPre notification
            switch (getAtPre().getEventType()) {
            case Notification.ADD:
            case Notification.ADD_MANY:
                // if the addition operated on the result of the source expression, remove the element from the local results
                // again
                ((Collection<?>) localResult).remove(getAtPre().getNotifier());
                break;
            case Notification.MOVE:
                // there is no ordering for opposite properties in Ecore; it's safe to ignore this notification
                break;
            case Notification.REMOVE:
            case Notification.REMOVE_MANY:
                // if the removal operated on the result of the source expression, add the element back at the index provided
                ((Collection<Object>) localResult).add(getAtPre().getNotifier());
                break;
            case Notification.SET:
            case Notification.UNSET:
                if (getAtPre().getOldValue() == context) {
                    // the notification tells that previously the source context was referenced by the notifier;
                    // re-add the notifier to the result:
                    ((Collection<Object>) localResult).add(getAtPre().getNotifier());
                } else if (getAtPre().getNewValue() == context) {
                    // the notification tells that after the change the source context is referenced by the notifier;
                    // remove the notifier from the result:
                    ((Collection<Object>) localResult).remove(getAtPre().getNotifier());
                }
                break;
            default:
                throw new RuntimeException("Don't understand @pre notification " + getAtPre());
            }
        }
        return localResult;
    }
}
