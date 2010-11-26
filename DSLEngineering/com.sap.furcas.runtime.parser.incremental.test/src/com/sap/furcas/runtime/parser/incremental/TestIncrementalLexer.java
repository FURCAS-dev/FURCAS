package com.sap.furcas.runtime.parser.incremental;

import static junit.framework.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.Eostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksFactory;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.metamodel.FURCAS.textblocks.util.TextblocksAdapterFactory;
import com.sap.furcas.runtime.textblocks.model.TextBlocksModel;
import com.sap.furcas.runtime.textblocks.modifcation.TbChangeUtil;
import com.sap.furcas.runtime.textblocks.modifcation.TbVersionUtil;
import com.sap.furcas.runtime.textblocks.testbase.TextBlockTest;
import com.sap.furcas.runtime.textblocks.testutils.TestSourceTextBlockCreator;
import com.sap.furcas.runtime.textblocks.validation.TbValidationUtil;
import com.sap.ide.cts.parser.incremental.IncrementalLexer;
import com.sap.ide.cts.parser.incremental.antlr.ANTLRIncrementalLexerAdapter;

public class TestIncrementalLexer extends TextBlockTest {

	@Test
	public void testWithInitialContentTokenNoChange() throws Exception {
		// should leave the textblock as it is.

		MockLexerAdapter mockLexerAdapter = new MockLexerAdapter(null);
		EditingDomain editingDomain =  new AdapterFactoryEditingDomain(new TextblocksAdapterFactory(), new BasicCommandStack());
		ANTLRIncrementalLexerAdapter incrementalLexer = new ANTLRIncrementalLexerAdapter(
				mockLexerAdapter, null, editingDomain);

		LexedToken contentToken = createToken("test");

		TextBlock root = TestSourceTextBlockCreator
				.initialiseTextBlocksWithContentToken(modelFactory,
						contentToken);
		TbChangeUtil.makeVersion(root, Version.REFERENCE);
		TextBlocksModel tbModel = new TextBlocksModel(root, null);

		// Do actually nothing
		tbModel.replace(0, 0, "");

		TextBlock editedVersion = TbVersionUtil.getOtherVersion(
				root, Version.PREVIOUS);

		incrementalLexer.setSource(editedVersion.getTokens().iterator().next());

		mockLexerAdapter.setNextTokens(editedVersion.getTokens());

		incrementalLexer.lex(editedVersion);

		TextBlock newlyLexedVersion = TbVersionUtil
				.getOtherVersion(editedVersion, Version.CURRENT);

		assertEquals(3, newlyLexedVersion.getTokens().size());
		assertEquals("test", newlyLexedVersion.getTokens().get(1).getValue()); // (BOS,
		// contentToken,
		// EOS )expected
	}

	@Test
	public void testWithInitialContentTokenValueOnlyChange() throws Exception {
		// should leave the textblock as it is.

		MockLexerAdapter mockLexerAdapter = new MockLexerAdapter(null);
		ANTLRIncrementalLexerAdapter incrementalLexer = new ANTLRIncrementalLexerAdapter(
				mockLexerAdapter, null, new AdapterFactoryEditingDomain(
						new TextblocksAdapterFactory(), new BasicCommandStack()));

		LexedToken contentToken = createToken("test");

		TextBlock root = TestSourceTextBlockCreator
				.initialiseTextBlocksWithContentToken(modelFactory,
						contentToken);
		TbChangeUtil.makeVersion(root, Version.REFERENCE);

		TextBlocksModel tbModel = new TextBlocksModel(root, null);

		// Add "1" to end of token
		tbModel.replace(4, 0, "1");

		TextBlock editedVersion = TbVersionUtil.getOtherVersion(
				root, Version.PREVIOUS);

		incrementalLexer.setSource(editedVersion.getTokens().iterator().next());

		// Set exactly the same tokens as nothing in their structure changed
		// except BOS token
		List<AbstractToken> nextTokens = new ArrayList<AbstractToken>(2);
//		AbstractToken tok1 = (AbstractToken) TbUtil.createNewCopy(editedVersion.getTokens().get(1),
//                        Version.CURRENT, false, null);
//		TbUtil.dereferenceVersions(tok1, editedVersion.getTokens().get(1));
//		tok1.getOtherVersions().clear();
		
		LexedToken lt = createToken(editedVersion.getTokens().get(1).getValue());
		lt.setVersion(Version.CURRENT);
		lt.setLength(5);
		
		nextTokens.add(lt);
		nextTokens.add(editedVersion.getTokens().get(2));
//		
//		//The following is here to clear
//		AbstractToken tok1 = (AbstractToken) TbUtil.createNewCopy(editedVersion.getTokens().get(1),
//                        Version.CURRENT, false, null);
//                TbUtil.dereferenceVersions(tok1, editedVersion.getTokens().get(1));
//                tok1.getOtherVersions().clear();
//                
//		
//		TbVersionUtil.getOtherVersion(editedVersion.getTokens().get(2), Version.CURRENT).refDelete();
//		TextBlock currentTB = TbVersionUtil.getOtherVersion(editedVersion, Version.CURRENT);
//                TbUtil.dereferenceVersions(editedVersion, currentTB);
//                currentTB.getOtherVersions().clear();

		mockLexerAdapter.setNextTokens(nextTokens);

		incrementalLexer.lex(editedVersion);
 
		TextBlock currentTB = TbVersionUtil.getOtherVersion(editedVersion, Version.CURRENT);
		TextBlock newlyLexedVersion = currentTB;

		//TODO fix!
		assertEquals(3, newlyLexedVersion.getTokens().size());
		assertEquals("test1", newlyLexedVersion.getTokens().get(1).getValue()); // (BOS,
		// contentToken,
		// EOS )expected
		TbValidationUtil.assertTextBlockConsistency(newlyLexedVersion);
	}

	@Test
	public void testWithInitialContentTokenNewToken() throws Exception {
		// should leave the textblock as it is.

		MockLexerAdapter mockLexerAdapter = new MockLexerAdapter(null);
		ANTLRIncrementalLexerAdapter incrementalLexer = new ANTLRIncrementalLexerAdapter(
				mockLexerAdapter, null, new AdapterFactoryEditingDomain(
						new TextblocksAdapterFactory(), new BasicCommandStack()));
		
		LexedToken contentToken = createToken("test");

		TextBlock root = TestSourceTextBlockCreator
				.initialiseTextBlocksWithContentToken(modelFactory,
						contentToken);
		TbChangeUtil.makeVersion(root, Version.REFERENCE);

		TextBlocksModel tbModel = new TextBlocksModel(root, null);

		// Add "1" to end of token
		tbModel.replace(4, 0, "1");

		TextBlock editedVersion = TbVersionUtil.getOtherVersion(
				root, Version.PREVIOUS);

		incrementalLexer.setSource(editedVersion.getTokens().iterator().next());

		// Set exactly the same tokens as nothing in their structure changed
		// except BOS token
		List<AbstractToken> nextTokens = new ArrayList<AbstractToken>(3);
		LexedToken newTok1 = createToken("test");
		newTok1.setLength(4);
		newTok1.setVersion(Version.CURRENT);
		nextTokens.add(newTok1);

		LexedToken newTok2 = createToken("1");
		newTok2.setOffset(4);
		newTok2.setLength(1);
		newTok2.setVersion(Version.CURRENT);
		nextTokens.add(newTok2);

		nextTokens.add(editedVersion.getTokens().get(2));

		mockLexerAdapter.setNextTokens(nextTokens);

		incrementalLexer.lex(editedVersion);

		TextBlock newlyLexedVersion = TbVersionUtil
				.getOtherVersion(editedVersion, Version.CURRENT);

		assertEquals(4, newlyLexedVersion.getTokens().size());
		assertEquals("test", newlyLexedVersion.getTokens().get(1).getValue());
		assertEquals("1", newlyLexedVersion.getTokens().get(2).getValue());
		TbValidationUtil.assertTextBlockConsistency(newlyLexedVersion);
	}

	@Test
	public void testWithTextBlocksAfterInitialToken() throws Exception {
		// should leave the textblock as it is.

		MockLexerAdapter mockLexerAdapter = new MockLexerAdapter(null);
		ANTLRIncrementalLexerAdapter incrementalLexer = new ANTLRIncrementalLexerAdapter(
				mockLexerAdapter, null, new AdapterFactoryEditingDomain(
						new TextblocksAdapterFactory(), new BasicCommandStack()));

		LexedToken tok1 = createToken("tok1");

		/*
		 * Structure before: -root -tok1 -subBlock --tok2 --tok3x
		 */

		/*
		 * Structure afterwards: -root -tok1 -subBlock --tok2 --tok3 --x
		 */

		TextBlock root = TestSourceTextBlockCreator
				.initialiseTextBlocksWithContentToken(modelFactory, tok1);
		TextBlock subBlock = modelFactory.createTextBlock();
		subBlock.setVersion(Version.REFERENCE);
		subBlock.setOffset(4);
		subBlock.setLength(8);
		root.getSubNodes().add(subBlock);

		LexedToken tok2 = createToken("tok2");
		tok2.setOffsetRelative(true);
		subBlock.getSubNodes().add(tok2);

		LexedToken tok3 = createToken("tok3");
		tok3.setOffset(4);
		tok3.setOffsetRelative(true);
		subBlock.getSubNodes().add(tok3);

		root.setCachedString("tok1tok2tok3");
		root.setLength(12);
		TextBlocksModel tbModel = new TextBlocksModel(root, null);

		// Add "x" to end of tok3
		tbModel.replace(12, 0, "x");

		TextBlock editedVersion = TbVersionUtil.getOtherVersion(
				root, Version.PREVIOUS);

		incrementalLexer.setSource(editedVersion.getTokens().iterator().next());

		// except BOS token
		List<AbstractToken> nextTokens = new ArrayList<AbstractToken>(3);

		LexedToken newTok3 = createToken("tok3");
		// lexer uses offset relative to last constructionlocation
		// so this has to be simulated here as well
		newTok3.setOffset(0);
		newTok3.setLength(4);
		newTok3.setVersion(Version.CURRENT);
		newTok3.setRelexingNeeded(true);
		nextTokens.add(newTok3);

		LexedToken newTok4 = createToken("x");
		newTok4.setOffset(4);
		newTok4.setLength(1);
		newTok4.setVersion(Version.CURRENT);
		newTok4.setRelexingNeeded(true);
		nextTokens.add(newTok4);

		// add EOS
		Eostoken eos = IncrementalLexer.createEOSToken(TextblocksFactory.eINSTANCE,
				Version.CURRENT, ANTLRIncrementalLexerAdapter.eosTokenType);
		eos.setOffset(5);
		nextTokens.add(eos);

		mockLexerAdapter.setNextTokens(nextTokens);

		incrementalLexer.lex(editedVersion);

		TextBlock newlyLexedVersion = TbVersionUtil
				.getOtherVersion(editedVersion, Version.CURRENT);

		assertEquals(3, newlyLexedVersion.getTokens().size());
		assertEquals("tok1", newlyLexedVersion.getTokens().get(1).getValue());
		assertEquals(3, newlyLexedVersion.getSubBlocks().get(0).getTokens()
				.size());
		assertEquals("x", newlyLexedVersion.getSubBlocks().get(0).getTokens()
				.get(2).getValue());
		TbValidationUtil.assertTextBlockConsistency(newlyLexedVersion);
		TbValidationUtil.assertTextBlockConsistency(newlyLexedVersion
				.getSubBlocks().get(0));
	}

	@Test
	public void testLookaheadFixingLA1() throws Exception {
		// should leave the textblock as it is.

		MockLexerAdapterWithLookaheadLLStar mockLexerAdapter = new MockLexerAdapterWithLookaheadLLStar(null);
		ANTLRIncrementalLexerAdapter incrementalLexer = new ANTLRIncrementalLexerAdapter(
				mockLexerAdapter, null, new AdapterFactoryEditingDomain(
						new TextblocksAdapterFactory(), new BasicCommandStack()));

		LexedToken tok1 = createToken("tok1");

		/*
		 * Structure before: -root -tok1 -subBlock --tok2 --tok3x
		 */

		/*
		 * Structure afterwards: -root -tok1 -subBlock --tok2 --tok3 --x --y
		 */

		TextBlock root = TestSourceTextBlockCreator
				.initialiseTextBlocksWithContentToken(modelFactory, tok1);
		TextBlock subBlock = modelFactory.createTextBlock();
		subBlock.setVersion(Version.REFERENCE);
		subBlock.setOffset(4);
		subBlock.setLength(8);
		root.getSubNodes().add(subBlock);

		LexedToken tok2 = createToken("tok2");
		tok2.setOffsetRelative(true);
		tok2.setLookback(1);
		subBlock.getSubNodes().add(tok2);

		LexedToken tok3 = createToken("tok3");
		tok3.setOffset(4);
		tok3.setOffsetRelative(true);
		tok3.setLookback(1);
		subBlock.getSubNodes().add(tok3);

		root.setCachedString("tok1tok2tok3");
		root.setLength(12);
		TextBlocksModel tbModel = new TextBlocksModel(root, null);

		// Add "x" to end of tok3
		tbModel.replace(12, 0, "xy");

		TextBlock editedVersion = TbVersionUtil.getOtherVersion(
				root, Version.PREVIOUS);

		incrementalLexer.setSource(editedVersion.getTokens().iterator().next());

		// except BOS token
		List<AbstractToken> nextTokens = new ArrayList<AbstractToken>(5);

		LexedToken newTok2 = createToken("tok2");
		// lexer uses offset relative to last constructionlocation
		// so this has to be simulated here as well which is this token
		newTok2.setOffset(0);
		newTok2.setLength(4);
		newTok2.setVersion(Version.CURRENT);
		newTok2.setRelexingNeeded(true);
		nextTokens.add(newTok2);

		LexedToken newTok3 = createToken("tok3");
		// lexer uses offset relative to last constructionlocation
		// so this has to be simulated here as well which is this tok2
		newTok3.setOffset(4);
		newTok3.setLength(4);
		newTok3.setVersion(Version.CURRENT);
		newTok3.setRelexingNeeded(true);
		nextTokens.add(newTok3);

		LexedToken newTok4 = createToken("x");
		// lexer uses offset relative to last constructionlocation
		// so this has to be simulated here as well which is tok3
		newTok4.setOffset(4);
		newTok4.setLength(1);
		newTok4.setVersion(Version.CURRENT);
		newTok4.setRelexingNeeded(true);
		nextTokens.add(newTok4);

		LexedToken newTok5 = createToken("y");
		// lexer uses offset relative to last constructionlocation
		// so this has to be simulated here as well which is tok3
		newTok5.setOffset(5);
		newTok5.setLength(1);
		newTok5.setVersion(Version.CURRENT);
		newTok5.setRelexingNeeded(true);
		nextTokens.add(newTok5);

		// add EOS
		Eostoken eos = IncrementalLexer.createEOSToken(TextblocksFactory.eINSTANCE,
				Version.CURRENT, ANTLRIncrementalLexerAdapter.eosTokenType);
		eos.setOffsetRelative(true);
		// lexer uses offset relative to last constructionlocation
		// so this has to be simulated here as well which is tok3
		eos.setOffset(6);
		nextTokens.add(eos);

		mockLexerAdapter.setNextTokens(nextTokens);

		incrementalLexer.lex(editedVersion);

		TextBlock newlyLexedVersion = TbVersionUtil
				.getOtherVersion(editedVersion, Version.CURRENT);

		assertEquals(3, newlyLexedVersion.getTokens().size());
		assertEquals("tok1", newlyLexedVersion.getTokens().get(1).getValue());
		assertEquals(4, newlyLexedVersion.getSubBlocks().get(0).getTokens()
				.size());
		assertEquals(newTok4, newlyLexedVersion.getSubBlocks().get(0)
				.getTokens().get(2));
		assertEquals(newTok5, newlyLexedVersion.getSubBlocks().get(0)
				.getTokens().get(3));

		assertEquals(1, newTok3.getLookback());
		assertEquals(1, newTok4.getLookback());
		assertEquals(1, newTok5.getLookback());

		TbValidationUtil.assertTextBlockConsistency(newlyLexedVersion);
		TbValidationUtil.assertTextBlockConsistency(newlyLexedVersion
				.getSubBlocks().get(0));
	}

	@Test
	public void testModifySubBlockAtBeginning() throws Exception {
		// should leave the textblock as it is.

		MockLexerAdapterWithLookaheadLLStar mockLexerAdapter = new MockLexerAdapterWithLookaheadLLStar(
				null){

                    @Override
                    public List<AbstractToken> moreTokens() {
                        //simulate a lookahead of 1 within a LL(*) parser
                        int mark = callbackLexer.mark();
                        callbackLexer.LA(1);
                        callbackLexer.consume();
                        callbackLexer.rewind(mark);
                        //simulate token consumption on callbacked lexer
                        callbackLexer.consume();
                        AbstractToken o = nextTokens.get(nextTokenIndex++);
                        if(o.getValue().equals("tok3")) {
                            o = TbVersionUtil.getOtherVersion(o, Version.CURRENT);
                            //this needs to be done as tok3 will be simulated as being reused but its offset needs
                            //to be adapted to the changes
                            
                            o.setOffset(1);
                        }
                        return Collections.singletonList(o);
                    }
		    
		};
		ANTLRIncrementalLexerAdapter incrementalLexer = new ANTLRIncrementalLexerAdapter(
				mockLexerAdapter, null, new AdapterFactoryEditingDomain(
						new TextblocksAdapterFactory(), new BasicCommandStack()));

		LexedToken tok1 = createToken("tok1");

		/*
		 * Structure before: -root -tok1 -subBlock --xtok2 --tok3
		 */

		/*
		 * Structure afterwards: -root -tok1 -subBlock --x --tok2 --tok3
		 */

		TextBlock root = TestSourceTextBlockCreator
				.initialiseTextBlocksWithContentToken(modelFactory, tok1);
		TextBlock subBlock = modelFactory.createTextBlock();
		subBlock.setVersion(Version.REFERENCE);
		subBlock.setOffset(4);
		subBlock.setLength(8);
		root.getSubNodes().add(root.getSubNodes().size() - 2, subBlock);

		LexedToken tok2 = createToken("tok2");
		tok2.setOffsetRelative(true);
		tok2.setLookback(1);
		subBlock.getSubNodes().add(tok2);

		LexedToken tok3 = createToken("tok3");
		tok3.setOffset(4);
		tok3.setOffsetRelative(true);
		tok3.setLookback(1);
		subBlock.getSubNodes().add(tok3);

		root.getTokens().get(root.getTokens().size()-1).setOffset(12);
		root.setCachedString("tok1tok2tok3");
		root.setLength(12);
		TextBlocksModel tbModel = new TextBlocksModel(root, null);

		// Add "x" to beginning of tok2
		tbModel.replace(4, 0, "x");

		assertEquals("xtok2", TbVersionUtil.getOtherVersion(tok2,
				Version.PREVIOUS).getValue());

		TextBlock editedVersion = TbVersionUtil.getOtherVersion(
				root, Version.PREVIOUS);

		incrementalLexer.setSource(editedVersion.getTokens().iterator().next());

		// except BOS token
		List<AbstractToken> nextTokens = new ArrayList<AbstractToken>(5);

		LexedToken newTok1 = createToken("tok1");
		// lexer uses offset relative to last constructionlocation
		// so this has to be simulated here as well which is this token
		newTok1.setOffset(0);
		newTok1.setLength(4);
		newTok1.setVersion(Version.CURRENT);
		newTok1.setRelexingNeeded(true);
		nextTokens.add(newTok1);

		LexedToken x = createToken("x");
		// lexer uses offset relative to last constructionlocation
		// so this has to be simulated here as well which is tok1
		x.setOffset(4);
		x.setLength(1);
		x.setVersion(Version.CURRENT);
		x.setRelexingNeeded(true);
		nextTokens.add(x);

		LexedToken newTok2 = createToken("tok2");
		// lexer uses offset relative to last constructionlocation
		// so this has to be simulated here as well which is this token in the
		// previous version
		newTok2.setOffset(1);
		newTok2.setLength(4);
		newTok2.setVersion(Version.CURRENT);
		newTok2.setRelexingNeeded(false);
		nextTokens.add(newTok2);

//		LexedToken newTok3 = createToken("tok3");
//		// lexer uses offset relative to last constructionlocation
//		// so this has to be simulated here as well which is this tok2
//		newTok3.setOffset(5);
//		newTok3.setLength(4);
//		newTok3.setVersion(Version.CURRENT);
//		newTok3.setRelexingNeeded(false);
		nextTokens.add(tok3);

		// add EOS
		Eostoken eos = IncrementalLexer.createEOSToken(TextblocksFactory.eINSTANCE,
				Version.CURRENT, ANTLRIncrementalLexerAdapter.eosTokenType);
		eos.setOffsetRelative(true);
		// lexer uses offset relative to last constructionlocation
		// so this has to be simulated here as well which is tok3
		eos.setOffset(13);
		nextTokens.add(eos);

		mockLexerAdapter.setNextTokens(nextTokens);

		incrementalLexer.lex(editedVersion);

		TextBlock newlyLexedVersion = TbVersionUtil
				.getOtherVersion(editedVersion, Version.CURRENT);

		assertEquals(3, newlyLexedVersion.getTokens().size());
		assertEquals("tok1", newlyLexedVersion.getTokens().get(1).getValue());

		assertEquals(3, newlyLexedVersion.getSubBlocks().get(0).getTokens()
				.size());
		assertEquals(x, newlyLexedVersion.getSubBlocks().get(0).getTokens()
				.get(0));
		assertEquals(newTok2, newlyLexedVersion.getSubBlocks().get(0)
				.getTokens().get(1));

		assertEquals(1, tok3.getLookback());
		assertEquals(1, x.getLookback());
		assertEquals(0, newTok2.getLookback());

		TbValidationUtil.assertTextBlockConsistency(newlyLexedVersion);
		TbValidationUtil.assertTextBlockConsistency(newlyLexedVersion
				.getSubBlocks().get(0));
	}
}
