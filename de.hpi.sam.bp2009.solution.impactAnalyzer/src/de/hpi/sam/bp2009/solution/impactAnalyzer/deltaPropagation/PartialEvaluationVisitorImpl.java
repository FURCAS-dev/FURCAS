package de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
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
import org.eclipse.ocl.EvaluationVisitorImpl;
import org.eclipse.ocl.ecore.CallExp;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.AssociationClassCallExp;
import org.eclipse.ocl.expressions.BooleanLiteralExp;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.expressions.CollectionLiteralExp;
import org.eclipse.ocl.expressions.EnumLiteralExp;
import org.eclipse.ocl.expressions.IfExp;
import org.eclipse.ocl.expressions.IntegerLiteralExp;
import org.eclipse.ocl.expressions.InvalidLiteralExp;
import org.eclipse.ocl.expressions.IterateExp;
import org.eclipse.ocl.expressions.IteratorExp;
import org.eclipse.ocl.expressions.LetExp;
import org.eclipse.ocl.expressions.MessageExp;
import org.eclipse.ocl.expressions.NullLiteralExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.OppositePropertyCallExp;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.RealLiteralExp;
import org.eclipse.ocl.expressions.StateExp;
import org.eclipse.ocl.expressions.StringLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralExp;
import org.eclipse.ocl.expressions.TypeExp;
import org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.ocl.expressions.VariableExp;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.util.CollectionUtil;

import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerPlugin;

/**
 * When a {@link ValueNotFoundException} occurs during evaluating an expression, it is not caught, logged ans swallowed but
 * forwarded to the caller.
 * <p>
 * 
 * All <tt>visit...</tt> operations check if the expression to evaluate is the {@link #sourceExpression} passed to the
 * constructor. If so, instead of actually evaluating the expression, the {@link #valueOfSourceExpression} object is returned
 * which was also passed to the constructor. This allows for partial evaluation of any {@link CallExp} with a given value for the
 * source expression.
 * <p>
 * 
 * FIXME Issue with recursive operations may exist: if the sourceExpression belongs to the body of a recursive operation and
 * evaluating it performs a recursive call and the source expression may depend on operation parameters or the self object then
 * the sourceExpressionValue must not be used during recursive evaluation. First produce this error in a failing test case, then
 * fix.
 * 
 * @author Axel Uhl
 * 
 */
public class PartialEvaluationVisitorImpl
        extends
        EvaluationVisitorImpl<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> {
    private org.eclipse.ocl.ecore.OCLExpression sourceExpression;
    private Object valueOfSourceExpression;

    /**
     * a {@link Notification} object such that an evaluation will be based on the state *before* the notification. For example, if
     * the notification indicates the removal of a reference from an element <tt>e1</tt> to an element <tt>e2</tt> across
     * reference <tt>r</tt> then when during partial evaluation <tt>r</tt> is traversed starting from <tt>e1</tt> then <tt>e2</tt>
     * will show in the results although in the current version of the model it would not. If <tt>null</tt>, the evaluator will
     * evaluate expressions on the model as is.
     */
    private Notification atPre;

    /**
     * @param atPre
     *            a {@link Notification} object such that an evaluation will be based on the state *before* the notification. For
     *            example, if the notification indicates the removal of a reference from an element <tt>e1</tt> to an element
     *            <tt>e2</tt> across reference <tt>r</tt> then when during partial evaluation <tt>r</tt> is traversed starting
     *            from <tt>e1</tt> then <tt>e2</tt> will show in the results although in the current version of the model it would
     *            not. If <tt>null</tt>, the evaluator will evaluate expressions on the model as is.
     */
    public PartialEvaluationVisitorImpl(
            Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
            EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> evalEnv,
            Map<? extends EClass, ? extends Set<? extends EObject>> extentMap,
            org.eclipse.ocl.ecore.OCLExpression sourceExpression, Object valueOfSourceExpression, Notification atPre) {
        super(env, evalEnv, extentMap);
        this.sourceExpression = sourceExpression;
        this.valueOfSourceExpression = valueOfSourceExpression;
        this.atPre = atPre;
    }

    @Override
    public Object visitOperationCallExp(OperationCallExp<EClassifier, EOperation> oc) {
        if (oc == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitOperationCallExp(oc);
    }

    @Override
    public Object visitIterateExp(IterateExp<EClassifier, EParameter> ie) {
        if (ie == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitIterateExp(ie);
    }

    @Override
    public Object visitIteratorExp(IteratorExp<EClassifier, EParameter> ie) {
        if (ie == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitIteratorExp(ie);
    }

    @Override
    public Object visitEnumLiteralExp(EnumLiteralExp<EClassifier, EEnumLiteral> el) {
        if (el == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitEnumLiteralExp(el);
    }

    @Override
    public Object visitVariableExp(VariableExp<EClassifier, EParameter> v) {
        if (v == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitVariableExp(v);
    }

    @Override
    public Object visitPropertyCallExp(PropertyCallExp<EClassifier, EStructuralFeature> pc) {
        if (pc == sourceExpression) {
            return valueOfSourceExpression;
        }

        /*
         * These are the sources of the super implementation copied here which is ugly. We only want to get access to the value of
         * the source expression because it may be needed for the comparison with the atPre event later.
         * 
         * TODO evaluate source expression here and cache the result before delegating to super.visitPropertyCallExp; when then
         * super.visitPropertyCallExp asks the visitor to evaluate the source expression, the result is taken from the cache
         */
        EStructuralFeature property = pc.getReferredProperty();
        OCLExpression<EClassifier> source = pc.getSource();
        // evaluate source
        Object context = source.accept(getVisitor());
        Object localResult;
        // if source is undefined, result is OclInvalid
        if (isUndefined(context)) {
            localResult = getInvalid();
        } else {
            OCLExpression<EClassifier> derivation = getPropertyBody(property);
            if (derivation != null) {
                // this is an additional property
                localResult = navigate(property, derivation, context);
            } else {
                List<Object> qualifiers;
                if (pc.getQualifier().isEmpty()) {
                    qualifiers = Collections.emptyList();
                } else {
                    // handle qualified association navigation
                    qualifiers = new java.util.ArrayList<Object>();
                    for (OCLExpression<EClassifier> q : pc.getQualifier()) {
                        qualifiers.add(q.accept(getVisitor()));
                    }
                }
                localResult = getEvaluationEnvironment().navigateProperty(property, qualifiers, context);
                if ((pc.getType() instanceof CollectionType<?, ?>) && !(result instanceof Collection<?>)) {
                    // this was an XSD "unspecified multiplicity". Now that we know what
                    // the multiplicity is, we can coerce it to a collection value
                    @SuppressWarnings("unchecked")
                    CollectionKind kind = ((CollectionType<EClassifier, EOperation>) pc.getType()).getKind();
                    Collection<Object> collection = CollectionUtil.createNewCollection(kind);
                    collection.add(localResult);
                    localResult = collection;
                }
            }
        }
        
        if (atPre != null && atPre.getNotifier() != null && atPre.getNotifier() == context && pc == atPre.getFeature()) {
            // evaluate property call based on the model state that existed before the change
            // described by the atPre notification
            switch (atPre.getEventType()) {
            case Notification.ADD:
                // if the addition operated on the result of the source expression, remove the element from the local results
                // again
            case Notification.ADD_MANY:
                // if the addition operated on the result of the source expression, remove the elements from the local results
                // again
            case Notification.MOVE:
                // if the move operated on the result of the source expression, move the element back to the old index
                // indicated by getOldIntValue()
            case Notification.REMOVE:
                // if the removal operated on the result of the source expression, add the element back at the index provided
            case Notification.REMOVE_MANY:
                // if the removal operated on the result of the source expression, add the elements back in the order provided by
                // the getOldValue() collection
            case Notification.SET:
            case Notification.UNSET:
                // if the setting/unsetting operated on the result of the source expression, return the old value
            default:
                throw new RuntimeException("Don't understand @pre notification " + atPre);
            }
        }
        return localResult;
    }

    @Override
    public Object visitOppositePropertyCallExp(OppositePropertyCallExp<EClassifier, EStructuralFeature> pc) {
        if (pc == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitOppositePropertyCallExp(pc);
    }

    @Override
    public Object visitAssociationClassCallExp(AssociationClassCallExp<EClassifier, EStructuralFeature> ae) {
        if (ae == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitAssociationClassCallExp(ae);
    }

    @Override
    public Object visitIfExp(IfExp<EClassifier> ie) {
        if (ie == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitIfExp(ie);
    }

    @Override
    public Object visitTypeExp(TypeExp<EClassifier> t) {
        if (t == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitTypeExp(t);
    }

    @Override
    public Object visitStateExp(StateExp<EClassifier, EObject> s) {
        if (s == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitStateExp(s);
    }

    @Override
    public Object visitMessageExp(MessageExp<EClassifier, CallOperationAction, SendSignalAction> m) {
        if (m == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitMessageExp(m);
    }

    @Override
    public Object visitUnspecifiedValueExp(UnspecifiedValueExp<EClassifier> uv) {
        if (uv == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitUnspecifiedValueExp(uv);
    }

    @Override
    public Object visitIntegerLiteralExp(IntegerLiteralExp<EClassifier> il) {
        if (il == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitIntegerLiteralExp(il);
    }

    @Override
    public Object visitUnlimitedNaturalLiteralExp(UnlimitedNaturalLiteralExp<EClassifier> literalExp) {
        if (literalExp == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitUnlimitedNaturalLiteralExp(literalExp);
    }

    @Override
    public Object visitRealLiteralExp(RealLiteralExp<EClassifier> rl) {
        if (rl == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitRealLiteralExp(rl);
    }

    @Override
    public Object visitStringLiteralExp(StringLiteralExp<EClassifier> sl) {
        if (sl == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitStringLiteralExp(sl);
    }

    @Override
    public Object visitBooleanLiteralExp(BooleanLiteralExp<EClassifier> bl) {
        if (bl == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitBooleanLiteralExp(bl);
    }

    @Override
    public Object visitInvalidLiteralExp(InvalidLiteralExp<EClassifier> il) {
        if (il == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitInvalidLiteralExp(il);
    }

    @Override
    public Object visitNullLiteralExp(NullLiteralExp<EClassifier> il) {
        if (il == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitNullLiteralExp(il);
    }

    @Override
    public Object visitLetExp(LetExp<EClassifier, EParameter> l) {
        if (l == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitLetExp(l);
    }

    @Override
    public Object visitCollectionLiteralExp(CollectionLiteralExp<EClassifier> cl) {
        if (cl == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitCollectionLiteralExp(cl);
    }

    @Override
    public Object visitTupleLiteralExp(TupleLiteralExp<EClassifier, EStructuralFeature> tl) {
        if (tl == sourceExpression) {
            return valueOfSourceExpression;
        }
        return super.visitTupleLiteralExp(tl);
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
