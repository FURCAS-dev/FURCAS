package com.sap.runlet.interpreter;

import behavioral.actions.Block;

import com.sap.runlet.abstractinterpreter.StackFrame;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.interpreter.signatureimplementations.BlockInterpreter;

import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.NamedValue;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;

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
public class RunletStackFrame
extends StackFrame<AssociationEnd, TypeDefinition, ClassTypeDefinition, SignatureImplementation> {
    /**
     * Creates a new stack frame for a method or function invocation with no parent stack
     * for name resolution.
     */
    public RunletStackFrame() {
	super();
    }
    
    /**
     * Create a stack frame that has <tt>parent</tt> as its parent stack frame. This constructor
     * is expected to be used when a nested block inside a method or function execution begins
     * to execute.
     */
    public RunletStackFrame(RunletStackFrame parent) {
	super(parent);
    }
    
    /**
     * Stores the variable into this particular frame. This will hide any definitions under the same
     * key in any parent frame. If a definition by that key is already known by this very frame
     * (not ascending to parent frames), an exception will be thrown.
     */
    public void enterValue(NamedValue variable, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> value) {
	if (variable == null) {
	    throw new RuntimeException("Cannot create unnamed variable on StackFrame");
	}
	enterValue(variable.getName(), value);
    }
    
    /**
     * Retrieves the value for <tt>variable</tt> from this stack frame. If the variable
     * is not in scope in the current frame, the parent frame stack is checked one after the
     * other until a value is found or the end of the stack has been reached. In that case,
     * a {@link RuntimeException} is thrown because the value is undefined.
     */
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> getValue(NamedValue variable) {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> result;
	if (variable == null) {
	    throw new RuntimeException("No value defined for <null> variable");
	} else {
	    result = getValue(variable.getName());
	}
	return result;
    }
    
    /**
     * Tries to locate the variable in this and the connected scope parent frames. If the entry is found,
     * it is updated by the <tt>value</tt> provided. Otherwise, the variable is added to this frame and
     * set to <tt>value</tt>.
     */
    public void setValue(NamedValue variable, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> value) {
	if (variable == null) {
	    throw new RuntimeException("Cannot create unnamed variable on StackFrame");
	}
	setValue(variable.getName(), value);
    }
    
    @Override
    public RunletStackFrame getScopeParent() {
	return (RunletStackFrame) super.getScopeParent();
    }
    
}
