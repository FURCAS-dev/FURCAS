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
package org.eclipse.emf.query.index.api.query;

import org.eclipse.emf.query.index.api.query.descriptors.EObjectDescriptor;
import org.eclipse.emf.query.index.api.query.descriptors.EReferenceDescriptor;
import org.eclipse.emf.query.index.api.query.descriptors.ResourceDescriptor;
import org.eclipse.emf.query.index.impl.query.EObjectQueryImpl;
import org.eclipse.emf.query.index.impl.query.EReferenceQueryImpl;
import org.eclipse.emf.query.index.impl.query.ResourceQueryImpl;
/**
 * @author Martin Strenge, SAP AG
 * @author Bernd Kolb, SAP AG
 *
 */
public class IndexQueryFactory {

	public static EObjectQuery<EObjectDescriptor> createEObjectQuery() {
		return new EObjectQueryImpl<EObjectDescriptor>();
	}

	public static EReferenceQuery<EReferenceDescriptor> createEReferenceQuery() {
		return new EReferenceQueryImpl<EReferenceDescriptor>();
	}

	public static ResourceQuery<ResourceDescriptor> createResourceQuery() {
		return new ResourceQueryImpl<ResourceDescriptor>();
	}

}
