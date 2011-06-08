package com.sap.furcas.runtime.parser.incremental;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
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
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.incremental.testbase.GeneratedParserAndFactoryBasedTest;
import com.sap.furcas.runtime.parser.incremental.testbase.GeneratedParserAndFactoryTestConfiguration;
import com.sap.furcas.runtime.parser.incremental.testbase.MockPartitionAssignmentHandler;
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
        AbstractToken content = modelFactory.createToken("");
        TextBlock root = TestSourceTextBlockCreator.initialiseTextBlocksWithContentToken(modelFactory, content);
        transientParsingResource.getContents().add(root);

        TextBlocksModel tbModel = new TextBlocksModel(root, null);
        tbModel.replace(0, 0,
                "article{  Testing, \"John Doe\",  year = \"2002\" } author = \"John Doe\".");

        TextBlock currentVersionTb = incrementalParserFacade.parseIncrementally(root);
        Object syntaxObject = currentVersionTb.getCorrespondingModelElements().iterator().next();
        
        // assert no exception
        assertNotNull(syntaxObject);
        List<?> entries = (List<?>) ((EObject) syntaxObject).eGet(((EObject) syntaxObject).eClass()
                .getEStructuralFeature("entries"));
        assertEquals(2, entries.size());
    }

     /**
     * Tests whether an simple addition to a textblock is correctly mapped to
     an
     * insertion in the model without re-creating the parent element.
     *
     * @throws Exception
     */
    @Test
     public void testParseBibTextAddNewSubBlock() throws Exception {
         AbstractToken content = modelFactory.createToken("");
         TextBlock root = TestSourceTextBlockCreator.initialiseTextBlocksWithContentToken(modelFactory, content);
         transientParsingResource.getContents().add(root);

         TextBlocksModel tbModel = new TextBlocksModel(root, null);
         tbModel.replace(0, 0, "article{  Testing, \"John Doe\",  year = \"2002\" } author = \"John Doe\".");

         TextBlock currentVersionTb = incrementalParserFacade.parseIncrementally(root);
         EObject syntaxObject = currentVersionTb.getCorrespondingModelElements().iterator().next();
         // assert no exception
         assertNotNull(syntaxObject);

         EList<?> entries = (EList<?>) (syntaxObject).eGet((syntaxObject).eClass().getEStructuralFeature("entries"));
         assertEquals(2, entries.size());
         EObject article = (EObject) entries.get(0);

         EList<?> attributes = (EList<?>) article.eGet(article.eClass().getEStructuralFeature("attributes"));
         assertEquals(1, attributes.size());
    
         TbChangeUtil.cleanUp(currentVersionTb);
         
         // add a new year to article
         tbModel = new TextBlocksModel(currentVersionTb, null);
         tbModel.replace(31, 0, "year = \"2010\",");
         TextBlock currentVersionTbNew = incrementalParserFacade.parseIncrementally(currentVersionTb);
         
         // textBlock shouldn't have changed
         assertEquals(currentVersionTb, currentVersionTb);
         EObject syntaxObject2 = currentVersionTbNew.getCorrespondingModelElements().iterator().next();
        
         // bibtexfile element shouldn't have changed
         assertEquals(syntaxObject, syntaxObject2);
        
         // article element shouldn't have changed
         entries = (EList<?>) (syntaxObject2).eGet((syntaxObject).eClass().getEStructuralFeature("entries"));
         EObject newArticle = (EObject) entries.get(0);
         assertEquals(article, newArticle);
         
         attributes = (EList<?>) article.eGet(article.eClass().getEStructuralFeature("attributes"));
         assertEquals(2, attributes.size());
         EObject newYear = (EObject) attributes.get(0);
         assertEquals("2010", newYear.eGet(newYear.eClass().getEStructuralFeature("value")));
     }
    
}
