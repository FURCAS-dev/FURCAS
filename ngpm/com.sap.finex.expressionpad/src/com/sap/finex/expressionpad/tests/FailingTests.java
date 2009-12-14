package com.sap.finex.expressionpad.tests;

import structure.Field;
import structure.FinexClass;
import structure.Type;

import com.sap.runlet.abstractexpressionpad.Evaluator.ExecuteResult;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;

public class FailingTests extends FinexTestCase {
    public void testAliasWithEqualOperandAlias() throws Exception {
        ExecuteResult<Field, Type, FinexClass> executeResult = main.execute(
            "[create A(.a: \"abc\", .b: 1), create A(.a: \"def\", .b: 2), create A(.a: \"ghi\", .b: 3)] AS x.a AS y.(a: x, b: x.b).b",
            "[create A(.a: \"abc\", .b: 1), create A(.a: \"def\", .b: 2), create A(.a: \"abc\", .b: 3)] AS x.a AS y.(a: x, b: x.b).b");
        RunletObject<Field, Type, FinexClass>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(2, result.length);
        assertEquals(0, errors.length);
        assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new Long[] { 1l, 2l, 3l }, result[0]);
        assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new Long[] { 1l, 2l, 3l }, result[1]);
    }
}
