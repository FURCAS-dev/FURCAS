package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.SemanticIdentity;

/**
 * Steps of this type can be an empty placeholder during the analysis phase and can
 * be filled in later, e.g., pointing to a real {@link NavigationStep}. All fields are
 * initialized with <tt>null</tt> by the constructor. Clients have to ensure that
 * a valid state is achieved before leaving the analysis phase and using this step.<p>
 *
 * An indirecting step listens for changes of its actual step's hash code. See
 * {@link HashCodeChangeListener}. Changes to the actual step's hash code are forwarded to this
 * step's hash code change listeners.
 */
public class IndirectingStep extends AbstractNavigationStep implements HashCodeChangeListener{
    private NavigationStep actualStep;
    private int hashCode;
    private final boolean currentlyEvaluatingHashCode = false;
    private int maxTokenSeen = -1;
    private final List<Object> currentlyEvaluatingEqualsForParameters = new ArrayList<Object>();
    private final SemanticIdentity semanticIdentity;

    private static class IndirectingStepThreadLocal extends ThreadLocal<Set<EObject>> {
        @Override
        protected Set<EObject> initialValue() {
            return new HashSet<EObject>();
        }
    }
    
    /**
     * The set of objects for which {@link #navigate(Set, Map, Notification)} is currently being evaluated on
     * this step instance, keyed by the current thread by means of using a {@link ThreadLocal}. This is used to avoid
     * endless recursions. Navigating the same thing again starting from the same object wouldn't contribute new things.
     * So in that case, an empty set will be returned.
     */
    private final ThreadLocal<Set<EObject>> currentlyEvaluatingNavigateFor = new IndirectingStepThreadLocal();

    public IndirectingStep(OCLExpression expr) {
	super(null, null, expr);

	semanticIdentity = new IndirectingStepSemanticIdentity();
    }

    public class IndirectingStepSemanticIdentity extends SemanticIdentity{
    @Override
    public synchronized boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || hashCode() != o.hashCode()) {
            return false;
        }
	for (int i=currentlyEvaluatingEqualsForParameters.size()-1; i>=0; i--) {
	    if (currentlyEvaluatingEqualsForParameters.get(i) == o) {
                return true;
	    }
        }
        boolean result;
        currentlyEvaluatingEqualsForParameters.add(o);
        if (actualStep == null) {
            result = false; // not identical; could be set to something different later
        } else {
            if (o instanceof IndirectingStep) {
                result = actualStep.equals(((IndirectingStep) o).getActualStep());
            } else {
                result = false;
            }
        }
        currentlyEvaluatingEqualsForParameters.remove(currentlyEvaluatingEqualsForParameters.size()-1);
	return result;
    }

    @Override
    protected synchronized int calculateHashCode() {
	int result;
	if (currentlyEvaluatingHashCode) {
	    result = 0;
        } else {
        if (actualStep == null) {
            result = getStep().hashCode();
        } else {
            result = hashCode;
        }
        }

	return result;
    }

    @Override
    public NavigationStep getStep() {
	return IndirectingStep.this;
    }
    }

    @SuppressWarnings("unused")
    private SemanticIdentity getSemanticIdentityOfSuper(){
	return super.getSemanticIdentity();
    }

    public void setActualStep(NavigationStep actualStep) {
	if (this.actualStep != null) {
	   throw new RuntimeException("Internal error: can't set an IndirectingStep's actual step twice");
	}
	fireBeforeHashCodeChange(newTokenForFiringHashCodeChangeEvent());
	this.actualStep = actualStep;
	hashCode = actualStep.getSemanticIdentity().hashCode();
	fireAfterHashCodeChange(newTokenForFiringHashCodeChangeEvent());
	actualStep.addHashCodeChangeListener(this);
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
	    visited.add(this);

	    if(((AbstractNavigationStep) actualStep) != null){
		return 1+((AbstractNavigationStep) actualStep).size(visited);
	    }else{
		return 0;
	    }
	}
    }

    @Override
    public synchronized void beforeHashCodeChange(NavigationStep step, int token) {
        if (token > maxTokenSeen) {
            maxTokenSeen = token;
            fireBeforeHashCodeChange(token);
        }
    }

    @Override
    public synchronized void afterHashCodeChange(NavigationStep step, int token) {
        if (token > maxTokenSeen) {
            maxTokenSeen = token;
            hashCode = step.getSemanticIdentity().hashCode();
            fireAfterHashCodeChange(token);
        }
    }

    @Override
    protected int distinctSize(Set<SemanticIdentity> visited) {
	if (visited.contains(this.getSemanticIdentity())) {
	    return 0;
	} else {
	    visited.add(this.getSemanticIdentity());

	    return 1+((AbstractNavigationStep) actualStep).distinctSize(visited);
	}
    }


    @Override
    public SemanticIdentity getSemanticIdentity() {
	return semanticIdentity;
    }
}
