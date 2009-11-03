package com.sap.mi.gfw.eclipse.internal.parts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.internal.WorkbenchImages;
import org.eclipse.ui.model.IWorkbenchAdapter;
import org.eclipse.ui.model.IWorkbenchAdapter2;
import org.eclipse.ui.progress.UIJob;

import com.sap.mi.gfw.GfwTestConfiguration;
import com.sap.mi.gfw.datatypes.IDimension;
import com.sap.mi.gfw.datatypes.ILocation;
import com.sap.mi.gfw.datatypes.impl.LocationImpl;
import com.sap.mi.gfw.dt.IDiagramTypeProvider;
import com.sap.mi.gfw.eclipse.Messages;
import com.sap.mi.gfw.eclipse.internal.GfwEclipseConstants;
import com.sap.mi.gfw.eclipse.internal.ImagePool;
import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.eclipse.internal.editor.DiagramEditor;
import com.sap.mi.gfw.eclipse.internal.figures.GfwAbstractShape;
import com.sap.mi.gfw.eclipse.internal.figures.GfwEllipse;
import com.sap.mi.gfw.eclipse.internal.figures.GfwEllipseDecoration;
import com.sap.mi.gfw.eclipse.internal.figures.GfwImageFigure;
import com.sap.mi.gfw.eclipse.internal.figures.GfwMultilineText;
import com.sap.mi.gfw.eclipse.internal.figures.GfwPolygon;
import com.sap.mi.gfw.eclipse.internal.figures.GfwPolygonDecoration;
import com.sap.mi.gfw.eclipse.internal.figures.GfwPolyline;
import com.sap.mi.gfw.eclipse.internal.figures.GfwPolylineConnection;
import com.sap.mi.gfw.eclipse.internal.figures.GfwPolylineDecoration;
import com.sap.mi.gfw.eclipse.internal.figures.GfwRectangleFigure;
import com.sap.mi.gfw.eclipse.internal.figures.GfwRoundedRectangle;
import com.sap.mi.gfw.eclipse.internal.figures.GfwText;
import com.sap.mi.gfw.eclipse.internal.figures.ImageFigureAntialias;
import com.sap.mi.gfw.eclipse.internal.util.DataTypeTransformation;
import com.sap.mi.gfw.eclipse.internal.util.Util;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IReason;
import com.sap.mi.gfw.features.IUpdateFeature;
import com.sap.mi.gfw.features.context.IUpdateContext;
import com.sap.mi.gfw.features.context.impl.UpdateContext;
import com.sap.mi.gfw.features.impl.Reason;
import com.sap.mi.gfw.internal.GaUtilInternal;
import com.sap.mi.gfw.internal.util.MoinHelper;
import com.sap.mi.gfw.mm.pictograms.AbstractText;
import com.sap.mi.gfw.mm.pictograms.Anchor;
import com.sap.mi.gfw.mm.pictograms.BoxRelativeAnchor;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.ConnectionDecorator;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.Ellipse;
import com.sap.mi.gfw.mm.pictograms.FixPointAnchor;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.Image;
import com.sap.mi.gfw.mm.pictograms.LineStyle;
import com.sap.mi.gfw.mm.pictograms.LineStyleEnum;
import com.sap.mi.gfw.mm.pictograms.MultiText;
import com.sap.mi.gfw.mm.pictograms.Orientation;
import com.sap.mi.gfw.mm.pictograms.OrientationEnum;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.PlatformGraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.Polygon;
import com.sap.mi.gfw.mm.pictograms.Polyline;
import com.sap.mi.gfw.mm.pictograms.Rectangle;
import com.sap.mi.gfw.mm.pictograms.RoundedRectangle;
import com.sap.mi.gfw.mm.pictograms.Text;
import com.sap.mi.gfw.platform.ga.IGraphicsAlgorithmRenderer;
import com.sap.mi.gfw.platform.ga.IGraphicsAlgorithmRendererFactory;
import com.sap.mi.gfw.platform.ga.IRendererContext;
import com.sap.mi.gfw.platform.ga.IVisualState;
import com.sap.mi.gfw.platform.ga.RendererContext;
import com.sap.mi.gfw.platform.ga.VisualState;
import com.sap.mi.gfw.tb.IRenderingDecorator;
import com.sap.mi.gfw.tb.IToolBehaviorProvider;
import com.sap.mi.gfw.tb.ImageRenderingDecorator;
import com.sap.mi.gfw.util.GaUtil;
import com.sap.mi.gfw.util.PeUtil;
import com.sap.mi.gfw.util.T;
import com.sap.tc.moin.repository.InvalidConnectionException;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.EventRegistry;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.filter.AndFilter;
import com.sap.tc.moin.repository.events.filter.CompositionHierarchyFilter;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.filter.EventTypeFilter;
import com.sap.tc.moin.repository.events.filter.PartitionFilter;
import com.sap.tc.moin.repository.events.type.PartitionChangeEvent;

/**
 * A class, which contains helper-methods, which are necessarry to implement the interface IAnchorContainerEditPart. It is not possible to
 * make this an EditPart itself, because of different inheritance-hierarchies used in the sub-classes.
 */
public class PictogramElementDelegate implements IPictogramElementDelegate {

	private boolean forceRefresh = false;

	private boolean valid = true;

	private final class BusinessChangeListener implements UpdateListener {
		private Job businessRefreshJob;

		BusinessChangeListener() {
			super();
		}

		public void notifyUpdate(EventChain events) {
			doTheNotification();
		}

		private void doTheNotification() {
			if (LISTEN_TO_BUSINESS_CHANGES) {
				getBusinessRefreshJob().schedule(1);
			}
		}

		private Job getBusinessRefreshJob() {
			if (businessRefreshJob == null) {
				businessRefreshJob = new UIJob(Messages.PictogramElementDelegate_0_xmsg) {
					@Override
					public boolean belongsTo(Object family) {
						return GfwEclipseConstants.UIJOB_FAMILY_REFRESH.equals(family);
					}

					@Override
					public IStatus runInUIThread(IProgressMonitor monitor) {
						IDiagramTypeProvider diagramTypeProvider = getConfigurationProvider().getDiagramTypeProvider();
						PictogramElement pe = getPictogramElement();
						if (!MoinHelper.isObjectAlive(pe)) {
							return Status.OK_STATUS;
						}
						DiagramEditor editor = getEditor();

						if (!editor.isAlive()) {
							return Status.OK_STATUS;
						}

						boolean isEditorDirty;
						try {
							isEditorDirty = editor.isDirty();
						} catch (InvalidConnectionException e) {
							// $JL-EXC$
							// Connection no longer valid
							return Status.CANCEL_STATUS;
						}
						if (diagramTypeProvider.isAutoUpdateAtRuntime() && isEditorDirty) {
							UpdateContext context = new UpdateContext(pe);
							IFeatureProvider featureProvider = diagramTypeProvider.getFeatureProvider();
							featureProvider.updateIfPossibleAndNeeded(context);
						} else {
							GraphicsAlgorithm ga = pe.getGraphicsAlgorithm();
							if (ga != null) {
								IReason updateNeeded = checkIfUpdateNeeded(pe);
								refreshFigureForGraphicsAlgorithm(ga, pe, updateNeeded);
							}
						}
						return Status.OK_STATUS;
					}

				};
			}
			return businessRefreshJob;
		}
	}

	private static final boolean LISTEN_TO_BUSINESS_CHANGES = true;

	private BusinessChangeListener[] businessChangeListeners;

	private IConfigurationProvider configurationProvider;

	private final Hashtable<GraphicsAlgorithm, IFigure> elementFigureHash = new Hashtable<GraphicsAlgorithm, IFigure>();

	private final HashSet<Font> fontList = new HashSet<Font>();

	private PictogramElement pictogramElement;

	// edit part which holds the instance of this delegate
	private EditPart containerEditPart;

	/**
	 * The {@link IVisualState} of this pictogram element delegate.
	 */
	private IVisualState visualState;

	/**
	 * Creates a new PictogramElementDelegate.
	 * 
	 * @param configurationProvider
	 *            the configuration provider
	 * @param pictogramElement
	 *            the pictogram element
	 * @param containerEditPart
	 *            the container edit part
	 */
	public PictogramElementDelegate(IConfigurationProvider configurationProvider, PictogramElement pictogramElement,
			EditPart containerEditPart) {
		setConfigurationProvider(configurationProvider);
		setPictogramElement(pictogramElement);
		setContainerEditPart(containerEditPart);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.eclipse.internal.parts.IPictogramElementDelegate#activate()
	 */
	public void activate() {
		// registerBusinessChangeListenersForPictogramElement(getPictogramElement());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.eclipse.internal.parts.IPictogramElementDelegate#createFigure()
	 */
	public IFigure createFigure() {
		PictogramElement pe = getPictogramElement();
		IFigure ret = createFigureForPictogramElement(pe);
		if (GfwTestConfiguration.isMultipleRefreshSupressionActive()) {
			return ret;
		} else {
			refreshFigureForPictogramElement(pe);
			return ret;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.eclipse.internal.parts.IPictogramElementDelegate#deactivate()
	 */
	public void deactivate() {
		unregisterBusinessChangeListeners();
		disposeFonts();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	public Object getAdapter(Class key) {
		Object ret = null;
		if (key == IGfwAdapter.class || key == IWorkbenchAdapter.class || key == IWorkbenchAdapter2.class) {
			ret = new GfwAdapter();
		}
		return ret;
	}

	/**
	 * Gets the configuration provider.
	 * 
	 * @return Returns the configurationProvider.
	 */
	public IConfigurationProvider getConfigurationProvider() {
		return configurationProvider;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seecom.sap.mi.gfw.eclipse.internal.parts.IPictogramElementDelegate#getFigureForGraphicsAlgorithm(com.sap.mi.gfw.mm.pictograms.
	 * GraphicsAlgorithm)
	 */
	public IFigure getFigureForGraphicsAlgorithm(GraphicsAlgorithm graphicsAlgorithm) {
		IFigure ret = null;
		if (graphicsAlgorithm == null) {
			return ret;
		}
		Object element = elementFigureHash.get(graphicsAlgorithm);
		if (element instanceof IFigure) {
			ret = (IFigure) element;
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.eclipse.internal.parts.IPictogramElementDelegate#getPictogramElement()
	 */
	public PictogramElement getPictogramElement() {
		return pictogramElement;
	}

	/**
	 * refresh edit parts for child pictogram elements.
	 * 
	 * @param ep
	 *            the ep
	 */
	public void refreshEditPartsForModelChildrenAndSourceConnections(EditPart ep) {
		if (ep instanceof IPictogramElementEditPart) {

			IPictogramElementEditPart peep = (IPictogramElementEditPart) ep;

			List<PictogramElement> peList = new ArrayList();
			peList.addAll(peep.getModelChildren());
			peList.addAll(peep.getModelSourceConnections());
			// peList.addAll(peep.getModelTargetConnections());

			if (ep.getParent() != null) {
				EditPartViewer viewer = ep.getViewer();
				if (viewer != null) {
					Map editPartRegistry = viewer.getEditPartRegistry();
					if (editPartRegistry != null) {
						for (PictogramElement childPe : peList) {
							Object object = editPartRegistry.get(childPe);
							if (object instanceof EditPart) {
								EditPart editPart = (EditPart) object;
								try {
									editPart.refresh();
								} catch (NullPointerException e) {
									String message = "PictogramElementDelegate.refreshEditPartsForModelChildrenAndSourceConnections():\n    editPart.refresh() threw NullPointerException\n    editPart: " //$NON-NLS-1$
											+ editPart;
									T.racer().error(message, e);
								}// try
							}// if
						}// for
					}// if
				}// if
			}// if
		}// if
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.eclipse.internal.parts.IPictogramElementDelegate#refreshFigureForEditPart(org.eclipse.gef.EditPart)
	 */
	public void refreshFigureForEditPart() {

		// DR: Avoid multiple refresh of the same edit part
		if (!isForceRefresh() && GfwTestConfiguration.isMultipleRefreshSupressionActive()) {
			if (!getEditor().getRefreshedFigure4EP().add(getContainerEditPart())) {
				return;
			}
		}

		PictogramElement pe = getPictogramElement();

		if (!MoinHelper.isObjectAlive(pe)) {
			return;
		}

		if (pe instanceof com.sap.mi.gfw.mm.pictograms.Shape) {
			if (isRefreshPossible(pe)) {
				refreshFigureForPictogramElement(pe);
			} else {
				EditPart parentEp = getContainerEditPart().getParent();
				if (parentEp instanceof IShapeEditPart) {
					elementFigureHash.clear();
					IShapeEditPart parent = (IShapeEditPart) parentEp;
					parent.deleteChildAndRefresh(getContainerEditPart());
					setValid(false); // invalidate current delegate
				}
			}
		} else if (pe instanceof Connection) {
			Connection connection = (Connection) pe;
			if (!isConnectionRefreshPossible(connection)) {
				// if refresh is not possible -> reset figure-tree
				IFigure figure = getFigureForGraphicsAlgorithm(connection.getGraphicsAlgorithm());
				elementFigureHash.clear();

				// clean passive decorators
				if (figure instanceof GfwPolylineConnection) {
					GfwPolylineConnection c = (GfwPolylineConnection) figure;
					c.removeAllDecorations();
				}

				addGraphicsAlgorithmForFigure(figure, connection.getGraphicsAlgorithm());
				// create passive decorators
				createFiguresForPassiveDecorators(connection);
			}
			refreshFigureForPictogramElement(pe);
		} else if (pe instanceof Anchor) {
			refreshFigureForPictogramElement(pe);
		}
	}

	/**
	 * Gets the edit part which holds the instance of this delegate.
	 * 
	 * @return the container edit part
	 */
	protected EditPart getContainerEditPart() {
		return containerEditPart;
	}

	/**
	 * Sets the edit part which holds the instance of this delegate.
	 * 
	 * @param containerEditPart
	 *            the new container edit part
	 */
	protected void setContainerEditPart(EditPart containerEditPart) {
		this.containerEditPart = containerEditPart;
	}

	/**
	 * Check if update needed.
	 * 
	 * @param pe
	 *            the pe
	 * @return the i reason
	 */
	IReason checkIfUpdateNeeded(PictogramElement pe) {
		IReason ret = Reason.createFalseReason();
		IFeatureProvider featureProvider = getConfigurationProvider().getFeatureProvider();
		IUpdateContext updateCtx = new UpdateContext(pe);
		IUpdateFeature updateFeature = featureProvider.getUpdateFeature(updateCtx);
		if (updateFeature != null) {
			ret = updateFeature.updateNeeded(updateCtx);
		}

		if (GfwTestConfiguration.isRecursiveCheckForUpdateActive()) {
			// check children as well
			if (!ret.toBoolean()) {
				Collection<PictogramElement> peChildren = PeUtil.getPictogramElementChildren(pe);
				for (PictogramElement peChild : peChildren) {
					ret = checkIfUpdateNeeded(peChild);
					if (ret.toBoolean()) {
						break;
					}
				}
			}
		}
		if (T.racer().info()) {
			T.racer().info("returns " + ret.toString()); //$NON-NLS-1$
		}
		return ret;
	}

	/**
	 * Refresh figure for graphics algorithm.
	 * 
	 * @param graphicsAlgorithm
	 *            the graphics algorithm
	 * @param pe
	 *            The pictogram-element to which the graphics-algorithm (or the parent-ga) belongs
	 * @param updateNeeded
	 *            the update needed
	 */
	void refreshFigureForGraphicsAlgorithm(final GraphicsAlgorithm graphicsAlgorithm, final PictogramElement pe, IReason updateNeeded) {
		if (graphicsAlgorithm == null || pe == null) {
			return;
		}
		final IFigure figure = getFigureForGraphicsAlgorithm(graphicsAlgorithm);
		if (figure == null) {
			return;
		}

		if (!isForceRefresh() && GfwTestConfiguration.isMultipleRefreshSupressionActive()) {
			if (!getEditor().getRefreshedFigure4GA().add(graphicsAlgorithm)) {
				return;
			}
		}

		// figure.getChildren().removeAll(figure.getChildren()); //?

		// refresh common figure data
		figure.setOpaque(true);
		figure.setVisible(pe.isVisible());

		// check whether the edit part is a connection edit part and the edit
		// part is selected
		// if yes, refresh of colors and shape style is not necessary
		boolean selectedConnection = false;

		if (getContainerEditPart() instanceof ConnectionEditPart) {
			int selectedState = getContainerEditPart().getSelected();
			if (selectedState == EditPart.SELECTED_PRIMARY || selectedState == EditPart.SELECTED) {
				selectedConnection = true;
			}
		}

		// refresh figure colors only if it is not a customer figure (e.g. CoDe)
		if (!(figure instanceof IGraphicsAlgorithmRenderer)) {
			if (selectedConnection) {
				Color bg = DataTypeTransformation.toSwtColor(getConfigurationProvider(), GaUtilInternal.getBackgroundColor(
						graphicsAlgorithm, true));
				figure.setBackgroundColor(bg);
			} else {
				refreshFigureColors(figure, graphicsAlgorithm);
			}
		}

		// refresh specific figure-data
		if (graphicsAlgorithm instanceof Ellipse
				&& (figure instanceof org.eclipse.draw2d.Ellipse || figure instanceof GfwEllipse || figure instanceof GfwEllipseDecoration)) {
			Shape f = (Shape) figure;
			refreshShapeData(f, graphicsAlgorithm);

		} else if (graphicsAlgorithm instanceof Polygon
				&& (figure instanceof org.eclipse.draw2d.Polygon || figure instanceof GfwPolygon || figure instanceof GfwPolygonDecoration)) {

			Polygon polygon = (Polygon) graphicsAlgorithm;
			ILocation polygonLocation = new LocationImpl(polygon.getX(), polygon.getY());
			PointList pointList = toAbsoluteDraw2dPoints(polygon.getPoints(), polygonLocation);

			if (figure instanceof GfwPolygonDecoration) {
				GfwPolygonDecoration p = (GfwPolygonDecoration) figure;
				p.setSpecificBezierDistances(getBezierDistances(polygon.getPoints()));
				p.setDecoratorTemplate(pointList);
			} else if (figure instanceof GfwPolygon) {
				GfwPolygon p = (GfwPolygon) figure;
				p.setSpecificBezierDistances(getBezierDistances(polygon.getPoints()));
				p.setPoints(pointList);
			}

			if (!selectedConnection) {
				refreshShapeData((org.eclipse.draw2d.Shape) figure, graphicsAlgorithm);
			}

		} else if (graphicsAlgorithm instanceof Polyline
				&& (figure instanceof org.eclipse.draw2d.Polyline || figure instanceof GfwPolyline || figure instanceof GfwPolylineDecoration)) {

			// if figure is a PolylineConnection then just a refreshShapeData is
			// necessary

			Polyline polyline = (Polyline) graphicsAlgorithm;
			ILocation polylineLocation = new LocationImpl(polyline.getX(), polyline.getY());
			PointList pointList = toAbsoluteDraw2dPoints(polyline.getPoints(), polylineLocation);

			if (figure instanceof GfwPolylineConnection) {
				// do nothing
				// GfwPolylineConnection is a sub-class of GfwPolyline, so this
				// check is necessary
			} else if (figure instanceof GfwPolylineDecoration) {
				GfwPolylineDecoration p = (GfwPolylineDecoration) figure;
				p.setSpecificBezierDistances(getBezierDistances(polyline.getPoints()));
				p.setDecoratorTemplate(pointList);
			} else if (figure instanceof GfwPolyline) {
				GfwPolyline p = (GfwPolyline) figure;
				p.setSpecificBezierDistances(getBezierDistances(polyline.getPoints()));
				p.setPoints(pointList);
			}

			if (!selectedConnection) {
				refreshShapeData((org.eclipse.draw2d.Shape) figure, graphicsAlgorithm);
			}

		} else if (graphicsAlgorithm instanceof Rectangle && figure instanceof GfwRectangleFigure) {
			GfwRectangleFigure f = (GfwRectangleFigure) figure;
			refreshShapeData(f, graphicsAlgorithm);
		} else if (graphicsAlgorithm instanceof RoundedRectangle) {
			if (figure instanceof GfwRoundedRectangle) {
				GfwRoundedRectangle f = (GfwRoundedRectangle) figure;
				refreshShapeData(f, graphicsAlgorithm);
				RoundedRectangle rr = (RoundedRectangle) graphicsAlgorithm;
				Dimension dimension = new Dimension(rr.getCornerWidth(), rr.getCornerHeight());

				f.setCornerDimensions(dimension);
			}
		} else if (graphicsAlgorithm instanceof MultiText && figure instanceof GfwMultilineText) {
			MultiText text = (MultiText) graphicsAlgorithm;
			GfwMultilineText label = (GfwMultilineText) figure;
			label.setText(text.getValue());
			refreshFlowTextAlignment(label, text);
			refreshFont(text, label);
			label.setOpaque(false);
			label.setRequestFocusEnabled(false);
			label.invalidateTree();
		} else if (graphicsAlgorithm instanceof Text && figure instanceof GfwText) {
			Text text = (Text) graphicsAlgorithm;
			GfwText label = (GfwText) figure;
			label.setText(text.getValue());
			refreshTextOrientation(label, text);
			refreshFont(text, label);
			label.setOpaque(false);
			label.setRequestFocusEnabled(false);
		} else if (graphicsAlgorithm instanceof Image && figure instanceof ImageFigure) {
			ImageFigure imageFigure = (ImageFigure) figure;
			Image pictogramImage = (Image) graphicsAlgorithm;
			org.eclipse.swt.graphics.Image image = ImagePool.getImageForPictogramImage(pictogramImage);
			imageFigure.setImage(image);
			imageFigure.setAlignment(PositionConstants.CENTER);
			imageFigure.setOpaque(false);
		}
		// set location and size of figure
		setFigureConstraint(figure, graphicsAlgorithm, pe);

		// refresh child GAs
		Collection graphicsAlgorithmChildren = graphicsAlgorithm.getGraphicsAlgorithmChildren();
		for (Iterator iter = graphicsAlgorithmChildren.iterator(); iter.hasNext();) {
			GraphicsAlgorithm childGA = (GraphicsAlgorithm) iter.next();
			refreshFigureForGraphicsAlgorithm(childGA, pe, Reason.createFalseReason());
		}

		IDiagramTypeProvider diagramTypeProvider = getConfigurationProvider().getDiagramTypeProvider();
		IToolBehaviorProvider toolBehaviorProvider = diagramTypeProvider.getCurrentToolBehaviorProvider();

		// rendering decorators
		addRenderingDecorators(graphicsAlgorithm, pe, figure, toolBehaviorProvider);

		// indicate needed updates
		indicateNeededUpdates(figure, updateNeeded);

		// set tool tips
		final String toolTip = toolBehaviorProvider.getToolTip(graphicsAlgorithm);
		if (toolTip != null) {
			Label ttf = new Label(toolTip);
			figure.setToolTip(ttf);
		}
	}

	private void refreshFont(AbstractText text, Figure label) {
		if (text == null || label == null) {
			return;
		}

		// if valid font-information exists in the pictogram-model, then
		// create/change swt-font of label
		com.sap.mi.gfw.mm.pictograms.Font font = GaUtilInternal.getFont(text, true);
		if (font != null && font.getName() != null) {

			Font currentSwtFont = label.getFont();
			if (currentSwtFont == null || currentSwtFont.isDisposed()) {
				Font newSwtFont = DataTypeTransformation.toSwtFont(font);
				fontList.add(newSwtFont);
				label.setFont(newSwtFont);
			} else {
				Font newSwtFont = DataTypeTransformation.syncToSwtFont(font, currentSwtFont);
				if (newSwtFont != currentSwtFont) {
					fontList.add(newSwtFont);
					label.setFont(newSwtFont);
					boolean wasInList = fontList.remove(currentSwtFont);
					if (wasInList) {
						currentSwtFont.dispose();
					}
				}
			}
		}
	}

	private void addGraphicsAlgorithmForFigure(IFigure figure, GraphicsAlgorithm graphicsAlgorithm) {
		if (figure != null && graphicsAlgorithm != null) {
			elementFigureHash.put(graphicsAlgorithm, figure);
		}
	}

	private ILocation calculatePolylineLocation(Polyline polyline) {
		Collection<com.sap.mi.gfw.mm.datatypes.Point> points = polyline.getPoints();

		int minX = points.isEmpty() ? 0 : ((com.sap.mi.gfw.mm.datatypes.Point) points.toArray()[0]).getX();
		int minY = points.isEmpty() ? 0 : ((com.sap.mi.gfw.mm.datatypes.Point) points.toArray()[0]).getY();

		for (Iterator<com.sap.mi.gfw.mm.datatypes.Point> iter = points.iterator(); iter.hasNext();) {
			com.sap.mi.gfw.mm.datatypes.Point point = iter.next();
			int x = point.getX();
			int y = point.getY();
			minX = Math.min(minX, x);
			minY = Math.min(minY, y);
		}

		int locX = polyline.getX();
		int locY = polyline.getY();

		return new LocationImpl(minX + locX, minY + locY);
	}

	/**
	 * @param graphicsAlgorithm
	 * @return TRUE, if a figure exists for the ga and for all child-ga's
	 */
	private boolean checkGA(GraphicsAlgorithm graphicsAlgorithm) {

		if (graphicsAlgorithm != null && MoinHelper.isObjectAlive(graphicsAlgorithm)) {
			IFigure ret = getFigureForGraphicsAlgorithm(graphicsAlgorithm);
			if (ret == null) {
				return false;
			}
			Collection children = graphicsAlgorithm.getGraphicsAlgorithmChildren();
			for (Iterator iter = children.iterator(); iter.hasNext();) {
				GraphicsAlgorithm childGraphicsAlgorithm = (GraphicsAlgorithm) iter.next();
				if (!checkGA(childGraphicsAlgorithm)) {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * returns TRUE, if a figure exists for each ga
	 */
	private boolean checkGAs(com.sap.mi.gfw.mm.pictograms.Shape shape) {

		if (!MoinHelper.isObjectAlive(shape))
			return false;

		GraphicsAlgorithm graphicsAlgorithm = shape.getGraphicsAlgorithm();

		if (!checkGA(graphicsAlgorithm)) {
			return false;
		}

		if (shape instanceof ContainerShape) {
			ContainerShape containerShape = (ContainerShape) shape;
			Collection children = containerShape.getChildren();
			for (Iterator iter = children.iterator(); iter.hasNext();) {
				Object obj = iter.next();
				if (obj instanceof com.sap.mi.gfw.mm.pictograms.Shape) {
					com.sap.mi.gfw.mm.pictograms.Shape childShape = (com.sap.mi.gfw.mm.pictograms.Shape) obj;
					if (!childShape.isActive()) {
						if (!checkGAs(childShape)) {
							return false;
						}
					}
				}
			}
		}

		return true;
	}

	private IFigure createFigureForGraphicsAlgorithm(PictogramElement pe, GraphicsAlgorithm graphicsAlgorithm) {
		return createFigureForGraphicsAlgorithm(pe, graphicsAlgorithm, false);
	}

	/**
	 * @param graphicsAlgorithm
	 * @return
	 */
	private IFigure createFigureForGraphicsAlgorithm(PictogramElement pe, GraphicsAlgorithm graphicsAlgorithm,
			boolean specialSelectionHandlingForOuterGaFigures) {
		IFigure ret = null;
		if (graphicsAlgorithm != null) {
			if (pe instanceof Connection) {
				// special for connections
				ret = new GfwPolylineConnection(this, graphicsAlgorithm);
			} else if (graphicsAlgorithm instanceof Ellipse) {
				if (pe instanceof ConnectionDecorator && !pe.isActive()) {
					ret = new GfwEllipseDecoration(this, graphicsAlgorithm);
				} else {
					ret = new GfwEllipse(this, graphicsAlgorithm);
				}
			} else if (graphicsAlgorithm instanceof Polygon) {
				// if graphics-algorithm belongs to an inactive decorator-shape
				// use special polygon
				if (pe instanceof ConnectionDecorator && !pe.isActive()) {
					ret = new GfwPolygonDecoration(this, graphicsAlgorithm);
				} else {
					ret = new GfwPolygon(this, graphicsAlgorithm);
				}
			} else if (graphicsAlgorithm instanceof Polyline) {
				// if graphics-algorithm belongs to an inactive decorator-shape
				// use special polygon
				if (pe instanceof ConnectionDecorator && !pe.isActive()) {
					ret = new GfwPolylineDecoration(this, graphicsAlgorithm);
				} else {
					ret = new GfwPolyline(this, graphicsAlgorithm);
				}
			} else if (graphicsAlgorithm instanceof Rectangle) {
				ret = new GfwRectangleFigure(this, graphicsAlgorithm);
			} else if (graphicsAlgorithm instanceof RoundedRectangle) {
				ret = new GfwRoundedRectangle(this, graphicsAlgorithm);
			} else if (graphicsAlgorithm instanceof MultiText) {
				ret = new GfwMultilineText();
			} else if (graphicsAlgorithm instanceof Text) {
				ret = new GfwText(this, graphicsAlgorithm);
			} else if (graphicsAlgorithm instanceof PlatformGraphicsAlgorithm) {
				PlatformGraphicsAlgorithm pga = (PlatformGraphicsAlgorithm) graphicsAlgorithm;
				IGraphicsAlgorithmRendererFactory factory = getGraphicsAlgorithmRendererFactory();
				if (factory != null) {
					IRendererContext rendererContext = new RendererContext(pga, getConfigurationProvider().getDiagramTypeProvider());
					IGraphicsAlgorithmRenderer pr = factory.createGraphicsAlgorithmRenderer(rendererContext);
					if (pr instanceof IFigure) {
						ret = (IFigure) pr;
					}
				}
			} else if (graphicsAlgorithm instanceof Image) {
				ret = new GfwImageFigure(graphicsAlgorithm);
			}

			if (ret != null) {

				if (graphicsAlgorithm.getGraphicsAlgorithmChildren().size() > 0) {
					ret.setLayoutManager(new XYLayout());
				}

				addGraphicsAlgorithmForFigure(ret, graphicsAlgorithm);

				Collection graphicsAlgorithmChildren = graphicsAlgorithm.getGraphicsAlgorithmChildren();
				for (Iterator iter = graphicsAlgorithmChildren.iterator(); iter.hasNext();) {
					GraphicsAlgorithm childGa = (GraphicsAlgorithm) iter.next();
					ret.add(createFigureForGraphicsAlgorithm(null, childGa));
				}
			}
		}
		if (specialSelectionHandlingForOuterGaFigures) {
			if (ret instanceof GfwAbstractShape) {
				GfwAbstractShape gfwAbstractShape = (GfwAbstractShape) ret;
				IToolBehaviorProvider currentToolBehaviorProvider = getConfigurationProvider().getDiagramTypeProvider()
						.getCurrentToolBehaviorProvider();
				gfwAbstractShape.setSelectionGraphicsAlgorithm(currentToolBehaviorProvider
						.getSelectionGraphicsAlgorithm(getPictogramElement()));
				gfwAbstractShape.setSelectionArea(currentToolBehaviorProvider.getSelectionArea(getPictogramElement()));
			}
		}

		return ret;
	}

	private IFigure createFigureForPictogramElement(final PictogramElement pe) {
		GraphicsAlgorithm graphicsAlgorithm = pe.getGraphicsAlgorithm();

		IFigure ret = createFigureForGraphicsAlgorithm(pe, graphicsAlgorithm, pe.isActive());

		if (ret == null) {
			return ret;
		}

		// _directEditPerformer = new
		// DirectEditPerformer(getConfigurationProvider(), this, _labels,
		// attributes);

		if (pe instanceof ContainerShape) {
			ret.setLayoutManager(new XYLayout());
			ContainerShape containerShape = (ContainerShape) pe;
			Collection containersChildren = containerShape.getChildren();
			for (Iterator iter = containersChildren.iterator(); iter.hasNext();) {
				Object obj = iter.next();
				if (obj instanceof PictogramElement) {
					PictogramElement childPe = (PictogramElement) obj;
					if (!childPe.isActive()) {
						IFigure f = createFigureForPictogramElement(childPe);
						ret.add(f);
					}
				}
			}
		} else if (pe instanceof Connection) {
			createFiguresForPassiveDecorators((Connection) pe);
		}

		return ret;
	}

	private void createFiguresForPassiveDecorators(Connection connection) {

		IFigure figure = getFigureForGraphicsAlgorithm(connection.getGraphicsAlgorithm());
		if (figure instanceof GfwPolylineConnection) {
			GfwPolylineConnection polylineConnection = (GfwPolylineConnection) figure;
			Collection<ConnectionDecorator> c = connection.getConnectionDecorators();
			for (ConnectionDecorator connectionDecorator : c) {
				if (!connectionDecorator.isActive()) {
					GraphicsAlgorithm graphicsAlgorithm = connectionDecorator.getGraphicsAlgorithm();
					IFigure newFigure = createFigureForGraphicsAlgorithm(connectionDecorator, graphicsAlgorithm);
					RotatableDecoration rotatableDecoration = null;
					if (newFigure instanceof RotatableDecoration) {
						rotatableDecoration = (RotatableDecoration) newFigure;
					}
					if (connectionDecorator.isLocationRelative()) {
						double relativeLocation = connectionDecorator.getLocation();
						// TODO: change metamodel to get rid of special handling
						// for backward compability
						if (relativeLocation != 1) {
							polylineConnection.addDecoration(rotatableDecoration, true, relativeLocation, 0, 0);
						} else {
							polylineConnection.addDecoration(rotatableDecoration, false, 0.0, 0, 0);
						}
					}
				}
			}
		}
	}

	private IFigure decorateFigure(final IFigure figure, final IRenderingDecorator renderingDecorator) {
		String messageText = renderingDecorator.getMessage();

		IFigure decoratorFigure = null;
		org.eclipse.draw2d.geometry.Rectangle boundsForDecoratorFigure = new org.eclipse.draw2d.geometry.Rectangle(0, 0, 16, 16);

		if (renderingDecorator instanceof ImageRenderingDecorator) {
			ImageRenderingDecorator imageRenderingDecorator = (ImageRenderingDecorator) renderingDecorator;
			org.eclipse.swt.graphics.Image imageForId = ImagePool.getImageForId(imageRenderingDecorator.getImageId());
			ImageFigure imageFigure = new ImageFigureAntialias(imageForId);
			decoratorFigure = imageFigure;
			org.eclipse.swt.graphics.Rectangle imageBounds = imageFigure.getImage().getBounds();
			boundsForDecoratorFigure.setSize(imageBounds.width, imageBounds.height);
		}

		if (decoratorFigure != null) {
			if (renderingDecorator instanceof ILocation) {
				ILocation location = (ILocation) renderingDecorator;
				boundsForDecoratorFigure.setLocation(location.getX(), location.getY());
			}

			decoratorFigure.setVisible(true);
			if (messageText != null && messageText.length() > 0) {
				decoratorFigure.setToolTip(new Label(messageText));
			}
			figure.add(decoratorFigure);
			figure.setConstraint(decoratorFigure, boundsForDecoratorFigure);
		}

		return decoratorFigure;
	}

	private final HashMap<IFigure, List<IFigure>> renderingDecoratorMap = new HashMap<IFigure, List<IFigure>>();

	/*
	 * must be called from the edit-part if this edit-part is de-activated
	 */
	private void disposeFonts() {
		for (Iterator<Font> iter = fontList.iterator(); iter.hasNext();) {
			Font font = iter.next();
			font.dispose();
		}
	}

	/**
	 * @param figure
	 * @param updateNeeded
	 */
	private void indicateNeededUpdates(IFigure figure, IReason updateNeeded) {
		if (figure != null && updateNeeded != null) {
			if (figure instanceof Shape) {
				Shape draw2dShape = (Shape) figure;
				IFigure toolTip = draw2dShape.getToolTip();
				if (toolTip != null) {
					draw2dShape.setToolTip(null);
				}
			}

			if (updateNeeded.toBoolean()) {
				figure.setForegroundColor(ColorConstants.red);
				if (figure instanceof Shape) {
					Shape draw2dShape = (Shape) figure;
					draw2dShape.setLineWidth(2);
					draw2dShape.setLineStyle(Graphics.LINE_DOT);

					String updateNeededText = updateNeeded.getText();
					if (updateNeededText != null && updateNeededText.length() > 0) {
						Label toolTipFigure = new Label();
						toolTipFigure.setText(updateNeededText);
						toolTipFigure.setIcon(WorkbenchImages.getImage(ISharedImages.IMG_OBJS_WARN_TSK));
						draw2dShape.setToolTip(toolTipFigure);
					}
				}
			}
		}
	}

	/**
	 * returns TRUE if structure of connection-model (connection,passive decorators and ga's) are in sync with the current figure-tree
	 */
	private boolean isConnectionRefreshPossible(Connection connection) {
		if (!MoinHelper.isObjectAlive(connection)) {
			return false;
		}

		// compare pictogram-model with figure-tree -> structural changes?

		List<GraphicsAlgorithm> gaList = new ArrayList<GraphicsAlgorithm>();
		Collection<ConnectionDecorator> c = connection.getConnectionDecorators();
		for (ConnectionDecorator connectionDecorator : c) {
			if (!connectionDecorator.isActive()) {
				GraphicsAlgorithm ga = connectionDecorator.getGraphicsAlgorithm();
				if (ga != null) {
					gaList.add(ga);
				}
			}
		}

		if (connection.getGraphicsAlgorithm() != null) {
			gaList.add(connection.getGraphicsAlgorithm());
		}

		// do all ga's have a figure?
		for (GraphicsAlgorithm graphicsAlgorithm : gaList) {
			IFigure figure = getFigureForGraphicsAlgorithm(graphicsAlgorithm);
			if (figure == null) {
				return false;
			}
		}

		// are there any registered GA, which are not in use?
		for (GraphicsAlgorithm graphicsAlgorithm : elementFigureHash.keySet()) {
			if (!gaList.contains(graphicsAlgorithm)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * returns TRUE if structure of pictogram-model (shapes & ga's) are in sync with the current figure-tree
	 */
	private boolean isRefreshPossible(PictogramElement pe) {
		// compare pictogram-model with figure-tree -> structural changes?
		if (pe instanceof com.sap.mi.gfw.mm.pictograms.Shape) {
			boolean ret = checkGAs((com.sap.mi.gfw.mm.pictograms.Shape) pe);
			if (ret == false) {
				return ret;
			}
			// invalid ga's in hashtable?
			for (GraphicsAlgorithm graphicsAlgorithm : elementFigureHash.keySet()) {
				if (!MoinHelper.isObjectAlive(graphicsAlgorithm)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * @param figure
	 * @param graphicsAlgorithm
	 */
	private void refreshFigureColors(IFigure figure, GraphicsAlgorithm graphicsAlgorithm) {
		Color fg = DataTypeTransformation
				.toSwtColor(getConfigurationProvider(), GaUtilInternal.getForegroundColor(graphicsAlgorithm, true));
		Color bg = DataTypeTransformation
				.toSwtColor(getConfigurationProvider(), GaUtilInternal.getBackgroundColor(graphicsAlgorithm, true));
		figure.setBackgroundColor(bg);
		figure.setForegroundColor(fg);
	}

	// private void refreshFigureColors(IFigure figure, GraphicsAlgorithm graphicsAlgorithm, int redShift) {
	// if (redShift == 0) {
	// refreshFigureColors(figure, graphicsAlgorithm);
	// } else {
	// Color fg = toSwtColor(GaUtilInternal.getForegroundColor(graphicsAlgorithm, true), redShift);
	// Color bg = toSwtColor(GaUtilInternal.getBackgroundColor(graphicsAlgorithm, true), redShift);
	// figure.setBackgroundColor(bg);
	// figure.setForegroundColor(fg);
	// }
	// }

	/**
	 * @param figure
	 */
	private void refreshFigureForPictogramElement(PictogramElement pe) {

		if (pe != null) {
			if (!isForceRefresh() && GfwTestConfiguration.isMultipleRefreshSupressionActive()) {
				if (!getEditor().getRefreshedFigure4PE().add(pe)) {
					return;
				}
			}

			if (pe instanceof ContainerShape) {
				ContainerShape containerShape = (ContainerShape) pe;
				for (Iterator iter = containerShape.getChildren().iterator(); iter.hasNext();) {
					Object obj = iter.next();
					if (obj instanceof PictogramElement) {
						PictogramElement childPe = (PictogramElement) obj;
						if (!childPe.isActive()) {
							refreshFigureForPictogramElement(childPe);
						}
					}
				}
			} else if (pe instanceof Connection) {
				Connection connection = (Connection) pe;
				Collection<ConnectionDecorator> c = connection.getConnectionDecorators();
				for (ConnectionDecorator decorator : c) {
					if (!decorator.isActive()) {
						refreshFigureForPictogramElement(decorator);
					}
				}
			}

			GraphicsAlgorithm ga = pe.getGraphicsAlgorithm();
			if (ga != null) {
				IReason updateNeeded = checkIfUpdateNeeded(pe);
				refreshFigureForGraphicsAlgorithm(ga, pe, updateNeeded);
			}
		}
	}

	/**
	 * @param shape
	 * @param graphicsAlgorithm
	 */
	private void refreshShapeData(org.eclipse.draw2d.Shape shape, GraphicsAlgorithm graphicsAlgorithm) {

		if (shape == null || graphicsAlgorithm == null) {
			return;
		}

		// line width
		int lineWidth = GaUtilInternal.getLineWidth(graphicsAlgorithm, true);
		shape.setLineWidth(lineWidth);

		// line style
		LineStyle lineStyle = GaUtilInternal.getLineStyle(graphicsAlgorithm, true);
		int draw2dLineStyle = Graphics.LINE_SOLID;
		if (lineStyle == LineStyleEnum.DASH) {
			draw2dLineStyle = Graphics.LINE_DASH;
		} else if (lineStyle == LineStyleEnum.DASHDOT) {
			draw2dLineStyle = Graphics.LINE_DASHDOT;
		} else if (lineStyle == LineStyleEnum.DASHDOTDOT) {
			draw2dLineStyle = Graphics.LINE_DASHDOTDOT;
		} else if (lineStyle == LineStyleEnum.DOT) {
			draw2dLineStyle = Graphics.LINE_DOT;
		} else if (lineStyle == LineStyleEnum.SOLID) {
			draw2dLineStyle = Graphics.LINE_SOLID;
		}
		shape.setLineStyle(draw2dLineStyle);

		// fill?
		final boolean filled = GaUtilInternal.isFilled(graphicsAlgorithm, true);
		shape.setFill(filled);

		// outline?
		final boolean lineVisible = GaUtilInternal.isLineVisible(graphicsAlgorithm, true);
		shape.setOutline(lineVisible);
	}

	private void refreshTextOrientation(GfwText label, Text text) {

		int draw2dOrientation = PositionConstants.LEFT;

		Orientation orientation = GaUtilInternal.getHorizontalAlignment(text, true);
		if (orientation != null) {
			if (orientation == OrientationEnum.ALIGNMENT_BOTTOM) {
				draw2dOrientation = PositionConstants.BOTTOM;
			} else if (orientation == OrientationEnum.ALIGNMENT_CENTER) {
				draw2dOrientation = PositionConstants.CENTER;
			} else if (orientation == OrientationEnum.ALIGNMENT_LEFT) {
				draw2dOrientation = PositionConstants.LEFT;
			} else if (orientation == OrientationEnum.ALIGNMENT_RIGHT) {
				draw2dOrientation = PositionConstants.RIGHT;
			} else if (orientation == OrientationEnum.ALIGNMENT_TOP) {
				draw2dOrientation = PositionConstants.TOP;
			}
		}
		label.setLabelAlignment(draw2dOrientation);
	}

	private void refreshFlowTextAlignment(GfwMultilineText label, MultiText text) {

		int draw2dOrientation = PositionConstants.LEFT;
		Orientation orientation = GaUtilInternal.getHorizontalAlignment(text, true);
		if (orientation != null) {
			if (orientation == OrientationEnum.ALIGNMENT_RIGHT) {
				draw2dOrientation = PositionConstants.RIGHT;
			} else if (orientation == OrientationEnum.ALIGNMENT_CENTER) {
				draw2dOrientation = PositionConstants.CENTER;
			}
		}
		label.setHorizontalAligment(draw2dOrientation);

		draw2dOrientation = PositionConstants.TOP;
		orientation = GaUtilInternal.getVerticalAlignment(text, true);
		if (orientation != null) {
			if (orientation == OrientationEnum.ALIGNMENT_BOTTOM) {
				draw2dOrientation = PositionConstants.BOTTOM;
			} else if (orientation == OrientationEnum.ALIGNMENT_CENTER) {
				draw2dOrientation = PositionConstants.MIDDLE;
			}
		}
		label.setVerticalAligment(draw2dOrientation);
	}

	private void registerBusinessChangeListenersForPictogramElement(PictogramElement pe) {
		if (businessChangeListeners != null) {
			return; // throw new IllegalStateException("Listeners already
			// registered");
		}
		EventRegistry eventRegistry = getEditor().getEventRegistry();
		if (eventRegistry != null) {
			IFeatureProvider featureProvider = getConfigurationProvider().getDiagramTypeProvider().getFeatureProvider();
			if (featureProvider != null) {
				Object[] businessObjects = featureProvider.getAllBusinessObjectsForPictogramElement(pe);

				int boCount = businessObjects.length;
				businessChangeListeners = new BusinessChangeListener[boCount];
				for (int i = 0; i < boCount; i++) {
					Object bo = businessObjects[i];
					if (bo instanceof RefBaseObject) {
						RefBaseObject rbo = (RefBaseObject) bo;
						EventFilter filter = new CompositionHierarchyFilter(rbo);
						businessChangeListeners[i] = new BusinessChangeListener();
						eventRegistry.registerUpdateListener(businessChangeListeners[i], filter);
						// register a partition change listener as well
						if (bo instanceof Partitionable) {
							Partitionable partitionlable = (Partitionable) bo;
							ModelPartition partition = partitionlable.get___Partition();
							eventRegistry.registerUpdateListener(businessChangeListeners[i], new AndFilter(new EventTypeFilter(
									PartitionChangeEvent.class), new PartitionFilter(partition)));
						}
					}
				}
			}
		}
	}

	/**
	 * @param configurationProvider
	 *            The configurationProvider to set.
	 */
	private void setConfigurationProvider(IConfigurationProvider configurationProvider) {
		this.configurationProvider = configurationProvider;
	}

	private void setFigureConstraint(IFigure figure, GraphicsAlgorithm graphicsAlgorithm, PictogramElement pe) {

		// PolylineConnection's and RotatableDecoration's will be handled by the
		// gef-framework
		if ((figure instanceof PolylineConnection) || figure instanceof GfwPolylineConnection || (figure instanceof RotatableDecoration)
				|| figure.getParent() == null) {
			return;
		}

		IDimension gaSize = GaUtil.calculateSizeOfGraphicsAlgorithm(graphicsAlgorithm);

		if (gaSize == null) {
			return;
		}

		Dimension dimension = new Dimension(gaSize.getWidth(), gaSize.getHeight());

		ILocation gaLocation = null;

		if (!(graphicsAlgorithm instanceof Polyline)) {
			gaLocation = new LocationImpl(graphicsAlgorithm.getX(), graphicsAlgorithm.getY());
		} else {
			gaLocation = calculatePolylineLocation((Polyline) graphicsAlgorithm);
		}

		if (gaLocation == null) {
			gaLocation = new LocationImpl(0, 0);
		}

		Point point = null;

		if (pe instanceof ConnectionDecorator && pe.isActive()) {

			// get relative point on connection-figure
			ConnectionDecorator connectionDecorator = (ConnectionDecorator) pe;
			Connection connection = connectionDecorator.getConnection();
			Point pointAt = null;
			double decoratorLocation = connectionDecorator.getLocation();
			if (connectionDecorator.isLocationRelative()) {
				pointAt = Util.getConnectionPointAt(connection, decoratorLocation);
			} else { // location is absolute
				pointAt = Util.getAbsolutePointOnConnection(connection, decoratorLocation);
			}

			if (pointAt == null) {
				return;
			}
			point = new Point(pointAt.x + gaLocation.getX(), pointAt.y + gaLocation.getY());

			// all decorator-shapes get the the dimension of the text which they
			// contain
			// TODO fix this hack; later the features are responsibles for
			// providing the correct size
			if (figure instanceof Label && connectionDecorator.getGraphicsAlgorithm() instanceof Text) {
				Label label = (Label) figure;
				if (label.getText() != null && label.getText().length() > 0) {
					// if text was not set, getTextBounds() does not work
					// correct
					dimension = label.getTextBounds().getSize();
					// WORKAROUND:
					// We had the problem, that the text-width was sometimes too
					// small
					// (depending on the zoom-level, text or installation?!)
					// As an easy fix, we add one pixel per character
					dimension.width += label.getText().length();
				}
			}

		} else if (pe instanceof BoxRelativeAnchor) {
			BoxRelativeAnchor bra = (BoxRelativeAnchor) pe;
			java.awt.Rectangle gaBoundsForAnchor = PeUtil.getGaBoundsForAnchor(bra);
			double newX = gaBoundsForAnchor.x + (gaBoundsForAnchor.width * bra.getRelativeWidth()) + gaLocation.getX();
			double newY = gaBoundsForAnchor.y + (gaBoundsForAnchor.height * bra.getRelativeHeight()) + gaLocation.getY();
			point = new Point(newX, newY);

		} else if (pe instanceof FixPointAnchor) {
			FixPointAnchor fpa = (FixPointAnchor) pe;
			java.awt.Rectangle gaBoundsForAnchor = PeUtil.getGaBoundsForAnchor(fpa);
			com.sap.mi.gfw.mm.datatypes.Point fpaLocation = fpa.getLocation();
			if (fpaLocation == null) {
				return;
			}
			point = new Point(gaBoundsForAnchor.x + fpaLocation.getX() + gaLocation.getX(), gaBoundsForAnchor.y + fpaLocation.getY()
					+ gaLocation.getY());

		} else {
			point = new Point(gaLocation.getX(), gaLocation.getY());
		}

		if (point != null) {
			IFigure parent = figure.getParent();
			if (parent != null) {
				parent.setConstraint(figure, new org.eclipse.draw2d.geometry.Rectangle(point, dimension));
			}
		}
	}

	/**
	 * @param pictogramElement
	 *            The pictogramElement to set.
	 */
	private void setPictogramElement(PictogramElement pictogramElement) {
		this.pictogramElement = pictogramElement;
	}

	private PointList toAbsoluteDraw2dPoints(Collection points, ILocation location) {
		int deltaX = 0;
		int deltaY = 0;
		if (location != null) {
			deltaX = location.getX();
			deltaY = location.getY();
		}
		PointList pointList = new PointList();
		for (Iterator iter = points.iterator(); iter.hasNext();) {
			com.sap.mi.gfw.mm.datatypes.Point dtp = (com.sap.mi.gfw.mm.datatypes.Point) iter.next();
			pointList.addPoint(dtp.getX() + deltaX, dtp.getY() + deltaY);
		}
		return pointList;
	}

	/**
	 * Returns the bezier-distances (distance-before and distance-after), which are calculated from the radius of the given points.
	 * 
	 * @param points
	 *            The points, for which to return the bezier-distances.
	 * 
	 * @return The bezier-distances (distance-before and distance-after), which are calculated from the radius of the given points.
	 */
	private int[] getBezierDistances(Collection points) {
		if (GfwTestConfiguration.getPolylineRounding() == 0 || GfwTestConfiguration.getPolylineRounding() == 2) {
			int i = 0;
			int bezierDistances[] = new int[points.size() * 2];
			for (Iterator iter = points.iterator(); iter.hasNext();) {
				com.sap.mi.gfw.mm.datatypes.Point dtp = (com.sap.mi.gfw.mm.datatypes.Point) iter.next();
				if (GfwTestConfiguration.getPolylineRounding() == 0) { // rounding on
					bezierDistances[i++] = dtp.getBefore(); // bezierDistancesBefore
					bezierDistances[i++] = dtp.getAfter(); // bezierDistancesAfter
				} else if (GfwTestConfiguration.getPolylineRounding() == 2) { // rounding always
					bezierDistances[i++] = 15; // bezierDistancesBefore
					bezierDistances[i++] = 15; // bezierDistancesAfter
				}
			}
			return bezierDistances;
		}
		return null; // rounding off
	}

	private void unregisterBusinessChangeListeners() {
		if (businessChangeListeners != null) {
			EventRegistry eventRegistry = getEditor().getEventRegistry();
			if (eventRegistry != null) {
				for (int i = 0; i < businessChangeListeners.length; i++) {
					UpdateListener listener = businessChangeListeners[i];
					eventRegistry.deregister(listener);
				}
				businessChangeListeners = null;
			}
		}
	}

	private IGraphicsAlgorithmRendererFactory getGraphicsAlgorithmRendererFactory() {
		return getConfigurationProvider().getDiagramTypeProvider().getGraphicsAlgorithmRendererFactory();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeatureProviderHolder#getFeatureProvider()
	 */
	public IFeatureProvider getFeatureProvider() {
		IConfigurationProvider cp = getConfigurationProvider();
		IFeatureProvider ret = null;
		if (cp != null) {
			ret = cp.getFeatureProvider();
		}
		if (T.racer().info()) {
			T.racer().info("PictogramElementDelegate", "getFeatureProvider", "returns " + ret.toString()); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
		return ret;
	}

	public void setForceRefresh(boolean forceRefresh) {
		this.forceRefresh = forceRefresh;
	}

	protected boolean isForceRefresh() {
		return forceRefresh;
	}

	private DiagramEditor getEditor() {
		return getConfigurationProvider().getDiagramEditor();
	}

	protected void addRenderingDecorators(final GraphicsAlgorithm graphicsAlgorithm, final PictogramElement pe, final IFigure figure,
			IToolBehaviorProvider toolBehaviorProvider) {
		if (pe.isActive() && !(pe instanceof Anchor) && !(pe instanceof Connection) && graphicsAlgorithm.equals(pe.getGraphicsAlgorithm())) {

			List<IFigure> decFigureList = renderingDecoratorMap.get(figure);
			if (decFigureList != null) {
				for (IFigure decFigure : decFigureList) {
					IFigure parent = decFigure.getParent();
					if (parent != null && figure.equals(parent)) {
						figure.remove(decFigure);
					}
				}
				decFigureList.clear();
				renderingDecoratorMap.remove(figure);
			}

			IRenderingDecorator[] renderingDecorators = toolBehaviorProvider.getRenderingDecorators(pe);

			if (renderingDecorators.length > 0) {
				List<IFigure> decList = new ArrayList<IFigure>();
				renderingDecoratorMap.put(figure, decList);
				for (int i = 0; i < renderingDecorators.length; i++) {
					IRenderingDecorator renderingDecorator = renderingDecorators[i];
					IFigure decorateFigure = decorateFigure(figure, renderingDecorator);
					decList.add(decorateFigure);
				}
			}
		}
	}

	public boolean isValid() {
		return valid;
	}

	protected void setValid(boolean valid) {
		this.valid = valid;
	}

	/**
	 * Returns the visual state of this shape.
	 * 
	 * @return The visual state of this shape.
	 */
	public IVisualState getVisualState() {
		if (visualState == null) {
			visualState = new VisualState();
		}
		return visualState;
	}
}
