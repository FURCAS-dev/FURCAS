/**
 * 
 */
package com.sap.furcas.runtime.parser.incremental;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.antlr.runtime.Lexer;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.ide.parserfactory.AbstractParserFactory;
import com.sap.furcas.metamodel.FURCAS.TCS.Block;
import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.LiteralRef;
import com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.parser.tcs.TCSParserFactory;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.parser.incremental.testbase.MockPartitionAssignmentHandler;
import com.sap.furcas.runtime.textblocks.model.TextBlocksModel;
import com.sap.furcas.runtime.textblocks.modifcation.TbChangeUtil;
import com.sap.furcas.runtime.textblocks.testutils.EMFTextBlocksModelElementFactory;
import com.sap.furcas.runtime.textblocks.testutils.TestSourceTextBlockCreator;
import com.sap.furcas.runtime.textblocks.testutils.TextBlocksModelElementFactory;
import com.sap.furcas.test.fixture.ScenarioFixtureData;
import com.sap.furcas.test.testutils.ResourceTestHelper;
import com.sap.ide.cts.parser.incremental.antlr.IncrementalParserFacade;

public class TestParsingObserverWithTcsSyntax {

    private static IncrementalParserFacade incrementalParserFacade;
    private TextBlocksModelElementFactory modelFactory;
    private static Resource transientParsingResource;
    private static ResourceSet resourceSet;

    @BeforeClass
    public static void setupParser() throws Exception {
        resourceSet = ResourceTestHelper.createResourceSet();
        transientParsingResource = ResourceTestHelper.createTransientResource(resourceSet);
        
        AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory = new TCSParserFactory();
        resourceSet.getResource(parserFactory.getSyntaxResourceURI(), true);

        incrementalParserFacade = new IncrementalParserFacade(parserFactory, resourceSet,
            new MockPartitionAssignmentHandler(transientParsingResource));
        
        ECrossReferenceAdapter crossRefAdapter = new ECrossReferenceAdapter();
        resourceSet.eAdapters().add(crossRefAdapter);
        crossRefAdapter.setTarget(resourceSet);
    }
    
    @Before
    public void setup() {
        modelFactory = new EMFTextBlocksModelElementFactory();
    }
    
    @After
    public void cleanup() throws Exception {
        transientParsingResource.getContents().clear();
    }

    @Test
    @Ignore("Still not working on EMF")
    public void testParseTcsItself() throws Exception {

        AbstractToken content = modelFactory.createToken("");
        TextBlock root = TestSourceTextBlockCreator.initialiseTextBlocksWithContentToken(modelFactory, content);

        TextBlocksModel tbModel = new TextBlocksModel(root, null);
        tbModel.replace(0, 0, getTcsFileContent(ScenarioFixtureData.TCS_OBSOLETE_TCS));

        TextBlock currentVersionTb = incrementalParserFacade.parseIncrementally(root);
        Object syntaxObject = currentVersionTb.getCorrespondingModelElements().iterator().next();
        // assert no exception
        assertNotNull(syntaxObject);
        ConcreteSyntax syntax = (ConcreteSyntax) syntaxObject;
        assertEquals("TCS", syntax.getName());
        assertEquals(80, syntax.getTemplates().size());

        assertNotNull(currentVersionTb); // future version
        assertEquals(155, currentVersionTb.getSubNodes().size());
    }

    @Test
    @Ignore("Still not working on EMF")
    public void testParseBibText() throws Exception {

        AbstractToken content = modelFactory.createToken("");
        TextBlock root = TestSourceTextBlockCreator.initialiseTextBlocksWithContentToken(modelFactory, content);

        TextBlocksModel tbModel = new TextBlocksModel(root, null);
        tbModel.replace(0, 0, getTcsFileContent(ScenarioFixtureData.BIBTEXT_TCS));

        TextBlock currentVersionTb = incrementalParserFacade.parseIncrementally(root);
        Object syntaxObject = currentVersionTb.getCorrespondingModelElements().iterator().next();
        // assert no exception
        assertNotNull(syntaxObject);
        ConcreteSyntax syntax = (ConcreteSyntax) syntaxObject;
        assertEquals("Bibtext", syntax.getName());
        assertEquals(7, syntax.getTemplates().size());

        assertNotNull(currentVersionTb); // future version
        assertEquals(88, currentVersionTb.getSubNodes().size());
    }

    @Test
    public void testMinimalSyntax() throws Exception {

        String syntaxString = "syntax test{}";

        AbstractToken content = modelFactory.createToken("");
        TextBlock root = TestSourceTextBlockCreator.initialiseTextBlocksWithContentToken(modelFactory, content);

        TextBlocksModel tbModel = new TextBlocksModel(root, null);
        tbModel.replace(0, 0, syntaxString);

        TextBlock tb = incrementalParserFacade.parseIncrementally(root);
        Object syntaxObject = tb.getCorrespondingModelElements().iterator().next();
        // assert no exception
        assertNotNull(syntaxObject);
        ConcreteSyntax syntax = (ConcreteSyntax) syntaxObject;
        assertEquals("test", syntax.getName());
        assertEquals(0, syntax.getTemplates().size());

    }

    @Test
    public void testMinimalSyntaxWithMain() throws Exception {

        String syntaxString = "syntax test{template ->Foo main :\"foo\";}";

        AbstractToken content = modelFactory.createToken("");
        TextBlock root = TestSourceTextBlockCreator.initialiseTextBlocksWithContentToken(modelFactory, content);

        TextBlocksModel tbModel = new TextBlocksModel(root, null);
        tbModel.replace(0, 0, syntaxString);

        TextBlock tb = incrementalParserFacade.parseIncrementally(root);
        Object syntaxObject = tb.getCorrespondingModelElements().iterator().next();
        // assert no exception
        assertNotNull(syntaxObject);
        ConcreteSyntax syntax = (ConcreteSyntax) syntaxObject;
        assertEquals("test", syntax.getName());
        assertEquals(1, syntax.getTemplates().size());

        Template fooTemplate = syntax.getTemplates().get(0);
        assertTrue(fooTemplate instanceof ClassTemplate);
        assertEquals("Foo", fooTemplate.getNames().get(0));
    }

    @Test
    public void testMinimalSyntaxWith2PrimitiveTemps() throws Exception {

        String syntaxString = "syntax test{\r\n"
                + "    primitiveTemplate identifier for ->String using NAME:value=\"%token%\";\r\n"
                + "    primitiveTemplate name for ->String using NAME:value=\"%token%\";\r\n" + "}";

        AbstractToken content = modelFactory.createToken("");
        TextBlock root = TestSourceTextBlockCreator.initialiseTextBlocksWithContentToken(modelFactory, content);

        TextBlocksModel tbModel = new TextBlocksModel(root, null);
        tbModel.replace(0, 0, syntaxString);

        TextBlock tb = incrementalParserFacade.parseIncrementally(root);
        Object syntaxObject = tb.getCorrespondingModelElements().iterator().next();
        // assert no exception
        assertNotNull(syntaxObject);
        ConcreteSyntax syntax = (ConcreteSyntax) syntaxObject;
        assertEquals("test", syntax.getName());
        assertEquals(2, syntax.getTemplates().size());

        Template fooTemplate = syntax.getTemplates().get(0);
        assertEquals("identifier", ((PrimitiveTemplate) fooTemplate).getTemplateName());

        Template barTemplate = syntax.getTemplates().get(1);
        assertEquals("name", ((PrimitiveTemplate) barTemplate).getTemplateName());
    }

    @Test
    public void testMinimalSyntaxWithMainAndBlanks() throws Exception {

        String syntaxString = "\r\n  \r\n\tsyntax test {\r\n  \r\n  \r\n  template ->Foo main \r\n  :  \"foo\"\r\n  ;}";

        AbstractToken content = modelFactory.createToken("");
        TextBlock root = TestSourceTextBlockCreator.initialiseTextBlocksWithContentToken(modelFactory, content);

        TextBlocksModel tbModel = new TextBlocksModel(root, null);
        tbModel.replace(0, 0, syntaxString);

        TextBlock tb = incrementalParserFacade.parseIncrementally(root);
        Object syntaxObject = tb.getCorrespondingModelElements().iterator().next();
        // assert no exception
        assertNotNull(syntaxObject);
        ConcreteSyntax syntax = (ConcreteSyntax) syntaxObject;
        assertEquals("test", syntax.getName());
        assertEquals(1, syntax.getTemplates().size());

        Template fooTemplate = syntax.getTemplates().get(0);
        assertTrue(fooTemplate instanceof ClassTemplate);
        assertEquals("Foo", fooTemplate.getNames().get(0));
    }

    @Test
    @Ignore("Still not working on EMF")
    public void testParseATL() throws Exception {

        File syntaxDefFile = ScenarioFixtureData.ATL_TCS;

        AbstractToken content = modelFactory.createToken("");
        TextBlock root = TestSourceTextBlockCreator.initialiseTextBlocksWithContentToken(modelFactory, content);

        TextBlocksModel tbModel = new TextBlocksModel(root, null);
        tbModel.replace(0, 0, getTcsFileContent(syntaxDefFile));

        TextBlock currentVersionTb = incrementalParserFacade.parseIncrementally(root);
        Object syntaxObject = currentVersionTb.getCorrespondingModelElements().iterator().next();
        // assert no exception
        assertNotNull(syntaxObject);
        ConcreteSyntax syntax = (ConcreteSyntax) syntaxObject;
        assertEquals("ATL", syntax.getName());
        assertEquals(85, syntax.getTemplates().size());

        assertNotNull(currentVersionTb); // future version
        assertEquals(183, currentVersionTb.getSubNodes().size());
    }
	
    /**
     * Tests whether a reference where the reference by value was replaced is
     * correctly set to thw new value;
     */
    @Test
    @Ignore("Still not working on EMF")
    public void testParseBibTextReplaceReference() throws Exception {
        AbstractToken content = modelFactory.createToken("");
        TextBlock root = TestSourceTextBlockCreator.initialiseTextBlocksWithContentToken(modelFactory, content);
        transientParsingResource.getContents().add(root);

        TextBlocksModel tbModel = new TextBlocksModel(root, null);
        tbModel.replace(0, 0, getTcsFileContent(ScenarioFixtureData.BIBTEXT_TCS));

        TextBlock currentVersionTb = incrementalParserFacade.parseIncrementally(root);
        ConcreteSyntax syntaxObject = (ConcreteSyntax) currentVersionTb.getCorrespondingModelElements().iterator().next();
        // assert no exception
        assertNotNull(syntaxObject);
        ConcreteSyntax syntax = syntaxObject;
        assertEquals("Bibtext", syntax.getName());
        assertEquals(7, syntax.getTemplates().size());

        Template article = syntaxObject.getTemplates().get(3);

        assertNotNull(currentVersionTb); // future version
        assertEquals(88, currentVersionTb.getSubNodes().size());

        TbChangeUtil.cleanUp(currentVersionTb);
        // replace a reference that referred to the "." token with one that
        // refers to the "{" token
        tbModel = new TextBlocksModel(currentVersionTb, null);
        tbModel.replace(423, 1, "{");
        TextBlock currentVersionTbNew = incrementalParserFacade.parseIncrementally(currentVersionTb);
        // textBlock shouldn't have changed
        assertEquals(currentVersionTb, currentVersionTb);
        ConcreteSyntax syntaxObject2 = (ConcreteSyntax) currentVersionTbNew.getCorrespondingModelElements().iterator().next();

        // syntax element shouldn't have changed
        assertEquals(syntaxObject, syntaxObject2);

        ClassTemplate article2 = (ClassTemplate) syntaxObject2.getTemplates().get(3);
        assertEquals(article, article2);
        Block b = (Block) article2.getTemplateSequence().getElements().get(2);
        LiteralRef lit = (LiteralRef) b.getBlockSequence().getElements().get(3);
        assertEquals("{", lit.getReferredLiteral().getValue());
    }
	    
    private String getTcsFileContent(File syntaxDefFile) {
        String content = null;
        if (syntaxDefFile != null) {
            try {
                FileInputStream inputStream = new FileInputStream(syntaxDefFile);
                StringBuilder out = new StringBuilder();
                byte[] b = new byte[4096];
                for (int n; (n = inputStream.read(b)) != -1;) {
                    out.append(new String(b, 0, n));
                }
                content = out.toString();
                inputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return content;
    }

}
