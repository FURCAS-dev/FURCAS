package com.sap.ide.moftool.editor.internal.refactoring.ui.actions;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.ActionDelegate;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;

import com.sap.ide.moftool.editor.internal.refactoring.ui.dialog.OpenTypeDialog;
import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.fwk.ui.editor.ModelEditorManager;



public class OpenTypeAction extends ActionDelegate implements IWorkbenchWindowActionDelegate {

	private static final Logger sTracer = Logger.getLogger(MiLocations.MI_MOFTOOLSET);

	private IWorkbenchWindow window;

	public void init(IWorkbenchWindow window) {
		this.window = window;
	}

	@Override
	public void run(IAction action) {
		try {
			FilteredItemsSelectionDialog spd = new OpenTypeDialog(window.getShell());
			if (spd.open() == Dialog.OK) {
				final Object firstResult = spd.getFirstResult();
				if (firstResult instanceof ModelElement) {
					ModelElement modelElement = (ModelElement) firstResult;
					final RefObject refObject = ModelAdapterUI.getInstance().getRefObject(modelElement);
					try {
						if (refObject.is___Alive()) {
							ModelEditorManager.getInstance().openEditor(refObject);
						}
					} catch (final PartInitException e) {
						sTracer.log(Level.SEVERE, "Failed to start editor for " + refObject, e); //$NON-NLS-1$
					}
				}
			}
		} catch (Exception e) {
			sTracer.log(Level.SEVERE, e.getMessage(), e);
		}

	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		action.setEnabled(true);
	}

}
