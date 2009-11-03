package com.sap.mi.tools.diagnostics.internal.actions;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonMenuConstants;
import org.eclipse.ui.navigator.ICommonViewerSite;

/**
 * Supplies the view's actions
 * 
 * @author d031150
 */
public class DiagnosticsActionProvider extends CommonActionProvider {

	private DiagnosticsViewerAction mRefreshAction;
	private DiagnosticsViewerAction mSaveConnectionAction;
	private DiagnosticsViewerAction mRevertConnectionAction;
	private DiagnosticsViewerAction mCloseConnectionAction;
	private DiagnosticsViewerAction mDumpAllocTraceAction;
	private DiagnosticsViewerAction mClearNullPartitionAction;
	private DiagnosticsViewerAction mDumpPartitionAction;
	private DiagnosticsViewerAction mPropertiesAction;
	private DiagnosticsViewerAction mCopyTextAction;
	private DiagnosticsViewerAction mReloadEditorRegistryAction;

	@Override
	public void init(ICommonActionExtensionSite aSite) {
		super.init(aSite);
		ICommonViewerSite viewSite = aSite.getViewSite();
		StructuredViewer viewer = aSite.getStructuredViewer();

		mRefreshAction = new RefreshAction(viewer);
		viewer.addSelectionChangedListener(mRefreshAction);
		
		mSaveConnectionAction = new SaveConnectionAction(viewSite.getShell(), viewer);
		viewer.addSelectionChangedListener(mSaveConnectionAction);

		mRevertConnectionAction = new RevertConnectionAction(viewSite.getShell(), viewer);
		viewer.addSelectionChangedListener(mRevertConnectionAction);

		mCloseConnectionAction = new CloseConnectionAction(viewSite.getShell(), viewer);
		viewer.addSelectionChangedListener(mCloseConnectionAction);

		mDumpAllocTraceAction = new DumpAllocationStackTraceAction(viewer);
		viewer.addSelectionChangedListener(mDumpAllocTraceAction);

		mClearNullPartitionAction = new ClearNullPartitionAction(viewer);
		viewer.addSelectionChangedListener(mClearNullPartitionAction);

		mDumpPartitionAction = new DumpPartitionContentsAction(viewer);
		viewer.addSelectionChangedListener(mDumpPartitionAction);

		mPropertiesAction = new ShowPropertiesAction(viewer);
		viewer.addSelectionChangedListener(mPropertiesAction);

		mCopyTextAction = new CopyNodeTextAction(viewer);
		viewer.addSelectionChangedListener(mCopyTextAction);
		
		mReloadEditorRegistryAction = new ReloadEditorRegistryAction(viewer);
		viewer.addSelectionChangedListener(mReloadEditorRegistryAction);
	}

	@Override
	public void fillContextMenu(IMenuManager menu) {
		super.fillContextMenu(menu);

		if (mSaveConnectionAction.isAvailable())
			menu.appendToGroup(ICommonMenuConstants.GROUP_EDIT, mSaveConnectionAction);
		if (mRevertConnectionAction.isAvailable())
			menu.appendToGroup(ICommonMenuConstants.GROUP_EDIT, mRevertConnectionAction);
		if (mCloseConnectionAction.isAvailable())
			menu.appendToGroup(ICommonMenuConstants.GROUP_EDIT, mCloseConnectionAction);
		if (mDumpAllocTraceAction.isAvailable())
			menu.appendToGroup(ICommonMenuConstants.GROUP_GOTO, mDumpAllocTraceAction);
		if (mDumpPartitionAction.isAvailable())
			menu.appendToGroup(ICommonMenuConstants.GROUP_GOTO, mDumpPartitionAction);
		if (mClearNullPartitionAction.isAvailable())
			menu.appendToGroup(ICommonMenuConstants.GROUP_EDIT, mClearNullPartitionAction);
		if (mPropertiesAction.isAvailable())
			menu.appendToGroup(ICommonMenuConstants.GROUP_PROPERTIES, mPropertiesAction);
		if (mCopyTextAction.isAvailable())
			menu.appendToGroup(ICommonMenuConstants.GROUP_REORGANIZE, mCopyTextAction);
		if (mReloadEditorRegistryAction.isAvailable())
			menu.appendToGroup(ICommonMenuConstants.GROUP_REORGANIZE, mReloadEditorRegistryAction);
	}
	

	@Override
	public void fillActionBars(IActionBars actionBars) {
		super.fillActionBars(actionBars);

		IToolBarManager toolbar = actionBars.getToolBarManager();
		if (toolbar.find(mRefreshAction.getId()) == null && mRefreshAction.isEnabled())
			toolbar.add(mRefreshAction);
		actionBars.setGlobalActionHandler(ActionFactory.REFRESH.getId(), mRefreshAction);
		actionBars.setGlobalActionHandler(ActionFactory.SAVE.getId(), mSaveConnectionAction);
		actionBars.setGlobalActionHandler(ActionFactory.REVERT.getId(), mRevertConnectionAction);
		actionBars.setGlobalActionHandler(ActionFactory.PROPERTIES.getId(), mPropertiesAction);
		actionBars.setGlobalActionHandler(ActionFactory.COPY.getId(), mCopyTextAction);

		actionBars.updateActionBars();
	}

}