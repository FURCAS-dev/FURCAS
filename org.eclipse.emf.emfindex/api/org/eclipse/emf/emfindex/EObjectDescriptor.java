/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Jan Kšöhnlein - Initial contribution and API
 */
public interface EObjectDescriptor extends BaseDescriptor {
	
	String getName();

	String getFragment();

	URI getFragmentURI();
	
	EClass getEClass();
	
	ResourceDescriptor getResourceDescriptor();

	EObject createProxy();
}