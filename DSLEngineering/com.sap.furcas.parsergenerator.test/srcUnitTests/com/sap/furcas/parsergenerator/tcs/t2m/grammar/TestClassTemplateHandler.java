/**
 * 
 */
package com.sap.furcas.parsergenerator.tcs.t2m.grammar;

import static com.sap.furcas.parsergenerator.testutils.RuleComparisonHelper.tokens;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Priority;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.ClassTemplateStub;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.OperatorListStub;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.OperatorTemplateStub;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.PriorityStub;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.SequenceStub;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub.ANTLR3WriterStub;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub.MetaLookupStub;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub.MetaModelElementResolutionHelperStub;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub.OperatorHandlerStub;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub.RuleBufferFactoryStub;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub.SyntaxLookupStub;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub.TemplateNamingHelperStub;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.rules.AbstractAntlr3Rule;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.rules.ClassProductionRule;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.furcas.runtime.parser.exceptions.SyntaxParsingException;
import com.sap.furcas.runtime.tcs.SyntaxLookup;
import com.sap.furcas.runtime.tcs.TemplateNamingHelper;
import com.sap.furcas.test.testutils.ResolutionBeanHelper;
import com.sap.furcas.test.testutils.StringListHelper;



/**
 * Probably one of the most important tests for DSL Engineering.
 */
public class TestClassTemplateHandler {


    @BeforeClass
    public static void setup() {
        ObservationDirectivesHelper.doAddObserverParts = ObservationDirectivesHelper.NONE;
    }
    
    @Test
    public void testAddElement() throws Exception {
        SyntaxLookup syntaxLookupStub = new SyntaxLookupStub();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        OperatorHandlerStub operatorHandlerStub = new OperatorHandlerStub();
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        MetaModelElementResolutionHelperStub resolutionHelperStub = new MetaModelElementResolutionHelperStub();
        // Class under test
        ClassTemplateHandler classhandler = new ClassTemplateHandler(writerStub, operatorHandlerStub, metaLookupStub, syntaxLookupStub, namingStub, null, resolutionHelperStub);


        ClassTemplateStub template = new ClassTemplateStub();
        template.names = StringListHelper.list("test", "class");
        RuleBodyBufferFactory ruleBodyBufferFactory = new RuleBufferFactoryStub();
        
        classhandler.addTemplate(template, ruleBodyBufferFactory, false);
        
        assertEquals(1, writerStub.rules.size());
        ClassProductionRule result = (ClassProductionRule) writerStub.rules.get(0);

        String expected = "testclass returns[Object ret2] @init{IModelElementProxy ret; List<String> metaType=testclass;" +  
        		" ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;" + 
        		" onEnterTemplateRule(metaType);" +
        		" org.antlr.runtime.Token firstToken=input.LT(1);" + 
        		" }" + 
        		"  :" + 
        		"  " + 
        		"  {" + 
        		" ret2 = commitCreation(ret, firstToken, false);" + 
        		" }" + 
        		"  ;" +
        		" catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals(expected + "\n!=\n" + result +'\n', tokens, tokens2);
    }
    
    @Test
    public void testAddElementReferenceOnly() throws Exception {
        SyntaxLookup syntaxLookupStub = new SyntaxLookupStub();
        IMetaModelLookup metaLookupStub = new MetaLookupStub();
        OperatorHandlerStub operatorHandlerStub = new OperatorHandlerStub();
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        MetaModelElementResolutionHelperStub resolutionHelperStub = new MetaModelElementResolutionHelperStub();
        // Class under test
        ClassTemplateHandler classhandler = new ClassTemplateHandler(writerStub, operatorHandlerStub, metaLookupStub, syntaxLookupStub, namingStub, null, resolutionHelperStub);


        ClassTemplateStub template = new ClassTemplateStub();
        template.names = StringListHelper.list("test", "class");
        template.referenceOnly = true;
        RuleBodyBufferFactory ruleBodyBufferFactory = new RuleBufferFactoryStub();
        
        classhandler.addTemplate(template, ruleBodyBufferFactory, false);
        
        assertEquals(1, writerStub.rules.size());
        ClassProductionRule result = (ClassProductionRule) writerStub.rules.get(0);

        String expected = "testclass returns[Object ret2] @init{IModelElementProxy ret; List<String> metaType=testclass;" +  
        		" ret=(getBacktrackingLevel()==0) ? createReferenceProxy(metaType) : null;" + 
        		" onEnterTemplateRule(metaType);" +
        		" org.antlr.runtime.Token firstToken=input.LT(1);" + 
        " }" + 
        "  :" + 
        "  " + 
        "  {" + 
        " ret2 = commitCreation(ret, firstToken, false);" + 
        " }" + 
        "  ;" +
        " catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals(expected + "\n!=\n" + result +'\n', tokens, tokens2);
    }
    
    @Test
    public void testAddElementMode() throws Exception {
        // tests that modename gets appended to rulename
        SyntaxLookup syntaxLookupStub = new SyntaxLookupStub();
        IMetaModelLookup metaLookupStub = new MetaLookupStub();
        OperatorHandlerStub operatorHandlerStub = new OperatorHandlerStub();
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        MetaModelElementResolutionHelperStub resolutionHelperStub = new MetaModelElementResolutionHelperStub();
        // Class under test
        ClassTemplateHandler classhandler = new ClassTemplateHandler(writerStub, operatorHandlerStub, metaLookupStub, syntaxLookupStub, namingStub, null, resolutionHelperStub);


        ClassTemplateStub template = new ClassTemplateStub();
        template.names = StringListHelper.list("test", "class");
        template.mode = "testmode";
        RuleBodyBufferFactory ruleBodyBufferFactory = new RuleBufferFactoryStub();
        
        classhandler.addTemplate(template, ruleBodyBufferFactory, false);
        
        assertEquals(1, writerStub.rules.size());
        ClassProductionRule result = (ClassProductionRule) writerStub.rules.get(0);

        String expected = "testclass_testmode returns[Object ret2] @init{IModelElementProxy ret; List<String> metaType=testclass;" + 
        " ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;" + 
        " onEnterTemplateRule(metaType,\"testmode\");" + 
        " org.antlr.runtime.Token firstToken=input.LT(1);" + 
        " }" + 
        "  :" + 
        "  " + 
        "  {" + 
        " ret2 = commitCreation(ret, firstToken, false);" + 
        " }" + 
        "  ;" +
        " catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals(expected + "\n!=\n" + result +'\n', tokens, tokens2);
    }
    
    @Test
    public void testAddElementModeAbstract() throws Exception {
        // tests that modename gets appended to rulename, and to rule calls to subclass rules
        SyntaxLookupStub syntaxLookupStub = new SyntaxLookupStub();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        OperatorHandlerStub operatorHandlerStub = new OperatorHandlerStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        MetaModelElementResolutionHelperStub resolutionHelperStub = new MetaModelElementResolutionHelperStub();
        // Class under test
        ClassTemplateHandler classhandler = new ClassTemplateHandler(writerStub, operatorHandlerStub, metaLookupStub, syntaxLookupStub, namingStub, null, resolutionHelperStub);


        ClassTemplateStub template = new ClassTemplateStub();
        template.names = StringListHelper.list("test", "class");
       /** !!!**/ 
        template.isAbstract = true;
        template.mode = "testmode";
        
        // subtypes to be used for abstract rule
        metaLookupStub.subTypes = ResolutionBeanHelper.multiSimpleList("subtype1", "subtype2"); // names get ignored later
        
        ClassTemplateStub subtemplate = new ClassTemplateStub();
        subtemplate.names = StringListHelper.list("subtype");
        syntaxLookupStub.typeTemplate = subtemplate; // to be returned as template for both subtype1 and subtype2
        
        RuleBodyBufferFactory ruleBodyBufferFactory = new RuleBufferFactoryStub();
        classhandler.addTemplate(template, ruleBodyBufferFactory, false);
        
        assertTrue(writerStub.rules.size() == 1);
        // this is a white Box test, so casting is allowed
        ClassProductionRule result = (ClassProductionRule) writerStub.rules.get(0);

        
        
        String expected = "testclass_testmode returns[Object ret2]\r\n" + 
                "  :  (ret=subtype_testmode | ret=subtype_testmode) {\r\n" + 
                "ret2=ret;\n" +             
                " }\n" +
                "  ;";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals(expected + "\n!=\n" + result +'\n', tokens, tokens2);
    }
    
   
    
    /**
     * test with template that is context, should pass true for isContext in create, and leave context afterwards 
     * @throws Exception
     */
    @Test
    public void testAddElementContext() throws Exception {
        SyntaxLookup syntaxLookupStub = new SyntaxLookupStub();
        IMetaModelLookup metaLookupStub = new MetaLookupStub();
        OperatorHandlerStub operatorHandlerStub = new OperatorHandlerStub();
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        MetaModelElementResolutionHelperStub resolutionHelperStub = new MetaModelElementResolutionHelperStub();
        // Class under test
        ClassTemplateHandler classhandler = new ClassTemplateHandler(writerStub, operatorHandlerStub, metaLookupStub, syntaxLookupStub, namingStub, null, resolutionHelperStub);


        ClassTemplateStub template = new ClassTemplateStub();
        template.names = StringListHelper.list("test", "class");
        template.isContext = true;
        RuleBodyBufferFactory ruleBodyBufferFactory = new RuleBufferFactoryStub();
        
        classhandler.addTemplate(template, ruleBodyBufferFactory, false);
        
        assertEquals(1, writerStub.rules.size());
        ClassProductionRule result = (ClassProductionRule) writerStub.rules.get(0);

        String expected = "testclass returns[Object ret2] @init{IModelElementProxy ret; List<String> metaType=testclass;" + 
        " ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;" + 
        " onEnterTemplateRule(metaType);" + 
        " org.antlr.runtime.Token firstToken=input.LT(1);" + 
        " }" + 
        "  :" + 
        "  " + 
        "  {" + 
        " ret2 = commitCreation(ret, firstToken, true);" + 
        " }" + 
        "  ;" +
        " catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals(expected + "\n!=\n" + result +'\n', tokens, tokens2);
    }
    
    /**
     * test with template that is context, should pass true for isContext in create, and leave context afterwards and include 1 tag
     * @throws Exception
     */
    @Test
    public void testAddElementContext1Tag() throws Exception {
        SyntaxLookup syntaxLookupStub = new SyntaxLookupStub();
        IMetaModelLookup metaLookupStub = new MetaLookupStub();
        OperatorHandlerStub operatorHandlerStub = new OperatorHandlerStub();
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        MetaModelElementResolutionHelperStub resolutionHelperStub = new MetaModelElementResolutionHelperStub();
        // Class under test
        ClassTemplateHandler classhandler = new ClassTemplateHandler(writerStub, operatorHandlerStub, metaLookupStub, syntaxLookupStub, namingStub, null, resolutionHelperStub);


        ClassTemplateStub template = new ClassTemplateStub();
        template.names = StringListHelper.list("test", "class");
        template.isContext = true;
        template.contextTags.tags.add("testTag");
        RuleBodyBufferFactory ruleBodyBufferFactory = new RuleBufferFactoryStub();
        
        classhandler.addTemplate(template, ruleBodyBufferFactory, false);
        
        assertEquals(1, writerStub.rules.size());
        ClassProductionRule result = (ClassProductionRule) writerStub.rules.get(0);

        String expected = "testclass returns[Object ret2] @init{IModelElementProxy ret; List<String> metaType=testclass;" + 
        " ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{\"testTag\"}) : null;" + 
        " onEnterTemplateRule(metaType);" +
        " org.antlr.runtime.Token firstToken=input.LT(1);" + 
        " }" + 
        "  :" + 
        "  " + 
        "  {" + 
        " ret2 = commitCreation(ret, firstToken, true);" + 
        " }" + 
        "  ;" +
        " catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals(expected + "\n!=\n" + result +'\n', tokens, tokens2);
    }
    
    /**
     * test with template that is context, should pass true for isContext in create, and leave context afterwards and include 1 tag
     * @throws Exception
     */
    @Test
    public void testAddElementContext2Tags() throws Exception {
        SyntaxLookup syntaxLookupStub = new SyntaxLookupStub();
        IMetaModelLookup metaLookupStub = new MetaLookupStub();
        OperatorHandlerStub operatorHandlerStub = new OperatorHandlerStub();
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        MetaModelElementResolutionHelperStub resolutionHelperStub = new MetaModelElementResolutionHelperStub();
        // Class under test
        ClassTemplateHandler classhandler = new ClassTemplateHandler(writerStub, operatorHandlerStub, metaLookupStub, syntaxLookupStub, namingStub, null, resolutionHelperStub);


        ClassTemplateStub template = new ClassTemplateStub();
        template.names = StringListHelper.list("test", "class");
        template.isContext = true;
        template.contextTags.tags.add("testTag1");
        template.contextTags.tags.add("testTag2");
        RuleBodyBufferFactory ruleBodyBufferFactory = new RuleBufferFactoryStub();
        
        classhandler.addTemplate(template, ruleBodyBufferFactory, false);
        
        assertEquals(1, writerStub.rules.size());
        ClassProductionRule result = (ClassProductionRule) writerStub.rules.get(0);

        String expected = "testclass returns[Object ret2] @init{IModelElementProxy ret; List<String> metaType=testclass;" + 
        " ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{\"testTag1\", \"testTag2\"}) : null;" + 
        " onEnterTemplateRule(metaType);" +
        " org.antlr.runtime.Token firstToken=input.LT(1);" + 
        " }" + 
        "  :" + 
        "  " + 
        "  {" + 
        " ret2 = commitCreation(ret, firstToken, true);" + 
        " }" + 
        "  ;" +
        " catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals(expected + "\n!=\n" + result +'\n', tokens, tokens2);
    }
    
    /**
     * Test for addToContext, should modify to create(...,false, true);
     * @throws Exception
     */
    @Test
    public void testAddElementAddToContext() throws Exception {
        SyntaxLookup syntaxLookupStub = new SyntaxLookupStub();
        IMetaModelLookup metaLookupStub = new MetaLookupStub();
        OperatorHandlerStub operatorHandlerStub = new OperatorHandlerStub();
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        MetaModelElementResolutionHelperStub resolutionHelperStub = new MetaModelElementResolutionHelperStub();
        // Class under test
        ClassTemplateHandler classhandler = new ClassTemplateHandler(writerStub, operatorHandlerStub, metaLookupStub, syntaxLookupStub, namingStub, null, resolutionHelperStub);


        ClassTemplateStub template = new ClassTemplateStub();
        template.names = StringListHelper.list("test", "class");
        template.isAddToContext = true;
        RuleBodyBufferFactory ruleBodyBufferFactory = new RuleBufferFactoryStub();
        
        classhandler.addTemplate(template, ruleBodyBufferFactory, false);
        
        assertEquals(1, writerStub.rules.size());
        ClassProductionRule result = (ClassProductionRule) writerStub.rules.get(0);

        String expected = "testclass returns[Object ret2] @init{IModelElementProxy ret; List<String> metaType=testclass;" + 
        " ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;" + 
        " onEnterTemplateRule(metaType);" +
        " org.antlr.runtime.Token firstToken=input.LT(1);" + 
        " }" + 
        "  :" + 
        "  " + 
        "  {" + 
        " ret2 = commitCreation(ret, firstToken, false);" + 
        " }" + 
        "  ;" +
        " catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals(expected + "\n!=\n" + result +'\n', tokens, tokens2);
    }
    
    /**
     * Test for addToContext, should modify to create(...,false, true);
     * @throws Exception
     */
    @Test
    public void testAddElementIsContextAddToContext() throws Exception {
        SyntaxLookup syntaxLookupStub = new SyntaxLookupStub();
        IMetaModelLookup metaLookupStub = new MetaLookupStub();
        OperatorHandlerStub operatorHandlerStub = new OperatorHandlerStub();
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        MetaModelElementResolutionHelperStub resolutionHelperStub = new MetaModelElementResolutionHelperStub();
        // Class under test
        ClassTemplateHandler classhandler = new ClassTemplateHandler(writerStub, operatorHandlerStub, metaLookupStub, syntaxLookupStub, namingStub, null, resolutionHelperStub);


        ClassTemplateStub template = new ClassTemplateStub();
        template.names = StringListHelper.list("test", "class");
        template.isAddToContext = true;
        template.isContext = true;
        RuleBodyBufferFactory ruleBodyBufferFactory = new RuleBufferFactoryStub();
        
        classhandler.addTemplate(template, ruleBodyBufferFactory, false);
        
        assertEquals(1, writerStub.rules.size());
        ClassProductionRule result = (ClassProductionRule) writerStub.rules.get(0);

        String expected = "testclass returns[Object ret2] @init{IModelElementProxy ret; List<String> metaType=testclass;" + 
        " ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, true) : null;" + 
        " onEnterTemplateRule(metaType);" +
        " org.antlr.runtime.Token firstToken=input.LT(1);" + 
        " }" + 
        "  :" + 
        "  " + 
        "  {" + 
        " ret2 = commitCreation(ret, firstToken, true);" + 
        " }" + 
        "  ;" +
        " catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals(expected + "\n!=\n" + result +'\n', tokens, tokens2);
    }
    
    /**
     * tests creation of rule for a given sequence, though sequence is stubbed
     * @throws MetaModelLookupException
     * @throws SyntaxParsingException
     */
    @Test
    public void testAddElementWithSequence() throws Exception {
        SyntaxLookup syntaxLookupStub = new SyntaxLookupStub();
        IMetaModelLookup metaLookupStub = new MetaLookupStub();
        OperatorHandlerStub operatorHandlerStub = new OperatorHandlerStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        MetaModelElementResolutionHelperStub resolutionHelperStub = new MetaModelElementResolutionHelperStub();
        // Class under test
        ClassTemplateHandler classhandler = new ClassTemplateHandler(writerStub, operatorHandlerStub, metaLookupStub, syntaxLookupStub, namingStub, null, resolutionHelperStub);


        ClassTemplateStub template = new ClassTemplateStub();
        template.names = StringListHelper.list("test", "class");
       /** !!!**/ 


        SequenceStub sequenceStub = new SequenceStub();
        sequenceStub.representation = "sequence";
        template.sequence = sequenceStub ;
        RuleBodyBufferFactory ruleBodyBufferFactory = new RuleBufferFactoryStub();
        classhandler.addTemplate(template, ruleBodyBufferFactory, false);

        assertEquals(1, writerStub.rules.size());
        ClassProductionRule result = (ClassProductionRule) writerStub.rules.get(0);
        
        String expected = "testclass returns[Object ret2] @init{IModelElementProxy ret; List<String> metaType=testclass;" + 
        " ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;" + 
        " onEnterTemplateRule(metaType);" +
        " org.antlr.runtime.Token firstToken=input.LT(1);" + 
        " }" + 
        "  :" + 
        "  sequence" + 
        "  {" + 
        " ret2 = commitCreation(ret, firstToken, false);" + 
        " }" + 
        "  ;" +
        " catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}";

        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals(expected + "\n!=\n" + result +'\n', tokens, tokens2);

    }

    /**
     * tests creation of rule for main
     * @throws MetaModelLookupException
     * @throws SyntaxParsingException
     */
    @Test
    public void testAddElementWithMain() throws Exception {
        SyntaxLookup syntaxLookupStub = new SyntaxLookupStub();
        IMetaModelLookup metaLookupStub = new MetaLookupStub();
        OperatorHandlerStub operatorHandlerStub = new OperatorHandlerStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        MetaModelElementResolutionHelperStub resolutionHelperStub = new MetaModelElementResolutionHelperStub();
        // Class under test
        ClassTemplateHandler classhandler = new ClassTemplateHandler(writerStub, operatorHandlerStub, metaLookupStub, syntaxLookupStub, namingStub, null, resolutionHelperStub);

        ClassTemplateStub template = new ClassTemplateStub();
        template.names = StringListHelper.list("test", "class");
       /** !!!**/ 
        template.isMain = true;

        RuleBodyBufferFactory ruleBodyBufferFactory = new RuleBufferFactoryStub();
        classhandler.addTemplate(template, ruleBodyBufferFactory,template.isMain);

        assertEquals(2, writerStub.rules.size());
        
        
        String expected = 
            "main returns[Object ret2]\r\n" + 
            "  :  ((ret=testclass) EOF) {\r\n" + 
            "ret2=ret;\n" +             
            " }\n" +
            "  ;";

        List<?> tokens = tokens( expected); 
        String result =  writerStub.rules.get(0).toString();
        List<?> tokens2 = tokens(result); 

        assertEquals(expected + "\n!=\n" + result +'\n', tokens, tokens2);

    }
    
    /**
     * Multi adds a '+' to the called rule
     * @throws Exception
     */
    @Test
    public void testAddElementMainMulti() throws Exception {
        SyntaxLookup syntaxLookupStub = new SyntaxLookupStub();
        IMetaModelLookup metaLookupStub = new MetaLookupStub();
        OperatorHandlerStub operatorHandlerStub = new OperatorHandlerStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        MetaModelElementResolutionHelperStub resolutionHelperStub = new MetaModelElementResolutionHelperStub();
        // Class under test
        ClassTemplateHandler classhandler = new ClassTemplateHandler(writerStub, operatorHandlerStub, metaLookupStub, syntaxLookupStub, namingStub, null, resolutionHelperStub);


        ClassTemplateStub template = new ClassTemplateStub();
        template.names = StringListHelper.list("test", "class");
       /** !!!**/ 
        template.isMain = true;
        template.isMulti = true;
        
        RuleBodyBufferFactory ruleBodyBufferFactory = new RuleBufferFactoryStub();
        classhandler.addTemplate(template, ruleBodyBufferFactory,template.isMain);
        
        assertEquals(2, writerStub.rules.size());

        String expected = 
            "main returns[Object ret2]\r\n" + 
            "  :  ((ret=testclass)+ EOF) {\r\n" + 
            "ret2=ret;\n" +             
            " }\n" +
            "  ;";

        List tokens = tokens( expected); 
        String result = writerStub.rules.get(0).toString();
        List tokens2 = tokens( result); 

        assertEquals(expected + "\n!=\n" + result +'\n', tokens, tokens2);
    }
    
    /**
     * tests creation of abstract rule with subtemplates
     * @throws MetaModelLookupException
     * @throws SyntaxParsingException
     */
    @Test
    public void testAddElementWithSubs() throws Exception {
        SyntaxLookupStub syntaxLookupStub = new SyntaxLookupStub();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        OperatorHandlerStub operatorHandlerStub = new OperatorHandlerStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        MetaModelElementResolutionHelperStub resolutionHelperStub = new MetaModelElementResolutionHelperStub();
        // Class under test
        ClassTemplateHandler classhandler = new ClassTemplateHandler(writerStub, operatorHandlerStub, metaLookupStub, syntaxLookupStub, namingStub, null, resolutionHelperStub);


        ClassTemplateStub template = new ClassTemplateStub();
        template.names = StringListHelper.list("test", "class");
       /** !!!**/ 
        template.isAbstract = false;
        
        SequenceStub sequenceStub = new SequenceStub();
        sequenceStub.representation = "sequence";
        template.sequence = sequenceStub ;
        
        // subtypes to be used for rule
        metaLookupStub.subTypes = ResolutionBeanHelper.multiSimpleList("subtype1", "subtype2");
        
        ClassTemplateStub subtemplate = new ClassTemplateStub();
        subtemplate.names = StringListHelper.list("subtype");
        syntaxLookupStub.typeTemplate = subtemplate; // to be returned as template for subtype1 and subtype2
        
        RuleBodyBufferFactory ruleBodyBufferFactory = new RuleBufferFactoryStub();
        classhandler.addTemplate(template, ruleBodyBufferFactory, false);
        
        assertEquals(2, writerStub.rules.size());
        // this is a white Box test, so casting is allowed
        ClassProductionRule result = (ClassProductionRule) writerStub.rules.get(0);
        ClassProductionRule result2 = (ClassProductionRule) writerStub.rules.get(1);        
        
        String expected = "testclass__impl returns[Object ret2] @init{IModelElementProxy ret; List<String> metaType=testclass;\n"
		+ "ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;\n"
		+ "onEnterTemplateRule(metaType);\n"
		+ "org.antlr.runtime.Token firstToken=input.LT(1);\n"
		+ "}\n"
		+ ":\n"
		+ "sequence\n"
		+ "{\n"
		+ "ret2 = commitCreation(ret, firstToken, false);\n"
		+ "\n"
		+ " }\n"
		+ "  ;\n"
		+ "catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}\n";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals(expected + "\n!=\n" + result +'\n', tokens, tokens2);
        
        expected = "testclass returns[Object ret2]\n" 
            +":\n"
            + "(ret=testclass__impl|(ret=subtype\n" 
            + "| ret=subtype)\n"
            + "{\n"
            + "ret2=ret;\n" 
            + "}){ret2 = ret;}\n" 
            + ";\n";

        tokens = tokens( expected); 
        tokens2 = tokens( result2.toString()); 

        assertEquals(expected + "\n!=\n" + result2 +'\n', tokens, tokens2);
    }
    
    /**
     * tests creation of abstract rule with subtemplates
     * @throws MetaModelLookupException
     * @throws SyntaxParsingException
     */
    @Test
    public void testAddElementAbstract() throws Exception {
        SyntaxLookupStub syntaxLookupStub = new SyntaxLookupStub();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        OperatorHandlerStub operatorHandlerStub = new OperatorHandlerStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        MetaModelElementResolutionHelperStub resolutionHelperStub = new MetaModelElementResolutionHelperStub();
        // Class under test
        ClassTemplateHandler classhandler = new ClassTemplateHandler(writerStub, operatorHandlerStub, metaLookupStub, syntaxLookupStub, namingStub, null, resolutionHelperStub);


        ClassTemplateStub template = new ClassTemplateStub();
        template.names = StringListHelper.list("test", "class");
       /** !!!**/ 
        template.isAbstract = true;
        
        // subtypes to be used for abstact rule
        metaLookupStub.subTypes = ResolutionBeanHelper.multiSimpleList("subtype1", "subtype2");
        
        ClassTemplateStub subtemplate = new ClassTemplateStub();
        subtemplate.names = StringListHelper.list("subtype");
        syntaxLookupStub.typeTemplate = subtemplate; // to be returned as template for subtype1 and subtype2
        
        RuleBodyBufferFactory ruleBodyBufferFactory = new RuleBufferFactoryStub();
        classhandler.addTemplate(template, ruleBodyBufferFactory, false);
        
        assertTrue(writerStub.rules.size() == 1);
        // this is a white Box test, so casting is allowed
        ClassProductionRule result = (ClassProductionRule) writerStub.rules.get(0);

        
        
        String expected = "testclass returns[Object ret2]\r\n" + 
        		"  :  (ret=subtype | ret=subtype) {\r\n" + 
        		"ret2=ret;\n" +        		
        		" }\n" +
        		"  ;";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals(expected + "\n!=\n" + result +'\n', tokens, tokens2);

    }
    
    /**
     * tests creation of abstract rule with subtemplates, tests operatored subtemplates are left out
     * @throws MetaModelLookupException
     * @throws SyntaxParsingException
     */
    @Test
    public void testAddElementAbstractOperatoredSubs() throws Exception {
        SyntaxLookupStub syntaxLookupStub = new SyntaxLookupStub();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        OperatorHandlerStub operatorHandlerStub = new OperatorHandlerStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        MetaModelElementResolutionHelperStub resolutionHelperStub = new MetaModelElementResolutionHelperStub();
        // Class under test
        ClassTemplateHandler classhandler = new ClassTemplateHandler(writerStub, operatorHandlerStub, metaLookupStub, syntaxLookupStub, namingStub, null, resolutionHelperStub);


        ClassTemplateStub template = new ClassTemplateStub();
        template.names = StringListHelper.list("test", "class");
       /** !!!**/ 
        template.isAbstract = true;
        
        // subtypes to be used for abstact rule
        metaLookupStub.subTypes = ResolutionBeanHelper.multiSimpleList("subtype1", "subtype2");
        
        OperatorTemplateStub subtemplate = new OperatorTemplateStub();
//        subtemplate.names = StringListHelper.list("subtype");
        syntaxLookupStub.typeTemplate = subtemplate; // to be returned as template for subtype1 and subtype2
        
        RuleBodyBufferFactory ruleBodyBufferFactory = new RuleBufferFactoryStub();
        classhandler.addTemplate(template, ruleBodyBufferFactory, false);
        
        assertTrue(writerStub.rules.size() == 1);
        // this is a white Box test, so casting is allowed
        ClassProductionRule result = (ClassProductionRule) writerStub.rules.get(0);

        
        
        String expected = "testclass returns[Object ret2]\r\n" + 
                "  :  () {\r\n" + 
                " }\n" +
                "  ;";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals(expected + "\n!=\n" + result +'\n', tokens, tokens2);

    }
    
    @Test
    public void testAddElementSemanticDisambiguate() throws Exception {
    	SyntaxLookupStub syntaxLookupStub = new SyntaxLookupStub() {
			@Override
			public Collection<Template> getTCSTemplate(
					ResolvedNameAndReferenceBean<?> refBean, String mode) {
				return Collections.singleton(subtemplates.get(refBean.getNames().get(0)));
			}
    	};
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        OperatorHandlerStub operatorHandlerStub = new OperatorHandlerStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        MetaModelElementResolutionHelperStub resolutionHelperStub = new MetaModelElementResolutionHelperStub();
        // Class under test
        ClassTemplateHandler classhandler = new ClassTemplateHandler(writerStub, 
        		operatorHandlerStub, metaLookupStub, syntaxLookupStub, namingStub, 
        		null, resolutionHelperStub);


        ClassTemplateStub template = new ClassTemplateStub();
        template.names = StringListHelper.list("test", "class");
       /** !!!**/ 
        template.isAbstract = true;
        
        // subtypes to be used for abstact rule
        metaLookupStub.subTypes = ResolutionBeanHelper.multiSimpleList("subtype1", "subtype2");
        
        ClassTemplateStub subtemplate = new ClassTemplateStub();
        subtemplate.names = StringListHelper.list("subtype1");
        subtemplate.semDisambiguate = "true";
        syntaxLookupStub.addSubtemplate("subtype1", subtemplate);
        
        subtemplate = new ClassTemplateStub();
        subtemplate.names = StringListHelper.list("subtype2");
        subtemplate.semDisambiguate = "false";
        syntaxLookupStub.addSubtemplate("subtype2", subtemplate);
        
        RuleBodyBufferFactory ruleBodyBufferFactory = new RuleBufferFactoryStub();
        classhandler.addTemplate(template, ruleBodyBufferFactory, false);
        
        assertTrue(writerStub.rules.size() == 1);
        // this is a white Box test, so casting is allowed
        ClassProductionRule result = (ClassProductionRule) writerStub.rules.get(0);

        
        
        String expected = "testclass returns[Object ret2] @init{Object semRef = null;\n"+
							"IModelElementProxy ret;\n"+
							"List<String> metaType=testclass;\n"+
							"ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;\n"+
							"onEnterTemplateRule(metaType);\n"+
							"org.antlr.runtime.Token firstToken=input.LT(1);\n"+
							"}\n"+
							  ":\n"+
							 " (\n"+
							"{List<SemanticDisambRuleData> semDisambRuleData = new ArrayList<SemanticDisambRuleData>();\n"+
							"semDisambRuleData.add(new SemanticDisambRuleData(\"subtype1\",\"true\"));\n"+
							"semDisambRuleData.add(new SemanticDisambRuleData(\"subtype2\",\"false\"));\n"+
							"setSemDisambiguate(ret,null,null,semRef,semDisambRuleData,false, (ANTLR3LocationToken)firstToken);\n"+
							"})\n"+
							 " {\n"+
							"ret2=ret;\n} \n;";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals(expected + "\n!=\n" + result +'\n', tokens, tokens2);

    }
    
    /**
     * tests creation of abstract rule with subtemplates and 
     * disambiguation rules
     * @throws MetaModelLookupException
     * @throws SyntaxParsingException
     */
    @Test
    public void testAddElementAbstractWithDisambiguation() throws Exception {
        SyntaxLookupStub syntaxLookupStub = new SyntaxLookupStub();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        OperatorHandlerStub operatorHandlerStub = new OperatorHandlerStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        MetaModelElementResolutionHelperStub resolutionHelperStub = new MetaModelElementResolutionHelperStub();
        // Class under test
        ClassTemplateHandler classhandler = new ClassTemplateHandler(writerStub, operatorHandlerStub, metaLookupStub, syntaxLookupStub, namingStub, null, resolutionHelperStub);


        ClassTemplateStub template = new ClassTemplateStub();
        template.names = StringListHelper.list("test", "class");
       /** !!!**/ 
        template.isAbstract = true;
        
        // subtypes to be used for abstact rule
        metaLookupStub.subTypes = ResolutionBeanHelper.multiSimpleList("subtype1", "subtype2");
        
        ClassTemplateStub subtemplate = new ClassTemplateStub();
        subtemplate.names = StringListHelper.list("subtype");
        subtemplate.setDisambiguateV3("MAGICTOKEN");
        syntaxLookupStub.typeTemplate = subtemplate; // to be returned as template for subtype1 and subtype2
        
        RuleBodyBufferFactory ruleBodyBufferFactory = new RuleBufferFactoryStub();
        classhandler.addTemplate(template, ruleBodyBufferFactory, false);
        
        assertTrue(writerStub.rules.size() == 1);
        // this is a white Box test, so casting is allowed
        ClassProductionRule result = (ClassProductionRule) writerStub.rules.get(0);

        
        
        String expected = "testclass returns[Object ret2]\r\n" + 
        		"  :  ((MAGICTOKEN)=>(ret=subtype) | (MAGICTOKEN)=>(ret=subtype)) {\r\n" + 
        		"ret2=ret;\n" +        		
        		" }\n" +
        		"  ;";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals(expected + "\n!=\n" + result +'\n', tokens, tokens2);

    }
    
    /**
     * tests creation of abstract rule with addToContext
     * @throws MetaModelLookupException
     * @throws SyntaxParsingException
     */
    @Test
    public void testAddElementAbstractAddToContext() throws Exception {
        SyntaxLookupStub syntaxLookupStub = new SyntaxLookupStub();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        OperatorHandlerStub operatorHandlerStub = new OperatorHandlerStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        MetaModelElementResolutionHelperStub resolutionHelperStub = new MetaModelElementResolutionHelperStub();
        // Class under test
        ClassTemplateHandler classhandler = new ClassTemplateHandler(writerStub, operatorHandlerStub, metaLookupStub, syntaxLookupStub, namingStub, null, resolutionHelperStub);


        ClassTemplateStub template = new ClassTemplateStub();
        template.names = StringListHelper.list("test", "class");
       /** !!!**/ 
        template.isAbstract = true;
        template.isAddToContext = true;
        
        // subtypes to be used for abstact rule
        metaLookupStub.subTypes = ResolutionBeanHelper.multiSimpleList("subtype1", "subtype2");
        
        ClassTemplateStub subtemplate = new ClassTemplateStub();
        subtemplate.names = StringListHelper.list("subtype");
        syntaxLookupStub.typeTemplate = subtemplate; // to be returned as template for subtype1 and subtype2
        
        RuleBodyBufferFactory ruleBodyBufferFactory = new RuleBufferFactoryStub();
        classhandler.addTemplate(template, ruleBodyBufferFactory, false);
        
        assertTrue(writerStub.rules.size() == 1);
        // this is a white Box test, so casting is allowed
        ClassProductionRule result = (ClassProductionRule) writerStub.rules.get(0);

        
        
        String expected = "testclass returns[Object ret2]\r\n" + 
                "  :  (ret=subtype | ret=subtype) { " + 
                "addToCurrentContext(ret); " +
                "ret2=ret;\n" +             
                " }\n" +
                "  ;";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals(expected + "\n!=\n" + result +'\n', tokens, tokens2);

    }
    
    /**
     * tests creation of abstract rule with subtemplates and sequence, should generate extra rule templatename_abstractContents
     * @throws MetaModelLookupException
     * @throws SyntaxParsingException
     */
    @Test
    public void testAddElementAbstractWithSequence() throws Exception {
        assertEquals("_abstractContents", TemplateNamingHelper.ABSTRACT_CONTENTS_SUFFIX);
        
        SyntaxLookupStub syntaxLookupStub = new SyntaxLookupStub();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        OperatorHandlerStub operatorHandlerStub = new OperatorHandlerStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        MetaModelElementResolutionHelperStub resolutionHelperStub = new MetaModelElementResolutionHelperStub();
        // Class under test
        ClassTemplateHandler classhandler = new ClassTemplateHandler(writerStub, operatorHandlerStub, metaLookupStub, syntaxLookupStub, namingStub, null, resolutionHelperStub);


        ClassTemplateStub template = new ClassTemplateStub();
        template.names = StringListHelper.list("test", "class");
       /** !!!**/ 
        template.isAbstract = true;
        SequenceStub sequence = new SequenceStub();
        sequence.representation = "AbstractSequence";
        template.sequence = sequence;
        
        // subtypes to be used for abstact rule
        metaLookupStub.subTypes = ResolutionBeanHelper.multiSimpleList("subtype1", "subtype2");
        
        ClassTemplateStub subtemplate = new ClassTemplateStub();
        subtemplate.names = StringListHelper.list("subtype");
        syntaxLookupStub.typeTemplate = subtemplate; // to be returned as template for subtype1 and subtype2
        
        RuleBodyBufferFactory ruleBodyBufferFactory = new RuleBufferFactoryStub();
        classhandler.addTemplate(template, ruleBodyBufferFactory, false);
        
        assertTrue(writerStub.rules.size() == 2);
      
        /** test abstract rule, assume it to be first **/
        
        AbstractAntlr3Rule result = writerStub.rules.get(0);

        String expected = "testclass_abstractContents returns[Object ret2] @init{IModelElementProxy ret; List<String> metaType=testclass;" +  
        		" ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;" + 
        		" onEnterTemplateRule(metaType);" +
        		" org.antlr.runtime.Token firstToken=input.LT(1);" + 
        		" }" + 
        		"  :" + 
        		"  AbstractSequence" + 
        		"  {" + 
        		" ret2 = commitCreation(ret, firstToken, false);" +  
        		" }" + 
        		"  ;" + 
        		" catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);} ";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals("Rule mismatch, also check that rule order has not changed:\n" + result.toString(), tokens, tokens2);
        
        
        /** test subtemplates rule **/
        result = writerStub.rules.get(1);

        expected = "testclass returns[Object ret2]\r\n" + 
                "  :  (ret=subtype | ret=subtype | ret=testclass_abstractContents) {\r\n" + 
                "ret2=ret;\n" +             
                " }\n" +
                "  ;";
        
        tokens = tokens( expected); 
        tokens2 = tokens( result.toString()); 

        assertEquals("Rule mismatch, also check that rule order has not changed:", tokens, tokens2);

    }
    
    /**
     * tests creation of abstract rule with subtemplates and sequence, should generate extra rule templatename_abstractContents
     * @throws MetaModelLookupException
     * @throws SyntaxParsingException
     */
    @Test
    public void testAddElementAbstractWithSequenceContext() throws Exception {
        assertEquals("_abstractContents", TemplateNamingHelper.ABSTRACT_CONTENTS_SUFFIX);
        
        SyntaxLookupStub syntaxLookupStub = new SyntaxLookupStub();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        OperatorHandlerStub operatorHandlerStub = new OperatorHandlerStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        MetaModelElementResolutionHelperStub resolutionHelperStub = new MetaModelElementResolutionHelperStub();
        // Class under test
        ClassTemplateHandler classhandler = new ClassTemplateHandler(writerStub, operatorHandlerStub, metaLookupStub, syntaxLookupStub, namingStub, null, resolutionHelperStub);


        ClassTemplateStub template = new ClassTemplateStub();
        template.names = StringListHelper.list("test", "class");
       /** !!!**/ 
        template.isAbstract = true;
        template.isContext = true;
        SequenceStub sequence = new SequenceStub();
        sequence.representation = "AbstractSequence";
        template.sequence = sequence;
        
        // subtypes to be used for abstact rule
        metaLookupStub.subTypes = ResolutionBeanHelper.multiSimpleList("subtype1", "subtype2");
        
        ClassTemplateStub subtemplate = new ClassTemplateStub();
        subtemplate.names = StringListHelper.list("subtype");
        syntaxLookupStub.typeTemplate = subtemplate; // to be returned as template for subtype1 and subtype2
        
        RuleBodyBufferFactory ruleBodyBufferFactory = new RuleBufferFactoryStub();
        classhandler.addTemplate(template, ruleBodyBufferFactory, false);
        
        assertTrue(writerStub.rules.size() == 2);
      
        /** test abstract rule, assume it to be first **/
        
        AbstractAntlr3Rule result = writerStub.rules.get(0);

        String expected = "testclass_abstractContents returns[Object ret2] @init{IModelElementProxy ret; List<String> metaType=testclass;" + 
        " ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;" + 
        " onEnterTemplateRule(metaType);" +
        " org.antlr.runtime.Token firstToken=input.LT(1);" + 
        " }" + 
        "  :" + 
        "  AbstractSequence" + 
        "  {" + 
        " ret2 = commitCreation(ret, firstToken, true);" +  
        " }" + 
        "  ;" + 
        " catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);} ";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals("Rule mismatch, also check that rule order has not changed:", tokens, tokens2);
        
        
        /** test subtemplates rule **/
        result = writerStub.rules.get(1);

        expected = "testclass returns[Object ret2]\r\n" + 
                "  :  (ret=subtype | ret=subtype | ret=testclass_abstractContents) {\r\n" + 
                "ret2=ret;\n" +             
                " }\n" +
                "  ;";
        
        tokens = tokens( expected); 
        tokens2 = tokens( result.toString()); 

        assertEquals("Rule mismatch, also check that rule order has not changed:", tokens, tokens2);

    }
    
    /**
     * ensures create is called with (... , true, false) , because we do not want to add to context in this case
     * @throws MetaModelLookupException
     * @throws SyntaxParsingException
     */
    @Test
    public void testAddElementAbstractWithSequenceContextAddToContext() throws Exception {
        assertEquals("_abstractContents", TemplateNamingHelper.ABSTRACT_CONTENTS_SUFFIX);
        
        SyntaxLookupStub syntaxLookupStub = new SyntaxLookupStub();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        OperatorHandlerStub operatorHandlerStub = new OperatorHandlerStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        MetaModelElementResolutionHelperStub resolutionHelperStub = new MetaModelElementResolutionHelperStub();
        // Class under test
        ClassTemplateHandler classhandler = new ClassTemplateHandler(writerStub, operatorHandlerStub, metaLookupStub, syntaxLookupStub, namingStub, null, resolutionHelperStub);


        ClassTemplateStub template = new ClassTemplateStub();
        template.names = StringListHelper.list("test", "class");
       /** !!!**/ 
        template.isAbstract = true;
        template.isContext = true;
        template.isAddToContext = true;
        SequenceStub sequence = new SequenceStub();
        sequence.representation = "AbstractSequence";
        template.sequence = sequence;
        
        // subtypes to be used for abstact rule
        metaLookupStub.subTypes = ResolutionBeanHelper.multiSimpleList("subtype1", "subtype2");
        
        ClassTemplateStub subtemplate = new ClassTemplateStub();
        subtemplate.names = StringListHelper.list("subtype");
        syntaxLookupStub.typeTemplate = subtemplate; // to be returned as template for subtype1 and subtype2
        
        RuleBodyBufferFactory ruleBodyBufferFactory = new RuleBufferFactoryStub();
        classhandler.addTemplate(template, ruleBodyBufferFactory, false);
        
        assertTrue(writerStub.rules.size() == 2);
      
        /** test abstract rule, assume it to be first **/
        
        AbstractAntlr3Rule result = writerStub.rules.get(0);

        String expected = "testclass_abstractContents returns[Object ret2] @init{IModelElementProxy ret; List<String> metaType=testclass;" +  
        " ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;" + 
        " onEnterTemplateRule(metaType);" +
        " org.antlr.runtime.Token firstToken=input.LT(1);" + 
        " }" + 
        "  :" + 
        "  AbstractSequence" + 
        "  {" + 
        " ret2 = commitCreation(ret, firstToken, true);" +  
        " }" + 
        "  ;" + 
        " catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);} ";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals("Rule mismatch, also check that rule order has not changed:\n" + result.toString(), tokens, tokens2);
        
        
        /** test subtemplates rule **/
        result = writerStub.rules.get(1);

        expected = "testclass returns[Object ret2]\r\n" + 
                "  :  (ret=subtype | ret=subtype | ret=testclass_abstractContents) { " + 
                "addToCurrentContext(ret); " +
                "ret2=ret;\n" +             
                " }\n" +
                "  ;";
        
        tokens = tokens( expected); 
        tokens2 = tokens( result.toString()); 

        assertEquals("Rule mismatch, also check that rule order has not changed:", tokens, tokens2);

    }
    
    /**
     * tests creation of abstract rule without subtemplates (should suppress ret2=ret;)
     * @throws MetaModelLookupException
     * @throws Exception
     */
    @Test
    public void testAddElementAbstractNoSubs() throws MetaModelLookupException, Exception {
        SyntaxLookupStub syntaxLookupStub = new SyntaxLookupStub();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        OperatorHandlerStub operatorHandlerStub = new OperatorHandlerStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        MetaModelElementResolutionHelperStub resolutionHelperStub = new MetaModelElementResolutionHelperStub();
        // Class under test
        ClassTemplateHandler classhandler = new ClassTemplateHandler(writerStub, operatorHandlerStub, metaLookupStub, syntaxLookupStub, namingStub, null, resolutionHelperStub);


        ClassTemplateStub template = new ClassTemplateStub();
        template.names = StringListHelper.list("test", "class");
       /** !!!**/ 
        template.isAbstract = true;
        
        // subtypes to be used for abstact rule
        metaLookupStub.subTypes = ResolutionBeanHelper.multiSimpleList();
        
        RuleBodyBufferFactory ruleBodyBufferFactory = new RuleBufferFactoryStub();
        classhandler.addTemplate(template, ruleBodyBufferFactory, false);
        
        assertTrue(writerStub.rules.size() == 1);
        // this is a white Box test, so casting is allowed
        ClassProductionRule result = (ClassProductionRule) writerStub.rules.get(0);
        
        String expected = "testclass returns[Object ret2]\r\n" + 
                "  :  () {\r\n" + 
                " }\n" +
                "  ;";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals(expected + "\n!=\n" + result +'\n', tokens, tokens2);

    }
    
 
    
    /**
     * tests creation of rule for operatored template
     * @throws MetaModelLookupException
     * @throws Exception
     */
    @Test
    public void testAddElementOperatored() throws MetaModelLookupException, Exception {
        SyntaxLookupStub syntaxLookupStub = new SyntaxLookupStub();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        OperatorHandlerStub operatorHandlerStub = new OperatorHandlerStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        MetaModelElementResolutionHelperStub resolutionHelperStub = new MetaModelElementResolutionHelperStub();
        // Class under test
        ClassTemplateHandler classhandler = new ClassTemplateHandler(writerStub, operatorHandlerStub, metaLookupStub, syntaxLookupStub, namingStub, null, resolutionHelperStub);


        ClassTemplateStub template = new ClassTemplateStub();
        template.names = StringListHelper.list("test", "class");
       /** !!!**/ 
        template.isOperatored = true;
        template.isAbstract = true;
        
        OperatorListStub opList = new OperatorListStub();
        opList.name = "opListName";
        template.operatorList = opList;
        opList.priorities = new BasicEList<Priority>();
        
        // subtypes to be used for abstact rule
        metaLookupStub.subTypes = ResolutionBeanHelper.multiSimpleList("subtype1", "subtype2");
        ClassTemplateStub subTemplate =  new ClassTemplateStub();
        subTemplate.names = StringListHelper.list("subtemplate");
        syntaxLookupStub.typeTemplate = subTemplate ; // syntaxLookUpStub will confirm types above are ClassTemplates
        
        syntaxLookupStub.nonPrimaries = new ArrayList<ClassTemplate>(Collections.singletonList((ClassTemplate)subTemplate));
        syntaxLookupStub.primaries = new ArrayList<ClassTemplate>(Collections.singletonList((ClassTemplate)subTemplate));
        
        RuleBodyBufferFactory ruleBodyBufferFactory = new RuleBufferFactoryStub();
        classhandler.addTemplate(template, ruleBodyBufferFactory, false);
        
        assertTrue(writerStub.rules.size() == 2); // contains 2 rules, one for priority_0, one for primary_class
        
        List resultTokenList1 = tokens(writerStub.rules.get(0).toString());
        List resultTokenList2 = tokens(writerStub.rules.get(1).toString());
        
        // check the rules are ok
        String rule1 = "primary_testclass returns[Object ret2]\r\n" + 
        "  :  (ret=subtemplate | (LPAREN ret=testclass RPAREN))\r\n" + 
        "{\r\n" + 
        "ret2=ret;\r\n" + 
        "}\r\n" + 
        "  ;";
        List tokenList1 = tokens(rule1);
        
        
        String rule2 = "testclass returns[Object ret2]\r\n" + 
        "  :  (ret=oplistname_priority_0 | ret=subtemplate) {\r\n" + 
        "ret2=ret;\r\n" + 
        " }\r\n" + 
        " ;";
        List tokenList2 = tokens(rule2);
        
        if (resultTokenList1.equals(tokenList1)) {
            assertEquals( tokenList2, resultTokenList2); 
        } else if (resultTokenList1.equals(tokenList2)) {
            assertEquals( tokenList2, resultTokenList1 );
        } else {
            fail("<" + resultTokenList1 + "> \nnot found in \n<" + tokenList1 +  "> \nor \n<" + tokenList2 + ">" );
        }
        
        // assert ophandler has been called
        assertTrue(operatorHandlerStub.elements.size() == 1);
    }
    
    
    /**
     * tests nonPrimary subtemplates, which do not go into the primary_... rule
     * @throws MetaModelLookupException
     * @throws Exception
     */
    @Test
    public void testAddElementOperatoredNonPrimary() throws MetaModelLookupException, Exception {
        SyntaxLookupStub syntaxLookupStub = new SyntaxLookupStub();
        MetaLookupStub metaLookupStub = new MetaLookupStub();
        OperatorHandlerStub operatorHandlerStub = new OperatorHandlerStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        MetaModelElementResolutionHelperStub resolutionHelperStub = new MetaModelElementResolutionHelperStub();
        // Class under test
        ClassTemplateHandler classhandler = new ClassTemplateHandler(writerStub, operatorHandlerStub, metaLookupStub, syntaxLookupStub, namingStub, null, resolutionHelperStub);


        ClassTemplateStub template = new ClassTemplateStub();
        template.names = StringListHelper.list("test", "class");
       /** !!!**/ 
        template.isOperatored = true;
        template.isAbstract = true;
        
        OperatorListStub opList = new OperatorListStub();
        opList.name = "opListName";
        template.operatorList = opList;
        opList.priorities = new BasicEList<Priority>();
        
        // subtypes to be used for abstact rule
        metaLookupStub.subTypes = ResolutionBeanHelper.multiSimpleList("subtype1", "subtype2");
        ClassTemplateStub subTemplate =  new ClassTemplateStub();
        subTemplate.names = StringListHelper.list("subtemplate");
        subTemplate.isNonPrimary = true;
        syntaxLookupStub.typeTemplate = subTemplate ; // syntaxLookUpStub will confirm types above are ClassTemplates
        syntaxLookupStub.nonPrimaries = new ArrayList<ClassTemplate>(Collections.singletonList((ClassTemplate)subTemplate));
        syntaxLookupStub.primaries = new ArrayList<ClassTemplate>(Collections.singletonList((ClassTemplate)subTemplate));
        
        RuleBodyBufferFactory ruleBodyBufferFactory = new RuleBufferFactoryStub();
        classhandler.addTemplate(template, ruleBodyBufferFactory, false);
        
        assertTrue(writerStub.rules.size() == 2); // contains 2 rules, one for priority_0, one for primary_class
        
        List resultTokenList1 = tokens(writerStub.rules.get(0).toString());
        List resultTokenList2 = tokens(writerStub.rules.get(1).toString());
        
        // check the rules are ok
        String rule1 = "primary_testclass returns[Object ret2]\r\n" + 
        "  :  ((LPAREN ret=testclass RPAREN))\r\n" + 
        "{\r\n" + 
        "ret2=ret;\r\n" + 
        "}\r\n" + 
        "  ;";
        List tokenList1 = tokens(rule1);
        
        
        String rule2 = "testclass returns[Object ret2]\r\n" + 
        "  :  (ret=oplistname_priority_0 | ret=subtemplate | ret=subtemplate) {\r\n" + 
        "ret2=ret;\r\n" + 
        " }\r\n" + 
        " ;";
        List tokenList2 = tokens(rule2);
        
        if (resultTokenList1.equals(tokenList1)) {
            assertEquals( tokenList2, resultTokenList2); 
        } else if (resultTokenList1.equals(tokenList2)) {
            assertEquals( tokenList2, resultTokenList1 );
        } else {
            fail("<" + resultTokenList1 + "> \nnot found in \n<" + tokenList1 +  "> \nor \n<" + tokenList2 + ">" );
        }
        
        // assert ophandler has been called
        assertTrue(operatorHandlerStub.elements.size() == 1);
    }
    
    
    
    
    @Test
    public void testHighestPriority() throws Exception {

        OperatorListStub opList = new OperatorListStub();
        opList.priorities = new BasicEList<Priority>();
        PriorityStub pStub = new PriorityStub();
        pStub.value = 4;
        opList.priorities.add(pStub );
        pStub = new PriorityStub();
        pStub.value = 3;
        opList.priorities.add(pStub );
        pStub = new PriorityStub();
        pStub.value = 5;
        opList.priorities.add(pStub );
        pStub = new PriorityStub();
        pStub.value = 2;
        opList.priorities.add(pStub );
        pStub = new PriorityStub();
        pStub.value = 1;
        opList.priorities.add(pStub );
        pStub = new PriorityStub();
        pStub.value = 0;
        opList.priorities.add(pStub );
        assertEquals(5, ClassTemplateHandler.getHighestPriorityIndex(opList ));
        
        
    }
  
    
}
