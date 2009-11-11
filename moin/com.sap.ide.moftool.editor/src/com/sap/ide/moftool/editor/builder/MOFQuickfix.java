package com.sap.ide.moftool.editor.builder;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.DataType;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;

import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.MarkerManager;
import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.ui.CommandManager;
import com.sap.mi.fwk.ui.ConnectionManagerUI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.commands.PartitionOperation.Operation;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * Quickfix implementation for MOF constraint violation C-16 AbstractClassesCannotBeSingleton. This Quickfix either removes the singleton,
 * the abstract, or both attributes.
 * 
 * @author d024127
 */

public class MOFQuickfix implements IMarkerResolution {

	private static final TracerI sTracer = TracingManager.getTracer(MiLocations.MI_OCL);

	public static final int REMOVE_SINGLETON = 1 << 1;
	public static final int REMOVE_ABSTRACT = 1 << 2;
	public static final int SET_ROOT_AND_LEAF = 1 << 3;

	private final int type;

	protected MOFQuickfix(int type) {
		this.type = type;
	}

	public String getLabel() {
		switch (type) {
		case REMOVE_ABSTRACT:
			return LocalizationMessages.MOFQuickfix_0_XMSG;

		case REMOVE_SINGLETON:
			return LocalizationMessages.MOFQuickfix_1_XMSG;

		case REMOVE_ABSTRACT | REMOVE_SINGLETON:
			return LocalizationMessages.MOFQuickfix_2_XMSG;

		case SET_ROOT_AND_LEAF:
			return LocalizationMessages.MOFQuickfix_3_XMSG;

		default:
			throw new IllegalStateException("Unrecognized type:" + type); //$NON-NLS-1$
		}
	}

	public void run(IMarker marker) {
		if (!marker.exists()) {
			return;
		}
		IProject project = marker.getResource().getProject();
		Connection con = null;
		try {
			con = createConnection(project);
			RefBaseObject obj = MarkerManager.getInstance().getObject(con, marker);
			if (obj instanceof GeneralizableElement) {

				PRI pri = ((Partitionable) obj).get___Partition().getPri();
				PartitionOperation editOperation = new PartitionOperation(Operation.EDIT, pri);

				// IStatus status =
				// ModelManagerUI.getCommandManager().openCommandGroup(con,
				// "Setting class attributes",
				// Collections.singleton(editOperation));

				IStatus status = CommandManager.getInstance().prepareExecution(con, Collections.singleton(editOperation));
				if (status.isOK()) {
					con.getCommandStack().openGroup(LocalizationMessages.MOFQuickfix_5_XMSG);
					GeneralizableElement element = (GeneralizableElement) obj;

					if ((type & REMOVE_ABSTRACT) == REMOVE_ABSTRACT) {
						element.setAbstract(false);
					}

					if ((type & REMOVE_SINGLETON) == REMOVE_SINGLETON && element instanceof MofClass) {
						((MofClass) element).setSingleton(false);
					}

					if ((type & SET_ROOT_AND_LEAF) == SET_ROOT_AND_LEAF
							&& (element instanceof MofPackage || element instanceof Association || element instanceof DataType)) {
						element.setRoot(true);
						element.setLeaf(true);
					}

					// ModelManagerUI.getCommandManager().closeCommandGroup(con);
					con.getCommandStack().closeGroup();
					IStatus result = ConnectionManagerUI.getInstance().save(con, null);
					if (!result.isOK()) {
						sTracer.error("Exception while fixing constraint violation: " + result.getMessage(), //$NON-NLS-1$
								result.getException());
					} else {
						ModelManager.getMarkerManager().deleteMarker(marker);
					}
				}
			}
		} catch (InterruptedException e) {
			sTracer.warning("User canceled quick fix execution"); //$NON-NLS-1$
		} catch (Exception e) {
			sTracer.error("Exception while fixing constraint violation:", e); //$NON-NLS-1$
			MessageDialog.openError(Display.getCurrent().getActiveShell(), LocalizationMessages.MOFQuickfix_errorTitle,
					LocalizationMessages.MOFQuickfix_errorMsg);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	private Connection createConnection(final IProject project) throws InvocationTargetException, InterruptedException {

		// connection has to be created
		final Connection[] connections = new Connection[1];

		// create runnable
		IRunnableWithProgress operation = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
				// running in non UI thread
				monitor.beginTask(LocalizationMessages.MOFQuickfix_gettingConnection, 1);
				connections[0] = ConnectionManager.getInstance().createConnection(project);
				if (monitor.isCanceled()) {
					throw new InterruptedException();
				}
				connections[0].setLabel("MOF Quickfix"); //$NON-NLS-1$
				monitor.done();
			}
		};

		IProgressService ps = PlatformUI.getWorkbench().getProgressService();
		ps.busyCursorWhile(operation);
		return connections[0];
	}
}