package com.sap.mi.gfw.features.impl;

import com.sap.mi.gfw.Messages;
import com.sap.mi.gfw.features.DefaultResizeConfiguration;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IResizeConfiguration;
import com.sap.mi.gfw.features.IResizeShapeFeature;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.IResizeShapeContext;
import com.sap.mi.gfw.features.context.impl.ResizeShapeContext;
import com.sap.mi.gfw.mm.pictograms.Shape;
import com.sap.mi.gfw.util.GaUtil;

/**
 * The Class DefaultResizeShapeFeature.
 */
public class DefaultResizeShapeFeature extends AbstractFeature implements IResizeShapeFeature {

	/**
	 * The Constructor.
	 * 
	 * @param fp
	 *            the fp
	 */
	public DefaultResizeShapeFeature(IFeatureProvider fp) {
		super(fp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IResizeShapeFeature#canResizeShape(com.sap.mi.gfw.dt.IContext)
	 */
	public boolean canResizeShape(IResizeShapeContext context) {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IResizeShapeFeature#resizeShape(com.sap.mi.gfw.dt.IContext)
	 */
	public void resizeShape(IResizeShapeContext context) {
		Shape shape = context.getShape();
		int width = context.getWidth();
		int height = context.getHeight();

		if (shape.getGraphicsAlgorithm() != null) {
			GaUtil.setSizeOfGraphicsAlgorithm(shape.getGraphicsAlgorithm(), width, height);
		}

		layoutPictogramElement(shape);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#canExecute(com.sap.mi.gfw.features.context.IContext)
	 */
	public boolean canExecute(IContext context) {
		boolean ret = false;
		if (context instanceof IResizeShapeContext) {
			ret = canResizeShape((IResizeShapeContext) context);
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#execute(com.sap.mi.gfw.features.context.IContext)
	 */
	public void execute(IContext context) {
		if (context instanceof IResizeShapeContext) {
			resizeShape((IResizeShapeContext) context);
		}
	}

	/**
	 * Resize shape.
	 * 
	 * @param currentShape
	 *            the current shape
	 */
	protected void resizeShape(Shape currentShape) {
		final ResizeShapeContext resizeShapeContext = new ResizeShapeContext(currentShape);
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

	private static final String NAME = Messages.DefaultResizeShapeFeature_0_xfld;

	public IResizeConfiguration getResizeConfiguration() {
		return new DefaultResizeConfiguration();
	}
}
