package com.sap.mi.gfw.notification;

import java.util.ArrayList;

import com.sap.mi.gfw.dt.IDiagramTypeProvider;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.impl.UpdateContext;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * The Class AbstractNotificationService.
 */
public abstract class AbstractNotificationService implements INotificationService {

	private IDiagramTypeProvider diagramTypeProvider;

	/**
	 * Instantiates a new abstract notification service.
	 * 
	 * @param diagramTypeProvider
	 *            the diagram type provider
	 */
	public AbstractNotificationService(IDiagramTypeProvider diagramTypeProvider) {
		this.diagramTypeProvider = diagramTypeProvider;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.notification.INotificationService#update(java.lang.Object[])
	 */
	final public void update(Object[] changedBOs) {
		PictogramElement[] dirtyPes = calculateDirtyPictogramElements(changedBOs);
		updateDirtyPictogramElements(dirtyPes);
	}

	/**
	 * Gets the diagram type provider.
	 * 
	 * @return the diagram type provider
	 */
	protected IDiagramTypeProvider getDiagramTypeProvider() {
		return diagramTypeProvider;
	}

	/**
	 * Update dirty pictogram elements.
	 * 
	 * @param dirtyPes
	 *            the dirty pes
	 */
	void updateDirtyPictogramElements(PictogramElement[] dirtyPes) {
		final IDiagramTypeProvider dtp = getDiagramTypeProvider();
		final IFeatureProvider fp = dtp.getFeatureProvider();
		for (PictogramElement pe : dirtyPes) {
			final UpdateContext updateContext = new UpdateContext(pe);
			// fp.updateIfPossible(updateContext);
			fp.updateIfPossibleAndNeeded(updateContext);
		}
	}

	/**
	 * Calculate linked pictogram elements.
	 * 
	 * @param changedAndRelatedBOsList
	 *            the changed and related BOs list
	 * @return the pictogram element[]
	 */
	protected PictogramElement[] calculateLinkedPictogramElements(ArrayList<Object> changedAndRelatedBOsList) {
		ArrayList<PictogramElement> retList = new ArrayList<PictogramElement>();
		final IFeatureProvider featureProvider = getDiagramTypeProvider().getFeatureProvider();
		for (Object crbo : changedAndRelatedBOsList) {
			final PictogramElement[] allPictogramElementsForBusinessObject = featureProvider.getAllPictogramElementsForBusinessObject(crbo);
			for (PictogramElement pe : allPictogramElementsForBusinessObject) {
				retList.add(pe);
			}
		}
		return retList.toArray(new PictogramElement[0]);
	}

	/**
	 * Calculate dirty pictogram elements.
	 * 
	 * @param changedBOs
	 *            the changed BOs
	 * @return the pictogram element[]
	 */
	protected PictogramElement[] calculateDirtyPictogramElements(Object[] changedBOs) {
		ArrayList<Object> changedAndRelatedBOsList = new ArrayList<Object>();
		for (Object cbo : changedBOs) {
			changedAndRelatedBOsList.add(cbo);
		}
		Object[] relatedBOs = getRelatedBOs(changedBOs);
		for (Object rbo : relatedBOs) {
			changedAndRelatedBOsList.add(rbo);
		}

		return calculateLinkedPictogramElements(changedAndRelatedBOsList);
	}

	final private Object[] getRelatedBOs(Object[] changedBOs) {
		return getDiagramTypeProvider().getRelatedBusinessObjects(changedBOs);
	}
}
