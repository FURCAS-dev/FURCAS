package com.sap.mi.fwk.ui.internal;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorLauncher;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.EditorPart;

import com.sap.mi.fwk.IRunnableWithConnection;
import com.sap.mi.fwk.MarkerManager;
import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.ui.ConnectionManagerUI;
import com.sap.mi.fwk.ui.ModelManagerUI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.Partitionable;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * This class is used to launch other editors based on marker entries in the
 * Eclipse problems view. The editor will not appear but rather analyze the
 * marker handed over via the <code>gotoMarker</code> method. The editor id must
 * be present in the marker and will be used to launch the actual editor. The
 * class extends {@link EditorPart} rather than implementing
 * {@link IEditorLauncher} since only editors can receive markers by
 * implementing {@link IGotoMarker}.
 * 
 * @author d024127
 * @see IGotoMarker
 * @see IEditorLauncher
 */
public final class ModelEditorLauncher extends EditorPart implements IGotoMarker {

	private static final TracerI sTracer = TracingManager.getTracer(MiLocations.MI_EDITORS);

	@Override
	public void createPartControl(Composite parent) {
		// silent editor -> do nothing
	}

	/**
	 * Takes a marker and determines the editor id using the
	 * ModelEditorRegistry.
	 * 
	 * @see IGotoMarker#gotoMarker(IMarker)
	 */
	public void gotoMarker(final IMarker marker) {
		try {
			IRunnableWithConnection runnable = new IRunnableWithConnection() {
				public void run(Connection connection, IProgressMonitor monitor) {
					startEditor(connection, marker);
				}
			};
			Connection connection = ConnectionManagerUI.getInstance().getOrCreateDefaultConnectionAsync(marker.getResource().getProject(),
					runnable);
			if (connection != null) {
				startEditor(connection, marker);
			}

		} catch (Exception ex) {
			sTracer.error("Could not open editor for marker: " + marker, ex); //$NON-NLS-1$
		} finally {
			// close this editor w/o saving
			// this should happen fast enough so editor won't be noticed by user
			getEditorSite().getPage().closeEditor(this, false);
		}
	}

	private void startEditor(Connection connection, IMarker marker) {
		try {
			String objMRI = marker.getAttribute(MarkerManager.ATTRIBUTE_OBJ_MRI, null);
			MRI mri = ModelManager.getInstance().getMoinInstance().createMri(objMRI);
			RefBaseObject obj = connection.getElement(mri);
			if (obj == null) {
				sTracer.error("Model element with the given mri does not exist. mri:" + objMRI); //$NON-NLS-1$
				return;
			}

			IEditorPart part = ModelManagerUI.getEditorManager().openEditor(obj);
			if (part != null) {
				IDE.gotoMarker(part, marker);
				return;
			}

			String objName = ModelManager.getInstance().getObjectName(obj);
			sTracer.error("No editor registered for object. object: " + objName + ", className: " //$NON-NLS-1$ //$NON-NLS-2$
					+ ((Partitionable) obj).get___JmiInterface());
		} catch (Exception ex) {
			sTracer.error("Could not open editor for marker: " + marker, ex); //$NON-NLS-1$
		}
	}

	public ModelEditorLauncher() {
		super();
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		throw new UnsupportedOperationException("This method must not be called"); //$NON-NLS-1$
	}

	@Override
	public void doSaveAs() {
		throw new UnsupportedOperationException("This method must not be called"); //$NON-NLS-1$
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		setSite(site);
		setInput(input);
	}

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public void setFocus() {
	}
}
