package com.sap.mi.fwk.ui.dnd;

import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionGroup;

import com.sap.mi.fwk.ui.internal.dnd.CopyObjectsAction;
import com.sap.mi.fwk.ui.internal.dnd.PasteObjectsAction;

/**
 * Action group comprising copy and paste actions
 * 
 * @author d031150
 */
public final class CopyPasteActionGroup extends ActionGroup {

	private final ISelectionProvider mSelProvider;
	private final CopyObjectsAction mCopyAction;
	private final PasteObjectsAction mPasteAction;
	private final DisposeListener mActionDisposeListener = new ActionDisposeListener();

	/**
	 * Creates an action group using the given part's site selection provider to
	 * update this group's actions
	 * 
	 * @param part
	 *            a workbench part
	 * 
	 * @see #CopyPasteActionGroup(ISelectionProvider)
	 */
	public CopyPasteActionGroup(IWorkbenchPart part) {
		this(part.getSite().getSelectionProvider());
		mCopyAction.setActivePart(part);
		mPasteAction.setActivePart(part);
	}

	/**
	 * Creates an action group using the given selection provider to update this
	 * group's actions
	 * 
	 * @param provider
	 *            a selection provider
	 * 
	 * @see #CopyPasteActionGroup(IWorkbenchPart)
	 * 
	 */
	public CopyPasteActionGroup(ISelectionProvider provider) {
		if (provider == null) {
			throw new IllegalArgumentException("Selection provider must not be null"); //$NON-NLS-1$
		}
		mSelProvider = provider;
		mCopyAction = new CopyObjectsAction();
		mPasteAction = new PasteObjectsAction();
		registerAction(mCopyAction, mSelProvider);
		registerAction(mPasteAction, mSelProvider);

		if (provider instanceof Viewer) {
			Viewer viewer = (Viewer) provider;
			hookDispose(viewer);
		}
	}

	/**
	 * Fills the given menu manager's menu with actions, appending them at the
	 * current end of the menu
	 * 
	 * @param manager
	 *            the menu
	 * 
	 * @see #fillContextMenu(IMenuManager, String)
	 */
	@Override
	public void fillContextMenu(IMenuManager manager) {
		fillContextMenu(manager, null);
	}

	/**
	 * Fills the given menu manager's menu with actions, appending them to the
	 * given group. If the group doesn't exist, it is created.
	 * 
	 * @param manager
	 *            the menu
	 * @param groupName
	 *            the group to append the actions to or <code>null</code>
	 * 
	 * @see #fillContextMenu(IMenuManager)
	 */
	public void fillContextMenu(IMenuManager manager, String groupName) {
		if (groupName != null) {
			IContributionItem group = manager.find(groupName);
			if (group != null && group.isGroupMarker()) {
				manager.appendToGroup(groupName, mCopyAction);
				manager.appendToGroup(groupName, mPasteAction);
				return;
			}
			manager.add(new Separator(groupName));
		}
		manager.add(mCopyAction);
		manager.add(mPasteAction);
	}

	/**
	 * Registers this group's actions as global action handlers
	 */
	@Override
	public void fillActionBars(IActionBars actionBars) {
		actionBars.setGlobalActionHandler(ActionFactory.COPY.getId(), mCopyAction);
		actionBars.setGlobalActionHandler(ActionFactory.PASTE.getId(), mPasteAction);
		actionBars.updateActionBars();
	}

	/**
	 * Disposes this group. Unless this group was initialized with a viewer as
	 * selection provider, this method must be called from clients when this
	 * group's action become obsolete.
	 */
	@Override
	public void dispose() {
		disposeAction(mCopyAction, mSelProvider);
		disposeAction(mPasteAction, mSelProvider);
		super.dispose();
	}

	CopyObjectsAction getCopyAction() {
		return mCopyAction;
	}

	PasteObjectsAction getPasteAction() {
		return mPasteAction;
	}

	private void hookDispose(Viewer viewer) {
		Control control = viewer.getControl();
		if (control != null && !control.isDisposed()) {
			control.addDisposeListener(mActionDisposeListener);
		}
	}

	private void registerAction(ISelectionChangedListener action, ISelectionProvider provider) {
		provider.addSelectionChangedListener(action);
		// set initial selection
		ISelection selection = provider.getSelection();
		SelectionChangedEvent event = new SelectionChangedEvent(provider, selection != null ? selection : StructuredSelection.EMPTY);
		action.selectionChanged(event);
	}

	private void disposeAction(ISelectionChangedListener action, ISelectionProvider provider) {
		if (action != null) {
			provider.removeSelectionChangedListener(action);
		}
	}

	private final class ActionDisposeListener implements DisposeListener {
		public void widgetDisposed(DisposeEvent e) {
			dispose();
		}
	}

}
