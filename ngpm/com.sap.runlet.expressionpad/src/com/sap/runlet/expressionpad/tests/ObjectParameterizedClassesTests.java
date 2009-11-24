package com.sap.runlet.expressionpad.tests;

import com.sap.runlet.abstractexpressionpad.Evaluator.ExecuteResult;
import com.sap.runlet.abstractinterpreter.objects.MultiValuedObject;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.abstractinterpreter.util.Fraction;
import com.sap.runlet.interpreter.objects.ValueObject;

import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.TypeDefinition;


public class ObjectParameterizedClassesTests extends RunletTestCase {
    
    public void testInitializationConversion() throws Exception {
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "OPC1|1| o1 = value OPC1|2|()",
            "OPC1|2| o2 = value OPC1|2|()",
            "o1.n()",
            "o2.n()");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(4, result.length);
        assertEquals(0, errors.length);
        
        assertNOEquals(new Fraction(1), result[2]);
        assertNOEquals(new Fraction(2), result[3]);
    }

    public void testAssignmentConversion() throws Exception {
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "OPC1|1| o1",
            "o1 = value OPC1|2|()",
            "o1.n()");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(3, result.length);
        assertEquals(0, errors.length);
        
        assertNOEquals(new Fraction(1), result[2]);
    }
    
    public void testMultiObjectConversion() throws Exception {
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "OPC1|2|[] o2s",
            "o2s = o2s->including(value OPC1|2|())",
            "o2s = o2s->including(value OPC1|2|())",
            "o2s = o2s->including(value OPC1|2|())",
            "OPC1|1|[] o1s = o2s",
            "o1s.n()");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(6, result.length);
        assertEquals(0, errors.length);
        
        assertTrue(result[5] instanceof MultiValuedObject);
        for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> ro : result[5]) {
            assertTrue(ro instanceof ValueObject);
            ValueObject vo = (ValueObject) ro;
            assertNOEquals(new Fraction(1), vo);
        }
    }
    
    public void testObjectParameterizedFeatureInOPC() throws Exception {
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "var o=value OPCWithFeature|2|(feature: value OPC1|3|())",
            "o.feature.n()");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(2, result.length);
        assertEquals(0, errors.length);
        
        assertNOEquals(new Fraction(2), result[1]);
    }

    public void testOptionalObjectParameters() throws Exception {
        ExecuteResult<AssociationEnd, TypeDefinition, ClassTypeDefinition> executeResult = main.execute(
            "var o=value OPCWithOptional()",
            "o.getPrecision()",
            "o.getRoundingRule()",
            "OPCWithOptional|1| o2",
            "o2=o",
            "o2.getPrecision()");
        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();
        String[]      errors = executeResult.getErrors();
        assertEquals(6, result.length);
        assertEquals(0, errors.length);

        assertNOEquals(new Fraction(-1), result[1]);
        assertNOEquals(new Fraction(0), result[2]);
        assertNOEquals(new Fraction(1), result[5]);
    }
}
