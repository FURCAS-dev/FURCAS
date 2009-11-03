package com.sap.mi.gfw.eclipse.internal.command;

import org.eclipse.gef.commands.Command;

import com.sap.mi.gfw.command.CommandExec;
import com.sap.mi.gfw.command.ICommand;
import com.sap.tc.moin.repository.Connection;

public class GefCommandWrapper extends Command {
	private ICommand command;

	private Connection connection;

	public GefCommandWrapper(ICommand command, Connection connection) {
		super();
		setCommand(command);
		this.connection = connection;
	}

	@Override
	public boolean canExecute() {
		return getCommand().canExecute() && super.canExecute();
	}

	@Override
	public boolean canUndo() {
		return getCommand().canUndo() && super.canUndo();
	}

	@Override
	public void execute() {
		ICommand c = getCommand();
		CommandExec.getSingleton().executeCommand(c, connection);
		super.execute();
	}

	@Override
	public String getLabel() {
		String ret = null;
		final ICommand c = getCommand();
		if (c != null) {
			ret = c.getDescription();
		}
		if (ret != null) {
			return ret;
		}
		return super.getLabel();
	}

	@Override
	public void undo() {
		getCommand().undo();
		super.undo();
	}

	public ICommand getCommand() {
		return command;
	}

	private void setCommand(ICommand command) {
		this.command = command;
	}

}
