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
    public void testTransitiveDetermination() throws Exception {
        ExecuteResult<Field, Type, FinexClass> executeResult = main.execute(
            "create A(.b: 1).transitiveDependent");
        RunletObject<Field, Type, FinexClass>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(1, result.length);
        assertEquals(0, errors.length);
    }
    
    public void testSimpleDetermination() throws Exception {
        ExecuteResult<Field, Type, FinexClass> executeResult = main.execute(
            "create A(.b: 234, .c: 1).d",
            "create A(.b: 234).d");
        RunletObject<Field, Type, FinexClass>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(2, result.length);
        assertEquals(0, errors.length);
        assertNOEquals(235l, result[0]);
        assertNOEquals(357l, result[1]);
    }

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
            "create A(.a: \"abc\").a",
            "create A(.a: \"abc\").c",
            "create A(.a: \"abc\", .c:234).c",
            "create A(.a: \"abc\", .c:234).a");
        RunletObject<Field, Type, FinexClass>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(4, result.length);
        assertEquals(0, errors.length);
        assertNOEquals("abc", result[0]);
        assertNOEquals(123l, result[1]);
        assertNOEquals(234l, result[2]);
        assertNOEquals("abc", result[3]);
    }

    public void testTupleOverMultipleEntities() throws Exception {
	ExecuteResult<Field, Type, FinexClass> executeResult = main.execute(
            "[create A(.b: 1), create A(.b: 2), create A(.b: 3)].(b: .b).b");
	RunletObject<Field, Type, FinexClass>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(1, result.length);
        assertEquals(0, errors.length);
        assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new Long[] { 1l, 2l, 3l }, result[0]);
    }

    public void testTupleOverMultipleAliasedEntities() throws Exception {
	ExecuteResult<Field, Type, FinexClass> executeResult = main.execute(
            "[create A(.b: 1), create A(.b: 2), create A(.b: 3)] AS e.(b: e.b).b");
	RunletObject<Field, Type, FinexClass>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(1, result.length);
        assertEquals(0, errors.length);
        assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new Long[] { 1l, 2l, 3l }, result[0]);
    }
    
    public void testAdditionWithAliasAndTuple() throws Exception {
	ExecuteResult<Field, Type, FinexClass> executeResult = main.execute(
            "(1 AS eins + 2).(x: eins, y: 2*eins).x",
            "(1 AS eins + 2).(x: eins, y: 2*eins).y");
	RunletObject<Field, Type, FinexClass>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(2, result.length);
        assertEquals(0, errors.length);
        assertNOEquals(1l, result[0]);
        assertNOEquals(2l, result[1]);
    }
    
    public void testTupleOverMultiObjectWithAlias() throws Exception {
	ExecuteResult<Field, Type, FinexClass> executeResult = main.execute(
            "[create A(.b: 1), create A(.b: 2 AS two), create A(.b: 3)].(z: two).z");
	RunletObject<Field, Type, FinexClass>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(1, result.length);
        assertEquals(0, errors.length);
        assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new Long[] { 2l, 2l, 2l }, result[0]);
    }

    public void testAliasOnLiteralInSumWithTuple() throws Exception {
	ExecuteResult<Field, Type, FinexClass> executeResult = main.execute(
            "(1 + 2 AS x).(x1: x).x1");
	RunletObject<Field, Type, FinexClass>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(1, result.length);
        assertEquals(0, errors.length);
        assertNOEquals(2l, result[0]);
    }

    public void testSimpleAliases() throws Exception {
	ExecuteResult<Field, Type, FinexClass> executeResult = main.execute(
            "[1 AS one, 2 AS two].sum() AS s.(a: one, b: two, c: s).a",
            "[1 AS one, 2 AS two].sum() AS s.(a: one, b: two, c: s).b",
            "[1 AS one, 2 AS two].sum() AS s.(a: one, b: two, c: s).c");
	RunletObject<Field, Type, FinexClass>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(3, result.length);
        assertEquals(0, errors.length);
        assertNOEquals(1l, result[0]);
        assertNOEquals(2l, result[1]);
        assertNOEquals(3l, result[2]);
    }

    public void testComplexPathExpressionWithAliasInTheMiddle() throws Exception {
	ExecuteResult<Field, Type, FinexClass> executeResult = main.execute(
            "[create SalesOrder(.Type: \"Type1\", .SOItem: ["+
              "create SOItem(.Quantity: 1., .Product: create Product(.Color: \"Blue\"), .Price: 10.), "+
              "create SOItem(.Quantity: 2., .Product: create Product(.Color: \"Green\"), .Price: 22.)]),"+
             "create SalesOrder(.Type: \"Type1\", .SOItem: ["+
              "create SOItem(.Quantity: 1., .Product: create Product(.Color: \"Blue\"), .Price: 10.), "+
              "create SOItem(.Quantity: 3., .Product: create Product(.Color: \"Blue\"), .Price: 33.)]), "+
             "create SalesOrder(.Type: \"Type2\", .SOItem: ["+
              "create SOItem(.Quantity: 1., .Product: create Product(.Color: \"Blue\"), .Price: 10.), "+
              "create SOItem(.Quantity: 4., .Product: create Product(.Color: \"Yellow\"), .Price: 44.)])]"+
                    "[.Type==\"Type1\"].SOItem AS i.Product[.Color==\"Blue\"].(item: i).item.Price");
	RunletObject<Field, Type, FinexClass>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(1, result.length);
        assertEquals(0, errors.length);
        assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new Fraction[] {
        	new Fraction(10), new Fraction(33), new Fraction(10) }, result[0]);
    }

    public void testSimpleAll() throws Exception {
	ExecuteResult<Field, Type, FinexClass> executeResult = main.execute(
            "create Product(.Color: \"Blue\")",
            "create Product(.Color: \"Green\")",
            "create Product(.Color: \"Yellow\")",
            "create Product(.Color: \"Red\")",
            "all Product.Color");
	RunletObject<Field, Type, FinexClass>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(5, result.length);
        assertEquals(0, errors.length);
        assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new String[] {
        	"Blue", "Red", "Green", "Yellow" }, result[4]);
    }
}
