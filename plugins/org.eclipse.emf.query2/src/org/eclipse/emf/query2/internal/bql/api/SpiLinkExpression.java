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
 * Link search criterion. A LinkExpression describes the existence or
 * non-existences of a link from a model element to an element of a Set of model
 * elements. The set of model elements is expressed either by the MRIs of the
 * model elements or by a ModelElementExpression, which defines a query
 * expression that selects model elements. The linkType defines the type of the
 * link, which is either the MRI of the association or the MRI of the attribute.
 * The associationEndOfLinkedObject describes the direction of the link. The
 * field isLinked describes whether the existence or the non-existence of the
 * link is to be checked. Let ME be a model element and S the set of model
 * elements defined by the LinkExpression then the link expression is satisfied
 * for ME0 if isLinked is true and there is (at least one) model element ME1 in
 * S for which such a link exists or if isLinked is false and there is no model
 * element ME1 in S for which such a link exists.
 */
@Deprecated
abstract public class SpiLinkExpression {

	private boolean isLinked;

	private URI linkType;

	//    private SpiFqlAssociationCategory linkCategory;

	private SpiModelElementExpression fromModelElementExpression;

	//    private byte associationEndOfLinkedObject;

	//    private byte storageEnd;

	private Object linkTarget;

	/**
	 * @param isLinked
	 *            specifies whether the object should be linked or not
	 * @param linkType
	 *            MRI of the association or attribute
	 * @param linkCategory
	 *            link category (ATTRIBUTE or ASSOCIATION)
	 * @param associationEndOfLinkTarget
	 *            link direction (0 or 1)
	 * @param storageEnd
	 *            storage end (0 or 1)
	 * @param fromModelElementExpression
	 *            set of model elements specified by a ModelElementExpression
	 * @param linkTarget
	 *            link target
	 */
	protected SpiLinkExpression(boolean isLinked, URI linkType, SpiModelElementExpression fromModelElementExpression, Object linkTarget) {

		this.isLinked = isLinked;
		this.linkType = linkType;
		//        this.linkCategory = linkCategory;
		//        this.associationEndOfLinkedObject = associationEndOfLinkTarget;
		//        this.storageEnd = storageEnd;
		this.fromModelElementExpression = fromModelElementExpression;
		this.linkTarget = linkTarget;
	}

	//    public byte getAssociationEndOfLinkedObject( ) {
	//
	//        return associationEndOfLinkedObject;
	//    }

	public SpiModelElementExpression getFromModelElementExpression() {

		return fromModelElementExpression;
	}

	public boolean isLinked() {

		return isLinked;
	}

	public URI getLinkType() {

		return linkType;
	}

	//    public byte getStorageEnd( ) {
	//
	//        return storageEnd;
	//    }

	public Object getLinkTarget() {

		return linkTarget;
	}

	//    public SpiFqlAssociationCategory getLinkCategory( ) {
	//
	//        return linkCategory;
	//    }

	public abstract Set<URI> getLinkTargetTypesSet();

	public abstract Set<URI> getLinkTargetElementsSet();

	public abstract Set<URI> getLinkTargetScopeSet();

	public abstract boolean getLinkTargetScopeIncluded();

	public Set<URI> getFromTypesSet() {

		return getFromModelElementExpression().getTypesSet();
	}

	public Set<URI> getFromScopeSet() {

		return getFromModelElementExpression().getScope();
	}

	public boolean getFromScopeIncluded() {

		return getFromModelElementExpression().scopeIsIncluded();
	}

	public Set<URI> getFromElementsSet() {

		return getFromModelElementExpression().getElementsSet();
	}

	/**
     *
     */
	public void toString(StringBuffer sb, int ident, boolean newline) {

		SpiUtils.toStringNewLine(sb, ident);
		sb.append(SpiUtils.OPENING_PARENTHESES);
		if (this.isLinked) {
			sb.append(SpiUtils.IS_LINKED);
		} else {
			sb.append(SpiUtils.NOT_LINKED);
		}
		sb.append(',');
		sb.append(SpiUtils.LINK_TYPE);
		sb.append(SpiUtils.EQUAL);
		sb.append(SpiUtils.uriIdForPrinting(this.linkType));
		sb.append(',');
		//        sb.append( SpiUtils.ASSOCIATION_END_LINKED_OBJ );
		//        sb.append( SpiUtils.EQUAL );
		//        sb.append( this.associationEndOfLinkedObject );
		//        sb.append( ',' );
		//        sb.append( SpiUtils.STORAGE_END );
		//        sb.append( SpiUtils.EQUAL );
		//        sb.append( this.storageEnd );
		//        sb.append( ',' );
		sb.append(SpiUtils.LINK_FROM);
		sb.append(": "); //$NON-NLS-1$
		sb.append(this.fromModelElementExpression.getAlias());
		sb.append(", "); //$NON-NLS-1$
		sb.append(SpiUtils.LINK_TO);
		sb.append(": "); //$NON-NLS-1$
		if (linkTarget instanceof URI[]) {
			URI[] toLinkedModelElements = (URI[]) linkTarget;
			SpiUtils.uriArrayForPrinting(sb, toLinkedModelElements);
		} else if (linkTarget instanceof SpiModelElementExpression) {
			SpiModelElementExpression modelElementExpression = (SpiModelElementExpression) linkTarget;
			sb.append(modelElementExpression.getAlias());
		} else if (linkTarget instanceof SpiModelElementClusterExpression) {
			SpiModelElementClusterExpression modelElementClusterExpression = (SpiModelElementClusterExpression) linkTarget;
			modelElementClusterExpression.toString(sb, ident + 1, true);
		}
		sb.append(SpiUtils.CLOSING_PARENTHESES);
	}

}