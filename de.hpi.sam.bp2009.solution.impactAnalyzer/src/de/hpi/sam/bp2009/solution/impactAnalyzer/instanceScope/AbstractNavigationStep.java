package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.ocl.ecore.OCLExpression;

import com.sap.emf.ocl.hiddenopposites.DefaultOppositeEndFinder;

import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.OclHelper;
import de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser;


public abstract class AbstractNavigationStep implements NavigationStep {
    private static int idCounter;
    private final int id;
    private EClass sourceType;
    private EClass targetType;
    private final Set<OCLExpression> debugInfo;
    private int cacheMisses;
    private int resultObjectsCounter;
    private Set<AlwaysEmptyChangeListener> alwaysEmptyChangeListeners = null;
    private Set<SourceTypeChangeListener> sourceTypeChangeListeners = null;
    private Set<TargetTypeChangeListener> targetTypeChangeListeners = null;
    private boolean alwaysEmpty;
    private String annotation;
    
    private final static String NOT_IN_DEBUG_MODE_MESSAGE = "To enable annotations, set the system property de.hpi.sam.bp2009.solution.impactAnalyzer.debug to true, "
        + "e.g., by using the VM argument -Dde.hpi.sam.bp2009.solution.impactAnalyzer.debug=true";
    private final static boolean IS_IN_DEBUG_MODE = Boolean.getBoolean("de.hpi.sam.bp2009.solution.impactAnalyzer.debug");
    
    /**
     * The navigateCounter counts how many times the navigate method of this NavigationStep is called
     */
    private int navigateCounter;
    
    public AbstractNavigationStep(EClass sourceType, EClass targetType, OCLExpression debugInfo) {
        this.sourceType = sourceType;
        this.targetType = targetType;
        this.debugInfo = new HashSet<OCLExpression>();
        this.debugInfo.add(debugInfo);
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
	if(this.alwaysEmptyChangeListeners == null){
	    this.alwaysEmptyChangeListeners = new HashSet<AlwaysEmptyChangeListener>(1);
	}
	
        alwaysEmptyChangeListeners.add(listener);
    }

    @Override
    public void addSourceTypeChangeListener(SourceTypeChangeListener listener) {
	if(this.sourceTypeChangeListeners == null){
	    this.sourceTypeChangeListeners = new HashSet<SourceTypeChangeListener>(1);
	}
	
        sourceTypeChangeListeners.add(listener);
    }

    @Override
    public void addTargetTypeChangeListener(TargetTypeChangeListener listener) {
	if(this.targetTypeChangeListeners == null){
	    this.targetTypeChangeListeners = new HashSet<TargetTypeChangeListener>(1);
	}
	
	targetTypeChangeListeners.add(listener);
    }

    void setSourceType(EClass sourceType) {
        boolean changed = (this.sourceType == null && sourceType != null)
        || (this.sourceType != null && !this.sourceType.equals(sourceType));
        if (changed) {
            this.sourceType = sourceType;
            if(sourceTypeChangeListeners != null){
                for (SourceTypeChangeListener listener : sourceTypeChangeListeners) {
                    listener.sourceTypeChanged(this);
                }
            }
        }
    }

    void setTargetType(EClass targetType) {
        boolean changed = (this.targetType == null && targetType != null)
        || (this.targetType != null && !this.targetType.equals(targetType));
        if (changed) {
            this.targetType = targetType;
            if(targetTypeChangeListeners != null){
                for (TargetTypeChangeListener listener : targetTypeChangeListeners) {
                    listener.targetTypeChanged(this);
                }
            }
        }
    }
    
    @Override
    public void addExpressionForWhichThisIsNavigationStep(OCLExpression oclExpression) {
        debugInfo.add(oclExpression);
    }

    public int getNavigateCounter() {
        return navigateCounter;
    }

    public int getResultObjectsCounter() {
        return resultObjectsCounter;
    }

    @Override
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
     * Breaks down the navigation from the <tt>from</tt> set to the individual elements in <tt>from</tt> and
     * manages the type checks.
     */
    @Override
    public Set<AnnotatedEObject> navigate(Set<AnnotatedEObject> from, Map<List<Object>, Set<AnnotatedEObject>> cache, Notification changeEvent) {
        incrementNavigateCounter(from);

        Set<AnnotatedEObject> result = new HashSet<AnnotatedEObject>();
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

    private Collection<AnnotatedEObject> getFromCacheOrNavigate(AnnotatedEObject fromObject, Map<List<Object>, Set<AnnotatedEObject>> cache, Notification changeEvent) {
        Set<AnnotatedEObject> result;
        List<Object> cacheKey = new BasicEList<Object>();
        cacheKey.add(this);
        cacheKey.add(fromObject);

        result = cache.get(cacheKey);
        if (result == null) {
            cacheMisses++;
            result = navigate(fromObject , cache, changeEvent); 
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
            if(alwaysEmptyChangeListeners != null){
                for (AlwaysEmptyChangeListener listener : alwaysEmptyChangeListeners) {
                    listener.alwaysEmptyChanged(this);
                }
            }
        }
    }

    protected abstract Set<AnnotatedEObject> navigate(AnnotatedEObject fromObject,
            Map<List<Object>, Set<AnnotatedEObject>> cache, Notification changeEvent);

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
        return visited.contains(this) ? 0 : 1;
    }

    public int getId(){
	return id;
    }
    
}
