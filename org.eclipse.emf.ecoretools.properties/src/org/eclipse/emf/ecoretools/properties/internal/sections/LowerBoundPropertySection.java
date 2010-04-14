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
 * $Id: LowerBoundPropertySection.java,v 1.5 2008/05/26 12:28:57 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.properties.internal.sections;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecoretools.properties.internal.Messages;
import org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractIntegerPropertySection;

/**
 * A section for the lower bound property of an ETypedElement Object.
 * 
 * Creation 5 avr. 2006
 * 
 * @author jlescot
 */
public class LowerBoundPropertySection extends AbstractIntegerPropertySection {

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTextPropertySection#getFeature()
	 */
	@Override
	protected EStructuralFeature getFeature() {
		return EcorePackage.Literals.ETYPED_ELEMENT__LOWER_BOUND;
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractIntegerPropertySection#getFeatureInteger()
	 */
	@Override
	protected Integer getFeatureInteger() {
		return new Integer(((ETypedElement) getEObject()).getLowerBound());
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTextPropertySection#getLabelText()
	 */
	@Override
	protected String getLabelText() {
		return Messages.LowerBoundPropertySection_LowerBound;
	}

}
