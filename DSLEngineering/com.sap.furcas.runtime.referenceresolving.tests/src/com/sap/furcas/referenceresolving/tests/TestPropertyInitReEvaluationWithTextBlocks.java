package com.sap.furcas.referenceresolving.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ocl.ecore.opposites.DefaultOppositeEndFinder;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.incremental.testbase.GeneratedParserAndFactoryBasedTest;
import com.sap.furcas.runtime.parser.incremental.testbase.GeneratedParserAndFactoryTestConfiguration;
import com.sap.furcas.runtime.textblocks.model.TextBlocksModel;
import com.sap.furcas.runtime.textblocks.testutils.EMFTextBlocksModelElementFactory;
import com.sap.furcas.runtime.textblocks.testutils.TestSourceTextBlockCreator;
import com.sap.furcas.runtime.textblocks.testutils.TextBlocksModelElementFactory;
import com.sap.furcas.test.fixture.ScenarioFixtureData;
import com.sap.furcas.test.testutils.ResourceTestHelper;
import com.sap.ide.cts.parser.incremental.antlr.IncrementalParserFacade;

public class TestPropertyInitReEvaluationWithTextBlocks extends GeneratedParserAndFactoryBasedTest {
    
    private static final String LANGUAGE = "BibtexWithPropertyInits";
    private static final File TCS = new File("fixtures/BibtexWithPropertyInits.tcs");

    private static final File[] METAMODELS = { ScenarioFixtureData.BIBTEXT_METAMODEL, ScenarioFixtureData.BIBTEXT1_METAMODEL };
    private static final String MM_PACKAGE_NAME = "BibText";

    private static IncrementalParserFacade incrementalParserFacade;
    
    private TextBlocksModelElementFactory modelFactory;
    private Resource transientParsingResource;
    private static ResourceSet resourceSet;


    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserAndFactoryTestConfiguration testConfig = new GeneratedParserAndFactoryTestConfiguration(LANGUAGE, TCS, MM_PACKAGE_NAME, METAMODELS);

        resourceSet = testConfig.getSourceConfiguration().getResourceSet();
        EditingDomain editingDomain = new AdapterFactoryEditingDomain(new AdapterFactoryImpl(),
                new BasicCommandStack(), resourceSet);

        OppositeEndFinder oppositeEndFinder = DefaultOppositeEndFinder.getInstance();
        
        TCSSyntaxContainerBean syntaxBean = parseSyntax(testConfig);
        incrementalParserFacade = generateParserAndParserFactoryForLanguage(syntaxBean, testConfig,
                editingDomain, oppositeEndFinder, new ClassLookupImpl());
        
        ECrossReferenceAdapter crossRefAdapter = new ECrossReferenceAdapter();
        resourceSet.eAdapters().add(crossRefAdapter);
        crossRefAdapter.setTarget(resourceSet);
    }

    @Before
    public void setup() {
        modelFactory = new EMFTextBlocksModelElementFactory();
        transientParsingResource = ResourceTestHelper.createTransientResource(resourceSet);
    }
    
    @After
    public void cleanup() throws Exception {
        transientParsingResource.delete(/*options*/ null);
    }
    
    /**
     * Tests whether an simple addition to a textblock is correctly mapped to an insertion in the model without
     * re-creating the parent element.
     * 
     * @throws Exception
     */
    @Test
    public void testParseBibTextAddNewSubBlock() throws Exception {
        AbstractToken content = modelFactory.createToken("");
        TextBlock root = TestSourceTextBlockCreator.initialiseTextBlocksWithContentToken(modelFactory, content);
        transientParsingResource.getContents().add(root);

        TextBlocksModel tbModel = new TextBlocksModel(root, null);
        tbModel.replace(0, 0, "article{" + "  Testing, \"John Doe\"," + "  year = \"2002\"" + "}" +
                "author = \"John Doe\"." + "author = \"Jane Doll\".");

        TextBlock currentVersionTb = incrementalParserFacade.parseIncrementally(root);
        EObject syntaxObject = currentVersionTb.getCorrespondingModelElements().iterator().next();
        // assert no exception
        assertNotNull(syntaxObject);

        EList<?> entries = (EList<?>) (syntaxObject).eGet((syntaxObject).eClass().getEStructuralFeature("entries"));
        assertEquals(3, entries.size());
//         EObject article = entries.get(0);
//
//         EList<EObject> attributes = (EList<EObject>) article.eGet(article.eClass().getEStructuralFeature("attributes"));
//         assertEquals(1, attributes.size());
//    
//         TbChangeUtil.cleanUp(currentVersionTb);
//         // add a new year to article
//         tbModel = new TextBlocksModel(currentVersionTb, null);
//         tbModel.replace(31, 0,
//             "year = \"2010\",");
//         TextBlock currentVersionTbNew = facade.parseIncrementally(currentVersionTb);
//         // textBlock shouldn't have changed
//         assertEquals(currentVersionTb, currentVersionTb);
//         EObject syntaxObject2 = currentVersionTbNew
//                 .getCorrespondingModelElements().iterator().next();
//        
//         // bibtexfile element shouldn't have changed
//         assertEquals(syntaxObject, syntaxObject2);
//        
//         // article element shouldn't have changed
//         entries = (EList<EObject>) (syntaxObject2)
//             .eGet((syntaxObject).eClass().getEStructuralFeature(
//                 "entries"));
//         EObject newArticle = entries.get(0);
//         assertEquals(article, newArticle);
//         
//         attributes = (EList<EObject>) article.eGet(article.eClass().getEStructuralFeature("attributes"));
//         
//         assertEquals(2, attributes.size());
//         
//         EObject newYear = attributes.get(0);
//         assertEquals("2010", newYear.eGet(newYear.eClass().getEStructuralFeature("value")));
     }
}
