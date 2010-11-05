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
/*
 * Created on 27.02.2006
 */
package org.eclipse.emf.query2.internal.bql.engine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query2.internal.bql.api.SpiAbstractBasicQueryProcessor;
import org.eclipse.emf.query2.internal.bql.api.SpiAttributeExpression;
import org.eclipse.emf.query2.internal.bql.api.SpiSelectExpression;
import org.eclipse.emf.query2.internal.fql.SpiFqlQueryResultSet;
import org.eclipse.emf.query2.internal.index.SpiFacilityQueryClientScope;
import org.eclipse.emf.query2.internal.logger.LogSeverity;
import org.eclipse.emf.query2.internal.logger.LoggerFactory;
import org.eclipse.emf.query2.internal.logger.QueryLogger;
import org.eclipse.emf.query2.internal.messages.BugMessages;
import org.eclipse.emf.query2.internal.messages.FQLTraceMessages;
import org.eclipse.emf.query2.internal.shared.BugException;
import org.eclipse.emf.query2.internal.shared.EmfHelper;

/**
 * This implementation of
 * {@link org.eclipse.emf.query2.internal.bql.api.core.query.bql.api.moin.query.basicquery.spi.SpiBasicQueryProcessor} does not require that
 * the model elements which are relevant for the search are loaded in memory. Link traversal during the execution of the query can lead to
 * partition loading.
 */
public final class BasicQueryProcessorMemoryImpl extends SpiAbstractBasicQueryProcessor {

	// trace setup
	private static final QueryLogger logger = LoggerFactory.getLogger(BasicQueryProcessorMemoryImpl.class);

	/**
	 * This is the ID used for the in-memory BQL of the CORE
	 */
	private static final String MEMORY_ID = "_MEMORY_"; //$NON-NLS-1$

	public BasicQueryProcessorMemoryImpl() {

		super(MEMORY_ID);
	}

	/**
	 * Executes a BQL query in memory. This implementation requires that the partitionScope is inclusive. If a partition in the scope is not
	 * loaded, it will be loaded by this BQL processor.
	 */
	@Override
	public SpiFqlQueryResultSet execute(EmfHelper _emfHelper, SpiFacilityQueryClientScope queryClientScope,
			SpiSelectExpression selectExpression, int maxResultSetSize, int numberOfRequestedRows) {

		// CoreConnection connection = ( (CoreQueryClientScope) queryClientScope
		// ).getConnection( );

		long timeStamp = System.nanoTime();
		this.checkQueryConsistency(selectExpression);
		long time = 0;
		if (logger.isTraced(LogSeverity.DEBUG)) {
			time = (System.nanoTime() - timeStamp) / 1000000;
			logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_BQL_VERIFICATION_FINISHED, time);
		}

		if (logger.isTraced(LogSeverity.DEBUG)) {
			logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_BQL_MEMORY_ENGINE_CONSTRUCTS_CLUSTER);
		}

		if (!queryClientScope.isPartitionScopeInclusive()) {
			throw new BugException(BugMessages.UNEXPECTED_NON_INCLUSIVE_SCOPE_FOR_MEMORY_SCENARIO);
		}

		Set<URI> pris = queryClientScope.getPartitionsScope();
		ClusterEvaluator clusterEvaluator = new ClusterEvaluator(_emfHelper, pris.toArray(new URI[pris.size()]));
		if (logger.isTraced(LogSeverity.DEBUG)) {
			logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_BQL_MEMORY_ENGINE_EVALUATES_CLUSTER);
		}
		SpiFqlQueryResultSet basicQueryResultSet = clusterEvaluator.evaluateCluster(selectExpression, maxResultSetSize,
				numberOfRequestedRows);
		if (logger.isTraced(LogSeverity.DEBUG)) {
			logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_BQL_MEMORY_EXECUTION_DONE);
		}

		return basicQueryResultSet;
	}

	/**
	 * For a given fromObject, obtains all elements, associated with the it via the associationMRI (and indicated association end number),
	 * where we restrict the result set to the provided set of partitions. Storage can be on either side.
	 */
	public static EObject[] getLinkedObjects(EmfHelper emfHelper, EObject fromObject, URI assocMRI, Set<URI> priScope,
			Set<URI> mrisOfTypes, Set<URI> elements) {

		List<EObject> result;

		// sanity checks
		// if ( endNumberOfFromObject != 0 && endNumberOfFromObject != 1 ) {
		// throw new MQLBugException(
		// MQLBugMessages.UNEXPECTED_ASSOCIATION_END_NUMBER,
		// endNumberOfFromObject );
		// }
		// RefObject metaObject = (RefObject) connection.getElement( assocMRI );

		//		EReference metaObject = emfHelper.getReference(assocMRI);
		//		if (metaObject == null) {
		//			throw new BugException(BugMessages.LINK_TYPE_NOT_JMI_OBJECT, assocMRI);
		//		}

		// first check if we have storage on the start side.
		// boolean startAtStorageEnd;
		// if ( metaObject instanceof Attribute ) {
		// startAtStorageEnd = endNumberOfFromObject != 1;
		// } else
		// if ( metaObject instanceof Association ) {
		// SpiJmiHelper jmiHelper = connection.getCoreJmiHelper( );
		// List<AssociationEnd> associationEnds = jmiHelper.getAssociationEnds(
		// connection.getSession( ), (Association) metaObject );
		// startAtStorageEnd = jmiHelper.isEndStored( connection.getSession( ),
		// associationEnds.get( endNumberOfFromObject ) );
		// } else {
		// throw new MQLBugException(
		// MQLBugMessages.LINK_TYPE_NOT_ATTRIBUTE_OR_ASSOCIATION, assocMRI );
		// }

		// get refObjects on "other side"
		// Workspace workspace = ( (CorePartitionable) fromObject
		// ).get___Workspace( );
		// EndAndMetaObject endAndMetaObject = workspace.getWorkspaceSet(
		// ).getEndAndMetaObjectPool( ).getEndAndMetaObject(
		// endNumberOfFromObject, metaObject );

		// if ( startAtStorageEnd ) {
		// start at storage end
		Set<EClass> eclassTypes;
		if (mrisOfTypes != null) {
			eclassTypes = new HashSet<EClass>(mrisOfTypes.size()); // FIXME quick hack for performance
			for (URI uri : mrisOfTypes) {
				eclassTypes.add(emfHelper.getTypeElement(uri));
			}
		} else {
			eclassTypes = null;
		}
		result = getLinkedObjectsAndFilterByPartitions(emfHelper, fromObject, assocMRI, priScope, eclassTypes, elements);
		// } else {
		// // start at non-storage end
		// result = new ArrayList<RefObject>( );
		// for ( PRI pri : priScope ) {
		// // get workspace of partition in scope
		// Workspace partitionWorkspace = connection.getPartition( pri
		// ).getWorkspace( );
		//
		// // set this pri as the scope to be considered
		// Set<PRI> priAsScope = Collections.singleton( pri );
		//
		// // accumulate results for each pri in the scope
		// result.addAll( getLinkedObjectsAndFilterByPartitions( connection,
		// partitionWorkspace, (CorePartitionable) fromObject, endAndMetaObject,
		// false, priAsScope, mrisOfTypes, elements ) );
		// }
		// }

		return result.toArray(new EObject[result.size()]);
	}

	/**
	 * For the given fromObject, obtain all linked refObjects, where we know that the fromObject is handled by the provided workspace.
	 */
	private static List<EObject> getLinkedObjectsAndFilterByPartitions(EmfHelper emfHelper, EObject fromObject, URI referenceURI,
			Set<URI> priScope, Set<EClass> mrisOfTypes, Set<URI> elements) {

		List<EObject> result = null;
		EReference endAndMetaObject = emfHelper.getReference(referenceURI);

		if (fromObject.eClass().getEAllReferences().contains(endAndMetaObject)) {
			Object o = fromObject.eGet(endAndMetaObject, true);

			if (o == null) {
				result = Collections.emptyList();
			} else if (o instanceof List) {
				result = new ArrayList<EObject>();
				for (EObject eObject : (List<EObject>) o) {
					if (isInPartitionsOfTypeAndInElements(eObject, priScope, mrisOfTypes, elements)) {
						if (eObject.eIsProxy()) {
							eObject = emfHelper.resolve(eObject);
						}
						if (eObject != null) {
							result.add(eObject);
						}
					}
				}
			} else {
				EObject oppositeEObject = (EObject) o;
				if (isInPartitionsOfTypeAndInElements(oppositeEObject, priScope, mrisOfTypes, elements)) {
					if (oppositeEObject.eIsProxy()) {
						oppositeEObject = emfHelper.resolve(oppositeEObject);
					}
					if (oppositeEObject != null) {
						result = Collections.singletonList(oppositeEObject);
					} else {
						result = Collections.emptyList();
					}
				}
			}
		} else {

			EReference opposite = endAndMetaObject.getEOpposite();
			if (opposite != null) {
				Object oppositeObject = fromObject.eGet(opposite, true);

				if (oppositeObject instanceof EObject) {
					EObject oppositeEObject = (EObject) oppositeObject;
					if (isInPartitionsOfTypeAndInElements(oppositeEObject, priScope, mrisOfTypes, elements)) {
						if (oppositeEObject.eIsProxy()) {
							oppositeEObject = emfHelper.resolve(oppositeEObject);
						}
						if (oppositeEObject != null) {
							result = Collections.singletonList(oppositeEObject);
						} else {
							result = Collections.emptyList();
						}
					}
				} else if (oppositeObject instanceof List) {
					result = new ArrayList<EObject>();
					for (EObject eObject : (List<EObject>) oppositeObject) {
						if (isInPartitionsOfTypeAndInElements(eObject, priScope, mrisOfTypes, elements)) {
							if (eObject.eIsProxy()) {
								eObject = emfHelper.resolve(eObject);
							}
							if (eObject != null) {
								result.add(eObject);
							}
						}
					}
				}
			} else {
				result = emfHelper.getReferringElementsWithTypeAndInScope(fromObject, referenceURI, priScope, mrisOfTypes, elements);
			}
		}

		if (result == null) {
			result = Collections.emptyList();
		}

		return result;
	}

	/**
	 * Checks if the provide object is in the element set if it is provided or not empty, otherwise, check if it has the right type and
	 * finally, check if it is in scope.
	 */
	public static boolean isInPartitionsOfTypeAndInElements(EObject object, Set<URI> priScope, Set<EClass> mrisOfTypes, Set<URI> elements) {

		// don't forget Reflect::Element
		boolean toBeKept = mrisOfTypes == null || mrisOfTypes.isEmpty() || mrisOfTypes.contains(object.eClass());

		// if not, we have to verify the type
		if (toBeKept) {
			// we keep the element if it exists in the fixed element set
			URI objectUri = EcoreUtil.getURI(object);
			toBeKept = elements == null || elements.isEmpty() || elements.contains(objectUri);

			if (toBeKept) {
				// if of correct type, then check for partition in scope
				toBeKept = (priScope != null ? priScope.contains(objectUri.trimFragment()) : false);
			}
		}

		return toBeKept;
	}

	/**
	 * gets the objects of all provided types within the provided priScope. If a fixed element set is provided, only return objects from
	 * that set.
	 */
	public static EObject[] getObjectsOfTypeInPartitions(EmfHelper _emfHelper, Set<URI> priScope, Set<URI> mrisOfTypes, Set<URI> elements,
			SpiAttributeExpression attributeExpression) {

		List<EObject> result = new ArrayList<EObject>();

		// filter for the partition, the types, and the element set
		for (URI pri : priScope) {
			// potentially load the partition
			// CoreModelPartition modelPartition = (CoreModelPartition)
			// connection.getPartition( pri );
			Resource modelPartition = _emfHelper.getResource(pri);

			// SANITY CHECK
			if (modelPartition == null) {
				throw new BugException(BugMessages.PRI_DOES_NOT_EXIST, pri);
			}

			Collection<EObject> possibleResultElements;

			// if we have a fixed set of provided elements, the possible result
			// elements are only those which
			// are also in the set of fixed elements
			if (elements != null && elements.size() > 0) {
				possibleResultElements = new LinkedHashSet<EObject>();
				for (URI elementMri : elements) {
					// only add if PRI is identical
					if (elementMri.trimFragment().equals(pri)) {
						possibleResultElements.add(_emfHelper.getElement(elementMri));
					}
				}
			} else {
				possibleResultElements = _emfHelper.getElementsInResource(modelPartition);
			}

			Set<EClass> mriEclassSet = null;
			if (possibleResultElements.size() > 0 && mrisOfTypes != null && mrisOfTypes.size() != 0) {
				mriEclassSet = new HashSet<EClass>(mrisOfTypes.size());
				for (URI uri : mrisOfTypes) {
					mriEclassSet.add(_emfHelper.getTypeElement(uri));
				}
			}

			// for all possible elements, only consider the refObjects, which
			// have the "right" type.
			for (EObject refObject : possibleResultElements) {
				// if ( object instanceof RefObject ) {
				// RefObject refObject = (RefObject) object;

				// check for the type (unless we are dealing with
				// Reflect::Element)
				// MRI mriOfType = ( (Partitionable) refObject.refMetaObject( )
				// ).get___Mri( );
				//				URI mriOfType = getUri(refObject.eClass());
				//				if (mrisOfTypes == null || mrisOfTypes.isEmpty() || mrisOfTypes.contains(mriOfType)) {
				if (mriEclassSet == null || mriEclassSet.contains(refObject.eClass())) {
					if (ClusterEvaluator.evaluateAttributesExceptAttrComparisons(_emfHelper, refObject, attributeExpression))
						result.add(refObject);
				}
				// }
			}
		}

		return result.toArray(new EObject[result.size()]);
	}

	private static Map<EClass, URI> typeUris = new WeakHashMap<EClass, URI>(256);

	private static synchronized URI getUri(EClass eClass) {
		URI result = typeUris.get(eClass);
		if (result == null) {
			typeUris.put(eClass, result = EcoreUtil.getURI(eClass));
		}
		return result;
	}
}