package com.sap.finex.interpreter;

import structure.Association;
import structure.Field;
import structure.FinexClass;
import structure.Type;
import behavior.actions.Statement;
import behavior.expressions.Expression;
import behavior.functions.NativeImpl;
import behavior.functions.SignatureImplementation;

import com.sap.runlet.abstractinterpreter.LinkContainer;
import com.sap.runlet.abstractinterpreter.repository.Repository;
import com.sap.runlet.abstractinterpreter.util.ModelAdapter;

public class FinexLinkContainer
	extends
	LinkContainer<Association, Field, FinexClass, Type, FinexClass, Statement,
	Expression, SignatureImplementation, FinexStackFrame, NativeImpl, FinexInterpreter> {

    public FinexLinkContainer(ModelAdapter<Association, Field, FinexClass, Type, FinexClass> modelAdapter,
	    Repository<Association, Field, FinexClass, Type, FinexClass> repository) {
	super(modelAdapter, repository);
    }

}
