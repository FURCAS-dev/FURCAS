package com.sap.river.interpreter.expressions;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.FunctionObject;
import com.sap.river.interpreter.objects.RiverObject;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import dataaccess.expressions.fp.AnonymousFunctionExpr;

/**
 * Computes the {@link FunctionObject} that holds the implementation of the function expression
 *  
 * @author Axel Uhl (D043530)
 */
public class AnonymousFunctionExpressionInterpreter implements Interpreter<AnonymousFunctionExpr> {
    private AnonymousFunctionExpr afe;
    
    public AnonymousFunctionExpressionInterpreter(AnonymousFunctionExpr afe) {
	this.afe = afe;
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException {
	return new FunctionObject(afe.getType(), afe.getImplementation());
    }

}
