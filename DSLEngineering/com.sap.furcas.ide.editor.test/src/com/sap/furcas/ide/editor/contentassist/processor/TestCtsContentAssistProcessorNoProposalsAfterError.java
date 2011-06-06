package com.sap.furcas.ide.editor.contentassist.processor;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.ide.editor.test.utils.StringReplacement;

public class TestCtsContentAssistProcessorNoProposalsAfterError extends
        CtsContentAssistProcessorEditorTestMetamodelTestBase {

    @BeforeClass
    public static void generateParser() throws Exception {
        initMetamodelTestbase("NoProposalsAfterErr");
    }

    @Test
    public void testTokenErrorBeginningOfFile() throws Exception {
        initProcessorForPrefix("TokenError", new StringReplacement(0, 0, "studX  \n\n"));
        
        List<String> expected = new ArrayList<String>();
        expected.add("student");
        expected.add("student name aaa");
        expected.add("student name bbb");

        assertDisplayStrings(expected, 0, 0);
    }

    @Test
    public void testTokenErrorInBrokenTokenBeforeError() throws Exception {
        initProcessorForPrefix("TokenError", new StringReplacement(0, 0, "studX  \n\n"));
        
        List<String> expected = new ArrayList<String>();
        expected.add("student");
        expected.add("student name aaa");
        expected.add("student name bbb");

        assertDisplayStrings(expected, 0, 4);
    }

    @Test
    public void testTokenErrorInBrokenTokenAfterError() throws Exception {
        initProcessorForPrefix("TokenError", new StringReplacement(0, 0, "studX  \n\n"));
        
        List<String> expected = new ArrayList<String>();

        // prefix filter should deal with this

        assertDisplayStrings(expected, 0, 5);
    }

    @Test
    public void testTokenErrorAfterBrokenNonIdentifierToken() throws Exception {
        initProcessorForPrefix("TokenError", new StringReplacement(0, 0, "studX  \n\n"));
        
        List<String> expected = new ArrayList<String>();

        // no proposals after error

        assertDisplayStrings(expected, 0, 6);
    }

    @Test
    public void testTokenErrorInNextLine() throws Exception {
        initProcessorForPrefix("TokenError", new StringReplacement(0, 0, "studX  \n\n"));
        
        List<String> expected = new ArrayList<String>();

        // no proposals after error

        assertDisplayStrings(expected, 1, 0);
    }
    
    @Test
    public void testRuleErrorBeginningOfFile() throws Exception {
        initProcessorForPrefix("RuleError", new StringReplacement(0, 0, "student peter aa"));
        
        List<String> expected = new ArrayList<String>();
        expected.add("student");
        expected.add("student name aaa");
        expected.add("student name bbb");

        assertDisplayStrings(expected, 0, 0);
    }

    @Test
    public void testRuleErrorBeforeNonIdentifierToken() throws Exception {
        initProcessorForPrefix("RuleError", new StringReplacement(0, 0, "student peter aa"));
        
        List<String> expected = new ArrayList<String>();

        // no proposals, as alternative as ANTRL puts an error at alternative

        assertDisplayStrings(expected, 0, 14);
    }

    @Test
    public void testRuleErrorMiddleOfNonIdentifierToken() throws Exception {
        initProcessorForPrefix("RuleError", new StringReplacement(0, 0, "student peter aa"));
        
        List<String> expected = new ArrayList<String>();

        // no proposals, as alternative as ANTRL puts an error at alternative

        assertDisplayStrings(expected, 0, 15);
    }
}
