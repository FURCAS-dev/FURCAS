/*
 * Created on 13.07.2005
 */
package com.sap.mi.gfw.features.impl;

import com.sap.mi.gfw.GfwUtil;
import com.sap.mi.gfw.Messages;
import com.sap.mi.gfw.features.IFeature;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IProgress;
import com.sap.mi.gfw.features.context.IAreaContext;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.impl.AddContext;
import com.sap.mi.gfw.features.context.impl.LayoutContext;
import com.sap.mi.gfw.features.context.impl.UpdateContext;
import com.sap.mi.gfw.mm.datatypes.Color;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.platform.IDiagramEditor;
import com.sap.mi.gfw.platform.IPlatformService;
import com.sap.mi.gfw.util.GaUtil;
import com.sap.mi.gfw.util.IColorConstant;
import com.sap.tc.moin.repository.Connection;

/**
 * Abstract base class for all features. Prefer extending this class over inheriting interface {@link com.sap.mi.gfw.features.IFeature}.
 */
public abstract class AbstractFeature implements IFeature {

	private IFeatureProvider fp;

	private IProgress progressCallback;

	/**
	 * Instantiates a new abstract feature.
	 * 
	 * @param fp
	 *            the fp
	 */
	public AbstractFeature(IFeatureProvider fp) {
		super();
		this.fp = fp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#canUndo(com.sap.mi.gfw.features.context.IContext)
	 */
	public boolean canUndo(IContext context) {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.IDescription#getDescription()
	 */
	public String getDescription() {
		return toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeatureProviderHolder#getFeatureProvider()
	 */
	public IFeatureProvider getFeatureProvider() {
		return fp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.IName#getName()
	 */
	public String getName() {
		return this.getClass().getName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#isAvailable(com.sap.mi.gfw.features.context.IContext)
	 */
	public boolean isAvailable(IContext context) {
		return true;
	}

	// protected DiagramLink getDiagramLink() {
	// return getFeatureProvider().getDiagramTypeProvider().getDiagramLink();
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IProgressProvider#setProgressCallback(com.sap.mi.gfw.features.IProgress)
	 */
	/**
	 * Sets the progress callback.
	 * 
	 * @param progress
	 *            the new progress callback
	 */
	public void setProgressCallback(IProgress progress) {
		this.progressCallback = progress;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName();
	}

	/**
	 * Adds the graphical representation.
	 * 
	 * @param context
	 *            the context
	 * @param newObject
	 *            the new object
	 * 
	 * @return the added pictogram element
	 */
	protected PictogramElement addGraphicalRepresentation(IAreaContext context, Object newObject) {
		return getFeatureProvider().addIfPossible(new AddContext(context, newObject));
	}

	/**
	 * Gets the all business objects for pictogram element.
	 * 
	 * @param pe
	 *            the pe
	 * 
	 * @return the all business objects for pictogram element
	 */
	protected Object[] getAllBusinessObjectsForPictogramElement(PictogramElement pe) {
		return getFeatureProvider().getAllBusinessObjectsForPictogramElement(pe);
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
	 * Gets the diagram.
	 * 
	 * @return the diagram
	 */
	protected Diagram getDiagram() {
		return getFeatureProvider().getDiagramTypeProvider().getDiagram();
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
	 * Gets the platform service.
	 * 
	 * @return the platform service
	 */
	protected final IPlatformService getPlatformService() {
		return GfwUtil.getPlatformService();
	}

	/**
	 * Gets the progress callback.
	 * 
	 * @return the progress callback
	 */
	protected IProgress getProgressCallback() {
		return progressCallback;
	}

	// protected void provideProgress() {
	// provideProgress(1);
	// }

	// protected void provideProgress(int progress) {
	// IProgress p = getProgressCallback();
	// if (p != null) {
	// p.addProgress(progress);
	// }
	// }

	/**
	 * Override this method to decide what users should be asked. Return null, if user should not be asked at all. Feature will then be
	 * performed without asking the user.
	 * 
	 * @return question text presented to the user
	 */
	protected String getQuestionToUser() {
		return null;
	}

	/**
	 * Gets the user decision.
	 * 
	 * @return the user decision
	 */
	protected final boolean getUserDecision() {
		boolean ret = false;
		String questionToUser = getQuestionToUser();

		if (questionToUser == null) {
			ret = true;
		} else {
			ret = getPlatformService().askUser(Messages.AbstractFeature_0_xhed, questionToUser);
		}
		return ret;
	}

	/**
	 * Layoutes the given pictogram element. This implementation asks the feature provider for available layout features and processes the
	 * first one.
	 * 
	 * @param pe
	 *            the pe
	 */
	protected void layoutPictogramElement(PictogramElement pe) {
		LayoutContext context = new LayoutContext(pe);
		getFeatureProvider().layoutIfPossible(context);
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
		getFeatureProvider().link(pe, businessObjects);
	}

	/**
	 * Manage color.
	 * 
	 * @param colorConstant
	 *            the color constant
	 * 
	 * @return the color
	 */
	protected Color manageColor(IColorConstant colorConstant) {
		return GaUtil.manageColor(getDiagram(), colorConstant);
	}

	/**
	 * Manage color.
	 * 
	 * @param red
	 *            the red
	 * @param green
	 *            the green
	 * @param blue
	 *            the blue
	 * 
	 * @return the color
	 */
	protected Color manageColor(int red, int green, int blue) {
		return GaUtil.manageColor(getDiagram(), red, green, blue);
	}

	/**
	 * Updates the given pictogram element. This implementation asks the feature provider for available update features and processes the
	 * first one.
	 * 
	 * @param pe
	 *            the pe
	 */
	protected void updatePictogramElement(PictogramElement pe) {
		UpdateContext context = new UpdateContext(pe);
		getFeatureProvider().updateIfPossible(context);
	}
}