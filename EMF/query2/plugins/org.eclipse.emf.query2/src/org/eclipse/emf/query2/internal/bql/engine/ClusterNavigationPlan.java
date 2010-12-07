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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import javax.print.attribute.UnmodifiableSetException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.query2.internal.bql.api.SpiAttributeExpression;
import org.eclipse.emf.query2.internal.bql.api.SpiClusterInternalLinkExpression;
import org.eclipse.emf.query2.internal.bql.api.SpiLinkExpression;
import org.eclipse.emf.query2.internal.bql.api.SpiModelElementClusterExpression;
import org.eclipse.emf.query2.internal.bql.api.SpiModelElementExpression;
import org.eclipse.emf.query2.internal.bql.api.SpiMriSetLinkExpression;
import org.eclipse.emf.query2.internal.fql.SpiFqlFromTypeCategory;
import org.eclipse.emf.query2.internal.messages.BugMessages;
import org.eclipse.emf.query2.internal.shared.BugException;
import org.eclipse.emf.query2.internal.shared.EmfHelper;

/**
 * The cluster navigation plan describes how the memory query implementation can navigate between the ModelElementExpression instances of a
 * cluster.
 * <p>
 * The cluster navigation plan is constructed from a model element cluster expression. During the initialization a navigation plan is
 * calculated which allows the user to iterate over the model element tuples fulfilling the cluster internal link expressions of the
 * cluster. The internal operating mode is described in the following.
 * <p>
 * The navigation plan is structured into several ordered navigation steps. A navigation step consists of a navigation source and a
 * navigation target each representing a model element expression in the cluster. Every navigation step allows the navigation from one model
 * element expression of the cluster to another model element expression of the cluster. The navigation plan defines one specific start
 * model element expression which is the source of the first navigation step.
 * <p>
 * In the initialization phase it is tried to find a combination of start model element expression and navigation steps that allows the
 * navigation from the start model element expression to each other model element expression in the cluster by navigating the navigation
 * steps according to the order of the steps. The calculation of the navigation plan takes into account that some association links can be
 * navigated in both directions while attribute links can be navigated only in one direction.
 * <p>
 * In the iteration phase every model element expression in the cluster is assigned a specific model element. These assignments alltogether
 * define a model element tuple in the cluster. The objective of the cluster navigation plan is to provide the means for users to iterate
 * over the model element tuples which fulfill the link expressions in the cluster. It is possible that the model element cluster expression
 * contains more link expression than required in order to create a navigation plan. In this case only a part of the link expressions in the
 * cluster are incorporated in the navigation steps. This means that tuples that are found by navigating the navigation steps have to be
 * checked whether they fulfill the other link expressions as well.
 * 
 * @author D029158
 * @version 27.02.2006
 */

public final class ClusterNavigationPlan {

	private static final int NAVIGATION_STEP_INITIAL_VALUE = -1;

	private static final int CURRENT_READ_MODEL_ELEMENT_INITIAL_VALUE = -1;

	//    private CoreConnection connection;
	private EmfHelper emfHelper;

	final private HashSet<URI> partitionScopeSet;

	private SpiModelElementClusterExpression modelElementClusterExpression;

	private boolean isTupleReadingInitialized = false;

	private int clusterSize;

	private int totalNavigationSteps;

	private int lastNavigationStep;

	private int startModelElementExpression;

	// navigation source for navigation steps as number of model element
	// expression
	private int[] navigationSource;

	// navigation target for navigation steps as number of model element
	// expression
	private int[] navigationTarget;

	// link expression of the navigation step
	private SpiLinkExpression[] navigationLinkExpression;

	// link direction
	private boolean[] navigationDirectionForward;

	// cluster internal links that are not contained in any navigation step
	private List<SpiLinkExpression> otherLinkExpressions = new ArrayList<SpiLinkExpression>();

	// current list of RefObjects or RefStructs for all model element expressions in the cluster
	private EObject[][] currentModelElementList;

	// positions of current model element for all model element expressions in
	// the cluster
	private int[] currentReadModelElement;

	// RefObjects of the link targets of the MriSetLinkExpressions
	private EObject[][] mriSetLinkExpressionsRefObjects = null;

	// For every MriSetLinkExpression: Set of RefObjects that are linked with at least one of the MriSetLink targets
	@SuppressWarnings("unchecked")
	private Set[] mriSetLinkExpressionsCalculatedLinkSet = null;

	// cache for other link sets
	private Map<URI, Map<Object, EObject[]>> linkCache = new HashMap<URI, Map<Object, EObject[]>>(15);

	public ClusterNavigationPlan(EmfHelper _emfHelper, HashSet<URI> partitionScopeSet,
			SpiModelElementClusterExpression modelElementClusterExpression) {

		//        this.connection = connection;
		this.emfHelper = _emfHelper;
		this.partitionScopeSet = partitionScopeSet;
		this.modelElementClusterExpression = modelElementClusterExpression;
		this.initialize();

		//		System.err.println("Direction: ");
		//		for (int i = 0; i < this.navigationDirectionForward.length; i++) {
		//			System.err.println("\t" + this.modelElementClusterExpression.getModelElementExpression(this.navigationSource[i]).getAlias()
		//					+ " " + this.navigationDirectionForward[i] + " "
		//					+ this.modelElementClusterExpression.getModelElementExpression(this.navigationTarget[i]).getAlias());
		//		}
		//		System.err.println();
	}

	// ///////////////////////////////////////////////////////////////////////////////////////////////
	// Initialization of the cluster navigation plan
	// ///////////////////////////////////////////////////////////////////////////////////////////////

	private void initialize() {

		// cache cluster size and the corresponding number of navigation steps
		this.clusterSize = this.modelElementClusterExpression.getTotalNumberOfModelElementExpressions();
		this.totalNavigationSteps = this.clusterSize - 1;
		this.lastNavigationStep = this.totalNavigationSteps - 1;
		// MriSetLinkExpressions work with MRI, convert the MRIs to RefObjects
		this.initializeMriSetLinkEvaluation();
		// initialize navigation steps
		this.initializeNavigationSteps();
		// try to create the navigation plan for different start model element
		// expressions if one navigation plan could be created then stop

		// we build a list of int where all fixed set MEEs come first (its value is the index in the cluster),
		// and the CLASS-based MEEs second. The STRUCTURE-based MEEs do not come at all. 
		// Atomic Entries which work on Reflect::Element are moved to the end
		List<Integer> preferredOrderOfStartElements = new ArrayList<Integer>();
		List<Integer> nonPreferredElements = new ArrayList<Integer>();
		for (int i = 0; i < this.clusterSize; i++) {
			SpiModelElementExpression modelElementExpression = this.modelElementClusterExpression.getModelElementExpression(i);

			if (modelElementExpression.getTypes() == null || modelElementExpression.getTypes().length == 0) {
				// Reflect::Element is moved to the back
				nonPreferredElements.add(i);
			} else {

				// if a fixed set, then add at the front, otherwise, if it is CLASS-based at the end
				if (modelElementExpression.hasElements()) {
					preferredOrderOfStartElements.add(0, i);
				} else if (SpiFqlFromTypeCategory.CLASS.equals(modelElementExpression.getModelElementCategory())) {
					preferredOrderOfStartElements.add(i);
				}
			}
		}

		// move the nonPreferredElements to the preferredElements
		preferredOrderOfStartElements.addAll(nonPreferredElements);

		// now search for a start element and build navigation plan
		boolean foundNavigationPlan = false;

		for (Iterator<Integer> iter = preferredOrderOfStartElements.iterator(); !foundNavigationPlan && iter.hasNext();) {
			int index = iter.next();

			// assume we find a navigation plan until proven otherwise
			foundNavigationPlan = true;

			this.startModelElementExpression = index;
			this.clearNavigationSteps();

			// add the navigation steps. The number of navigation steps is one less than the cluster size
			// since one model element is the start model element expression
			for (int navigationStep = 0; foundNavigationPlan && navigationStep < this.totalNavigationSteps; navigationStep++) {
				foundNavigationPlan = this.addNavigationStep(navigationStep);
			}

			// successfully create navigation plan for the current start model element expression
			if (foundNavigationPlan) {
				this.calculateOtherLinkExpressions();
			}

		}

		if (!foundNavigationPlan) {
			throw new BugException(BugMessages.IMPOSSIBLE_TO_CREATE_CLUSTER_NAVIGATION_PLAN);
		}

	}

	@SuppressWarnings( { "unchecked", "null" })
	private void initializeMriSetLinkEvaluation() {

		List<SpiMriSetLinkExpression> mriSetLinkExpressions = this.modelElementClusterExpression.getMriSetLinks();
		if (mriSetLinkExpressions == null || mriSetLinkExpressions.size() == 0) {
			return;
		} else {
			int totalNumberOfMriSetLinkExpressions = mriSetLinkExpressions.size();
			this.mriSetLinkExpressionsRefObjects = new EObject[totalNumberOfMriSetLinkExpressions][];
			this.mriSetLinkExpressionsCalculatedLinkSet = new HashSet[totalNumberOfMriSetLinkExpressions];
			for (int i = 0; i < totalNumberOfMriSetLinkExpressions; i++) {
				SpiMriSetLinkExpression mriSetLinkExpression = mriSetLinkExpressions.get(i);
				URI[] linkTarget = mriSetLinkExpression.getLinkTarget();
				int linkTargetSize = (linkTarget == null) ? 0 : linkTarget.length;
				this.mriSetLinkExpressionsRefObjects[i] = new EObject[linkTargetSize];
				this.mriSetLinkExpressionsCalculatedLinkSet[i] = new HashSet();
				for (int linkTargetNum = 0; linkTargetNum < linkTargetSize; linkTargetNum++) {
					EObject currentLinkTargetRefObject = this.emfHelper.getElement(linkTarget[linkTargetNum]);// (EObject) this.connection.getElement( linkTarget[linkTargetNum] );
					this.mriSetLinkExpressionsRefObjects[i][linkTargetNum] = currentLinkTargetRefObject;
					// calculated the objects that are linked to the current link target object
					EObject[] currentLinkedObjects = BasicQueryProcessorMemoryImpl.getLinkedObjects(this.emfHelper,
							currentLinkTargetRefObject, mriSetLinkExpression.getLinkType(), this.partitionScopeSet, mriSetLinkExpression
									.getFromTypesSet(), null);
					// collect the linked objects in a set containing all linked objects of all link targets
					for (int currentLinkedObjectNum = 0; currentLinkedObjectNum < currentLinkedObjects.length; currentLinkedObjectNum++) {
						this.mriSetLinkExpressionsCalculatedLinkSet[i].add(currentLinkedObjects[currentLinkedObjectNum]);
					}
				}
			}
		}
	}

	private boolean isInCalculatedLinkSet(int numMriSetLinkExpression, EObject refObject) {

		return this.mriSetLinkExpressionsCalculatedLinkSet[numMriSetLinkExpression].contains(refObject);
	}

	private void initializeNavigationSteps() {

		this.navigationSource = new int[this.totalNavigationSteps];
		this.navigationTarget = new int[this.totalNavigationSteps];
		this.navigationLinkExpression = new SpiLinkExpression[this.totalNavigationSteps];
		this.navigationDirectionForward = new boolean[this.totalNavigationSteps];
		this.clearNavigationSteps();
	}

	private void clearNavigationSteps() {

		for (int i = 0; i < this.totalNavigationSteps; i++) {
			this.navigationSource[i] = NAVIGATION_STEP_INITIAL_VALUE;
			this.navigationTarget[i] = NAVIGATION_STEP_INITIAL_VALUE;
		}
	}

	/**
	 * Initializes the read positions of the navigation targets starting with the navigation step <code>startNavigationStep</code> and
	 * finishing with the last navigation step.
	 * 
	 * @param startNavigationStep
	 *            navigation step to start with
	 */
	private void initializeReadPosOfNavigationTargets(int startNavigationStep) {

		for (int i = startNavigationStep; i < this.totalNavigationSteps; i++) {
			this.currentReadModelElement[this.navigationTarget[i]] = CURRENT_READ_MODEL_ELEMENT_INITIAL_VALUE;
		}
	}

	/**
	 * Try to add a navigation step to any navigation target.
	 * 
	 * @param stepNumber
	 *            navigation step which shall be added
	 * @return true if the navigation step could be added, otherwise false
	 */
	private boolean addNavigationStep(int stepNumber) {

		// try to add a navigation step to any navigation target
		for (int i = 0; i < this.clusterSize; i++) {
			// if model element expression is already navigation target, try the
			// next one
			if (!this.isNavigableByNavigationPlan(i)) {
				if (this.addNavigationStep(i, stepNumber)) {
					// succesfully added navigation step
					return true;
				}
			}
		}
		// could not add any navigation step
		return false;
	}

	/**
	 * Tries to add a navigation step to a specified model element expression as navigation target. Tries to find a model element expression
	 * that can be the source of the navigation step to the specified navigation target.
	 * 
	 * @param modelElementExpression
	 *            number of model element expression
	 * @return true if the navigation step could be added, otherwise false
	 */
	@SuppressWarnings("unchecked")
	private boolean addNavigationStep(int targetModelElementExpression, int stepNumber) {

		List linkExpressions = this.modelElementClusterExpression.getClusterInternalLinks();
		SpiModelElementExpression target = this.modelElementClusterExpression.getModelElementExpression(targetModelElementExpression);
		// try to find a suitable navigation sources, iterate over all possible
		// navigation sources
		for (int i = 0; i < this.clusterSize; i++) {
			// check that the source is already navigable
			if (this.isNavigableByNavigationPlan(i)) {
				SpiModelElementExpression source = this.modelElementClusterExpression.getModelElementExpression(i);
				SpiLinkExpression linkExpression;
				linkExpression = this.navigatesForward(linkExpressions, source, target);
				if (linkExpression != null) {
					this.storeNavigationStep(stepNumber, i, targetModelElementExpression, linkExpression, true);
					return true;
				}
				linkExpression = this.navigatesBackward(linkExpressions, source, target);
				if (linkExpression != null) {
					this.storeNavigationStep(stepNumber, i, targetModelElementExpression, linkExpression, false);
					return true;
				}
			}
		}
		return false;
	}

	private void storeNavigationStep(int stepNumber, int source, int target, SpiLinkExpression linkExpression, boolean forward) {

		this.navigationSource[stepNumber] = source;
		this.navigationTarget[stepNumber] = target;
		this.navigationLinkExpression[stepNumber] = linkExpression;
		this.navigationDirectionForward[stepNumber] = forward;
	}

	/**
	 * Checks the current plan if the model element expression is already included
	 * 
	 * @param modelElementExpression
	 *            number of model element expression
	 * @return
	 */
	private boolean isNavigableByNavigationPlan(int modelElementExpression) {

		if (this.startModelElementExpression == modelElementExpression) {
			return true;
		}
		for (int i = 0; i < this.clusterSize; i++) {
			if (this.navigationTarget[i] == modelElementExpression) {
				return true;
			}
			if (this.navigationTarget[i] == NAVIGATION_STEP_INITIAL_VALUE) {
				return false;
			}
		}
		return false;
	}

	/**
	 * Checks whether it is possible to navigate forward between two model element expressions. Forward navigation means that the navigation
	 * source corresponds to the link expression 'from' and the navigation target corresponds to the link target.
	 * 
	 * @param links
	 *            links that should be checked
	 * @param source
	 *            source model element expression
	 * @param target
	 *            target model element expression
	 * @return link expression with which the navigation can take place or null if no appropriate link expression could be found
	 */
	@SuppressWarnings("unchecked")
	private SpiLinkExpression navigatesForward(List links, SpiModelElementExpression source, SpiModelElementExpression target) {

		int size = links.size();
		for (int i = 0; i < size; i++) {
			SpiClusterInternalLinkExpression link = (SpiClusterInternalLinkExpression) links.get(i);
			if (this.navigatesForward(link, source, target)) {
				// at least one navigation possibility found
				return link;
			}
		}
		return null;
	}

	/**
	 * Checks whether it is possible to navigate backward between two model element expressions. Backward navigation means that the
	 * navigation source corresponds to the link expression target and the navigation target corresponds to the link 'from'.
	 * 
	 * @param links
	 *            links that should be checked
	 * @param source
	 *            source model element expression
	 * @param target
	 *            target model element expression
	 * @return link expression with which the navigation can take place or null if no appropriate link expression could be found
	 */
	@SuppressWarnings("unchecked")
	private SpiLinkExpression navigatesBackward(List links, SpiModelElementExpression source, SpiModelElementExpression target) {

		int size = links.size();
		for (int i = 0; i < size; i++) {
			SpiClusterInternalLinkExpression link = (SpiClusterInternalLinkExpression) links.get(i);
			if (this.navigatesBackward(link, source, target)) {
				// at least one navigation possibility found
				return link;
			}
		}
		return null;
	}

	/**
	 * Checks whether it is possible to navigate forward between two model element expressions using a specific link expression. Forward
	 * navigation means that the navigation source corresponds to the link expression 'from' and the navigation target corresponds to the
	 * link target.
	 * 
	 * @param linkExpression
	 *            link expression for which the forward navigation shall be possible
	 * @param source
	 *            navigation source
	 * @param target
	 *            navigation target
	 * @return true if the navigation is possible, otherwise false
	 */
	private boolean navigatesForward(SpiClusterInternalLinkExpression linkExpression, SpiModelElementExpression source,
			SpiModelElementExpression target) {

		SpiModelElementExpression linkFrom = linkExpression.getFromModelElementExpression();
		if (linkFrom != source) {
			return false;
		}
		SpiModelElementExpression linkTo = linkExpression.getLinkTarget();
		if (linkTo != target) {
			return false;
		}
		// forward navigation is per convention always possible, especially with
		// attributes
		return true;
	}

	/**
	 * Checks whether it is possible to navigate backward between two model element expressions using a specific link expression. Backward
	 * navigation means that the navigation source corresponds to the link expression target and the navigation target corresponds to the
	 * link 'from'.
	 * 
	 * @param linkExpression
	 *            link expression for which the forward navigation shall be possible
	 * @param source
	 *            navigation source
	 * @param target
	 *            navigation target
	 * @return true if the navigation is possible, otherwise false
	 */
	private boolean navigatesBackward(SpiClusterInternalLinkExpression linkExpression, SpiModelElementExpression source,
			SpiModelElementExpression target) {

		//        SpiFqlAssociationCategory linkCategory = linkExpression.getLinkCategory( );
		SpiModelElementExpression linkFrom = linkExpression.getFromModelElementExpression();
		if (linkFrom != target) {
			return false;
		}
		SpiModelElementExpression linkTo = linkExpression.getLinkTarget();
		if (linkTo != source) {
			return false;
		}
		// associations can be navigated in both directions
		//        return ( linkCategory == SpiFqlAssociationCategory.ASSOCIATION );
		return true;
	}

	/**
	 * Determines the "other" link expressions that are not incorporated in the navigation steps
	 */
	private void calculateOtherLinkExpressions() {

		List<SpiClusterInternalLinkExpression> clusterInternalLinkExpressions = this.modelElementClusterExpression
				.getClusterInternalLinks();
		for (int i = 0; i < clusterInternalLinkExpressions.size(); i++) {
			SpiLinkExpression linkExpression = clusterInternalLinkExpressions.get(i);
			if (!this.isLinkExpressionInNavigationPlan(linkExpression)) {
				this.otherLinkExpressions.add(linkExpression);
			}
		}
	}

	/**
	 * Returns true if the link expression is "already" included in the navigation plan
	 * 
	 * @param linkExpression
	 * @return
	 */
	private boolean isLinkExpressionInNavigationPlan(SpiLinkExpression linkExpression) {

		for (int i = 0; i < this.navigationLinkExpression.length; i++) {
			if (this.navigationLinkExpression[i] == linkExpression) {
				return true;
			}
		}
		return false;
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// model element tuple iteration
	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Initializes the tuple reading. Calculates the model element list of the start model element expression and sets the read pointer of
	 * the start model element expression to the first model element. Sets the read of the other model element expressions to initial.
	 * Returns true if the start model element expression list contains at least one element, otherwise false indicating that the query has
	 * not result
	 */
	private boolean initializeTupleReading() {

		this.isTupleReadingInitialized = true;
		this.currentModelElementList = new EObject[this.clusterSize][];
		this.currentReadModelElement = new int[this.clusterSize];
		// initialize current model element list for start model element expression
		SpiModelElementExpression mee = this.modelElementClusterExpression.getModelElementExpression(this.startModelElementExpression);

		// get scope
		Set<URI> scope = calculateScopeViaGlobalScope(mee.getScope(), mee.scopeIsIncluded());

		this.currentModelElementList[this.startModelElementExpression] = BasicQueryProcessorMemoryImpl.getObjectsOfTypeInPartitions(
				this.emfHelper, scope, mee.getTypesSet(), mee.getElementsSet(), mee.getAttributeExpression());
		if (this.currentModelElementList[this.startModelElementExpression] == null
				|| this.currentModelElementList[this.startModelElementExpression].length == 0) {
			// no result
			return false;
		}
		// Read position is the beginning of the list -> The initial value is set to -1 because after one incrementation
		// it starts with 0
		this.currentReadModelElement[this.startModelElementExpression] = CURRENT_READ_MODEL_ELEMENT_INITIAL_VALUE;
		// initialize read position for all link targets
		this.initializeReadPosOfNavigationTargets(0);
		return true;
	}

	private boolean checkOtherLinkExpressions() {

		int numberOfOtherLinkExpressions = this.otherLinkExpressions.size();
		for (int i = 0; i < numberOfOtherLinkExpressions; i++) {
			SpiClusterInternalLinkExpression currentLinkExpression = (SpiClusterInternalLinkExpression) this.otherLinkExpressions.get(i);
			SpiModelElementExpression from = currentLinkExpression.getFromModelElementExpression();
			SpiModelElementExpression to = currentLinkExpression.getLinkTarget();
			int fromNumber = this.modelElementClusterExpression.getIndexOfModelElementExpressionInCluster(from);
			int toNumber = this.modelElementClusterExpression.getIndexOfModelElementExpressionInCluster(to);
			EObject fromObject = this.currentModelElementList[fromNumber][this.currentReadModelElement[fromNumber]];
			EObject toObject = this.currentModelElementList[toNumber][this.currentReadModelElement[toNumber]];

			// get scope of to object
			Set<URI> scopeOfToObject = currentLinkExpression.getLinkTargetScopeSet();
			boolean scopeOfToObjectIncluded = currentLinkExpression.getLinkTargetScopeIncluded();

			// calculate scope
			Set<URI> scope = calculateScopeViaGlobalScope(scopeOfToObject, scopeOfToObjectIncluded);

			// get types and fixed elements of to objects
			Set<URI> mrisOfTypesOfToObject = currentLinkExpression.getLinkTargetTypesSet();
			Set<URI> fixedElements = currentLinkExpression.getLinkTargetElementsSet();

			if (!this.isLinked(currentLinkExpression, fromObject, toObject, scope, mrisOfTypesOfToObject, fixedElements)) {
				return false;
			}
		}
		// checked all other link expressions successfully
		return true;
	}

	private Set<URI> calculateScopeViaGlobalScope(final Set<URI> scopeOfToObject, final boolean scopeOfToObjectIncluded) {

		return new ScopeSet<URI>(this.partitionScopeSet, scopeOfToObject, !scopeOfToObjectIncluded);
	}

	public class ScopeSet<E> implements Set<E> {

		private final Set<E> firstSet;

		private final Set<E> secondSet;

		private final boolean isDifferenceOperation;

		private int size = -1;

		public ScopeSet(Set<E> firstSet, Set<E> secondSet, boolean isDifferenceOperation) {

			if (isDifferenceOperation || firstSet.size() < secondSet.size()) {
				this.firstSet = firstSet;
				this.secondSet = secondSet;
			} else {
				this.firstSet = secondSet;
				this.secondSet = firstSet;
			}
			this.isDifferenceOperation = isDifferenceOperation;
		}

		public boolean add(Object e) {

			throw new UnmodifiableSetException();
		}

		@SuppressWarnings("unchecked")
		public boolean addAll(Collection c) {

			throw new UnmodifiableSetException();
		}

		public void clear() {

			throw new UnmodifiableSetException();
		}

		public boolean contains(Object o) {

			return this.firstSet.contains(o) && this.isDifferenceOperation != this.secondSet.contains(o);
		}

		@SuppressWarnings("unchecked")
		public boolean containsAll(Collection c) {

			boolean contains = true;
			for (Iterator iterator = c.iterator(); contains && iterator.hasNext();) {
				Object object = iterator.next();
				contains = this.contains(object);
			}
			return contains;
		}

		public boolean isEmpty() {

			return (this.size() == 0);
		}

		public Iterator<E> iterator() {

			return new Iterator<E>() {

				private E buffer;

				@SuppressWarnings("synthetic-access")
				private final Iterator<E> firstSetIterator = ScopeSet.this.firstSet.iterator();

				@SuppressWarnings("synthetic-access")
				public boolean hasNext() {

					for (; this.buffer == null && this.firstSetIterator.hasNext();) {
						this.buffer = this.firstSetIterator.next();
						// keep looking until an element if found
						if (ScopeSet.this.isDifferenceOperation) {
							if (ScopeSet.this.secondSet.contains(this.buffer)) {
								this.buffer = null;
							}
						} else {
							if (!ScopeSet.this.secondSet.contains(this.buffer)) {
								this.buffer = null;
							}
						}
					}

					return (this.buffer != null);
				}

				public E next() {

					if (this.hasNext()) {
						E element = this.buffer;
						this.buffer = null;
						return element;
					} else {
						throw new NoSuchElementException();
					}
				}

				public void remove() {

					throw new UnmodifiableSetException();
				}
			};

		}

		public boolean remove(Object o) {

			throw new UnmodifiableSetException();
		}

		@SuppressWarnings("unchecked")
		public boolean removeAll(Collection c) {

			throw new UnmodifiableSetException();
		}

		@SuppressWarnings("unchecked")
		public boolean retainAll(Collection c) {

			throw new UnmodifiableSetException();
		}

		/**
		 * happens maximum one time on first usage (unmodifiable set)
		 */
		public int size() {

			if (this.size < 0) {
				this.size = 0;
				if (this.isDifferenceOperation) {
					for (E object : this.firstSet) {
						if (!this.secondSet.contains(object)) {
							this.size++;
						}
					}
				} else {
					for (E object : this.firstSet) {
						if (this.secondSet.contains(object)) {
							this.size++;
						}
					}
				}
			}

			return this.size;
		}

		public Object[] toArray() {

			throw new UnsupportedOperationException();
		}

		@SuppressWarnings("unchecked")
		public Object[] toArray(Object[] a) {

			throw new UnsupportedOperationException();
		}
	}

	private boolean checkMriSetLinkExpressions() {

		if (this.mriSetLinkExpressionsRefObjects == null) {
			// no MriSetLinks - ready
			return true;
		} else {
			List<SpiMriSetLinkExpression> mriSetLinkExpressions = this.modelElementClusterExpression.getMriSetLinks();
			for (int i = 0; i < this.mriSetLinkExpressionsRefObjects.length; i++) {
				SpiMriSetLinkExpression mriSetLinkExpression = mriSetLinkExpressions.get(i);
				int modelElementExpressionFromNum = this.modelElementClusterExpression
						.getIndexOfModelElementExpressionInCluster(mriSetLinkExpression.getFromModelElementExpression());
				EObject currentRefObjectFrom = this.currentModelElementList[modelElementExpressionFromNum][this.currentReadModelElement[modelElementExpressionFromNum]];
				//                if ( !( currentObjectFrom instanceof RefObject ) ) {
				//                    throw new MQLBugException( MQLBugMessages.UNEXPECTED_TYPE_IN_MRISETLINKEXPRESSION, currentObjectFrom.getClass( ).getName( ) );
				//                }
				//                RefObject currentRefObjectFrom = (RefObject) this.currentModelElementList[modelElementExpressionFromNum][this.currentReadModelElement[modelElementExpressionFromNum]];
				if (mriSetLinkExpression.isLinked()) {
					if (!this.isInCalculatedLinkSet(i, currentRefObjectFrom)) {
						return false;
					}
				} else if (this.isInCalculatedLinkSet(i, currentRefObjectFrom)) {
					return false;
				}
			}
			// all MriSetLinkExpression are fulfilled
			return true;
		}
	}

	/**
	 * Returns true if the intersection of set1 and set2 is empty, otherwise false.
	 */
	public static boolean isIntersectionOfSetsIsEmpty(EObject[] set1, EObject[] set2) {

		for (int i = 0; i < set1.length; i++) {
			EObject currentRefObject1 = set1[i];
			if (currentRefObject1 == null) {
				continue;
			}
			for (int j = 0; j < set2.length; j++) {
				EObject currentRefObject2 = set2[j];
				if (currentRefObject1.equals(currentRefObject2)) {
					return false;
				}
			}
		}
		// no intersection found
		return true;
	}

	/**
	 * this is used to check if an "other" link exists between from and to objects (i.e. those crossing two MEEs not followed by the
	 * navigation path
	 */
	private boolean isLinked(SpiClusterInternalLinkExpression currentLinkExpression, EObject fromObject, EObject toObject, Set<URI> scope,
			Set<URI> types, Set<URI> elements) {

		//        int associationEndFrom = 1 - currentLinkExpression.getAssociationEndOfLinkedObject( );
		URI linkType = currentLinkExpression.getLinkType();
		//        SpiFqlAssociationCategory linkCategory = currentLinkExpression.getLinkCategory( );

		// for the linked results
		EObject[] linkedObjectArray;

		// obtain cache for current linkType
		Map<Object, EObject[]> cacheForLinkType = this.linkCache.get(linkType);

		// if it did not yet exist, create it
		if (cacheForLinkType == null) {
			cacheForLinkType = new HashMap<Object, EObject[]>(20);
			this.linkCache.put(linkType, cacheForLinkType);
		}

		// check if we already retrieved the linked elements
		linkedObjectArray = cacheForLinkType.get(fromObject);

		if (linkedObjectArray == null) {
			// if not, calculate and put in cache
			linkedObjectArray = getLinkedElementObjects(fromObject, linkType, scope, types, elements);
			cacheForLinkType.put(fromObject, linkedObjectArray);
		}

		// check if we have a match
		boolean match = linkedObjectArray.length > 0;

		// if at least one link exists, check whether toObject is in the set of linked elements
		if (match) {
			// start assuming no link matches
			match = false;
			for (int i = 0; !match && i < linkedObjectArray.length; i++) {
				match = linkedObjectArray[i].equals(toObject);
			}
		}
		return match;

	}

	/**
	 * Calculates for the navigation source the linked RefObject instances of the navigation target. Returns true if at least one navigation
	 * target was found, otherwise false.
	 * 
	 * @param navigationStep
	 *            navigation step
	 */
	private boolean calculateLinkedObjects(int navigationStep) {

		int navigationSourceModelElementExpr = this.navigationSource[navigationStep];
		int navigationTargetModelElementExpr = this.navigationTarget[navigationStep];

		// get the starting object
		EObject sourceObject = this.currentModelElementList[navigationSourceModelElementExpr][this.currentReadModelElement[navigationSourceModelElementExpr]];

		// get linkExpression information
		SpiLinkExpression currentLinkExpression = this.navigationLinkExpression[navigationStep];
		//        int associationEndFrom;
		Set<URI> mrisOfTypes;
		Set<URI> elements;
		Set<URI> scope;
		boolean scopeIncluded;

		// look at navigation plan to determine whether we go forward or backwards
		if (this.navigationDirectionForward[navigationStep]) {
			//            associationEndFrom = 1 - currentLinkExpression.getAssociationEndOfLinkedObject( );
			mrisOfTypes = currentLinkExpression.getLinkTargetTypesSet();
			elements = currentLinkExpression.getLinkTargetElementsSet();
			scope = currentLinkExpression.getLinkTargetScopeSet();
			scopeIncluded = currentLinkExpression.getLinkTargetScopeIncluded();
		} else {
			//            associationEndFrom = currentLinkExpression.getAssociationEndOfLinkedObject( );
			mrisOfTypes = currentLinkExpression.getFromTypesSet();
			elements = currentLinkExpression.getFromElementsSet();
			scope = currentLinkExpression.getFromScopeSet();
			scopeIncluded = currentLinkExpression.getFromScopeIncluded();
		}

		URI linkType = currentLinkExpression.getLinkType();
		//        SpiFqlAssociationCategory linkCategory = currentLinkExpression.getLinkCategory( );
		Set<URI> scopeForLinkedObjects = calculateScopeViaGlobalScope(scope, scopeIncluded);

		// for keeping the linked objects
		EObject[] linkedObjectArray = getLinkedElementObjectsWithAttributeCheck(sourceObject, linkType, scopeForLinkedObjects, mrisOfTypes,
				elements, this.modelElementClusterExpression.getModelElementExpression(navigationTargetModelElementExpr)
						.getAttributeExpression());

		// if there are no links, return false
		if (linkedObjectArray == null || linkedObjectArray.length == 0) {
			return false;
		}
		this.currentModelElementList[navigationTargetModelElementExpr] = linkedObjectArray;
		this.currentReadModelElement[navigationTargetModelElementExpr] = 0;
		return true;
	}

	@SuppressWarnings("unchecked")
	private EObject[] getLinkedElementObjects(EObject sourceObject, URI linkType, Set<URI> scope, Set<URI> types, Set<URI> elements) {

		return BasicQueryProcessorMemoryImpl.getLinkedObjects(this.emfHelper, sourceObject, linkType, scope, types, elements);
	}

	@SuppressWarnings("unchecked")
	private EObject[] getLinkedElementObjectsWithAttributeCheck(EObject sourceObject, URI linkType, Set<URI> scope, Set<URI> types,
			Set<URI> elements, SpiAttributeExpression attributeExpression) {

		EObject[] list = BasicQueryProcessorMemoryImpl.getLinkedObjects(this.emfHelper, sourceObject, linkType, scope, types, elements);
		ArrayList<EObject> result = new ArrayList<EObject>(list.length);
		for (int i = 0, n = list.length; i < n; i++) {
			if (ClusterEvaluator.evaluateAttributesExceptAttrComparisons(emfHelper, list[i], attributeExpression)) {
				result.add(list[i]);
			}
		}
		return result.toArray(new EObject[result.size()]);
	}

	//
	//        // for keeping the linked objects
	//        EObject[] linkedObjectArray = new EObject[0];
	//
	//        // get the objects in case of an association
	//        if ( linkCategory == SpiFqlAssociationCategory.ASSOCIATION ) {
	//            if ( !( sourceObject instanceof RefObject ) ) {
	//                throw new MQLBugException( MQLBugMessages.SOURCEOBJECT_MUST_BE_REFOBJECT_TYPE, sourceObject.getClass( ).getName( ) );
	//            }
	//        linkedObjectArray = BasicQueryProcessorMemoryImpl.getLinkedObjects( this.emfHelper, sourceObject, linkType, scope, types, elements );

	//        } else if ( linkCategory == SpiFqlAssociationCategory.ATTRIBUTE ) {
	//            // get the objects in case of an attribute
	//
	//            RefObject linkTypeRefObject = (RefObject) ( this.connection.getElement( linkType ) );
	//            Object linkedObject = null;
	//            if ( sourceObject instanceof RefObject ) {
	//                // class-based
	//                linkedObject = ( (RefObjectImpl) sourceObject ).refGetValue( this.connection, linkTypeRefObject );
	//
	//            } else if ( sourceObject instanceof RefStruct ) {
	//                // structure-based
	//
	//                // linked object must be structure, link type must be a structure field
	//                StructureField structureField = (StructureField) linkTypeRefObject;
	//                String fieldName = structureField.getName( );
	//                linkedObject = ( (RefStruct) sourceObject ).refGetValue( fieldName );
	//            } else {
	//                throw new MQLBugException( MQLBugMessages.NO_SUCH_NAVIGATION_STEP_SOURCE, sourceObject.getClass( ).getName( ) );
	//            }
	//
	//            if ( linkedObject == null ) {
	//                linkedObjectArray = new Object[0];
	//            } else {
	//
	//                if ( linkedObject instanceof RefObject ) {
	//                    // check for types and elements
	//                    boolean isDesiredLinkedObject = BasicQueryProcessorMemoryImpl.isInPartitionsOfTypeAndInElements( (RefObject) linkedObject, scope, types, elements );
	//
	//                    // the result is an object (single-valued)
	//                    if ( isDesiredLinkedObject ) {
	//                        linkedObjectArray = new Object[1];
	//                        linkedObjectArray[0] = linkedObject;
	//                    } else {
	//                        linkedObjectArray = new Object[0];
	//                    }
	//
	//                } else if ( linkedObject instanceof RefStruct ) {
	//                    // the result is a structure (single-valued)
	//                    linkedObjectArray = new RefStruct[1];
	//                    linkedObjectArray[0] = linkedObject;
	//
	//                } else if ( linkedObject instanceof Collection ) {
	//                    // the result is multi-valued. If the link is ordered then linkedObject is even a list, but there is
	//                    // no special handling needed here
	//
	//                    // copy result set because we may remove elements from it
	//                    Collection linkedCollection = (Collection) linkedObject;
	//                    Collection<Object> copiedLinkedCollection = new ArrayList<Object>( linkedCollection.size( ) );
	//                    copiedLinkedCollection.addAll( linkedCollection );
	//
	//                    // Register what kind of collection we are dealing with. We initially assume it is RefObject-based
	//                    boolean isRefObjectBased = true;
	//
	//                    // Now run through the collection and do the type and element check
	//                    for ( Iterator iter = copiedLinkedCollection.iterator( ); iter.hasNext( ); ) {
	//                        Object collectionElement = iter.next( );
	//
	//                        // check if it is refObjectBased
	//                        isRefObjectBased = collectionElement instanceof RefObject;
	//
	//                        // if so, check for types and elements
	//                        if ( isRefObjectBased ) {
	//                            // we only remove it if the linked element is not in the expected partition, type, or
	//                            // element set
	//                            if ( !BasicQueryProcessorMemoryImpl.isInPartitionsOfTypeAndInElements( (RefObject) collectionElement, scope, types, elements ) ) {
	//                                iter.remove( );
	//                            }
	//                        } else {
	//                            // note that if we are dealing with structure types, then we do not have to check for
	//                            // partition, type, and element relationships
	//                        }
	//                    }
	//
	//                    int collectionSize = copiedLinkedCollection.size( );
	//                    if ( isRefObjectBased ) {
	//                        linkedObjectArray = new RefObject[collectionSize];
	//                    } else {
	//                        linkedObjectArray = new RefStruct[collectionSize];
	//                    }
	//                    Iterator it = copiedLinkedCollection.iterator( );
	//                    for ( int i = 0; it.hasNext( ); i++ ) {
	//                        linkedObjectArray[i] = it.next( );
	//                    }
	//
	//                } else {
	//                    throw new MQLBugException( MQLBugMessages.UNEXPECTED_TYPE_OF_LINKEDOBJECT_CLASS_NAME, linkedObject.getClass( ).getName( ) );
	//                }
	//            }
	//        } else {
	//            throw new MQLBugException( MQLBugMessages.NO_SUCH_LINK_CATEGORY );
	//        }

	//        return linkedObjectArray;
	//    }

	/**
	 * Returns true if the read pointer of the navigation target of a specified navigation step is initial, which means that the link
	 * navigation has not been calculated yet, otherwise this method returns false.
	 * 
	 * @param navigationStep
	 *            navigation step
	 */
	private boolean isReadPointerOfNavigationTargetInitial(int navigationStep) {

		int navigationTargetModelElementExpr = this.navigationTarget[navigationStep];
		int currentReadModelElement_ = this.currentReadModelElement[navigationTargetModelElementExpr];
		return (currentReadModelElement_ == NAVIGATION_STEP_INITIAL_VALUE);
	}

	/**
	 * Returns true if the read pointer of the navigation source of a specified navigation step is initial, which means that the link
	 * navigation cannot be calculated, otherwise this method returns false.
	 * 
	 * @param navigationStep
	 *            navigation step
	 */
	private boolean isReadPointerOfNavigationSourceInitial(int navigationStep) {

		int navigationTargetModelElementExpr = this.navigationSource[navigationStep];
		int currentReadModelElement_ = this.currentReadModelElement[navigationTargetModelElementExpr];
		return (currentReadModelElement_ == NAVIGATION_STEP_INITIAL_VALUE);
	}

	/**
	 * Returns true if the navigation target of a specified navigation step is incrementable, otherwise returns false, which means that the
	 * iteration of the navigation target is completed.
	 * 
	 * @param navigationStep
	 *            navigation step
	 */
	private boolean isNavigationTargetIncrementable(int navigationStep) {

		int navigationTargetModelElementExpr = this.navigationTarget[navigationStep];
		int currentReadModelElement_ = this.currentReadModelElement[navigationTargetModelElementExpr];
		if (currentReadModelElement_ < this.currentModelElementList[navigationTargetModelElementExpr].length - 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Increment the navigation target of a navigation step. Returns true if incrementation was successful, otherwise false which means that
	 * the navigation target is not incrementable
	 * 
	 * @param navigationStep
	 *            navigation step
	 */
	private boolean incrementNavigationTarget(int navigationStep) {

		if (!isNavigationTargetIncrementable(navigationStep)) {
			return false;
		}
		int navigationTargetModelElementExpr = this.navigationTarget[navigationStep];
		this.currentReadModelElement[navigationTargetModelElementExpr]++;
		this.initializeReadPosOfNavigationTargets(navigationStep + 1);
		return true;
	}

	/**
	 * Updates the navigation target of a specified navigation step. There are two kind of update activies possible: 1. calculating the
	 * linked objects and setting the read position to the first linked model element or 2. incrementing the read position of the linked
	 * model elements.
	 * <p>
	 * If the read pointer of the navigation target is initial then the objects which are linked to the link source are calculated. If at
	 * least one linked object was found then the read pointer is set to the first linked object and true is returned, otherwise false is
	 * returned
	 * <p>
	 * If the navigation target is not initial then it is tried to increment the read pointer to the linked objects. If the incrementation
	 * was succesful then true is returned, otherwise false is returned meaning that all linked objects have been read already
	 * 
	 * @param navigationStep
	 *            navigation step
	 * @return true if the update was successful, otherwise false
	 */
	private boolean updateNavigationTarget(int navigationStep) {

		if (this.isReadPointerOfNavigationSourceInitial(navigationStep)) {
			return false;
		}
		if (this.isReadPointerOfNavigationTargetInitial(navigationStep)) {
			return this.calculateLinkedObjects(navigationStep);
		} else {
			return this.incrementNavigationTarget(navigationStep);
		}
	}

	/**
	 * Sets the next tuple that fulfills all link expressions in the cluster
	 * 
	 * @return true if a tuple was found, otherwise false
	 */
	public boolean nextTuple() {

		while (this.nextTupleNoCheckForOtherLinkExpressions()) {
			// check whether the current tuple fulfills the other link
			// expressions
			if (this.checkOtherLinkExpressions() && this.checkMriSetLinkExpressions()) {
				return true;
			}
			// continue with next tuple
		}
		// no more tuples
		return false;
	}

	/**
	 * Gets a tuple element.
	 * 
	 * @param numberOfModelElementExpression
	 *            number of the model element expression in the cluster
	 * @return RefObject representing the current model element to the model element expression
	 */
	public EObject getTupleElement(int numberOfModelElementExpression) {

		return this.currentModelElementList[numberOfModelElementExpression][this.currentReadModelElement[numberOfModelElementExpression]];
	}

	/**
	 * Sets the next tuple. If a tuple was found then this method returns true, otherwise false.
	 */
	private boolean nextTupleNoCheckForOtherLinkExpressions() {

		int currentNavigationStep;

		// initialize tuple reading if not done before
		if (!this.isTupleReadingInitialized) {
			if (!this.initializeTupleReading()) {
				// query returns empty result
				return false;
			}
			// at the very first iteration we start with the first navigation step
			currentNavigationStep = 0;
		} else {
			// start with the last navigation step
			currentNavigationStep = this.lastNavigationStep;
		}

		// special handling for the case that there is no navigation step
		if (this.totalNavigationSteps == 0) {
			// try to increment read position of first navigation source
			this.currentReadModelElement[this.startModelElementExpression]++;
			if (this.currentReadModelElement[this.startModelElementExpression] < this.currentModelElementList[this.startModelElementExpression].length) {
				// continue with the incremented read position of the
				// first navigation source
				return true;
			} else {
				// no more tuples
				return false;
			}
		}

		// Tuple iteration algorithm described as in activity diagram
		for (;;) {
			// try to update the current navigation step
			if (this.updateNavigationTarget(currentNavigationStep)) {
				if (currentNavigationStep == this.lastNavigationStep) {
					// found tuple
					return true;
				} else {
					// continue with updating the target of the next navigation
					// step
					currentNavigationStep++;
					continue;
				}
			} else {
				if (currentNavigationStep == 0) {
					// try to increment read position of first navigation source
					this.currentReadModelElement[this.startModelElementExpression]++;
					this.initializeReadPosOfNavigationTargets(0);
					if (this.currentReadModelElement[this.startModelElementExpression] < this.currentModelElementList[this.startModelElementExpression].length) {
						// continue with the incremented read position of the
						// first navigation source
						continue;
					} else {
						// no more tuples
						return false;
					}
				} else {
					// continue with updating the target of the previous navigation step
					currentNavigationStep--;
					continue;
				}
			}
		}
	}

}
