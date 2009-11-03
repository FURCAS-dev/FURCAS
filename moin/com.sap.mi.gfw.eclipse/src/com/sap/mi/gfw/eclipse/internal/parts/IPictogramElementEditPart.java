package com.sap.mi.gfw.eclipse.internal.parts;

import java.util.List;

import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProviderHolder;
import com.sap.mi.gfw.features.IFeatureProviderHolder;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * The Interface IPictogramElementEditPart.
 */
public interface IPictogramElementEditPart extends IConfigurationProviderHolder, IFeatureProviderHolder {

	/**
	 * Gets the pictogram element.
	 * 
	 * @return the pictogram element
	 */
	PictogramElement getPictogramElement();

	/**
	 * Gets the model children.
	 * 
	 * @return the model children
	 */
	List<PictogramElement> getModelChildren();

	/**
	 * Gets the model source connections.
	 * 
	 * @return the model source connections
	 */
	List<Connection> getModelSourceConnections();

	/**
	 * Gets the model target connections.
	 * 
	 * @return the model target connections
	 */
	List<Connection> getModelTargetConnections();

	/**
	 * Gets the pictogram element delegate.
	 * 
	 * @return the pictogram element delegate
	 */
	IPictogramElementDelegate getPictogramElementDelegate();
}