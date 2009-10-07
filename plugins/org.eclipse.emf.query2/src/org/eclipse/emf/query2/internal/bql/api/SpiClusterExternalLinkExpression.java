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

import java.util.Set;

import org.eclipse.emf.common.util.URI;

/**
 * LinkExpression with a model element cluster expression as link target.
 */
@Deprecated
public final class SpiClusterExternalLinkExpression extends SpiLinkExpression {

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
	protected SpiClusterExternalLinkExpression(boolean isLinked, URI linkType, SpiModelElementExpression fromModelElementExpression,
			SpiModelElementClusterExpression linkTarget) {

		super(isLinked, linkType, fromModelElementExpression, linkTarget);
	}

	@Override
	public SpiModelElementClusterExpression getLinkTarget() {

		return (SpiModelElementClusterExpression) super.getLinkTarget();
	}

	@Override
	public Set<URI> getLinkTargetTypesSet() {

		return getLinkTarget().getHeaderModelElementExpression().getTypesSet();
	}

	@Override
	public Set<URI> getLinkTargetElementsSet() {

		return getLinkTarget().getHeaderModelElementExpression().getElementsSet();
	}

	@Override
	public Set<URI> getLinkTargetScopeSet() {

		return getLinkTarget().getHeaderModelElementExpression().getPartitionExpression().getPartitionSet();
	}

	@Override
	public boolean getLinkTargetScopeIncluded() {

		return getLinkTarget().getHeaderModelElementExpression().getPartitionExpression().isIncludeList();
	}

}
