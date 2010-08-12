package com.sap.ide.cts.editor.document;

import java.util.Collection;
import java.util.HashSet;

import org.antlr.runtime.Lexer;

import tcs.ClassTemplate;
import tcs.ConcreteSyntax;
import textblocks.Bostoken;
import textblocks.DocumentNode;
import textblocks.Eostoken;
import textblocks.LexedToken;
import textblocks.TextBlock;
import textblocks.TextblocksPackage;
import textblocks.VersionEnum;

import com.sap.ide.cts.editor.CtsActivator;
import com.sap.ide.cts.editor.commands.PrettyPrintCommand;
import com.sap.ide.cts.editor.prettyprint.textblocks.TextBlockTCSExtractorStream;
import com.sap.ide.cts.parser.incremental.ParserFactory;
import com.sap.ide.cts.parser.incremental.TextBlockMappingBrokenException;
import com.sap.ide.cts.parser.incremental.antlr.ANTLRIncrementalLexerAdapter;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.mi.textual.parsing.textblocks.TbNavigationUtil;
import com.sap.mi.textual.parsing.textblocks.TbUtil;
import com.sap.mi.textual.parsing.textblocks.TbValidationUtil;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.exception.ExecutionRollbackFailedException;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * Util classes required to get a corresponding rootBlock for an
 * existing rootObject.
 * 
 * @author D049157
 * 
 */
public class TbModelInitializationUtil {

    /**
     * Determines an existing root TextBlock
     * 
     * @param rootObject
     * @param tbPackage
     * @param rootTemplate
     * @return a TextBlock or null if none could be found
     * @throws TextBlockMappingBrokenException
     */
    public static TextBlock getRootBlockForRootObject(RefObject rootObject, TextblocksPackage tbPackage, ClassTemplate rootTemplate)
	    throws TextBlockMappingBrokenException {
	Collection<DocumentNode> nodes = tbPackage.getDocumentNodeReferencesCorrespondingModelElement().getDocumentNode(
		rootObject);

	// find all potential, existing roots. 
	Collection<TextBlock> rootBlocks = new HashSet<TextBlock>();
	Collection<TextBlock> rootBlocksWithBrokenMapping = new HashSet<TextBlock>(); 
	for (DocumentNode documentNode : nodes) {
	    if (documentNode.getVersion() == null) {
		CtsActivator.logWarning("Document contains unversioned TextBlock: " + documentNode
			+ ". Please consider to cleanup the TextBlocks of this project.");
		continue;
	    }
	    if (!(documentNode instanceof TextBlock)) {
		continue;
	    }
	    TextBlock block = (TextBlock) documentNode;
	    if (!TbNavigationUtil.isUltraRoot(block)) {
		continue;
	    }
	    block = (TextBlock) TbUtil.getNewestVersion(block);
	    // type can only be checked if mapping is not broken
	    if (TbUtil.isTextBlockOfType(rootTemplate, block)) {
		rootBlocks.add(block);
	    } else if (block.getType() == null) {
		rootBlocksWithBrokenMapping.add(block);
	    }
	}
	
	// try to find suitable block
	if (rootBlocks.size() + rootBlocksWithBrokenMapping.size() == 0) {
	    // no root block does exist
	    return null;
	} else if (rootBlocks.size() == 1) {
	    TextBlock existingRoot = rootBlocks.iterator().next();
	    TbValidationUtil.assertTextBlockConsistency(existingRoot);
	    return existingRoot;
	} else if (rootBlocksWithBrokenMapping.size() == 1) {
	    TextBlock existingRoot = rootBlocksWithBrokenMapping.iterator().next();
	    // Might still be valid. Requires further processing
	    throw new TextBlockMappingBrokenException(existingRoot);
	} else {
		if(rootBlocks.size() > 0) {
			//TODO provide selection dialog with possibility to open and/or delete blocks.
			CtsActivator.logWarning("Found more than one root TextBlock for " + rootObject + " using template " + rootTemplate
			    + ": " + rootBlocks);
			return rootBlocks.iterator().next();
		} else if(rootBlocksWithBrokenMapping.size() > 0) {
			//TODO provide selection dialog with possibility to open and/or delete blocks.
			CtsActivator.logWarning("Found more than one root TextBlock for " + rootObject + " using template " + rootTemplate
			    + ": " + rootBlocksWithBrokenMapping);
			return rootBlocksWithBrokenMapping.iterator().next();
		} else {
			//this should not happen.
			return null;
		}
//	    throw new RuntimeException("Found more than one root TextBlock for " + rootObject + " using template " + rootTemplate
//		    + ": " + rootBlocks);
	}
    }

    /**
     * Tries to pretty print a TextBlock model for a given rootObject and syntax
     * 
     * @param rootObject
     * @param tbPackage
     * @param syntax
     * @param connection
     * @param parserFactory
     * @return the created root TextBlock or null if initialization failed
     */
    public static TextBlock initilizeTextBlocksFromModel(RefObject rootObject, TextblocksPackage tbPackage,
	    ConcreteSyntax syntax, Connection connection,
	    ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory) {

	TextBlock rootBlock = null;
	ModelPartition partitionForTextBlocks = getPartitionForTextBlocks(rootObject);

	TextBlockTCSExtractorStream target = new TextBlockTCSExtractorStream(tbPackage, partitionForTextBlocks,
		parserFactory);
	PrettyPrintCommand ppCommand = new PrettyPrintCommand(rootObject, syntax, target, connection);
	try {
	    connection.getCommandStack().execute(ppCommand);
	} catch (ExecutionRollbackFailedException e) {
	    CtsActivator.logError(e);
	} catch (Exception e) {
	    CtsActivator.logError(e);
	}
	rootBlock = ppCommand.getResult();

	if (rootBlock != null) {
	    partitionForTextBlocks.assignElement(rootBlock);
	    TbValidationUtil.assertTextBlockConsistency(rootBlock);
	}

	return rootBlock;
    }

    /**
     * This method is the last last resort: Create a completely new TextBlock
     * model for a given rootObject.
     * 
     * <p>
     * It should only be used if the actual ConcreteSyntax is unknown and pretty
     * printing therefore becomes impossible.
     * </p>
     * 
     * @param rootObject
     * @return
     */
    public static TextBlock createNewTextBlockForModel(RefObject rootObject) {
	ModelPartition partitionForTextBlocks = getPartitionForTextBlocks(rootObject);
	TextBlock rootBlock = createNewTextBlockModel(rootObject, partitionForTextBlocks);
	return rootBlock;
    }

    /**
     * TODO this has to be adapted if there is going to be an extra partition
     * for model elements
     */
    private static ModelPartition getPartitionForTextBlocks(RefBaseObject modelElement) {
	return ((Partitionable) modelElement).get___Partition();
    }

    /**
     * Create TextBlock model for a given rootObject;
     * 
     * @param rootObject
     * @param partitionForTextBlocks
     * @return
     */
    private static TextBlock createNewTextBlockModel(RefObject rootObject, ModelPartition partitionForTextBlocks) {
	TextblocksPackage tbPackage = ((Partitionable) rootObject).get___Connection().getPackage(
		TextblocksPackage.PACKAGE_DESCRIPTOR);
	TextBlock rootBlock = (TextBlock) tbPackage.getTextBlock().refCreateInstanceInPartition(partitionForTextBlocks);
	rootBlock.getCorrespondingModelElements().add(rootObject);
	Bostoken bosToken = ANTLRIncrementalLexerAdapter.createBOSToken(tbPackage, VersionEnum.REFERENCE,
		ANTLRIncrementalLexerAdapter.bosTokenType);
	rootBlock.getTokens().add(bosToken);

	LexedToken contentToken = (LexedToken) tbPackage.getLexedToken().refCreateInstance();
	contentToken.setValue("");
	contentToken.setLength(0);
	contentToken.setEndColumn(0);
	contentToken.setType(0); // TODO What is the type of nothing?
	contentToken.setVersion(VersionEnum.REFERENCE);
	rootBlock.getTokens().add(contentToken);

	Eostoken eosToken = ANTLRIncrementalLexerAdapter.createEOSToken(tbPackage, VersionEnum.REFERENCE,
		ANTLRIncrementalLexerAdapter.eosTokenType);
	rootBlock.getTokens().add(eosToken);

	rootBlock.setLength(0);
	rootBlock.setComplete(true);
	rootBlock.setEndColumn(0);
	rootBlock.setCachedString("");
	rootBlock.setVersion(VersionEnum.REFERENCE);

	return rootBlock;
    }
}
