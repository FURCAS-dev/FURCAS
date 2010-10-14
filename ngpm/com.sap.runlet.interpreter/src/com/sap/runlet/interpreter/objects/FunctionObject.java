package com.sap.runlet.interpreter.objects;

import java.lang.reflect.InvocationTargetException;

import com.sap.ap.metamodel.utils.StringFormatter;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.statements.ReturnInterpreter;

import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.FunctionSignatureTypeDefinition;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;

/**
 * Represents an (possibly multi-)object that is a callable function. Its {@link #getType() type}
 * therefore is a {@link FunctionSignatureTypeDefinition}. The object holds a reference to the
 * function implementation.
 * <p>
 * 
 * Calling multiple functions in a single expression (in case this represents a multi-valued object)
 * means that the results are multi-valued and perhaps nested where the nesting structure
 * corresponds with the structure of this multi-object, and the innermost parts of the nesting are
 * the actual results returned by each function call.
 * <p>
 * 
 * For example, assume there are two functions both of type <tt>Number->Number</tt>:
 * 
 * <pre>
 * 	f1 = { Number i -&gt; Number | i+1 }
 * 	f2 = { Number i -&gt; Number | i*i }
 * </pre>
 * 
 * Then we can join them into a multi-object of type <tt>Number->Number[*]</tt> like this:
 * 
 * <pre>
 * 	multipleFs = [f1, f2]
 * </pre>
 * 
 * This expression can still be "invoked", e.g., like this:
 * 
 * <pre>
 * results = multipleFs(5)
 * </pre>
 * 
 * yielding <tt>[6, 25]</tt>. Let's look at another example where the functions are of type
 * <tt>Number->Number[*]</tt>, defined like this:
 * 
 * <pre>
 * 	f1 = { Number i -&gt; Number[*] | [i+1, i+2] }
 * 	f2 = { Number i -&gt; Number[*] | [i*i, i*i*i] }
 * </pre>
 * 
 * Then we can join them into a multi-object of type <tt>Number->Number[*])[*]</tt> like this:
 * 
 * <pre>
 * 	multipleFs = [f1, f2]
 * </pre>
 * 
 * This expression can still be "invoked", e.g., like this:
 * 
 * <pre>
 * results = multipleFs(5)
 * </pre>
 * 
 * yielding <tt>[[6, 7], [25, 125]]</tt>.
 * 
 * @author Axel Uhl (D043530)
 */
public class FunctionObject extends RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> {
    private SignatureImplementation implementation;

    /**
     * ensures that the <tt>type</tt> is really a {@link FunctionSignatureTypeDefinition}
     */
    public FunctionObject(TypeDefinition type, SignatureImplementation implementation) {
	super(type);
	this.implementation = implementation;
    }
    
    public SignatureImplementation getImplementation() {
        return implementation;
    }
    
    /**
     * Assumes the arguments have already been put on a new stack frame which has already been
     * pushed to the interpreter's call stack. Computes the result of executing the function
     * implementation. If the implementation returns a non-<tt>null</tt> object that is not a
     * {@link ReturnInterpreter.ReturnResult}, it was an "inofficial" last computed value during
     * executing the implementation which will not be returned; <tt>null</tt> will be returned
     * instead. If the implementation returns a {@link ReturnInterpreter.ReturnResult}, the object
     * wrapped within represents the real return value of the implementation. The inner object which
     * represents the actual return value will be unwrapped and returned from this method.
     * <p>
     * 
     * The stack frame is left on the stack. It's the caller's obligation to remove the stack again that
     * previously was added by the caller. This should give "symmetric" behavior.<p>
     * 
     * The result undergoes implicit object-parameterized type conversion. See
     * {@link RunletInterpreter#convert(ValueObject, data.classes.ClassTypeDefinition)}.
     */
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(RunletInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException,
	    NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> result;
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> unconvertedResult = interpreter.evaluateSignatureImplementation(getImplementation());
        if (unconvertedResult instanceof ReturnInterpreter.ReturnResult) {
            // the explicit return value for the signature; unwrap and return
            unconvertedResult = ((ReturnInterpreter.ReturnResult) unconvertedResult).getResult();
            result = interpreter.convert(unconvertedResult, implementation.getImplementedSignature().getOutput());
        } else {
            result = null;
        }
	return result;
    }
    
    @Override
    public String toString() {
	return "function "+StringFormatter.toString(getImplementation().getImplementedSignature());
    }
    
}
