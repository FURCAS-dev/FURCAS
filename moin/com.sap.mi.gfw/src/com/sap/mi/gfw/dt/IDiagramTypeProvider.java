/*
 * Created on 17.05.2005
 */
package com.sap.mi.gfw.dt;

import com.sap.mi.gfw.features.IFeatureProviderHolder;
import com.sap.mi.gfw.mm.links.DiagramLink;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.notification.INotificationService;
import com.sap.mi.gfw.platform.IDiagramEditor;
import com.sap.mi.gfw.platform.IGFWExtension;
import com.sap.mi.gfw.platform.ga.IGraphicsAlgorithmRendererFactory;
import com.sap.mi.gfw.tb.IToolBehaviorProvider;

/**
 * This is the central interface from the Graphics Framework (GFW) to the diagram type agent. Do not implement this class directly. Extend
 * appropriate classes instead. This is the first revision of the diagram type interface.
 */
public interface IDiagramTypeProvider extends IGFWExtension, IFeatureProviderHolder {

	/**
	 * Implement this method to initialize the diagram type provider.
	 * 
	 * @param diagram
	 *            the currently opened diagram
	 * @param diagramEditor
	 *            TODO
	 */
	void init(Diagram diagram, IDiagramEditor diagramEditor);

	/**
	 * Returns the diagram.
	 * 
	 * @return the currently opened diagram
	 */
	Diagram getDiagram();

	/**
	 * Returns the notification service.
	 * 
	 * @return the notification service
	 */
	INotificationService getNotificationService();

	/**
	 * Returns the diagram link.
	 * 
	 * @return the diagram link
	 */
	DiagramLink getDiagramLink();

	/**
	 * Get the list of available tool behavior providers.
	 * 
	 * @return the list of tool behavior providers
	 * @see IToolBehaviorProvider
	 */
	IToolBehaviorProvider[] getAvailableToolBehaviorProviders();

	/**
	 * Gets the current tool behavior provider.
	 * 
	 * @return the currently active tool behavior provider
	 * @see IToolBehaviorProvider
	 */
	IToolBehaviorProvider getCurrentToolBehaviorProvider();

	/**
	 * Returns the diagram title.
	 * 
	 * @return the diagram-title, e.g. this will be used for the title-bar of the editor
	 */
	String getDiagramTitle();

	/**
	 * Returns the image id for the title bar of the diagram.
	 * 
	 * @return the image id or null if default image should be used.
	 */
	String getDiagramTitleImage();

	/**
	 * Returns the editor's update behavior at startup.
	 * 
	 * @return true if diagram should be updated (if needed) immediately after open in editor - editor will be dirty then; false if diagram
	 *         should not be updated - editor not dirty but eventually red at out of date areas
	 */
	boolean isAutoUpdateAtStartup();

	/**
	 * Returns the editor's update behavior.
	 * 
	 * @return true if diagram should be updated automatically (only if editor is already dirty)
	 */
	boolean isAutoUpdateAtRuntime();

	/**
	 * Returns the current diagram editor.
	 * 
	 * @return current diagram editor
	 */
	IDiagramEditor getDiagramEditor();

	/**
	 * Dispose.
	 */
	void dispose();

	/**
	 * Gets the related business objects.
	 * 
	 * @param bos
	 *            the bos
	 * @return the related business objects
	 */
	Object[] getRelatedBusinessObjects(Object[] bos);

	/**
	 * Gets the graphics algorithm renderer factory.
	 * 
	 * @return the graphics algorithm renderer factory
	 */
	IGraphicsAlgorithmRendererFactory getGraphicsAlgorithmRendererFactory();

	/**
	 * This method will be called after this diagram type provider has been completely initialized. The state of the using diagram editor
	 * can not be predicted.
	 */
	void postInit();

	int getCurrentToolBahaviorIndex();

	void setCurrentToolBahaviorIndex(int index);
}