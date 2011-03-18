package com.sap.furcas.ide.editor.commands;

import org.eclipse.emf.common.command.AbstractCommand;

/**
 * A fake command that does nothing. We just want the editing domain to know we changed something
 * so that it allows us to save our resources.
 * 
 * This won't be needed anymore if our actual model midifactions are wrapped into EMF Transactions.
 *
 */
public class NullCommand extends AbstractCommand {

    public NullCommand() {
        super("Do Nothing");
    }

    @Override
    public boolean canExecute() {
        return true;
    }

    @Override
    public void execute() {
    }

    @Override
    public void redo() {

    }

}
