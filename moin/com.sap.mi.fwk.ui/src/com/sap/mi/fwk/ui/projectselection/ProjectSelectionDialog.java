package com.sap.mi.fwk.ui.projectselection;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.dialogs.FilteredList;
import org.eclipse.ui.model.WorkbenchLabelProvider;

import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.ui.editor.ModelEditorManager;
import com.sap.mi.fwk.ui.internal.messages.MiFwkUiMessages;

/**
 * This class provides a standard eclipse based project selection dialog for
 * moin based projects. Usage:
 * 
 * <pre>
 * &lt;code&gt;
 * ProjectSelectionDialog dlg = new ProjectSelectionDialog();
 * IProject project = dlg.openDialog();
 * &lt;/code&gt;
 * </pre>
 * 
 * @author d024127
 */
public final class ProjectSelectionDialog extends ElementListSelectionDialog {

	private static final String WIDGET_DATA_NAME = "name"; //$NON-NLS-1$
	public static final String SHELL_PROJECT_SELECTION_DIALOG = "ProjectSelectionDialog.SelectProject"; //$NON-NLS-1$
	public static final String SHELL_PROJECT_SELECTION_DIALOG_LIST = "ProjectSelectionDialog.SelectProject.list"; //$NON-NLS-1$

	public ProjectSelectionDialog(Shell parent, ILabelProvider renderer) {
		super(parent, renderer);
		init();
	}

	public ProjectSelectionDialog(Shell parent) {
		super(parent, new ProjectLabelProvider());
		init();
	}

	public ProjectSelectionDialog() {
		super(null, new ProjectLabelProvider());
		init();
	}

	/**
	 * Fills the list with moin projects and sets inital default values. Since
	 * these settings are set during constructor calls they can be overridden
	 * later.
	 */
	private void init() {
		// guess the active project
		// IProject p = ModelManagerUI.getEditorManager().getActiveProject();
		// assumption: returns the projects in the same order they appear in the
		// project explorer
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		List<IProject> moinProjects = new ArrayList<IProject>();
		for (IProject project : projects) {
			if (ModelManager.getInstance().isMoinProject(project)) {
				moinProjects.add(project);
			}
		}
		this.setElements(moinProjects.toArray(new IProject[moinProjects.size()]));
		this.setBlockOnOpen(true);

		// next method call also applies for null pointer
		// then the first project is selected
		// this.setInitialSelections(new IProject[] { p });

		this.setMultipleSelection(false);

		// empty search field means show all projects
		this.setMatchEmptyString(true);

		this.setTitle(MiFwkUiMessages.ProjectSelectionDialog_title);
		this.setMessage(MiFwkUiMessages.ProjectSelectionDialog_text);
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
	public IProject openDialog() {
		super.open();
		Object[] results = super.getResult();
		if (results != null && results.length > 0) {
			return (IProject) results[0];
		}
		return null;
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setData(WIDGET_DATA_NAME, SHELL_PROJECT_SELECTION_DIALOG);
		setShellStyle(getShellStyle() | SWT.RESIZE | SWT.MAX);
	}

	@Override
	protected FilteredList createFilteredList(Composite parent) {
		FilteredList result = super.createFilteredList(parent);
		fFilteredList.setData(WIDGET_DATA_NAME, SHELL_PROJECT_SELECTION_DIALOG_LIST);
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

	private static final class ProjectLabelProvider extends WorkbenchLabelProvider {

		@Override
		protected String decorateText(String input, Object element) {
			return PlatformUI.getWorkbench().getDecoratorManager().getLabelDecorator().decorateText(input, element);
		}

	}

}