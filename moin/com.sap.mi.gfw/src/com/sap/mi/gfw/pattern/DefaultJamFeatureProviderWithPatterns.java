package com.sap.mi.gfw.pattern;

import java.util.ArrayList;
import java.util.List;

import com.sap.mi.gfw.dt.IDiagramTypeProvider;
import com.sap.mi.gfw.features.IAddFeature;
import com.sap.mi.gfw.features.ICreateConnectionFeature;
import com.sap.mi.gfw.features.ICreateFeature;
import com.sap.mi.gfw.features.IDirectEditingInfo;
import com.sap.mi.gfw.features.IFeature;
import com.sap.mi.gfw.features.ILayoutFeature;
import com.sap.mi.gfw.features.IMoveShapeFeature;
import com.sap.mi.gfw.features.IResizeShapeFeature;
import com.sap.mi.gfw.features.IUpdateFeature;
import com.sap.mi.gfw.features.context.IAddContext;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.ILayoutContext;
import com.sap.mi.gfw.features.context.IMoveShapeContext;
import com.sap.mi.gfw.features.context.IResizeShapeContext;
import com.sap.mi.gfw.features.context.IUpdateContext;
import com.sap.mi.gfw.features.jam.DefaultJAMFeatureProvider;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.util.T;

/**
 * The Class DefaultJamFeatureProviderWithPatterns.
 */
public class DefaultJamFeatureProviderWithPatterns extends DefaultJAMFeatureProvider implements IFeatureProviderWithPatterns {

	private List<IPattern> patterns;

	private List<IConnectionPattern> connectionPatters;

	/**
	 * Instantiates a new default jam feature provider with patterns.
	 * 
	 * @param dtp
	 *            the dtp
	 */
	public DefaultJamFeatureProviderWithPatterns(IDiagramTypeProvider dtp) {
		super(dtp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pattern.IPatternContainer#addPattern(com.sap.mi.gfw.pattern.IPattern)
	 */
	public void addPattern(IPattern pattern) {
		pattern.setFeatureProvider(this);
		getPatterns().add(pattern);
	}

	/**
	 * Adds the connection pattern.
	 * 
	 * @param pattern
	 *            the pattern
	 */
	public void addConnectionPattern(IConnectionPattern pattern) {
		pattern.setFeatureProvider(this);
		getConnectionPatterns().add(pattern);
	}

	private boolean checkFeature(IFeature feature) {
		boolean ret = (feature != null); // feature.isAvailable(context);
		return ret;
	}

	/**
	 * Check feature and context.
	 * 
	 * @param feature
	 *            the feature
	 * @param context
	 *            the context
	 * 
	 * @return true, if successful
	 */
	protected boolean checkFeatureAndContext(IFeature feature, IContext context) {
		boolean featureOkay = checkFeature(feature);
		boolean featureAvailable = feature.isAvailable(context);
		boolean ret = featureOkay && featureAvailable;
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.impl.AbstractFeatureProvider#getAddFeature(com.sap.mi.gfw.features.context.IAddContext) Prefer
	 * overriding getAddFeatureAdditional instead of overriding this method.
	 */
	@Override
	public IAddFeature getAddFeature(IAddContext context) {
		IAddFeature ret = null;
		for (IPattern pattern : getPatterns()) {
			if (checkPattern(pattern, context.getNewObject())) {
				IPattern choosenPattern = null;
				IAddFeature f = new AddFeatureForPattern(this, pattern);
				boolean executable = checkFeatureAndContext(f, context);
				if (executable) {
					if (ret == null) {
						ret = f;
						choosenPattern = pattern;
					} else {
						traceWarning("getAddFeature", pattern, choosenPattern); //$NON-NLS-1$
					}
				}
			}
		}
		if (ret == null) {
			for (IConnectionPattern conPattern : getConnectionPatterns()) {
				if (conPattern.canAdd(context))
					return new AddFeatureForPattern(this, conPattern);
			}
		}

		if (ret == null) {
			ret = getAddFeatureAdditional(context);
		}

		return ret;
	}

	/**
	 * Trace warning.
	 * 
	 * @param string
	 *            the string
	 * @param pattern
	 *            the pattern
	 * @param choosenPattern
	 *            the choosen pattern
	 */
	protected void traceWarning(String string, IPattern pattern, IPattern choosenPattern) {
		T.racer().warning(string + ": " + "Pattern " + pattern + " is executable additionally to pattern " + choosenPattern + "."); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	}

	/**
	 * Gets the adds the feature additional.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @return the adds the feature additional
	 */
	protected IAddFeature getAddFeatureAdditional(IAddContext context) {
		return super.getAddFeature(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.impl.AbstractFeatureProvider#getCreateFeatures()
	 */
	@Override
	public final ICreateFeature[] getCreateFeatures() {
		ICreateFeature[] ret = new ICreateFeature[0];
		List<ICreateFeature> retList = new ArrayList<ICreateFeature>();

		for (IPattern pattern : getPatterns()) {
			retList.add(new CreateFeatureForPattern(this, pattern));
		}

		ICreateFeature[] a = getCreateFeaturesAdditional();
		for (ICreateFeature element : a) {
			retList.add(element);
		}

		return retList.toArray(ret);
	}

	/**
	 * Gets the creates the features additional.
	 * 
	 * @return the creates the features additional
	 */
	protected ICreateFeature[] getCreateFeaturesAdditional() {
		ICreateFeature[] ret = new ICreateFeature[0];
		List<ICreateFeature> retList = new ArrayList<ICreateFeature>();
		ICreateFeature[] s = super.getCreateFeatures();
		for (ICreateFeature element : s) {
			retList.add(element);
		}
		return retList.toArray(ret);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.impl.AbstractFeatureProvider#getLayoutFeature(com.sap.mi.gfw.features.context.ILayoutContext) Prefer
	 * overriding getLayoutFeatureAdditional instead of overriding this method.
	 */
	@Override
	public ILayoutFeature getLayoutFeature(ILayoutContext context) {
		ILayoutFeature ret = null;
		for (IPattern pattern : getPatterns()) {
			if (checkPattern(pattern, getBusinessObjectForPictogramElement(context.getPictogramElement()))) {
				IPattern choosenPattern = null;
				ILayoutFeature f = new LayoutFeatureForPattern(this, pattern);
				if (checkFeatureAndContext(f, context)) {
					if (ret == null) {
						ret = f;
						choosenPattern = pattern;
					} else {
						traceWarning("getLayoutFeature", pattern, choosenPattern); //$NON-NLS-1$
					}
				}
			}
		}

		if (ret == null) {
			ret = getLayoutFeatureAdditional(context);
		}

		return ret;
	}

	/**
	 * Gets the layout feature additional.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @return the layout feature additional
	 */
	protected ILayoutFeature getLayoutFeatureAdditional(ILayoutContext context) {
		return super.getLayoutFeature(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.jam.DefaultJAMFeatureProvider#getMoveShapeFeature(com.sap.mi.gfw.features.context.IMoveShapeContext)
	 * Prefer overriding getMoveShapeFeatureAdditional instead of overriding this method.
	 */
	@Override
	public IMoveShapeFeature getMoveShapeFeature(IMoveShapeContext context) {
		IMoveShapeFeature ret = null;
		for (IPattern pattern : getPatterns()) {
			if (checkPattern(pattern, getBusinessObjectForPictogramElement(context.getPictogramElement()))) {
				IPattern choosenPattern = null;
				IMoveShapeFeature f = new MoveShapeFeatureForPattern(this, pattern);
				if (checkFeatureAndContext(f, context)) {
					if (ret == null) {
						ret = f;
						choosenPattern = pattern;
					} else {
						traceWarning("getMoveShapeFeature", pattern, choosenPattern); //$NON-NLS-1$
					}
				}
			}
		}

		if (ret == null) {
			ret = getMoveShapeFeatureAdditional(context);
		}

		return ret;
	}

	/**
	 * Gets the move shape feature additional.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @return the move shape feature additional
	 */
	protected IMoveShapeFeature getMoveShapeFeatureAdditional(IMoveShapeContext context) {
		return super.getMoveShapeFeature(context);
	}

	/**
	 * Gets the patterns.
	 * 
	 * @return the patterns
	 */
	protected List<IPattern> getPatterns() {
		if (patterns == null) {
			patterns = new ArrayList<IPattern>();
		}
		return patterns;
	}

	/**
	 * Gets the connection patterns.
	 * 
	 * @return the patterns
	 */
	protected List<IConnectionPattern> getConnectionPatterns() {
		if (connectionPatters == null) {
			connectionPatters = new ArrayList<IConnectionPattern>();
		}
		return connectionPatters;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.jam.DefaultJAMFeatureProvider#getResizeShapeFeature(com.sap.mi.gfw.features.context.IResizeShapeContext)
	 * Prefer overriding getResizeShapeFeatureAdditional instead of overriding this method.
	 */
	@Override
	public IResizeShapeFeature getResizeShapeFeature(IResizeShapeContext context) {
		IResizeShapeFeature ret = null;
		for (IPattern pattern : getPatterns()) {
			if (checkPattern(pattern, getBusinessObjectForPictogramElement(context.getPictogramElement()))) {
				IPattern choosenPattern = null;
				IResizeShapeFeature f = new ResizeShapeFeatureForPattern(this, pattern);
				if (checkFeatureAndContext(f, context)) {
					if (ret == null) {
						ret = f;
						choosenPattern = pattern;
					} else {
						traceWarning("getResizeShapeFeature", pattern, choosenPattern); //$NON-NLS-1$
					}
				}
			}
		}

		if (ret == null) {
			ret = getResizeShapeFeatureAdditional(context);
		}

		return ret;
	}

	/**
	 * Check pattern.
	 * 
	 * @param pattern
	 *            the pattern
	 * @param object
	 *            the object
	 * 
	 * @return true, if successful
	 */
	protected boolean checkPattern(IPattern pattern, Object object) {
		return pattern.isMainBusinessObjectApplicable(object);
	}

	/**
	 * Gets the resize shape feature additional.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @return the resize shape feature additional
	 */
	protected IResizeShapeFeature getResizeShapeFeatureAdditional(IResizeShapeContext context) {
		return super.getResizeShapeFeature(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.impl.AbstractFeatureProvider#getUpdateFeature(com.sap.mi.gfw.features.context.IUpdateContext) Prefer
	 * overriding getUpdateFeatureAdditional instead of overriding this method.
	 */
	@Override
	public IUpdateFeature getUpdateFeature(IUpdateContext context) {
		IUpdateFeature ret = null;
		Object businessObject = getBusinessObjectForPictogramElement(context.getPictogramElement());
		for (IPattern pattern : getPatterns()) {
			if (checkPattern(pattern, businessObject) || pattern.canUpdate(context)) {
				IPattern choosenPattern = null;
				IUpdateFeature f = new UpdateFeatureForPattern(this, pattern);
				if (checkFeatureAndContext(f, context)) {
					if (ret == null) {
						ret = f;
						choosenPattern = pattern;
					} else {
						traceWarning("getUpdateFeature", pattern, choosenPattern); //$NON-NLS-1$
					}
				}
			}
		}

		if (ret == null) {
			ret = getUpdateFeatureAdditional(context);
		}

		return ret;
	}

	/**
	 * Gets the update feature additional.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @return the update feature additional
	 */
	protected IUpdateFeature getUpdateFeatureAdditional(IUpdateContext context) {
		return super.getUpdateFeature(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pattern.IFeatureProviderWithPatterns#getPatternForPictogramElement(com.sap.mi.gfw.mm.pictograms.PictogramElement)
	 */
	public IPattern getPatternForPictogramElement(PictogramElement pe) {
		for (IPattern pattern : getPatterns()) {
			if (pattern instanceof AbstractPattern) {
				AbstractPattern ap = (AbstractPattern) pattern;
				if (ap.isPatternRoot(pe))
					return pattern;
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sap.mi.gfw.pattern.IFeatureProviderWithPatterns#activateDirectEditingForPatterns(com.sap.mi.gfw.mm.pictograms.PictogramElement,
	 * java.lang.Object)
	 */
	public void activateDirectEditingForPatterns(PictogramElement mainPictogramElement, Object bo) {
		IPattern pattern = getPatternForPictogramElement(mainPictogramElement);
		if (pattern != null) {
			IDirectEditingInfo dei = getDirectEditingInfo();
			dei.setMainPictogramElement(mainPictogramElement);
			pattern.completeInfo(dei, bo);
			dei.setActive(true);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sap.mi.gfw.pattern.IFeatureProviderWithPatterns#activateDirectEditingForPatterns(com.sap.mi.gfw.mm.pictograms.PictogramElement,
	 * java.lang.Object, java.lang.String)
	 */
	public void activateDirectEditingForPatterns(PictogramElement mainPictogramElement, Object bo, String keyProperty) {
		IPattern pattern = getPatternForPictogramElement(mainPictogramElement);
		if (pattern != null) {
			IDirectEditingInfo dei = getDirectEditingInfo();
			dei.setMainPictogramElement(mainPictogramElement);
			pattern.completeInfo(dei, bo, keyProperty);
			dei.setActive(true);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.impl.AbstractFeatureProvider#getCreateConnectionFeatures()
	 */
	@Override
	public ICreateConnectionFeature[] getCreateConnectionFeatures() {
		ICreateConnectionFeature[] ret = new ICreateConnectionFeature[0];
		List<ICreateConnectionFeature> retList = new ArrayList<ICreateConnectionFeature>();

		for (IConnectionPattern conPattern : getConnectionPatterns()) {
			retList.add(new CreateConnectionFeatureForPattern(this, conPattern));
		}

		ICreateConnectionFeature[] a = getCreateConnectionFeaturesAdditional();
		for (ICreateConnectionFeature element : a) {
			retList.add(element);
		}

		return retList.toArray(ret);
	}

	/**
	 * Gets the creates the connection features additional.
	 * 
	 * @return the creates the connection features additional
	 */
	protected ICreateConnectionFeature[] getCreateConnectionFeaturesAdditional() {
		return super.getCreateConnectionFeatures();
	}

}
