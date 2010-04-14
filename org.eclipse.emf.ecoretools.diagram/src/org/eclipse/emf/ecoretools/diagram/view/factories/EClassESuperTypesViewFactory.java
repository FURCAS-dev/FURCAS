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
 * $Id: EClassESuperTypesViewFactory.java,v 1.8 2009/03/19 15:04:28 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.view.factories;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EClassESuperTypesEditPart;
import org.eclipse.emf.ecoretools.diagram.part.EcoreVisualIDRegistry;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.ConnectionViewFactory;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.notation.ConnectorStyle;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class EClassESuperTypesViewFactory extends ConnectionViewFactory {

	static final Color THIS_FORE = ColorConstants.darkGray;

	@Override
	protected void initializeFromPreferences(View view) {
		super.initializeFromPreferences(view);
		ConnectorStyle connectorStyle = (ConnectorStyle) view.getStyle(NotationPackage.Literals.CONNECTOR_STYLE);
		connectorStyle.setLineColor(FigureUtilities.colorToInteger(THIS_FORE));
		connectorStyle.setRouting(Routing.RECTILINEAR_LITERAL);
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
			semanticHint = EcoreVisualIDRegistry.getType(EClassESuperTypesEditPart.VISUAL_ID);
			view.setType(semanticHint);
		}
		super.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);
	}
}
