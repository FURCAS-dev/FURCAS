package org.eclipse.emf.query.index.ui.internal.view.tree.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.emf.query.index.query.descriptors.EObjectDescriptor;
import org.eclipse.emf.query.index.query.descriptors.EReferenceDescriptor;
import org.eclipse.emf.query.index.query.descriptors.ResourceDescriptor;
import org.eclipse.emf.query.index.ui.internal.properties.IndexViewProperty;
import org.eclipse.emf.query.index.ui.internal.view.IndexView;
import org.eclipse.emf.query.index.ui.internal.view.tree.nodes.IndexTypeURI;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;

/**
 * @author Animesh Kumar, SAP Labs India Pvt. Ltd.
 * 
 */
public class OpenResourceinEditorHandler implements IHandler {

	public void addHandlerListener(IHandlerListener handlerListener) {

	}

	public void dispose() {

	}

	public Object execute(ExecutionEvent event) throws ExecutionException {
		IndexView.openInEditor(getSelectedElement());
		return null;
	}

	public boolean isEnabled() {
		Object selectedElement = getSelectedElement();
		if (selectedElement instanceof ResourceDescriptor || selectedElement instanceof EObjectDescriptor || selectedElement instanceof EReferenceDescriptor || selectedElement instanceof IndexViewProperty) {
			return true;
		} else if (selectedElement instanceof IndexTypeURI) {
			return true;
		} else {
			return false;
		}
	}

	public Object getSelectedElement() {
		TreeViewer treeViewer = IndexView.getTreeViewer();
		IStructuredSelection selection = (IStructuredSelection) treeViewer.getSelection();
		Object selectedElement = selection.getFirstElement();
		return selectedElement;
	}

	public boolean isHandled() {
		return true;
	}

	public void removeHandlerListener(IHandlerListener handlerListener) {

	}

}
