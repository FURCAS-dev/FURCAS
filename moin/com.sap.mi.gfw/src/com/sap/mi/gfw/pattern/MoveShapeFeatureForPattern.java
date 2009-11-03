package com.sap.mi.gfw.pattern;

import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IMoveShapeContext;
import com.sap.mi.gfw.features.jam.AbstractMoveShapeFeature;

/**
 * The Class MoveShapeFeatureForPattern.
 */
public class MoveShapeFeatureForPattern extends AbstractMoveShapeFeature {
	private IFeatureForPattern delegate;

	/**
	 * Instantiates a new move shape feature for pattern.
	 * 
	 * @param featureProvider
	 *            the feature provider
	 * @param pattern
	 *            the pattern
	 */
	public MoveShapeFeatureForPattern(IFeatureProvider featureProvider, IPattern pattern) {
		super(featureProvider);
		delegate = new FeatureForPatternDelegate(pattern);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.impl.DefaultMoveShapeFeature#canMoveShape(com.sap.mi.gfw.features.context.IMoveShapeContext)
	 */
	public boolean canMoveShape(IMoveShapeContext context) {
		IPattern pattern = delegate.getPattern();
		return pattern.canMoveShape(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.impl.DefaultMoveShapeFeature#moveShape(com.sap.mi.gfw.features.context.IMoveShapeContext)
	 */
	public void moveShape(IMoveShapeContext context) {
		delegate.getPattern().moveShape(context);
	}
}
