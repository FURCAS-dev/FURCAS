/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.query;

import static org.eclipse.emf.emfindex.query.newimpl.Queries.*;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.emfindex.EObjectDescriptor;
import org.eclipse.emf.emfindex.ResourceDescriptor;
import org.eclipse.emf.emfindex.query.newimpl.QueryImpl;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Client {

	public static void main(String[] args) {

		URI uri = URI.createURI("foo");

		QueryImpl<EObjectDescriptor> impl = from(EObjectDescriptor.class).where(
				obj_name.matches("foo").and(
						not(obj_resourceDesc.in(from(ResourceDescriptor.class).where(res_URI.equals(uri))))));
		
	}

}
