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
 * $Id: ItemTypeSection.java,v 1.5 2008/05/26 12:28:57 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.properties.internal.metadata;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecoretools.properties.internal.Messages;
import org.eclipse.emf.ecoretools.tabbedproperties.EMFRecordingChangeCommand;
import org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractChooserPropertySection;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;

/**
 * Section to edit item type extended metadata annotation
 * 
 * @see ExtendedMetaData#setItemType(EDataType, EDataType)
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class ItemTypeSection extends AbstractChooserPropertySection {

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#getFeature()
	 */
	@Override
	protected EStructuralFeature getFeature() {
		return null;
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#getLabelText()
	 */
	@Override
	protected String getLabelText() {
		return Messages.ItemTypeSection_ItemType;
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractChooserPropertySection#getComboFeatureValues()
	 */
	@Override
	protected Object[] getComboFeatureValues() {
		return getChoices(getEObject(), EcorePackage.Literals.EDATA_TYPE);
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
		return ExtendedMetaData.INSTANCE.getItemType((EDataType) getEObject());
	}

	/**
	 * Handle the combo modified event.
	 */
	@Override
	protected void handleComboModified() {
		if (!isRefreshing()) {
			final Object newItemType = getCSingleObjectChooser().getSelection();
			EditingDomain editingDomain = getEditingDomain();
			if (getEObjectList().size() == 1) {
				EDataType oldItemType = ExtendedMetaData.INSTANCE.getItemType((EDataType) getEObject());
				if (oldItemType != newItemType) {
					editingDomain.getCommandStack().execute(new EMFRecordingChangeCommand(getEObject().eResource()) {

						@Override
						protected void doExecute() {
							ExtendedMetaData.INSTANCE.setItemType((EDataType) getEObject(), (EDataType) newItemType);
						}
					});
				}
			} else {
				CompoundCommand compoundCommand = new CompoundCommand();
				/* apply the property change to all selected elements */
				for (final EObject nextObject : getEObjectList()) {
					EDataType oldItemType = ExtendedMetaData.INSTANCE.getItemType((EDataType) nextObject);
					if (oldItemType != newItemType) {
						editingDomain.getCommandStack().execute(new EMFRecordingChangeCommand(nextObject.eResource()) {

							@Override
							protected void doExecute() {
								ExtendedMetaData.INSTANCE.setItemType((EDataType) nextObject, (EDataType) newItemType);
							}
						});
					}
				}
				editingDomain.getCommandStack().execute(compoundCommand);
			}
		}
	}
}
