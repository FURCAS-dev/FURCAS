/**
 * 
 */
package com.sap.mi.gfw.pattern.template;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.mi.gfw.datatypes.IInsets;
import com.sap.mi.gfw.dt.IDiagramTypeProvider;
import com.sap.mi.gfw.features.IDirectEditingFeature;
import com.sap.mi.gfw.features.ILayoutFeature;
import com.sap.mi.gfw.features.IMoveShapeFeature;
import com.sap.mi.gfw.features.IReconnectionFeature;
import com.sap.mi.gfw.features.IUpdateFeature;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.features.context.IDirectEditingContext;
import com.sap.mi.gfw.features.context.ILayoutContext;
import com.sap.mi.gfw.features.context.IMoveShapeContext;
import com.sap.mi.gfw.features.context.IReconnectionContext;
import com.sap.mi.gfw.features.context.IUpdateContext;
import com.sap.mi.gfw.features.custom.ICustomFeature;
import com.sap.mi.gfw.func.IDirectEditing;
import com.sap.mi.gfw.func.IReconnection;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Shape;
import com.sap.mi.gfw.pattern.DefaultJamFeatureProviderWithPatterns;
import com.sap.mi.gfw.pattern.DirectEditingFeatureForPattern;
import com.sap.mi.gfw.pattern.IConnectionPattern;
import com.sap.mi.gfw.pattern.IPattern;
import com.sap.mi.gfw.pattern.LayoutFeatureForPattern;
import com.sap.mi.gfw.pattern.MoveShapeFeatureForPattern;
import com.sap.mi.gfw.pattern.ReconnectionFeatureForPattern;
import com.sap.mi.gfw.pattern.UpdateFeatureForPattern;
import com.sap.mi.gfw.util.ILocationInfo;

/**
 * The Class TemplatePatternFeatureProvider.
 * 
 * @author d023588 This Feature provider makes usage of template patterns easier and more efficient. It assumes that each Shape that is
 *         contained in a Diagram is linked with a domain objects, and each of those shapes are handled by a TemplatePattern.
 */
public class TemplatePatternFeatureProvider extends DefaultJamFeatureProviderWithPatterns {

	/**
	 * Contains the mapping from the main domain object MofClass to the (Template-)Pattern, that handles it.
	 */
	protected HashMap<MofClass, Collection<IPattern>> patternMap;

	/**
	 * The Constructor.
	 * 
	 * @param dtp
	 *            the dtp
	 */
	public TemplatePatternFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
	}

	private void ensurePatternMap() {
		if (patternMap == null) {
			patternMap = new HashMap<MofClass, Collection<IPattern>>(getPatterns().size());
			for (IPattern p : getPatterns()) {
				if (p instanceof TemplatePattern) {
					TemplatePattern tp = (TemplatePattern) p;
					MofClass key = tp.getDomainModelClass();
					if (!patternMap.containsKey(key)) {
						patternMap.put(key, new ArrayList<IPattern>());
					}
					patternMap.get(key).add(tp);
				}
			}
		}
	}

	/**
	 * Given a domain RefOject, the method returns the pattern that handles it.
	 * 
	 * @param bo
	 *            the bo
	 * 
	 * @return the pattern for domain object
	 */
	public IPattern getPatternForDomainObject(RefObject bo) {
		ensurePatternMap();

		Collection<IPattern> patterns = getPatternsForDomainObject(bo);
		if (patterns != null) {
			for (IPattern pattern : getPatternsForDomainObject(bo)) {
				if (pattern.isMainBusinessObjectApplicable(bo))
					return pattern;
			}
		}
		return null;
	}

	/**
	 * Given a domain RefOject, the method returns the patterns that handles it.
	 * 
	 * @param bo
	 *            the bo
	 * 
	 * @return the patterns for domain object
	 */
	public Collection<IPattern> getPatternsForDomainObject(RefObject bo) {
		ensurePatternMap();
		MofClass mc = (MofClass) bo.refMetaObject();
		return patternMap.get(mc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pattern.DefaultJamFeatureProviderWithPatterns#getPatternForPictogramElement(com.sap.mi.gfw.mm.pictograms.PictogramElement)
	 */
	@Override
	public IPattern getPatternForPictogramElement(PictogramElement pe) {
		RefObject ro = (RefObject) getBusinessObjectForPictogramElement(pe);
		if (ro != null)
			return getPatternForDomainObject(ro);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pattern.DefaultJamFeatureProviderWithPatterns#getLayoutFeature(com.sap.mi.gfw.features.context.ILayoutContext)
	 */
	@Override
	public ILayoutFeature getLayoutFeature(ILayoutContext context) {
		IPattern pattern = getPatternForPictogramElement(context.getPictogramElement());
		if (pattern != null)
			return new LayoutFeatureForPattern(this, pattern);

		return getLayoutFeatureAdditional(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pattern.DefaultJamFeatureProviderWithPatterns#getMoveShapeFeature(com.sap.mi.gfw.features.context.IMoveShapeContext)
	 */
	@Override
	public IMoveShapeFeature getMoveShapeFeature(IMoveShapeContext context) {
		IPattern pattern = getPatternForPictogramElement(context.getPictogramElement());
		if (pattern != null)
			return new MoveShapeFeatureForPattern(this, pattern);

		return getMoveShapeFeatureAdditional(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pattern.DefaultJamFeatureProviderWithPatterns#getUpdateFeature(com.sap.mi.gfw.features.context.IUpdateContext)
	 */
	@Override
	public IUpdateFeature getUpdateFeature(IUpdateContext context) {
		if (context.getPictogramElement() instanceof Diagram)
			// return diagramUpdateFeature;
			return null;

		IPattern pattern = getPatternForPictogramElement(context.getPictogramElement());
		if (pattern != null)
			return new UpdateFeatureForPattern(this, pattern);
		return super.getUpdateFeatureAdditional(context);
	}

	private Shape getMainShape(PictogramElement pictogramElement) {
		if (pictogramElement instanceof Shape) {
			Shape shape = (Shape) pictogramElement;
			Object bo = getBusinessObjectForPictogramElement(pictogramElement);
			if (bo != null)
				return shape;
			else {
				return getMainShape(shape.getContainer());
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.impl.AbstractFeatureProvider#getDirectEditingFeature(com.sap.mi.gfw.features.context.IDirectEditingContext)
	 */
	@Override
	public IDirectEditingFeature getDirectEditingFeature(IDirectEditingContext context) {

		Shape mainShape = getMainShape(context.getPictogramElement());
		IPattern pattern = getPatternForPictogramElement(mainShape);
		if (pattern != null && pattern instanceof IDirectEditing)
			return new DirectEditingFeatureForPattern(this, (IDirectEditing) pattern);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.impl.AbstractFeatureProvider#getReconnectionFeature(com.sap.mi.gfw.features.context.IReconnectionContext)
	 */
	@Override
	public IReconnectionFeature getReconnectionFeature(IReconnectionContext context) {
		for (IConnectionPattern connectionPattern : getConnectionPatterns()) {
			if (connectionPattern instanceof IReconnection) {
				IReconnection def = (IReconnection) connectionPattern;
				if (def.canReconnect(context)) {
					return new ReconnectionFeatureForPattern(this, def);
				}
			}

		}
		// return null to avoid that DefaultReconnectionFeature class is called
		// and does visual reconnection
		return null;// super.getReconnectionFeature(context);

	}

	/**
	 * Gets the default location info for direct editing.
	 * 
	 * @param pe
	 *            the pe
	 * @param locationInfo
	 *            the location info
	 * 
	 * @return the default location info for direct editing
	 */
	public ILocationInfo getDefaultLocationInfoForDirectEditing(PictogramElement pe, ILocationInfo locationInfo) {
		IPattern pattern = getPatternForPictogramElement(pe);
		if (pattern instanceof TemplatePattern) {
			return ((TemplatePattern) pattern).getDefaultLocationInfoForDirectEditing((Shape) pe, locationInfo);
		}
		return null;
	}

	/**
	 * Gets the selection graphics algorithm.
	 * 
	 * @param mainShape
	 *            the main shape
	 * 
	 * @return the selection graphics algorithm
	 */
	public GraphicsAlgorithm getSelectionGraphicsAlgorithm(PictogramElement mainShape) {
		IPattern pattern = getPatternForPictogramElement(mainShape);
		if (pattern instanceof TemplatePattern) {
			return ((TemplatePattern) pattern).getSelectionGraphicsAlgorithm(mainShape);
		}
		return null;
	}

	/**
	 * Gets the selected patterns.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @return the selected patterns
	 */
	protected Collection<IPattern> getSelectedPatterns(ICustomContext context) {
		HashSet<IPattern> result = new HashSet<IPattern>();
		PictogramElement[] source = context.getPictogramElements();
		for (int i = 0; i < source.length; i++) {
			IPattern p = getPatternForPictogramElement(source[0]);
			if (p != null)
				result.add(p);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.jam.DefaultJAMFeatureProvider#getCustomFeatures(com.sap.mi.gfw.features.context.ICustomContext)
	 */
	@Override
	public ICustomFeature[] getCustomFeatures(ICustomContext context) {
		List<ICustomFeature> result = new ArrayList<ICustomFeature>();
		Collections.addAll(result, super.getCustomFeatures(context));

		Collection<IPattern> patterns = getSelectedPatterns(context);
		for (IPattern pattern : patterns) {
			if (pattern instanceof TemplatePattern)
				Collections.addAll(result, ((TemplatePattern) pattern).getCustomFeatures(context));
		}
		return result.toArray(new ICustomFeature[0]);
	}

	/**
	 * Provide the insets for the context buttons appearing for the given pictogram element. Positive insets result in context buttons with
	 * a larger distance to the shape. Negative insets decrease the distance. These insets are relative to the outline of the
	 * SelectionGraphicsAlgorithm.
	 * 
	 * @param mainShape
	 *            the pictogram element
	 * @return the insets to influence the context button positions
	 */
	public IInsets getContextButtonInsets(PictogramElement mainShape) {
		IPattern pattern = getPatternForPictogramElement(mainShape);
		if (pattern instanceof TemplatePattern) {
			return ((TemplatePattern) pattern).getContextButtonInsets();
		}
		return null;

	}
}
