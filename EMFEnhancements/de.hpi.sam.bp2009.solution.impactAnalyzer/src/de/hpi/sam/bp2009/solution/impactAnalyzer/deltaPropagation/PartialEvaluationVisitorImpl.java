/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
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
import org.eclipse.ocl.ecore.CallExp;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EvaluationEnvironmentWithHiddenOpposites;
import org.eclipse.ocl.ecore.EvaluationVisitorImpl;
import org.eclipse.ocl.ecore.OppositePropertyCallExp;
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
import org.eclipse.ocl.utilities.PredefinedType;

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
public class PartialEvaluationVisitorImpl
        extends
        EvaluationVisitorImpl {
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
            sourceExpression = null;
            return valueOfSourceExpression;
        } else {
            int opCode = oc.getOperationCode();
            if (opCode == PredefinedType.AT) {
                OCLExpression<EClassifier> source = oc.getSource();
                List<OCLExpression<EClassifier>> args = oc.getArgument();
                // evaluate source
                Object sourceVal = source.accept(getVisitor());
                if (sourceVal == getInvalid() || ((Collection<?>) sourceVal).isEmpty()) {
                    // then we know there's going to be an IndexOutOfBoundsException thrown in CollectionUtil.at; skip the
                    // evaluation of the argument expression which could only raise a ValueNotFoundException in case a variable
                    // is accessed that is not defined; but it wouldn't change the result which always will be invalid for
                    // an empty collection.
                    return getInvalid();
                }
                // evaluate argument
                OCLExpression<EClassifier> arg = args.get(0);
                if (isUndefined(sourceVal)) {
                    return getInvalid();
                }
                @SuppressWarnings("unchecked")
                Collection<Object> sourceColl = (Collection<Object>) sourceVal;
                // bug 183144: inputting OclInvalid should result in OclInvalid
                Object argVal = arg.accept(getVisitor());
                if (argVal == getInvalid()) {
                    return argVal;
                }
                // OrderedSet, Sequence::at(Integer)
                if (!(argVal instanceof Integer)) {
                        return getInvalid();
                }
                int indexVal = ((Integer) argVal).intValue();
                return CollectionUtil.at(sourceColl, indexVal);
            }
        }
        return super.visitOperationCallExp(oc);
    }

    @Override
    public Object visitIterateExp(IterateExp<EClassifier, EParameter> ie) {
        if (ie == sourceExpression) {
            sourceExpression = null;
            return valueOfSourceExpression;
        }
        return super.visitIterateExp(ie);
    }

    @Override
    public Object visitIteratorExp(IteratorExp<EClassifier, EParameter> ie) {
        if (ie == sourceExpression) {
            sourceExpression = null;
            return valueOfSourceExpression;
        }
        return super.visitIteratorExp(ie);
    }

    @Override
    public Object visitEnumLiteralExp(EnumLiteralExp<EClassifier, EEnumLiteral> el) {
        if (el == sourceExpression) {
            sourceExpression = null;
            return valueOfSourceExpression;
        }
        return super.visitEnumLiteralExp(el);
    }

    @Override
    public PartialEcoreEvaluationEnvironment getEvaluationEnvironment() {
        return (PartialEcoreEvaluationEnvironment) super.getEvaluationEnvironment();
    }

    @Override
    public Object visitVariableExp(VariableExp<EClassifier, EParameter> v) {
        if (v == sourceExpression) {
            sourceExpression = null;
            return valueOfSourceExpression;
        }
        // evaluate the variable in the current environment, using a special getValueOf(...) operation that
        // accepts the VariableExp so as to better be able to annotate an exception in case the variable is
        // unknown
        return getEvaluationEnvironment().getValueOf(v);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object visitPropertyCallExp(PropertyCallExp<EClassifier, EStructuralFeature> pc) {
        if (pc == sourceExpression) {
            sourceExpression = null;
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
                if ((pc.getType() instanceof CollectionType<?, ?>) && !(localResult instanceof Collection<?>)) {
                    // this was an XSD "unspecified multiplicity". Now that we know what
                    // the multiplicity is, we can coerce it to a collection value
                    CollectionKind kind = ((CollectionType<EClassifier, EOperation>) pc.getType()).getKind();
                    Collection<Object> collection = CollectionUtil.createNewCollection(kind);
                    collection.add(localResult);
                    localResult = collection;
                }
            }
        }

        if (atPre != null && atPre.getNotifier() != null && atPre.getNotifier() == context
                && pc.getReferredProperty() == atPre.getFeature()) {
            CollectionKind kind = (pc.getType() instanceof CollectionType<?, ?>) ? ((CollectionType<EClassifier, EOperation>) pc
                    .getType()).getKind() : null;
            // evaluate property call based on the model state that existed before the change
            // described by the atPre notification
            switch (atPre.getEventType()) {
            case Notification.ADD:
                // if the addition operated on the result of the source expression, remove the element from the local results
                // again
                localResult = removeAt((Collection<?>) localResult, kind);
                break;
            case Notification.ADD_MANY:
                // if the addition operated on the result of the source expression, remove the elements from the local results
                // again
                ((Collection<?>) localResult).removeAll((Collection<?>) atPre.getNewValue());
                break;
            case Notification.MOVE:
                // if the move operated on the result of the source expression, move the element back to the old index
                // indicated by getOldIntValue()
                localResult = move((Collection<?>) localResult, kind);
                break;
            case Notification.REMOVE:
                // if the removal operated on the result of the source expression, add the element back at the index provided
                localResult = insertAt((Collection<Object>) localResult, kind);
                break;
            case Notification.REMOVE_MANY:
                // if the removal operated on the result of the source expression, add the elements back at the positions
                // given in the getNewValue() int[].
                // TODO restore at appropriate position if provided and collection is ordered (a list)
                localResult = insertManyAt((Collection<Object>) localResult, kind);
                break;
            case Notification.SET:
            case Notification.UNSET:
                // if the setting/unsetting operated on the result of the source expression, return the old value
                // TODO restore old value at position specified by index, if any, and if the local result is a collection
                localResult = atPre.getOldValue();
                break;
            case Notification.RESOLVE:
                // TODO consider avoiding filtering for RESOLVE notifications in the first place
                break; // stay with new, resolved value because resolution is automatic
            default:
                throw new RuntimeException("Don't understand @pre notification " + atPre);
            }
        }
        return localResult;
    }

    /**
     * Assumes that {@link #atPre}.{@link Notification#getOldValue()} contains a collection of the
     * objects that were removed and that {@link #atPre}.{@link Notification#getNewValue()} is an
     * <tt>int[]</tt> describing the old positions at which the elements were removed.
     * 
     * @param <T>
     * @param into
     * @param kind
     * @return
     */
    @SuppressWarnings("unchecked")
    private <T> Collection<T> insertManyAt(Collection<T> into, CollectionKind kind) {
        Collection<T> result;
        int[] oldPositions = (int[]) atPre.getNewValue();
        if ((kind == CollectionKind.SEQUENCE_LITERAL || kind == CollectionKind.ORDERED_SET_LITERAL)
                && atPre.getPosition() != Notification.NO_INDEX) {
            if (into instanceof List<?>) {
                int i=0;
                for (T t : ((Collection<T>) atPre.getOldValue())) {
                    ((List<T>) into).add(oldPositions[i++], t);
                }
                result = into;
            } else {
                // ordered but not a list; probably an OrderedSet rendered as a LinkedHashMap; we need to copy
                // maybe we're lucky and can append to the end:
                if (oldPositions[0] >= into.size()) {
                    for (T t : ((Collection<T>) atPre.getOldValue())) {
                        ((List<T>) into).add(t);
                    }
                    result = into;
                } else {
                    result = CollectionUtil.createNewCollection(kind);
                    int i = 0;
                    Iterator<T> removedIter = ((Collection<T>) atPre.getOldValue()).iterator();
                    int sourcePos = 0;
                    int targetPos = 0;
                    for (T t : into) {
                        if (targetPos == oldPositions[i]) {
                            result.add(removedIter.next());
                            targetPos++;
                        }
                        result.add(t);
                        targetPos++;
                        sourcePos++;
                    }
                }
            }
        } else {
            into.addAll((Collection<T>) atPre.getOldValue());
            result = into;
        }
        return result;
    }

    /**
     * Moves the {@link #atPre}'s {@link Notification#getNewValue() new value} from the new position
     * described by {@link #atPre}.{@link Notification#getPosition() getPosition()} to the old position
     * described by  {@link #atPre}.{@link Notification#getOldValue() getOldValue()}. Does what is needed,
     * including cloning the collection and fixing the order by iteration if necessary.
     */
    @SuppressWarnings("unchecked")
    private <T> Collection<T> move(Collection<T> collection, CollectionKind kind) {
        Collection<T> result = collection;
        if ((kind == CollectionKind.SEQUENCE_LITERAL || kind == CollectionKind.ORDERED_SET_LITERAL)
                && atPre.getPosition() != Notification.NO_INDEX) {
            int oldPositionBeforeMove = (Integer) atPre.getOldValue();
            int newPositionAfterMove = atPre.getPosition();
            if (collection instanceof List<?>) {
                if (((List<?>) collection).get(atPre.getPosition()) != atPre.getNewValue()) {
                    throw new RuntimeException("Internal error. Didn't find " + atPre.getNewValue() + " at position "
                            + atPre.getPosition());
                } else {
                    ((List<T>) collection).remove(newPositionAfterMove);
                    ((List<T>) collection).add(oldPositionBeforeMove, (T) atPre.getNewValue());
                    result = collection;
                }
            } else {
                if (oldPositionBeforeMove >= collection.size()) {
                    // can handle by remove and add at end
                    collection.remove(atPre.getNewValue());
                    collection.add((T) atPre.getNewValue());
                } else {
                    // ordered but not a list; probably an OrderedSet rendered as a LinkedHashMap; we need to copy
                    result = CollectionUtil.createNewCollection(kind);
                    int sourcePos = 0;
                    int targetPos = 0;
                    for (T t : collection) {
                        if (targetPos == oldPositionBeforeMove) {
                            result.add((T) atPre.getNewValue());
                            targetPos++;
                        }
                        if (sourcePos != newPositionAfterMove) {
                            result.add(t);
                            targetPos++;
                        }
                        sourcePos++;
                    }
                }
            }
        }
        // no action required otherwise because the collection is not ordered and moving is not defined
        // on an unordered collection
        return result;
    }

    /**
     * Removes {@link #atPre}'s new value from the <tt>from</tt> collection. If the collection kind indicates an ordered
     * collection and the {@link #atPre} event specifies a valid index, removal will take place at the index specified after a
     * check that at that index the {@link #atPre}.{@link Notification#getNewValue() getNewValue()} object is found.
     * <p>
     * 
     * Precondition: {@link #atPre} <tt>!= null</tt>
     */
    private <T> Collection<T> removeAt(Collection<T> from, CollectionKind kind) {
        Collection<T> result;
        if ((kind == CollectionKind.SEQUENCE_LITERAL || kind == CollectionKind.ORDERED_SET_LITERAL)
                && atPre.getPosition() != Notification.NO_INDEX) {
            if (from instanceof List<?>) {
                if (((List<?>) from).get(atPre.getPosition()) != atPre.getNewValue()) {
                    throw new RuntimeException("Internal error. Didn't find " + atPre.getNewValue() + " at position "
                            + atPre.getPosition());
                } else {
                    ((List<?>) from).remove(atPre.getPosition());
                    result = from;
                }
            } else {
                // ordered but not a list; probably an OrderedSet rendered as a LinkedHashMap; we need to copy
                result = CollectionUtil.createNewCollection(kind);
                int i = 0;
                for (T t : from) {
                    if (i++ != atPre.getPosition()) {
                        result.add(t);
                    }
                }
            }
        } else {
            from.remove(atPre.getNewValue());
            result = from;
        }
        return result;
    }

    /**
     * Adds {@link #atPre}'s old value to the <tt>into</tt> collection. If the collection kind indicates an ordered collection and
     * the {@link #atPre} event specifies a valid index, insertion will take place at the index specified.
     * <p>
     * 
     * Precondition: {@link #atPre} <tt>!= null</tt>
     */
    @SuppressWarnings("unchecked")
    private <T> Collection<T> insertAt(Collection<T> into, CollectionKind kind) {
        Collection<T> result;
        if ((kind == CollectionKind.SEQUENCE_LITERAL || kind == CollectionKind.ORDERED_SET_LITERAL)
                && atPre.getPosition() != Notification.NO_INDEX) {
            if (into instanceof List<?>) {
                ((List<T>) into).add(atPre.getPosition(), (T) atPre.getOldValue());
                result = into;
            } else {
                // ordered but not a list; probably an OrderedSet rendered as a LinkedHashMap; we need to copy
                // maybe we're lucky and can append to the end:
                if (atPre.getPosition() >= into.size()) {
                    into.add((T) atPre.getOldValue());
                    result = into;
                } else {
                    result = CollectionUtil.createNewCollection(kind);
                    int i = 0;
                    for (T t : into) {
                        if (i++ == atPre.getPosition()) {
                            result.add((T) atPre.getOldValue());
                            i++;
                        }
                        result.add(t);
                    }
                }
            }
        } else {
            into.add((T) atPre.getOldValue());
            result = into;
        }
        return result;
    }

    @Override
    public Object visitAssociationClassCallExp(AssociationClassCallExp<EClassifier, EStructuralFeature> ae) {
        if (ae == sourceExpression) {
            sourceExpression = null;
            return valueOfSourceExpression;
        }
        return super.visitAssociationClassCallExp(ae);
    }

    @Override
    public Object visitIfExp(IfExp<EClassifier> ie) {
        if (ie == sourceExpression) {
            sourceExpression = null;
            return valueOfSourceExpression;
        }
        return super.visitIfExp(ie);
    }

    @Override
    public Object visitTypeExp(TypeExp<EClassifier> t) {
        if (t == sourceExpression) {
            sourceExpression = null;
            return valueOfSourceExpression;
        }
        return super.visitTypeExp(t);
    }

    @Override
    public Object visitStateExp(StateExp<EClassifier, EObject> s) {
        if (s == sourceExpression) {
            sourceExpression = null;
            return valueOfSourceExpression;
        }
        return super.visitStateExp(s);
    }

    @Override
    public Object visitMessageExp(MessageExp<EClassifier, CallOperationAction, SendSignalAction> m) {
        if (m == sourceExpression) {
            sourceExpression = null;
            return valueOfSourceExpression;
        }
        return super.visitMessageExp(m);
    }

    @Override
    public Object visitUnspecifiedValueExp(UnspecifiedValueExp<EClassifier> uv) {
        if (uv == sourceExpression) {
            sourceExpression = null;
            return valueOfSourceExpression;
        }
        return super.visitUnspecifiedValueExp(uv);
    }

    @Override
    public Object visitIntegerLiteralExp(IntegerLiteralExp<EClassifier> il) {
        if (il == sourceExpression) {
            sourceExpression = null;
            return valueOfSourceExpression;
        }
        return super.visitIntegerLiteralExp(il);
    }

    @Override
    public Object visitUnlimitedNaturalLiteralExp(UnlimitedNaturalLiteralExp<EClassifier> literalExp) {
        if (literalExp == sourceExpression) {
            sourceExpression = null;
            return valueOfSourceExpression;
        }
        return super.visitUnlimitedNaturalLiteralExp(literalExp);
    }

    @Override
    public Object visitRealLiteralExp(RealLiteralExp<EClassifier> rl) {
        if (rl == sourceExpression) {
            sourceExpression = null;
            return valueOfSourceExpression;
        }
        return super.visitRealLiteralExp(rl);
    }

    @Override
    public Object visitStringLiteralExp(StringLiteralExp<EClassifier> sl) {
        if (sl == sourceExpression) {
            sourceExpression = null;
            return valueOfSourceExpression;
        }
        return super.visitStringLiteralExp(sl);
    }

    @Override
    public Object visitBooleanLiteralExp(BooleanLiteralExp<EClassifier> bl) {
        if (bl == sourceExpression) {
            sourceExpression = null;
            return valueOfSourceExpression;
        }
        return super.visitBooleanLiteralExp(bl);
    }

    @Override
    public Object visitInvalidLiteralExp(InvalidLiteralExp<EClassifier> il) {
        if (il == sourceExpression) {
            sourceExpression = null;
            return valueOfSourceExpression;
        }
        return super.visitInvalidLiteralExp(il);
    }

    @Override
    public Object visitNullLiteralExp(NullLiteralExp<EClassifier> il) {
        if (il == sourceExpression) {
            sourceExpression = null;
            return valueOfSourceExpression;
        }
        return super.visitNullLiteralExp(il);
    }

    @Override
    public Object visitLetExp(LetExp<EClassifier, EParameter> l) {
        if (l == sourceExpression) {
            sourceExpression = null;
            return valueOfSourceExpression;
        }
        return super.visitLetExp(l);
    }

    @Override
    public Object visitCollectionLiteralExp(CollectionLiteralExp<EClassifier> cl) {
        if (cl == sourceExpression) {
            sourceExpression = null;
            return valueOfSourceExpression;
        }
        return super.visitCollectionLiteralExp(cl);
    }

    @Override
    public Object visitTupleLiteralExp(TupleLiteralExp<EClassifier, EStructuralFeature> tl) {
        if (tl == sourceExpression) {
            sourceExpression = null;
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
        EStructuralFeature property = (EStructuralFeature) pc.getReferredOppositeProperty();
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
                localResult = ((EvaluationEnvironmentWithHiddenOpposites<EStructuralFeature>) getEvaluationEnvironment()).navigateOppositeProperty(property, context);
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

    protected org.eclipse.ocl.ecore.OCLExpression getSourceExpression() {
        return sourceExpression;
    }

    protected void setSourceExpression(org.eclipse.ocl.ecore.OCLExpression sourceExpression) {
        this.sourceExpression = sourceExpression;
    }

    protected Object getValueOfSourceExpression() {
        return valueOfSourceExpression;
    }

    protected Notification getAtPre() {
        return atPre;
    }
}
