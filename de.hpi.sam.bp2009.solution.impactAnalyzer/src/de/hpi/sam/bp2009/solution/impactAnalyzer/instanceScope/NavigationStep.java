package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.event.ChangeListener;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;

/**
 * During instance scope analysis, starting from an event's source element, by navigation the analyzer is trying to find a small
 * superset of those context elements for which re-evaluating the OCL expression may yield a different value after the event
 * compared to the value the OCL expression would have returned before the event. This navigation is performed by following a set
 * of pre-computed paths. The paths are precomputed because many subexpressions in an OCL expression do not reasonably contribute
 * to the finding of those contexts and should therefore be pruned during an analysis that is performend only once per expression.
 * <p>
 * 
 * Navigation steps are generally able to navigate from one or more {@link EObject}s to zero or more {@link EObject}s. Each
 * navigation step knows its static start and end type. If the source element's type doesn't conform to the step's start type, the
 * navigation is not performed and an empty set is returned immediately. If the target type is not matched, an empty set is
 * returned, too.
 * <p>
 * 
 * Navigation steps may form a possibly cyclic (in case of recursive operations) graph. Steps may navigate, e.g., along
 * associations or ascend the composition hierarchy, using {@link RefObject#refImmediateComposite()}.
 * <p>
 * 
 * A navigation step object may change its {@link #hashCode()} over its life time. This particularly has to do with
 * the propagation of information taking place after an {@link IndirectingStep} has its actual step set. This can lead
 * to a ripple effect regarding source and target type settings as well as {@link #isAlwaysEmpty()} changes, all
 * affecting a step's hash code and equality definition. Whenever you insert a navigation step into a hashing
 * structure such as a {@link HashMap} or a {@link HashSet}, ensure that you use {@link #addHashCodeChangeListener(HashCodeChangeListener)}
 * to register yourself as a listener for hash code changes. Whenever such a change is signalled, take this as an
 * opportunity to first remove (before the change) the navigation step object from the hashing structure and then
 * insert it again with the new hash code after the change. See also {@link HashCodeChangeListener}. 
 */
public interface NavigationStep {
    public Set<AnnotatedEObject> navigate(Set<AnnotatedEObject> from, Map<List<Object>, Set<AnnotatedEObject>> cache,
            Notification changeEvent);

    /**
     * Some "navigation" steps produce absolute results, ignoring the <tt>from</tt> object that is passed to
     * {@link #navigate(Set, Map, Notification)}. Those must return <tt>true</tt> here. Examples are navigation steps returning
     * all instances of a given type and the step always returning the empty set.
     */
    boolean isAbsolute();

    /**
     * Tells if this step in all cases returns an empty set. Specific shortcuts may be taken for such steps when combining them
     * with other steps.
     * <p>
     * 
     * {@link #isAlwaysEmpty()} implies {@link #isAbsolute()}
     */
    boolean isAlwaysEmpty();

    EClass getSourceType();

    EClass getTargetType();

    /**
     * Optionally, a navigation step may tell for which OCL expression it was mainly created. This can aid the impact analysis
     * debugging process. May return <tt>null</tt>.
     * 
     * @return
     */
    Set<OCLExpression> getDebugInfo();

    /**
     * Whenever the result of {@link #isAlwaysEmpty()} changes, registered listeners will be informed by calling their
     * {@link ChangeListener#alwaysEmptyChanged(NavigationStep)} method with this step as parameter.
     */
    void addAlwaysEmptyChangeListener(AlwaysEmptyChangeListener listener);

    /**
     * Whenever the result of {@link #getSourceType()} changes, registered listeners will be informed by calling their
     * {@link SourceTypeChangeListener#sourceTypeChanged(NavigationStep)} method with this step as parameter.
     */
    void addSourceTypeChangeListener(SourceTypeChangeListener listener);

    /**
     * Whenever the result of {@link #getTargetType()} changes, registered listeners will be informed by calling their
     * {@link TargetTypeChangeListener#targetTypeChanged(NavigationStep)} method with this step as parameter.
     */
    void addTargetTypeChangeListener(TargetTypeChangeListener listener);
    
    void addHashCodeChangeListener(HashCodeChangeListener listener);

    /**
     * Counts the number of steps in the navigation step tree of which this is the root
     */
    int size();

    /**
     * Adds <code>oclExpression</code> as an expression for which this is the computed
     * navigation step. Multiple expressions may share the same navigation step. An expression
     * added here will be returned in the set resulting from {@link #getDebugInfo()}.
     */
    void addExpressionForWhichThisIsNavigationStep(OCLExpression oclExpression);

}
