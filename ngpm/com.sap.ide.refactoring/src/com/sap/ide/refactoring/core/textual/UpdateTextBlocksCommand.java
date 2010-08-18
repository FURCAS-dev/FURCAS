package com.sap.ide.refactoring.core.textual;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.antlr.runtime.Lexer;
import org.eclipse.core.commands.Command;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;

import com.sap.furcas.metamodel.TCS.ClassTemplate;
import com.sap.furcas.metamodel.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.furcas.metamodel.textblocks.TextblocksPackage;
import com.sap.ide.cts.editor.EditorUtil;
import com.sap.ide.cts.editor.prettyprint.CtsTextBlockIncrementalTCSExtractorStream;
import com.sap.ide.cts.editor.prettyprint.IncrementalPrettyPrinter;
import com.sap.ide.cts.editor.prettyprint.SyntaxAndModelMismatchException;
import com.sap.ide.cts.moin.parserfactory.AbstractParserFactory;
import com.sap.ide.refactoring.core.RefactoringCoreException;
import com.sap.ide.refactoring.core.TextBlockChange;
import com.sap.ide.refactoring.core.textual.TextBlockInChangeCalculator.ModelElementTextBlockTuple;
import com.sap.mi.textual.grammar.IModelElementInvestigator;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.mi.textual.parsing.textblocks.TbNavigationUtil;
import com.sap.mi.textual.textblocks.model.TextBlocksModel;


public class UpdateTextBlocksCommand extends Command {

    private final Map<EObject, List<ModelElementTextBlockTuple>> textBlocksNeedingPrettyPrinting;
    private final Map<EObject, List<ModelElementTextBlockTuple>> textBlocksNeedingShortPrettyPrinting;

    private final Collection<Change> prettyPrintedTextBlocks = new ArrayList<Change>();

    public UpdateTextBlocksCommand(ResourceSet connection,
	    Map<EObject, List<ModelElementTextBlockTuple>> textBlocksNeedingPrettyPrinting,
	    Map<EObject, List<ModelElementTextBlockTuple>> textBlocksNeedingShortPrettyPrinting) {
	super(connection, "Update Refactoring dependet TextBlocks");

	this.textBlocksNeedingPrettyPrinting = textBlocksNeedingPrettyPrinting;
	this.textBlocksNeedingShortPrettyPrinting = textBlocksNeedingShortPrettyPrinting;
    }

    @Override
    public boolean canExecute() {
	return true;
    }

    @Override
    public void doExecute() {

	// do full pretty print
	for (Entry<EObject, List<ModelElementTextBlockTuple>> entry : textBlocksNeedingPrettyPrinting.entrySet()) {
	    CompositeChange composite = new CompositeChange("Pretty Print " + ((EClass) entry.getKey().refMetaObject()).getName());
	    for (ModelElementTextBlockTuple tuple : entry.getValue()) {

		if (tuple.textBlock.getType() == null ) {
		    System.out.println(">>> Skipping Tb: Broken Mapping for " + tuple.textBlock.getClass().getName());
		    continue;
		}
		TextBlockChange change = new TextBlockChange(tuple.modelElement);
		change.fetchPreChangeState(tuple.textBlock);
		TextBlock prettyPrintedBlock = prettyPrint(tuple);
		change.fetchPostChangeState("Pretty Print", prettyPrintedBlock);
		composite.add(change);
	    }
	    if (composite.getChildren().length < 2) {
		composite.markAsSynthetic();
	    }
	    prettyPrintedTextBlocks.add(composite);
	}

	// do short pretty print
	for (Entry<EObject, List<ModelElementTextBlockTuple>> entry : textBlocksNeedingShortPrettyPrinting.entrySet()) {
	    for (ModelElementTextBlockTuple tuple : entry.getValue()) {
		if (tuple.textBlock.getType() == null ) {
		    System.out.println(">>> Skipping Tb: Broken Mapping for " + tuple.textBlock.getClass().getName());
		    continue;
		}
		// Short pretty printing works only for a complete TextBlocks tree
		// no need do redo for the various subtrees
		TextBlockChange change = new TextBlockChange(tuple.modelElement);
		TextBlock rootBlock = TbNavigationUtil.getUltraRoot(tuple.textBlock);
		change.fetchPreChangeState(rootBlock);
		prettyPrintShort(rootBlock);
		change.fetchPostChangeState("Short Pretty Print", rootBlock);
		prettyPrintedTextBlocks.add(change);
		break;
	    }
	}
    }



    private TextBlock prettyPrint(ModelElementTextBlockTuple tuple) {
	IncrementalPrettyPrinter prettyPrinter = new IncrementalPrettyPrinter();

	ClassTemplate template = (ClassTemplate) tuple.textBlock.getType().getParseRule();
	ConcreteSyntax syntax = template.getConcretesyntax();

	AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory = EditorUtil
		.constructParserFactoryForSyntax(syntax);

	TextblocksPackage tbPackage = getConnection().getPackage(TextblocksPackage.PACKAGE_DESCRIPTOR);
	CtsTextBlockIncrementalTCSExtractorStream stream = new CtsTextBlockIncrementalTCSExtractorStream(tbPackage,
		tuple.textBlock.get___Partition(), parserFactory, /*progressive mode*/ false);

	try {
	    prettyPrinter.prettyPrint(new EObject[]{tuple.textBlock}, tuple.modelElement, syntax, stream, template);
	} catch (SyntaxAndModelMismatchException e) {
	    throw new RefactoringCoreException("Unable to pretty print ModelElement: " + tuple.modelElement, e);
	}
	return prettyPrinter.getRootBlock();
    }

    private void prettyPrintShort(TextBlock rootBlock) {
	TextBlocksModel model = new TextBlocksModel(rootBlock, getModelElementInvestigator(rootBlock));
	model.doShortPrettyPrintToEditableVersion();
    }

    private IModelElementInvestigator getModelElementInvestigator(TextBlock textBlock) {
	ConcreteSyntax syntax = textBlock.getType().getParseRule().getConcretesyntax();
	AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory = EditorUtil
		.constructParserFactoryForSyntax(syntax);
	EPackage metamodelPackage = parserFactory.getMetamodelPackage(getConnection());
	return new MOINModelAdapter(metamodelPackage, getConnection(), null, null);
    }

    @Override
    public Collection<EOperation> getAffectedPartitions() {
	return null;
    }

    public Collection<Change> getTextBlockChanges() {
	return prettyPrintedTextBlocks;
    }

}
