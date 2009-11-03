package com.sap.mi.gfw.features.impl;

import com.sap.mi.gfw.Messages;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.ILayoutFeature;
import com.sap.mi.gfw.features.IResizeShapeFeature;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.ILayoutContext;
import com.sap.mi.gfw.features.context.impl.LayoutContext;
import com.sap.mi.gfw.features.context.impl.ResizeShapeContext;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Shape;

/**
 * The Class AbstractLayoutFeature.
 */
public abstract class AbstractLayoutFeature extends AbstractFeature implements ILayoutFeature {

	/**
	 * The Constructor.
	 * 
	 * @param fp
	 *            the fp
	 */
	public AbstractLayoutFeature(IFeatureProvider fp) {
		super(fp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#canExecute(com.sap.mi.gfw.features.context.IContext)
	 */
	public final boolean canExecute(IContext context) {
		boolean ret = false;
		if (context instanceof ILayoutContext) {
			ILayoutContext layoutSemanticsContext = (ILayoutContext) context;
			ret = canLayout(layoutSemanticsContext);
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#execute(com.sap.mi.gfw.features.context.IContext)
	 */
	public void execute(IContext context) {
		if (context instanceof ILayoutContext) {
			layout((ILayoutContext) context);
		}
	}

	/**
	 * Can layout pictogram element.
	 * 
	 * @param pe
	 *            the pe
	 * 
	 * @return true, if successful
	 */
	protected boolean canLayoutPictogramElement(PictogramElement pe) {
		return getFeatureProvider().canLayout(new LayoutContext(pe)).toBoolean();
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
		resizeShapeContext.setWidth(ga.getWidth());
		resizeShapeContext.setHeight(ga.getHeight());

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

	private static final String NAME = Messages.AbstractLayoutFeature_0_xfld;
}