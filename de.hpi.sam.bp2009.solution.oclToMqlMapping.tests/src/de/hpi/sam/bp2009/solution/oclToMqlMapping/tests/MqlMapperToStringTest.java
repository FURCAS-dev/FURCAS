package de.hpi.sam.bp2009.solution.oclToMqlMapping.tests;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.IteratorExp;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;
import org.junit.Test;

import de.hpi.sam.bp2009.solution.oclToMqlMapping.impl.MappingOCL;
import de.hpi.sam.bp2009.solution.oclToMqlMapping.impl.MqlMapperToString;
import de.hpi.sam.petriNet.PetriNetPackage;

public class MqlMapperToStringTest extends TestCase {
    private String expressionStringComplete;
    private OCLExpression oclexpressionComplete;
    private de.hpi.sam.bp2009.solution.oclToMqlMapping.impl.MqlMapperToString fixture;
    private String expressionStringBody;
    private OCLExpression oclexpressionBody;
    private String expressionStringCollectNavigation;
    private OCLExpression oclexpressionCompleteNav;
    private OCLExpression oclexpressionBodyNav;
    private String expressionStringCollectBody;
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        
        expressionStringComplete = "Place.allInstances()->select(p : Place| p.noTokens = 2)";
        expressionStringBody = "p.noTokens=2";
        expressionStringCollectNavigation ="Place.allInstances()->collect(p|p.outgoingArcs)";
        expressionStringCollectBody="p.outgoingArcs";

        MappingOCL ocl = MappingOCL.newInstance();
        Helper oclhelper=(Helper) ocl.createOCLHelper();
        Map<EClass, Set<EObject>> map = new HashMap<EClass, Set<EObject>>();
        ocl.setExtentMap(map);
        oclhelper.setContext(PetriNetPackage.eINSTANCE.getPetriNet());
        
        try {
                oclexpressionComplete = oclhelper.createQuery(expressionStringComplete);
                oclexpressionBody= (OCLExpression) ((IteratorExp)oclexpressionComplete).getBody();
                oclexpressionCompleteNav =oclhelper.createQuery(expressionStringCollectNavigation);
                oclexpressionBodyNav= (OCLExpression) ((IteratorExp)oclexpressionCompleteNav).getBody();


        } catch (ParserException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        fixture= new MqlMapperToString(ocl.getEnvironment(), ocl.getEvaluationEnvironment(), ocl.getExtentMap());
          }
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        expressionStringBody=null;
        oclexpressionBody=null;
        expressionStringComplete=null;
        oclexpressionComplete=null;
        expressionStringCollectNavigation= null;
        expressionStringCollectBody=null;
        oclexpressionCompleteNav=null;
        oclexpressionBodyNav=null;
    }
    @Test
    public void testVisitExpressionComplete() {
       fixture.visitExpression(oclexpressionComplete);
       assertTrue(fixture.wasErrorful());
    }
    @Test
    public void testVisitExpressionBody() {
       Object r=fixture.visitExpression(oclexpressionBody);
       assertFalse(fixture.wasErrorful());
       assertEquals(expressionStringBody, r);
    }
    @Test
    public void testVisitExpressionCompleteNav() {
        //TODO
       fixture.visitExpression(oclexpressionCompleteNav);
       assertTrue(fixture.wasErrorful());
    }
    @Test
    public void testVisitExpressionBodyNav() {
        //TODO
        Object r= fixture.visitExpression(oclexpressionBodyNav);
        assertFalse(fixture.wasErrorful());
        assertEquals(expressionStringCollectBody, r);
    }

}
