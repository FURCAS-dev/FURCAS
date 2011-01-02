package com.sap.furcas.parser.tcs.scenario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.ModelParsingResult;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.testbase.EMFParsingHelper;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.test.fixture.ScenarioFixtureData;

/**
 * Simple Test for a simple, java like language.
 * 
 * TODO: pull up findPackage or createModelAdapter into an additional base clase
 */
public class TestMiniJava extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "MiniJava";
    private static final File TCS = ScenarioFixtureData.MINI_JAVA_TCS;
    private static final File[] METAMODELS = { ScenarioFixtureData.MINI_JAVA_METAMODEL};
    private static final String DSLSAMPLEDIR = "./scenarioTestSample/";
    private static final String PACKAGE_URI = ScenarioFixtureData.MINI_JAVA_PACKAGE_URI;
    
    private static EMFParsingHelper parsingHelper;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS);
        TCSSyntaxContainerBean syntaxBean = parseSyntax(testConfig);
        ParserFacade facade = generateParserForLanguage(syntaxBean, testConfig, new ClassLookupImpl());
        parsingHelper = new EMFParsingHelper(facade, testConfig, PACKAGE_URI);
    }

    /**
     * Parse a simple, self-contained MiniJava compilation unit. It just contains one basic class. 
     */
    @Test
    public void testParseSimpleSample() throws Exception {
        ModelParsingResult result = parsingHelper.parseFile("MiniJava_TestSimple.sam", DSLSAMPLEDIR, /*expected errors*/ 0);
        
        // Check we have one class and three methods.
        EObject compilationUnit = (EObject) result.getParsedModelElement();
        EObject clazz = (EObject) compilationUnit.eGet(compilationUnit.eClass().getEStructuralFeature("containedClass"));
        Object methods = clazz.eGet(clazz.eClass().getEStructuralFeature("members"));
        assertTrue(methods instanceof Collection);
        assertEquals(3, ((Collection<?>) methods).size());
    }
    
    
    /**
     * Parse a MiniJava compilation unit with missing imports. The class references two types which
     * are meant to be imported. However, the he imported package does not exist and the import
     * therefore fails. 
     */
    @Test
    public void testParseWithMissingImportedPackage() throws Exception {
        // Expect three errors:
        //      unable to resolve two imports
        //      unable to resolve two attribute type
        ModelParsingResult result = parsingHelper.parseFile("MiniJava_TestImportPackage.sam", DSLSAMPLEDIR, /*expected errors*/ 4);
        
        EObject compilationUnit = (EObject) result.getParsedModelElement();
        EObject clazz = (EObject) compilationUnit.eGet(compilationUnit.eClass().getEStructuralFeature("containedClass"));
        
        Object imports = compilationUnit.eGet(compilationUnit.eClass().getEStructuralFeature("imports"));
        assertTrue(imports instanceof List);
        assertEquals("There should be one imported package", 2, ((List<?>) imports).size());
        
        EObject importedClassA = (EObject) ((List<?>) imports).get(0);
        assertFalse("Class import should have failed", importedClassA.eIsSet(importedClassA.eClass().getEStructuralFeature("importedClass")));
        EObject importedClassB = (EObject) ((List<?>) imports).get(1);
        assertFalse("Class import should have failed", importedClassB.eIsSet(importedClassB.eClass().getEStructuralFeature("importedClass")));
        
        Object attributes = clazz.eGet(clazz.eClass().getEStructuralFeature("members"));
        assertTrue(attributes instanceof List<?>);
        assertEquals("There should be two attributes", 2, ((Collection<?>) attributes).size());
        
        // Attribute types should not be set.
        EObject attribute1 = (EObject) ((List<?>) attributes).get(0);
        assertFalse("Type should not be set", attribute1.eIsSet(attribute1.eClass().getEStructuralFeature("type")));
        EObject attribute2 = (EObject) ((List<?>) attributes).get(0);
        assertFalse("Type should not be set", attribute2.eIsSet(attribute2.eClass().getEStructuralFeature("type")));
    }
    
    /**
     * Same as {@link #testParseWithMissingImportedPackage}, however this time first parse
     * the other required class files. It should now be possible to resolve the import.
     *
     * This works because the same model adapter is used. The model adapter knows which
     * model elements have been parsed previously.
     */
    @Ignore("Fails for unknown reason (Unclear if we have a bug in our code of the ecore or tcs is flawed)")
    @Test
    public void testParseWithResolvableImportedClass() throws Exception {
        // the pre-requisites
        parsingHelper.parseFile("MiniJava_ImportedPackage_ClassA.sam", DSLSAMPLEDIR, /*expected errors*/ 0);
        parsingHelper.parseFile("MiniJava_ImportedPackage_ClassB.sam", DSLSAMPLEDIR, /*expected errors*/ 0);
        
        // the class containing the imports to be resolved
        ModelParsingResult result = parsingHelper.parseFile("MiniJava_TestImportPackage.sam", DSLSAMPLEDIR, /*expected errors*/ 0);
        
        // make sure that the package and subsequently all types have been resolved
        EObject compilationUnit = (EObject) result.getParsedModelElement();
        EObject clazz = (EObject) compilationUnit.eGet(compilationUnit.eClass().getEStructuralFeature("containedClass"));
        
        Object imports = compilationUnit.eGet(compilationUnit.eClass().getEStructuralFeature("imports"));
        assertTrue(imports instanceof List);
        assertEquals("There should be one imported class", 2, ((List<?>) imports).size());

        EObject importedClassA = (EObject) ((List<?>) imports).get(0);
        assertTrue("Class import should be successfull", importedClassA.eIsSet(importedClassA.eClass().getEStructuralFeature("importedClass")));
        EObject importedClassB = (EObject) ((List<?>) imports).get(1);
        assertTrue("Class import should be successfull", importedClassB.eIsSet(importedClassB.eClass().getEStructuralFeature("importedClass")));
        
        Object attributes = clazz.eGet(clazz.eClass().getEStructuralFeature("members"));
        assertTrue(attributes instanceof List<?>);
        assertEquals("There should be two attributes", 2, ((Collection<?>) attributes).size());
        
        // Attribute types should not be set.
        EObject attribute1 = (EObject) ((List<?>) attributes).get(0);
        assertTrue("Type should be set", attribute1.eIsSet(attribute1.eClass().getEStructuralFeature("type")));
        EObject attribute2 = (EObject) ((List<?>) attributes).get(0);
        assertTrue("Type should be set", attribute2.eIsSet(attribute2.eClass().getEStructuralFeature("type")));
    }
    
}
