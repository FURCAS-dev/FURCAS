package com.sap.ide.cts.editor.commands;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.commands.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.ide.cts.editor.AbstractGrammarBasedEditor;
import com.sap.ide.cts.parser.errorhandling.SemanticParserException;


public class ParseCommand extends Command {

	private final TextBlock previousBlock;
	private TextBlock newBlock;
	private SemanticParserException parseException;
	private final AbstractGrammarBasedEditor editor;
        private final boolean errorMode;

	public ParseCommand(TextBlock previousBlock, ResourceSet connection, AbstractGrammarBasedEditor editor, boolean errorMode) {
	    super(connection, "Incremental Parse and Model Update");
	    this.previousBlock = previousBlock;
	    this.editor = editor;
	    this.errorMode = errorMode;
	}

	@Override
	public boolean canExecute() {
		return true;
	}

	@Override
	public void doExecute() {
		//URI pri = ((EObject)previousBlock).get___Partition().getPri();
		try {
//		    	getWorkingConnection().getSession().getLockManager().obtainTransientLock(
//		    		pri, getWorkingConnection());
			newBlock = editor.parse(previousBlock, errorMode);
		} catch (SemanticParserException e) {
			parseException = e;
		}
	}

	@Override
	public Collection<EOperation> getAffectedPartitions() {
		EObject partitionable = previousBlock;
	    URI pri = partitionable.eResource().getURI();
	    EOperation editOperation = new EOperation(EOperation.Operation.EDIT, pri);
	    return Collections.singleton(editOperation);
	}

	public TextBlock getNewBlock() {
		return newBlock;
	}

	public SemanticParserException getParseException() {
		return parseException;
	}

}
