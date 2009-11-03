package com.sap.mi.gfw.eclipse.internal.parts;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;

import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.features.IFeatureProviderHolder;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.platform.ga.IVisualStateHolder;

/**
 * The Interface IPictogramElementDelegate.
 */
public interface IPictogramElementDelegate extends IAdaptable, IFeatureProviderHolder, IVisualStateHolder {

	/**
	 * Creates the figure.
	 * 
	 * @return the i figure
	 */
	IFigure createFigure();

	/**
	 * Refresh figure for edit part.
	 */
	void refreshFigureForEditPart();

	/**
	 * Gets the configuration provider.
	 * 
	 * @return the configuration provider
	 */
	IConfigurationProvider getConfigurationProvider();

	/**
	 * Gets the pictogram element.
	 * 
	 * @return the pictogram element
	 */
	PictogramElement getPictogramElement();

	/**
	 * Activate.
	 */
	void activate();

	/**
	 * Deactivate.
	 */
	void deactivate();

	/**
	 * Gets the figure for graphics algorithm.
	 * 
	 * @param graphicsAlgorithm
	 *            the graphics algorithm
	 * 
	 * @return the figure for graphics algorithm
	 */
	IFigure getFigureForGraphicsAlgorithm(GraphicsAlgorithm graphicsAlgorithm);

	/**
	 * Refresh edit parts for model children and source connections.
	 * 
	 * @param ep
	 *            the ep
	 */
	void refreshEditPartsForModelChildrenAndSourceConnections(EditPart ep);

	/**
	 * If set to true, the visual refresh (synchronization of figures and graphics algorithm) will be done even it is not necessary.
	 * 
	 * @param forceRefresh
	 */
	void setForceRefresh(boolean forceRefresh);

	/**
	 * 
	 * @return true, if edit part (and it's delegate) are still valid (alive)
	 */
	boolean isValid();
}
