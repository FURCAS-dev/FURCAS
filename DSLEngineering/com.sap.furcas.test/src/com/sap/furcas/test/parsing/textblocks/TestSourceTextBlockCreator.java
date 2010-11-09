/**
 * 
 */
package com.sap.furcas.test.parsing.textblocks;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;


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
			TextBlocksModelElementFactory modelFactory,
			AbstractToken contentToken) {
		TextBlock rootBlock;
		rootBlock = modelFactory.createTextBlock();
		// ((Partitionable) rootObject).get___Partition());
		// rootBlock.getCorrespondingModelElements().add((RefObject)
		// rootObject);
		rootBlock.getSubNodes().add(modelFactory.createBostoken());
		AbstractToken eosToken = modelFactory.createEostoken();

		if (contentToken != null) {
			rootBlock.getSubNodes().add(contentToken);

			rootBlock.setLength(contentToken.getLength());
			//rootBlock.setIsComplete(true);
			rootBlock.setEndColumn(contentToken.getLength());
			rootBlock.setCachedString(contentToken.getValue());
			eosToken.setOffset(contentToken.getLength());
		}

		rootBlock.getSubNodes().add(eosToken);
		rootBlock.setVersion(Version.REFERENCE);
		
		// TODO: make this paramterizable: either assign to same or separate
		// partiotion
		// ((Partitionable)rootObject).get___Partition().assignElement(rootBlock);
		return rootBlock;
	}

}
