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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.imp.parser.IMessageHandler;
import org.eclipse.swt.widgets.Display;

import com.sap.furcas.ide.editor.document.CtsDocument;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.runtime.parser.ParsingError;
import com.sap.furcas.runtime.textblocks.modifcation.TbChangeUtil;
import com.sap.furcas.runtime.textblocks.modifcation.TbVersionUtil;
import com.sap.furcas.runtime.textblocks.shortprettyprint.ShortPrettyPrinter;
import com.sap.ide.cts.parser.errorhandling.SemanticParserException;
import com.sap.ide.cts.parser.errorhandling.SemanticParserException.Component;
import com.sap.ide.cts.parser.incremental.IncrementalParserFacade;

/**
 * Command which controlls the execution of the incremental parser.
 * It is designed to properly synchronize with both the editing domain
 * and the content of the editor.
 *  
 * @author Stephan Erb
 */
public class ParseCommand extends RecordingCommand {
    
    // TODO: Looks like that for proper undo/redo all modifications have to be
    // wrapped into CompositeEMFOperation, so that after redo we can restore
    // the old content of the CtsDocument. This would mean steps 1) and 3)
    // have to individual operations.
    // Stephan Erb, 28.05.2011

    private final CtsDocument document;
    private final IncrementalParserFacade parserFacade;
    private TextBlock result;
    private final IMessageHandler handler;
    private boolean wasEffective;
    private final ShortPrettyPrinter shortPrettyPrinter;
    private final IProgressMonitor monitor;
    private final TransactionalEditingDomain domain;

    public ParseCommand(TransactionalEditingDomain domain, CtsDocument document, IncrementalParserFacade parserFacade, IMessageHandler handler, IProgressMonitor monitor) {
        super(domain, "Parse document");
        this.domain = domain;
        this.document = document;
        this.parserFacade = parserFacade;
        this.handler = handler;
        this.monitor = monitor;
        this.result = document.getRootBlock();
        this.shortPrettyPrinter = new ShortPrettyPrinter(parserFacade.getModelElementInvestigator());
    }

    @Override
    protected void doExecute() {
        wasEffective = false;
        
        // 1) Write all buffered user edits to the underlying 
        //    textblocks model. Synchronize to prevent concurrent
        //    editing from within the UI thread.
        boolean contentChanged = document.flushUserEditsToTextBlocskModel();
        if (!contentChanged) {
            // parser was triggered by IMP, but there are no changes that require reparsing.
            return;
        }
                
        // 2) Run the parser. This creates a new TextBlocks model
        //    Parsing runs in the background only.
        TextBlock blockWithUnparsedEdits = TbVersionUtil.getOtherVersion(document.getRootBlock(), Version.PREVIOUS);
        result = parse(blockWithUnparsedEdits);
        
        // Succeded without an exception. The command will not be rolled back and the
        // model changes will remain in effect
        wasEffective = true; 
        
        if (result == null || Version.REFERENCE != result.getVersion()) {
            return;
        }
        // 3) Merge all user edits that happened while step 2 was running.
        //    Afterwards, run the short pretty printer to update all tokens according
        //    to domain model changes. The order is essential here, because otherwise 
        //    the offsets of the user's text edits are already invalid. 
        document.setRootBlock(result);
        Runnable privRunnable = domain.createPrivilegedRunnable(new Runnable() {
            @Override
            public void run() {
                document.refreshContentFromTextBlocksModelChanges(shortPrettyPrinter);
            }
        });
        Display.getDefault().syncExec(privRunnable);
    }
        
    private TextBlock parse(TextBlock oldBlock) {
        try {
            TextBlock newBlock = parserFacade.parseIncrementally(oldBlock, monitor);
            if (monitor.isCanceled()) {
                return null;
            } else {
                // Both lexing and parsing were successfull. Make a new REFERENCE version. 
                return (TextBlock) TbChangeUtil.cleanUp(newBlock);
            }
        } catch (SemanticParserException e) {
            handleParseException(e);
            // We can use the created textblock as an intermediate result, as
            // it is sufficient for services such as the token colorer.
            if (e.getComponentThatFailed() == Component.LEXICAL_ANALYSIS) {
                return TbVersionUtil.getOtherVersion(oldBlock, Version.PREVIOUS);
            } else {
                return TbVersionUtil.getOtherVersion(oldBlock, Version.CURRENT);
            }
        }
    }

    
    private void handleParseException(SemanticParserException parserException) {
        for (ParsingError ex : parserException.getIssuesList()) {
            handler.handleSimpleMessage(ex.getMessage(), ex.getIndex(), ex.getStopIndex(),
                    ex.getPosition(), ex.getEndPosition(), ex.getLine(), ex.getEndLine());
        }
    }
    
    public TextBlock getParsingResult() {
        return result;
    }
    
    /**
     * True if some actual work was done. False if the command did not change anything. 
     */
    public boolean wasEffective() {
        return wasEffective;
    }
    
}