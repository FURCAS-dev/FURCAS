/***********************************************************************
 * Copyright (c) 2007, 2008 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 *
 * $Id: EReferenceEditPart.java,v 1.9 2009/02/02 08:39:05 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecoretools.diagram.edit.policies.EReferenceItemSemanticEditPolicy;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.Anchor;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class EReferenceEditPart extends ConnectionNodeEditPart {

	private boolean selectable = true;

	@Override
	protected void handleNotificationEvent(Notification notification) {
		if (notification.getNotifier() instanceof EReference) {
			switch (notification.getFeatureID(EReference.class)) {
			case EcorePackage.EREFERENCE__CONTAINMENT:
				refreshSourceDecoration();
				break;
			case EcorePackage.EREFERENCE__EOPPOSITE:
				refreshLinkedReference();
				trackLinkedReference();
				break;
			}
		}
		if (NotationPackage.Literals.ROUTING_STYLE__ROUTING.equals(notification.getFeature()) || notification.getNotifier() instanceof RelativeBendpoints
				|| notification.getNotifier() instanceof Anchor) {
			trackLinkedReference();
		}
		super.handleNotificationEvent(notification);
	}

	protected void trackLinkedReference() {
		EObject semanticElement = resolveSemanticElement();
		if (false == semanticElement instanceof EReference) {
			return;
		}
		if (((EReference) semanticElement).getEOpposite() != null) {
			EReferenceUtils.trackReferences(this);
		}
	}

	/**
	 * Refresh reference decoration and visibility
	 */
	protected void refreshLinkedReference() {
		EObject semanticElement = resolveSemanticElement();
		if (false == semanticElement instanceof EReference) {
			return;
		}
		if (((EReference) semanticElement).getEOpposite() != null) {
			getPrimaryShape().displayTargetDecoration(false);
		} else {
			getPrimaryShape().setHideLine(false);
			getPrimaryShape().displayTargetDecoration(true);
		}
	}

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3002;

	/**
	 * @generated
	 */
	public EReferenceEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new EReferenceItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
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
	protected boolean removeFixedChild(EditPart childEditPart) {
		return false;
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
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so
	 * you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected Connection createConnectionFigure() {
		return new SolidLineWDstArrow();
	}

	/**
	 * @generated
	 */
	public SolidLineWDstArrow getPrimaryShape() {
		return (SolidLineWDstArrow) getFigure();
	}

	/**
	 * @generated
	 */
	public class SolidLineWDstArrow extends PolylineConnectionEx {

		private boolean hideLine;

		/**
		 * @return the hideLine
		 */
		public boolean isHideLine() {
			return hideLine;
		}

		/**
		 * @param hideLine
		 *            the hideLine to set
		 */
		public void setHideLine(boolean hideLine) {
			this.hideLine = hideLine;
			synchronized (EReferenceEditPart.this) {
				if (hideLine) {
					getViewer().deselect(EReferenceEditPart.this);
					EReferenceEditPart.this.setSelected(SELECTED_NONE);
					EReferenceEditPart.this.setSelectable(false);
				} else {
					EReferenceEditPart.this.setSelectable(true);
				}
			}
		}

		/**
		 * @generated NOT
		 */
		public SolidLineWDstArrow() {
			setTargetDecoration(createTargetDecoration());
		}

		public void displayTargetDecoration(boolean display) {
			if (display == true) {
				setTargetDecoration(createTargetDecoration());
			} else {
				if (getTargetDecoration() != null) {
					setTargetDecoration(null);
				}
			}
		}

		public void displaySourceDecoration(boolean display) {
			if (display == true) {
				setSourceDecoration(createSourceDecoration());
			} else {
				if (getSourceDecoration() != null) {
					setSourceDecoration(null);
				}
			}
		}

		/**
		 * @generated
		 */
		private RotatableDecoration createTargetDecoration() {
			PolylineDecoration df = new PolylineDecoration();
			PointList pl = new PointList();
			pl.addPoint(getMapMode().DPtoLP(-1), getMapMode().DPtoLP(1));
			pl.addPoint(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0));
			pl.addPoint(getMapMode().DPtoLP(-1), getMapMode().DPtoLP(-1));
			df.setTemplate(pl);
			df.setScale(getMapMode().DPtoLP(7), getMapMode().DPtoLP(3));
			return df;
		}

		private RotatableDecoration createSourceDecoration() {
			PolygonDecoration df = new PolygonDecoration();
			PointList pl = new PointList();
			pl.addPoint(getMapMode().DPtoLP(-1), getMapMode().DPtoLP(1));
			pl.addPoint(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0));
			pl.addPoint(getMapMode().DPtoLP(-1), getMapMode().DPtoLP(-1));
			pl.addPoint(getMapMode().DPtoLP(-2), getMapMode().DPtoLP(0));
			pl.addPoint(getMapMode().DPtoLP(-1), getMapMode().DPtoLP(1));
			df.setTemplate(pl);
			df.setScale(getMapMode().DPtoLP(7), getMapMode().DPtoLP(3));
			return df;
		}

		/**
		 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx#paintFigure(org.eclipse.draw2d.Graphics)
		 */
		@Override
		public void paintFigure(Graphics graphics) {
			if (hideLine) {
				return;
			}
			super.paintFigure(graphics);
		}

	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart#refreshVisuals()
	 */
	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshSourceDecoration();
		refreshLinkedReference();
	}

	/**
	 * Update the source decoration depending on the containment property of the
	 * EReference
	 */
	protected void refreshSourceDecoration() {
		EObject semanticElement = resolveSemanticElement();
		if (semanticElement instanceof EReference) {
			((SolidLineWDstArrow) getFigure()).displaySourceDecoration(((EReference) semanticElement).isContainment());
		}
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart#isSelectable()
	 */
	@Override
	public boolean isSelectable() {
		return selectable;
	}

	/**
	 * @param selectable
	 *            the selectable to set
	 */
	public void setSelectable(boolean selectable) {
		this.selectable = selectable;
	}

}
