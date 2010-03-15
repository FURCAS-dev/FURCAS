package com.sap.tc.moin.ocl.ia.instancescope;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.omg.ocl.expressions.__impl.OclExpressionInternal;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.shared.util.Tuple.Pair;

/**
 * Steps of this type can be an empty placeholder during the analysis phase and can
 * be filled in later, e.g., pointing to a real {@link NavigationStep}. All fields are
 * initialized with <tt>null</tt> by the constructor. Clients have to ensure that
 * a valid state is achieved before leaving the analysis phase and using this step.<p>
 * 
 * @author Axel Uhl D043530
 *
 */
public class IndirectingStep extends AbstractNavigationStep {
    private NavigationStep actualStep;
    private boolean equalsOrHashCodeCalledBeforeActualStepSet = false;

    /**
     * The set of objects for which {@link #navigate(CoreConnection, RefObjectImpl, Map)} is currently being evaluated on
     * this step instance, keyed by the current thread by means of using a {@link ThreadLocal}. This is used to avoid
     * endless recursions. Navigating the same thing again starting from the same object wouldn't contribute new things.
     * So in that case, an empty set will be returned.
     */
    private ThreadLocal<Set<RefObjectImpl>> currentlyEvaluatingNavigateFor = new ThreadLocal<Set<RefObjectImpl>>() {
	@Override
	protected Set<RefObjectImpl> initialValue() {
	    return new HashSet<RefObjectImpl>();
	}
    };

    public IndirectingStep(OclExpressionInternal debugInfo) {
	super(null, null, debugInfo);
    }
    
    public boolean equals(Object o) {
	boolean result;
	if (actualStep == null || equalsOrHashCodeCalledBeforeActualStepSet) {
	    equalsOrHashCodeCalledBeforeActualStepSet = true;
	    result = this.equals(o);
	} else {
	    Object toCompareWith = o;
	    if (o instanceof IndirectingStep) {
		toCompareWith = ((IndirectingStep) o).getActualStep();
	    }
	    result = actualStep.equals(toCompareWith);
	}
	return result;
    }
    
    public int hashCode() {
	int result;
	if (actualStep == null || equalsOrHashCodeCalledBeforeActualStepSet) {
	    equalsOrHashCodeCalledBeforeActualStepSet = true;
	    result = super.hashCode();
	} else {
	    result = actualStep.hashCode();
	}
	return result;
    }
    
    public void setActualStep(NavigationStep actualStep) {
	if (this.actualStep != null) {
	   throw new RuntimeException("Internal error: can't set an IndirectingStep's actual step twice");
	}
	this.actualStep = actualStep;
	setSourceType(actualStep.getSourceType());
	setTargetType(actualStep.getTargetType());
	if (this.actualStep.isAlwaysEmpty()) {
	    setAlwaysEmpty();
	} else {
	    this.actualStep.addAlwaysEmptyChangeListener(new AlwaysEmptyChangeListener() {
		@Override
		public void alwaysEmptyChanged(NavigationStep stepForWhichAlwaysEmptyChanged) {
		    assert stepForWhichAlwaysEmptyChanged == IndirectingStep.this.actualStep;
		    setAlwaysEmpty();
		}
	    });
	}
    }
    
    public NavigationStep getActualStep() {
        return actualStep;
    }

    @Override
    protected Set<AnnotatedRefObjectImpl> navigate(CoreConnection conn, AnnotatedRefObjectImpl fromObject, Map<Pair<NavigationStep, RefObjectImpl>, Set<AnnotatedRefObjectImpl>> cache) {
	Set<AnnotatedRefObjectImpl> result;
	if (currentlyEvaluatingNavigateFor.get().contains(fromObject.getElement()) || isAlwaysEmpty()) {
	    result = Collections.emptySet();
	} else {
	    currentlyEvaluatingNavigateFor.get().add(fromObject.getElement());
	    Set<AnnotatedRefObjectImpl> set = Collections.singleton(fromObject);
	    result = actualStep.navigate(conn, set, cache);
	    currentlyEvaluatingNavigateFor.get().remove(fromObject.getElement());
	}
	return result;
    }
    
    /** 
     * Overrides incrementNavigateCounter to suppress counting of additional navigate() call in case of a recursion 
     */
    @Override
    protected void incrementNavigateCounter(CoreConnection conn, Set<AnnotatedRefObjectImpl> from) {
	boolean oneFromObjectIsEvaluating = false;
	
	for(AnnotatedRefObjectImpl obj : from){
	    if( currentlyEvaluatingNavigateFor.get().contains(obj.getElement()) ){
		oneFromObjectIsEvaluating = true;
		return;
	    }
	}
	
	if(!oneFromObjectIsEvaluating){
            super.incrementNavigateCounter(conn, from);
        }
    }
    
    @Override
    public boolean isAbsolute() {
	boolean result;
	if (actualStep == null) {
	    result = false; // don't know yet
	} else {
	    result = actualStep.isAbsolute();
	}
	return result;
    }
    
    @Override
    protected String contentToString(Map<NavigationStep, Integer> visited, int indent) {
	return "(i)"
		+ ((actualStep != null) ? ((actualStep instanceof AbstractNavigationStep ? ((AbstractNavigationStep) actualStep)
			.contentToString(visited, indent) : actualStep.toString())) : "null");
    }
    
    /**
     * An indirecting step  <tt>1</tt>.
     */
    @Override
    protected int size(Set<NavigationStep> visited) {
	if (visited.contains(this)) {
	    return 0;
	} else {
	    return ((AbstractNavigationStep) actualStep).size(visited);
	}
    }
}
