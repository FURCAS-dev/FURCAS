package com.sap.mi.gfw.eclipse.internal.editor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
import org.eclipse.gef.palette.ConnectionCreationToolEntry;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteStack;
import org.eclipse.gef.palette.PanningSelectionToolEntry;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.jface.resource.ImageDescriptor;

import com.sap.mi.gfw.eclipse.Messages;
import com.sap.mi.gfw.eclipse.internal.ImagePool;
import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.eclipse.internal.util.gef.MultiCreationFactory;
import com.sap.mi.gfw.features.ICreateFeature;
import com.sap.mi.gfw.palette.IConnectionCreationToolEntry;
import com.sap.mi.gfw.palette.ICreationToolEntry;
import com.sap.mi.gfw.palette.IObjectCreationToolEntry;
import com.sap.mi.gfw.palette.IPaletteCompartmentEntry;
import com.sap.mi.gfw.palette.IStackToolEntry;
import com.sap.mi.gfw.palette.IToolEntry;
import com.sap.mi.gfw.tb.IToolBehaviorProvider;

/**
 * This PaletteRoot provides some standard-tools and adds them to the Palette.
 * <p>
 * Some of the standard-tools are: selection-tool, marque-tool, connection-tool, creation-tools.
 */
public class GraphicsPaletteRoot extends PaletteRoot {

	/*
	 * later we can make this configurable in the toolbehaviour provider, so that the dtp developer can influence the creation style from
	 * palette
	 */
	private static boolean DND_FROM_PALETTE = true; // if true then drag&drop from the palette is possible

	private IConfigurationProvider cfgProvider;

	/**
	 * Creates a new GenericPaletteRoot for the given Model. It is constructed by calling createModelIndependentTools() and
	 * createCreationTools().
	 * 
	 * @param configurationProvider
	 *            the configuration provider
	 */
	public GraphicsPaletteRoot(IConfigurationProvider configurationProvider) {
		cfgProvider = configurationProvider;
		updatePaletteEntries();
	}

	/**
	 * Creates resp. updates the PaletteEntries. All old PaletteEntries will be removed and new ones will be created by calling the
	 * corresponding create-methods.
	 */
	public void updatePaletteEntries() {
		// remove old entries
		setDefaultEntry(null);
		List allEntries = new ArrayList(getChildren()); // MUST make a copy
		for (Iterator iter = allEntries.iterator(); iter.hasNext();) {
			PaletteEntry entry = (PaletteEntry) iter.next();
			remove(entry);
		}

		// create new entries
		add(createModelIndependentTools());

		IToolBehaviorProvider currentToolBehaviorProvider = cfgProvider.getDiagramTypeProvider().getCurrentToolBehaviorProvider();

		IPaletteCompartmentEntry[] paletteCompartments = currentToolBehaviorProvider.getPaletteCompartments();

		for (IPaletteCompartmentEntry compartmentEntry : paletteCompartments) {
			PaletteDrawer drawer = new PaletteDrawer(compartmentEntry.getLabel(), getImageDescriptor(compartmentEntry));
			if (!compartmentEntry.isInitiallyOpen()) {
				drawer.setInitialState(PaletteDrawer.INITIAL_STATE_CLOSED);
			}
			add(drawer);

			List<IToolEntry> toolEntries = compartmentEntry.getToolEntries();

			for (IToolEntry toolEntry : toolEntries) {

				if (toolEntry instanceof ICreationToolEntry) {
					ICreationToolEntry creationToolEntry = (ICreationToolEntry) toolEntry;

					PaletteEntry createTool = createTool(creationToolEntry);
					if (createTool != null) {
						drawer.add(createTool);
					}

				} else if (toolEntry instanceof IStackToolEntry) {
					IStackToolEntry stackToolEntry = (IStackToolEntry) toolEntry;
					PaletteStack stack = new PaletteStack(stackToolEntry.getLabel(), stackToolEntry.getDescription(), ImagePool
							.getImageDescriptorForId(stackToolEntry.getIconId()));
					drawer.add(stack);
					List<ICreationToolEntry> creationToolEntries = stackToolEntry.getCreationToolEntries();
					for (ICreationToolEntry creationToolEntry : creationToolEntries) {
						PaletteEntry createTool = createTool(creationToolEntry);
						if (createTool != null) {
							stack.add(createTool);
						}
					}
				}

			}

		}

		// PaletteEntry creationTools = createCreationTools();
		// if (creationTools != null)
		// add(creationTools);
	}

	/**
	 * Creates and adds the model-independent tools to a new PaletteContainer. Those are for example: selection-tool, marque-tool,
	 * connection-tool.
	 * 
	 * @return The PaletteContainer withe the model-independent tools.
	 */
	protected PaletteContainer createModelIndependentTools() {
		PaletteGroup controlGroup = new PaletteGroup(Messages.GraphicsPaletteRoot_0_xmen);
		List<PaletteEntry> entries = new ArrayList<PaletteEntry>();

		// selection tool
		ToolEntry tool = new PanningSelectionToolEntry();
		entries.add(tool);
		setDefaultEntry(tool);

		// marquee tool
		tool = new GfwMarqueeToolEntry();
		entries.add(tool);

		controlGroup.addAll(entries);
		return controlGroup;
	}

	/**
	 * Creates and adds the creation-tools to a new PaletteContainer. Those creation-tools are created depending on the information in the
	 * Model.
	 * 
	 * @return The PaletteContainer with the the creation-tools.
	 */
	// protected PaletteContainer createCreationTools() {
	//
	// if (cfgProvider == null) {
	// // can happen for example on first initialization
	// return null;
	// }
	//
	// List<PaletteEntry> entries = new LinkedList<PaletteEntry>();
	//
	// IDiagramTypeProvider diagramTypeProvider =
	// cfgProvider.getDiagramTypeProvider();
	// IFeatureProvider featureProvider =
	// diagramTypeProvider.getFeatureProvider();
	// if (featureProvider != null) {
	// ICreateConnectionFeature[] connectionFeatures =
	// featureProvider.getCreateConnectionFeatures();
	// for (int i = 0; i < connectionFeatures.length; i++) {
	// ICreateConnectionFeature feat = connectionFeatures[i];
	// DefaultCreationFactory cf = new DefaultCreationFactory(feat,
	// ICreateFeature.class);
	// PaletteEntry pe = new ConnectionCreationToolEntry(feat.getCreateName(),
	// feat.getCreateDescription(),
	// cf, ImagePool.getImageDescriptor(ImagePool.IMG_CONNECTION_SMALL),
	// ImagePool
	// .getImageDescriptor(ImagePool.IMG_CONNECTION_LARGE));
	// entries.add(pe);
	// }
	//
	// ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();
	// for (int i = 0; i < createFeatures.length; i++) {
	// ICreateFeature feat = createFeatures[i];
	// if
	// (diagramTypeProvider.getCurrentToolBehaviorProvider().isPaletteApplicable(feat))
	// {
	// DefaultCreationFactory cf = new DefaultCreationFactory(feat,
	// ICreateFeature.class);
	// Object template = (DND_FROM_PALETTE == true) ? cf : null;
	// PaletteEntry pe = new CombinedTemplateCreationEntry(feat.getCreateName(),
	// feat
	// .getCreateDescription(), template, cf,
	// ImagePool.getImageDescriptorForId(feat
	// .getCreateImageId()),
	// ImagePool.getImageDescriptorForId(feat.getCreateImageId()));
	// entries.add(pe);
	// }
	// }
	// }
	// if (entries.size() == 0)
	// return null;
	//
	// PaletteDrawer drawer = new
	// PaletteDrawer(TextPool.getString(TextPool.PALETTE_CREATION_GROUP), null);
	// drawer.addAll(entries);
	// return drawer;
	// }
	private PaletteEntry createTool(ICreationToolEntry creationToolEntry) {

		if (creationToolEntry instanceof IObjectCreationToolEntry) {
			IObjectCreationToolEntry objectCreationToolEntry = (IObjectCreationToolEntry) creationToolEntry;

			ICreateFeature feat = objectCreationToolEntry.getCreateFeature();

			boolean paletteApplicable = cfgProvider.getDiagramTypeProvider().getCurrentToolBehaviorProvider().isPaletteApplicable(feat);

			if (paletteApplicable) {
				DefaultCreationFactory cf = new DefaultCreationFactory(feat, ICreateFeature.class);
				Object template = (DND_FROM_PALETTE == true) ? cf : null;

				PaletteEntry pe = new CombinedTemplateCreationEntry(feat.getCreateName(), feat.getCreateDescription(), template, cf,
						getImageDescriptor(creationToolEntry, true), getImageDescriptor(creationToolEntry, false));

				return pe;
			}

		} else if (creationToolEntry instanceof IConnectionCreationToolEntry) {
			IConnectionCreationToolEntry connectionCreationToolEntry = (IConnectionCreationToolEntry) creationToolEntry;

			MultiCreationFactory multiCreationFactory = new MultiCreationFactory(connectionCreationToolEntry.getCreateConnectionFeatures());

			PaletteEntry pe = new ConnectionCreationToolEntry(creationToolEntry.getLabel(), creationToolEntry.getDescription(),
					multiCreationFactory, getImageDescriptor(creationToolEntry, true), getImageDescriptor(creationToolEntry, false));

			return pe;

		}

		return null;
	}

	private class DefaultCreationFactory implements CreationFactory {

		private Object obj;

		private Object objType;

		/**
		 * 
		 */
		public DefaultCreationFactory(Object obj, Object objType) {
			super();
			this.obj = obj;
			this.objType = objType;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.gef.requests.CreationFactory#getNewObject()
		 */
		public Object getNewObject() {
			return obj;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.gef.requests.CreationFactory#getObjectType()
		 */
		public Object getObjectType() {
			return objType;
		}

	}

	private ImageDescriptor getImageDescriptor(ICreationToolEntry creationToolEntry, boolean smallImage) {
		ImageDescriptor imageDescriptor = null;
		if (creationToolEntry instanceof IEclipseImageDescriptor) {
			imageDescriptor = ((IEclipseImageDescriptor) creationToolEntry).getImageDescriptor();
		} else {
			String iconId = (smallImage) ? creationToolEntry.getIconId() : creationToolEntry.getLargeIconId();
			imageDescriptor = ImagePool.getImageDescriptorForId(iconId);
		}
		return imageDescriptor;
	}

	private ImageDescriptor getImageDescriptor(IPaletteCompartmentEntry compartmentEntry) {
		ImageDescriptor imageDescriptor = null;
		if (compartmentEntry instanceof IEclipseImageDescriptor) {
			imageDescriptor = ((IEclipseImageDescriptor) compartmentEntry).getImageDescriptor();
		} else {
			imageDescriptor = ImagePool.getImageDescriptorForId(compartmentEntry.getIconId());
		}
		return imageDescriptor;
	}

}