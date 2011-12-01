package com.sap.furcas.prettyprinter.scenario;

import static com.sap.furcas.prettyprinter.testutils.PrettyPrintAssertionUtil.assertEqualsByLines;
import static com.sap.furcas.prettyprinter.testutils.PrettyPrintTestHelper.prettyPrintTextBlock;
import static com.sap.furcas.prettyprinter.testutils.PrettyPrintTestHelper.readFile;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.SpaceKind;
import com.sap.furcas.metamodel.FURCAS.TCS.Symbol;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSFactory;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.parser.tcs.TCSParserFactory;
import com.sap.furcas.parser.tcs.TCSSyntaxDefinition;
import com.sap.furcas.parsergenerator.GrammarGenerationSourceConfiguration;
import com.sap.furcas.parsergenerator.TCSParserGenerator;
import com.sap.furcas.parsergenerator.TCSParserGeneratorFactory;
import com.sap.furcas.prettyprinter.testutils.PrettyPrintAssertionUtil;
import com.sap.furcas.prettyprinter.testutils.PrettyPrintTestHelper;
import com.sap.furcas.runtime.parser.incremental.testbase.TcsTestHelper;
import com.sap.furcas.runtime.parser.testbase.FailOnErrorErrorHandler;
import com.sap.furcas.runtime.textblocks.model.TextBlocksModel;
import com.sap.furcas.runtime.textblocks.testutils.EMFTextBlocksModelElementFactory;
import com.sap.furcas.runtime.textblocks.testutils.TestSourceTextBlockCreator;
import com.sap.furcas.runtime.textblocks.testutils.TextBlocksModelElementFactory;
import com.sap.furcas.test.testutils.ResourceTestHelper;
import com.sap.furcas.utils.projects.FileReadHelper;
import com.sap.ide.cts.parser.incremental.IncrementalParserFacade;

public class TestPrettyPrintTCS {

    private final TCSFactory modelFactory = TCSFactory.eINSTANCE;
    private static ConcreteSyntax syntax;
    
    @Rule
    public final TemporaryFolder tmpFolder = new TemporaryFolder();
    private static Set<URI> referenceScope;


    @BeforeClass
    public static void init() {
        referenceScope = ResourceTestHelper.createFURCASReferenceScope();
        referenceScope.addAll(ResourceTestHelper.createEcoreReferenceScope());
        ResourceSet resourceSet = ResourceTestHelper.createResourceSet();
        
        TCSParserFactory factory = new TCSParserFactory();
        syntax = (ConcreteSyntax) resourceSet.getEObject(URI.createURI(factory.getSyntaxUUID()), /*load*/true);
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
        String reprintedTCS = PrettyPrintTestHelper.prettyPrintString(syntax, syntax, referenceScope);
        assertTrue(reprintedTCS.startsWith("syntax TCS"));
        assertTrue(reprintedTCS.endsWith("}"));
        
        // write to file
        File tmpFile = tmpFolder.newFile("reprinted.tcs");
        FileWriter out = new FileWriter(tmpFile);
        out.write(reprintedTCS);
        out.close();
        
        // parse the tmpFile
        TCSParserGenerator generator = TCSParserGeneratorFactory.INSTANCE.createTCSParserGenerator();
        Set<URI> refScope = ResourceTestHelper.createFURCASReferenceScope();
        refScope.addAll(ResourceTestHelper.createEcoreReferenceScope());
        ConcreteSyntax reparsedSyntax = generator.parseSyntax(new GrammarGenerationSourceConfiguration(ResourceTestHelper.createResourceSet(),
                refScope), tmpFile, new FailOnErrorErrorHandler()).getSyntax();
        assertNotNull(reparsedSyntax);
        
        // reprint the new syntax model yet another time.
        // Obviously both pretty print results should be equal.
        TextBlock reprintedTCS2 = PrettyPrintTestHelper.prettyPrintTextBlock(reparsedSyntax, syntax, new TCSParserFactory());
        
        assertEqualsByLines(reprintedTCS2, reprintedTCS);
    }
    
    /** 
     * Print the TCS model and then check if it can be parsed again.
     * Use a pre-existing TextBlock to re-use comments and formatting.
     */
    @Test
    public void testPrettyPrintWithReuse() throws Exception {
        IncrementalParserFacade incrementalParserFacade = TcsTestHelper.createTCSIncrementalParserFacade();
        
        TextBlocksModelElementFactory factory = new EMFTextBlocksModelElementFactory();
        AbstractToken tcsTcsContent = factory.createToken("");
        TextBlock root = TestSourceTextBlockCreator.initialiseTextBlocksWithContentToken(factory, tcsTcsContent);
        
        FileInputStream in = new FileInputStream(TCSSyntaxDefinition.TCS_TCS);
        String referenceContent = FileReadHelper.readInput(in);

        TextBlocksModel tbModel = new TextBlocksModel(root);
        tbModel.replace(0, 0, referenceContent);
        root = incrementalParserFacade.parseIncrementally(root);

        // Incremental reprint.
        TextBlock reprinted = PrettyPrintTestHelper.prettyPrintTextBlock(IncrementalParserFacade.getParsingResult(root),
                root, new TCSParserFactory());
        
        // FIXME: Workaround for missing formatting re-use between primitive-typed lists.
        String reprintedContent = reprinted.getCachedString().replace("createAs = FURCAS:: TCS:: Keyword", "createAs = FURCAS::TCS::Keyword");
        
        // Unfortunately the TCS Syntax definition is not "determinstic". There are certain things
        // that the pretty printer cannot know solely from the syntax definition. We have to fix those.
        reprintedContent = reprintedContent.replace("FURCAS:: TCS::", "TCS::");
        reprintedContent = reprintedContent.replace("\n    \n    \n    keywords {\r\n\r\n}", "");
        
        assertEqualsByLines(reprintedContent, referenceContent);
    }

}
