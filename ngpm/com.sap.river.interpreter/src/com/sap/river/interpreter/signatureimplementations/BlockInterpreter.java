package com.sap.river.interpreter.signatureimplementations;

import java.lang.reflect.InvocationTargetException;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.StackFrame;
import com.sap.river.interpreter.objects.RiverObject;
import com.sap.river.interpreter.statements.ReturnInterpreter;

import behavioral.actions.Block;
import behavioral.actions.Statement;

public class BlockInterpreter implements Interpreter<Block> {
    private Block block;
    
    public BlockInterpreter(Block block) {
	this.block = block;
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException,
	    NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RiverObject result = null;
	StackFrame stackFrame = new StackFrame(/* parent */ interpreter.getCallstack().peek());
	interpreter.getCallstack().push(stackFrame);
	for (Statement statement:block.getStatements()) {
	    result = interpreter.evaluate(statement);
	    if (result instanceof ReturnInterpreter.ReturnResult) {
		// The ReturnInterpreter is expected to already have popped the stack frame
		break;
	    }
	}
	interpreter.getCallstack().pop();
	return result;
    }

}
