/*******************************************************************************
 * Copyright (c) 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query.index.test.convenience;

import org.eclipse.emf.query.index.query.EObjectQuery;
import org.eclipse.emf.query.index.query.EReferenceQuery;
import org.eclipse.emf.query.index.query.ResourceQuery;
/**
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 * 
 */
public class ConvenientIndexQueryFactory {

	public EObjectQuery<?> createEObjectQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	public EReferenceQuery<?> createEReferenceQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResourceQuery<ConvenientResourceDescriptor> createResourceQuery() {
		return new ConvenientResourceQueryImpl<ConvenientResourceDescriptor>();
	}

}
