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
 * $Id: EDataType2ViewFactory.java,v 1.4 2009/02/02 08:39:07 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.view.factories;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EDataType2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EDataTypeInstanceClass2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EDataTypeName2EditPart;
import org.eclipse.emf.ecoretools.diagram.part.EcoreVisualIDRegistry;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class EDataType2ViewFactory extends AbstractShapeViewFactory {

	static final Color THIS_FONT = ColorConstants.darkGray;

	static final Color THIS_FORE = ColorConstants.gray;

	static final Color THIS_BACK = new Color(null, 248, 249, 209);

	static final int fontHeight = 10;

	@Override
	protected void initializeFromPreferences(View view) {
		super.initializeFromPreferences(view);
		ShapeStyle style = (ShapeStyle) view.getStyle(NotationPackage.Literals.SHAPE_STYLE);
		style.setFillColor(FigureUtilities.colorToInteger(THIS_BACK));
		style.setLineColor(FigureUtilities.colorToInteger(THIS_FORE));
		style.setFontColor(FigureUtilities.colorToInteger(THIS_FONT));
		style.setFontHeight(fontHeight);
	}

	/**
	 * @generated
	 */
	protected List createStyles(View view) {
		List styles = new ArrayList();
		styles.add(NotationFactory.eINSTANCE.createShapeStyle());
		return styles;
	}

	/**
	 * @generated
	 */
	protected void decorateView(View containerView, View view, IAdaptable semanticAdapter, String semanticHint, int index, boolean persisted) {
		if (semanticHint == null) {
			semanticHint = EcoreVisualIDRegistry.getType(EDataType2EditPart.VISUAL_ID);
			view.setType(semanticHint);
		}
		super.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);
		IAdaptable eObjectAdapter = null;
		EObject eObject = (EObject) semanticAdapter.getAdapter(EObject.class);
		if (eObject != null) {
			eObjectAdapter = new EObjectAdapter(eObject);
		}
		getViewService().createNode(eObjectAdapter, view, EcoreVisualIDRegistry.getType(EDataTypeName2EditPart.VISUAL_ID), ViewUtil.APPEND, true, getPreferencesHint());
		getViewService().createNode(eObjectAdapter, view, EcoreVisualIDRegistry.getType(EDataTypeInstanceClass2EditPart.VISUAL_ID), ViewUtil.APPEND, true, getPreferencesHint());
	}
}
