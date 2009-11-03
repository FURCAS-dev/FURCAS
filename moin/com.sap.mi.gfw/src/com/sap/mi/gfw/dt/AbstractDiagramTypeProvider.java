package com.sap.mi.gfw.dt;

import com.sap.mi.gfw.autolayout.ILayoutStructureProvider;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.mm.links.DiagramLink;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.notification.INotificationService;
import com.sap.mi.gfw.notification.MoinNotificationService;
import com.sap.mi.gfw.platform.AbstractGFWExtension;
import com.sap.mi.gfw.platform.IDiagramEditor;
import com.sap.mi.gfw.platform.IPlatformImageConstants;
import com.sap.mi.gfw.platform.ga.IGraphicsAlgorithmRendererFactory;
import com.sap.mi.gfw.tb.AdvancedToolBehaviorProvider;
import com.sap.mi.gfw.tb.IToolBehaviorProvider;
import com.sap.mi.gfw.util.LinkUtil;
import com.sap.mi.gfw.util.T;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.CommandStack;
import com.sap.tc.moin.repository.events.EventRegistry;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.filter.EventTypeFilter;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.events.type.PartitionChangeEvent;

/**
 * The Class AbstractDiagramTypeProvider.
 */
public abstract class AbstractDiagramTypeProvider extends AbstractGFWExtension implements IDiagramTypeProvider {

	private IToolBehaviorProvider[] availableToolBehaviorProviders = null;

	private Diagram diagram;

	private IDiagramEditor diagramEditor;

	// Cache DiagramLink
	private DiagramLink diagramLink = null;

	private IFeatureProvider featureProvider;

	private INotificationService notificationService;

	private int currentToolBahaviorIndex = 0;

	/**
	 * Instantiates a new abstract diagram type provider.
	 */
	public AbstractDiagramTypeProvider() {
		super();
	}

	/*
	 * @see com.sap.mi.gfw.dt.IDiagramTypeProvider#createLink(java.lang.Object[])
	 */
	// public void link(PictogramElement pictogramElement, Object[]
	// businessObjects) {
	// // create link
	// PictogramLink newLink =
	// PackageUtil.getLinksPackage(getDiagram()).getPictogramLink().createPictogramLink();
	// newLink.setPictogramElement(pictogramElement);
	//
	// for (int i = 0; i < businessObjects.length; i++) {
	// List linkBos = newLink.getBusinessObjects();
	// linkBos.add(businessObjects[i]);
	// }
	//
	// // add new link to diagram-link
	// if (getDiagramLink() != null) {
	// getDiagramLink().getPictogramLinks().add(newLink);
	// }
	// }
	/*
	 * @see com.sap.mi.gfw.dt.IDiagramTypeProvider#getToolBehaviorProviders()
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.dt.IDiagramTypeProvider#getAvailableToolBehaviorProviders()
	 */
	public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {
		if (availableToolBehaviorProviders == null) {
			availableToolBehaviorProviders = new IToolBehaviorProvider[] { new AdvancedToolBehaviorProvider(this) };
		}
		return availableToolBehaviorProviders;
	}

	/*
	 * @see com.sap.mi.gfw.dt.IDiagramTypeProvider#getCurrentToolBehaviorProvider()
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.dt.IDiagramTypeProvider#getCurrentToolBehaviorProvider()
	 */
	public IToolBehaviorProvider getCurrentToolBehaviorProvider() {
		IToolBehaviorProvider ret = null;
		if (getAvailableToolBehaviorProviders().length > 0) {
			ret = getAvailableToolBehaviorProviders()[getCurrentToolBahaviorIndex()];
		}
		return ret;
	}

	public int getCurrentToolBahaviorIndex() {
		return currentToolBahaviorIndex;
	}

	public void setCurrentToolBahaviorIndex(int index) {
		if (currentToolBahaviorIndex != index) {
			if (index < 0 || index >= getAvailableToolBehaviorProviders().length) {
				throw new IllegalArgumentException("Index not valid"); //$NON-NLS-1$
			}
			currentToolBahaviorIndex = index;

			IDiagramEditor de = getDiagramEditor();
			de.refresh();
			de.refreshPalette();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.dt.IDiagramTypeProvider#getDiagram()
	 */
	public Diagram getDiagram() {
		return diagram;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.dt.IDiagramTypeProvider#getDiagramLink()
	 */
	public final DiagramLink getDiagramLink() {
		if (diagramLink == null) {
			diagramLink = LinkUtil.getDiagramLink(getDiagram(), true);
		}
		return diagramLink;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.dt.IDiagramTypeProvider#getDiagramTitle()
	 */
	public String getDiagramTitle() {
		String name = ""; //$NON-NLS-1$
		if (getDiagram() != null) {
			name = getDiagram().getName();
		}
		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.dt.IDiagramTypeProvider#getDiagramEditor()
	 */
	public IDiagramEditor getDiagramEditor() {
		return diagramEditor;
	}

	/*
	 * @see com.sap.mi.gfw.dt.IDiagramTypeProvider#getActionProvider()
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeatureProviderHolder#getFeatureProvider()
	 */
	public IFeatureProvider getFeatureProvider() {
		if (featureProvider == null) {
			T.racer().error("featureProvider is null"); //$NON-NLS-1$
		}
		return featureProvider;
	}

	/*
	 * @see com.sap.mi.gfw.dt.IDiagramTypeProvider#init(com.sap.mi.gfw.mm.pictograms.Diagram, com.sap.mi.gfw.platform.IPlatformService)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.dt.IDiagramTypeProvider#init(com.sap.mi.gfw.mm.pictograms.Diagram, com.sap.mi.gfw.platform.IDiagramEditor)
	 */
	public void init(Diagram diagram, IDiagramEditor diagramEditor) {
		setDiagram(diagram);
		setDiagramEditor(diagramEditor);
	}

	private void registerAsMoinUpdateListener() {
		final INotificationService ns = getNotificationService();
		if (ns instanceof UpdateListener) {
			final IFeatureProvider fp = getFeatureProvider();
			if (fp != null) {
				final Connection connection = fp.getConnection();
				if (connection != null) {
					MoinNotificationService mns = (MoinNotificationService) ns;
					EventFilter filter = new EventTypeFilter(ModelChangeEvent.class);
					EventFilter partitionFilter = new EventTypeFilter(PartitionChangeEvent.class);
					final EventRegistry eventRegistry = connection.getEventRegistry();
					CommandStack cStack = connection.getCommandStack();
					boolean stackEmpty = cStack.getUndoStack().isEmpty();
					// Open a command group to avoid direct JMI call, when
					// registering event listener
					cStack.openGroup("InitialListenerRegistration"); //$NON-NLS-1$
					eventRegistry.registerUpdateListener(mns, filter);
					// TODO: Check the event type!
					eventRegistry.registerUpdateListener(mns.getPartitionListener(), partitionFilter);
					cStack.closeGroup();
					if (stackEmpty) {
						cStack.clear();
					}
				}
			}
		}
	}

	private void setDiagramEditor(IDiagramEditor diagramEditor) {
		this.diagramEditor = diagramEditor;
	}

	/**
	 * @param diagram
	 *            The diagram to set.
	 */
	private void setDiagram(Diagram diagram) {
		this.diagram = diagram;
		// TODO: check if this is the right place to do the registration!
		// This registration should happen only once, and after a Connection is
		// available, obtained from the featureProvider
		registerAsMoinUpdateListener();
	}

	/**
	 * Sets the feature provider.
	 * 
	 * @param featureProvider
	 *            The featureProvider to set.
	 */
	protected void setFeatureProvider(IFeatureProvider featureProvider) {
		this.featureProvider = featureProvider;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.dt.IDiagramTypeProvider#isAutoUpdateAtRuntime()
	 */
	public boolean isAutoUpdateAtRuntime() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.dt.IDiagramTypeProvider#isAutoUpdateAtStartup()
	 */
	public boolean isAutoUpdateAtStartup() {
		return false;
	}

	/**
	 * Gets the layout provider.
	 * 
	 * @return the layout provider
	 */
	public ILayoutStructureProvider getLayoutProvider() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.dt.IDiagramTypeProvider#getDiagramTitleImage()
	 */
	public String getDiagramTitleImage() {
		return IPlatformImageConstants.IMG_DIAGRAM;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.dt.IDiagramTypeProvider#dispose()
	 */
	public void dispose() {
		if (getCurrentToolBehaviorProvider() != null) {
			getCurrentToolBehaviorProvider().dispose();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.dt.IDiagramTypeProvider#getNotificationService()
	 */
	public INotificationService getNotificationService() {
		if (notificationService == null) {
			notificationService = new MoinNotificationService(this);
		}
		return notificationService;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.dt.IDiagramTypeProvider#getRelatedBusinessObjects(java.lang.Object[])
	 */
	public Object[] getRelatedBusinessObjects(Object[] bos) {
		return new Object[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.dt.IDiagramTypeProvider#getGraphicsAlgorithmRendererFactory()
	 */
	public IGraphicsAlgorithmRendererFactory getGraphicsAlgorithmRendererFactory() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.dt.IDiagramTypeProvider#postInit()
	 */
	public void postInit() {
	}
}