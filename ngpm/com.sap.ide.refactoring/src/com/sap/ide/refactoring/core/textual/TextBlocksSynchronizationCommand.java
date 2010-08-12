package com.sap.ide.refactoring.core.textual;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.antlr.runtime.Lexer;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;

import tcs.ConcreteSyntax;
import textblocks.TextBlock;

import com.sap.ide.cts.editor.EditorUtil;
import com.sap.ide.cts.moin.parserfactory.AbstractParserFactory;
import com.sap.ide.refactoring.Activator;
import com.sap.ide.refactoring.core.RefactoringCoreException;
import com.sap.ide.refactoring.core.RefactoringSeverity;
import com.sap.ide.refactoring.core.textual.prettyprint.BatchPrettyPrinter;
import com.sap.ide.refactoring.ui.NamedSubProgressMonitor;
import com.sap.mi.textual.grammar.IModelElementInvestigator;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.mi.textual.parsing.textblocks.TbNavigationUtil;
import com.sap.mi.textual.parsing.textblocks.TbValidationUtil;
import com.sap.mi.textual.textblocks.model.TextBlocksModel;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.commands.PartitionOperation.Operation;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.textual.moinadapter.adapter.MOINModelAdapter;

/**
 * Command used to to synchronize the textual views after model changes.
 * Runs the short and the incremental pretty printer. 
 * 
 * @author Stephan Erb (d049157)
 */
public class TextBlocksSynchronizationCommand extends Command {
    
    private final Map<RootElementTextBlockTuple, List<ModelElementDocumentNodeChangeDescriptor>> textBlocksNeedingPrettyPrinting;
    private final Map<RootElementTextBlockTuple, List<ModelElementDocumentNodeChangeDescriptor>> textBlocksNeedingShortPrettyPrinting;

    private final Map<RootElementTextBlockTuple, TextBlockChange> changePerPrettyPrintedRootTuple = new HashMap<RootElementTextBlockTuple, TextBlockChange>();

    private final RefactoringEditorFacade facade;
    private final RefactoringStatus synchronizationStatus = new RefactoringStatus();
    private final IProgressMonitor pm;

    
    public TextBlocksSynchronizationCommand(RefactoringEditorFacade facade,
	    Map<RootElementTextBlockTuple, List<ModelElementDocumentNodeChangeDescriptor>> textBlocksNeedingPrettyPrinting,
	    Map<RootElementTextBlockTuple, List<ModelElementDocumentNodeChangeDescriptor>> textBlocksNeedingShortPrettyPrinting, IProgressMonitor pm) {
	super(facade.getEditorConnection(), "Synchronize TextBlocksModel according to  DomainModel changes");
	
	this.facade = facade;
	this.textBlocksNeedingPrettyPrinting = textBlocksNeedingPrettyPrinting;
	this.textBlocksNeedingShortPrettyPrinting = textBlocksNeedingShortPrettyPrinting;
	this.pm = pm;
    }

    @Override
    public boolean canExecute() {
	return true;
    }

    @Override
    public void doExecute() {
	pm.beginTask("Updating Views:", textBlocksNeedingPrettyPrinting.size() + textBlocksNeedingShortPrettyPrinting.size());
	try {
	    doAllShortPrettyPrinting();
	    doAllFullPrettyPrinting();
	} finally {
	    pm.done();
	}
    }

    private void doAllShortPrettyPrinting() {
	pm.subTask("Short Pretty Printing");
	// TODO: we should not try to synchronize the whole model, but only synchronoize
	// the individual tokens that have actually changed
	// Promises better performance (though that is not a problem at the momen).
	for (RootElementTextBlockTuple rootTuple : textBlocksNeedingShortPrettyPrinting.keySet()) {
	    initializeChangeForRootIfNecessary(rootTuple);
	    prettyPrintShort(rootTuple.textBlock);
	    updateChangeToReflectPrettyPrinting(rootTuple, rootTuple.textBlock);

	    pm.worked(1);
	}
    }

    private void doAllFullPrettyPrinting() {
	pm.subTask("Pretty Printing");
	BatchPrettyPrinter batchPrettyPrinter = new BatchPrettyPrinter();
	
	// First of all, just calculate which textblocks can re reused.
	for (Entry<RootElementTextBlockTuple, List<ModelElementDocumentNodeChangeDescriptor>> entry : textBlocksNeedingPrettyPrinting.entrySet()) {
	    for (ModelElementDocumentNodeChangeDescriptor changeDescriptor : entry.getValue()) {
		initializeChangeForRootIfNecessary(entry.getKey());
		batchPrettyPrinter.queuePrettyPrintJob(changeDescriptor);
	    }
	}
	synchronizationStatus.merge(batchPrettyPrinter.run(new NamedSubProgressMonitor(pm,  textBlocksNeedingPrettyPrinting.size())));
	for (Entry<RootElementTextBlockTuple, List<ModelElementDocumentNodeChangeDescriptor>> entry : textBlocksNeedingPrettyPrinting.entrySet()) {
	    for (ModelElementDocumentNodeChangeDescriptor changeDescriptor : entry.getValue()) {
		TextBlock prettyPrintedTextBlock = batchPrettyPrinter.getPrettyPrinterResultFor(changeDescriptor);
		updateChangeToReflectPrettyPrinting(entry.getKey(), prettyPrintedTextBlock);
	    }
	}
    }

    private void initializeChangeForRootIfNecessary(RootElementTextBlockTuple rootTuple) {
	if (!changePerPrettyPrintedRootTuple.containsKey(rootTuple)) {
	    TextBlockChange change = new TextBlockChange(facade, rootTuple);
	    changePerPrettyPrintedRootTuple.put(rootTuple, change);
	}
    }

    private void updateChangeToReflectPrettyPrinting(RootElementTextBlockTuple rootTuple, TextBlock prettyPrintedTextBlock) {
	if (!rootTuple.modelElement.is___Alive()) {
	    return;
	}
	TextBlockChange change = changePerPrettyPrintedRootTuple.get(rootTuple);
	change.fetchPostChangeState(prettyPrintedTextBlock);
    }

    private void prettyPrintShort(TextBlock rootBlock) {
	if (rootBlock.getType() == null || rootBlock.getType().getParseRule() == null) {
	    Activator.logWarning("Ignoring TextBlock in pretty printing due to broken mapping: " + rootBlock);
	    return;
	}
	try { 
	    TextBlocksModel model = new TextBlocksModel(rootBlock, getModelElementInvestigator(rootBlock));
	    model.doShortPrettyPrintToEditableVersion();
	    TbValidationUtil.assertTextBlockConsistencyRecursive(TbNavigationUtil.getUltraRoot(rootBlock));
	    TbValidationUtil.assertCacheIsUpToDate(TbNavigationUtil.getUltraRoot(rootBlock));
	} catch (Exception e) {
	    Activator.logError(e, "Short PrettyPrint failed");
	    synchronizationStatus.merge(new RefactoringCoreException("Short PrettyPrint failed", e).asRefactoringStatus(RefactoringSeverity.ERROR));
	}
    }

    private IModelElementInvestigator getModelElementInvestigator(TextBlock textBlock) {
	ConcreteSyntax syntax = textBlock.getType().getParseRule().getConcretesyntax();
	AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory = EditorUtil
		.constructParserFactoryForSyntax(syntax);
	RefPackage metamodelPackage = parserFactory.getMetamodelPackage(getConnection());
	return new MOINModelAdapter(metamodelPackage, getConnection(), null, null);
    }

    @Override
    public Collection<PartitionOperation> getAffectedPartitions() {
	Collection<RootElementTextBlockTuple> tuples = new ArrayList<RootElementTextBlockTuple>();
	tuples.addAll(textBlocksNeedingPrettyPrinting.keySet());
	tuples.addAll(textBlocksNeedingShortPrettyPrinting.keySet());
	
	HashSet<ModelPartition> partitionThatWillBeTouched = new HashSet<ModelPartition>();
	for (RootElementTextBlockTuple tuple : tuples) {
	    partitionThatWillBeTouched.add(tuple.textBlock.get___Partition());
	    partitionThatWillBeTouched.add(tuple.modelElement.get___Partition());
	}
	Collection<PartitionOperation> partitionOps = new ArrayList<PartitionOperation>();
	for (ModelPartition part : partitionThatWillBeTouched) {
	    partitionOps.add(new PartitionOperation(Operation.EDIT, part.getPri()));
	}
	return partitionOps;
    }

    public Collection<TextBlockChange> getTextBlockChanges() {
	return changePerPrettyPrintedRootTuple.values();
    }

    public RefactoringStatus getSynchronizationStatus() {
        return synchronizationStatus;
    }

}
