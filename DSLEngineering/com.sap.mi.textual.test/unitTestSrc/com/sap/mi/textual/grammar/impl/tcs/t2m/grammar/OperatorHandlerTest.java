/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar;

import static com.sap.mi.textual.test.util.RuleComparisonHelper.assertEqualTokens;
import static com.sap.mi.textual.test.util.StringListHelper.list;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import tcs.AssociativityEnum;
import tcs.Operator;
import tcs.OperatorTemplate;
import tcs.Priority;

import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.handlerStub.ANTLR3WriterStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.handlerStub.SyntaxLookupStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.handlerStub.TemplateNamingHelperStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.rules.AbstractAntlr3Rule;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.rules.ClassProductionRule;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.LiteralStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.OperatorListStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.OperatorStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.OperatorTemplateStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.PriorityStub;
import com.sap.mi.textual.moinlookup.util.TemplateNamingHelper;
import com.sap.mi.textual.tcs.util.SyntaxLookup;

/**
 * Tests the operatorHandler class.
 * Due to the complexity of the task, tests are difficult to understand. Use them mostly as regressionTests, not as documentation.
 * Just consider that the OperatorHandler's output generally are a number of rules "priority_0" to "priority_n" where n
 * is the number of priorities defined in the Syntax. And within each rule, the operatored class template rule is called on
 * the left side of the operator, and the operatorTemplate is called on the right side of the operator.
 * Also, this shall allow associativity, meaning a +b + c + d .... That's why the rulebody should loook like this
 * : classTemplate ( (Operator) OperatorTemplate ) *
 * so that the second bit can be repeated several times.
 */
public class OperatorHandlerTest {

    @BeforeClass
    public static void setup() {
        ObservationDirectivesHelper.doAddObserverParts = ObservationDirectivesHelper.NONE;
    }

    @Test
    public void testAddElement() throws Exception {
        // This test is not a real world scenario, no syntax should define an operatorList without operators
        // This test though might reveal bugs on a very basic level, so it is included.
        SyntaxLookup syntaxLookupStub = new SyntaxLookupStub();
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        // Class under test
        OperatorHandler ophandler = new OperatorHandler(writerStub, namingStub, null);

        String classTemplateName = "testClassTemplate";
        OperatorListStub opList = new OperatorListStub();

        List<Priority> prioList = new ArrayList<Priority>();
        PriorityStub priority1 = new PriorityStub();
        prioList.add(priority1);
        opList.priorities = prioList ;

        ophandler.addOperatorList(opList , classTemplateName , true);

        assertEquals(1, writerStub.rules.size());
        ClassProductionRule result = (ClassProductionRule) writerStub.rules.get(0);

        String expected = "priority_0 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);} " + 
        "  :   (ret=primary_testclasstemplate) " + 
        "{ " + 
        "this.setLocationAndComment(ret, firstToken); " +
        "ret2=ret; " + 
        " } ; " +
        "catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}";

        assertEqualTokens(expected, result.toString());
    }

    @Test
    public void testAddElementOnePriorityOneOperator() throws Exception {   
        SyntaxLookup syntaxLookupStub = new SyntaxLookupStub();
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        // Class under test
        OperatorHandler ophandler = new OperatorHandler(writerStub, namingStub, null);

        String classTemplateName = "testClassTemplate";
        
        /****** Main driver for expected result ****/
        OperatorListStub opList = getMockOperatorList(list("TestOp"));
        /******/
        
        ophandler.addOperatorList(opList , classTemplateName , true);

        assertEquals(1, writerStub.rules.size());
        ClassProductionRule result = (ClassProductionRule) writerStub.rules.get(0);

        String expected = "priority_0 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}\r\n" + 
        		"  :   ( ( ret=primary_testclasstemplate((TESTOP)=>(TESTOP {opName = \"TestOp\";}((ret=template[opName, ret, firstToken]))))*)) " + 
        		"{ " + 
        		"this.setLocationAndComment(ret, firstToken); " +
        		"ret2=ret; " + 
        		" } ; " +
        "catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}";

        assertEqualTokens(expected, result.toString());
    }
    
    @Test
    public void testAddElementOneOperatorDisambiguated() throws Exception {   
        SyntaxLookup syntaxLookupStub = new SyntaxLookupStub();
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        // Class under test
        OperatorHandler ophandler = new OperatorHandler(writerStub, namingStub, null);

        String classTemplateName = "testClassTemplate";
        
        /****** Main driver for expected result ****/
        OperatorListStub opList = getMockOperatorList(list("TestOp"));
        /******/
        OperatorStub operator = (OperatorStub) opList.priorities.get(0).getOperators().get(0);
        OperatorTemplateStub optemplate = (OperatorTemplateStub) operator.templatesList.get(0);
        optemplate.disambiguateV3 = "DISAMBIGUATE";
        
        ophandler.addOperatorList(opList , classTemplateName , true);

        assertEquals(1, writerStub.rules.size());
        ClassProductionRule result = (ClassProductionRule) writerStub.rules.get(0);

        String expected = "priority_0 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}\r\n" + 
                "  :   ( ( ret=primary_testclasstemplate((TESTOP)=>(TESTOP {opName = \"TestOp\";}((DISAMBIGUATE)=>(ret=template[opName, ret, firstToken]))))*)) " + 
                "{ " + 
                "this.setLocationAndComment(ret, firstToken); " +
                "ret2=ret; " + 
                " } ; " +
        "catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}";

        assertEqualTokens(expected, result.toString());
    }
    
   
    
    @Test
    public void testAddElementOnePriorityTwoOperators() throws Exception {   
        SyntaxLookup syntaxLookupStub = new SyntaxLookupStub();
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        // Class under test
        OperatorHandler ophandler = new OperatorHandler(writerStub, namingStub, null);

        String classTemplateName = "testClassTemplate";
        
        /****** Main driver for expected result ****/
        OperatorListStub opList = getMockOperatorList(list("TestOp", "OtherTestOp"));
        /******/
        
        ophandler.addOperatorList(opList , classTemplateName , true);

        assertEquals(1, writerStub.rules.size());
        ClassProductionRule result = (ClassProductionRule) writerStub.rules.get(0);

        String expected = "priority_0 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);} " + 
        		"  :   ( ( ret=primary_testclasstemplate((TESTOP)=>(TESTOP {opName = \"TestOp\";}((ret=template[opName, ret, firstToken]))) " + 
        		"| (OTHERTESTOP)=>(OTHERTESTOP {opName = \"OtherTestOp\";}((ret=template[opName, ret, firstToken]))))*)) " + 
        		"{ " + 
        		"this.setLocationAndComment(ret, firstToken); " +
        		"ret2=ret; " + 
        		" }  ; " +
        "catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}";

        assertEqualTokens(expected, result.toString());
    }
    
    @Test
    public void testAddElementThreePriorityTwoOperators() throws Exception {   
        SyntaxLookup syntaxLookupStub = new SyntaxLookupStub();
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        // Class under test
        OperatorHandler ophandler = new OperatorHandler(writerStub, namingStub, null);

        String classTemplateName = "testClassTemplate";
        
        /****** Main driver for expected result ****/
        OperatorListStub opList = getMockOperatorList(list("TestOp", "OtherTestOp"), list("TestOp222", "OtherTestOp222"), list("TestOp333", "OtherTestOp333"));
        /******/
        
        ophandler.addOperatorList(opList , classTemplateName , true);

        assertEquals(3, writerStub.rules.size());
       
        ClassProductionRule result = (ClassProductionRule) writerStub.rules.get(0);

        String expected = "priority_0 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);} " + 
                "  :   ( ( ret=primary_testclasstemplate((TESTOP)=>(TESTOP {opName = \"TestOp\";}((ret=template[opName, ret, firstToken]))) " + 
                "| (OTHERTESTOP)=>(OTHERTESTOP {opName = \"OtherTestOp\";}((ret=template[opName, ret, firstToken]))))*)) " + 
                "{ " + 
                "this.setLocationAndComment(ret, firstToken); " +
                "ret2=ret; " + 
                " }  ; " +
        "catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}";

        assertEqualTokens(expected, result.toString());
        
        
        // test next priority as well
        result = (ClassProductionRule) writerStub.rules.get(1);

        expected = "priority_1 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);} " + 
                "  :   ( ( ret=priority_0((TESTOP222)=>(TESTOP222 {opName = \"TestOp222\";}((ret=template[opName, ret, firstToken]))) " + 
                "| (OTHERTESTOP222)=>(OTHERTESTOP222 {opName = \"OtherTestOp222\";}((ret=template[opName, ret, firstToken]))))*)) " + 
                "{ " + 
                "this.setLocationAndComment(ret, firstToken); " +
                "ret2=ret; " + 
                " }  ; " +
        "catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}";
        assertEqualTokens(expected, result.toString());
    }

    @Test
    public void testAddElementUnary() throws Exception {
        // This test is not a real world scenario, no syntax should define an operatorList without operators
        // This test though might reveal bugs on a very basic level, so it is included.
        SyntaxLookup syntaxLookupStub = new SyntaxLookupStub();
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        // Class under test
        OperatorHandler ophandler = new OperatorHandler(writerStub, namingStub, null);

        String classTemplateName = "testClassTemplate";
        OperatorListStub opList = new OperatorListStub();

        List<Priority> prioList = new ArrayList<Priority>();
        PriorityStub priority1 = new PriorityStub();
        prioList.add(priority1);
        opList.priorities = prioList ;
        
        List<Operator> operatorsList = new ArrayList<Operator>();
        OperatorStub unaryOperator = new OperatorStub();
        unaryOperator.arity = 1;
        LiteralStub operatorLiteral = new LiteralStub();
        operatorLiteral.value = "value";
        operatorLiteral.name = "name";
        operatorLiteral.representation = "REP";
        unaryOperator.literal = operatorLiteral;
        OperatorTemplateStub opTemplate = new OperatorTemplateStub();
        opTemplate.names = list("optemplate");
        unaryOperator.templatesList.add(opTemplate );
        
        operatorsList.add(unaryOperator );
        priority1.operators = operatorsList ;

        
        ophandler.addOperatorList(opList , classTemplateName , true);

        assertEquals(1, writerStub.rules.size());
         AbstractAntlr3Rule result = writerStub.rules.get(0);

        String expected = "priority_0 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);} " + 
        		"  : " + 
        		"   (((NAME)=>(NAME {opName = \"value\";}((ret=optemplate[opName, null, firstToken]right=primary_testclasstemplate {setProperty(ret, \"null\", right); " + 
        		"this.setLocationAndComment(ret, firstToken); " + 
        		"})))) " + 
        		"| " + 
        		" ( ret=primary_testclasstemplate)) " + 
        		"{ " + 
        		"this.setLocationAndComment(ret, firstToken); " + 
        		"ret2=ret; " + 
        		" } " + 
        		"  ; " +
        "catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}";
        assertEqualTokens(expected, result.toString());
    }
    
    @Test
    public void testAddElementUnaryRightAssociative() throws Exception {
        // This test is not a real world scenario, no syntax should define an operatorList without operators
        // This test though might reveal bugs on a very basic level, so it is included.
        SyntaxLookup syntaxLookupStub = new SyntaxLookupStub();
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        // Class under test
        OperatorHandler ophandler = new OperatorHandler(writerStub, namingStub, null);

        String classTemplateName = "testClassTemplate";
        OperatorListStub opList = new OperatorListStub();

        List<Priority> prioList = new ArrayList<Priority>();
        PriorityStub priority1 = new PriorityStub();
        priority1.associativity = AssociativityEnum.RIGHT;
        prioList.add(priority1);
        opList.priorities = prioList ;
        
        List<Operator> operatorsList = new ArrayList<Operator>();
        OperatorStub unaryOperator = new OperatorStub();
        unaryOperator.arity = 1;
        LiteralStub operatorLiteral = new LiteralStub();
        operatorLiteral.value = "value";
        operatorLiteral.name = "name";
        operatorLiteral.representation = "REP";
        unaryOperator.literal = operatorLiteral;
        OperatorTemplateStub opTemplate = new OperatorTemplateStub();
        opTemplate.names = list("optemplate");
        unaryOperator.templatesList.add(opTemplate );
        
        operatorsList.add(unaryOperator );
        priority1.operators = operatorsList ;

        
        ophandler.addOperatorList(opList , classTemplateName , true);

        assertEquals(1, writerStub.rules.size());
         AbstractAntlr3Rule result = writerStub.rules.get(0);

        String expected = "priority_0 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);} " + 
        		"  : " + 
        		"   (((((ret=optemplate[opName, null, firstToken]NAME {opName = \"value\";}right=priority_0 {setProperty(ret, \"null\", right); " + 
        		"this.setLocationAndComment(ret, firstToken); " + 
        		"})))) " + 
        		"| " + 
        		" ( ret=primary_testclasstemplate)) " + 
        		"{ " + 
        		"this.setLocationAndComment(ret, firstToken); " + 
        		"ret2=ret; " + 
        		" } " + 
        		"  ; " +
        "catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}";

        assertEqualTokens(expected, result.toString());
    }
    
    @Test
    public void testAddElementUnaryPostfix() throws Exception {
        // This test is not a real world scenario, no syntax should define an operatorList without operators
        // This test though might reveal bugs on a very basic level, so it is included.
        SyntaxLookup syntaxLookupStub = new SyntaxLookupStub();
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        // Class under test
        OperatorHandler ophandler = new OperatorHandler(writerStub, namingStub, null);

        String classTemplateName = "testClassTemplate";
        OperatorListStub opList = new OperatorListStub();

        List<Priority> prioList = new ArrayList<Priority>();
        PriorityStub priority1 = new PriorityStub();
        prioList.add(priority1);
        opList.priorities = prioList ;
        
        List<Operator> operatorsList = new ArrayList<Operator>();
        OperatorStub unaryOperator = new OperatorStub();
        unaryOperator.arity = 1;
        LiteralStub operatorLiteral = new LiteralStub();
        operatorLiteral.value = "value";
        operatorLiteral.name = "name";
        operatorLiteral.representation = "REP";
        unaryOperator.literal = operatorLiteral;
        unaryOperator.isPostFix = true;
        OperatorTemplateStub opTemplate = new OperatorTemplateStub();
        opTemplate.names = list("optemplate");
        unaryOperator.templatesList.add(opTemplate );
        
        operatorsList.add(unaryOperator );
        priority1.operators = operatorsList ;

        
        ophandler.addOperatorList(opList , classTemplateName , true);

        assertEquals(1, writerStub.rules.size());
         AbstractAntlr3Rule result = writerStub.rules.get(0);

        String expected = "priority_0 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);} " + 
        		"  : " +
        		" ( ( ret=primary_testclasstemplate )(" + 
        		" ((NAME)=>(NAME {opName = \"value\";}((ret=optemplate[opName, ret, firstToken]{this.setLocationAndComment(ret, firstToken); })))) " + 
        		"| )) " + 
        		"{ " + 
        		"this.setLocationAndComment(ret, firstToken); " + 
        		"ret2=ret; " + 
        		" } " + 
        		"  ; " +
        "catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}";

        assertEqualTokens(expected, result.toString());
    }
    
    /**
     * helps with setting up operatorlists. An operatorList has n priorities, 
     * and each priority has operators, and operator each has a literal and a template.
     * 
     * That's the basic concept, though there is also associativity and arity to consider. (TODO)
     * @param priorities
     * @return
     */
    private OperatorListStub getMockOperatorList(List<String>... priorities) {
        OperatorListStub opList = new OperatorListStub();
        List<Priority> prioList = new ArrayList<Priority>();
        
        for (int i = 0; i < priorities.length; i++) {
            List<String> operatorsList = priorities[i];
            List<Operator> opsList = new ArrayList<Operator>();
            
            PriorityStub loopPriority = new PriorityStub();
            loopPriority.value = i;
            prioList.add(loopPriority);
            opList.priorities = prioList ;
            
            for (Iterator iterator = operatorsList.iterator(); iterator.hasNext();) {
                String nextString = (String) iterator.next();
                LiteralStub operatorLiteral = new LiteralStub();
                operatorLiteral.value = nextString;
                operatorLiteral.name = nextString;
                operatorLiteral.representation = nextString;
                OperatorStub op = new OperatorStub();
                
                op.literal = operatorLiteral;
                List<OperatorTemplate> templList = new ArrayList<OperatorTemplate>();
                OperatorTemplateStub template = new OperatorTemplateStub();
                template.names = list("template");
                templList.add(template);
                op.templatesList = templList;
                
                opsList.add(op );
                loopPriority.operators = opsList ;
            }
        }
              
        return opList;
    }
    
    // TODO test other arities and associativities

    @Test
    public void testPrefix() throws Exception {

        assertEquals("", OperatorHandler.getPriorityPrefix(null));

        OperatorListStub opList = new OperatorListStub();
        assertEquals("", OperatorHandler.getPriorityPrefix(opList));

        opList.name = "test";
        assertEquals("test_", OperatorHandler.getPriorityPrefix(opList));

        opList.name = "TEST";
        assertEquals("test_", OperatorHandler.getPriorityPrefix(opList));

        opList.name = "Test";
        assertEquals("test_", OperatorHandler.getPriorityPrefix(opList));
    }

}