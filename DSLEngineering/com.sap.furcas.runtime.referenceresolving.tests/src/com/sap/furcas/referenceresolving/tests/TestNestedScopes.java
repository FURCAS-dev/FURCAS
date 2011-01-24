package com.sap.furcas.referenceresolving.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.ModelParsingResult;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.testbase.EMFParsingHelper;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;

/**
 * Tests NestedScopes TCS and metamodel, which will be used to test impact analysis behavior on renames.
 * 
 * @author Sebastian Schlag (D049672)
 * 
 */

public class TestNestedScopes extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "NestedScopesTestSyntax";
    private static final File TCS =  new File("fixtures/NestedScopes.tcs");
    private static final File METAMODEL = new File("fixtures/NestedScopes.ecore");
    private static final String PACKAGE_URI = "http://www.furcas.org/TCS/referenceresolving/tests/nestedScopes";

    private static EMFParsingHelper parsingHelper;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODEL);
        TCSSyntaxContainerBean syntaxBean = parseSyntax(testConfig);
        ParserFacade facade = generateParserForLanguage(syntaxBean, testConfig, new ClassLookupImpl());
        parsingHelper = new EMFParsingHelper(facade, testConfig, PACKAGE_URI);
    }

    /**
     * Usages should be bound to the corresponding definition.
     */
    @Test
    public void testResolvableBindingsBasicExample() throws Exception {
        String sample = "{ def a; use a;" + "{ def b; use b; }" + "}";
        ModelParsingResult result = parsingHelper.parseString(sample,/* expected errors */0);

        EObject firstBlock = (EObject) result.getParsedModelElement();
        assertNotNull(firstBlock);

        EClass blockClass = firstBlock.eClass();
        assertEquals("Block", blockClass.getName());
        
        EObject defA = getStatementNinBlockM(1, 0, firstBlock);
        assertEquals("Definition", defA.eClass().getName());
        assertEquals("a", defA.eGet(defA.eClass().getEStructuralFeature("name")));
        
        EObject useA = getStatementNinBlockM(2, 0, firstBlock);
        assertEquals("Usage", useA.eClass().getName());
        assertSame(useA.eGet(useA.eClass().getEStructuralFeature("boundDefinition")),defA);
        
        EObject defB = getStatementNinBlockM(1, 1, firstBlock);
        assertEquals("Definition", defB.eClass().getName());
        assertEquals("b", defB.eGet(defB.eClass().getEStructuralFeature("name")));
        
        EObject useB = getStatementNinBlockM(2, 1, firstBlock);
        assertEquals("Usage", useB.eClass().getName());
        assertSame(useB.eGet(useB.eClass().getEStructuralFeature("boundDefinition")),defB);

    }
    
    /**
     * Definition of b should not be visible outside the inner scope. Therefore the boundDefinition property
     * of Usage "a" should not be set.
     * @throws Exception
     */
    @Test
    public void testDefinitionNotVisibleOutsideOfScope() throws Exception{
        String sample = "{" + "{ def a; }" + "use a; }";
        ModelParsingResult result = parsingHelper.parseString(sample,/* expected errors */1);
        
        EObject firstBlock = (EObject) result.getParsedModelElement();
        assertNotNull(firstBlock);
        
        EObject useA = getStatementNinBlockM(2, 0, firstBlock);
        assertEquals("Usage", useA.eClass().getName());
        assertFalse(useA.eIsSet((useA.eClass().getEStructuralFeature("boundDefinition"))));
        
    }
    
    /**
     * "Use before declaration" should not be possible.
     * @throws Exception
     */
    @Test
    public void testUseBeforeDeclaration() throws Exception{
        String sample = "{use a; def a;}";
        ModelParsingResult result = parsingHelper.parseString(sample,/* expected errors */1); 
        
        EObject firstBlock = (EObject) result.getParsedModelElement();
        assertNotNull(firstBlock);
        
        EObject useA = getStatementNinBlockM(1, 0, firstBlock);
        assertEquals("Usage", useA.eClass().getName());
        assertFalse(useA.eIsSet((useA.eClass().getEStructuralFeature("boundDefinition"))));
        
    }
    
    /**
     * Usage should be bound to the innermost definition of a.
     * @throws Exception
     */
    @Test
    public void testShadowing() throws Exception{
        String sample = "{ def a;" + "{def a; use a;}" +"}";
        ModelParsingResult result = parsingHelper.parseString(sample,/* expected errors */0); 
        
        EObject firstBlock = (EObject) result.getParsedModelElement();
        assertNotNull(firstBlock);
        
        EObject firstDefA = getStatementNinBlockM(1, 0, firstBlock);
        assertEquals("Definition", firstDefA.eClass().getName());
        assertEquals("a", firstDefA.eGet(firstDefA.eClass().getEStructuralFeature("name")));
        
        EObject secondDefA = getStatementNinBlockM(1, 1, firstBlock);
        assertEquals("Definition", secondDefA.eClass().getName());
        assertEquals("a", secondDefA.eGet(secondDefA.eClass().getEStructuralFeature("name")));
        
        EObject useA = getStatementNinBlockM(2, 1, firstBlock);
        assertEquals("Usage", useA.eClass().getName());
        assertSame(useA.eGet(useA.eClass().getEStructuralFeature("boundDefinition")),secondDefA);
        assertNotSame(useA.eGet(useA.eClass().getEStructuralFeature("boundDefinition")),firstDefA);
 
        
    }

    public Collection<EObject> collectAllElementsOfType(Collection<?> statements, String type) {
        ArrayList<EObject> definitions = new ArrayList<EObject>();
        for (Object object : statements) {
            EObject statement = (EObject) object;
            if (statement.eClass().getName().equals(type)) {
                definitions.add(statement);
            } else if (statement.eClass().getName().equals("Block")) {
                Collection<?> statementsOfInnerBlock = (Collection<?>) statement.eGet(statement.eClass().getEStructuralFeature("statementsInBlock"));
                definitions.addAll((ArrayList<EObject>) collectAllElementsOfType(statementsOfInnerBlock, type));
            }
        }
        return definitions;
    }

    public EObject getStatementNinBlockM(int n, int m, EObject rootBlock) {
        EObject currentBlock = rootBlock;
        for (int nestingLevel = 0; nestingLevel < m; nestingLevel++) {
            @SuppressWarnings("unchecked")
            Collection<EObject> statements = (Collection<EObject>) currentBlock.eGet(currentBlock.eClass().getEStructuralFeature("statementsInBlock"));
            for (EObject statement : statements) {
                if (statement.eClass().getName().equals("Block")) {
                    currentBlock = statement;
                }
            }
        }
        @SuppressWarnings("unchecked")
        Collection<EObject> statmentsInBlockM = (Collection<EObject>) currentBlock.eGet(currentBlock.eClass().getEStructuralFeature("statementsInBlock"));
        return (EObject) statmentsInBlockM.toArray()[n-1];
    }
}
