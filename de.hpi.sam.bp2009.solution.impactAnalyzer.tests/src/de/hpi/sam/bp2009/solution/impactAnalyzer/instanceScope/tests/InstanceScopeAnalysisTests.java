/**
 * 
 */
package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.tests;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.FilterSynthesisImpl;
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
    private FilterSynthesisImpl filterSynthesizerMock;
//    private OCLExpression<EClassifier> oclExpressionMock;
//    private AssociationEndAndAttributeCallFinder visitorMock;

    @Before
    public void setUp() {   
        super.setUp();
        pathCacheMock = ClassMock.createMock(PathCache.class);
        filterSynthesizerMock = EasyMock.createMock(FilterSynthesisImpl.class);
//        oclExpressionMock = ClassMock.createMock(OCLExpression.class);
//        visitorMock = ClassMock.createMock(AssociationEndAndAttributeCallFinder.class);
    }

    @After
    public void tearDown() {
        pathCacheMock = null;
        filterSynthesizerMock = null;
    }

    /**
     * Test method for {@link de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.InstanceScopeAnalysis#InstanceScopeAnalysis(org.eclipse.ocl.expressions.OCLExpression, de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.PathCache)}.
     */
    @Test
    public void testInstanceScopeAnalysisArguments() {
        String errorMsg = "Should produce IllegalArgumentException";
        InstanceScopeAnalysis isa = null;
        try{
            isa = new InstanceScopeAnalysis(null, null, filterSynthesizerMock);
            fail(errorMsg);
        }catch (IllegalArgumentException e){}
        
        try{
            isa = new InstanceScopeAnalysis(null, pathCacheMock, null);
            fail(errorMsg);
        }catch (IllegalArgumentException e){}
        
        try{
            isa = new InstanceScopeAnalysis(this.maxJuniorsAST, null, null);
            fail(errorMsg);
        }catch (IllegalArgumentException e){}
        
        try{
            isa = new InstanceScopeAnalysis(this.maxJuniorsAST, pathCacheMock, null);
            fail(errorMsg);
        }catch (IllegalArgumentException e){}
        
        try{
            isa = new InstanceScopeAnalysis(this.maxJuniorsAST, null, filterSynthesizerMock);
            fail(errorMsg);
        }catch (IllegalArgumentException e){}
        
        try{
            isa = new InstanceScopeAnalysis(null, pathCacheMock, filterSynthesizerMock);
            fail(errorMsg);
        }catch (IllegalArgumentException e){}
        
        isa = new InstanceScopeAnalysis(this.maxJuniorsAST, pathCacheMock, filterSynthesizerMock);
        assertTrue(isa != null);
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
