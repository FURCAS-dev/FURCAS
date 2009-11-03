package com.sap.mi.tools.diagnostics.internal;

import java.util.TimerTask;

import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.widgets.Control;

import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * Updates the view on a regular basis or on explicit request
 * 
 * @author d031150
 */
public class DiagnosticsUpdater extends TimerTask {
	
	private static final TracerI sTracer = TracingManager.getTracer(MiLocations.MI_DIAGNOSTICS);
	
	private StructuredViewer mViewer;
	private final Runnable mUpdater = new Updater();

	public DiagnosticsUpdater(StructuredViewer viewer) {
		mViewer = viewer;
	}

	@Override
	public void run() {
		sTracer.debug("Update called in thread: " + Thread.currentThread().getName()); //$NON-NLS-1$
		
		Control control = mViewer.getControl();
		if (control.isDisposed()) {
			cancel();
			return;
		}
		
		control.getDisplay().asyncExec(mUpdater);
	}
	
	@Override
	public boolean cancel() {
		sTracer.debug("Update cancelled in thread: " + Thread.currentThread().getName()); //$NON-NLS-1$
		mViewer = null;
		return super.cancel();
	}

	/**
	 * Must be called from the UI thread
	 */
	public void doUpdate() {
		if (mViewer != null && !mViewer.getControl().isDisposed()) {
			sTracer.debug("Refreshing viewer"); //$NON-NLS-1$
			mViewer.refresh(true);
		}
	}

	private final class Updater implements Runnable {
		public void run() {
			doUpdate();
		}
	}

}
