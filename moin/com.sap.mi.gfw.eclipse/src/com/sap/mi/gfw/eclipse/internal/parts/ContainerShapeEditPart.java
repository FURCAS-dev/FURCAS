package com.sap.mi.gfw.eclipse.internal.parts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.gef.CompoundSnapToHelper;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.SnapToGeometry;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.SnapToGuides;
import org.eclipse.gef.SnapToHelper;
import org.eclipse.gef.rulers.RulerProvider;

import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.eclipse.internal.util.ui.sfx.GFSnapFeedbackPolicy;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.platform.ga.IGraphicsAlgorithmRenderer;
import com.sap.mi.gfw.tb.IToolBehaviorProvider;

/**
 * A GraphicalEditPart, which model is of the type ContainerShape.
 */
public class ContainerShapeEditPart extends ShapeEditPart implements IContainerShapeEditPart {

	private IFigure contentPaneFigureCache;

	private Integer contentPaneChilds = null;

	/**
	 * Creates a new ContainerShapeEditPart.
	 * 
	 * @param configurationProvider
	 *            the configuration provider
	 * @param containerShape
	 *            the container shape
	 */
	public ContainerShapeEditPart(IConfigurationProvider configurationProvider, ContainerShape containerShape) {
		super(configurationProvider, containerShape);
	}

	// ======================= overwriteable behaviour ========================

	/**
	 * Creates the EditPolicies of this EditPart. Subclasses often overwrite this method to change the behaviour of the editpart. This
	 * implementation adds the layout-specific EditPolicy to the super-implementation.
	 * 
	 * @see com.sap.ide.eclipse.gf.part.GenericModelObjectEditPart#createEditPolicies()
	 */
	@Override
	protected void createEditPolicies() {
		super.createEditPolicies();
		installEditPolicy(EditPolicy.LAYOUT_ROLE, getConfigurationProvider().getEditPolicyFactory().createShapeXYLayoutEditPolicy());
		// installEditPolicy(EditPolicy.CONTAINER_ROLE,
		// getConfigurationProvider().getEditPolicyFactory().createShapeXYLayoutEditPolicy());
		installEditPolicy("Snap Feedback", new GFSnapFeedbackPolicy()); //$NON-NLS-1$
	}

	/**
	 * Creates the Figure of this editpart. This determines how the editpart will be displayed. The actual data for this figure should be
	 * provided in refreshVisuals().
	 * 
	 * @return the i figure
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	@Override
	protected IFigure createFigure() {
		resetContentPaneFigureCache();
		IFigure figure = super.createFigure();
		if (figure != null) {
			if (figure.getBackgroundColor() == null && !(figure instanceof IGraphicsAlgorithmRenderer))
				figure.setBackgroundColor(ColorConstants.lightGray);
			figure.setOpaque(true);
		}
		return figure;
	}

	// ========================= standard behaviour ===========================

	/**
	 * Returns the children of this EditPart.
	 * 
	 * @return the model children
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#getModelChildren()
	 */
	@Override
	public List<PictogramElement> getModelChildren() {
		List<PictogramElement> result = new ArrayList<PictogramElement>();
		if (getPictogramElementDelegate().isValid()) {
			ContainerShape containerShape = (ContainerShape) getPictogramElement();
			List<PictogramElement> activeChildren = collectActiveChildrenRecursively(containerShape);
			result.addAll(activeChildren);

			result.addAll(super.getModelChildren());
		}
		return result;
	}

	/**
	 * @param containerShape
	 * @return
	 */
	private List<PictogramElement> collectActiveChildrenRecursively(ContainerShape containerShape) {
		Collection coll = containerShape.getChildren();
		List<PictogramElement> activeChildren = new ArrayList<PictogramElement>();
		for (Iterator iter = coll.iterator(); iter.hasNext();) {
			Object obj = iter.next();
			if (obj != null && obj instanceof PictogramElement) {
				PictogramElement pe = (PictogramElement) obj;
				if (pe.isActive()) {
					activeChildren.add(pe);
				} else if (pe instanceof ContainerShape) {
					activeChildren.addAll(collectActiveChildrenRecursively((ContainerShape) pe));
				}
			}
		}
		return activeChildren;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#addChildVisual(org.eclipse.gef.EditPart, int)
	 */
	@Override
	protected void addChildVisual(EditPart childEditPart, int index) {
		resetContentPaneFigureCache();
		int realIndex = index + getContentPaneChildCount();
		super.addChildVisual(childEditPart, realIndex);
	}

	private void resetContentPaneFigureCache() {
		contentPaneFigureCache = null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.eclipse.internal.parts.ShapeEditPart#getAdapter(java.lang.Class)
	 */
	@Override
	public Object getAdapter(Class adapter) {
		if (adapter == SnapToHelper.class) {
			List snapStrategies = new ArrayList();
			Boolean val = (Boolean) getViewer().getProperty(RulerProvider.PROPERTY_RULER_VISIBILITY);
			if (val != null && val.booleanValue())
				snapStrategies.add(new SnapToGuides(this));
			val = (Boolean) getViewer().getProperty(SnapToGeometry.PROPERTY_SNAP_ENABLED);
			if (val != null && val.booleanValue())
				snapStrategies.add(new SnapToGeometry(this));
			val = (Boolean) getViewer().getProperty(SnapToGrid.PROPERTY_GRID_ENABLED);
			if (val != null && val.booleanValue())
				snapStrategies.add(new SnapToGrid(this));

			if (snapStrategies.size() == 0)
				return null;
			if (snapStrategies.size() == 1)
				return snapStrategies.get(0);

			SnapToHelper ss[] = new SnapToHelper[snapStrategies.size()];
			for (int i = 0; i < snapStrategies.size(); i++)
				ss[i] = (SnapToHelper) snapStrategies.get(i);
			return new CompoundSnapToHelper(ss);
		}
		return super.getAdapter(adapter);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getContentPane()
	 */
	@Override
	public IFigure getContentPane() {
		if (getContentPaneFigureCache() != null) {
			return getContentPaneFigureCache();
		}
		IToolBehaviorProvider tbp = getConfigurationProvider().getDiagramTypeProvider().getCurrentToolBehaviorProvider();
		PictogramElement pe = getPictogramElement();
		if (pe instanceof ContainerShape && !(this instanceof DiagramEditPart)) {
			ContainerShape cs = (ContainerShape) pe;
			GraphicsAlgorithm contentGa = tbp.getContentGraphicsAlgorithm(cs);
			if (contentGa != null) {
				setConentPaneFigureCache(getPictogramElementDelegate().getFigureForGraphicsAlgorithm(contentGa));
				if (getContentPaneFigureCache() != null) {
					LayoutManager lm = getContentPaneFigureCache().getLayoutManager();
					if (!(lm instanceof XYLayout)) {
						getContentPaneFigureCache().setLayoutManager(new XYLayout());
					}
					return getContentPaneFigureCache();
				}
			}
		}

		IFigure ret = super.getContentPane();
		return ret;
	}

	private void setConentPaneFigureCache(IFigure figure) {
		contentPaneFigureCache = figure;
	}

	private IFigure getContentPaneFigureCache() {
		return contentPaneFigureCache;
	}

	private Integer getContentPaneChildCount() {
		if (contentPaneChilds == null) {
			contentPaneChilds = getContentPane().getChildren().size();
		}
		return contentPaneChilds;
	}
}