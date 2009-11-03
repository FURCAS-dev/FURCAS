package com.sap.river.interpreter.objects;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

import com.sap.river.interpreter.RiverInterpreter;

import data.classes.ClassTypeDefinition;
import data.classes.FunctionSignatureTypeDefinition;
import data.classes.Parameter;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;

/**
 * Represents an object that is a callable function. Its {@link #getType() type} therefore is a
 * {@link FunctionSignatureTypeDefinition}. The object holds a reference to the function
 * implementation.
 * 
 * @author Axel Uhl (D043530)
 */
public class FunctionFromMethodObject extends FunctionObject {
    /**
     * The object on which to call the method specified by the {@link #getType() FunctionSignatureTypeDefinition}.
     */
    private ClassTypedObject thiz;
    
    /**
     * Ensures that the <tt>type</tt> is really a {@link FunctionSignatureTypeDefinition}.
     * It is assumed that the resolution of the <tt>implementation</tt> has been performed
     * considering the definitions of polymorphic method calls, based on the runtime type of
     * <tt>thiz</tt>.
     */
    public FunctionFromMethodObject(TypeDefinition type, SignatureImplementation implementation,
	    ClassTypedObject thiz) {
	super(type, implementation);
	this.thiz = thiz;
    }
    
    @Override
    public RiverObject evaluate(RiverInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException,
	    NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	// Note that the stack frame is expected to have been added particularly for the purpose
	// of this call; therefore, no other "this" pointer is overwritten by this; it is just an
	// enrichment over what a non-method function call would put on the stack frame
	interpreter.getCallstack().peek().setThis(thiz);
	addObjectParametersToStackFrame(interpreter);
        return super.evaluate(interpreter);
    }

    /**
     * If {@link #thiz}'s class has {@link ClassTypeDefinition#getObjectParameters() object parameters},
     * those will be added to the interpreter's current stack frame.
     */
    private void addObjectParametersToStackFrame(RiverInterpreter interpreter) {
	if (thiz instanceof ValueObject) {
	    ValueObject value = (ValueObject) thiz;
	    Iterator<Parameter> aop = thiz.getType().getClazz().getFormalObjectParameters().iterator();
	    for (RiverObject actualObjectParameterValue : value.getActualObjectParameters()) {
		// TODO consider using a separate StackFrame for object parameters so that method parameters can hide them
		interpreter.getCallstack().peek().enterValue(aop.next(), actualObjectParameterValue);
	    }
	}
    }
    
}
