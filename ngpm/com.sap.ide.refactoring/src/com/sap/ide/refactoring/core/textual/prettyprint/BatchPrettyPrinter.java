package com.sap.ide.refactoring.core.textual.prettyprint;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.antlr.runtime.Lexer;

import tcs.ClassTemplate;
import tcs.ConcreteSyntax;
import textblocks.AbstractToken;
import textblocks.TextBlock;
import textblocks.TextblocksPackage;

import com.sap.ide.cts.editor.EditorUtil;
import com.sap.ide.cts.editor.prettyprint.SyntaxAndModelMismatchException;
import com.sap.ide.cts.moin.parserfactory.AbstractParserFactory;
import com.sap.ide.refactoring.Activator;
import com.sap.ide.refactoring.core.RefactoringCoreException;
import com.sap.ide.refactoring.core.textual.ModelElementDocumentNodeChangeDescriptor;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * A wrapper about incremental pretty printers that enables them
 * to correctly handle the move of an decorated object: the corresponding
 * textblock will be moved as well. 
 * 
 * @author D049157
 *
 */
public class BatchPrettyPrinter {

    private static boolean CONSERVATIVE_PRETTYPRINTING_MODE = false;

    /**
     * This collection is shared by all {@link CtsTextBlockBatchEnabledIncrementalTCSExtractorStream} instances
     * involved in this batch run.
     */
    private Collection<TextBlock> reusableTextBlocks = new ArrayList<TextBlock>();
    private Map<ModelElementDocumentNodeChangeDescriptor, DelayedIncrementalPrettyPrinter> prettyPrinterPerChange = new HashMap<ModelElementDocumentNodeChangeDescriptor, DelayedIncrementalPrettyPrinter>();

    public void queuePrettyPrintJob(ModelElementDocumentNodeChangeDescriptor changeDescriptor) {
	if (changeDescriptor.documentNode instanceof AbstractToken) {
	    System.out.println(">>> Skipping Token: Can only prettyprint TextBlocks, not Tokens,.");
	    return;
	}
	TextBlock textBlockToPrint = (TextBlock) changeDescriptor.documentNode;
	if (textBlockToPrint.getType() == null || textBlockToPrint.getType().getParseRule() == null) {
	    Activator.logWarning("Ignoring TextBlock in pretty printing due to broken mapping: " + textBlockToPrint);
	    return;
	}

	prettyPrinterPerChange.put(changeDescriptor, getAndRunDelayedPrettyPrinter(changeDescriptor));
    }

    private DelayedIncrementalPrettyPrinter getAndRunDelayedPrettyPrinter(
	    ModelElementDocumentNodeChangeDescriptor changeDescriptor) {
	TextBlock textBlockToPrint = (TextBlock) changeDescriptor.documentNode;
	RefObject correspondingModelElement = changeDescriptor.modelElement;
	assert textBlockToPrint != null && correspondingModelElement != null;

	ClassTemplate template = (ClassTemplate) textBlockToPrint.getType().getParseRule();
	ConcreteSyntax syntax = template.getConcretesyntax();

	AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory = EditorUtil
		.constructParserFactoryForSyntax(syntax);
	TextblocksPackage tbPackage = textBlockToPrint.get___Connection().getPackage(TextblocksPackage.PACKAGE_DESCRIPTOR);
	CtsTextBlockBatchEnabledIncrementalTCSExtractorStream stream = new CtsTextBlockBatchEnabledIncrementalTCSExtractorStream(
		tbPackage, textBlockToPrint.get___Partition(), parserFactory, CONSERVATIVE_PRETTYPRINTING_MODE,
		reusableTextBlocks);

	DelayedIncrementalPrettyPrinter prettyPrinter = new DelayedIncrementalPrettyPrinter();
	try {
	    prettyPrinter.prettyPrint(new RefObject[] { textBlockToPrint }, correspondingModelElement, syntax, stream, template);
	} catch (SyntaxAndModelMismatchException e) {
	    throw new RefactoringCoreException("Unable to pretty print ModelElement: " + correspondingModelElement, e);
	}
	return prettyPrinter;
    }

    public void run() {
	for (DelayedIncrementalPrettyPrinter prettyPrinter : prettyPrinterPerChange.values()) {
	    try {
		prettyPrinter.finish();
	    } catch (Exception e) { //TODO needs propper Eclipse integration
		Activator.logError(e, "Unable to construct TextBlocks Model");
	    }
	}
	// TextBlocks that are still left can be deleted for sure.
	for (TextBlock tb : reusableTextBlocks) {
	    if (tb.is___Alive()) {
		tb.refDelete();
	    }
	}
    }

    public TextBlock getPrettyPrinterResultFor(ModelElementDocumentNodeChangeDescriptor changeDescriptor) {
	if (!prettyPrinterPerChange.containsKey(changeDescriptor)) {
	    return null;
	}
	return prettyPrinterPerChange.get(changeDescriptor).getRootBlock();
    }

}
