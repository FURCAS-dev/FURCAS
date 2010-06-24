package com.sap.ide.refactoring.core.textual;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.antlr.runtime.Lexer;

import tcs.ConcreteSyntax;
import textblocks.DocumentNode;
import textblocks.TextBlock;

import com.sap.ide.cts.editor.EditorUtil;
import com.sap.ide.cts.moin.parserfactory.AbstractParserFactory;
import com.sap.ide.refactoring.core.TextBlockChange;
import com.sap.ide.refactoring.core.textual.prettyprint.BatchPrettyPrinter;
import com.sap.mi.textual.grammar.IModelElementInvestigator;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.mi.textual.parsing.textblocks.TbNavigationUtil;
import com.sap.mi.textual.textblocks.model.TextBlocksModel;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.textual.moinadapter.adapter.MOINModelAdapter;

public class TextBlocksSynchronizationCommand extends Command {

    private final Map<RefObject, List<ModelElementDocumentNodeChangeDescriptor>> textBlocksNeedingPrettyPrinting;
    private final Map<RefObject, List<ModelElementDocumentNodeChangeDescriptor>> textBlocksNeedingShortPrettyPrinting;

    private final Map<TextBlock, TextBlockChange> changePerPrettyPrintedRootTextBlock = new HashMap<TextBlock, TextBlockChange>();

    public TextBlocksSynchronizationCommand(Connection connection,
	    Map<RefObject, List<ModelElementDocumentNodeChangeDescriptor>> textBlocksNeedingPrettyPrinting,
	    Map<RefObject, List<ModelElementDocumentNodeChangeDescriptor>> textBlocksNeedingShortPrettyPrinting) {
	super(connection, "Synchronize TextBlocksModel according to  DomainModel changes");

	this.textBlocksNeedingPrettyPrinting = textBlocksNeedingPrettyPrinting;
	this.textBlocksNeedingShortPrettyPrinting = textBlocksNeedingShortPrettyPrinting;
    }

    @Override
    public boolean canExecute() {
	return true;
    }

    @Override
    public void doExecute() {
	// do short pretty print
	doAllShortPrettyPrinting();
	doAllFullPrettyPrinting();
    }

    private void doAllFullPrettyPrinting() {
	BatchPrettyPrinter batchPrettyPrinter = new BatchPrettyPrinter();
	// First of all, just calculate which textblocks can re reused.
	for (Entry<RefObject, List<ModelElementDocumentNodeChangeDescriptor>> entry : textBlocksNeedingPrettyPrinting.entrySet()) {
	    for (ModelElementDocumentNodeChangeDescriptor changeDescriptor : entry.getValue()) {
		initializeChangeForRootIfNecessary(entry.getKey(), changeDescriptor.documentNode);
		batchPrettyPrinter.queuePrettyPrintJob(changeDescriptor);
	    }
	}
	batchPrettyPrinter.run();
	// Finally create the new 
	for (Entry<RefObject, List<ModelElementDocumentNodeChangeDescriptor>> entry : textBlocksNeedingPrettyPrinting.entrySet()) {
	    for (ModelElementDocumentNodeChangeDescriptor changeDescriptor : entry.getValue()) {
		TextBlock prettyPrintedTextBlock = batchPrettyPrinter.getPrettyPrinterResultFor(changeDescriptor);
		if (prettyPrintedTextBlock != null) {
		    updateChangeToReflectPrettyPrinting(changeDescriptor.documentNode);
		    // another init might be needed if either a new rootBlock was created, or we were linked to another parent.
		    initializeChangeForRootIfNecessary(entry.getKey(), prettyPrintedTextBlock);
		    updateChangeToReflectPrettyPrinting(prettyPrintedTextBlock);
		}
	    }
	}
    }

    private void doAllShortPrettyPrinting() {
	for (Entry<RefObject, List<ModelElementDocumentNodeChangeDescriptor>> entry : textBlocksNeedingShortPrettyPrinting.entrySet()) {
	    for (ModelElementDocumentNodeChangeDescriptor changeDescriptor : entry.getValue()) {
		initializeChangeForRootIfNecessary(entry.getKey(), changeDescriptor.documentNode);
		TextBlock rootBlock = TbNavigationUtil.getUltraRoot(changeDescriptor.documentNode);
		prettyPrintShort(rootBlock);
		updateChangeToReflectPrettyPrinting(rootBlock);
		// Short pretty printing works only for a complete TextBlocks tree
		// no need do redo for the various subtrees
		break;
	    }
	}
    }

    private void initializeChangeForRootIfNecessary(RefObject rootObject, DocumentNode documentNode) {
	TextBlock rootBlock = TbNavigationUtil.getUltraRoot(documentNode);
	if (!changePerPrettyPrintedRootTextBlock.containsKey(rootBlock)) {
	    TextBlockChange change = new TextBlockChange(rootObject);
	    change.fetchPreChangeState(rootBlock);
	    changePerPrettyPrintedRootTextBlock.put(rootBlock, change);
	}
    }

    private void updateChangeToReflectPrettyPrinting(DocumentNode prettyPrintedTextBlock) {
	if (!prettyPrintedTextBlock.is___Alive()) {
	    return;
	}
	TextBlock rootBlock = TbNavigationUtil.getUltraRoot(prettyPrintedTextBlock);
	TextBlockChange change = changePerPrettyPrintedRootTextBlock.get(rootBlock);
	change.fetchPostChangeState(rootBlock);
    }



    private void prettyPrintShort(TextBlock rootBlock) {
	if (rootBlock.getType() == null || rootBlock.getType().getParseRule() == null) {
	    System.out.println(">>> Skipping Tb: Broken Mapping.");
	    return;
	}
	
	TextBlocksModel model = new TextBlocksModel(rootBlock, getModelElementInvestigator(rootBlock));
	model.doShortPrettyPrintToEditableVersion();
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
	return null;
    }

    public Collection<TextBlockChange> getTextBlockChanges() {
	return changePerPrettyPrintedRootTextBlock.values();
    }

}
