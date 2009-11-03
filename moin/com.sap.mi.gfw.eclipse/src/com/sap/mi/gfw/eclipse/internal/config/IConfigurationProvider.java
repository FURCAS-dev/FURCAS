package com.sap.mi.gfw.eclipse.internal.config;

import org.eclipse.ui.IWorkbenchPart;

import com.sap.mi.gfw.dt.IDiagramTypeProvider;
import com.sap.mi.gfw.eclipse.internal.IResourceRegistryHolder;
import com.sap.mi.gfw.eclipse.internal.editor.DiagramEditor;
import com.sap.mi.gfw.eclipse.internal.policy.IEditPolicyFactory;
import com.sap.mi.gfw.features.IFeatureProviderHolder;
import com.sap.mi.gfw.mm.pictograms.Diagram;

/**
 * This interface is the wrapping container around all providers and factories, which determine this framework. So by having access to this
 * interface, it is possible to retrieve every information which might be necessarry to build on this framework.
 * <p>
 * All providers and factories have access to the IConfigurationProvider, to which they belong (backward-pointer). This is necessarry,
 * because the providers/factories are sometimes dependent on each other. However, this prohibits the usage of the same instance of a
 * provider/factory in different IConfigurationProviders.
 */
public interface IConfigurationProvider extends IFeatureProviderHolder, IResourceRegistryHolder {

	/**
	 * Disposes this object and frees all resources. This object will be unusable afterwards.
	 */
	public void dispose();

	/**
	 * Returns true, if this object is already disposed.
	 * 
	 * @return true, if this object is already disposed.
	 */
	public boolean isDisposed();

	/**
	 * Returns the IEditPartFactory of this Model.
	 * 
	 * @return The IEditPartFactory of this Model.
	 */
	public IEditPartFactory getEditPartFactory();

	/**
	 * Returns the IEditPolicyFactory of this Model.
	 * 
	 * @return The IEditPolicyFactory of this Model.
	 */
	public IEditPolicyFactory getEditPolicyFactory();

	/**
	 * Returns the Diagram-Model to display.
	 * 
	 * @return The Diagram-Model to display.
	 */
	public Diagram getDiagram();

	// ================ ConnectionDecoratorTreeEditPart to (graphical)
	// environment ====================

	/**
	 * Sets the workbench-part of this configuration-provider. This method should be called, when a workbench-part is available for the
	 * configuration-provider. After setting the workbench-part it must not be changed again.
	 * <p>
	 * However, it must not be assumed, that this method is ever called. So the workbench-part might always be null. It is just an offer, to
	 * support possible further functionality.
	 * 
	 * @param workbenchPart
	 *            The workbench-part to set.
	 */
	public void setWorkbenchPart(IWorkbenchPart workbenchPart);

	/**
	 * Returns the workbench-part of this configuration-provider. Can return null.
	 * 
	 * @return The workbench-part of this configuration-provider. Can return null.
	 */
	public IWorkbenchPart getWorkbenchPart();

	/**
	 * Returns the diagram type provider.
	 * 
	 * @return diagram type provider
	 */
	IDiagramTypeProvider getDiagramTypeProvider();

	/**
	 * Gets the diagram editor.
	 * 
	 * @return the editor which is connected with this configuration-provider
	 */
	DiagramEditor getDiagramEditor();
}