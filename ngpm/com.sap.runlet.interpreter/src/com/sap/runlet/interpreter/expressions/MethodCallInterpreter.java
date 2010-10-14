package com.sap.runlet.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sap.ap.metamodel.utils.StringFormatter;
import com.sap.runlet.abstractinterpreter.StackFrame;
import com.sap.runlet.abstractinterpreter.objects.ClassTypedObject;
import com.sap.runlet.abstractinterpreter.objects.EmptyObject;
import com.sap.runlet.abstractinterpreter.objects.MultiValuedObject;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.objects.FunctionFromMethodObject;

import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.FunctionSignatureTypeDefinition;
import data.classes.MethodSignature;
import data.classes.SapClass;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;
import dataaccess.expressions.MethodCallExpression;

public class MethodCallInterpreter extends SignatureCallInterpreter {
    public MethodCallInterpreter(MethodCallExpression mce) {
	super(mce);
    }
    
    protected MethodCallExpression getSignatureCallExpression() {
	return (MethodCallExpression) sce;
    }

    /**
     * This implementation computes and adds the <tt>this</tt> value to the stack frame
     */
    protected RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> completeStackFrameAndExecute(final RunletInterpreter interpreter,
	    final List<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> parameterValues) throws NoSuchMethodException,
	    InstantiationException, IllegalAccessException,
	    InvocationTargetException {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> result;
	// The cast to ClassTypedObject is okay because of constraint MethodCallExpression.ObjectMustSupportOperation
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> on = getOnObject(interpreter);
	if (on == null) {
	    // TODO clarify exception handling semantics in River
	    // TODO clarify: should invoking on null for 0..x cause an exception at all or just do nothing?
	    throw new NullPointerException("trying to invoke method "+
		    StringFormatter.toString(getSignatureCallExpression().getSignature()));
	}
	// multi-valued can't be recognized from the expression's multiplicity; it could itself have
	// resulted from a multi-valued this invocation, leading to multiple individual results combined
	// into one multi-valued object; do an ugly "instanceof" instead:
	boolean isMultipleThis = on instanceof MultiValuedObject<?, ?, ?>;
	if (isMultipleThis) {
	    // create result collection and wrap with MultiValuedObject
	    final List<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> resultCollection = new ArrayList<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>();
	    int i = 0;
	    Set<Thread> threadsToWaitFor = new HashSet<Thread>();
	    // FIXME (bug #2173) on.flatten() contradicts the way the return type definition is computed; collect one by one recursively
	    for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> thizz : on.flatten()) {
		final FunctionFromMethodObject evaluator = getEvaluator(interpreter,
			(ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>) thizz);
		if (evaluator.getImplementation().getImplements_().isSideEffectFree()) {
		    final int j = i;
		    resultCollection.add(null); // ensure that the list holds j+1 elements
		    // background execution
		    Thread t = new Thread() {
			public void run() {
			    try {
				resultCollection.set(j, exec(interpreter.spawn(), parameterValues, evaluator));
			    } catch (Throwable e) {
				e.printStackTrace();
				resultCollection.set(j, new ExceptionObject(interpreter, e, interpreter.getDefaultSnapshot()));
			    }
			}
		    };
		    t.start();
		    threadsToWaitFor.add(t);
		} else {
		    resultCollection.add(exec(interpreter, parameterValues, evaluator));
		}
		i++;
	    }
	    for (Thread t:threadsToWaitFor) {
		try {
		    t.join();
		} catch (InterruptedException e) {
		    throw new RuntimeException(e);
		}
	    }
	    // TODO if a signature has a null output/return type, shouldn't we be creating an EmptyObject instead?
	    TypeDefinition outputType = getSignatureCallExpression().getSignature().getOutput();
	    if (outputType == null) {
		result = new EmptyObject<AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition>(
			getSignatureCallExpression().getSignature().getOutput(), interpreter.getModelAdapter());
	    } else {
		result = new MultiValuedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>(outputType, resultCollection,
			outputType.isOrdered(), outputType.isUnique());
	    }
	} else {
	    if (on instanceof EmptyObject<?, ?, ?, ?>) {
		result = new EmptyObject<AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition>(
			getSignatureCallExpression().getSignature().getOutput(), interpreter.getModelAdapter());
	    }
	    else {
		result = exec(interpreter, parameterValues, getEvaluator(interpreter,
			(ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>) on));
	    }
	}
	return result;
    }

    /**
     * Determines the object on which to invoke the method. This implementation uses the
     * {@link MethodCallExpression#getObject()} expression for this purpose.
     */
    protected RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> getOnObject(final RunletInterpreter interpreter) throws NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	return interpreter.evaluate(getSignatureCallExpression().getObject());
    }

    /**
     * Polymorphically resolves the method to call, based on the object currently
     * listed as the {@link StackFrame#getThis() this} pointer of the current stack
     * frame.<p>
     * 
     * @return a {@link FunctionFromMethodObject} whose type attribute is not filled but
     * left as <tt>null</tt>. Otherwise, this method would have to create a new
     * {@link FunctionSignatureTypeDefinition} which is really undesirable here. The
     * dedicated use of the {@link FunctionMethodFromObject} just for passing the
     * implementation to call and the this pointer back to the call by {@link #exec}
     * seem to justify this.
     */
    private FunctionFromMethodObject getEvaluator(RunletInterpreter interpreter, ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> thiz)
	    throws SecurityException, IllegalArgumentException {
	SignatureImplementation impl = interpreter.resolveMethodCallToImplementation(
		(MethodSignature) getSignatureCallExpression().getSignature(),
		thiz);
	FunctionFromMethodObject result = new FunctionFromMethodObject(/*type*/null, impl, thiz);
	return result;
    }

}
