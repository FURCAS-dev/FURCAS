/*******************************************************************************
 * Copyright (c) 2011 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.furcas.ide.editor.commands;

import java.io.ByteArrayOutputStream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import com.sap.furcas.ide.editor.CtsActivator;
import com.sap.furcas.ide.editor.dialogs.PrettyPrintPreviewDialog;
import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.runtime.parser.PartitionAssignmentHandler;
import com.sap.furcas.runtime.tcs.MessageHelper;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.furcas.runtime.textblocks.TbUtil;
import com.sap.furcas.runtime.textblocks.modifcation.TbChangeUtil;
import com.sap.furcas.runtime.textblocks.validation.TbValidationUtil;
import com.sap.furcas.unparser.PrettyPrinter;
import com.sap.furcas.unparser.SyntaxAndModelMismatchException;
import com.sap.furcas.unparser.extraction.TCSExtractorPrintStream;
import com.sap.furcas.unparser.extraction.TCSExtractorStream;
import com.sap.furcas.unparser.extraction.textblocks.TextBlockTCSExtractorStream;
import com.sap.furcas.unparser.textblocks.IncrementalTextBlockPrettyPrinter;
import com.sap.ide.cts.parser.incremental.IncrementalParserFacade;
import com.sap.ide.cts.parser.incremental.MappingRecoveringTextBlocksValidator;
import com.sap.ide.cts.parser.incremental.TextBlockMappingRecoveringFailedException;

/**
 * Does everything that is required to create a valid TextBlocks model
 * for a given root object. Existing TextBlocks are re-used if available
 * and recovered if needed.
 * 
 * @author Stephan Erb
 */
public class SetupTextBlocksModelCommand extends RecordingCommand {
    
    private final IncrementalParserFacade parserFacade;
    private final EObject rootObject;
    private final TextBlock rootBlock;
    
    private TextBlock resultBlock;
    private final ConcreteSyntax syntax;
    private final ClassTemplate mainTemplate;
    private final PartitionAssignmentHandler partitionHandler;

    public SetupTextBlocksModelCommand(TransactionalEditingDomain domain, EObject rootObject, TextBlock rootBlock,
            IncrementalParserFacade parserFacade, PartitionAssignmentHandler partitionHandler) {
        super(domain, "Initialize TextBlocks Model");
        
        this.rootObject = rootObject;
        this.rootBlock = rootBlock;
        this.parserFacade = parserFacade;
        this.partitionHandler = partitionHandler;
        
        this.syntax = parserFacade.getParserScope().getSyntax();
        this.mainTemplate = TcsUtil.getMainClassTemplate(syntax);
    }


    @Override
    protected void doExecute() {
        try  {
            if (rootBlock == null) {
                resultBlock = prettyPrintModelToTextBlock();
            } else {
                resultBlock = validateAndMigrateTextBlocksModel();
            }
            
            TbValidationUtil.assertTextBlockConsistencyRecursive(resultBlock);
            TbValidationUtil.assertCacheIsUpToDate(resultBlock);
            
            if (resultBlock.eResource() == null) {
                // It is not optimal to do this here, as it is meant to be the task
                // of the parser facade. However, the invariant that each textblock
                // is always assigned to a resources makes the implementation of the
                // rest of the editor much easier. (Currently required to calculated
                // marker positions within the current document).
                partitionHandler.setDefaultPartition(rootObject.eResource());
                partitionHandler.assignToDefaultTextBlocksPartition(resultBlock);
            }
            
        } catch (Exception e) {
            CtsActivator.logger.logError("Failed to initialize textual view", e);
            throw new RuntimeException("Failed to initialize textual view", e);
        }
    }

    private TextBlock validateAndMigrateTextBlocksModel() {
        MappingRecoveringTextBlocksValidator validator = new MappingRecoveringTextBlocksValidator(parserFacade);
        
        if (validator.hasBrokenMapping(rootBlock)) {
            TextBlock result = recoverBrokenTextBlockMapping(validator);
            assertCorrectTextBlockType(result, TcsUtil.getMainClassTemplate(syntax));
            return result;
        } else {
            assertCorrectTextBlockType(rootBlock, TcsUtil.getMainClassTemplate(syntax));
            validator.checkAndMigrateTokenIds(rootBlock);
            return rootBlock;
        }
    }

    private static void assertCorrectTextBlockType(TextBlock rootBlock, ClassTemplate rootTemplate) {
        if (rootBlock != null && !TbUtil.isTextBlockOfType(rootTemplate, rootBlock)) {
            throw new RuntimeException("Main template " + MessageHelper.getTemplateName(rootTemplate) +
                    " does not fit the given TextBlocks model.");
        }
    }
        
    /**
     * Inspect the {@link #rootBlock} and try to recover it. After the recovery it might turn out that
     * we have a block of the wrong type at hand. <p>
     */
    private TextBlock recoverBrokenTextBlockMapping(MappingRecoveringTextBlocksValidator validator) {
        try {
            validator.recoverMappingLink(rootBlock, mainTemplate);
            return rootBlock;
        } catch (TextBlockMappingRecoveringFailedException e) {
            
            String title = "Mapping Link Recovery Failed";
            String error = "The link from the current document to the mapping definition is broken." + "The recovery failed! \n "
            + e.getMessage() + "\n \n"
            + "You have two options: \n"
            + " a) Click OK and the model will be pretty printed. The old textual view will be replaced. \n"
            + " b) Click Cancel to keep the texutal view as it is. However, this will force the recreation of all model elements"
            + " defined in this view upon changes to this document.";
            
            String oldTextualView = rootBlock.getCachedString();
            String newTextualView = prettyPrintModelToString();
            PrettyPrintPreviewDialog previewDialog = new PrettyPrintPreviewDialog(title, error, oldTextualView, newTextualView);
            boolean prettyPrintAccepted = previewDialog.open();
            
            if (prettyPrintAccepted) {
                TextBlock newRootBlock = prettyPrintModelToTextBlock();
                TbChangeUtil.deleteOtherVersions(rootBlock);
                TbChangeUtil.delete(rootBlock);
                return newRootBlock;
            } 
        }
        return null;
    }
    
    private String prettyPrintModelToString() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        prettyPrintToStream(new TCSExtractorPrintStream(stream));
        return stream.toString();
    }

    private TextBlock prettyPrintModelToTextBlock() {
        TextBlockTCSExtractorStream target = new TextBlockTCSExtractorStream(parserFacade.getParserFactory());
        prettyPrintToStream(target);
        return target.getPrintedResultRootBlock();
    }

    private void prettyPrintToStream(TCSExtractorStream target) {
        try {
            if (rootBlock != null && target instanceof TextBlockTCSExtractorStream) {
                IncrementalTextBlockPrettyPrinter prettyPrinter = new IncrementalTextBlockPrettyPrinter(syntax,
                        parserFacade.getParserScope().getMetamodelLookup());
                prettyPrinter.prettyPrint(rootObject, rootBlock, mainTemplate, target);
    
            } else {
                PrettyPrinter prettyPrinter = new PrettyPrinter(parserFacade.getParserScope().getSyntax(),
                        parserFacade.getParserScope().getMetamodelLookup());
                prettyPrinter.prettyPrint(rootObject, target);
            }
        } catch (SyntaxAndModelMismatchException e) {
            throw new RuntimeException("Model does not (fully) conform to syntax "
                    + parserFacade.getParserFactory().getLanguageId() + ": \n\n" + e.getCause().getMessage(), e);
        }
    }
    
    public TextBlock getResultBlock() {
        return resultBlock;
    }
    

}
