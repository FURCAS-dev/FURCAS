/*
 * Created on 05.07.2005
 */
package com.sap.mi.gfw.command;

import com.sap.mi.gfw.features.IFeature;
import com.sap.mi.gfw.features.IResizeShapeFeature;
import com.sap.mi.gfw.features.context.IResizeShapeContext;

/**
 * The Class ResizeShapeFeatureCommandWithContext.
 */
public class ResizeShapeFeatureCommandWithContext extends FeatureCommandWithContext {

	/**
	 * The Constructor.
	 * 
	 * @param feature
	 *            the feature
	 * @param context
	 *            the context
	 */
	public ResizeShapeFeatureCommandWithContext(IFeature feature, IResizeShapeContext context) {
		super(feature, context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	public boolean canExecute() {
		boolean ret = true;
		if (ret) {
			IResizeShapeFeature f = getResizeShapeFeature();
			ret = f != null && f.canResizeShape(getResizeShapeContext());
		}
		return ret;
	}

	/**
	 * @return
	 */
	private IResizeShapeContext getResizeShapeContext() {
		IResizeShapeContext ret = null;
		if (getContext() instanceof IResizeShapeContext) {
			ret = (IResizeShapeContext) getContext();
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public final boolean execute() {
		IResizeShapeContext layouShapeContext = getResizeShapeContext();
		IResizeShapeFeature resizeShapeFeature = getResizeShapeFeature();

		resizeShapeFeature.resizeShape(layouShapeContext);

		// create new positions of box-relative anchors
		// LayoutUtil.resizeBoxRelativeAnchors(getResizeShapeContext().getShape());

		return true;
	}

	/**
	 * Gets the resize shape feature.
	 * 
	 * @return the resize shape feature
	 */
	protected IResizeShapeFeature getResizeShapeFeature() {
		IResizeShapeFeature ret = null;
		if (getFeature() instanceof IResizeShapeFeature) {
			ret = (IResizeShapeFeature) getFeature();
		} else {
			return ret;
		}
		return ret;
	}
}