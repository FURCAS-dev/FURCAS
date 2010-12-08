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
/**
 * 
 */
package org.eclipse.emf.query.index.internal.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query.index.internal.EReferenceDescriptorInternal;

/**
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 * 
 */
public class IncomingReferenceDescriptorImpl implements EReferenceDescriptorInternal {

	private final URI sourceResource;

	private final String sourceFragment;

	private final String referenceURI;

	private final PageableResourceDescriptorImpl targetResource;

	private final String targetFragement;

	public IncomingReferenceDescriptorImpl(PageableResourceDescriptorImpl tgtResource, String targetFrag, URI srcRes, String srcFragment,
			String linkTypeUri) {
		targetResource = tgtResource;
		this.targetFragement = targetFrag;
		this.sourceResource = srcRes;
		this.sourceFragment = srcFragment;
		this.referenceURI = linkTypeUri;
	}

	@Override
	public Object getKeyElement(int keyNr) {
		switch (keyNr) {
		case TARGET_FRAGMENT:
			return targetFragement;
		default:
			throw new IllegalArgumentException();
		}
	}

	public URI getSourceResourceURI() {
		return sourceResource;
	}

	public String getSourceFragment() {
		return sourceFragment;
	}

	public String getTargetFragment() {
		return targetFragement;
	}

	@Override
	public boolean isIntraLink() {
		return false;
	}

	@Override
	public String getEReferenceURI() {
		return this.referenceURI;
	}

	@Override
	public URI getTargetResourceURI() {
		return this.targetResource.getURI();
	}

}