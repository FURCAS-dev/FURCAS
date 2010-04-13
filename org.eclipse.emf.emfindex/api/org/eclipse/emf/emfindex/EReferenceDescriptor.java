/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EReference;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public interface EReferenceDescriptor extends BaseDescriptor {

	ResourceDescriptor getSourceResourceDescriptor();

	String getSourceFragment();
	
	URI getSourceFragmentURI();

	EReference getEReference();

	String getTargetFragment();

	URI getTargetResourceURI();
	
	URI getTargetFragmentURI();
	
}