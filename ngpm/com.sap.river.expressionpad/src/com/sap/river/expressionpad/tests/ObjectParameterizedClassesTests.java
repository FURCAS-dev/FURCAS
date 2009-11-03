package com.sap.river.expressionpad.tests;

import com.sap.river.expressionpad.Main.ExecuteResult;
import com.sap.river.interpreter.objects.MultiValuedObject;
import com.sap.river.interpreter.objects.RiverObject;
import com.sap.river.interpreter.objects.ValueObject;
import com.sap.river.interpreter.util.Fraction;


public class ObjectParameterizedClassesTests extends RiverTestCase {
    
    public void testInitializationConversion() throws Exception {
        ExecuteResult executeResult = main.execute(
            "OPC1|1| o1 = value OPC1|2|()",
            "OPC1|2| o2 = value OPC1|2|()",
            "o1.n()",
            "o2.n()");
        RiverObject[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(4, result.length);
        assertEquals(0, errors.length);
        
        assertNOEquals(new Fraction(1), result[2]);
        assertNOEquals(new Fraction(2), result[3]);
    }

    public void testAssignmentConversion() throws Exception {
        ExecuteResult executeResult = main.execute(
            "OPC1|1| o1",
            "o1 = value OPC1|2|()",
            "o1.n()");
        RiverObject[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(3, result.length);
        assertEquals(0, errors.length);
        
        assertNOEquals(new Fraction(1), result[2]);
    }
    
    public void testMultiObjectConversion() throws Exception {
        ExecuteResult executeResult = main.execute(
            "OPC1|2|[] o2s",
            "o2s = o2s->including(value OPC1|2|())",
            "o2s = o2s->including(value OPC1|2|())",
            "o2s = o2s->including(value OPC1|2|())",
            "OPC1|1|[] o1s = o2s",
            "o1s.n()");
        RiverObject[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(6, result.length);
        assertEquals(0, errors.length);
        
        assertTrue(result[5] instanceof MultiValuedObject);
        for (RiverObject ro : result[5]) {
            assertTrue(ro instanceof ValueObject);
            ValueObject vo = (ValueObject) ro;
            assertNOEquals(new Fraction(1), vo);
        }
    }
    
    public void testObjectParameterizedFeatureInOPC() throws Exception {
        ExecuteResult executeResult = main.execute(
            "var o=value OPCWithFeature|2|(feature: value OPC1|3|())",
            "o.feature.n()");
        RiverObject[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(2, result.length);
        assertEquals(0, errors.length);
        
        assertNOEquals(new Fraction(2), result[1]);
    }

    public void testOptionalObjectParameters() throws Exception {
        ExecuteResult executeResult = main.execute(
            "var o=value OPCWithOptional()",
            "o.getPrecision()",
            "o.getRoundingRule()",
            "OPCWithOptional|1| o2",
            "o2=o",
            "o2.getPrecision()");
        RiverObject[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(6, result.length);
        assertEquals(0, errors.length);

        assertNOEquals(new Fraction(-1), result[1]);
        assertNOEquals(new Fraction(0), result[2]);
        assertNOEquals(new Fraction(1), result[5]);
    }
}
