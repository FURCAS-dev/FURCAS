package com.sap.furcas.runtime.parser.incremental;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.eclipse.emf.ecore.EObject;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.TCS.Alternative;
import com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.runtime.parser.incremental.testbase.IncrementalParserBasedTest;
import com.sap.furcas.test.fixture.ScenarioFixtureData;
import com.sap.ide.cts.parser.incremental.IncrementalParserFacade;

/**
 * Test actions that the incremental parser might encounter within an editor environment.
 * 
 * The focus of this testclass lies on {@link Alternative}s and {@link ConditionalElement}s.
 * 
 * @author Stephan Erb
 */
public class TestAlternativeParsingScenarios extends IncrementalParserBasedTest {

    private static final String LANGUAGE = "BibtexWithAlternatives";
    private static final File TCS = new File("fixtures/BibtexWithAlternatives.tcs");
    private static final File[] METAMODELS = { ScenarioFixtureData.BIBTEXT_METAMODEL, ScenarioFixtureData.BIBTEXT1_METAMODEL };


    @BeforeClass
    public static void setupParser() throws Exception {
        setupParser(LANGUAGE, TCS, METAMODELS);
    }

    protected ParsingResult triggerParserAndExpectReuse() {
        ParsingResult result = super.triggerParser();
        // Within this testclass we expect full re-use of all root elements
        if (result.oldRoot != null) {
            assertEquals(result.oldRoot, result.newRoot);
        }
        return result;
    }
    
    @Test
    public void testInitialParse() throws Exception {
        model.replace(0, 0, "Library: Foo Entries:{}");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    /**
     * Change name from Foo to Bar
     */
    @Test
    public void testChangeOptionalProperty() throws Exception {
        model.replace(0, 0, "Library: Foo Entries:{}");
        triggerParserAndExpectReuse();
        assertEquals("Foo", get(getLibrary(), "name"));
        
        model.replace("Library: ".length(), "Foo".length(), "Bar");
        triggerParserAndExpectReuse();
        assertEquals("Bar", get(getLibrary(), "name"));
        
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    /**
     * Change name from nothing to Foo.
     * Expect that the propertyInit on hasName is executed.
     */
    @Test
    public void testSetOptionalProperty() throws Exception {
        model.replace(0, 0, "Library: Entries:{}");
        triggerParserAndExpectReuse();
        assertFalse("Should not be considered set", isSet(getLibrary(), "name"));
        assertEquals(false, get(getLibrary(), "hasName"));
        
        model.replace("Library:".length(), "".length(), "NewName");
        triggerParserAndExpectReuse();
        assertEquals("NewName", get(getLibrary(), "name"));
        assertTrue("Should be considered set", isSet(getLibrary(), "name"));
        assertEquals(true, get(getLibrary(), "hasName"));

        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    /**
     * Change name from Foo to nothing.
     * Expect that the propertyInit on hasName is executed.
     */
    @Test
    public void testUnsetOptionalProperty() throws Exception {
        model.replace(0, 0, "Library: Foo Entries:{}");
        triggerParserAndExpectReuse();
        assertEquals("Foo", get(getLibrary(), "name"));
        assertTrue("Should be considered set", isSet(getLibrary(), "name"));
        assertEquals(true, get(getLibrary(), "hasName"));
        
        model.replace("Library: ".length(), "Foo".length(), "");
        triggerParserAndExpectReuse();
        assertEquals(false, get(getLibrary(), "hasName"));
        assertFalse("Should no longer be considered set", isSet(getLibrary(), "name"));
        
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    private Object get(EObject obj, String name) {
        return obj.eGet(obj.eClass().getEStructuralFeature(name));
    }
    
    private boolean isSet(EObject obj, String name) {
        return obj.eIsSet(obj.eClass().getEStructuralFeature(name));
    }
    
    private EObject getLibrary() {
        return IncrementalParserFacade.getParsingResult(model.getRoot());
    }
}
