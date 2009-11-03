package com.sap.river.interpreter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import behavioral.actions.Block;

import com.sap.river.interpreter.objects.ClassTypedObject;
import com.sap.river.interpreter.objects.RiverObject;
import com.sap.river.interpreter.signatureimplementations.BlockInterpreter;

import data.classes.NamedValue;
import data.classes.Signature;

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
public class StackFrame {
    private StackFrame scopeParent;
    private Map<String, RiverObject> variableValues;
    
    /**
     * In debug mode, the {@link DebugSession} will maintain the "instruction pointer" which is the
     * model element currently being evaluated
     */
    private RefObject currentlyEvaluating;
    
    /**
     * In debug mode, holds the signature whose implementation is currently being executed.
     */
    private Signature currentlyExecutingImplementationOf;
    
    /**
     * The <tt>this</tt> pointer of the stack frame in element 0; the array is <tt>null</tt>
     * if this frame is not for a method call but, e.g., a function call, or if this frame is for a nested
     * block. This is different from a valid array holding the value <tt>null</tt> in element 0
     * which encodes <tt>this==null</tt>.
     */
    private ClassTypedObject[] thiz;
    
    /**
     * Creates a new stack frame for a method or function invocation with no parent stack
     * for name resolution.
     */
    public StackFrame() {
	variableValues = new HashMap<String, RiverObject>();
    }
    
    /**
     * Create a stack frame that has <tt>parent</tt> as its parent stack frame. This constructor
     * is expected to be used when a nested block inside a method or function execution begins
     * to execute.
     */
    public StackFrame(StackFrame parent) {
	this();
	this.scopeParent = parent;
    }
    
    public StackFrame clone() {
	StackFrame result = new StackFrame();
	result.scopeParent = getScopeParent();
	result.variableValues = getVariableValues();
	if (getThis() != null) {
	    result.thiz = new ClassTypedObject[] { getThis() };
	}
	return result;
    }
    
    protected void setCurrentlyEvaluating(RefObject element) {
	currentlyEvaluating = element;
    }
    
    public RefObject getCurrentlyEvaluating() {
	return currentlyEvaluating;
    }
    
    /**
     * Tries to locate the variable in this and the connected scope parent frames. If the entry is found,
     * it is updated by the <tt>value</tt> provided. Otherwise, the variable is added to this frame and
     * set to <tt>value</tt>.
     */
    public void setValue(NamedValue variable, RiverObject value) {
	if (variable == null) {
	    throw new RuntimeException("Cannot create unnamed variable on StackFrame");
	}
	if (value == null) {
	    throw new RuntimeException("Cannot create variable with value <null> on StackFrame");
	}
	StackFrame container = this;
	while (container != null && !container.getVariableValues().containsKey(variable.getName())) {
	    container = container.getScopeParent();
	}
	if (container == null) {
	    // not found in this or parent frames; add to this frame
	    getVariableValues().put(variable.getName(), value);
	} else {
	    container.getVariableValues().put(variable.getName(), value);
	}
    }
    
    /**
     * Stores the variable into this particular frame. This will hide any definitions under the same
     * key in any parent frame. If a definition by that key is already known by this very frame
     * (not ascending to parent frames), an exception will be thrown.
     */
    public void enterValue(NamedValue variable, RiverObject value) {
	if (variable == null) {
	    throw new RuntimeException("Cannot create unnamed variable on StackFrame");
	}
	if (value == null) {
	    throw new RuntimeException("Cannot create variable with value <null> on StackFrame");
	}
	if (getVariableValues().containsKey(variable.getName())) {
	    throw new RuntimeException("Cannot enter the same variable twice into the same StackFrame");
	}
	getVariableValues().put(variable.getName(), value);
    }
    
    /**
     * Retrieves the value for <tt>variable</tt> from this stack frame. If the variable
     * is not in scope in the current frame, the parent frame stack is checked one after the
     * other until a value is found or the end of the stack has been reached. In that case,
     * a {@link RuntimeException} is thrown because the value is undefined.
     */
    public RiverObject getValue(NamedValue variable) {
	RiverObject result;
	if (variable != null && getVariableValues().containsKey(variable.getName())) {
	    result = getVariableValues().get(variable.getName());
	} else {
	    if (variable != null && getScopeParent() != null) {
		result = getScopeParent().getValue(variable);
	    } else {
		throw new RuntimeException("No value defined for "+((variable==null)?"<null> variable":variable.getName()));
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
    public Map<String, RiverObject> getAllVisibleVariableValues() {
	Map<String, RiverObject> result = new LinkedHashMap<String, RiverObject>();
	if (hasThis()) {
	    result.put("this", getThis());
	}
	result.putAll(getVariableValues());
	if (getScopeParent() != null) {
	    Map<String, RiverObject> parentScopeVariableValues = getScopeParent().getAllVisibleVariableValues();
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
    
    private Map<String, RiverObject> getVariableValues() {
        return variableValues;
    }
    
    public ClassTypedObject getThis() {
	ClassTypedObject result;
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

    public void setThis(ClassTypedObject thiz) {
        this.thiz = new ClassTypedObject[] { thiz };
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
    public StackFrame getScopeParent() {
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
    public Signature getCurrentlyExecutingImplementationOf() {
	Signature result = currentlyExecutingImplementationOf;
	if (result == null && getScopeParent() != null) {
	    result = getScopeParent().getCurrentlyExecutingImplementationOf();
	}
        return result;
    }

    public void setCurrentlyExecutingImplementationOf(Signature currentlyExecutingImplementationOf) {
        this.currentlyExecutingImplementationOf = currentlyExecutingImplementationOf;
    }
}
