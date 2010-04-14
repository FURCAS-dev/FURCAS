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
 * $Id: AbstractStringPropertySection.java,v 1.1 2008/05/26 12:25:14 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.tabbedproperties.sections;

import org.eclipse.swt.widgets.Event;

/**
 * An abstract implementation of a section for a field with a String property
 * value.
 * 
 * Creation 5 apr. 2006 Updated 7 aug. 2006
 * 
 * @author Jacques Lescot
 * @author Alfredo Serrano
 */
public abstract class AbstractStringPropertySection extends AbstractTextPropertySection {

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTextPropertySection#verifyField(Event)
	 */
	protected void verifyField(Event e) {
		// do nothing
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTextPropertySection#getFeatureAsString()
	 */
	protected String getFeatureAsString() {
		String string = getEObject() == null ? null : (String) getEObject().eGet(getFeature());
		if (string == null) {
			return ""; //$NON-NLS-1$
		}
		return string;
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTextPropertySection#getNewFeatureValue(java.lang.String)
	 */
	protected Object getNewFeatureValue(String newText) {
		return newText;
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTextPropertySection#getOldFeatureValue()
	 */
	protected Object getOldFeatureValue() {
		return getFeatureAsString();
	}
}