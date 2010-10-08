/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar;

import static com.sap.mi.textual.test.util.RuleComparisonHelper.tokens;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.sap.furcas.parsergenerator.tcs.t2m.grammar.FunctionTemplateHandler;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.RuleBodyBufferFactory;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.rules.FunctionProductionRule;
import com.sap.furcas.runtime.tcs.TemplateNamingHelper;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.handlerStub.ANTLR3WriterStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.handlerStub.RuleBufferFactoryStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.handlerStub.TemplateNamingHelperStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.FunctionTemplateStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.SequenceStub;
import com.sap.mi.textual.test.util.StringListHelper;

/**
 * Probably one of the most important tests for DSL Engineering.
 */
public class FunctionTemplateHandlerTest {

  
    @Test
    public void testAddElement() throws Exception {

        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        // Class under test
        FunctionTemplateHandler funchandler = new FunctionTemplateHandler(writerStub, namingStub);


        FunctionTemplateStub template = new FunctionTemplateStub();
        template.names = StringListHelper.list("functionName");
        template.functionName = "error";
        RuleBodyBufferFactory ruleBodyBufferFactory = new RuleBufferFactoryStub();
        
        funchandler.addTemplate(template, ruleBodyBufferFactory);
        
        assertTrue(writerStub.rules.size() == 1);
        FunctionProductionRule result = (FunctionProductionRule) writerStub.rules.get(0);

        String expected = "functionName[Object ret]" + 
        		"  :  " + 
        		"{ " + 
        		" }" + 
        		"  ;";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals(tokens, tokens2);
    }
    
    @Test
    public void testAddElementWithSequence() throws Exception {

        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        // Class under test
        FunctionTemplateHandler funchandler = new FunctionTemplateHandler(writerStub, namingStub);


        FunctionTemplateStub template = new FunctionTemplateStub();
        template.names = StringListHelper.list("functionName");
        template.functionName = "error";
        SequenceStub sequenceStub = new SequenceStub();
        sequenceStub.representation = "sequence";
        template.functionSequence = sequenceStub ;
        
        RuleBodyBufferFactory ruleBodyBufferFactory = new RuleBufferFactoryStub();
        
        funchandler.addTemplate(template, ruleBodyBufferFactory);
        
        assertTrue(writerStub.rules.size() == 1);
        FunctionProductionRule result = (FunctionProductionRule) writerStub.rules.get(0);

        String expected = "functionName[Object ret]" + 
                "  :  sequence " + 
                "{ " + 
                " }" + 
                "  ;";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals(tokens, tokens2);
    }
    
 
}
