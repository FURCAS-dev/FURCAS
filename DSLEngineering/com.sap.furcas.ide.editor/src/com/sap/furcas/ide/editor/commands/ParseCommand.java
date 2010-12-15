package com.sap.furcas.ide.editor.commands;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.ide.editor.AbstractGrammarBasedEditor;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.ide.cts.parser.errorhandling.SemanticParserException;

public class ParseCommand extends AbstractCommand {

    private final TextBlock previousBlock;
    private TextBlock newBlock;
    private SemanticParserException parseException;
    private final AbstractGrammarBasedEditor editor;
    private final boolean errorMode;

    public ParseCommand(TextBlock previousBlock, ResourceSet connection,
            AbstractGrammarBasedEditor editor, boolean errorMode) {
        super("Incremental Parse and Model Update");
        this.previousBlock = previousBlock;
        this.editor = editor;
        this.errorMode = errorMode;
    }

    @Override
    public boolean canExecute() {
        return true;
    }

    @Override
    public void execute() {
        // URI pri = ((EObject)previousBlock).get___Partition().getPri();
        try {
            // getWorkingConnection().getSession().getLockManager().obtainTransientLock(
            // pri, getWorkingConnection());
            newBlock = editor.parse(previousBlock, errorMode);
        } catch (SemanticParserException e) {
            parseException = e;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void redo() {
        // TODO Auto-generated method stub

    }

    // public Collection<EOperation> getAffectedPartitions() {
    // EObject partitionable = previousBlock;
    // URI pri = partitionable.eResource().getURI();
    // EOperation editOperation = new EOperation(EOperation.Operation.EDIT,
    // pri);
    // return Collections.singleton(editOperation);
    // }

    public TextBlock getNewBlock() {
        return newBlock;
    }

    public SemanticParserException getParseException() {
        return parseException;
    }

}
