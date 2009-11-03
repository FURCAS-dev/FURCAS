package com.sap.mi.gfw.eclipse.internal.editor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.internal.win32.OS;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.actions.ActionFactory;

import com.sap.mi.gfw.GfwTestConfiguration;
import com.sap.mi.gfw.datatypes.ILocation;
import com.sap.mi.gfw.eclipse.Messages;
import com.sap.mi.gfw.eclipse.internal.ImagePool;
import com.sap.mi.gfw.eclipse.internal.action.CustomAction;
import com.sap.mi.gfw.eclipse.internal.action.DeleteAction;
import com.sap.mi.gfw.eclipse.internal.action.IAvailable;
import com.sap.mi.gfw.eclipse.internal.action.RemoveAction;
import com.sap.mi.gfw.eclipse.internal.action.SaveImageAction;
import com.sap.mi.gfw.eclipse.internal.action.UpdateAction;
import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.eclipse.internal.feature.DebugFeature;
import com.sap.mi.gfw.eclipse.internal.parts.DiagramEditPart;
import com.sap.mi.gfw.eclipse.internal.util.gef.GEFUtil;
import com.sap.mi.gfw.features.IFeature;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.ISaveImageFeature;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.features.context.ISaveImageContext;
import com.sap.mi.gfw.features.context.impl.CustomContext;
import com.sap.mi.gfw.features.context.impl.SaveImageContext;
import com.sap.mi.gfw.features.custom.ICustomFeature;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Shape;
import com.sap.mi.gfw.tb.ContextMenuEntry;
import com.sap.mi.gfw.tb.IContextMenuEntry;
import com.sap.mi.gfw.tb.IToolBehaviorProvider;
import com.sap.mi.gfw.util.ILocationInfo;
import com.sap.mi.gfw.util.PeUtil;

/**
 * This ContextMenuProvider provides a standard-context-menu and adds it to the given EditPartViewer. Another feature is, that it can set
 * the menu-location to all Actions, which implement the interface ILocationReceiver.
 * <p>
 * Some of the standard-menu-items are: undo/redo, delete, copy/paste, alignment, zooming.
 */
public class GraphicsContextMenuProvider extends ContextMenuProvider {

	private ActionRegistry _actionRegistry;

	private Control _menuLocationReferenceControl;

	private IConfigurationProvider configurationProvider;

	/**
	 * Creates a new GraphicsContextMenuProvider.
	 * 
	 * @param viewer
	 *            The EditPartViewer, for which the context-menu shall be displayed.
	 * @param registry
	 *            The action-registry, which contains the actions corresponding to the menu-items.
	 * @param menuLocationReferenceControl
	 *            The control which serves as origin to calculate the menu-location. If null, then the menu-location is not calculated (and
	 *            not forwarded).
	 * @param configurationProvider
	 *            the configuration provider
	 */
	public GraphicsContextMenuProvider(EditPartViewer viewer, ActionRegistry registry, Control menuLocationReferenceControl,
			IConfigurationProvider configurationProvider) {
		super(viewer);
		_actionRegistry = registry;
		_menuLocationReferenceControl = menuLocationReferenceControl;
		this.configurationProvider = configurationProvider;
	}

	/**
	 * Adds the Actions to the given IMenuManager, which is displayed as a context-menu.
	 * 
	 * @param manager
	 *            the manager
	 * @see org.eclipse.gef.ContextMenuProvider#buildContextMenu(IMenuManager)
	 */
	@Override
	public void buildContextMenu(IMenuManager manager) {

		// org.eclipse.draw2d.geometry.Point mouseLocation = getEditor().getMouseLocation();
		org.eclipse.draw2d.geometry.Point mouseLocation = getEditor().calculateRealMouseLocation(getEditor().getMouseLocation());
		final GraphicalViewer graphicalViewer = getEditor().getGraphicalViewer();
		EditPart findEditPartAt = GEFUtil.findEditPartAt(graphicalViewer, mouseLocation, true);
		if (findEditPartAt instanceof DiagramEditPart) {
			graphicalViewer.select(findEditPartAt);
		}

		GEFActionConstants.addStandardActionGroups(manager);
		Point menuLocation = getCurrentMouseLocation();

		addDefaultMenuGroupSave(manager, menuLocation);
		addDefaultMenuGroupEdit(manager, menuLocation);
		addDefaultMenuGroupPrint(manager, menuLocation);
		addDefaultMenuGroupRest(manager, menuLocation);
	}

	// ====================== add default menu-groups =========================

	/**
	 * Adds the default menu group undo.
	 * 
	 * @param manager
	 *            the manager
	 * @param menuLocation
	 *            the menu location
	 */
	protected void addDefaultMenuGroupUndo(IMenuManager manager, Point menuLocation) {
		addActionToMenu(manager, menuLocation, ActionFactory.UNDO.getId(), GEFActionConstants.GROUP_UNDO);
		addActionToMenu(manager, menuLocation, ActionFactory.REDO.getId(), GEFActionConstants.GROUP_UNDO);
	}

	/**
	 * Adds the default menu group save.
	 * 
	 * @param manager
	 *            the manager
	 * @param menuLocation
	 *            the menu location
	 */
	protected void addDefaultMenuGroupSave(IMenuManager manager, Point menuLocation) {
		// addActionToMenu(manager, menuLocation, ActionFactory.SAVE.getId(),
		// GEFActionConstants.GROUP_SAVE);
		// addActionToMenu(manager, menuLocation, ActionFactory.SAVE_AS.getId(),
		// GEFActionConstants.GROUP_SAVE);

		IFeatureProvider fp = getConfigurationProvider().getDiagramTypeProvider().getFeatureProvider();
		if (fp != null) {
			ISaveImageFeature sf = fp.getSaveImageFeature();

			if (sf != null) {
				PictogramElement pe[] = getEditor().getSelectedPictogramElements();
				ISaveImageContext context = new SaveImageContext(pe);
				IAction action = new SaveImageAction(sf, context, getEditor());
				manager.appendToGroup(GEFActionConstants.GROUP_SAVE, action);
			}
		}
	}

	/**
	 * Adds the default menu group edit.
	 * 
	 * @param manager
	 *            the manager
	 * @param menuLocation
	 *            the menu location
	 */
	protected void addDefaultMenuGroupEdit(IMenuManager manager, Point menuLocation) {
		addNewObjectSubMenu(manager, GEFActionConstants.GROUP_EDIT, menuLocation);
		addActionToMenuIfAvailable(manager, menuLocation, ActionFactory.COPY.getId(), GEFActionConstants.GROUP_EDIT);
		addActionToMenuIfAvailable(manager, menuLocation, ActionFactory.PASTE.getId(), GEFActionConstants.GROUP_EDIT);
		// addActionToMenuIfAvailable(manager, menuLocation,
		// ActionFactory.DELETE.getId(),
		// GEFActionConstants.GROUP_EDIT);
		// addActionToMenuIfAvailable(manager, menuLocation,
		// GEFActionConstants.DIRECT_EDIT,
		// GEFActionConstants.GROUP_EDIT);
	}

	/**
	 * Adds the default menu group print.
	 * 
	 * @param manager
	 *            the manager
	 * @param menuLocation
	 *            the menu location
	 */
	protected void addDefaultMenuGroupPrint(IMenuManager manager, Point menuLocation) {
		// addActionToMenu(manager, menuLocation, ActionFactory.PRINT.getId(),
		// GEFActionConstants.GROUP_PRINT);
	}

	/**
	 * Adds the default menu group rest.
	 * 
	 * @param manager
	 *            the manager
	 * @param menuLocation
	 *            the menu location
	 */
	protected void addDefaultMenuGroupRest(IMenuManager manager, Point menuLocation) {
		addAlignmentSubMenu(manager, GEFActionConstants.GROUP_REST, menuLocation);

		addActionToMenuIfAvailable(manager, menuLocation, UpdateAction.ACTION_ID, GEFActionConstants.GROUP_REST);
		addActionToMenuIfAvailable(manager, menuLocation, RemoveAction.ACTION_ID, GEFActionConstants.GROUP_REST);
		addActionToMenuIfAvailable(manager, menuLocation, DeleteAction.ACTION_ID, GEFActionConstants.GROUP_REST);

		PictogramElement pes[] = getEditor().getSelectedPictogramElements();
		ICustomContext context = new CustomContext(pes);

		if (pes.length == 1) {
			extendCustomContext(pes[0], (CustomContext) context);
		}

		IToolBehaviorProvider tb = getConfigurationProvider().getDiagramTypeProvider().getCurrentToolBehaviorProvider();

		IContextMenuEntry[] contextMenuEntries = tb.getContextMenu(context);

		if (GfwTestConfiguration.areDebugActionsActive()) {
			IFeatureProvider fp = getConfigurationProvider().getFeatureProvider();
			ContextMenuEntry debugEntry = new ContextMenuEntry(null, context);
			debugEntry.setText("Debug"); //$NON-NLS-1$
			debugEntry.setSubmenu(true);
			debugEntry.add(new ContextMenuEntry(new DebugFeature(fp, DebugFeature.TYPE_DUMP_FIGURE_DATA), context));
			debugEntry.add(new ContextMenuEntry(new DebugFeature(fp, DebugFeature.TYPE_DUMP_PICTOGRAM_DATA), context));
			debugEntry.add(new ContextMenuEntry(new DebugFeature(fp, DebugFeature.TYPE_DUMP_EDIT_PART_DATA), context));
			debugEntry.add(new ContextMenuEntry(new DebugFeature(fp, DebugFeature.TYPE_DUMP_ALL), context));
			debugEntry.add(new ContextMenuEntry(new DebugFeature(fp, DebugFeature.TYPE_REFRESH), context));
			IContextMenuEntry[] contextMenuEntries2 = new IContextMenuEntry[contextMenuEntries.length + 1];
			System.arraycopy(contextMenuEntries, 0, contextMenuEntries2, 0, contextMenuEntries.length);
			contextMenuEntries2[contextMenuEntries2.length - 1] = debugEntry;
			contextMenuEntries = contextMenuEntries2;
		}

		addEntries(manager, contextMenuEntries, menuLocation, context, GEFActionConstants.GROUP_REST, null);
	}

	private void addEntries(IMenuManager manager, IContextMenuEntry[] contextMenuEntries, Point menuLocation, ICustomContext context,
			String groupID, String textParentEntry) {

		for (int i = 0; i < contextMenuEntries.length; i++) {
			IContextMenuEntry cmEntry = contextMenuEntries[i];
			String text = cmEntry.getText();
			if (cmEntry.getChildren().length == 0) {
				IFeature feature = cmEntry.getFeature();
				if (feature instanceof ICustomFeature && feature.isAvailable(context)) {
					IAction action = new CustomAction((ICustomFeature) feature, context, getEditor());
					if (textParentEntry != null) {
						text = textParentEntry + " " + text; //$NON-NLS-1$
					}
					action.setText(text);
					action.setDescription(cmEntry.getDescription());
					ImageDescriptor image = ImagePool.getImageDescriptorForId(cmEntry.getIconId());
					action.setImageDescriptor(image);
					appendContributionItem(manager, groupID, new ActionContributionItem(action));
				}
			} else {

				if (cmEntry.isSubmenu()) {

					MenuManager subMenu = new MenuManager(text);
					addEntries(subMenu, cmEntry.getChildren(), menuLocation, context, null, null);
					if (!subMenu.isEmpty()) {
						appendContributionItem(manager, groupID, subMenu);
					}
				} else {
					appendContributionItem(manager, groupID, new Separator());
					addEntries(manager, cmEntry.getChildren(), menuLocation, context, groupID, text);
					appendContributionItem(manager, groupID, new Separator());
				}
			}
		}
	}

	private void appendContributionItem(IMenuManager manager, String groupID, IContributionItem contributionItem) {
		if (groupID != null) {
			manager.appendToGroup(groupID, contributionItem);
		} else {
			manager.add(contributionItem);
		}
	}

	// ====================== add single menu-entries =========================

	private void extendCustomContext(PictogramElement pe, CustomContext context) {
		Point location = getCurrentMouseLocation();

		if (location == null) {
			return;
		}

		int mX = location.x;
		int mY = location.y;
		context.setX(mX);
		context.setY(mY);

		if ((pe instanceof Shape) && (!(pe instanceof Diagram))) {
			GraphicsAlgorithm ga = pe.getGraphicsAlgorithm();
			if (ga != null) {
				// int x = ga.getX();
				// int y = ga.getY();
				ILocation relLocation = PeUtil.getLocationRelativeToDiagram((Shape) pe);
				int x = relLocation.getX();
				int y = relLocation.getY();
				int width = ga.getWidth();
				int height = ga.getHeight();

				if (mX > x && mX < (x + width) && mY > y && mY < (y + height)) {
					int relativeX = mX - x;
					int relativeY = mY - y;
					ILocationInfo locationInfo = PeUtil.getLocationInfo((Shape) pe, relativeX, relativeY);
					context.setInnerPictogramElement(locationInfo.getShape());
					context.setInnerGraphicsAlgorithm(locationInfo.getGraphicsAlgorithm());
				}
			}
		}
	}

	/**
	 * Adds the alignment sub menu.
	 * 
	 * @param manager
	 *            the manager
	 * @param group
	 *            the group
	 * @param menuLocation
	 *            the menu location
	 */
	protected void addAlignmentSubMenu(IMenuManager manager, String group, Point menuLocation) {
		IAction action;
		MenuManager alignmentSubMenu = new MenuManager(Messages.GraphicsContextMenuProvider_0_xmen);

		action = _actionRegistry.getAction(GEFActionConstants.ALIGN_LEFT);
		if (action != null && action.isEnabled())
			alignmentSubMenu.add(action);

		action = _actionRegistry.getAction(GEFActionConstants.ALIGN_CENTER);
		if (action != null && action.isEnabled())
			alignmentSubMenu.add(action);

		action = _actionRegistry.getAction(GEFActionConstants.ALIGN_RIGHT);
		if (action != null && action.isEnabled())
			alignmentSubMenu.add(action);

		action = _actionRegistry.getAction(GEFActionConstants.ALIGN_TOP);
		if (action != null && action.isEnabled())
			alignmentSubMenu.add(action);

		action = _actionRegistry.getAction(GEFActionConstants.ALIGN_MIDDLE);
		if (action != null && action.isEnabled())
			alignmentSubMenu.add(action);

		action = _actionRegistry.getAction(GEFActionConstants.ALIGN_BOTTOM);
		if (action != null && action.isEnabled())
			alignmentSubMenu.add(action);

		action = _actionRegistry.getAction(GEFActionConstants.MATCH_WIDTH);
		if (action != null && action.isEnabled())
			alignmentSubMenu.add(action);

		action = _actionRegistry.getAction(GEFActionConstants.MATCH_HEIGHT);
		if (action != null && action.isEnabled())
			alignmentSubMenu.add(action);

		if (!alignmentSubMenu.isEmpty())
			manager.appendToGroup(group, alignmentSubMenu);
	}

	/**
	 * Adds the new object sub menu.
	 * 
	 * @param manager
	 *            the manager
	 * @param group
	 *            the group
	 * @param menuLocation
	 *            the menu location
	 */
	protected void addNewObjectSubMenu(IMenuManager manager, String group, Point menuLocation) {
		IAction action;
		MenuManager subMenu = new MenuManager(Messages.GraphicsContextMenuProvider_1_xmen);
		// XXX: find all new-object-actions in the action-registry
		List createActions = new ArrayList();
		for (Iterator iter = createActions.iterator(); iter.hasNext();) {
			action = (IAction) iter.next();
			if (action.isEnabled()) {
				subMenu.add(action);
			}
		}

		if (!subMenu.isEmpty())
			manager.appendToGroup(group, subMenu);
	}

	/**
	 * Adds the action to menu.
	 * 
	 * @param manager
	 *            the manager
	 * @param menuLocation
	 *            the menu location
	 * @param actionId
	 *            the action id
	 * @param menuGroup
	 *            the menu group
	 */
	protected void addActionToMenu(IMenuManager manager, Point menuLocation, String actionId, String menuGroup) {
		IAction action;
		action = _actionRegistry.getAction(actionId);
		if (action != null && action.isEnabled())
			manager.appendToGroup(menuGroup, action);
	}

	/**
	 * Adds the action to menu if available.
	 * 
	 * @param manager
	 *            the manager
	 * @param menuLocation
	 *            the menu location
	 * @param actionId
	 *            the action id
	 * @param menuGroup
	 *            the menu group
	 */
	protected void addActionToMenuIfAvailable(IMenuManager manager, Point menuLocation, String actionId, String menuGroup) {
		IAction action = _actionRegistry.getAction(actionId);
		if (action instanceof IAvailable) {
			if (((IAvailable) action).isAvailable())
				manager.appendToGroup(menuGroup, action);
		}
	}

	// ======================== private helper methods =========================

	/**
	 * Returns the current mouse menuLocation with regard to the reference-control. Returns null, if the mouse menuLocation is outside the
	 * area of the reference-control.
	 * 
	 * @return The current mouse menuLocation with regard to the reference-control.
	 */
	protected Point getCurrentMouseLocation() {
		if (_menuLocationReferenceControl != null) {
			int pos = OS.GetMessagePos();
			int x = (short) (pos & 0xFFFF);
			int y = (short) (pos >> 16);
			Point point = new Point(x, y);
			Point location = Display.getCurrent().map(null, _menuLocationReferenceControl, point);
			Rectangle rectangle = new Rectangle(0, 0, _menuLocationReferenceControl.getSize().x, _menuLocationReferenceControl.getSize().y);
			if (rectangle.contains(location))
				return location;
		}
		return null;
	}

	/**
	 * Gets the configuration provider.
	 * 
	 * @return Returns the configurationProvider.
	 */
	protected IConfigurationProvider getConfigurationProvider() {
		return configurationProvider;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.ContributionManager#allowItem(org.eclipse.jface.action.IContributionItem)
	 */
	@Override
	protected boolean allowItem(IContributionItem itemToAdd) {
		boolean ret = super.allowItem(itemToAdd);
		if (ret) {
			String itemId = itemToAdd.getId();
			if (itemId != null) {
				if (itemId.startsWith("org.eclipse.debug.ui.contextualLaunch.")) { //$NON-NLS-1$
					return false;
				}
			}
		}
		return ret;
	}

	private DiagramEditor getEditor() {
		return getConfigurationProvider().getDiagramEditor();
	}
}