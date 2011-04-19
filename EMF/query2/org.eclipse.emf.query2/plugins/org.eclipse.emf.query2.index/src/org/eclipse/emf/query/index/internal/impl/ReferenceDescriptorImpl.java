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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query.index.internal.EReferenceDescriptorInternal;
import org.eclipse.emf.query.index.properties.ReferenceDescriptorProperties;
import org.eclipse.ui.views.properties.IPropertySource;

/**
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 * 
 */
public class ReferenceDescriptorImpl implements EReferenceDescriptorInternal, IAdaptable {

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

	public String getTargetFragment() {
		return this.targetFragment;
	}

	public String getEReferenceURI() {
		return this.reference;
	}

	public String getSourceFragment() {
		return this.source.getFragment();
	}

	public URI getSourceResourceURI() {
		return this.source.getResourceURI();
	}

	public URI getTargetResourceURI() {
		return this.targetResource;
	}

	public boolean isIntraLink() {
		return this.source.getResourceURI() == this.targetResource;
	}

	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class adapter) {
		if (adapter == IPropertySource.class)
			return new ReferenceDescriptorProperties(this);
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reference == null) ? 0 : reference.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((targetFragment == null) ? 0 : targetFragment.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReferenceDescriptorImpl other = (ReferenceDescriptorImpl) obj;
		if (reference == null) {
			if (other.reference != null)
				return false;
		} else if (!reference.equals(other.reference))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (targetFragment == null) {
			if (other.targetFragment != null)
				return false;
		} else if (!targetFragment.equals(other.targetFragment))
			return false;
		return true;
	}

}
