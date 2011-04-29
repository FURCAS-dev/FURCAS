/**
 * Copyright (c) 2009, 2011 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *     Axel Uhl (SAP AG) - Bug 342644
 */
package org.eclipse.ocl.ecore.tests;

import org.eclipse.ocl.util.CollectionUtil;

// FIXME we're missing oclIsNew and oclIsInState
/**
 * This unit test focuses on the Standard library's Collection operations.
 * 
 * @author Laurent Goubet (lgoubet)
 */
@SuppressWarnings("nls")
public class EvaluationCollectionOperationTest
		extends AbstractEvaluationTest {

	public void testCollectionAppend() {
		assertExpressionResults("Sequence{'a', 'b', 'c'}", "Sequence{'a', 'b'}->append('c')");
		assertExpressionResults("OrderedSet{'a', 'b', 'c'}", "OrderedSet{'a', 'b'}->append('c')");
	}

	public void testCollectionAppendInvalid() {
		assertResultInvalid("let s : Sequence(String) = invalid in s->append('a')");
		assertResultInvalid("let o : OrderedSet(String) = invalid in o->append('a')");
	}

	public void testCollectionAppendInvalidValue() {
		assertResultInvalid("Sequence{'a', 'b'}->append(invalid)");
		assertResultInvalid("OrderedSet{'a', 'b'}->append(invalid)");
	}

	public void testCollectionAppendNull() {
		assertResultInvalid("let s : Sequence(String) = null in s->append('a')");
		assertResultInvalid("let o : OrderedSet(String) = null in o->append('a')");
	}

	public void testCollectionAppendNullValue() {
		assertExpressionResults("Sequence{'a', 'b', null}", "Sequence{'a', 'b'}->append(null)");
		assertExpressionResults("OrderedSet{'a', 'b', null}", "OrderedSet{'a', 'b'}->append(null)");
	}

	public void testCollectionAsBag() {
		assertResult(CollectionUtil.createNewBag(), "Sequence{}->asBag()");
		assertResult(CollectionUtil.createNewBag(), "Bag{}->asBag()");
		assertResult(CollectionUtil.createNewBag(), "Set{}->asBag()");
		assertResult(CollectionUtil.createNewBag(), "OrderedSet{}->asBag()");

		assertExpressionResults("Bag{1, 2.0, '3'}", "Sequence{1, 2.0, '3'}->asBag()");
		assertExpressionResults("Bag{1, 2.0, '3'}", "Bag{1, 2.0, '3'}->asBag()");
		assertExpressionResults("Bag{1, 2.0, '3'}", "Set{1, 2.0, '3'}->asBag()");
		assertExpressionResults("Bag{1, 2.0, '3'}", "OrderedSet{1, 2.0, '3'}->asBag()");
	}

	public void testCollectionAsBagInvalid() {
		assertResultInvalid("let s : Sequence(Integer) = invalid in s->asBag()");
		assertResultInvalid("let b : Bag(Integer) = invalid in b->asBag()");
		assertResultInvalid("let s : Set(Integer) = invalid in s->asBag()");
		assertResultInvalid("let o : OrderedSet(Integer) = invalid in o->asBag()");
	}

	public void testCollectionAsBagNull() {
		assertResultInvalid("let s : Sequence(Integer) = null in s->asBag()");
		assertResultInvalid("let b : Bag(Integer) = null in b->asBag()");
		assertResultInvalid("let s : Set(Integer) = null in s->asBag()");
		assertResultInvalid("let o : OrderedSet(Integer) = null in o->asBag()");
	}

	public void testCollectionAsOrderedSet() {
		assertResult(CollectionUtil.createNewOrderedSet(),
			"Sequence{}->asOrderedSet()");
		assertResult(CollectionUtil.createNewOrderedSet(),
			"Bag{}->asOrderedSet()");
		assertResult(CollectionUtil.createNewOrderedSet(),
			"Set{}->asOrderedSet()");
		assertResult(CollectionUtil.createNewOrderedSet(),
			"OrderedSet{}->asOrderedSet()");

		assertExpressionResults("OrderedSet{1, 2.0, '3'}", "Sequence{1, 2.0, '3'}->asOrderedSet()");
		assertExpressionResults("OrderedSet{1, 2.0, '3'}", "OrderedSet{1, 2.0, '3'}->asOrderedSet()");

		/*
		 * Bag and Set are not ordered, simply check that the result is an
		 * OrderedSet and it contains all needed values.
		 */
		assertResultContainsAll("OrderedSet{1, 2.0, '3'}", "Set{1, 2.0, '3'}->asOrderedSet()");
		assertResultContainsAll("OrderedSet{1, 2.0, '3'}", "Bag{1, 2.0, '3'}->asOrderedSet()");
	}

	public void testCollectionAsOrderedSetInvalid() {
		assertResultInvalid("let s : Sequence(Integer) = invalid in s->asOrderedSet()");
		assertResultInvalid("let b : Bag(Integer) = invalid in b->asOrderedSet()");
		assertResultInvalid("let s : Set(Integer) = invalid in s->asOrderedSet()");
		assertResultInvalid("let o : OrderedSet(Integer) = invalid in o->asOrderedSet()");
	}

	public void testCollectionAsOrderedSetNull() {
		assertResultInvalid("let s : Sequence(Integer) = null in s->asOrderedSet()");
		assertResultInvalid("let b : Bag(Integer) = null in b->asOrderedSet()");
		assertResultInvalid("let s : Set(Integer) = null in s->asOrderedSet()");
		assertResultInvalid("let o : OrderedSet(Integer) = null in o->asOrderedSet()");
	}

	public void testCollectionAsSequence() {
		assertResult(CollectionUtil.createNewSequence(),
			"Sequence{}->asSequence()");
		assertResult(CollectionUtil.createNewSequence(), "Bag{}->asSequence()");
		assertResult(CollectionUtil.createNewSequence(), "Set{}->asSequence()");
		assertResult(CollectionUtil.createNewSequence(),
			"OrderedSet{}->asSequence()");

		assertExpressionResults("Sequence{1, 2.0, '3'}", "Sequence{1, 2.0, '3'}->asSequence()");
		assertExpressionResults("Sequence{1, 2.0, '3'}", "OrderedSet{1, 2.0, '3'}->asSequence()");

		/*
		 * Bag and Set are not ordered, simply check that the result is a
		 * Sequence and it contains all needed values.
		 */
		assertResultContainsAll("Sequence{1, 2.0, '3'}", "Bag{1, 2.0, '3'}->asSequence()");
		assertResultContainsAll("Sequence{1, 2.0, '3'}", "Set{1, 2.0, '3'}->asSequence()");
	}

	public void testCollectionAsSequenceInvalid() {
		assertResultInvalid("let s : Sequence(Integer) = invalid in s->asSequence()");
		assertResultInvalid("let b : Bag(Integer) = invalid in b->asSequence()");
		assertResultInvalid("let s : Set(Integer) = invalid in s->asSequence()");
		assertResultInvalid("let o : OrderedSet(Integer) = invalid in o->asSequence()");
	}

	public void testCollectionAsSequenceNull() {
		assertResultInvalid("let s : Sequence(Integer) = null in s->asSequence()");
		assertResultInvalid("let b : Bag(Integer) = null in b->asSequence()");
		assertResultInvalid("let s : Set(Integer) = null in s->asSequence()");
		assertResultInvalid("let o : OrderedSet(Integer) = null in o->asSequence()");
	}

	public void testCollectionAsSet() {
		assertResult(CollectionUtil.createNewSet(), "Sequence{}->asSet()");
		assertResult(CollectionUtil.createNewSet(), "Bag{}->asSet()");
		assertResult(CollectionUtil.createNewSet(), "Set{}->asSet()");
		assertResult(CollectionUtil.createNewSet(), "OrderedSet{}->asSet()");

		assertExpressionResults("Set{1, 2.0, '3'}", "Sequence{1, 2.0, '3'}->asSet()");
		assertResultContainsAll("Set{1, 2.0, '3'}", "Bag{1, 2.0, '3'}->asSet()");
		assertResultContainsAll("Set{1, 2.0, '3'}", "Set{1, 2.0, '3'}->asSet()");
		assertExpressionResults("Set{1, 2.0, '3'}", "OrderedSet{1, 2.0, '3'}->asSet()");
	}

	public void testCollectionAsSetInvalid() {
		assertResultInvalid("let s : Sequence(Integer) = invalid in s->asSet()");
		assertResultInvalid("let b : Bag(Integer) = invalid in b->asSet()");
		assertResultInvalid("let s : Set(Integer) = invalid in s->asSet()");
		assertResultInvalid("let o : OrderedSet(Integer) = invalid in o->asSet()");
	}

	public void testCollectionAsSetNull() {
		assertResultInvalid("let s : Sequence(Integer) = null in s->asSet()");
		assertResultInvalid("let b : Bag(Integer) = null in b->asSet()");
		assertResultInvalid("let s : Set(Integer) = null in s->asSet()");
		assertResultInvalid("let o : OrderedSet(Integer) = null in o->asSet()");
	}

	public void testCollectionAt() {
		assertResult("a", "Sequence{'a', 'b'}->at(1)");
		assertResult("b", "OrderedSet{'a', 'b'}->at(2)");
	}

	public void testCollectionAtInvalid() {
		assertResultInvalid("let s : Sequence(String) = invalid in s->at(1)");
		assertResultInvalid("let o : OrderedSet(String) = invalid in o->at(1)");
	}

	public void testCollectionAtInvalidValue() {
		assertResultInvalid("Sequence{'a', invalid}->at(1)");
		assertResultInvalid("OrderedSet{'a', invalid}->at(1)");
	}

	public void testCollectionAtNull() {
		assertResultInvalid("let s : Sequence(String) = null in s->at(1)");
		assertResultInvalid("let o : OrderedSet(String) = null in o->at(1)");
	}

	public void testCollectionAtNullValue() {
		assertResult(null, "Sequence{null, 'a'}->at(1)");
		assertResult(null, "OrderedSet{null, 'a'}->at(1)");
	}

	public void testCollectionAtOutOfBounds() {
		assertResultInvalid("Sequence{'a'}->at(0)");
		assertResultInvalid("OrderedSet{'a'}->at(0)");

		assertResultInvalid("Sequence{'a'}->at(2)");
		assertResultInvalid("OrderedSet{'a'}->at(2)");
	}

	public void testCollectionCount() {
		assertResult(Integer.valueOf(1),
			"Sequence{3, 'test', 4.0, 4, 4.0, 'test'}->count(3)");
		assertResult(Integer.valueOf(3),
			"Sequence{3, 'test', 4.0, 4, 4.0, 'test'}->count(4.0)");
		assertResult(Integer.valueOf(2),
			"Sequence{3, 'test', 4.0, 4, 4.0, 'test'}->count('test')");
		assertResult(Integer.valueOf(1),
			"Bag{3, 'test', 4.0, 4, 4.0, 'test'}->count(3)");
		assertResult(Integer.valueOf(3),
			"Bag{3, 'test', 4.0, 4, 4.0, 'test'}->count(4.0)");
		assertResult(Integer.valueOf(2),
			"Bag{3, 'test', 4.0, 4, 4.0, 'test'}->count('test')");
		assertResult(Integer.valueOf(1),
			"Set{3, 'test', 4.0, 4, 4.0, 'test'}->count(3)");
		// FIXME number values currently have different Java equality from OCL equality
		//assertResult(Integer.valueOf(1),
		//	"Set{3, 'test', 4.0, 4, 4.0, 'test'}->count(4.0)");
		assertResult(Integer.valueOf(1),
			"Set{3, 'test', 4.0, 4, 4.0, 'test'}->count('test')");
		assertResult(Integer.valueOf(1),
			"OrderedSet{3, 'test', 4.0, 4, 4.0, 'test'}->count(3)");
		// FIXME number values currently have different Java equality from OCL equality
		//assertResult(Integer.valueOf(1),
		//	"OrderedSet{3, 'test', 4.0, 4, 4.0, 'test'}->count(4.0)");
		assertResult(Integer.valueOf(1),
			"OrderedSet{3, 'test', 4.0, 4, 4.0, 'test'}->count('test')");

		assertResult(Integer.valueOf(0),
			"Sequence{3, 'test', 4.0, 4, 4.0, 'test'}->count(0)");
		assertResult(Integer.valueOf(0),
			"Bag{3, 'test', 4.0, 4, 4.0, 'test'}->count(0)");
		assertResult(Integer.valueOf(0),
			"Set{3, 'test', 4.0, 4, 4.0, 'test'}->count(0)");
		assertResult(Integer.valueOf(0),
			"OrderedSet{3, 'test', 4.0, 4, 4.0, 'test'}->count(0)");
	}

	public void testCollectionCountInvalid() {
		assertResultInvalid("let s : Sequence(Integer) = invalid in s->count(0)");
		assertResultInvalid("let b : Bag(Integer) = invalid in b->count(0)");
		assertResultInvalid("let s : Set(Integer) = invalid in s->count(0)");
		assertResultInvalid("let os : OrderedSet(Integer) = invalid in os->count(0)");
	}

	public void testCollectionCountInvalidValue() {
		assertResultInvalid("Sequence{3, 'test', 4.0, 4, 4.0, 'test'}->count(invalid)");
		assertResultInvalid("Bag{3, 'test', 4.0, 4, 4.0, 'test'}->count(invalid)");
		assertResultInvalid("Set{3, 'test', 4.0, 4, 4.0, 'test'}->count(invalid)");
		assertResultInvalid("OrderedSet{3, 'test', 4.0, 4, 4.0, 'test'}->count(invalid)");

		assertResultInvalid("Sequence{3, invalid, 4.0, invalid, 'test'}->count(3)");
		assertResultInvalid("Bag{3, invalid, 4.0, invalid, 'test'}->count(3)");
		assertResultInvalid("Set{3, invalid, 4.0, invalid, 'test'}->count(3)");
		assertResultInvalid("OrderedSet{3, invalid, 4.0, invalid, 'test'}->count(3)");
	}

	public void testCollectionCountNull() {
		assertResultInvalid("let s : Sequence(Integer) = null in s->count(0)");
		assertResultInvalid("let b : Bag(Integer) = null in b->count(0)");
		assertResultInvalid("let s : Set(Integer) = null in s->count(0)");
		assertResultInvalid("let os : OrderedSet(Integer) = null in os->count(0)");
	}

	public void testCollectionCountNullValue() {
		assertResult(Integer.valueOf(0),
			"Sequence{3, 'test', 4.0, 4, 4.0, 'test'}->count(null)");
		assertResult(Integer.valueOf(0),
			"Bag{3, 'test', 4.0, 4, 4.0, 'test'}->count(null)");
		assertResult(Integer.valueOf(0),
			"Set{3, 'test', 4.0, 4, 4.0, 'test'}->count(null)");
		assertResult(Integer.valueOf(0),
			"OrderedSet{3, 'test', 4.0, 4, 4.0, 'test'}->count(null)");

		assertResult(Integer.valueOf(2),
			"Sequence{3, null, 4.0, null, 'test'}->count(null)");
		assertResult(Integer.valueOf(2),
			"Bag{3, null, 4.0, null, 'test'}->count(null)");
		assertResult(Integer.valueOf(1),
			"Set{3, null, 4.0, null, 'test'}->count(null)");
		assertResult(Integer.valueOf(1),
			"OrderedSet{3, null, 4.0, null, 'test'}->count(null)");
	}

	public void testCollectionEqualInvalid() {
		// operation invocations on invalid except for oclIsInvalid and oclIsUndefined yield invalid
		assertResultInvalid("let s : Sequence(Integer) = invalid in s = Sequence{5}");
		assertResultInvalid("let b : Bag(Integer) = invalid in Bag{5} = b");
		assertResultInvalid("let s : Set(Integer) = invalid in s = Set{5}");
		assertResultInvalid("let o : OrderedSet(Integer) = invalid in OrderedSet{5} = o");

		assertResultInvalid("let s1 : Sequence(Integer) = invalid, s2 : Sequence(Integer) = invalid in s1 = s2");
		assertResultInvalid("let b1 : Bag(Integer) = invalid, b2 : Bag(Integer) = invalid in b1 = b2");
		assertResultInvalid("let s1 : Set(Integer) = invalid, s2 : Set(Integer) = invalid in s1 = s2");
		assertResultInvalid("let o1 : OrderedSet(Integer) = invalid, o2 : OrderedSet(Integer) = invalid in o1 = o2");
	}

	public void testCollectionEqualNull() {
		assertResultFalse("let s : Sequence(Integer) = null in s = Sequence{5}");
		assertResultFalse("let b : Bag(Integer) = null in Bag{5} = b");
		assertResultFalse("let s : Set(Integer) = null in s = Set{5}");
		assertResultFalse("let o : OrderedSet(Integer) = null in OrderedSet{5} = o");

		assertResultTrue("let s1 : Sequence(Integer) = null, s2 : Sequence(Integer) = null in s1 = s2");
		assertResultTrue("let b1 : Bag(Integer) = null, b2 : Bag(Integer) = null in b1 = b2");
		assertResultTrue("let s1 : Set(Integer) = null, s2 : Set(Integer) = null in s1 = s2");
		assertResultTrue("let o1 : OrderedSet(Integer) = null, o2 : OrderedSet(Integer) = null in o1 = o2");
	}

	public void testCollectionEqualOrderedXOrdered() {
		// same order, same quantities
		assertResultTrue("Sequence{4, 5, 'test'} = Sequence{4, 5, 'test'}");
		assertResultTrue("Sequence{4, 5, 'test', 5} = Sequence{4, 5, 'test', 5}");
		assertResultTrue("OrderedSet{4, 5, 'test', 5} = OrderedSet{4, 5, 'test'}");
		// according to 11.7.1 two collections not of the same kind are not equal
		// The following don't parse because:
		// "Cannot find operation (=(OrderedSet(OclAny))) for the type (Sequence(OclAny))"
		//		assertResultFalse("Sequence{4, 5, 'test'} = OrderedSet{4, 5, 'test', 5}");
		//		assertResultFalse("OrderedSet{4, 5, 'test', 5} = Sequence{4, 5, 'test'}");

		// distinct order, same quantities
		assertResultFalse("Sequence{4, 5, 'test'} = Sequence{4, 'test', 5}");
		assertResultFalse("Sequence{4, 5, 'test', 5} = Sequence{5, 4, 'test', 5}");
		// The following seems not clearly specified:
		// assertResultFalse("OrderedSet{4, 5, 'test', 5} = OrderedSet{4, 'test', 5}");
		// The following don't parse because:
		// "Cannot find operation (=(OrderedSet(OclAny))) for the type (Sequence(OclAny))"
		//		assertResultFalse("Sequence{4, 5, 'test'} = OrderedSet{5, 4, 'test', 5}");
		//		assertResultFalse("OrderedSet{4, 5, 'test', 5} = Sequence{5, 4, 'test'}");

		// distinct quantities
		assertResultFalse("Sequence{4, 5, 'test', 5} = Sequence{4, 5, 'test'}");
		// The following don't parse because:
		// "Cannot find operation (=(OrderedSet(OclAny))) for the type (Sequence(OclAny))"
		//		assertResultFalse("Sequence{4, 5, 'test', 5} = OrderedSet{4, 5, 'test', 5}");
		//		assertResultFalse("OrderedSet{4, 5, 'test', 5} = Sequence{4, 5, 'test', 5}");
	}

	public void testCollectionEqualUnorderedXUnordered() {
		// same quantities
		// doesn't parse because = for different collection types is currently not supported
		// assertResultTrue("Bag{4, 5, 'test'} = Set{4, 'test', 5, 4}");
		assertResultTrue("Bag{4, 5, 'test', 4} = Bag{4, 'test', 5, 4}");
		assertResultTrue("Set{4, 5, 'test', 4} = Set{4, 'test', 5, 4}");
		// assertResultTrue("Set{4, 5, 'test', 4} = Bag{4, 'test', 5}");

		// distinct quantities
		// assertResultFalse("Bag{4, 5, 'test', 4} = Set{4, 'test', 5, 4}");
		assertResultFalse("Bag{4, 5, 'test'} = Bag{4, 'test', 5, 4}");
		// assertResultFalse("Set{4, 5, 'test', 4} = Bag{4, 'test', 5, 4}");
	}

	public void testCollectionExcludes() {
		assertResultFalse("Sequence{3, 4.0, 'test'}->excludes(3)");
		assertResultFalse("Sequence{3, 4.0, 'test'}->excludes('test')");
		assertResultFalse("Bag{3, 4.0, 'test'}->excludes(3)");
		assertResultFalse("Bag{3, 4.0, 'test'}->excludes('test')");
		assertResultFalse("Set{3, 4.0, 'test'}->excludes(3)");
		assertResultFalse("Set{3, 4.0, 'test'}->excludes('test')");
		assertResultFalse("OrderedSet{3, 4.0, 'test'}->excludes(3)");
		assertResultFalse("OrderedSet{3, 4.0, 'test'}->excludes('test')");

		assertResultTrue("Sequence{3, 4.0, 'test'}->excludes(3.0)");
		assertResultTrue("Sequence{3, 4.0, 'test'}->excludes(4)");
		assertResultTrue("Bag{3, 4.0, 'test'}->excludes(3.0)");
		assertResultTrue("Bag{3, 4.0, 'test'}->excludes(4)");
		assertResultTrue("Set{3, 4.0, 'test'}->excludes(3.0)");
		assertResultTrue("Set{3, 4.0, 'test'}->excludes(4)");
		assertResultTrue("OrderedSet{3, 4.0, 'test'}->excludes(3.0)");
		assertResultTrue("OrderedSet{3, 4.0, 'test'}->excludes(4)");
	}

	public void testCollectionExcludesAll() {
		assertResultFalse("Sequence{3, 4.0, 'test'}->excludesAll(Sequence{3, 'test'})");
		assertResultFalse("Sequence{3, 4.0, 'test'}->excludesAll(Bag{3, 'test'})");
		assertResultFalse("Sequence{3, 4.0, 'test'}->excludesAll(Set{3, 'test'})");
		assertResultFalse("Sequence{3, 4.0, 'test'}->excludesAll(OrderedSet{3, 'test'})");
		assertResultFalse("Bag{3, 4.0, 'test'}->excludesAll(Sequence{3, 'test'})");
		assertResultFalse("Bag{3, 4.0, 'test'}->excludesAll(Bag{3, 'test'})");
		assertResultFalse("Bag{3, 4.0, 'test'}->excludesAll(Set{3, 'test'})");
		assertResultFalse("Bag{3, 4.0, 'test'}->excludesAll(OrderedSet{3, 'test'})");
		assertResultFalse("Set{3, 4.0, 'test'}->excludesAll(Sequence{3, 'test'})");
		assertResultFalse("Set{3, 4.0, 'test'}->excludesAll(Bag{3, 'test'})");
		assertResultFalse("Set{3, 4.0, 'test'}->excludesAll(Set{3, 'test'})");
		assertResultFalse("Set{3, 4.0, 'test'}->excludesAll(OrderedSet{3, 'test'})");
		assertResultFalse("OrderedSet{3, 4.0, 'test'}->excludesAll(Sequence{3, 'test'})");
		assertResultFalse("OrderedSet{3, 4.0, 'test'}->excludesAll(Bag{3, 'test'})");
		assertResultFalse("OrderedSet{3, 4.0, 'test'}->excludesAll(Set{3, 'test'})");
		assertResultFalse("OrderedSet{3, 4.0, 'test'}->excludesAll(OrderedSet{3, 'test'})");

		assertResultTrue("Sequence{3, 4.0, 'test'}->excludesAll(Sequence{3.0, 4, 'TEST'})");
		assertResultTrue("Sequence{3, 4.0, 'test'}->excludesAll(Bag{3.0, 4, 'TEST'})");
		assertResultTrue("Sequence{3, 4.0, 'test'}->excludesAll(Set{3.0, 4, 'TEST'})");
		assertResultTrue("Sequence{3, 4.0, 'test'}->excludesAll(OrderedSet{3.0, 4, 'TEST'})");
		assertResultTrue("Bag{3, 4.0, 'test'}->excludesAll(Sequence{3.0, 4, 'TEST'})");
		assertResultTrue("Bag{3, 4.0, 'test'}->excludesAll(Bag{3.0, 4, 'TEST'})");
		assertResultTrue("Bag{3, 4.0, 'test'}->excludesAll(Set{3.0, 4, 'TEST'})");
		assertResultTrue("Bag{3, 4.0, 'test'}->excludesAll(OrderedSet{3.0, 4, 'TEST'})");
		assertResultTrue("Set{3, 4.0, 'test'}->excludesAll(Sequence{3.0, 4, 'TEST'})");
		assertResultTrue("Set{3, 4.0, 'test'}->excludesAll(Bag{3.0, 4, 'TEST'})");
		assertResultTrue("Set{3, 4.0, 'test'}->excludesAll(Set{3.0, 4, 'TEST'})");
		assertResultTrue("Set{3, 4.0, 'test'}->excludesAll(OrderedSet{3.0, 4, 'TEST'})");
		assertResultTrue("OrderedSet{3, 4.0, 'test'}->excludesAll(Sequence{3.0, 4, 'TEST'})");
		assertResultTrue("OrderedSet{3, 4.0, 'test'}->excludesAll(Bag{3.0, 4, 'TEST'})");
		assertResultTrue("OrderedSet{3, 4.0, 'test'}->excludesAll(Set{3.0, 4, 'TEST'})");
		assertResultTrue("OrderedSet{3, 4.0, 'test'}->excludesAll(OrderedSet{3.0, 4, 'TEST'})");
	}

	public void testCollectionExcludesAllInvalid() {
		assertResultInvalid("let s : Sequence(Integer) = invalid in s->excludesAll(Sequence{0})");
		assertResultInvalid("let b : Bag(Integer) = invalid in b->excludesAll(Bag{0})");
		assertResultInvalid("let s : Set(Integer) = invalid in s->excludesAll(Set{0})");
		assertResultInvalid("let os : OrderedSet(Integer) = invalid in os->excludesAll(OrderedSet{0})");

		assertResultInvalid("let s : Sequence(Integer) = invalid in Sequence{0}->excludesAll(s)");
		assertResultInvalid("let b : Bag(Integer) = invalid in Bag{0}->excludesAll(b)");
		assertResultInvalid("let s : Set(Integer) = invalid in Set{0}->excludesAll(s)");
		assertResultInvalid("let os : OrderedSet(Integer) = invalid in OrderedSet{0}->excludesAll(os)");
	}

	public void testCollectionExcludesAllInvalidValue() {
		// Collections can't contain the invalid value
		assertResultInvalid("Sequence{3, 4, invalid, 'test'}->excludesAll(OrderedSet{'test'})");
		assertResultInvalid("Bag{3, 4, invalid, 'test'}->excludesAll(Set{'test'})");
		assertResultInvalid("Set{3, 4, invalid, 'test'}->excludesAll(Bag{'test'})");
		assertResultInvalid("OrderedSet{3, 4, invalid, 'test'}->excludesAll(Sequence{'test'})");

		assertResultInvalid("Sequence{3, 4, 'test'}->excludesAll(OrderedSet{'test', invalid})");
		assertResultInvalid("Bag{3, 4, 'test'}->excludesAll(Set{'test', invalid})");
		assertResultInvalid("Set{3, 4, 'test'}->excludesAll(Bag{'test', invalid})");
		assertResultInvalid("OrderedSet{3, 4, 'test'}->excludesAll(Sequence{'test', invalid})");
	}

	public void testCollectionExcludesAllNull() {
		assertResultInvalid("let s : Sequence(Integer) = null in s->excludesAll(Sequence{0})");
		assertResultInvalid("let b : Bag(Integer) = null in b->excludesAll(Bag{0})");
		assertResultInvalid("let s : Set(Integer) = null in s->excludesAll(Set{0})");
		assertResultInvalid("let os : OrderedSet(Integer) = null in os->excludesAll(OrderedSet{0})");

		assertResultInvalid("let s : Sequence(Integer) = null in Sequence{0}->excludesAll(s)");
		assertResultInvalid("let b : Bag(Integer) = null in Bag{0}->excludesAll(b)");
		assertResultInvalid("let s : Set(Integer) = null in Set{0}->excludesAll(s)");
		assertResultInvalid("let os : OrderedSet(Integer) = null in OrderedSet{0}->excludesAll(os)");
	}

	public void testCollectionExcludesAllNullValue() {
		assertResultFalse("Sequence{3, 4, null, 'test'}->excludesAll(OrderedSet{'TEST', null})");
		assertResultFalse("Bag{3, 4, null, 'test'}->excludesAll(Set{'TEST', null})");
		assertResultFalse("Set{3, 4, null, 'test'}->excludesAll(Bag{'TEST', null})");
		assertResultFalse("OrderedSet{3, 4, null, 'test'}->excludesAll(Sequence{'TEST', null})");

		assertResultTrue("Sequence{3, 4, 'test'}->excludesAll(OrderedSet{'TEST', null})");
		assertResultTrue("Bag{3, 4, 'test'}->excludesAll(Set{'TEST', null})");
		assertResultTrue("Set{3, 4, 'test'}->excludesAll(Bag{'TEST', null})");
		assertResultTrue("OrderedSet{3, 4, 'test'}->excludesAll(Sequence{'TEST', null})");
	}

	public void testCollectionExcludesInvalid() {
		assertResultInvalid("let s : Sequence(Integer) = invalid in s->excludes(0)");
		assertResultInvalid("let b : Bag(Integer) = invalid in b->excludes(0)");
		assertResultInvalid("let s : Set(Integer) = invalid in s->excludes(0)");
		assertResultInvalid("let os : OrderedSet(Integer) = invalid in os->excludes(0)");
	}

	public void testCollectionExcludesInvalidValue() {
		assertResultInvalid("Sequence{3, 4.0, 'test'}->excludes(invalid)");
		assertResultInvalid("Bag{3, 4.0, 'test'}->excludes(invalid)");
		assertResultInvalid("Set{3, 4.0, 'test'}->excludes(invalid)");
		assertResultInvalid("OrderedSet{3, 4.0, 'test'}->excludes(invalid)");

		assertResultInvalid("Sequence{0, invalid}->excludes(0)");
		assertResultInvalid("Bag{0, invalid}->excludes(0)");
		assertResultInvalid("Set{0, invalid}->excludes(0)");
		assertResultInvalid("OrderedSet{0, invalid}->excludes(0)");
	}

	public void testCollectionExcludesNull() {
		assertResultInvalid("let s : Sequence(Integer) = null in s->excludes(0)");
		assertResultInvalid("let b : Bag(Integer) = null in b->excludes(0)");
		assertResultInvalid("let s : Set(Integer) = null in s->excludes(0)");
		assertResultInvalid("let os : OrderedSet(Integer) = null in os->excludes(0)");
	}

	public void testCollectionExcludesNullValue() {
		assertResultFalse("Sequence{3, 4.0, null, 'test'}->excludes(null)");
		assertResultFalse("Sequence{null}->excludes(null)");
		assertResultFalse("Bag{3, 4.0, null, 'test'}->excludes(null)");
		assertResultFalse("Bag{null}->excludes(null)");
		assertResultFalse("Set{3, 4.0, null, 'test'}->excludes(null)");
		// Set{null} has special semantics due to the implicit set conversion
		// in x->... for the case where x==null. Therefore, Set{null} evaluates
		// to an empty set which therefore excludes null.
		assertResultTrue("Set{null}->excludes(null)");
		assertResultFalse("OrderedSet{3, 4.0, null, 'test'}->excludes(null)");
		assertResultFalse("OrderedSet{null}->excludes(null)");

		assertResultTrue("Sequence{3, 4.0, 'test'}->excludes(null)");
		assertResultTrue("Sequence{}->excludes(null)");
		assertResultTrue("Bag{3, 4.0, 'test'}->excludes(null)");
		assertResultTrue("Bag{}->excludes(null)");
		assertResultTrue("Set{3, 4.0, 'test'}->excludes(null)");
		assertResultTrue("Set{}->excludes(null)");
		assertResultTrue("OrderedSet{3, 4.0, 'test'}->excludes(null)");
		assertResultTrue("OrderedSet{}->excludes(null)");
	}

	public void testCollectionExcluding() {
		/*
		 * FIXME raise issue for adding OrderedSet::excluding ... especially
		 * since it's defined in oclstdlib.ecore. However the defined
		 * "OrderedSet::excluding(T) : Set" should be
		 * "OrderedSet::excluding(T) : OrderedSet"
		 */
		assertExpressionResults("Sequence{'a', 'c'}", "Sequence{'b', 'a', 'b', 'c'}->excluding('b')");
		assertExpressionResults("Bag{'c', 'a'}", "Bag{'b', 'a', 'b', 'c'}->excluding('b')");
		assertExpressionResults("Set{'c', 'a'}", "Set{'a', 'b', 'c'}->excluding('b')");
		assertExpressionResults("OrderedSet{'a', 'c'}", "OrderedSet{'a', 'b', 'c'}->excluding('b')");
	}

	public void testCollectionExcludingInvalid() {
		assertResultInvalid("let s : Sequence(String) = invalid in s->excluding('a')");
		assertResultInvalid("let b : Bag(String) = invalid in b->excluding('a')");
		assertResultInvalid("let s : Set(String) = invalid in s->excluding('a')");
		assertResultInvalid("let o : OrderedSet(String) = invalid in o->excluding('a')");
	}

	public void testCollectionExcludingInvalidValue() {
		assertResultInvalid("Sequence{'a', 'b'}->excluding(invalid)");
		assertResultInvalid("Bag{'a', 'b'}->excluding(invalid)");
		assertResultInvalid("Set{'a', 'b'}->excluding(invalid)");
		assertResultInvalid("OrderedSet{'a', 'b'}->excluding(invalid)");
	}

	public void testCollectionExcludingNull() {
		assertResultInvalid("let s : Sequence(String) = null in s->excluding('a')");
		assertResultInvalid("let b : Bag(String) = null in b->excluding('a')");
		assertResultInvalid("let s : Set(String) = null in s->excluding('a')");
		assertResultInvalid("let o : OrderedSet(String) = null in o->excluding('a')");
	}

	public void testCollectionExcludingNullValue() {
		// FIXME passes as a side effect of bug 283518
		assertExpressionResults("Sequence{'a', 'b'}", "Sequence{null, 'a', null, 'b'}->excluding(null)");
		assertExpressionResults("Bag{'b', 'a'}", "Bag{null, 'a', null, 'b'}->excluding(null)");
		assertExpressionResults("Set{'b', 'a'}", "Set{'a', null, 'b'}->excluding(null)");
		assertExpressionResults("OrderedSet{'a', 'b'}", "OrderedSet{'a', null, 'b'}->excluding(null)");
	}

	public void testCollectionFirst() {
		assertResultInvalid("Sequence{}->first()");
		assertResultInvalid("OrderedSet{}->first()");

		assertResult(Integer.valueOf(1), "Sequence{1, 2.0, '3'}->first()");
		assertResult(Integer.valueOf(1), "OrderedSet{1, 2.0, '3'}->first()");
	}

	public void testCollectionFirstInvalid() {
		assertResultInvalid("let s : Sequence(Integer) = invalid in s->first()");
		assertResultInvalid("let o : OrderedSet(Integer) = invalid in o->first()");
	}

	public void testCollectionFirstInvalidValue() {
		assertResultInvalid("Sequence{1, invalid}->first()");
		assertResultInvalid("OrderedSet{1, invalid}->first()");
	}

	public void testCollectionFirstNull() {
		assertResultInvalid("let s : Sequence(Integer) = null in s->first()");
		assertResultInvalid("let o : OrderedSet(Integer) = null in o->first()");
	}

	public void testCollectionFirstNullValue() {
		assertResult(null, "Sequence{null}->first()");
		assertResult(null, "OrderedSet{null}->first()");
	}

	public void testCollectionFlatten() {
		assertResult(CollectionUtil.createNewSequence(),
			"Sequence{}->flatten()");
		assertResult(CollectionUtil.createNewBag(), "Bag{}->flatten()");
		assertResult(CollectionUtil.createNewSet(), "Set{}->flatten()");
		// Our implementation chooses to flatten an OrderedSet into an OrderedSet because
		// Section A.2.5.8 of OCL 2.3 (OMG 10-11-42) leaves it unspecified
		assertResult(CollectionUtil.createNewOrderedSet(),
			"OrderedSet{}->flatten()");

		String expression = "Sequence{Set{1,2,3}, Sequence{2.0, 3.0}, Bag{'test'}}->flatten()";
		String expectedResultExpression = "Sequence{1, 2, 3, 2.0, 3.0, 'test'}";
		/*
		 * as the Sequence is ordered and we cannot know in which order the
		 * result of the Set flatenning were inserted, simply check that the
		 * result is a Sequence and contains all elements.
		 */
		assertResultContainsAll(expectedResultExpression, expression);

		expression = "Bag{Set{Bag{'test', 2, 3.0}}, Sequence{OrderedSet{2.0, 3, 1}}}->flatten()";
		expectedResultExpression = "Bag{1, 2, 3, 2.0, 3.0, 'test'}";
		assertExpressionResults(expectedResultExpression, expression);

		expression = "Set{OrderedSet{Set{3.0, 'test'}, Sequence{2.0, 2}, Bag{1, 3}}}->flatten()";
		expectedResultExpression = "Set{1, 2, 3, 2.0, 3.0, 'test'}";
		assertExpressionResults(expectedResultExpression, expression);

		// FIXME The following doesn't currently work because equal numeric values of different
		// types are inserted as distinct elements into Set/OrderedSet based on Java
		// object semantics.
		// expression = "OrderedSet{Set{Set{3.0, 'test'}, Sequence{2.0, 2}, Bag{1, 3}}}->flatten()";
		// expectedResultExpression = "OrderedSet{1, 2, 3, 2.0, 3.0, 'test'}";
		/*
		 * as the OrderedSet is ordered and we cannot know in which order the
		 * result of the Set flatenning were inserted, simply check that the
		 * result is an OrderedSet and contains all elements.
		 */
		// FIXME OrderedSet::flatten() : Set should be OrderedSet::flatten() :
		// OrderedSet
		// assertResultContainsAll(expectedResultExpression, expression);

		// expression = "Set{Sequence{Sequence{3.0, 'test'}}, Sequence{Sequence{2.0, 2}, Sequence{1, 3}}}->flatten()";
		// expectedResultExpression = "Set{1, 2, 3, 2.0, 3.0, 'test'}";
		// assertExpressionResults(expectedResultExpression, expression);
	}

	public void testCollectionFlattenInvalid() {
		assertResultInvalid("let s : Sequence(Integer) = invalid in s->flatten()");
		assertResultInvalid("let b : Bag(Integer) = invalid in b->flatten()");
		assertResultInvalid("let s : Set(Integer) = invalid in s->flatten()");
		assertResultInvalid("let o : OrderedSet(Integer) = invalid in o->flatten()");
	}

	public void testCollectionFlattenNull() {
		assertResultInvalid("let s : Sequence(Integer) = null in s->flatten()");
		assertResultInvalid("let b : Bag(Integer) = null in b->flatten()");
		assertResultInvalid("let s : Set(Integer) = null in s->flatten()");
		assertResultInvalid("let o : OrderedSet(Integer) = null in o->flatten()");
	}

	public void testCollectionIncludes() {
		assertResultTrue("Sequence{3, 4.0, 'test'}->includes(3)");
		assertResultTrue("Sequence{3, 4.0, 'test'}->includes('test')");
		assertResultTrue("Bag{3, 4.0, 'test'}->includes(3)");
		assertResultTrue("Bag{3, 4.0, 'test'}->includes('test')");
		assertResultTrue("Set{3, 4.0, 'test'}->includes(3)");
		assertResultTrue("Set{3, 4.0, 'test'}->includes('test')");
		assertResultTrue("OrderedSet{3, 4.0, 'test'}->includes(3)");
		assertResultTrue("OrderedSet{3, 4.0, 'test'}->includes('test')");

		assertResultFalse("Sequence{3, 4.0, 'test'}->includes(3.0)");
		assertResultFalse("Sequence{3, 4.0, 'test'}->includes(4)");
		assertResultFalse("Bag{3, 4.0, 'test'}->includes(3.0)");
		assertResultFalse("Bag{3, 4.0, 'test'}->includes(4)");
		assertResultFalse("Set{3, 4.0, 'test'}->includes(3.0)");
		assertResultFalse("Set{3, 4.0, 'test'}->includes(4)");
		assertResultFalse("OrderedSet{3, 4.0, 'test'}->includes(3.0)");
		assertResultFalse("OrderedSet{3, 4.0, 'test'}->includes(4)");
	}

	public void testCollectionIncludesAll() {
		assertResultTrue("Sequence{3, 4.0, 'test'}->includesAll(Sequence{3, 'test'})");
		assertResultTrue("Sequence{3, 4.0, 'test'}->includesAll(Bag{3, 'test'})");
		assertResultTrue("Sequence{3, 4.0, 'test'}->includesAll(Set{3, 'test'})");
		assertResultTrue("Sequence{3, 4.0, 'test'}->includesAll(OrderedSet{3, 'test'})");
		assertResultTrue("Bag{3, 4.0, 'test'}->includesAll(Sequence{3, 'test'})");
		assertResultTrue("Bag{3, 4.0, 'test'}->includesAll(Bag{3, 'test'})");
		assertResultTrue("Bag{3, 4.0, 'test'}->includesAll(Set{3, 'test'})");
		assertResultTrue("Bag{3, 4.0, 'test'}->includesAll(OrderedSet{3, 'test'})");
		assertResultTrue("Set{3, 4.0, 'test'}->includesAll(Sequence{3, 'test'})");
		assertResultTrue("Set{3, 4.0, 'test'}->includesAll(Bag{3, 'test'})");
		assertResultTrue("Set{3, 4.0, 'test'}->includesAll(Set{3, 'test'})");
		assertResultTrue("Set{3, 4.0, 'test'}->includesAll(OrderedSet{3, 'test'})");
		assertResultTrue("OrderedSet{3, 4.0, 'test'}->includesAll(Sequence{3, 'test'})");
		assertResultTrue("OrderedSet{3, 4.0, 'test'}->includesAll(Bag{3, 'test'})");
		assertResultTrue("OrderedSet{3, 4.0, 'test'}->includesAll(Set{3, 'test'})");
		assertResultTrue("OrderedSet{3, 4.0, 'test'}->includesAll(OrderedSet{3, 'test'})");

		assertResultFalse("Sequence{3, 4.0, 'test'}->includesAll(Sequence{3, 4, 'test'})");
		assertResultFalse("Sequence{3, 4.0, 'test'}->includesAll(Bag{3, 4, 'test'})");
		assertResultFalse("Sequence{3, 4.0, 'test'}->includesAll(Set{3, 4, 'test'})");
		assertResultFalse("Sequence{3, 4.0, 'test'}->includesAll(OrderedSet{3, 4, 'test'})");
		assertResultFalse("Bag{3, 4.0, 'test'}->includesAll(Sequence{3, 4, 'test'})");
		assertResultFalse("Bag{3, 4.0, 'test'}->includesAll(Bag{3, 4, 'test'})");
		assertResultFalse("Bag{3, 4.0, 'test'}->includesAll(Set{3, 4, 'test'})");
		assertResultFalse("Bag{3, 4.0, 'test'}->includesAll(OrderedSet{3, 4, 'test'})");
		assertResultFalse("Set{3, 4.0, 'test'}->includesAll(Sequence{3, 4, 'test'})");
		assertResultFalse("Set{3, 4.0, 'test'}->includesAll(Bag{3, 4, 'test'})");
		assertResultFalse("Set{3, 4.0, 'test'}->includesAll(Set{3, 4, 'test'})");
		assertResultFalse("Set{3, 4.0, 'test'}->includesAll(OrderedSet{3, 4, 'test'})");
		assertResultFalse("OrderedSet{3, 4.0, 'test'}->includesAll(Sequence{3, 4, 'test'})");
		assertResultFalse("OrderedSet{3, 4.0, 'test'}->includesAll(Bag{3, 4, 'test'})");
		assertResultFalse("OrderedSet{3, 4.0, 'test'}->includesAll(Set{3, 4, 'test'})");
		assertResultFalse("OrderedSet{3, 4.0, 'test'}->includesAll(OrderedSet{3, 4, 'test'})");
	}

	public void testCollectionIncludesAllInvalid() {
		assertResultInvalid("let s : Sequence(Integer) = invalid in s->includesAll(Sequence{0})");
		assertResultInvalid("let b : Bag(Integer) = invalid in b->includesAll(Bag{0})");
		assertResultInvalid("let s : Set(Integer) = invalid in s->includesAll(Set{0})");
		assertResultInvalid("let os : OrderedSet(Integer) = invalid in os->includesAll(OrderedSet{0})");

		assertResultInvalid("let s : Sequence(Integer) = invalid in Sequence{0}->includesAll(s)");
		assertResultInvalid("let b : Bag(Integer) = invalid in Bag{0}->includesAll(b)");
		assertResultInvalid("let s : Set(Integer) = invalid in Set{0}->includesAll(s)");
		assertResultInvalid("let os : OrderedSet(Integer) = invalid in OrderedSet{0}->includesAll(os)");
	}

	public void testCollectionIncludesAllInvalidValue() {
		// Collections can't contain the invalid value
		assertResultInvalid("Sequence{3, 4, invalid, 'test'}->includesAll(OrderedSet{'test'})");
		assertResultInvalid("Bag{3, 4, invalid, 'test'}->includesAll(Set{'test'})");
		assertResultInvalid("Set{3, 4, invalid, 'test'}->includesAll(Bag{'test'})");
		assertResultInvalid("OrderedSet{3, 4, invalid, 'test'}->includesAll(Sequence{'test'})");

		assertResultInvalid("Sequence{3, 4, 'test'}->includesAll(OrderedSet{'test', invalid})");
		assertResultInvalid("Bag{3, 4, 'test'}->includesAll(Set{'test', invalid})");
		assertResultInvalid("Set{3, 4, 'test'}->includesAll(Bag{'test', invalid})");
		assertResultInvalid("OrderedSet{3, 4, 'test'}->includesAll(Sequence{'test', invalid})");
	}

	public void testCollectionIncludesAllNull() {
		assertResultInvalid("let s : Sequence(Integer) = null in s->includesAll(Sequence{0})");
		assertResultInvalid("let b : Bag(Integer) = null in b->includesAll(Bag{0})");
		assertResultInvalid("let s : Set(Integer) = null in s->includesAll(Set{0})");
		assertResultInvalid("let os : OrderedSet(Integer) = null in os->includesAll(OrderedSet{0})");

		assertResultInvalid("let s : Sequence(Integer) = null in Sequence{0}->includesAll(s)");
		assertResultInvalid("let b : Bag(Integer) = null in Bag{0}->includesAll(b)");
		assertResultInvalid("let s : Set(Integer) = null in Set{0}->includesAll(s)");
		assertResultInvalid("let os : OrderedSet(Integer) = null in OrderedSet{0}->includesAll(os)");
	}

	public void testCollectionIncludesAllNullValue() {
		assertResultTrue("Sequence{3, 4, null, 'test'}->includesAll(OrderedSet{'test', null})");
		assertResultTrue("Bag{3, 4, null, 'test'}->includesAll(Set{'test', null})");
		assertResultTrue("Set{3, 4, null, 'test'}->includesAll(Bag{'test', null})");
		assertResultTrue("OrderedSet{3, 4, null, 'test'}->includesAll(Sequence{'test', null})");

		assertResultFalse("Sequence{3, 4, 'test'}->includesAll(OrderedSet{'test', null})");
		assertResultFalse("Bag{3, 4, 'test'}->includesAll(Set{'test', null})");
		assertResultFalse("Set{3, 4, 'test'}->includesAll(Bag{'test', null})");
		assertResultFalse("OrderedSet{3, 4, 'test'}->includesAll(Sequence{'test', null})");
	}

	public void testCollectionIncludesInvalid() {
		assertResultInvalid("let s : Sequence(Integer) = invalid in s->includes(0)");
		assertResultInvalid("let b : Bag(Integer) = invalid in b->includes(0)");
		assertResultInvalid("let s : Set(Integer) = invalid in s->includes(0)");
		assertResultInvalid("let os : OrderedSet(Integer) = invalid in os->includes(0)");
	}

	public void testCollectionIncludesInvalidValue() {
		assertResultInvalid("Sequence{3, 4.0, 'test'}->includes(invalid)");
		assertResultInvalid("Bag{3, 4.0, 'test'}->includes(invalid)");
		assertResultInvalid("Set{3, 4.0, 'test'}->includes(invalid)");
		assertResultInvalid("OrderedSet{3, 4.0, 'test'}->includes(invalid)");

		assertResultInvalid("Sequence{0, invalid}->includes(0)");
		assertResultInvalid("Bag{0, invalid}->includes(0)");
		assertResultInvalid("Set{0, invalid}->includes(0)");
		assertResultInvalid("OrderedSet{0, invalid}->includes(0)");
	}

	public void testCollectionIncludesNull() {
		assertResultInvalid("let s : Sequence(Integer) = null in s->includes(0)");
		assertResultInvalid("let b : Bag(Integer) = null in b->includes(0)");
		assertResultInvalid("let s : Set(Integer) = null in s->includes(0)");
		assertResultInvalid("let os : OrderedSet(Integer) = null in os->includes(0)");
	}

	public void testCollectionIncludesNullValue() {
		assertResultTrue("Sequence{3, 4.0, null, 'test'}->includes(null)");
		assertResultTrue("Sequence{null}->includes(null)");
		assertResultTrue("Bag{3, 4.0, null, 'test'}->includes(null)");
		assertResultTrue("Bag{null}->includes(null)");
		assertResultTrue("Set{3, 4.0, null, 'test'}->includes(null)");
		// the following results in an empty set according to OCL spec 11.2.3,
		// used by implicit Set conversion when -> is used on a null value
		assertResultFalse("Set{null}->includes(null)");
		assertResultTrue("OrderedSet{3, 4.0, null, 'test'}->includes(null)");
		assertResultTrue("OrderedSet{null}->includes(null)");

		assertResultFalse("Sequence{3, 4.0, 'test'}->includes(null)");
		assertResultFalse("Sequence{}->includes(null)");
		assertResultFalse("Bag{3, 4.0, 'test'}->includes(null)");
		assertResultFalse("Bag{}->includes(null)");
		assertResultFalse("Set{3, 4.0, 'test'}->includes(null)");
		assertResultFalse("Set{}->includes(null)");
		assertResultFalse("OrderedSet{3, 4.0, 'test'}->includes(null)");
		assertResultFalse("OrderedSet{}->includes(null)");
	}

	public void testCollectionIncluding() {
		/*
		 * FIXME raise issue for adding OrderedSet::including ... especially
		 * since it's defined in oclstdlib.ecore. However the defined
		 * "OrderedSet::including(T) : Set" should be
		 * "OrderedSet::including(T) : OrderedSet"
		 */
		assertExpressionResults("Sequence{'a', 'b', 'c'}", "Sequence{'a', 'b'}->including('c')");
		assertExpressionResults("Bag{'c', 'b', 'a'}", "Bag{'a', 'b'}->including('c')");
		assertExpressionResults("Set{'a', 'c', 'b'}", "Set{'a', 'b'}->including('c')");
		assertExpressionResults("OrderedSet{'a', 'b', 'c'}", "OrderedSet{'a', 'b'}->including('c')");
	}

	public void testCollectionIncludingInvalid() {
		assertResultInvalid("let s : Sequence(String) = invalid in s->including('a')");
		assertResultInvalid("let b : Bag(String) = invalid in b->including('a')");
		assertResultInvalid("let s : Set(String) = invalid in s->including('a')");
		assertResultInvalid("let o : OrderedSet(String) = invalid in o->including('a')");
	}

	public void testCollectionIncludingInvalidValue() {
		assertResultInvalid("Sequence{'a', 'b'}->including(invalid)");
		assertResultInvalid("Bag{'a', 'b'}->including(invalid)");
		assertResultInvalid("Set{'a', 'b'}->including(invalid)");
		assertResultInvalid("OrderedSet{'a', 'b'}->including(invalid)");
	}

	public void testCollectionIncludingNull() {
		assertResultInvalid("let s : Sequence(String) = null in s->including('a')");
		assertResultInvalid("let b : Bag(String) = null in b->including('a')");
		assertResultInvalid("let s : Set(String) = null in s->including('a')");
		assertResultInvalid("let o : OrderedSet(String) = null in o->including('a')");
	}

	public void testCollectionIncludingNullValue() {
		assertExpressionResults("Sequence{'a', 'b', null}", "Sequence{'a', 'b'}->including(null)");
		assertExpressionResults("Bag{null, 'b', 'a'}", "Bag{'a', 'b'}->including(null)");
		assertExpressionResults("Set{'a', null, 'b'}", "Set{'a', 'b'}->including(null)");
		assertExpressionResults("OrderedSet{'a', 'b', null}", "OrderedSet{'a', 'b'}->including(null)");
	}

	public void testCollectionIndexOf() {
		assertResult(Integer.valueOf(1), "Sequence{'a', 'b'}->indexOf('a')");
		assertResult(Integer.valueOf(2), "OrderedSet{'a', 'b'}->indexOf('b')");
	}

	public void testCollectionIndexOfInvalid() {
		assertResultInvalid("let s : Sequence(String) = invalid in s->indexOf('a')");
		assertResultInvalid("let o : OrderedSet(String) = invalid in o->indexOf('a')");
	}

	public void testCollectionIndexOfInvalidValue() {
		assertResultInvalid("Sequence{'a', invalid}->indexOf(invalid)");
		assertResultInvalid("OrderedSet{'a', invalid}->indexOf(invalid)");
	}

	public void testCollectionIndexOfNotContained() {
		/*
		 * FIXME raise issue for the result of this to be "0" or "-1" instead of
		 * the invalid value
		 */
		assertResultInvalid("Sequence{'a'}->indexOf('b')");
		assertResultInvalid("OrderedSet{'a'}->indexOf('b')");
	}

	public void testCollectionIndexOfNull() {
		assertResultInvalid("let s : Sequence(String) = null in s->indexOf('a')");
		assertResultInvalid("let o : OrderedSet(String) = null in o->indexOf('a')");
	}

	public void testCollectionIndexOfNullValue() {
		assertResult(Integer.valueOf(1), "Sequence{null, 'a'}->indexOf(null)");
		assertResult(Integer.valueOf(1), "OrderedSet{null, 'a'}->indexOf(null)");
	}

	public void testCollectionInsertAt() {
		assertExpressionResults("Sequence{'c', 'a', 'b'}", "Sequence{'a', 'b'}->insertAt(1, 'c')");
		assertExpressionResults("OrderedSet{'a', 'c', 'b'}", "OrderedSet{'a', 'b'}->insertAt(2, 'c')");

		// We can add _after_ the last element
		assertExpressionResults("Sequence{'a', 'b', 'c'}", "Sequence{'a', 'b'}->insertAt(3, 'c')");
		assertExpressionResults("OrderedSet{'a', 'b', 'c'}", "OrderedSet{'a', 'b'}->insertAt(3, 'c')");
	}

	public void testCollectionInsertAtInvalid() {
		assertResultInvalid("let s : Sequence(String) = invalid in s->insertAt(1, 'a')");
		assertResultInvalid("let o : OrderedSet(String) = invalid in o->insertAt(1, 'a')");
	}

	public void testCollectionInsertAtInvalidValue() {
		assertResultInvalid("Sequence{'a'}->insertAt(1, invalid)");
		assertResultInvalid("OrderedSet{'a'}->insertAt(1, invalid)");
	}

	public void testCollectionInsertAtNull() {
		assertResultInvalid("let s : Sequence(String) = null in s->insertAt(1, 'a')");
		assertResultInvalid("let o : OrderedSet(String) = null in o->insertAt(1, 'a')");
	}

	public void testCollectionInsertAtNullValue() {
		/*
		 * FIXME cannot "insertAt" a null value with the current implementation.
		 * lines 1161 to 1166 of the EvaluationVisitorImpl :
		 */
		// Object arg2 = args.get(1).accept(getVisitor());
		//
		// // check if undefined
		// if (isUndefined(arg2)) {
		// return getinvalid();
		// }
		assertExpressionResults("Sequence{'a', null}", "Sequence{'a'}->insertAt(2, null)");
		assertExpressionResults("OrderedSet{'a', null}", "OrderedSet{'a'}->insertAt(2, null)");
	}

	public void testCollectionInsertAtOutOfBounds() {
		assertResultInvalid("Sequence{'a'}->insertAt(0, 'b')");
		assertResultInvalid("OrderedSet{'a'}->insertAt(0, 'b')");

		assertResultInvalid("Sequence{'a'}->insertAt(3, 'b')");
		assertResultInvalid("OrderedSet{'a'}->insertAt(3, 'b')");
	}

	public void testCollectionIntersectionDuplicates() {
		assertExpressionResults("Set{'a', 'b'}", "Set{'a', 'b', 'a'}->intersection(Set{'a', 'b', 'c'})");
		assertExpressionResults("Set{'a', 'b'}", "Set{'a', 'b', 'a'}->intersection(Bag{'a', 'b', 'c'})");
		assertExpressionResults("Set{'a', 'b'}", "Bag{'a', 'b', 'a'}->intersection(Set{'a', 'b', 'c'})");
		// FIXME : The specification tells us we should be expecting the least
		// amount of occurences as the result of the
		// intersection of two bags. The expected results should then be :
		// "Bag{'a', 'b', 'a'}->intersection(Bag{'a', 'b'})" == "Bag{'a', 'b'}"
		// and
		// "Bag{'a', 'b', 'a', 'b'}->intersection(Bag{'a', 'b', 'b'})" ==
		// "Bag{'a', 'b', 'b'}"

		// Note that the current implementation sports a bug : we take into
		// account the "smaller" bag and copy its elements if they're contained
		// by the "greater" so that
		// "Bag{'a', 'b', 'a'}->intersection(Bag{'a', 'b'})" == "Bag{'a', 'b'}"
		// and
		// "Bag{'a', 'b', 'a'}->intersection(Bag{'a', 'b', 'c'})" ==
		// "Bag{'a', 'a', 'b'}"
		assertExpressionResults("Bag{'a', 'b'}", "Bag{'a', 'b', 'a'}->intersection(Bag{'a', 'b'})");
		assertExpressionResults("Bag{'a', 'b', 'b'}", "Bag{'a', 'b', 'a', 'b'}->intersection(Bag{'a', 'b', 'b'})");
	}

	public void testCollectionIntersectionEmptyCollection() {
		assertResult(CollectionUtil.createNewSet(),
			"Set{3, 4}->intersection(Set{})");
		assertResult(CollectionUtil.createNewSet(),
			"Set{3, 4}->intersection(Bag{})");
		assertResult(CollectionUtil.createNewBag(),
			"Bag{3, 4}->intersection(Bag{})");
		assertResult(CollectionUtil.createNewSet(),
			"Bag{3, 4}->intersection(Set{})");

		assertResult(CollectionUtil.createNewSet(),
			"let s:Set(Integer)=Set{} in s->intersection(Set{3, 4})");
		assertResult(CollectionUtil.createNewSet(),
			"let s:Set(Integer)=Set{} in s->intersection(Bag{3, 4})");
		assertResult(CollectionUtil.createNewBag(),
			"let b:Bag(Integer)=Bag{} in b->intersection(Bag{3, 4})");
		assertResult(CollectionUtil.createNewSet(),
			"let b:Bag(Integer)=Bag{} in b->intersection(Set{3, 4})");
	}

	public void testCollectionIntersectionInvalid() {
		assertResultInvalid("let s : Set(Integer) = invalid in s->intersection(Set{4})");
		assertResultInvalid("let s : Set(Integer) = invalid in s->intersection(Bag{4})");
		assertResultInvalid("let b : Bag(Integer) = invalid in b->intersection(Set{4})");
		assertResultInvalid("let b : Bag(Integer) = invalid in b->intersection(Bag{4})");

		assertResultInvalid("let s : Set(Integer) = invalid in Set{4}->intersection(s)");
		assertResultInvalid("let s : Set(Integer) = invalid in Bag{4}->intersection(s)");
		assertResultInvalid("let b : Bag(Integer) = invalid in Set{4}->intersection(b)");
		assertResultInvalid("let b : Bag(Integer) = invalid in Bag{4}->intersection(b)");
	}

	public void testCollectionIntersectionInvalidValue() {
		assertResultInvalid("Set{3, 4}->intersection(Set{invalid})");
		assertResultInvalid("Set{3, invalid}->intersection(Bag{4})");
		assertResultInvalid("Bag{3, invalid}->intersection(Set{4})");
		assertResultInvalid("Bag{3, 4}->intersection(Bag{invalid})");
	}

	public void testCollectionIntersectionNoDuplicates() {
		assertResult(CollectionUtil.createNewSet(),
			"Set{'a', 'b'}->intersection(Set{'c', 'd'})");
		assertResult(CollectionUtil.createNewSet(),
			"Set{'a', 'b'}->intersection(Bag{'c', 'd'})");
		assertResult(CollectionUtil.createNewSet(),
			"Bag{'a', 'b'}->intersection(Set{'c', 'd'})");

		assertResult(CollectionUtil.createNewBag(),
			"Bag{'a', 'b'}->intersection(Bag{'c', 'd'})");
	}

	public void testCollectionIntersectionNull() {
		assertResultInvalid("let s : Set(Integer) = null in s->intersection(Set{4})");
		assertResultInvalid("let s : Set(Integer) = null in s->intersection(Bag{4})");
		assertResultInvalid("let b : Bag(Integer) = null in b->intersection(Set{4})");
		assertResultInvalid("let b : Bag(Integer) = null in b->intersection(Bag{4})");

		assertResultInvalid("let s : Set(Integer) = null in Set{4}->intersection(s)");
		assertResultInvalid("let s : Set(Integer) = null in Bag{4}->intersection(s)");
		assertResultInvalid("let b : Bag(Integer) = null in Set{4}->intersection(b)");
		assertResultInvalid("let b : Bag(Integer) = null in Bag{4}->intersection(b)");
	}

	public void testCollectionIntersectionNullValue() {
		assertExpressionResults("Set{2, null}", "Set{2, 3, null}->intersection(Set{2, 4, null})");
		assertExpressionResults("Set{2, null}", "Set{2, 3, null}->intersection(Bag{2, 4, null})");
		assertExpressionResults("Set{2, null}", "Bag{2, 3, null}->intersection(Set{2, 4, null})");
		assertExpressionResults("Bag{null, null}", "Bag{3, 4, null, null}->intersection(Bag{null, 2, null})");
	}

	public void testCollectionIsEmpty() {
		assertResultTrue("Sequence{}->isEmpty()");
		assertResultTrue("Bag{}->isEmpty()");
		assertResultTrue("Set{}->isEmpty()");
		assertResultTrue("OrderedSet{}->isEmpty()");

		assertResultFalse("Sequence{4, 4, 'test'}->isEmpty()");
		assertResultFalse("Bag{4, 4, 'test'}->isEmpty()");
		assertResultFalse("Set{4, 4, 'test'}->isEmpty()");
		assertResultFalse("OrderedSet{4, 4, 'test'}->isEmpty()");

		assertResultFalse("'test'->isEmpty()");
	}

	public void testCollectionIsEmptyInvalid() {
		assertResultInvalid("let s : Sequence(Integer) = invalid in s->isEmpty()");
		assertResultInvalid("let b : Bag(Integer) = invalid in b->isEmpty()");
		assertResultInvalid("let s : Set(Integer) = invalid in s->isEmpty()");
		assertResultInvalid("let o : OrderedSet(Integer) = invalid in o->isEmpty()");
	}

	public void testCollectionIsEmptyInvalidValue() {
		assertResultInvalid("Sequence{invalid}->isEmpty()");
		assertResultInvalid("Bag{invalid}->isEmpty()");
		assertResultInvalid("Set{invalid}->isEmpty()");
		assertResultInvalid("OrderedSet{invalid}->isEmpty()");

		assertResultInvalid("invalid->isEmpty()");
	}

	public void testCollectionIsEmptyNull() {
		assertResultInvalid("let s : Sequence(Integer) = null in s->isEmpty()");
		assertResultInvalid("let b : Bag(Integer) = null in b->isEmpty()");
		assertResultInvalid("let s : Set(Integer) = null in s->isEmpty()");
		assertResultInvalid("let o : OrderedSet(Integer) = null in o->isEmpty()");
	}

	public void testCollectionIsEmptyNullValue() {
		assertResultFalse("Sequence{null}->isEmpty()");
		assertResultFalse("Bag{null}->isEmpty()");
		// Set{null} is the exceptional case used by implicit set conversion with ->
		assertResultTrue("Set{null}->isEmpty()");
		assertResultFalse("OrderedSet{null}->isEmpty()");

		// 11.7.1 : clarification was added for this :
		assertResultTrue("null->isEmpty()");
	}

	public void testCollectionLast() {
		assertResultInvalid("Sequence{}->last()");
		assertResultInvalid("OrderedSet{}->last()");

		assertResult("3", "Sequence{1, 2.0, '3'}->last()"); //$NON-NLS-2$
		assertResult("3", "OrderedSet{1, 2.0, '3'}->last()"); //$NON-NLS-2$
	}

	public void testCollectionLastInvalid() {
		assertResultInvalid("let s : Sequence(Integer) = invalid in s->last()");
		assertResultInvalid("let o : OrderedSet(Integer) = invalid in o->last()");
	}

	public void testCollectionLastInvalidValue() {
		assertResultInvalid("Sequence{invalid, 1}->last()");
		assertResultInvalid("OrderedSet{invalid, 1}->last()");
	}

	public void testCollectionLastNull() {
		assertResultInvalid("let s : Sequence(Integer) = null in s->last()");
		assertResultInvalid("let o : OrderedSet(Integer) = null in o->last()");
	}

	public void testCollectionLastNullValue() {
		assertResult(null, "Sequence{null}->last()");
		assertResult(null, "OrderedSet{null}->last()");
	}

	public void testCollectionMinus() {
		assertExpressionResults("Set{'b'}", "Set{'a', 'b', 'c'} - Set{'c', 'a'}");
		/*
		 * FIXME this is no specified operation. If we define
		 * "OrderedSet::-(Set) : Set", we also need "Set::-(OrderedSet) : Set"
		 * and "OrderedSet::-(OrderedSet) : OrderedSet". That being said,
		 * "OrderedSet::-(Set) : Set" should be
		 * "OrderedSet::-(Set) : OrderedSet". revisit all "testCollectionMinus*"
		 * to add the new
		 */
		assertExpressionResults("Set{'b'}", "OrderedSet{'a', 'b', 'c'} - Set{'c', 'a'}");
	}

	public void testCollectionMinusInvalid() {
		assertResultInvalid("let s : Set(String) = invalid in s - Set{'c'}");
		assertResultInvalid("let s : Set(String) = invalid in Set{'a'} - s");
	}

	public void testCollectionMinusInvalidValue() {
		assertResultInvalid("Set{'a', invalid} - Set{'c', invalid}");
		assertResultInvalid("Set{'a', invalid} - Set{'c', 'a'}");
	}

	public void testCollectionMinusNull() {
		assertResultInvalid("let s : Set(String) = null in s - Set{'c', null}");
		assertResultInvalid("let s : Set(String) = null in Set{'a', null} - s");
	}

	public void testCollectionMinusNullValue() {
		assertExpressionResults("Set{'a'}", "Set{'a', null} - Set{'c', null}");
		assertExpressionResults("let s:Set(String)=Set{} in s->including(null)", "Set{'a', null} - Set{'c', 'a'}");
	}

	public void testCollectionNotEmpty() {
		assertResultFalse("Sequence{}->notEmpty()");
		assertResultFalse("Bag{}->notEmpty()");
		assertResultFalse("Set{}->notEmpty()");
		assertResultFalse("OrderedSet{}->notEmpty()");

		assertResultTrue("Sequence{4, 4, 'test'}->notEmpty()");
		assertResultTrue("Bag{4, 4, 'test'}->notEmpty()");
		assertResultTrue("Set{4, 4, 'test'}->notEmpty()");
		assertResultTrue("OrderedSet{4, 4, 'test'}->notEmpty()");

		assertResultTrue("'test'->notEmpty()");
	}

	public void testCollectionNotEmptyInvalid() {
		assertResultInvalid("let s : Sequence(Integer) = invalid in s->notEmpty()");
		assertResultInvalid("let b : Bag(Integer) = invalid in b->notEmpty()");
		assertResultInvalid("let s : Set(Integer) = invalid in s->notEmpty()");
		assertResultInvalid("let o : OrderedSet(Integer) = invalid in o->notEmpty()");
	}

	public void testCollectionNotEmptyInvalidValue() {
		assertResultInvalid("Sequence{invalid}->notEmpty()");
		assertResultInvalid("Bag{invalid}->notEmpty()");
		assertResultInvalid("Set{invalid}->notEmpty()");
		assertResultInvalid("OrderedSet{invalid}->notEmpty()");

		assertResultInvalid("invalid->notEmpty()");
	}

	public void testCollectionNotEmptyNull() {
		assertResultInvalid("let s : Sequence(Integer) = null in s->notEmpty()");
		assertResultInvalid("let b : Bag(Integer) = null in b->notEmpty()");
		assertResultInvalid("let s : Set(Integer) = null in s->notEmpty()");
		assertResultInvalid("let o : OrderedSet(Integer) = null in o->notEmpty()");
	}

	public void testCollectionNotEmptyNullValue() {
		assertResultTrue("Sequence{null}->notEmpty()");
		assertResultTrue("Bag{null}->notEmpty()");
		// Set{null} is the special case for an empty set because of implicit -> conversion
		assertResultFalse("Set{null}->notEmpty()");
		assertResultTrue("OrderedSet{null}->notEmpty()");

		assertResultFalse("null->notEmpty()");
	}

	public void testCollectionNotEqualInvalid() {
		// operation invocations on invalid except for oclIsInvalid and oclIsUndefined yield invalid
		assertResultInvalid("let s : Sequence(Integer) = invalid in s <> Sequence{5}");
		assertResultInvalid("let b : Bag(Integer) = invalid in Bag{5} <> b");
		assertResultInvalid("let s : Set(Integer) = invalid in s <> Set{5}");
		assertResultInvalid("let o : OrderedSet(Integer) = invalid in OrderedSet{5} <> o");

		assertResultInvalid("let s1 : Sequence(Integer) = invalid, s2 : Sequence(Integer) = invalid in s1 <> s2");
		assertResultInvalid("let b1 : Bag(Integer) = invalid, b2 : Bag(Integer) = invalid in b1 <> b2");
		assertResultInvalid("let s1 : Set(Integer) = invalid, s2 : Set(Integer) = invalid in s1 <> s2");
		assertResultInvalid("let o1 : OrderedSet(Integer) = invalid, o2 : OrderedSet(Integer) = invalid in o1 <> o2");
	}

	public void testCollectionNotEqualNull() {
		assertResultTrue("let s : Sequence(Integer) = null in s <> Sequence{5}");
		assertResultTrue("let b : Bag(Integer) = null in Bag{5} <> b");
		assertResultTrue("let s : Set(Integer) = null in s <> Set{5}");
		assertResultTrue("let o : OrderedSet(Integer) = null in OrderedSet{5} <> o");

		assertResultFalse("let s1 : Sequence(Integer) = null, s2 : Sequence(Integer) = null in s1 <> s2");
		assertResultFalse("let b1 : Bag(Integer) = null, b2 : Bag(Integer) = null in b1 <> b2");
		assertResultFalse("let s1 : Set(Integer) = null, s2 : Set(Integer) = null in s1 <> s2");
		assertResultFalse("let o1 : OrderedSet(Integer) = null, o2 : OrderedSet(Integer) = null in o1 <> o2");
	}

	public void testCollectionNotEqualOrderedXOrdered() {
		// same order, same quantities
		assertResultFalse("Sequence{4, 5, 'test'} <> Sequence{4, 5, 'test'}");
		assertResultFalse("Sequence{4, 5, 'test', 5} <> Sequence{4, 5, 'test', 5}");
		assertResultFalse("OrderedSet{4, 5, 'test', 5} <> OrderedSet{4, 5, 'test'}");
		// Collections are equal only if they are of the same kind
		assertResultTrue("Sequence{4, 5, 'test'} <> OrderedSet{4, 5, 'test', 5}");
		assertResultTrue("OrderedSet{4, 5, 'test', 5} <> Sequence{4, 5, 'test'}");

		// distinct order, same quantities
		assertResultTrue("Sequence{4, 5, 'test'} <> Sequence{4, 'test', 5}");
		assertResultTrue("Sequence{4, 5, 'test', 5} <> Sequence{5, 4, 'test', 5}");
		// FIXME unclear semantics of ordering in OrderedSet collection literal with multiple occurrences of equal values
		// assertResultTrue("OrderedSet{4, 5, 'test', 5} <> OrderedSet{4, 'test', 5}");
		assertResultTrue("Sequence{4, 5, 'test'} <> OrderedSet{5, 4, 'test', 5}");
		assertResultTrue("OrderedSet{4, 5, 'test', 5} <> Sequence{5, 4, 'test'}");

		// distinct quantities
		assertResultTrue("Sequence{4, 5, 'test', 5} <> Sequence{4, 5, 'test'}");
		assertResultTrue("Sequence{4, 5, 'test', 5} <> OrderedSet{4, 5, 'test', 5}");
		assertResultTrue("OrderedSet{4, 5, 'test', 5} <> Sequence{4, 5, 'test', 5}");
	}

	public void testCollectionNotEqualOrderedXUnordered() {
		/*
		 * FIXME <ordered collection> x <non ordered collection> Should return
		 * true or false when containing the elements in the same quantities?
		 */
		// same quantities
		assertResultTrue("Sequence{4, 5, 'test'} <> Set{4, 'test', 5, 4}");
		assertResultTrue("Sequence{4, 5, 'test', 4} <> Bag{4, 'test', 5, 4}");
		assertResultTrue("OrderedSet{4, 5, 'test', 4} <> Set{4, 'test', 5, 4}");
		assertResultTrue("OrderedSet{4, 5, 'test', 4} <> Bag{4, 'test', 5}");

		// distinct quantities
		assertResultTrue("Sequence{4, 5, 'test', 4} <> Set{4, 'test', 5, 4}");
		assertResultTrue("Sequence{4, 5, 'test'} <> Bag{4, 'test', 5, 4}");
		assertResultTrue("OrderedSet{4, 5, 'test', 4} <> Bag{4, 'test', 5, 4}");
	}

	public void testCollectionNotEqualUnorderedXUnordered() {
		// same quantities
		// collections are only equal if they are of the same kind
		assertResultTrue("Bag{4, 5, 'test'} <> Set{4, 'test', 5, 4}");
		assertResultFalse("Bag{4, 5, 'test', 4} <> Bag{4, 'test', 5, 4}");
		assertResultFalse("Set{4, 5, 'test', 4} <> Set{4, 'test', 5, 4}");
		// collections are only equal if they are of the same kind
		assertResultTrue("Set{4, 5, 'test', 4} <> Bag{4, 'test', 5}");

		// distinct quantities
		assertResultTrue("Bag{4, 5, 'test', 4} <> Set{4, 'test', 5, 4}");
		assertResultTrue("Bag{4, 5, 'test'} <> Bag{4, 'test', 5, 4}");
		assertResultTrue("Set{4, 5, 'test', 4} <> Bag{4, 'test', 5, 4}");
	}

	public void testCollectionPrepend() {
		assertExpressionResults("Sequence{'c', 'a', 'b'}", "Sequence{'a', 'b'}->prepend('c')");
		assertExpressionResults("OrderedSet{'c', 'a', 'b'}", "OrderedSet{'a', 'b'}->prepend('c')");
	}

	public void testCollectionPrependInvalid() {
		assertResultInvalid("let s : Sequence(String) = invalid in s->prepend('a')");
		assertResultInvalid("let o : OrderedSet(String) = invalid in o->prepend('a')");
	}

	public void testCollectionPrependInvalidValue() {
		assertResultInvalid("Sequence{'a', 'b'}->prepend(invalid)");
		assertResultInvalid("OrderedSet{'a', 'b'}->prepend(invalid)");
	}

	public void testCollectionPrependNull() {
		assertResultInvalid("let s : Sequence(String) = null in s->prepend('a')");
		assertResultInvalid("let o : OrderedSet(String) = null in o->prepend('a')");
	}

	public void testCollectionPrependNullValue() {
		assertExpressionResults("Sequence{null, 'a', 'b'}", "Sequence{'a', 'b'}->prepend(null)");
		assertExpressionResults("OrderedSet{null, 'a', 'b'}", "OrderedSet{'a', 'b'}->prepend(null)");
	}

	public void testCollectionProduct() {
		String expectedResultExpression = "Set{Tuple{first = 3, second = 3.0}, Tuple{first = 3, second = 4.0}, Tuple{first = 4, second = 3.0}, Tuple{first = 4, second = 4.0}}";

		// Sequence::product(Collection)
		assertExpressionResults(expectedResultExpression, "Sequence{3, 4}->product(Sequence{3.0, 4.0})");
		assertExpressionResults(expectedResultExpression, "Sequence{3, 4}->product(Bag{3.0, 4.0})");
		assertExpressionResults(expectedResultExpression, "Sequence{3, 4}->product(Set{3.0, 4.0})");
		assertExpressionResults(expectedResultExpression, "Sequence{3, 4}->product(OrderedSet{3.0, 4.0})");

		// Bag::product(Collection)
		assertExpressionResults(expectedResultExpression, "Bag{3, 4}->product(Sequence{3.0, 4.0})");
		assertExpressionResults(expectedResultExpression, "Bag{3, 4}->product(Bag{3.0, 4.0})");
		assertExpressionResults(expectedResultExpression, "Bag{3, 4}->product(Set{3.0, 4.0})");
		assertExpressionResults(expectedResultExpression, "Bag{3, 4}->product(OrderedSet{3.0, 4.0})");

		// Set::product(Collection)
		assertExpressionResults(expectedResultExpression, "Set{3, 4}->product(Sequence{3.0, 4.0})");
		assertExpressionResults(expectedResultExpression, "Set{3, 4}->product(Bag{3.0, 4.0})");
		assertExpressionResults(expectedResultExpression, "Set{3, 4}->product(Set{3.0, 4.0})");
		assertExpressionResults(expectedResultExpression, "Set{3, 4}->product(OrderedSet{3.0, 4.0})");

		// OrderedSet::product(Collection)
		assertExpressionResults(expectedResultExpression, "OrderedSet{3, 4}->product(Sequence{3.0, 4.0})");
		assertExpressionResults(expectedResultExpression, "OrderedSet{3, 4}->product(Bag{3.0, 4.0})");
		assertExpressionResults(expectedResultExpression, "OrderedSet{3, 4}->product(Set{3.0, 4.0})");
		assertExpressionResults(expectedResultExpression, "OrderedSet{3, 4}->product(OrderedSet{3.0, 4.0})");
	}

	public void testCollectionProduct_bug284129() {
		// FIXME Due to number equality inconsistency between Java and OCL, the following doesn't work:
		// assertExpressionResults("Set{Tuple{first = 3, second = 3.0}, Tuple{first = 3, second = 4}, Tuple{first = 4.0, second = 3.0}, Tuple{first = 4.0, second = 4}}", "Sequence{3, 4.0}->product(Sequence{3.0, 4})");
		// But if we relax a little and compare the result to all Double/Real values, it works:
		assertExpressionResults("Set{Tuple{first = 3.0, second = 3.0}, Tuple{first = 3.0, second = 4.0}, Tuple{first = 4.0, second = 3.0}, Tuple{first = 4.0, second = 4.0}}", "Sequence{3, 4.0}->product(Sequence{3.0, 4})");
	}

	public void testCollectionProductEmptyCollection() {
		assertResult(CollectionUtil.createNewSet(),
			"Sequence{3, 4}->product(OrderedSet{})");
		assertResult(CollectionUtil.createNewSet(), "Bag{3, 4}->product(Set{})");
		assertResult(CollectionUtil.createNewSet(), "Set{3, 4}->product(Bag{})");
		assertResult(CollectionUtil.createNewSet(),
			"OrderedSet{3, 4}->product(Sequence{})");

		assertResult(CollectionUtil.createNewSet(),
			"Sequence{}->product(OrderedSet{3, 4})");
		assertResult(CollectionUtil.createNewSet(), "Bag{}->product(Set{3, 4})");
		assertResult(CollectionUtil.createNewSet(), "Set{}->product(Bag{3, 4})");
		assertResult(CollectionUtil.createNewSet(),
			"OrderedSet{}->product(Sequence{3, 4})");
	}

	public void testCollectionProductInvalid() {
		assertResultInvalid("let s : Sequence(Integer) = invalid in OrderedSet{3, 4}->product(s)");
		assertResultInvalid("let b : Bag(Integer) = invalid in Set{3, 4}->product(b)");
		assertResultInvalid("let s : Set(Integer) = invalid in Bag{3, 4}->product(s)");
		assertResultInvalid("let o : OrderedSet(Integer) = invalid in Sequence{3, 4}->product(o)");

		assertResultInvalid("let s : Sequence(Integer) = invalid in s->product(OrderedSet{3, 4})");
		assertResultInvalid("let b : Bag(Integer) = invalid in b->product(Set{3, 4})");
		assertResultInvalid("let s : Set(Integer) = invalid in s->product(Bag{3, 4})");
		assertResultInvalid("let o : OrderedSet(Integer) = invalid in o->product(Sequence{3, 4})");
	}

	public void testCollectionProductInvalidValue() {
		assertResultInvalid("Sequence{3, 4}->product(OrderedSet{invalid})");
		assertResultInvalid("Bag{3, 4}->product(Set{invalid})");
		assertResultInvalid("Set{3, 4}->product(Bag{invalid})");
		assertResultInvalid("OrderedSet{3, 4}->product(Sequence{invalid})");

		assertResultInvalid("Sequence{invalid, 4}->product(Sequence{3})");
		assertResultInvalid("Bag{invalid, 4}->product(Set{3})");
		assertResultInvalid("Set{invalid, 4}->product(Bag{3})");
		assertResultInvalid("OrderedSet{invalid, 4}->product(Sequence{3})");
	}

	public void testCollectionProductNull() {
		assertResultInvalid("let s : Sequence(Integer) = null in OrderedSet{3, 4}->product(s)");
		assertResultInvalid("let b : Bag(Integer) = null in Set{3, 4}->product(b)");
		assertResultInvalid("let s : Set(Integer) = null in Bag{3, 4}->product(s)");
		assertResultInvalid("let o : OrderedSet(Integer) = null in Sequence{3, 4}->product(o)");

		assertResultInvalid("let s : Sequence(Integer) = null in s->product(OrderedSet{3, 4})");
		assertResultInvalid("let b : Bag(Integer) = null in b->product(Set{3, 4})");
		assertResultInvalid("let s : Set(Integer) = null in s->product(Bag{3, 4})");
		assertResultInvalid("let o : OrderedSet(Integer) = null in o->product(Sequence{3, 4})");
	}

	public void testCollectionProductNullValue() {
		assertExpressionResults("Set{Tuple{first = 3, second = null}, Tuple{first = 4, second = null}}", "Sequence{3, 4}->product(OrderedSet{null})");
		assertExpressionResults("Set{Tuple{first = 3, second = null}, Tuple{first = 4, second = null}}", "Bag{3, 4}->product(let s:Set(OclVoid)=Set{} in s->including(null))");
		assertExpressionResults("Set{Tuple{first = 3, second = null}, Tuple{first = 4, second = null}}", "Set{3, 4}->product(Bag{null})");
		assertExpressionResults("Set{Tuple{first = 3, second = null}, Tuple{first = 4, second = null}}", "OrderedSet{3, 4}->product(Sequence{null})");

		assertExpressionResults("Set{Tuple{first = null, second = 3}, Tuple{first = 4, second = 3}}", "Sequence{null, 4}->product(Sequence{3})");
		assertExpressionResults("Set{Tuple{first = null, second = 3}, Tuple{first = 4, second = 3}}", "Bag{null, 4}->product(Set{3})");
		assertExpressionResults("Set{Tuple{first = null, second = 3}, Tuple{first = 4, second = 3}}", "Set{null, 4}->product(Bag{3})");
		assertExpressionResults("Set{Tuple{first = null, second = 3}, Tuple{first = 4, second = 3}}", "OrderedSet{null, 4}->product(Sequence{3})");
	}

	public void testCollectionSize() {
		assertResult(Integer.valueOf(4), "Sequence{4, 4, 5, 'test'}->size()");
		assertResult(Integer.valueOf(4), "Bag{4, 4, 5, 'test'}->size()");
		assertResult(Integer.valueOf(3), "Set{4, 4, 5, 'test'}->size()");
		assertResult(Integer.valueOf(3), "OrderedSet{4, 4, 5, 'test'}->size()");

		assertResult(Integer.valueOf(0), "Sequence{}->size()");
		assertResult(Integer.valueOf(0), "Bag{}->size()");
		assertResult(Integer.valueOf(0), "Set{}->size()");
		assertResult(Integer.valueOf(0), "OrderedSet{}->size()");
	}

	public void testCollectionSizeInvalid() {
		assertResultInvalid("let s : String = invalid in s->size()");
		assertResultInvalid("let s : Sequence(Integer) = invalid in s->size()");
	}

	public void testCollectionSizeInvalidValue() {
		assertResultInvalid("OrderedSet{'a', 'b', invalid}->size()");
		assertResultInvalid("Set{'a', 'b', invalid}->size()");
		assertResultInvalid("Bag{'a', 'b', invalid}->size()");
		assertResultInvalid("Sequence{'a', 'b', invalid}->size()");
	}

	public void testCollectionSizeNull() {
		// converting a null value to a set has to result in an empty set;
		// see OCL spec 11.2.3
		assertResult(Integer.valueOf(0), "let s : String = null in s->size()");
		// In the following case there is no implicit conversion to Set.
		// Therefore, size() will be attempted on a null Sequence, required
		// to evaluate to invalid.
		assertResultInvalid("let s : Sequence(Integer) = null in s->size()");
	}

	public void testCollectionSizeNullValue() {
		assertResult(Integer.valueOf(4),
			"Sequence{'a', 'b', null, null}->size()");
		assertResult(Integer.valueOf(4), "Bag{'a', 'b', null, null}->size()");
		assertResult(Integer.valueOf(3), "Set{'a', 'b', null, null}->size()");
		assertResult(Integer.valueOf(3),
			"OrderedSet{'a', 'b', null, null}->size()");
	}

	public void testCollectionSubOrderedSet() {
		assertExpressionResults("OrderedSet{'a'}", "OrderedSet{'a', 'b', 'c', 'd'}->subOrderedSet(1, 1)");
		assertExpressionResults("OrderedSet{'b', 'c'}", "OrderedSet{'a', 'b', 'c', 'd'}->subOrderedSet(2, 3)");
		assertExpressionResults("OrderedSet{'d'}", "OrderedSet{'a', 'b', 'c', 'd'}->subOrderedSet(4, 4)");
	}

	public void testCollectionSubOrderedSetIllegalArguments() {
		assertResultInvalid("OrderedSet{'a', 'b', 'c', 'd'}->subOrderedSet(2, 1)");
	}

	public void testCollectionSubOrderedSetInvalid() {
		assertResultInvalid("let o : OrderedSet(String) = invalid in o->subOrderedSet(1, 1)");
	}

	public void testCollectionSubOrderedSetNull() {
		assertResultInvalid("let o : OrderedSet(String) = null in o->subOrderedSet(1, 1)");
	}

	public void testCollectionSubOrderedSetOutOfBounds() {
		assertResultInvalid("OrderedSet{'a', 'b', 'c', 'd'}->subOrderedSet(0, 1)");
		assertResultInvalid("OrderedSet{'a', 'b', 'c', 'd'}->subOrderedSet(4, 5)");
	}

	public void testCollectionSubSequence() {
		assertExpressionResults("Sequence{'a'}", "Sequence{'a', 'b', 'c', 'd'}->subSequence(1, 1)");
		assertExpressionResults("Sequence{'b', 'c'}", "Sequence{'a', 'b', 'c', 'd'}->subSequence(2, 3)");
		assertExpressionResults("Sequence{'d'}", "Sequence{'a', 'b', 'c', 'd'}->subSequence(4, 4)");
	}

	public void testCollectionSubSequenceIllegalArguments() {
		assertResultInvalid("Sequence{'a', 'b', 'c', 'd'}->subSequence(2, 1)");
	}

	public void testCollectionSubSequenceInvalid() {
		assertResultInvalid("let o : Sequence(String) = invalid in o->subSequence(1, 1)");
	}

	public void testCollectionSubSequenceNull() {
		assertResultInvalid("let o : Sequence(String) = null in o->subSequence(1, 1)");
	}

	public void testCollectionSubSequenceOutOfBounds() {
		assertResultInvalid("Sequence{'a', 'b', 'c', 'd'}->subSequence(0, 1)");
		assertResultInvalid("Sequence{'a', 'b', 'c', 'd'}->subSequence(4, 5)");
	}

	public void testCollectionSum() {
		assertResult(Integer.valueOf(0),
			"let s : Sequence(Integer) = Sequence{} in s->sum()");
		assertResult(Double.valueOf(0d),
			"let b : Bag(Real) = Bag{} in b->sum()");
		assertResult(Double.valueOf(0d),
			"let s : Set(Real) = Set{} in s->sum()");
		assertResult(Integer.valueOf(0),
			"let o : OrderedSet(Integer) = OrderedSet{} in o->sum()");

		assertResult(Double.valueOf(13d), "Sequence{4.0, 4.0, 5.0}->sum()");
		assertResult(Integer.valueOf(13), "Bag{4, 4, 5}->sum()");
		assertResult(Integer.valueOf(9), "Set{4, 4, 5}->sum()");
		assertResult(Double.valueOf(9d), "OrderedSet{4.0, 4.0, 5.0}->sum()");

		assertResult(Integer.valueOf(4), "4->sum()");
	}

	public void testCollectionSumInvalid() {
		assertResultInvalid("let s : Sequence(Integer) = invalid in s->sum()");
		assertResultInvalid("let b : Bag(Integer) = invalid in b->sum()");
		assertResultInvalid("let s : Set(Integer) = invalid in s->sum()");
		assertResultInvalid("let o : OrderedSet(Integer) = invalid in o->sum()");
	}

	public void testCollectionSumInvalidValue() {
		assertResultInvalid("Sequence{4.0, invalid, 5.0}->sum()");
		assertResultInvalid("Bag{4, invalid, 5}->sum()");
		assertResultInvalid("Set{4, invalid, 5}->sum()");
		assertResultInvalid("OrderedSet{4.0, invalid, 5.0}->sum()");
	}

	public void testCollectionSumNull() {
		assertResultInvalid("let s : Sequence(Integer) = null in s->sum()");
		assertResultInvalid("let b : Bag(Integer) = null in b->sum()");
		assertResultInvalid("let s : Set(Integer) = null in s->sum()");
		assertResultInvalid("let o : OrderedSet(Integer) = null in o->sum()");
	}

	public void testCollectionSumNullValue() {
		assertResultInvalid("Sequence{4.0, null, 5.0}->sum()");
		assertResultInvalid("Bag{4, null, 5}->sum()");
		assertResultInvalid("Set{4, null, 5}->sum()");
		assertResultInvalid("OrderedSet{4.0, null, 5.0}->sum()");
	}

	public void testCollectionSymmetricDifference() {
		assertExpressionResults("Set{'a', 'c'}", "Set{'a', 'b'}->symmetricDifference(Set{'b', 'c'})");
	}

	public void testCollectionSymmetricDifferenceInvalid() {
		assertResultInvalid("let s : Set(String) = invalid in s->symmetricDifference(Set{'a'})");
	}

	public void testCollectionSymmetricDifferenceInvalidValue() {
		assertResultInvalid("Set{'a', invalid, 'b'}->symmetricDifference(Set{'b', 'c'})");
	}

	public void testCollectionSymmetricDifferenceNull() {
		assertResultInvalid("let s : Set(String) = null in s->symmetricDifference(Set{'a'})");
	}

	public void testCollectionSymmetricDifferenceNullValue() {
		// FIXME passes as a side effect of bug 283518
		assertExpressionResults("Set{'a', null, 'c'}", "Set{'a', null, 'b'}->symmetricDifference(Set{'b', 'c'})");
	}

	public void testCollectionUnionDuplicates() {
		assertExpressionResults("Set{'a', 'b', 'c'}", "Set{'a', 'b', 'a'}->union(Set{'b', 'c'})");
		assertExpressionResults("Bag{'a', 'b', 'b', 'c'}", "Set{'a', 'b', 'a'}->union(Bag{'b', 'c'})");
		assertExpressionResults("Bag{'a', 'b', 'a', 'b', 'c'}", "Bag{'a', 'b', 'a'}->union(Bag{'b', 'c'})");
		assertExpressionResults("Bag{'a', 'b', 'a', 'b', 'c'}", "Bag{'a', 'b', 'a'}->union(Set{'b', 'c'})");

		assertExpressionResults("Sequence{'a', 'b', 'a', 'b', 'c'}", "Sequence{'a', 'b', 'a'}->union(Sequence{'b', 'c'})");
	}

	public void testCollectionUnionEmptyCollection() {
		assertExpressionResults("Set{3, 4}", "Set{3, 4}->union(Set{})");
		assertExpressionResults("Bag{3, 4}", "Set{3, 4}->union(Bag{})");
		assertExpressionResults("Bag{3, 4}", "Bag{3, 4}->union(Bag{})");
		assertExpressionResults("Bag{3, 4}", "Bag{3, 4}->union(Set{})");
		assertExpressionResults("Sequence{3, 4}", "Sequence{3, 4}->union(Sequence{})");

		assertExpressionResults("Set{3, 4}", "let s:Set(Integer)=Set{} in s->union(Set{3, 4})");
		assertExpressionResults("Bag{3, 4}", "let s:Set(Integer)=Set{} in s->union(Bag{3, 4})");
		assertExpressionResults("Bag{3, 4}", "let b:Bag(Integer)=Bag{} in b->union(Bag{3, 4})");
		assertExpressionResults("Bag{3, 4}", "let b:Bag(Integer)=Bag{} in b->union(Set{3, 4})");
		assertExpressionResults("Sequence{3, 4}", "let s:Sequence(Integer)=Sequence{} in s->union(Sequence{3, 4})");
	}

	public void testCollectionUnionInvalid() {
		assertResultInvalid("let s : Set(String) = invalid in s->union(Set{'a'})");
		assertResultInvalid("let s : Set(String) = invalid in s->union(Bag{'a'})");
		assertResultInvalid("let b : Bag(String) = invalid in b->union(Bag{'a'})");
		assertResultInvalid("let b : Bag(String) = invalid in b->union(Set{'a'})");
		assertResultInvalid("let s : Sequence(String) = invalid in s->union(Sequence{'a'})");

		assertResultInvalid("let s : Set(String) = invalid in Set{'a'}->union(s)");
		assertResultInvalid("let s : Set(String) = invalid in Bag{'a'}->union(s)");
		assertResultInvalid("let b : Bag(String) = invalid in Bag{'a'}->union(b)");
		assertResultInvalid("let b : Bag(String) = invalid in Set{'a'}->union(b)");
		assertResultInvalid("let s : Sequence(String) = invalid in Sequence{'a'}->union(s)");
	}

	public void testCollectionUnionInvalidValue() {
		assertResultInvalid("Set{'a', invalid}->union(Set{'b', invalid})");
		assertResultInvalid("Set{'a', invalid}->union(Bag{'b', invalid})");
		assertResultInvalid("Bag{'a', invalid}->union(Bag{'b', invalid})");
		assertResultInvalid("Bag{'a', invalid}->union(Set{'b', invalid})");
		assertResultInvalid("Sequence{'a', invalid}->union(Sequence{'b', invalid})");
	}

	public void testCollectionUnionNoDuplicates() {
		/*
		 * FIXME the specification defines operations Set::union(Set),
		 * Set::union(Bag), Bag::union(Set) and Bag::union(Bag) with the same
		 * semantics "the union of self and bag" and operation
		 * Sequence::union(Sequence) with the description
		 * "The sequence consisting of all elements in self, followed by all elements in s"
		 * . Why aren't there Sequence::union(OrderedSet),
		 * OrderedSet::union(Sequence) and OrderedSet::union(OrderedSet) with
		 * the same semantics as Sequence::union(Sequence) ? That is most likely
		 * an overlook.
		 */
		assertExpressionResults("Set{'a', 'b', 'c', 'd'}", "Set{'a', 'b'}->union(Set{'c', 'd'})");
		assertExpressionResults("Bag{'a', 'b', 'c', 'd'}", "Set{'a', 'b'}->union(Bag{'c', 'd'})");
		assertExpressionResults("Bag{'a', 'b', 'c', 'd'}", "Bag{'a', 'b'}->union(Bag{'c', 'd'})");
		assertExpressionResults("Bag{'a', 'b', 'c', 'd'}", "Bag{'a', 'b'}->union(Set{'c', 'd'})");

		assertExpressionResults("Sequence{'a', 'b', 'c', 'd'}", "Sequence{'a', 'b'}->union(Sequence{'c', 'd'})");
	}

	public void testCollectionUnionNull() {
		assertResultInvalid("let s : Set(String) = null in s->union(Set{'a'})");
		assertResultInvalid("let s : Set(String) = null in s->union(Bag{'a'})");
		assertResultInvalid("let b : Bag(String) = null in b->union(Bag{'a'})");
		assertResultInvalid("let b : Bag(String) = null in b->union(Set{'a'})");
		assertResultInvalid("let s : Sequence(String) = null in s->union(Sequence{'a'})");

		assertResultInvalid("let s : Set(String) = null in Set{'a'}->union(s)");
		assertResultInvalid("let s : Set(String) = null in Bag{'a'}->union(s)");
		assertResultInvalid("let b : Bag(String) = null in Bag{'a'}->union(b)");
		assertResultInvalid("let b : Bag(String) = null in Set{'a'}->union(b)");
		assertResultInvalid("let s : Sequence(String) = null in Sequence{'a'}->union(s)");
	}

	public void testCollectionUnionNullValue() {
		assertExpressionResults("Set{'a', null, 'b'}", "Set{'a', null}->union(Set{'b', null})");
		assertExpressionResults("Bag{'a', null, 'b', null}", "Set{'a', null}->union(Bag{'b', null})");
		assertExpressionResults("Bag{'a', null, 'b', null}", "Bag{'a', null}->union(Bag{'b', null})");
		assertExpressionResults("Bag{'a', null, 'b', null}", "Bag{'a', null}->union(Set{'b', null})");
		assertExpressionResults("Sequence{'a', null, 'b', null}", "Sequence{'a', null}->union(Sequence{'b', null})");
	}
}
