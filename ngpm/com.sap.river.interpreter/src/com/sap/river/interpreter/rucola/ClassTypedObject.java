package com.sap.river.interpreter.rucola;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.expressions.MethodCallInterpreter;
import com.sap.river.interpreter.objects.RiverObject;

import data.classes.ClassTypeDefinition;
import data.classes.MethodSignature;
import data.classes.Parameter;
import data.classes.SapClass;
import dataaccess.expressions.MethodCallExpression;

public class ClassTypedObject extends RucolaObject {

    public ClassTypedObject(Rucola rucola, RiverObject object) {
	super(rucola, object);
    }
    
    public RucolaObject call(String methodName, Object... args) {
	MethodCallExpression mce = getConnection().createElement(MethodCallExpression.CLASS_DESCRIPTOR);
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
	List<RiverObject> argsAsRiver = new LinkedList<RiverObject>();
	for (RucolaObject rucolaArg:argsAsRucola) {
	    argsAsRiver.add(rucolaArg.getObject());
	}
	RucolaMethodCallInterpreter mcInterpreter = new RucolaMethodCallInterpreter(mce, getObject(), argsAsRiver);
	try {
	    RiverObject riverResult = mcInterpreter.evaluate(getInterpreter());
	    return getRucola().createRucolaObjectForRiverObject(riverResult);
	} catch (Exception e) {
	    throw new RucolaException("Error during evaluating method call to "+methodName+" on "+getObject()+
		    ": "+e.getMessage(), e);
	} finally {
	    mce.refDelete();
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
	private RiverObject thiz;
	private List<RiverObject> params;

	public RucolaMethodCallInterpreter(MethodCallExpression mce, RiverObject thiz, List<RiverObject> params) {
	    super(mce);
	    this.thiz = thiz;
	    this.params = params;
	}

	@Override
	protected RiverObject getOnObject(RiverInterpreter interpreter) {
	    return thiz;
	}
	
	@Override
	protected List<RiverObject> getParameterValues(RiverInterpreter interpreter) {
	    return params;
	}
    }
}
