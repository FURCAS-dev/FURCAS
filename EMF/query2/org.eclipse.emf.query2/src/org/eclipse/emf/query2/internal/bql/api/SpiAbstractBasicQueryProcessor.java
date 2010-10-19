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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.query2.exception.LocalizedBaseRuntimeException;
import org.eclipse.emf.query2.internal.fql.SpiFqlQuery;
import org.eclipse.emf.query2.internal.fql.SpiFqlQueryResultSet;
import org.eclipse.emf.query2.internal.index.SpiFacilityQueryClientScope;
import org.eclipse.emf.query2.internal.index.SpiFacilityQueryServiceException;
import org.eclipse.emf.query2.internal.shared.EmfHelper;


/**
 * Basic query language for querying partitions, model elements and links on a
 * given facility. BasicQL itself is facility independent.
 */
@Deprecated
public abstract class SpiAbstractBasicQueryProcessor implements SpiBasicQueryProcessor {

	/**
	 * keeps the facility ID of BQL's host
	 */
	private String facilityId;

	public SpiAbstractBasicQueryProcessor(String facilityId) {

		this.facilityId = facilityId;
	}

	/**
	 * This method should be called by facility-dependant implementations within
	 * its {@link #execute(Connection, SpiSelectExpression, PRI[], int)} method.
	 * 
	 * @param selectExpression
	 */
	protected void checkQueryConsistency(SpiSelectExpression selectExpression) {

		// check the consistency of the select list
		this.checkSelectListModelElementsExpressionConsistency(selectExpression);
		// check the consistency of the cluster
		this.checkModelElementClusterConsistency(selectExpression.getModelElementClusterExpression(),
				new HashSet<SpiModelElementClusterExpression>());

	}

	/**
	 * Checks that the ModelElementExpressions in the select lists are part of
	 * the root ModelElementClusterExpression
	 * 
	 * @param selectExpression
	 *            select expression to eb checked
	 */
	private void checkSelectListModelElementsExpressionConsistency(SpiSelectExpression selectExpression) {

		SpiModelElementClusterExpression modelElementClusterExpression = selectExpression.getModelElementClusterExpression();
		SpiSelectList[] selectLists = selectExpression.getSelectLists();
		if (selectLists.length == 0) {
			throw new SpiFacilityQueryServiceException(SpiFacilityQueryServiceException.ERROR_CODE_UNSPECIFIED,
					BQLBugMessages.SELECTEXPRESSION_MUST_HAVE_AT_LEAST_ONE_SELECTLIST_SELECTEXPRESSION, selectExpression);
		}
		for (int numSelList = 0; numSelList < selectLists.length; numSelList++) {
			SpiModelElementExpression modelElementExpressionOfSelectList = selectLists[numSelList].getModelElementExpression();
			if (!this.isModelElementExpressionInModelElementClusterExpression(modelElementExpressionOfSelectList,
					modelElementClusterExpression)) {
				throw new SpiFacilityQueryServiceException(SpiFacilityQueryServiceException.ERROR_CODE_UNSPECIFIED,
						BQLBugMessages.MODELELEMENTEXPRESSIONS_IN_SELECTLISTS_MUST_BE_PART_OF_THE_ROOT_MODELELEMENTCLUSTEREXPRESSION);
			}
		}
	}

	/**
	 * Checks whether a ModelElementExpression is part of a
	 * ModelElementClusterExpression
	 * 
	 * @param modelElementExpression
	 * @param modelElementClusterExpression
	 * @return true if the model element expression is part of the cluster,
	 *         otherwise false
	 */
	private boolean isModelElementExpressionInModelElementClusterExpression(SpiModelElementExpression modelElementExpression,
			SpiModelElementClusterExpression modelElementClusterExpression) {

		SpiModelElementExpression headerModelElementExpression = modelElementClusterExpression.getHeaderModelElementExpression();
		List<SpiModelElementExpression> additionalModelElementExpressions = modelElementClusterExpression
				.getAdditionalModelElementExpressions();
		if (modelElementExpression == headerModelElementExpression) {
			return true;
		}
		if (additionalModelElementExpressions != null) {
			int additionalModelElements = additionalModelElementExpressions.size();
			for (int numAddModElements = 0; numAddModElements < additionalModelElements; numAddModElements++) {
				if (modelElementExpression == additionalModelElementExpressions.get(numAddModElements)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Checks that attribute comparisons to attributes refer to model elements
	 * in the same cluster.
	 * 
	 * @param attributeExpression
	 *            attribute expression
	 * @param modelElementClusterExpression
	 *            model element cluster expression
	 */
	private void checkAttributeExpressionInClusterConsistency(SpiAttributeExpression attributeExpression,
			SpiModelElementClusterExpression modelElementClusterExpression) {

		if (attributeExpression instanceof SpiMultinaryExpression) {
			SpiMultinaryExpression multinaryExpression = (SpiMultinaryExpression) attributeExpression;
			List operands = multinaryExpression.operands;
			int size = operands.size();
			for (int i = 0; i < size; i++) {
				this.checkAttributeExpressionInClusterConsistency((SpiAttributeExpression) operands.get(i), modelElementClusterExpression);
			}
		}

		if (attributeExpression instanceof SpiAttributeToAttributeComparisonExpression) {
			SpiAttributeToAttributeComparisonExpression attributeToAttributeComparisonExpression = (SpiAttributeToAttributeComparisonExpression) attributeExpression;
			SpiAttributeInModelElement comparedAttributeInModelElement = attributeToAttributeComparisonExpression
					.getComparedAttributeInModelElement();
			if (!this.isModelElementExpressionInModelElementClusterExpression(comparedAttributeInModelElement.getModelElementExpression(),
					modelElementClusterExpression)) {
				StringBuffer sb = new StringBuffer();
				attributeExpression.toString(sb, 0, false);
				throw new SpiFacilityQueryServiceException(SpiFacilityQueryServiceException.ERROR_CODE_UNSPECIFIED,
						BQLBugMessages.ATTRIBUTE_CANNOT_BE_COMPARED_TO_AN_ATTRIBUTE_IN_ANOTHER_CLUSTER_ATTRIBUTE_EXPRESSION, sb);
			}
		}
	}

	/**
	 * Checks the consistency of a cluster and the consistency of all child
	 * clusters recursively. Checks that attribute comparisons refer only to the
	 * same cluster. Checks that cluster internal links are really internal.
	 * Does the check for all child clusters recursively.
	 * 
	 * @param modelElementClusterExpression
	 */
	private void checkModelElementClusterConsistency(SpiModelElementClusterExpression modelElementClusterExpression,
			Set<SpiModelElementClusterExpression> checkedClusters) {

		// check whether this cluster has been checked before
		if (checkedClusters.contains(modelElementClusterExpression)) {
			throw new SpiFacilityQueryServiceException(SpiFacilityQueryServiceException.ERROR_CODE_UNSPECIFIED,
					BQLBugMessages.FOUND_LOOP_IN_THE_HIERARCHY_OF_THE_MODEL_ELEMENT_CLUSTER_EXPRESSIONS, modelElementClusterExpression
							.getHeaderModelElementExpression().getAlias());
		}
		// remember that this cluster was checked
		checkedClusters.add(modelElementClusterExpression);

		// do the attribute comparison check for all model element expressions
		SpiModelElementExpression modelElementExpression = modelElementClusterExpression.getHeaderModelElementExpression();
		this.checkModelElementExpressionConsistency(modelElementExpression);
		this.checkAttributeExpressionInClusterConsistency(modelElementExpression.getAttributeExpression(), modelElementClusterExpression);
		List<SpiModelElementExpression> additionModelElementExpressions = modelElementClusterExpression
				.getAdditionalModelElementExpressions();
		for (int i = 0; i < additionModelElementExpressions.size(); i++) {
			modelElementExpression = additionModelElementExpressions.get(i);
			this.checkModelElementExpressionConsistency(modelElementExpression);
			this.checkAttributeExpressionInClusterConsistency(modelElementExpression.getAttributeExpression(),
					modelElementClusterExpression);
		}

		// Check the cluster internal links
		List<SpiClusterInternalLinkExpression> clusterInternalLinks = modelElementClusterExpression.getClusterInternalLinks();
		for (int i = 0; i < clusterInternalLinks.size(); i++) {
			SpiClusterInternalLinkExpression clusterInternalLinkExpression = clusterInternalLinks.get(i);
			SpiModelElementExpression fromModelElementExpression = clusterInternalLinkExpression.getFromModelElementExpression();
			this.isModelElementExpressionInModelElementClusterExpression(fromModelElementExpression, modelElementClusterExpression);
			SpiModelElementExpression toModelElementExpression = clusterInternalLinkExpression.getLinkTarget();
			this.isModelElementExpressionInModelElementClusterExpression(toModelElementExpression, modelElementClusterExpression);
		}

		// Check the cluster external links
		List<SpiClusterExternalLinkExpression> clusterExternalLinks = modelElementClusterExpression.getClusterExternalLinks();
		for (int i = 0; i < clusterExternalLinks.size(); i++) {
			SpiClusterExternalLinkExpression clusterExternalLinkExpression = clusterExternalLinks.get(i);
			SpiModelElementExpression fromModelElementExpression = clusterExternalLinkExpression.getFromModelElementExpression();
			this.isModelElementExpressionInModelElementClusterExpression(fromModelElementExpression, modelElementClusterExpression);
			SpiModelElementClusterExpression toModelElementClusterExpressison = clusterExternalLinkExpression.getLinkTarget();
			this.checkModelElementClusterConsistency(toModelElementClusterExpressison, checkedClusters);
		}
	}

	/**
	 * Checks the consistency of a cluster and the consistency of all child
	 * clusters recursively. Checks that attribute comparisons refer only to the
	 * same cluster. Checks that cluster internal links are really internal.
	 * Does the check for all child clusters recursively.
	 * 
	 * @param modelElementClusterExpression
	 */
	private void checkModelElementExpressionConsistency(SpiModelElementExpression modelElementExpression) {

		// fixed sets
		if (modelElementExpression.getElements() != null) {
			// no types set
			if (modelElementExpression.getTypes() != null ||
			// no partition expression set
					modelElementExpression.getPartitionExpression() != null) {
				throw new SpiFacilityQueryServiceException(
						SpiFacilityQueryServiceException.ERROR_CODE_UNSPECIFIED,
						BQLBugMessages.MODELELEMENTEXPRESSION_INCONSISTENCY_TYPES_AND_PARTITIONEXPRESSION_SET_NOT_ALLOWED_IN_CASE_ELEMENTS_ARE_SET);
			}

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sap.tc.moin.repository.spi.facility.basicquery.BasicQueryProcessor
	 * #execute(com.sap.tc.moin.repository.Connection,
	 * com.sap.tc.moin.repository.spi.facility.basicquery.SelectExpression,
	 * com.sap.tc.moin.repository.PRI[], int)
	 */
	abstract public SpiFqlQueryResultSet execute(EmfHelper _emfHelper, SpiFacilityQueryClientScope queryClientScope,
			SpiSelectExpression selectExpression, int maxResultSetSize, int numberOfRequestedRows);

	public SpiFqlQueryResultSet execute(SpiFacilityQueryClientScope queryClientScope, SpiFqlQuery iqlQuery, int maxResultSetSize,
			int numberOfRequestedRows) {

		throw new LocalizedBaseRuntimeException(BQLBugMessages.FQLDEPRECATED);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sap.tc.moin.repository.spi.facility.basicquery.BasicQueryProcessor
	 * #getFacilityId()
	 */
	public String getFacilityId() {

		return facilityId;
	}

}