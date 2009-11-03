package com.sap.mi.gfw.eclipse.internal.editor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EventObject;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.KeyStroke;
import org.eclipse.gef.SnapToGeometry;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.dnd.TemplateTransferDragSourceListener;
import org.eclipse.gef.editparts.GridLayer;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.AlignmentAction;
import org.eclipse.gef.ui.actions.DirectEditAction;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.gef.ui.actions.MatchHeightAction;
import org.eclipse.gef.ui.actions.MatchWidthAction;
import org.eclipse.gef.ui.actions.ToggleGridAction;
import org.eclipse.gef.ui.actions.ZoomInAction;
import org.eclipse.gef.ui.actions.ZoomOutAction;
import org.eclipse.gef.ui.palette.DefaultPaletteViewerPreferences;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gef.ui.palette.PaletteViewerPreferences;
import org.eclipse.gef.ui.palette.PaletteViewerProvider;
import org.eclipse.gef.ui.palette.FlyoutPaletteComposite.FlyoutPreferences;
import org.eclipse.gef.ui.parts.GraphicalViewerKeyHandler;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.gef.ui.parts.SelectionSynchronizer;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.TransferDropTargetListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.internal.KeyBindingService;
import org.eclipse.ui.internal.SaveAsAction;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.progress.UIJob;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.sap.mi.fwk.MarkerManager;
import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.ui.editor.IDecoratingModelEditor;
import com.sap.mi.fwk.ui.editor.ModelEditorInput;
import com.sap.mi.fwk.ui.editor.ModelEditorManager;
import com.sap.mi.fwk.ui.properties.TabbedPropertyContributorServices;
import com.sap.mi.gfw.DiagramScrollingBehavior;
import com.sap.mi.gfw.GfwTestConfiguration;
import com.sap.mi.gfw.GfwUtil;
import com.sap.mi.gfw.datatypes.IDimension;
import com.sap.mi.gfw.datatypes.impl.DimensionImpl;
import com.sap.mi.gfw.dt.IDiagramTypeProvider;
import com.sap.mi.gfw.eclipse.GraphicsPlugin;
import com.sap.mi.gfw.eclipse.Messages;
import com.sap.mi.gfw.eclipse.internal.GfwEclipseConstants;
import com.sap.mi.gfw.eclipse.internal.IResourceRegistry;
import com.sap.mi.gfw.eclipse.internal.IResourceRegistryHolder;
import com.sap.mi.gfw.eclipse.internal.ImagePool;
import com.sap.mi.gfw.eclipse.internal.ResourceRegistry;
import com.sap.mi.gfw.eclipse.internal.action.CopyAction;
import com.sap.mi.gfw.eclipse.internal.action.DeleteAction;
import com.sap.mi.gfw.eclipse.internal.action.PasteAction;
import com.sap.mi.gfw.eclipse.internal.action.PrintGraphicalViewerAction;
import com.sap.mi.gfw.eclipse.internal.action.RemoveAction;
import com.sap.mi.gfw.eclipse.internal.action.UpdateAction;
import com.sap.mi.gfw.eclipse.internal.config.ConfigurationProvider;
import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProviderHolder;
import com.sap.mi.gfw.eclipse.internal.contextbuttons.ContextButtonManagerForPad;
import com.sap.mi.gfw.eclipse.internal.contextbuttons.IContextButtonManager;
import com.sap.mi.gfw.eclipse.internal.dnd.GfwTemplateTransferDropTargetListener;
import com.sap.mi.gfw.eclipse.internal.dnd.ObjectsTransferDropTargetListener;
import com.sap.mi.gfw.eclipse.internal.parts.ConnectionDecoratorEditPart;
import com.sap.mi.gfw.eclipse.internal.parts.DiagramEditPart;
import com.sap.mi.gfw.eclipse.internal.parts.IShapeEditPart;
import com.sap.mi.gfw.eclipse.internal.parts.ShapeEditPart;
import com.sap.mi.gfw.eclipse.internal.platform.GFWExtensionManagerEclipse;
import com.sap.mi.gfw.eclipse.internal.util.Util;
import com.sap.mi.gfw.eclipse.internal.util.gef.ScalableRootEditPartAnimated;
import com.sap.mi.gfw.features.IDirectEditingInfo;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IPrintFeature;
import com.sap.mi.gfw.features.context.IUpdateContext;
import com.sap.mi.gfw.features.context.impl.UpdateContext;
import com.sap.mi.gfw.internal.util.MoinHelper;
import com.sap.mi.gfw.mm.pictograms.Anchor;
import com.sap.mi.gfw.mm.pictograms.AnchorContainer;
import com.sap.mi.gfw.mm.pictograms.ConnectionDecorator;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithmContainer;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Shape;
import com.sap.mi.gfw.platform.IDiagramEditor;
import com.sap.mi.gfw.tb.IToolBehaviorProvider;
import com.sap.mi.gfw.util.LinkUtil;
import com.sap.mi.gfw.util.PeUtil;
import com.sap.mi.gfw.util.T;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.events.CommitListener;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.EventRegistry;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.filter.CompositionHierarchyFilter;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ElementChangeEvent;
import com.sap.tc.moin.repository.events.type.LinkChangeEvent;
import com.sap.tc.moin.repository.events.type.PartitionChangeEvent;
import com.sap.tc.moin.repository.events.type.PartitionMembershipChangeEvent;
import com.tssap.util.ui.dialog.MessageDialog;

/**
 * The Class DiagramEditor.
 */
public class DiagramEditor extends FWGraphicalEditor implements IConfigurationProviderHolder, IDiagramEditor,
		ITabbedPropertySheetPageContributor, IGotoMarker, IDecoratingModelEditor, IResourceRegistryHolder {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.ui.editor.IDecoratingModelEditor#decoratorStateChanged (boolean)
	 */
	public void decoratorStateChanged(boolean newState) {
		refresh();
	}

	private class DiagramChangeListener implements UpdateListener, CommitListener {
		private RefreshDiagramJob refreshDiagramJob;

		DiagramChangeListener() {
			super();
		}

		public void notifyCommit(EventChain events) {
			if (!isAutoRefresh()) {
				return;
			}
			if (GfwTestConfiguration.isCPUProfilingTraceActive()) {
				if (T.racer().info()) {
					T.racer().info("DiagramChangeListener.notifyCommit()"); //$NON-NLS-1$
				}
			}
			for (ChangeEvent ev : events.getEvents()) {
				notify(ev);
			}
		}

		public void notifyUpdate(EventChain events) {
			if (!isAutoRefresh()) {
				return;
			}
			if (GfwTestConfiguration.isCPUProfilingTraceActive()) {
				if (T.racer().info()) {
					T.racer().info("UPDATE EVENT => DiagramChangeListener.notifyUpdate()"); //$NON-NLS-1$
				}
			}

			List<ChangeEvent> eventsList = events.getEvents();
			int eventCount = eventsList.size();
			if (GfwTestConfiguration.isCPUProfilingTraceActive()) {
				if (T.racer().info()) {
					T.racer().info("COUNT      DiagramChangeListener.notifyUpdate()   eventCount = " + eventCount); //$NON-NLS-1$
				}
			}
			if (eventCount < 5000) {
				for (ChangeEvent ev : eventsList) {
					notify(ev);
				}
			} else {
				getRefreshDiagramJob().setRefreshAll();
				getRefreshDiagramJob().schedule(1);
			}
		}

		boolean stopListening() {
			return getRefreshDiagramJob().cancel();
		}

		private void addRelevantChildEditPartsToRefreshJob(PictogramElement pe) {
			Map editPartRegistry = getGraphicalViewer().getEditPartRegistry();
			RefreshDiagramJob refreshJob = getRefreshDiagramJob();

			if (pe instanceof AnchorContainer) {
				AnchorContainer anchorContainer = (AnchorContainer) pe;
				Collection<Anchor> anchors = anchorContainer.getAnchors();
				for (Iterator<Anchor> iter = anchors.iterator(); iter.hasNext();) {
					Anchor anchor = iter.next();
					Collection<com.sap.mi.gfw.mm.pictograms.Connection> incomingConnections = anchor.getIncomingConnections();
					for (Iterator<com.sap.mi.gfw.mm.pictograms.Connection> iterator = incomingConnections.iterator(); iterator.hasNext();) {
						com.sap.mi.gfw.mm.pictograms.Connection connection = iterator.next();
						refreshJob.addEditPart((EditPart) editPartRegistry.get(connection));
						addRelevantChildEditPartsToRefreshJob(connection);
					}
					Collection<com.sap.mi.gfw.mm.pictograms.Connection> outgoingConnections = anchor.getOutgoingConnections();
					for (Iterator<com.sap.mi.gfw.mm.pictograms.Connection> iterator = outgoingConnections.iterator(); iterator.hasNext();) {
						com.sap.mi.gfw.mm.pictograms.Connection connection = iterator.next();
						refreshJob.addEditPart((EditPart) editPartRegistry.get(connection));
						addRelevantChildEditPartsToRefreshJob(connection);
					}
				}
			}

			if (pe instanceof com.sap.mi.gfw.mm.pictograms.Connection) {
				com.sap.mi.gfw.mm.pictograms.Connection connection = (com.sap.mi.gfw.mm.pictograms.Connection) pe;
				for (Iterator<ConnectionDecorator> iter = connection.getConnectionDecorators().iterator(); iter.hasNext();) {
					ConnectionDecorator connectionDecorator = iter.next();
					if (connectionDecorator.isActive()) {
						Object object = editPartRegistry.get(connectionDecorator);
						if (object instanceof EditPart) {
							refreshJob.addEditPart((EditPart) object);
						}
					}
				}
			}
		}

		private PictogramElement calculateActiveContainerPe(RefObject affectedElement) {
			if (affectedElement instanceof PictogramElement) {
				PictogramElement pe = (PictogramElement) affectedElement;
				if (pe.isActive()) {
					return pe;
				}
			}

			GraphicsAlgorithmContainer gac = null;
			if (affectedElement instanceof GraphicsAlgorithmContainer) {
				gac = (GraphicsAlgorithmContainer) affectedElement;
			} else if (affectedElement instanceof com.sap.mi.gfw.mm.datatypes.Point) {
				// com.sap.mi.gfw.mm.datatypes.Point p =
				// (com.sap.mi.gfw.mm.datatypes.Point) affectedElement;
				// RefFeatured refImmediateComposite =
				// p.refImmediateComposite();
				// if (refImmediateComposite instanceof
				// GraphicsAlgorithmContainer) {
				// gac = (GraphicsAlgorithmContainer) refImmediateComposite;
				// }
			}

			PictogramElement ret = null;
			if (gac != null) {
				if (gac instanceof PictogramElement) {
					ret = (PictogramElement) gac;
				} else if (gac instanceof GraphicsAlgorithm) {
					ret = PeUtil.getActiveContainerPe((GraphicsAlgorithm) gac);
				}
			}
			return ret;
		}

		private RefreshDiagramJob getRefreshDiagramJob() {
			if (refreshDiagramJob == null) {
				refreshDiagramJob = new RefreshDiagramJob(Messages.DiagramEditor_0_xmsg);
			}
			return refreshDiagramJob;
		}

		private void notify(ChangeEvent event) {
			if (LISTEN_TO_CHANGES && !(event instanceof PartitionChangeEvent) && !(event instanceof PartitionMembershipChangeEvent)) {
				boolean singleEditPart = false;
				RefreshDiagramJob refreshDiagramJob = getRefreshDiagramJob();
				if (!refreshDiagramJob.isRefreshAll()) {
					GraphicalViewer graphicalViewer = getGraphicalViewer();
					if (graphicalViewer == null) {
						return;
					}
					if (event instanceof ElementChangeEvent) {
						ElementChangeEvent elementChangeEvent = (ElementChangeEvent) event;
						RefObject affectedElement = elementChangeEvent.getAffectedElement(getConnection());
						PictogramElement activeContainerPe = calculateActiveContainerPe(affectedElement);
						if (activeContainerPe != null) {
							Map editPartRegistry = graphicalViewer.getEditPartRegistry();
							Object o = editPartRegistry.get(activeContainerPe);
							if (o instanceof EditPart) {
								EditPart affectedEditPart = (EditPart) o;
								refreshDiagramJob.addEditPart(affectedEditPart);
								singleEditPart = true;
								addRelevantChildEditPartsToRefreshJob(activeContainerPe);
							}
						}
					}
					if (event instanceof LinkChangeEvent) {
						LinkChangeEvent linkChangeEvent = (LinkChangeEvent) event;
						RefFeatured firstLinkEnd = linkChangeEvent.getFirstLinkEnd(getConnection());
						if (firstLinkEnd instanceof RefObject) {
							PictogramElement activeContainerPe = calculateActiveContainerPe((RefObject) firstLinkEnd);
							if (activeContainerPe != null) {
								Map editPartRegistry = graphicalViewer.getEditPartRegistry();
								Object o = editPartRegistry.get(activeContainerPe);
								if (o instanceof EditPart) {
									EditPart affectedEditPart = (EditPart) o;
									refreshDiagramJob.addEditPart(affectedEditPart);
									singleEditPart = true;
									addRelevantChildEditPartsToRefreshJob(activeContainerPe);
								}
							}
						}
					}

					if (!singleEditPart) {
						refreshDiagramJob.setRefreshAll();
					}
				}

				refreshDiagramJob.schedule(1);
			}
		}
	}

	private class RefreshDiagramJob extends UIJob {
		private final List<EditPart> editParts = new ArrayList<EditPart>();

		private boolean refreshAll = false;

		RefreshDiagramJob(String name) {
			super(name);
		}

		@Override
		public IStatus runInUIThread(IProgressMonitor monitor) {
			if (GfwTestConfiguration.isCPUProfilingTraceActive()) {
				if (T.racer().info()) {
					T.racer().info("RUN UI  =>  DiagramEditor.RefreshDiagramJob.runInUIThread()"); //$NON-NLS-1$
				}
			}

			// IDiagramTypeProvider diagramTypeProvider =
			// getConfigurationProvider().getDiagramTypeProvider();
			// if (diagramTypeProvider.isAutoUpdateAtRuntime() && isDirty()) {
			// Diagram diagram = diagramTypeProvider.getDiagram();
			// UpdateContext context = new UpdateContext(diagram);
			// IFeatureProvider featureProvider =
			// diagramTypeProvider.getFeatureProvider();
			// featureProvider.updateIfPossibleAndNeeded(context);
			// }

			initRefresh();
			if (refreshAll) {
				refresh();
			} else {
				for (EditPart ep : editParts) {
					internalRefreshEditPart(ep);
				}
				// refresh all active connection decorators
				Set<Entry> entrySet = getGraphicalViewer().getEditPartRegistry().entrySet();
				for (Entry e : entrySet) {
					Object value = e.getValue();
					if (value instanceof ConnectionDecoratorEditPart) {
						EditPart ep = (EditPart) value;
						ep.refresh();
					}
				}
			}

			refreshAll = false;
			editParts.clear();

			return Status.OK_STATUS;
		}

		void addEditPart(EditPart ep) {
			if (ep instanceof DiagramEditPart) {
				setRefreshAll();
				return;
			}

			if (!editParts.contains(ep)) {
				editParts.add(ep);
			}
		}

		boolean isRefreshAll() {
			return refreshAll;
		}

		void setRefreshAll() {
			this.refreshAll = true;
		}

		@Override
		public boolean belongsTo(Object family) {
			return GfwEclipseConstants.UIJOB_FAMILY_REFRESH.equals(family);
		}
	}

	/**
	 * The Constant DEFAULT_PALETTE_SIZE.
	 */
	protected static final int DEFAULT_PALETTE_SIZE = 130;

	/**
	 * The Constant PALETTE_DOCK_LOCATION.
	 */
	protected static final String PALETTE_DOCK_LOCATION = "Dock location"; //$NON-NLS-1$

	/**
	 * The Constant PALETTE_SIZE.
	 */
	protected static final String PALETTE_SIZE = "Palette Size"; //$NON-NLS-1$

	/**
	 * The Constant PALETTE_STATE.
	 */
	public static final String PALETTE_STATE = "Palette state"; //$NON-NLS-1$

	private static final boolean LISTEN_TO_CHANGES = true;

	// private static final boolean REFRESH_ON_COMMAND_STACK_CHANGES = false;

	private static final boolean REFRESH_ON_GAINED_FOCUS = false;

	private DiagramScrollingBehavior diagramScrollingBehavior = null;

	private PictogramElement pictogramElementsForSelection[] = null;

	private IConfigurationProvider _configurationProvider;

	private KeyHandler _keyHandler;

	private PaletteRoot _paletteRoot;

	private Point mouseLocation;

	private DiagramChangeListener diagramChangeListener;

	private IContextButtonManager contextButtonManager = null;

	private String contributorId = null;

	/* keep refreshed EP/GA/PE to avoid multiple refresh of same figure */
	private HashSet<EditPart> refreshedFigure4EP = new HashSet<EditPart>();

	private HashSet<GraphicsAlgorithm> refreshedFigure4GA = new HashSet<GraphicsAlgorithm>();

	private HashSet<PictogramElement> refreshedFigure4PE = new HashSet<PictogramElement>();

	private IResourceRegistry resourceRegistry = new ResourceRegistry();

	// remember MRIs to select when called from gotoMarker during initialization
	private MRI[] mrisToSelect = null;

	/**
	 * Instantiates a new diagram editor.
	 */
	public DiagramEditor() {
	}

	/**
	 * Inits the refresh.
	 */
	public void initRefresh() {
		refreshedFigure4EP = new HashSet<EditPart>();
		refreshedFigure4GA = new HashSet<GraphicsAlgorithm>();
		refreshedFigure4PE = new HashSet<PictogramElement>();
	}

	/**
	 * Gets the refreshed figure4 ep.
	 * 
	 * @return the refreshed figure4 ep
	 */
	public HashSet<EditPart> getRefreshedFigure4EP() {
		return refreshedFigure4EP;
	}

	/**
	 * Gets the refreshed figure4 ga.
	 * 
	 * @return the refreshed figure4 ga
	 */
	public HashSet<GraphicsAlgorithm> getRefreshedFigure4GA() {
		return refreshedFigure4GA;
	}

	/**
	 * Gets the refreshed figure4 pe.
	 * 
	 * @return the refreshed figure4 pe
	 */
	public HashSet<PictogramElement> getRefreshedFigure4PE() {
		return refreshedFigure4PE;
	}

	/**
	 * Calculates the location in dependence from scrollbars and zoom factor.
	 * 
	 * @param nativeLocation
	 *            the native location
	 * @return the point
	 */
	public Point calculateRealMouseLocation(Point nativeLocation) {

		Point ret = new Point(nativeLocation);
		Point viewLocation;
		// view location depends on the current scroll bar position
		if (getDiagramScrollingBehavior() == DiagramScrollingBehavior.SCROLLBARS_ALWAYS_VISIBLE) {
			viewLocation = getGFWFigureCanvas().getViewport().getViewLocation();
		} else {
			viewLocation = getFigureCanvas().getViewport().getViewLocation();
		}

		ret.x += viewLocation.x;
		ret.y += viewLocation.y;

		ZoomManager zoomManager = (ZoomManager) getGraphicalViewer().getProperty(ZoomManager.class.toString());
		ret = ret.getScaled(1 / zoomManager.getZoom());

		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.CommandStackListener#commandStackChanged(java .util.EventObject)
	 */
	@Override
	public void commandStackChanged(EventObject event) {
		super.commandStackChanged(event);
		/*
		 * disabled to prevent a SWTException (Invalid thread access) from occurring when using a progress bar during long running
		 * operations
		 */
		// firePropertyChange(PROP_DIRTY);
		// if (REFRESH_ON_COMMAND_STACK_CHANGES) {
		// refresh();
		// }
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchPart#dispose()
	 */
	@Override
	public void dispose() {

		if (!isCorrectInitialized()) { // e.g. a PartInitException has been
			// thrown while init()
			return;
		}

		unregisterDiagramChangeListener();

		if (isDirty()) {
			// TODO rollback
		}

		if (_configurationProvider != null) {
			_configurationProvider.dispose();
		}

		_paletteRoot = null;

		// unregister selection listener, registered during createPartControl()
		if (getSite() != null && getSite().getPage() != null) {
			getSite().getPage().removeSelectionListener(this);
		}

		if (resourceRegistry != null) {
			resourceRegistry.dispose();
		}

		super.dispose();
	}

	/**
	 * This implementation returns the ZoomManager for the ZoomManager.class and the OutlinePage for the IContentOutlinePage.class.
	 * 
	 * @param type
	 *            the type
	 * @return the adapter
	 * @see org.eclipse.gef.ui.parts.GraphicalEditor#getAdapter(Class)
	 */
	@Override
	public Object getAdapter(Class type) {
		IConfigurationProvider cfgProvider = getConfigurationProvider();

		if (cfgProvider != null) {
			IToolBehaviorProvider tbp = cfgProvider.getDiagramTypeProvider().getCurrentToolBehaviorProvider();
			if (tbp != null) {
				Object ret = tbp.getAdapter(type);
				if (ret != null) {
					return ret;
				}
			}
		}

		GraphicalViewer viewer = getGraphicalViewer();
		if (type == ZoomManager.class && viewer != null) {
			return viewer.getProperty(ZoomManager.class.toString());
		}

		if (type == IPropertySheetPage.class) {
			if (cfgProvider != null) {
				return new TabbedPropertySheetPage(this);
			}
			return null; // not yet initialized
		}

		return super.getAdapter(type);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seecom.sap.mi.gfw.eclipse.internal.config.IConfigurationProviderHolder# getConfigurationProvider()
	 */
	public IConfigurationProvider getConfigurationProvider() {
		return _configurationProvider;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.platform.IDiagramEditor#getConnection()
	 */
	public Connection getConnection() {
		return getModelEditor().getConnection();
	}

	// ====================== standard behaviour ==============================

	/**
	 * Gets the context button manager.
	 * 
	 * @return the context button manager
	 */
	public IContextButtonManager getContextButtonManager() {
		return contextButtonManager;
	}

	/**
	 * ID for tabbed property sheets.
	 * 
	 * @return the contributor id
	 */
	public String getContributorId() {

		if (contributorId == null) {

			IConfigurationProvider cfgProvider = getConfigurationProvider();
			if (cfgProvider != null) {
				contributorId = TabbedPropertyContributorServices.getContributorId(cfgProvider.getDiagram().getDiagramTypeId());
			}
		}
		return contributorId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.platform.IDiagramEditor#getCurrentSize()
	 */
	public IDimension getCurrentSize() {

		if (getDiagramScrollingBehavior() == DiagramScrollingBehavior.SCROLLBARS_ALWAYS_VISIBLE) {
			GFWFigureCanvas canvas = getGFWFigureCanvas();
			// if this method is called during editor opening, it can fail, so
			// we return "default size".
			if (canvas != null) {
				Dimension size = canvas.getContents().getSize();
				return new DimensionImpl(size.width, size.height);
			} else
				return new DimensionImpl(1024, 768);
		} else {
			FigureCanvas canvas = getFigureCanvas();
			// if this method is called during editor opening, it can fail, so
			// we return "default size".
			if (canvas != null) {
				Dimension size = canvas.getContents().getSize();
				return new DimensionImpl(size.width, size.height);
			} else
				return new DimensionImpl(1024, 768);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.platform.IDiagramEditor#getDiagramTypeProvider()
	 */
	public IDiagramTypeProvider getDiagramTypeProvider() {
		IConfigurationProvider cfgProvider = getConfigurationProvider();
		if (cfgProvider != null)
			return cfgProvider.getDiagramTypeProvider();
		return null;
	}

	private IToolBehaviorProvider getToolBehaviorProvider() {
		IDiagramTypeProvider dtp = getDiagramTypeProvider();
		if (dtp != null) {
			return dtp.getCurrentToolBehaviorProvider();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalEditor#getEditDomain()
	 */
	@Override
	public DefaultEditDomain getEditDomain() {
		return super.getEditDomain();
	}

	/**
	 * Gets the gFW figure canvas.
	 * 
	 * @return the gFW figure canvas
	 */
	public GFWFigureCanvas getGFWFigureCanvas() {
		GraphicalViewer viewer = getGraphicalViewer();
		if (viewer != null)
			return (GFWFigureCanvas) viewer.getControl();
		else
			return null;
	}

	/**
	 * Gets the figure canvas.
	 * 
	 * @return the figure canvas
	 */
	public FigureCanvas getFigureCanvas() {
		GraphicalViewer viewer = getGraphicalViewer();
		if (viewer != null)
			return (FigureCanvas) viewer.getControl();
		else
			return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalEditor#getGraphicalViewer()
	 */
	@Override
	public GraphicalViewer getGraphicalViewer() {
		return super.getGraphicalViewer();
	}

	/**
	 * Gets the mouse location.
	 * 
	 * @return the mouse location
	 */
	public Point getMouseLocation() {
		if (mouseLocation == null) {
			mouseLocation = new Point();
		}
		return mouseLocation;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.platform.IDiagramEditor#getSelectedPictogramElements()
	 */
	public PictogramElement[] getSelectedPictogramElements() {
		PictogramElement pe[] = new PictogramElement[0];
		ISelectionProvider selectionProvider = getSite().getSelectionProvider();
		if (selectionProvider != null) {
			ISelection s = selectionProvider.getSelection();
			if (s instanceof IStructuredSelection) {
				IStructuredSelection sel = (IStructuredSelection) s;
				List list = new ArrayList();
				for (Iterator iter = sel.iterator(); iter.hasNext();) {
					Object o = iter.next();
					if (o instanceof EditPart) {
						EditPart editPart = (EditPart) o;
						if (editPart.getModel() instanceof PictogramElement) {
							list.add(editPart.getModel());
						}
					}
				}
				pe = (PictogramElement[]) list.toArray(new PictogramElement[0]);
			}
		}
		return pe;
	}

	/**
	 * Gets the event registry.
	 * 
	 * @return the event registry
	 */
	public EventRegistry getEventRegistry() {
		EventRegistry eventRegistry = null;
		Connection connection = getConnection();
		if (connection != null && connection.isAlive() && connection.getSession() != null) {
			eventRegistry = connection.getSession().getEventRegistry();
		}
		return eventRegistry;
	}

	/**
	 * Gets the zoom level.
	 * 
	 * @return the zoom level
	 */
	public double getZoomLevel() {
		ZoomManager zoomManager = (ZoomManager) getAdapter(ZoomManager.class);
		if (zoomManager == null)
			return 1;

		/*
		 * avoid long running calculations for large diagrams and zoom factors below 5%
		 */
		return Math.max(0.05D, zoomManager.getZoom());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.ide.IGotoMarker#gotoMarker(org.eclipse.core.resources. IMarker)
	 */
	public void gotoMarker(IMarker marker) {
		String mriString = marker.getAttribute(MarkerManager.ATTRIBUTE_OBJ_MRI, null);

		if (mriString != null) {
			Moin moinInstance = ModelManager.getInstance().getMoinInstance();
			MRI objectMri = moinInstance.createMri(mriString);

			String[] secondaryMris = MarkerManager.getInstance().getSecondaryObjectMris(marker);
			MRI[] mris = new MRI[secondaryMris.length + 1];
			mris[0] = objectMri;

			for (int i = 0; i < secondaryMris.length; i++) {
				MRI mri = moinInstance.createMri(secondaryMris[i]);
				mris[i + 1] = mri;
			}

			if (getModelEditor().isInitialized()) {
				selectMris(mris);
			} else {
				mrisToSelect = mris;
			}
		}
	}

	@Override
	protected void postInit() {
		getDiagramTypeProvider().postInit();
		if (mrisToSelect != null) {
			selectMris(mrisToSelect);
			mrisToSelect = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.platform.IDiagramEditor#refresh()
	 */
	public void refresh() {

		if (!isAlive()) {
			return;
		}

		if (GfwTestConfiguration.isCPUProfilingTraceActive()) {
			if (T.racer().info()) {
				T.racer().info("DiagramEditor.refresh()"); //$NON-NLS-1$
			}
		}

		if (Display.getCurrent() == null) {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					refresh();
				}
			});
			return;
		}

		// this should indicate that the editor is already disposed
		// perhaps you find a better way to do this
		if (_paletteRoot == null)
			return;

		long start = System.currentTimeMillis();

		final EditPart contentEditPart = getContentEditPart();
		if (contentEditPart == null) {
			return;
		}

		internalRefreshEditPart(contentEditPart);

		refreshTitle();

		long stop = System.currentTimeMillis();
		long time = (stop - start);
		if (time > 500) {
			String output = "refresh took " + time + " ms."; //$NON-NLS-1$ //$NON-NLS-2$
			T.racer().warning("DiagramEditor.refresh() ", output); //$NON-NLS-1$
		}

		// prove if switch to direct editing is required
		IDirectEditingInfo dei = getConfigurationProvider().getFeatureProvider().getDirectEditingInfo();
		if (dei.isActive()) {
			EditPart editPart = (EditPart) getGraphicalViewer().getEditPartRegistry().get(dei.getMainPictogramElement());
			if (editPart instanceof ShapeEditPart) {
				ShapeEditPart shapeEditPart = (ShapeEditPart) editPart;
				shapeEditPart.switchToDirectEditingMode(dei.getPictogramElement(), dei.getGraphicsAlgorithm());
				// reset values
				dei.reset();
			}
		}

		if (getPictogramElementsForSelection() != null) {
			selectPictogramElements(getPictogramElementsForSelection());
			setPictogramElementsForSelection(null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalEditor#selectionChanged(org.eclipse .ui.IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		// If not the active editor, ignore selection changed.
		// or should we check for isVisible ???
		// if (this.equals(getSite().getPage().getActiveEditor())) {
		if (getSite().getPage().isPartVisible(this)) {

			// long start = System.nanoTime();
			// this is where we should check the selection source (part)
			// * for CNF view the link flag must be obeyed
			// this would however require a dependency to
			// org.eclipse.ui.navigator
			if (part instanceof CommonNavigator) {
				if (!((CommonNavigator) part).isLinkingEnabled()) {
					return;
				}
			}
			// usefull selection ??
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection structuredSelection = (IStructuredSelection) selection;
				Object firstElement = structuredSelection.getFirstElement();
				RefBaseObject refObject = null;
				if (firstElement instanceof RefObject) {
					refObject = (RefObject) firstElement;
				} else if (firstElement instanceof IAdaptable) {
					refObject = (RefObject) ((IAdaptable) firstElement).getAdapter(RefObject.class);
					if (refObject == null) {
						MRI mri = (MRI) ((IAdaptable) firstElement).getAdapter(MRI.class);
						if (mri != null) {
							refObject = getConnection().getElement(mri);
						}
					}
				}

				if (refObject != null) {
					Diagram diagram = getDiagramTypeProvider().getDiagram();
					List<PictogramElement> referencingPes = LinkUtil.getPictogramElements(LinkUtil.getDiagramLink(diagram, true),
							(RefObject) refObject);
					if (referencingPes.size() > 0) {
						PictogramElement[] pes = referencingPes.toArray(new PictogramElement[referencingPes.size()]);
						selectPictogramElements(pes);
					}
				}
			}
		}
		super.selectionChanged(part, selection);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.platform.IDiagramEditor#selectPictogramElements(com.sap .mi.gfw.mm.pictograms.PictogramElement[])
	 */
	public void selectPictogramElements(PictogramElement[] pictogramElements) {
		List<EditPart> editParts = new ArrayList<EditPart>();
		Map editPartRegistry = getGraphicalViewer().getEditPartRegistry();
		if (editPartRegistry != null) {
			for (int i = 0; i < pictogramElements.length; i++) {
				PictogramElement pe = pictogramElements[i];
				Object obj = editPartRegistry.get(pe);
				if (obj instanceof EditPart) {
					editParts.add((EditPart) obj);
				}
			}
			getSite().getSelectionProvider().setSelection(new StructuredSelection(editParts));
			if (editParts.size() > 0) {
				getGraphicalViewer().reveal(editParts.get(0));
			}
		}
	}

	public IFigure getFigureForPictogramElement(PictogramElement pe) {
		GraphicalEditPart ep = getEditPartForPictogramElement(pe);
		if (ep != null) {
			return ep.getFigure();
		}
		return null;
	}

	public GraphicalEditPart getEditPartForPictogramElement(PictogramElement pe) {
		Map editPartRegistry = getGraphicalViewer().getEditPartRegistry();
		if (editPartRegistry != null) {
			Object obj = editPartRegistry.get(pe);
			if (obj instanceof GraphicalEditPart) {
				GraphicalEditPart ep = (GraphicalEditPart) obj;
				return ep;
			}
		}
		return null;
	}

	private RemoveAction removeAction;

	private boolean autoRefresh = true;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		if (getGraphicalViewer() == null)
			return;

		super.setFocus();
		if (REFRESH_ON_GAINED_FOCUS) {
			refresh();
		}
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		// Eclipse may call us with an IFileEditorInput when a file is to be
		// opened. Try to convert this to a diagram input.
		if (!(input instanceof ModelEditorInput)) {
			IEditorInput newInput = ModelEditorManager.getInstance().convertEditorInput(input, GraphicsPlugin.DIAGRAM_EDITOR_ID);
			if (!(newInput instanceof DiagramEditorInput)) {
				// give up
				throw new PartInitException("Unknown editor input: " + newInput); //$NON-NLS-1$
			}
			input = newInput;
		}

		super.init(site, input);
	}

	@Override
	protected Connection getConnectionFromInput(IEditorInput input) {
		if (input instanceof DiagramEditorInput) {
			DiagramEditorInput dei = (DiagramEditorInput) input;
			Connection connection = dei.getExternalConnection();
			if (connection != null && connection.isAlive()) {
				return connection;
			}
		}
		return null;
	}

	@Override
	protected void doSetInput(IEditorInput input) {
		final String METHOD = "doSetInput(IEditorInput)"; //$NON-NLS-1$

		try {
			// determine filename
			if (input == null)
				throw new IllegalArgumentException("The IEditorInput must not be null"); //$NON-NLS-1$
			if (!(input instanceof DiagramEditorInput))
				throw new IllegalArgumentException("The IEditorInput has the wrong type: " + input.getClass()); //$NON-NLS-1$

			DiagramEditorInput diagramEditorInput = (DiagramEditorInput) input;
			Diagram diagram = diagramEditorInput.getDiagram();

			// can happen if editor is started via marker and marker contains
			// invalid mri
			if (diagram == null) {
				throw new IllegalStateException("Cannot open diagram '" + diagramEditorInput.getName() + "' from project '" //$NON-NLS-1$ //$NON-NLS-2$
						+ diagramEditorInput.getProjectName()
						+ "'. Might have been deleted or was part of a transient partition when saved. See the error log for details."); //$NON-NLS-1$
			}

			String providerId = diagramEditorInput.getProviderId();

			// if provider is null then take the first installed provider
			// for this diagram type
			if (providerId == null) {
				String diagramTypeProviders[] = GfwUtil.getExtensionManager()
						.getDiagramTypeProviderExtensionIds(diagram.getDiagramTypeId());
				if (diagramTypeProviders != null && diagramTypeProviders.length > 0) {
					providerId = diagramTypeProviders[0];
					diagramEditorInput.setProviderId(providerId);
				}
			}

			// get according diagram-type-provider
			IDiagramTypeProvider diagramTypeProvider = GFWExtensionManagerEclipse.getSingleton().createDiagramTypeProvider(providerId);
			if (diagramTypeProvider != null) {
				diagramTypeProvider.init(diagram, this);
				IConfigurationProvider configurationProvider = new ConfigurationProvider(this, diagramTypeProvider);
				setConfigurationProvider(configurationProvider);
				handleAutoUpdateAtStartup(diagram, diagramTypeProvider);
			} else {
				throw new IllegalArgumentException("could not find diagram type provider"); //$NON-NLS-1$
			}

			// registerPartitionChangeListener();
			registerDiagramChangeListener(diagram);

			// set title
			refreshTitle();

			// override title image if the diagram type provider provides an
			// image
			String imageId = diagramTypeProvider.getDiagramTitleImage();
			if (imageId != null) {
				Image image = ImagePool.getImageForId(imageId);
				if (image != null) {
					setTitleImage(image);
				}
			}

		} catch (final Exception e) {

			// report exception async as UI may not be there yet
			getSite().getShell().getDisplay().asyncExec(new Runnable() {
				public void run() {
					String message = "Can not open the modifier. Details " + e.getMessage(); //$NON-NLS-1$
					T.racer().error(message, e);
					T.racer().error(METHOD, message + "\nDetails: " + Util.getStacktrace(e)); //$NON-NLS-1$
					MessageDialog.showError("Error when opening modifier", message, Util.getStacktrace(e)); //$NON-NLS-1$
				}
			});
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.platform.IDiagramEditor#setPictogramElementForSelection (com.sap.mi.gfw.mm.pictograms.PictogramElement)
	 */
	public void setPictogramElementForSelection(PictogramElement pictogramElementForSelection) {
		if (pictogramElementForSelection == null)
			this.pictogramElementsForSelection = null;
		else
			this.pictogramElementsForSelection = new PictogramElement[] { pictogramElementForSelection };
	}

	public void setPictogramElementsForSelection(PictogramElement pictogramElementsForSelection[]) {
		this.pictogramElementsForSelection = pictogramElementsForSelection;
	}

	/**
	 * Called to configure the editor, before it receives its content. The default-implementation is for example doing the following:
	 * configure the ZoomManager, registering Actions... Here everything is done, which is independent of the IConfigurationProvider.
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalEditor#configureGraphicalViewer()
	 */
	@Override
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();

		ScrollingGraphicalViewer viewer = (ScrollingGraphicalViewer) getGraphicalViewer();

		ScalableRootEditPartAnimated rootEditPart = new ScalableRootEditPartAnimated(viewer) {

			@Override
			protected GridLayer createGridLayer() {
				return new com.sap.mi.gfw.eclipse.internal.util.draw2d.GridLayer(getConfigurationProvider());
			}

		};

		// configure ZoomManager
		viewer.setRootEditPart(rootEditPart); // support

		// animation
		// of the
		// zoom
		ZoomManager zoomManager = rootEditPart.getZoomManager();
		List zoomLevels = new ArrayList(3);
		zoomLevels.add(ZoomManager.FIT_ALL);
		zoomLevels.add(ZoomManager.FIT_WIDTH);
		zoomLevels.add(ZoomManager.FIT_HEIGHT);
		zoomManager.setZoomLevelContributions(zoomLevels);
		IToolBehaviorProvider toolBehaviorProvider = getConfigurationProvider().getDiagramTypeProvider().getCurrentToolBehaviorProvider();
		zoomManager.setZoomLevels(toolBehaviorProvider.getZoomLevels());

		// register actions
		registerAction(new ZoomInAction(zoomManager));
		registerAction(new ZoomOutAction(zoomManager));
		registerAction(new DirectEditAction((IWorkbenchPart) this));
		registerAction(new SaveAsAction(((IWorkbenchPart) this).getSite().getWorkbenchWindow()));

		registerAction(new AlignmentAction((IWorkbenchPart) this, PositionConstants.LEFT));
		registerAction(new AlignmentAction((IWorkbenchPart) this, PositionConstants.RIGHT));
		registerAction(new AlignmentAction((IWorkbenchPart) this, PositionConstants.TOP));
		registerAction(new AlignmentAction((IWorkbenchPart) this, PositionConstants.BOTTOM));
		registerAction(new AlignmentAction((IWorkbenchPart) this, PositionConstants.CENTER));
		registerAction(new AlignmentAction((IWorkbenchPart) this, PositionConstants.MIDDLE));
		registerAction(new MatchWidthAction(this));
		registerAction(new MatchHeightAction(this));
		IAction showGrid = new ToggleGridAction(getGraphicalViewer());
		getActionRegistry().registerAction(showGrid);

		// if (getDiagramTypeProvider().getDiagram().isShowGuides())
		// getActionRegistry().registerAction(new
		// ToggleSnapToGeometryAction(getGraphicalViewer()));

		initActionRegsitry();

		// set the keyhandler.
		viewer.setKeyHandler((new GraphicalViewerKeyHandler(viewer)).setParent(getCommonKeyHandler()));

		// settings for grid and guides
		Diagram diagram = getConfigurationProvider().getDiagram();

		boolean snapToGrid = diagram.isSnapToGrid();
		int gridUnit = diagram.getGridUnit();
		boolean gridVisisble = gridUnit > 0;

		viewer.setProperty(SnapToGrid.PROPERTY_GRID_VISIBLE, new Boolean(gridVisisble));
		viewer.setProperty(SnapToGrid.PROPERTY_GRID_ENABLED, new Boolean(snapToGrid));
		viewer.setProperty(SnapToGrid.PROPERTY_GRID_SPACING, new Dimension(gridUnit, gridUnit));
		viewer.setProperty(SnapToGeometry.PROPERTY_SNAP_ENABLED, toolBehaviorProvider.isShowGuides());

		// context button manager
		contextButtonManager = new ContextButtonManagerForPad(this);

		/* sw: make scroll bars always visible */
		if (getDiagramScrollingBehavior() == DiagramScrollingBehavior.SCROLLBARS_ALWAYS_VISIBLE) {
			GFWFigureCanvas figureCanvas = getGFWFigureCanvas();
			if (figureCanvas != null) {
				figureCanvas.setScrollBarVisibility(FigureCanvas.ALWAYS);
			}
		}
	}

	/**
	 * Returns a new ContextMenuProvider. Can be null, if no context-menu shall be displayed.
	 * 
	 * @return A new ContextMenuProvider.
	 */
	protected ContextMenuProvider createContextMenuProvider() {
		return new GraphicsContextMenuProvider(getGraphicalViewer(), getActionRegistry(), getGraphicalViewer().getControl(),
				getConfigurationProvider());
	}

	/**
	 * Creates the GraphicalViewer AND navigation-bar on the specified <code>Composite</code>.
	 * 
	 * @param parent
	 *            the parent composite
	 */
	@Override
	protected void createGraphicalViewer(Composite parent) {
		if (getDiagramScrollingBehavior() == DiagramScrollingBehavior.SCROLLBARS_ALWAYS_VISIBLE) {
			GFWScrollingGraphicalViewer viewer = new GFWScrollingGraphicalViewer(this);
			viewer.createGFWControl(parent);
			setGraphicalViewer(viewer);
			configureGraphicalViewer();
			hookGraphicalViewer();
			initializeGraphicalViewer();
		} else {
			super.createGraphicalViewer(parent);
		}
	}

	/**
	 * Returns the object, which is used to store/provide the preferences for the Palette. This implementation will use the
	 * IModelExtensionProvider as persistent storage.
	 * 
	 * @return The object, which is used to store/provide the preferences for the Palette.
	 */
	protected FlyoutPreferences createPalettePreferences() {
		return new DefaultFlyoutPalettePreferences();
	}

	/**
	 * Creates the PaletteRoot of this editor.
	 * 
	 * @return the palette root
	 * @see com.sap.ide.eclipse.gf.editor.GraphicalEditorIncludingPalette#createPaletteRoot()
	 */
	protected PaletteRoot createPaletteRoot() {
		return new GraphicsPaletteRoot(getConfigurationProvider());
	}

	public void refreshPalette() {
		PaletteRoot pr = getPaletteRoot();
		if (pr instanceof GraphicsPaletteRoot) {
			GraphicsPaletteRoot gpr = (GraphicsPaletteRoot) pr;
			gpr.updatePaletteEntries();
		}
	}

	/**
	 * Returns the PaletteViewerProvider, which can be used to create a new PaletteViewer. This method can be overwritten to return a
	 * subclass of the PaletteViewerProvider, which configures the PaletteViewer with a different ContextMenu, with a PaletteCustomizer or
	 * with a different IPreferencesStore. Do not call this method directly, instead call getPaletteViewerProvider(), which buffers the
	 * created object.
	 * <p>
	 * By default this method returns a new PaletteViewerProvider.
	 * 
	 * @return The PaletteViewerProvider, which can be used to create a new PaletteViewer.
	 */
	@Override
	protected PaletteViewerProvider createPaletteViewerProvider() {
		return new PaletteViewerProvider(getEditDomain()) {
			@Override
			protected void configurePaletteViewer(PaletteViewer viewer) {
				super.configurePaletteViewer(viewer);
				viewer.addDragSourceListener(new TemplateTransferDragSourceListener(viewer));
			}
		};
	}

	/**
	 * Returns the KeyHandler with common bindings for both the Outline and the Graphical Viewer.
	 * 
	 * @return The KeyHandler with common bindings for both the Outline and the Graphical Viewer.
	 */
	public KeyHandler getCommonKeyHandler() {
		if (_keyHandler == null) {
			_keyHandler = new KeyHandler();
			_keyHandler.put(KeyStroke.getPressed(SWT.DEL, 127, 0), getActionRegistry().getAction(ActionFactory.DELETE.getId()));
			_keyHandler.put(KeyStroke.getPressed(SWT.DEL, 127, SWT.SHIFT), getActionRegistry().getAction(RemoveAction.ACTION_ID));
			_keyHandler.put(KeyStroke.getPressed(SWT.F2, 0), getActionRegistry().getAction(GEFActionConstants.DIRECT_EDIT));
			_keyHandler.put(KeyStroke.getPressed('c', SWT.CTRL), getActionRegistry().getAction(ActionFactory.COPY.getId()));
			_keyHandler.put(KeyStroke.getPressed('v', SWT.CTRL), getActionRegistry().getAction(ActionFactory.PASTE.getId()));
			// _keyHandler.put(KeyStroke.getPressed((char) 1, 'a', SWT.CTRL),
			// getActionRegistry().getAction(ActionFactory.SELECT_ALL.getId()));
		}
		return _keyHandler;
	}

	/**
	 * Returns the internal SelectionSynchronizer (because {@link #getSelectionSynchronizer()} is protected).
	 * 
	 * @return The internal SelectionSynchronizer (because {@link #getSelectionSynchronizer()} is protected).
	 */
	public SelectionSynchronizer getSelectionSynchronizerInternal() {
		return getSelectionSynchronizer();
	}

	/**
	 * Returns the internal ActionRegistry (because {@link #getActionRegistry()} is protected).
	 * 
	 * @return The internal ActionRegistry (because {@link #getActionRegistry()} is protected).
	 */
	public ActionRegistry getActionRegistryInternal() {
		return getActionRegistry();
	}

	/**
	 * Returns the contents-editpart of this Editor. This is the topmost EditPart, which contains business-data.
	 * 
	 * @return The contents-editpart of this Editor.
	 */
	protected EditPart getContentEditPart() {
		if (getGraphicalViewer() != null) {
			return getGraphicalViewer().getContents();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette# getPalettePreferences()
	 */
	@Override
	protected FlyoutPreferences getPalettePreferences() {
		return new FlyoutPreferences() {
			public int getDockLocation() {
				return GraphicsPlugin.getDefault().getPreferenceStore().getInt(PALETTE_DOCK_LOCATION);
			}

			public int getPaletteState() {
				return GraphicsPlugin.getDefault().getPreferenceStore().getInt(PALETTE_STATE);
			}

			public int getPaletteWidth() {
				return GraphicsPlugin.getDefault().getPreferenceStore().getInt(PALETTE_SIZE);
			}

			public void setDockLocation(int location) {
				GraphicsPlugin.getDefault().getPreferenceStore().setValue(PALETTE_DOCK_LOCATION, location);
			}

			public void setPaletteState(int state) {
				GraphicsPlugin.getDefault().getPreferenceStore().setValue(PALETTE_STATE, state);
			}

			public void setPaletteWidth(int width) {
				GraphicsPlugin.getDefault().getPreferenceStore().setValue(PALETTE_SIZE, width);
			}
		};
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette#getPaletteRoot ()
	 */
	@Override
	protected PaletteRoot getPaletteRoot() {
		if (_paletteRoot == null)
			_paletteRoot = createPaletteRoot();
		return _paletteRoot;
	}

	/**
	 * Gets the pictogram element for selection.
	 * 
	 * @return the pictogram element for selection
	 */
	protected PictogramElement[] getPictogramElementsForSelection() {
		return pictogramElementsForSelection;
	}

	/**
	 * Called to initialize the editor with its content. Here everything is done, which is dependent of the IConfigurationProvider.
	 */
	@Override
	protected void initializeGraphicalViewer() {

		super.initializeGraphicalViewer();

		// register Actions
		IFeatureProvider featureProvider = getConfigurationProvider().getDiagramTypeProvider().getFeatureProvider();
		if (featureProvider != null) {
			IPrintFeature pf = featureProvider.getPrintFeature();
			if (pf != null) {
				registerAction(new PrintGraphicalViewerAction(getConfigurationProvider(), getConfigurationProvider().getWorkbenchPart(), pf));
			}
		}

		initActionRegsitry();

		buildNewObjectActions();

		// this will cause the ActionBarContributor to refresh with the
		// new actions (there is no specific refresh-action).
		if (getEditorSite().getActionBarContributor() != null)
			getEditorSite().getActionBarContributor().setActiveEditor(this);

		// setting ContextMenuProvider
		ContextMenuProvider contextMenuProvider = createContextMenuProvider();
		if (contextMenuProvider != null) {
			getGraphicalViewer().setContextMenu(contextMenuProvider);
			// the registration allows an extension of the context-menu by other
			// plugins
			getSite().registerContextMenu(contextMenuProvider, getGraphicalViewer());
		}

		// set contents
		getGraphicalViewer().setEditPartFactory(getConfigurationProvider().getEditPartFactory());
		getGraphicalViewer().setContents(getConfigurationProvider().getDiagram());

		// set preference-store for palette
		PaletteViewer paletteViewer = getEditDomain().getPaletteViewer();
		if (paletteViewer != null) {
			IPreferenceStore store = GraphicsPlugin.getDefault().getPreferenceStore();
			paletteViewer.setPaletteViewerPreferences(new DefaultPaletteViewerPreferences(store));

			// change the palette's background color to WHITE
			// ((Figure) ((PaletteRootEditPart)
			// paletteViewer.getRootEditPart()).getContentPane().getChildren().get(0))
			// .setBackgroundColor(ColorConstants.white);

			// Refresh the PaletteViewer
			// This can be achieved by firing a font-change-event from the
			// IPreferenceStore.
			// It would be nicer, if the PaletteViewer would have some kind of
			// refresh()-method directly.
			store.firePropertyChangeEvent(PaletteViewerPreferences.PREFERENCE_FONT, null, null);
		}

		getGraphicalViewer().getControl().addMouseMoveListener(new MouseMoveListener() {
			public void mouseMove(MouseEvent e) {
				setMouseLocation(e.x, e.y);
			}
		});

		getGraphicalViewer()
				.addDropTargetListener((TransferDropTargetListener) new ObjectsTransferDropTargetListener(getGraphicalViewer()));

		getGraphicalViewer().addDropTargetListener(new GfwTemplateTransferDropTargetListener(getGraphicalViewer()));

		registerDiagramChangeListener(getDiagramTypeProvider().getDiagram());
	}

	/**
	 * Inits the action regsitry.
	 */
	protected void initActionRegsitry() {
		final ActionRegistry actionRegistry = getActionRegistry();
		final List selectionActions = getSelectionActions();

		// register predefined actions (e.g. update, remove, delete, ...)
		IAction action = new UpdateAction(this, getConfigurationProvider());
		actionRegistry.registerAction(action);
		selectionActions.add(action.getId());

		if (removeAction == null) {
			removeAction = new RemoveAction(this, getConfigurationProvider());
			action = removeAction;
			actionRegistry.registerAction(action);
			selectionActions.add(action.getId());
		}

		action = new DeleteAction(this, getConfigurationProvider());
		actionRegistry.registerAction(action);
		selectionActions.add(action.getId());

		action = new CopyAction(this, getConfigurationProvider());
		actionRegistry.registerAction(action);
		selectionActions.add(action.getId());

		action = new PasteAction(this, getConfigurationProvider());
		actionRegistry.registerAction(action);
		selectionActions.add(action.getId());
	}

	/**
	 * selects the editpart the PE is associated with.
	 * 
	 * @param pictogramElement
	 *            the pictogram element
	 */
	protected void selectEditPartFor(PictogramElement pictogramElement) {
		EditPart editPart = (EditPart) getGraphicalViewer().getEditPartRegistry().get(pictogramElement);

		if (editPart == null) {
			if (MoinHelper.isObjectAlive(pictogramElement) && pictogramElement instanceof Shape)
				selectEditPartFor(((Shape) pictogramElement).getContainer());

		} else {
			getGraphicalViewer().select(editPart);
		}
	}

	/**
	 * Internal refresh edit part.
	 * 
	 * @param editPart
	 *            the edit part
	 */
	void internalRefreshEditPart(final EditPart editPart) {
		if (Display.getCurrent() == null) {
			Display.getDefault().syncExec(new Runnable() {
				public void run() {
					internalRefreshEditPart(editPart);
					// refreshOutline();
				}
			});
			return;
		}

		long start = System.currentTimeMillis();

		try {
			getContextButtonManager().hideContextButtonsInstantly();

			editPart.refresh();

			long stop = System.currentTimeMillis();
			long time = (stop - start);
			if (time > 500) {
				String output = "refreshEditPart took " + time + " ms."; //$NON-NLS-1$ //$NON-NLS-2$
				T.racer().warning("DiagramEditor.refreshEditPart() ", output); //$NON-NLS-1$

			}
		} catch (NullPointerException e) {
			T.racer().error("refresh edit part problem", e); //$NON-NLS-1$
		}
	}

	/**
	 * Sets the mouse location.
	 * 
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	void setMouseLocation(int x, int y) {
		getMouseLocation().setLocation(x, y);

		// <sw 3.9.08> translate mouse position from absolute coordinates to
		// canvas coordinates
		// Point viewPortLocation;
		// if (getDiagramScrollingBehavior() ==
		// DiagramScrollingBehavior.SCROLLBARS_ALWAYS_VISIBLE) {
		// viewPortLocation =
		// getGFWFigureCanvas().getViewport().getViewLocation();
		// } else {
		// viewPortLocation = getFigureCanvas().getViewport().getViewLocation();
		// }
		// getMouseLocation().setLocation(x + viewPortLocation.x, y +
		// viewPortLocation.y);
		// </sw 3.9.08>
	}

	/**
	 * Creates and registers the "New ..." actions. Those actions are dependent on the IConfigurationProvider.
	 */
	private void buildNewObjectActions() {
		if (getConfigurationProvider() == null) // can happen for example on
			// first initialization
			return;

		// XXX: create and register the new-object-actions
	}

	private DiagramChangeListener getDiagramChangeListener() {
		if (diagramChangeListener == null) {
			diagramChangeListener = new DiagramChangeListener();
		}
		return diagramChangeListener;
	}

	/**
	 * Handle auto update at startup.
	 * 
	 * @param diagram
	 *            the diagram
	 * @param diagramTypeProvider
	 *            the diagram type provider
	 */
	protected void handleAutoUpdateAtStartup(Diagram diagram, IDiagramTypeProvider diagramTypeProvider) {
		IFeatureProvider featureProvider = diagramTypeProvider.getFeatureProvider();
		IUpdateContext updateCtx = new UpdateContext(diagram);
		if (diagramTypeProvider.isAutoUpdateAtStartup()) {
			featureProvider.updateIfPossibleAndNeeded(updateCtx);
			refresh();
		}
	}

	private void refreshTitle() {
		String name = getConfigurationProvider().getDiagramTypeProvider().getDiagramTitle();
		if (name == null || name.length() == 0) {
			name = getConfigurationElement().getAttribute("name"); //$NON-NLS-1$
		}
		setPartName(name);
	}

	/**
	 * Register action.
	 * 
	 * @param action
	 *            the action
	 */
	protected void registerAction(IAction action) {
		if (action == null)
			return;
		getActionRegistry().registerAction(action);
		// getSite().getKeyBindingService().registerAction(action);

		KeyBindingService kbs = ((KeyBindingService) getSite().getService(KeyBindingService.class));
		if (kbs != null) {
			kbs.registerAction(action);
		}
		getSelectionActions().add(action.getId());
	}

	/**
	 * Register diagram change listener.
	 * 
	 * @param diagram
	 *            the diagram
	 */
	protected void registerDiagramChangeListener(Diagram diagram) {
		EventRegistry eventRegistry = getEventRegistry();
		if (eventRegistry != null) {
			EventFilter chFilter = new CompositionHierarchyFilter(diagram);
			// EventFilter pFilter = new PartitionFilter(((Partitionable)
			// diagram).get___Partition());
			// eventRegistry.registerListener(new DiagramChangeListener(), new
			// OrFilter(new EventFilter[] { chFilter,
			// pFilter }));

			// eventRegistry.registerCommitListener(getDiagramChangeListener(),
			// chFilter);
			eventRegistry.registerUpdateListener(getDiagramChangeListener(), chFilter);

			// eventRegistry.registerCommitListener(getDiagramChangeListener(),
			// chFilter);
		}
	}

	private void selectMris(MRI[] mris) {

		List<PictogramElement> selection = new ArrayList<PictogramElement>();
		List<RefObject> possibleBOs = new ArrayList<RefObject>();
		Connection c = getConnection();

		for (MRI mri : mris) {
			RefBaseObject element = c.getElement(mri);
			if (element instanceof PictogramElement) {
				PictogramElement pe = (PictogramElement) element;
				if (pe.isActive()) {
					selection.add(pe);
				}
			} else if (element instanceof RefObject) {
				possibleBOs.add((RefObject) element);
			}
		}

		Diagram diagram = getDiagramTypeProvider().getDiagram();
		List<PictogramElement> referencingPes = LinkUtil.getPictogramElements(diagram, possibleBOs, true);
		selection.addAll(referencingPes);
		PictogramElement[] pes = selection.toArray(new PictogramElement[0]);

		selectPictogramElements(pes);
	}

	private void setConfigurationProvider(IConfigurationProvider configurationProvider) {

		_configurationProvider = configurationProvider;

		// initialize configuration-provider depending on this editor
		_configurationProvider.setWorkbenchPart(this);

		if (getGraphicalViewer() != null)
			initializeGraphicalViewer();

		DefaultEditDomain editDomain = new DefaultEditDomain(this);
		// XXX: replace default CommandStack with CombinedCommandStack
		CommandStack commandStack = new CommandStack();
		commandStack = new GFWCommandStack(getConnection().getCommandStack(), getDiagramTypeProvider().getFeatureProvider(),
				getConnection());
		editDomain.setCommandStack(commandStack);
		setEditDomain(editDomain);
	}

	private void unregisterDiagramChangeListener() {
		getDiagramChangeListener().stopListening();
		EventRegistry eventRegistry = getEventRegistry();
		if (eventRegistry != null) {
			eventRegistry.deregister(getDiagramChangeListener());
		}
	}

	/**
	 * Checks if is alive.
	 * 
	 * @return TRUE, if editor contains a valid MOIN connection and a valid Diagram
	 */
	public boolean isAlive() {
		IConfigurationProvider cp = getConfigurationProvider();
		if (cp != null) {
			Connection connection = getConnection();
			Diagram diagram = cp.getDiagram();
			if (connection != null && connection.isAlive() && MoinHelper.isObjectAlive(diagram)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Gets the diagram scrolling behavior.
	 * 
	 * @return the diagram scrolling behavior
	 */
	public DiagramScrollingBehavior getDiagramScrollingBehavior() {
		if (this.diagramScrollingBehavior == null) {
			IToolBehaviorProvider tbp = getConfigurationProvider().getDiagramTypeProvider().getCurrentToolBehaviorProvider();
			this.diagramScrollingBehavior = tbp.getDiagramScrollingBehavior();
		}
		return this.diagramScrollingBehavior;
	}

	/**
	 * Checks if is auto refresh.
	 * 
	 * @return true, if is auto refresh
	 */
	protected boolean isAutoRefresh() {
		return autoRefresh;
	}

	/**
	 * Sets the auto refresh.
	 * 
	 * @param b
	 *            the new auto refresh
	 */
	protected void setAutoRefresh(boolean b) {
		autoRefresh = b;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.EditorPart#getTitleToolTip()
	 */
	@Override
	public String getTitleToolTip() {
		if (getDiagramTypeProvider() != null && getDiagramTypeProvider().getCurrentToolBehaviorProvider() != null) {
			IToolBehaviorProvider tbp = getDiagramTypeProvider().getCurrentToolBehaviorProvider();
			String titleToolTip = tbp.getTitleToolTip();
			if (titleToolTip != null) {
				return titleToolTip;
			}
		}
		return super.getTitleToolTip();
	}

	public void refreshTitleToolTip() {
		setTitleToolTip(getTitleToolTip());
	}

	public IResourceRegistry getResourceRegistry() {
		return resourceRegistry;
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		IToolBehaviorProvider tbp = getToolBehaviorProvider();
		if (tbp != null) {
			tbp.preSave();
		}
		super.doSave(monitor);
		if (tbp != null) {
			tbp.postSave();
		}
	}

	public void refreshRenderingDecorators(PictogramElement pe) {
		GraphicalEditPart ep = getEditPartForPictogramElement(pe);
		if (ep instanceof IShapeEditPart) {
			IShapeEditPart sep = (IShapeEditPart) ep;
			sep.refreshRenderingDecorators();
		}
	}
}