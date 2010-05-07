package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.Collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;


public abstract class AbstractNavigationStep implements NavigationStep {
    private static int idCounter;
    private final int id;
    private EClass sourceType;
    private EClass targetType;
    private OCLExpression debugInfo;
    private int navigateCounter;
    private int cacheMisses;
    private int resultObjectsCounter;
    private Set<AlwaysEmptyChangeListener> alwaysEmptyChangeListeners;
    private Set<SourceTypeChangeListener> sourceTypeChangeListeners;
    private Set<TargetTypeChangeListener> targetTypeChangeListeners;
    private boolean alwaysEmpty;

    public AbstractNavigationStep(EClass sourceType, EClass targetType, OCLExpression debugInfo2) {
        this.sourceType = sourceType;
        this.targetType = targetType;
        this.debugInfo = debugInfo2;
        this.alwaysEmptyChangeListeners = new HashSet<AlwaysEmptyChangeListener>();
        this.sourceTypeChangeListeners = new HashSet<SourceTypeChangeListener>();
        this.targetTypeChangeListeners = new HashSet<TargetTypeChangeListener>();
        this.id = idCounter++;
    }

    public EClass getTargetType() {
        return this.targetType;
    }

    public EClass getSourceType() {
        return this.sourceType;
    }

    @Override
    public void addAlwaysEmptyChangeListener(AlwaysEmptyChangeListener listener) {
        alwaysEmptyChangeListeners.add(listener);
    }

    @Override
    public void addASourceTypeChangeListener(SourceTypeChangeListener listener) {
        sourceTypeChangeListeners.add(listener);
    }

    @Override
    public void addTargetTypeChangeListener(TargetTypeChangeListener listener) {
        targetTypeChangeListeners.add(listener);
    }

    void setSourceType(EClass sourceType) {
        boolean changed = (this.sourceType == null && sourceType != null)
        || (this.sourceType != null && !this.sourceType.equals(sourceType));
        if (changed) {
            this.sourceType = sourceType;
            for (SourceTypeChangeListener listener : sourceTypeChangeListeners) {
                listener.sourceTypeChanged(this);
            }
        }
    }

    void setTargetType(EClass targetType) {
        boolean changed = (this.targetType == null && targetType != null)
        || (this.targetType != null && !this.targetType.equals(targetType));
        if (changed) {
            this.targetType = targetType;
            for (TargetTypeChangeListener listener : targetTypeChangeListeners) {
                listener.targetTypeChanged(this);
            }
        }
    }

    public int getNavigateCounter() {
        return navigateCounter;
    }

    public int getResultObjectsCounter() {
        return resultObjectsCounter;
    }

    @Override
    public OCLExpression getDebugInfo() {
        return debugInfo;
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
     * Breaks down the navigation from the <tt>from</tt> set to the individual elements in <tt>from</tt> and
     * manages the type checks.
     */
    @Override
    public Set<AnnotatedEObject> navigate(Set<AnnotatedEObject> from, Map<List<Object>, Set<AnnotatedEObject>> cache) {
        incrementNavigateCounter(from);

        Set<AnnotatedEObject> result = new HashSet<AnnotatedEObject>();
        if (isAbsolute()) {
            from = Collections.singleton(null);
        }
        if (!isAlwaysEmpty()) { // don't do anything for empty steps
            for (AnnotatedEObject fromObject : from) {
                // for absolute steps, don't do the source type check and invoke just once, passing null for "from"
                if (isAbsolute() || AbstractTracer.doesTypeMatch(getSourceType(), fromObject)) {
                    for (AnnotatedEObject singleResult : getFromCacheOrNavigate(fromObject, cache)) {
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

    private Collection<AnnotatedEObject> getFromCacheOrNavigate(AnnotatedEObject fromObject, Map<List<Object>, Set<AnnotatedEObject>> cache) {
        Set<AnnotatedEObject> result;
        List<Object> cacheKey = new BasicEList<Object>();
        cacheKey.add(this);
        cacheKey.add(fromObject);

        result = cache.get(cacheKey);
        if (result == null) {
            cacheMisses++;
            Set<AnnotatedEObject> from = new HashSet<AnnotatedEObject>();
            from.add(fromObject);
            result = navigate(from , cache); 
            cache.put(cacheKey, result);
        }
        return result;
    }

    /**
     * By default, navigation steps depend on the object set to which they are applied.
     * 
     * @return always <tt>false</tt>
     */
    @Override
    public boolean isAbsolute() {
        return false;
    }

    /**
     * By default it is expected that steps return non-empty sets in some cases.
     * @return always <tt>false</tt>
     */
    @Override
    public boolean isAlwaysEmpty() {
        return alwaysEmpty;
    }

    protected void setAlwaysEmpty() {
        if (!this.alwaysEmpty) {
            this.alwaysEmpty = true;
            for (AlwaysEmptyChangeListener listener : alwaysEmptyChangeListeners) {
                listener.alwaysEmptyChanged(this);
            }
        }
    }

    protected abstract Set<AnnotatedEObject> navigate(AnnotatedEObject fromObject,
            Map<List<Object>, Set<AnnotatedEObject>> cache);

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

    protected String contentToString(Map<NavigationStep, Integer> visited, int indent) {
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
            Collection<Object> targetSubtypesIncludingTargetType = EcoreUtil.getObjectsByType(a.getEPackage().getEClassifiers(), a);
            if (targetSubtypesIncludingTargetType.contains(b)) {
                result = true;
            } else {
                for (Object sourceSubType : EcoreUtil.getObjectsByType(b.getEPackage().getEClassifiers(), b)) {
                    if (targetSubtypesIncludingTargetType.contains((EClassifier)sourceSubType)) {
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
        return visited.contains(this) ? 0 : 1;
    }

}
