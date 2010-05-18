package com.sap.ide.cts.dialogs;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;


public class ChoosePrettyPrintModeDialog extends AbstractHandler
{

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException
	{
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(Display.getCurrent().getActiveShell(), new LabelProvider());
		Object[] ppModes = new Object[] {"progressive", "conservative"};
		dialog.setTitle("Select Pretty Printing Mode");
		dialog.setMessage("Select a Mode:");
		dialog.setElements(ppModes);
		dialog.open();
		return dialog.getFirstResult();
	}

}
