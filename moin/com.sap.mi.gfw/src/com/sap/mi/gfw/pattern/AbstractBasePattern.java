package com.sap.mi.gfw.pattern;

import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IFeatureProviderHolder;
import com.sap.mi.gfw.features.IMappingProvider;
import com.sap.mi.gfw.features.context.IAddContext;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.platform.IDiagramEditor;
import com.sap.tc.moin.repository.Connection;

/**
 * The Class AbstractBasePattern.
 */
public abstract class AbstractBasePattern implements IFeatureProviderHolder {

	private IFeatureProvider featureProvider;

	/**
	 * Adds the.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @return the pictogram element
	 */
	public PictogramElement add(IAddContext context) {
		return null;
	}

	/**
	 * Can add.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @return true, if successful
	 */
	public boolean canAdd(IAddContext context) {
		return false;
	}

	/**
	 * Gets the feature provider.
	 * 
	 * @return Returns the featureProvider.
	 */
	public IFeatureProvider getFeatureProvider() {
		return featureProvider;
	}

	/**
	 * Sets the feature provider.
	 * 
	 * @param featureProvider
	 *            The featureProvider to set.
	 */
	public void setFeatureProvider(IFeatureProvider featureProvider) {
		this.featureProvider = featureProvider;
	}

	/**
	 * Gets the business object for pictogram element.
	 * 
	 * @param pe
	 *            the pe
	 * 
	 * @return the business object for pictogram element
	 */
	protected Object getBusinessObjectForPictogramElement(PictogramElement pe) {
		return getFeatureProvider().getBusinessObjectForPictogramElement(pe);
	}

	/**
	 * Gets the connection.
	 * 
	 * @return the connection
	 */
	protected Connection getConnection() {
		return getFeatureProvider().getConnection();
	}

	/**
	 * Gets the diagram editor.
	 * 
	 * @return the diagram editor
	 */
	protected IDiagramEditor getDiagramEditor() {
		return getFeatureProvider().getDiagramTypeProvider().getDiagramEditor();
	}

	/**
	 * Gets the mapping provider.
	 * 
	 * @return the mapping provider
	 */
	protected IMappingProvider getMappingProvider() {
		return getFeatureProvider();
	}

	/**
	 * Link.
	 * 
	 * @param pe
	 *            the pe
	 * @param businessObject
	 *            the business object
	 */
	protected void link(PictogramElement pe, Object businessObject) {
		link(pe, new Object[] { businessObject });
	}

	/**
	 * Link.
	 * 
	 * @param pe
	 *            the pe
	 * @param businessObjects
	 *            the business objects
	 */
	protected void link(PictogramElement pe, Object businessObjects[]) {
		getMappingProvider().link(pe, businessObjects);
	}
}
