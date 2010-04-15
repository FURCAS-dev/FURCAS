package de.hpi.sam.bp2009.moin.impactAnalyzer.instancescope;

import java.util.Map;
import java.util.Set;

import org.omg.ocl.expressions.__impl.OclExpressionInternal;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.shared.util.Tuple.Pair;

/**
 * During instance scope analysis, starting from an event's source element, by navigation the analyzer is trying to find
 * a small superset of those context elements for which re-evaluating the OCL expression may yield a different value
 * after the event compared to the value the OCL expression would have returned before the event. This navigation is
 * performed by following a set of pre-computed paths. The paths are precomputed because many subexpressions in an OCL
 * expression do not reasonably contribute to the finding of those contexts and should therefore be pruned during an
 * analysis that is performend only once per expression.
 * <p>
 * 
 * Navigation steps are generally able to navigate from one or more {@link RefObject}s to zero or more {@link RefObject}
 * s. Each navigation step knows its static start and end type. If the source element's type doesn't conform to the
 * step's start type, the navigation is not performed and an empty set is returned immediately. If the target type is
 * not matched, an empty set is returned, too.
 * <p>
 * 
 * Navigation steps may form a possibly cyclic (in case of recursive operations) graph. Steps may navigate, e.g., along
 * associations or ascend the composition hierarchy, using {@link RefObject#refImmediateComposite()}.
 * 
 * @author Axel Uhl (d043530)
 * 
 */
public interface NavigationStep {
    Set<RefObjectImpl> navigate(CoreConnection conn, Set<RefObjectImpl> from, Map<Pair<NavigationStep, RefObjectImpl>, Set<RefObjectImpl>> cache);
    
    /**
     * Some "navigation" steps produce absolute results, ignoring the <tt>from</tt> object that is
     * passed to {@link #navigate(CoreConnection, Set, Map)}. Those must return <tt>true</tt> here.
     * Examples are navigation steps returning all instances of a given type and the step always
     * returning the empty set.
     */
    boolean isAbsolute();
    
    /**
     * Tells if this step in all cases returns an empty set. Specific shortcuts may be taken
     * for such steps when combining them with other steps.<p>
     * 
     * {@link #isAlwaysEmpty()} implies {@link #isAbsolute()}
     */
    boolean isAlwaysEmpty();

    MofClass getSourceType();

    MofClass getTargetType();
    
    /**
     * Optionally, a navigation step may tell for which OCL expression it was mainly
     * created. This can aid the impact analysis debugging process. May return <tt>null</tt>.
     * @return
     */
    OclExpressionInternal getDebugInfo();
    
    /**
     * Whenever the result of {@link #isAlwaysEmpty()} changes, registered listeners will be
     * informed by calling their {@link ChangeListener#alwaysEmptyChanged(NavigationStep)}
     * method with this step as parameter.
     */
    void addAlwaysEmptyChangeListener(AlwaysEmptyChangeListener listener);

    /**
     * Whenever the result of {@link #getSourceType()} changes, registered listeners will be
     * informed by calling their {@link SourceTypeChangeListener#sourceTypeChanged(NavigationStep)}
     * method with this step as parameter.
     */
    void addASourceTypeChangeListener(SourceTypeChangeListener listener);

    /**
     * Whenever the result of {@link #getTargetType()} changes, registered listeners will be
     * informed by calling their {@link TargetTypeChangeListener#targetTypeChanged(NavigationStep)}
     * method with this step as parameter.
     */
    void addTargetTypeChangeListener(TargetTypeChangeListener listener);
    
    /**
     * Counts the number of steps in the navigation step tree of which this is the root
     */
    int size();
}
