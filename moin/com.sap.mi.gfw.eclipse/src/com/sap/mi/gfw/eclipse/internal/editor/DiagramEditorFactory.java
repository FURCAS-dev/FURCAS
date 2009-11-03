package com.sap.mi.gfw.eclipse.internal.editor;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.operation.ModalContext;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorMatchingStrategy;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.PartInitException;

import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.PartitionService;
import com.sap.mi.fwk.ui.editor.ModelEditorInput;
import com.sap.mi.fwk.ui.editor.ModelObjectElementFactory;
import com.sap.mi.gfw.GfwUtil;
import com.sap.mi.gfw.mm.links.DiagramLink;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.util.PeUtil;
import com.sap.mi.gfw.util.T;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

/**
 * A factory for creating DiagramEditor objects.
 */
public class DiagramEditorFactory extends ModelObjectElementFactory {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.ui.editor.ModelObjectElementFactory#createEditorInput( org.eclipse.ui.IMemento)
	 */
	@Override
	protected ModelEditorInput createEditorInput(IMemento memento) {
		// get diagram element
		String diagramMriString = memento.getString(ModelObjectElementFactory.KEY_MRI);
		if (diagramMriString == null)
			return null;

		// get provider id
		String providerID = memento.getString(DiagramEditorInput.KEY_PROVIDER_ID);
		if (providerID == null)
			return null;

		return new DiagramEditorInput(diagramMriString, providerID);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.ui.editor.ModelObjectElementFactory#createEditorInput( com.sap.tc.moin.repository.mmi.reflect.RefBaseObject)
	 */
	@Override
	public ModelEditorInput createEditorInput(RefBaseObject obj) {
		Diagram diagram = getDiagramFromElement(obj);
		if (diagram == null) {
			T.racer().error("Factory could not retrieve diagram from given object. obj:" + obj); //$NON-NLS-1$
			return null;
		}

		String diagramTypeProviders[] = GfwUtil.getExtensionManager().getDiagramTypeProviderExtensionIds(diagram.getDiagramTypeId());
		if (diagramTypeProviders != null && diagramTypeProviders.length > 0) {
			// TODO handle if more then one DTPs are available
			String providerId = diagramTypeProviders[0];
			return new DiagramEditorInput(diagram, null, providerId);
		}
		T.racer().warning("No diagramTypeProviders found for typeId. Returning null. diagramTypeId:" + diagram.getDiagramTypeId()); //$NON-NLS-1$
		return null;
	}

	@Override
	public ModelEditorInput createEditorInput(IEditorInput otherInput) {
		if (otherInput instanceof IFileEditorInput) {
			IFileEditorInput fileInput = (IFileEditorInput) otherInput;
			IFile file = fileInput.getFile();
			Diagram diagram = getDiagramFromFile(file);
			if (diagram != null) {
				return new DiagramEditorInput(diagram, null, null);
			}
		}

		return super.createEditorInput(otherInput);
	}

	private static Diagram getDiagramFromFile(IFile file) {
		PRI pri = ModelAdapter.getInstance().getPri(file, null);
		if (pri != null) {
			// We use the shared default connection and not new one. Reason is
			// that any new connection would need to be closed again, which
			// would invalidate the returned diagram.
			Connection connection = getDefaultConnectionSync(file.getProject());
			if (connection != null) {
				ModelPartition partition = connection.getPartition(pri);
				if (partition != null) {
					Collection<Partitionable> elements = PartitionService.getInstance().getRootElements(partition);
					for (Partitionable element : elements) {
						Diagram diagram = getDiagramFromElement((RefBaseObject) element);
						if (diagram != null) {
							return diagram;
						}
					}
				}
			}
		}
		return null;
	}

	private static Diagram getDiagramFromElement(RefBaseObject obj) {
		if (obj instanceof Diagram) {
			return (Diagram) obj;
		}
		if (obj instanceof DiagramLink) {
			return ((DiagramLink) obj).getDiagram();
		}
		if (obj instanceof PictogramElement) {
			return PeUtil.getDiagramForPictogramElement((PictogramElement) obj);
		}
		return null;
	}

	/*
	 * Gets the default connection for the project synchronously. Creates one using ModalContext if we're in the UI thread.
	 * 
	 * IMPORTANT: this is not a general purpose pattern and can only be applied if we're in a user-driven flow (e.g. user has invoked an
	 * action). In other flows like a programmatic call or editor restore during workbench startup this would fail or deadlock.
	 */
	private static Connection getDefaultConnectionSync(final IProject project) {
		if (!ModelManager.getInstance().isMoinProject(project))
			return null;

		final ConnectionManager connectionManager = ConnectionManager.getInstance();
		// check for existing default connection
		Connection connection = connectionManager.getExistingDefaultConnection(project);
		if (connection != null) {
			return connection;
		}

		// Create the default connection. Check which thread we're in. UI tread
		// means creating the connection in a background thread.
		if (Display.getCurrent() == null) {
			return connectionManager.getOrCreateDefaultConnection(project);
		}

		final Connection[] conn = new Connection[1];
		try {
			ModalContext.run(new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					conn[0] = connectionManager.getOrCreateDefaultConnection(project);
				}
			}, /* fork */true, new NullProgressMonitor(), Display.getCurrent());
			return conn[0];
		} catch (InvocationTargetException e) { // $JL-EXC$
			throw new IllegalStateException(e.getCause());
		} catch (InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}

	/**
	 * <b>For internal use only</b>. Checks whether any file editor input matches one of the opened editors. Scenario is a user's
	 * double-clicking on a diagram file in the explorer. If done multiple times on the same file, no new editor must be opened.
	 */
	public static final class DiagramEditorMatchingStrategy implements IEditorMatchingStrategy {
		public boolean matches(IEditorReference editorRef, IEditorInput input) {
			try {
				if (input instanceof IFileEditorInput) {
					IFileEditorInput fileInput = (IFileEditorInput) input;
					IFile file = fileInput.getFile();

					// Check whether the gven file contains a diagram as its
					// root element. If yes, compare it with the given editor's
					// diagram.
					IEditorInput editorInput = editorRef.getEditorInput();
					if (editorInput instanceof DiagramEditorInput) {
						DiagramEditorInput diagInput = (DiagramEditorInput) editorInput;

						// We do not compare diagram object but MRIs only.
						// Reason is that if editorRef points to a not yet
						// realized editor, its input's diagram is null (not yet
						// created), thus we can only get its MRI.
						String mriString = diagInput.getMriString();
						MRI mri = ModelManager.getInstance().getMoinInstance().createMri(mriString);
						if (mri != null) {
							Diagram diagram = getDiagramFromFile(file);
							if (diagram != null && diagram.get___Mri().equals(mri)) {
								return true;
							}
						}
					}
				} else if (input instanceof ModelEditorInput) {
					// normal case: check for input equality
					IEditorInput editorInput = editorRef.getEditorInput();
					if (input.equals(editorInput))
						return true;
				}
			} catch (PartInitException e) {
				T.racer().error(e.getMessage(), e);
			}
			return false;
		}
	}

}