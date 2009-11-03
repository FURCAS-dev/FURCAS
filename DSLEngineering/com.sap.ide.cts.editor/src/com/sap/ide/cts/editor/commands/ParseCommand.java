package com.sap.ide.cts.editor.commands;

import java.util.Collection;
import java.util.Collections;

import textblocks.TextBlock;

import com.sap.ide.cts.editor.AbstractGrammarBasedEditor;
import com.sap.ide.cts.parser.errorhandling.SemanticParserException;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public class ParseCommand extends Command {

	private final TextBlock previousBlock;
	private TextBlock newBlock;
	private SemanticParserException parseException;
	private final AbstractGrammarBasedEditor editor;

	public ParseCommand(TextBlock previousBlock, Connection connection, AbstractGrammarBasedEditor editor) {
		super(connection);
		this.previousBlock = previousBlock;
		this.editor = editor;
	}

	@Override
	public boolean canExecute() {
		return true;
	}

	@Override
	public void doExecute() {
		//PRI pri = ((Partitionable)previousBlock).get___Partition().getPri();
		try {
//		    	getWorkingConnection().getSession().getLockManager().obtainTransientLock(
//		    		pri, getWorkingConnection());
			newBlock = editor.parse(previousBlock);
		} catch (SemanticParserException e) {
			parseException = e;
		}
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		Partitionable partitionable = previousBlock;
	    PRI pri = partitionable.get___Partition().getPri();
	    PartitionOperation editOperation = new PartitionOperation(PartitionOperation.Operation.EDIT, pri);
	    return Collections.singleton(editOperation);
	}

	public TextBlock getNewBlock() {
		return newBlock;
	}

	public SemanticParserException getParseException() {
		return parseException;
	}

}
