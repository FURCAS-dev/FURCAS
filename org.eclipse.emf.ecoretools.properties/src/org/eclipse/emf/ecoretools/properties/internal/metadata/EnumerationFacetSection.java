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
 * $Id: EnumerationFacetSection.java,v 1.2 2009/05/06 13:54:14 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.properties.internal.metadata;

import java.util.List;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecoretools.properties.internal.Messages;
import org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractStringListPropertySection;

/**
 * Section to edit enumeration facet extended metadata
 * 
 * @see ExtendedMetaData#setEnumerationFacet(EDataType, List)
 * @author <a href="jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class EnumerationFacetSection extends AbstractStringListPropertySection {

	@Override
	protected String getLabelText() {
		return Messages.EnumerationFacetSection_EnumerationFacet;
	}

	@Override
	protected List<String> getStringListValues(EObject modelElt) {
		return ExtendedMetaData.INSTANCE.getEnumerationFacet((EDataType) getEObject());
	}

	@Override
	protected void setStringListValues(EObject modelElt, List<String> newValue) {
		ExtendedMetaData.INSTANCE.setEnumerationFacet((EDataType) modelElt, newValue);
	}
}
