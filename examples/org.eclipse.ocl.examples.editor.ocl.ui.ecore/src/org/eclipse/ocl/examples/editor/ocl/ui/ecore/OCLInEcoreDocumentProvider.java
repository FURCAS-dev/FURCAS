package org.eclipse.ocl.examples.editor.ocl.ui.ecore;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.editors.text.FileDocumentProvider;

public class OCLInEcoreDocumentProvider extends FileDocumentProvider
{
	private final class MyOCLInEcoreSynchronizer extends OCLInEcoreSynchronizer
	{
		private final IDocument document;

		private MyOCLInEcoreSynchronizer(IDocument document) {
			this.document = document;
		}

		@Override
		protected void updateDocument(final String newText) {
			final Display display = editor.getDisplay();
			if (display != null) {
				if (display.getThread() == Thread.currentThread()) {
					String oldText = document.get();
					if (!newText.equals(oldText)) {
						document.set(newText);
					}
				}
				else {
					display.asyncExec(new Runnable() {
						public void run() {
							if (!display.isDisposed()) {
								String oldText = document.get();
								if (!newText.equals(oldText)) {
									document.set(newText);
								}
							}
						}
					});
				}
			}
		}
	}

	protected final IOCLInEcoreEditor editor;
	
	public OCLInEcoreDocumentProvider(IOCLInEcoreEditor editor) {
		this.editor = editor;		
	}
	
	@Override
	public boolean canSaveDocument(Object element) {
		// TODO Auto-generated method stub
		return super.canSaveDocument(element);
	}
	
	@Override
	public void setCanSaveDocument(Object element) {
		// TODO Auto-generated method stub
		super.setCanSaveDocument(element);
	}

	@Override
	protected void disposeElementInfo(Object element, ElementInfo info) {
		// TODO Auto-generated method stub
		super.disposeElementInfo(element, info);
	}

	@Override
	protected void handleElementContentChanged(
			IFileEditorInput fileEditorInput) {
		// TODO Auto-generated method stub
		super.handleElementContentChanged(fileEditorInput);
	}

	@Override
	protected void handleElementMoved(IFileEditorInput fileEditorInput,
			IPath path) {
		// TODO Auto-generated method stub
		super.handleElementMoved(fileEditorInput, path);
	}

	@Override
	protected void handleElementDeleted(IFileEditorInput fileEditorInput) {
		// TODO Auto-generated method stub
		super.handleElementDeleted(fileEditorInput);
	}

	@Override
	protected void doSaveDocument(IProgressMonitor monitor, Object element,
			IDocument document, boolean overwrite) throws CoreException {
/*		OCLInEcoreExporter exporter = new OCLInEcoreExporter(editor.getParseController());
		Collection<Resource> resources = exporter.export();
		if (resources != null) {
			for (Resource resource : resources) {
				try {
					monitor.subTask("Saving " + resource.getURI());
					resource.save(null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally {
					monitor.done();
				}
			}
		} */
	}
	
	@Override
	protected void doResetDocument(Object element, IProgressMonitor monitor)
			throws CoreException {
		// TODO Auto-generated method stub
		super.doResetDocument(element, monitor);
	}

	@Override
	protected boolean setDocumentContent(final IDocument document,
			IEditorInput editorInput, String encoding) throws CoreException {
		URI uri = EditUIUtil.getURI(editorInput);
		ResourceSet resourceSet = editor.getResourceSet();		
		Resource resource = resourceSet.getResource(uri, true);
		try {
			resource.load(null);
			resource.setTrackingModification(true);
			OCLInEcoreSynchronizer annotationSynchronizer = new MyOCLInEcoreSynchronizer(document);
			resourceSet.eAdapters().add(annotationSynchronizer);
			annotationSynchronizer.importFromResources();
		} catch (IOException e) {
			IStatus iStatus = new Status(IStatus.ERROR, OCLInEcorePlugin.kPluginID, "Failed to open", e);
			throw new CoreException(iStatus);
		}
		return true;
	}
}