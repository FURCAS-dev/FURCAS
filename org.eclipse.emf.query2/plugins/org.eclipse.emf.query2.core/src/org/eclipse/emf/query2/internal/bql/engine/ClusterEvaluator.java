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
package org.eclipse.emf.query2.internal.bql.engine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query2.internal.bql.api.SpiAnd;
import org.eclipse.emf.query2.internal.bql.api.SpiAttributeExpression;
import org.eclipse.emf.query2.internal.bql.api.SpiAttributeInModelElement;
import org.eclipse.emf.query2.internal.bql.api.SpiAttributeToAttributeComparisonExpression;
import org.eclipse.emf.query2.internal.bql.api.SpiClusterExternalLinkExpression;
import org.eclipse.emf.query2.internal.bql.api.SpiLeafExpression;
import org.eclipse.emf.query2.internal.bql.api.SpiLike;
import org.eclipse.emf.query2.internal.bql.api.SpiModelElementClusterExpression;
import org.eclipse.emf.query2.internal.bql.api.SpiModelElementExpression;
import org.eclipse.emf.query2.internal.bql.api.SpiMultinaryExpression;
import org.eclipse.emf.query2.internal.bql.api.SpiOr;
import org.eclipse.emf.query2.internal.bql.api.SpiSelectExpression;
import org.eclipse.emf.query2.internal.bql.api.SpiSelectList;
import org.eclipse.emf.query2.internal.bql.api.SpiSimpleComparisonExpression;
import org.eclipse.emf.query2.internal.fql.SpiFqlComparisonOperation;
import org.eclipse.emf.query2.internal.fql.SpiFqlQueryResultSet;
import org.eclipse.emf.query2.internal.index.SpiFacilityQueryServiceException;
import org.eclipse.emf.query2.internal.messages.ApiMessages;
import org.eclipse.emf.query2.internal.messages.BugMessages;
import org.eclipse.emf.query2.internal.moinql.ast.QueryResultSetImpl;
import org.eclipse.emf.query2.internal.shared.AuxServices;
import org.eclipse.emf.query2.internal.shared.BugException;
import org.eclipse.emf.query2.internal.shared.EmfHelper;

/**
 * The cluster evaluator provides the functionalty to evaluate a nested model element cluster expression.
 * 
 * @author D029158
 * @version 27.02.2006
 */
public final class ClusterEvaluator {

	private static final int MAXIMUM_STACK_SIZE = 10;

	private static Stack<List<Object>> valuesListCache = new Stack<List<Object>>();

	//    private CoreConnection connection;

	private HashSet<URI> partitionScopeSet;

	private EmfHelper emfHelper;

	public ClusterEvaluator(EmfHelper _emfHelper, URI[] partitionScope) {

		//        this.connection = conn;
		this.emfHelper = _emfHelper;
		this.partitionScopeSet = new HashSet<URI>();
		for (int i = 0; i < partitionScope.length; i++) {
			this.partitionScopeSet.add(partitionScope[i]);
		}
	}

	private static List<Object> getReusableList() {

		synchronized (valuesListCache) {
			if (valuesListCache.isEmpty()) {
				return new ArrayList<Object>();
			} else {
				return valuesListCache.pop();
			}
		}
	}

	private static void reuseList(List<Object> list) {

		// empty list
		synchronized (valuesListCache) {
			if (valuesListCache.size() < MAXIMUM_STACK_SIZE) {
				for (int i = list.size() - 1; i >= 0; i--) {
					list.remove(i);
				}
				valuesListCache.push(list);
			}
		}
	}

	public SpiFqlQueryResultSet evaluateCluster(SpiSelectExpression selectExpression, int maxResultSetSize, int numberOfRequestedRows) {

		return (SpiFqlQueryResultSet) this.evaluateClusterAuxiliary(selectExpression, maxResultSetSize, numberOfRequestedRows);
	}

	/**
	 * Evaluates model element cluster. If the parameter clusterObject is an instance of SelectExpression then this method returns the
	 * appropriate result set If the parameter clusterObject is an instance of ModelElementClusterExpression then this method returns a List
	 * of Objects
	 * 
	 * @param clusterObject
	 *            select expression or model element cluster expression
	 * @return BasicQueryResult if clusterObject represents a root model element cluster expression, otherwise list of Objects
	 */
	@SuppressWarnings( { "unchecked" })
	private Object evaluateClusterAuxiliary(Object clusterObject, int maxResultSetSize, int numberOfRequestedRows) {

		boolean isRoot;
		SpiSelectExpression selectExpression = null;
		SpiModelElementClusterExpression modelElementClusterExpression = null;
		// local variables for the case that clusterObject is the root cluster
		SpiFqlQueryResultSet resultSet = null;
		SpiSelectList[] selectLists = null;
		// local variables for the case that clusterObject is not the root cluster
		List<Object> resultList = null;

		if (clusterObject instanceof SpiSelectExpression) {
			isRoot = true;
			selectExpression = (SpiSelectExpression) clusterObject;
			modelElementClusterExpression = selectExpression.getModelElementClusterExpression();

			selectLists = selectExpression.getSelectLists();
			int[] numberOfSelectedAttributesPerList = new int[selectLists.length];
			for (int i = 0; i < selectLists.length; i++) {
				numberOfSelectedAttributesPerList[i] = selectLists[i].getNumberOfAttributeDefinitions();
			}
			resultSet = new QueryResultSetImpl(numberOfSelectedAttributesPerList);
		} else if (clusterObject instanceof SpiModelElementClusterExpression) {
			isRoot = false;
			modelElementClusterExpression = (SpiModelElementClusterExpression) clusterObject;
			resultList = new ArrayList();
		} else {
			throw new BugException(BugMessages.NO_SUCH_OBJECT_TYPE, clusterObject.getClass().getName());
		}

		// pre-calculated scope map
		Map<SpiClusterExternalLinkExpression, Set<URI>> scopeMap = new IdentityHashMap<SpiClusterExternalLinkExpression, Set<URI>>();

		// Evaluate child model element cluster expressions recursively
		List<SpiClusterExternalLinkExpression> clusterExternalLinks = modelElementClusterExpression.getClusterExternalLinks();
		int numberOfClusterExternalLinks = clusterExternalLinks.size();
		EObject[][] childClusterResults = new EObject[numberOfClusterExternalLinks][];
		for (int i = 0; i < numberOfClusterExternalLinks; i++) {
			SpiClusterExternalLinkExpression clusterExternalLinkExpression = clusterExternalLinks.get(i);
			SpiModelElementClusterExpression linkTarget = clusterExternalLinkExpression.getLinkTarget();
			List<Object> childClusterResultList = (List<Object>) this.evaluateClusterAuxiliary(linkTarget, maxResultSetSize,
					maxResultSetSize + 1);
			// store the result as RefObject[]
			EObject[] childClusterResultArray = new EObject[childClusterResultList.size()];
			childClusterResultList.toArray(childClusterResultArray);
			childClusterResults[i] = childClusterResultArray;

			// get scope
			Set<URI> scope;

			// separate between fixed elements and the "normal" case
			if (clusterExternalLinkExpression.getLinkTargetElementsSet() == null) {

				Set<URI> scopeOfExternal = clusterExternalLinkExpression.getLinkTargetScopeSet();
				boolean scopeOfExternalIncluded = clusterExternalLinkExpression.getLinkTargetScopeIncluded();

				scope = (Set<URI>) this.partitionScopeSet.clone();
				scopeOfExternal = (scopeOfExternal == null ? Collections.<URI> emptySet() : scopeOfExternal);
				if (scopeOfExternalIncluded) {
					scope.retainAll(scopeOfExternal);
				} else {
					scope.removeAll(scopeOfExternal);
				}
			} else {
				scope = new HashSet<URI>();
				Set<URI> elements = clusterExternalLinkExpression.getLinkTargetElementsSet();
				for (URI mri : elements) {
					scope.add(mri.trimFragment());
				}
			}

			scopeMap.put(clusterExternalLinkExpression, scope);
		}

		// create navigation plan
		ClusterNavigationPlan clusterNavigationPlan = new ClusterNavigationPlan(this.emfHelper, this.partitionScopeSet,
				modelElementClusterExpression);

		// we should not pass the threshold
		boolean keepObtainingTuples = true;

		while (keepObtainingTuples && clusterNavigationPlan.nextTuple()) {
			if (!this.evaluateClusterExternalLinks(clusterNavigationPlan, modelElementClusterExpression, childClusterResults, scopeMap)) {
				continue;
			}
			if (!this.evaluateAttributeComparisons(clusterNavigationPlan, modelElementClusterExpression)) {
				continue;
			}
			//			if (!this.evaluateAttributes(clusterNavigationPlan, modelElementClusterExpression)) {
			//				continue;
			//			}

			if (isRoot) {
				// new entry in the result set
				int resultSetPos = resultSet.addEmptyEntry();
				for (int i = 0; i < selectLists.length; i++) {
					SpiSelectList currentSelectList = selectLists[i];
					int modelElementExpressionNumber = modelElementClusterExpression
							.getIndexOfModelElementExpressionInCluster(currentSelectList.getModelElementExpression());
					EObject currentObject = clusterNavigationPlan.getTupleElement(modelElementExpressionNumber);
					//                    if ( currentObject instanceof RefObject ) {
					resultSet.setMri(resultSetPos, i, EcoreUtil.getURI(currentObject));
					//                    } else if ( currentObject instanceof RefStruct ) {
					//                        // RefStructs don't have a real identifier
					//                        resultSet.setMri( resultSetPos, i, null );
					//                    } else {
					//                        throw new MQLBugException( MQLBugMessages.NO_SUCH_OBJECT_TYPE, currentObject.getClass( ).getName( ) );
					//                    }
					int numberOfAttributesInSelectList = currentSelectList.getNumberOfAttributeDefinitions();
					for (int attrNum = 0; attrNum < numberOfAttributesInSelectList; attrNum++) {
						Object attributeValue = getAttrOrFieldValue(this.emfHelper, currentObject, currentSelectList
								.getAttributeId(attrNum));
						if (attributeValue != null) {
							if (attributeValue instanceof Collection) {
								// multi-valued
								resultSet.setAttributeValue(resultSetPos, i, attrNum, ((Collection) attributeValue).toArray());
							} else {
								// single value
								resultSet.setAttributeValue(resultSetPos, i, attrNum, attributeValue);
							}
						}
					}
				}
				// we stop calculating results once we are over the number of requested rows
				keepObtainingTuples = resultSetPos + 1 < numberOfRequestedRows;

				// check if the sub-result does not become too large to avoid memory problems
				if (keepObtainingTuples && (resultSetPos + 1) > maxResultSetSize) {
					throw new SpiFacilityQueryServiceException(SpiFacilityQueryServiceException.ERROR_CODE_RESULTSET_TOO_LARGE,
							ApiMessages.RESULTSET_TOO_LARGE);
				}

			} else {
				// is child cluster, fill result list
				resultList.add(clusterNavigationPlan.getTupleElement(0));
				// check if the sub-result does not become too large to avoid memory problems
				if (resultList.size() > maxResultSetSize) {
					throw new SpiFacilityQueryServiceException(SpiFacilityQueryServiceException.ERROR_CODE_RESULTSET_TOO_LARGE,
							ApiMessages.RESULTSET_TOO_LARGE);
				}
			}
		}

		if (isRoot) {
			return resultSet;
		} else {
			return resultList;
		}
	}

	private boolean evaluateAttributeComparisons(ClusterNavigationPlan clusterNavigationPlan,
			SpiModelElementClusterExpression modelElementClusterExpression) {

		// check the attribute conditions for every model element expression in the cluster
		int clusterSize = modelElementClusterExpression.getTotalNumberOfModelElementExpressions();
		for (int i = 0; i < clusterSize; i++) {
			SpiModelElementExpression currentModelElementExpression = modelElementClusterExpression.getModelElementExpression(i);
			SpiAttributeExpression currentAttributeExpression = currentModelElementExpression.getAttributeExpression();
			EObject currentObject = clusterNavigationPlan.getTupleElement(i);
			if (currentAttributeExpression != null) {
				if (currentAttributeExpression instanceof SpiAttributeToAttributeComparisonExpression) {
					SpiAttributeToAttributeComparisonExpression leafExpression = (SpiAttributeToAttributeComparisonExpression) currentAttributeExpression;
					Object currentAttributeValue = getAttrOrFieldValue(this.emfHelper, currentObject, leafExpression.getAttributeId());

					List<Object> currentAttributeValueList = convertAttributeValueToReusableList(currentAttributeValue);
					int currentAttributeValueSize = currentAttributeValueList.size();
					SpiAttributeToAttributeComparisonExpression attributeToAttributeComparisonExpression = (SpiAttributeToAttributeComparisonExpression) leafExpression;
					SpiAttributeInModelElement attributeInModelElement = attributeToAttributeComparisonExpression
							.getComparedAttributeInModelElement();
					SpiModelElementExpression comparedModelElementExpression = attributeInModelElement.getModelElementExpression();
					int comparedModelElementExpressionNumber = modelElementClusterExpression
							.getIndexOfModelElementExpressionInCluster(comparedModelElementExpression);
					EObject comparedObject = clusterNavigationPlan.getTupleElement(comparedModelElementExpressionNumber);
					String comparedAttributeId = attributeInModelElement.getAttributeId();
					Object comparedAttributeValue = getAttrOrFieldValue(this.emfHelper, comparedObject, comparedAttributeId);
					List<Object> comparedAttributeValueList = convertAttributeValueToReusableList(comparedAttributeValue);
					for (int j = 0; j < currentAttributeValueSize; j++) {
						if (compareSimpleObjectToSetOfSimpleObjects(currentAttributeValueList.get(j), comparedAttributeValueList,
								attributeToAttributeComparisonExpression.getOperator())) {
							reuseList(currentAttributeValueList);
							reuseList(comparedAttributeValueList);
							return true;
						}
					}
					reuseList(currentAttributeValueList);
					reuseList(comparedAttributeValueList);
					return false;
				}
			}
		}
		// all evaluations successful
		return true;
	}

	public static boolean evaluateAttributesExceptAttrComparisons(EmfHelper emfHelper, EObject currentObject,
			SpiAttributeExpression attributeExpression) {

		if (attributeExpression == null) {
			return true;
		}

		if (attributeExpression instanceof SpiMultinaryExpression) {
			SpiMultinaryExpression multinaryExpression = (SpiMultinaryExpression) attributeExpression;
			Iterator<?> it = multinaryExpression.getOperands();
			if (multinaryExpression instanceof SpiAnd) {
				while (it.hasNext()) {
					SpiAttributeExpression childAttributeExpression = (SpiAttributeExpression) it.next();
					if (!evaluateAttributesExceptAttrComparisons(emfHelper, currentObject, childAttributeExpression)) {
						return false;
					}
				}
				return true;
			} else if (multinaryExpression instanceof SpiOr) {
				while (it.hasNext()) {
					SpiAttributeExpression childAttributeExpression = (SpiAttributeExpression) it.next();
					if (evaluateAttributesExceptAttrComparisons(emfHelper, currentObject, childAttributeExpression)) {
						return true;
					}
				}
				return false;
			} else {
				throw new BugException(BugMessages.NO_SUCH_MULTINARY_ATTRIBUTE_EXPRESSION_TYPE, multinaryExpression.getClass().getName());
			}
		} else if (attributeExpression instanceof SpiLeafExpression) {
			SpiLeafExpression leafExpression = (SpiLeafExpression) attributeExpression;
			Object currentAttributeValue = getAttrOrFieldValue(emfHelper, currentObject, leafExpression.getAttributeId());

			List<Object> currentAttributeValueList = convertAttributeValueToReusableList(currentAttributeValue);
			int currentAttributeValueSize = currentAttributeValueList.size();
			if (leafExpression instanceof SpiSimpleComparisonExpression) {
				SpiSimpleComparisonExpression simpleComparisonExpression = (SpiSimpleComparisonExpression) leafExpression;
				for (int i = 0; i < currentAttributeValueSize; i++) {
					if (AuxServices.compareValues(currentAttributeValueList.get(i), simpleComparisonExpression.getOperator(),
							simpleComparisonExpression.getValue())) {
						reuseList(currentAttributeValueList);
						return true;
					}
				}
				reuseList(currentAttributeValueList);
				return false;
			} else if (leafExpression instanceof SpiLike) {
				SpiLike likeExpression = (SpiLike) leafExpression;
				for (int i = 0; i < currentAttributeValueSize; i++) {
					if (evaluateLikeOperation(currentAttributeValueList.get(i), likeExpression)) {
						reuseList(currentAttributeValueList);
						return true;
					}
				}
				reuseList(currentAttributeValueList);
				return false;
			} else if (leafExpression instanceof SpiAttributeToAttributeComparisonExpression) {
				return true;
			} else {
				throw new BugException(BugMessages.NO_SUCH_LEAF_EXPRESSION_TYPE, leafExpression.getClass().getName());
			}
		} else {
			throw new BugException(BugMessages.NO_SUCH_ATTRIBUTE_EXPRESSION_TYPE, attributeExpression.getClass().getName());
		}
	}

//	private boolean evaluateAttributes(ClusterNavigationPlan clusterNavigationPlan,
//			SpiModelElementClusterExpression modelElementClusterExpression) {
//
//		// check the attribute conditions for every model element expression in the cluster
//		int clusterSize = modelElementClusterExpression.getTotalNumberOfModelElementExpressions();
//		for (int i = 0; i < clusterSize; i++) {
//			SpiModelElementExpression currentModelElementExpression = modelElementClusterExpression.getModelElementExpression(i);
//			SpiAttributeExpression currentAttributeExpression = currentModelElementExpression.getAttributeExpression();
//			EObject currentObject = clusterNavigationPlan.getTupleElement(i);
//			if (currentAttributeExpression != null
//					&& !this.evaluateAttributeExpression(clusterNavigationPlan, modelElementClusterExpression, currentObject,
//							currentAttributeExpression)) {
//				// for at least model element expression the attribute evaluation failed
//				return false;
//			}
//		}
//		// all evaluations successful
//		return true;
//	}
//
//	@SuppressWarnings("unchecked")
//	private boolean evaluateAttributeExpression(ClusterNavigationPlan clusterNavigationPlan,
//			SpiModelElementClusterExpression modelElementClusterExpression, EObject currentObject,
//			SpiAttributeExpression attributeExpression) {
//
//		if (attributeExpression instanceof SpiMultinaryExpression) {
//			SpiMultinaryExpression multinaryExpression = (SpiMultinaryExpression) attributeExpression;
//			Iterator it = multinaryExpression.getOperands();
//			if (multinaryExpression instanceof SpiAnd) {
//				while (it.hasNext()) {
//					SpiAttributeExpression childAttributeExpression = (SpiAttributeExpression) it.next();
//					if (!this.evaluateAttributeExpression(clusterNavigationPlan, modelElementClusterExpression, currentObject,
//							childAttributeExpression)) {
//						return false;
//					}
//				}
//				return true;
//			} else if (multinaryExpression instanceof SpiOr) {
//				while (it.hasNext()) {
//					SpiAttributeExpression childAttributeExpression = (SpiAttributeExpression) it.next();
//					if (this.evaluateAttributeExpression(clusterNavigationPlan, modelElementClusterExpression, currentObject,
//							childAttributeExpression)) {
//						return true;
//					}
//				}
//				return false;
//			} else {
//				throw new BugException(BugMessages.NO_SUCH_MULTINARY_ATTRIBUTE_EXPRESSION_TYPE, multinaryExpression.getClass().getName());
//			}
//		} else if (attributeExpression instanceof SpiLeafExpression) {
//			SpiLeafExpression leafExpression = (SpiLeafExpression) attributeExpression;
//			Object currentAttributeValue = getAttrOrFieldValue(this.emfHelper, currentObject, leafExpression.getAttributeId());
//
//			List<Object> currentAttributeValueList = convertAttributeValueToReusableList(currentAttributeValue);
//			int currentAttributeValueSize = currentAttributeValueList.size();
//			if (leafExpression instanceof SpiSimpleComparisonExpression) {
//				SpiSimpleComparisonExpression simpleComparisonExpression = (SpiSimpleComparisonExpression) leafExpression;
//				for (int i = 0; i < currentAttributeValueSize; i++) {
//					if (AuxServices.compareValues(currentAttributeValueList.get(i), simpleComparisonExpression.getOperator(),
//							simpleComparisonExpression.getValue())) {
//						reuseList(currentAttributeValueList);
//						return true;
//					}
//				}
//				reuseList(currentAttributeValueList);
//				return false;
//			} else if (leafExpression instanceof SpiLike) {
//				SpiLike likeExpression = (SpiLike) leafExpression;
//				for (int i = 0; i < currentAttributeValueSize; i++) {
//					if (this.evaluateLikeOperation(currentAttributeValueList.get(i), likeExpression)) {
//						reuseList(currentAttributeValueList);
//						return true;
//					}
//				}
//				reuseList(currentAttributeValueList);
//				return false;
//			} else if (leafExpression instanceof SpiAttributeToAttributeComparisonExpression) {
//				SpiAttributeToAttributeComparisonExpression attributeToAttributeComparisonExpression = (SpiAttributeToAttributeComparisonExpression) leafExpression;
//				SpiAttributeInModelElement attributeInModelElement = attributeToAttributeComparisonExpression
//						.getComparedAttributeInModelElement();
//				SpiModelElementExpression comparedModelElementExpression = attributeInModelElement.getModelElementExpression();
//				int comparedModelElementExpressionNumber = modelElementClusterExpression
//						.getIndexOfModelElementExpressionInCluster(comparedModelElementExpression);
//				EObject comparedObject = clusterNavigationPlan.getTupleElement(comparedModelElementExpressionNumber);
//				String comparedAttributeId = attributeInModelElement.getAttributeId();
//				Object comparedAttributeValue = getAttrOrFieldValue(this.emfHelper, comparedObject, comparedAttributeId);
//				List<Object> comparedAttributeValueList = convertAttributeValueToReusableList(comparedAttributeValue);
//				for (int i = 0; i < currentAttributeValueSize; i++) {
//					if (compareSimpleObjectToSetOfSimpleObjects(currentAttributeValueList.get(i), comparedAttributeValueList,
//							attributeToAttributeComparisonExpression.getOperator())) {
//						reuseList(currentAttributeValueList);
//						reuseList(comparedAttributeValueList);
//						return true;
//					}
//				}
//				reuseList(currentAttributeValueList);
//				reuseList(comparedAttributeValueList);
//				return false;
//			} else {
//				throw new BugException(BugMessages.NO_SUCH_LEAF_EXPRESSION_TYPE, leafExpression.getClass().getName());
//			}
//		} else {
//			throw new BugException(BugMessages.NO_SUCH_ATTRIBUTE_EXPRESSION_TYPE, attributeExpression.getClass().getName());
//		}
//	}

	/**
	 * Get the attribute value of a RefObject or RefStruct. If the value
	 * 
	 * @param object
	 *            object which is from type RefObject or RefStruct
	 * @return value of the object
	 */
	public static Object getAttrOrFieldValue(EmfHelper _emfHelper, EObject object, String attrId) {

		EStructuralFeature feature = object.eClass().getEStructuralFeature(attrId);
		Object attrValue = null;
		if (feature instanceof EAttribute) {
			attrValue = object.eGet(feature);
			//        if ( object instanceof RefObjectImpl ) {
			//            attrValue = ( (RefObjectImpl) object ).refGetValue( connection, attrId );
			//        } else if ( object instanceof RefStructImpl ) {
			//            attrValue = ( (RefStructImpl) object ).refGetValue( attrId );
		} else {
			throw new BugException(BugMessages.NO_SUCH_OBJECT_TYPE, object.getClass().getName());
		}

		return attrValue;
	}

	@SuppressWarnings("unchecked")
	private static List<Object> convertAttributeValueToReusableList(Object attributeValue) {

		List<Object> resultList = getReusableList();
		if (attributeValue instanceof List) {
			// multiple values in list
			List attrValueList = (List) attributeValue;
			for (int i = 0; i < attrValueList.size(); i++) {
				resultList.add(attrValueList.get(i));
			}
		} else if (attributeValue instanceof Collection) {
			// multiple values in collection
			Collection attrValueCollection = (Collection) attributeValue;
			Iterator it = attrValueCollection.iterator();
			while (it.hasNext()) {
				resultList.add(it.next());
			}
		} else {
			// one single String value
			resultList.add(attributeValue);
		}
		return resultList;
	}

	/**
	 * Compares simple object of type Integer, Long, Double or Float with a list of objects of the same type. This method returns true if
	 * there is at least one element in the
	 * 
	 * @param obj1
	 *            Integer, Long, Float or Double instance
	 * @param list
	 *            of Integer, Long, Float or Double instances
	 * @return true if at least one comparison returned true, otherwise false
	 */
	@SuppressWarnings("unchecked")
	private static boolean compareSimpleObjectToSetOfSimpleObjects(Object obj1, List objectList, SpiFqlComparisonOperation operator) {

		if (objectList == null || obj1 == null) {
			// no value
			return false;
		}
		int objectListSize = objectList.size();
		for (int i = 0; i < objectListSize; i++) {
			if (AuxServices.compareValues(obj1, operator, objectList.get(i))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks whether the current tuple of the cluster navigation plan fulfulls the cluster external link expressions
	 * 
	 * @param clusterNavigationPlan
	 *            cluster navigation plan containing the current tuple
	 * @param clusterExternalLinks
	 *            cluster external links that are to be checked
	 * @param childClusterResults
	 *            results of the child clusters that have to match the cluster external links
	 * @param scopeMap
	 * @return
	 */
	private boolean evaluateClusterExternalLinks(ClusterNavigationPlan clusterNavigationPlan,
			SpiModelElementClusterExpression modelElementClusterExpression, EObject[][] childClusterResults,
			Map<SpiClusterExternalLinkExpression, Set<URI>> scopeMap) {

		List<SpiClusterExternalLinkExpression> clusterExternalLinks = modelElementClusterExpression.getClusterExternalLinks();
		for (int i = 0; i < childClusterResults.length; i++) {
			EObject[] childClusterResult = childClusterResults[i];
			SpiClusterExternalLinkExpression clusterExternalLinkExpression = clusterExternalLinks.get(i);
			SpiModelElementExpression from = clusterExternalLinkExpression.getFromModelElementExpression();
			int fromNum = modelElementClusterExpression.getIndexOfModelElementExpressionInCluster(from);
			EObject currentObject = clusterNavigationPlan.getTupleElement(fromNum);
			//            if ( !( currentObject instanceof RefObject ) ) {
			//                throw new MQLBugException( MQLBugMessages.CLUSTER_EXTERNAL_LINK_WORK_ONLY_WITH_REFOBJECTS, currentObject.getClass( ).getName( ) );
			//            }

			// get scope
			Set<URI> scope = scopeMap.get(clusterExternalLinkExpression);

			// observe that it is impossible for a nested cluster to return struct elements
			EObject[] currentLinkedObjects = BasicQueryProcessorMemoryImpl.getLinkedObjects(this.emfHelper, currentObject,
					clusterExternalLinkExpression.getLinkType(), scope, clusterExternalLinkExpression.getLinkTargetTypesSet(),
					clusterExternalLinkExpression.getLinkTargetElementsSet());
			if (clusterExternalLinkExpression.isLinked()) {
				if (ClusterNavigationPlan.isIntersectionOfSetsIsEmpty(currentLinkedObjects, childClusterResult)) {
					return false;
				}
			} else {
				if (!ClusterNavigationPlan.isIntersectionOfSetsIsEmpty(currentLinkedObjects, childClusterResult)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Tries to match the pattern with the string value
	 * 
	 * @param val
	 * @return true if the pattern matches, otherwise false
	 */
	public static boolean evaluateLikeOperation(Object val, SpiLike spiLike) {

		if (val == null) {
			return (spiLike.isNegated() ? true : false);
		}
		String currentStringValue = null;
		if (val instanceof String) {
			String str = (String) val;
			currentStringValue = AuxServices.cutOffTrailingBlanks(str);
			currentStringValue = (str.length() > AuxServices.STRING_COMPARISON_MAX_LENGTH ? str.substring(0,
					AuxServices.STRING_COMPARISON_MAX_LENGTH - 1) : str);
		} else if (val instanceof Enumerator) {
			currentStringValue = ((Enumerator) val).toString();
		} else {
			throw new BugException(BugMessages.LIKE_COMPARISON_WITH_TYPES_OTHER_THAN_STRING_AND_LABELS_NOT_ALLOWED);
		}

		boolean positiveResult = matchesLikePattern(0, currentStringValue, 0, spiLike.getParseResult());

		return (spiLike.isNegated() ? !positiveResult : positiveResult);
	}

	/**
	 * Returns true if the substring of strValue starting with position aStrPos matches the pattern starting with aParseResultPos. This
	 * method is normally called in evaluate() for the evaluation of a string value with aParseResultPos = 0 and aStrPos = 0. The method
	 * checks the first sub string of the parse result. If the check was successful then this method is called recursively with the
	 * positions of the next sub string of the parse result.
	 * 
	 * @param aParseResultPos
	 *            position of the parse result from which the check is to be executed
	 * @param strValue
	 *            string value which is to be matched
	 * @param aStrPos
	 *            position of strValue from which the check is to be executed
	 * @return
	 */
	private static boolean matchesLikePattern(int aParseResultPos, String strValue, int aStrPos, Object[] parseResult) {

		int parseResultPos = aParseResultPos;
		int strPos = aStrPos;

		for (;;) {
			// termination conditions
			if (strPos > strValue.length()) {
				// string value end does not match
				return false;
			}
			if (parseResultPos == parseResult.length) {
				// end of parse result reached, check was successful if the end of the string value has been reached as
				// well.
				return (strPos == strValue.length());
			}

			// check next sub string of parse result
			Object currentParseResultObject = parseResult[parseResultPos];
			if (currentParseResultObject instanceof String) {
				// the current parse result sub string must match strValue beginning with strPos
				String currentSubString = (String) currentParseResultObject;
				int index = strValue.indexOf(currentSubString, strPos);
				if (index != strPos) {
					// currentSubString does not match strValue at its current position
					return false;
				} else {
					strPos += currentSubString.length();
					parseResultPos++;
					continue;
				}
			} else if (currentParseResultObject instanceof Integer) {
				int intValue = ((Integer) currentParseResultObject).intValue();
				int absIntValue = Math.abs(intValue);
				// there are absIntValue single arbitrary characters -> move the read position
				strPos += absIntValue;
				// already increment to the next the parse result position
				parseResultPos++;
				if (intValue <= 0) {
					// zero to n arbitrary characters
					if (parseResultPos == parseResult.length) {
						// no more pattern objects in parse result -> ready
						return true;
					} else {
						// next parse result object must be string
						String nextSubstring = (String) parseResult[parseResultPos];
						int index;
						while ((index = strValue.indexOf(nextSubstring, strPos)) != -1) {
							if (matchesLikePattern(parseResultPos, strValue, index, parseResult)) {
								// for at least one found index is the matching of the remaining parse result objects
								// successful
								return true;
							}
							strPos = index + 1;
						}
						// matching not successful
						return false;
					}
				}
			} else {
				throw new BugException(BugMessages.UNEXPECTED_OBJECT_TYPE_IN_PARSE_RESULT, currentParseResultObject.getClass().getName());
			}
		}
	}

}
