package com.sap.mi.gfw.eclipse.internal.command;

import org.eclipse.gef.commands.Command;

import com.sap.mi.gfw.tb.IContextEntry;

public class ContextEntryCommand extends Command {

	private IContextEntry contextEntry;

	public ContextEntryCommand(IContextEntry contextEntry) {
		setContextEntry(contextEntry);
	}

	@Override
	public void execute() {
		getContextEntry().execute();
		super.execute();
	}

	private void setContextEntry(IContextEntry contextEntry) {
		this.contextEntry = contextEntry;
	}

	private IContextEntry getContextEntry() {
		return contextEntry;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#getLabel()
	 */
	@Override
	public String getLabel() {
		return getContextEntry().getText();
	}

}
