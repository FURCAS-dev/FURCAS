package com.sap.river.interpreter.rucola;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.sap.ap.metamodel.utils.MetamodelUtils;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.expressions.SignatureCallInterpreter;
import com.sap.river.interpreter.objects.FunctionObject;
import com.sap.river.interpreter.objects.RiverObject;

import data.classes.FunctionSignature;
import data.classes.Parameter;
import dataaccess.expressions.FunctionCallExpression;
import dataaccess.expressions.SignatureCallExpression;

/**
 * Encapsulates a {@link FunctionObject} that can be invoked.
 * 
 * @author Axel Uhl D043530
 * 
 */
public class Function extends RucolaObject {
    public Function(Rucola rucola, RiverObject functionObject) {
	super(rucola, functionObject);
    }

    protected FunctionObject getObject() {
	return (FunctionObject) super.getObject();
    }

    public RucolaObject call(Object... args) {
	FunctionCallExpression fce = MetamodelUtils.createFunctionCallExpression(getConnection(), (FunctionSignature) getObject()
		.getImplementation().getImplementedSignature());
	List<RucolaObject> argsAsRucola = new LinkedList<RucolaObject>();
	Iterator<Parameter> paramIter = fce.getSignature().getInput().iterator();
	for (Object arg : args) {
	    argsAsRucola.add(getRucola().wrap(arg, paramIter.next().getType()));
	}
	List<RiverObject> argsAsRiver = new LinkedList<RiverObject>();
	for (RucolaObject rucolaArg : argsAsRucola) {
	    argsAsRiver.add(rucolaArg.getObject());
	}
	RucolaCallInterpreter fcInterpreter = new RucolaCallInterpreter(fce, argsAsRiver);
	try {
	    RiverObject riverResult = fcInterpreter.evaluate(getInterpreter());
	    return getRucola().createRucolaObjectForRiverObject(riverResult);
	} catch (Exception e) {
	    throw new RucolaException("Error during evaluating function call to " + getObject() + ": " + e.getMessage(), e);
	} finally {
	    fce.refDelete();
	}
    }

    @Override
    public Function asFunction() {
	return this;
    }

    private class RucolaCallInterpreter extends SignatureCallInterpreter {
	private List<RiverObject> params;

	public RucolaCallInterpreter(SignatureCallExpression sce, List<RiverObject> params) {
	    super(sce);
	    this.params = params;
	}

	@Override
	protected List<RiverObject> getParameterValues(RiverInterpreter interpreter) {
	    return params;
	}
    }
}
