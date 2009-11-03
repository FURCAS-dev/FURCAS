package com.sap.mi.gfw.eclipse.internal.contextbuttons;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.editparts.ZoomListener;
import org.eclipse.gef.editparts.ZoomManager;

import com.sap.mi.gfw.GfwTestConfiguration;
import com.sap.mi.gfw.eclipse.internal.editor.DiagramEditor;
import com.sap.mi.gfw.eclipse.internal.parts.IPictogramElementEditPart;
import com.sap.mi.gfw.features.context.impl.base.PictogramElementContext;
import com.sap.mi.gfw.internal.contextbuttons.IContextButtonPadDeclaration;
import com.sap.mi.gfw.internal.contextbuttons.SpecialContextButtonPadDeclaration;
import com.sap.mi.gfw.internal.contextbuttons.StandardContextButtonPadDeclaration;
import com.sap.mi.gfw.internal.util.MoinHelper;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.tb.IContextButtonPadData;
import com.sap.mi.gfw.tb.IToolBehaviorProvider;

/**
 * The context button manager shows and hides the context button pad. Mostly showing/hiding the context button pad is triggered by mouse
 * events.
 */
public class ContextButtonManagerForPad implements IContextButtonManager {

	/**
	 * The context button pad is not shown, when the zoom level is below this minimum value.
	 */
	protected static final double MINIMUM_ZOOM_LEVEL = 0.75d;

	/**
	 * The editor on which this context button manager works, see {@link #getEditor()}. It is set in the constructor.
	 */
	private DiagramEditor editor;

	/**
	 * A backward-map from the edit-part figures to their edit-parts as described in {@link #getFigure2EditPart()}.
	 */
	private Map<IFigure, EditPart> figure2EditPart = new HashMap<IFigure, EditPart>();

	/**
	 * The currently active figure as described in {@link #getActiveFigure()}.
	 */
	private IFigure activeFigure;

	/**
	 * The currently active figure as described in {@link #getActiveContextButtonPad()}.
	 */
	private ContextButtonPad activeContextButtonPad;

	// ============================= listener =================================

	/**
	 * The zoom-listener is registered on the editor and calls {@link #handleZoomChanged()} on zoom level changes.
	 */
	private ZoomListener zoomListener = new ZoomListener() {
		public void zoomChanged(double newZoom) {
			handleZoomChanged();
		}
	};

	/**
	 * The mouse motion listener is registered on the relevant figures. It calls {@link #showContextButtonsInstantly()} when the mouse
	 * enters the figure.
	 */
	private MouseMotionListener mouseMotionListener = new MouseMotionListener.Stub() {
		@Override
		public void mouseEntered(MouseEvent me) {
			Object source = me.getSource();
			showContextButtonsInstantly((IFigure) source, me.getLocation());
		}

		@Override
		public void mouseMoved(MouseEvent me) {
			Object source = me.getSource();
			showContextButtonsInstantly((IFigure) source, me.getLocation());
		}
	};

	// ============================ constructor ===============================

	/**
	 * Creates a new ContextButtonManagerForPad.
	 * 
	 * @param editor
	 *            The editor on which this context button manager works, see {@link #getEditor()}.
	 */
	public ContextButtonManagerForPad(DiagramEditor editor) {
		this.editor = editor;

		ZoomManager zoomMgr = (ZoomManager) getEditor().getGraphicalViewer().getProperty(ZoomManager.class.toString());
		if (zoomMgr != null) {
			zoomMgr.addZoomListener(zoomListener);
		}
	}

	// ====================== getter/setter for fields ========================

	/**
	 * Returns the editor this context button manager works on. It is set in the constructor and can not be changed.
	 * 
	 * @return The editor this context button manager works on.
	 */
	public DiagramEditor getEditor() {
		return editor;
	}

	/**
	 * Returns a backward-map from the edit-part figures to their edit-parts. So it delivers the opposite of GraphicalEditPart.getFigure().
	 * This map is maintained in {@link #register(GraphicalEditPart)} and {@link #deRegister(GraphicalEditPart)}.
	 * 
	 * @return A backward-map from the edit-part figures to their edit-parts.
	 */
	private Map<IFigure, EditPart> getFigure2EditPart() {
		return figure2EditPart;
	}

	/**
	 * Sets the active figure and context button pad. A figure is called active, when a context button pad is currently active (shown) for
	 * this figure. There can only be one active figure and context button pad at a time. Figure and context button pad are either both null
	 * or both not null.
	 * 
	 * @param activeFigure
	 *            The figure to set active.
	 * @param activeContextButtonPad
	 *            The context button pad to set active.
	 */
	private void setActive(IFigure activeFigure, ContextButtonPad activeContextButtonPad) {
		this.activeFigure = activeFigure;
		this.activeContextButtonPad = activeContextButtonPad;
	}

	/**
	 * Returns the active figure as described in {@link #setActive(IFigure, ContextButtonPad)}.
	 * 
	 * @return The active figure as described in {@link #setActive(IFigure, ContextButtonPad)}.
	 */
	private IFigure getActiveFigure() {
		return activeFigure;
	}

	/**
	 * Returns the active context button pad as described in {@link #setActive(IFigure, ContextButtonPad)}.
	 * 
	 * @return The active context button pad as described in {@link #setActive(IFigure, ContextButtonPad)}.
	 */
	private ContextButtonPad getActiveContextButtonPad() {
		return activeContextButtonPad;
	}

	// =================== interface IContextButtonManager ====================

	/**
	 * Registers a given edit-part. This means, that a context button pad will be shown for this edit-part when the mouse enters its figure.
	 * Typically this method is called, when an edit-part is activated.
	 */
	public void register(GraphicalEditPart graphicalEditPart) {
		getFigure2EditPart().put(graphicalEditPart.getFigure(), graphicalEditPart);

		graphicalEditPart.getFigure().addMouseMotionListener(mouseMotionListener);
	}

	/**
	 * Deregisters a given edit-part, which is opposite to {@link #register(GraphicalEditPart)}. If a context-button pad is currently shown
	 * for this edit-part / figure, it is hidden first. Typically this method is called, when an edit-part is deactivated.
	 */
	public void deRegister(GraphicalEditPart graphicalEditPart) {
		if (graphicalEditPart.getFigure().equals(getActiveFigure())) {
			hideContextButtonsInstantly();
		}

		getFigure2EditPart().remove(graphicalEditPart.getFigure());

		graphicalEditPart.getFigure().removeMouseMotionListener(mouseMotionListener);
	}

	/**
	 * Hides the context button pad (if there is currently a context button pad active).
	 */
	public void hideContextButtonsInstantly() {
		if (getActiveContextButtonPad() != null) {
			synchronized (this) {
				ScalableFreeformRootEditPart rootEditPart = (ScalableFreeformRootEditPart) getEditor().getGraphicalViewer()
						.getRootEditPart();
				IFigure feedbackLayer = rootEditPart.getLayer(LayerConstants.HANDLE_LAYER);
				feedbackLayer.remove(getActiveContextButtonPad());
				setActive(null, null);
			}
		}
	}

	/**
	 * Returns true, if for the given figure a replacement of the context button pad is required. For example it returns false, if there is
	 * already a context button pad shown for this figure or if the mouse is still on the context button pad, and it returns true, if there
	 * is currently no context button pad.
	 * 
	 * @param figure
	 *            The figure which to check.
	 * @return true, if for the given figure a replacement of the context button pad is required.
	 */
	private boolean replaceContextButtonPad(IFigure figure) {
		// requires new context buttons, if there is no active figure
		if (getActiveFigure() == null) {
			return true;
		}

		// requires no changed context buttons, if the given figure equals
		// the active figure
		if (figure.equals(getActiveFigure()))
			return false;

		// requires changed context buttons, if the given figure is a child of
		// the active figure (otherwise children would not have context buttons
		// when the mouse moves from parent to child -- see next check)
		IFigure parent = figure.getParent();
		while (parent != null) {
			if (parent.equals(getActiveFigure()))
				return true;
			parent = parent.getParent();
		}

		// requires no (new) context buttons, if the the mouse is still in the
		// sensitive area of the active context button pad
		if (getActiveContextButtonPad() != null) {
			if (getActiveContextButtonPad().isMouseInOverlappingArea()) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Shows the context button pad for the given figure, but only if {@link #replaceContextButtonPad(IFigure)} return true and the
	 * zoom-level is at least {@link #MINIMUM_ZOOM_LEVEL}.
	 * 
	 * @param figure
	 *            The figure for which to show the context button pad.
	 * @param mouse
	 *            The current location of the mouse.
	 */
	private void showContextButtonsInstantly(IFigure figure, Point mouse) {
		if (!replaceContextButtonPad(figure))
			return;

		synchronized (this) {
			hideContextButtonsInstantly();

			// determine zoom level
			ScalableFreeformRootEditPart rootEditPart = (ScalableFreeformRootEditPart) getEditor().getGraphicalViewer().getRootEditPart();
			double zoom = rootEditPart.getZoomManager().getZoom();
			if (zoom < MINIMUM_ZOOM_LEVEL) {
				return;
			}

			// determine pictogram element
			IPictogramElementEditPart editPart = (IPictogramElementEditPart) getFigure2EditPart().get(figure);
			PictogramElement pe = editPart.getPictogramElement();
			PictogramElementContext context = new PictogramElementContext(pe);
			if (!MoinHelper.isObjectAlive(pe)) {
				return;
			}

			// retrieve context button pad data
			IToolBehaviorProvider toolBehaviorProvider = getEditor().getConfigurationProvider().getDiagramTypeProvider()
					.getCurrentToolBehaviorProvider();
			IContextButtonPadData contextButtonPadData = toolBehaviorProvider.getContextButtonPadData(context);
			if (contextButtonPadData == null) {
				return; // no context buttons to show
			}
			if (contextButtonPadData.getDomainSpecificContextButtons().size() == 0
					&& contextButtonPadData.getGenericContextButtons().size() == 0
					&& contextButtonPadData.getCollapseContextButton() == null) {
				return; // no context buttons to show
			}

			if (!contextButtonPadData.getPadLocation().contains(mouse.x, mouse.y)) {
				return; // mouse outside area of context button pad
			}

			// determine context button pad declaration
			int declarationType = GfwTestConfiguration.getContextButtonPadDeclaration();
			IContextButtonPadDeclaration declaration;
			if (declarationType == 1) {
				declaration = new SpecialContextButtonPadDeclaration(contextButtonPadData);
			} else {
				declaration = new StandardContextButtonPadDeclaration(contextButtonPadData);
			}

			// create context button pad and add to handle layer
			EditPart activeEditPart = getFigure2EditPart().get(figure);
			ContextButtonPad contextButtonPad = new ContextButtonPad(declaration, zoom, getEditor(), activeEditPart);
			setActive(figure, contextButtonPad);

			IFigure feedbackLayer = rootEditPart.getLayer(LayerConstants.HANDLE_LAYER);
			feedbackLayer.add(contextButtonPad);
		}
	}

	/**
	 * Is called when the zoom-level changes and hides the context buttons.
	 */
	private void handleZoomChanged() {
		hideContextButtonsInstantly();

		// It would be possible to show a new context button pad, depending
		// on the new mouse location. But to avoid problems we skip this.
		// The scenario, that the zoom changes when context buttons are
		// visible is not so typical anyway.
	}
}
