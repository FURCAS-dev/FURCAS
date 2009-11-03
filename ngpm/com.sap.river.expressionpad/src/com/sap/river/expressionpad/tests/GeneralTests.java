package com.sap.river.expressionpad.tests;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.net.URL;
import java.util.Date;
import java.util.Iterator;

import org.antlr.runtime.RecognitionException;

import com.sap.river.expressionpad.Main;
import com.sap.river.expressionpad.Main.ExecuteResult;
import com.sap.river.expressionpad.views.RunletHTTPHandler;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.NativeObject;
import com.sap.river.interpreter.objects.RiverObject;
import com.sap.river.interpreter.repository.simpleimpl.InMemoryRepository;
import com.sap.river.interpreter.util.DateParser;
import com.sap.river.interpreter.util.Fraction;
import com.sap.river.interpreter.util.InvalidDateException;
import com.sap.tc.moin.repository.Connection;
import com.sun.net.httpserver.HttpServer;

public class GeneralTests extends RiverTestCase {
    
    public void testSimpleExpression() throws SecurityException, IllegalArgumentException,
	    RecognitionException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RiverObject[] result = main.evaluate("123");
	assertEquals(1, result.length);
	assertTrue(result[0] instanceof NativeObject);
	assertEquals(((NativeObject) result[0]).getNativeObject(), new Fraction(123));
    }

    public void testFunctionExpression() throws SecurityException, IllegalArgumentException,
	    RecognitionException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RiverObject[] result = main
		.evaluate("function(String s):Number { return s.length(); }(\"abc\")");
	assertEquals(1, result.length);
	assertTrue(result[0] instanceof NativeObject);
	assertEquals(((NativeObject) result[0]).getNativeObject(), new Fraction(3));
    }

    public void testTypeOfStringLiteral() throws SecurityException, IllegalArgumentException,
	    RecognitionException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RiverObject[] result = main
		.evaluate("function(String s):Number { return \"kaputt\".length(); }(\"a\")");
	assertEquals(1, result.length);
	assertTrue(result[0] instanceof NativeObject);
	assertEquals(((NativeObject) result[0]).getNativeObject(), new Fraction(6));
    }

    public void testEmptyParameterListOnFunctionSignature() throws SecurityException,
	    IllegalArgumentException, RecognitionException, NoSuchMethodException,
	    InstantiationException, IllegalAccessException, InvocationTargetException {
	RiverObject[] result = main.evaluate("function():Number { return 1; }()");
	assertEquals(1, result.length);
	assertTrue(result[0] instanceof NativeObject);
	assertEquals(((NativeObject) result[0]).getNativeObject(), new Fraction(1));
    }

    public void testStatementSequence() throws SecurityException, IllegalArgumentException,
	    RecognitionException {
	RiverObject[] result = main.execute("var s = \"abc\";", "s;").getResult();
	assertEquals(2, result.length);
	assertTrue(result[1] instanceof NativeObject);
	assertEquals("abc", ((NativeObject) result[1]).getNativeObject());
    }

    public void testStatementSequenceWithExceptionInBetween() throws SecurityException,
	    IllegalArgumentException, RecognitionException {
	RiverObject[] result;
	result = main.execute("var s = \"abc\";").getResult();
	result = main.execute("s;").getResult();
	assertEquals(1, result.length);
	assertTrue(result[0] instanceof NativeObject);
	assertEquals("abc", ((NativeObject) result[0]).getNativeObject());
	ExecuteResult resultAndErrors = main.execute("s.humba();");
	assertTrue("Method humba() should not have been present in class String",
		resultAndErrors.getErrors().length>0);
	result = main.execute("var i = 123;").getResult();
	result = main.execute("i;").getResult();
	assertEquals(1, result.length);
	assertTrue(result[0] instanceof NativeObject);
	assertEquals(new Fraction(123), ((NativeObject) result[0]).getNativeObject());
    }

    public void testExecuteOfAnonymousFunction() throws SecurityException, IllegalArgumentException,
	    RecognitionException {
	RiverObject[] result = main.execute("function(String s):Number { return s.length(); }(\"abc\")").getResult();
	assertEquals(1, result.length);
	assertTrue(result[0] instanceof NativeObject);
	assertEquals(new Fraction(3), ((NativeObject) result[0]).getNativeObject());
    }

    public void testTypedVariableDeclaration() throws SecurityException,
	    IllegalArgumentException, RecognitionException {
	RiverObject[] result = main.execute(
		"String s = \"abc\";", "s.length();").getResult();
	assertEquals(2, result.length);
	assertTrue(result[1] instanceof NativeObject);
	assertEquals(new Fraction(3), ((NativeObject) result[1]).getNativeObject());
    }

    public void testGarbageAfterTarget() throws SecurityException,
	    IllegalArgumentException, RecognitionException {
	ExecuteResult result = main.execute("String s = \"abc\" a b c");
	assertTrue("Expected parse errors due to garbage at end of input", result.getErrors().length>0);
    }

    public void testUnresolvableClassName() throws SecurityException, IllegalArgumentException,
	    RecognitionException {
	ExecuteResult result = main.execute("new Humba");
	assertTrue("Expected parse errors due to garbage at end of input",
		result.getErrors().length > 0);
    }

    public void testRedundantFunctionType() throws SecurityException, IllegalArgumentException,
	    RecognitionException {
	RiverObject[] result = main.execute("function(String s):Number f = function(String s):Number { return s.length(); }",
		"f(\"123\")").getResult();
	assertEquals(2, result.length);
	assertTrue(result[1] instanceof NativeObject);
	assertEquals(new Fraction(3), ((NativeObject) result[1]).getNativeObject());
    }

    public void testApplyFunction() throws SecurityException, IllegalArgumentException,
	    RecognitionException {
	RiverObject[] result = main.execute(
		"function(Number n):Number plus1 = function(Number n):Number { return n.plus(1); }",
		"var apply=function(function(Number n):Number func, Number arg):Number { return func(arg); }",
		"apply(plus1, 1)").getResult();
	assertEquals(3, result.length);
	assertTrue(result[2] instanceof NativeObject);
	assertEquals(new Fraction(2), ((NativeObject) result[2]).getNativeObject());
    }

    public void testSimpleEntityToValueAssoc() throws SecurityException, IllegalArgumentException,
	    RecognitionException {
	RiverObject[] result = main
		.execute(
			"var p=new Person",
			"p.name=\"abc\"",
			"p.name").getResult();
	assertEquals(3, result.length);
	assertTrue(result[2] instanceof NativeObject);
	assertEquals("abc", ((NativeObject) result[2]).getNativeObject());
    }
    
    public void testValueClassEquality() throws SecurityException, IllegalArgumentException,
	    RecognitionException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	// equal street names should compare equal
	RiverObject[] result = main.evaluate("value Address(street: \"a\") == "+
		"value Address(street: \"a\")");
	assertEquals(1, result.length);
	assertTrue(result[0] instanceof NativeObject);
	assertEquals(true, ((NativeObject) result[0]).getNativeObject());
	// different street names should compare unequal
	RiverObject[] result2 = main.evaluate("value Address(street: \"a\") == "
		+ "value Address(street: \"ab\")");
	assertEquals(1, result2.length);
	assertTrue(result2[0] instanceof NativeObject);
	assertEquals(false, ((NativeObject) result2[0]).getNativeObject());
	// equal street names but distinct (yet equal) City objects for the city
	// property should compare unequal
	RiverObject[] result3 = main.evaluate("value Address(street: \"a\", city: new City) == "
		+ "value Address(street: \"a\", city: new City)");
	assertEquals(1, result3.length);
	assertTrue(result3[0] instanceof NativeObject);
	assertEquals(false, ((NativeObject) result3[0]).getNativeObject());
    }

    public void testValueClassEqualityWithEmbeddedEntity() throws SecurityException, IllegalArgumentException,
	    RecognitionException {
	RiverObject[] result = main.execute(
		"var c=new City",
		"var a1=value Address(street: \"a\", city: c)",
		"var a2=value Address(street: \"a\", city: c)",
		"a1==a2").getResult();
	assertEquals(4, result.length);
	assertTrue(result[3] instanceof NativeObject);
	assertEquals(true, ((NativeObject) result[3]).getNativeObject());
    }

    public void testEntityEquality() throws SecurityException, IllegalArgumentException,
    RecognitionException {
	RiverObject[] result = main.execute("var c1=new City",
		"var c2=new City",
		"c1==c2",
		"c1==c1").getResult();
	assertEquals(4, result.length);
	assertTrue(result[2] instanceof NativeObject);
	assertEquals(false, ((NativeObject) result[2]).getNativeObject());
	assertTrue(result[3] instanceof NativeObject);
	assertEquals(true, ((NativeObject) result[3]).getNativeObject());
    }

    public void testObjectCountPrecedence() throws SecurityException, IllegalArgumentException,
	    RecognitionException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RiverObject[] result = main.evaluate("1.count");
	assertEquals(1, result.length);
	assertTrue(result[0] instanceof NativeObject);
	assertEquals(new Fraction(1), ((NativeObject) result[0]).getNativeObject());
    }

    public void testSimpleStringTemplate() throws SecurityException, IllegalArgumentException,
	    RecognitionException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RiverObject[] result = main.evaluate("new Templ.m(\"m\"->including(\"y \"))");
	assertEquals(1, result.length);
	assertTrue(result[0] instanceof NativeObject);
	assertEquals("Hello my World!", ((NativeObject) result[0]).getNativeObject());
    }
    
    public void testRunletHttpServerAndBinding() throws IOException {
	Connection conn = Main.getConnection("ngpm.stdlib");
	RiverInterpreter interpreter = new RiverInterpreter(conn, new InMemoryRepository());
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
	conn.close();
    }

    public void testCompositionCheck() throws SecurityException, IllegalArgumentException,
    RecognitionException {
	RiverObject[] result = main.execute(
		"var o1 = new Organization",
		"var o2 = new Organization",
		"var p = new Person",
		"o1.persons += p").getResult();
	assertEquals(4, result.length);
	try {
	    main.execute("o2.persons += p").getErrors();
	    fail("Expected exception due to illegal attempt to establish a second composite parent link");
	} catch (RuntimeException e) {
	    assertTrue(e.getMessage().startsWith(
			    "java.lang.RuntimeException: Illegal attempt to establish a second composite parent link for composite child"));
	    RiverObject[] result2 = main.execute(
		    "o1.persons->iterate(Boolean b=false; pIter | b.or(pIter == p))")
		    .getResult();
	    assertEquals(1, result2.length);
	    assertEquals(true, ((NativeObject) result2[0]).getNativeObject());
	}
    }
    
    public void testUniqueness() throws SecurityException, IllegalArgumentException,
    RecognitionException {
	RiverObject[] result = main.execute(
		"var u = new UniquenessTest",
		"var p1 = new Person",
		"var p2 = new Person",
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

    public void testScopeStabilityAcrossParseErrors() throws SecurityException, IllegalArgumentException,
    RecognitionException {
	RiverObject[] result = main.execute(
		"var p = new Person",
		"p.name=\"Axel\"",
		"var dim : : ,+=/| -> iterate(bla blubb trala; )",
		"p.addresses->iterate(i|i.street.append(\"asf\"))",
		"p.name").getResult();
	assertEquals(5, result.length);
	assertTrue(result[4] instanceof NativeObject);
	assertEquals("Axel", ((NativeObject) result[4]).getNativeObject());
    }
    
    public void testValueLiteralWithTwoPropertyInits() throws SecurityException,
	    IllegalArgumentException, RecognitionException, NoSuchMethodException,
	    InstantiationException, IllegalAccessException, InvocationTargetException {
	// equal street names should compare equal
	RiverObject[] result = main.evaluate("value Address(street: \"a\", city: new City).street == \"a\")");
	assertEquals(1, result.length);
	assertTrue(result[0] instanceof NativeObject);
	assertEquals(true, ((NativeObject) result[0]).getNativeObject());
    }

    public void testSaveLeavesValueLinkIntact() throws SecurityException,
	    IllegalArgumentException, RecognitionException {
	
	RiverObject[] result = main.execute(
		"var p = new Person",
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

    public void testDeleteWithSubsequentAll() throws SecurityException,
	    IllegalArgumentException, RecognitionException {
	RiverObject[] result = main.execute(
		"var p1 = new Person",
		"p1.name=\"Jan\"",
		"var p2 = new Person",
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
    
    public void testAddTransientCompositeChildToPersistentEntity() throws SecurityException,
	    IllegalArgumentException, RecognitionException {
	RiverObject[] result = main.execute(
		"var o = new Organization",
		"var p1 = new Person",
		"p1.name=\"Jan\"",
		"var p2 = new Person",
		"p2.name=\"Axel\"",
		"o.persons += p1",
		"store o",
		"o.persons += p2",
		"o.persons.count").getResult();
	assertEquals(9, result.length);
	assertTrue(result[8] instanceof NativeObject);
	assertEquals(new Fraction(2), ((NativeObject) result[8]).getNativeObject());
    }

    public void testDeleteFromComposition() throws SecurityException,
	    IllegalArgumentException, RecognitionException {
	RiverObject[] result = main.execute(
		"var o = new Organization",
		"var p1 = new Person",
		"p1.name=\"Jan\"",
		"var p2 = new Person",
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

    public void testNativeValueVariableAsArgument() throws SecurityException,
	    IllegalArgumentException, RecognitionException {
	RiverObject[] result = main.execute(
		"var p1 = new Person",
		"var s = \"a\"",
		"s = s.append(\"b\")",
		"p1.name = s",
		"p1.name").getResult();
	assertEquals(5, result.length);
	assertTrue(result[4] instanceof NativeObject);
	assertEquals("ab", ((NativeObject) result[4]).getNativeObject());
    }

    public void testSimpleCellSet() throws SecurityException,
	    IllegalArgumentException, RecognitionException {
	RiverObject[] result = main.execute(
		"new CellSetTest.m(\"Mannheim\", \"John\")",
		"new CellSetTest.m(\"Heidelberg\", \"Elton\")").getResult();
	assertEquals(2, result.length);
	assertTrue(result[0] instanceof NativeObject);
	assertEquals(new Fraction(2), ((NativeObject) result[0]).getNativeObject());
	assertTrue(result[1] instanceof NativeObject);
	assertEquals(new Fraction(1), ((NativeObject) result[1]).getNativeObject());
    }

    public void testSimpleFunctionFromMethod() throws SecurityException,
	    IllegalArgumentException, RecognitionException {
	ExecuteResult result = main
		.execute(
			"var f = \"abc\"::substring",
			"f(0,2)",
			"f(1,3)");
	RiverObject[] result2 = result.getResult();
	assertEquals(3, result2.length);
	assertTrue(result2[1].iterator().next() instanceof NativeObject);
	assertEquals("ab", ((NativeObject) result2[1].iterator().next()).getNativeObject());
	assertTrue(result2[2].iterator().next() instanceof NativeObject);
	assertEquals("bc", ((NativeObject) result2[2].iterator().next()).getNativeObject());
    }

    public void testTypeAdapterAndSimplePolymorphism() throws SecurityException,
	    IllegalArgumentException, RecognitionException {
	ExecuteResult result = main
		.execute(
			"Organization o = new Organization",
			"var at1 = new AdapterTest1",
			"at1.polymorphismTest(o)",
			"o = at1",
			"at1.polymorphismTest(at1)");
	String[] errors = result.getErrors();
	assertTrue(errors == null || errors.length == 0);
	RiverObject[] result2 = result.getResult();
	assertEquals(5, result2.length);
	assertTrue(result2[2].iterator().next() instanceof NativeObject);
	assertEquals(true, ((NativeObject) result2[2].iterator().next()).getNativeObject());
	assertTrue(result2[4].iterator().next() instanceof NativeObject);
	assertEquals(false, ((NativeObject) result2[4].iterator().next()).getNativeObject());
    }

    public void testSimpleReplaceExpression() throws SecurityException, IllegalArgumentException,
	    RecognitionException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RiverObject[] result = main
		.evaluate("new ReplaceTest.n(\"Trala\").b.c.s");
	assertEquals(1, result.length);
	assertTrue(result[0] instanceof NativeObject);
	assertEquals("Trala", ((NativeObject) result[0]).getNativeObject());
    }

    public void testSimpleDateExpression() throws SecurityException, IllegalArgumentException,
	    RecognitionException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException, InvalidDateException {
	RiverObject[] result = main.evaluate("2008-10-15T10:12:55");
	assertEquals(1, result.length);
	assertTrue(result[0] instanceof NativeObject);
	Date date = DateParser.parse("2008-10-15T10:12:55");
	assertEquals(date, ((NativeObject) result[0]).getNativeObject());
    }

    public void testConstantNamedValue() throws Exception {
        ExecuteResult executeResult = main.execute(
            "const i = 5",
            "i = 6");
        RiverObject[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(1, result.length);
        assertTrue(errors.length > 0);
    }

    public void testDistinctNamedValueNames() throws Exception {
        ExecuteResult executeResult = main.execute(
            "var a = 5",
            "const a = 10");
        RiverObject[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(1, result.length); // expecting one exception for the second statement and no output
        assertEquals(2, errors.length); // runtime exception ("Cannot enter the same value twice") and
    }					// constraint violation (DistinctNamedValueNames)

    public void testSimpleObjectParameterizedClass() throws Exception {
        ExecuteResult executeResult = main.execute(
            "var opc=value OPC1|123|()",
            "opc.n()");
        RiverObject[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(2, result.length);
        assertEquals(0, errors.length);
        assertNOEquals(new Fraction(123), result[1]);
    }
    
    public void testHeadAndTail() throws Exception {
        ExecuteResult executeResult = main.execute(
            "Number[] n = 1",
            "n = n->including(2)",
            "n = n->including(3)",
            "n->head()",
            "n->tail()",
            "n->tail()->head()",
            "n->tail()->tail()->head()",
            "n->tail()->tail()->tail()",
            "n->tail()->tail()->tail()->head()");
        RiverObject[] result = executeResult.getResult();
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
        ExecuteResult executeResult = main.execute(
            "new Iterators.select(1->including(2)->including(3), function(Number n):Boolean { return n.greaterThan(2); })");
        RiverObject[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(1, result.length);
        assertEquals(0, errors.length);
        
        assertEquals(1, result[0].size());
        assertNOEquals(new Fraction(3), result[0].iterator().next());
    }

    public void testOptionalParametersForMethod() throws Exception {
        ExecuteResult executeResult = main.execute(
            "value DefaultParametersTest().s(\"a\", \"b\")",
            "value DefaultParametersTest().s(\"a\", \"b\", \"c\")",
            "value DefaultParametersTest().s(\"a\", \"b\", \"c\", \"d\")");
        RiverObject[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(3, result.length);
        assertEquals(0, errors.length);
        assertNOEquals("ababcdef", result[0]);
        assertNOEquals("abcdef", result[1]);
        assertNOEquals("abcd", result[2]);
    }
    
    public void testOptionalParameterForFunction() throws Exception {
        ExecuteResult executeResult = main.execute(
            "function(Number 1..1 n, Number 1..1 b=1):Number f=function(Number 1..1 n, Number 1..1 b=1):Number { return n.plus(b); }",
            "f(2, 2)",
            "f(2)");
        RiverObject[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(3, result.length);
        assertEquals(0, errors.length);
        assertNOEquals(new Fraction(4), result[1]);
        assertNOEquals(new Fraction(3), result[2]);
    }

    public void testAnalyticsQueryOnOpportunity() throws Exception {
        ExecuteResult executeResult = main.execute(
            "var o=new Opportunity",
            "o.expectedSalesVolume=value Amount(val:30, currency:value Currency(code:\"USD\"))",
            "o.probability=1.div(3)",
            "o.phase=\"open\"",
            "o.expectedCloseDate=2009-07-01",
            "value Reports().getExpectedRevenueByMonthAndPhase(o, value Calendar().getMonth(2009-07-01), \"open\").val");
        RiverObject[] result = executeResult.getResult();
        // String[]      errors = executeResult.getErrors();
        assertEquals(6, result.length);
        // assertTrue(errors.length<=1); // TODO set to 0 when OutputMultiplicities problem has been resolved
        assertNOEquals(new Fraction(10), result[5]);
    }
    
    public void testTernary() throws Exception {
        ExecuteResult executeResult = main.execute(
            "true?1:2",
            "false?1:2",
            "2.greaterThan(1)?\"a\":\"b\"",
            "1.greaterThan(1)?\"a\":\"b\"");
        RiverObject[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertNOEquals(new Fraction(1), result[0]);
        assertNOEquals(new Fraction(2), result[1]);
        assertNOEquals("a", result[2]);
        assertNOEquals("b", result[3]);
        assertEquals(4, result.length);
        assertEquals(0, errors.length);
    }
    
    public void testDimensionExpression() throws Exception {
        ExecuteResult executeResult = main.execute(
            "new CellSetTest.getCellSet()->dim(new CellSetTest.createOrganizations().persons, name)",
            "new CellSetTest.getCellSet()->dim(new CellSetTest.createOrganizations().persons, cityName)");
        RiverObject[] result = executeResult.getResult();
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
     * value objects "Mannheim" and "John" will have to compare using {@link RiverObject#logicallyEquals(RiverObject)}
     * instead of {@link Object#equals(Object)} so as to ignore that these string values come from the
     * current snapshot while the values to compare against come from the historic snapshot.
     */
    public void testCellSetOverHistoricData() throws Exception {
        ExecuteResult executeResult = main.execute(
            "var cst=new CellSetTest",
            "var orgs=cst.createOrganizations()",
            "store orgs",
            "var ss1=commit",
            "new CellSetTest.getCellSet()(all[ss1] Organization.persons, \"Mannheim\", \"John\")");
        RiverObject[] result = executeResult.getResult();
        assertEquals(5, result.length);
        assertNOEquals(new Fraction(2), result[4]);
    }

    public void testDimensionExpressionAcrossSnapshots() throws Exception {
        ExecuteResult executeResult = main.execute(
            "var p1=new Person",
            "var c1=new City",
            "c1.name=\"Mannheim\"",
            "p1.addresses+=value Address(street: \"abc\", city: c1)",
            "store p1",
            "p1.name=\"Axel\"",
            "var ss1=commit",
            "var p2=new Person",
            "p2.name=\"Jan\"",
            "var c2=new City",
            "c2.name=\"Heidelberg\"",
            "p2.addresses+=value Address(street: \"Rohrbacher Str.\", city: c2)",
            "store p2",
            "var ss2=commit",
            "Person[] ps=all[ss1] Person->including(all[ss2] Person)",
            "ps.count",
            "new CellSetTest.getCellSet()->dim(ps, cityName)",
            "new CellSetTest.getCellSet()->dim(ps, cityName).count");
        RiverObject[] result = executeResult.getResult();
        assertEquals(18, result.length);
        assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new String[] { "Mannheim", "Heidelberg" }, result[16]);
        assertNOEquals(new Fraction(2), result[17]);
    }

    public void testMethodCallOnMultiObjectWithEmptyObjectInside() throws Exception {
        ExecuteResult executeResult = main.execute(
            "var o=new Organization",
            "var p1=new Person",
            "p1.name=\"Nick\"",
            "var p2=new Person",
            "p2.name=\"Axel\"",
            "o.persons+=p1",
            "o.persons+=p2",
            "o.persons.count",
            "o.persons",
            "o.persons.name",
            "var p3=new Person",
            "o.persons+=p3",
            "o.persons.name", // produces a multi-object with one EmptyObject inside
            "o.persons.name.length()"); // tests a call on a multi-object with empty object inside
        RiverObject[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(14, result.length);
        assertEquals(0, errors.length);
        assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new Fraction[] { new Fraction(4), new Fraction(4)}, result[13]);
    }

    public void testOrderedAssoc1() throws Exception {
        ExecuteResult executeResult = main.execute(
            "var o=new OrderedAssocTest",
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
        RiverObject[] result = executeResult.getResult();
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
        ExecuteResult executeResult = main.execute(
            "new SelectionTest.filterSmallElements(1->including(2), 2)",
            "new SelectionTest.filterSmallElements(1->including(2), 3)",
            "new SelectionTest.filterSmallElements(1->including(2), 1)");
        RiverObject[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(3, result.length);
        assertEquals(0, errors.length); // output multiplicities problems
        assertNOEquals(new Fraction(1), result[0].iterator().next());
        assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new Fraction[] { new Fraction(1), new Fraction(2) }, result[1]);
        assertEquals(0, result[2].size());
    }

    public void testSelectionAtIndex() throws Exception {
        ExecuteResult executeResult = main.execute(
            "new SelectionTest.getAtIndices(1->including(2), 2)",
            "new SelectionTest.getAtIndices(1->including(2), 1)",
            "new SelectionTest.getAtIndices(1->including(2), 1->including(0))");
        RiverObject[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(3, result.length);
        assertEquals(0, errors.length);
        assertEquals(1, result[0].size()); // should result in a multi-object with one empty object
        assertEquals(0, result[0].iterator().next().size()); // should result in a multi-object with one empty object
        assertNOEquals(new Fraction(2), result[1].iterator().next());
        assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(new Fraction[] { new Fraction(2), new Fraction(1) }, result[2]);
    }

    public void testSelectionWithUnorderedIndices() throws Exception {
        ExecuteResult executeResult = main.execute(
            "String[] s = \"abc\"->including(\"def\")->including(\"ghi\")->including(\"jkl\")",
            "Number* n = 2->including(1)",
            "s[n]",
            "s[2->including(1)]");
        RiverObject[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(4, result.length);
        assertEquals(0, errors.length);
        Iterator<RiverObject> iter = result[2].iterator();
        assertNOEquals("def", iter.next());
        assertNOEquals("ghi", iter.next());
        iter = result[3].iterator();
        assertNOEquals("ghi", iter.next());
        assertNOEquals("def", iter.next());
    }

    public void testIteratorTyping() throws Exception {
        ExecuteResult executeResult = main.execute(
            "new IteratorTest.m()");
        RiverObject[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(1, result.length);
        assertEquals(0, errors.length);
        assertNOEquals("Axel", result[0]);
    }

}
