/**
 * 
 */
package com.sap.furcas.runtime.parser.incremental;

import static com.sap.furcas.runtime.common.util.FileResourceHelper.getResourceSetAsScope;
import static com.sap.furcas.runtime.common.util.FileResourceHelper.loadResourceSet;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.antlr.runtime.Lexer;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.TCS.Block;
import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.LiteralRef;
import com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.parser.tcs.TCSParserFactory;
import com.sap.furcas.runtime.parser.ParserFactory;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.parser.testbase.MockPartitionAssignmentHandler;
import com.sap.furcas.runtime.textblocks.model.TextBlocksModel;
import com.sap.furcas.runtime.textblocks.modifcation.TbChangeUtil;
import com.sap.furcas.runtime.textblocks.testutils.EMFTextBlocksModelElementFactory;
import com.sap.furcas.runtime.textblocks.testutils.TestSourceTextBlockCreator;
import com.sap.furcas.runtime.textblocks.testutils.TextBlocksModelElementFactory;
import com.sap.furcas.test.fixture.ScenarioFixtureData;
import com.sap.furcas.test.testutils.ResourceTestHelper;
import com.sap.ide.cts.parser.incremental.IncrementalParserFacade;

public class TestParsingObserverWithTcsSyntax {

    private IncrementalParserFacade incrementalParserFacade;
    private TextBlocksModelElementFactory modelFactory;
    private Resource transientParsingResource;
    private ResourceSet resourceSet;

    private void setupParserFor(final Set<URI> metamodels) throws Exception {
        resourceSet = ResourceTestHelper.createResourceSet();
        transientParsingResource = ResourceTestHelper.createTransientResource(resourceSet);
        
        ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory = new TCSParserFactory() {
            /**
             * We must be able to reference the metamodels to which the different TCS
             * languages that we parse refer to.
             */
            @Override
            public Set<URI> getAdditionalQueryScope() {
                return metamodels;
            }
        };

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
        transientParsingResource.delete(/*options*/ null);
    }

    @Test
    public void testParseTcsItself() throws Exception {
        File[] metamodels = { ScenarioFixtureData.TCS_OBSOLETE_METAMODEL };
        ResourceSet metamodelResources = loadResourceSet(metamodels);
        setupParserFor(getResourceSetAsScope(metamodelResources));
        
        AbstractToken content = modelFactory.createToken("");
        TextBlock root = TestSourceTextBlockCreator.initialiseTextBlocksWithContentToken(modelFactory, content);

        TextBlocksModel tbModel = new TextBlocksModel(root);
        tbModel.replace(0, 0, getTcsFileContent(ScenarioFixtureData.TCS_OBSOLETE_TCS));

        TextBlock currentVersionTb = incrementalParserFacade.parseIncrementally(root);
        Object syntaxObject = currentVersionTb.getCorrespondingModelElements().iterator().next();
        // assert no exception
        assertNotNull(syntaxObject);
        ConcreteSyntax syntax = (ConcreteSyntax) syntaxObject;
        assertEquals("TCSObsolete", syntax.getName());
        assertEquals(78, syntax.getTemplates().size());

        assertNotNull(currentVersionTb); // future version
        assertEquals(152, currentVersionTb.getSubNodes().size());
    }

    @Test
    public void testParseBibText() throws Exception {
        File[] metamodels = { ScenarioFixtureData.BIBTEXT1_METAMODEL, ScenarioFixtureData.BIBTEXT_METAMODEL };
        ResourceSet metamodelResources = loadResourceSet(metamodels);
        setupParserFor(getResourceSetAsScope(metamodelResources));
        
        AbstractToken content = modelFactory.createToken("");
        TextBlock root = TestSourceTextBlockCreator.initialiseTextBlocksWithContentToken(modelFactory, content);

        TextBlocksModel tbModel = new TextBlocksModel(root);
        tbModel.replace(0, 0, getTcsFileContent(ScenarioFixtureData.BIBTEXT_TCS));

        TextBlock currentVersionTb = incrementalParserFacade.parseIncrementally(root);
        Object syntaxObject = currentVersionTb.getCorrespondingModelElements().iterator().next();
        // assert no exception
        assertNotNull(syntaxObject);
        ConcreteSyntax syntax = (ConcreteSyntax) syntaxObject;
        assertEquals("Bibtext", syntax.getName());
        assertEquals(7, syntax.getTemplates().size());

        assertNotNull(currentVersionTb); // future version
        assertEquals(81, currentVersionTb.getSubNodes().size());
    }

    @Test
    public void testMinimalSyntax() throws Exception {
        HashSet<URI> metamodels = new HashSet<URI>();
        metamodels.addAll(ResourceTestHelper.createFURCASReferenceScope());
        setupParserFor(metamodels);
        
        String syntaxString = "syntax test{}";

        AbstractToken content = modelFactory.createToken("");
        TextBlock root = TestSourceTextBlockCreator.initialiseTextBlocksWithContentToken(modelFactory, content);

        TextBlocksModel tbModel = new TextBlocksModel(root);
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
        HashSet<URI> metamodels = new HashSet<URI>();
        metamodels.addAll(ResourceTestHelper.createFURCASReferenceScope());
        setupParserFor(metamodels);
        
        String syntaxString = "syntax test{template ClassTemplate main :\"foo\";}";

        AbstractToken content = modelFactory.createToken("");
        TextBlock root = TestSourceTextBlockCreator.initialiseTextBlocksWithContentToken(modelFactory, content);

        TextBlocksModel tbModel = new TextBlocksModel(root);
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
        assertEquals("ClassTemplate", fooTemplate.getMetaReference().getName());
    }

    @Test
    public void testMinimalSyntaxWith2PrimitiveTemps() throws Exception {
        HashSet<URI> metamodels = new HashSet<URI>();
        metamodels.addAll(ResourceTestHelper.createEcoreReferenceScope());
        setupParserFor(metamodels);

        String syntaxString = "syntax test{\r\n"
                + "    primitiveTemplate identifier for EString using NAME:value=\"%token%\";\r\n"
                + "    primitiveTemplate name for EString using NAME:value=\"%token%\";\r\n" + "}";

        AbstractToken content = modelFactory.createToken("");
        TextBlock root = TestSourceTextBlockCreator.initialiseTextBlocksWithContentToken(modelFactory, content);

        TextBlocksModel tbModel = new TextBlocksModel(root);
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
        HashSet<URI> metamodels = new HashSet<URI>();
        metamodels.addAll(ResourceTestHelper.createEcoreReferenceScope());
        setupParserFor(metamodels);

        String syntaxString = "\r\n  \r\n\tsyntax test {\r\n  \r\n  \r\n  template ecore::EClass main \r\n  :  \"foo\"\r\n  ;}";

        AbstractToken content = modelFactory.createToken("");
        TextBlock root = TestSourceTextBlockCreator.initialiseTextBlocksWithContentToken(modelFactory, content);

        TextBlocksModel tbModel = new TextBlocksModel(root);
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
        assertEquals("EClass", fooTemplate.getMetaReference().getName());
    }

    @Test
    public void testParseATL() throws Exception {
        File[] metamodels = { ScenarioFixtureData.ATL_METAMODEL };
        ResourceSet metamodelResources = loadResourceSet(metamodels);
        setupParserFor(getResourceSetAsScope(metamodelResources));

        File syntaxDefFile = ScenarioFixtureData.ATL_TCS;

        AbstractToken content = modelFactory.createToken("");
        TextBlock root = TestSourceTextBlockCreator.initialiseTextBlocksWithContentToken(modelFactory, content);

        TextBlocksModel tbModel = new TextBlocksModel(root);
        tbModel.replace(0, 0, getTcsFileContent(syntaxDefFile));

        TextBlock currentVersionTb = incrementalParserFacade.parseIncrementally(root);
        Object syntaxObject = currentVersionTb.getCorrespondingModelElements().iterator().next();
        // assert no exception
        assertNotNull(syntaxObject);
        ConcreteSyntax syntax = (ConcreteSyntax) syntaxObject;
        assertEquals("ATL", syntax.getName());
        assertEquals(85, syntax.getTemplates().size());

        assertNotNull(currentVersionTb); // future version
        assertEquals(176, currentVersionTb.getSubNodes().size());
    }
	
    /**
     * Tests whether a reference where the reference by value was replaced is
     * correctly set to thw new value;
     */
    @Test
    public void testParseBibTextReplaceReference() throws Exception {
        File[] metamodels = { ScenarioFixtureData.BIBTEXT1_METAMODEL, ScenarioFixtureData.BIBTEXT_METAMODEL };
        ResourceSet metamodelResources = loadResourceSet(metamodels);
        setupParserFor(getResourceSetAsScope(metamodelResources));
        
        AbstractToken content = modelFactory.createToken("");
        TextBlock root = TestSourceTextBlockCreator.initialiseTextBlocksWithContentToken(modelFactory, content);
        transientParsingResource.getContents().add(root);

        TextBlocksModel tbModel = new TextBlocksModel(root);
        String tcsContent = getTcsFileContent(ScenarioFixtureData.BIBTEXT_TCS);
        tbModel.replace(0, 0, tcsContent);

        TextBlock currentVersionTb = incrementalParserFacade.parseIncrementally(root);
        ConcreteSyntax syntaxObject = (ConcreteSyntax) currentVersionTb.getCorrespondingModelElements().iterator().next();
        // assert no exception
        assertNotNull(syntaxObject);
        ConcreteSyntax syntax = syntaxObject;
        assertEquals("Bibtext", syntax.getName());
        assertEquals(7, syntax.getTemplates().size());

        Template article = syntaxObject.getTemplates().get(3);

        assertNotNull(currentVersionTb); // future version
        assertEquals(81, currentVersionTb.getSubNodes().size());

        TbChangeUtil.cleanUp(currentVersionTb);
        // replace a reference that referred to the "." token with one that
        // refers to the "{" token
        tbModel = new TextBlocksModel(currentVersionTb);
        tbModel.replace(tcsContent.indexOf(","), 1, "{");
        TextBlock currentVersionTbNew = incrementalParserFacade.parseIncrementally(currentVersionTb);
        // textBlock shouldn't have changed
        assertEquals(currentVersionTb, currentVersionTb);
        ConcreteSyntax syntaxObject2 = (ConcreteSyntax) currentVersionTbNew.getCorrespondingModelElements().iterator().next();

        // syntax element shouldn't have changed
        assertEquals(syntaxObject, syntaxObject2);

        ClassTemplate article2 = (ClassTemplate) syntaxObject2.getTemplates().get(3);
        assertEquals(article, article2);
        Block b = (Block) article2.getTemplateSequence().getElements().get(2);
        LiteralRef lit = (LiteralRef) b.getBlockSequence().getElements().get(1);
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
