/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.query;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.emfindex.EReferenceDescriptor;

/**
 * @author koehnlein - Initial contribution and API
 */
public class AllReferencesToResourceQuery implements Query<EReferenceDescriptor>{

	private URI targetResourceURIEquals;

	public URI getTargetResourceURIEquals() {
		return targetResourceURIEquals;
	}

	public void setTargetResourceURIEquals(URI resourceURI) {
		this.targetResourceURIEquals = resourceURI;
	}
	
}
