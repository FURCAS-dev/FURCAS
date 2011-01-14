/**
 * 
 */
package com.sap.furcas.runtime.parser.impl;

import static junit.framework.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.parser.tcs.TCSParserFacadeFactory;
import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.testbase.stubs.StubModelAdapter;
import com.sap.furcas.test.fixture.ScenarioFixtureData;
import com.sap.furcas.utils.projects.FileReadHelper;

/**
 * Test class to make sure a generated Parser notifies an Observer of all required events and none more.
 */
public class TestObservation {

    @Test
    public void testTcsParserWithBibText() throws Exception {
        ParserFacade facade = TCSParserFacadeFactory.INSTANCE.createTCSParserFacade();
        File syntaxDefFile = ScenarioFixtureData.BIBTEXT_TCS;
        InputStream in = new FileInputStream(syntaxDefFile);
        StubModelAdapter modelHandler = new StubModelAdapter();
        ConsistencyChecksObserver testObserver = new ConsistencyChecksObserver();

        // SystemOutObserver testObserver = new SystemOutObserver();
        facade.parseProductionRule(in, modelHandler, null, null, testObserver);

        assertEquals(0, testObserver.errorsInRule.size());
        assertEquals(111, testObserver.tokensConsumed.size());
        assertEquals(0, testObserver.errorTokensConsumed.size());
        assertEquals(0, testObserver.ruleContextStack.size());
        assertEquals(0, testObserver.sequenceContextStack.size());
        assertEquals(65, testObserver.elementsResolved.size());
        assertEquals(11, testObserver.outOfContextResolved.size());
        assertEquals(0, testObserver.sequenceElementsEnteredNotLeft);
        assertEquals(0, testObserver.injectorActionsEnteredNotleft);

    }

    @Test
    public void testTcsParserWithTCS() throws Exception {
        ParserFacade facade = TCSParserFacadeFactory.INSTANCE.createTCSParserFacade();
        File syntaxDefFile = ScenarioFixtureData.TCS_OBSOLETE_TCS;
        InputStream in = new FileInputStream(syntaxDefFile);
        IModelAdapter modelHandler = new StubModelAdapter();
        ConsistencyChecksObserver testObserver = new ConsistencyChecksObserver();

        // SystemOutObserver testObserver = new SystemOutObserver();
        facade.parseProductionRule(in, modelHandler, null, null, testObserver);

        assertEquals(0, testObserver.errorsInRule.size());
        assertEquals(1511, testObserver.tokensConsumed.size());
        assertEquals(0, testObserver.errorTokensConsumed.size());
        assertEquals(0, testObserver.ruleContextStack.size());
        assertEquals(0, testObserver.sequenceContextStack.size());
        assertEquals(1186, testObserver.elementsResolved.size());
        assertEquals(253, testObserver.outOfContextResolved.size());
        assertEquals(0, testObserver.sequenceElementsEnteredNotLeft);
        assertEquals(0, testObserver.injectorActionsEnteredNotleft);
    }

    @Test
    public void testTcsParserWithTCSSeparator() throws Exception {
        ParserFacade facade = TCSParserFacadeFactory.INSTANCE.createTCSParserFacade();

        String input = "syntax test{template ->name1::name2::name3;}";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        IModelAdapter modelHandler = new StubModelAdapter();
        ConsistencyChecksObserver testObserver = new ConsistencyChecksObserver();

        // SystemOutObserver testObserver = new SystemOutObserver();
        facade.parseProductionRule(in, modelHandler, "furcas_tcs_concretesyntax", null, testObserver);

    }

    @Test
    public void testTcsParserWithTCSDelegationObserver() throws Exception {
        ParserFacade facade = TCSParserFacadeFactory.INSTANCE.createTCSParserFacade();
        File syntaxDefFile = ScenarioFixtureData.TCS_OBSOLETE_TCS;
        InputStream in = new FileInputStream(syntaxDefFile);
        IModelAdapter modelHandler = new StubModelAdapter();
        DelegationParsingObserver delegationObserver = new DelegationParsingObserver();
        ConsistencyChecksObserver testObserver = new ConsistencyChecksObserver();
        delegationObserver.addParsingObserver(testObserver);

        // SystemOutObserver testObserver = new SystemOutObserver();
        facade.parseProductionRule(in, modelHandler, null, null, delegationObserver);

        assertEquals(0, testObserver.errorsInRule.size());
        assertEquals(1511, testObserver.tokensConsumed.size());
        assertEquals(0, testObserver.errorTokensConsumed.size());
        assertEquals(0, testObserver.ruleContextStack.size());
        assertEquals(0, testObserver.sequenceContextStack.size());
        assertEquals(1186, testObserver.elementsResolved.size());
        assertEquals(253, testObserver.outOfContextResolved.size());
        assertEquals(0, testObserver.sequenceElementsEnteredNotLeft);
        assertEquals(0, testObserver.injectorActionsEnteredNotleft);
    }

    @Test
    @Ignore("long running Test")
    public void testTcsParserWithPartialTCSInLoop() throws Exception {

        File syntaxDefFile = ScenarioFixtureData.TCS_OBSOLETE_TCS;
        // InputStream fileInin = new FileInputStream(syntaxDefFile);
        byte[] oldBytes = FileReadHelper.readBytesFromFile(syntaxDefFile);
        for (int j = 0; j < oldBytes.length; j++) {
            byte[] loopBytes = new byte[j];
            System.arraycopy(oldBytes, 0, loopBytes, 0, j);
            ByteArrayInputStream in = new ByteArrayInputStream(loopBytes);

            ParserFacade facade = TCSParserFacadeFactory.INSTANCE.createTCSParserFacade();

            IModelAdapter modelHandler = new StubModelAdapter();
            ConsistencyChecksObserver testObserver = new ConsistencyChecksObserver();

            // SystemOutObserver testObserver = new SystemOutObserver();
            facade.parseProductionRule(in, modelHandler, null, null, testObserver);

        }

    }

    @Test
    public void testTcsParserWithATL() throws Exception {
        ParserFacade facade = TCSParserFacadeFactory.INSTANCE.createTCSParserFacade();
        File syntaxDefFile = ScenarioFixtureData.ATL_TCS;
        InputStream in = new FileInputStream(syntaxDefFile);
        IModelAdapter modelHandler = new StubModelAdapter();
        ConsistencyChecksObserver testObserver = new ConsistencyChecksObserver();

        // SystemOutObserver testObserver = new SystemOutObserver();
        facade.parseProductionRule(in, modelHandler, null, null, testObserver);

        assertEquals(0, testObserver.errorsInRule.size());
        assertEquals(1731, testObserver.tokensConsumed.size());
        assertEquals(0, testObserver.errorTokensConsumed.size());
        assertEquals(0, testObserver.ruleContextStack.size());
        assertEquals(0, testObserver.sequenceContextStack.size());
        assertEquals(1159, testObserver.elementsResolved.size());
        assertEquals(234, testObserver.outOfContextResolved.size());
        assertEquals(0, testObserver.sequenceElementsEnteredNotLeft);
        assertEquals(0, testObserver.injectorActionsEnteredNotleft);
    }

    // @Test
    // public void testNoAlt() throws Exception {
    // String invalidSample = "syntax MyLanguage { \n"
    // +"template Attribute abstract abstract;\n"
    // +"}";
    // InputStream in = new ByteArrayInputStream(invalidSample.getBytes());
    //
    // Connection con = MOINTCSMetaConnectionProvider.getTestConnection();
    // //SystemOutObserver testObserver = new SystemOutObserver();
    // ModelInjectionResult modelParsingResult =
    // TCS2MOINInjectorFacade.parseSyntaxDefinition(in, con, null,
    // testObserver);
    // assertNotNull(modelParsingResult);
    // assertNotNull(modelParsingResult.getResult().getErrors());
    // assertEquals(1, modelParsingResult.getResult().getErrors().size());
    // ParsingError e1 = modelParsingResult.getResult().getErrors().get(0);
    // assertEquals(2, e1.getLine());
    // assertEquals(28, e1.getPosition());
    // assertEquals(2, e1.getEndLine());
    // assertEquals(36, e1.getEndPosition());
    // }
}
