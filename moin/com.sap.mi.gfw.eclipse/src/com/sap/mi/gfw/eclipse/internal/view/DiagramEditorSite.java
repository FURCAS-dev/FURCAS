package com.sap.mi.gfw.eclipse.internal.view;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorActionBarContributor;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;

public class DiagramEditorSite implements IEditorSite {

	private IViewSite myViewSite;

	public DiagramEditorSite(IViewSite site) {
		super();
		setViewSite(site);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IViewSite#getActionBars()
	 */
	public IActionBars getActionBars() {
		return getViewSite().getActionBars();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchPartSite#getId()
	 */
	public String getId() {
		return getViewSite().getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchPartSite#getPluginId()
	 */
	public String getPluginId() {
		return getViewSite().getPluginId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchPartSite#getRegisteredName()
	 */
	public String getRegisteredName() {
		return getViewSite().getRegisteredName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchPartSite#registerContextMenu(java.lang.String, org.eclipse.jface.action.MenuManager,
	 * org.eclipse.jface.viewers.ISelectionProvider)
	 */
	public void registerContextMenu(String menuId, MenuManager menuManager, ISelectionProvider selectionProvider) {
		getViewSite().registerContextMenu(menuId, menuManager, selectionProvider);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchPartSite#registerContextMenu(org.eclipse.jface.action.MenuManager,
	 * org.eclipse.jface.viewers.ISelectionProvider)
	 */
	public void registerContextMenu(MenuManager menuManager, ISelectionProvider selectionProvider) {
		getViewSite().registerContextMenu(menuManager, selectionProvider);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchPartSite#getKeyBindingService()
	 */
	@SuppressWarnings("deprecation")
	public org.eclipse.ui.IKeyBindingService getKeyBindingService() {
		return getViewSite().getKeyBindingService();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchSite#getPage()
	 */
	public IWorkbenchPage getPage() {
		return getViewSite().getPage();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchSite#getSelectionProvider()
	 */
	public ISelectionProvider getSelectionProvider() {
		return getViewSite().getSelectionProvider();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchSite#getShell()
	 */
	public Shell getShell() {
		return getViewSite().getShell();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchSite#getWorkbenchWindow()
	 */
	public IWorkbenchWindow getWorkbenchWindow() {
		return getViewSite().getWorkbenchWindow();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchSite#setSelectionProvider(org.eclipse.jface.viewers.ISelectionProvider)
	 */
	public void setSelectionProvider(ISelectionProvider provider) {
		getViewSite().setSelectionProvider(provider);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	public Object getAdapter(Class adapter) {
		return getViewSite().getAdapter(adapter);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IEditorSite#getActionBarContributor()
	 */
	public IEditorActionBarContributor getActionBarContributor() {
		return null;
	}

	/**
	 * @param myViewSite
	 *            The myViewSite to set.
	 */
	private void setViewSite(IViewSite myViewSite) {
		this.myViewSite = myViewSite;
	}

	/**
	 * @return Returns the myViewSite.
	 */
	private IViewSite getViewSite() {
		return myViewSite;
	}

	public void registerContextMenu(MenuManager menuManager, ISelectionProvider selectionProvider, boolean arg2) {
		// TODO: handle last boolean parameter
		getViewSite().registerContextMenu(menuManager, selectionProvider);
	}

	public void registerContextMenu(String arg0, MenuManager menuManager, ISelectionProvider selectionProvider, boolean arg3) {
		// TODO: handle last boolean parameter
		getViewSite().registerContextMenu(arg0, menuManager, selectionProvider);
	}

	public IWorkbenchPart getPart() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getService(Class api) {
		return getViewSite().getService(api);
	}

	public boolean hasService(Class api) {
		return getViewSite().hasService(api);
	}
}