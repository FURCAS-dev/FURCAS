package com.sap.runlet.expressionpad.failing;

import com.sap.runlet.abstractexpressionpad.Evaluator.ExecuteResult;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.expressionpad.tests.RunletTestCase;

import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.TypeDefinition;

public class FailingTests extends RunletTestCase {
    public void testCreateEntityWithInitializers() throws Exception {
	ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
	            "var c = new City(name: \"Karl-Marx-Stadt\")",
	            "c.name == \"Karl-Marx-Stadt\"");
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(2, result.length);
        assertEquals(0, errors.length);
        assertNOEquals(true, result[1]);
    }
}
