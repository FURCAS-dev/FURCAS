package com.sap.furcas.parsergenerator.tcs.scenario;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.base.FileBasedEcoreMetaModelLookUp;
import com.sap.furcas.parsergenerator.base.ExtendedGeneratedParserBasedTest;
import com.sap.furcas.parsergenerator.tcs.t2m.InputStreamBasedTCSGrammarGenerator;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.ObservationDirectivesHelper;

public class GrammarTest extends ExtendedGeneratedParserBasedTest {

    @BeforeClass
    public static void setup() {
        ObservationDirectivesHelper.doAddObserverParts = ObservationDirectivesHelper.NONE;
    }

    @Test
    public void testBibTextGrammarGeneration() throws Exception {

        // this test relies on the contents of the BibText sample file
        File sample = new File("scenarioTestResource/Bibtext.tcs");
        assertTrue(sample.exists());
        InputStream in = new FileInputStream(sample);

        OutputStream out = new ByteArrayOutputStream();
        InputStreamBasedTCSGrammarGenerator generator = new InputStreamBasedTCSGrammarGenerator(in, out, new FileBasedEcoreMetaModelLookUp(
                "BibText.ecore", "BibText1.ecore"), "generated");
        generator.generateGrammar(createDefaultResourceSet(), createDefaultReferenceScope(), null);
        out.flush();
        String grammar = out.toString();
        assertTrue(grammar.indexOf("grammar Bibtext") > -1);
        assertTrue(grammar.indexOf("package generated;") > -1);
        assertTrue(grammar.indexOf("import com.sap.furcas.runtime.parser.antlr3.ANTLR3LocationToken") > -1);
        assertTrue(grammar.indexOf("main returns[Object ret2]") > -1);
        assertTrue(grammar.indexOf("public com.sap.furcas.runtime.parser.IModelInjector ei = null;") > -1);

        assertTrue(grammar.indexOf("identifier returns[Object ret2] @init{java.lang.Object ret=null;}") > -1);

        in.close();
        out.close();
    }

    @Test
    public void testExpressionGrammarGeneration() throws Exception {

        // this test relies on the contents of the Expression sample file
        File sample = new File("scenarioTestResource/Expression.tcs");
        assertTrue(sample.exists());
        InputStream in = new FileInputStream(sample);

        OutputStream out = new ByteArrayOutputStream();
        InputStreamBasedTCSGrammarGenerator generator = new InputStreamBasedTCSGrammarGenerator(in, out, new FileBasedEcoreMetaModelLookUp(
                "Expression.ecore"), "generated");
        generator.generateGrammar(createDefaultResourceSet(), createDefaultReferenceScope(), null);
        out.flush();
        String grammar = out.toString();
        assertTrue(grammar.indexOf("grammar Expression;") > -1);
        assertTrue(grammar.indexOf("package generated;") > -1);
        assertTrue(grammar.indexOf("import com.sap.furcas.runtime.parser.antlr3.ANTLR3LocationToken") > -1);
        assertTrue(grammar.indexOf("main returns[Object ret2]") > -1);
        assertTrue(grammar.indexOf("public com.sap.furcas.runtime.parser.IModelInjector ei = null;") > -1);

        assertTrue(grammar
                .indexOf("priority_0 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}") > -1);

        assertTrue(grammar
                .indexOf("priority_0 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}") > -1);
        assertTrue(grammar.indexOf("primary_expression_expression returns[Object ret2]") > -1);
        assertTrue(grammar.indexOf("(LPAREN ret=expression_expression RPAREN))") > -1);

        in.close();
        out.close();
    }
}
