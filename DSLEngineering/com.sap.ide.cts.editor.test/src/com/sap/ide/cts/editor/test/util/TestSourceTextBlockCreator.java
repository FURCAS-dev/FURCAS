/**
 * 
 */
package com.sap.ide.cts.editor.test.util;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.textblocks.AbstractToken;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.furcas.metamodel.textblocks.Version;
import com.sap.mi.textual.parsing.textblocks.TestTextBlocksModelElementFactory;


/**
 *
 */
public class TestSourceTextBlockCreator {

	// copied from CtsDocument
	public static TextBlock initialiseTextBlocksFromModel(
			EObject rootObject, String content) {
		return null;
		// TODO
		// TextBlock rootBlock;
		// rootBlock = tbPackage.getTextBlock().createTextBlockInPartition(
		// ((Partitionable) rootObject).get___Partition());
		// rootBlock.getCorrespondingModelElements().add((RefObject)
		// rootObject);
		// rootBlock.getTokens().add(
		// ANTLRIncrementalLexerAdapter.createBOSToken(tbPackage,
		// VersionEnum.REFERENCE,
		// ANTLRIncrementalLexerAdapter.bosTokenType));
		// LexedToken contentToken =
		// tbPackage.getLexedToken().createLexedToken();
		// contentToken.setValue(content);
		// contentToken.setLength(content.length());
		// contentToken.setEndColumn(content.length());
		// // TODO What is the type of nothing?
		// contentToken.setType(0);
		// contentToken.setVersion(VersionEnum.REFERENCE);
		// rootBlock.getTokens().add(contentToken);
		// AbstractToken eosToken =
		// ANTLRIncrementalLexerAdapter.createEOSToken(tbPackage,
		// VersionEnum.REFERENCE,
		// ANTLRIncrementalLexerAdapter.eosTokenType);
		// eosToken.setOffset(content.length());
		// rootBlock.getTokens().add(
		// eosToken);
		// rootBlock.setLength(0);
		// rootBlock.setComplete(true);
		// rootBlock.setEndColumn(0);
		// rootBlock.setCachedString("");
		// rootBlock.setVersion(VersionEnum.REFERENCE);
		// //TODO: make this paramterizable: either assign to same or separate
		// partiotion
		// ((Partitionable)rootObject).get___Partition().assignElement(rootBlock);
		// return rootBlock;
	}

	// copied from CtsDocument
	public static TextBlock initialiseTextBlocksWithContentToken(
			TestTextBlocksModelElementFactory modelFactory,
			AbstractToken contentToken) {
		TextBlock rootBlock;
		rootBlock = modelFactory.createTextBlock();
		// ((Partitionable) rootObject).get___Partition());
		// rootBlock.getCorrespondingModelElements().add((RefObject)
		// rootObject);
		rootBlock.getTokens().add(modelFactory.createBostoken());
		AbstractToken eosToken = modelFactory.createEostoken();

		if (contentToken != null) {
			rootBlock.getTokens().add(contentToken);

			rootBlock.setLength(contentToken.getLength());
			//rootBlock.setIsComplete(true);
			rootBlock.setEndColumn(contentToken.getLength());
			rootBlock.setCachedString(contentToken.getValue());
			eosToken.setOffset(contentToken.getLength());
		}

		rootBlock.getTokens().add(eosToken);
		rootBlock.setVersion(Version.REFERENCE);
		
		// TODO: make this paramterizable: either assign to same or separate
		// partiotion
		// ((Partitionable)rootObject).get___Partition().assignElement(rootBlock);
		return rootBlock;
	}

}
