package com.sap.furcas.ide.editor.dialogs;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

public class PrettyPrinterInfoDialog extends AbstractHandler
{
	private String title, message;
	
	public PrettyPrinterInfoDialog(String title, String message)
	{
		super();
		this.title = title;
		this.message = message;
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException
	{
		MessageDialog.openInformation(Display.getCurrent().getActiveShell(), this.title, this.message);
		return null;
	}
	
}
