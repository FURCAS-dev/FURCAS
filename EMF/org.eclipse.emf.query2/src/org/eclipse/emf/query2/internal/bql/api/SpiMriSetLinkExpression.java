/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query2.internal.bql.api;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;

/**
 * LinkExpression with an MRI set as link target.
 */
@Deprecated
public final class SpiMriSetLinkExpression extends SpiLinkExpression {

	private Set<URI> linkTargetSet;

	/**
	 * @param isLinked
	 *            specifies whether the object should be linked or not
	 * @param linkType
	 *            MRI of the association or attribute
	 * @param linkCategory
	 *            link category (ATTRIBUTE or ASSOCIATION)
	 * @param associationEndOfLinkedObject
	 *            link direction (0 or 1)
	 * @param storageEnd
	 *            storage end (0 or 1)
	 * @param fromModelElementExpression
	 *            set of model elements specified by a ModelElementExpression
	 * @param linkTarget
	 *            link target
	 */
	protected SpiMriSetLinkExpression(boolean isLinked, URI linkType, SpiModelElementExpression fromModelElementExpression, URI[] linkTarget) {

		super(isLinked, linkType, fromModelElementExpression, linkTarget);
		if (linkTarget != null && linkTarget.length > 0) {
			linkTargetSet = new HashSet<URI>();
			for (int i = 0; i < linkTarget.length; i++) {
				linkTargetSet.add(linkTarget[i]);
			}
		} else {
			linkTargetSet = Collections.emptySet();
		}
	}

	@Override
	public URI[] getLinkTarget() {

		return (URI[]) super.getLinkTarget();
	}

	public Set<URI> getLinkTargetSet() {

		return linkTargetSet;
	}

	@Override
	public Set<URI> getLinkTargetTypesSet() {

		return null;
	}

	@Override
	public Set<URI> getLinkTargetElementsSet() {

		return this.getLinkTargetSet();
	}

	@Override
	public Set<URI> getLinkTargetScopeSet() {

		return null;
	}

	@Override
	public boolean getLinkTargetScopeIncluded() {

		return false;
	}

}
