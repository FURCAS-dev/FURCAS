package de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation.tests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import junit.framework.TestCase;
import modelmanagement.ModelmanagementPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.CallExp;
import org.eclipse.ocl.ecore.IfExp;
import org.eclipse.ocl.ecore.IterateExp;
import org.eclipse.ocl.ecore.IteratorExp;
import org.eclipse.ocl.ecore.LetExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.PropertyCallExp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.emf.ocl.oclwithhiddenopposites.expressions.OppositePropertyCallExp;
import company.CompanyFactory;
import company.CompanyPackage;
import company.Department;
import company.Division;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.ClassesFactory;
import data.classes.ClassesPackage;
import data.classes.MethodSignature;
import data.classes.Parameter;
import data.classes.SapClass;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications.BenchmarkNotificationPreparer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.OCLExpressionFromClassTcsPicker;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.OCLExpressionWithContext;
import de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation.PartialEvaluator;
import de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation.ValueNotFoundException;
import de.hpi.sam.bp2009.solution.impactAnalyzer.filterSynthesis.FilterSynthesisImpl;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerImpl;
import de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser;
import de.hpi.sam.bp2009.solution.oclToAst.OclToAstFactory;

public class PartialEvaluatorTest extends TestCase {
    private PartialEvaluator evaluator;

    @Override
    @Before
    public void setUp() {
        evaluator = new PartialEvaluator();
    }

    @Override
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
        assertTrue(evaluator.hasNoEffectOnOverallExpression((OCLExpression) oce.getSource(), "Humba", "Trala", mapper));
        assertFalse(evaluator.hasNoEffectOnOverallExpression((OCLExpression) oce.getSource(), "Humba", "Humba Humba", mapper));
    }

    @Test
    public void testNoEffectForFullValuesOfSelectSource() throws ParserException {
        evaluator.getHelper().setContext(ClassesPackage.eINSTANCE.getSapClass());
        MethodSignature ms = ClassesFactory.eINSTANCE.createMethodSignature();
        ms.setName("def");
        ResourceSet rs = new ResourceSetImpl();
        OCLExpression expression = evaluator.getHelper().createQuery("self.ownedSignatures->select(name='abc')");
        rs.getResources().add(expression.eResource());
        assertTrue(expression instanceof IteratorExp);
        IteratorExp iteratorExp = (IteratorExp) expression;
        FilterSynthesisImpl mapper = new FilterSynthesisImpl(expression, /* notifyNewContextElements */false);
        assertTrue(evaluator.hasNoEffectOnOverallExpression((OCLExpression) iteratorExp.getSource(), Collections.EMPTY_SET,
                Collections.singleton(ms), mapper));
        ms.setName("abc");
        assertFalse(evaluator.hasNoEffectOnOverallExpression((OCLExpression) iteratorExp.getSource(), Collections.EMPTY_SET,
                Collections.singleton(ms), mapper));
    }

    @Test
    public void testNoEffectForDeltaOfSelectSource() throws ParserException {
        evaluator.getHelper().setContext(ClassesPackage.eINSTANCE.getSapClass());
        Parameter p = ClassesFactory.eINSTANCE.createParameter();
        p.setName("def");
        ResourceSet rs = new ResourceSetImpl();
        // the following expresssion becomes self.ownedSignatures->collect(s | s.input)->select(name='abc')
        OCLExpression expression = evaluator.getHelper().createQuery("self.ownedSignatures.input->select(name='abc')");
        rs.getResources().add(expression.eResource());
        assertTrue(expression instanceof IteratorExp);
        IteratorExp selectExp = (IteratorExp) expression; // select
        IteratorExp collectExp = (IteratorExp) selectExp.getSource();
        PropertyCallExp inputPropertyCallExp = (PropertyCallExp) collectExp.getBody(); // s.input->select(...)
        FilterSynthesisImpl mapper = new FilterSynthesisImpl(expression, /* notifyNewContextElements */false);
        assertTrue(evaluator.hasNoEffectOnOverallExpression(inputPropertyCallExp, Collections.EMPTY_SET,
                Collections.singleton(p), mapper));
        p.setName("abc");
        assertFalse(evaluator.hasNoEffectOnOverallExpression(inputPropertyCallExp, Collections.EMPTY_SET,
                Collections.singleton(p), mapper));
    }

    @Test
    public void testNoEffectForDeltaOfDelegatesToPart() throws ParserException {
        evaluator.getHelper().setContext(ClassesPackage.eINSTANCE.getSapClass());
        SapClass c1 = ClassesFactory.eINSTANCE.createSapClass();
        c1.setName("c1");
        SapClass c2 = ClassesFactory.eINSTANCE.createSapClass();
        c2.setName("c2");
        ClassTypeDefinition ctdc1 = ClassesFactory.eINSTANCE.createClassTypeDefinition();
        ctdc1.setClazz(c1);
        ClassTypeDefinition ctdc2 = ClassesFactory.eINSTANCE.createClassTypeDefinition();
        ctdc2.setClazz(c2);
        Association assoc = ClassesFactory.eINSTANCE.createAssociation();
        assoc.setName("assoc");
        AssociationEnd ae1 = ClassesFactory.eINSTANCE.createAssociationEnd();
        ae1.setName("ae1");
        ae1.setType(ctdc1);
        AssociationEnd ae2 = ClassesFactory.eINSTANCE.createAssociationEnd();
        ae2.setName("ae2");
        ae2.setType(ctdc2);
        assoc.getEnds().add(ae1);
        assoc.getEnds().add(ae2);
        ResourceSet rs = new ResourceSetImpl();
        // the following expresssion becomes self.ownedSignatures->collect(s | s.input)->select(name='abc')
        OCLExpression expression = evaluator.getHelper().createQuery("self.getAssociationEnds().otherEnd()->select(delegation->notEmpty()).type.clazz->reject(c|c=self)->asSet()");
        FilterSynthesisImpl mapper = new FilterSynthesisImpl(expression, /* notifyNewContextElements */false);
        OperationCallExp getAssociationEnds = ((OperationCallExp) ((IteratorExp) ((IteratorExp) ((IteratorExp) ((IteratorExp) ((IteratorExp) ((CallExp) expression) /*asSet*/.getSource())/*reject*/.getSource())/*collect(clazz)*/.getSource())/*collect(type)*/.getSource())/*select(delegation->notEmpty())*/.getSource())/*collect(otherEnd())*/.getSource())/*self.getAssociationEnds()*/;
        // getAssociationEnds(): self.elementsOfType->collect(associationEnd->asSet())->asSet()
        OCLExpression getAssociationEndsBody = mapper.getBodyForCall(getAssociationEnds);
        PropertyCallExp selfElementsOfType = (PropertyCallExp) ((IteratorExp) ((OperationCallExp) getAssociationEndsBody).getSource())/*collect*/.getSource();
        rs.getResources().add(expression.eResource());
        assertTrue(evaluator.hasNoEffectOnOverallExpression(selfElementsOfType, Collections.EMPTY_SET,
                Collections.singleton(ctdc1), mapper));
        ae2.setDelegation(ClassesFactory.eINSTANCE.createDelegation());
        assertFalse(evaluator.hasNoEffectOnOverallExpression(selfElementsOfType, Collections.EMPTY_SET,
                Collections.singleton(ctdc1), mapper));
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

    @Test
    public void testAtPreEvaluationWithSingleRemoveFromReferenceWithOrdering() throws ParserException {
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
                    Iterator<?> i = ((Collection<?>) result).iterator();
                    testResult[0] = result instanceof Collection<?> && ((Collection<?>) result).size() == 2
                            && "sig1".equals(((MethodSignature) i.next()).getName())
                            && "sig2".equals(((MethodSignature) i.next()).getName());
                } catch (ParserException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        c.getOwnedSignatures().remove(signature1);
        assertTrue(testResult[0]);
        assertEquals(1, c.getOwnedSignatures().size());
        assertFalse(c.getOwnedSignatures().contains(signature1));
        assertTrue(c.getOwnedSignatures().contains(signature2));
        assertEquals("sig2", c.getOwnedSignatures().iterator().next().getName());
    }

    @Test
    public void testAtPreEvaluationWithMove() throws ParserException {
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
                    Iterator<?> i = ((Collection<?>) result).iterator();
                    testResult[0] = result instanceof Collection<?> && ((Collection<?>) result).size() == 2
                            && "sig1".equals(((MethodSignature) i.next()).getName())
                            && "sig2".equals(((MethodSignature) i.next()).getName());
                } catch (ParserException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        c.getOwnedSignatures().move(1, signature1);
        assertTrue(testResult[0]);
        assertEquals(2, c.getOwnedSignatures().size());
        assertEquals(0, c.getOwnedSignatures().indexOf(signature2));
        assertEquals(1, c.getOwnedSignatures().indexOf(signature1));
    }

    @Test
    public void testAtPreEvaluationWithSetName() throws ParserException {
        final SapClass c = ClassesFactory.eINSTANCE.createSapClass();
        final boolean testResult[] = new boolean[1];
        c.eAdapters().add(new AdapterImpl() {
            @Override
            public void notifyChanged(Notification n) {
                try {
                    final ResourceSet rs = new ResourceSetImpl();
                    PartialEvaluator myEvaluator = new PartialEvaluator(n);
                    myEvaluator.getHelper().setContext(ClassesPackage.eINSTANCE.getSapClass());
                    OCLExpression expression = myEvaluator.getHelper().createQuery("self.name");
                    rs.getResources().add(expression.eResource());
                    assertTrue(expression instanceof PropertyCallExp);
                    PropertyCallExp pce = (PropertyCallExp) expression;
                    Object result = myEvaluator.evaluate(null, pce, c);
                    testResult[0] = result == null;
                } catch (ParserException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        c.setName("MyClass");
        assertTrue(testResult[0]);
        c.getName().equals("MyClass");
    }

    @Test
    public void testAtPreEvaluationWithUnsetName() throws ParserException {
        final SapClass c = ClassesFactory.eINSTANCE.createSapClass();
        final boolean testResult[] = new boolean[1];
        c.setName("MyClass");
        c.eAdapters().add(new AdapterImpl() {
            @Override
            public void notifyChanged(Notification n) {
                try {
                    final ResourceSet rs = new ResourceSetImpl();
                    PartialEvaluator myEvaluator = new PartialEvaluator(n);
                    myEvaluator.getHelper().setContext(ClassesPackage.eINSTANCE.getSapClass());
                    OCLExpression expression = myEvaluator.getHelper().createQuery("self.name");
                    rs.getResources().add(expression.eResource());
                    assertTrue(expression instanceof PropertyCallExp);
                    PropertyCallExp pce = (PropertyCallExp) expression;
                    Object result = myEvaluator.evaluate(null, pce, c);
                    testResult[0] = result instanceof String && ((String) result).equals("MyClass");
                } catch (ParserException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        c.eUnset(ModelmanagementPackage.eINSTANCE.getNamedElement_Name());
        assertTrue(testResult[0]);
        assertNull(c.getName());
    }

    @Test
    public void testPartialEvaluationWithOppositeProperty() throws ParserException {
        final ResourceSet rs = new ResourceSetImpl();
        final Resource r = new XMIResourceImpl(URI.createURI("http://humba/trala"));
        rs.getResources().add(r);
        final Division division = CompanyFactory.eINSTANCE.createDivision();
        r.getContents().add(division);
        final Department department = CompanyFactory.eINSTANCE.createDepartment();
        division.getDepartment().add(department);
        evaluator.getHelper().setContext(CompanyPackage.eINSTANCE.getDepartment());
        OCLExpression expression = evaluator.getHelper().createQuery("self.department2division");
        rs.getResources().add(expression.eResource());
        assertTrue(expression instanceof OppositePropertyCallExp);
        OppositePropertyCallExp pce = (OppositePropertyCallExp) expression;
        Object result = evaluator.evaluate(null, pce, department);
        assertTrue(result instanceof Collection<?>);
        assertTrue(((Collection<?>) result).contains(division));
    }

    @Test
    public void testAtPreEvaluationWithSettingOppositeProperty() throws ParserException {
        final ResourceSet rs = new ResourceSetImpl();
        final Resource r = new XMIResourceImpl(URI.createURI("http://humba/trala"));
        rs.getResources().add(r);
        final Division division = CompanyFactory.eINSTANCE.createDivision();
        r.getContents().add(division);
        final Department department = CompanyFactory.eINSTANCE.createDepartment();
        r.getContents().add(department);
        final boolean testResult[] = new boolean[1];
        division.eAdapters().add(new AdapterImpl() {
            @Override
            public void notifyChanged(Notification n) {
                try {
                    PartialEvaluator myEvaluator = new PartialEvaluator(n);
                    myEvaluator.getHelper().setContext(CompanyPackage.eINSTANCE.getDepartment());
                    OCLExpression expression = myEvaluator.getHelper().createQuery("self.department2division");
                    rs.getResources().add(expression.eResource());
                    assertTrue(expression instanceof OppositePropertyCallExp);
                    OppositePropertyCallExp pce = (OppositePropertyCallExp) expression;
                    Object result = myEvaluator.evaluate(null, pce, department);
                    testResult[0] = result == null || (result instanceof Collection<?> && ((Collection<?>) result).isEmpty());
                } catch (ParserException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        division.getDepartment().add(department);
        assertTrue(testResult[0]);
        assertTrue(division.getDepartment().contains(department));
    }

    @Test
    public void testAtPreEvaluationWithUnsettingOppositeProperty() throws ParserException {
        final ResourceSet rs = new ResourceSetImpl();
        final Resource r = new XMIResourceImpl(URI.createURI("http://humba/trala"));
        rs.getResources().add(r);
        final Division division = CompanyFactory.eINSTANCE.createDivision();
        r.getContents().add(division);
        final Department department = CompanyFactory.eINSTANCE.createDepartment();
        division.getDepartment().add(department);
        final boolean testResult[] = new boolean[1];
        division.eAdapters().add(new AdapterImpl() {
            @Override
            public void notifyChanged(Notification n) {
                try {
                    PartialEvaluator myEvaluator = new PartialEvaluator(n);
                    myEvaluator.getHelper().setContext(CompanyPackage.eINSTANCE.getDepartment());
                    OCLExpression expression = myEvaluator.getHelper().createQuery("self.department2division");
                    rs.getResources().add(expression.eResource());
                    assertTrue(expression instanceof OppositePropertyCallExp);
                    OppositePropertyCallExp pce = (OppositePropertyCallExp) expression;
                    Object result = myEvaluator.evaluate(null, pce, department);
                    testResult[0] = result instanceof Collection<?> && ((Collection<?>) result).contains(division);
                } catch (ParserException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        r.getContents().add(department);
        assertTrue(testResult[0]);
        assertFalse(division.getDepartment().contains(department));
    }

    /**
     * Partially evaluate a recursive operation such that during partial evaluation a recursive call happens.
     * The source expression for which the value is provided is an operation parameter on which the recursive call
     * will take place, but with a different parameter value. This way, during the recursive call evaluating the
     * source expression for which the value was provided for the first call needs to be computed normally.
     */
    @Test
    public void testAtPreEvaluationForParameterInRecursiveOperation() throws ParserException {
        final ResourceSet rs = new ResourceSetImpl();
        final Resource r = new XMIResourceImpl(URI.createURI("http://humba/trala"));
        rs.getResources().add(r);
        final Department department = CompanyFactory.eINSTANCE.createDepartment();
        department.setBudget(100);
        r.getContents().add(department);
        Department sub = CompanyFactory.eINSTANCE.createDepartment();
        sub.setBudget(200);
        department.getSubDepartment().add(sub);
        Department subsub = CompanyFactory.eINSTANCE.createDepartment();
        subsub.setBudget(300);
        sub.getSubDepartment().add(subsub);

        evaluator.getHelper().setContext(CompanyPackage.eINSTANCE.getDepartment());
        EAnnotationOCLParser annotationsParser =OclToAstFactory.eINSTANCE.createEAnnotationOCLParser();
        OCLExpression sumBudgetBody = annotationsParser.getExpressionFromAnnotationsOf(CompanyPackage.eINSTANCE.getDepartment().getEOperations().get(1), "body");
        /* expression expected:
         * if self.subDepartment->size() >= 1 then
              self.subDepartment->iterate(department; return : Integer = 0 | return + department.sumBudget()) + self.budget
           else
              self.budget
           endif
         */
        assertTrue(sumBudgetBody instanceof IfExp);
        IfExp ifExp = (IfExp) sumBudgetBody;
        IterateExp selfSubDepartment_Iterate =
          (IterateExp) ((OperationCallExp) ifExp.getThenExpression()) // iterate+self.budget
            .getSource();   // self.subDepartment->iterate(...)
        Object result = evaluator.evaluate(null, selfSubDepartment_Iterate, Collections.singletonList(department));
        assertEquals(600, result);
    }

    // TODO Test case needs a meaningful name
    @Test
    public void testDeltaPropagationEndsInEndlessRecursion() throws ParserException{
	OCLExpressionWithContext ocl = new OCLExpressionFromClassTcsPicker().pickUpExpression(5);
	System.out.println(ocl.getExpression());
	Notification notification =((ArrayList<Notification>)BenchmarkNotificationPreparer.prepareRealWorldReplayNotification()).get(2);
	System.out.println(notification);

	new ImpactAnalyzerImpl(ocl.getExpression(), ocl.getContext()).getContextObjects(notification);
    }

    // TODO add a test case that computes delegatesTo() and pass old and new value for self.elementsOfType
    // (getAssociationEnds()) and for association.ends (otherEnd()) with a suitable test model that does
    // not use delegation on either association end
}
