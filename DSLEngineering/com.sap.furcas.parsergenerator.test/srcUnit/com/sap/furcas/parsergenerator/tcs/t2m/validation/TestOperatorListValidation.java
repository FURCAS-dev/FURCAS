/**
 * 
 */
package com.sap.furcas.parsergenerator.tcs.t2m.validation;

import static junit.framework.Assert.assertEquals;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.TCS.OperatorList;
import com.sap.furcas.metamodel.FURCAS.TCS.Priority;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.ConcreteSyntaxStub;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.OperatorListStub;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.OperatorStub;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.PriorityStub;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.SemanticErrorBucket;


/**
 *
 */
public class TestOperatorListValidation {

    @Test
    public void testEmpty() throws Exception {
        OperatorListValidation validator = new OperatorListValidation();
        
        ConcreteSyntaxStub syntaxStub = new ConcreteSyntaxStub();
        SemanticErrorBucket errorBucket = new SemanticErrorBucket();
        
        validator.validate(syntaxStub, null, errorBucket);
        assertEquals(0, errorBucket.getErrors().size());
        
        
        EList<OperatorList> opListList = new BasicEList<OperatorList>();
        syntaxStub.operatorListList = opListList;
        
        validator.validate(syntaxStub, null, errorBucket);
        assertEquals(0, errorBucket.getErrors().size());
        
        
        OperatorListStub opList = new OperatorListStub();
        opListList.add(opList );
        
        validator.validate(syntaxStub, null, errorBucket);
        assertEquals(0, errorBucket.getErrors().size());
        
        EList<Priority> prioList = new BasicEList<Priority>();
        opList.priorities = prioList;
        
        validator.validate(syntaxStub, null, errorBucket);
        assertEquals(0, errorBucket.getErrors().size());
    }
    
    @Test
    public void testOnePriority() throws Exception {
        // setup
        EList<Priority> prioList = new BasicEList<Priority>();
        PriorityStub prio = new PriorityStub();
        OperatorStub operator1 = new OperatorStub();
        prio.operators.add(operator1 );
        prioList.add(prio);
        ConcreteSyntaxStub syntaxStub = getSyntaxStub(prioList);
        SemanticErrorBucket errorBucket = new SemanticErrorBucket(); // not using a dummy, it's just a bean class
 
           // class under test
        OperatorListValidation validator = new OperatorListValidation();

        validator.validate(syntaxStub, null, errorBucket);
        
        assertEquals(0, errorBucket.getErrors().size());
    }
    
   
    @Test
    public void testTwoPriorities() throws Exception {
        // setup
        EList<Priority> prioList = new BasicEList<Priority>();
        PriorityStub prio2 = new PriorityStub();
        OperatorStub operator2 = new OperatorStub();
        prio2.operators.add(operator2 );
        prio2.value = 1;
        prioList.add(prio2);
        PriorityStub prio = new PriorityStub();
        OperatorStub operator1 = new OperatorStub();
        prio.operators.add(operator1 );
        prioList.add(prio);
        ConcreteSyntaxStub syntaxStub = getSyntaxStub(prioList);
        SemanticErrorBucket errorBucket = new SemanticErrorBucket(); // not using a dummy, it's just a bean class
 
           // class under test
        OperatorListValidation validator = new OperatorListValidation();

        validator.validate(syntaxStub, null, errorBucket);
        
        assertEquals(0, errorBucket.getErrors().size());
    }
    
    @Test
    public void testthreeListsDifferentName() throws Exception {
        // two anonymous lists are not allowed
        ConcreteSyntaxStub syntaxStub = new ConcreteSyntaxStub();
        SemanticErrorBucket errorBucket = new SemanticErrorBucket();
        EList<OperatorList> opListList = new BasicEList<OperatorList>();
        syntaxStub.operatorListList = opListList;
        OperatorListStub opList = new OperatorListStub();
        opList.name = "test";
        opListList.add(opList );
        OperatorListStub opList2 = new OperatorListStub();
        opList2.name = "test2";
        opListList.add(opList2 );
        
        OperatorListStub opList3 = new OperatorListStub(); // anonymous
        opListList.add(opList3 );

        // class under test
        OperatorListValidation validator = new OperatorListValidation();

        validator.validate(syntaxStub, null, errorBucket);
        
        assertEquals(0, errorBucket.getErrors().size());
    }
    
    /****** negative cases ******/
    
    
    @Test
    public void testTwoAnonymousLists() throws Exception {
        // two anonymous lists are not allowed
        ConcreteSyntaxStub syntaxStub = new ConcreteSyntaxStub();
        SemanticErrorBucket errorBucket = new SemanticErrorBucket();
        EList<OperatorList> opListList = new BasicEList<OperatorList>();
        syntaxStub.operatorListList = opListList;
        OperatorListStub opList = new OperatorListStub();
        opListList.add(opList );
        OperatorListStub opList2 = new OperatorListStub();
        opListList.add(opList2 );
        

        // class under test
        OperatorListValidation validator = new OperatorListValidation();

        validator.validate(syntaxStub, null, errorBucket);
        
        assertEquals(1, errorBucket.getErrors().size());
    }
    
    @Test
    public void testTwoListsSameName() throws Exception {
        // two anonymous lists are not allowed
        ConcreteSyntaxStub syntaxStub = new ConcreteSyntaxStub();
        SemanticErrorBucket errorBucket = new SemanticErrorBucket();
        EList<OperatorList> opListList = new BasicEList<OperatorList>();
        syntaxStub.operatorListList = opListList;
        OperatorListStub opList = new OperatorListStub();
        opList.name = "test";
        opListList.add(opList );
        OperatorListStub opList2 = new OperatorListStub();
        opList2.name = "test";
        opListList.add(opList2 );
        

        // class under test
        OperatorListValidation validator = new OperatorListValidation();

        validator.validate(syntaxStub, null, errorBucket);
        
        assertEquals(1, errorBucket.getErrors().size());
    }
    
    @Test
    public void testNegativePriority() throws Exception {
        // setup
        EList<Priority> prioList = new BasicEList<Priority>();
        PriorityStub prio = new PriorityStub();
        OperatorStub operator1 = new OperatorStub();
        prio.operators.add(operator1 );
        prio.value = -1;
        prioList.add(prio);
        ConcreteSyntaxStub syntaxStub = getSyntaxStub(prioList);
        SemanticErrorBucket errorBucket = new SemanticErrorBucket(); // not using a dummy, it's just a bean class
 
           // class under test
        OperatorListValidation validator = new OperatorListValidation();

        validator.validate(syntaxStub, null, errorBucket);
        
        assertEquals(1, errorBucket.getErrors().size());
    }
    
    @Test
    public void testDoublePriorities() throws Exception {
        // setup (using priority 0 twice)
        EList<Priority> prioList = new BasicEList<Priority>();
        PriorityStub prio2 = new PriorityStub();
        OperatorStub operator2 = new OperatorStub();
        prio2.operators.add(operator2 );
        prioList.add(prio2);
        PriorityStub prio = new PriorityStub();
        OperatorStub operator1 = new OperatorStub();
        prio.operators.add(operator1 );
        prioList.add(prio);
        ConcreteSyntaxStub syntaxStub = getSyntaxStub(prioList);
        SemanticErrorBucket errorBucket = new SemanticErrorBucket(); // not using a dummy, it's just a bean class
 
           // class under test
        OperatorListValidation validator = new OperatorListValidation();

        validator.validate(syntaxStub, null, errorBucket);
        
        // expect one error
        assertEquals(1, errorBucket.getErrors().size());
    }
    
    @Test
    public void testMissingPriority1() throws Exception {
        // setup (using values 0 and 2)
        EList<Priority> prioList = new BasicEList<Priority>();
        PriorityStub prio2 = new PriorityStub();
        OperatorStub operator2 = new OperatorStub();
        prio2.operators.add(operator2 );
        prio2.value = 2;
        prioList.add(prio2);
        PriorityStub prio = new PriorityStub();
        OperatorStub operator1 = new OperatorStub();
        prio.operators.add(operator1 );
        prioList.add(prio);
        ConcreteSyntaxStub syntaxStub = getSyntaxStub(prioList);
        SemanticErrorBucket errorBucket = new SemanticErrorBucket(); // not using a dummy, it's just a bean class
 
           // class under test
        OperatorListValidation validator = new OperatorListValidation();

        validator.validate(syntaxStub, null, errorBucket);
        
        assertEquals(1, errorBucket.getErrors().size());
    }
    
    @Test
    public void testMissingPriority0() throws Exception {
        // setup (using values 1 and 2)
        EList<Priority> prioList = new BasicEList<Priority>();
        PriorityStub prio2 = new PriorityStub();
        OperatorStub operator2 = new OperatorStub();
        prio2.operators.add(operator2 );
        prio2.value = 2;
        prioList.add(prio2);
        PriorityStub prio = new PriorityStub();
        OperatorStub operator1 = new OperatorStub();
        prio.operators.add(operator1 );
        prio.value = 1;
        prioList.add(prio);
        ConcreteSyntaxStub syntaxStub = getSyntaxStub(prioList);
        SemanticErrorBucket errorBucket = new SemanticErrorBucket(); // not using a dummy, it's just a bean class
 
           // class under test
        OperatorListValidation validator = new OperatorListValidation();

        validator.validate(syntaxStub, null, errorBucket);
        
        assertEquals(1, errorBucket.getErrors().size());
    }
    

    
    /**
     * @param prioList
     * @return
     */
    private ConcreteSyntaxStub getSyntaxStub(EList<Priority> prioList) {
        ConcreteSyntaxStub syntaxStub = new ConcreteSyntaxStub();
        EList<OperatorList> opListList = new BasicEList<OperatorList>();
        syntaxStub.operatorListList = opListList;
        OperatorListStub opList = new OperatorListStub();
        opListList.add(opList );

        opList.priorities = prioList;
        return syntaxStub;
    }
    

    
}
