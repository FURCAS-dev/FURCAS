package org.eclipse.emf.query2.internal.ui.handlers;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.ide.IDE;
import org.eclipse.xtext.resource.DefaultLocationInFileProvider;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.XtextReadonlyEditorInput;
import org.eclipse.xtext.util.TextLocation;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

public class OpenQueryInEditor extends AbstractHandler {

	protected ILocationInFileProvider locationProvider = new DefaultLocationInFileProvider();

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		if (selection != null & selection instanceof IStructuredSelection) {
			IStructuredSelection strucSelection = (IStructuredSelection) selection;
			for (Iterator<Object> iterator = strucSelection.iterator(); iterator.hasNext();) {
				Object element = iterator.next();
				if (element instanceof URI) {
					URI uri = (URI) element;
					doOpen(uri);
				}
			}
		}
		return null;
	}

	public void doOpen(final URI uri) {
		IFile file = getContainingResourceSetFile(uri);
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorPart openEditor = null;
		try {
			if (file != null) {
				openEditor = IDE.openEditor(page, file);
			} else if (uri.isArchive()) {
				// TODO don't fall back to java.io
				IEditorInput input = new XtextReadonlyEditorInput(file);
				openEditor = IDE.openEditor(page, input, PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(uri.lastSegment()).getId());
			} else {
				// fall back: URI is bundle resource uri and has to converted,
				// or http uri
				URL url = FileLocator.toFileURL(new URL(uri.scheme() + ":" + uri.devicePath())); //$NON-NLS-1$
				URI urlAsUri = URI.createURI(url.toString());
				String path = urlAsUri.toFileString();
				if (path != null) {
					IEditorInput input = new XtextReadonlyEditorInput(file);
					openEditor = IDE.openEditor(page, input, PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(uri.lastSegment()).getId());
				}
			}
		} catch (PartInitException partInitException) {
			partInitException.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (openEditor != null && openEditor instanceof XtextEditor) {
			final XtextEditor edit = (XtextEditor) openEditor;
			if (uri.fragment() != null) {
				edit.getDocument().readOnly(new IUnitOfWork.Void<XtextResource>() {

					public void process(XtextResource resource) throws Exception {
						EObject object = resource.getEObject(uri.fragment());
						TextLocation region = locationProvider.getLocation(object);
						edit.selectAndReveal(region.getOffset(), region.getLength());
					}
				});
			}
		}
		// else if (openEditor instanceof EcoreEditor) {
		// EcoreEditor ecoreEditor = (EcoreEditor)openEditor;
		// // set selection
		// EditingDomain editingDomain = ecoreEditor.getEditingDomain();
		// EObject editObject = editingDomain.getResourceSet().getEObject(uri,
		// true);
		// if (editObject != null) {
		// ecoreEditor.setSelectionToViewer(Collections.singleton(editObject));
		// }
		// }
		else if (openEditor instanceof ISelectionProvider) {
			// TODO: use ISelectionProvider instead of ITextEditor
		}
	}

	private IFile getContainingResourceSetFile(URI uri) {
		String path = null;
		if (uri.isPlatformResource()) {
			path = uri.toPlatformString(true);
		} else if (uri.isPlatformPlugin()) {
			path = uri.toPlatformString(true);
		} else if (uri.isFile()) {
			path = uri.toFileString();
		} else if (uri.isArchive()) {
			URI archiveUri = URI.createURI(uri.authority());
			String archive = null;
			if (archiveUri.isFile()) {
				archive = archiveUri.toFileString();
			} else if (archiveUri.isPlatformResource()) {
				archive = archiveUri.toPlatformString(true);
			} else {
				archive = archiveUri.toString();
			}
			path = uri.scheme() + ":" + archive + uri.path(); //$NON-NLS-1$
		} else {
			path = uri.toString();
		}
		IFile result = null;
		if (uri.isPlatformResource()) {
			result = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(path));
		} else {
			result = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(new Path(path));
			if (result == null) {
				IResource res = ResourcesPlugin.getWorkspace().getRoot().findMember(path);
				if (res != null && (res instanceof IFile))
					result = (IFile) res;
			}
		}
		return result;
	}

}
