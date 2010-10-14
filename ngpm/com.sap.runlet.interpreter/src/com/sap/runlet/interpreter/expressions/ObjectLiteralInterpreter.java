package com.sap.runlet.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import behavioral.actions.Statement;

import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.ClassTypedObject;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.RunletStackFrame;
import com.sap.runlet.interpreter.objects.ValueObject;

import data.classes.ActualObjectParameter;
import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.NativeImpl;
import data.classes.Parameter;
import data.classes.SapClass;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;
import dataaccess.expressions.Expression;
import dataaccess.expressions.literals.ObjectLiteral;
import dataaccess.expressions.literals.ValueInit;

public class ObjectLiteralInterpreter implements Interpreter<ObjectLiteral, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {
    private ObjectLiteral objectLiteral;
    
    public ObjectLiteralInterpreter(ObjectLiteral objectLiteral) {
	this.objectLiteral = objectLiteral;
    }

    @Override
    public ValueObject evaluate(RunletInterpreter interpreter) throws SecurityException,
	    IllegalArgumentException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	ClassTypeDefinition ctd = (ClassTypeDefinition) objectLiteral.getType();
	assert ctd.getClazz().isValueType() && !ctd.getClazz().isAbstract();
	RunletStackFrame actualObjectParamsFrame = null;
	// push a stack frame linked to the current frame as its parent frame and put
	// the actual object parameters on the frame if any; this is required to resolve
	// the formal parameters when they are used, e.g., as actual parameters in
	// feature type definitions of the value class of which this interpreter
	// is creating an instance
	try {
	    if (ctd.getClazz().getFormalObjectParameters().size() > 0) {
		actualObjectParamsFrame = new RunletStackFrame(interpreter.getCallstack().peek());
		Iterator<Parameter> fopIter = ctd.getClazz().getFormalObjectParameters().iterator();
		for (ActualObjectParameter aop : ctd.getObjectParameters()) {
		    Parameter fop = fopIter.next();
		    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> aopValue = interpreter.evaluate(aop.getValue());
		    // coerce the actual parameter to the type of the formal parameter if necessary
		    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> convertedAopValue = interpreter.convert(aopValue, fop.getType());
		    actualObjectParamsFrame.enterValue(fop, convertedAopValue);
		}
		// fill up with default parameters
		for (int i=ctd.getObjectParameters().size(); i<ctd.getClazz().getFormalObjectParameters().size(); i++) {
		    Parameter fop = fopIter.next();
		    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> defaultValue = interpreter.evaluate(fop.getDefaultValue());
		    // coerce the actual parameter to the type of the formal parameter if necessary
		    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> convertedAopValue = interpreter.convert(defaultValue, fop.getType());
		    actualObjectParamsFrame.enterValue(fop, convertedAopValue);
		}
		interpreter.push(actualObjectParamsFrame);
	    }
	    Map<AssociationEnd, Collection<ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>> propertyValues =
		new HashMap<AssociationEnd, Collection<ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>>();
	    for (ValueInit vi : objectLiteral.getPropertyValues()) {
		Collection<ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> values = RunletObject.createCollection(vi.getForEnd()
			.getType().isOrdered(), vi.getForEnd().getType().isUnique());
		Iterable<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> featureValue = interpreter.evaluate(vi.getValue()).flatten();
		for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> value : featureValue) {
		    ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> propertyValue = (ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>) interpreter.convert(value,
			    vi.getForEnd().getType());
		    values.add(propertyValue);
		}
		propertyValues.put(vi.getForEnd(), values);
	    }
	    ValueObject result = interpreter.createValueObject((ClassTypeDefinition) objectLiteral.getType(), propertyValues); 
	    interpreter.loadEqualityRelevantLinksOfValue(result);
	    return result;
	} finally {
	    if (actualObjectParamsFrame != null) {
		interpreter.pop();
	    }
	}
    }

}
