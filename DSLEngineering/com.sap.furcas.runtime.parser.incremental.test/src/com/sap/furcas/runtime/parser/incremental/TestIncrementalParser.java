package com.sap.furcas.runtime.parser.incremental;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.OmittedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.incremental.testbase.GeneratedParserAndFactoryBasedTest;
import com.sap.furcas.runtime.parser.incremental.testbase.GeneratedParserAndFactoryTestConfiguration;
import com.sap.furcas.runtime.parser.incremental.testbase.MockPartitionAssignmentHandler;
import com.sap.furcas.runtime.textblocks.TbNavigationUtil;
import com.sap.furcas.runtime.textblocks.TbUtil;
import com.sap.furcas.runtime.textblocks.model.TextBlocksModel;
import com.sap.furcas.runtime.textblocks.modifcation.TbChangeUtil;
import com.sap.furcas.runtime.textblocks.testutils.EMFTextBlocksModelElementFactory;
import com.sap.furcas.runtime.textblocks.testutils.TestSourceTextBlockCreator;
import com.sap.furcas.runtime.textblocks.testutils.TextBlocksModelElementFactory;
import com.sap.furcas.test.fixture.ScenarioFixtureData;
import com.sap.furcas.test.testutils.ResourceTestHelper;
import com.sap.ide.cts.parser.errorhandling.SemanticParserException;
import com.sap.ide.cts.parser.incremental.IncrementalParserFacade;

public class TestIncrementalParser extends GeneratedParserAndFactoryBasedTest {
    
    private static final String LANGUAGE = "Bibtex";
    private static final File TCS = new File("fixtures/Bibtex.tcs");

    private static final File[] METAMODELS = { ScenarioFixtureData.BIBTEXT_METAMODEL, ScenarioFixtureData.BIBTEXT1_METAMODEL };

    private static IncrementalParserFacade incrementalParserFacade;
    
    private TextBlocksModelElementFactory modelFactory;
    private static Resource transientParsingResource;
    private static ResourceSet resourceSet;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserAndFactoryTestConfiguration testConfig = new GeneratedParserAndFactoryTestConfiguration(LANGUAGE, TCS, METAMODELS);

        resourceSet = testConfig.getSourceConfiguration().getResourceSet();
        
        TCSSyntaxContainerBean syntaxBean = parseSyntax(testConfig);
        transientParsingResource = ResourceTestHelper.createTransientResource(resourceSet);
        
        incrementalParserFacade = generateParserAndParserFactoryForLanguage(syntaxBean, testConfig,
                resourceSet, new MockPartitionAssignmentHandler(transientParsingResource),
                new ClassLookupImpl());
        
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
    public void testIncrementalParserSetup() throws SemanticParserException {
        TextBlock currentVersionTb = createJohnDoe();
        EObject syntaxObject = IncrementalParserFacade.getParsingResult(currentVersionTb);
        
        // assert no exception
        assertNotNull(syntaxObject);
        List<?> entries = getEntries(syntaxObject);
        assertEquals(2, entries.size());
    }


    private TextBlock createJohnDoe() throws SemanticParserException {
        AbstractToken content = modelFactory.createToken("");
        TextBlock root = TestSourceTextBlockCreator.initialiseTextBlocksWithContentToken(modelFactory, content);
        transientParsingResource.getContents().add(root);

        TextBlocksModel tbModel = new TextBlocksModel(root);
        tbModel.replace(0, 0,
                "article{  Testing, \"John Doe\",  year = \"2002\" } author = \"John Doe\".");

        TextBlock currentVersionTb = incrementalParserFacade.parseIncrementally(root);
        return currentVersionTb;
    }
       

    /**
     * Tests whether an simple addition to a textblock is correctly mapped to an
     * insertion in the model without re-creating the parent element.
     *
     * @throws Exception
     */
    @Test
    public void testParseBibTextAddNewSubBlock() throws Exception {
        TextBlock currentVersionTb = createJohnDoe();
        EObject syntaxObject = IncrementalParserFacade.getParsingResult(currentVersionTb);
        // assert no exception
        assertNotNull(syntaxObject);

        EList<?> entries = getEntries(syntaxObject);
        assertEquals(2, entries.size());
        EObject article = (EObject) entries.get(0);

        EList<?> attributes = getArticles(article);
        assertEquals(1, attributes.size());

        TbChangeUtil.cleanUp(currentVersionTb);

        // add a new year to article
        TextBlocksModel tbModel = new TextBlocksModel(currentVersionTb);
        tbModel.replace(31, 0, "year = \"2010\",");
        TextBlock currentVersionTbNew = incrementalParserFacade.parseIncrementally(currentVersionTb);

        // textBlock shouldn't have changed
        assertEquals(currentVersionTb, currentVersionTb);
        EObject syntaxObject2 = IncrementalParserFacade.getParsingResult(currentVersionTbNew);

        // bibtexfile element shouldn't have changed
        assertEquals(syntaxObject, syntaxObject2);

        // article element shouldn't have changed
        entries = (EList<?>) (syntaxObject2).eGet((syntaxObject).eClass().getEStructuralFeature("entries"));
        EObject newArticle = (EObject) entries.get(0);
        assertEquals(article, newArticle);

        attributes = getArticles(article);
        assertEquals(2, attributes.size());
        EObject newYear = (EObject) attributes.get(0);
        assertEquals("2010", newYear.eGet(newYear.eClass().getEStructuralFeature("value")));
    }


    /**
     * Make sure {@link LexedToken#getReferencedElements()} are set as expected.
     * 
     * They should just be set for the reference from Article to Author, but no
     * where else. 
     */
    @Test
    public void testReferencedElements() throws Exception {
        TextBlock currentVersionTb = createJohnDoe();
        EObject syntaxObject = IncrementalParserFacade.getParsingResult(currentVersionTb);
        
        EList<?> entries = getEntries(syntaxObject);
        assertEquals(2, entries.size());
        EObject article = (EObject) entries.get(0);
        EObject author = (EObject) entries.get(1);
        
        Collection<LexedToken> tokensWithSetReference = new ArrayList<LexedToken>();
        
        AbstractToken token = TbNavigationUtil.firstToken(currentVersionTb);
        while (token != null) {
            if (token instanceof LexedToken && ((LexedToken) token).getReferencedElements().size() > 0) {
                tokensWithSetReference.add((LexedToken) token);
            }
            token = TbNavigationUtil.nextToken(token);
        }
        
        assertEquals(1, tokensWithSetReference.size());
        LexedToken lexedToken = tokensWithSetReference.iterator().next();
        
        assertTrue("Should be the token belonging to the article",
                lexedToken.getParent().getCorrespondingModelElements().contains(article));
        
        assertTrue("Token should be pointing to the author",
                lexedToken.getReferencedElements().contains(author));
        assertEquals(1, lexedToken.getReferencedElements().size());

    }
    
    
    /**
     * Different tests asserting how omitted tokens (i.e. whitespaces and comments) are handled
     * by the incremental parser.
     */
    @Test
    public void testOmittedTokens() throws Exception {
        TextBlock textBlock = createJohnDoe();
        TbChangeUtil.cleanUp(textBlock);
        
        Collection<OmittedToken> omittedTokens = extractTokens(textBlock, OmittedToken.class);
        
        // 1) Assert default omitted tokens as initially created by the lexer
        for (OmittedToken token : omittedTokens) {
            assertNull("Should have no sequence element", token.getSequenceElement());
            assertEquals("Each space has an individual token", " ", token.getValue());
        }
        
        // 2) Morph a " " into a comment. Check its state after parsing.
        OmittedToken omittedToken = omittedTokens.iterator().next();
        TextBlocksModel model = new TextBlocksModel(textBlock);
        model.replace(omittedToken.getOffset(), omittedToken.getLength(), "/** A comment */");
        textBlock = incrementalParserFacade.parseIncrementally(model.getRoot());
        TbChangeUtil.cleanUp(textBlock);
        
        OmittedToken comment = extractTokens(textBlock, OmittedToken.class).iterator().next();
        assertEquals("/** A comment */", comment.getValue());
        assertNull("Should have no sequence element either", comment.getSequenceElement());
        assertTrue("Token types should be different", comment.getType() != omittedToken.getType());
        
        // 3) Change all tokens to be whitespaces (this will still be syntactically valid).
        //    Check their state after parsing
        model = new TextBlocksModel(textBlock);
        List<LexedToken> lexedTokens = extractTokens(textBlock, LexedToken.class);
        Collections.reverse(lexedTokens); // replace from right to left so that offset information stays valid
        for (LexedToken token : lexedTokens) {
            assertNotNull("Must have a squence element", token.getSequenceElement());
            model.replace(TbUtil.getAbsoluteOffset(token), token.getLength(), " ");
        }
        textBlock = incrementalParserFacade.parseIncrementally(model.getRoot());
        TbChangeUtil.cleanUp(textBlock);
        
        lexedTokens = extractTokens(textBlock, LexedToken.class);;
        assertEquals("All lexed tokens should be gone", 0, lexedTokens.size());
        
        omittedTokens = extractTokens(textBlock, OmittedToken.class);
        for (OmittedToken token : omittedTokens) {
            assertNull("Should no longer have a sequence element", token.getSequenceElement());
        }
        
    }

    private <T> List<T> extractTokens(TextBlock currentVersionTb, Class<T> clazz) {
        List<T> result = new ArrayList<T>();

        AbstractToken token = TbNavigationUtil.firstToken(currentVersionTb);
        while (token != null) {
            if (clazz.isInstance(token)) {
                result.add(clazz.cast(token));
            }
            token = TbNavigationUtil.nextToken(token);
        }
        return result;
    }

    private EList<?> getArticles(EObject article) {
        return (EList<?>) article.eGet(article.eClass().getEStructuralFeature("attributes"));
    }

    private EList<?> getEntries(EObject syntaxObject) {
        return (EList<?>) (syntaxObject).eGet((syntaxObject).eClass().getEStructuralFeature("entries"));
    }

    
    
    
}
