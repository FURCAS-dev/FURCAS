package com.sap.runlet.expressionpad.views;

import java.util.Collection;

import behavioral.actions.Block;
import behavioral.actions.Statement;

import com.sap.runlet.abstractexpressionpad.views.BlockService;

import data.classes.NamedValue;
import data.classes.TypeDefinition;

public class RunletBlockService implements BlockService<Block, NamedValue, Statement, TypeDefinition> {

    @Override
    public Collection<Statement> getStatements(Block block) {
	return block.getStatements();
    }

    @Override
    public String getVariableName(NamedValue variable) {
	return variable.getName();
    }

    @Override
    public TypeDefinition getVariableType(NamedValue variable) {
	return variable.getType();
    }

    @Override
    public Collection<NamedValue> getVariables(Block block) {
	return block.getVariables();
    }
    
}
