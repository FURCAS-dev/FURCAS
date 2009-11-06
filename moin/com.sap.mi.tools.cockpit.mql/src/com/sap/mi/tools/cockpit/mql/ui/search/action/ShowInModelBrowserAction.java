package com.sap.mi.tools.cockpit.mql.ui.search.action;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.tools.cockpit.mql.Messages;
import com.sap.mi.tools.cockpit.mql.QueryConsole;
import com.sap.mi.tools.cockpit.mql.ui.search.MQLCellData;
import com.sap.mi.tools.cockpit.mql.ui.search.MQLSearchResultPage;
import com.sap.mi.tools.cockpit.mql.ui.search.selectionprovider.SelectionProviderIntermediate;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mql.MQLColumnType;
import com.sap.tc.moin.repository.mql.MQLResultException;

/**
 * Instantiates {@link RefObject} from selected {@link MRI}, if it is element of a {@link IProject} with MOIN <code>nature</code>. Model
 * Browser <code>MOINBrowserView</code> receives {@link RefObject} while listening to selection provider
 * {@link SelectionProviderIntermediate}.
 * 
 * @author d003456
 * 
 */
public final class ShowInModelBrowserAction extends Action {

	private static final Logger tracer = Logger.getLogger(MiLocations.MI_MQLVIEW);

	private final static String SHOW_IN_MODEL_BROWSER_ACTION_LABEL = Messages.ShowInModelBrowserAction_0_xmit;

	private final static String MODEL_BROWSER_ID = "com.sap.mi.tools.cockpit.editor.ui.MOINBrowserView"; //$NON-NLS-1$

	private final static String ERROR_DIALOG_TITLE = Messages.ShowInModelBrowserAction_1_xhed;

	private final static String ERROR_MESSAGE_PART_INIT_EXCEPTION = Messages.ShowInModelBrowserAction_2_xmsg;

	private final static String ERROR_MESSAGE_MODEL_BROWSER_NOT_SHOWN = Messages.ShowInModelBrowserAction_3_xmsg;

	private final static String ERROR_MESSAGE_REFOBJECT_NOT_IN_PROJECT = Messages.ShowInModelBrowserAction_4_xmsg;

	private final static String ERROR_MESSAGE_REFOBJECT_NOT_INSTANTIATED = Messages.ShowInModelBrowserAction_5_xmsg;

	private final static String ERROR_MESSAGE_REFOBJECT_NOT_ALIVE = Messages.ShowInModelBrowserAction_6_xmsg;

	private final MQLSearchResultPage page;

	/**
	 * Creates {@link ShowInModelBrowserAction}.
	 * 
	 * @param page
	 *            the {@link MQLSearchResultPage} page
	 */
	public ShowInModelBrowserAction(MQLSearchResultPage page) {

		super(ShowInModelBrowserAction.SHOW_IN_MODEL_BROWSER_ACTION_LABEL);
		Assert.isNotNull(page);
		this.page = page;
		setText(ShowInModelBrowserAction.SHOW_IN_MODEL_BROWSER_ACTION_LABEL);
		setImageDescriptor(QueryConsole.getDefault().getImageDescriptor(QueryConsole.MOIN_BROWSER_IMAGE));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {

		final List<RefObject> refObjs = new ArrayList<RefObject>();
		final Iterator<?> iter = getSelection();
		getRefObjects(refObjs, iter, getMriIndex());

		if (checkProjectForRefObject(refObjs)) {
			final IWorkbenchPage wPage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			IViewPart part = null;
			try {
				part = wPage.showView(ShowInModelBrowserAction.MODEL_BROWSER_ID);
			}
			catch (final PartInitException e) {
				ShowInModelBrowserAction.tracer.log(Level.SEVERE, e.getMessage(), e);
				MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
						ShowInModelBrowserAction.ERROR_DIALOG_TITLE, ShowInModelBrowserAction.ERROR_MESSAGE_PART_INIT_EXCEPTION);
			}
			if (part != null) {
				final IStructuredSelection selection = new StructuredSelection(refObjs.toArray());
				this.page.setRefObjectSelectionProviderAdapter();
				this.page.getSelectionProviderMediator().setSelection(selection);
				this.page.getSelectionProviderMediator().fireSelectionChanged(selection);
				this.page.setSelectionChangedProviderAdapter();
			} else {
				MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
						ShowInModelBrowserAction.ERROR_DIALOG_TITLE, ShowInModelBrowserAction.ERROR_MESSAGE_MODEL_BROWSER_NOT_SHOWN);
			}
		} else {
			MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
					ShowInModelBrowserAction.ERROR_DIALOG_TITLE, ShowInModelBrowserAction.ERROR_MESSAGE_REFOBJECT_NOT_IN_PROJECT);
		}
	}

	private boolean checkProjectForRefObject(List<RefObject> refObjs) {

		IProject project = null;
		if (refObjs != null && !refObjs.isEmpty()) {
			final Connection connection = ((Partitionable) refObjs.get(0)).get___Connection();
			project = ModelAdapter.getInstance().getProject(connection);
		}
		return project != null && project.exists() && project.isAccessible();

	}

	@SuppressWarnings("unchecked")
	private void getRefObjects(List<RefObject> refObjs, Iterator<?> iter, int mriIndex) {

		while (iter.hasNext()) {
			final ArrayList<MQLCellData> row = (ArrayList<MQLCellData>) iter.next();
			try {
				final RefObject refObj = getRefObject(row.get(mriIndex));
				if (((Partitionable) refObj).is___Alive()) {
					refObjs.add(refObj);
				} else {
					MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
							ShowInModelBrowserAction.ERROR_DIALOG_TITLE, MessageFormat.format(
									ShowInModelBrowserAction.ERROR_MESSAGE_REFOBJECT_NOT_ALIVE, new Object[] { getName(refObj) }));
				}
			}
			catch (final Exception e) {
				ShowInModelBrowserAction.tracer.log(Level.SEVERE, e.getMessage(), e);
				MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
						ShowInModelBrowserAction.ERROR_DIALOG_TITLE, ShowInModelBrowserAction.ERROR_MESSAGE_REFOBJECT_NOT_INSTANTIATED);
			}
		}
	}

	private int getMriIndex() {

		final MQLColumnType[] columns = this.page.getInput().getResult().getQueryColumnTypes();
		int mriIndex = 0;
		for (int i = 0; i < columns.length; i++) {
			if (columns[i].attribute == null) {
				mriIndex = i;
				break;
			}
		}
		return mriIndex;

	}

	private Iterator<?> getSelection() {

		final ISelection selection = this.page.getViewer().getSelection();

		if (selection instanceof IStructuredSelection) {
			return ((IStructuredSelection) selection).iterator();
		}
		return Collections.EMPTY_LIST.iterator();

	}

	private RefObject getRefObject(MQLCellData cell) throws MQLResultException {

		RefObject result = null;

		if (cell.isMRI()) {
			result = this.page.getInput().getResult().getRefObject(cell.getRowIndex(), cell.getAlias());
		}
		return result;

	}

	private String getName(RefObject element) {

		return ((ModelElement) element.refMetaObject()).getName();

	}

}
