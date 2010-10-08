/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.validation;

import static junit.framework.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.sap.furcas.metamodel.TCS.OperatorList;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.SemanticErrorBucket;
import com.sap.furcas.parsergenerator.tcs.t2m.validation.OperatorListValidation;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.ConcreteSyntaxStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.OperatorListStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.OperatorStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.PriorityStub;


/**
 *
 */
public class OperatorListValidationTest {

    @Test
    public void testEmpty() throws Exception {
        OperatorListValidation validator = new OperatorListValidation();
        
        ConcreteSyntaxStub syntaxStub = new ConcreteSyntaxStub();
        SemanticErrorBucket errorBucket = new SemanticErrorBucket();
        
        validator.validate(syntaxStub, null, errorBucket);
        assertEquals(0, errorBucket.getErrors().size());
        
        
        List<OperatorList> opListList = new ArrayList<OperatorList>();
        syntaxStub.operatorListList = opListList;
        
        validator.validate(syntaxStub, null, errorBucket);
        assertEquals(0, errorBucket.getErrors().size());
        
        
        OperatorListStub opList = new OperatorListStub();
        opListList.add(opList );
        
        validator.validate(syntaxStub, null, errorBucket);
        assertEquals(0, errorBucket.getErrors().size());
        
        List<Priority> prioList = new ArrayList<Priority>();
        opList.priorities = prioList;
        
        validator.validate(syntaxStub, null, errorBucket);
        assertEquals(0, errorBucket.getErrors().size());
    }
    
    @Test
    public void testOnePriority() throws Exception {
        // setup
        List<Priority> prioList = new ArrayList<Priority>();
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
        List<Priority> prioList = new ArrayList<Priority>();
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
        List<OperatorList> opListList = new ArrayList<OperatorList>();
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
        List<OperatorList> opListList = new ArrayList<OperatorList>();
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
        List<OperatorList> opListList = new ArrayList<OperatorList>();
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
        List<Priority> prioList = new ArrayList<Priority>();
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
        List<Priority> prioList = new ArrayList<Priority>();
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
        List<Priority> prioList = new ArrayList<Priority>();
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
        List<Priority> prioList = new ArrayList<Priority>();
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
    private ConcreteSyntaxStub getSyntaxStub(List<Priority> prioList) {
        ConcreteSyntaxStub syntaxStub = new ConcreteSyntaxStub();
        List<OperatorList> opListList = new ArrayList<OperatorList>();
        syntaxStub.operatorListList = opListList;
        OperatorListStub opList = new OperatorListStub();
        opListList.add(opList );

        opList.priorities = prioList;
        return syntaxStub;
    }
    

    
}
