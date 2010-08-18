package com.sap.runlet.interpreter.expressions;

import behavioral.actions.Statement;

import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.EntityObject;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.RunletStackFrame;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.NativeImpl;
import data.classes.SapClass;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;
import dataaccess.expressions.Expression;
import dataaccess.expressions.MethodCallExpression;
import dataaccess.expressions.ObjectCreationExpression;

public class ObjectCreationInterpreter implements Interpreter<ObjectCreationExpression, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {
    private ObjectCreationExpression oce;
    
    public ObjectCreationInterpreter(ObjectCreationExpression oce) {
	this.oce = oce;
    }

    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(RunletInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException {
    EntityObject<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition> result;
	// can only instantiate entity types
	assert !oce.getClassToInstantiate().isValueType() && !oce.getClassToInstantiate().isAbstract();
	result = interpreter.createEntityObject((ClassTypeDefinition) oce.getType());
	if (oce.getInitializers().size() > 0) {
		try {
			RunletStackFrame objectCreationFrame = new RunletStackFrame();
			objectCreationFrame.setThis(result);
			interpreter.getCallstack().push(objectCreationFrame);
			for (MethodCallExpression initializer : oce.getInitializers()) {
				interpreter.evaluate(initializer);
			}
		}
		catch (Exception e) {
			
		}
		finally {
			interpreter.getCallstack().pop();
		}
	}
	return result;
    }

}
