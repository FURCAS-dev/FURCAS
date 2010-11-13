package com.sap.furcas.parsergenerator.tcs.grammar;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.FURCASPackage;
import com.sap.furcas.modeladaptation.emf.lookup.FileBasedEcoreMetaModelLookUp;
import com.sap.furcas.parsergenerator.GrammarGenerationSourceConfiguration;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.parsergenerator.tcs.generator.SyntaxParser;
import com.sap.furcas.parsergenerator.tcs.t2m.ModelBasedTCSGrammarGenerator;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.ObservationDirectivesHelper;
import com.sap.furcas.test.fixture.FixtureData;

/**
 * Simple test case that assures we can generate an ANTLR grammar from a given syntax definition.
 */
public class GrammarGenerationTest {

    @BeforeClass
    public static void setup() {
        ObservationDirectivesHelper.doAddObserverParts = ObservationDirectivesHelper.NONE;
    }

    @Test
    public void testBibTextGrammarGeneration() throws Exception {

        // this test relies on the contents of the BibText sample file
        File sample = FixtureData.BIBTEXT_TCS;
        assertTrue(sample.exists());

        OutputStream out = new ByteArrayOutputStream();

        GrammarGenerationSourceConfiguration sourceConfiguration = new GrammarGenerationSourceConfiguration(
                createResourceSet(), createReferenceScope());

        TCSSyntaxContainerBean syntaxBean = SyntaxParser.parse(sourceConfiguration,sample);
        ModelBasedTCSGrammarGenerator modelBasedGenerator = new ModelBasedTCSGrammarGenerator(out,
                new FileBasedEcoreMetaModelLookUp(FixtureData.BIBTEXT_METAMODEL, FixtureData.BIBTEXT1_METAMODEL), "generated",
                syntaxBean);

        modelBasedGenerator.generateGrammar(createResourceSet(), createReferenceScope(), null);
        out.flush();

        String grammar = out.toString();
        assertTrue(grammar.indexOf("grammar Bibtext") > -1);
        assertTrue(grammar.indexOf("package generated;") > -1);
        assertTrue(grammar.indexOf("import com.sap.furcas.runtime.parser.ANTLR3LocationToken") > -1);
        assertTrue(grammar.indexOf("main returns[Object ret2]") > -1);
        assertTrue(grammar.indexOf("public com.sap.furcas.runtime.parser.IModelInjector ei = null;") > -1);

        assertTrue(grammar.indexOf("identifier returns[Object ret2] @init{java.lang.Object ret=null;}") > -1);

        out.close();
    }

    @Test
    public void testExpressionGrammarGeneration() throws Exception {

        // this test relies on the contents of the Expression sample file
        File sample = FixtureData.EXPRESSION_TCS;
        assertTrue(sample.exists());

        OutputStream out = new ByteArrayOutputStream();

        GrammarGenerationSourceConfiguration sourceConfiguration = new GrammarGenerationSourceConfiguration(
                createResourceSet(), createReferenceScope());

        TCSSyntaxContainerBean syntaxBean = SyntaxParser.parse(sourceConfiguration,sample);
        ModelBasedTCSGrammarGenerator modelBasedGenerator = new ModelBasedTCSGrammarGenerator(out,
                new FileBasedEcoreMetaModelLookUp(FixtureData.EXPRESSION_METAMODEL), "generated", syntaxBean);

        modelBasedGenerator.generateGrammar(createResourceSet(), createReferenceScope(), null);
        out.flush();

        String grammar = out.toString();
        assertTrue(grammar.indexOf("grammar Expression;") > -1);
        assertTrue(grammar.indexOf("package generated;") > -1);
        assertTrue(grammar.indexOf("import com.sap.furcas.runtime.parser.ANTLR3LocationToken") > -1);
        assertTrue(grammar.indexOf("main returns[Object ret2]") > -1);
        assertTrue(grammar.indexOf("public com.sap.furcas.runtime.parser.IModelInjector ei = null;") > -1);

        assertTrue(grammar
                .indexOf("priority_0 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}") > -1);

        assertTrue(grammar
                .indexOf("priority_0 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}") > -1);
        assertTrue(grammar.indexOf("primary_expression_expression returns[Object ret2]") > -1);
        assertTrue(grammar.indexOf("(LPAREN ret=expression_expression RPAREN))") > -1);

        out.close();
    }

    private static Set<URI> createReferenceScope() {
        Set<URI> referenceScope = Collections.emptySet();
        return referenceScope;
    }

    private static ResourceSet createResourceSet() {
        ResourceSet resourceSet = new ResourceSetImpl();
        resourceSet.getPackageRegistry().put(FURCASPackage.eNS_URI, FURCASPackage.eINSTANCE);
        resourceSet.getPackageRegistry().put(FURCASPackage.eNAME, FURCASPackage.eINSTANCE);
        return resourceSet;
    }
}
