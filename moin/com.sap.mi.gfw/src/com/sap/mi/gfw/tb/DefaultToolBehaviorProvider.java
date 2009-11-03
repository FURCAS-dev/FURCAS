/*
 * Created on 28.06.2005
 */
package com.sap.mi.gfw.tb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.sap.mi.gfw.DiagramScrollingBehavior;
import com.sap.mi.gfw.Messages;
import com.sap.mi.gfw.datatypes.IInsets;
import com.sap.mi.gfw.datatypes.ILocation;
import com.sap.mi.gfw.datatypes.impl.LocationImpl;
import com.sap.mi.gfw.dt.IDiagramTypeProvider;
import com.sap.mi.gfw.ei.IExecutionInfo;
import com.sap.mi.gfw.features.ICreateConnectionFeature;
import com.sap.mi.gfw.features.ICreateFeature;
import com.sap.mi.gfw.features.IFeature;
import com.sap.mi.gfw.features.IFeatureAndContext;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.ILongRunning;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.features.context.IDoubleClickContext;
import com.sap.mi.gfw.features.context.IPictogramElementContext;
import com.sap.mi.gfw.features.custom.ICustomFeature;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.LineStyleEnum;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Shape;
import com.sap.mi.gfw.palette.IPaletteCompartmentEntry;
import com.sap.mi.gfw.palette.impl.ConnectionCreationToolEntry;
import com.sap.mi.gfw.palette.impl.ObjectCreationToolEntry;
import com.sap.mi.gfw.palette.impl.PaletteCompartmentEntry;
import com.sap.mi.gfw.util.IColorConstant;
import com.sap.mi.gfw.util.ILocationInfo;
import com.sap.mi.gfw.util.PeUtil;
import com.sap.mi.gfw.util.T;

/**
 * The Class DefaultToolBehaviorProvider.
 */
public class DefaultToolBehaviorProvider implements IToolBehaviorProvider {

	protected int THRESHOLD_FOR_LONG_RUNNING_OPERATION = 20;

	private static final IRenderingDecorator[] NO_RENDERING_DECORATORS = new IRenderingDecorator[0];

	private static double[] ZOOM_LEVELS = { 0.01, 0.1, 0.2, 0.5, 0.75, 1.0, 1.5, 2.0, 2.5, 3.0, 4.0, 10.0 };

	/**
	 * Identifier for a generic context button, used in {@link #addGenericContextButtons(IContextButtonPadData, PictogramElement)}.
	 */
	protected static int CONTEXT_BUTTON_UPDATE = 1 << 1;

	/**
	 * Identifier for a generic context button, used in {@link #addGenericContextButtons(IContextButtonPadData, PictogramElement)}.
	 */
	protected static int CONTEXT_BUTTON_REMOVE = 1 << 2;

	/**
	 * Identifier for a generic context button, used in {@link #addGenericContextButtons(IContextButtonPadData, PictogramElement)}.
	 */
	protected static int CONTEXT_BUTTON_DELETE = 1 << 3;

	/**
	 * The Constant NO_CONTEXT_MENU_ENTRIES.
	 */
	protected static final IContextMenuEntry[] NO_CONTEXT_MENU_ENTRIES = new IContextMenuEntry[0];

	private IDiagramTypeProvider diagramTypeProvider;

	/**
	 * Instantiates a new default tool behavior provider.
	 * 
	 * @param diagramTypeProvider
	 *            the diagram type provider
	 */
	public DefaultToolBehaviorProvider(IDiagramTypeProvider diagramTypeProvider) {
		super();
		setDiagramTypeProvider(diagramTypeProvider);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.IToolBehaviorProvider#dispose()
	 */
	public void dispose() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.IToolBehaviorProvider#getAdapter(java.lang.Class)
	 */
	public Object getAdapter(Class type) {
		return null;
	}

	/**
	 * @deprecated This method is not longer used in the new context button implementation. Use
	 *             {@link #getContextButtonPadData(IPictogramElementContext)} instead.
	 */
	@Deprecated
	public IContextButtonEntry[] getContextButtons(IContext context) {
		return new IContextButtonEntry[0];
	}

	/**
	 * @deprecated This method is not longer used in the new context button implementation. Use
	 *             {@link #getContextButtonPadData(IPictogramElementContext)} instead.
	 */
	@Deprecated
	public PictogramElement getAlternativeContextButtonLocation(PictogramElement originalPe) {
		return originalPe;
	}

	/**
	 * @deprecated This method is not longer used in the new context button implementation. Use
	 *             {@link #getContextButtonPadData(IPictogramElementContext)} instead.
	 */
	@Deprecated
	public IInsets getContextButtonInsets(PictogramElement pe) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.IToolBehaviorProvider#getAlternativeSelection(com.sap.mi.gfw.mm.pictograms.PictogramElement,
	 * com.sap.mi.gfw.mm.pictograms.PictogramElement[])
	 */
	public PictogramElement getAlternativeSelection(PictogramElement originalPe, PictogramElement[] oldSelection) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.IToolBehaviorProvider#getConnectionSelectionInfo(com.sap.mi.gfw.mm.pictograms.Connection)
	 */
	public ISelectionInfo getConnectionSelectionInfo(Connection connection) {
		ISelectionInfo si = new SelectionInfoImpl(IColorConstant.CONNECTION_SELECTION_FG, IColorConstant.HANDLE_FG,
				IColorConstant.HANDLE_BG, LineStyleEnum.DASH);
		return si;
	}

	/**
	 * Returns the context button pad data for the given pictogram element context. This default implementation sets the pad-location to the
	 * bounds to the selection graphics algorithm or the pictogram element (see {@link #getSelectionGraphicsAlgorithm(PictogramElement)}) or
	 * if not defined to the graphics algorithm associated directly the pictogram element. Note, that the pad-location must be given in
	 * absolute coordinates, which can be calculated using {@link #getAbsoluteLocation(GraphicsAlgorithm)}.
	 * 
	 * @return The context button pad data for the given pictogram element context.
	 */
	public IContextButtonPadData getContextButtonPadData(IPictogramElementContext context) {
		final String SIGNATURE = "getContextButtonPadData(IPictogramElementContext)"; //$NON-NLS-1$
		boolean info = T.racer().info();
		if (info) {
			T.racer().entering(DefaultToolBehaviorProvider.class, SIGNATURE, new Object[] { context });
		}

		IContextButtonPadData ret = new DefaultContextButtonPadData();

		PictogramElement pe = context.getPictogramElement();
		GraphicsAlgorithm ga = getSelectionGraphicsAlgorithm(pe);
		if (ga == null) {
			ga = pe.getGraphicsAlgorithm();
		}

		// set default location
		if (ga != null) {
			ILocation origin = getAbsoluteLocation(ga);
			ret.getPadLocation().setRectangle(origin.getX(), origin.getY(), ga.getWidth(), ga.getHeight());
		}

		// set default generic context buttons
		setGenericContextButtons(ret, pe, CONTEXT_BUTTON_DELETE | CONTEXT_BUTTON_REMOVE | CONTEXT_BUTTON_UPDATE);

		if (info) {
			T.racer().exiting(DefaultToolBehaviorProvider.class, SIGNATURE, ret);
		}

		return ret;
	}

	/**
	 * Sets the defined generic context buttons to the given IContextButtonPadData. You should never change the list of generic context
	 * buttons directly but always use this method. This ensures, that only the 'generic' context buttons are set and that they have the
	 * correct ordering.
	 * 
	 * @param data
	 *            The IContextButtonPadData to which to set the generic context buttons.
	 * @param pe
	 *            The pictogram element for which to get the underlying features of the context buttons.
	 * @param identifiers
	 *            The context button identifiers (e.g. "{@link #CONTEXT_BUTTON_UPDATE} & {@link #CONTEXT_BUTTON_REMOVE}")
	 */
	protected void setGenericContextButtons(IContextButtonPadData data, PictogramElement pe, int identifiers) {
		data.getGenericContextButtons().clear();

		// update button
		if ((identifiers & CONTEXT_BUTTON_UPDATE) != 0) {
			IContextButtonEntry updateButton = ContextEntryHelper.createDefaultUpdateContextButton(getFeatureProvider(), pe);
			if (updateButton != null) {
				data.getGenericContextButtons().add(updateButton);
			}
		}

		// remove button
		if ((identifiers & CONTEXT_BUTTON_REMOVE) != 0) {
			IContextButtonEntry removeButton = ContextEntryHelper.createDefaultRemoveContextButton(getFeatureProvider(), pe);
			if (removeButton != null) {
				data.getGenericContextButtons().add(removeButton);
			}
		}

		// delete button
		if ((identifiers & CONTEXT_BUTTON_DELETE) != 0) {
			IContextButtonEntry deleteButton = ContextEntryHelper.createDefaultDeleteContextButton(getFeatureProvider(), pe);
			if (deleteButton != null) {
				data.getGenericContextButtons().add(deleteButton);
			}
		}
	}

	/**
	 * Returns the location of the graphics algorithm associated to the pictogram element in absolute coordinates. Also see
	 * {@link #getAbsoluteLocation(GraphicsAlgorithm)}.
	 * 
	 * @param pe
	 *            The pictogram element, for which graphics algorithm to return the location.
	 * @return The location of the graphics algorithm associated to the pictogram element in absolute coordinates.
	 */
	protected ILocation getAbsoluteLocation(PictogramElement pe) {
		return getAbsoluteLocation(pe.getGraphicsAlgorithm());
	}

	/**
	 * Returns the location of the graphics algorithm in absolute coordinates.
	 * 
	 * @param ga
	 *            The graphics algorithm for which to return the location.
	 * @return The location of the graphics algorithm in absolute coordinates.
	 */
	protected ILocation getAbsoluteLocation(GraphicsAlgorithm ga) {
		ILocation ret = new LocationImpl(0, 0);
		while (ga != null) {
			ret.setX(ret.getX() + ga.getX());
			ret.setY(ret.getY() + ga.getY());
			PictogramElement pe = ga.getPictogramElement();
			if (pe != null) {
				PictogramElement parent = PeUtil.getPictogramElementParent(pe);
				if (parent != null) {
					ga = parent.getGraphicsAlgorithm();
				} else {
					ga = null;
				}
			} else {
				ga = ga.getParentGraphicsAlgorithm();
			}
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.IToolBehaviorProvider#getContextMenu(com.sap.mi.gfw.features.context.IContext)
	 */
	public IContextMenuEntry[] getContextMenu(IContext context) {
		final String SIGNATURE = "getContextMenu(IContext)"; //$NON-NLS-1$
		boolean info = T.racer().info();
		if (info) {
			T.racer().entering(DefaultToolBehaviorProvider.class, SIGNATURE, new Object[] { context });
		}
		IContextMenuEntry[] ret = NO_CONTEXT_MENU_ENTRIES;
		List<IContextMenuEntry> retList = new ArrayList();

		// custom features
		if (context instanceof ICustomContext) {
			ICustomContext customContext = (ICustomContext) context;
			ICustomFeature[] customFeatures = getFeatureProvider().getCustomFeatures(customContext);
			for (int i = 0; i < customFeatures.length; i++) {
				ICustomFeature customFeature = customFeatures[i];
				if (isContextMenuApplicable(customFeature)) {
					retList.add(new ContextMenuEntry(customFeature, context));
				}
			}
		}

		ret = retList.toArray(NO_CONTEXT_MENU_ENTRIES);
		if (info) {
			T.racer().exiting(DefaultToolBehaviorProvider.class, SIGNATURE, ret);
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.IToolBehaviorProvider#getDefaultLocationInfoForDirectEditing(com.sap.mi.gfw.mm.pictograms.PictogramElement,
	 * com.sap.mi.gfw.util.ILocationInfo)
	 */
	public ILocationInfo getDefaultLocationInfoForDirectEditing(PictogramElement pe, ILocationInfo locationInfo) {
		return locationInfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.IToolBehaviorProvider#getDoubleClickFeature(com.sap.mi.gfw.features.context.IDoubleClickContext)
	 */
	public ICustomFeature getDoubleClickFeature(IDoubleClickContext context) {
		return null;
	}

	/**
	 * Default implementation: creates a connection and an object compartment. Adds all connection creation features and creation features.
	 * 
	 * @return the palette compartments
	 */
	public IPaletteCompartmentEntry[] getPaletteCompartments() {
		final String SIGNATURE = "getPaletteCompartments()"; //$NON-NLS-1$
		boolean info = T.racer().info();
		if (info) {
			T.racer().entering(DefaultToolBehaviorProvider.class, SIGNATURE, new Object[0]);
		}
		List<IPaletteCompartmentEntry> compartments = new ArrayList<IPaletteCompartmentEntry>();

		PaletteCompartmentEntry compartmentEntry = new PaletteCompartmentEntry(Messages.DefaultToolBehaviorProvider_0_xfld, null);
		compartments.add(compartmentEntry);

		IFeatureProvider featureProvider = getFeatureProvider();
		ICreateConnectionFeature[] createConnectionFeatures = featureProvider.getCreateConnectionFeatures();
		if (createConnectionFeatures.length > 0) {

			// ConnectionCreationToolEntry multiTool = null;
			// if (createConnectionFeatures.length > 1) {
			// multiTool = new ConnectionCreationToolEntry("Connection",
			// "dynamic connection", null);
			// compartmentEntry.addToolEntry(multiTool);
			// }

			for (ICreateConnectionFeature createConnectionFeature : createConnectionFeatures) {
				ConnectionCreationToolEntry ccTool = new ConnectionCreationToolEntry(createConnectionFeature.getCreateName(),
						createConnectionFeature.getCreateDescription(), createConnectionFeature.getCreateImageId(), createConnectionFeature
								.getCreateLargeImageId());
				ccTool.addCreateConnectionFeature(createConnectionFeature);
				// if (multiTool != null) {
				// multiTool.addCreateConnectionFeature(createConnectionFeature);
				// }
				compartmentEntry.addToolEntry(ccTool);
			}

		}

		compartmentEntry = new PaletteCompartmentEntry(Messages.DefaultToolBehaviorProvider_1_xfld, null);
		compartments.add(compartmentEntry);

		ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();

		for (ICreateFeature createFeature : createFeatures) {
			ObjectCreationToolEntry objectCreationToolEntry = new ObjectCreationToolEntry(createFeature.getCreateName(), createFeature
					.getCreateDescription(), createFeature.getCreateImageId(), createFeature.getCreateLargeImageId(), createFeature);

			compartmentEntry.addToolEntry(objectCreationToolEntry);

		}

		IPaletteCompartmentEntry[] res = compartments.toArray(new IPaletteCompartmentEntry[compartments.size()]);
		if (info) {
			T.racer().exiting(DefaultToolBehaviorProvider.class, SIGNATURE, res);
		}
		return res;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.IToolBehaviorProvider#getRenderingDecorators(com.sap.mi.gfw.mm.pictograms.PictogramElement)
	 */
	public IRenderingDecorator[] getRenderingDecorators(PictogramElement pe) {
		return NO_RENDERING_DECORATORS;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.IToolBehaviorProvider#getShapeSelectionInfo(com.sap.mi.gfw.mm.pictograms.Shape)
	 */
	public ISelectionInfo getShapeSelectionInfo(Shape shape) {
		ISelectionInfo si = new SelectionInfoImpl(IColorConstant.SHAPE_SELECTION_FG, IColorConstant.HANDLE_FG, IColorConstant.HANDLE_BG,
				LineStyleEnum.DASH);
		return si;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.IToolBehaviorProvider#getZoomLevels()
	 */
	public double[] getZoomLevels() {
		return ZOOM_LEVELS;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.IToolBehaviorProvider#getDiagramScrollingBehavior()
	 */
	public DiagramScrollingBehavior getDiagramScrollingBehavior() {
		return DiagramScrollingBehavior.GEF_DEFAULT;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.IToolBehaviorProvider#isPaletteApplicable(com.sap.mi.gfw.features.IFeature)
	 */
	public boolean isPaletteApplicable(IFeature feature) {
		return (feature instanceof ICreateFeature);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.IToolBehaviorProvider#isToolbarApplicable(com.sap.mi.gfw.features.IFeature)
	 */
	public boolean isToolbarApplicable(IFeature feature) {
		return false;
	}

	private void setDiagramTypeProvider(IDiagramTypeProvider diagramTypeProvider) {
		this.diagramTypeProvider = diagramTypeProvider;
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
	 * Gets the feature provider.
	 * 
	 * @return the feature provider
	 */
	protected IFeatureProvider getFeatureProvider() {
		return getDiagramTypeProvider().getFeatureProvider();
	}

	/**
	 * Checks if is context menu applicable.
	 * 
	 * @param feature
	 *            the feature
	 * @return true, if is context menu applicable
	 */
	protected boolean isContextMenuApplicable(IFeature feature) {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.IToolBehaviorProvider#preExecute(com.sap.mi.gfw.ei.IExecutionInfo)
	 */
	public void preExecute(IExecutionInfo executionInfo) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.IToolBehaviorProvider#postExecute(com.sap.mi.gfw.ei.IExecutionInfo)
	 */
	public void postExecute(IExecutionInfo executionInfo) {
	}

	/**
	 * Gets the tool tip.
	 * 
	 * @param ga
	 *            the ga
	 * @return the tool tip
	 * @see com.sap.mi.gfw.tb.IToolBehaviorProvider#getToolTip(com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm)
	 */
	public String getToolTip(GraphicsAlgorithm ga) {
		return null;
	}

	/**
	 * Gets the selection graphics algorithm.
	 * 
	 * @param pe
	 *            the pe
	 * @return the selection graphics algorithm
	 * @see com.sap.mi.gfw.tb.IToolBehaviorProvider#getSelectionGraphicsAlgorithm(com.sap.mi.gfw.mm.pictograms.PictogramElement)
	 */
	public GraphicsAlgorithm getSelectionGraphicsAlgorithm(PictogramElement pe) {
		return null;
	}

	/**
	 * Gets the selection area.
	 * 
	 * @param pe
	 *            the pe
	 * @return the selection area
	 * @see com.sap.mi.gfw.tb.IToolBehaviorProvider#getSelectionArea(com.sap.mi.gfw.mm.pictograms.PictogramElement)
	 */
	public GraphicsAlgorithm[] getSelectionArea(PictogramElement pe) {
		GraphicsAlgorithm graphicsAlgorithm = pe.getGraphicsAlgorithm();
		if (graphicsAlgorithm != null) {
			return new GraphicsAlgorithm[] { graphicsAlgorithm };
		}
		return new GraphicsAlgorithm[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.IToolBehaviorProvider#isLongRunningOperation(com.sap.mi.gfw.ei.IExecutionInfo)
	 */
	public boolean isLongRunningOperation(IExecutionInfo executionInfo) {
		final String SIGNATURE = "isLongRunningOperation(IExecutionInfo)"; //$NON-NLS-1$
		boolean info = T.racer().info();
		if (info) {
			T.racer().entering(DefaultToolBehaviorProvider.class, SIGNATURE, new Object[] { executionInfo });
		}
		boolean ret = false;
		IFeatureAndContext[] featureAndContextArray = executionInfo.getExecutionList();

		for (IFeatureAndContext featureAndContext : featureAndContextArray) {
			if (featureAndContext.getFeature() instanceof ILongRunning) {
				ret = true;
				break;
			}
		}

		// if no feature implements ILongRunning, determine if this operation is
		// a long running one by considering the amount of involved features
		if (featureAndContextArray.length >= THRESHOLD_FOR_LONG_RUNNING_OPERATION) {
			ret = true;
		}
		if (info) {
			T.racer().exiting(DefaultToolBehaviorProvider.class, SIGNATURE, ret);
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.IToolBehaviorProvider#getChopboxAnchorGraphicsAlgorithm(com.sap.mi.gfw.mm.pictograms.PictogramElement)
	 */
	public GraphicsAlgorithm getChopboxAnchorGraphicsAlgorithm(PictogramElement pe) {
		return pe.getGraphicsAlgorithm();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.IToolBehaviorProvider#getTitleToolTip()
	 */
	public String getTitleToolTip() {
		return null;
	}

	public Collection<IToolbarEntry> getToolbarEntries() {
		return Collections.EMPTY_LIST;
	}

	public boolean isShowGuides() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.IToolBehaviorProvider#getContentGraphicsAlgorithm(com.sap.mi.gfw.mm.pictograms.ContainerShape) Default
	 * implementation returns null which is interpreted by framework as the master graphics algorithm for the container shape
	 */
	public GraphicsAlgorithm getContentGraphicsAlgorithm(ContainerShape cs) {
		return null;
	}

	public void postSave() {
	}

	public void preSave() {
	}
}