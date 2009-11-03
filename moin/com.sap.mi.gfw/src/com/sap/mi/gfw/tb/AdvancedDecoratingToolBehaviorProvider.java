package com.sap.mi.gfw.tb;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;

import com.sap.mi.fwk.MarkerManager;
import com.sap.mi.fwk.MarkerManager.MarkerRefreshListener;
import com.sap.mi.gfw.dt.IDiagramTypeProvider;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.platform.IPlatformImageConstants;
import com.sap.mi.gfw.util.T;

/**
 * The Class AdvancedDecoratingToolBehaviorProvider.
 */
public class AdvancedDecoratingToolBehaviorProvider extends AdvancedToolBehaviorProvider {

	/**
	 * Instantiates a new advanced decorating tool behavior provider.
	 * 
	 * @param diagramTypeProvider
	 *            the diagram type provider
	 */
	public AdvancedDecoratingToolBehaviorProvider(IDiagramTypeProvider diagramTypeProvider) {
		super(diagramTypeProvider);
	}

	private final class GfwMarkerRefreshListener implements MarkerRefreshListener {
		private final IFeatureProvider provider;

		GfwMarkerRefreshListener(IFeatureProvider provider) {
			this.provider = provider;
		}

		public void onMarkerChange(IProject affectedProject) {
			provider.getDiagramTypeProvider().getDiagramEditor().refresh();
		}
	}

	private MarkerRefreshListener markerRefreshListener;

	/*
	 * FUNCTIONALITY SWITCHED OFF UX has to decide, if and how quick-fixes are offered as context buttons.
	 * 
	 * @Override public IContextButtonPadData getContextButtonPadData(IPictogramElementContext context) { final String SIGNATURE =
	 * "getContextButtonPadData(IPictogramElementContext)"; //$NON-NLS-1$ boolean info = T.racer().info(); if (info) {
	 * T.racer().entering(AdvancedToolBehaviorProvider.class, SIGNATURE, new Object[] { context }); }
	 * 
	 * IContextButtonPadData ret = super.getContextButtonPadData(context); PictogramElement pe = context.getPictogramElement();
	 * 
	 * CustomContext customContext = new CustomContext(new PictogramElement[] { pe }); ICustomFeature[] customFeatures =
	 * getFeatureProvider().getCustomFeatures(customContext); int featureCount = customFeatures.length; for (int i = 0; i < featureCount;
	 * i++) { ICustomFeature customFeature = customFeatures[i]; if (customFeature.isAvailable(customContext)) { if (customFeature instanceof
	 * QuickFixFeature) { if (customFeature.canExecute(customContext)) { ContextButtonEntry contextButtonEntry = new
	 * ContextButtonEntry(customFeature, customContext); contextButtonEntry.setText(customFeature.getName());
	 * contextButtonEntry.setDescription(customFeature.getDescription());
	 * contextButtonEntry.setIconId(IPlatformImageConstants.IMG_ECLIPSE_QUICKASSIST);
	 * ret.getDomainSpecificContextButtons().add(contextButtonEntry); } } } }
	 * 
	 * if (info) { T.racer().exiting(AdvancedToolBehaviorProvider.class, SIGNATURE, ret); }
	 * 
	 * return ret; }
	 */

	/**
	 * Gets the rendering decorator.
	 * 
	 * @param severity
	 *            the severity
	 * @return the rendering decorator
	 */
	public IRenderingDecorator getRenderingDecorator(int severity) {
		switch (severity) {
		case IMarker.SEVERITY_ERROR:
			return new ImageRenderingDecorator(IPlatformImageConstants.IMG_ECLIPSE_ERROR_TSK);
		case IMarker.SEVERITY_WARNING:
			return new ImageRenderingDecorator(IPlatformImageConstants.IMG_ECLIPSE_WARNING_TSK);
		case IMarker.SEVERITY_INFO:
			return new ImageRenderingDecorator(IPlatformImageConstants.IMG_ECLIPSE_INFORMATION_TSK);
		default:
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.DefaultToolBehaviorProvider#getRenderingDecorators(com.sap.mi.gfw.mm.pictograms.PictogramElement)
	 */
	@Override
	public IRenderingDecorator[] getRenderingDecorators(PictogramElement pe) {
		final String SIGNATURE = "getContextButtons(PictogramElement)"; //$NON-NLS-1$
		boolean info = T.racer().info();
		if (info) {
			T.racer().entering(DefaultToolBehaviorProvider.class, SIGNATURE, new Object[] { pe });
		}
		IRenderingDecorator[] ret = null;
		IFeatureProvider featureProvider = getFeatureProvider();
		initMarkerListenerLazy(featureProvider);
		Object bo = featureProvider.getBusinessObjectForPictogramElement(pe);
		IRenderingDecorator imageRenderingDecorator = null;
		if (pe.isActive() && bo instanceof RefBaseObject) {
			int maxSeverity = MarkerManager.getInstance().findMaxProblemSeverity((RefBaseObject) bo, IMarker.PROBLEM, true,
					IResource.DEPTH_INFINITE);

			imageRenderingDecorator = getRenderingDecorator(maxSeverity);
			if (imageRenderingDecorator != null) {
				ret = new IRenderingDecorator[] { imageRenderingDecorator };
				if (info) {
					T.racer().exiting(DefaultToolBehaviorProvider.class, SIGNATURE, ret);
				}
				return ret;
			}
		}
		ret = super.getRenderingDecorators(pe);
		if (info) {
			T.racer().exiting(DefaultToolBehaviorProvider.class, SIGNATURE, ret);
		}
		return ret;
	}

	/**
	 * Inits the marker listener lazy.
	 * 
	 * @param featureProvider
	 *            the feature provider
	 */
	protected void initMarkerListenerLazy(final IFeatureProvider featureProvider) {
		if (markerRefreshListener == null) {
			markerRefreshListener = new GfwMarkerRefreshListener(featureProvider);
			MarkerManager.getInstance().addRefreshListener(markerRefreshListener);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.DefaultToolBehaviorProvider#dispose()
	 */
	@Override
	public void dispose() {
		if (markerRefreshListener != null) {
			MarkerManager.getInstance().removeRefreshListener(markerRefreshListener);
		}
		super.dispose();
	}

}
