/***********************************************************************
 * Copyright (c) 2007, 2009 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 *
 * $Id: EAnnotationEditPart.java,v 1.13 2009/04/20 15:08:17 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecoretools.diagram.edit.figures.AlphaDropShadowBorder;
import org.eclipse.emf.ecoretools.diagram.edit.figures.FigureFromLabelUtils;
import org.eclipse.emf.ecoretools.diagram.edit.figures.GradientRectangleFigure;
import org.eclipse.emf.ecoretools.diagram.edit.figures.ToolbarLayoutExt;
import org.eclipse.emf.ecoretools.diagram.edit.policies.AlphaResizableShapeEditPolicy;
import org.eclipse.emf.ecoretools.diagram.edit.policies.EAnnotationItemSemanticEditPolicy;
import org.eclipse.emf.ecoretools.diagram.edit.policies.EcoreTextSelectionEditPolicy;
import org.eclipse.emf.ecoretools.diagram.part.EcoreVisualIDRegistry;
import org.eclipse.emf.ecoretools.diagram.preferences.IEcoreToolsPreferenceConstants;
import org.eclipse.emf.ecoretools.diagram.providers.EcoreElementTypes;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.DiagramColorConstants;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class EAnnotationEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 1003;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	public EAnnotationEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	@Override
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy() {

			@Override
			public Command getCommand(Request request) {
				if (understandsRequest(request)) {
					if (request instanceof CreateViewAndElementRequest) {
						CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request).getViewAndElementDescriptor().getCreateElementRequestAdapter();
						IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
						if (type == EcoreElementTypes.EStringToStringMapEntry_2007) {
							EditPart compartmentEditPart = getChildBySemanticHint(EcoreVisualIDRegistry.getType(EAnnotationDetailsEditPart.VISUAL_ID));
							return compartmentEditPart == null ? null : compartmentEditPart.getCommand(request);
						}
					}
					return super.getCommand(request);
				}
				return null;
			}
		});

		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new EAnnotationItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that
		// would let children add reasonable editpolicies
		removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {

		ConstrainedToolbarLayoutEditPolicy lep = new ConstrainedToolbarLayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				if (child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE) == null) {
					if (child instanceof ITextAwareEditPart) {
						return new EcoreTextSelectionEditPolicy();
					}
				}
				return super.createChildEditPolicy(child);
			}
		};
		return lep;
	}

	/**
	 * @generated NOT
	 */
	protected IFigure createNodeShape() {
		AnnotationFigure figure = new AnnotationFigure();
		figure.setShouldUseGradient(Boolean.TRUE.equals(getViewer().getProperty(IEcoreToolsPreferenceConstants.PREF_FILL_FIGURE_USING_GRADIENT)));
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public AnnotationFigure getPrimaryShape() {
		return (AnnotationFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof EAnnotationSourceEditPart) {
			((EAnnotationSourceEditPart) childEditPart).setLabel(getPrimaryShape().getFigureAnnotationNameLabel());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof EAnnotationSourceEditPart) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		return getContentPane();
	}

	/**
	 * @generated NOT
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode().DPtoLP(40), getMapMode().DPtoLP(40)) {

			@Override
			public PointList getPolygonPoints() {
				return getPrimaryShape().getPointsList();
			}
		};
		AlphaDropShadowBorder shadowBorder = new AlphaDropShadowBorder();
		shadowBorder.setShouldDrawDropShadow(Boolean.TRUE.equals(getViewer().getProperty(IEcoreToolsPreferenceConstants.PREF_USE_SHADOW_ON_BORDER)));
		result.setBorder(shadowBorder);
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so
	 * you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane. Respects
	 * layout one may have set for generated figure.
	 * 
	 * @param nodeShape
	 *            instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(getMapMode().DPtoLP(5));
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(getMapMode().DPtoLP(width));
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(EcoreVisualIDRegistry.getType(EAnnotationSourceEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<org.eclipse.gmf.runtime.emf.type.core.IElementType> getMARelTypesOnSource() {
		List<org.eclipse.gmf.runtime.emf.type.core.IElementType> types = new ArrayList<org.eclipse.gmf.runtime.emf.type.core.IElementType>();
		types.add(EcoreElementTypes.EAnnotationReferences_3001);
		return types;
	}

	/**
	 * @generated
	 */
	public List<org.eclipse.gmf.runtime.emf.type.core.IElementType> getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		List<org.eclipse.gmf.runtime.emf.type.core.IElementType> types = new ArrayList<org.eclipse.gmf.runtime.emf.type.core.IElementType>();
		if (targetEditPart instanceof EClassEditPart) {
			types.add(EcoreElementTypes.EAnnotationReferences_3001);
		}
		if (targetEditPart instanceof EPackage2EditPart) {
			types.add(EcoreElementTypes.EAnnotationReferences_3001);
		}
		if (targetEditPart instanceof org.eclipse.emf.ecoretools.diagram.edit.parts.EAnnotationEditPart) {
			types.add(EcoreElementTypes.EAnnotationReferences_3001);
		}
		if (targetEditPart instanceof EDataTypeEditPart) {
			types.add(EcoreElementTypes.EAnnotationReferences_3001);
		}
		if (targetEditPart instanceof EEnumEditPart) {
			types.add(EcoreElementTypes.EAnnotationReferences_3001);
		}
		if (targetEditPart instanceof EClass2EditPart) {
			types.add(EcoreElementTypes.EAnnotationReferences_3001);
		}
		if (targetEditPart instanceof EDataType2EditPart) {
			types.add(EcoreElementTypes.EAnnotationReferences_3001);
		}
		if (targetEditPart instanceof EEnum2EditPart) {
			types.add(EcoreElementTypes.EAnnotationReferences_3001);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<org.eclipse.gmf.runtime.emf.type.core.IElementType> getMATypesForTarget(IElementType relationshipType) {
		List<org.eclipse.gmf.runtime.emf.type.core.IElementType> types = new ArrayList<org.eclipse.gmf.runtime.emf.type.core.IElementType>();
		if (relationshipType == EcoreElementTypes.EAnnotationReferences_3001) {
			types.add(EcoreElementTypes.EClass_1001);
		}
		if (relationshipType == EcoreElementTypes.EAnnotationReferences_3001) {
			types.add(EcoreElementTypes.EPackage_1002);
		}
		if (relationshipType == EcoreElementTypes.EAnnotationReferences_3001) {
			types.add(EcoreElementTypes.EAnnotation_1003);
		}
		if (relationshipType == EcoreElementTypes.EAnnotationReferences_3001) {
			types.add(EcoreElementTypes.EDataType_1004);
		}
		if (relationshipType == EcoreElementTypes.EAnnotationReferences_3001) {
			types.add(EcoreElementTypes.EEnum_1005);
		}
		if (relationshipType == EcoreElementTypes.EAnnotationReferences_3001) {
			types.add(EcoreElementTypes.EClass_2003);
		}
		if (relationshipType == EcoreElementTypes.EAnnotationReferences_3001) {
			types.add(EcoreElementTypes.EDataType_2004);
		}
		if (relationshipType == EcoreElementTypes.EAnnotationReferences_3001) {
			types.add(EcoreElementTypes.EEnum_2005);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<org.eclipse.gmf.runtime.emf.type.core.IElementType> getMARelTypesOnTarget() {
		List<org.eclipse.gmf.runtime.emf.type.core.IElementType> types = new ArrayList<org.eclipse.gmf.runtime.emf.type.core.IElementType>();
		types.add(EcoreElementTypes.EAnnotationReferences_3001);
		return types;
	}

	/**
	 * @generated
	 */
	public List<org.eclipse.gmf.runtime.emf.type.core.IElementType> getMATypesForSource(IElementType relationshipType) {
		List<org.eclipse.gmf.runtime.emf.type.core.IElementType> types = new ArrayList<org.eclipse.gmf.runtime.emf.type.core.IElementType>();
		if (relationshipType == EcoreElementTypes.EAnnotationReferences_3001) {
			types.add(EcoreElementTypes.EAnnotation_1003);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public EditPart getTargetEditPart(Request request) {
		if (request instanceof CreateViewAndElementRequest) {
			CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request).getViewAndElementDescriptor().getCreateElementRequestAdapter();
			IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
			if (type == EcoreElementTypes.EStringToStringMapEntry_2007) {
				return getChildBySemanticHint(EcoreVisualIDRegistry.getType(EAnnotationDetailsEditPart.VISUAL_ID));
			}
		}
		return super.getTargetEditPart(request);
	}

	/**
	 * @generated
	 */
	protected void handleNotificationEvent(Notification event) {
		if (event.getNotifier() == getModel() && EcorePackage.eINSTANCE.getEModelElement_EAnnotations().equals(event.getFeature())) {
			handleMajorSemanticChange();
		} else {
			super.handleNotificationEvent(event);
		}
	}

	@Override
	protected void refreshVisuals() {
		EObject semanticElement = resolveSemanticElement();
		if (FigureFromLabelUtils.needFromLabel(semanticElement, getNotationView())) {
			getPrimaryShape().updateFromLabel(FigureFromLabelUtils.getQualifiedName(semanticElement));
			getPrimaryShape().addFromLabel();
		} else {
			getPrimaryShape().removeFromLabel();
		}
		super.refreshVisuals();
	}

	@Override
	public EditPolicy getPrimaryDragEditPolicy() {
		return new AlphaResizableShapeEditPolicy();
	}

	/**
	 * @generated NOT
	 */
	public class AnnotationFigure extends GradientRectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureAnnotationNameLabel;

		protected static final int BENT_CORNER_WIDTH = 12;

		protected static final int BENT_CORNER_HEIGHT = 12;

		public PointList getPointsList() {
			int lineInset = (int) Math.ceil(Math.max(1.0, getLineWidthFloat() / 2.0));
			Rectangle r = Rectangle.SINGLETON.setBounds(getBounds());
			r.shrink(lineInset, lineInset);
			int x = r.x;
			int y = r.y;
			int h = r.height;
			int w = r.width;

			Point point1 = new Point(x, y);
			Point point2 = new Point(x + w - BENT_CORNER_WIDTH, y);
			Point point3 = new Point(x + w, y + BENT_CORNER_HEIGHT);
			Point point4 = new Point(x + w, y + h);
			Point point5 = new Point(x, y + h);

			PointList desiredBounds = new PointList();
			desiredBounds.addPoint(point1);
			desiredBounds.addPoint(point2);
			desiredBounds.addPoint(point3);
			desiredBounds.addPoint(point4);
			desiredBounds.addPoint(point5);
			return desiredBounds;
		}

		@Override
		protected void fillShape(Graphics graphics) {
			Rectangle r = getBounds();
			int x = r.x + lineWidth / 2;
			int y = r.y + lineWidth / 2;
			int h = r.height - Math.max(1, lineWidth);
			int w = r.width - Math.max(1, lineWidth);

			Point point1 = new Point(x, y);
			Point point2 = new Point(x + w - BENT_CORNER_WIDTH, y);
			Point point3 = new Point(x + w, y + BENT_CORNER_HEIGHT);
			Point point4 = new Point(x + w, y + h);
			Point point5 = new Point(x, y + h);

			PointList desiredBounds = new PointList();
			desiredBounds.addPoint(point1);
			desiredBounds.addPoint(point2);
			desiredBounds.addPoint(point3);
			desiredBounds.addPoint(point4);
			desiredBounds.addPoint(point5);

			graphics.fillPolygon(desiredBounds);

			if (shouldUseGradient()) {
				// fill gradient
				// get gradient rectangle
				Rectangle gradientRectangle = r.getCopy();
				gradientRectangle.crop(new Insets(BENT_CORNER_HEIGHT, 0, 0, 0));
				// draw gradient rectangle
				graphics.pushState();
				graphics.setBackgroundColor(DiagramColorConstants.white);
				graphics.setForegroundColor(getBackgroundColor());
				graphics.fillGradient(gradientRectangle, true);
				graphics.popState();
			}
		}

		@Override
		protected void outlineShape(Graphics graphics) {
			int lineInset = (int) Math.ceil(Math.max(1.0, getLineWidthFloat() / 2.0));
			Rectangle r = Rectangle.SINGLETON.setBounds(getBounds());
			r.shrink(lineInset, lineInset);
			int x = r.x;
			int y = r.y;
			int h = r.height;
			int w = r.width;

			Point point1 = new Point(x, y);
			Point point2 = new Point(x + w - BENT_CORNER_WIDTH, y);
			Point point3 = new Point(x + w, y + BENT_CORNER_HEIGHT);
			Point point4 = new Point(x + w, y + h);
			Point point5 = new Point(x, y + h);
			Point point6 = new Point(x + w - BENT_CORNER_WIDTH, y + BENT_CORNER_HEIGHT);

			PointList desiredBounds = new PointList();
			desiredBounds.addPoint(point1);
			desiredBounds.addPoint(point2);
			desiredBounds.addPoint(point3);
			desiredBounds.addPoint(point4);
			desiredBounds.addPoint(point5);

			graphics.drawPolygon(desiredBounds);
			graphics.drawLine(point2, point3);
			graphics.drawLine(point2, point6);
			graphics.drawLine(point6, point3);
		}

		/**
		 * @generated NOT
		 */
		public AnnotationFigure() {

			ToolbarLayoutExt layoutThis = new ToolbarLayoutExt();
			layoutThis.setStretchMinorAxis(true);
			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);
			layoutThis.setExpandLastItemMajorAxis(true);
			layoutThis.setSpacing(0);
			layoutThis.setVertical(true);

			this.setLayoutManager(layoutThis);

			this.setMinimumSize(new Dimension(getMapMode().DPtoLP(100), getMapMode().DPtoLP(30)));
			this.setBorder(new MarginBorder(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0), getMapMode().DPtoLP(0), getMapMode().DPtoLP(14)));
			createContents();
		}

		/**
		 * @generated NOT
		 */
		private void createContents() {

			fFigureAnnotationNameLabel = new WrappingLabel();
			fFigureAnnotationNameLabel.setAlignment(PositionConstants.TOP);
			fFigureAnnotationNameLabel.setText("<..>"); //$NON-NLS-1$

			this.add(fFigureAnnotationNameLabel);

			fFigureFromLabel = new WrappingLabel();
			fFigureFromLabel.setAlignment(PositionConstants.TOP);
			fFigureFromLabel.setText("<..>"); //$NON-NLS-1$
		}

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = false;

		private boolean canRemovedFromLabel;

		private WrappingLabel fFigureFromLabel;

		/**
		 * @generated
		 */
		protected boolean useLocalCoordinates() {
			return myUseLocalCoordinates;
		}

		/**
		 * @generated
		 */
		protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
			myUseLocalCoordinates = useLocalCoordinates;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureAnnotationNameLabel() {
			return fFigureAnnotationNameLabel;
		}

		public void addFromLabel() {
			this.add(getFigureFromLabel(), 1);
			canRemovedFromLabel = true;
		}

		public WrappingLabel getFigureFromLabel() {
			return fFigureFromLabel;
		}

		public void removeFromLabel() {
			if (canRemovedFromLabel) {
				this.remove(getFigureFromLabel());
				canRemovedFromLabel = false;
			}
		}

		public void updateFromLabel(String text) {
			getFigureFromLabel().setText(text);
		}

	}

}
