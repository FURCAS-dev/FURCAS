package com.sap.runlet.interpreter.expressions;

import behavioral.actions.Statement;

import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.RunletStackFrame;
import com.sap.runlet.interpreter.objects.FunctionObject;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.NativeImpl;
import data.classes.SapClass;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;
import dataaccess.expressions.Expression;
import dataaccess.expressions.fp.AnonymousFunctionExpr;

/**
 * Computes the {@link FunctionObject} that holds the implementation of the function expression
 *  
 * @author Axel Uhl (D043530)
 */
public class AnonymousFunctionExpressionInterpreter implements Interpreter<AnonymousFunctionExpr, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {
    private AnonymousFunctionExpr afe;
    
    public AnonymousFunctionExpressionInterpreter(AnonymousFunctionExpr afe) {
	this.afe = afe;
    }

    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(RunletInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException {
	return new FunctionObject(afe.getType(), afe.getImplementation());
    }

}
