package com.sap.river.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.ClassTypedObject;
import com.sap.river.interpreter.objects.FunctionFromMethodObject;
import com.sap.river.interpreter.objects.MultiValuedObject;
import com.sap.river.interpreter.objects.RiverObject;

import data.classes.SignatureImplementation;
import dataaccess.expressions.fp.FunctionFromMethodExpr;

/**
 * The value returned from evaluating a {@link FunctionFromMethodExpr} is an instance of
 * {@link FunctionFromMethodObject}.
 * 
 * @author Axel Uhl (D043530)
 */
public class FunctionFromMethodExpressionInterpreter implements Interpreter<FunctionFromMethodExpr> {
    private FunctionFromMethodExpr ffm;
    
    public FunctionFromMethodExpressionInterpreter(FunctionFromMethodExpr ffm) {
	this.ffm = ffm;
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException,
	    NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	final Collection<FunctionFromMethodObject> resultCollection = RiverObject.createCollection(
		ffm.getType().isOrdered(), ffm.getType().isUnique());
	for (RiverObject thisFlattened : interpreter.evaluate(ffm.getObject()).flatten()) {
	    ClassTypedObject thiz = (ClassTypedObject) thisFlattened;
	    SignatureImplementation implementation = interpreter.resolveMethodCallToImplementation(
		    ffm.getMethod().getImplementation().getImplements(), thiz);
	    resultCollection.add(new FunctionFromMethodObject(ffm.getType(), implementation, thiz));
	}
	return new MultiValuedObject(ffm.getType(), RiverInterpreter
		.getRiverObjectFromIterable(ffm.getType(), resultCollection));
    }

}
