package com.sap.mi.gfw.eclipse.internal.config;

import org.eclipse.ui.IWorkbenchPart;

import com.sap.mi.gfw.eclipse.internal.editor.DiagramEditor;
import com.sap.mi.gfw.eclipse.internal.policy.IEditPolicyFactory;

/**
 * An abstract base implementation of the interface IConfigurationProvider. It implements every get-method in a way, that it calls a
 * corresponding abstract create-method, and buffers the created instance for further calls of the get-method.
 */
public abstract class AbstractConfigurationProvider implements IConfigurationProvider {

	private boolean _isDisposed = false;

	private IEditPolicyFactory _editPolicyFactory;

	private IEditPartFactory _editPartFactory;

	private IWorkbenchPart _workbenchPart;

	private DiagramEditor diagramEditor;

	/**
	 * Creates a new AbstractConfigurationProvider.
	 * 
	 * @param diagramEditor
	 *            the diagram editor
	 */
	public AbstractConfigurationProvider(DiagramEditor diagramEditor) {
		this.diagramEditor = diagramEditor;
	}

	// =================== forward get-methods to create-methods ==============

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.ide.eclipse.gf.config.provider.IConfigurationProvider#dispose()
	 */
	public void dispose() {
		_editPolicyFactory = null;
		_editPartFactory = null;

		_isDisposed = true;

		getDiagramTypeProvider().dispose();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.ide.eclipse.gf.config.provider.IConfigurationProvider#isDisposed()
	 */
	public boolean isDisposed() {
		return _isDisposed;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.ide.eclipse.gf.config.provider.IConfigurationProvider#getEditPolicyFactory()
	 */
	public IEditPolicyFactory getEditPolicyFactory() {
		if (_editPolicyFactory == null && !_isDisposed) {
			_editPolicyFactory = createEditPolicyFactory();
		}
		return _editPolicyFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.ide.eclipse.gf.config.provider.IConfigurationProvider#getEditPartFactory()
	 */
	public IEditPartFactory getEditPartFactory() {
		if (_editPartFactory == null && !_isDisposed) {
			_editPartFactory = createEditPartFactory();
		}
		return _editPartFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.ide.eclipse.gf.config.provider.IConfigurationProvider#setWorkbenchPart(org.eclipse.ui.IWorkbenchPart)
	 */
	public void setWorkbenchPart(IWorkbenchPart workbenchPart) {
		if (_workbenchPart != null && (!_workbenchPart.equals(workbenchPart)))
			throw new RuntimeException("The IWorbenchPart must not be changed after setting it initially."); //$NON-NLS-1$
		_workbenchPart = workbenchPart;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.ide.eclipse.gf.config.provider.IConfigurationProvider#getWorkbenchPart()
	 */
	public IWorkbenchPart getWorkbenchPart() {
		return _workbenchPart;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pf.eclipse.internal.config.IConfigurationProvider#getDiagramEditor()
	 */
	public DiagramEditor getDiagramEditor() {
		return diagramEditor;
	}

	// ====================== define abstract create-methods ==================

	/**
	 * Creates the edit policy factory.
	 * 
	 * @return the i edit policy factory
	 */
	protected abstract IEditPolicyFactory createEditPolicyFactory();

	/**
	 * Creates the edit part factory.
	 * 
	 * @return the i edit part factory
	 */
	protected abstract IEditPartFactory createEditPartFactory();
}