package com.sap.furcas.ide.editor;

import java.util.List;

import org.antlr.runtime.Lexer;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import com.sap.furcas.ide.parserfactory.AbstractParserFactory;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.tcs.TcsUtil;


public class EditorUtil {
    
    public static ConcreteSyntax loadConcreteSyntax(AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory) {
        ResourceSet resourceSet = new ResourceSetImpl();
        resourceSet.getResource(parserFactory.getSyntaxUri(), /*load*/ true);
        return TcsUtil.getSyntaxByName(resourceSet, parserFactory.getLanguageId());
    }

    public static AbstractGrammarBasedEditor getCurrentEditor() {
        IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        if(activeEditor instanceof AbstractGrammarBasedEditor) {
            return (AbstractGrammarBasedEditor) activeEditor;
        } else {
            return null;
        }
    }

    public static class SimpleListContentProvider implements IStructuredContentProvider {

	private final List<?> _contents;

	public SimpleListContentProvider(List<?> contents) {
	    _contents = contents;
	}

	/**
	 * Implements IStructuredContentProvider.
	 *
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(Object)
	 */
	@Override
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
	@Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	    // do nothing
	}

	/**
	 * Implements IContentProvider.
	 *
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	@Override
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
