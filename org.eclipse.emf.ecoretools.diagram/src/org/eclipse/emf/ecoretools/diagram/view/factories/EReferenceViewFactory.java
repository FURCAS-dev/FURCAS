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
 * $Id: EReferenceViewFactory.java,v 1.5 2009/02/02 08:39:07 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.view.factories;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EReferenceEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EReferenceLowerBoundUpperBoundEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EReferenceNameEditPart;
import org.eclipse.emf.ecoretools.diagram.part.EcoreVisualIDRegistry;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.ConnectionViewFactory;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.ConnectorStyle;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class EReferenceViewFactory extends ConnectionViewFactory {

	static final Color THIS_FORE = ColorConstants.darkGray;

	static final int fontHeight = 10;

	@Override
	protected void initializeFromPreferences(View view) {
		super.initializeFromPreferences(view);
		FontStyle fontStyle = (FontStyle) view.getStyle(NotationPackage.Literals.FONT_STYLE);
		fontStyle.setFontHeight(fontHeight);
		fontStyle.setFontColor(FigureUtilities.colorToInteger(THIS_FORE));
		ConnectorStyle connectorStyle = (ConnectorStyle) view.getStyle(NotationPackage.Literals.CONNECTOR_STYLE);
		connectorStyle.setLineColor(FigureUtilities.colorToInteger(THIS_FORE));
	}

	/**
	 * @generated
	 */
	protected List createStyles(View view) {
		List styles = new ArrayList();
		styles.add(NotationFactory.eINSTANCE.createConnectorStyle());
		styles.add(NotationFactory.eINSTANCE.createFontStyle());
		return styles;
	}

	/**
	 * @generated
	 */
	protected void decorateView(View containerView, View view, IAdaptable semanticAdapter, String semanticHint, int index, boolean persisted) {
		if (semanticHint == null) {
			semanticHint = EcoreVisualIDRegistry.getType(EReferenceEditPart.VISUAL_ID);
			view.setType(semanticHint);
		}
		super.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);
		IAdaptable eObjectAdapter = null;
		EObject eObject = (EObject) semanticAdapter.getAdapter(EObject.class);
		if (eObject != null) {
			eObjectAdapter = new EObjectAdapter(eObject);
		}
		getViewService().createNode(eObjectAdapter, view, EcoreVisualIDRegistry.getType(EReferenceNameEditPart.VISUAL_ID), ViewUtil.APPEND, true, getPreferencesHint());
		getViewService().createNode(eObjectAdapter, view, EcoreVisualIDRegistry.getType(EReferenceLowerBoundUpperBoundEditPart.VISUAL_ID), ViewUtil.APPEND, true, getPreferencesHint());
	}
}
