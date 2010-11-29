package com.sap.furcas.runtime.parser.incremental;

import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ocl.ecore.opposites.DefaultOppositeEndFinder;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Bibtex.util.BibtexAdapterFactory;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.testbase.ClassLookup;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.runtime.textblocks.model.TextBlocksModel;
import com.sap.furcas.runtime.textblocks.testutils.EMFTextBlocksModelElementFactory;
import com.sap.furcas.runtime.textblocks.testutils.TestSourceTextBlockCreator;
import com.sap.furcas.runtime.textblocks.testutils.TextBlocksModelElementFactory;
import com.sap.furcas.test.fixture.FixtureData;
import com.sap.ide.cts.parser.incremental.antlr.IncrementalParserFacade;

public class TestIncrementalParser extends GeneratedParserAndFactoryBasedTest {
	private static final String LANGUAGE = "BibtexWithPropertyInits";
	private static final File TCS = new File(
			"fixtures/BibtexWithPropertyInits.tcs");

	private static final File[] METAMODELS = { FixtureData.BIBTEXT_METAMODEL,
			FixtureData.BIBTEXT1_METAMODEL };

	private static ParserFacade facade;
	private static ResourceSet resourceSet;
	private static ConcreteSyntax syntax;
	private static IncrementalParserFacade incrementalParserFacade;

	@BeforeClass
	public static void setupParser() throws Exception {
		GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(
				LANGUAGE, TCS, METAMODELS);
		resourceSet = testConfig.getSourceConfiguration().getResourceSet();
		TCSSyntaxContainerBean syntaxBean = parseSyntax(testConfig);
		syntax = syntaxBean.getSyntax();
		facade = generateParserForLanguage(syntaxBean, testConfig,
				new ClassLookup() {

					@Override
					public Class<?> loadClass(String className)
							throws ClassNotFoundException {
						return Class.forName(className);
					}

				});
//		EPackage pack = findPackage(LANGUAGE);
//		IModelAdapter adapter = new TextBlocksAwareModelAdapter(
//				new EMFModelAdapter(pack, resourceSet, testConfig
//						.getSourceConfiguration().getReferenceScope()));
		generateParserFactoryForLanguage(LANGUAGE, LANGUAGE, testConfig
				.getTargetConfiguration().getParserTargetPackageName());
		EditingDomain editingDomain = new AdapterFactoryEditingDomain(new BibtexAdapterFactory(), new BasicCommandStack());
		OppositeEndFinder oppositeEndFinder = DefaultOppositeEndFinder.getInstance();
		incrementalParserFacade = getIncrementalFacade(LANGUAGE,
				resourceSet, editingDomain , oppositeEndFinder, testConfig
						.getSourceConfiguration().getReferenceScope());
	}
	
	private IncrementalParserFacade getParserFacade() {
		return incrementalParserFacade;
	}

	/**
	 * Finds an EPackage in the {@link #resourceSet} by the <code>name</code>
	 * specified
	 */
	private static EPackage findPackage(String name) {
		for (Resource r : resourceSet.getResources()) {
			for (EObject c : r.getContents()) {
				if (c instanceof EPackage
						&& ((EPackage) c).getName().equals(name)) {
					return (EPackage) c;
				}
			}
		}
		return null;
	}

	protected TextBlocksModelElementFactory modelFactory;

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
	@Test
	public void testIncrementalParserSetup() {
		IncrementalParserFacade facade = getParserFacade();
		

		AbstractToken content = createToken("");
		TextBlock root = TestSourceTextBlockCreator
				.initialiseTextBlocksWithContentToken(modelFactory, content);

		TextBlocksModel tbModel = new TextBlocksModel(root, null);
		tbModel.replace(0, 0, "@article { test, bla }");

		TextBlock currentVersionTb = facade.parseIncrementally(root);
		Object syntaxObject = currentVersionTb.getCorrespondingModelElements()
				.iterator().next();
		// assert no exception
		assertNotNull(syntaxObject);
	}

//	/**
//	 * Tests whether an simple addition to a textblock is correctly mapped to an
//	 * insertion in the model without re-creating the parent element.
//	 * 
//	 * @throws Exception
//	 */
//	@Test
//	public void testParseBibTextAddNewSubBlock() throws Exception {
//		// create TCS mapping on connection
//		TcsTestHelper.createTcsSyntaxMappingOnConnection(new ResourceSetImpl());
//
//		IncrementalParserFacade facade = getParserFacade();
//		File syntaxDefFile = new File("scenarioTestResource/TCS.tcs");
//
//		AbstractToken content = createToken("");
//		TextBlock root = TestSourceTextBlockCreator
//				.initialiseTextBlocksWithContentToken(modelFactory, content);
//
//		TextBlocksModel tbModel = new TextBlocksModel(root, null);
//		tbModel.replace(0, 0, getTcsFileContent(syntaxDefFile));
//
//		TextBlock currentVersionTb = facade.parseIncrementally(root);
//		Object syntaxObject = currentVersionTb.getCorrespondingModelElements()
//				.iterator().next();
//		// assert no exception
//		assertNotNull(syntaxObject);
//		ConcreteSyntax syntax = (ConcreteSyntax) syntaxObject;
//		assertEquals("Bibtext", syntax.getName());
//		assertEquals(7, syntax.getTemplates().size());
//
//		assertNotNull(currentVersionTb); // future version
//		assertEquals(88, currentVersionTb.getSubNodes().size());
//
//		TbChangeUtil.cleanUp(currentVersionTb);
//		// add a new template
//		tbModel = new TextBlocksModel(currentVersionTb, null);
//		tbModel.replace(26, 0,
//				"primitiveTemplate identifier2 for ->String using NAME:value = \"%token%\";");
//		TextBlock currentVersionTbNew = facade
//				.parseIncrementally(currentVersionTb);
//		// textBlock shouldn't have changed
//		assertEquals(currentVersionTb, currentVersionTb);
//		ConcreteSyntax syntaxObject2 = (ConcreteSyntax) currentVersionTbNew
//				.getCorrespondingModelElements().iterator().next();
//
//		// syntax element shouldn't have changed
//		assertEquals(syntaxObject, syntaxObject2);
//
//		// check if primitive template was added
//		Template newTemplate = syntaxObject2.getTemplates().get(0);
//		assertEquals(true, newTemplate instanceof PrimitiveTemplate);
//		assertEquals("identifier2",
//				((PrimitiveTemplate) newTemplate).getTemplateName());
//	}
//
//
//
//	/**
//	 * Tests whether a reference where the reference by value was replaced is
//	 * correctly set to thw new value;
//	 * 
//	 * @throws Exception
//	 */
//	@Test
//	public void testParseBibTextReplaceReference() throws Exception {
//		// create TCS mapping on connection
//		TcsTestHelper.createTcsSyntaxMappingOnConnection(connection);
//
//		IncrementalParserFacade facade = getParserFacade();
//		File syntaxDefFile = new File("scenarioTestResource/Bibtext.tcs");
//
//		AbstractToken content = createToken("");
//		TextBlock root = TestSourceTextBlockCreator
//				.initialiseTextBlocksWithContentToken(modelFactory, content);
//
//		TextBlocksModel tbModel = new TextBlocksModel(root, null);
//		tbModel.replace(0, 0, getTcsFileContent(syntaxDefFile));
//
//		TextBlock currentVersionTb = facade.parseIncrementally(root);
//		ConcreteSyntax syntaxObject = (ConcreteSyntax) currentVersionTb
//				.getCorrespondingModelElements().iterator().next();
//		// assert no exception
//		assertNotNull(syntaxObject);
//		ConcreteSyntax syntax = syntaxObject;
//		assertEquals("Bibtext", syntax.getName());
//		assertEquals(7, syntax.getTemplates().size());
//
//		Template article = syntaxObject.getTemplates().get(3);
//
//		assertNotNull(currentVersionTb); // future version
//		assertEquals(88, currentVersionTb.getSubNodes().size());
//
//		TbChangeUtil.cleanUp(currentVersionTb);
//		// replace a reference that referred to the "." token with one that
//		// refers to the "{" token
//		tbModel = new TextBlocksModel(currentVersionTb, null);
//		tbModel.replace(423, 1, "{");
//		TextBlock currentVersionTbNew = facade
//				.parseIncrementally(currentVersionTb);
//		// textBlock shouldn't have changed
//		assertEquals(currentVersionTb, currentVersionTb);
//		ConcreteSyntax syntaxObject2 = (ConcreteSyntax) currentVersionTbNew
//				.getCorrespondingModelElements().iterator().next();
//
//		// syntax element shouldn't have changed
//		assertEquals(syntaxObject, syntaxObject2);
//
//		ClassTemplate article2 = (ClassTemplate) syntaxObject2.getTemplates()
//				.get(3);
//		assertEquals(article, article2);
//		Block b = (Block) article2.getTemplateSequence().getElements().get(2);
//		LiteralRef lit = (LiteralRef) b.getBlockSequence().getElements().get(3);
//		assertEquals("{", lit.getReferredLiteral().getValue());
//	}
//
//	private String getTcsFileContent(File syntaxDefFile) {
//		String content = null;
//		if (syntaxDefFile != null) {
//			try {
//				FileInputStream inputStream = new FileInputStream(syntaxDefFile);
//				StringBuilder out = new StringBuilder();
//				byte[] b = new byte[4096];
//				for (int n; (n = inputStream.read(b)) != -1;) {
//					out.append(new String(b, 0, n));
//				}
//				content = out.toString();
//				inputStream.close();
//			} catch (IOException e) {
//				throw new RuntimeException(e);
//			}
//		}
//		return content;
//	}
}
