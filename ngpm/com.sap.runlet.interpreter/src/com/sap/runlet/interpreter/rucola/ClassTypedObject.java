package com.sap.runlet.interpreter.rucola;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.expressions.MethodCallInterpreter;

import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.MethodSignature;
import data.classes.Parameter;
import data.classes.SapClass;
import data.classes.TypeDefinition;
import dataaccess.expressions.ExpressionsFactory;
import dataaccess.expressions.MethodCallExpression;

public class ClassTypedObject extends RucolaObject {

    public ClassTypedObject(Rucola rucola, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> object) {
	super(rucola, object);
    }
    
    public RucolaObject call(String methodName, Object... args) {
	MethodCallExpression mce = ExpressionsFactory.eINSTANCE.createMethodCallExpression();
	// TODO for NestedTypeDefinitions this won't work and we'd need to resolve the innermost type definition
	SapClass c = ((ClassTypeDefinition) getObject().getType()).getClazz();
	MethodSignature ms = null;
	for (MethodSignature m : c.allSignatures()) {
	    if (m.getName().equals(methodName)) {
		ms = m;
		break;
	    }
	}
	if (ms == null) {
	    throw new RucolaException("Method "+methodName+" not found on "+getObject()+" of type "+getObject().getType());
	}
	mce.setMethodSignature(ms);
	List<RucolaObject> argsAsRucola = new LinkedList<RucolaObject>();
	Iterator<Parameter> paramIter = ms.getInput().iterator();
	for (Object arg:args) {
	    argsAsRucola.add(getRucola().wrap(arg, paramIter.next().getType()));
	}
	List<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> argsAsRiver = new LinkedList<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>();
	for (RucolaObject rucolaArg:argsAsRucola) {
	    argsAsRiver.add(rucolaArg.getObject());
	}
	RucolaMethodCallInterpreter mcInterpreter = new RucolaMethodCallInterpreter(mce, getObject(), argsAsRiver);
	try {
	    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> riverResult = mcInterpreter.evaluate(getInterpreter());
	    return getRucola().createRucolaObjectForRiverObject(riverResult);
	} catch (Exception e) {
	    throw new RucolaException("Error during evaluating method call to "+methodName+" on "+getObject()+
		    ": "+e.getMessage(), e);
	}
    }
    
    public RucolaObject get(String remoteAssociationEndName) {
	// TODO extend such that it works based on non-exposed but navigable association ends too
	return call("."+remoteAssociationEndName);
    }
    
    public RucolaObject set(String remoteAssociationEndName, Object value) {
	// TODO extend such that it works based on non-exposed but navigable association ends too
	return call(remoteAssociationEndName+"=", value);
    }
    
    private class RucolaMethodCallInterpreter extends MethodCallInterpreter {
	private RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> thiz;
	private List<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> params;

	public RucolaMethodCallInterpreter(MethodCallExpression mce, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> thiz, List<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> params) {
	    super(mce);
	    this.thiz = thiz;
	    this.params = params;
	}

	@Override
	protected RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> getOnObject(RunletInterpreter interpreter) {
	    return thiz;
	}
	
	@Override
	protected List<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> getParameterValues(RunletInterpreter interpreter) {
	    return params;
	}
    }
}
