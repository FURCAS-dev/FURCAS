package com.sap.ide.refactoring.core.textual;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.sap.ide.cts.editor.prettyprint.IncrementalPrettyPrinter;
import com.sap.ide.refactoring.core.textual.TextBlockInChangeCalculator.ModelElementTextBlockTuple;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class UpdateTextBlocksCommand extends Command {

    private final Map<RefObject, List<ModelElementTextBlockTuple>> textBlocksNeedingPrettyPrinting;
    private final Map<RefObject, List<ModelElementTextBlockTuple>> textBlocksNeedingShortPrettyPrinting;

    public UpdateTextBlocksCommand(Connection connection,
	    Map<RefObject, List<ModelElementTextBlockTuple>> textBlocksNeedingPrettyPrinting,
	    Map<RefObject, List<ModelElementTextBlockTuple>> textBlocksNeedingShortPrettyPrinting) {
	super(connection, "Update Refactoring Dependet TextBlocks");

	this.textBlocksNeedingPrettyPrinting = textBlocksNeedingPrettyPrinting;
	this.textBlocksNeedingShortPrettyPrinting = textBlocksNeedingShortPrettyPrinting;
    }

    @Override
    public boolean canExecute() {
	return true;
    }

    @Override
    public void doExecute() {

	for (Entry<RefObject, List<ModelElementTextBlockTuple>> entry : textBlocksNeedingPrettyPrinting.entrySet()) {
	    for (ModelElementTextBlockTuple tuple : entry.getValue()) {
		IncrementalPrettyPrinter prettyPrinter = new IncrementalPrettyPrinter();

//		ClassTemplate template = (ClassTemplate) tuple.textBlock.getType().getParseRule();
//		ConcreteSyntax syntax = template.getConcretesyntax();
//
//		AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory = EditorUtil
//			.constructParserFactoryForSyntax(syntax);
//
//		TextblocksPackage tbPackage = getConnection().getPackage(TextblocksPackage.PACKAGE_DESCRIPTOR);
//		CtsTextBlockIncrementalTCSExtractorStream stream = new CtsTextBlockIncrementalTCSExtractorStream(tbPackage,
//			tuple.textBlock.get___Partition(), parserFactory, /*conservative mode*/true);
//
//		try {
//		    prettyPrinter.prettyPrint(new RefObject[]{tuple.textBlock}, tuple.modelElement, syntax, stream, template);
//		} catch (SyntaxAndModelMismatchException e) {
//		    throw new RefactoringCoreException("Unable to pretty print ModelElement: " + tuple.modelElement, e);
//		}

	    }
	}

    }

    @Override
    public Collection<PartitionOperation> getAffectedPartitions() {
	// TODO Auto-generated method stub
	return null;
    }

}
