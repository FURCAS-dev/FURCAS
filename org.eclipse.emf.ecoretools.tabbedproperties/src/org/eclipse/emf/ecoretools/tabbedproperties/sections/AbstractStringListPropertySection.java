/***********************************************************************
 * Copyright (c) 2008 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 *
 * $Id: AbstractStringListPropertySection.java,v 1.2 2009/05/06 13:54:20 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.tabbedproperties.sections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecoretools.tabbedproperties.EMFRecordingChangeCommand;
import org.eclipse.emf.ecoretools.tabbedproperties.internal.Messages;
import org.eclipse.emf.ecoretools.tabbedproperties.internal.utils.ColorRegistry;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.widgets.Event;

/**
 * An abstract Section used to edit features of type <code>List&lt;String&gt;</code>
 * 
 * @author <a href="jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public abstract class AbstractStringListPropertySection extends AbstractTextPropertySection {

	/** The Pattern used to check an List of String */
	public static final Pattern STRING_LIST_PATTERN = Pattern.compile("(\\w)*(,(\\w)+)*"); //$NON-NLS-1$

	@Override
	protected String getFeatureAsString() {
		StringBuffer result = new StringBuffer();
		List<String> values = getStringListValues(getEObject());
		for (Iterator<String> itValue = values.iterator(); itValue.hasNext();) {
			String nextValue = itValue.next();
			result.append(nextValue);
			if (itValue.hasNext()) {
				result.append(","); //$NON-NLS-1$
			}
		}
		return result.toString();
	}

	@Override
	protected Object getNewFeatureValue(String newText) {
		return Arrays.asList(newText.split(",")); //$NON-NLS-1$
	}

	@Override
	protected void verifyField(Event e) {
		String value = getText().getText();
		if (value == null || value.equals("") || isTextValid()) { //$NON-NLS-1$
			setErrorMessage(null);
			getText().setBackground(null);
			e.doit = true;
		} else {
			setErrorMessage(Messages.AbstractStringListPropertySection_InvalidSequence);
			getText().setBackground(ColorRegistry.COLOR_ERROR);
			e.doit = false;
		}
	}

	@Override
	protected boolean isTextValid() {
		return STRING_LIST_PATTERN.matcher(getText().getText()).matches();
	}

	@Override
	protected EStructuralFeature getFeature() {
		// createCommand() has been overridden
		return null;
	}
	
	@Override
	protected Object getOldFeatureValue() {
		return getStringListValues(getEObject());
	}

	@Override
	protected void createCommand(final Object oldValue, final Object newValue) {
		EditingDomain editingDomain = getEditingDomain();
		if (getEObjectList().size() == 1) {
			if (oldValue != newValue) {
				editingDomain.getCommandStack().execute(new EMFRecordingChangeCommand(getEObject().eResource()) {

					@Override
					protected void doExecute() {
						setStringListValues(getEObject(), (List<String>) newValue);
					}
				});
			}
		} else {
			CompoundCommand compoundCommand = new CompoundCommand();
			/* apply the property change to all selected elements */
			for (final EObject nextObject : getEObjectList()) {
				List<String> oldWildcards = ExtendedMetaData.INSTANCE.getWildcards((EStructuralFeature) nextObject);
				if (oldWildcards != newValue) {
					editingDomain.getCommandStack().execute(new EMFRecordingChangeCommand(nextObject.eResource()) {

						@Override
						protected void doExecute() {
							setStringListValues(nextObject, (List<String>) newValue);
						}
					});
				}
			}
			editingDomain.getCommandStack().execute(compoundCommand);
		}
	}

	protected abstract List<String> getStringListValues(EObject modelElt);
	
	protected abstract void setStringListValues(EObject modelElt, List<String> newValue);

}
