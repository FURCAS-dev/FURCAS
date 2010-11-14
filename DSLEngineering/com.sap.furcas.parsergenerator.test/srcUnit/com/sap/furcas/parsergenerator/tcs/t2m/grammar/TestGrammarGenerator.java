/**
 * 
 */
package com.sap.furcas.parsergenerator.tcs.t2m.grammar;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.TCS.Keyword;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.ConcreteSyntaxStub;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub.ANTLR3WriterStub;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub.MetaLookupStub;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.parser.exceptions.SyntaxParsingException;
import com.sap.furcas.test.testutils.StringListHelper;

/**
 *
 */
public class TestGrammarGenerator {


    /**
     * Test method for {@link com.sap.furcas.parsergenerator.tcs.t2m.grammar.ANTLRGrammarGenerator#generateGrammar()}.
     * @throws SyntaxParsingException 
     * @throws MetaModelLookupException 
     */
    @Test
    public void testGenerateGrammarFixedString() throws Exception {
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        MetaLookupStub metaStub = new MetaLookupStub();
        
        ConcreteSyntaxStub syntaxStub = new ConcreteSyntaxStub();
        Set<Keyword> keywordSet = new HashSet<Keyword>();
        TCSSyntaxContainerBean bean = new TCSSyntaxContainerBean();
        bean.setSyntax(syntaxStub);
        bean.setKeywords(keywordSet);
        
        ANTLRGrammarGenerator generator = new ANTLRGrammarGenerator();

        // first test name has not been set
        generator.generateGrammar(writerStub, metaStub, bean, null, null);
        assertEquals(null, writerStub.grammarName);
        
        // test name has been set
        syntaxStub.name = "SyntaxName";
        generator.generateGrammar(writerStub, metaStub, bean, null, null);
        assertEquals("SyntaxName", writerStub.grammarName);
        String replacedLexer = ANTLRGrammarGenerator.DEFAULT_LEXER.replaceAll("%protected", "fragment")
        .replaceAll("%options", "//")
        .replaceAll("%v3", "")
        .replaceAll("%v2.*", "");
        assertEquals(replacedLexer, writerStub.fixedString);
        
        // test substitution of %protected with fragment
        syntaxStub.lexer = "test%protectederror";
        generator.generateGrammar(writerStub, metaStub, bean, null, null);
        assertEquals("testfragmenterror", writerStub.fixedString);
        
        // test substitution of %options with //
        syntaxStub.lexer = "test%optionstest";
        generator.generateGrammar(writerStub, metaStub, bean, null, null);
        assertEquals("test//test", writerStub.fixedString);

        
        // test elimination of v2s and v3s
        syntaxStub.lexer = "test%v3";
        generator.generateGrammar(writerStub, metaStub, bean, null, null);
        assertEquals("test", writerStub.fixedString);
        
        syntaxStub.lexer = "test%v3test";
        generator.generateGrammar(writerStub, metaStub, bean, null, null);
        assertEquals("testtest", writerStub.fixedString);
        
        syntaxStub.lexer = "test%v2HelloWorld";
        generator.generateGrammar(writerStub, metaStub, bean, null, null);
        assertEquals("test", writerStub.fixedString);
        
        syntaxStub.lexer = "test%v2HelloWorld\n";
        generator.generateGrammar(writerStub, metaStub, bean, null, null);
        assertEquals("test\n", writerStub.fixedString);
        
        syntaxStub.lexer = "test%v2Hello\nWorld";
        generator.generateGrammar(writerStub, metaStub, bean, null, null);
        assertEquals("test\nWorld", writerStub.fixedString);
        
        syntaxStub.lexer = "Hello%v2error\nWorld%v2something\n%v2other";
        generator.generateGrammar(writerStub, metaStub, bean, null, null);
        assertEquals("Hello\nWorld\n", writerStub.fixedString);
        
        
        // assert k = 1 means backtrack = true is set
        syntaxStub.syntaxK = 1;
        generator.generateGrammar(writerStub, metaStub, bean, null, null);
        assertEquals("k = 1;", writerStub.grammarOptions);
        
        syntaxStub.syntaxK = -1;
        generator.generateGrammar(writerStub, metaStub, bean, null, null);
        assertEquals("backtrack = true;", writerStub.grammarOptions);
        
        syntaxStub.syntaxK = 0;
        generator.generateGrammar(writerStub, metaStub, bean, null, null);
        assertEquals(null, writerStub.grammarOptions);
        
        syntaxStub.syntaxK = 2;
        generator.generateGrammar(writerStub, metaStub, bean, null, null);
        assertEquals("k = 2;", writerStub.grammarOptions);
    }
    
    @Test
    public void testGenerateGrammarAdditionalLexerMembers() throws Exception {
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        MetaLookupStub metaStub = new MetaLookupStub();
        
        
        ConcreteSyntaxStub syntaxStub = new ConcreteSyntaxStub();
        Set<Keyword> keywordSet = new HashSet<Keyword>();
        TCSSyntaxContainerBean bean = new TCSSyntaxContainerBean();
        bean.setSyntax(syntaxStub);
        bean.setKeywords(keywordSet);
        
        ANTLRGrammarGenerator generator = new ANTLRGrammarGenerator();

        syntaxStub.lexer = "test1@lexer::members [[testcontent]]test2";
        generator.generateGrammar(writerStub, metaStub, bean, null, null);
        assertEquals(StringListHelper.list("testcontent"), writerStub.additionalMembers);
        assertEquals("test1test2", writerStub.fixedString);
    }

}
