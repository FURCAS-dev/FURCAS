package com.sap.furcas.referenceresolving.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.Collections;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ocl.ecore.opposites.DefaultOppositeEndFinder;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.incremental.GeneratedParserAndFactoryBasedTest;
import com.sap.furcas.runtime.parser.incremental.ParserGenerationTestHelper;
import com.sap.furcas.runtime.parser.testbase.ClassLookup;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.runtime.textblocks.model.TextBlocksModel;
import com.sap.furcas.runtime.textblocks.modifcation.TbChangeUtil;
import com.sap.furcas.runtime.textblocks.testutils.EMFTextBlocksModelElementFactory;
import com.sap.furcas.runtime.textblocks.testutils.TestSourceTextBlockCreator;
import com.sap.furcas.runtime.textblocks.testutils.TextBlocksModelElementFactory;
import com.sap.furcas.test.fixture.ScenarioFixtureData;
import com.sap.ide.cts.parser.incremental.antlr.IncrementalParserFacade;

public class TestIncrementalParser extends GeneratedParserAndFactoryBasedTest {
    private static final String LANGUAGE = "BibtexWithPropertyInits";
    private static final File TCS = new File("fixtures/BibtexWithPropertyInits.tcs");

    private static final File[] METAMODELS = { ScenarioFixtureData.BIBTEXT_METAMODEL,
            ScenarioFixtureData.BIBTEXT1_METAMODEL };
    
    private static final String GENERATION_TEMP = "./generationTemp/";
    private static final String PACKAGE_NAME = "generated";

    private static final String MM_PACKAGE = "BibText";

    private static ResourceSet resourceSet;
    private static ConcreteSyntax syntax;
    private static IncrementalParserFacade incrementalParserFacade;

    @BeforeClass
    public static void setupParser() throws Exception {
        testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS,
                GENERATION_TEMP + File.separator + PACKAGE_NAME
                        + File.separator, PACKAGE_NAME, METAMODELS);
        resourceSet = testConfig.getSourceConfiguration().getResourceSet();
        TCSSyntaxContainerBean syntaxBean = parseSyntax(testConfig);
        syntax = syntaxBean.getSyntax();
        resourceSet.getResources().add(syntax.eResource());
        ClassLookup classLookup = new ClassLookup() {
            @Override
            public Class<?> loadClass(String className) throws ClassNotFoundException {
                return Class.forName(className);
            }
        };
        generateParserForLanguage(syntaxBean, testConfig, classLookup, false);

        generationHelper = new ParserGenerationTestHelper(GENERATION_TEMP,
                Collections.singletonList(PACKAGE_NAME), true);
        // EPackage pack = findPackage(LANGUAGE);
        // IModelAdapter adapter = new TextBlocksAwareModelAdapter(
        // new EMFModelAdapter(pack, resourceSet, testConfig
        // .getSourceConfiguration().getReferenceScope()));
        generateParserFactoryForLanguage(LANGUAGE, MM_PACKAGE, testConfig
                .getTargetConfiguration().getParserTargetPackageName());
        EditingDomain editingDomain = new AdapterFactoryEditingDomain(
                new AdapterFactoryImpl(), new BasicCommandStack(),
                resourceSet);

        OppositeEndFinder oppositeEndFinder = DefaultOppositeEndFinder
                .getInstance();
        incrementalParserFacade = getIncrementalFacade(LANGUAGE, resourceSet,
                editingDomain, oppositeEndFinder, testConfig
                        .getSourceConfiguration().getReferenceScope(), classLookup);
        ECrossReferenceAdapter crossRefAdapter = new ECrossReferenceAdapter();
        resourceSet.eAdapters().add(crossRefAdapter);
        crossRefAdapter.setTarget(resourceSet);
    }

    @AfterClass
    public static void tearDown() {
        for (File file : new File(GENERATION_TEMP).listFiles()) {
            file.delete();
        }
    }

    private IncrementalParserFacade getParserFacade() {
        return incrementalParserFacade;
    }

    protected TextBlocksModelElementFactory modelFactory;
    private static GeneratedParserTestConfiguration testConfig;

    @Before
    public void setModelFactory() {
        modelFactory = new EMFTextBlocksModelElementFactory();
    }

    /**
     * @param content
     * @return
     */
    protected LexedToken createToken(String content) {
        LexedToken contentToken = modelFactory.createLexedToken();
        contentToken.setValue(content);
        contentToken.setLength(content.length());
        contentToken.setEndColumn(content.length());
        contentToken.setType(0);
        contentToken.setVersion(Version.REFERENCE);
        return contentToken;
    }

    /**
     * Create a resource to holds all element created by this ModelAdapter.
     * Otherwise query2 cannot find them.
     * 
     * @param rootPackage
     */
    private Resource createTransientParsingResource(ResourceSet resourceSet,
            String rootPackage) {
        Resource resource = resourceSet.createResource(URI
                .createURI(rootPackage + "/transientParsingResource"
                        + EcoreUtil.generateUUID()));
        return resource;
    }

    /**
     * Tests whether an simple addition to a textblock is correctly mapped to an insertion in the model without
     * re-creating the parent element.
     * 
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testParseBibTextAddNewSubBlock() throws Exception {
         IncrementalParserFacade facade = getParserFacade();

         AbstractToken content = createToken("");
         TextBlock root = TestSourceTextBlockCreator
                 .initialiseTextBlocksWithContentToken(modelFactory, content);
         Resource r = createTransientParsingResource(resourceSet, MM_PACKAGE);
         r.getContents().add(root);

         TextBlocksModel tbModel = new TextBlocksModel(root, null);
         tbModel.replace(0, 0,
                 "article{" + "  Testing, \"John Doe\"," + "  year = \"2002\"" + "}" + "author = \"John Doe\"."
                 + "author = \"Jane Doll\".");

         TextBlock currentVersionTb = facade.parseIncrementally(root);
         EObject syntaxObject = currentVersionTb.getCorrespondingModelElements()
                 .iterator().next();
         // assert no exception
         assertNotNull(syntaxObject);

         EList<EObject> entries = (EList<EObject>) (syntaxObject)
                 .eGet((syntaxObject).eClass().getEStructuralFeature(
                         "entries"));
         assertEquals(2, entries.size());
         EObject article = entries.get(0);

         EList<EObject> attributes = (EList<EObject>) article.eGet(article.eClass().getEStructuralFeature("attributes"));
         assertEquals(1, attributes.size());
    
         TbChangeUtil.cleanUp(currentVersionTb);
         // add a new year to article
         tbModel = new TextBlocksModel(currentVersionTb, null);
         tbModel.replace(31, 0,
             "year = \"2010\",");
         TextBlock currentVersionTbNew = facade.parseIncrementally(currentVersionTb);
         // textBlock shouldn't have changed
         assertEquals(currentVersionTb, currentVersionTb);
         EObject syntaxObject2 = currentVersionTbNew
                 .getCorrespondingModelElements().iterator().next();
        
         // bibtexfile element shouldn't have changed
         assertEquals(syntaxObject, syntaxObject2);
        
         // article element shouldn't have changed
         entries = (EList<EObject>) (syntaxObject2)
             .eGet((syntaxObject).eClass().getEStructuralFeature(
                 "entries"));
         EObject newArticle = entries.get(0);
         assertEquals(article, newArticle);
         
         attributes = (EList<EObject>) article.eGet(article.eClass().getEStructuralFeature("attributes"));
         
         assertEquals(2, attributes.size());
         
         EObject newYear = attributes.get(0);
         assertEquals("2010", newYear.eGet(newYear.eClass().getEStructuralFeature("value")));
     }
}
