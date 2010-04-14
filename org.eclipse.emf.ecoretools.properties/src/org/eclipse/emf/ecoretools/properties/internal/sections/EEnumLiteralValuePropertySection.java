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
 * $Id: EEnumLiteralValuePropertySection.java,v 1.5 2008/05/26 12:28:57 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.properties.internal.sections;

import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecoretools.properties.internal.Messages;
import org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractIntegerPropertySection;

/**
 * A section for the value property of an EEnumLiteral Object.
 * 
 * Creation 5 avr. 2006
 * 
 * @author jlescot
 */
public class EEnumLiteralValuePropertySection extends AbstractIntegerPropertySection {

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTextPropertySection#getFeature()
	 */
	@Override
	protected EStructuralFeature getFeature() {
		return EcorePackage.Literals.EENUM_LITERAL__VALUE;
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractIntegerPropertySection#getFeatureInteger()
	 */
	@Override
	protected Integer getFeatureInteger() {
		return new Integer(((EEnumLiteral) getEObject()).getValue());
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTextPropertySection#getLabelText()
	 */
	@Override
	protected String getLabelText() {
		return Messages.EEnumLiteralValuePropertySection_Value;
	}

}
