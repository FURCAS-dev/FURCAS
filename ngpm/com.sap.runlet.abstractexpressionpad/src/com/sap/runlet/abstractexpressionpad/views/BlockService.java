package com.sap.runlet.abstractexpressionpad.views;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;

public interface BlockService<BlockType extends EObject,
			      VariableType extends EObject,
			      StatementType extends EObject,
			      TypeUsage extends EObject> {
    Collection<VariableType> getVariables(BlockType block);
    String getVariableName(VariableType variable);
    Collection<StatementType> getStatements(BlockType block);
    TypeUsage getVariableType(VariableType variable);
}
