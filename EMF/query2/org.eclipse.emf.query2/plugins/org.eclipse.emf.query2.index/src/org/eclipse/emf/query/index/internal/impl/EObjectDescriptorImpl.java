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
package org.eclipse.emf.query.index.internal.impl;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query.index.internal.maps.MapEntry;
import org.eclipse.emf.query.index.query.descriptors.EObjectDescriptor;

/**
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 * 
 */
public class EObjectDescriptorImpl implements EObjectDescriptor, MapEntry {

	private String eClass;
	public static final int ECLASS = 1;

	private PageableResourceDescriptorImpl resource;

	private String fragment;
	public static final int FRAGMENT = 2;

	private String name;

	private Map<String, String> userData;

	public EObjectDescriptorImpl(String type, PageableResourceDescriptorImpl res, String frag, String _name, Map<String, String> uData) {
		this.eClass = type;
		this.resource = res;
		this.fragment = frag;
		this.name = _name;
		this.userData = uData;
	}

	public Object getKeyElement(int keyNr) {
		switch (keyNr) {
		case ECLASS:
			return eClass;
		case FRAGMENT:
			return fragment;
		default:
			throw new IllegalArgumentException();
		}
	}

	public String getFragment() {
		return this.fragment;
	}

	public String getName() {
		return this.name;
	}

	public String getUserData(String key) {
		if (this.userData == null) {
			return null;
		}
		return this.userData.get(key);
	}

	public void setFragment(String value) {
		this.fragment = value;
	}

	protected Map<String, String> getUserData() {
		return this.userData;
	}

	public void setEClass(String value) {
		this.eClass = value;
	}

	public String getEClassURI() {
		return this.eClass;
	}

	public URI getResourceURI() {
		return this.resource.getURI();
	}
}
