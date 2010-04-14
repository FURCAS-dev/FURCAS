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
 * $Id: ETypePropertySection.java,v 1.5 2008/05/26 12:28:57 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.properties.internal.sections;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecoretools.properties.internal.Messages;
import org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractChooserPropertySection;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;

/**
 * A section for the shot property of a selected player Object.
 * 
 * Creation 5 avr. 2006
 * 
 * @author jlescot
 */
public class ETypePropertySection extends AbstractChooserPropertySection {

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#getFeature()
	 */
	@Override
	protected EStructuralFeature getFeature() {
		return EcorePackage.Literals.ETYPED_ELEMENT__ETYPE;
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#getLabelText()
	 */
	@Override
	protected String getLabelText() {
		return Messages.ETypePropertySection_EType;
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractChooserPropertySection#getComboFeatureValues()
	 */
	@Override
	protected Object[] getComboFeatureValues() {
		for (Adapter adapter : getEObject().eAdapters()) {
			if (adapter instanceof ItemProviderAdapter) {
				IItemPropertyDescriptor descriptor = ((ItemProviderAdapter) adapter).getPropertyDescriptor(getEObject(), getFeature().getName());
				if (descriptor != null) {
					return descriptor.getChoiceOfValues(getEObject()).toArray();
				}
			}
		}
		return new String[] { "" }; //$NON-NLS-1$
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractChooserPropertySection#getLabelProvider()
	 */
	@Override
	protected ILabelProvider getLabelProvider() {
		return new AdapterFactoryLabelProvider(new EcoreItemProviderAdapterFactory());
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractChooserPropertySection#getFeatureValue()
	 */
	@Override
	protected Object getFeatureValue() {
		return ((ETypedElement) getEObject()).getEType();
	}

}
