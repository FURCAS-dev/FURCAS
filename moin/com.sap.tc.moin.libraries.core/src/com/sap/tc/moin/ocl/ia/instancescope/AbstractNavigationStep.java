package com.sap.tc.moin.ocl.ia.instancescope;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.omg.ocl.expressions.__impl.OclExpressionInternal;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.mmi.model.MofClass;
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

    /**
     * The incrementing of the navigate counter gets its own protected method because subclasses
     * must be able to suppress incrementing under special circumstances
     * (e.g. suppress count of additional recursive round trip in IndirectingStep)
     */
    protected void incrementNavigateCounter(CoreConnection conn, Set<RefObjectImpl> from){
	navigateCounter++;
    }
    
    /**
     * Breaks down the navigation from the <tt>from</tt> set to the individual elements in <tt>from</tt> and
     * manages the type checks.
     */
    @Override
    public Set<RefObjectImpl> navigate(CoreConnection conn, Set<RefObjectImpl> from,
	    Map<Pair<NavigationStep, RefObjectImpl>, Set<RefObjectImpl>> cache) {
	incrementNavigateCounter(conn, from);
	
	Set<RefObjectImpl> result = new HashSet<RefObjectImpl>();
	if (isAbsolute()) {
	    from = Collections.singleton(null);
	}
	if (!isAlwaysEmpty()) { // don't do anything for empty steps
	    for (RefObjectImpl fromObject : from) {
		// for absolute steps, don't do the source type check and invoke just once, passing null for "from"
		if (isAbsolute() || AbstractTracer.doesTypeMatch(conn, getSourceType(), fromObject)) {
		    for (RefObjectImpl singleResult : getFromCacheOrNavigate(conn, fromObject, cache)) {
			if (AbstractTracer.doesTypeMatch(conn, getTargetType(), singleResult)) {
			    result.add(singleResult);
			}
		    }
		}
	    }
	}
	resultObjectsCounter += result.size();
	return result;
    }
    
    private Collection<RefObjectImpl> getFromCacheOrNavigate(CoreConnection conn, RefObjectImpl fromObject,
	    Map<Pair<NavigationStep, RefObjectImpl>, Set<RefObjectImpl>> cache) {
	Set<RefObjectImpl> result;
	Pair<NavigationStep, RefObjectImpl> cacheKey = new Pair<NavigationStep, RefObjectImpl>(this, fromObject);
	result = cache.get(cacheKey);
	if (result == null) {
	    cacheMisses++;
	    result = navigate(conn, fromObject, cache); 
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
    
    protected abstract Set<RefObjectImpl> navigate(CoreConnection conn, RefObjectImpl fromObject,
	    Map<Pair<NavigationStep, RefObjectImpl>, Set<RefObjectImpl>> cache);

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
    
}
