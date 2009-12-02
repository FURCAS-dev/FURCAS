package com.sap.ide.cts.dialogs;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

public class ChooseConcreteSyntaxDialog extends AbstractHandler
{
	private Object[] elements;
	
	public ChooseConcreteSyntaxDialog(Object[] elements)
	{
		this.elements = elements;
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException
	{
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(Display.getCurrent().getActiveShell(), new LabelProvider());
		dialog.setTitle("Concrete Syntax Selection");
		dialog.setMessage("Select a concrete Syntax:");
		dialog.setElements(this.elements);
		int selected = dialog.open();
		return this.elements[selected];
	}
	
	
}
