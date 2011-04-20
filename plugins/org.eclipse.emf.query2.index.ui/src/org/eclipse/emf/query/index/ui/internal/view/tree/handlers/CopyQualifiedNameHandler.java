package org.eclipse.emf.query.index.ui.internal.view.tree.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query.index.query.descriptors.EObjectDescriptor;
import org.eclipse.emf.query.index.query.descriptors.EReferenceDescriptor;
import org.eclipse.emf.query.index.query.descriptors.ResourceDescriptor;
import org.eclipse.emf.query.index.ui.internal.Activator;
import org.eclipse.emf.query.index.ui.internal.Messages;
import org.eclipse.emf.query.index.ui.internal.view.IndexView;
import org.eclipse.emf.query.index.ui.internal.view.tree.nodes.ResourceType;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Display;

/**
 * @author Animesh Kumar, SAP Labs India Pvt. Ltd.
 * 
 */
public class CopyQualifiedNameHandler implements IHandler {

	public void addHandlerListener(IHandlerListener handlerListener) {

	}

	public void dispose() {

	}

	public Object execute(ExecutionEvent event) throws ExecutionException {
		Object selectedElement = getSelectedElement();
		if (selectedElement == null) {
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, Messages.Query2IndexUI_CopyQualifiedName_NullSelection);
			ErrorDialog.openError(Display.getDefault().getActiveShell(), Messages.Query2IndexUI_CopyQualifiedNameHandler_ErrorStatus,
					Messages.Query2IndexUI_CopyQualifiedNameHandler_SelectionErrorMessage, status);

			return null;
		}

		Object[] data = null;
		Transfer[] dataTypes = null;

		String qualifiedName = getQualifiedName(selectedElement);

		data = new Object[] { qualifiedName };
		dataTypes = new Transfer[] { TextTransfer.getInstance() };

		Clipboard clipboard = new Clipboard(Display.getDefault());
		try {
			clipboard.setContents(data, dataTypes);
		} catch (SWTError e) {
			if (e.code != DND.ERROR_CANNOT_SET_CLIPBOARD) {
				throw e;
			}
			if (MessageDialog.openQuestion(Display.getDefault().getActiveShell(), Messages.Query2IndexUI_CopyQualifiedNameHandler_ErrorStatus,
					Messages.Query2IndexUI_CopyQualifiedNameHandler_UnableToCopyErrorMessage)) {
				clipboard.setContents(data, dataTypes);
			}
		} finally {
			clipboard.dispose();
		}

		return null;
	}

	public Object getSelectedElement() {
		TreeViewer treeViewer = IndexView.getTreeViewer();
		IStructuredSelection selection = (IStructuredSelection) treeViewer.getSelection();
		Object selectedElement = selection.getFirstElement();
		return selectedElement;
	}

	public boolean isEnabled() {
		Object selectedElement = getSelectedElement();
		if (selectedElement instanceof ResourceDescriptor) {
			return true;
		} else if (selectedElement instanceof EObjectDescriptor) {
			return true;
		} else if (selectedElement instanceof EReferenceDescriptor) {
			return true;
		} else if (selectedElement instanceof ResourceType) {
			return true;
		} else if (selectedElement instanceof URI) {
			return true;
		} else {
			return false;
		}

	}

	public boolean isHandled() {
		return true;
	}

	public void removeHandlerListener(IHandlerListener handlerListener) {

	}

	private String getQualifiedName(Object element) {
		if (element instanceof ResourceDescriptor) {
			return ((ResourceDescriptor) element).getURI().toString();
		} else if (element instanceof EObjectDescriptor) {
			EObjectDescriptor eObjectDescriptor = (EObjectDescriptor) element;
			String eClassURI = eObjectDescriptor.getEClassURI() + eObjectDescriptor.getFragment();
			return eClassURI;
		} else if (element instanceof EReferenceDescriptor) {
			EReferenceDescriptor referenceDescriptor = (EReferenceDescriptor) element;
			String referenceURI = referenceDescriptor.getEReferenceURI();
			return referenceURI;
		} else if (element instanceof ResourceType) {
			Object elementType = ((ResourceType) element).getElementType();
			return elementType.toString();
		} else if (element instanceof URI) {
			return element.toString();
		}
		return null;
	}

}
