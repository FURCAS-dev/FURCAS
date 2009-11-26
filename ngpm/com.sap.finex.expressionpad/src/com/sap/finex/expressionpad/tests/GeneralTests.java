package com.sap.finex.expressionpad.tests;

import java.lang.reflect.InvocationTargetException;

import org.antlr.runtime.RecognitionException;

import structure.Field;
import structure.FinexClass;
import structure.Type;

import com.sap.finex.interpreter.objects.FinexNativeObject;
import com.sap.runlet.abstractexpressionpad.Evaluator.ExecuteResult;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.abstractinterpreter.util.Fraction;

public class GeneralTests extends FinexTestCase {
    public void testSimpleExpression() throws SecurityException, IllegalArgumentException,
	    RecognitionException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RunletObject<Field, Type, FinexClass>[] result = main.evaluate("123");
	assertEquals(1, result.length);
	assertTrue(result[0] instanceof FinexNativeObject);
	assertEquals(((FinexNativeObject) result[0]).getNativeObject(), 123l);
    }
    
    public void testSimpleArithmeticAndComparisons() throws Exception {
        ExecuteResult<Field, Type, FinexClass> executeResult = main.execute(
            "123==123",
            "123==124",
            "123!=124",
            "123!=123",
            "2*2",
            "2./3.",
            "4-1",
            "1+1",
            "\"abc\"==\"abc\"",
            "\"abc\"==\"def\"",
            "\"abc\"!=\"abc\"",
            "\"abc\"!=\"def\"");
        RunletObject<Field, Type, FinexClass>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(12, result.length);
        assertEquals(0, errors.length);
        assertNOEquals(true, result[0]);
        assertNOEquals(false, result[1]);
        assertNOEquals(true, result[2]);
        assertNOEquals(false, result[3]);
        assertNOEquals(4l, result[4]);
        assertNOEquals(new Fraction(2, 3), result[5]);
        assertNOEquals(3l, result[6]);
        assertNOEquals(2l, result[7]);
        assertNOEquals(true, result[8]);
        assertNOEquals(false, result[9]);
        assertNOEquals(false, result[10]);
        assertNOEquals(true, result[11]);
    }
    
    public void testDefaultValueForField() throws Exception {
        ExecuteResult<Field, Type, FinexClass> executeResult = main.execute(
            "create A(a: \"abc\").a",
            "create A(a: \"abc\").c",
            "create A(a: \"abc\", c:234).c",
            "create A(a: \"abc\", c:234).a");
        RunletObject<Field, Type, FinexClass>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(4, result.length);
        assertEquals(0, errors.length);
        assertNOEquals("abc", result[0]);
        assertNOEquals(123l, result[1]);
        assertNOEquals(234l, result[2]);
        assertNOEquals("abc", result[3]);
    }
}
