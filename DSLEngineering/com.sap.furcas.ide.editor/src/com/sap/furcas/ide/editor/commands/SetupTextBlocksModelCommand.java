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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import com.sap.furcas.ide.editor.CtsActivator;
import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.prettyprinter.PrettyPrinter;
import com.sap.furcas.runtime.parser.PartitionAssignmentHandler;
import com.sap.furcas.runtime.tcs.MessageHelper;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.furcas.runtime.textblocks.TbUtil;
import com.sap.furcas.runtime.textblocks.modifcation.TbChangeUtil;
import com.sap.ide.cts.parser.incremental.IncrementalParserFacade;
import com.sap.ide.cts.parser.incremental.MappingRecoveringTextBlocksValidator;
import com.sap.ide.cts.parser.incremental.TextBlockMappingRecoveringFailedException;

/**
 * Does everything that is required to create a valid TextBlocks model
 * for a given root object. Existing TextBlocks are re-used if available
 * and recovered if needed, in order to extract their information (comments, formatting, ...)
 * 
 * In any case, a fresh TextBlocks model is created. This is to make sure that the TextBlocks
 * model is always valid and up-to-date (as expected by the incremental parser).
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
        PrettyPrinter prettyPrinter = createPrettyPrinter();
        try  {
            if (rootBlock != null) {
                boolean wasNeeded = recoverOldBlock();
                if (wasNeeded || TbUtil.getNewestVersion(rootBlock).getVersion() ==  Version.REFERENCE) {
                    resultBlock = prettyPrinter.prettyPrint(rootObject, rootBlock);
                    TbChangeUtil.deleteOtherVersions(rootBlock);
                    TbChangeUtil.delete(rootBlock);
                } else {
                    resultBlock = rootBlock; // keep current one.
                }
            } else {
                resultBlock = prettyPrinter.prettyPrint(rootObject);
            }
        } catch (Exception e) {
            CtsActivator.logger.logError("Failed to initialize textual view", e);
            throw new RuntimeException("Failed to initialize textual view", e);
        }
        setupPartitioning();
    }

    protected boolean recoverOldBlock() {
        MappingRecoveringTextBlocksValidator validator = new MappingRecoveringTextBlocksValidator(parserFacade);
        if (validator.hasBrokenMapping(rootBlock)) {
            try {
                validator.recoverMappingLink(rootBlock, mainTemplate);
            } catch (TextBlockMappingRecoveringFailedException e) {
                CtsActivator.logger.logError("Mapping recovery failed. Creating new textual view", e);
            }
            assertCorrectTextBlockType(rootBlock, mainTemplate);
            return true;
        }
        return false;
    }
    
    protected void setupPartitioning() {
        if (resultBlock.eResource() == null) {
            // It is not optimal to do this here, as it is meant to be the task
            // of the parser facade. However, the invariant that each textblock
            // is always assigned to a resources makes the implementation of the
            // rest of the editor much easier. (Currently required to calculated
            // marker positions within the current document).
            partitionHandler.setDefaultPartition(rootObject.eResource());
            partitionHandler.assignToDefaultTextBlocksPartition(resultBlock);
        }
    }

    protected PrettyPrinter createPrettyPrinter() {
        return new PrettyPrinter(syntax, parserFacade.getParserScope().getMetamodelLookup(), 
                parserFacade.getOclEvaluator(), parserFacade.getParserFactory());
    }

    private static void assertCorrectTextBlockType(TextBlock rootBlock, ClassTemplate rootTemplate) {
        if (rootBlock != null && !TbUtil.isTextBlockOfType(rootTemplate, rootBlock)) {
            throw new RuntimeException("Main template " + MessageHelper.getTemplateName(rootTemplate) +
                    " does not fit the given TextBlocks model.");
        }
    }
    
    public TextBlock getResultBlock() {
        return resultBlock;
    }
    

}
