/***********************************************************************
 * Copyright (c) 2007 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 *
 * $Id: EDataTypeEditPart.java,v 1.12 2009/02/02 08:39:05 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecoretools.diagram.edit.figures.AlphaDropShadowBorder;
import org.eclipse.emf.ecoretools.diagram.edit.figures.FigureFromLabelUtils;
import org.eclipse.emf.ecoretools.diagram.edit.figures.GradientRectangleFigure;
import org.eclipse.emf.ecoretools.diagram.edit.policies.AlphaResizableShapeEditPolicy;
import org.eclipse.emf.ecoretools.diagram.edit.policies.EDataTypeItemSemanticEditPolicy;
import org.eclipse.emf.ecoretools.diagram.edit.policies.EcoreTextSelectionEditPolicy;
import org.eclipse.emf.ecoretools.diagram.part.EcoreVisualIDRegistry;
import org.eclipse.emf.ecoretools.diagram.preferences.IEcoreToolsPreferenceConstants;
import org.eclipse.emf.ecoretools.diagram.providers.EcoreElementTypes;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
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
public class EDataTypeEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 1004;

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
	public EDataTypeEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {

		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new EDataTypeItemSemanticEditPolicy());
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
		DataTypeFigure figure = new DataTypeFigure();
		figure.setShouldUseGradient(Boolean.TRUE.equals(getViewer().getProperty(IEcoreToolsPreferenceConstants.PREF_FILL_FIGURE_USING_GRADIENT)));
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public DataTypeFigure getPrimaryShape() {
		return (DataTypeFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof EDataTypeInstanceClassEditPart) {
			((EDataTypeInstanceClassEditPart) childEditPart).setLabel(getPrimaryShape().getFigureDataTypeJavaLabel());
			return true;
		}
		if (childEditPart instanceof EDataTypeNameEditPart) {
			((EDataTypeNameEditPart) childEditPart).setLabel(getPrimaryShape().getFigureDataTypeNameLabel());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof EDataTypeInstanceClassEditPart) {
			return true;
		}
		if (childEditPart instanceof EDataTypeNameEditPart) {
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
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode().DPtoLP(40), getMapMode().DPtoLP(40));
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
		return getChildBySemanticHint(EcoreVisualIDRegistry.getType(EDataTypeNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<org.eclipse.gmf.runtime.emf.type.core.IElementType> getMARelTypesOnTarget() {
		List<org.eclipse.gmf.runtime.emf.type.core.IElementType> types = new ArrayList<org.eclipse.gmf.runtime.emf.type.core.IElementType>();
		types.add(EcoreElementTypes.EAnnotationReferences_3001);
		types.add(EcoreElementTypes.EReference_3002);
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
		if (relationshipType == EcoreElementTypes.EReference_3002) {
			types.add(EcoreElementTypes.EClass_1001);
		}
		if (relationshipType == EcoreElementTypes.EReference_3002) {
			types.add(EcoreElementTypes.EClass_2003);
		}
		return types;
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
	public class DataTypeFigure extends GradientRectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureDataTypeNameLabel;

		/**
		 * @generated
		 */
		private WrappingLabel fFigureDataTypeJavaLabel;

		private WrappingLabel dataTypeFixedNameLabel0;

		/**
		 * @generated
		 */
		public DataTypeFigure() {

			ToolbarLayout layoutThis = new ToolbarLayout();
			layoutThis.setStretchMinorAxis(true);
			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);

			layoutThis.setSpacing(1);
			layoutThis.setVertical(true);

			this.setLayoutManager(layoutThis);

			this.setMinimumSize(new Dimension(getMapMode().DPtoLP(100), getMapMode().DPtoLP(30)));
			createContents();
		}

		/**
		 * @generated NOT
		 */
		private void createContents() {

			dataTypeFixedNameLabel0 = new WrappingLabel();
			dataTypeFixedNameLabel0.setAlignment(PositionConstants.TOP);
			dataTypeFixedNameLabel0.setText("<<datatype>>"); //$NON-NLS-1$

			this.add(dataTypeFixedNameLabel0);

			fFigureDataTypeNameLabel = new WrappingLabel();
			fFigureDataTypeNameLabel.setAlignment(PositionConstants.TOP);
			fFigureDataTypeNameLabel.setText("<..>"); //$NON-NLS-1$

			this.add(fFigureDataTypeNameLabel);

			fFigureDataTypeJavaLabel = new WrappingLabel();
			fFigureDataTypeJavaLabel.setAlignment(PositionConstants.TOP);
			fFigureDataTypeJavaLabel.setText(""); //$NON-NLS-1$

			this.add(fFigureDataTypeJavaLabel);

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
		public WrappingLabel getFigureDataTypeNameLabel() {
			return fFigureDataTypeNameLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDataTypeJavaLabel() {
			return fFigureDataTypeJavaLabel;
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
			int labelHeight = getFigureDataTypeJavaLabel().getBounds().y - dataTypeFixedNameLabel0.getBounds().y;
			Point point1 = new Point(x, y + labelHeight);
			Point point2 = new Point(x + w, y + labelHeight);
			graphics.drawLine(point1, point2);
			graphics.drawRectangle(x, y, w, h);
		}

		public void addFromLabel() {
			this.add(getFigureFromLabel(), 2);
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
