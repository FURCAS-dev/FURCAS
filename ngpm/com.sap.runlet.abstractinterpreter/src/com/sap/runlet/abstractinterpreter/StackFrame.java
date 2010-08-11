package com.sap.runlet.abstractinterpreter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.omg.CORBA.NamedValue;

import com.sap.furcas.metamodel.TCS.Block;
import com.sap.runlet.abstractinterpreter.objects.ClassTypedObject;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;

/**
 * Holds one frame of a call stack of an execution thread corresponding to a {@link Block}
 * execution. This stack contains all variables that are declared in the block and are
 * already in scope (variables are in scope only after their declaration in the block).<p>
 * 
 * Stack frames that represent executions of nested blocks (such as that of a loop
 * or an if/else statement) know their parent frame which is then also used to
 * resolve variables that are not in scope for the current innermost block. The
 * outermost block's frame that corresponds to a method or function invocation does
 * not have a parent as no named value from outside such a scope is mapped into the
 * method's or function's scope.<p>
 * 
 * The {@link BlockInterpreter} works in lock-step with this class to announce
 * block entries and exits.<p>
 * 
 * TODO give stack frames names; creators then can specify them, e.g., when invoking something or creating a thread
 * 
 * @author Axel Uhl (D043530)
 *
 */
public class StackFrame<LinkEndMetaObject, TypeUsage, ClassUsage extends TypeUsage, SignatureImplementationType> {
    private StackFrame<LinkEndMetaObject, TypeUsage, ClassUsage, SignatureImplementationType> scopeParent;
    private Map<String, RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>> variableValues;
    
    /**
     * In debug mode, holds the signature whose implementation is currently being executed.
     */
    private SignatureImplementationType currentlyExecutingImplementationOf;
    
    /**
     * In debug mode, the {@link DebugSession} will maintain the "instruction pointer" which is the
     * model element currently being evaluated
     */
    private EObject currentlyEvaluating;
    
    /**
     * The <tt>this</tt> pointer of the stack frame in element 0; the array is <tt>null</tt>
     * if this frame is not for a method call but, e.g., a function call, or if this frame is for a nested
     * block. This is different from a valid array holding the value <tt>null</tt> in element 0
     * which encodes <tt>this==null</tt>.
     */
    private ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>[] thiz;
    
    /**
     * Creates a new stack frame for a method or function invocation with no parent stack
     * for name resolution.
     */
    public StackFrame() {
	variableValues = new HashMap<String, RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>>();
    }
    
    /**
     * Create a stack frame that has <tt>parent</tt> as its parent stack frame. This constructor
     * is expected to be used when a nested block inside a method or function execution begins
     * to execute.
     */
    public StackFrame(StackFrame<LinkEndMetaObject, TypeUsage, ClassUsage, SignatureImplementationType> parent) {
	this();
	this.scopeParent = parent;
    }
    
    @SuppressWarnings("unchecked")
    public StackFrame<LinkEndMetaObject, TypeUsage, ClassUsage, SignatureImplementationType> clone() {
	StackFrame<LinkEndMetaObject, TypeUsage, ClassUsage, SignatureImplementationType> result = new StackFrame<LinkEndMetaObject, TypeUsage, ClassUsage, SignatureImplementationType>();
	result.scopeParent = getScopeParent();
	result.variableValues = getVariableValues();
	if (getThis() != null) {
	    result.thiz = (ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>[]) new ClassTypedObject<?, ?, ?>[] { getThis() };
	}
	return result;
    }
    
    public void setCurrentlyEvaluating(EObject element) {
	currentlyEvaluating = element;
    }
    
    public EObject getCurrentlyEvaluating() {
	return currentlyEvaluating;
    }
    
    /**
     * Tries to locate the variable in this and the connected scope parent frames. If the entry is found,
     * it is updated by the <tt>value</tt> provided. Otherwise, the variable is added to this frame and
     * set to <tt>value</tt>.
     */
    public void setValue(String variableName, RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> value) {
	if (variableName == null) {
	    throw new RuntimeException("Cannot create unnamed variable on StackFrame");
	}
	if (value == null) {
	    throw new RuntimeException("Cannot create variable with value <null> on StackFrame");
	}
	StackFrame<LinkEndMetaObject, TypeUsage, ClassUsage, SignatureImplementationType> container = this;
	while (container != null && !container.getVariableValues().containsKey(variableName)) {
	    container = container.getScopeParent();
	}
	if (container == null) {
	    // not found in this or parent frames; add to this frame
	    getVariableValues().put(variableName, value);
	} else {
	    container.getVariableValues().put(variableName, value);
	}
    }
    
    /**
     * Stores the variable into this particular frame. This will hide any definitions under the same
     * key in any parent frame. If a definition by that key is already known by this very frame
     * (not ascending to parent frames), an exception will be thrown.
     */
    public void enterValue(String variableName, RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> value) {
	if (variableName == null) {
	    throw new RuntimeException("Cannot create unnamed variable on StackFrame");
	}
	if (value == null) {
	    throw new RuntimeException("Cannot create variable with value <null> on StackFrame");
	}
	if (getVariableValues().containsKey(variableName)) {
	    throw new RuntimeException("Cannot enter the same variable twice into the same StackFrame");
	}
	setOrEnterValue(variableName, value);
    }
    
    /**
     * Stores the variable into this particular frame. This will hide any definitions under the same
     * key in any parent frame. If a definition by that key is already known by this very frame
     * (not ascending to parent frames), its value will be overwritten and no exception will be thrown
     * (as opposed to the behavior of {@link #enterValue}, which would throw an exception in this case).
     */
    public void setOrEnterValue(String variableName, RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> value) {
	if (variableName == null) {
	    throw new RuntimeException("Cannot create unnamed variable on StackFrame");
	}
	if (value == null) {
	    throw new RuntimeException("Cannot create variable with value <null> on StackFrame");
	}
	getVariableValues().put(variableName, value);
    }
    
    /**
     * Retrieves the value for <tt>variable</tt> from this stack frame. If the variable
     * is not in scope in the current frame, the parent frame stack is checked one after the
     * other until a value is found or the end of the stack has been reached. In that case,
     * a {@link RuntimeException} is thrown because the value is undefined.
     */
    public RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> getValue(String variableName) {
	RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> result;
	if (variableName != null && getVariableValues().containsKey(variableName)) {
	    result = getVariableValues().get(variableName);
	} else {
	    if (variableName != null && getScopeParent() != null) {
		result = getScopeParent().getValue(variableName);
	    } else {
		throw new RuntimeException("No value defined for "+((variableName==null)?"<null> variable":variableName));
	    }
	}
	return result;
    }
    
    /**
     * For all variables for which {@link #getValue(NamedValue)} will return a non-<tt>null</tt>
     * result, either from this frame or from one of its scope parents, adds the variable name and
     * its value to the result map. Variables from scope parents that have an equally-named definition
     * in a lower stack will not be added.
     */
    public Map<String, RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>> getAllVisibleVariableValues() {
	Map<String, RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>> result = new LinkedHashMap<String, RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>>();
	if (hasThis()) {
	    result.put("this", getThis());
	}
	result.putAll(getVariableValues());
	if (getScopeParent() != null) {
	    Map<String, RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>> parentScopeVariableValues = getScopeParent().getAllVisibleVariableValues();
	    for (String parentVariableName : parentScopeVariableValues.keySet()) {
		if (!result.containsKey(parentVariableName)) {
		    result.put(parentVariableName, parentScopeVariableValues.get(parentVariableName));
		}
	    }
	}
	return result;
    }

    /**
     * For all variables for which {@link #getValue(NamedValue)} will return a non-<tt>null</tt>
     * result, either from this frame or from one of its scope parents, adds the variable name to
     * the result. Variables from scope parents that have an equally-named definition in a lower
     * stack will not be added.
     */
    public Set<String> getAllVisibleVariableNames() {
	Set<String> result = new LinkedHashSet<String>();
	if (hasThis()) {
	    result.add("this");
	}
	result.addAll(getVariableValues().keySet());
	if (getScopeParent() != null) {
	    result.addAll(getScopeParent().getAllVisibleVariableNames());
	}
	return result;
    }
    
    private Map<String, RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>> getVariableValues() {
        return variableValues;
    }
    
    public ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> getThis() {
	ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> result;
	if (thiz == null) {
	    if (getScopeParent() != null) {
		result = getScopeParent().getThis();
	    } else {
		throw new RuntimeException("No value defined for this");
	    }
	} else {
	    result = thiz[0];
	}
        return result;
    }
    
    /**
     * Checks if a <tt>this</tt> value is defined for this frame, including looking at this frame's
     * scope parents.
     */
    private boolean hasThis() {
	boolean result = false;
	if (thiz == null) {
	    if (getScopeParent() != null) {
		result = getScopeParent().hasThis();
	    }
	} else {
	    result = true;
	}
        return result;
    }

    @SuppressWarnings("unchecked")
    public void setThis(ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> thiz) {
        this.thiz = (ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>[]) new ClassTypedObject<?, ?, ?>[] { thiz };
    }
    
    /**
     * Tells if this frame resorts to a parent frame recursively to resolve elements it does not
     * hold itself. This is used for language constructs where scopes can be nested and still see
     * elements from their enclosing scopes.
     * <p>
     * 
     * Both, this frame and the scope parent will be on the interpreter's
     * {@link RiverInterpreter#getCallstack() callstack}.
     */
    public StackFrame<LinkEndMetaObject, TypeUsage, ClassUsage, SignatureImplementationType> getScopeParent() {
        return scopeParent;
    }
    
    public String toString() {
	StringBuilder result = new StringBuilder();
	if (thiz != null) {
	    result.append("this=");
	    result.append(thiz[0]);
	    result.append('\n');
	}
	for (String variableName : variableValues.keySet()) {
	    assert variableName != null;
	    result.append(variableName);
	    result.append('=');
	    result.append(variableValues.get(variableName));
	    result.append('\n');
	}
	return result.toString();
    }
    
    public String renderAsString() {
    	StringBuilder str = new StringBuilder();
    	str.append("Frame:\n");
    	str.append(this);
    	if (scopeParent != null) {
    	    str.append("Parent:\n");
    	    str.append(getScopeParent().toString());
    	}
    	return str.toString();
    }

    /**
     * Checks if the {@link #currentlyExecutingImplementationOf} is set to a non-<tt>null</tt>
     * value here and if so, returns it. If not, checks up the {@link #scopeParent scope parent}
     * hierarchy.
     */
    public SignatureImplementationType getCurrentlyExecutingImplementation() {
	SignatureImplementationType result = currentlyExecutingImplementationOf;
	if (result == null && getScopeParent() != null) {
	    result = getScopeParent().getCurrentlyExecutingImplementation();
	}
        return result;
    }

    public void setCurrentlyExecutingImplementation(SignatureImplementationType currentlyExecutingImplementation) {
        this.currentlyExecutingImplementationOf = currentlyExecutingImplementation;
    }
}
