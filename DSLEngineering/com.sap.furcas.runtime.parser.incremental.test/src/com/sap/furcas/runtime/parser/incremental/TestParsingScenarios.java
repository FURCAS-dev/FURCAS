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
        setupParser(LANGUAGE, TCS, /*useModelUpdaters*/ true, METAMODELS);
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
        model.replace(0, 0, "{ def a; use a; { def b; use b; } }");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testReparseWithoutModificationsSimple() throws Exception {
        model.replace(0, 0, "{ { /*inner*/ } }");
        triggerParserAndExpectReuse();
        Object initialRootObject = IncrementalParserFacade.getParsingResult(model.getRoot());
        
        // Just set the same text again. Everything is the same, thus re-use can be expected
        model.replace(0, model.getLength(), "{ { /*inner*/ } }");
        triggerParserAndExpectReuse();
        
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        assertTrue(initialRootObject == IncrementalParserFacade.getParsingResult(model.getRoot()));
    }
    
    @Test
    public void testReparseWithoutModifications() throws Exception {
        model.replace(0, 0, "{ def a; use a; { def b; use b; } }");
        triggerParserAndExpectReuse();
        Object initialRootObject = IncrementalParserFacade.getParsingResult(model.getRoot());
        
        // Just set the same text again. Everything is the same, thus re-use can be expected
        model.replace(0, model.getLength(), "{ def a; use a; { def b; use b; } }");
        triggerParserAndExpectReuse();
        
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        assertTrue(initialRootObject == IncrementalParserFacade.getParsingResult(model.getRoot()));
    }
    
    @Test
    public void testAddWhiteSpaces() throws Exception {
        model.replace(0, 0, "{ def a; use a; { def b; use b; } }");
        triggerParserAndExpectReuse();
        model.replace(0, 0, " \n  "); // add whitespace at the beginning
        model.replace(model.getLength(), 0, "  \n "); // add whitespace at the end
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testAddWhiteSpacesWithoutIntermediateParse() throws Exception {
        model.replace(0, 0, "{ def a; use a; { def b; use b; } }");
        triggerParserAndExpectReuse();
        model.replace(0, 0, "  \n "); // add whitespace at the beginning
        model.replace(model.getLength(), 0, " \n  "); // add whitespace at the end
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testAddNewBlockBefore() throws Exception {
        model.replace(0, 0, "{ def a; use a; { def b; use b; } }");
        triggerParserAndExpectReuse();
        // add new block before the existing sub-block
        model.replace("{ def a; use a; ".length(), 0, "{ use a; }");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testAddNewBlockAfter() throws Exception {
        model.replace(0, 0, "{ def a; use a; { def b; use b; } }");
        triggerParserAndExpectReuse();
        // add new block after the existing sub-block
        model.replace("{ def a; use a; { def b; use b; }".length(), 0, "{ use a; }");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testAddNewBlockBeforeAndAfter() throws Exception {
        model.replace(0, 0, "{ def a; use a; { def b; use b; } }");
        triggerParserAndExpectReuse();
        // add new block after the existing sub-block
        model.replace("{ def a; use a; { def b; use b; }".length(), 0, "{ use a; }");
        // add new block before the existing sub-block
        model.replace("{ def a; use a; ".length(), 0, "{ use a; }");
        triggerParserAndExpectReuse();

        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testAddBlockCommentsAroundBlock() throws Exception {
        model.replace(0, 0, "{ def a; use a; { def b; use b; } }");
        triggerParserAndExpectReuse();
        // quote an existing block
        model.replace("{ def a; use a; ".length(), 0, "/*");
        model.replace(model.getLength()-2, 0, "*/"); // -2 to insert just after the } closing the inner block
        triggerParserAndExpectReuse();
        
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testAddBlockCommentsAroundBlockWithIntermediateErrors() throws Exception {
        model.replace(0, 0, "{ def a; use a; { def b; use b; } }");
        triggerParserAndExpectReuse();
        
        // quote an existing block in a partial fashion. Will lead to parsing errors
        model.replace("{ def a; use a; ".length(), 0, "/*");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() != Version.REFERENCE);
        
        // now fix the error
        model.replace(model.getLength()-1, 0, "*/");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testAddLineComment() throws Exception {
        model.replace(0, 0, "{ \n def a; use a; \n { def b; use b; }\n { def c; use c; }}");
        triggerParserAndExpectReuse();
        
        model.replace("{ \n def a; use a; \n ".length(), 0, "//"); // before the { opening the first inner block
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testAddLineComments() throws Exception {
        model.replace(0, 0, "{ \n def a; use a; \n { \n def b; use b; \n } \n}");
        triggerParserAndExpectReuse();
        
        model.replace("{ \n def a; use a; \n { \n def b; use b; \n".length(), 0, "//"); // before the } closing the inner block
        model.replace("{ \n def a; use a; \n { \n".length(), 0, "//"); // before the content of the inner block
        model.replace("{ \n def a; use a; \n".length(), 0, "//"); // before the { opening the inner block
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testAddLineCommentsWithIntermediateErrors() throws Exception {
        model.replace(0, 0, "{ \n def a; use a; \n { \n def b; use b; \n } \n}");
        triggerParserAndExpectReuse();
        
        // same as testcase above, but parser tirggered in-between 
        
        model.replace("{ \n def a; use a; \n { \n def b; use b; \n".length(), 0, "//"); // before the } closing the inner block
        triggerParserAndExpectReuse();
        model.replace("{ \n def a; use a; \n { \n".length(), 0, "//"); // before the conent of the inner block
        triggerParserAndExpectReuse();
        model.replace("{ \n def a; use a; \n".length(), 0, "//"); // before the { opening the inner block
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testInsertInBlock() throws Exception{
        model.replace(0, 0, "{ def a; use a; { def b; use b; } }");
        triggerParserAndExpectReuse();

        // Insert a new definition in the root block
        model.replace("{ def a; ".length(), 0, "def new;");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        
        // Insert a new usage in the sub block
        model.replace("{ def a; use a; { def b; ".length(), 0, "use new;");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testInsertAtBlockBoundary() throws Exception{
        model.replace(0, 0, "{ def a; use a; { def b; use b; } }");
        triggerParserAndExpectReuse();

        // Insert a new definition at the end of the root block
        model.replace("{ def a; use a; { def b; use b; } ".length(), 0, "def last; ");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        
        // Insert a new definition at the end of the sub block
        model.replace("{ def a; use a; { def b; use b; ".length(), 0, "def last; ");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        
        // Insert a new definition at the beginning of the sub block
        model.replace("{ def a; use a; {".length(), 0, "def first;");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        
        // Insert a new definition at the beginning of the root block
        model.replace("{".length(), 0, "def first;");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testInsertCharactersInBlock() throws Exception{
        model.replace(0, 0, "{ def a; use a; { def b; use b; } }");
        triggerParserAndExpectReuse();

        // We want to insert a new definition (def new;) but will add it via  
        // many little steps, similar to a potential editor session
        model.replace("{ def a".length(), 0, " ");
        triggerParserAndExpectReuse();
        model.replace("{ def a".length(), 0, " ");
        triggerParserAndExpectReuse();
        model.replace("{ def a ".length(), 0, "de");
        triggerParserAndExpectReuse();
        model.replace("{ def a de".length(), 0, "f");
        triggerParserAndExpectReuse();
        model.replace("{ def a".length(), 0, ";");
        triggerParserAndExpectReuse();
        model.replace("{ def a; def ".length(), 0, "n");
        triggerParserAndExpectReuse();
        model.replace("{ def a; def n".length(), 0, "ew");
        triggerParserAndExpectReuse();
        
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testDeleteBlock() throws Exception {
        model.replace(0, 0, "{ def a; use a; { def b; use b; } }");
        triggerParserAndExpectReuse();

        // Replace block contents with comment
        model.replace("{ def a; use a; {".length(), " def b; use b;".length(), " /* now empty */");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        
        // Remove everything from empty up to the end (but not including the } belonging to the outer block}
        model.replace("{ def a; use a;".length(), model.getLength() - "{ def a; use a;".length() -1, "");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testDeleteBlockWithIntermediateErrors() throws Exception {
        model.replace(0, 0, "{ def a; use a; { def b; use b; } }");
        triggerParserAndExpectReuse();

        // Replace block contents with comment
        model.replace("{ def a; use a; {".length(), " def b; use b;".length(), " /* now empty */");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        
        // Remove everything from empty up to the end (including the } belonging to the outer block}
        // Will lead to parsing errors because outer block is not closed
        model.replace("{ def a; use a;".length(), model.getLength() - "{ def a; use a;".length() , "");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() != Version.REFERENCE);
        
        // add missing quote. Parsing errors should go away
        model.replace(model.getLength(), 0, "}"); 
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testDeleteInBlock() throws Exception {
        model.replace(0, 0, "{ def a; use a; { def b; use b; } }");
        triggerParserAndExpectReuse();
        
        model.replace("{ def a; use a; { def b; ".length(), "use b;".length(), "");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        
        model.replace("{ def a; use a; { ".length(), "def b;".length(), "");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        
        model.replace("{ def a; ".length(), "use a;".length(), "");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        
        model.replace("{ ".length(), "def a;".length(), "");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testEnterAndRemoveParsingErrors() throws Exception {
        model.replace(0, 0, "{ def a; use a; { def b; use b; } }");
        triggerParserAndExpectReuse();

        model.replace(0, "{ def a; ".length(), " BUG  ");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() != Version.REFERENCE);
        
        // re-add the required starting {
        model.replace(0, " BUG".length(), " { ");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testEnterAndRemoveParsingErrorsViaComment() throws Exception {
        model.replace(0, 0, "{ def a; use a; { def b; use b; } }");
        triggerParserAndExpectReuse();

        model.replace(0, "{ def a; ".length(), " BUG  ");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() != Version.REFERENCE);

        // Add newline after BUG
        model.replace(" BUG".length(), 0, "\n");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() != Version.REFERENCE);

        // Fix the bug by adding a comment before the problematic region
        model.replace(0, 0, "//");
        model.replace("// BUG ".length(), 0, "{"); // re add after commented line
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        
        // Remove the comment again. Parsing problem should be back
        model.replace(0, "// ".length(), "");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() != Version.REFERENCE);
        
        // Re-add the comment. Everything should be fine again.
        model.replace(0, 0, "//");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testEnterAndRemoveLexerErrors() throws Exception {
        model.replace(0, 0, "{ def a; use a; { def b; use b; } }");
        triggerParserAndExpectReuse();

        model.replace("{ def a; use".length(), 0, "&%$ Unlexable");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() != Version.REFERENCE);
        
        model.replace("{ def a; use".length(), "&%$ Unlexable".length(), " /* Removed unlexable cruft */ ");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    
    @Test
    public void testMergeTwoBlocks() throws Exception {
        model.replace(0, 0, "{ def a; use a; { def b; use b; } }");
        triggerParserAndExpectReuse();

        // remove the { which starts the second block
        model.replace("{ def a; use a; ".length(), "{".length(), " ");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() != Version.REFERENCE);

        // remove the last }. This will fix the parsing error and the two
        // blocks are finnally merged.
        model.replace(model.getLength()-1, "}".length(), " ");
        triggerParser(); // can't expect reuse. Don't know which block will survive
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testMergeTwoBlocksInstant() throws Exception {
        model.replace(0, 0, "{ def a; use a; { def b; use b; } }");
        triggerParserAndExpectReuse();

        // this is the same as #testMergeTwoBlocks() but without intermediate errors

        // remove the { which starts the second block and the last }
        // which originally belonged to the outer block
        model.replace("{ def a; use a; ".length(), "{".length(), " ");
        model.replace(model.getLength()-1, "}".length(), " ");
        triggerParser(); // can't expect reuse. Don't know which block will survive
        
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testMergeTwoBlocksInstant2() throws Exception {
        model.replace(0, 0, "{ def a; use a; { def b; use b; } }");
        triggerParserAndExpectReuse();

        // this is the same as #testMergeTwoBlocksInstant() but
        // now the inner bracket is removed.

        // remove the { which starts the second block and the second last }
        // which originally belonged to the inner block
        model.replace("{ def a; use a; ".length(), "{".length(), " ");
        model.replace(model.getLength()-"} }".length(), "}".length(), " ");
        triggerParserAndExpectReuse();
        
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testSplitTwoBlocks() throws Exception {
        model.replace(0, 0, "{ def a; use a; def b; use b; }");
        triggerParserAndExpectReuse();

        // enter { after use a; to open a sub block
        model.replace("{ def a; use a; ".length(), 0, "{");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() != Version.REFERENCE);

        // close the sub-block with a }. This will fix the parsing error and lead
        // to the instantiation of a sub-block
        model.replace(model.getLength()-1, 0, " }"); //FIXME: Fails when we simply replace with "}"
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testSplitTwoBlocksInner() throws Exception {
        model.replace(0, 0, "{ def a; use a; def b; use b; }");
        triggerParserAndExpectReuse();

        // enter { after def a; to open a sub block
        model.replace("{ def a; ".length(), 0, "{");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() != Version.REFERENCE);

        // close the sub-block with a }. This is similar to the testcase above,
        // but we make sure the created subblock lies within the 
        // root block and not at its boundary
        model.replace("{ def a; { use a;".length(), 0, "}");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testMergeTwoTokens() throws Exception {
        model.replace(0, 0, "{ def Double; }");
        triggerParserAndExpectReuse();

        // add space
        model.replace("{ def Double".length(), 0, " ");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        
        // add new identifier after the space
        model.replace("{ def Double ".length(), 0, "Name");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() != Version.REFERENCE);
        
        // merge the two tokens into one by removing the space
        model.replace("{ def Double".length(), 1, "");
        triggerParserAndExpectReuse();
        
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testSplitToken() throws Exception {
        model.replace(0, 0, "{ def DoubleName; }");
        triggerParserAndExpectReuse();

        // split token via space
        model.replace("{ def Double".length(), 0, " ");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() != Version.REFERENCE);
        
        // fix error by morphing the token fragment into a valid definition
        model.replace("{ def Double".length(), 0, "; def");
        triggerParserAndExpectReuse();
        
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testSplitToken2() throws Exception {
        model.replace(0, 0, "{ def DoubleName; }");
        triggerParserAndExpectReuse();

        // split token via space
        model.replace("{ def Double".length(), 0, " ");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() != Version.REFERENCE);
        
        // fix error by removing one of the two token fragments
        model.replace("{ def ".length(), "Double".length(), "");
        triggerParserAndExpectReuse();
        
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testDeeplyNestedBlocks() throws Exception {
        model.replace(0, 0, "{ }");
        triggerParserAndExpectReuse();

        // add several new blocks.
        model.replace("{".length(), 0, "{{ def a; { {use a;} {use a;} }}}");
        triggerParserAndExpectReuse();
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
        triggerParser(); // Cannot expect reuse. We don't know which of the block shall be retained.
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testResetCharactsIndividually() throws Exception {
        model.replace(0, 0, "{ def a; use a; { { def b; use b; } } {} {}  }");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        
        String initialContent = model.get(0, model.getLength());
        // Loop over the whole model. Replace each char with itself.
        // So basically do a no-op
        for (int i = 0; i < model.getLength(); i++) {
            model.replace(i, 1, model.get(i, 1));
            triggerParserAndExpectReuse();
            assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        }
        assertEquals(initialContent, model.get(0, model.getLength()));
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testReplaceCharactersWithWhiteSpace() throws Exception {
        model.replace(0, 0, "{ def a; use a; { { def b; use b; } } {} {}  }");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        
        // Loop over the whole model. Replace each char with itself,
        // except the first and last bracket. Keep the { } to still have a valid model
        for (int i = 1; i < model.getLength()-1; i++) {
            model.replace(i, 1, " ");
            triggerParserAndExpectReuse();
            // can have intermediate errors here
        }
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testReplaceTokenWithItself() throws Exception {
        model.replace(0, 0, "{ { def a; } }");
        triggerParserAndExpectReuse();
        
        // rename a to a
        model.replace("{ { def ".length(), "a".length(), "a");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        
        // rename ; to ;
        model.replace("{ { def a".length(), ";".length(), ";");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testReplaceSubBlockWithItself() throws Exception {
        model.replace(0, 0, "{ { def a; } { def b; } { def c; } }");
        triggerParserAndExpectReuse();
        
        //  replace the inner block with itself
        model.replace("{ { def a; } ".length(), "{ def b; }".length(), "{ def b; }");
        triggerParserAndExpectReuse();
        
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testSwapStatementsViaRename() throws Exception {
        model.replace(0, 0, "{ def a; def b; }");
        triggerParserAndExpectReuse();
        
        // rename "a" to "b" and "b" to "a".
        model.replace("{ def a; def ".length(), "b".length(), "a");
        triggerParserAndExpectReuse();
        model.replace("{ def ".length(), "a".length(), "b");
        triggerParserAndExpectReuse();
        
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testSwapStatementsViaRenameInstant() throws Exception {
        model.replace(0, 0, "{ def a; def b; }");
        triggerParserAndExpectReuse();
        
        // rename "a" to "b" and "b" to "a" without intermediate parsing.
        model.replace("{ def a; def ".length(), "b".length(), "a");
        model.replace("{ def ".length(), "a".length(), "b");
        triggerParserAndExpectReuse();
        
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testSwapStatements() throws Exception {
        model.replace(0, 0, "{ def a; def b; }");
        triggerParserAndExpectReuse();
        
        // replace "def a" with "def b" and "def b" with "def a"
        model.replace("{ def a; ".length(), "def b;".length(), "def a;");
        triggerParserAndExpectReuse();
        model.replace("{ ".length(), "def a;".length(), "def b;");
        triggerParserAndExpectReuse();
        
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testSwapStatementsInstant() throws Exception {
        model.replace(0, 0, "{ def a; def b; }");
        triggerParserAndExpectReuse();
        
        // replace "def a" with "def b" and "def b" with "def a".
        // Without intermediate parsing.
        model.replace("{ def a; ".length(), "def b;".length(), "def a;");
        model.replace("{ ".length(), "def a;".length(), "def b;");
        triggerParserAndExpectReuse();
        
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testSwapStatementsComplex() throws Exception {
        model.replace(0, 0, "{{ def a; { { {use a; {def c;} } } {use a; def d;} }}}");
        triggerParserAndExpectReuse();
        
        // swap the right most "def d" with "use a; {def c;}" 
        model.replace("{{ def a; { { {".length(), "use a; {def c;}".length(), "def d;");
        triggerParserAndExpectReuse();
        model.replace("{{ def a; { { {def d; } } {use a; ".length(), "def d;".length(), "use a; {def c;}");
        triggerParserAndExpectReuse();
        
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testSwapStatementsComplexInstant() throws Exception {
        model.replace(0, 0, "{{ def a; { { {use a; {def c;} } } {use a; def d;} }}}");
        triggerParserAndExpectReuse();
        
        // swap the right most "def d" with "use a; {def c;}" without intermediate parsing.
        model.replace("{{ def a; { { {".length(), "use a; {def c;}" .length(), "def d;");
        model.replace("{{ def a; { { {def d; } } {use a; ".length(), "def d;".length(), "use a; {def c;}");
        triggerParserAndExpectReuse();
        
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testMoveStatement() throws Exception {
        model.replace(0, 0, "{{ def a; { {use a; {def c;} } {use a;} }}}");
        triggerParserAndExpectReuse();
        
        // Move def c; to different places.
        
        // move before use a;
        model.replace("{{ def a; { {use a; {".length(), "def c;".length(), ""); // delete
        model.replace("{{ def a; { {".length(), 0, "def c;"); // insert
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        
        // move before def a;
        model.replace("{{ def a; { {".length(), "def c;".length(), ""); // delete
        model.replace("{{".length(), 0, "def c;"); // insert 
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        
        // move to the end before the last }
        model.replace("{{".length(), "def c;".length(), ""); // delete
        model.replace("{{ def a; { {use a; {} } {use a;} }".length(), 0, "def c;"); // insert
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    @Test
    public void testMoveStatementWithErrors() throws Exception {
        model.replace(0, 0, "{{ def a; { {use a; {def c;} } {use a;} }}}");
        triggerParserAndExpectReuse();
        
        // Move def c; out of scope. Then back again.
        
        // move behind the last closing }
        model.replace("{{ def a; { {use a; {".length(), "def c;".length(), ""); // delete
        model.replace("{{ def a; { {use a; {} } {use a;} }}}".length(), 0, "def c;"); // insert
        triggerParserAndExpectReuse();
        
        // has to yield errors. Statement may not be placed there
        assertTrue(model.getRoot().getVersion() != Version.REFERENCE);

        // move to the left of the right most }
        model.replace("{{ def a; { {use a; {} } {use a;} }}}".length(), "def c;".length(), ""); // delete
        model.replace("{{ def a; { {use a; {} } {use a;} }}".length(), 0, "def c;"); // insert

        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    
}
