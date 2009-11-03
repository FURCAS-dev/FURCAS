package com.sap.ide.cts.editor.commands;

import java.util.Collection;
import java.util.Collections;

import tcs.ConcreteSyntax;
import textblocks.TextBlock;

import com.sap.ide.cts.editor.CtsActivator;
import com.sap.ide.cts.editor.prettyprint.CtsPrettyPrinter;
import com.sap.ide.cts.editor.prettyprint.CtsTextBlockTCSExtractorStream;
import com.sap.ide.cts.editor.prettyprint.SyntaxAndModelMismatchException;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class PrettyPrintCommand extends Command {

	private final RefObject refObject;
	private final ConcreteSyntax syntax;
	private final CtsTextBlockTCSExtractorStream target;
	private TextBlock result;

	public PrettyPrintCommand(RefObject refObject, ConcreteSyntax syntax,
			CtsTextBlockTCSExtractorStream target, Connection con) {
		super(con);
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
			CtsPrettyPrinter.prettyPrint(refObject, syntax, target);

			result = target.getRootBlock();
		} catch (SyntaxAndModelMismatchException e) {
			CtsActivator.logError(e);

			result = null;
		}
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		Partitionable partitionable = refObject;
		PRI pri = partitionable.get___Partition().getPri();
		PartitionOperation editOperation = new PartitionOperation(
				PartitionOperation.Operation.EDIT, pri);
		return Collections.singleton(editOperation);
	}

	public TextBlock getResult() {
		return result;
	}

}
