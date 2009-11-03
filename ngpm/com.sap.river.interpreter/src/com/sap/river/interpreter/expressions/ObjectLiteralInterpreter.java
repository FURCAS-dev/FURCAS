package com.sap.river.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.StackFrame;
import com.sap.river.interpreter.objects.ClassTypedObject;
import com.sap.river.interpreter.objects.RiverObject;
import com.sap.river.interpreter.objects.ValueObject;

import data.classes.ActualObjectParameter;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.Parameter;
import dataaccess.expressions.literals.ObjectLiteral;
import dataaccess.expressions.literals.ValueInit;

public class ObjectLiteralInterpreter implements Interpreter<ObjectLiteral> {
    private ObjectLiteral objectLiteral;
    
    public ObjectLiteralInterpreter(ObjectLiteral objectLiteral) {
	this.objectLiteral = objectLiteral;
    }

    @Override
    public ValueObject evaluate(RiverInterpreter interpreter) throws SecurityException,
	    IllegalArgumentException, JmiException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	ClassTypeDefinition ctd = (ClassTypeDefinition) objectLiteral.getType();
	assert ctd.getClazz().isValueType() && !ctd.getClazz().isAbstract();
	StackFrame actualObjectParamsFrame = null;
	// push a stack frame linked to the current frame as its parent frame and put
	// the actual object parameters on the frame if any; this is required to resolve
	// the formal parameters when they are used, e.g., as actual parameters in
	// feature type definitions of the value class of which this interpreter
	// is creating an instance
	try {
	    if (ctd.getClazz().getFormalObjectParameters().size() > 0) {
		actualObjectParamsFrame = new StackFrame(interpreter.getCallstack().peek());
		Iterator<Parameter> fopIter = ctd.getClazz().getFormalObjectParameters().iterator();
		for (ActualObjectParameter aop : ctd.getObjectParameters()) {
		    Parameter fop = fopIter.next();
		    RiverObject aopValue = interpreter.evaluate(aop.getValue());
		    // coerce the actual parameter to the type of the formal parameter if necessary
		    RiverObject convertedAopValue = interpreter.convert(aopValue, fop.getType());
		    actualObjectParamsFrame.enterValue(fop, convertedAopValue);
		}
		// fill up with default parameters
		for (int i=ctd.getObjectParameters().size(); i<ctd.getClazz().getFormalObjectParameters().size(); i++) {
		    Parameter fop = fopIter.next();
		    RiverObject defaultValue = interpreter.evaluate(fop.getDefaultValue());
		    // coerce the actual parameter to the type of the formal parameter if necessary
		    RiverObject convertedAopValue = interpreter.convert(defaultValue, fop.getType());
		    actualObjectParamsFrame.enterValue(fop, convertedAopValue);
		}
		interpreter.push(actualObjectParamsFrame);
	    }
	    Map<AssociationEnd, Collection<ClassTypedObject>> propertyValues =
		new HashMap<AssociationEnd, Collection<ClassTypedObject>>();
	    for (ValueInit vi : objectLiteral.getPropertyValues()) {
		Collection<ClassTypedObject> values = RiverObject.createCollection(vi.getForEnd()
			.getType().isOrdered(), vi.getForEnd().getType().isUnique());
		Iterable<RiverObject> featureValue = interpreter.evaluate(vi.getValue()).flatten();
		for (RiverObject value : featureValue) {
		    ClassTypedObject propertyValue = (ClassTypedObject) interpreter.convert(value,
			    vi.getForEnd().getType());
		    values.add(propertyValue);
		}
		propertyValues.put(vi.getForEnd(), values);
	    }
	    ValueObject result = new ValueObject((ClassTypeDefinition) objectLiteral.getType(),
		    propertyValues, interpreter.getDefaultSnapshot(), interpreter);
	    interpreter.loadEqualityRelevantLinksOfValue(result);
	    return result;
	} finally {
	    if (actualObjectParamsFrame != null) {
		interpreter.pop();
	    }
	}
    }

}
