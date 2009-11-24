package com.sap.runlet.abstractexpressionpad.views;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public interface BlockService<BlockType extends RefObject,
			      VariableType extends RefObject,
			      StatementType extends RefObject,
			      TypeUsage extends RefObject> {
    Collection<VariableType> getVariables(BlockType block);
    String getVariableName(VariableType variable);
    Collection<StatementType> getStatements(BlockType block);
    TypeUsage getVariableType(VariableType variable);
}
