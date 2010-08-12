package com.sap.ide.cts.editor.commands;

import java.util.Collection;
import java.util.Collections;

import tcs.ConcreteSyntax;
import textblocks.TextBlock;

import com.sap.ide.cts.editor.CtsActivator;
import com.sap.ide.cts.editor.prettyprint.imported.PrettyPrinter;
import com.sap.ide.cts.editor.prettyprint.imported.SyntaxAndModelMismatchException;
import com.sap.ide.cts.editor.prettyprint.textblocks.TextBlockTCSExtractorStream;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class PrettyPrintCommand extends Command {

	private final RefObject refObject;
	private final ConcreteSyntax syntax;
	private final TextBlockTCSExtractorStream target;
	private TextBlock result;

	public PrettyPrintCommand(RefObject refObject, ConcreteSyntax syntax,
			TextBlockTCSExtractorStream target, Connection con) {
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
