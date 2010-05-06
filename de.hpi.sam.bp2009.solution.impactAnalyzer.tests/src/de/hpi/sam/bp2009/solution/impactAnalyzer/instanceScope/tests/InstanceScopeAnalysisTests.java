/**
 * 
 */
package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.tests;

import static org.junit.Assert.fail;
import junit.framework.TestCase;

import org.easymock.EasyMock;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.utilities.AbstractVisitor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.AssociationEndAndAttributeCallFinder;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.InstanceScopeAnalysis;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.PathCache;
import de.hpi.sam.bp2009.solution.impactAnalyzer.tests.helper.BaseDepartmentTest;

/**
 * @author martin.hanysz
 *
 */
public class InstanceScopeAnalysisTests extends BaseDepartmentTest {
    /**
     * This Class renames the EasyMock extension that mocks classes to avoid the name collision.
     * @author martin.hanysz
     *
     */
    private class ClassMock extends org.easymock.classextension.EasyMock{}
    private PathCache pathCacheMock;
//    private OCLExpression<EClassifier> oclExpressionMock;
//    private AssociationEndAndAttributeCallFinder visitorMock;

    @SuppressWarnings("unchecked") // EasyMock cant't handle generic types
    @Before
    public void setUp() {   
        super.setUp();
        pathCacheMock = ClassMock.createMock(PathCache.class);
//        oclExpressionMock = ClassMock.createMock(OCLExpression.class);
//        visitorMock = ClassMock.createMock(AssociationEndAndAttributeCallFinder.class);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test method for {@link de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.InstanceScopeAnalysis#InstanceScopeAnalysis(org.eclipse.ocl.expressions.OCLExpression, de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.PathCache)}.
     */
    @Test
    public void testInstanceScopeAnalysisArguments() {
        InstanceScopeAnalysis isa;
//        ClassMock.expect(oclExpressionMock.accept(visitorMock)).andReturn(EcoreFactory.eINSTANCE.createEPackage());
//        ClassMock.replay(oclExpressionMock);
        try{
            isa = new InstanceScopeAnalysis(null, null);
            fail("Should produce IllegalArgumentException");
        }catch (IllegalArgumentException e){}
        try{
            isa = new InstanceScopeAnalysis(null, pathCacheMock);
            fail("Should produce IllegalArgumentException");
        }catch (IllegalArgumentException e){}
        try{
            isa = new InstanceScopeAnalysis(this.maxJuniorsAST, null);
            fail("Should produce IllegalArgumentException");
        }catch (IllegalArgumentException e){}
        
        isa = new InstanceScopeAnalysis(this.maxJuniorsAST, pathCacheMock);
    }

    /**
     * Test method for {@link de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.InstanceScopeAnalysis#getContextObjects(org.eclipse.emf.common.notify.Notification, org.eclipse.ocl.expressions.OCLExpression, org.eclipse.emf.ecore.EClass)}.
     */
    @Test
    public void testGetContextObjects() {
        fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.InstanceScopeAnalysis#isUnaffectedDueToPrimitiveAttributeValueComparisonWithLiteralOnly(java.util.List, java.lang.String)}.
     */
    @Test
    public void testIsUnaffectedDueToPrimitiveAttributeValueComparisonWithLiteralOnly() {
        fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.InstanceScopeAnalysis#getAllPossibleContextInstances(de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject, org.eclipse.emf.ecore.EClass)}.
     */
    @Test
    public void testGetAllPossibleContextInstances() {
        fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.InstanceScopeAnalysis#getTracer(org.eclipse.ocl.expressions.OCLExpression)}.
     */
    @Test
    public void testGetTracer() {
        fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.InstanceScopeAnalysis#getDefines(org.eclipse.ocl.expressions.OCLExpression)}.
     */
    @Test
    public void testGetDefines() {
        fail("Not yet implemented"); // TODO
    }

}
