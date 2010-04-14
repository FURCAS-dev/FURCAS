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
 * $Id: QualifiedSection.java,v 1.4 2008/05/26 12:28:57 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.properties.internal.metadata;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecoretools.properties.internal.Messages;
import org.eclipse.emf.ecoretools.tabbedproperties.EMFRecordingChangeCommand;
import org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractBooleanPropertySection;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * Section to edit qualified extended metadata annotation
 * 
 * @see ExtendedMetaData#setQualified(org.eclipse.emf.ecore.EPackage, boolean)
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class QualifiedSection extends AbstractBooleanPropertySection {

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractBooleanPropertySection#getFeature()
	 */
	@Override
	protected EStructuralFeature getFeature() {
		return null;
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractBooleanPropertySection#getFeatureValue()
	 */
	@Override
	protected boolean getFeatureValue() {
		return ExtendedMetaData.INSTANCE.isQualified((EPackage) getEObject());
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#getLabelText()
	 */
	@Override
	protected String getLabelText() {
		return Messages.QualifiedSection_Qualified;
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractBooleanPropertySection#handleCheckButtonModified()
	 */
	@Override
	protected void handleCheckButtonModified() {
		EditingDomain editingDomain = (EditingDomain) getPart().getAdapter(EditingDomain.class);
		final boolean newValue = getCheckButton().getSelection();
		if (getEObjectList().size() == 1) {
			editingDomain.getCommandStack().execute(new EMFRecordingChangeCommand(getEObject().eResource()) {

				@Override
				protected void doExecute() {
					ExtendedMetaData.INSTANCE.setQualified((EPackage) getEObject(), newValue);
				}
			});
		} else {
			CompoundCommand compoundCommand = new CompoundCommand();
			/* apply the property change to all selected elements */
			for (final EObject nextObject : getEObjectList()) {
				editingDomain.getCommandStack().execute(new EMFRecordingChangeCommand(nextObject.eResource()) {

					@Override
					protected void doExecute() {
						ExtendedMetaData.INSTANCE.setQualified((EPackage) nextObject, newValue);
					}
				});
			}
			editingDomain.getCommandStack().execute(compoundCommand);
		}
	}
}
