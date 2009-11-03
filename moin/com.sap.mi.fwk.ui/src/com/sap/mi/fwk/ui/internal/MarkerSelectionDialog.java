package com.sap.mi.fwk.ui.internal;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IMarkerActionFilter;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.dialogs.FilteredList;

import com.sap.mi.fwk.ui.editor.ModelEditorManager;
import com.sap.mi.fwk.ui.internal.messages.MiFwkUiMessages;

/**
 * This class provides a standard eclipse based project selection dialog for
 * moin based projects. Usage:
 * 
 * <pre><code>
 * MarkerSelectionDialog dlg = new MarkerSelectionDialog();
 * IMarker marker = dlg.openDialog();
 * </code></pre>
 * 
 * @author d024127
 */
public final class MarkerSelectionDialog extends ElementListSelectionDialog {

	private static final String WIDGET_DATA_NAME = "name"; //$NON-NLS-1$

	private IMarker[] markers;

	public static final class MarkerLabelProvider extends LabelProvider {
		public String getText(Object element) {
			if (element instanceof IMarker) {
				return ((IMarker) element).getAttribute(IMarkerActionFilter.MESSAGE, ""); //$NON-NLS-1$
			}
			return element.toString();
		}
	}

	public MarkerSelectionDialog(Shell parent, IMarker[] markers) {
		super(parent, new MarkerLabelProvider());
		this.markers = markers;
		init();
	}

	/**
	 * Fills the list with moin projects and sets inital default values. Since
	 * these settings are set during constructor calls they can be overridden
	 * later.
	 */
	private void init() {

		this.setElements(markers);
		this.setBlockOnOpen(true);

		// next method call also applies for null pointer
		// then the first project is selected
		// this.setInitialSelections(new IProject[] { p });

		this.setMultipleSelection(false);

		// empty search field means show all projects
		this.setMatchEmptyString(true);

		this.setTitle(MiFwkUiMessages.MarkerSelectionDialog_title);
		this.setMessage(MiFwkUiMessages.MarkerSelectionDialog_text);
	}

	/**
	 * Opens the dialog and returns the selected project or null if user
	 * canceled the dialog. The dialog only displays moin based projects and
	 * tries to determine the currently active project by using
	 * {@link ModelEditorManager#getActiveProject()} and selects it in the list.
	 * If no active project could be determined the first project is selected.
	 * 
	 * @return The selected proejct or null if user canceled the dialog
	 * @see ModelEditorManager#getActiveProject()
	 */
	public IMarker openDialog() {
		super.open();
		Object[] results = super.getResult();
		if (results != null && results.length > 0) {
			return (IMarker) results[0];
		}
		return null;
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setData(WIDGET_DATA_NAME, "MarkerSelectionDialog.SelectMarker"); //$NON-NLS-1$ for testing
		setShellStyle(getShellStyle() | SWT.RESIZE | SWT.MAX);
	}

	@Override
	protected FilteredList createFilteredList(Composite parent) {
		FilteredList result = super.createFilteredList(parent);
		fFilteredList.setData(WIDGET_DATA_NAME, "MarkerSelectionDialog.SelectMarker.list"); //$NON-NLS-1$ for testing
		return result;
	}

	@Override
	protected Button createButton(Composite parent, int id, String label, boolean defaultButton) {
		Button button = super.createButton(parent, id, label, defaultButton);
		if (IDialogConstants.OK_ID == id)
			button.setData(WIDGET_DATA_NAME, "OK"); //$NON-NLS-1$
		else if (IDialogConstants.CANCEL_ID == id)
			button.setData(WIDGET_DATA_NAME, "Cancel"); //$NON-NLS-1$
		return button;
	}
}