package com.sap.ide.refactoring.core.textual.prettyprint;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.antlr.runtime.Lexer;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;

import tcs.ClassTemplate;
import tcs.ConcreteSyntax;
import textblocks.AbstractToken;
import textblocks.TextBlock;
import textblocks.TextblocksPackage;

import com.sap.ide.cts.editor.EditorUtil;
import com.sap.ide.cts.editor.prettyprint.imported.SyntaxAndModelMismatchException;
import com.sap.ide.cts.editor.prettyprint.textblocks.TextBlockIndex;
import com.sap.ide.cts.editor.prettyprint.textblocks.TextBlockTCSExtractorStream;
import com.sap.ide.cts.moin.parserfactory.AbstractParserFactory;
import com.sap.ide.refactoring.Activator;
import com.sap.ide.refactoring.core.RefactoringCoreException;
import com.sap.ide.refactoring.core.RefactoringSeverity;
import com.sap.ide.refactoring.core.textual.ModelElementDocumentNodeChangeDescriptor;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * A wrapper about incremental pretty printers that enables them
 * to correctly handle the move of an decorated object: the corresponding
 * TextBlock will be moved as well. 
 * 
 * @author Stephan Erb (d049157)
 *
 */
public class BatchPrettyPrinter {

    private final Map<ModelElementDocumentNodeChangeDescriptor, DelayedIncrementalPrettyPrinter> prettyPrinterPerChange = new HashMap<ModelElementDocumentNodeChangeDescriptor, DelayedIncrementalPrettyPrinter>();
    private final Map<ModelElementDocumentNodeChangeDescriptor, TextBlock> printedResulTextBlockPerChange = new HashMap<ModelElementDocumentNodeChangeDescriptor, TextBlock>();

    private final RefactoringStatus status = new RefactoringStatus();
    private final TextBlockIndex sharedIndex = new TextBlockIndex();

    public void queuePrettyPrintJob(ModelElementDocumentNodeChangeDescriptor changeDescriptor) {
	if (changeDescriptor.documentNode instanceof AbstractToken) {
	    Activator.logWarning("Skipping Token: Can only prettyprint TextBlocks, not Tokens,.");
	    return;
	}
	TextBlock textBlockToPrint = (TextBlock) changeDescriptor.documentNode;
	if (textBlockToPrint.getType() == null || textBlockToPrint.getType().getParseRule() == null) {
	    Activator.logWarning("Ignoring TextBlock in pretty printing due to broken mapping: " + textBlockToPrint);
	    return;
	}
	try {
	    prettyPrinterPerChange.put(changeDescriptor, getAndSetupDelayedPrettyPrinter(changeDescriptor));
	} catch (Exception e) {
	    Activator.logError(e, "Unable to setup pretty printer for: " + changeDescriptor.modelElement);
	    status.merge(new RefactoringCoreException("Unable to setup pretty printer for: " + changeDescriptor.modelElement, e).asRefactoringStatus(RefactoringSeverity.ERROR));
	}
    }

    private DelayedIncrementalPrettyPrinter getAndSetupDelayedPrettyPrinter(ModelElementDocumentNodeChangeDescriptor changeDescriptor) {
	TextBlock textBlockToPrint = (TextBlock) changeDescriptor.documentNode;
	sharedIndex.index(textBlockToPrint);
	return new DelayedIncrementalPrettyPrinter(sharedIndex);
    }

    public RefactoringStatus run(IProgressMonitor pm) {
	pm.beginTask("", prettyPrinterPerChange.size()*2);
	
	for (Entry<ModelElementDocumentNodeChangeDescriptor, DelayedIncrementalPrettyPrinter> entry : prettyPrinterPerChange.entrySet()) {
	    try {
		DelayedIncrementalPrettyPrinter prettyPrinter = entry.getValue();
		ModelElementDocumentNodeChangeDescriptor changeDescriptor = entry.getKey();
		TextBlock result = prettyPrint(prettyPrinter, changeDescriptor);
		printedResulTextBlockPerChange.put(changeDescriptor, result);
	    } catch (Exception e) {
		Activator.logError(e, "Unable to pretty print "+ entry.getKey().modelElement);
		status.merge(new RefactoringCoreException("Unable to pretty print "+ entry.getKey().modelElement, e).asRefactoringStatus(RefactoringSeverity.ERROR));
	    } finally {
		pm.worked(1);
	    }
	}
	pm.subTask("Construction new TextBlocks models.");
	for (Entry<ModelElementDocumentNodeChangeDescriptor, DelayedIncrementalPrettyPrinter> entry : prettyPrinterPerChange.entrySet()) {
	    try {
		if (!printedResulTextBlockPerChange.containsKey(entry.getKey())) {
		    // pretty printing failed with exception; there is nothing to finish ere
		    continue;
		}
		DelayedIncrementalPrettyPrinter prettyPrinter = entry.getValue();
		prettyPrinter.finish();
	    } catch (Exception e) {
		Activator.logError(e, "Unable to finish pretty printing for "+ entry.getKey().modelElement);
		status.merge(new RefactoringCoreException("Unable to finish pretty printing for "+ entry.getKey().modelElement, e).asRefactoringStatus(RefactoringSeverity.ERROR));
	    } finally {
		pm.worked(1);
	    }
	}
	pm.done();
	return status;
    }

    private TextBlock prettyPrint(DelayedIncrementalPrettyPrinter prettyPrinter, ModelElementDocumentNodeChangeDescriptor changeDescriptor) throws SyntaxAndModelMismatchException {
	TextBlock textBlockToPrint = (TextBlock) changeDescriptor.documentNode;
	RefObject correspondingModelElement = changeDescriptor.modelElement;
	assert textBlockToPrint != null && correspondingModelElement != null;
	
	ClassTemplate template = (ClassTemplate) textBlockToPrint.getType().getParseRule();
	ConcreteSyntax syntax = template.getConcretesyntax();
	
	AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory = EditorUtil.constructParserFactoryForSyntax(syntax);
	TextblocksPackage tbPackage = textBlockToPrint.get___Connection().getPackage(TextblocksPackage.PACKAGE_DESCRIPTOR);
	
	TextBlockTCSExtractorStream stream = new TextBlockTCSExtractorStream(tbPackage, textBlockToPrint.get___Partition(), parserFactory);
	prettyPrinter.prettyPrint(correspondingModelElement, textBlockToPrint, syntax, template, stream);
	
	return stream.getPrintedResultRootBlock();
    }

    public TextBlock getPrettyPrinterResultFor(ModelElementDocumentNodeChangeDescriptor changeDescriptor) {
	if (printedResulTextBlockPerChange.containsKey(changeDescriptor)) {
	    return printedResulTextBlockPerChange.get(changeDescriptor);
	} else {
	    return null;
	}
    }

}
