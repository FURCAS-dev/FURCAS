package de.hpi.sam.bp2009.solution.oclToMqlMapping.tests;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.IterateExp;
import org.eclipse.ocl.ecore.IteratorExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.junit.Test;

import de.hpi.sam.bp2009.solution.oclToMqlMapping.impl.MappingOCL;
import de.hpi.sam.bp2009.solution.oclToMqlMapping.impl.MqlMapperToString;
import de.hpi.sam.petriNet.PetriNetPackage;

public class MqlMapperToStringTest extends TestCase {
    private String expressionStringComplete;
    private OCLExpression oclexpressionComplete;
    private de.hpi.sam.bp2009.solution.oclToMqlMapping.impl.MqlMapperToString<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject>  fixture;
    private String expressionStringBody;
    private OCLExpression oclexpressionBody;
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        
        expressionStringComplete = "Place.allInstances()->select(p : Place| p.noTokens = 2)";
        expressionStringBody = "p.noTokens = 2";

        MappingOCL ocl = MappingOCL.newInstance();
        Helper oclhelper=(Helper) ocl.createOCLHelper();
        Map<EClass, Set<EObject>> map = new HashMap<EClass, Set<EObject>>();
        ocl.setExtentMap(map);
        oclhelper.setContext(PetriNetPackage.eINSTANCE.getPetriNet());
        Object statement = null;
        try {
                oclexpressionComplete = oclhelper.createQuery(expressionStringComplete);
                oclexpressionBody= (OCLExpression) ((IteratorExp)oclexpressionComplete).getBody();

//                statement = ocl.evaluate(PetriNetPackage.eINSTANCE.getPetriNet(), oclexpression);
        } catch (ParserException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        fixture= new MqlMapperToString<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> (ocl.getEnvironment(), ocl.getEvaluationEnvironment(), ocl.getExtentMap());
          }
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        expressionStringBody=null;
        oclexpressionBody=null;
        expressionStringComplete=null;
        oclexpressionComplete=null;
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
       assertEquals("p.noTokens=2", r);
    }

}
