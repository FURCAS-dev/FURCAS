/**
 * 
 */
package com.sap.mi.tools.cockpit.editor.action;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;

import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.tools.cockpit.editor.MOINBrowser;
import com.sap.mi.tools.cockpit.editor.Messages;
import com.sap.mi.tools.cockpit.editor.model.ProjectRootNode;
import com.sap.mi.tools.cockpit.editor.model.RefObjectNodeSearcher;
import com.sap.mi.tools.cockpit.editor.provider.MOINBrowserContentProvider;
import com.sap.mi.tools.cockpit.editor.ui.MOINBrowserView;
import com.sap.mi.tools.cockpit.editor.ui.dialog.select.SelectRefObjectDialog;
import com.sap.tc.moin.repository.Partitionable;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;
import com.tssap.util.ui.dialog.ExtendedMessageDialog;

/**
 * @author d003456
 * 
 */
public class OpenObjectAction extends Action {

	private static final TracerI tracer = TracingManager.getTracer(MiLocations.MI_MODELBROWSER);

	private final static String CONTENT_PROVIDER_NULL_MSG = Messages.OpenObjectAction_0_xmsg;

	private final static String ERROR_DIALOG_TITLE = Messages.OpenObjectAction_1_xhed;

	private final static String ERROR_GET_OR_CREATE_CONNECTION = Messages.OpenObjectAction_2_xmsg;

	private final static String OPEN_OBJECT_DIALOG_TITLE = Messages.OpenObjectAction_3_xhed;

	private final static String CREATE_CONNECTION_DIALOG_TITLE = Messages.OpenObjectAction_4_xhed;

	private final static String CREATE_CONNECTIONS_DIALOG_TITLE = Messages.OpenObjectAction_5_xhed;

	private final static String OPEN_OBJECT_MENU_ENTRY = Messages.OpenObjectAction_6_xmen;

	private final static String OPEN_OBJECT_TOOLTIP = Messages.OpenObjectAction_7_xtol;

	private final MOINBrowserView viewer;

	/**
	 * @param viewer
	 */
	public OpenObjectAction(MOINBrowserView viewer) {

		super(OpenObjectAction.class.getName());
		Assert.isNotNull(viewer);
		this.viewer = viewer;
		setText(OpenObjectAction.OPEN_OBJECT_MENU_ENTRY);
		setToolTipText(OpenObjectAction.OPEN_OBJECT_TOOLTIP);
		setImageDescriptor(MOINBrowser.getDefault().getImageDescriptor(MOINBrowser.OPEN_TYPE_IMAGE));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {

		final IContentProvider conProv = this.viewer.getTreeViewer().getContentProvider();
		final RefObjectNodeSearcher refObjectNodeSearcher = new RefObjectNodeSearcher(this.viewer);
		if (conProv == null) {
			String msg = ""; //$NON-NLS-1$
			if (OpenObjectAction.tracer.debug()) {
				msg = OpenObjectAction.CONTENT_PROVIDER_NULL_MSG;
			}
			ExtendedMessageDialog.showError(Display.getCurrent().getActiveShell(), OpenObjectAction.ERROR_DIALOG_TITLE,
					OpenObjectAction.CONTENT_PROVIDER_NULL_MSG, null, new String[] { IDialogConstants.OK_LABEL });
			OpenObjectAction.tracer.debug(RefObjectNodeSearcher.class, "findProjectRootNode", msg); //$NON-NLS-1$
		} else {
			final List<ProjectRootNode> rootNodes = ((MOINBrowserContentProvider) conProv).getRootNodes();
			try {
				getOrCreateDefaultConnections(rootNodes);
			}
			catch (final Exception e) {
				ExtendedMessageDialog.showError(Display.getCurrent().getActiveShell(), OpenObjectAction.ERROR_GET_OR_CREATE_CONNECTION, e
						.getMessage(), null, new String[] { IDialogConstants.OK_LABEL }, e);
				OpenObjectAction.tracer.error(OpenObjectAction.class, "run", OpenObjectAction.ERROR_GET_OR_CREATE_CONNECTION, e); //$NON-NLS-1$
			}

			final SelectRefObjectDialog dialog = new SelectRefObjectDialog(Display.getCurrent().getActiveShell(), false, rootNodes);
			dialog.setTitle(OpenObjectAction.OPEN_OBJECT_DIALOG_TITLE);
			dialog.setImage(MOINBrowser.getDefault().getImage(MOINBrowser.TYPES_IMAGE));

			if (dialog.open() == Window.OK) {
				final Partitionable element = (Partitionable) dialog.getFirstResult();
				refObjectNodeSearcher.revealRefObjectNodeinModelTree((RefObject) element);
			}
		}
	}

	private void getOrCreateDefaultConnections(final List<ProjectRootNode> rootNodes) throws InvocationTargetException,
			InterruptedException {

		final IRunnableWithProgress operation = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {

				if (monitor != null) {
					if (rootNodes.size() == 1) {
						monitor.beginTask(OpenObjectAction.CREATE_CONNECTION_DIALOG_TITLE, IProgressMonitor.UNKNOWN);
					} else {
						monitor.beginTask(OpenObjectAction.CREATE_CONNECTIONS_DIALOG_TITLE, IProgressMonitor.UNKNOWN);
					}
					int i = 1;
					for (final Iterator<ProjectRootNode> iterator = rootNodes.iterator(); iterator.hasNext();) {
						final ProjectRootNode projectRootNode = iterator.next();
						monitor.subTask("Connection (" + i + ")"); //$NON-NLS-1$ //$NON-NLS-2$
						ConnectionManager.getInstance().getOrCreateDefaultConnection(projectRootNode.getValue());
						i = i + 1;
					}
					monitor.done();
				}
			}
		};

		final IProgressService ps = PlatformUI.getWorkbench().getProgressService();
		ps.busyCursorWhile(operation);
	}
}
