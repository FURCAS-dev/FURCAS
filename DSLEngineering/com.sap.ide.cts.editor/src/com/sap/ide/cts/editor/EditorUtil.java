package com.sap.ide.cts.editor;

import java.util.List;

import org.antlr.runtime.Lexer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;

import tcs.ConcreteSyntax;

import com.sap.furcas.textual.tcs.TcsUtil;
import com.sap.ide.cts.moin.parserfactory.AbstractParserFactory;
import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.fwk.ui.ModelManagerUI;
import com.sap.mi.fwk.ui.editor.ModelEditor;
import com.sap.mi.fwk.ui.editor.ModelEditorInput;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
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
		conn[0] = ConnectionManager.getInstance().getOrCreateDefaultConnection(project);
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

    public static List<ConcreteSyntax> getSyntaxesInProjectWithName(final IProject project, String languageId) {
	final Connection[] conn = new Connection[1];
	IRunnableWithProgress operation = new IRunnableWithProgress() {
	    public void run(IProgressMonitor monitor) {
		// non UI thread
		try {
		    project.open(/* progress monitor */null);
		} catch (CoreException e) {
		    throw new RuntimeException(e);
		}
		conn[0] = ConnectionManager.getInstance().getOrCreateDefaultConnection(project);
	    }
	};
	IProgressService ps = PlatformUI.getWorkbench().getProgressService();
	try {
	    ps.busyCursorWhile(operation);
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
	return TcsUtil.getSyntaxesInConnectionWithName(conn[0], languageId);
    }

    public static ConcreteSyntax getActiveSyntax(AbstractGrammarBasedEditor grammarBasedEditor) {
	String languageId = grammarBasedEditor.getLanguageId();
	ConcreteSyntax found = getActiveSyntaxByName(grammarBasedEditor.getEditorInput(), languageId);
	return found;
    }

    public static ConcreteSyntax getActiveSyntaxByName(IEditorInput input, String languageId) {
	List<ConcreteSyntax> syntaxesInProject = getSyntaxesInProjectWithName(ModelAdapterUI.getInstance().getProject(input),
		languageId);
	ConcreteSyntax found = null;
	for (ConcreteSyntax syntax : syntaxesInProject) {
	    if (syntax.getName().toLowerCase().equals(languageId.toLowerCase())) {
		if (found != null) {
		    throw new IllegalStateException("Found more than one syntax with id: " + syntax.getName() + "!\n"
			    + "Cannot decide which one to use for current editor!\n" + "Locations are: "
			    + ((Partitionable) found).get___Partition().getPri() + "\nand:"
			    + ((Partitionable) syntax).get___Partition().getPri());
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
	ModelEditor modelEditor = (ModelEditor) ModelManagerUI.getEditorManager().getActiveModelEditor();
	AbstractGrammarBasedEditor agbEditor = (AbstractGrammarBasedEditor) ModelManagerUI.getEditorManager().findEditorPart(
		modelEditor);
	return agbEditor;
    }

    public static class SimpleListContentProvider implements IStructuredContentProvider {

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

    @SuppressWarnings("unchecked")
    public static AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> constructParserFactoryForSyntax(ConcreteSyntax syntax) {
	IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(
		"com.sap.ide.cts.parser.parserFactory");
	if (config != null) {
	    for (IConfigurationElement configElement : config) {
		String languageID = configElement.getAttribute("languageID");
		if (languageID != null && languageID.equals(syntax.getName())) {
		    try {
			return (AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer>) configElement
				.createExecutableExtension("dynamicParserFactoryClass");
		    } catch (CoreException e) {
			throw new RuntimeException("Failed to instatiate ParserFactory", e);
		    }
		}
	    }
	}
	throw new RuntimeException("No Parser Factory registered for syntax: " + syntax.getName());
    }
}
