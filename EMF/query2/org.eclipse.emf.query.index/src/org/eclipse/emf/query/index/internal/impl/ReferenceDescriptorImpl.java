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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query.index.internal.EReferenceDescriptorInternal;

/**
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 * 
 */
public class ReferenceDescriptorImpl implements EReferenceDescriptorInternal {

	private final EObjectDescriptorImpl source;
	public static final int SOURCE_FRAGMENT = 1;

	private final String reference;

	private URI targetResource;

	private String targetFragment;

	public ReferenceDescriptorImpl(EObjectDescriptorImpl src, String ref, URI tarRes, String tarFrag) {
		this.source = src;
		this.reference = ref;
		this.targetResource = tarRes;
		this.targetFragment = tarFrag;
	}

	@Override
	public Object getKeyElement(int keyNr) {
		switch (keyNr) {
		case SOURCE_FRAGMENT:
			return source.getFragment();
		case TARGET_FRAGMENT:
			return targetFragment;
		default:
			throw new IllegalArgumentException();
		}
	}

	public void setTargetResource(URI value) {
		this.targetResource = value;
	}

	public void setTargetFragment(String value) {
		this.targetFragment = value;
	}

	public EObjectDescriptorImpl getSource() {
		return this.source;
	}

	@Override
	public String getTargetFragment() {
		return this.targetFragment;
	}

	@Override
	public String getEReferenceURI() {
		return this.reference;
	}

	@Override
	public String getSourceFragment() {
		return this.source.getFragment();
	}

	@Override
	public URI getSourceResourceURI() {
		return this.source.getResourceURI();
	}

	@Override
	public URI getTargetResourceURI() {
		return this.targetResource;
	}

	@Override
	public boolean isIntraLink() {
		return this.source.getResourceURI() == this.targetResource;
	}
}
