package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.ocl.ecore.OCLExpression;

import com.sap.emf.ocl.hiddenopposites.DefaultOppositeEndFinder;
import com.sap.emf.ocl.util.OclHelper;

import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.SemanticIdentity;
import de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser;

/**
 * Abstract implementation of the {@link NavigationStep} interface. Provides fields for source and target type and performs the
 * necessary type checks in {@link #navigate(Set, TracebackCache, Notification)}. Furthermore, does the unfolding of the <code>from</code>
 * argument to {@link #navigate(Set, TracebackCache, Notification)} and dispatches for individual objects to the
 * {@link #navigate(AnnotatedEObject, TracebackCache, Notification)} operation to be implemented by all subclasses. Furthermore, generaly
 * bookkeeping facilities are implemented here, such as counting cache misses, managing an {@link #id ID} and maintaining for
 * which {@link OCLExpression}s this is the corresponding navigation step (see {@link #debugInfo}).
 * <p>
 *
 * This class implements the observer pattern specified by the {@link NavigationStep} interface for setting the source and target
 * type and for defining this step as always empty.
 * <p>
 *
 * A default {@link #hashCode} and {@link #equals} implementation is provided based on the <em>behavior</em> of this step.
 * Navigation steps are only allowed to call themselves equal to another step if for all <code>from</code> objects their
 * {@link #navigate(AnnotatedEObject, TracebackCache, Notification)} operation returns equal results for an equal model state and the same
 * original change {@link Notification notification}.<p>
 *
 * Subclasses have to make sure that any modification to equals/hashCode-related parts of the object's state
 * are announced by firing {@link HashCodeChangeListener#beforeHashCodeChange(NavigationStep, int)} before
 * and {@link HashCodeChangeListener#afterHashCodeChange(NavigationStep, int)} after the change. This class
 * manages this for those state changes affecting this class's implementation of equals/hashCode.
 *
 * @author Axel Uhl
 */
public abstract class AbstractNavigationStep implements NavigationStep {
    private static int idCounter;
    private final int id;
    private EClass sourceType;
    private EClass targetType;
    private final Set<OCLExpression> debugInfo;
    private int cacheMisses;
    private int resultObjectsCounter;
    private List<AlwaysEmptyChangeListener> alwaysEmptyChangeListeners = null;
    private List<SourceTypeChangeListener> sourceTypeChangeListeners = null;
    private List<TargetTypeChangeListener> targetTypeChangeListeners = null;
    private List<HashCodeChangeListener> hashCodeChangeListeners = null;
    private boolean alwaysEmpty;
    private String annotation;
    private final SemanticIdentity semanticIdentity;

    private final static String NOT_IN_DEBUG_MODE_MESSAGE = "To enable annotations, set the system property de.hpi.sam.bp2009.solution.impactAnalyzer.debug to true, "
        + "e.g., by using the VM argument -Dde.hpi.sam.bp2009.solution.impactAnalyzer.debug=true";
    private final static boolean IS_IN_DEBUG_MODE = Boolean.getBoolean("de.hpi.sam.bp2009.solution.impactAnalyzer.debug");

    /**
     * The navigateCounter counts how many times the navigate method of this NavigationStep is called
     */
    private int navigateCounter;
    /**
     * Used for calls to {@link AbstractNavigationStep#fireAfterHashCodeChange(int)} and
     * {@link AbstractNavigationStep#fireBeforeHashCodeChange(int)} to generate a new token.
     */
    private static int maxToken = 0;

    public AbstractNavigationStep(EClass sourceType, EClass targetType, OCLExpression debugInfo) {
        this.sourceType = sourceType;
        this.targetType = targetType;
        this.debugInfo = new HashSet<OCLExpression>();
        this.debugInfo.add(debugInfo);
        this.id = idCounter++;
        this.semanticIdentity = new AbstractNavigationStepIdentity();
    }

    protected static int newTokenForFiringHashCodeChangeEvent() {
        return maxToken++;
    }

    private class AbstractNavigationStepIdentity extends SemanticIdentity {
	/**
	 * For source and target type, special rules apply. Normally, if either
	 * of them is <code>null</code>, this means that it hasn't been
	 * initialized yet, e.g., because it depends on some
	 * {@link IndirectingStep} getting its source or target type set later.
	 * This will then propagate through the observer pattern (see
	 * {@link #addSourceTypeChangeListener(SourceTypeChangeListener)} and
	 * {@link #addTargetTypeChangeListener(TargetTypeChangeListener)} to the
	 * using step(s). However, until this propagation has taken place, we
	 * don't know yet what the source or target type, respectively, will be.
	 * Therefore, we have to be conservative and assume that they eventually
	 * will be set to different values, so <code>false</code> will be
	 * returned for <code>null</code> values of either source or target
	 * type.
	 * <p>
	 *
	 * There is one exception, though: if a step {@link #isAbsolute() is
	 * absolute}, then its source type may be ignored and will be ignored
	 * for this equality comparison.
	 */
	@Override
	public boolean equals(Object o) {
	    if (this == o) {
		return true;
	    }
	    boolean result = false;
	    if (o instanceof AbstractNavigationStepIdentity) {
		AbstractNavigationStep otherStep = ((AbstractNavigationStepIdentity) o).getNavigationStep();
		result = getNavigationStep().getClass() == otherStep.getClass()
			&& getNavigationStep().alwaysEmpty == otherStep.alwaysEmpty
			&& ((isAbsolute() && otherStep.isAbsolute()) || (getNavigationStep().sourceType != null
				&& otherStep.sourceType != null && getNavigationStep().sourceType.equals(otherStep.sourceType)))
			&& getNavigationStep().targetType != null && otherStep.targetType != null
			&& getNavigationStep().targetType.equals(otherStep.targetType);
	    }
	    return result;
	}

	@Override
	public int calculateHashCode() {
	    return 4711 ^ getClass().hashCode() ^ (alwaysEmpty ? 31 : 0) ^ (sourceType == null ? 0 : sourceType.hashCode())
		    ^ (targetType == null ? 0 : targetType.hashCode());
	}

	public AbstractNavigationStep getNavigationStep() {
	    return AbstractNavigationStep.this;
	}

	@Override
	public NavigationStep getStep() {
	    return getNavigationStep();
	}
    }

    public EClass getTargetType() {
        return this.targetType;
    }

    public EClass getSourceType() {
        return this.sourceType;
    }

    public void addAlwaysEmptyChangeListener(AlwaysEmptyChangeListener listener) {
	if(this.alwaysEmptyChangeListeners == null){
	    this.alwaysEmptyChangeListeners = new ArrayList<AlwaysEmptyChangeListener>(1);
	}
        alwaysEmptyChangeListeners.add(listener);
    }

    public void addSourceTypeChangeListener(SourceTypeChangeListener listener) {
	if(this.sourceTypeChangeListeners == null){
	    this.sourceTypeChangeListeners = new ArrayList<SourceTypeChangeListener>(1);
	}
        sourceTypeChangeListeners.add(listener);
    }

    public void addTargetTypeChangeListener(TargetTypeChangeListener listener) {
	if(this.targetTypeChangeListeners == null){
	    this.targetTypeChangeListeners = new ArrayList<TargetTypeChangeListener>(1);
	}
	targetTypeChangeListeners.add(listener);
    }
    
    public void addHashCodeChangeListener(HashCodeChangeListener listener) {
        if (this.hashCodeChangeListeners == null) {
            this.hashCodeChangeListeners = new ArrayList<HashCodeChangeListener>(1);
        }
        hashCodeChangeListeners.add(listener);
    }
    
    void setSourceType(EClass sourceType) {
        boolean changed = (this.sourceType == null && sourceType != null)
        || (this.sourceType != null && !this.sourceType.equals(sourceType));
        if (changed) {
            fireBeforeHashCodeChange(newTokenForFiringHashCodeChangeEvent());
            this.sourceType = sourceType;
            fireAfterHashCodeChange(newTokenForFiringHashCodeChangeEvent());
            if(sourceTypeChangeListeners != null){
                for (SourceTypeChangeListener listener : sourceTypeChangeListeners) {
                    listener.sourceTypeChanged(this);
                }
            }
        }
    }

    protected void fireAfterHashCodeChange(int token) {
        if (hashCodeChangeListeners != null) {
            for (HashCodeChangeListener listener : hashCodeChangeListeners) {
                listener.afterHashCodeChange(this, token);
            }
        }
    }

    protected void fireBeforeHashCodeChange(int token) {
        if (hashCodeChangeListeners != null) {
            for (HashCodeChangeListener listener : hashCodeChangeListeners) {
                listener.beforeHashCodeChange(this, token);
            }
        }
    }
    
    void setTargetType(EClass targetType) {
        boolean changed = (this.targetType == null && targetType != null)
        || (this.targetType != null && !this.targetType.equals(targetType));
        if (changed) {
            fireBeforeHashCodeChange(newTokenForFiringHashCodeChangeEvent());
            this.targetType = targetType;
            fireAfterHashCodeChange(newTokenForFiringHashCodeChangeEvent());
            if(targetTypeChangeListeners != null){
                for (TargetTypeChangeListener listener : targetTypeChangeListeners) {
                    listener.targetTypeChanged(this);
                }
            }
        }
    }

    public void addExpressionForWhichThisIsNavigationStep(OCLExpression oclExpression) {
        debugInfo.add(oclExpression);
    }

    public int getNavigateCounter() {
        return navigateCounter;
    }

    public int getResultObjectsCounter() {
        return resultObjectsCounter;
    }

    public Set<OCLExpression> getDebugInfo() {
        return debugInfo;
    }

    protected AnnotatedEObject annotateEObject(AnnotatedEObject fromObject,
            EObject next) {
        if (IS_IN_DEBUG_MODE) {
            return new AnnotatedEObject(next, fromObject.getAnnotation()+
                "\n------------- tracing back through ---------------\n"+
                getAnnotation()+
                "\narriving at object: "+next);
        } else {
            return new AnnotatedEObject(next, NOT_IN_DEBUG_MODE_MESSAGE);
        }
    }

    protected String getAnnotation() {
        if (annotation == null) {
            annotation = getVerboseDebugInfo();
        }
        return annotation;
    }

    /**
     * Constructs a human-readable description of the OCL expression used as debug info for this
     * navigation step. This includes traveling up to the root expression in which the debug info
     * expression is embedded.
     */
    private String getVerboseDebugInfo() {
        try {
            if (IS_IN_DEBUG_MODE) {
                StringBuilder result = new StringBuilder();
                result.append("Step's expressions: ");
                for (OCLExpression debugInfo : getDebugInfo()) {
                    result.append(debugInfo);
                    result.append("\n ===== in expression =====\n");
                    // TODO highlight getDebugInfo() expression in root expression
                    result.append(OclHelper.getRootExpression(debugInfo));
                    result.append(((getDefines(OclHelper.getRootExpression(debugInfo)) != null) ? "\n ===== which is the body of operation "
                            + getDefines(OclHelper.getRootExpression(debugInfo)).getName() + " ====="
                            : ""));
                    result.append("\n");
                }
                return result.toString();
            } else {
                return NOT_IN_DEBUG_MODE_MESSAGE;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private EOperation getDefines(OCLExpression rootExpression) {
        EOperation result = null;
        if (rootExpression.eContainer() instanceof EAnnotation) {
            EAnnotation annotation = (EAnnotation) rootExpression.eContainer();
            if (annotation.getSource().equals(EAnnotationOCLParser.ANNOTATION_SOURCE) &&
                    annotation.eContainer() instanceof EOperation) {
                result = (EOperation) annotation.eContainer();
            }
        }
        return result;
    }

    /**
     * The incrementing of the navigate counter gets its own protected method because subclasses
     * must be able to suppress incrementing under special circumstances
     * (e.g. suppress count of additional recursive round trip in IndirectingStep)
     */
    protected void incrementNavigateCounter(Set<AnnotatedEObject> from){
        navigateCounter++;
    }

    /**
     * Breaks down the navigation from the <tt>from</tt> set to the individual elements in <tt>from</tt> and manages the type
     * checks.
     * 
     * @param cache
     *            keys are lists of which the first element (index 0) is the {@link NavigationStep}, the second element (index 1)
     *            the from-object (of type {@link AnnotatedEObject}) for which to look up any previously computed results.
     */
    public Set<AnnotatedEObject> navigate(Set<AnnotatedEObject> from, TracebackCache cache, Notification changeEvent) {
        incrementNavigateCounter(from);

        Set<AnnotatedEObject> result = new HashSet<AnnotatedEObject>(from.size());
        if (isAbsolute()) {
            from = Collections.singleton(null);
        }
        if (!isAlwaysEmpty()) { // don't do anything for empty steps
            for (AnnotatedEObject fromObject : from) {
                // for absolute steps, don't do the source type check and invoke just once, passing null for "from"
                if (isAbsolute() || AbstractTracer.doesTypeMatch(getSourceType(), fromObject)) {
                    for (AnnotatedEObject singleResult : getFromCacheOrNavigate(fromObject, cache, changeEvent)) {
                        if (AbstractTracer.doesTypeMatch(getTargetType(), singleResult)) {
                            result.add(singleResult);
                        }
                    }
                }
            }
        }
        resultObjectsCounter += result.size();
        return result;
    }

    private Collection<AnnotatedEObject> getFromCacheOrNavigate(AnnotatedEObject fromObject, TracebackCache cache, Notification changeEvent) {
        Set<AnnotatedEObject> result;
        result = cache.get(this, fromObject);
        if (result == null) {
            cacheMisses++;
            result = navigate(fromObject, cache, changeEvent);
            cache.put(this, fromObject, result);
        }
        return result;
    }

    /**
     * By default, navigation steps depend on the object set to which they are applied.
     *
     * @return always <tt>false</tt>
     */
    public boolean isAbsolute() {
        return false;
    }

    /**
     * By default it is expected that steps return non-empty sets in some cases.
     * @return always <tt>false</tt>
     */
    public boolean isAlwaysEmpty() {
        return alwaysEmpty;
    }

    protected void setAlwaysEmpty() {
        if (!this.alwaysEmpty) {
            fireBeforeHashCodeChange(newTokenForFiringHashCodeChangeEvent());
            this.alwaysEmpty = true;
            fireAfterHashCodeChange(newTokenForFiringHashCodeChangeEvent());
            if(alwaysEmptyChangeListeners != null){
                for (AlwaysEmptyChangeListener listener : alwaysEmptyChangeListeners) {
                    listener.alwaysEmptyChanged(this);
                }
            }
        }
    }

    protected abstract Set<AnnotatedEObject> navigate(AnnotatedEObject fromObject,
            TracebackCache cache, Notification changeEvent);

    @Override
    public String toString() {
        Map<NavigationStep, Integer> visited = new HashMap<NavigationStep, Integer>();
        return toString(visited, /* indent */ 0);
    }

    private int getCacheMisses() {
        return cacheMisses;
    }

    protected String toString(Map<NavigationStep, Integer> visited, int indent) {
        if (visited.containsKey(this)) {
            return "(#"+getCacheMisses()+"/"+getNavigateCounter()+") GOTO "+visited.get(this);
        } else {
            visited.put(this, id);
            return ""+id+"(#"+getCacheMisses()+"/"+getNavigateCounter()+"):" + "(" + (getSourceType() == null ? "null" : getSourceType().getName())
            + ")" + contentToString(visited, indent) + "("
            + (getTargetType() == null ? "null" : getTargetType().getName()) + ")";
        }
    }

    public String contentToString(Map<NavigationStep, Integer> visited, int indent) {
        return "";
    }

    /**
     * For <tt>a</tt> or <tt>b</tt> being <tt>null</tt> (a yet unresolved {@link IndirectingStep}, probablu),
     * we unfortunately don't know yet if there will be a non-empty subtype tree intersection. Therefore,
     * this method returns <tt>true</tt> if either of <tt>a</tt> or <tt>b</tt> is <tt>null</tt><p>
     */
    protected static boolean haveIntersectingSubclassTree(EClass a, EClass b) {
        boolean result = a==null || b==null || a.equals(b);
        if (!result) {
            Collection<EClass> targetSubtypesIncludingTargetType = new HashSet<EClass>(DefaultOppositeEndFinder.getInstance().getAllSubclasses(a));
            targetSubtypesIncludingTargetType.add(a);
            if (targetSubtypesIncludingTargetType.contains(b)) {
                result = true;
            } else {
                Collection<EClass> sourceSubtypesIncludingSourceType = new HashSet<EClass>(DefaultOppositeEndFinder.getInstance().getAllSubclasses(b));
                sourceSubtypesIncludingSourceType.add(b);
                Collection<EClass> smaller;
                Collection<EClass> larger;
                if (targetSubtypesIncludingTargetType.size() < sourceSubtypesIncludingSourceType.size()) {
                    smaller = targetSubtypesIncludingTargetType;
                    larger = sourceSubtypesIncludingSourceType;
                } else {
                    smaller = sourceSubtypesIncludingSourceType;
                    larger = targetSubtypesIncludingTargetType;
                }
                for (Object fromSmaller : smaller) {
                    if (larger.contains((EClassifier) fromSmaller)) {
                        result = true;
                        break;
                    }
                }
            }
        }
        return result;
    }

    /**
     * The default size in particular for atomic navigation steps is <tt>1</tt>.
     */
    public int size() {
        Set<NavigationStep> visited = new HashSet<NavigationStep>();
        return size(visited);
    }

    /**
     * The default size in particular for atomic navigation steps is <tt>1</tt>.
     */
    protected int size(Set<NavigationStep> visited) {
        if(visited.contains(this)){
            return 0;
        }else{
            visited.add(this);
            return 1;
        }
    }

    public int distinctSize(){
	Set<SemanticIdentity> visited = new HashSet<SemanticIdentity>();
	return distinctSize(visited);
    }

    protected int distinctSize(Set<SemanticIdentity> visited){
        if(visited.contains(this.getSemanticIdentity())){
            return 0;
        }else{
            visited.add(this.getSemanticIdentity());
            return 1;
        }
    }

    public int getId(){
	return id;
    }

    public SemanticIdentity getSemanticIdentity() {
	return semanticIdentity;
    }
}
