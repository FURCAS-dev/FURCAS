package com.sap.ide.cts.dialogs;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

public class ChooseConcreteSyntaxDialog extends AbstractHandler
{
	private EObject[] templateEntries;
	
	public ChooseConcreteSyntaxDialog(EObject[] templates)
	{
		this.templateEntries = templates;
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException
	{
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(Display.getCurrent().getActiveShell(), new LabelProvider());
		dialog.setTitle("Concrete Template Selection");
		dialog.setMessage("Select a concrete Template:");
		dialog.setElements(this.prepareTemplates());
		dialog.open();
		return ((ChooseConcreteSyntaxDialogElement) dialog.getFirstResult()).getWrappedObject();
	}
	
	private Object[] prepareTemplates()
	{
		Object[] preparedTemplates = new Object[this.templateEntries.length];
		for(int i = 0; i < this.templateEntries.length; i++)
		{
			EObject o = this.templateEntries[i];
			ChooseConcreteSyntaxDialogElement entry = new ChooseConcreteSyntaxDialogElement(o);
			preparedTemplates[i] = entry;
		}
		return preparedTemplates;
	}
}
