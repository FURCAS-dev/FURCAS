/*******************************************************************************
 * Copyright (c) 2011 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.furcas.unparser.incremental;
import static com.sap.furcas.unparser.testutils.PrettyPrintAssertionUtil.assertEqualsByLines;

import java.io.File;

import org.eclipse.emf.ecore.EObject;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.prettyprinter.PrettyPrinter;
import com.sap.furcas.runtime.common.util.TCSSpecificOCLEvaluator;
import com.sap.furcas.runtime.parser.impl.ParserScope;
import com.sap.furcas.runtime.parser.incremental.testbase.IncrementalParserBasedTest;
import com.sap.furcas.test.fixture.FeatureFixtureData;
import com.sap.furcas.unparser.template.ClassLookupImpl;

/**
 * Test the incremental re-use capabilities of the pretty printer.
 * It should be able to extract and re-use information from existing TextBlocks.
 * 
 * @author Stephan Erb
 *
 */
public class TestTextBlockBasedPrintPolicy extends IncrementalParserBasedTest {

    private static final String LANGUAGE = "QueryByIdentifierFeatureTestSyntax";
    private static final File TCS = FeatureFixtureData.PARG_QUERY_BY_IDENTIFIER_TCS;
    private static final File[] METAMODELS = { FeatureFixtureData.PARG_REFERENCE_BY_IDENTIFIER_METAMODEL };
    
    private static PrettyPrinter prettyPrinter;
    

    @BeforeClass
    public static void setupParser() throws Exception {
        setupParser(LANGUAGE, TCS, new ClassLookupImpl(), METAMODELS);
       
        ParserScope scope = incrementalParserFacade.getParserScope();
        prettyPrinter = new PrettyPrinter(scope.getSyntax(), scope.getMetamodelLookup(),
                new TCSSpecificOCLEvaluator(), incrementalParserFacade.getParserFactory()); 
    }
    
    /**
     * Make sure the simple stuff works: Parsing and re-printing. 
     */
    @Test
    public void testSimple() throws Exception {
        String content = "Definitions : def a ; Usages : use a ;";

        model.replace(0, model.getLength(), content);
        triggerParser();
        
        TextBlock reprinted = prettyPrinter.prettyPrint(getRootObject());
        assertEqualsByLines(reprinted.getCachedString(), content);
    }
    
    /**
     * Parsing and re-printing, while passing in the old block.
     * 
     * Content is formatted according to the default style
     * so this should be exactly the same as {@link #testSimple()}.  
     */
    @Test
    public void testSimpleWithReuse() throws Exception {
        String content = "Definitions : def a ; Usages : use a ;";

        model.replace(0, model.getLength(), content);
        triggerParser();
        
        TextBlock reprinted = prettyPrinter.prettyPrint(getRootObject(), getRootBlock());
        assertEqualsByLines(reprinted.getCachedString(), content);
    }
    
    /**
     * Content is slightly modified. As the old block is not passed in,
     * we cannot expect any formatting re-use.
     */
    @Test(expected=Throwable.class)
    public void testSimpleFormattingChanges() throws Exception {
        String content = "Definitions: def a; Usages: use a;";

        model.replace(0, model.getLength(), content);
        triggerParser();
        
        TextBlock reprinted = prettyPrinter.prettyPrint(getRootObject());
        assertEqualsByLines(reprinted.getCachedString(), content);
    }
    
    /**
     * Content is slightly modified. As the old block is not passed in,
     * we cannot expect any formatting re-use.
     */
    @Test
    public void testSimpleFormattingChangesWithReuse() throws Exception {
        String content = "Definitions: def a; Usages: use a;";

        model.replace(0, model.getLength(), content);
        triggerParser();
        
        TextBlock reprinted = prettyPrinter.prettyPrint(getRootObject(), getRootBlock());
        assertEqualsByLines(reprinted.getCachedString(), content);
    }
    
    /**
     * There is an alternativ way to reference definitions named xxFOOxx.
     * Without re-use the pretty printer has to default to the first choice.
     */
    @Test
    public void testAlternativeChoice() throws Exception {
        String content  = "Definitions : def xxFOOxx ; Usages : useXX FOO ; use xxFOOxx ;";
        String expected = "Definitions : def xxFOOxx ; Usages : use xxFOOxx ; use xxFOOxx ;";

        model.replace(0, model.getLength(), content);
        triggerParser();
        
        TextBlock reprinted = prettyPrinter.prettyPrint(getRootObject());
        assertEqualsByLines(reprinted.getCachedString(), expected);
    }
    
    /**
     * There is an alternativ way to reference definitions named xxFOOxx.
     * The pretty printer should re-use the alternative choice that was used
     * in the existing textblock.
     */
    @Test
    public void testAlternativeChoiceWithReuse() throws Exception {
        String content  = "Definitions : def xxFOOxx ; Usages : useXX FOO ; use xxFOOxx ;";

        model.replace(0, model.getLength(), content);
        triggerParser();
        
        TextBlock reprinted = prettyPrinter.prettyPrint(getRootObject(), getRootBlock());
        assertEqualsByLines(reprinted.getCachedString(), content);
    }
    
    private TextBlock getRootBlock() {
        return model.getRoot();
    }
    
    private EObject getRootObject() {
        return model.getRoot().getCorrespondingModelElements().iterator().next();
    }
    
}
