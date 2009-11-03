package com.sap.mi.gfw.features.impl;

import com.sap.mi.gfw.Messages;
import com.sap.mi.gfw.datatypes.IDimension;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IReason;
import com.sap.mi.gfw.features.IResizeShapeFeature;
import com.sap.mi.gfw.features.IUpdateFeature;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.IUpdateContext;
import com.sap.mi.gfw.features.context.impl.ResizeShapeContext;
import com.sap.mi.gfw.features.context.impl.UpdateContext;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Shape;
import com.sap.mi.gfw.util.GaUtil;
import com.sap.mi.gfw.util.T;

/**
 * The Class AbstractUpdateFeature.
 */
public abstract class AbstractUpdateFeature extends AbstractFeature implements IUpdateFeature {

	/**
	 * The Constructor.
	 * 
	 * @param fp
	 *            the fp
	 */
	public AbstractUpdateFeature(IFeatureProvider fp) {
		super(fp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#canExecute(com.sap.mi.gfw.features.context.IContext)
	 */
	public final boolean canExecute(IContext context) {
		final String SIGNATURE = Messages.AbstractUpdateFeature_0_xfld;
		boolean info = T.racer().info();
		if (info) {
			T.racer().entering(AbstractUpdateFeature.class, SIGNATURE, new Object[] { context });
		}
		boolean ret = false;
		if (context instanceof IUpdateContext) {
			IUpdateContext updateSemanticsContext = (IUpdateContext) context;
			ret = canUpdate(updateSemanticsContext);
		}
		if (info) {
			T.racer().exiting(AbstractUpdateFeature.class, SIGNATURE, ret);
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#execute(com.sap.mi.gfw.features.context.IContext)
	 */
	public void execute(IContext context) {
		final String SIGNATURE = Messages.AbstractUpdateFeature_1_xfld;
		boolean info = T.racer().info();
		if (info) {
			T.racer().entering(AbstractUpdateFeature.class, SIGNATURE, new Object[] { context });
		}
		if (context instanceof IUpdateContext) {
			update((IUpdateContext) context);
		}
		if (info) {
			T.racer().exiting(AbstractUpdateFeature.class, SIGNATURE);
		}
	}

	/**
	 * Can update pictogram element.
	 * 
	 * @param pe
	 *            the pe
	 * @return true, if successful
	 */
	protected boolean canUpdatePictogramElement(PictogramElement pe) {
		return getFeatureProvider().canUpdate(new UpdateContext(pe)).toBoolean();
	}

	/**
	 * Update pictogram element needed.
	 * 
	 * @param pe
	 *            the pe
	 * @return the i reason
	 */
	protected IReason updatePictogramElementNeeded(PictogramElement pe) {
		return getFeatureProvider().updateNeeded(new UpdateContext(pe));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.impl.AbstractFeature#updatePictogramElement(com.sap.mi.gfw.mm.pictograms.PictogramElement)
	 */
	@Override
	protected void updatePictogramElement(PictogramElement pe) {
		getFeatureProvider().updateIfPossible(new UpdateContext(pe));
	}

	/**
	 * Resize shape.
	 * 
	 * @param shape
	 *            the shape
	 */
	protected void resizeShape(Shape shape) {
		final ResizeShapeContext resizeShapeContext = new ResizeShapeContext(shape);
		GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();
		IDimension gaSize = GaUtil.calculateSizeOfGraphicsAlgorithm(ga, false);
		resizeShapeContext.setWidth(gaSize.getWidth());
		resizeShapeContext.setHeight(gaSize.getHeight());

		final IResizeShapeFeature resizeShapeFeature = getFeatureProvider().getResizeShapeFeature(resizeShapeContext);
		if (resizeShapeFeature != null) {
			if (resizeShapeFeature.canResizeShape(resizeShapeContext)) {
				resizeShapeFeature.resizeShape(resizeShapeContext);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.impl.AbstractFeature#getName()
	 */
	@Override
	public String getName() {
		return NAME;
	}

	private static final String NAME = Messages.AbstractUpdateFeature_2_xfld;
}