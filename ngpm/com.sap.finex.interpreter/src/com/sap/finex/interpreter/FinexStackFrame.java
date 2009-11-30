package com.sap.finex.interpreter;

import structure.Field;
import structure.FinexClass;
import structure.Type;
import behavior.expressions.Alias;
import behavior.expressions.Expression;
import behavior.functions.SignatureImplementation;

import com.sap.runlet.abstractinterpreter.StackFrame;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;

public class FinexStackFrame extends StackFrame<Field, Type, FinexClass, SignatureImplementation> {
    /**
     * The <tt>this</tt> pointer of the stack frame in element 0; the array is <tt>null</tt>
     * if this frame is not for a method call but, e.g., a function call, or if this frame is for a nested
     * block. This is different from a valid array holding the value <tt>null</tt> in element 0
     * which encodes <tt>this==null</tt>.
     */
    private RunletObject<Field, Type, FinexClass>[] implicitContext;
    
    /**
     * The set of alias values keyed by the expressions and their result objects for which the
     * alias value is in scope.
     */
    private AliasValues aliasValues;
    
    /**
     * Creates a new stack frame for a method or function invocation with no parent stack
     * for name resolution. The frame initializes a new, clean {@link AliasValues} map.
     */
    public FinexStackFrame() {
	super();
	aliasValues = new AliasValues();
    }
    /**
     * Create a stack frame that has <tt>parent</tt> as its parent stack frame. This constructor
     * is expected to be used when a nested block inside a method or function execution begins
     * to execute.<p>
     * 
     * The parent's alias values map is used for the new frame as well.
     */
    public FinexStackFrame(FinexStackFrame parent) {
	super(parent);
	this.aliasValues = parent.getAliasValues();
    }
    
    @Override
    public FinexStackFrame getScopeParent() {
        return (FinexStackFrame) super.getScopeParent();
    }

    public RunletObject<Field, Type, FinexClass> getImplicitContext() {
	RunletObject<Field, Type, FinexClass> result;
	if (implicitContext == null) {
	    if (getScopeParent() != null) {
		result = getScopeParent().getImplicitContext();
	    } else {
		result = null;
	    }
	} else {
	    result = implicitContext[0];
	}
        return result;
    }
    
    @SuppressWarnings("unchecked")
    public void setImplicitContext(RunletObject<Field, Type, FinexClass> implicitContext) {
        this.implicitContext = (RunletObject<Field, Type, FinexClass>[]) new RunletObject<?, ?, ?>[] {
            implicitContext };
    }

    public AliasValues getAliasValues() {
        return aliasValues;
    }
    
    /**
     * Finds all aliases from the {@link #getAliasValues() alias values map} that have been computed by
     * the evaluation of the expression <tt>e</tt> and adds the values they had for the particular
     * result object <tt>o</tt> of expression <tt>e</tt> as entries to this stack frame.
     */
    public void enterCurrentAliasValues(Expression e, RunletObject<Field, Type, FinexClass> resultOfE) {
	for (Alias a : getAliasValues().getAllAliasesDefinedFor(e, resultOfE)) {
	    setOrEnterValue(a.getName(), getAliasValues().getAliasValue(e, resultOfE, a));
	}
    }
}
