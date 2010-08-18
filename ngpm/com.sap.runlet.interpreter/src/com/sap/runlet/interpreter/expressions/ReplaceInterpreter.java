package com.sap.runlet.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import behavioral.actions.Statement;

import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.ClassTypedObject;
import com.sap.runlet.abstractinterpreter.objects.MultiValuedObject;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.RunletStackFrame;
import com.sap.runlet.interpreter.objects.ValueObject;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.NativeImpl;
import data.classes.SapClass;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;
import dataaccess.expressions.Expression;
import dataaccess.expressions.NavigationStep;
import dataaccess.expressions.Replace;

public class ReplaceInterpreter implements Interpreter<Replace, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {
    private Replace replace;
    
    public ReplaceInterpreter(Replace replace) {
	this.replace = replace;
    }

    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(RunletInterpreter interpreter) throws SecurityException,
	    IllegalArgumentException, JmiException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> ro = interpreter.evaluate(replace.getObject());
	if (ro instanceof ValueObject) { // not a multi-object
	    ValueObject vo = (ValueObject) interpreter.evaluate(replace.getObject());
	    int step = 0;
	    return replace(interpreter, vo, step);
	} else {
	    // TODO parallelize
	    Collection<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> resultCol = RunletObject.createCollection(replace.getType().isOrdered(),
		    replace.getType().isUnique());
	    for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> voUncast : ro.flatten()) {
		    ValueObject vo = (ValueObject) voUncast;
		    int step = 0;
		    resultCol.add(replace(interpreter, vo, step));
	    }
	    return new MultiValuedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>(replace.getType(), resultCol,
		    replace.getType().isOrdered(), replace.getType().isUnique());
	}
    }

    private ValueObject replace(RunletInterpreter interpreter, ValueObject vo, int step)
	    throws SecurityException, IllegalArgumentException, JmiException,
	    NoSuchMethodException, InstantiationException, IllegalAccessException,
	    InvocationTargetException {
	Collection<AssociationEnd> equalityRelevantEnds = vo.getType().getClazz()
		.getEqualityRelevantAssociationEnds();
	Map<AssociationEnd, Collection<ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>> propertyValues = new HashMap<AssociationEnd, Collection<ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>>();
	// now fill this map with the objects at all equality-relevant association end except
	// for the one named in the first step of the replace expression
	NavigationStep nextStep = replace.getSteps().get(step);
	AssociationEnd stepEnd = nextStep.getTo();
	for (AssociationEnd ae:equalityRelevantEnds) {
	    AssociationEnd otherEnd = ae.otherEnd();
	    if (!otherEnd.equals(stepEnd)) {
		// copy value from original object to map for copy
		Collection<ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> values = RunletObject.createCollection(otherEnd.getType()
			.isOrdered(), otherEnd.getType().isUnique());
		for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> value : interpreter.navigate(vo, otherEnd).flatten()) {
		    ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> propertyValue = (ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>) value;
		    values.add(propertyValue);
		}
		propertyValues.put(otherEnd, values);
	    }
	}
	Collection<ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> valuesForStep = RunletObject.createCollection(stepEnd
		.getType().isOrdered(), stepEnd.getType().isUnique());
	if (step < replace.getSteps().size() - 1) {
	    // now recurse for the values for the end identified by stepEnd
	    for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> stepResult : interpreter.navigate(vo, stepEnd).flatten()) {
		valuesForStep.add(replace(interpreter, (ValueObject) stepResult, step + 1));
	    }
	} else {
	    // last step: replace with "with" expression
	    ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> replacement = (ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>) interpreter.convert(
		    interpreter.evaluate(replace.getWith()),
		    stepEnd.getType());
	    valuesForStep.add(replacement);
	}
	propertyValues.put(stepEnd, valuesForStep);
	ValueObject result = interpreter.createValueObject(vo.getType(), propertyValues);
	interpreter.loadEqualityRelevantLinksOfValue(result);
	return result;
    }
}
