package com.sap.tc.moin.ocl.ia.instancescope;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.omg.ocl.expressions.OclExpression;
import org.omg.ocl.expressions.__impl.OclExpressionInternal;

import com.sap.tc.moin.ocl.utils.impl.OclSerializer;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.shared.util.Tuple.Pair;

public abstract class AbstractNavigationStep implements NavigationStep {
    private static int idCounter;
    private final int id;
    private MofClass sourceType;
    private MofClass targetType;
    private OclExpressionInternal debugInfo;
    private int navigateCounter;
    private int cacheMisses;
    private int resultObjectsCounter;
    private Set<AlwaysEmptyChangeListener> alwaysEmptyChangeListeners;
    private Set<SourceTypeChangeListener> sourceTypeChangeListeners;
    private Set<TargetTypeChangeListener> targetTypeChangeListeners;
    private boolean alwaysEmpty;
    private String annotation;

    public AbstractNavigationStep(MofClass sourceType, MofClass targetType, OclExpressionInternal debugInfo) {
	this.sourceType = sourceType;
	this.targetType = targetType;
	this.debugInfo = debugInfo;
	this.alwaysEmptyChangeListeners = new HashSet<AlwaysEmptyChangeListener>();
	this.sourceTypeChangeListeners = new HashSet<SourceTypeChangeListener>();
	this.targetTypeChangeListeners = new HashSet<TargetTypeChangeListener>();
	this.id = idCounter++;
    }
    
    public MofClass getTargetType() {
	return this.targetType;
    }
    
    public MofClass getSourceType() {
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
    
    void setSourceType(MofClass sourceType) {
	boolean changed = (this.sourceType == null && sourceType != null)
		|| (this.sourceType != null && !this.sourceType.equals(sourceType));
	if (changed) {
	    this.sourceType = sourceType;
	    for (SourceTypeChangeListener listener : sourceTypeChangeListeners) {
		listener.sourceTypeChanged(this);
	    }
	}
    }
    
    void setTargetType(MofClass targetType) {
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
    public OclExpressionInternal getDebugInfo() {
	return debugInfo;
    }
    
    protected AnnotatedRefObjectImpl annotateRefObject(CoreConnection conn, AnnotatedRefObjectImpl fromObject,
	    RefObjectImpl next) {
	final String notInDebugMode = "To enable annotations, set the system property com.sap.tc.moin.ocl.debug to true, "
		+ "e.g., by using the VM argument -Dcom.sap.tc.moin.ocl.debug=true";
	final boolean debugMode = Boolean.getBoolean("com.sap.tc.moin.ocl.debug");
	if (debugMode) {
	    return new AnnotatedRefObjectImpl(fromObject.getAnnotation()+
		"\n------------- tracing back through ---------------\n"+
		getAnnotation(conn)+
		"\narriving at object: "+next,
		next);
	} else {
	    return new AnnotatedRefObjectImpl(notInDebugMode, next);
	}
    }

    protected String getAnnotation(CoreConnection conn) {
	if (annotation == null) {
	    annotation = getVerboseDebugInfo(conn);
	}
	return annotation;
    }

    /**
     * Constructs a human-readable description of the OCL expression used as debug info for this
     * navigation step. This includes traveling up to the root expression in which the debug info
     * expression is embedded.
     */
    private String getVerboseDebugInfo(CoreConnection conn) {
	final String notInDebugMode = "To enable annotations, set the system property com.sap.tc.moin.ocl.debug to true, "
		+ "e.g., by using the VM argument -Dcom.sap.tc.moin.ocl.debug=true";
	final boolean debugMode = Boolean.getBoolean("com.sap.tc.moin.ocl.debug");
	try {
	    if (debugMode) {
		OclSerializer serializer = OclSerializer.getInstance(conn);
		return "Step's expression: "
			+ serializer.serialize((OclExpression) this.getDebugInfo(), new RefPackage[0])
			+ "\n ===== in expression =====\n"
			+ serializer.serializeAndHighlight(AbstractTracer.getRootExpression((RefObjectImpl) this
				.getDebugInfo(), conn), (OclExpression) this.getDebugInfo(), new RefPackage[0])
			+ (InstanceScopeAnalysis.getDefines(conn, AbstractTracer.getRootExpression((RefObjectImpl) this
				.getDebugInfo(), conn)) != null ? "\n ===== which is the body of operation "
				+ InstanceScopeAnalysis.getDefines(conn,
					AbstractTracer.getRootExpression((RefObjectImpl) this.getDebugInfo(), conn))
					.getName() + " =====" : "");
	    } else {
		return notInDebugMode;
	    }
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }

    /**
     * The incrementing of the navigate counter gets its own protected method because subclasses
     * must be able to suppress incrementing under special circumstances
     * (e.g. suppress count of additional recursive round trip in IndirectingStep)
     */
    protected void incrementNavigateCounter(CoreConnection conn, Set<AnnotatedRefObjectImpl> from){
	navigateCounter++;
    }
    
    /**
     * Breaks down the navigation from the <tt>from</tt> set to the individual elements in <tt>from</tt> and
     * manages the type checks.
     */
    @Override
    public Set<AnnotatedRefObjectImpl> navigate(CoreConnection conn, Set<AnnotatedRefObjectImpl> from,
	    Map<Pair<NavigationStep, RefObjectImpl>, Set<AnnotatedRefObjectImpl>> cache, Set<Pair<RefFeatured, RefObject>> throwExceptionWhenVisiting) {
	incrementNavigateCounter(conn, from);
	
	Set<AnnotatedRefObjectImpl> result = new HashSet<AnnotatedRefObjectImpl>();
	if (isAbsolute()) {
	    from = Collections.singleton(null);
	}
	if (!isAlwaysEmpty()) { // don't do anything for empty steps
	    for (AnnotatedRefObjectImpl fromObject : from) {
		// for absolute steps, don't do the source type check and invoke just once, passing null for "from"
		if (isAbsolute() || AbstractTracer.doesTypeMatch(conn, getSourceType(), fromObject.getElement())) {
		    for (AnnotatedRefObjectImpl singleResult : getFromCacheOrNavigate(conn, fromObject, cache, throwExceptionWhenVisiting)) {
			if (AbstractTracer.doesTypeMatch(conn, getTargetType(), singleResult.getElement())) {
			    result.add(singleResult);
			}
		    }
		}
	    }
	}
	resultObjectsCounter += result.size();
	return result;
    }
    
    private Collection<AnnotatedRefObjectImpl> getFromCacheOrNavigate(CoreConnection conn,
	    AnnotatedRefObjectImpl fromObject, Map<Pair<NavigationStep, RefObjectImpl>, Set<AnnotatedRefObjectImpl>> cache, Set<Pair<RefFeatured, RefObject>> throwExceptionWhenVisiting) {
	Set<AnnotatedRefObjectImpl> result;
	Pair<NavigationStep, RefObjectImpl> cacheKey = new Pair<NavigationStep, RefObjectImpl>(this, fromObject.getElement());
	result = cache.get(cacheKey);
	if (result == null) {
	    cacheMisses++;
	    result = navigate(conn, fromObject, cache, throwExceptionWhenVisiting);
	    if (result.contains(null)) {
		throw new RuntimeException("OCL Instance Scope Analysis hit a null value where it shouldn't have");
	    } else {
		cache.put(cacheKey, result);
	    }
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
    
    protected abstract Set<AnnotatedRefObjectImpl> navigate(CoreConnection conn, AnnotatedRefObjectImpl fromObject,
	    Map<Pair<NavigationStep, RefObjectImpl>, Set<AnnotatedRefObjectImpl>> cache, Set<Pair<RefFeatured, RefObject>> throwExceptionWhenVisiting);

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
    
    public int getId() {
	return id;
    }
}
