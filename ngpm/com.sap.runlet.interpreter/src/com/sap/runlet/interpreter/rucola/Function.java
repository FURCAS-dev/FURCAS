package com.sap.runlet.interpreter.rucola;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.sap.ap.metamodel.utils.MetamodelUtils;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.expressions.SignatureCallInterpreter;
import com.sap.runlet.interpreter.objects.FunctionObject;

import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.FunctionSignature;
import data.classes.Parameter;
import data.classes.TypeDefinition;
import dataaccess.expressions.FunctionCallExpression;
import dataaccess.expressions.SignatureCallExpression;

/**
 * Encapsulates a {@link FunctionObject} that can be invoked.
 * 
 * @author Axel Uhl D043530
 * 
 */
public class Function extends RucolaObject {
    public Function(Rucola rucola, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> functionObject) {
	super(rucola, functionObject);
    }

    protected FunctionObject getObject() {
	return (FunctionObject) super.getObject();
    }

    public RucolaObject call(Object... args) {
	FunctionCallExpression fce = MetamodelUtils.createFunctionCallExpression(getResourceSet(), (FunctionSignature) getObject()
		.getImplementation().getImplementedSignature());
	List<RucolaObject> argsAsRucola = new LinkedList<RucolaObject>();
	Iterator<Parameter> paramIter = fce.getSignature().getInput().iterator();
	for (Object arg : args) {
	    argsAsRucola.add(getRucola().wrap(arg, paramIter.next().getType()));
	}
	List<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> argsAsRiver = new LinkedList<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>();
	for (RucolaObject rucolaArg : argsAsRucola) {
	    argsAsRiver.add(rucolaArg.getObject());
	}
	RucolaCallInterpreter fcInterpreter = new RucolaCallInterpreter(fce, argsAsRiver);
	try {
	    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> riverResult = fcInterpreter.evaluate(getInterpreter());
	    return getRucola().createRucolaObjectForRiverObject(riverResult);
	} catch (Exception e) {
	    throw new RucolaException("Error during evaluating function call to " + getObject() + ": " + e.getMessage(), e);
	}
    }

    @Override
    public Function asFunction() {
	return this;
    }

    private class RucolaCallInterpreter extends SignatureCallInterpreter {
	private List<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> params;

	public RucolaCallInterpreter(SignatureCallExpression sce, List<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> params) {
	    super(sce);
	    this.params = params;
	}

	@Override
	protected List<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> getParameterValues(RunletInterpreter interpreter) {
	    return params;
	}
    }
}
