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
 * $Id: EcoreSheetLabelProvider.java,v 1.3 2009/02/02 08:39:08 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.sheet;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecoretools.diagram.navigator.EcoreNavigatorGroup;
import org.eclipse.emf.ecoretools.diagram.part.EcoreDiagramEditorPlugin;
import org.eclipse.emf.ecoretools.diagram.part.EcoreVisualIDRegistry;
import org.eclipse.emf.ecoretools.diagram.providers.EcoreElementTypes;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.graphics.Image;

/**
 * @generated
 */
public class EcoreSheetLabelProvider extends BaseLabelProvider implements ILabelProvider {

	// Provide a LabelProvider that could be used when selection is made from
	// outline view
	private static final ILabelProvider labelProvider = new AdapterFactoryLabelProvider(EcoreDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());

	/**
	 * @generated
	 */
	public String getText(Object element) {
		element = unwrap(element);
		if (element instanceof EcoreNavigatorGroup) {
			return ((EcoreNavigatorGroup) element).getGroupName();
		}
		IElementType etype = getElementType(getView(element));
		// Instead of returning null, use the LabelProvider to retrieve the
		// associated text
		return etype == null ? labelProvider.getText(element) : etype.getDisplayName();
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		IElementType etype = getElementType(getView(unwrap(element)));
		// Instead of returning null, use the LabelProvider to retrieve the
		// associated image
		return etype == null ? labelProvider.getImage(unwrap(element)) : EcoreElementTypes.getImage(etype);
	}

	/**
	 * @generated
	 */
	private Object unwrap(Object element) {
		if (element instanceof IStructuredSelection) {
			return ((IStructuredSelection) element).getFirstElement();
		}
		return element;
	}

	/**
	 * @generated
	 */
	private View getView(Object element) {
		if (element instanceof View) {
			return (View) element;
		}
		if (element instanceof IAdaptable) {
			return (View) ((IAdaptable) element).getAdapter(View.class);
		}
		return null;
	}

	/**
	 * @generated
	 */
	private IElementType getElementType(View view) {
		// For intermediate views climb up the containment hierarchy to find the
		// one associated with an element type.
		while (view != null) {
			int vid = EcoreVisualIDRegistry.getVisualID(view);
			IElementType etype = EcoreElementTypes.getElementType(vid);
			if (etype != null) {
				return etype;
			}
			view = view.eContainer() instanceof View ? (View) view.eContainer() : null;
		}
		return null;
	}
}
