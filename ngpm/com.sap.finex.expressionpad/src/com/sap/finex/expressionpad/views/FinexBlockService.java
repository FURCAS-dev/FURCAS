package com.sap.finex.expressionpad.views;

import java.util.Collection;

import structure.Type;
import behavior.actions.Block;
import behavior.actions.NamedValue;
import behavior.actions.Statement;

import com.sap.runlet.abstractexpressionpad.views.BlockService;

public class FinexBlockService implements BlockService<Block, NamedValue, Statement, Type> {

    @Override
    public Collection<Statement> getStatements(Block block) {
	return block.getStatements();
    }

    @Override
    public String getVariableName(NamedValue variable) {
	return variable.getName();
    }

    @Override
    public Type getVariableType(NamedValue variable) {
	return variable.getType();
    }

    @Override
    public Collection<NamedValue> getVariables(Block block) {
	return block.getNamedValues();
    }
    
}
