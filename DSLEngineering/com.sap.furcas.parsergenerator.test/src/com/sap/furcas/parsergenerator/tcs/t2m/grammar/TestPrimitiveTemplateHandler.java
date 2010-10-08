/**
 * 
 */
package com.sap.furcas.parsergenerator.tcs.t2m.grammar;

import static com.sap.furcas.parsergenerator.testutils.RuleComparisonHelper.tokens;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.sap.furcas.metamodel.TCS.Keyword;
import com.sap.furcas.metamodel.TCS.stubs.LiteralStub;
import com.sap.furcas.metamodel.TCS.stubs.PrimitiveTemplateStub;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub.ANTLR3WriterStub;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub.MetaModelElementResolutionHelperStub;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub.SyntaxLookupStub;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub.TemplateNamingHelperStub;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.rules.AbstractAntlr3Rule;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.parser.exceptions.SyntaxParsingException;
import com.sap.furcas.runtime.tcs.TemplateNamingHelper;
import com.sap.furcas.test.parsing.testutils.StringListHelper;

/**
 * Probably one of the most important tests for DSL Engineering.
 */
public class TestPrimitiveTemplateHandler {


    @Test
    public void testAddElement() throws Exception {

        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        MetaModelElementResolutionHelperStub metaLookupStub = new MetaModelElementResolutionHelperStub();

        // Class under test
        PrimitiveTemplateHandler primHandler = new PrimitiveTemplateHandler(writerStub, namingStub, null, null, metaLookupStub);


        PrimitiveTemplateStub template = new PrimitiveTemplateStub();
        template.names = StringListHelper.list("functionName");
// in real code, templateName would be used, but NamingHelperStub is dull.
        //        template.templateName = "templateName";
        
        primHandler.addTemplate(template);
        
        assertTrue(writerStub.rules.size() == 1);
        AbstractAntlr3Rule result = writerStub.rules.get(0);

        String expected = "functionName returns[Object ret2] @init{java.lang.Object ret=null;} : (ast=null {ret = ast.getText(); }) { ret2=ret; } ;";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals(expected + "\n!=\n" + result +'\n', tokens, tokens2);
    }
    
    /**
     * tests using a value, handler should do a replace of %token%
     * @throws MetaModelLookupException
     * @throws SyntaxParsingException
     */
    @Test
    public void testAddElementValue() throws Exception {

        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        MetaModelElementResolutionHelperStub metaLookupStub = new MetaModelElementResolutionHelperStub();

        // Class under test
        PrimitiveTemplateHandler primHandler = new PrimitiveTemplateHandler(writerStub, namingStub, null, null, metaLookupStub);


        PrimitiveTemplateStub template = new PrimitiveTemplateStub();
        template.names = StringListHelper.list("functionName");
// 
        template.value = "test1%token%2test";
        
        primHandler.addTemplate(template);
        
        assertTrue(writerStub.rules.size() == 1);
        AbstractAntlr3Rule result = writerStub.rules.get(0);

        String expected = "functionName returns[Object ret2] @init{java.lang.Object ret=null;} : (ast=null {ret = test1 ast.getText()2test; }) { ret2=ret; } ;";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals(expected + "\n!=\n" + result +'\n', tokens, tokens2);
    }
    
    @Test
    public void testAddElementOrKeywordZero() throws Exception {

        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        SyntaxLookupStub syntaxStub = new SyntaxLookupStub();
        MetaModelElementResolutionHelperStub metaLookupStub = new MetaModelElementResolutionHelperStub();
   
        // Class under test
        PrimitiveTemplateHandler primHandler = new PrimitiveTemplateHandler(writerStub, namingStub, syntaxStub, null, metaLookupStub );


        PrimitiveTemplateStub template = new PrimitiveTemplateStub();
        template.names = StringListHelper.list("functionName");
        template.isOrkeyword = true;
        
        syntaxStub.keywords = new HashSet<Keyword>();
        
        primHandler.addTemplate(template);

        
        assertTrue(writerStub.rules.size() == 1);
        AbstractAntlr3Rule result = writerStub.rules.get(0);

        String expected = "functionName returns[Object ret2] @init{java.lang.Object ret=null;} : (ast=null {ret = ast.getText(); }) { ret2=ret; } ;";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals(expected + "\n!=\n" + result +'\n', tokens, tokens2);
        

    }
    
    @Test
    public void testAddElementOrKeywordOne() throws Exception {

        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        SyntaxLookupStub syntaxStub = new SyntaxLookupStub();
        MetaModelElementResolutionHelperStub metaLookupStub = new MetaModelElementResolutionHelperStub();

        // Class under test
        PrimitiveTemplateHandler primHandler = new PrimitiveTemplateHandler(writerStub, namingStub, syntaxStub, null, metaLookupStub );


        PrimitiveTemplateStub template = new PrimitiveTemplateStub();
        template.names = StringListHelper.list("functionName");
        template.isOrkeyword = true;
        
        syntaxStub.keywords = new HashSet<Keyword>();
        KeywordStub keyStub = new KeywordStub();
        keyStub.name = "keyName";
        keyStub.value = "keyValue";
        syntaxStub.keywords.add(keyStub);
        
        primHandler.addTemplate(template);

        
        assertTrue(writerStub.rules.size() == 1);
        AbstractAntlr3Rule result = writerStub.rules.get(0);

        String expected = "functionName returns[Object ret2] @init{java.lang.Object ret=null;} " + 
        		"  :  (ast=null {ret =  ast.getText(); } " + 
        		" | \'keyName\' {ret = \"keyValue\";}) " + 
        		"{ " + 
                "ret2=ret; " + 
                "}" +
        		"  ;";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals(expected + "\n!=\n" + result +'\n', tokens, tokens2);
        
      
    }
    
    /**
     * should use value both times
     * @throws MetaModelLookupException
     * @throws SyntaxParsingException
     */
    @Test
    public void testAddElementOrKeywordOneNullName() throws Exception {

        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        SyntaxLookupStub syntaxStub = new SyntaxLookupStub();
        MetaModelElementResolutionHelperStub metaLookupStub = new MetaModelElementResolutionHelperStub();
 
        // Class under test
        PrimitiveTemplateHandler primHandler = new PrimitiveTemplateHandler(writerStub, namingStub, syntaxStub, null, metaLookupStub );


        PrimitiveTemplateStub template = new PrimitiveTemplateStub();
        template.names = StringListHelper.list("functionName");
        template.isOrkeyword = true;
        
        syntaxStub.keywords = new HashSet<Keyword>();
        KeywordStub keyStub = new KeywordStub();
        keyStub.name = null;
        keyStub.value = "keyValue";
        syntaxStub.keywords.add(keyStub);
        
        primHandler.addTemplate(template);

        
        assertTrue(writerStub.rules.size() == 1);
        AbstractAntlr3Rule result = writerStub.rules.get(0);

        String expected = "functionName returns[Object ret2] @init{java.lang.Object ret=null;} " + 
                "  :  (ast=null {ret =  ast.getText(); } " + 
                " | \'keyValue\' {ret = \"keyValue\";}) " +
               " { " + 
                    "ret2=ret; " + 
                    "}" +
                "  ;";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals(expected + "\n!=\n" + result +'\n', tokens, tokens2);
        
      
    }
    
    @Test
    public void testAddElementOrKeywordTwo() throws Exception {

        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        TemplateNamingHelper namingStub = new TemplateNamingHelperStub();
        SyntaxLookupStub syntaxStub = new SyntaxLookupStub();
        MetaModelElementResolutionHelperStub metaLookupStub = new MetaModelElementResolutionHelperStub();

        // Class under test
        PrimitiveTemplateHandler primHandler = new PrimitiveTemplateHandler(writerStub, namingStub, syntaxStub, null, metaLookupStub);


        PrimitiveTemplateStub template = new PrimitiveTemplateStub();
        template.names = StringListHelper.list("functionName");
        template.isOrkeyword = true;
        
        
        final KeywordStub keyStub = new KeywordStub();
        keyStub.name = "keyName";
        keyStub.value = "keyValue";
        
        final KeywordStub keyStub2 = new KeywordStub();
        keyStub2.name = "keyName2";
        keyStub2.value = "keyValue2";
        
        syntaxStub.keywords = new HashSet<Keyword>() {

            @Override
            public Iterator<Keyword> iterator() {
                return new Iterator<Keyword>() {

                    int counter = 3;
                    
                    @Override
		    public boolean hasNext() {
                        return counter > 1;
                    }

                    @Override
		    public Keyword next() {
                        counter--;
                        if (counter == 2) {
			    return keyStub;
			}
                        if (counter == 1) {
			    return keyStub2;
			}
                        return null;
                    }

                    @Override
		    public void remove() {}};
            }
            
        };
        
        primHandler.addTemplate(template);

        
        assertTrue(writerStub.rules.size() == 1);
        AbstractAntlr3Rule result = writerStub.rules.get(0);

        String expected = "functionName returns[Object ret2] @init{java.lang.Object ret=null;} " + 
        "  :  (ast=null {ret =  ast.getText(); } " + 
        " | \'keyName\' {ret = \"keyValue\";} " +
        "| \'keyName2\' {ret = \"keyValue2\";}) "  +
        "{ " + 
        "ret2=ret; " + 
        "}" +
        "  ;";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals(expected + "\n!=\n" + result +'\n', tokens, tokens2);
        
      
    }
    
    private class KeywordStub extends LiteralStub implements Keyword {
        
    }
}
