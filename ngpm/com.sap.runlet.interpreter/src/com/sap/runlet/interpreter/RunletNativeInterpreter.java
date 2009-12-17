package com.sap.runlet.interpreter;

import behavioral.actions.Statement;

import com.sap.runlet.abstractinterpreter.NativeInterpreter;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.NativeImpl;
import data.classes.SapClass;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;
import dataaccess.expressions.Expression;

public class RunletNativeInterpreter extends NativeInterpreter<SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {
    public RunletNativeInterpreter(NativeImpl nativeImpl) {
	super(nativeImpl, new RunletObjectFormatter());
    }
}
