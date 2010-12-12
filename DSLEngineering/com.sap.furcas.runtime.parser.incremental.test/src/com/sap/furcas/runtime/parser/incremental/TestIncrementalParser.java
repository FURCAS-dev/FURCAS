package com.sap.furcas.runtime.parser.incremental;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.List;

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
import com.sap.furcas.runtime.textblocks.modifcation.TbChangeUtil;
import com.sap.furcas.runtime.textblocks.testutils.EMFTextBlocksModelElementFactory;
import com.sap.furcas.runtime.textblocks.testutils.TestSourceTextBlockCreator;
import com.sap.furcas.runtime.textblocks.testutils.TextBlocksModelElementFactory;
import com.sap.furcas.test.fixture.ScenarioFixtureData;
import com.sap.furcas.test.testutils.ResourceTestHelper;
import com.sap.ide.cts.parser.incremental.antlr.IncrementalParserFacade;

public class TestIncrementalParser extends GeneratedParserAndFactoryBasedTest {
    
    private static final String LANGUAGE = "Bibtex";
    private static final File TCS = new File("fixtures/Bibtex.tcs");

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

    @Test
    public void testIncrementalParserSetup() {
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
    
    
    
//     /**
//     * Tests whether a reference where the reference by value was replaced is
//     * correctly set to thw new value;
//     *
//     * @throws Exception
//     */
//     @Test
//     public void testParseBibTextReplaceReference() throws Exception {
//     // create TCS mapping on connection
//     TcsTestHelper.createTcsSyntaxMappingOnConnection(connection);
//    
//     IncrementalParserFacade facade = getParserFacade();
//     File syntaxDefFile = new File("scenarioTestResource/Bibtext.tcs");
//    
//     AbstractToken content = createToken("");
//     TextBlock root = TestSourceTextBlockCreator
//     .initialiseTextBlocksWithContentToken(modelFactory, content);
//    
//     TextBlocksModel tbModel = new TextBlocksModel(root, null);
//     tbModel.replace(0, 0, getTcsFileContent(syntaxDefFile));
//    
//     TextBlock currentVersionTb = facade.parseIncrementally(root);
//     ConcreteSyntax syntaxObject = (ConcreteSyntax) currentVersionTb
//     .getCorrespondingModelElements().iterator().next();
//     // assert no exception
//     assertNotNull(syntaxObject);
//     ConcreteSyntax syntax = syntaxObject;
//     assertEquals("Bibtext", syntax.getName());
//     assertEquals(7, syntax.getTemplates().size());
//    
//     Template article = syntaxObject.getTemplates().get(3);
//    
//     assertNotNull(currentVersionTb); // future version
//     assertEquals(88, currentVersionTb.getSubNodes().size());
//    
//     TbChangeUtil.cleanUp(currentVersionTb);
//     // replace a reference that referred to the "." token with one that
//     // refers to the "{" token
//     tbModel = new TextBlocksModel(currentVersionTb, null);
//     tbModel.replace(423, 1, "{");
//     TextBlock currentVersionTbNew = facade
//     .parseIncrementally(currentVersionTb);
//     // textBlock shouldn't have changed
//     assertEquals(currentVersionTb, currentVersionTb);
//     ConcreteSyntax syntaxObject2 = (ConcreteSyntax) currentVersionTbNew
//     .getCorrespondingModelElements().iterator().next();
//    
//     // syntax element shouldn't have changed
//     assertEquals(syntaxObject, syntaxObject2);
//    
//     ClassTemplate article2 = (ClassTemplate) syntaxObject2.getTemplates()
//     .get(3);
//     assertEquals(article, article2);
//     Block b = (Block) article2.getTemplateSequence().getElements().get(2);
//     LiteralRef lit = (LiteralRef) b.getBlockSequence().getElements().get(3);
//     assertEquals("{", lit.getReferredLiteral().getValue());
//     }
//    
//     private String getTcsFileContent(File syntaxDefFile) {
//     String content = null;
//     if (syntaxDefFile != null) {
//     try {
//     FileInputStream inputStream = new FileInputStream(syntaxDefFile);
//     StringBuilder out = new StringBuilder();
//     byte[] b = new byte[4096];
//     for (int n; (n = inputStream.read(b)) != -1;) {
//     out.append(new String(b, 0, n));
//     }
//     content = out.toString();
//     inputStream.close();
//     } catch (IOException e) {
//     throw new RuntimeException(e);
//     }
//     }
//     return content;
//     }
}
