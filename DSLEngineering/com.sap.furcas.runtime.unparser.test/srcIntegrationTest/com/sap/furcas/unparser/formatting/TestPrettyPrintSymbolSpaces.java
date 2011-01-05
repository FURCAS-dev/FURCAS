package com.sap.furcas.unparser.formatting;

import static com.sap.furcas.unparser.testutils.PrettyPrintTestHelper.readFile;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSFactory;
import com.sap.furcas.parsergenerator.GrammarGenerationSourceConfiguration;
import com.sap.furcas.parsergenerator.TCSParserGenerator;
import com.sap.furcas.parsergenerator.TCSParserGeneratorFactory;
import com.sap.furcas.test.testutils.ResourceTestHelper;
import com.sap.furcas.unparser.testutils.PrettyPrintAssertionUtil;
import com.sap.furcas.unparser.testutils.PrettyPrintTestHelper;



public class TestPrettyPrintSymbolSpaces  {

    private static ConcreteSyntax syntax;

    @BeforeClass
    public static void setupParser() throws Exception {
        File syntaxFile = new File("fixtureData/SymbolSpaces.tcs");
        TCSParserGenerator generator = TCSParserGeneratorFactory.INSTANCE.createTCSParserGenerator();
        syntax = generator.parseSyntax(new GrammarGenerationSourceConfiguration(ResourceTestHelper.createResourceSet(),
                ResourceTestHelper.createFURCASReferenceScope()), syntaxFile).getSyntax();
    }

    @Test
    public void testSymbolSpacesCombinations() throws Exception {
        ConcreteSyntax modelElement = TCSFactory.eINSTANCE.createConcreteSyntax();
        modelElement.setName("name");

        String output = PrettyPrintTestHelper.prettyPrintString(modelElement, syntax);
        PrettyPrintAssertionUtil.assertEqualsByLines(output, readFile("fixtureData/SymbolSpaces_Combinations.out"));
    }

}
