package de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation.tests;

import java.util.Collection;
import java.util.Collections;

import junit.framework.TestCase;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.CallExp;
import org.eclipse.ocl.ecore.IteratorExp;
import org.eclipse.ocl.ecore.LetExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.PropertyCallExp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.classes.ClassesFactory;
import data.classes.ClassesPackage;
import data.classes.MethodSignature;
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
        OCLExpression expression = evaluator.getHelper().createQuery("self.name.size()");
        rs.getResources().add(expression.eResource());
        assertTrue(expression instanceof OperationCallExp);
        OperationCallExp oce = (OperationCallExp) expression;
        FilterSynthesisImpl mapper = new FilterSynthesisImpl(expression, /* notifyNewContextElements */false);
        assertTrue(evaluator.hasNoEffectOnOverallExpression(oce, "Humba", "Trala", mapper));
        assertFalse(evaluator.hasNoEffectOnOverallExpression(oce, "Humba", "Humba Humba", mapper));
    }

    @Test
    public void testSimpleAtPreEvaluation() throws ParserException {
        final MethodSignature signature = ClassesFactory.eINSTANCE.createMethodSignature();
        signature.setName("oldM");
        final boolean testResult[] = new boolean[1];
        signature.eAdapters().add(new AdapterImpl() {
            @Override
            public void notifyChanged(Notification n) {
                try {
                    final ResourceSet rs = new ResourceSetImpl();
                    PartialEvaluator myEvaluator = new PartialEvaluator(n);
                    myEvaluator.getHelper().setContext(ClassesPackage.eINSTANCE.getSapClass());
                    OCLExpression expression = myEvaluator.getHelper().createQuery("self.ownedSignatures.name");
                    rs.getResources().add(expression.eResource());
                    assertTrue(expression instanceof CallExp);
                    final CallExp pce = (CallExp) expression;
                    Object result = myEvaluator.evaluate(null, pce, Collections.singleton(signature));
                    testResult[0] = result instanceof Collection<?> && ((Collection<?>) result).size() > 0
                            && "oldM".equals(((Collection<?>) result).iterator().next());
                } catch (ParserException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        signature.setName("newM");
        assertTrue(testResult[0]);
        assertEquals("newM", signature.getName());
    }

    @Test
    public void testAtPreEvaluationWithSingleAddToReference() throws ParserException {
        final MethodSignature signature1 = ClassesFactory.eINSTANCE.createMethodSignature();
        signature1.setName("sig1");
        final MethodSignature signature2 = ClassesFactory.eINSTANCE.createMethodSignature();
        signature2.setName("sig2");
        final SapClass c = ClassesFactory.eINSTANCE.createSapClass();
        c.getOwnedSignatures().add(signature1);
        final boolean testResult[] = new boolean[1];
        c.eAdapters().add(new AdapterImpl() {
            @Override
            public void notifyChanged(Notification n) {
                try {
                    final ResourceSet rs = new ResourceSetImpl();
                    PartialEvaluator myEvaluator = new PartialEvaluator(n);
                    myEvaluator.getHelper().setContext(ClassesPackage.eINSTANCE.getSapClass());
                    OCLExpression expression = myEvaluator.getHelper().createQuery("self.ownedSignatures.name");
                    rs.getResources().add(expression.eResource());
                    assertTrue(expression instanceof IteratorExp);
                    IteratorExp ie = (IteratorExp) expression;
                    PropertyCallExp pce = (PropertyCallExp) ie.getSource(); // self.ownedSignatures
                    Object result = myEvaluator.evaluate(null, pce, c);
                    testResult[0] = ((Collection<?>) result).size() == 1
                            && "sig1".equals(((MethodSignature) ((Collection<?>) result).iterator().next()).getName());
                } catch (ParserException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        c.getOwnedSignatures().add(signature2);
        assertTrue(testResult[0]);
        assertTrue(c.getOwnedSignatures().contains(signature1));
        assertTrue(c.getOwnedSignatures().contains(signature2));
        assertEquals(2, c.getOwnedSignatures().size());
    }

    @Test
    public void testAtPreEvaluationWithSingleRemoveFromReference() throws ParserException {
        final MethodSignature signature1 = ClassesFactory.eINSTANCE.createMethodSignature();
        signature1.setName("sig1");
        final MethodSignature signature2 = ClassesFactory.eINSTANCE.createMethodSignature();
        signature2.setName("sig2");
        final SapClass c = ClassesFactory.eINSTANCE.createSapClass();
        c.getOwnedSignatures().add(signature1);
        c.getOwnedSignatures().add(signature2);
        final boolean testResult[] = new boolean[1];
        c.eAdapters().add(new AdapterImpl() {
            @Override
            public void notifyChanged(Notification n) {
                try {
                    final ResourceSet rs = new ResourceSetImpl();
                    PartialEvaluator myEvaluator = new PartialEvaluator(n);
                    myEvaluator.getHelper().setContext(ClassesPackage.eINSTANCE.getSapClass());
                    OCLExpression expression = myEvaluator.getHelper().createQuery("self.ownedSignatures.name");
                    rs.getResources().add(expression.eResource());
                    assertTrue(expression instanceof IteratorExp);
                    IteratorExp ie = (IteratorExp) expression;
                    PropertyCallExp pce = (PropertyCallExp) ie.getSource(); // self.ownedSignatures
                    Object result = myEvaluator.evaluate(null, pce, c);
                    boolean foundSig1 = false;
                    boolean foundSig2 = false;
                    for (Object o : (Collection<?>) result) {
                        MethodSignature ms = (MethodSignature) o;
                        foundSig1 = foundSig1 || "sig1".equals(ms.getName());
                        foundSig2 = foundSig2 || "sig2".equals(ms.getName());
                    }
                    testResult[0] = result instanceof Collection<?> && ((Collection<?>) result).size() == 2
                            && foundSig1 && foundSig2;
                } catch (ParserException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        c.getOwnedSignatures().remove(signature2);
        assertTrue(testResult[0]);
        assertEquals(1, c.getOwnedSignatures().size());
        assertTrue(c.getOwnedSignatures().contains(signature1));
        assertFalse(c.getOwnedSignatures().contains(signature2));
        assertEquals("sig1", c.getOwnedSignatures().iterator().next().getName());
    }

    // TODO add a test case that computes delegatesTo() and pass old and new value for self.elementsOfType
    // (getAssociationEnds()) and for association.ends (otherEnd()) with a suitable test model that does
    // not use delegation on either association end

    // FIXME Issue with recursive operations may exist: if the sourceExpression belongs to the body of a recursive operation and
    // evaluating it performs a recursive call and the source expression may depend on operation parameters or the self object
    // then the sourceExpressionValue must not be used during recursive evaluation. First produce this error in a failing test
    // case, then fix.

}
