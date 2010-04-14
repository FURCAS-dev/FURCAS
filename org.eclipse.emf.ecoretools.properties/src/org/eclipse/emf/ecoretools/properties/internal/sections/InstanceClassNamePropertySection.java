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
 * $Id: InstanceClassNamePropertySection.java,v 1.6 2009/03/30 14:31:38 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.properties.internal.sections;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreValidator;
import org.eclipse.emf.ecoretools.properties.internal.Messages;
import org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractStringPropertySection;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * The section for the name instanceClassName of an EClassifier Object.
 * 
 * Creation 19 may 2006
 * 
 * @author jlescot
 */
public class InstanceClassNamePropertySection extends AbstractStringPropertySection {

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTextPropertySection#getLabelText()
	 */
	@Override
	protected String getLabelText() {
		return Messages.InstanceClassNamePropertySection_InstanceClassName;
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTextPropertySection#getFeature()
	 */
	@Override
	protected EStructuralFeature getFeature() {
		return EcorePackage.Literals.ECLASSIFIER__INSTANCE_CLASS_NAME;
	}

	/**
	 * Override the default behavior in order to prevent setting an "empty"
	 * string value to the InstanceClassName attribute.
	 */
	@Override
	protected void createCommand(Object oldValue, Object newValue) {
		boolean equals = oldValue == null ? false : oldValue.equals(newValue);
		if (!equals) {
			EditingDomain editingDomain = getEditingDomain();
			if (getEObjectList().size() == 1) {
				// apply the property change to single selected object
				EObject eObject = (EObject) getEObject();
				newValue = normalizeInstanceTypeName(stripToNull((String) newValue));
				if (editingDomain == null) {
					eObject.eSet(EcorePackage.Literals.ECLASSIFIER__INSTANCE_CLASS_NAME, newValue);
				} else {
					// Set the instance type name instead, since that will also
					// set the instance class name but this way will make undo
					// restore the current instance type name correctly
					editingDomain.getCommandStack().execute(SetCommand.create(editingDomain, eObject, EcorePackage.Literals.ECLASSIFIER__INSTANCE_TYPE_NAME, newValue));
				}
			} else {
				CompoundCommand compoundCommand = new CompoundCommand();
				// apply the property change to all selected elements
				for (EObject nextObject : getEObjectList()) {

					newValue = normalizeInstanceTypeName(stripToNull((String) newValue));
					if (editingDomain == null) {
						nextObject.eSet(EcorePackage.Literals.ECLASSIFIER__INSTANCE_CLASS_NAME, newValue);
					} else {
						// Set the instance type name instead, since that will
						// also set the instance class name but this way will
						// make undo restore the current instance type name
						// correctly
						compoundCommand.append(SetCommand.create(editingDomain, nextObject, EcorePackage.Literals.ECLASSIFIER__INSTANCE_TYPE_NAME, newValue));
					}
				}
				editingDomain.getCommandStack().execute(compoundCommand);
			}
		}
	}

	// Some utility methods copied from EModelElementItemProvider and
	// EClassifierItemProvider

	private String normalizeInstanceTypeName(String value) {
		if (value != null) {
			Diagnostic diagnostic = EcoreValidator.EGenericTypeBuilder.INSTANCE.parseInstanceTypeName(value);
			if (diagnostic.getSeverity() == Diagnostic.OK) {
				value = EcoreUtil.toJavaInstanceTypeName(((EGenericType) diagnostic.getData().get(0)));
			}
		}
		return value;
	}

	/**
	 * Strips whitespace and converts the empty string to null.
	 * 
	 * @param value
	 *            Any string or null.
	 * @return the trimmed value or null if it's an empty string.
	 */
	private String stripToNull(String value) {
		if (value != null) {
			value = value.trim();
			if (value.length() == 0) {
				value = null;
			}
		}
		return value;
	}
}
