package com.sap.furcas.runtime.parser.incremental;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Iterator;

import org.antlr.runtime.Lexer;
import org.antlr.runtime.Token;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.ide.parserfactory.AbstractParserFactory;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.Bostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.Eostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.parser.tcs.TCSParserFactory;
import com.sap.furcas.parser.tcs.stable.TCSLexer;
import com.sap.furcas.runtime.common.exceptions.ParserInstantiationException;
import com.sap.furcas.runtime.parser.PartitionAssignmentHandler;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.parser.impl.ParserScope;
import com.sap.furcas.runtime.parser.incremental.testbase.MockPartitionAssignmentHandler;
import com.sap.furcas.runtime.parser.textblocks.observer.ParserTextBlocksHandler;
import com.sap.furcas.runtime.parser.textblocks.observer.TextBlockProxy;
import com.sap.furcas.runtime.textblocks.TbNavigationUtil;
import com.sap.furcas.runtime.textblocks.model.TextBlocksModel;
import com.sap.furcas.runtime.textblocks.modifcation.TbVersionUtil;
import com.sap.furcas.runtime.textblocks.testbase.FixtureProvidingTextBlockTest;
import com.sap.furcas.test.testutils.ResourceTestHelper;
import com.sap.ide.cts.parser.errorhandling.SemanticParserException;
import com.sap.ide.cts.parser.incremental.LexerAdapter;
import com.sap.ide.cts.parser.incremental.TextBlockReuseStrategyImpl;
import com.sap.ide.cts.parser.incremental.antlr.ANTLRIncrementalLexerAdapter;
import com.sap.ide.cts.parser.incremental.antlr.ANTLRIncrementalTokenStream;
import com.sap.ide.cts.parser.incremental.antlr.ANTLRLexerAdapter;
import com.sap.ide.cts.parser.incremental.antlr.IncrementalParserFacade;

public class TestLexerParserInteraction extends FixtureProvidingTextBlockTest {

    @Test
    public void testTokenRelocationWithParser() throws ParserInstantiationException, SemanticParserException {
        ResourceSet resourceSet = ResourceTestHelper.createResourceSet();
        Resource transientParsingResource = ResourceTestHelper.createTransientResource(resourceSet);

        AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory = new TCSParserFactory();
        resourceSet.getResource(parserFactory.getSyntaxResourceURI(), true);

        IncrementalParserFacade ipf = new IncrementalParserFacade(parserFactory, resourceSet, new MockPartitionAssignmentHandler(
                transientParsingResource));

        TextBlock root = modelFactory.createTextBlock();
        transientParsingResource.getContents().add(root);
        root.setVersion(Version.REFERENCE);
        root.setCachedString("");
        LexedToken t = modelFactory.createLexedToken();
        t.setValue("");
        t.setOffset(0);
        t.setOffsetRelative(true);
        t.setVersion(Version.REFERENCE);

        Bostoken bostoken = modelFactory.createBostoken();
        bostoken.setOffsetRelative(true);
        root.getSubNodes().add(bostoken);
        root.getSubNodes().add(t);
        Eostoken eostoken = modelFactory.createEostoken();
        eostoken.setOffset(1);
        eostoken.setOffsetRelative(true);
        root.getSubNodes().add(eostoken);

        TextBlocksModel model = new TextBlocksModel(root, null);

        model.replace(0, 0, "syntax test{template ->bla:;}");

        ipf.parseIncrementally(root);

        bostoken = TbVersionUtil.getOtherVersion(bostoken, Version.CURRENT);

        root = TbVersionUtil.getOtherVersion(root, Version.CURRENT);

        if (ipf.getErrors().size() > 0) {
            fail(ipf.getErrors().get(0).getMessage());
        }

        assertEquals(0, ipf.getErrors().size());
        assertEquals(7, root.getTokens().size());
        assertEquals(1, root.getSubBlocks().size());
        TextBlock syntaxTb = root.getSubBlocks().get(0);
        assertEquals(6, syntaxTb.getTokens().size());
        // TODO check rest of expected structure:
        /*
         * tb - tok syntax - tok " " - tok test - tok { - tb - tok template -
         * tok " " - tok bla - tok ; - tok ; - tok }
         */
    }

    @Test
    @Ignore("Still not working on EMF")
    public void testTokenRelocationWithStub() {
        ResourceSet resourceSet = ResourceTestHelper.createResourceSet();
        Resource transientParsingResource = ResourceTestHelper.createTransientResource(resourceSet);

        TCSLexer antlrLexer = new TCSLexer(null, null);
        LexerAdapter lexerAdapter = new ANTLRLexerAdapter(antlrLexer, new TextBlockReuseStrategyImpl(antlrLexer, null));
        ANTLRIncrementalLexerAdapter lexer = new ANTLRIncrementalLexerAdapter(lexerAdapter, null);
        ANTLRIncrementalTokenStream input = new ANTLRIncrementalTokenStream(lexer);

        ParserScope parserScope = new ParserScope(resourceSet, transientParsingResource, new TCSParserFactory());

        PartitionAssignmentHandler partitioningHandler = new MockPartitionAssignmentHandler(transientParsingResource);
        ParserTextBlocksHandler tbh = new ParserTextBlocksHandler(input, parserScope, partitioningHandler);

        TextBlock root = modelFactory.createTextBlock();
        transientParsingResource.getContents().add(root);
        root.setVersion(Version.REFERENCE);
        root.setCachedString("");
        LexedToken t = modelFactory.createLexedToken();
        t.setValue("");
        t.setOffsetRelative(true);
        t.setVersion(Version.REFERENCE);

        Bostoken bostoken = modelFactory.createBostoken();
        bostoken.setOffsetRelative(true);
        root.getSubNodes().add(bostoken);
        root.getSubNodes().add(t);
        Eostoken eostoken = modelFactory.createEostoken();
        eostoken.setOffset(1);
        eostoken.setOffsetRelative(true);
        root.getSubNodes().add(eostoken);

        TextBlocksModel model = new TextBlocksModel(root, null);

        model.replace(0, 0, "syntax test{template bla:;}");

        lexer.setSource(bostoken);
        lexer.lex(root);
        bostoken = TbVersionUtil.getOtherVersion(bostoken, Version.CURRENT);
        lexer.setCurrentTokenForParser(bostoken);

        root = TbVersionUtil.getOtherVersion(root, Version.CURRENT);
        tbh.setRootBlock(root);

        // make sur the fillBuffer() method is caled before modeifications are
        // made to the textblock model
        input.getTokens();

        // simulate main parse rule
        tbh.notifyEnterRule(null, null);
        // simulate consumption of "syntax" token
        AbstractToken nextToken = TbNavigationUtil.nextToken(bostoken);
        tbh.notifyTokenConsume(getInverseToken(input, nextToken));
        // simulate consumption of "<space>" token
        nextToken = TbNavigationUtil.nextToken(nextToken);
        tbh.notifyTokenConsume(getInverseToken(input, nextToken));
        // simulate consumption of "test" token
        nextToken = TbNavigationUtil.nextToken(nextToken);
        tbh.notifyTokenConsume(getInverseToken(input, nextToken));
        // simulate consumption of "{" token
        nextToken = TbNavigationUtil.nextToken(nextToken);
        tbh.notifyTokenConsume(getInverseToken(input, nextToken));
        // descend into sub parse rule for template
        tbh.notifyEnterRule(null, null);
        // simulate consumption of "template" token
        nextToken = TbNavigationUtil.nextToken(nextToken);
        tbh.notifyTokenConsume(getInverseToken(input, nextToken));
        // simulate consumption of "<space>" token
        nextToken = TbNavigationUtil.nextToken(nextToken);
        tbh.notifyTokenConsume(getInverseToken(input, nextToken));
        // simulate consumption of "bla" token
        nextToken = TbNavigationUtil.nextToken(nextToken);
        tbh.notifyTokenConsume(getInverseToken(input, nextToken));
        // simulate consumption of ":" token
        nextToken = TbNavigationUtil.nextToken(nextToken);
        tbh.notifyTokenConsume(getInverseToken(input, nextToken));
        // simulate consumption of ";" token
        nextToken = TbNavigationUtil.nextToken(nextToken);
        tbh.notifyTokenConsume(getInverseToken(input, nextToken));
        // exit template rule
        tbh.notifyExitRule(null);
        // simulate consumption of "}" token
        nextToken = TbNavigationUtil.nextToken(nextToken);
        tbh.notifyTokenConsume(getInverseToken(input, nextToken));
        // exit main rule
        tbh.notifyExitRule(null);

        assertEquals(6, tbh.getCurrentTbProxy().getSubNodes().size());
        TextBlockProxy syntaxTb = (TextBlockProxy) tbh.getCurrentTbProxy().getSubNodes().get(4);
        assertEquals(5, syntaxTb.getSubNodes().size());
        // The following structure is being expected
        /*
         * rootTb EOS tb - tok syntax - tok { - tb - tok template - tok bla -
         * tok : - tok ; - tok } BOS
         */
    }

    private Token getInverseToken(ANTLRIncrementalTokenStream input, AbstractToken nextToken) {
        if (nextToken == null) {
            throw new IllegalArgumentException("nextToken has to be other than null");
        }
        for (Iterator<?> it = input.getTokens().iterator(); it.hasNext();) {
            Token tok = (Token) it.next();
            if (input.getTokenModelElementForParserToken(tok) == nextToken) {
                return tok;
            }
        }
        return null;
    }
}
