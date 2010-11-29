package com.sap.furcas.referenceresolving.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.modeladaptation.emf.adaptation.EMFModelAdapter;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.ModelParsingResult;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;
import com.sap.furcas.runtime.parser.impl.DefaultTextAwareModelAdapter;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.runtime.parser.testbase.ParsingHelper;
import com.sap.furcas.test.fixture.FixtureData;

/**
 * Base class for test cases that use a FURCAS mapping specification (".tcs" file) and based on this
 * produce lexer and parser, then parse a text resource and register all reference resolving callbacks.
 * Then, the tests can start to manipulate the model produced by the parser run and observe how
 * OCL-based property assignments get re-assigned.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public class FurcasMappingBasedTest extends GeneratedParserBasedTest {
    private static final String LANGUAGE = "BibtexWithPropertyInits";
    private static final File TCS = new File("fixtures/BibtexWithPropertyInits.tcs");

    private static final File[] METAMODELS = { FixtureData.BIBTEXT_METAMODEL, FixtureData.BIBTEXT1_METAMODEL };
    
    private static ParsingHelper parsingHelper;
	private static ResourceSet resourceSet;
	private static ConcreteSyntax syntax;
	private EObject johnDoe;
	private EObject article;
	private EClass authorClass;
	private EClass articleClass;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS);
        resourceSet = testConfig.getSourceConfiguration().getResourceSet();
        TCSSyntaxContainerBean syntaxBean = parseSyntax(testConfig);
        syntax = syntaxBean.getSyntax();
        ParserFacade facade = generateParserForLanguage(syntaxBean, testConfig, new ClassLookupImpl());
        parsingHelper = new ParsingHelper(facade);
    }
    
    @Before
    public void setupInitialModel() throws IOException, UnknownProductionRuleException {
        String sample = "article{" + "  Testing, \"John Doe\"," + "  year = \"2002\"" + "}" + "author = \"John Doe\"."
        + "author = \"Jane Doll\".";
        EPackage ePackage = findPackage("BibText");
        Set<URI> referenceScope = Collections.singleton(ePackage.eResource().getURI());
    	EMFModelAdapter handler = new EMFModelAdapter(ePackage, new ResourceSetImpl(), referenceScope);
    	DefaultTextAwareModelAdapter handlerWrapper = new DefaultTextAwareModelAdapter(handler);

        ModelParsingResult parsingResult = parsingHelper.parseString(sample, handlerWrapper);
        EObject bibTexFile = (EObject) parsingResult.getParsedModelElement();
        assertNotNull(bibTexFile);
        EClass bibTexFileClass = bibTexFile.eClass();
        assertEquals("BibTextFile", bibTexFileClass.getName());
        @SuppressWarnings("unchecked")
		Collection<EObject> entries = (Collection<EObject>) bibTexFile.eGet(bibTexFileClass.getEStructuralFeature("entries"));
        assertEquals(3, entries.size());
        johnDoe = null;
        article = null;
        authorClass = null;
        articleClass = null;
        for (EObject entry : entries) {
        	if (entry.eClass().getName().equals("Author")) {
        		authorClass = entry.eClass();
            	if (entry.eGet(authorClass.getEStructuralFeature("name")).equals("John Doe")) {
            		johnDoe = entry;
            	}
        	} else if (entry.eClass().getName().equals("Article")) {
        		articleClass = entry.eClass();
        		article = entry;
        	}
        }
    }

    @Test
    public void testInitialModel() throws Exception {
    	assertNotNull(syntax);
    	assertEquals("BibtexWithPropertyInits", syntax.getName());
        assertNotNull(johnDoe);
        // now check the reference was set using the right property name
        // assertNotNull(johnDoe.get("articles")); StubModelHandler not powerful enough
        assertNotNull(article.eGet(articleClass.getEStructuralFeature("author")));
        assertEquals(johnDoe, article.eGet(articleClass.getEStructuralFeature("author")));
        assertEquals("Where John Doe wrote it", article.eGet(articleClass.getEStructuralFeature("location")));
    }
    
    @Ignore // failing test case as preparation of impact analysis requirements
    public void testChangeAuthorName() {
    	johnDoe.eSet(authorClass.getEStructuralFeature("name"), "John Dough");
        assertEquals("Where John Dough wrote it", article.eGet(articleClass.getEStructuralFeature("location")));
    }
    
    /**
     * Finds an EPackage in the {@link #resourceSet} by the <code>name</code> specified 
     */
	private static EPackage findPackage(String name) {
		for (Resource r : resourceSet.getResources()) {
			for (EObject c : r.getContents()) {
				if (c instanceof EPackage && ((EPackage) c).getName().equals(name)) {
					return (EPackage) c;
				}
			}
		}
		return null;
	}

}
