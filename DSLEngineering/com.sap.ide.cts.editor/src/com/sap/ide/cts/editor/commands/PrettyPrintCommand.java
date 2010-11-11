package com.sap.ide.cts.editor.commands;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.commands.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.ide.cts.editor.CtsActivator;
import com.sap.ide.cts.editor.prettyprint.imported.PrettyPrinter;
import com.sap.ide.cts.editor.prettyprint.imported.SyntaxAndModelMismatchException;
import com.sap.ide.cts.editor.prettyprint.textblocks.TextBlockTCSExtractorStream;


public class PrettyPrintCommand extends Command {

	private final EObject refObject;
	private final ConcreteSyntax syntax;
	private final TextBlockTCSExtractorStream target;
	private TextBlock result;


	public PrettyPrintCommand(EObject refObject, ConcreteSyntax syntax,
			TextBlockTCSExtractorStream target, ResourceSet con) {
		super(con, "Pretty Print Full");
		this.refObject = refObject;
		this.syntax = syntax;
		this.target = target;
	}

	@Override
	public boolean canExecute() {
		return true;
	}

	@Override
	public void doExecute() {
		try {
		    	PrettyPrinter prettyPrinter = new PrettyPrinter();
		    	prettyPrinter.prettyPrint(refObject, syntax, target);

			result = target.getPrintedResultRootBlock();
		} catch (SyntaxAndModelMismatchException e) {
			CtsActivator.logError(e);
			result = null;
		}
	}

	@Override

	public Collection<PartitionOperation> getAffectedPartitions() {
		Partitionable partitionable = refObject;
		PRI pri = partitionable.get___Partition().getPri();
		PartitionOperation editOperation = new PartitionOperation(PartitionOperation.Operation.EDIT, pri);
		return Collections.singleton(editOperation);
	}

	public TextBlock getResult() {
		return result;
	}

}
