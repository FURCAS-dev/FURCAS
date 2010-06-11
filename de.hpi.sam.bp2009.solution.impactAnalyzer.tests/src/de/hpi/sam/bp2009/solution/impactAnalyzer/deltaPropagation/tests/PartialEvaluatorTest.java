package de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation.tests;

import junit.framework.TestCase;

import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.PropertyCallExp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.classes.ClassesFactory;
import data.classes.ClassesPackage;
import data.classes.SapClass;
import de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation.PartialEvaluator;

public class PartialEvaluatorTest extends TestCase {
    private PartialEvaluator evaluator;
    
    @Before
    public void setUp() {
        evaluator = new PartialEvaluator();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testSimplPartialEvaluate() throws ParserException {
        evaluator.getHelper().setContext(ClassesPackage.eINSTANCE.getSapClass());
        OCLExpression expression = evaluator.getHelper().createQuery("self.name");
        assertTrue(expression instanceof PropertyCallExp);
        PropertyCallExp pce = (PropertyCallExp) expression;
        SapClass c = ClassesFactory.eINSTANCE.createSapClass();
        c.setName("Humba");
        Object result = evaluator.evaluate(c, pce, c);
        assertEquals(c.getName(), result);
    }
}
