package de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation.tests;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.LetExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.PropertyCallExp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.classes.ClassesFactory;
import data.classes.ClassesPackage;
import data.classes.SapClass;
import de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation.PartialEvaluator;
import de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation.ValueNotFoundException;
import de.hpi.sam.bp2009.solution.impactAnalyzer.filterSynthesis.FilterSynthesisImpl;

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
    public void testSimplePartialEvaluate() throws ParserException {
        evaluator.getHelper().setContext(ClassesPackage.eINSTANCE.getSapClass());
        OCLExpression expression = evaluator.getHelper().createQuery("self.name");
        assertTrue(expression instanceof PropertyCallExp);
        PropertyCallExp pce = (PropertyCallExp) expression;
        SapClass c = ClassesFactory.eINSTANCE.createSapClass();
        c.setName("Humba");
        Object result = evaluator.evaluate(c, pce, c);
        assertEquals(c.getName(), result);
    }

    @Test
    public void testPartialEvaluateAccessingUndefinedVariable() throws ParserException {
        evaluator.getHelper().setContext(ClassesPackage.eINSTANCE.getSapClass());
        OCLExpression expression = evaluator.getHelper().createQuery("let x:Integer=1 in self.name.size() + x");
        assertTrue(expression instanceof LetExp);
        LetExp letExp = (LetExp) expression;
        OperationCallExp oce = (OperationCallExp) letExp.getIn();
        SapClass c = ClassesFactory.eINSTANCE.createSapClass();
        c.setName("Humba");
        try {
            evaluator.evaluate(c, oce, c.getName().length());
            fail("Expected ValueNotFoundException");
        } catch (ValueNotFoundException e) {
            // this is what we expected
        }
    }

    @Test
    public void testPartialEvaluateAccessingUndefinedSelfVariable() throws ParserException {
        evaluator.getHelper().setContext(ClassesPackage.eINSTANCE.getSapClass());
        OCLExpression expression = evaluator.getHelper().createQuery(
                "self.ownedSignatures->select(name='abc')->any(true).name.size() + self.name.size()");
        assertTrue(expression instanceof OperationCallExp);
        OperationCallExp oce = (OperationCallExp) expression;
        try {
            evaluator.evaluate(null, oce, 3);
            fail("Expected ValueNotFoundException");
        } catch (ValueNotFoundException e) {
            // this is what we expected
        }
    }

    @Test
    public void testNoEffectForTrivialExpression() throws ParserException {
        evaluator.getHelper().setContext(ClassesPackage.eINSTANCE.getSapClass());
        ResourceSet rs = new ResourceSetImpl();
        OCLExpression expression = evaluator.getHelper().createQuery(
                "self.name.size()");
        rs.getResources().add(expression.eResource());
        assertTrue(expression instanceof OperationCallExp);
        OperationCallExp oce = (OperationCallExp) expression;
        FilterSynthesisImpl mapper = new FilterSynthesisImpl(expression, /* notifyNewContextElements */ false);
        assertTrue(evaluator.hasNoEffectOnOverallExpression(oce, "Humba", "Trala", mapper));
        assertFalse(evaluator.hasNoEffectOnOverallExpression(oce, "Humba", "Humba Humba", mapper));
    }
}
