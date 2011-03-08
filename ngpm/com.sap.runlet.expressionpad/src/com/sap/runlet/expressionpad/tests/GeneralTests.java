package com.sap.runlet.expressionpad.tests;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.net.URL;
import java.util.Date;
import java.util.Iterator;

import org.antlr.runtime.RecognitionException;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.runlet.abstractexpressionpad.Evaluator.ExecuteResult;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.abstractinterpreter.util.DateParser;
import com.sap.runlet.abstractinterpreter.util.Fraction;
import com.sap.runlet.expressionpad.RunletEvaluator;
import com.sap.runlet.expressionpad.views.RunletHTTPHandler;
import com.sap.runlet.interpreter.Activator;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.objects.NativeObject;
import com.sap.runlet.interpreter.repository.simpleimpl.RunletInMemoryRepository;
import com.sun.net.httpserver.HttpServer;

import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.TypeDefinition;

public class GeneralTests extends RunletTestCase {
    
    public void testSimpleGroupByWithoutMapping() throws Exception {
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "group 1->including(2) by dim1:fact.div(fact)",
            "group 1->including(2) by dim1:fact");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(2, result.length);
        assertEquals(0, errors.length);
        assertEquals(1, result[0].size());
        boolean found1 = false;
        boolean found2 = false;
        for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> r : result[0].flatten()) {
            if (((NativeObject) r).getNativeObject().equals(new Fraction(1))) {
        	found1 = true;
            }
            if (((NativeObject) r).getNativeObject().equals(new Fraction(2))) {
        	found2 = true;
            }
        }
        assertTrue(found1 && found2);
        assertEquals(2, result[1].size());
        found1 = false;
        found2 = false;
        for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> r : result[1].flatten()) {
            if (((NativeObject) r).getNativeObject().equals(new Fraction(1))) {
        	found1 = true;
            }
            if (((NativeObject) r).getNativeObject().equals(new Fraction(2))) {
        	found2 = true;
            }
        }
        assertTrue(found1 && found2);
    }

    public void testSimpleMap() throws Exception {
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "var f=const function(String s):Number { return s.length(); }",
            "\"abc\"->map(f)",
            "\"abc\"->including(\"defg\")->map(f)",
            "\"abc\"->including(\"defg\")->map(f)->map(const function(Number n):Number { return n.times(2); })");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(4, result.length);
        assertEquals(0, errors.length);
        assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new Fraction[] {
        	new Fraction(3) },
        	result[1]);
        assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new Fraction[] {
        	new Fraction(3), new Fraction(4) },
        	result[2]);
        assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new Fraction[] {
        	new Fraction(6), new Fraction(8) },
        	result[3]);
    }

    public void testMultiFunctionCall() throws Exception {
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "new FunctionTest().test()");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(1, result.length);
        assertEquals(0, errors.length);
        assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new Fraction[] {
        	new Fraction(16), new Fraction(8) },
        	result[0]);
    }

    public void testOqlWithEqualValuesForDifferentAliasCombinations() throws Exception {
	// this test enforces the use of List instead of Set for the alias values cache
	ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "new IteratorTest().m2()");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(1, result.length);
        assertEquals(0, errors.length);
        assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new Fraction[] {
        	new Fraction(0), new Fraction(0), new Fraction(0), new Fraction(0) },
        	result[0]);
    }

    public void testOqlWithAliasUsagesInFromClause() throws Exception {
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "new OqlTest().testSimpleOqlExpression()");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(1, result.length);
        assertEquals(0, errors.length);
        assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new Fraction[] { new Fraction(5), new Fraction(6), new Fraction(7),
        	new Fraction(6), new Fraction(7), new Fraction(8), new Fraction(7), new Fraction(8), new Fraction(9) },
        	result[0]);
    }

    public void testSimpleOql() throws Exception {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main.evaluate(
            "(from 1->including(2)->including(3) as a, 4->including(5)->including(6) as b where true).count");
        assertEquals(1, result.length);
        assertNOEquals(new Fraction(9), result[0]);
    }
    
    public void testSimpleExpression() throws SecurityException, IllegalArgumentException,
	    RecognitionException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main.evaluate("123");
	assertEquals(1, result.length);
	assertTrue(result[0] instanceof NativeObject);
	assertEquals(new Fraction(123), ((NativeObject) result[0]).getNativeObject());
    }

    public void testFunctionExpression() throws SecurityException, IllegalArgumentException,
	    RecognitionException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main
		.evaluate("function(String s):Number { return s.length(); }(\"abc\")");
	assertEquals(1, result.length);
	assertTrue(result[0] instanceof NativeObject);
	assertEquals(new Fraction(3), ((NativeObject) result[0]).getNativeObject());
    }

    public void testTypeOfStringLiteral() throws SecurityException, IllegalArgumentException,
	    RecognitionException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main
		.evaluate("function(String s):Number { return \"kaputt\".length(); }(\"a\")");
	assertEquals(1, result.length);
	assertTrue(result[0] instanceof NativeObject);
	assertEquals(new Fraction(6), ((NativeObject) result[0]).getNativeObject());
    }

    public void testEmptyParameterListOnFunctionSignature() throws SecurityException,
	    IllegalArgumentException, RecognitionException, NoSuchMethodException,
	    InstantiationException, IllegalAccessException, InvocationTargetException {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main.evaluate("function():Number { return 1; }()");
	assertEquals(1, result.length);
	assertTrue(result[0] instanceof NativeObject);
	assertEquals(new Fraction(1), ((NativeObject) result[0]).getNativeObject());
    }

    public void testStatementSequence() throws Exception {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main.execute("var s = \"abc\";", "s;").getResult();
	assertEquals(2, result.length);
	assertTrue(result[1] instanceof NativeObject);
	assertEquals("abc", ((NativeObject) result[1]).getNativeObject());
    }

    public void testStatementSequenceWithExceptionInBetween() throws Exception,
	    IllegalArgumentException, RecognitionException {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result;
	result = main.execute("var s = \"abc\";").getResult();
	result = main.execute("s;").getResult();
	assertEquals(1, result.length);
	assertTrue(result[0] instanceof NativeObject);
	assertEquals("abc", ((NativeObject) result[0]).getNativeObject());
	ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> resultAndErrors = main.execute("s.humba();");
	assertTrue("Method humba() should not have been present in class String",
		resultAndErrors.getErrors().length>0);
	result = main.execute("var i = 123;").getResult();
	result = main.execute("i;").getResult();
	assertEquals(1, result.length);
	assertTrue(result[0] instanceof NativeObject);
	assertEquals(new Fraction(123), ((NativeObject) result[0]).getNativeObject());
    }

    public void testExecuteOfAnonymousFunction() throws Exception {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main.execute("function(String s):Number { return s.length(); }(\"abc\")").getResult();
	assertEquals(1, result.length);
	assertTrue(result[0] instanceof NativeObject);
	assertEquals(new Fraction(3), ((NativeObject) result[0]).getNativeObject());
    }

    public void testTypedVariableDeclaration() throws Exception {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main.execute(
		"String s = \"abc\";", "s.length();").getResult();
	assertEquals(2, result.length);
	assertTrue(result[1] instanceof NativeObject);
	assertEquals(new Fraction(3), ((NativeObject) result[1]).getNativeObject());
    }

    public void testGarbageAfterTarget() throws Exception {
	ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> result = main.execute("String s = \"abc\" a b c");
	assertTrue("Expected parse errors due to garbage at end of input", result.getErrors().length>0);
    }

    public void testUnresolvableClassName() throws Exception {
	ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> result = main.execute("new Humba");
	assertTrue("Expected parse errors due to garbage at end of input",
		result.getErrors().length > 0);
    }

    public void testRedundantFunctionType() throws Exception {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main.execute("function(String s):Number f = function(String s):Number { return s.length(); }",
		"f(\"123\")").getResult();
	assertEquals(2, result.length);
	assertTrue(result[1] instanceof NativeObject);
	assertEquals(new Fraction(3), ((NativeObject) result[1]).getNativeObject());
    }

    public void testApplyFunction() throws Exception {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main.execute(
		"function(Number n):Number plus1 = function(Number n):Number { return n.plus(1); }",
		"var apply=function(function(Number n):Number func, Number arg):Number { return func(arg); }",
		"apply(plus1, 1)").getResult();
	assertEquals(3, result.length);
	assertTrue(result[2] instanceof NativeObject);
	assertEquals(new Fraction(2), ((NativeObject) result[2]).getNativeObject());
    }

    public void testSimpleEntityToValueAssoc() throws Exception {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main
		.execute(
			"var p=new Person()",
			"p.name=\"abc\"",
			"p.name").getResult();
	assertEquals(3, result.length);
	assertTrue(result[2] instanceof NativeObject);
	assertEquals("abc", ((NativeObject) result[2]).getNativeObject());
    }
    
    public void testValueClassEquality() throws Exception {
	// equal street names should compare equal
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main.evaluate("value Address(street: \"a\") == "+
		"value Address(street: \"a\")");
	assertEquals(1, result.length);
	assertTrue(result[0] instanceof NativeObject);
	assertEquals(true, ((NativeObject) result[0]).getNativeObject());
	// different street names should compare unequal
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result2 = main.evaluate("value Address(street: \"a\") == "
		+ "value Address(street: \"ab\")");
	assertEquals(1, result2.length);
	assertTrue(result2[0] instanceof NativeObject);
	assertEquals(false, ((NativeObject) result2[0]).getNativeObject());
	// equal street names but distinct (yet equal) City objects for the city
	// property should compare unequal
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result3 = main.evaluate("value Address(street: \"a\", city: new City()) == "
		+ "value Address(street: \"a\", city: new City())");
	assertEquals(1, result3.length);
	assertTrue(result3[0] instanceof NativeObject);
	assertEquals(false, ((NativeObject) result3[0]).getNativeObject());
    }

    public void testValueClassEqualityWithEmbeddedEntity() throws Exception {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main.execute(
		"var c=new City()",
		"var a1=value Address(street: \"a\", city: c)",
		"var a2=value Address(street: \"a\", city: c)",
		"a1==a2").getResult();
	assertEquals(4, result.length);
	assertTrue(result[3] instanceof NativeObject);
	assertEquals(true, ((NativeObject) result[3]).getNativeObject());
    }

    public void testEntityEquality() throws Exception {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main.execute("var c1=new City()",
		"var c2=new City()",
		"c1==c2",
		"c1==c1").getResult();
	assertEquals(4, result.length);
	assertTrue(result[2] instanceof NativeObject);
	assertEquals(false, ((NativeObject) result[2]).getNativeObject());
	assertTrue(result[3] instanceof NativeObject);
	assertEquals(true, ((NativeObject) result[3]).getNativeObject());
    }

    public void testObjectCountPrecedence() throws Exception {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main.evaluate("1.count");
	assertEquals(1, result.length);
	assertTrue(result[0] instanceof NativeObject);
	assertEquals(new Fraction(1), ((NativeObject) result[0]).getNativeObject());
    }

    public void testSimpleStringTemplate() throws Exception {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main.evaluate("new Templ().m(\"m\"->including(\"y \"))");
	assertEquals(1, result.length);
	assertTrue(result[0] instanceof NativeObject);
	assertEquals("Hello my World!", ((NativeObject) result[0]).getNativeObject());
    }
    
    public void testRunletHttpServerAndBinding() throws Exception {
	ResourceSet rs = RunletEvaluator.getResourceSet("ngpm.stdlib");
	RunletInterpreter interpreter = new RunletInterpreter(rs, new RunletInMemoryRepository(
		Activator.getDefault().getModelAdapter()));
	final String testString = "123";
	URL url = new URL("http://localhost:8234/trala?s="+testString);
	HttpServer runletHTTPServer = HttpServer.create(new InetSocketAddress(8234), 8234);
	RunletHTTPHandler handler = new RunletHTTPHandler(interpreter);
	runletHTTPServer.createContext("/", handler);
	runletHTTPServer.setExecutor(handler); // creates a default executor
	runletHTTPServer.start();
	InputStream is = url.openStream();
	Reader r = new InputStreamReader(is);
	StringBuilder sb = new StringBuilder();
	int read = r.read();
	while (read != -1) {
	    sb.append((char) read);
	    read = r.read();
	}
	r.close();
	runletHTTPServer.stop(0);
	assertEquals(testString, sb.toString());
    }

    public void testCompositionCheck() throws Exception {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main.execute(
		"var o1 = new Organization()",
		"var o2 = new Organization()",
		"var p = new Person()",
		"o1.persons += p").getResult();
	assertEquals(4, result.length);
	try {
	    main.execute("o2.persons += p").getErrors();
	    fail("Expected exception due to illegal attempt to establish a second composite parent link");
	} catch (RuntimeException e) {
	    assertTrue(e.getMessage().startsWith(
			    "java.lang.RuntimeException: Illegal attempt to establish a second composite parent link for composite child"));
	    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result2 = main.execute(
		    "o1.persons->iterate(Boolean b=false; pIter | b.or(pIter == p))")
		    .getResult();
	    assertEquals(1, result2.length);
	    assertEquals(true, ((NativeObject) result2[0]).getNativeObject());
	}
    }
    
    public void testUniqueness() throws Exception {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main.execute(
		"var u = new UniquenessTest()",
		"var p1 = new Person()",
		"var p2 = new Person()",
		"u.persons += p1",
		"u.persons += p1",
		"u.persons += p2",
		"u.persons += p1",
		"u.persons.count",
		"u.numbers += 1",
		"u.numbers += 1",
		"u.numbers += 2",
		"u.numbers += 3",
		"u.numbers += 3",
		"u.numbers.count").getResult();
	assertEquals(14, result.length);
	assertTrue(result[7] instanceof NativeObject);
	assertEquals(new Fraction(2), ((NativeObject) result[7]).getNativeObject());
	assertTrue(result[13] instanceof NativeObject);
	assertEquals(new Fraction(3), ((NativeObject) result[13]).getNativeObject());
    }

    public void testScopeStabilityAcrossParseErrors() throws Exception {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main.execute(
		"var p = new Person()",
		"p.name=\"Axel\"",
		"var dim : : ,+=/| -> iterate(bla blubb trala; )",
		"p.addresses->iterate(i|i.street.append(\"asf\"))",
		"p.name").getResult();
	assertEquals(5, result.length);
	assertTrue(result[4] instanceof NativeObject);
	assertEquals("Axel", ((NativeObject) result[4]).getNativeObject());
    }
    
    public void testValueLiteralWithTwoPropertyInits() throws Exception {
	// equal street names should compare equal
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main.evaluate("value Address(street: \"a\", city: new City()).street == \"a\")");
	assertEquals(1, result.length);
	assertTrue(result[0] instanceof NativeObject);
	assertEquals(true, ((NativeObject) result[0]).getNativeObject());
    }

    public void testSaveLeavesValueLinkIntact() throws Exception {
	
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main.execute(
		"var p = new Person()",
		"p.name=\"Axel\"",
		"p.name",
		"store p",
		"p.name").getResult();
	assertEquals(5, result.length);
	assertTrue(result[2] instanceof NativeObject);
	assertEquals("Axel", ((NativeObject) result[2]).getNativeObject());
	assertTrue(result[4] instanceof NativeObject);
	assertEquals("Axel", ((NativeObject) result[4]).getNativeObject());
    }

    public void testDeleteWithSubsequentAll() throws Exception {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main.execute(
		"var p1 = new Person()",
		"p1.name=\"Jan\"",
		"var p2 = new Person()",
		"p2.name=\"Axel\"",
		"store p1",
		"store p2",
		"delete p1",
		"all Person.count",
		"all Person->iterate(p|p.name)").getResult();
	assertEquals(9, result.length);
	assertTrue(result[7] instanceof NativeObject);
	assertEquals(new Fraction(1), ((NativeObject) result[7]).getNativeObject());
	assertTrue(result[8] instanceof NativeObject);
	assertEquals("Axel", ((NativeObject) result[8]).getNativeObject());
    }
    
    public void testAddTransientCompositeChildToPersistentEntity() throws Exception {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main.execute(
		"var o = new Organization()",
		"var p1 = new Person()",
		"p1.name=\"Jan\"",
		"var p2 = new Person()",
		"p2.name=\"Axel\"",
		"o.persons += p1",
		"store o",
		"o.persons += p2",
		"o.persons.count").getResult();
	assertEquals(9, result.length);
	assertTrue(result[8] instanceof NativeObject);
	assertEquals(new Fraction(2), ((NativeObject) result[8]).getNativeObject());
    }

    public void testDeleteFromComposition() throws Exception {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main.execute(
		"var o = new Organization()",
		"var p1 = new Person()",
		"p1.name=\"Jan\"",
		"var p2 = new Person()",
		"p2.name=\"Axel\"",
		"o.persons += p1",
		"store o",
		"all Person.count", // expect 1, namely "Jan"
		"all Person->iterate(p|p.name)",
		"o.persons += p2",  // p2 should become persistent through composition
		"all Person.count", // therefore here we expect 2
		"delete p1",
		"all Person.count",
		"o.persons.count").getResult();
	assertEquals(14, result.length);
	assertTrue(result[7] instanceof NativeObject);
	assertEquals(new Fraction(1), ((NativeObject) result[7]).getNativeObject());
	assertTrue(result[8] instanceof NativeObject);
	assertEquals("Jan", ((NativeObject) result[8]).getNativeObject());
	assertTrue(result[10] instanceof NativeObject);
	assertEquals(new Fraction(2), ((NativeObject) result[10]).getNativeObject());
	assertTrue(result[12] instanceof NativeObject);
	assertEquals(new Fraction(1), ((NativeObject) result[12]).getNativeObject());
	assertTrue(result[13] instanceof NativeObject);
	assertEquals(new Fraction(1), ((NativeObject) result[13]).getNativeObject());
    }

    public void testNativeValueVariableAsArgument() throws Exception {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main.execute(
		"var p1 = new Person()",
		"var s = \"a\"",
		"s = s.append(\"b\")",
		"p1.name = s",
		"p1.name").getResult();
	assertEquals(5, result.length);
	assertTrue(result[4] instanceof NativeObject);
	assertEquals("ab", ((NativeObject) result[4]).getNativeObject());
    }

    public void testSimpleCellSet() throws Exception {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main.execute(
		"new CellSetTest().m(\"Mannheim\", \"John\")",
		"new CellSetTest().m(\"Heidelberg\", \"Elton\")").getResult();
	assertEquals(2, result.length);
	assertTrue(result[0] instanceof NativeObject);
	assertEquals(new Fraction(2), ((NativeObject) result[0]).getNativeObject());
	assertTrue(result[1] instanceof NativeObject);
	assertEquals(new Fraction(1), ((NativeObject) result[1]).getNativeObject());
    }

    public void testSimpleFunctionFromMethod() throws Exception {
	ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> result = main
		.execute(
			"var f = \"abc\"::substring",
			"f(0,2)",
			"f(1,3)");
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result2 = result.getResult();
	assertEquals(3, result2.length);
	assertTrue(result2[1].iterator().next() instanceof NativeObject);
	assertEquals("ab", ((NativeObject) result2[1].iterator().next()).getNativeObject());
	assertTrue(result2[2].iterator().next() instanceof NativeObject);
	assertEquals("bc", ((NativeObject) result2[2].iterator().next()).getNativeObject());
    }

    public void testTypeAdapterAndSimplePolymorphism() throws Exception {
	ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> result = main
		.execute(
			"Organization o = new Organization()",
			"var at1 = new AdapterTest1()",
			"at1.polymorphismTest(o)",
			"o = at1",
			"at1.polymorphismTest(at1)");
	String[] errors = result.getErrors();
	assertTrue(errors == null || errors.length == 0);
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result2 = result.getResult();
	assertEquals(5, result2.length);
	assertTrue(result2[2].iterator().next() instanceof NativeObject);
	assertEquals(true, ((NativeObject) result2[2].iterator().next()).getNativeObject());
	assertTrue(result2[4].iterator().next() instanceof NativeObject);
	assertEquals(false, ((NativeObject) result2[4].iterator().next()).getNativeObject());
    }

    public void testSimpleReplaceExpression() throws Exception {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main
		.evaluate("new ReplaceTest().n(\"Trala\").b.c.s");
	assertEquals(1, result.length);
	assertTrue(result[0] instanceof NativeObject);
	assertEquals("Trala", ((NativeObject) result[0]).getNativeObject());
    }

    public void testSimpleDateExpression() throws Exception {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = main.evaluate("2008-10-15T10:12:55");
	assertEquals(1, result.length);
	assertTrue(result[0] instanceof NativeObject);
	Date date = DateParser.parse("2008-10-15T10:12:55");
	assertEquals(date, ((NativeObject) result[0]).getNativeObject());
    }

    public void testConstantNamedValue() throws Exception {
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "const i = 5",
            "i = 6");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(1, result.length);
        assertTrue(errors.length > 0);
    }

    public void testDistinctNamedValueNames() throws Exception {
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "var a = 5",
            "const a = 10");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(1, result.length); // expecting one exception for the second statement and no output
        assertEquals(2, errors.length); // runtime exception ("Cannot enter the same value twice") and
    }					// constraint violation (DistinctNamedValueNames)

    public void testSimpleObjectParameterizedClass() throws Exception {
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "var opc=value OPC1|123|()",
            "opc.n()");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(2, result.length);
        assertEquals(0, errors.length);
        assertNOEquals(new Fraction(123), result[1]);
    }
    
    public void testHeadAndTail() throws Exception {
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "Number[] n = 1",
            "n = n->including(2)",
            "n = n->including(3)",
            "n->head()",
            "n->tail()",
            "n->tail()->head()",
            "n->tail()->tail()->head()",
            "n->tail()->tail()->tail()",
            "n->tail()->tail()->tail()->head()");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        //String[]      errors = executeResult.getErrors();
        assertEquals(9, result.length);
        //FIXME: too many constraint violations for now: assertEquals(0, errors.length);
        
        assertNOEquals(new Fraction(1), result[3]);
        assertNOEquals(new Fraction(2), result[5]);
        assertNOEquals(new Fraction(3), result[6]);
        assertTrue(result[7].isEmpty());
        assertTrue(result[8].isEmpty());
        
    }

    public void testSelectIterator() throws Exception {
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "new Iterators().sel(1->including(2)->including(3), function(Number n):Boolean { return n.greaterThan(2); })");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(1, result.length);
        assertEquals(0, errors.length);
        
        assertEquals(1, result[0].size());
        assertNOEquals(new Fraction(3), result[0].iterator().next());
    }

    public void testOptionalParametersForMethod() throws Exception {
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "value DefaultParametersTest().s(\"a\", \"b\")",
            "value DefaultParametersTest().s(\"a\", \"b\", \"c\")",
            "value DefaultParametersTest().s(\"a\", \"b\", \"c\", \"d\")");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(3, result.length);
        assertEquals(0, errors.length);
        assertNOEquals("ababcdef", result[0]);
        assertNOEquals("abcdef", result[1]);
        assertNOEquals("abcd", result[2]);
    }
    
    public void testOptionalParameterForFunction() throws Exception {
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "function(Number 1..1 n, Number 1..1 b=1):Number f=function(Number 1..1 n, Number 1..1 b=1):Number { return n.plus(b); }",
            "f(2, 2)",
            "f(2)");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(3, result.length);
        assertEquals(0, errors.length);
        assertNOEquals(new Fraction(4), result[1]);
        assertNOEquals(new Fraction(3), result[2]);
    }

    public void testAggregateExpression() throws Exception {
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "var m1 = value Measure(precise:true,date:value MonthAndYear(month:2,year:2009),val:100)",
            "var m2 = value Measure(precise:true,date:value MonthAndYear(month:2,year:2009),val:200)",
            "var m3 = value Measure(precise:false,date:value MonthAndYear(month:2,year:2009),val:300)",
            "var ms = m1->including(m2)->including(m3)",
            "m1.measuresByYear(ms,true,2009)");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(5, result.length);
        assertEquals(0, errors.length);
        assertNOEquals(new Fraction(300), result[4]);
    }

    
    public void testTernary() throws Exception {
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "true?1:2",
            "false?1:2",
            "2.greaterThan(1)?\"a\":\"b\"",
            "1.greaterThan(1)?\"a\":\"b\"");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertNOEquals(new Fraction(1), result[0]);
        assertNOEquals(new Fraction(2), result[1]);
        assertNOEquals("a", result[2]);
        assertNOEquals("b", result[3]);
        assertEquals(4, result.length);
        assertEquals(0, errors.length);
    }
    
    public void testDimensionExpression() throws Exception {
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "new CellSetTest().getCellSet()->dim(new CellSetTest().createOrganizations().persons, name)",
            "new CellSetTest().getCellSet()->dim(new CellSetTest().createOrganizations().persons, cityName)");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        // String[]      errors = executeResult.getErrors();
        assertEquals(2, result.length);
        // assertEquals(0, errors.length); // TODO fix model; currently there seem to be three errors...
        assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new String[] { "Elton", "John", "Curt" }, result[0]);
        assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new String[] { "Heidelberg", "Mannheim", "Dallas" }, result[1]);
    }
    
    /**
     * Creates a set of organizations, stores and commits it which starts a new snapshot.
     * From the "historic" snapshot reads the organizations and passes its contained
     * persons to a cell set for aggregation. During this, the comparison with the string
     * value objects "Mannheim" and "John" will have to compare using {@link RunletObject#logicallyEquals(RunletObject)}
     * instead of {@link Object#equals(Object)} so as to ignore that these string values come from the
     * current snapshot while the values to compare against come from the historic snapshot.
     */
    public void testCellSetOverHistoricData() throws Exception {
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "var cst=new CellSetTest()",
            "var orgs=cst.createOrganizations()",
            "store orgs",
            "var ss1=commit",
            "new CellSetTest().getCellSet()(all[ss1] Organization.persons, \"Mannheim\", \"John\")");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        assertEquals(5, result.length);
        assertNOEquals(new Fraction(2), result[4]);
    }

    public void testDimensionExpressionAcrossSnapshots() throws Exception {
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "var p1=new Person()",
            "var c1=new City()",
            "c1.name=\"Mannheim\"",
            "p1.addresses+=value Address(street: \"abc\", city: c1)",
            "store p1",
            "p1.name=\"Axel\"",
            "var ss1=commit",
            "var p2=new Person()",
            "p2.name=\"Jan\"",
            "var c2=new City()",
            "c2.name=\"Heidelberg\"",
            "p2.addresses+=value Address(street: \"Rohrbacher Str.\", city: c2)",
            "store p2",
            "var ss2=commit",
            "Person[] ps=all[ss1] Person->including(all[ss2] Person)",
            "ps.count",
            "new CellSetTest().getCellSet()->dim(ps, cityName)",
            "new CellSetTest().getCellSet()->dim(ps, cityName).count");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        assertEquals(18, result.length);
        assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new String[] { "Mannheim", "Heidelberg" }, result[16]);
        assertNOEquals(new Fraction(2), result[17]);
    }

    public void testMethodCallOnMultiObjectWithEmptyObjectInside() throws Exception {
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "var o=new Organization()",
            "var p1=new Person()",
            "p1.name=\"Nick\"",
            "var p2=new Person()",
            "p2.name=\"Axel\"",
            "o.persons+=p1",
            "o.persons+=p2",
            "o.persons.count",
            "o.persons",
            "o.persons.name",
            "var p3=new Person()",
            "o.persons+=p3",
            "o.persons.name", // produces a multi-object with one EmptyObject inside
            "o.persons.name.length()"); // tests a call on a multi-object with empty object inside
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(14, result.length);
        assertEquals(0, errors.length);
        assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new Fraction[] { new Fraction(4), new Fraction(4)}, result[13]);
    }

    public void testOrderedAssoc1() throws Exception {
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "var o=new OrderedAssocTest()",
            "o.orderedNumbers+=1",
            "o.orderedNumbers+=2",
            "o.orderedNumbers+=3",
            "o.orderedNumbers+=4",
            "o.orderedNumbers",
            "o.orderedNumbers = o.orderedNumbers->including[2](3.5)",
            "o.orderedNumbers",
            "o.orderedNumbers-=3",
            "o.orderedNumbers",
            "o.orderedNumbers+=4",
            "o.orderedNumbers");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        // String[]      errors = executeResult.getErrors();
        assertEquals(12, result.length);
        // assertEquals(0, errors.length); // TODO reanimate error check when models are fixed
        assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new Fraction[] {
        	new Fraction(1), new Fraction(2), new Fraction(3), new Fraction(4)},
        	result[5]);
        assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new Fraction[] {
        	new Fraction(1), new Fraction(2), new Fraction(7, 2), new Fraction(3), new Fraction(4)},
        	result[7]);
        assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new Fraction[] {
        	new Fraction(1), new Fraction(2), new Fraction(7, 2), new Fraction(4)},
        	result[9]);
        assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new Fraction[] {
        	new Fraction(1), new Fraction(2), new Fraction(7, 2), new Fraction(4), new Fraction(4)},
        	result[11]);
    }

    public void testSelectionExpression() throws Exception {
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "new SelectionTest().filterSmallElements(1->including(2), 2)",
            "new SelectionTest().filterSmallElements(1->including(2), 3)",
            "new SelectionTest().filterSmallElements(1->including(2), 1)");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(3, result.length);
        assertEquals(0, errors.length); // output multiplicities problems
        assertNOEquals(new Fraction(1), result[0].iterator().next());
        assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new Fraction[] { new Fraction(1), new Fraction(2) }, result[1]);
        assertEquals(0, result[2].size());
    }

    public void testSelectionAtIndex() throws Exception {
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "new SelectionTest().getAtIndices(1->including(2), 2)",
            "new SelectionTest().getAtIndices(1->including(2), 1)",
            "new SelectionTest().getAtIndices(1->including(2), 1->including(0))");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(3, result.length);
        assertEquals(0, errors.length);
        assertEquals(1, result[0].size()); // should result in a multi-object with one empty object
        assertEquals(0, result[0].iterator().next().size()); // should result in a multi-object with one empty object
        assertNOEquals(new Fraction(2), result[1].iterator().next());
        assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new Fraction[] { new Fraction(2), new Fraction(1) }, result[2]);
    }

    public void testSelectionWithUnorderedIndices() throws Exception {
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "String[] s = \"abc\"->including(\"def\")->including(\"ghi\")->including(\"jkl\")",
            "Number* n = 2->including(1)",
            "s[n]",
            "s[2->including(1)]");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(4, result.length);
        assertEquals(0, errors.length);
        Iterator<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> iter = result[2].iterator();
        assertNOEquals("def", iter.next());
        assertNOEquals("ghi", iter.next());
        iter = result[3].iterator();
        assertNOEquals("ghi", iter.next());
        assertNOEquals("def", iter.next());
    }

    public void testIteratorTyping() throws Exception {
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "new IteratorTest().m()");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(1, result.length);
        assertEquals(0, errors.length);
        assertNOEquals("Axel", result[0]);
    }

    public void testSelectionWithMultiObjects() throws Exception {
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "new SelectionTest().filterNestedMultiplicityElements(2)",
            "new SelectionTest().filterNestedMultiplicityElements(3)");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(2, result.length);
        assertEquals(0, errors.length);
        assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(
        	new Fraction[] { new Fraction(1) }, result[0]);
        assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(
        	new Fraction[] { new Fraction(1), new Fraction(1), new Fraction(2) },
        	result[1]);
    }
    
    public void testCheckForEmptyObject() throws Exception {
	ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
	            "Number * empty",
	            "Number * notEmpty",
	            "notEmpty = notEmpty->including(1)",
	            "var equal1 = empty == notEmpty",
	            "var equal2 = notEmpty == empty");
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(5, result.length);
        assertEquals(0, errors.length);
        assertNOEquals(false, result[3]);
        assertNOEquals(false, result[4]);
    }

    public void testContentEquality() throws Exception {
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "var c1=new City()",
            "var c2=new City()",
            "c1.name=\"abc\"",
            "c2.name=\"abc\"",
            "c1 <=> c2",
            "c1.name=\"def\"",
            "c1 <=> c2");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(7, result.length);
        assertEquals(0, errors.length);
        assertNOEquals(true, result[4]);
        assertNOEquals(false, result[6]);
    }

    public void testContentEqualityOnMultiObjects() throws Exception {
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "var c = new City()",
            "c.name = \"Karl-Marx-Stadt\"",
            "store c",
            "var ss1 = commit",
            "c.name = \"Chemnitz\"",
            "var ss2 = commit",
            "all[ss1] City == all[ss2] City",
            "all[ss1] City <=> all[ss2] City");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(8, result.length);
        assertEquals(0, errors.length);
        assertNOEquals(true, result[6]);
        assertNOEquals(false, result[7]);
    }
    
    /**
     * This test case was created because temporarily we have/had the problem of being
     * unable to create a proper respective model in the evaluator because of issues with
     * unresolved reference handling. This test case, however, relies on a readily parsed
     * (with hacks and manual interventions) test model that uses entity creation with
     * property initializers.
     */
    public void testEntityCreationWithInitializersInClass() throws Exception {
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "new City().m().name");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(1, result.length);
        assertEquals(0, errors.length);
        assertNOEquals("Karl-Marx-Stadt", result[0]);
    }
}
