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
package com.sap.furcas.runtime.parser.incremental;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.runtime.parser.incremental.testbase.IncrementalParserBasedTest;
import com.sap.furcas.test.fixture.ScenarioFixtureData;
import com.sap.ide.cts.parser.incremental.IncrementalParserFacade;

/**
 * Test actions that the incremental parser might encounter within an
 * editor environment. The parser is called regularly to simulate the
 * editor which starts the parser after almost every modification.
 * 
 * @author Stephan Erb
 */
public class TestParsingScenarios extends IncrementalParserBasedTest {

    private static final String LANGUAGE = "NestedScopesTestSyntax";
    private static final File TCS = ScenarioFixtureData.NESTED_SCOPE_TCS;
    private static final File[] METAMODELS = { ScenarioFixtureData.NESTED_SCOPE_METAMODEL };

    @BeforeClass
    public static void setupParser() throws Exception {
        setupParser(LANGUAGE, TCS, METAMODELS);
    }
    
    @Test
    public void testInitialParse() throws Exception {
        model.replace(0, 0, "{ def a; use a; { def b; use b; } }");
        triggerParser();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Ignore("TB merge produces invalid textblock")
    @Test
    public void testReparseWithoutModifications() throws Exception {
        model.replace(0, 0, "{ def a; use a; { def b; use b; } }");
        triggerParser();
        Object initialRootObject = IncrementalParserFacade.getParsingResult(model.getRoot());
        
        // Just set the same text again. Everything is the same, thus re-use can be expected
        model.replace(0, model.getLength(), "{ def a; use a; { def b; use b; } }");
        triggerParser();
        
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        assertTrue(initialRootObject == IncrementalParserFacade.getParsingResult(model.getRoot()));
    }
    
    @Test
    public void testAddWhiteSpaces() throws Exception {
        model.replace(0, 0, "{ def a; use a; { def b; use b; } }");
        triggerParser();
        model.replace(0, 0, " \n  "); // add whitespace at the beginning
        model.replace(model.getLength(), 0, "  \n "); // add whitespace at the end
        triggerParser();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testAddWhiteSpacesWithoutIntermediateParse() throws Exception {
        model.replace(0, 0, "{ def a; use a; { def b; use b; } }");
        triggerParser();
        model.replace(0, 0, "  \n "); // add whitespace at the beginning
        model.replace(model.getLength(), 0, " \n  "); // add whitespace at the end
        triggerParser();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testAddNewBlockBefore() throws Exception {
        model.replace(0, 0, "{ def a; use a; { def b; use b; } }");
        triggerParser();
        // add new block before the existing sub-block
        model.replace("{ def a; use a; ".length(), 0, "{ use a; }");
        triggerParser();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testAddNewBlockAfter() throws Exception {
        model.replace(0, 0, "{ def a; use a; { def b; use b; } }");
        triggerParser();
        // add new block after the existing sub-block
        model.replace("{ def a; use a; { def b; use b; }".length(), 0, "{ use a; }");
        triggerParser();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testAddNewBlockBeforeAndAfter() throws Exception {
        model.replace(0, 0, "{ def a; use a; { def b; use b; } }");
        triggerParser();
        // add new block after the existing sub-block
        model.replace("{ def a; use a; { def b; use b; }".length(), 0, "{ use a; }");
        // add new block before the existing sub-block
        model.replace("{ def a; use a; ".length(), 0, "{ use a; }");
        triggerParser();

        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testAddBlockCommentsAroundBlock() throws Exception {
        model.replace(0, 0, "{ def a; use a; { def b; use b; } }");
        triggerParser();
        // quote an existing block
        model.replace("{ def a; use a; ".length(), 0, "/*");
        model.replace(model.getLength()-2, 0, "*/"); // -2 to insert just after the } closing the inner block
        triggerParser();
        
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testAddBlockCommentsAroundBlockWithIntermediateErrors() throws Exception {
        model.replace(0, 0, "{ def a; use a; { def b; use b; } }");
        triggerParser();
        
        // quote an existing block in a partial fashion. Will lead to parsing errors
        model.replace("{ def a; use a; ".length(), 0, "/*");
        triggerParser();
        assertTrue(model.getRoot().getVersion() != Version.REFERENCE);
        
        // now fix the error
        model.replace(model.getLength()-1, 0, "*/");
        triggerParser();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testAddLineComments() throws Exception {
        model.replace(0, 0, "{ \n def a; use a; \n { \n def b; use b; \n } \n}");
        triggerParser();
        
        model.replace("{ \n def a; use a; \n { \n def b; use b; \n".length(), 0, "//"); // before the } closing the inner block
        model.replace("{ \n def a; use a; \n { \n".length(), 0, "//"); // before the conent of the inner block
        model.replace("{ \n def a; use a; \n".length(), 0, "//"); // before the { opening the inner block
        triggerParser();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testAddLineCommentsWithIntermediateErrors() throws Exception {
        model.replace(0, 0, "{ \n def a; use a; \n { \n def b; use b; \n } \n}");
        triggerParser();
        
        // same as testcase above, but parser tirggered in-between 
        
        model.replace("{ \n def a; use a; \n { \n def b; use b; \n".length(), 0, "//"); // before the } closing the inner block
        triggerParser();
        model.replace("{ \n def a; use a; \n { \n".length(), 0, "//"); // before the conent of the inner block
        triggerParser();
        model.replace("{ \n def a; use a; \n".length(), 0, "//"); // before the { opening the inner block
        triggerParser();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Ignore("Parxer accepting invalid syntax? Or is there some error recovery going on?")
    @Test
    public void testDeleteBlock() throws Exception {
        model.replace(0, 0, "{ def a; use a; { def b; use b; } }");
        triggerParser();

        // Replace block contents with comment
        model.replace("{ def a; use a; {".length(), " def b; use b;".length(), " /* now empty */");
        triggerParser();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        
        // Remove everything from empty up to the end (including the } belonging to the outer block}
        // Will lead to parsing errors because outer block is not closed
        model.replace("{ def a; use a;".length(), model.getLength() - "{ def a; use a;".length() , "");
        triggerParser();
        assertTrue(model.getRoot().getVersion() != Version.REFERENCE);
        
        // add missing quote. Parsing errors should go away
        model.replace(model.getLength(), 0, "}"); 
        triggerParser();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testEnterAndRemoveParsingErrors() throws Exception {
        model.replace(0, 0, "{ def a; use a; { def b; use b; } }");
        triggerParser();

        model.replace(0, "{ def a; ".length(), " BUG  ");
        triggerParser();
        assertTrue(model.getRoot().getVersion() != Version.REFERENCE);
        
        // re-add the required starting {
        model.replace(0, " BUG".length(), " { ");
        triggerParser();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testEnterAndRemoveParsingErrorsViaComment() throws Exception {
        model.replace(0, 0, "{ def a; use a; { def b; use b; } }");
        triggerParser();

        model.replace(0, "{ def a; ".length(), " BUG  ");
        triggerParser();
        assertTrue(model.getRoot().getVersion() != Version.REFERENCE);

        // Add newline after BUG
        model.replace(" BUG".length(), 0, "\n");
        triggerParser();
        assertTrue(model.getRoot().getVersion() != Version.REFERENCE);

        // Fix the bug by adding a comment before the problematic region
        model.replace(0, 0, "//");
        model.replace("// BUG ".length(), 0, "{"); // re add after commented line
        triggerParser();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        
        // Remove the comment again. Parsing problem should be back
        model.replace(0, "// ".length(), "");
        triggerParser();
        assertTrue(model.getRoot().getVersion() != Version.REFERENCE);
        
        // Re-add the comment. Everything should be fine again.
        model.replace(0, 0, "//");
        triggerParser();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testEnterAndRemoveLexerErrors() throws Exception {
        model.replace(0, 0, "{ def a; use a; { def b; use b; } }");
        triggerParser();

        model.replace("{ def a; use".length(), 0, "&%$ Unlexable");
        triggerParser();
        assertTrue(model.getRoot().getVersion() != Version.REFERENCE);
        
        model.replace("{ def a; use".length(), "&%$ Unlexable".length(), " /* Removed unlexable cruft */ ");
        triggerParser();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    
    @Test
    public void testMergeTwoBlocks() throws Exception {
        model.replace(0, 0, "{ def a; use a; { def b; use b; } }");
        triggerParser();

        // remove the { which starts the second block
        model.replace("{ def a; use a; ".length(), "{".length(), " ");
        triggerParser();
        assertTrue(model.getRoot().getVersion() != Version.REFERENCE);

        // remove the last }. This will fix the parsing error and the two
        // blocks are finnally merged.
        model.replace(model.getLength()-1, "}".length(), " ");
        triggerParser();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Ignore("TB merge produces invalid textblock")
    @Test
    public void testMergeTwoBlocksInstantious() throws Exception {
        model.replace(0, 0, "{ def a; use a; { def b; use b; } }");
        triggerParser();

        // this is the same as #testMergeTwoBlocks() but without intermediate errors

        // remove the { which starts the second block and the last }
        // which originally belonged to the outer block
        model.replace("{ def a; use a; ".length(), "{".length(), " ");
        model.replace(model.getLength()-1, "}".length(), " ");
        triggerParser();
        
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Ignore("TB merge produces invalid textblock")
    @Test
    public void testMergeTwoBlocksInstantious2() throws Exception {
        model.replace(0, 0, "{ def a; use a; { def b; use b; } }");
        triggerParser();

        // this is the same as #testMergeTwoBlocksInstantious() but
        // now the inner bracket is removed.

        // remove the { which starts the second block and the second last }
        // which originally belonged to the inner block
        model.replace("{ def a; use a; ".length(), "{".length(), " ");
        model.replace(model.getLength()-"} }".length(), "}".length(), " ");
        triggerParser();
        
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testSplitTwoBlocks() throws Exception {
        model.replace(0, 0, "{ def a; use a; def b; use b; }");
        triggerParser();

        // enter { after use a; to open a sub block
        model.replace("{ def a; use a; ".length(), 0, "{");
        triggerParser();
        assertTrue(model.getRoot().getVersion() != Version.REFERENCE);

        // close the sub-block with a }. This will fix the parsing error and lead
        // to the instantiation of a sub-block
        model.replace(model.getLength()-1, 0, "}");
        triggerParser();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testMergeTwoTokens() throws Exception {
        model.replace(0, 0, "{ def Double; }");
        triggerParser();

        // add space
        model.replace("{ def Double".length(), 0, " ");
        triggerParser();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        
        // add new identifier after the space
        model.replace("{ def Double ".length(), 0, "Name");
        triggerParser();
        assertTrue(model.getRoot().getVersion() != Version.REFERENCE);
        
        // merge the two tokens into one by removing the space
        model.replace("{ def Double".length(), 1, "");
        triggerParser();
        
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testSplitToken() throws Exception {
        model.replace(0, 0, "{ def DoubleName; }");
        triggerParser();

        // split token via space
        model.replace("{ def Double".length(), 0, " ");
        triggerParser();
        assertTrue(model.getRoot().getVersion() != Version.REFERENCE);
        
        // fix error by morphing the token fragment into a valid definition
        model.replace("{ def Double".length(), 0, "; def");
        triggerParser();
        
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testSplitToken2() throws Exception {
        model.replace(0, 0, "{ def DoubleName; }");
        triggerParser();

        // split token via space
        model.replace("{ def Double".length(), 0, " ");
        triggerParser();
        assertTrue(model.getRoot().getVersion() != Version.REFERENCE);
        
        // fix error by removing one of the two token fragments
        model.replace("{ def ".length(), "Double".length(), "");
        triggerParser();
        
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Ignore("Lexer crashes with exception")
    @Test
    public void testDeeplyNestedBlocks() throws Exception {
        model.replace(0, 0, "{ }");
        triggerParser();

        // add several new blocks.
        model.replace("{".length(), 0, "{{ def a; { {use a;} {use a;} }}}");
        triggerParser();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        
        // morph outmost block into an inner block
        model.replace(0 , 0, "{\n");
        model.replace(model.getLength() , 0, "\n}");
        triggerParser();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);

        // morph back to outmost block
        model.replace(0 , 1, ""); // delete { 
        model.replace(model.getLength()-1 , 1, ""); // delete }
        triggerParser();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        
        // remove all blocks at once.
        model.replace(0, model.getLength(), "{}");        
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testResetCharactsIndividually() throws Exception {
        model.replace(0, 0, "{ def a; use a; { { def b; use b; } } {} {}  }");
        triggerParser();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        
        String initialContent = model.get(0, model.getLength());
        // Loop over the whole model. Replace each char with itself.
        // So basically do a no-op
        for (int i = 0; i < model.getLength(); i++) {
            model.replace(i, 1, model.get(i, 1));
            triggerParser();
        }
        assertEquals(initialContent, model.get(0, model.getLength()));
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
        

    
}
