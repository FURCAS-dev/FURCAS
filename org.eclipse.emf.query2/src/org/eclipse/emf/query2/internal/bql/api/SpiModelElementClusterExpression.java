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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query2.internal.index.SpiFacilityQueryServiceException;


/**
 * Expression for a cluster of model element expressions The cluster has one
 * header model element expression. All model element expressions in the cluster
 * can be linked to each other.
 */
@Deprecated
public final class SpiModelElementClusterExpression {

	private SpiModelElementExpression headerModelElementExpression;

	private List<SpiModelElementExpression> additionalModelElementExpressions = new ArrayList<SpiModelElementExpression>();

	private List<SpiClusterInternalLinkExpression> clusterInternalLinks = new ArrayList<SpiClusterInternalLinkExpression>();

	private List<SpiClusterExternalLinkExpression> clusterExternalLinks = new ArrayList<SpiClusterExternalLinkExpression>();

	private List<SpiMriSetLinkExpression> mriSetLinks = new ArrayList<SpiMriSetLinkExpression>();

	// Every model element expression in the cluster has an index position. 
	// The header model element expression has the index 0. The other model element expression have an index depending on its position
	// in the additionalModelElementExpressions array starting with 1.
	// modelElementExpressionToIndex is used in order to fast retrieve the model element expression for a specific index. 
	private Map<SpiModelElementExpression, Integer> modelElementExpressionToIndex = new HashMap<SpiModelElementExpression, Integer>();

	public SpiModelElementClusterExpression(SpiModelElementExpression headerModelElementExpression) {

		this.headerModelElementExpression = headerModelElementExpression;
	}

	/**
	 * Adds a ModelElementExpression to the cluster.
	 * 
	 * @param modelElementExpression
	 */
	public void addModelElementExpressionToCluster(SpiModelElementExpression modelElementExpression) {

		this.additionalModelElementExpressions.add(modelElementExpression);
	}

	/**
	 * Gets the total number of model element expressions in the cluster. The
	 * total number of model elements is 1 for the header model element
	 * expression + the number of the additional model element expressions
	 * 
	 * @return total number of model element expressions in the cluster
	 */
	public int getTotalNumberOfModelElementExpressions() {

		return this.additionalModelElementExpressions.size() + 1;
	}

	/**
	 * Gets a model element expression from the cluster. The model element
	 * expression with the index 0 is the header model element expression.
	 * 
	 * @param index
	 *            index of the model element expressions starting with 0
	 * @return model element expression in the cluster
	 */
	public SpiModelElementExpression getModelElementExpression(int index) {

		if (index == 0) {
			return this.headerModelElementExpression;
		} else {
			return this.additionalModelElementExpressions.get(index - 1);
		}
	}

	public int getIndexOfModelElementExpressionInCluster(SpiModelElementExpression modelElementExpression) {

		Integer indexObj = this.modelElementExpressionToIndex.get(modelElementExpression);
		if (indexObj != null) {
			return indexObj.intValue();
		} else {
			// try to find model element expression in cluster and add it to the map
			int clusterSize = this.getTotalNumberOfModelElementExpressions();
			for (int i = 0; i < clusterSize; i++) {
				SpiModelElementExpression currentModelElementExpression = this.getModelElementExpression(i);
				if (currentModelElementExpression == modelElementExpression) {
					this.modelElementExpressionToIndex.put(modelElementExpression, Integer.valueOf(i));
					return i;
				}
			}
			throw new SpiFacilityQueryServiceException(SpiFacilityQueryServiceException.ERROR_CODE_UNSPECIFIED,
					BQLBugMessages.NO_INDEX_FOUND_FOR_MODEL_ELEMENT_EXPRESSION);
		}
	}

	/**
	 * Adds a cluster internal link which is a link between 2 ModelElements in
	 * the cluster. The isLinked flag of the LinkExpression must be true.
	 * 
	 * @param linkExpression
	 */
	protected void addClusterInternalLink(SpiClusterInternalLinkExpression linkExpression) {

		this.clusterInternalLinks.add(linkExpression);
	}

	/**
	 * Adds a cluster external link. A cluster internal link links a
	 * ModelElement in the cluster with another ModelElementClusterExpression.
	 * The isLinked flag of the LinkExpression can be true or false.
	 * 
	 * @param linkExpression
	 */
	protected void addClusterExternalLink(SpiClusterExternalLinkExpression linkExpression) {

		this.clusterExternalLinks.add(linkExpression);
	}

	/**
	 * Adds an MRI set link. An MRI set link links a ModelElement in the cluster
	 * with a fixed set of MRIs. The isLinked flag of the LinkExpression can be
	 * true or false.
	 * 
	 * @param linkExpression
	 */
	protected void addMriSetLink(SpiMriSetLinkExpression linkExpression) {

		this.mriSetLinks.add(linkExpression);
	}

	/**
	 * Adds a cluster internal link from a ModelElementExpression to another
	 * ModelElementExpression in the cluster. The isLinked flag of the
	 * LinkExpression is true.
	 * 
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
	 * @param toModelElementExpression
	 *            set of model elements specified by a ModelElementExpression
	 */
	public void addClusterInternalLink(URI linkType, SpiModelElementExpression fromModelElementExpression,
			SpiModelElementExpression toModelElementExpression) {

		this.addClusterInternalLink(new SpiClusterInternalLinkExpression(linkType, fromModelElementExpression, toModelElementExpression));
	}

	/**
	 * Adds a link from a ModelElementExpression to a set of MRIs.
	 * 
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
	 * @param toLinkedModelElements
	 *            set of model elements specified by MRIs
	 */
	public void addMriSetLink(boolean isLinked, URI linkType, SpiModelElementExpression fromModelElementExpression,
			URI[] toLinkedModelElements) {

		this.addMriSetLink(new SpiMriSetLinkExpression(isLinked, linkType, fromModelElementExpression, toLinkedModelElements));
	}

	/**
	 * Adds a cluster external link from a ModelElementExpression to a
	 * ModelElementClusterExpression. The isLinked flag can be true or false.
	 * 
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
	 * @param toModelElementClusterExpression
	 *            set of model elements specified by a ModelElementExpression
	 */
	public void addClusterExternalLink(boolean isLinked, URI linkType, SpiModelElementExpression fromModelElementExpression,
			SpiModelElementClusterExpression toModelElementClusterExpression) {

		this.addClusterExternalLink(new SpiClusterExternalLinkExpression(isLinked, linkType, fromModelElementExpression,
				toModelElementClusterExpression));
	}

	public List<SpiModelElementExpression> getAdditionalModelElementExpressions() {

		return additionalModelElementExpressions;
	}

	public List<SpiClusterExternalLinkExpression> getClusterExternalLinks() {

		return clusterExternalLinks;
	}

	public List<SpiClusterInternalLinkExpression> getClusterInternalLinks() {

		return clusterInternalLinks;
	}

	public List<SpiMriSetLinkExpression> getMriSetLinks() {

		return mriSetLinks;
	}

	public SpiModelElementExpression getHeaderModelElementExpression() {

		return headerModelElementExpression;
	}

	@SuppressWarnings("nls")
	public void toString(StringBuffer sb, int ident, boolean newline) {

		SpiUtils.toStringNewLine(sb, ident);
		sb.append(SpiUtils.OPENING_PARENTHESES);
		sb.append(SpiUtils.MODEL_ELEMENT_CLUSTER_EXPRESSION);
		sb.append(": ");
		SpiUtils.toStringNewLine(sb, ident + 1);
		sb.append(SpiUtils.HEADER_MODEL_ELEMENT_EXPRESSION);
		sb.append(": ");
		this.headerModelElementExpression.toString(sb, ident + 2, true);
		SpiUtils.toStringNewLine(sb, ident + 1);
		sb.append(SpiUtils.ADDITION_MODEL_ELEMENT_EXPRESSIONS);
		sb.append(": ");
		int addModElSize = this.additionalModelElementExpressions.size();
		for (int i = 0; i < addModElSize; i++) {
			if (i > 0) {
				sb.append(", ");
			}
			this.additionalModelElementExpressions.get(i).toString(sb, ident + 2, true);
		}
		int intLinksSize = this.clusterInternalLinks.size();
		if (intLinksSize > 0) {
			SpiUtils.toStringNewLine(sb, ident + 1);
			sb.append(SpiUtils.CLUSTER_INTERNAL_LINKS);
			sb.append(": ");
			for (int i = 0; i < intLinksSize; i++) {
				if (i > 0) {
					sb.append(", ");
				}
				this.clusterInternalLinks.get(i).toString(sb, ident + 2, true);
			}
		}
		int extLinksSize = this.clusterExternalLinks.size();
		if (extLinksSize > 0) {
			SpiUtils.toStringNewLine(sb, ident + 1);
			sb.append(SpiUtils.CLUSTER_EXTERNAL_LINKS);
			sb.append(": ");
			for (int i = 0; i < extLinksSize; i++) {
				if (i > 0) {
					sb.append(", ");
				}
				this.clusterExternalLinks.get(i).toString(sb, ident + 2, true);
			}
		}
		int mriSetLinksSize = this.mriSetLinks.size();
		if (mriSetLinksSize > 0) {
			SpiUtils.toStringNewLine(sb, ident + 1);
			sb.append(SpiUtils.MRI_SET_LINKS);
			sb.append(": ");
			for (int i = 0; i < mriSetLinksSize; i++) {
				if (i > 0) {
					sb.append(", ");
				}
				this.mriSetLinks.get(i).toString(sb, ident + 2, true);
			}
		}
		SpiUtils.toStringNewLine(sb, ident);
		sb.append(SpiUtils.CLOSING_PARENTHESES);
	}
}
