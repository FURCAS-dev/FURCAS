package com.sap.furcas.ide.editor.contentassist;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.TCS.FunctionCall;
import com.sap.furcas.runtime.common.util.TCSSpecificOCLEvaluator;
import com.sap.furcas.runtime.tcs.testbase.TCSFixtureTestBase;

public class TestCtsContentAssistUtil extends TCSFixtureTestBase {
    private CtsContentAssistContext context;
    private TCSSpecificOCLEvaluator oclEvaluator;

    @Before
    public void createContext() {
        context = new CtsContentAssistContext();
        Stack<FunctionCall> parentFunctionCallStack = new Stack<FunctionCall>();
        context.setParentFunctionCallStack(parentFunctionCallStack);
        
        oclEvaluator = new TCSSpecificOCLEvaluator();
    }

    @Test
    public void testFollowProposalsFromContextMain1Lit() {

        List<String> expected = new ArrayList<String>();
        // from main2Cond then branch
        expected.add("keywordA");
        // as main2Cond else branch is empty, from main3Prop
        expected.add("name");

        context.setSequenceElement(main1Lit);

        assertEquals(expected, CompletionListHelper.collectDisplayStrings(CompletionListHelper
                .removeNullValues(CtsCompletionCalculator.createFollowProposalsFromContext(null, context, null, null, 0, 0, null,
                        null, oclEvaluator))));
    }

    @Test
    public void testFollowProposalsFromContextMain2CondThenLit() {

        List<String> expected = new ArrayList<String>();
        expected.add("name");

        context.setSequenceElement(main2CondThenLit);

        assertEquals(expected, CompletionListHelper.collectDisplayStrings(CompletionListHelper
                .removeNullValues(CtsCompletionCalculator.createFollowProposalsFromContext(null, context, null, null, 0, 0, null,
                        null, oclEvaluator))));
    }

    @Test
    public void testFollowProposalsFromContextMain3Prop() {

        List<String> expected = new ArrayList<String>();
        expected.add("keywordB");
        expected.add("symbolB");

        context.setSequenceElement(main3Prop);

        assertEquals(expected, CompletionListHelper.collectDisplayStrings(CompletionListHelper
                .removeNullValues(CtsCompletionCalculator.createFollowProposalsFromContext(null, context, null, null, 0, 0, null,
                        null, oclEvaluator))));
    }

    @Ignore("Failing after the EMF migration. Failing for unknown reasons")
    @Test
    public void testFollowProposalsFromContextMain4AltCase1Lit() {

        List<String> expected = new ArrayList<String>();

        // not mode 1
        // from mode2
        expected.add("symbolB");
        // from funcTemplateLit
        expected.add("keywordA");

        context.setSequenceElement(main4AltCase1Lit);

        assertEquals(expected, CompletionListHelper.collectDisplayStrings(CompletionListHelper
                .removeNullValues(CtsCompletionCalculator.createFollowProposalsFromContext(null, context, classTemplateMap, null, 0,
                        0, null, null, oclEvaluator))));
    }

    @Ignore("Failing after the EMF migration. Failing for unknown reasons")
    @Test
    public void testFollowProposalsFromContextMain5BlockProp() {

        List<String> expected = new ArrayList<String>();

        // main5BlockProp is multi-valued, repeat possible tokens of
        // main5BlockProp

        // not mode 1
        // from mode2
        expected.add("symbolB");

        // from next SequenceElement
        expected.add("keywordA");

        context.setSequenceElement(main5BlockProp);

        assertEquals(expected, CompletionListHelper.collectDisplayStrings(CompletionListHelper
                .removeNullValues(CtsCompletionCalculator.createFollowProposalsFromContext(null, context, classTemplateMap, null, 0,
                        0, null, null, oclEvaluator))));
    }

    @Test
    public void testFollowProposalsFromContextFuncTemplateLitInMain6Call() {

        List<String> expected = new ArrayList<String>();
        expected.add("keywordA");

        context.setSequenceElement(funcTemplateLit);
        context.getParentFunctionCallStack().push(main6Call);

        assertEquals(expected, CompletionListHelper.collectDisplayStrings(CompletionListHelper
                .removeNullValues(CtsCompletionCalculator.createFollowProposalsFromContext(null, context, null, null, 0, 0, null,
                        null, oclEvaluator))));
    }

    @Test
    public void testFollowProposalsFromContextMain7Lit() {

        List<String> expected = new ArrayList<String>();

        expected.add("keywordA");

        context.setSequenceElement(main7Lit);

        assertEquals(expected, CompletionListHelper.collectDisplayStrings(CompletionListHelper
                .removeNullValues(CtsCompletionCalculator.createFollowProposalsFromContext(null, context, null, null, 0, 0, null,
                        null, oclEvaluator))));
    }

    @Test
    public void testFollowProposalsFromContextFuncTemplateLitInMain8Call() {
        List<String> expected = new ArrayList<String>();

        expected.add("keywordB");

        context.setSequenceElement(funcTemplateLit);
        context.getParentFunctionCallStack().push(main8Call);

        assertEquals(expected, CompletionListHelper.collectDisplayStrings(CompletionListHelper
                .removeNullValues(CtsCompletionCalculator.createFollowProposalsFromContext(null, context, null, null, 0, 0, null,
                        null, oclEvaluator))));
    }

    @Test
    public void testFollowProposalsFromContextNull() {

        List<String> expected = new ArrayList<String>();

        assertEquals(expected,
                CompletionListHelper.collectDisplayStrings(CompletionListHelper.removeNullValues(CtsCompletionCalculator
                        .createFollowProposalsFromContext(null, null, null, null, 0, 0, null, null, oclEvaluator))));
    }

    @Test
    public void testGetCommonPrefix() {
        String a = "aaaabbbbbb";
        String b = "aa";
        String c = "aaaccccc";

        assertEquals("aa", CtsContentAssistUtil.getCommonPrefix(a, b));
        assertEquals("aaa", CtsContentAssistUtil.getCommonPrefix(a, c));
    }
}
