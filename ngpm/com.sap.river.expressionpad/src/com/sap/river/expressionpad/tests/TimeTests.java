package com.sap.river.expressionpad.tests;

import com.sap.river.expressionpad.Main.ExecuteResult;
import com.sap.river.interpreter.objects.RiverObject;


public class TimeTests extends RiverTestCase {
    
    public void testListSeperatorAfterTimePointLiteral() throws Exception {
        ExecuteResult executeResult = main.execute(
            "var tp = value TimePeriod(to:2009-01-01T10:00:00, from:2009-01-01T10:00:00)");
        RiverObject[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(1, result.length);
        assertEquals(0, errors.length);
    }
    
    public void testPrecedes() throws Exception {
        ExecuteResult executeResult = main.execute(
            "var tp1 = value TimePeriod(from:2009-01-02, to:2009-01-10)",
            "var tp2 = value TimePeriod(from:2009-01-12, to:2009-01-20)",
            "tp1.precedes(tp2)",
            "tp2.precededBy(tp1)",
            "tp2.precedes(tp1)",
            "tp1.precedes(tp1)");
        RiverObject[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(6, result.length);
        assertEquals(0, errors.length);
        
        assertNOEquals(Boolean.TRUE,  result[2]);
        assertNOEquals(Boolean.TRUE,  result[3]);
        assertNOEquals(Boolean.FALSE, result[4]);
        assertNOEquals(Boolean.FALSE, result[5]);
    }

    public void testMeets() throws Exception {
        ExecuteResult executeResult = main.execute(
            "var tp1 = value TimePeriod(from:2009-01-02, to:2009-01-10)",
            "var tp2 = value TimePeriod(from:2009-01-10, to:2009-01-11)",
            "tp1.meets(tp2)",
            "tp2.metBy(tp1)",
            "tp1.meets(tp1)");
        RiverObject[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(5, result.length);
        assertEquals(0, errors.length);
        
        assertNOEquals(Boolean.TRUE,   result[2]);
        assertNOEquals(Boolean.TRUE,   result[3]);
        assertNOEquals(Boolean.FALSE,  result[4]);
    }
    
    public void testOverlaps() throws Exception {
        ExecuteResult executeResult = main.execute(
            "var tp1 = value TimePeriod(from:2009-01-02, to:2009-01-10)",
            "var tp2 = value TimePeriod(from:2009-01-08, to:2009-01-12)",
            "tp1.overlaps(tp2)",
            "tp2.overlappedBy(tp1)",
            "tp1.overlaps(tp1)");
        RiverObject[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(5, result.length);
        assertEquals(0, errors.length);
        
        assertNOEquals(Boolean.TRUE,   result[2]);
        assertNOEquals(Boolean.TRUE,   result[3]);
        assertNOEquals(Boolean.FALSE,  result[4]);
    }

    public void testFinishedBy() throws Exception {
        ExecuteResult executeResult = main.execute(
            "var tp1 = value TimePeriod(from:2009-01-02, to:2009-01-10)",
            "var tp2 = value TimePeriod(from:2009-01-04, to:2009-01-10)",
            "tp1.finishedBy(tp2)",
            "tp2.finishes(tp1)",
            "tp1.finishes(tp2)");
        RiverObject[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(5, result.length);
        assertEquals(0, errors.length);
        
        assertNOEquals(Boolean.TRUE,   result[2]);
        assertNOEquals(Boolean.TRUE,   result[3]);
        assertNOEquals(Boolean.FALSE,  result[4]);
    }
    
    public void testContains() throws Exception {
        ExecuteResult executeResult = main.execute(
            "var tp1 = value TimePeriod(from:2009-01-02, to:2009-01-10)",
            "var tp2 = value TimePeriod(from:2009-01-03, to:2009-01-09)",
            "tp1.contains(tp2)",
            "tp2.during(tp1)",
            "tp1.during(tp1)",
            "tp1.contains(tp1)");
        RiverObject[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(6, result.length);
        assertEquals(0, errors.length);
        
        assertNOEquals(Boolean.TRUE,   result[2]);
        assertNOEquals(Boolean.TRUE,   result[3]);
        assertNOEquals(Boolean.FALSE,  result[4]);
        assertNOEquals(Boolean.FALSE,  result[5]);
    }

    public void testEquals() throws Exception {
        ExecuteResult executeResult = main.execute(
            "var tp1 = value TimePeriod(from:2009-01-02, to:2009-01-10)",
            "var tp2 = value TimePeriod(from:2009-01-02, to:2009-01-12)",
            "tp1 == tp1",
            "tp1 == tp2");
        RiverObject[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(4, result.length);
        assertEquals(0, errors.length);
        
        assertNOEquals(Boolean.TRUE,   result[2]);
        assertNOEquals(Boolean.FALSE,  result[3]);
    }

    public void testStarts() throws Exception {
        ExecuteResult executeResult = main.execute(
            "var tp1 = value TimePeriod(from:2009-01-02, to:2009-01-10)",
            "var tp2 = value TimePeriod(from:2009-01-02, to:2009-01-20)",
            "tp1.starts(tp2)",
            "tp2.startedBy(tp1)",
            "tp1.starts(tp1)");
        RiverObject[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(5, result.length);
        assertEquals(0, errors.length);
        
        assertNOEquals(Boolean.TRUE,   result[2]);
        assertNOEquals(Boolean.TRUE,   result[3]);
        assertNOEquals(Boolean.FALSE,  result[4]);
    }
    
}
