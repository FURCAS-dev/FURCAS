package com.sap.river.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.ClassTypedObject;
import com.sap.river.interpreter.objects.MultiValuedObject;
import com.sap.river.interpreter.objects.RiverObject;
import com.sap.river.interpreter.objects.ValueObject;

import data.classes.AssociationEnd;
import dataaccess.expressions.NavigationStep;
import dataaccess.expressions.Replace;

public class ReplaceInterpreter implements Interpreter<Replace> {
    private Replace replace;
    
    public ReplaceInterpreter(Replace replace) {
	this.replace = replace;
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter) throws SecurityException,
	    IllegalArgumentException, JmiException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RiverObject ro = interpreter.evaluate(replace.getObject());
	if (ro instanceof ValueObject) { // not a multi-object
	    ValueObject vo = (ValueObject) interpreter.evaluate(replace.getObject());
	    int step = 0;
	    return replace(interpreter, vo, step);
	} else {
	    // TODO parallelize
	    Collection<RiverObject> resultCol = RiverObject.createCollection(replace.getType().isOrdered(),
		    replace.getType().isUnique());
	    for (RiverObject voUncast : ro.flatten()) {
		    ValueObject vo = (ValueObject) voUncast;
		    int step = 0;
		    resultCol.add(replace(interpreter, vo, step));
	    }
	    return new MultiValuedObject(replace.getType(), resultCol);
	}
    }

    private ValueObject replace(RiverInterpreter interpreter, ValueObject vo, int step)
	    throws SecurityException, IllegalArgumentException, JmiException,
	    NoSuchMethodException, InstantiationException, IllegalAccessException,
	    InvocationTargetException {
	Collection<AssociationEnd> equalityRelevantEnds = vo.getType().getClazz()
		.getEqualityRelevantAssociationEnds();
	Map<AssociationEnd, Collection<ClassTypedObject>> propertyValues = new HashMap<AssociationEnd, Collection<ClassTypedObject>>();
	// now fill this map with the objects at all equality-relevant association end except
	// for the one named in the first step of the replace expression
	NavigationStep nextStep = replace.getSteps().get(step);
	AssociationEnd stepEnd = nextStep.getTo();
	for (AssociationEnd ae:equalityRelevantEnds) {
	    AssociationEnd otherEnd = ae.otherEnd();
	    if (!otherEnd.equals(stepEnd)) {
		// copy value from original object to map for copy
		Collection<ClassTypedObject> values = RiverObject.createCollection(otherEnd.getType()
			.isOrdered(), otherEnd.getType().isUnique());
		for (RiverObject value : interpreter.navigate(vo, otherEnd).flatten()) {
		    ClassTypedObject propertyValue = (ClassTypedObject) value;
		    values.add(propertyValue);
		}
		propertyValues.put(otherEnd, values);
	    }
	}
	Collection<ClassTypedObject> valuesForStep = RiverObject.createCollection(stepEnd
		.getType().isOrdered(), stepEnd.getType().isUnique());
	if (step < replace.getSteps().size() - 1) {
	    // now recurse for the values for the end identified by stepEnd
	    for (RiverObject stepResult : interpreter.navigate(vo, stepEnd).flatten()) {
		valuesForStep.add(replace(interpreter, (ValueObject) stepResult, step + 1));
	    }
	} else {
	    // last step: replace with "with" expression
	    ClassTypedObject replacement = (ClassTypedObject) interpreter.convert(
		    interpreter.evaluate(replace.getWith()),
		    stepEnd.getType());
	    valuesForStep.add(replacement);
	}
	propertyValues.put(stepEnd, valuesForStep);
	ValueObject result = new ValueObject(vo.getType(),
		propertyValues, interpreter.getDefaultSnapshot(), interpreter);
	interpreter.loadEqualityRelevantLinksOfValue(result);
	return result;
    }
}
