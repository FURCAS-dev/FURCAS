package com.sap.ide.cts.parser.incremental;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Iterator;

import org.antlr.runtime.Token;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.junit.Test;

<<<<<<< HEAD
import com.sap.furcas.metamodel.textblocks.AbstractToken;
import com.sap.furcas.metamodel.textblocks.Bostoken;
import com.sap.furcas.metamodel.textblocks.Eostoken;
import com.sap.furcas.metamodel.textblocks.LexedToken;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.furcas.parser.tcs.stableversion.TCSLexer;
=======
import tcs.TcsPackage;
import textblocks.AbstractToken;
import textblocks.Bostoken;
import textblocks.Eostoken;
import textblocks.LexedToken;
import textblocks.TextBlock;
import textblocks.VersionEnum;

import com.sap.furcas.textual.textblocks.TbNavigationUtil;
import com.sap.furcas.textual.textblocks.TbVersionUtil;
import com.sap.furcas.textual.textblocks.model.TextBlocksModel;
import com.sap.furcas.textual.textblocks.testutils.UtilFixtureBase;
>>>>>>> 339c4f6827f2205a0254bfb911d75ecfc4a51698
import com.sap.ide.cts.editor.test.util.TcsTestHelper;
import com.sap.ide.cts.parser.incremental.antlr.ANTLRIncrementalLexerAdapter;
import com.sap.ide.cts.parser.incremental.antlr.ANTLRIncrementalTokenStream;
import com.sap.ide.cts.parser.incremental.antlr.ANTLRLexerAdapter;
import com.sap.ide.cts.parser.incremental.antlr.IncrementalParserFacade;
import com.sap.mi.tcs.parser.TcsParserFactory;
import com.sap.mi.textual.grammar.IModelAdapter;
import com.sap.mi.textual.parsing.textblocks.TextBlocksAwareModelAdapter;
import com.sap.mi.textual.parsing.textblocks.observer.ParserTextBlocksHandler;
import com.sap.mi.textual.parsing.textblocks.observer.TextBlockProxy;
<<<<<<< HEAD
import com.sap.mi.textual.textblocks.model.TextBlocksModel;

=======
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.textual.moinadapter.adapter.MOINModelAdapter;

public class TestLexerParserInteraction extends UtilFixtureBase {

	@Test
	public void testTokenRelocationWithParser() {
		//create TCS mapping on connection
		TcsTestHelper.createTcsSyntaxMappingOnConnection(connection);
		
		ResourceSet connection = ((EObject) main).get___Connection();

		IModelAdapter adapter = new TextBlocksAwareModelAdapter(new MOINModelAdapter(connection.getPackage(TcsPackage.PACKAGE_DESCRIPTOR), connection, null, null));
		IncrementalParserFacade ipf = new IncrementalParserFacade(new TcsParserFactory(),  adapter, connection, null);

		TextBlock root = modelFactory.createTextBlock();
		root.setVersion(EEnum.REFERENCE);
		root.setCachedString("");
		LexedToken t = modelFactory.createLexedToken();
		t.setOffset(0);
		t.setOffsetRelative(true);
		t.setVersion(EEnum.REFERENCE);

		Bostoken bostoken = modelFactory.createBostoken();
		bostoken.setOffsetRelative(true);
		root.getTokens().add(bostoken);
		root.getTokens().add(t);
		Eostoken eostoken = modelFactory.createEostoken();
		eostoken.setOffset(1);
		eostoken.setOffsetRelative(true);
		root.getTokens().add(eostoken);

		TextBlocksModel model = new TextBlocksModel(root, null);

		model.replace(0, 0, "syntax test{template ->bla:;}");

		ipf.parseIncrementally(root);
		
		bostoken = TbVersionUtil.getOtherVersion(bostoken,
				EEnum.CURRENT);
		
		root = TbVersionUtil.getOtherVersion(root, EEnum.CURRENT);
		
		
		if(ipf.getErrors().size()>0) {
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
	public void testTokenRelocationWithStub() {
		ResourceSet connection = ((EObject) main).get___Connection();
		TCSLexer antlrLexer = new TCSLexer(null, null);
		LexerAdapter lexerAdapter = new ANTLRLexerAdapter(antlrLexer, 
			new TextBlockReuseStrategyImpl(antlrLexer, null),
				connection);
		ANTLRIncrementalLexerAdapter lexer = new ANTLRIncrementalLexerAdapter(
				lexerAdapter, null, connection);
		ANTLRIncrementalTokenStream input = new ANTLRIncrementalTokenStream(
				lexer);
		ParserTextBlocksHandler tbh = new ParserTextBlocksHandler(input,
				connection, null, null, null, null);

		TextBlock root = modelFactory.createTextBlock();
		root.setVersion(EEnum.REFERENCE);
		root.setCachedString("");
		LexedToken t = modelFactory.createLexedToken();
		t.setOffsetRelative(true);
		t.setVersion(EEnum.REFERENCE);

		Bostoken bostoken = modelFactory.createBostoken();
		bostoken.setOffsetRelative(true);
		root.getTokens().add(bostoken);
		root.getTokens().add(t);
		Eostoken eostoken = modelFactory.createEostoken();
		eostoken.setOffset(1);
		eostoken.setOffsetRelative(true);
		root.getTokens().add(eostoken);

		TextBlocksModel model = new TextBlocksModel(root, null);

		model.replace(0, 0, "syntax test{template bla:;}");

		lexer.setSource(bostoken);
		lexer.lex(root);
		bostoken = TbVersionUtil.getOtherVersion(bostoken,
				EEnum.CURRENT);
		lexer.setCurrentTokenForParser(bostoken);

		root = TbVersionUtil.getOtherVersion(root,
				EEnum.CURRENT);
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

	private Token getInverseToken(ANTLRIncrementalTokenStream input,
			AbstractToken nextToken) {
		if (nextToken == null) {
			throw new IllegalArgumentException(
					"nextToken has to be other than null");
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
