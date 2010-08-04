package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;

/**
 * Steps of this type can be an empty placeholder during the analysis phase and can
 * be filled in later, e.g., pointing to a real {@link NavigationStep}. All fields are
 * initialized with <tt>null</tt> by the constructor. Clients have to ensure that
 * a valid state is achieved before leaving the analysis phase and using this step.<p>
 *
 */
public class IndirectingStep extends AbstractNavigationStep {
    private NavigationStep actualStep;
    private boolean equalsOrHashCodeCalledBeforeActualStepSet = false;

    /**
     * The set of objects for which {@link #navigate(Set, Map, Notification)} is currently being evaluated on
     * this step instance, keyed by the current thread by means of using a {@link ThreadLocal}. This is used to avoid
     * endless recursions. Navigating the same thing again starting from the same object wouldn't contribute new things.
     * So in that case, an empty set will be returned.
     */
    private ThreadLocal<Set<EObject>> currentlyEvaluatingNavigateFor = new ThreadLocal<Set<EObject>>() {
	@Override
	protected Set<EObject> initialValue() {
	    return new HashSet<EObject>();
	}
    };

    public IndirectingStep(OCLExpression expr) {
	super(null, null, expr);
    }
    
    public boolean equals(Object o) {
	boolean result;
	if (actualStep == null || equalsOrHashCodeCalledBeforeActualStepSet) {
	    equalsOrHashCodeCalledBeforeActualStepSet = true;
	    result = super.equals(o);
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
        if (actualStep.getSourceType() == null) {
            actualStep.addSourceTypeChangeListener(new SourceTypeChangeListener() {
                @Override
                public void sourceTypeChanged(NavigationStep stepForWhichSourceTypeChanged) {
                    setSourceType(stepForWhichSourceTypeChanged.getSourceType());
                }
            });
        } else {
            setSourceType(actualStep.getSourceType());
        }
        if (actualStep.getTargetType() == null) {
            actualStep.addTargetTypeChangeListener(new TargetTypeChangeListener() {
                @Override
                public void targetTypeChanged(NavigationStep stepForWhichTargetTypeChanged) {
                    setTargetType(stepForWhichTargetTypeChanged.getTargetType());
                }
            });
        } else {
            setTargetType(actualStep.getTargetType());
        }
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
    protected Set<AnnotatedEObject> navigate(AnnotatedEObject fromObject, Map<List<Object>, Set<AnnotatedEObject>> cache, Notification changeEvent) {
	Set<AnnotatedEObject> result;
	if (currentlyEvaluatingNavigateFor.get().contains(fromObject) || isAlwaysEmpty()) {
	    result = Collections.emptySet();
	} else {
	    currentlyEvaluatingNavigateFor.get().add(fromObject);
	    Set<AnnotatedEObject> set = Collections.singleton(fromObject);
	    result = actualStep.navigate(set, cache, changeEvent);
	    currentlyEvaluatingNavigateFor.get().remove(fromObject);
	}
	return result;
    }
    
    /** 
     * Overrides incrementNavigateCounter to suppress counting of additional navigate() call in case of a recursion 
     */
    @Override
    protected void incrementNavigateCounter(Set<AnnotatedEObject> from) {
	boolean oneFromObjectIsEvaluating = false;
	
	for(EObject obj : from){
	    if( currentlyEvaluatingNavigateFor.get().contains(obj) ){
		oneFromObjectIsEvaluating = true;
		return;
	    }
	}
	
	if(!oneFromObjectIsEvaluating){
            super.incrementNavigateCounter(from);
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
    public String contentToString(Map<NavigationStep, Integer> visited, int indent) {
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
