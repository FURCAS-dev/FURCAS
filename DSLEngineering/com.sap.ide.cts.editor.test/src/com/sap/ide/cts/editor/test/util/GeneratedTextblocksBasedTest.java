package com.sap.ide.cts.editor.test.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;

<<<<<<< HEAD
import com.sap.furcas.metamodel.textblocks.AbstractToken;
import com.sap.furcas.metamodel.textblocks.LexedToken;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.furcas.metamodel.textblocks.TextblocksPackage;
import com.sap.ide.cts.parser.incremental.antlr.IncrementalParserFacade;
import com.sap.mi.textual.grammar.exceptions.UnknownProductionRuleException;
import com.sap.mi.textual.grammar.impl.ParsingError;
import com.sap.mi.textual.parsing.textblocks.TbChangeUtil;
import com.sap.mi.textual.parsing.textblocks.TbVersionUtil;
import com.sap.mi.textual.textblocks.model.TextBlocksModel;
=======
import textblocks.AbstractToken;
import textblocks.LexedToken;
import textblocks.TextBlock;
import textblocks.TextblocksPackage;
import textblocks.VersionEnum;

import com.sap.furcas.textual.textblocks.TbChangeUtil;
import com.sap.furcas.textual.textblocks.TbVersionUtil;
import com.sap.furcas.textual.textblocks.model.TextBlocksModel;
import com.sap.ide.cts.parser.incremental.antlr.IncrementalParserFacade;
import com.sap.mi.textual.grammar.exceptions.UnknownProductionRuleException;
import com.sap.mi.textual.grammar.impl.ParsingError;
import com.sap.tc.moin.textual.moinadapter.adapter.MOINModelAdapter;
>>>>>>> 339c4f6827f2205a0254bfb911d75ecfc4a51698

public class GeneratedTextblocksBasedTest extends
		GeneratedParserAndFactoryBasedTest {

	protected TextBlocksModel tbModel;

	public void initTbModel(InputStream contentStream,
			IncrementalParserFacade facade,
			StringReplacement postFixtureParseReplacement) throws IOException,
			UnknownProductionRuleException {
		AbstractToken content = createToken("");
		TextBlock rootBlock = initialiseTextBlocksWithContentToken(content);

		tbModel = new TextBlocksModel(rootBlock, new MOINModelAdapter(facade
				.getParserFactory().getMetamodelPackage(connection),
				connection, null, null));

		String fixtureContents = TcsTestHelper.getStreamContents(contentStream);

		tbModel.replace(0, 0, fixtureContents);

		rootBlock = TbVersionUtil.getOtherVersion(rootBlock,
				EEnum.PREVIOUS);

		List<ParsingError> errorList = facade.dryParse(rootBlock);

		if (errorList.size() != 0) {
			
			if (!fixtureContents.equals("")) {
				// empty fixture fails to parse but should still be a valid
				// fixture
				// as a special case

				System.out.println("Error parsing fixture:");
				for (ParsingError pe : errorList) {
					System.out.println(pe.toString());
				}

				fail("error parsing fixture");
			}

		} else {

			TextBlock result = facade.parseIncrementally(rootBlock);

			assertNotNull(result);
			
			// re-create tbModel
			TbChangeUtil.cleanUp(result);
			// add a new template
			tbModel = new TextBlocksModel(result, new MOINModelAdapter(facade
					.getParserFactory().getMetamodelPackage(connection),
					connection, null, null));
			
			// add post-parse replacement
			// this is used for strings that would otherwise throw parse errors
			// if
			// contained in the fixture directly
			if (postFixtureParseReplacement != null) {
				// used to compute offset
				Document dummyDoc = new Document(fixtureContents);
				int offset = 0;
				try {
					offset = dummyDoc.getLineOffset(postFixtureParseReplacement
							.getLine())
							+ postFixtureParseReplacement
									.getCharPositionInLine();
				} catch (BadLocationException e) {
					fail("post-fixture-pase replacement failed");
				}
				tbModel.replace(offset,
						postFixtureParseReplacement.getLength(),
						postFixtureParseReplacement.getReplacementString());
			}
		}
	}

	private static TextBlock initialiseTextBlocksWithContentToken(
			AbstractToken contentToken) {
		TextblocksPackage tbPack = connection
				.getPackage(TextblocksPackage.PACKAGE_DESCRIPTOR);
		TextBlock rootBlock = (TextBlock) tbPack.getTextBlock()
				.refCreateInstance();

		AbstractToken bosToken = (AbstractToken) tbPack.getBostoken()
				.refCreateInstance();
		bosToken.setVersion(EEnum.REFERENCE);
		rootBlock.getTokens().add(bosToken);
		AbstractToken eosToken = (AbstractToken) tbPack.getEostoken()
				.refCreateInstance();
		eosToken.setVersion(EEnum.REFERENCE);

		if (contentToken != null) {
			rootBlock.getTokens().add(contentToken);

			rootBlock.setLength(contentToken.getLength());
			rootBlock.setComplete(true);
			rootBlock.setEndColumn(contentToken.getLength());
			rootBlock.setCachedString(contentToken.getValue());
			eosToken.setOffset(contentToken.getLength());
		}

		rootBlock.getTokens().add(eosToken);
		rootBlock.setVersion(EEnum.REFERENCE);
		return rootBlock;
	}

	private static LexedToken createToken(String content) {
		TextblocksPackage tbPack = connection
				.getPackage(TextblocksPackage.PACKAGE_DESCRIPTOR);

		LexedToken contentToken = (LexedToken) tbPack.getLexedToken()
				.refCreateInstance();
		contentToken.setValue(content);
		contentToken.setLength(content.length());
		contentToken.setEndColumn(content.length());
		contentToken.setType(0);
		contentToken.setVersion(EEnum.REFERENCE);
		return contentToken;
	}

}
