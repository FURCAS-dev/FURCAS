package com.sap.furcas.unparser.scenario;

import static com.sap.furcas.unparser.testutils.PrettyPrintAssertionUtil.assertEqualsByLines;
import static com.sap.furcas.unparser.testutils.PrettyPrintTestHelper.prettyPrintTextBlock;
import static com.sap.furcas.unparser.testutils.PrettyPrintTestHelper.readFile;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileWriter;

import org.eclipse.emf.ecore.EAttribute;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.SpaceKind;
import com.sap.furcas.metamodel.FURCAS.TCS.Symbol;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSFactory;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.parser.tcs.TCSParserFactory;
import com.sap.furcas.parser.tcs.TCSSyntaxDefinition;
import com.sap.furcas.parsergenerator.GrammarGenerationSourceConfiguration;
import com.sap.furcas.parsergenerator.TCSParserGenerator;
import com.sap.furcas.parsergenerator.TCSParserGeneratorFactory;
import com.sap.furcas.runtime.common.exceptions.ParserGeneratorInvocationException;
import com.sap.furcas.runtime.common.exceptions.ParserInvokationException;
import com.sap.furcas.test.testutils.ResourceTestHelper;
import com.sap.furcas.unparser.testutils.PrettyPrintAssertionUtil;
import com.sap.furcas.unparser.testutils.PrettyPrintTestHelper;

public class TestPrettyPrintTCS {

    private final TCSFactory modelFactory = TCSFactory.eINSTANCE;
    private static ConcreteSyntax syntax;
    
    @Rule
    public final TemporaryFolder tmpFolder = new TemporaryFolder();


    @BeforeClass
    public static void init() throws ParserGeneratorInvocationException, ParserInvokationException {
        TCSParserGenerator generator = TCSParserGeneratorFactory.INSTANCE.createTCSParserGenerator();
        syntax = generator.parseSyntax(new GrammarGenerationSourceConfiguration(ResourceTestHelper.createResourceSet(),
                ResourceTestHelper.createFURCASReferenceScope()), TCSSyntaxDefinition.TCS_TCS).getSyntax();
    }

    @Test
    public void testSyntaxOnly() throws Exception {
        ConcreteSyntax concreteSyntax = modelFactory.createConcreteSyntax();
        concreteSyntax.setName("SimpleSyntax");

        TextBlock output = prettyPrintTextBlock(concreteSyntax, syntax, new TCSParserFactory());
        PrettyPrintAssertionUtil.assertEqualsByLines(output, readFile("fixtureData/TCS_SyntaxOnly.out"));
    }

    @Test
    public void testSyntaxWithMainClassTemplateMetaReference() throws Exception  {
        ConcreteSyntax concreteSyntax = modelFactory.createConcreteSyntax();
        concreteSyntax.setName("SyntaxWithMainClassTemplateMetaReference");

        ClassTemplate template = modelFactory.createClassTemplate();
        template.setIsMain(true);

        EAttribute attr = (EAttribute) concreteSyntax.eClass().getEStructuralFeature("name");
        template.setMetaReference(attr.getEType());

        concreteSyntax.getTemplates().add(template);

        TextBlock output = prettyPrintTextBlock(concreteSyntax, syntax, new TCSParserFactory());
        assertEqualsByLines(output, readFile("fixtureData/TCS_SyntaxWithMainClassTemplateMetaReference.out"));
    }

    @Test
    public void testSyntaxWithSymbols() throws Exception {
        ConcreteSyntax concreteSyntax = modelFactory.createConcreteSyntax();
        concreteSyntax.setName("SyntaxWithSymbols");

        Symbol sym = modelFactory.createSymbol();
        sym.setName("lsquare");
        sym.setValue("[");
        sym.getSpaces().add(SpaceKind.LEFT_SPACE);
        sym.getSpaces().add(SpaceKind.RIGHT_NONE);
        concreteSyntax.getSymbols().add(sym);

        sym = modelFactory.createSymbol();
        sym.setName("rsquare");
        sym.setValue("]");
        concreteSyntax.getSymbols().add(sym);

        sym = modelFactory.createSymbol();
        sym.setName("dlsquare");
        sym.setValue("[[");
        sym.getSpaces().add(SpaceKind.LEFT_NONE);
        sym.getSpaces().add(SpaceKind.RIGHT_NONE);
        concreteSyntax.getSymbols().add(sym);

        sym = modelFactory.createSymbol();
        sym.setName("drsquare");
        sym.setValue("]]");
        sym.getSpaces().add(SpaceKind.RIGHT_SPACE);
        concreteSyntax.getSymbols().add(sym);

        TextBlock output = PrettyPrintTestHelper.prettyPrintTextBlock(concreteSyntax, syntax, new TCSParserFactory());
        assertEqualsByLines(output, readFile("fixtureData/TCS_SyntaxWithSymbols.out"));
    }
    
    /** 
     * Print the TCS model and then check if it can be parsed again.
     * 
     * No much validation on the pretty printed result is performed, as we cannot
     * compare it to the source TCS.tcs due to missing comments and extended keywords.
     * 
     * Reparsing asserts that all constructs used in the TCS can be printed correctly.
     * Common errors are that a name is quoted when it shouldn't be or that it is missing
     * entirely because the feature is not supported by the pretty printer.
     * With this test we can detect such errors.
     */
    @Test
    public void testPrettyPrintTCS() throws Exception {
        String reprintedTCS = PrettyPrintTestHelper.prettyPrintString(syntax, syntax);
        assertTrue(reprintedTCS.startsWith("syntax TCS"));
        assertTrue(reprintedTCS.endsWith("}"));
        
        // write to file
        File tmpFile = tmpFolder.newFile("reprinted.tcs");
        FileWriter out = new FileWriter(tmpFile);
        out.write(reprintedTCS);
        out.close();
        
        // parse the tmpFile
        TCSParserGenerator generator = TCSParserGeneratorFactory.INSTANCE.createTCSParserGenerator();
        ConcreteSyntax reparsedSyntax = generator.parseSyntax(new GrammarGenerationSourceConfiguration(ResourceTestHelper.createResourceSet(),
                ResourceTestHelper.createFURCASReferenceScope()), tmpFile).getSyntax();
        assertNotNull(reparsedSyntax);
        
        // reprint the new syntax model yet another time.
        // Obviously both pretty print results should be equal.
        TextBlock reprintedTCS2 = PrettyPrintTestHelper.prettyPrintTextBlock(reparsedSyntax, syntax, new TCSParserFactory());
        
        assertEqualsByLines(reprintedTCS2, reprintedTCS);
    }

}
