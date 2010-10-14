package com.sap.runlet.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;

import behavioral.actions.Statement;

import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.RunletStackFrame;
import com.sap.runlet.interpreter.objects.NativeObject;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.NativeImpl;
import data.classes.SapClass;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;
import dataaccess.expressions.Expression;
import dataaccess.expressions.Ternary;

public class TernaryInterpreter implements Interpreter<Ternary, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {
    
    private Ternary ternary;
    
    public TernaryInterpreter(Ternary ternary) {
	this.ternary = ternary;
    }

    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(RunletInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException,
	    NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> result;
	if ((Boolean) ((NativeObject) interpreter.evaluate(ternary.getCondition())).getNativeObject()) {
	    result = interpreter.evaluate(ternary.getTrueExpr());
	} else {
	    result = interpreter.evaluate(ternary.getFalseExpr());
	}
	return result;
    }

}
