package com.sap.mi.fwk.ui.internal;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.BaseSelectionListenerAction;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.texteditor.IWorkbenchActionDefinitionIds;

/**
 * Utility base class for an {@link IObjectActionDelegate} for a retarget action
 * (like Copy and Paste), which handles the action handler and keybinding
 * updates. May also be registered directly as a
 * {@link ISelectionChangedListener} on any {@link ISelectionProvider}. The
 * enablements state must be returned in
 * {@link #updateSelection(IStructuredSelection)}.
 * 
 * @author d031150
 * 
 * @see BaseSelectionListenerAction
 * @see IActionBars#setGlobalActionHandler(String, IAction)
 */
public abstract class RetargetSelectionAction extends BaseSelectionListenerAction implements IObjectActionDelegate {

	private final ActionFactory mActionFactory;
	private IWorkbenchPart mTargetPart;
	private IAction mProxyAction;

	/**
	 * Creates an action
	 * 
	 * @param text
	 *            the action text
	 * @param actionDefinitionId
	 *            the defintion id of the global action to handle (e.g.
	 *            {@link IWorkbenchActionDefinitionIds#COPY})
	 * @param factory
	 *            the factory for the global action to handle (e.g.
	 *            {@link ActionFactory#COPY})
	 */
	public RetargetSelectionAction(String text, String actionDefinitionId, ActionFactory factory) {
		super(text);
		mActionFactory = factory;
		setActionDefinitionId(actionDefinitionId);
	}

	/**
	 * Override to determine the enablement state based on the given selection
	 * 
	 * @return whether the action is enabled
	 */
	@Override
	protected abstract boolean updateSelection(IStructuredSelection selection);

	/**
	 * Delegates to {@link #updateSelection(IStructuredSelection)} and calls
	 * {@link #setEnabled(boolean)} with this result.
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		mProxyAction = action;
		boolean enabled;
		if (selection instanceof IStructuredSelection)
			enabled = updateSelection((IStructuredSelection) selection);
		else
			enabled = false;
		setEnabled(enabled);
	}

	/**
	 * Sets the given proxy action's enablement state, updates the target part's
	 * action bars
	 */
	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		if (mProxyAction != null) { // update proxy action
			mProxyAction.setEnabled(enabled);

			if (mTargetPart != null && mActionFactory != null) {
				IWorkbenchPartSite site = mTargetPart.getSite();

				IActionBars bars = null;
				if (site instanceof IViewSite)
					bars = ((IViewSite) site).getActionBars();
				else if (site instanceof IEditorSite)
					bars = ((IEditorSite) site).getActionBars();
				else if (site instanceof IPageSite)
					bars = ((IPageSite) site).getActionBars();
				if (bars != null) {
					bars.setGlobalActionHandler(mActionFactory.getId(), mProxyAction);
					bars.updateActionBars();
				}
			}
		}
	}

	/**
	 * Stores the given part as UI context, and updates the proxy action with
	 * the correct images. Also adds this delegate as selection listener of the
	 * target site since the standard
	 * {@link #selectionChanged(IAction, ISelection)} hook is only called when a
	 * popup menu is to be shown (right mouse click), which is too late to
	 * update the enablements state of our proxy action (and thereby the global
	 * menu). Only called if registered as
	 * {@link IObjectActionDelegate object delegate}.
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		mTargetPart = targetPart;
		if (action != null) {
			action.setActionDefinitionId(getActionDefinitionId());
			action.setDisabledImageDescriptor(getDisabledImageDescriptor());
			action.setImageDescriptor(getImageDescriptor());
		}

		IWorkbenchPartSite site = targetPart.getSite();
		site.getSelectionProvider().addSelectionChangedListener(this);
	}

	/**
	 * Sets the active part for this action. To be called in case this action is
	 * not an {@link IObjectActionDelegate}, but registered as selection
	 * listener in some part.
	 * 
	 * @param targetPart
	 *            the active part
	 */
	public void setActivePart(IWorkbenchPart targetPart) {
		mTargetPart = targetPart;
	}

	/**
	 * Delegates to {@link #run()}
	 */
	public void run(IAction action) {
		run();
	}

	/**
	 * @return this delegate's proxy action. Is <code>null</code> if this
	 *         action is not used as a delegate.
	 */
	protected IAction getProxyAction() {
		return mProxyAction;
	}

	/**
	 * @return this delegate's target part. Is <code>null</code> if this
	 *         action is not used as a delegate.
	 */
	protected IWorkbenchPart getTargetPart() {
		return mTargetPart;
	}

	/**
	 * @return the shell of the current UI context
	 */
	protected Shell getShell() {
		if (mTargetPart != null)
			return mTargetPart.getSite().getShell();
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
	}

}
