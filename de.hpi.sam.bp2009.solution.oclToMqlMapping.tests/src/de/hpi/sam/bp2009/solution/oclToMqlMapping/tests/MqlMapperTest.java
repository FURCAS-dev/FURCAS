package de.hpi.sam.bp2009.solution.oclToMqlMapping.tests;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

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
import org.eclipse.ocl.ecore.IteratorExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.junit.Test;

import de.hpi.sam.bp2009.solution.oclToMqlMapping.impl.MappingEvaluationVisitor;
import de.hpi.sam.bp2009.solution.oclToMqlMapping.impl.MappingOCL;
import de.hpi.sam.bp2009.solution.oclToMqlMapping.impl.MqlMapperToString;
import de.hpi.sam.petriNet.PetriNetPackage;


public class MqlMapperTest extends TestCase {
 
    private OCLExpression oclexpressionComplete;
    private MappingEvaluationVisitor<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject>  fixture;
    private OCLExpression oclexpressionBody;
    private String expressionStringCollectAttribute;
    private String expressionStringCollectNavigation;
    private OCLExpression oclexpressionCompleteNav;
    private OCLExpression oclexpressionBodyNav;
    private Object statementAtt = null;
    private Object statementNav = null;
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        
        expressionStringCollectAttribute = "Place.allInstances()->collect(p : Place| p.noTokens)";
        expressionStringCollectNavigation ="Place.allInstances()->collect(p : Place| p.outgoingArcsArc)";
        
        MappingOCL ocl = MappingOCL.newInstance();
        Helper oclhelper=(Helper) ocl.createOCLHelper();
        Map<EClass, Set<EObject>> map = new HashMap<EClass, Set<EObject>>();
        ocl.setExtentMap(map);
        oclhelper.setContext(PetriNetPackage.eINSTANCE.getPetriNet());
        
        try {
                oclexpressionComplete = oclhelper.createQuery(expressionStringCollectAttribute);
                oclexpressionBody= (OCLExpression) ((IteratorExp)oclexpressionComplete).getBody();
                oclexpressionCompleteNav =oclhelper.createQuery(expressionStringCollectNavigation);
                oclexpressionBodyNav= (OCLExpression) ((IteratorExp)oclexpressionCompleteNav).getBody();
                

                
        } catch (ParserException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        fixture= new MappingEvaluationVisitor<EPackage, EClassifier, EOperation, EStructuralFeature,
        EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> 
        (ocl.getEnvironment(), ocl.getEvaluationEnvironment(), ocl.getExtentMap());
          }
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        oclexpressionBody=null;
        expressionStringCollectAttribute=null;
        expressionStringCollectNavigation=null;
        oclexpressionComplete=null;
        oclexpressionCompleteNav=null;
        oclexpressionBodyNav=null;
    }
    @Test
    public void testVisitExpressionComplete() {
       fixture.visitExpression(oclexpressionComplete);
//       statementAtt = ocl.evaluate(PetriNetPackage.eINSTANCE.getPetriNet(), oclexpressionComplete);
//       
//       assert
    }
    @Test
    public void testVisitExpressionCompleteNav() {
       Object r=fixture.visitExpression(oclexpressionCompleteNav);
//       statementNav = ocl.evaluate(PetriNetPackage.eINSTANCE.getPetriNet(), oclexpressionCompleteNav);
    }

}

