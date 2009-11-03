package com.sap.ide.cts.editor;

import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListDialog;
import org.eclipse.ui.progress.IProgressService;

import tcs.ConcreteSyntax;

import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.fwk.ui.ModelManagerUI;
import com.sap.mi.fwk.ui.editor.ModelEditor;
import com.sap.mi.fwk.ui.editor.ModelEditorInput;
import com.sap.mi.textual.tcs.util.TcsUtil;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;

public class EditorUtil {
    public static List<ConcreteSyntax> getSyntaxesInProject(final IProject project) {

	final Connection[] conn = new Connection[1];
	IRunnableWithProgress operation = new IRunnableWithProgress() {
	    public void run(IProgressMonitor monitor) {
		// non UI thread
		try {
		    project.open(/* progress monitor */null);
		} catch (CoreException e) {
		    throw new RuntimeException(e);
    }
		conn[0] = ConnectionManager.getInstance()
			.getOrCreateDefaultConnection(project);
	    }
	};
	IProgressService ps = PlatformUI.getWorkbench().getProgressService();
	try {
	    ps.busyCursorWhile(operation);
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
	return TcsUtil.getSyntaxesInConnection(conn[0]);
    }

    public static ConcreteSyntax getActiveSyntax(
	    AbstractGrammarBasedEditor grammarBasedEditor) {
	String languageId = grammarBasedEditor.getLanguageId();

	ConcreteSyntax found = getActiveSyntax(grammarBasedEditor.getEditorInput(), languageId);
	return found;
    }

    public static ConcreteSyntax getActiveSyntax(IEditorInput input, String languageId) {
	List<ConcreteSyntax> syntaxesInProject = getSyntaxesInProject(ModelAdapterUI
		.getInstance().getProject(input));
	ConcreteSyntax found = null;
	for (ConcreteSyntax syntax : syntaxesInProject) {
	    if (syntax.getName().toLowerCase().equals(languageId.toLowerCase())) {
		if(found != null) {
		    throw new IllegalStateException("Found more than one syntax with id: " + syntax.getName() + "!\n" +
			    "Cannot decide which one to use for current editor!\n" + 
			    "Locations are: " + ((Partitionable)found).get___Partition().getPri() + 
			    "\nand:"  + ((Partitionable)syntax).get___Partition().getPri());
		}
		found = syntax;
	    }
	}
	return found;
    }

    /**
     * Retrieves the language id of the currently active editor for the given
     * {@link ModelEditorInput}.
     * 
     * @param modelEditorInput
     * @return The language id of the currently active editor.
     */
    public static String getLanguageID(ModelEditorInput modelEditorInput) {
	AbstractGrammarBasedEditor agbEditor = getCurrentEditor();
	return agbEditor.getLanguageId();
    }

    public static AbstractGrammarBasedEditor getCurrentEditor() {
	ModelEditor modelEditor = (ModelEditor) ModelManagerUI
		.getEditorManager().getActiveModelEditor();
	AbstractGrammarBasedEditor agbEditor = (AbstractGrammarBasedEditor) ModelManagerUI
		.getEditorManager().findEditorPart(modelEditor);
	return agbEditor;
    }

    /**
     * @param shell
     * @param project
     * @return
     */
    public static RefObject getProjectSyntax(Shell shell, IProject project) {
	// Connection connection =
	// ConnectionManager.getInstance().getDefaultConnection(project);

	List<ConcreteSyntax> syntaxList = getSyntaxesInProject(project);

	RefObject syntax = null;
	if (syntaxList != null && syntaxList.size() > 0) {
	    if (syntaxList.size() == 1) {
		syntax = syntaxList.iterator().next();

	    } else {

		IStructuredContentProvider contentProv = new SimpleListContentProvider(
			syntaxList);
		ILabelProvider labelProv = new ILabelProvider() {

		    @Override
		    public Image getImage(Object element) {
			return null;
		    }

		    @Override
		    public String getText(Object element) {
			if (element instanceof ConcreteSyntax) {
			    ConcreteSyntax syntax = (ConcreteSyntax) element;
			    return syntax.getName();
			}
			return null;
		    }

		    @Override
		    public void addListener(ILabelProviderListener listener) {
		    }

		    @Override
		    public void dispose() {
		    }

		    @Override
		    public boolean isLabelProperty(Object element,
			    String property) {

			return false;
		    }

		    @Override
		    public void removeListener(ILabelProviderListener listener) {
		    }
		};
		ListDialog diag = new ListDialog(shell);// , syntaxList,
		// contentProv,
		// LabelProv, "Select a
		// syntax");
		diag.setContentProvider(contentProv);
		diag.setInput(syntaxList);
		diag.setLabelProvider(labelProv);
		diag.setTitle("Choose one of the following syntaxes to open.");
		// MessageDialog.openError(shell, "Multiple syntax defined",
		// "DC Project contains several syntaxes.");
		diag.open();
		Object[] result = diag.getResult();
		syntax = (RefObject) result[0];
	    }
	} else {
	    MessageDialog.openError(shell, "No syntax defined",
		    "DC Project does not contain any syntax.");
	}
	return syntax;
    }

    public static class SimpleListContentProvider implements
	    IStructuredContentProvider {

	private List<?> _contents;

	public SimpleListContentProvider(List<?> contents) {
	    _contents = contents;
	}

	/**
	 * Implements IStructuredContentProvider.
	 * 
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(Object)
	 */
	public Object[] getElements(Object input) {
	    if (_contents != null && _contents == input) {
		return _contents.toArray();
	    }
	    return new Object[0];
	}

	/**
	 * Implements IContentProvider.
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(Viewer,
	 *      Object, Object)
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	    // do nothing
	}

	/**
	 * Implements IContentProvider.
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose() {
	    // do nothing
	}
    }
}
