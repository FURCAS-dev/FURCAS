package com.sap.furcas.ide.editor.document;

import java.util.Collection;
import java.util.HashSet;

import org.antlr.runtime.Lexer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;

import com.sap.furcas.ide.editor.CtsActivator;
import com.sap.furcas.ide.editor.commands.PrettyPrintCommand;
import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.textblocks.Bostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.metamodel.FURCAS.textblocks.Eostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksFactory;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.textblocks.TbNavigationUtil;
import com.sap.furcas.runtime.textblocks.TbUtil;
import com.sap.furcas.runtime.textblocks.validation.TbValidationUtil;
import com.sap.furcas.unparser.extraction.textblocks.TextBlockTCSExtractorStream;
import com.sap.ide.cts.parser.incremental.ParserFactory;
import com.sap.ide.cts.parser.incremental.TextBlockMappingBrokenException;
import com.sap.ide.cts.parser.incremental.antlr.ANTLRIncrementalLexerAdapter;

/**
 * Util classes required to get a corresponding rootBlock for an existing
 * rootObject.
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
    public static TextBlock getRootBlockForRootObject(EObject rootObject,
            OppositeEndFinder oppositeEndFinder, ClassTemplate rootTemplate)
            throws TextBlockMappingBrokenException {
        Collection<EObject> nodes = oppositeEndFinder
                .navigateOppositePropertyWithBackwardScope(
                        TextblocksPackage.eINSTANCE
                                .getDocumentNode_CorrespondingModelElements(),
                        rootObject);

        if (nodes != null) {
            // find all potential, existing roots.
            Collection<TextBlock> rootBlocks = new HashSet<TextBlock>();
            Collection<TextBlock> rootBlocksWithBrokenMapping = new HashSet<TextBlock>();
            for (EObject eObject : nodes) {
                if (eObject instanceof DocumentNode) {
                    DocumentNode documentNode = (DocumentNode) eObject;
                    if (documentNode.getVersion() == null) {
                        CtsActivator
                                .logWarning("Document contains unversioned TextBlock: "
                                        + documentNode
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
                TextBlock existingRoot = rootBlocksWithBrokenMapping.iterator()
                        .next();
                // Might still be valid. Requires further processing
                throw new TextBlockMappingBrokenException(existingRoot);
            } else {
                if (rootBlocks.size() > 0) {
                    // TODO provide selection dialog with possibility to open
                    // and/or delete blocks.
                    CtsActivator
                            .logWarning("Found more than one root TextBlock for "
                                    + rootObject
                                    + " using template "
                                    + rootTemplate + ": " + rootBlocks);
                    return rootBlocks.iterator().next();
                } else if (rootBlocksWithBrokenMapping.size() > 0) {
                    // TODO provide selection dialog with possibility to open
                    // and/or delete blocks.
                    CtsActivator
                            .logWarning("Found more than one root TextBlock for "
                                    + rootObject
                                    + " using template "
                                    + rootTemplate
                                    + ": "
                                    + rootBlocksWithBrokenMapping);
                    return rootBlocksWithBrokenMapping.iterator().next();
                } else {
                    // this should not happen.
                    return null;
                }
                // throw new
                // RuntimeException("Found more than one root TextBlock for " +
                // rootObject + " using template " + rootTemplate
                // + ": " + rootBlocks);
            }
        } else {
            return null;
        }
    }

    /**
     * Tries to pretty print a TextBlock model for a given rootObject and syntax
     * 
     * @param rootObject
     * @param tbPackage
     * @param syntax
     * @param editingDomain
     * @param parserFactory
     * @return the created root TextBlock or null if initialization failed
     */
    public static TextBlock initilizeTextBlocksFromModel(
            EObject rootObject,
            TextblocksPackage tbPackage,
            ConcreteSyntax syntax,
            EditingDomain editingDomain,
            ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory) {

        TextBlock rootBlock = null;

        TextBlockTCSExtractorStream target = new TextBlockTCSExtractorStream(
                tbPackage, parserFactory);
        PrettyPrintCommand ppCommand = new PrettyPrintCommand(rootObject,
                syntax, target, editingDomain.getResourceSet());
        try {
            editingDomain.getCommandStack().execute(ppCommand);
        } catch (Exception e) {
            CtsActivator.logError(e);
        }
        Collection<?> result = ppCommand.getResult();
        if(result.size() > 0 && result.iterator().next() instanceof TextBlock) {
            rootBlock = (TextBlock) result.iterator().next();
        }

        if (rootBlock != null) {
            //partitionForTextBlocks.assignElement(rootBlock);
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
    public static TextBlock createNewTextBlockForModel(EObject rootObject) {
        TextBlock rootBlock = createNewTextBlockModel(rootObject);
        return rootBlock;
    }

    /**
     * Create TextBlock model for a given rootObject;
     * 
     * @param rootObject
     * @param partitionForTextBlocks
     * @return
     */
    private static TextBlock createNewTextBlockModel(EObject rootObject) {
        TextblocksFactory tbFactory = TextblocksFactory.eINSTANCE;
        TextBlock rootBlock = tbFactory.createTextBlock();
        rootBlock.getCorrespondingModelElements().add(rootObject);
        Bostoken bosToken = ANTLRIncrementalLexerAdapter.createBOSToken(
                tbFactory, Version.REFERENCE,
                ANTLRIncrementalLexerAdapter.bosTokenType);
        rootBlock.getSubNodes().add(bosToken);

        LexedToken contentToken = tbFactory.createLexedToken();
        contentToken.setValue("");
        contentToken.setLength(0);
        contentToken.setEndColumn(0);
        contentToken.setType(0); // TODO What is the type of nothing?
        contentToken.setVersion(Version.REFERENCE);
        rootBlock.getSubNodes().add(contentToken);

        Eostoken eosToken = ANTLRIncrementalLexerAdapter.createEOSToken(
                tbFactory, Version.REFERENCE,
                ANTLRIncrementalLexerAdapter.eosTokenType);
        rootBlock.getSubNodes().add(eosToken);

        rootBlock.setLength(0);
        rootBlock.setComplete(true);
        rootBlock.setEndColumn(0);
        rootBlock.setCachedString("");
        rootBlock.setVersion(Version.REFERENCE);

        return rootBlock;
    }
}
