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
package org.eclipse.emf.query.index.impl;

import org.eclipse.emf.query.index.internal.IncomingReferenceDescriptor;
import org.eclipse.emf.query.index.maps.MapEntry;
/**
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 * 
 */
public class IncomingReferenceDescriptorImpl implements IncomingReferenceDescriptor {

	private final String targetFragement;
	public static final int TARGET_FRAGMENT = 1;

	private final String sourceResource;

	// TODO think about making this a 1..* reference -> one instance per target/src-res 
	private final String sourceFragment;

	public IncomingReferenceDescriptorImpl(String targetFrag, String srcRes, String srcFragment) {
		this.targetFragement = targetFrag;
		this.sourceResource = srcRes;
		this.sourceFragment = srcFragment;
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

	public String getSourceResourceURI() {
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
}