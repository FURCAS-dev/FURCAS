package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.CallExp;
import org.eclipse.ocl.ecore.IteratorExp;
import org.eclipse.ocl.ecore.LoopExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.utilities.PredefinedType;

import de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation.PartialEvaluator;
import de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation.ValueNotFoundException;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;

/**
 * Evaluates an OCL expression that is expected to be the {@link IteratorExp#getBody() body} expression of an iterator expression.
 * Before the evaluation is triggered, the single iterator variable obtained from {@link LoopExp#getIterators()} is set to the
 * {@link RefObject} passed to {@link #navigate(CoreConnection, AnnotatedRefObjectImpl, Map, Set)} in the <tt>fromObject</tt>
 * parameter. Depending on the particular type of iterator (<tt>select</tt>, <tt>reject</tt> or <tt>any</tt>), the object is
 * passed on if and only if the OCL expression evaluates to <tt>true</tt>/<tt>false</tt>/<tt>true</tt>, respectively. For any
 * iterators other than <tt>select</tt>, <tt>reject</tt> or <tt>any</tt> the object is passed through right away because the
 * semantics of the iterator are not known.
 * 
 * @author Axel Uhl D043530
 * 
 */
public class PredicateCheckNavigationStep extends AbstractNavigationStep {
    private String contentAsString;

    /**
     * Tells if the OCL predicate of the {@link #getIteratorExp() iterator expression} needs to be <tt>true</tt> so that the
     * element can pass through. This is the case for <tt>select</tt> and <tt>any</tt> iterators. For <tt>reject</tt> it's
     * <tt>false</tt>.
     */
    private final boolean positive;

    public PredicateCheckNavigationStep(EClass sourceType, EClass targetType, IteratorExp iteratorExp, PathCache pathCache) {
        super(sourceType, targetType, (OCLExpression) iteratorExp);
        if (!haveIntersectingSubclassTree(sourceType, targetType)) {
            setAlwaysEmpty();
        }
        if (iteratorExp.getName().equals(PredefinedType.SELECT_NAME) || iteratorExp.getName().equals(PredefinedType.ANY_NAME)) {
            positive = true;
        } else {
            positive = false;
        }
        // TODO check if this is expressive enough
        contentAsString = "checkPredicate[" + iteratorExp.getBody().toString() + "]";
    }

    private IteratorExp getIteratorExp() {
        return (IteratorExp) getDebugInfo();
    }

    @Override
    protected Set<AnnotatedEObject> navigate(AnnotatedEObject fromObject, Map<List<Object>, Set<AnnotatedEObject>> cache,
            Notification atPre) {
        Set<AnnotatedEObject> result = new LinkedHashSet<AnnotatedEObject>(1);
        Set<EObject> sourceValue = new LinkedHashSet<EObject>(1);
        sourceValue.add(fromObject.getAnnotatedObject());
        boolean passedPredicate = evaluate((OCLExpression) getIteratorExp(), sourceValue, atPre);
        if (passedPredicate) {
            result.add(fromObject);
        }
        return result;
    }

    private Boolean evaluate(OCLExpression exp, Collection<EObject> sourceObjects, Notification atPre) {
        // evaluate whether the source object would have passed the iterator's body before the change

        Boolean resultPre = positive;
        if (!(atPre == null)) {
            PartialEvaluator evalPre = new PartialEvaluator(atPre);
            try {
                Object result = evalPre.evaluate(null, (CallExp) exp, sourceObjects);
                resultPre = sourceObjects.contains(result);
            } catch (ValueNotFoundException vnfe) {
                // be conservative about undefined situations
                resultPre = positive;
            } catch (ClassCastException cce) {
                throw new RuntimeException("The result of the iterator expression's body is not of type Boolean.");
            }
        }
        // evaluate whether the source object passes the iterator's body after the change

        PartialEvaluator evalPost = new PartialEvaluator();
        Boolean resultPost;
        try {
            Object result = evalPost.evaluate(null, (CallExp) exp, sourceObjects);
            resultPost = sourceObjects.contains(result) ;
        } catch (ValueNotFoundException vnfe) {
            // be conservative about undefined situations
            resultPost = positive;
        } catch (ClassCastException cce) {
            throw new RuntimeException("The result of the iterator expression's body is not of type Boolean.");
        }
        // if the source object fulfills the condition before or after the change event
        // or accesses an undefined variable before or after the change event
        // it passes this navigation step
        return resultPre == positive || resultPost == positive;
    }

    @Override
    public String contentToString(Map<NavigationStep, Integer> visited, int indent) {
        return contentAsString;
    }
}
