/**
 * <copyright>
 * 
 * Copyright (c) 2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   L.Goubet, E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: GenericEvaluateCollectionOperationsTest.java,v 1.3 2011/02/08 17:57:13 ewillink Exp $
 */

package org.eclipse.ocl.examples.test.generic;

import org.eclipse.ocl.examples.pivot.messages.OCLMessages;


/**
 * Tests for collection operations.
 */
@SuppressWarnings("nls")
public abstract class GenericEvaluateCollectionOperationsTest
	extends GenericTestSuite {

    @Override
    protected void setUp() {
        super.setUp();
//        helper.setContext(getMetaclass(denormalize("%Package")));
        helper.setContext(getMetaclass("String"));
    }

	public void testCollectionAppend() {
		assertQueryResults(null, "Sequence{'a', 'b', 'c'}", "Sequence{'a', 'b'}->append('c')");
		assertQueryResults(null, "OrderedSet{'a', 'b', 'c'}", "OrderedSet{'a', 'b'}->append('c')");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(String) = invalid in s->append('a')");
		assertQueryInvalid(null, "let o : OrderedSet(String) = invalid in o->append('a')");
		// invalid collection element
		assertQueryInvalid(null, "Sequence{'a', 'b'}->append(invalid)");
		assertQueryInvalid(null, "OrderedSet{'a', 'b'}->append(invalid)");
		// null collection
//		assertQueryInvalid(null, "let s : Bag(String) = null in s->append('a')");
		assertQueryInvalid(null, "let o : OrderedSet(String) = null in o->append('a')");
		assertQueryInvalid(null, "let s : Sequence(String) = null in s->append('a')");
//		assertQueryInvalid(null, "let o : Set(String) = null in o->append('a')");
		// null collection element
		assertQueryResults(null, "Sequence{'a', 'b', null}", "Sequence{'a', 'b'}->append(null)");
		assertQueryResults(null, "OrderedSet{'a', 'b', null}", "OrderedSet{'a', 'b'}->append(null)");
	}

	public void testCollectionAsBag() {
		assertQueryEquals(null, valueFactory.getEmptyBagValue(), "Sequence{}->asBag()");
		assertQueryEquals(null, valueFactory.getEmptyBagValue(), "Bag{}->asBag()");
		assertQueryEquals(null, valueFactory.getEmptyBagValue(), "Set{}->asBag()");
		assertQueryEquals(null, valueFactory.getEmptyBagValue(), "OrderedSet{}->asBag()");

		assertQueryResults(null, "Bag{1, 2.0, '3'}", "Sequence{1, 2.0, '3'}->asBag()");
		assertQueryResults(null, "Bag{1, 2.0, '3'}", "Bag{1, 2.0, '3'}->asBag()");
		assertQueryResults(null, "Bag{1, 2.0, '3'}", "Set{1, 2.0, '3'}->asBag()");
		assertQueryResults(null, "Bag{1, 2.0, '3'}", "OrderedSet{1, 2.0, '3'}->asBag()");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in s->asBag()");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in b->asBag()");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in s->asBag()");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = invalid in o->asBag()");
		// null collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = null in s->asBag()");
		assertQueryInvalid(null, "let b : Bag(Integer) = null in b->asBag()");
		assertQueryInvalid(null, "let s : Set(Integer) = null in s->asBag()");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = null in o->asBag()");
	}

	public void testCollectionAsOrderedSet() {
		assertQueryEquals(null, valueFactory.getEmptyOrderedSetValue(), "Sequence{}->asOrderedSet()");
		assertQueryEquals(null, valueFactory.getEmptyOrderedSetValue(), "Bag{}->asOrderedSet()");
		assertQueryEquals(null, valueFactory.getEmptyOrderedSetValue(), "Set{}->asOrderedSet()");
		assertQueryEquals(null, valueFactory.getEmptyOrderedSetValue(), "OrderedSet{}->asOrderedSet()");

		assertQueryResults(null, "OrderedSet{1, 2.0, '3'}", "Sequence{1, 2.0, '3'}->asOrderedSet()");
		assertQueryResults(null, "OrderedSet{1, 2.0, '3'}", "OrderedSet{1, 2.0, '3'}->asOrderedSet()");

		/*
		 * Bag and Set are not ordered, simply check that the result is an
		 * OrderedSet and it contains all needed values.
		 */
		assertResultContainsAll(null, "OrderedSet{1, 2.0, '3'}", "Set{1, 2.0, '3'}->asOrderedSet()");
		assertResultContainsAll(null, "OrderedSet{1, 2.0, '3'}", "Bag{1, 2.0, '3'}->asOrderedSet()");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in s->asOrderedSet()");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in b->asOrderedSet()");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in s->asOrderedSet()");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = invalid in o->asOrderedSet()");
		// null collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = null in s->asOrderedSet()");
		assertQueryInvalid(null, "let b : Bag(Integer) = null in b->asOrderedSet()");
		assertQueryInvalid(null, "let s : Set(Integer) = null in s->asOrderedSet()");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = null in o->asOrderedSet()");
	}

	public void testCollectionAsSequence() {
		assertQueryEquals(null, valueFactory.getEmptySequenceValue(), "Sequence{}->asSequence()");
		assertQueryEquals(null, valueFactory.getEmptySequenceValue(), "Bag{}->asSequence()");
		assertQueryEquals(null, valueFactory.getEmptySequenceValue(), "Set{}->asSequence()");
		assertQueryEquals(null, valueFactory.getEmptySequenceValue(), "OrderedSet{}->asSequence()");

		assertQueryResults(null, "Sequence{1, 2.0, '3'}", "Sequence{1, 2.0, '3'}->asSequence()");
		assertQueryResults(null, "Sequence{1, 2.0, '3'}", "OrderedSet{1, 2.0, '3'}->asSequence()");

		/*
		 * Bag and Set are not ordered, simply check that the result is a
		 * Sequence and it contains all needed values.
		 */
		assertResultContainsAll(null, "Sequence{1, 2.0, '3'}", "Bag{1, 2.0, '3'}->asSequence()");
		assertResultContainsAll(null, "Sequence{1, 2.0, '3'}", "Set{1, 2.0, '3'}->asSequence()");
		// invalid collection
//		assertQueryInvalid(null, "invalid->asSequence()");
		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in s->asSequence()");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in b->asSequence()");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in s->asSequence()");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = invalid in o->asSequence()");
		// null collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = null in s->asSequence()");
		assertQueryInvalid(null, "let b : Bag(Integer) = null in b->asSequence()");
		assertQueryInvalid(null, "let s : Set(Integer) = null in s->asSequence()");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = null in o->asSequence()");
	}

	public void testCollectionAsSet() {
		assertQueryEquals(null, valueFactory.getEmptySetValue(), "Sequence{}->asSet()");
		assertQueryEquals(null, valueFactory.getEmptySetValue(), "Bag{}->asSet()");
		assertQueryEquals(null, valueFactory.getEmptySetValue(), "Set{}->asSet()");
		assertQueryEquals(null, valueFactory.getEmptySetValue(), "OrderedSet{}->asSet()");

		assertQueryResults(null, "Set{1, 2.0, '3'}", "Sequence{1, 2.0, '3'}->asSet()");
		assertResultContainsAll(null, "Set{1, 2.0, '3'}", "Bag{1, 2.0, '3'}->asSet()");
		assertResultContainsAll(null, "Set{1, 2.0, '3'}", "Set{1, 2.0, '3'}->asSet()");
		assertQueryResults(null, "Set{1, 2.0, '3'}", "OrderedSet{1, 2.0, '3'}->asSet()");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in s->asSet()");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in b->asSet()");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in s->asSet()");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = invalid in o->asSet()");
		// null collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = null in s->asSet()");
		assertQueryInvalid(null, "let b : Bag(Integer) = null in b->asSet()");
		assertQueryInvalid(null, "let s : Set(Integer) = null in s->asSet()");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = null in o->asSet()");
	}

	public void testCollectionAt() {
		assertQueryEquals(null, "a", "Sequence{'a', 'b'}->at(1)");
		assertQueryEquals(null, "b", "OrderedSet{'a', 'b'}->at(2)");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(String) = invalid in s->at(1)");
		assertQueryInvalid(null, "let o : OrderedSet(String) = invalid in o->at(1)");
		// invalid collection element
		assertQueryInvalid(null, "Sequence{'a', invalid}->at(1)");
		assertQueryInvalid(null, "OrderedSet{'a', invalid}->at(1)");
		// null collection
		assertQueryInvalid(null, "let s : Sequence(String) = null in s->at(1)");
		assertQueryInvalid(null, "let o : OrderedSet(String) = null in o->at(1)");
		// null collection element
		assertQueryNull(null, "Sequence{null, 'a'}->at(1)");
		assertQueryNull(null, "OrderedSet{null, 'a'}->at(1)");
		// out of bounds
		assertQueryInvalid(null, "Sequence{'a'}->at(0)");
		assertQueryInvalid(null, "OrderedSet{'a'}->at(0)");

		assertQueryInvalid(null, "Sequence{'a'}->at(2)");
		assertQueryInvalid(null, "OrderedSet{'a'}->at(2)");
	}

	public void testCollectionCount() {
		assertQueryEquals(null, 1, "Sequence{3, 'test', 4.0, 4, 4.0, 'test'}->count(3)");
		assertQueryEquals(null, 3, "Sequence{3, 'test', 4.0, 4, 4.0, 'test'}->count(4)");
		assertQueryEquals(null, 3, "Sequence{3, 'test', 4.0, 4, 4.0, 'test'}->count(-(-4))");
		assertQueryEquals(null, 3, "Sequence{3, 'test', 4.0, 4, 4.0, 'test'}->count(4.0)");
		assertQueryEquals(null, 2, "Sequence{3, 'test', 4.0, 4, 4.0, 'test'}->count('test')");
		assertQueryEquals(null, 1, "Bag{3, 'test', 4.0, 4, 4.0, 'test'}->count(3)");
		assertQueryEquals(null, 3, "Bag{3, 'test', 4.0, 4, 4.0, 'test'}->count(4)");
		assertQueryEquals(null, 3, "Bag{3, 'test', 4.0, 4, 4.0, 'test'}->count(-(-4))");
		assertQueryEquals(null, 3, "Bag{3, 'test', 4.0, 4, 4.0, 'test'}->count(4.0)");
		assertQueryEquals(null, 2, "Bag{3, 'test', 4.0, 4, 4.0, 'test'}->count('test')");
		assertQueryEquals(null, 1, "Set{3, 'test', 4.0, 4, 4.0, 'test'}->count(3)");
		assertQueryEquals(null, 1, "Set{3, 'test', 4.0, 4, 4.0, 'test'}->count(4)");
		assertQueryEquals(null, 1, "Set{3, 'test', 4.0, 4, 4.0, 'test'}->count(-(-4))");
		assertQueryEquals(null, 1, "Set{3, 'test', 4.0, 4, 4.0, 'test'}->count(4.0)");
		assertQueryEquals(null, 1, "Set{3, 'test', 4.0, 4, 4.0, 'test'}->count('test')");
		assertQueryEquals(null, 1, "OrderedSet{3, 'test', 4.0, 4, 4.0, 'test'}->count(3)");
		assertQueryEquals(null, 1, "OrderedSet{3, 'test', 4.0, 4, 4.0, 'test'}->count(4)");
		assertQueryEquals(null, 1, "OrderedSet{3, 'test', 4.0, 4, 4.0, 'test'}->count(-(-4))");
		assertQueryEquals(null, 1, "OrderedSet{3, 'test', 4.0, 4, 4.0, 'test'}->count(4.0)");
		assertQueryEquals(null, 1, "OrderedSet{3, 'test', 4.0, 4, 4.0, 'test'}->count('test')");

		assertQueryEquals(null, 0, "Sequence{3, 'test', 4.0, 4, 4.0, 'test'}->count(0)");
		assertQueryEquals(null, 0, "Bag{3, 'test', 4.0, 4, 4.0, 'test'}->count(0)");
		assertQueryEquals(null, 0, "Set{3, 'test', 4.0, 4, 4.0, 'test'}->count(0)");
		assertQueryEquals(null, 0, "OrderedSet{3, 'test', 4.0, 4, 4.0, 'test'}->count(0)");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in s->count(0)");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in b->count(0)");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in s->count(0)");
		assertQueryInvalid(null, "let os : OrderedSet(Integer) = invalid in os->count(0)");
		// invalid collection element
		assertQueryInvalid(null, "Sequence{3, 'test', 4.0, 4, 4.0, 'test'}->count(invalid)");
		assertQueryInvalid(null, "Bag{3, 'test', 4.0, 4, 4.0, 'test'}->count(invalid)");
		assertQueryInvalid(null, "Set{3, 'test', 4.0, 4, 4.0, 'test'}->count(invalid)");
		assertQueryInvalid(null, "OrderedSet{3, 'test', 4.0, 4, 4.0, 'test'}->count(invalid)");

		assertQueryInvalid(null, "Sequence{3, invalid, 4.0, invalid, 'test'}->count(3)");
		assertQueryInvalid(null, "Bag{3, invalid, 4.0, invalid, 'test'}->count(3)");
		assertQueryInvalid(null, "Set{3, invalid, 4.0, invalid, 'test'}->count(3)");
		assertQueryInvalid(null, "OrderedSet{3, invalid, 4.0, invalid, 'test'}->count(3)");
		// null collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = null in s->count(0)");
		assertQueryInvalid(null, "let b : Bag(Integer) = null in b->count(0)");
		assertQueryInvalid(null, "let s : Set(Integer) = null in s->count(0)");
		assertQueryInvalid(null, "let os : OrderedSet(Integer) = null in os->count(0)");
		// null collection element
		assertQueryEquals(null, 0, "Sequence{3, 'test', 4.0, 4, 4.0, 'test'}->count(null)");
		assertQueryEquals(null, 0, "Bag{3, 'test', 4.0, 4, 4.0, 'test'}->count(null)");
		assertQueryEquals(null, 0, "Set{3, 'test', 4.0, 4, 4.0, 'test'}->count(null)");
		assertQueryEquals(null, 0, "OrderedSet{3, 'test', 4.0, 4, 4.0, 'test'}->count(null)");

		assertQueryEquals(null, 2, "Sequence{3, null, 4.0, null, 'test'}->count(null)");
		assertQueryEquals(null, 2, "Bag{3, null, 4.0, null, 'test'}->count(null)");
		assertQueryEquals(null, 1, "Set{3, null, 4.0, null, 'test'}->count(null)");
		assertQueryEquals(null, 1, "OrderedSet{3, null, 4.0, null, 'test'}->count(null)");
	}

	public void testCollectionEqualOrderedXOrdered() {
		// same order, same quantities
		assertQueryTrue(null, "Sequence{4, 5, 'test'} = Sequence{4, 5, 'test'}");
		assertQueryTrue(null, "Sequence{4, 5, 'test', 5} = Sequence{4, 5, 'test', 5}");
		assertQueryTrue(null, "OrderedSet{4, 5, 'test', 5} = OrderedSet{4, 5, 'test'}");
		assertQueryFalse(null, "Sequence{4, 5, 'test'} = OrderedSet{4, 5, 'test', 5}");
		assertQueryFalse(null, "OrderedSet{4, 5, 'test', 5} = Sequence{4, 5, 'test'}");

		// distinct order, same quantities
		assertQueryFalse(null, "Sequence{4, 5, 'test'} = Sequence{4, 'test', 5}");
		assertQueryFalse(null, "Sequence{4, 5, 'test', 5} = Sequence{5, 4, 'test', 5}");
		assertQueryFalse(null, "OrderedSet{4, 5, 'test', 5} = OrderedSet{4, 'test', 5}");
		assertQueryFalse(null, "Sequence{4, 5, 'test'} = OrderedSet{5, 4, 'test', 5}");
		assertQueryFalse(null, "OrderedSet{4, 5, 'test', 5} = Sequence{5, 4, 'test'}");

		// distinct quantities
		assertQueryFalse(null, "Sequence{4, 5, 'test', 5} = Sequence{4, 5, 'test'}");
		assertQueryFalse(null, "Sequence{4, 5, 'test', 5} = OrderedSet{4, 5, 'test', 5}");
		assertQueryFalse(null, "OrderedSet{4, 5, 'test', 5} = Sequence{4, 5, 'test', 5}");
	}

	public void testCollectionEqualOrderedXUnordered() {
		// same quantities
		assertQueryFalse(null, "Sequence{4, 5, 'test'} = Set{4, 'test', 5, 4}");
		assertQueryFalse(null, "Sequence{4, 5, 'test', 4} = Bag{4, 'test', 5, 4}");
		assertQueryFalse(null, "OrderedSet{4, 5, 'test', 4} = Set{4, 'test', 5, 4}");
		assertQueryFalse(null, "OrderedSet{4, 5, 'test', 4} = Bag{4, 'test', 5}");

		// distinct quantities
		assertQueryFalse(null, "Sequence{4, 5, 'test', 4} = Set{4, 'test', 5, 4}");
		assertQueryFalse(null, "Sequence{4, 5, 'test'} = Bag{4, 'test', 5, 4}");
		assertQueryFalse(null, "OrderedSet{4, 5, 'test', 4} = Bag{4, 'test', 5, 4}");
	}

	public void testCollectionEqualUnorderedXUnordered() {
		// same quantities
		assertQueryFalse(null, "Bag{4, 5, 'test'} = Set{4, 'test', 5, 4}");
		assertQueryTrue(null, "Bag{4, 5, 'test', 4} = Bag{4, 'test', 5, 4}");
		assertQueryTrue(null, "Set{4, 5, 'test', 4} = Set{4, 'test', 5, 4}");
		assertQueryFalse(null, "Set{4, 5, 'test', 4} = Bag{4, 'test', 5}");

		// distinct quantities
		assertQueryFalse(null, "Bag{4, 5, 'test', 4} = Set{4, 'test', 5, 4}");
		assertQueryFalse(null, "Bag{4, 5, 'test'} = Bag{4, 'test', 5, 4}");
		assertQueryFalse(null, "Set{4, 5, 'test', 4} = Bag{4, 'test', 5, 4}");
	}

	public void testCollectionEqualInvalid() {
		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in s = Sequence{5}");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in Bag{5} = b");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in s = Set{5}");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = invalid in OrderedSet{5} = o");

		assertQueryInvalid(null, "let s1 : Sequence(Integer) = invalid, s2 : Sequence(Integer) = invalid in s1 = s2");
		assertQueryInvalid(null, "let b1 : Bag(Integer) = invalid, b2 : Bag(Integer) = invalid in b1 = b2");
		assertQueryInvalid(null, "let s1 : Set(Integer) = invalid, s2 : Set(Integer) = invalid in s1 = s2");
		assertQueryInvalid(null, "let o1 : OrderedSet(Integer) = invalid, o2 : OrderedSet(Integer) = invalid in o1 = o2");
	}

	public void testCollectionEqualNull() {		
		assertQueryFalse(null, "Bag{1} = 1");
		assertQueryFalse(null, "OrderedSet{1} = 1");
		assertQueryFalse(null, "Sequence{1} = 1");
		assertQueryFalse(null, "Set{1} = 1");

		assertQueryFalse(null, "1 = Bag{1}");
		assertQueryFalse(null, "1 = OrderedSet{1}");
		assertQueryFalse(null, "1 = Sequence{1}");
		assertQueryFalse(null, "1 = Set{1}");
		
		assertQueryFalse(null, "Bag{} = null");
		assertQueryFalse(null, "OrderedSet{} = null");
		assertQueryFalse(null, "Sequence{} = null");
		assertQueryFalse(null, "Set{} = null");

		assertQueryFalse(null, "null = Bag{}");
		assertQueryFalse(null, "null = OrderedSet{}");
		assertQueryFalse(null, "null = Sequence{}");
		assertQueryFalse(null, "null = Set{}");

		assertQueryFalse(null, "let b : Bag(Integer) = null in b = Bag{}");
		assertQueryFalse(null, "let b : Bag(Integer) = null, s : Set(Integer) = Set{} in b = s");	
		assertQueryFalse(null, "let s : Sequence(Integer) = null in s = Sequence{5}");
		assertQueryFalse(null, "let b : Bag(Integer) = null in Bag{5} = b");
		assertQueryFalse(null, "let s : Set(Integer) = null in s = Set{5}");
		assertQueryFalse(null, "let o : OrderedSet(Integer) = null in OrderedSet{5} = o");

		assertQueryTrue(null, "let s1 : Sequence(Integer) = null, s2 : Sequence(Integer) = null in s1 = s2");
		assertQueryTrue(null, "let b1 : Bag(Integer) = null, b2 : Bag(Integer) = null in b1 = b2");
		assertQueryTrue(null, "let s1 : Set(Integer) = null, s2 : Set(Integer) = null in s1 = s2");
		assertQueryTrue(null, "let o1 : OrderedSet(Integer) = null, o2 : OrderedSet(Integer) = null in o1 = o2");
	}

	public void testCollectionExcludes() {
		assertQueryFalse(null, "Sequence{3, 4.0, 'test'}->excludes(3)");
		assertQueryFalse(null, "Sequence{3, 4.0, 'test'}->excludes(3.0)");
		assertQueryFalse(null, "Sequence{3, 4.0, 'test'}->excludes(4)");
		assertQueryFalse(null, "Sequence{3, 4.0, 'test'}->excludes('test')");
		assertQueryFalse(null, "Bag{3, 4.0, 'test'}->excludes(3)");
		assertQueryFalse(null, "Bag{3, 4.0, 'test'}->excludes(3.0)");
		assertQueryFalse(null, "Bag{3, 4.0, 'test'}->excludes(4)");
		assertQueryFalse(null, "Bag{3, 4.0, 'test'}->excludes('test')");
		assertQueryFalse(null, "Set{3, 4.0, 'test'}->excludes(3)");
		assertQueryFalse(null, "Set{3, 4.0, 'test'}->excludes(3.0)");
		assertQueryFalse(null, "Set{3, 4.0, 'test'}->excludes(4)");
		assertQueryFalse(null, "Set{3, 4.0, 'test'}->excludes('test')");
		assertQueryFalse(null, "OrderedSet{3, 4.0, 'test'}->excludes(3)");
		assertQueryFalse(null, "OrderedSet{3, 4.0, 'test'}->excludes(3.0)");
		assertQueryFalse(null, "OrderedSet{3, 4.0, 'test'}->excludes(4)");
		assertQueryFalse(null, "OrderedSet{3, 4.0, 'test'}->excludes('test')");

		assertQueryTrue(null, "Sequence{3, 4.0, 'test'}->excludes(3.5)");
		assertQueryTrue(null, "Bag{3, 4.0, 'test'}->excludes(3.5)");
		assertQueryTrue(null, "Set{3, 4.0, 'test'}->excludes(3.5)");
		assertQueryTrue(null, "OrderedSet{3, 4.0, 'test'}->excludes(3.5)");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in s->excludes(0)");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in b->excludes(0)");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in s->excludes(0)");
		assertQueryInvalid(null, "let os : OrderedSet(Integer) = invalid in os->excludes(0)");
		// invalid collection element
		assertQueryInvalid(null, "Sequence{3, 4.0, 'test'}->excludes(invalid)");
		assertQueryInvalid(null, "Bag{3, 4.0, 'test'}->excludes(invalid)");
		assertQueryInvalid(null, "Set{3, 4.0, 'test'}->excludes(invalid)");
		assertQueryInvalid(null, "OrderedSet{3, 4.0, 'test'}->excludes(invalid)");

		assertQueryInvalid(null, "Sequence{0, invalid}->excludes(0)");
		assertQueryInvalid(null, "Bag{0, invalid}->excludes(0)");
		assertQueryInvalid(null, "Set{0, invalid}->excludes(0)");
		assertQueryInvalid(null, "OrderedSet{0, invalid}->excludes(0)");
		// null collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = null in s->excludes(0)");
		assertQueryInvalid(null, "let b : Bag(Integer) = null in b->excludes(0)");
		assertQueryInvalid(null, "let s : Set(Integer) = null in s->excludes(0)");
		assertQueryInvalid(null, "let os : OrderedSet(Integer) = null in os->excludes(0)");
		// null collection element
		assertQueryFalse(null, "Sequence{3, 4.0, null, 'test'}->excludes(null)");
		assertQueryFalse(null, "Sequence{null}->excludes(null)");
		assertQueryFalse(null, "Bag{3, 4.0, null, 'test'}->excludes(null)");
		assertQueryFalse(null, "Bag{null}->excludes(null)");
		assertQueryFalse(null, "Set{3, 4.0, null, 'test'}->excludes(null)");
		assertQueryFalse(null, "Set{null}->excludes(null)");
		assertQueryFalse(null, "OrderedSet{3, 4.0, null, 'test'}->excludes(null)");
		assertQueryFalse(null, "OrderedSet{null}->excludes(null)");

		assertQueryTrue(null, "Sequence{3, 4.0, 'test'}->excludes(null)");
		assertQueryTrue(null, "Sequence{}->excludes(null)");
		assertQueryTrue(null, "Bag{3, 4.0, 'test'}->excludes(null)");
		assertQueryTrue(null, "Bag{}->excludes(null)");
		assertQueryTrue(null, "Set{3, 4.0, 'test'}->excludes(null)");
		assertQueryTrue(null, "Set{}->excludes(null)");
		assertQueryTrue(null, "OrderedSet{3, 4.0, 'test'}->excludes(null)");
		assertQueryTrue(null, "OrderedSet{}->excludes(null)");
	}

	public void testCollectionExcludesAll() {
		assertQueryFalse(null, "Sequence{3, 4.0, 'test'}->excludesAll(Sequence{3, 'test'})");
		assertQueryFalse(null, "Sequence{3, 4.0, 'test'}->excludesAll(Bag{3, 'test'})");
		assertQueryFalse(null, "Sequence{3, 4.0, 'test'}->excludesAll(Set{3, 'test'})");
		assertQueryFalse(null, "Sequence{3, 4.0, 'test'}->excludesAll(OrderedSet{3, 'test'})");
		assertQueryFalse(null, "Bag{3, 4.0, 'test'}->excludesAll(Sequence{3, 'test'})");
		assertQueryFalse(null, "Bag{3, 4.0, 'test'}->excludesAll(Bag{3, 'test'})");
		assertQueryFalse(null, "Bag{3, 4.0, 'test'}->excludesAll(Set{3, 'test'})");
		assertQueryFalse(null, "Bag{3, 4.0, 'test'}->excludesAll(OrderedSet{3, 'test'})");
		assertQueryFalse(null, "Set{3, 4.0, 'test'}->excludesAll(Sequence{3, 'test'})");
		assertQueryFalse(null, "Set{3, 4.0, 'test'}->excludesAll(Bag{3, 'test'})");
		assertQueryFalse(null, "Set{3, 4.0, 'test'}->excludesAll(Set{3, 'test'})");
		assertQueryFalse(null, "Set{3, 4.0, 'test'}->excludesAll(OrderedSet{3, 'test'})");
		assertQueryFalse(null, "OrderedSet{3, 4.0, 'test'}->excludesAll(Sequence{3, 'test'})");
		assertQueryFalse(null, "OrderedSet{3, 4.0, 'test'}->excludesAll(Bag{3, 'test'})");
		assertQueryFalse(null, "OrderedSet{3, 4.0, 'test'}->excludesAll(Set{3, 'test'})");
		assertQueryFalse(null, "OrderedSet{3, 4.0, 'test'}->excludesAll(OrderedSet{3, 'test'})");

		assertQueryTrue(null, "Sequence{3, 4.0, 'test'}->excludesAll(Sequence{3.5, 'TEST'})");
		assertQueryTrue(null, "Sequence{3, 4.0, 'test'}->excludesAll(Bag{3.5, 'TEST'})");
		assertQueryTrue(null, "Sequence{3, 4.0, 'test'}->excludesAll(Set{3.5, 'TEST'})");
		assertQueryTrue(null, "Sequence{3, 4.0, 'test'}->excludesAll(OrderedSet{3.5, 'TEST'})");
		assertQueryTrue(null, "Bag{3, 4.0, 'test'}->excludesAll(Sequence{3.5, 'TEST'})");
		assertQueryTrue(null, "Bag{3, 4.0, 'test'}->excludesAll(Bag{3.5, 'TEST'})");
		assertQueryTrue(null, "Bag{3, 4.0, 'test'}->excludesAll(Set{3.5, 'TEST'})");
		assertQueryTrue(null, "Bag{3, 4.0, 'test'}->excludesAll(OrderedSet{3.5, 'TEST'})");
		assertQueryTrue(null, "Set{3, 4.0, 'test'}->excludesAll(Sequence{3.5, 'TEST'})");
		assertQueryTrue(null, "Set{3, 4.0, 'test'}->excludesAll(Bag{3.5, 'TEST'})");
		assertQueryTrue(null, "Set{3, 4.0, 'test'}->excludesAll(Set{3.5, 'TEST'})");
		assertQueryTrue(null, "Set{3, 4.0, 'test'}->excludesAll(OrderedSet{3.5, 'TEST'})");
		assertQueryTrue(null, "OrderedSet{3, 4.0, 'test'}->excludesAll(Sequence{3.5, 'TEST'})");
		assertQueryTrue(null, "OrderedSet{3, 4.0, 'test'}->excludesAll(Bag{3.5, 'TEST'})");
		assertQueryTrue(null, "OrderedSet{3, 4.0, 'test'}->excludesAll(Set{3.5, 'TEST'})");
		assertQueryTrue(null, "OrderedSet{3, 4.0, 'test'}->excludesAll(OrderedSet{3.5, 'TEST'})");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in s->excludesAll(Sequence{0})");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in b->excludesAll(Bag{0})");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in s->excludesAll(Set{0})");
		assertQueryInvalid(null, "let os : OrderedSet(Integer) = invalid in os->excludesAll(OrderedSet{0})");

		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in Sequence{0}->excludesAll(s)");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in Bag{0}->excludesAll(b)");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in Set{0}->excludesAll(s)");
		assertQueryInvalid(null, "let os : OrderedSet(Integer) = invalid in OrderedSet{0}->excludesAll(os)");
		// invalid collection element
		// Collections can't contain the invalid value
		assertQueryInvalid(null, "let b : Bag(String) = invalid in b->excludesAll(OrderedSet{'test'})");
		assertQueryInvalid(null, "Sequence{3, 4, invalid, 'test'}->excludesAll(OrderedSet{'test'})");
		assertQueryInvalid(null, "Bag{3, 4, invalid, 'test'}->excludesAll(Set{'test'})");
		assertQueryInvalid(null, "Set{3, 4, invalid, 'test'}->excludesAll(Bag{'test'})");
		assertQueryInvalid(null, "OrderedSet{3, 4, invalid, 'test'}->excludesAll(Sequence{'test'})");

		assertQueryInvalid(null, "Sequence{3, 4, 'test'}->excludesAll(OrderedSet{'test', invalid})");
		assertQueryInvalid(null, "Bag{3, 4, 'test'}->excludesAll(Set{'test', invalid})");
		assertQueryInvalid(null, "Set{3, 4, 'test'}->excludesAll(Bag{'test', invalid})");
		assertQueryInvalid(null, "OrderedSet{3, 4, 'test'}->excludesAll(Sequence{'test', invalid})");
		// null collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = null in s->excludesAll(Sequence{0})");
		assertQueryInvalid(null, "let b : Bag(Integer) = null in b->excludesAll(Bag{0})");
		assertQueryInvalid(null, "let s : Set(Integer) = null in s->excludesAll(Set{0})");
		assertQueryInvalid(null, "let os : OrderedSet(Integer) = null in os->excludesAll(OrderedSet{0})");

		assertQueryInvalid(null, "let s : Sequence(Integer) = null in Sequence{0}->excludesAll(s)");
		assertQueryInvalid(null, "let b : Bag(Integer) = null in Bag{0}->excludesAll(b)");
		assertQueryInvalid(null, "let s : Set(Integer) = null in Set{0}->excludesAll(s)");
		assertQueryInvalid(null, "let os : OrderedSet(Integer) = null in OrderedSet{0}->excludesAll(os)");
		// null collection element
		assertQueryFalse(null, "Sequence{3, 4, null, 'test'}->excludesAll(OrderedSet{'TEST', null})");
		assertQueryFalse(null, "Bag{3, 4, null, 'test'}->excludesAll(Set{'TEST', null})");
		assertQueryFalse(null, "Set{3, 4, null, 'test'}->excludesAll(Bag{'TEST', null})");
		assertQueryFalse(null, "OrderedSet{3, 4, null, 'test'}->excludesAll(Sequence{'TEST', null})");

		assertQueryTrue(null, "Sequence{3, 4, 'test'}->excludesAll(OrderedSet{'TEST', null})");
		assertQueryTrue(null, "Bag{3, 4, 'test'}->excludesAll(Set{'TEST', null})");
		assertQueryTrue(null, "Set{3, 4, 'test'}->excludesAll(Bag{'TEST', null})");
		assertQueryTrue(null, "OrderedSet{3, 4, 'test'}->excludesAll(Sequence{'TEST', null})");
	}

	public void testCollectionExcluding() {
		/*
		 * FIXME OMG-issue to add OrderedSet::excluding
		 * since it's defined in oclstdlib.ecore. However the defined
		 * "OrderedSet::excluding(T) : Set" should be
		 * "OrderedSet::excluding(T) : OrderedSet"
		 */
		assertQueryResults(null, "Sequence{'a', 'c'}", "Sequence{'b', 'a', 'b', 'c'}->excluding('b')");
		assertQueryResults(null, "Bag{'c', 'a'}", "Bag{'b', 'a', 'b', 'c'}->excluding('b')");
		assertQueryResults(null, "Set{'c', 'a'}", "Set{'a', 'b', 'c'}->excluding('b')");
		assertQueryResults(null, "OrderedSet{'a', 'c'}", "OrderedSet{'a', 'b', 'c'}->excluding('b')");
		assertQueryResults(null, "Sequence{1,3,4}", "Sequence{1..4}->excluding(2)");
		assertQueryResults(null, "Sequence{1..3,6..9}", "Sequence{1..4,6,7..9}->excluding(4)");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(String) = invalid in s->excluding('a')");
		assertQueryInvalid(null, "let b : Bag(String) = invalid in b->excluding('a')");
		assertQueryInvalid(null, "let s : Set(String) = invalid in s->excluding('a')");
		assertQueryInvalid(null, "let o : OrderedSet(String) = invalid in o->excluding('a')");
		// invalid collection element
		assertQueryInvalid(null, "Sequence{'a', 'b'}->excluding(invalid)");
		assertQueryInvalid(null, "Bag{'a', 'b'}->excluding(invalid)");
		assertQueryInvalid(null, "Set{'a', 'b'}->excluding(invalid)");
		assertQueryInvalid(null, "OrderedSet{'a', 'b'}->excluding(invalid)");
		// null collection
		assertQueryInvalid(null, "let s : Sequence(String) = null in s->excluding('a')");
		assertQueryInvalid(null, "let b : Bag(String) = null in b->excluding('a')");
		assertQueryInvalid(null, "let s : Set(String) = null in s->excluding('a')");
		assertQueryInvalid(null, "let o : OrderedSet(String) = null in o->excluding('a')");
		// invalid collection element
		assertQueryResults(null, "Sequence{'a', 'b'}", "Sequence{null, 'a', null, 'b'}->excluding(null)");
		assertQueryResults(null, "Bag{'b', 'a'}", "Bag{null, 'a', null, 'b'}->excluding(null)");
		assertQueryResults(null, "Set{'b', 'a'}", "Set{'a', null, 'b'}->excluding(null)");
		assertQueryResults(null, "OrderedSet{'a', 'b'}", "OrderedSet{'a', null, 'b'}->excluding(null)");
	}

	public void testCollectionFirst() {
		assertQueryEquals(null, 1, "Sequence{1, 2.0, '3'}->first()");
		assertQueryEquals(null, 1, "OrderedSet{1, 2.0, '3'}->first()");
		// empty
		assertQueryInvalid(null, "OrderedSet{}->first()");
		assertQueryInvalid(null, "Sequence{}->first()");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in s->first()");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = invalid in o->first()");
		// invalid collection element
		assertQueryInvalid(null, "Sequence{1, invalid}->first()");
		assertQueryInvalid(null, "OrderedSet{1, invalid}->first()");
		// null collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = null in s->first()");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = null in o->first()");
		// null collection element
		assertQueryNull(null, "Sequence{null}->first()");
		assertQueryNull(null, "OrderedSet{null}->first()");
	}

	public void testCollectionFlatten() {
		assertQueryEquals(null, valueFactory.getEmptySequenceValue(), "Sequence{}->flatten()");
		assertQueryEquals(null, valueFactory.getEmptyBagValue(), "Bag{}->flatten()");
		assertQueryEquals(null, valueFactory.getEmptySetValue(), "Set{}->flatten()");
		assertQueryEquals(null, valueFactory.getEmptyOrderedSetValue(), "OrderedSet{}->flatten()");

		String expression = "Sequence{Set{1,2,3}, Sequence{2.0, 3.0}, Bag{'test'}}->flatten()";
		String expectedResultExpression = "Sequence{1, 2, 3, 2.0, 3.0, 'test'}";
		/*
		 * as the Sequence is ordered and we cannot know in which order the
		 * result of the Set flatenning were inserted, simply check that the
		 * result is a Sequence and contains all elements.
		 */
		assertResultContainsAll(null, expectedResultExpression, expression);

		expression = "Bag{Set{Bag{'test', 2, 3.0}}, Sequence{OrderedSet{2.0, 3, 1}}}->flatten()";
		expectedResultExpression = "Bag{1, 2, 3, 2.0, 3.0, 'test'}";
		assertQueryResults(null, expectedResultExpression, expression);

		expression = "Set{OrderedSet{Set{3.0, 'test'}, Sequence{2.0, 2}, Bag{1, 3}}}->flatten()";
		expectedResultExpression = "Set{1, 2.0, 3.0, 'test'}";
		assertResultContainsAll(null, expectedResultExpression, expression);

		expression = "OrderedSet{Set{Set{3.0, 'test'}, Sequence{2.0, 2}, Bag{1, 3}}}->flatten()";
		expectedResultExpression = "OrderedSet{1, 2, 2.0, 3.0, 'test'}";
		assertResultContainsAll(null, expectedResultExpression, expression);

		expression = "Set{Sequence{Sequence{3.0, 'test'}}, Sequence{Sequence{2.0, 2}, Sequence{1, 3}}}->flatten()";
		expectedResultExpression = "Set{1, 2, 3, 2.0, 3.0, 'test'}";
		assertResultContainsAll(null, expectedResultExpression, expression);
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in s->flatten()");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in b->flatten()");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in s->flatten()");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = invalid in o->flatten()");
		// non collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = null in s->flatten()");
		assertQueryInvalid(null, "let b : Bag(Integer) = null in b->flatten()");
		assertQueryInvalid(null, "let s : Set(Integer) = null in s->flatten()");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = null in o->flatten()");
		// pseudo collection
		assertQueryResults(null, "Set{1}", "1->flatten()");
		assertQueryResults(null, "Set{1}", "let s : Sequence(Integer) = null in 1->flatten()");
		assertQueryResults(null, "Set{1}", "let b : Bag(Integer) = null in 1->flatten()");
		assertQueryResults(null, "Set{1}", "let s : Set(Integer) = null in 1->flatten()");
		assertQueryResults(null, "Set{1}", "let o : OrderedSet(Integer) = null in 1->flatten()");
	}

	public void testCollectionIncludes() {
		assertQueryTrue(null, "Sequence{3, 4.0, 'test'}->includes(3)");
		assertQueryTrue(null, "Sequence{3, 4.0, 'test'}->includes(3.0)");
		assertQueryTrue(null, "Sequence{3, 4.0, 'test'}->includes(4)");
		assertQueryTrue(null, "Sequence{3, 4.0, 'test'}->includes('test')");
		assertQueryTrue(null, "Bag{3, 4.0, 'test'}->includes(3)");
		assertQueryTrue(null, "Bag{3, 4.0, 'test'}->includes(3.0)");
		assertQueryTrue(null, "Bag{3, 4.0, 'test'}->includes(4)");
		assertQueryTrue(null, "Bag{3, 4.0, 'test'}->includes('test')");
		assertQueryTrue(null, "Set{3, 4.0, 'test'}->includes(3)");
		assertQueryTrue(null, "Set{3, 4.0, 'test'}->includes(3.0)");
		assertQueryTrue(null, "Set{3, 4.0, 'test'}->includes(4)");
		assertQueryTrue(null, "Set{3, 4.0, 'test'}->includes('test')");
		assertQueryTrue(null, "OrderedSet{3, 4.0, 'test'}->includes(3)");
		assertQueryTrue(null, "OrderedSet{3, 4.0, 'test'}->includes(3.0)");
		assertQueryTrue(null, "OrderedSet{3, 4.0, 'test'}->includes(4)");
		assertQueryTrue(null, "OrderedSet{3, 4.0, 'test'}->includes('test')");
		
		assertQueryFalse(null, "Sequence{3, 4.0, 'test'}->includes(3.5)");
		assertQueryFalse(null, "Bag{3, 4.0, 'test'}->includes(3.5)");
		assertQueryFalse(null, "Set{3, 4.0, 'test'}->includes(3.5)");
		assertQueryFalse(null, "OrderedSet{3, 4.0, 'test'}->includes(3.5)");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in s->includes(0)");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in b->includes(0)");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in s->includes(0)");
		assertQueryInvalid(null, "let os : OrderedSet(Integer) = invalid in os->includes(0)");
		// invalid collection element
		assertQueryInvalid(null, "Sequence{3, 4.0, 'test'}->includes(invalid)");
		assertQueryInvalid(null, "Bag{3, 4.0, 'test'}->includes(invalid)");
		assertQueryInvalid(null, "Set{3, 4.0, 'test'}->includes(invalid)");
		assertQueryInvalid(null, "OrderedSet{3, 4.0, 'test'}->includes(invalid)");

		assertQueryInvalid(null, "Sequence{0, invalid}->includes(0)");
		assertQueryInvalid(null, "Bag{0, invalid}->includes(0)");
		assertQueryInvalid(null, "Set{0, invalid}->includes(0)");
		assertQueryInvalid(null, "OrderedSet{0, invalid}->includes(0)");
		// invalid null
		assertQueryInvalid(null, "let s : Sequence(Integer) = null in s->includes(0)");
		assertQueryInvalid(null, "let b : Bag(Integer) = null in b->includes(0)");
		assertQueryInvalid(null, "let s : Set(Integer) = null in s->includes(0)");
		assertQueryInvalid(null, "let os : OrderedSet(Integer) = null in os->includes(0)");
		// invalid null element
		assertQueryTrue(null, "Sequence{3, 4.0, null, 'test'}->includes(null)");
		assertQueryTrue(null, "Sequence{null}->includes(null)");
		assertQueryTrue(null, "Bag{3, 4.0, null, 'test'}->includes(null)");
		assertQueryTrue(null, "Bag{null}->includes(null)");
		assertQueryTrue(null, "Set{3, 4.0, null, 'test'}->includes(null)");
		assertQueryTrue(null, "Set{null}->includes(null)");
		assertQueryTrue(null, "OrderedSet{3, 4.0, null, 'test'}->includes(null)");
		assertQueryTrue(null, "OrderedSet{null}->includes(null)");

		assertQueryFalse(null, "Sequence{3, 4.0, 'test'}->includes(null)");
		assertQueryFalse(null, "Sequence{}->includes(null)");
		assertQueryFalse(null, "Bag{3, 4.0, 'test'}->includes(null)");
		assertQueryFalse(null, "Bag{}->includes(null)");
		assertQueryFalse(null, "Set{3, 4.0, 'test'}->includes(null)");
		assertQueryFalse(null, "Set{}->includes(null)");
		assertQueryFalse(null, "OrderedSet{3, 4.0, 'test'}->includes(null)");
		assertQueryFalse(null, "OrderedSet{}->includes(null)");
	}

	public void testCollectionIncludesAll() {
		assertQueryTrue(null, "Sequence{3, 4.0, 'test'}->includesAll(Sequence{3, 'test'})");
		assertQueryTrue(null, "Sequence{3, 4.0, 'test'}->includesAll(Bag{3, 'test'})");
		assertQueryTrue(null, "Sequence{3, 4.0, 'test'}->includesAll(Set{3, 'test'})");
		assertQueryTrue(null, "Sequence{3, 4.0, 'test'}->includesAll(OrderedSet{3, 'test'})");
		assertQueryTrue(null, "Bag{3, 4.0, 'test'}->includesAll(Sequence{3, 'test'})");
		assertQueryTrue(null, "Bag{3, 4.0, 'test'}->includesAll(Bag{3, 'test'})");
		assertQueryTrue(null, "Bag{3, 4.0, 'test'}->includesAll(Set{3, 'test'})");
		assertQueryTrue(null, "Bag{3, 4.0, 'test'}->includesAll(OrderedSet{3, 'test'})");
		assertQueryTrue(null, "Set{3, 4.0, 'test'}->includesAll(Sequence{3, 'test'})");
		assertQueryTrue(null, "Set{3, 4.0, 'test'}->includesAll(Bag{3, 'test'})");
		assertQueryTrue(null, "Set{3, 4.0, 'test'}->includesAll(Set{3, 'test'})");
		assertQueryTrue(null, "Set{3, 4.0, 'test'}->includesAll(OrderedSet{3, 'test'})");
		assertQueryTrue(null, "OrderedSet{3, 4.0, 'test'}->includesAll(Sequence{3, 'test'})");
		assertQueryTrue(null, "OrderedSet{3, 4.0, 'test'}->includesAll(Bag{3, 'test'})");
		assertQueryTrue(null, "OrderedSet{3, 4.0, 'test'}->includesAll(Set{3, 'test'})");
		assertQueryTrue(null, "OrderedSet{3, 4.0, 'test'}->includesAll(OrderedSet{3, 'test'})");

		assertQueryFalse(null, "Sequence{3, 4.0, 'test'}->includesAll(Sequence{3.5, 'test'})");
		assertQueryFalse(null, "Sequence{3, 4.0, 'test'}->includesAll(Bag{3.5, 'test'})");
		assertQueryFalse(null, "Sequence{3, 4.0, 'test'}->includesAll(Set{3.5, 'test'})");
		assertQueryFalse(null, "Sequence{3, 4.0, 'test'}->includesAll(OrderedSet{3.5, 'test'})");
		assertQueryFalse(null, "Bag{3, 4.0, 'test'}->includesAll(Sequence{3.5, 'test'})");
		assertQueryFalse(null, "Bag{3, 4.0, 'test'}->includesAll(Bag{3.5, 'test'})");
		assertQueryFalse(null, "Bag{3, 4.0, 'test'}->includesAll(Set{3.5, 'test'})");
		assertQueryFalse(null, "Bag{3, 4.0, 'test'}->includesAll(OrderedSet{3.5, 'test'})");
		assertQueryFalse(null, "Set{3, 4.0, 'test'}->includesAll(Sequence{3.5, 'test'})");
		assertQueryFalse(null, "Set{3, 4.0, 'test'}->includesAll(Bag{3.5, 'test'})");
		assertQueryFalse(null, "Set{3, 4.0, 'test'}->includesAll(Set{3.5, 'test'})");
		assertQueryFalse(null, "Set{3, 4.0, 'test'}->includesAll(OrderedSet{3.5, 'test'})");
		assertQueryFalse(null, "OrderedSet{3, 4.0, 'test'}->includesAll(Sequence{3.5, 'test'})");
		assertQueryFalse(null, "OrderedSet{3, 4.0, 'test'}->includesAll(Bag{3.5, 'test'})");
		assertQueryFalse(null, "OrderedSet{3, 4.0, 'test'}->includesAll(Set{3.5, 'test'})");
		assertQueryFalse(null, "OrderedSet{3, 4.0, 'test'}->includesAll(OrderedSet{3.5, 'test'})");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in s->includesAll(Sequence{0})");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in b->includesAll(Bag{0})");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in s->includesAll(Set{0})");
		assertQueryInvalid(null, "let os : OrderedSet(Integer) = invalid in os->includesAll(OrderedSet{0})");

		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in Sequence{0}->includesAll(s)");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in Bag{0}->includesAll(b)");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in Set{0}->includesAll(s)");
		assertQueryInvalid(null, "let os : OrderedSet(Integer) = invalid in OrderedSet{0}->includesAll(os)");
		// invalid collection element
		// Collections can't contain the invalid value
		assertQueryInvalid(null, "Sequence{3, 4, invalid, 'test'}->includesAll(OrderedSet{'test'})");
		assertQueryInvalid(null, "Bag{3, 4, invalid, 'test'}->includesAll(Set{'test'})");
		assertQueryInvalid(null, "Set{3, 4, invalid, 'test'}->includesAll(Bag{'test'})");
		assertQueryInvalid(null, "OrderedSet{3, 4, invalid, 'test'}->includesAll(Sequence{'test'})");

		assertQueryInvalid(null, "Sequence{3, 4, 'test'}->includesAll(OrderedSet{'test', invalid})");
		assertQueryInvalid(null, "Bag{3, 4, 'test'}->includesAll(Set{'test', invalid})");
		assertQueryInvalid(null, "Set{3, 4, 'test'}->includesAll(Bag{'test', invalid})");
		assertQueryInvalid(null, "OrderedSet{3, 4, 'test'}->includesAll(Sequence{'test', invalid})");
		// null collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = null in s->includesAll(Sequence{0})");
		assertQueryInvalid(null, "let b : Bag(Integer) = null in b->includesAll(Bag{0})");
		assertQueryInvalid(null, "let s : Set(Integer) = null in s->includesAll(Set{0})");
		assertQueryInvalid(null, "let os : OrderedSet(Integer) = null in os->includesAll(OrderedSet{0})");

		assertQueryInvalid(null, "let s : Sequence(Integer) = null in Sequence{0}->includesAll(s)");
		assertQueryInvalid(null, "let b : Bag(Integer) = null in Bag{0}->includesAll(b)");
		assertQueryInvalid(null, "let s : Set(Integer) = null in Set{0}->includesAll(s)");
		assertQueryInvalid(null, "let os : OrderedSet(Integer) = null in OrderedSet{0}->includesAll(os)");
		// null collection element
		assertQueryTrue(null, "Sequence{3, 4, null, 'test'}->includesAll(OrderedSet{'test', null})");
		assertQueryTrue(null, "Bag{3, 4, null, 'test'}->includesAll(Set{'test', null})");
		assertQueryTrue(null, "Set{3, 4, null, 'test'}->includesAll(Bag{'test', null})");
		assertQueryTrue(null, "OrderedSet{3, 4, null, 'test'}->includesAll(Sequence{'test', null})");

		assertQueryFalse(null, "Sequence{3, 4, 'test'}->includesAll(OrderedSet{'test', null})");
		assertQueryFalse(null, "Bag{3, 4, 'test'}->includesAll(Set{'test', null})");
		assertQueryFalse(null, "Set{3, 4, 'test'}->includesAll(Bag{'test', null})");
		assertQueryFalse(null, "OrderedSet{3, 4, 'test'}->includesAll(Sequence{'test', null})");
	}

	public void testCollectionIncluding() {
		/*
		 * FIXME OMG-issue to add OrderedSet::including
		 * since it's defined in oclstdlib.ecore. However the defined
		 * "OrderedSet::including(T) : Set" should be
		 * "OrderedSet::including(T) : OrderedSet"
		 */
		assertQueryResults(null, "Sequence{'a', 'b', 'c'}", "Sequence{'a', 'b'}->including('c')");
		assertQueryResults(null, "Bag{'c', 'b', 'a'}", "Bag{'a', 'b'}->including('c')");
		assertQueryResults(null, "Set{'a', 'c', 'b'}", "Set{'a', 'b'}->including('c')");
		assertQueryResults(null, "OrderedSet{'a', 'b', 'c'}", "OrderedSet{'a', 'b'}->including('c')");
		assertQueryResults(null, "OrderedSet{1..2,3..4}", "OrderedSet{1..4}->including(4)");
		assertQueryResults(null, "Sequence{1..2,3..4,4}", "Sequence{1..4}->including(4)");
		assertQueryResults(null, "Set{1..9}", "Set{1..4,6,7..9}->including(5)");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(String) = invalid in s->including('a')");
		assertQueryInvalid(null, "let b : Bag(String) = invalid in b->including('a')");
		assertQueryInvalid(null, "let s : Set(String) = invalid in s->including('a')");
		assertQueryInvalid(null, "let o : OrderedSet(String) = invalid in o->including('a')");
		// invalid collection element
		assertQueryInvalid(null, "Sequence{'a', 'b'}->including(invalid)");
		assertQueryInvalid(null, "Bag{'a', 'b'}->including(invalid)");
		assertQueryInvalid(null, "Set{'a', 'b'}->including(invalid)");
		assertQueryInvalid(null, "OrderedSet{'a', 'b'}->including(invalid)");
		// null collection
		assertQueryInvalid(null, "let s : Sequence(String) = null in s->including('a')");
		assertQueryInvalid(null, "let b : Bag(String) = null in b->including('a')");
		assertQueryInvalid(null, "let s : Set(String) = null in s->including('a')");
		assertQueryInvalid(null, "let o : OrderedSet(String) = null in o->including('a')");
		// null collection element
		assertQueryResults(null, "Sequence{'a', 'b', null}", "Sequence{'a', 'b'}->including(null)");
		assertQueryResults(null, "Bag{null, 'b', 'a'}", "Bag{'a', 'b'}->including(null)");
		assertQueryResults(null, "Set{'a', null, 'b'}", "Set{'a', 'b'}->including(null)");
		assertQueryResults(null, "OrderedSet{'a', 'b', null}", "OrderedSet{'a', 'b'}->including(null)");
	}

	public void testCollectionIndexOf() {
		assertQueryEquals(null, 1, "Sequence{'a', 'b'}->indexOf('a')");
		assertQueryEquals(null, 2, "OrderedSet{'a', 'b'}->indexOf('b')");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(String) = invalid in s->indexOf('a')");
		assertQueryInvalid(null, "let o : OrderedSet(String) = invalid in o->indexOf('a')");
		// invalid collection element
		assertQueryInvalid(null, "Sequence{'a', invalid}->indexOf(invalid)");
		assertQueryInvalid(null, "OrderedSet{'a', invalid}->indexOf(invalid)");
		// null collection
		assertQueryInvalid(null, "let s : Sequence(String) = null in s->indexOf('a')");
		assertQueryInvalid(null, "let o : OrderedSet(String) = null in o->indexOf('a')");
		// null collection element
		assertQueryEquals(null, 1, "Sequence{null, 'a'}->indexOf(null)");
		assertQueryEquals(null, 1, "OrderedSet{null, 'a'}->indexOf(null)");
		// non-element
		assertQueryInvalid(null, "Sequence{'a'}->indexOf('b')");
		assertQueryInvalid(null, "OrderedSet{'a'}->indexOf('b')");
	}

	public void testCollectionInsertAt() {
		// For now resolve Issue 14980 semantics by by first removing an existing content
		assertQueryResults(null, "Sequence{'c', 'a', 'b'}", "Sequence{'a', 'b'}->insertAt(1, 'c')");
		assertQueryResults(null, "OrderedSet{'a', 'c', 'b'}", "OrderedSet{'a', 'b'}->insertAt(2, 'c')");

		// We can add _after_ the last element
		assertQueryResults(null, "Sequence{'a', 'b', 'c'}", "Sequence{'a', 'b'}->insertAt(3, 'c')");
		assertQueryResults(null, "OrderedSet{'a', 'b', 'c'}", "OrderedSet{'a', 'b'}->insertAt(3, 'c')");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(String) = invalid in s->insertAt(1, 'a')");
		assertQueryInvalid(null, "let o : OrderedSet(String) = invalid in o->insertAt(1, 'a')");
		// invalid collection element
		assertQueryInvalid(null, "Sequence{'a'}->insertAt(1, invalid)");
		assertQueryInvalid(null, "OrderedSet{'a'}->insertAt(1, invalid)");
		// null collection
		assertQueryInvalid(null, "let s : Sequence(String) = null in s->insertAt(1, 'a')");
		assertQueryInvalid(null, "let o : OrderedSet(String) = null in o->insertAt(1, 'a')");
		// null collection element
		assertQueryResults(null, "Sequence{null, 'a'}", "Sequence{'a'}->insertAt(1, null)");
		assertQueryResults(null, "OrderedSet{'a', null}", "OrderedSet{'a'}->insertAt(2, null)");
		// out of bounds
		assertQueryInvalid(null, "Sequence{'a'}->insertAt(0, 'b')");
		assertQueryInvalid(null, "OrderedSet{'a'}->insertAt(0, 'b')");
		assertQueryInvalid(null, "Sequence{'a'}->insertAt(3, 'b')");
		assertQueryInvalid(null, "OrderedSet{'a'}->insertAt(3, 'b')");
		assertQueryInvalid(null, "OrderedSet{'a'}->insertAt(2, 'a')");
		// duplicates
		assertQueryResults(null, "Sequence{'b', 'a', 'b', 'c'}", "Sequence{'a', 'b', 'c'}->insertAt(1, 'b')");
		assertQueryResults(null, "Sequence{'a', 'b', 'c', 'b'}", "Sequence{'a', 'b', 'c'}->insertAt(4, 'b')");
		assertQueryResults(null, "OrderedSet{'b', 'a', 'c'}", "OrderedSet{'a', 'b', 'c'}->insertAt(1, 'b')");
		assertQueryResults(null, "OrderedSet{'a', 'b', 'c'}", "OrderedSet{'a', 'b', 'c'}->insertAt(2, 'b')");
//		assertQueryResults(null, "OrderedSet{'a', 'b', 'c'}", "OrderedSet{'a', 'b', 'c'}->insertAt(3, 'b')");
		assertQueryResults(null, "OrderedSet{'a', 'c', 'b'}", "OrderedSet{'a', 'b', 'c'}->insertAt(3, 'b')");
//		assertQueryResults(null, "OrderedSet{'a', 'c', 'b'}", "OrderedSet{'a', 'b', 'c'}->insertAt(4, 'b')");
		assertQueryInvalid(null, "OrderedSet{'a', 'b', 'c'}->insertAt(4, 'b')");
	}

	public void testCollectionIntersection() {
		// No duplicates
		assertQueryEquals(null, valueFactory.getEmptySetValue(), "Set{'a', 'b'}->intersection(Set{'c', 'd'})");
		assertQueryEquals(null, valueFactory.getEmptySetValue(), "Set{'a', 'b'}->intersection(Bag{'c', 'd'})");
		assertQueryEquals(null, valueFactory.getEmptySetValue(), "Bag{'a', 'b'}->intersection(Set{'c', 'd'})");
		assertQueryEquals(null, valueFactory.getEmptyBagValue(), "Bag{'a', 'b'}->intersection(Bag{'c', 'd'})");
		// Duplicates
		assertQueryResults(null, "Set{'a', 'b'}", "Set{'a', 'b', 'a'}->intersection(Set{'a', 'b', 'c'})");
		assertQueryResults(null, "Set{'a', 'b'}", "Set{'a', 'b', 'a'}->intersection(Bag{'a', 'b', 'c'})");
		assertQueryResults(null, "Set{'a', 'b'}", "Bag{'a', 'b', 'a'}->intersection(Set{'a', 'b', 'c'})");
		// FIXME The specification tells us we should be expecting the least
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
		assertQueryResults(null, "Bag{'a', 'b'}", "Bag{'a', 'b', 'a'}->intersection(Bag{'a', 'b'})");
		assertQueryResults(null, "Bag{'a', 'b'}", "Bag{'a', 'b'}->intersection(Bag{'a', 'b', 'a'})");
		assertQueryResults(null, "Bag{'a', 'b', 'b'}", "Bag{'a', 'b', 'a', 'b'}->intersection(Bag{'a', 'b', 'b'})");
		assertQueryResults(null, "Bag{'a', 'b'}", "Bag{'a', 'b', 'a'}->intersection(Bag{'a', 'b', 'c'})");

		assertQueryResults(null, "Bag{'a'}", "Bag{'a', 'a', 'a', 'a'}->intersection(Bag{'a', 'b', 'b'})");

		
		// empty collection
		assertQueryEquals(null, valueFactory.getEmptySetValue(), "Set{3, 4}->intersection(Set{})");
		assertQueryEquals(null, valueFactory.getEmptySetValue(), "Set{3, 4}->intersection(Bag{})");
		assertQueryEquals(null, valueFactory.getEmptyBagValue(), "Bag{3, 4}->intersection(Bag{})");
		assertQueryEquals(null, valueFactory.getEmptySetValue(), "Bag{3, 4}->intersection(Set{})");
		// implicit collection
		assertQueryEquals(null, valueFactory.getEmptySetValue(), "1->intersection(Set{})");
		assertQueryEquals(null, valueFactory.getEmptySetValue(), "2->intersection(Bag{})");

//        assertBadQuery(SemanticException.class, Diagnostic.ERROR,
//        	"Set{}->intersection(Set{3, 4})",
//        	OCLMessages.OperationNotFound_ERROR_, "intersection(Set(Integer))", "Set(OclVoid)");	
		
		assertQueryEquals(null, valueFactory.getEmptySetValue(), "Set{}->intersection(Set{3, 4})");
		assertQueryEquals(null, valueFactory.getEmptySetValue(), "Set{}->intersection(Bag{3, 4})");
		assertQueryEquals(null, valueFactory.getEmptyBagValue(), "Bag{}->intersection(Bag{3, 4})");
		assertQueryEquals(null, valueFactory.getEmptySetValue(), "Bag{}->intersection(Set{3, 4})");
		// invalid collection
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in s->intersection(Set{4})");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in s->intersection(Bag{4})");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in b->intersection(Set{4})");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in b->intersection(Bag{4})");

		assertSemanticErrorQuery("let s : Set(Integer) = invalid in Set{4}->intersection(s)",
			OCLMessages.ErrorUnresolvedOperationName, "intersection");
		assertQueryInvalid(null, "let s : Set(UnlimitedNatural) = invalid in Set{4}->intersection(s)");
		assertQueryInvalid(null, "let s : Set(UnlimitedNatural) = invalid in Bag{4}->intersection(s)");
		assertQueryInvalid(null, "let b : Bag(UnlimitedNatural) = invalid in Set{4}->intersection(b)");
		assertQueryInvalid(null, "let b : Bag(UnlimitedNatural) = invalid in Bag{4}->intersection(b)");
		// invalid collection element
		assertQueryInvalid(null, "Set{3, 4}->intersection(Set{invalid})");
		assertQueryInvalid(null, "Set{3, invalid}->intersection(Bag{4})");
		assertQueryInvalid(null, "Bag{3, invalid}->intersection(Set{4})");
		assertQueryInvalid(null, "Bag{3, 4}->intersection(Bag{invalid})");
		// null collection
		assertQueryInvalid(null, "let s : Set(Integer) = null in s->intersection(Set{4})");
		assertQueryInvalid(null, "let s : Set(Integer) = null in s->intersection(Bag{4})");
		assertQueryInvalid(null, "let b : Bag(Integer) = null in b->intersection(Set{4})");
		assertQueryInvalid(null, "let b : Bag(Integer) = null in b->intersection(Bag{4})");

		assertQueryInvalid(null, "let s : Set(UnlimitedNatural) = null in Set{4}->intersection(s)");
		assertQueryInvalid(null, "let s : Set(UnlimitedNatural) = null in Bag{4}->intersection(s)");
		assertQueryInvalid(null, "let b : Bag(UnlimitedNatural) = null in Set{4}->intersection(b)");
		assertQueryInvalid(null, "let b : Bag(UnlimitedNatural) = null in Bag{4}->intersection(b)");
		// null collection element
		assertQueryResults(null, "Set{2, null}", "Set{2, 3, null}->intersection(Set{2, 4, null})");
		assertQueryResults(null, "Set{2, null}", "Set{2, 3, null}->intersection(Bag{2, 4, null})");
		assertQueryResults(null, "Set{2, null}", "Bag{2, 3, null}->intersection(Set{2, 4, null})");
		assertQueryResults(null, "Bag{null, null}", "Bag{3, 4, null, null}->intersection(Bag{null, 2, null})");
	}

	public void testCollectionIsEmpty() {
		assertQueryTrue(null, "Sequence{}->isEmpty()");
		assertQueryTrue(null, "Bag{}->isEmpty()");
		assertQueryTrue(null, "Set{}->isEmpty()");
		assertQueryTrue(null, "OrderedSet{}->isEmpty()");

		assertQueryFalse(null, "Sequence{4, 4, 'test'}->isEmpty()");
		assertQueryFalse(null, "Bag{4, 4, 'test'}->isEmpty()");
		assertQueryFalse(null, "Set{4, 4, 'test'}->isEmpty()");
		assertQueryFalse(null, "OrderedSet{4, 4, 'test'}->isEmpty()");

		assertQueryResults(null, "Set{'test'}", "'test'.oclAsSet()");
		assertQueryFalse(null, "'test'.oclAsSet()->isEmpty()");
		assertQueryFalse(null, "'test'->isEmpty()");
		assertQueryFalse(null, "''->isEmpty()");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in s->isEmpty()");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in b->isEmpty()");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in s->isEmpty()");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = invalid in o->isEmpty()");
		// invalid collection element
		assertQueryInvalid(null, "invalid->isEmpty()");
		assertQueryInvalid(null, "Sequence{invalid}->isEmpty()");
		assertQueryInvalid(null, "Bag{invalid}->isEmpty()");
		assertQueryInvalid(null, "Set{invalid}->isEmpty()");
		assertQueryInvalid(null, "OrderedSet{invalid}->isEmpty()");
		// null collection
//		assertQueryInvalid(null, "null->isEmpty()");
		assertQueryTrue(null, "null->isEmpty()");
		assertQueryInvalid(null, "let s : Sequence(Integer) = null in s->isEmpty()");
		assertQueryInvalid(null, "let b : Bag(Integer) = null in b->isEmpty()");
		assertQueryInvalid(null, "let s : Set(Integer) = null in s->isEmpty()");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = null in o->isEmpty()");
		// null collection element
//		assertQueryInvalid(null, "let s : String = null in s->isEmpty()");
		assertQueryTrue(null, "let s : String = null in s->isEmpty()");
		assertQueryFalse(null, "Sequence{null}->isEmpty()");
		assertQueryFalse(null, "Bag{null}->isEmpty()");
		assertQueryFalse(null, "Set{null}->isEmpty()");
		assertQueryFalse(null, "OrderedSet{null}->isEmpty()");
	}

	public void testCollectionLast() {
		assertQueryEquals(null, "3", "Sequence{1, 2.0, '3'}->last()"); //$NON-NLS-2$
		assertQueryEquals(null, "3", "OrderedSet{1, 2.0, '3'}->last()"); //$NON-NLS-2$
		// empty
		assertQueryInvalid(null, "Sequence{}->last()");
		assertQueryInvalid(null, "OrderedSet{}->last()");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in s->last()");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = invalid in o->last()");
		// invalid collection element
		assertQueryInvalid(null, "Sequence{invalid, 1}->last()");
		assertQueryInvalid(null, "OrderedSet{invalid, 1}->last()");
		// null collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = null in s->last()");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = null in o->last()");
		// null collection element
		assertQueryNull(null, "Sequence{null}->last()");
		assertQueryNull(null, "OrderedSet{null}->last()");
	}

	public void testCollectionMax() {
		assertQueryEquals(null, 2, "Sequence{1, 2}->max()");
		assertQueryEquals(null, 5.0, "Set{5, 4.0, 3.0, 2, 1}->max()");
		assertQueryEquals(null, 1, "Bag{1}->max()");
		assertQueryEquals(null, 1, "Bag{1}->max()");
		assertQueryInvalid(null, "OrderedSet{'hi', 'lo'}->max()");
		assertQueryInvalid(null, "Set{}->max()");
		assertQueryInvalid(null, "OrderedSet{true, 1, 'bad'}->max()");
//        assertBadQuery(SemanticException.class, Diagnostic.ERROR,
//        	"OrderedSet{'hi', 'lo'}->max()",
//        	OCLMessages.MaxOperator_ERROR_);
//        assertBadQuery(SemanticException.class, Diagnostic.ERROR,
//        	"Set{}->max()",
//        	OCLMessages.MaxOperator_ERROR_);
//        assertBadQuery(SemanticException.class, Diagnostic.ERROR,
//        	"OrderedSet{true, 1, 'bad'}->max()",
//        	OCLMessages.MaxOperator_ERROR_);		
		// FIXME Bug 301351 Subtest-not-implemented user-defined max
	}

	public void testCollectionMin() {
		assertQueryEquals(null, 1, "Sequence{1, 2}->min()");
		assertQueryEquals(null, 1.0, "Set{5, 4.0, 3.0, 2, 1}->min()");
		assertQueryEquals(null, 1, "Bag{1}->min()");
		assertQueryInvalid(null, "OrderedSet{'hi', 'lo'}->min()");
		assertQueryInvalid(null, "Set{}->min()");
		assertQueryInvalid(null, "OrderedSet{true, 1, 'bad'}->min()");
//        assertBadQuery(SemanticException.class, Diagnostic.ERROR,
//        	"OrderedSet{'hi', 'lo'}->min()",
//        	OCLMessages.MinOperator_ERROR_);
//        assertBadQuery(SemanticException.class, Diagnostic.ERROR,
//        	"Set{}->min()",
//        	OCLMessages.MinOperator_ERROR_);
//        assertBadQuery(SemanticException.class, Diagnostic.ERROR,
//        	"OrderedSet{true, 1, 'bad'}->min()",
//        	OCLMessages.MinOperator_ERROR_);		
		// FIXME Bug 301351 Subtest-not-implemented user-defined min
	}

	public void testCollectionMinus() {
		assertQueryResults(null, "Set{'b'}", "Set{'a', 'b', 'c'} - Set{'c', 'a'}");
		/*
		 * FIXME OMG-issue generalise to UniqueCollection::-
		 * "OrderedSet::-(Set) : Set", we also need "Set::-(OrderedSet) : Set"
		 * and "OrderedSet::-(OrderedSet) : OrderedSet". That being said,
		 * "OrderedSet::-(Set) : Set" should be
		 * "OrderedSet::-(Set) : OrderedSet". revisit all "testCollectionMinus*"
		 * to add the new
		 */
		assertQueryResults(null, "OrderedSet{'b'}", "OrderedSet{'a', 'b', 'c'} - Set{'c', 'a'}");
		// invalid collection
		assertQueryInvalid(null, "let s : Set(String) = invalid in s - Set{'c'}");
		assertQueryInvalid(null, "let s : Set(String) = invalid in Set{'a'} - s");
		// invalid collection element
		assertQueryInvalid(null, "Set{'a', invalid} - Set{'c', invalid}");
		assertQueryInvalid(null, "Set{'a', invalid} - Set{'c', 'a'}");
		// null collection
		assertQueryInvalid(null, "let s : Set(String) = null in s - Set{'c', null}");
		assertQueryInvalid(null, "let s : Set(String) = null in Set{'a', null} - s");
		// null collection element
		assertQueryResults(null, "Set{'a'}", "Set{'a', null} - Set{'c', null}");
		assertQueryResults(null, "Set{null}", "Set{'a', null} - Set{'c', 'a'}");
	}

	public void testCollectionNotEmpty() {
		assertQueryFalse(null, "Sequence{}->notEmpty()");
		assertQueryFalse(null, "Bag{}->notEmpty()");
		assertQueryFalse(null, "Set{}->notEmpty()");
		assertQueryFalse(null, "OrderedSet{}->notEmpty()");

		assertQueryTrue(null, "Sequence{4, 4, 'test'}->notEmpty()");
		assertQueryTrue(null, "Bag{4, 4, 'test'}->notEmpty()");
		assertQueryTrue(null, "Set{4, 4, 'test'}->notEmpty()");
		assertQueryTrue(null, "OrderedSet{4, 4, 'test'}->notEmpty()");

		assertQueryTrue(null, "'test'->notEmpty()");
		assertQueryTrue(null, "''->notEmpty()");
		// invalid collection
		assertQueryInvalid(null, "invalid->notEmpty()");
		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in s->notEmpty()");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in b->notEmpty()");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in s->notEmpty()");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = invalid in o->notEmpty()");
		// invalid collection element
		assertQueryInvalid(null, "Sequence{invalid}->notEmpty()");
		assertQueryInvalid(null, "Bag{invalid}->notEmpty()");
		assertQueryInvalid(null, "Set{invalid}->notEmpty()");
		assertQueryInvalid(null, "OrderedSet{invalid}->notEmpty()");
		// null collection
//		assertQueryInvalid(null, "null->notEmpty()");
		assertQueryFalse(null, "null->notEmpty()");
		assertQueryInvalid(null, "let s : Sequence(Integer) = null in s->notEmpty()");
		assertQueryInvalid(null, "let b : Bag(Integer) = null in b->notEmpty()");
		assertQueryInvalid(null, "let s : Set(Integer) = null in s->notEmpty()");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = null in o->notEmpty()");
		// null collection element
		assertQueryTrue(null, "Sequence{null}->notEmpty()");
		assertQueryTrue(null, "Bag{null}->notEmpty()");
		assertQueryTrue(null, "Set{null}->notEmpty()");
		assertQueryTrue(null, "OrderedSet{null}->notEmpty()");
	}

	public void testCollectionNotEqualInvalid() {
		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in s <> Sequence{5}");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in Bag{5} <> b");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in s <> Set{5}");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = invalid in OrderedSet{5} <> o");

		assertQueryInvalid(null, "let s1 : Sequence(Integer) = invalid, s2 : Sequence(Integer) = invalid in s1 <> s2");
		assertQueryInvalid(null, "let b1 : Bag(Integer) = invalid, b2 : Bag(Integer) = invalid in b1 <> b2");
		assertQueryInvalid(null, "let s1 : Set(Integer) = invalid, s2 : Set(Integer) = invalid in s1 <> s2");
		assertQueryInvalid(null, "let o1 : OrderedSet(Integer) = invalid, o2 : OrderedSet(Integer) = invalid in o1 <> o2");
	}

	public void testCollectionNotEqualNull() {
		assertQueryTrue(null, "let s : Sequence(Integer) = null in s <> Sequence{5}");
		assertQueryTrue(null, "let b : Bag(Integer) = null in Bag{5} <> b");
		assertQueryTrue(null, "let s : Set(Integer) = null in s <> Set{5}");
		assertQueryTrue(null, "let o : OrderedSet(Integer) = null in OrderedSet{5} <> o");

		assertQueryFalse(null, "let s1 : Sequence(Integer) = null, s2 : Sequence(Integer) = null in s1 <> s2");
		assertQueryFalse(null, "let b1 : Bag(Integer) = null, b2 : Bag(Integer) = null in b1 <> b2");
		assertQueryFalse(null, "let s1 : Set(Integer) = null, s2 : Set(Integer) = null in s1 <> s2");
		assertQueryFalse(null, "let o1 : OrderedSet(Integer) = null, o2 : OrderedSet(Integer) = null in o1 <> o2");
	}

	public void testCollectionNotEqualOrderedXOrdered() {
		// same order, same quantities
/*		assertQueryFalse(null, "Sequence{4, 5, 'test'} <> Sequence{4, 5, 'test'}");
		assertQueryFalse(null, "Sequence{4, 5, 'test', 5} <> Sequence{4, 5, 'test', 5}");
		assertQueryFalse(null, "OrderedSet{4, 5, 'test', 5} <> OrderedSet{4, 5, 'test'}");
		assertQueryTrue(null, "Sequence{4, 5, 'test'} <> OrderedSet{4, 5, 'test', 5}");
		assertQueryTrue(null, "OrderedSet{4, 5, 'test', 5} <> Sequence{4, 5, 'test'}");

		// distinct order, same quantities
		assertQueryTrue(null, "Sequence{4, 5, 'test'} <> Sequence{4, 'test', 5}");
		assertQueryTrue(null, "Sequence{4, 5, 'test', 5} <> Sequence{5, 4, 'test', 5}");
*/		assertQueryTrue(null, "OrderedSet{4, 5, 'test', 5} <> OrderedSet{4, 'test', 5}");
		assertQueryTrue(null, "Sequence{4, 5, 'test'} <> OrderedSet{5, 4, 'test', 5}");
		assertQueryTrue(null, "OrderedSet{4, 5, 'test', 5} <> Sequence{5, 4, 'test'}");

		// distinct quantities
		assertQueryTrue(null, "Sequence{4, 5, 'test', 5} <> Sequence{4, 5, 'test'}");
		assertQueryTrue(null, "Sequence{4, 5, 'test', 5} <> OrderedSet{4, 5, 'test', 5}");
		assertQueryTrue(null, "OrderedSet{4, 5, 'test', 5} <> Sequence{4, 5, 'test', 5}");
	}

public void testCollectionNotEqualOrderedXUnordered() {
		// same quantities
		assertQueryTrue(null, "Sequence{4, 5, 'test'} <> Set{4, 'test', 5, 4}");
		assertQueryTrue(null, "Sequence{4, 5, 'test', 4} <> Bag{4, 'test', 5, 4}");
		assertQueryTrue(null, "OrderedSet{4, 5, 'test', 4} <> Set{4, 'test', 5, 4}");
		assertQueryTrue(null, "OrderedSet{4, 5, 'test', 4} <> Bag{4, 'test', 5}");

		// distinct quantities
		assertQueryTrue(null, "Sequence{4, 5, 'test', 4} <> Set{4, 'test', 5, 4}");
		assertQueryTrue(null, "Sequence{4, 5, 'test'} <> Bag{4, 'test', 5, 4}");
		assertQueryTrue(null, "OrderedSet{4, 5, 'test', 4} <> Bag{4, 'test', 5, 4}");
	}

	public void testCollectionNotEqualUnorderedXUnordered() {
		// same quantities
		assertQueryTrue(null, "Bag{4, 5, 'test'} <> Set{4, 'test', 5, 4}");
		assertQueryFalse(null, "Bag{4, 5, 'test', 4} <> Bag{4, 'test', 5, 4}");
		assertQueryFalse(null, "Set{4, 5, 'test', 4} <> Set{4, 'test', 5, 4}");
		assertQueryTrue(null, "Set{4, 5, 'test', 4} <> Bag{4, 'test', 5}");

		// distinct quantities
		assertQueryTrue(null, "Bag{4, 5, 'test', 4} <> Set{4, 'test', 5, 4}");
		assertQueryTrue(null, "Bag{4, 5, 'test'} <> Bag{4, 'test', 5, 4}");
		assertQueryTrue(null, "Set{4, 5, 'test', 4} <> Bag{4, 'test', 5, 4}");
	}

	public void testCollectionPrepend() {
		assertQueryResults(null, "Sequence{'c', 'a', 'b'}", "Sequence{'a', 'b'}->prepend('c')");
		assertQueryResults(null, "OrderedSet{'c', 'a', 'b'}", "OrderedSet{'a', 'b'}->prepend('c')");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(String) = invalid in s->prepend('a')");
		assertQueryInvalid(null, "let o : OrderedSet(String) = invalid in o->prepend('a')");
		// invalid collection element
		assertQueryInvalid(null, "Sequence{'a', 'b'}->prepend(invalid)");
		assertQueryInvalid(null, "OrderedSet{'a', 'b'}->prepend(invalid)");
		// null collection
		assertQueryInvalid(null, "let s : Sequence(String) = null in s->prepend('a')");
		assertQueryInvalid(null, "let o : OrderedSet(String) = null in o->prepend('a')");
		// null collection element
		assertQueryResults(null, "Sequence{null, 'a', 'b'}", "Sequence{'a', 'b'}->prepend(null)");
		assertQueryResults(null, "OrderedSet{null, 'a', 'b'}", "OrderedSet{'a', 'b'}->prepend(null)");
	}

	public void testCollectionProduct() {
//		Abstract2Moniker.TRACE_MONIKERS.setState(true);
		String expectedResultExpression = "Set{Tuple{first = 3, second = 3.0}, Tuple{first = 3, second = 4.0}, Tuple{first = 4, second = 3.0}, Tuple{first = 4, second = 4.0}}";

		// Sequence::product(Collection)
		assertQueryResults(null, expectedResultExpression, "Sequence{3, 4}->product(Sequence{3.0, 4.0})");
		assertQueryResults(null, expectedResultExpression, "Sequence{3, 4}->product(Bag{3.0, 4.0})");
		assertQueryResults(null, expectedResultExpression, "Sequence{3, 4}->product(Set{3.0, 4.0})");
		assertQueryResults(null, expectedResultExpression, "Sequence{3, 4}->product(OrderedSet{3.0, 4.0})");

		// Bag::product(Collection)
		assertQueryResults(null, expectedResultExpression, "Bag{3, 4}->product(Sequence{3.0, 4.0})");
		assertQueryResults(null, expectedResultExpression, "Bag{3, 4}->product(Bag{3.0, 4.0})");
		assertQueryResults(null, expectedResultExpression, "Bag{3, 4}->product(Set{3.0, 4.0})");
		assertQueryResults(null, expectedResultExpression, "Bag{3, 4}->product(OrderedSet{3.0, 4.0})");

		// Set::product(Collection)
		assertQueryResults(null, expectedResultExpression, "Set{3, 4}->product(Sequence{3.0, 4.0})");
		assertQueryResults(null, expectedResultExpression, "Set{3, 4}->product(Bag{3.0, 4.0})");
		assertQueryResults(null, expectedResultExpression, "Set{3, 4}->product(Set{3.0, 4.0})");
		assertQueryResults(null, expectedResultExpression, "Set{3, 4}->product(OrderedSet{3.0, 4.0})");

		// OrderedSet::product(Collection)
		assertQueryResults(null, expectedResultExpression, "OrderedSet{3, 4}->product(Sequence{3.0, 4.0})");
		assertQueryResults(null, expectedResultExpression, "OrderedSet{3, 4}->product(Bag{3.0, 4.0})");
		assertQueryResults(null, expectedResultExpression, "OrderedSet{3, 4}->product(Set{3.0, 4.0})");
		assertQueryResults(null, expectedResultExpression, "OrderedSet{3, 4}->product(OrderedSet{3.0, 4.0})");
		// bug284129
//		assertQueryResults(null, "Set{Tuple{first = 3, second = 3.0}, Tuple{first = 3, second = 4}, Tuple{first = 4.0, second = 3.0}, Tuple{first = 4.0, second = 4}}", "Sequence{3, 4.0}->product(Sequence{3.0, 4})");
		assertQueryResults(null, "Set{Tuple{first = 3.0, second = 3.0}, Tuple{first = 3.0, second = 4.0}, Tuple{first = 4.0, second = 3.0}, Tuple{first = 4.0, second = 4.0}}", "Sequence{3, 4.0}->product(Sequence{3.0, 4})");
		// empty
		assertQueryEquals(null, valueFactory.getEmptySetValue(), "Sequence{3, 4}->product(OrderedSet{})");
		assertQueryEquals(null, valueFactory.getEmptySetValue(), "Bag{3, 4}->product(Set{})");
		assertQueryEquals(null, valueFactory.getEmptySetValue(), "Set{3, 4}->product(Bag{})");
		assertQueryEquals(null, valueFactory.getEmptySetValue(), "OrderedSet{3, 4}->product(Sequence{})");

		assertQueryEquals(null, valueFactory.getEmptySetValue(), "Sequence{}->product(OrderedSet{3, 4})");
		assertQueryEquals(null, valueFactory.getEmptySetValue(), "Bag{}->product(Set{3, 4})");
		assertQueryEquals(null, valueFactory.getEmptySetValue(), "Set{}->product(Bag{3, 4})");
		assertQueryEquals(null, valueFactory.getEmptySetValue(), "OrderedSet{}->product(Sequence{3, 4})");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in OrderedSet{3, 4}->product(s)");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in Set{3, 4}->product(b)");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in Bag{3, 4}->product(s)");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = invalid in Sequence{3, 4}->product(o)");

		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in s->product(OrderedSet{3, 4})");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in b->product(Set{3, 4})");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in s->product(Bag{3, 4})");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = invalid in o->product(Sequence{3, 4})");
		// invalid collection element
		assertQueryInvalid(null, "Sequence{3, 4}->product(OrderedSet{invalid})");
		assertQueryInvalid(null, "Bag{3, 4}->product(Set{invalid})");
		assertQueryInvalid(null, "Set{3, 4}->product(Bag{invalid})");
		assertQueryInvalid(null, "OrderedSet{3, 4}->product(Sequence{invalid})");

		assertQueryInvalid(null, "Sequence{invalid, 4}->product(Sequence{3})");
		assertQueryInvalid(null, "Bag{invalid, 4}->product(Set{3})");
		assertQueryInvalid(null, "Set{invalid, 4}->product(Bag{3})");
		assertQueryInvalid(null, "OrderedSet{invalid, 4}->product(Sequence{3})");
	}

	public void testCollectionProductNull() {
		assertQueryInvalid(null, "let s : Sequence(Integer) = null in OrderedSet{3, 4}->product(s)");
		assertQueryInvalid(null, "let b : Bag(Integer) = null in Set{3, 4}->product(b)");
		assertQueryInvalid(null, "let s : Set(Integer) = null in Bag{3, 4}->product(s)");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = null in Sequence{3, 4}->product(o)");

		assertQueryInvalid(null, "let s : Sequence(Integer) = null in s->product(OrderedSet{3, 4})");
		assertQueryInvalid(null, "let b : Bag(Integer) = null in b->product(Set{3, 4})");
		assertQueryInvalid(null, "let s : Set(Integer) = null in s->product(Bag{3, 4})");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = null in o->product(Sequence{3, 4})");
	}

	public void testCollectionProductNullValue() {
		assertQueryResults(null, "Set{Tuple{first = 3, second = null}, Tuple{first = 4, second = null}}", "Sequence{3, 4}->product(OrderedSet{null})");
		assertQueryResults(null, "Set{Tuple{first = 3, second = null}, Tuple{first = 4, second = null}}", "Bag{3, 4}->product(Set{null})");
		assertQueryResults(null, "Set{Tuple{first = 3, second = null}, Tuple{first = 4, second = null}}", "Set{3, 4}->product(Bag{null})");
		assertQueryResults(null, "Set{Tuple{first = 3, second = null}, Tuple{first = 4, second = null}}", "OrderedSet{3, 4}->product(Sequence{null})");

		assertQueryResults(null, "Set{Tuple{first = null, second = 3}, Tuple{first = null, second = 4}}", "Sequence{null}->product(OrderedSet{3, 4})");
		assertQueryResults(null, "Set{Tuple{first = null, second = 3}, Tuple{first = null, second = 4}}", "Bag{null}->product(Set{3, 4})");
		assertQueryResults(null, "Set{Tuple{first = null, second = 3}, Tuple{first = null, second = 4}}", "Set{null}->product(Bag{3, 4})");
		assertQueryResults(null, "Set{Tuple{first = null, second = 3}, Tuple{first = null, second = 4}}", "OrderedSet{null}->product(Sequence{3, 4})");

		assertQueryResults(null, "let nu : UnlimitedNatural = null in Set{Tuple{first = nu, second = 3}, Tuple{first = 4, second = 3}}", "Sequence{null, 4}->product(Sequence{3})");
		assertQueryResults(null, "let nu : UnlimitedNatural = null in Set{Tuple{first = nu, second = 3}, Tuple{first = 4, second = 3}}", "Bag{null, 4}->product(Set{3})");
		assertQueryResults(null, "let nu : UnlimitedNatural = null in Set{Tuple{first = nu, second = 3}, Tuple{first = 4, second = 3}}", "Set{null, 4}->product(Bag{3})");
		assertQueryResults(null, "let nu : UnlimitedNatural = null in Set{Tuple{first = nu, second = 3}, Tuple{first = 4, second = 3}}", "OrderedSet{null, 4}->product(Sequence{3})");
	}

	public void testCollectionReverse() {
		// FIXME Test-not-implemented
	}

	public void testCollectionSize() {
		assertQueryEquals(null, 4, "Sequence{4, 4, 5, 'test'}->size()");
		assertQueryEquals(null, 4, "Bag{4, 4, 5, 'test'}->size()");
		assertQueryEquals(null, 3, "Set{4, 4, 5, 'test'}->size()");
		assertQueryEquals(null, 3, "OrderedSet{4, 4, 5, 'test'}->size()");

		assertQueryEquals(null, 0, "Sequence{}->size()");
		assertQueryEquals(null, 0, "Bag{}->size()");
		assertQueryEquals(null, 0, "Set{}->size()");
		assertQueryEquals(null, 0, "OrderedSet{}->size()");
		// invalid collection
		assertQueryInvalid(null, "let s : String = invalid in s->size()");
		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in s->size()");
		// invalid collection element
		assertQueryInvalid(null, "OrderedSet{'a', 'b', invalid}->size()");
		assertQueryInvalid(null, "Set{'a', 'b', invalid}->size()");
		assertQueryInvalid(null, "Bag{'a', 'b', invalid}->size()");
		assertQueryInvalid(null, "Sequence{'a', 'b', invalid}->size()");
		// null collection
//		assertQueryInvalid(null, "let s : String = null in s->size()");
		assertQueryEquals(null, 0, "let s : String = null in s->size()");
		assertQueryInvalid(null, "let s : Sequence(Integer) = null in s->size()");
		// null collection element
		assertQueryEquals(null, 4, "Sequence{'a', 'b', null, null}->size()");
		assertQueryEquals(null, 4, "Bag{'a', 'b', null, null}->size()");
		assertQueryEquals(null, 3, "Set{'a', 'b', null, null}->size()");
		assertQueryEquals(null, 3, "OrderedSet{'a', 'b', null, null}->size()");
	}

	public void testCollectionSubOrderedSet() {
		assertQueryResults(null, "OrderedSet{'a'}", "OrderedSet{'a', 'b', 'c', 'd'}->subOrderedSet(1, 1)");
		assertQueryResults(null, "OrderedSet{'b', 'c'}", "OrderedSet{'a', 'b', 'c', 'd'}->subOrderedSet(2, 3)");
		assertQueryResults(null, "OrderedSet{'d'}", "OrderedSet{'a', 'b', 'c', 'd'}->subOrderedSet(4, 4)");
		// invalid collection
		assertQueryInvalid(null, "let o : OrderedSet(String) = invalid in o->subOrderedSet(1, 1)");
		// null collection
		assertQueryInvalid(null, "let o : OrderedSet(String) = null in o->subOrderedSet(1, 1)");
		// out of bounds
		assertQueryInvalid(null, "OrderedSet{'a', 'b', 'c', 'd'}->subOrderedSet(0, 1)");
		assertQueryInvalid(null, "OrderedSet{'a', 'b', 'c', 'd'}->subOrderedSet(4, 5)");
		// illegal arguments
		assertQueryInvalid(null, "OrderedSet{'a', 'b', 'c', 'd'}->subOrderedSet(2, 1)");
	}

	public void testCollectionSubSequence() {
		assertQueryResults(null, "Sequence{'a'}", "Sequence{'a', 'b', 'c', 'd'}->subSequence(1, 1)");
		assertQueryResults(null, "Sequence{'b', 'c'}", "Sequence{'a', 'b', 'c', 'd'}->subSequence(2, 3)");
		assertQueryResults(null, "Sequence{'d'}", "Sequence{'a', 'b', 'c', 'd'}->subSequence(4, 4)");
		// invalid collection
		assertQueryInvalid(null, "let o : Sequence(String) = invalid in o->subSequence(1, 1)");
		// null collection
		assertQueryInvalid(null, "let o : Sequence(String) = null in o->subSequence(1, 1)");
		// out of bounds
		assertQueryInvalid(null, "Sequence{'a', 'b', 'c', 'd'}->subSequence(0, 1)");
		assertQueryInvalid(null, "Sequence{'a', 'b', 'c', 'd'}->subSequence(4, 5)");
		// illegal arguments
		assertQueryInvalid(null, "Sequence{'a', 'b', 'c', 'd'}->subSequence(2, 1)");
	}

	public void testCollectionSum() {
		assertQueryEquals(null, 0, "let s : Sequence(Integer) = Sequence{} in s->sum()");
		assertQueryEquals(null, 0.0, "let b : Bag(Real) = Bag{} in b->sum()");
		assertQueryEquals(null, 0.0, "let s : Set(Real) = Set{} in s->sum()");
		assertQueryEquals(null, 0, "let o : OrderedSet(Integer) = OrderedSet{} in o->sum()");

		assertQueryEquals(null, 13.0, "Sequence{4.0, 4.0, 5.0}->sum()");
		assertQueryEquals(null, 13, "Bag{4, 4, 5}->sum()");
		assertQueryEquals(null, 9.0, "Set{4, 4.0, 5.0}->sum()");
		assertQueryEquals(null, 9.0, "OrderedSet{4.0, 4.0, 5.0}->sum()");

		assertQueryEquals(null, 4, "4->sum()");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in s->sum()");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in b->sum()");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in s->sum()");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = invalid in o->sum()");
		// invalid collection element
		assertQueryInvalid(null, "Sequence{4.0, invalid, 5.0}->sum()");
		assertQueryInvalid(null, "Bag{4, invalid, 5}->sum()");
		assertQueryInvalid(null, "Set{4, invalid, 5}->sum()");
		assertQueryInvalid(null, "OrderedSet{4.0, invalid, 5.0}->sum()");
		// null collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = null in s->sum()");
		assertQueryInvalid(null, "let b : Bag(Integer) = null in b->sum()");
		assertQueryInvalid(null, "let s : Set(Integer) = null in s->sum()");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = null in o->sum()");
		// null collection element
		assertQueryInvalid(null, "Sequence{4.0, null, 5.0}->sum()");
		assertQueryInvalid(null, "Bag{4, null, 5}->sum()");
		assertQueryInvalid(null, "Set{4, null, 5}->sum()");
		assertQueryInvalid(null, "OrderedSet{4.0, null, 5.0}->sum()");

		// FIXME Bug 301351 Subtest-not-implemented user-defined +
	}

	public void testCollectionSymmetricDifference() {
		assertQueryResults(null, "Set{'a', 'c'}", "Set{'a', 'b'}->symmetricDifference(Set{'b', 'c'})");
		// invalid collection
		assertQueryInvalid(null, "let s : Set(String) = invalid in s->symmetricDifference(Set{'a'})");
		// invalid collection element
		assertQueryInvalid(null, "Set{'a', invalid, 'b'}->symmetricDifference(Set{'b', 'c'})");
		// null collection
		assertQueryInvalid(null, "let s : Set(String) = null in s->symmetricDifference(Set{'a'})");
		// null collection element
		assertQueryResults(null, "Set{'a', null, 'c'}", "Set{'a', null, 'b'}->symmetricDifference(Set{'b', 'c'})");
	}

	public void testCollectionUnionDuplicates() {
		assertQueryResults(null, "Set{'a', 'b', 'c'}", "Set{'a', 'b', 'a'}->union(Set{'b', 'c'})");
		assertQueryResults(null, "Bag{'a', 'b', 'b', 'c'}", "Set{'a', 'b', 'a'}->union(Bag{'b', 'c'})");
		assertQueryResults(null, "Bag{'a', 'b', 'a', 'b', 'c'}", "Bag{'a', 'b', 'a'}->union(Bag{'b', 'c'})");
		assertQueryResults(null, "Bag{'a', 'b', 'a', 'b', 'c'}", "Bag{'a', 'b', 'a'}->union(Set{'b', 'c'})");

		assertQueryResults(null, "Sequence{'a', 'b', 'a', 'b', 'c'}", "Sequence{'a', 'b', 'a'}->union(Sequence{'b', 'c'})");
	}

	public void testCollectionUnionEmptyCollection() {
		assertQueryResults(null, "Set{3, 4}", "Set{3, 4}->union(Set{})");
		assertQueryResults(null, "Bag{3, 4}", "Set{3, 4}->union(Bag{})");
		assertQueryResults(null, "Bag{3, 4}", "Bag{3, 4}->union(Bag{})");
		assertQueryResults(null, "Bag{3, 4}", "Bag{3, 4}->union(Set{})");
		assertQueryResults(null, "Sequence{3, 4}", "Sequence{3, 4}->union(Sequence{})");

		assertQueryResults(null, "Set{3, 4}", "Set{}->union(Set{3, 4})");
		assertQueryResults(null, "Bag{3, 4}", "Set{}->union(Bag{3, 4})");
		assertQueryResults(null, "Bag{3, 4}", "Bag{}->union(Bag{3, 4})");
		assertQueryResults(null, "Bag{3, 4}", "Bag{}->union(Set{3, 4})");
		assertQueryResults(null, "Sequence{3, 4}", "Sequence{}->union(Sequence{3, 4})");
	}

	public void testCollectionUnionInvalid() {
		assertQueryInvalid(null, "let s : Set(String) = invalid in s->union(Set{'a'})");
		assertQueryInvalid(null, "let s : Set(String) = invalid in s->union(Bag{'a'})");
		assertQueryInvalid(null, "let b : Bag(String) = invalid in b->union(Bag{'a'})");
		assertQueryInvalid(null, "let b : Bag(String) = invalid in b->union(Set{'a'})");
		assertQueryInvalid(null, "let s : Sequence(String) = invalid in s->union(Sequence{'a'})");

		assertQueryInvalid(null, "let s : Set(String) = invalid in Set{'a'}->union(s)");
		assertQueryInvalid(null, "let s : Set(String) = invalid in Bag{'a'}->union(s)");
		assertQueryInvalid(null, "let b : Bag(String) = invalid in Bag{'a'}->union(b)");
		assertQueryInvalid(null, "let b : Bag(String) = invalid in Set{'a'}->union(b)");
		assertQueryInvalid(null, "let s : Sequence(String) = invalid in Sequence{'a'}->union(s)");
	}

	public void testCollectionUnionInvalidValue() {
		assertQueryInvalid(null, "Set{'a', invalid}->union(Set{'b', invalid})");
		assertQueryInvalid(null, "Set{'a', invalid}->union(Bag{'b', invalid})");
		assertQueryInvalid(null, "Bag{'a', invalid}->union(Bag{'b', invalid})");
		assertQueryInvalid(null, "Bag{'a', invalid}->union(Set{'b', invalid})");
		assertQueryInvalid(null, "Sequence{'a', invalid}->union(Sequence{'b', invalid})");
	}

	public void testCollectionUnionNoDuplicates() {
		/*
		 * FIXME OMG-issue generalise to Collection::union
		 * the specification defines operations Set::union(Set),
		 * Set::union(Bag), Bag::union(Set) and Bag::union(Bag) with the same
		 * semantics "the union of self and bag" and operation
		 * Sequence::union(Sequence) with the description
		 * "The sequence consisting of all elements in self, followed by all elements in s"
		 * . Why aren't there Sequence::union(OrderedSet),
		 * OrderedSet::union(Sequence) and OrderedSet::union(OrderedSet) with
		 * the same semantics as Sequence::union(Sequence) ? That is most likely
		 * an overlook.
		 */
		assertQueryResults(null, "Set{'a', 'b', 'c', 'd'}", "Set{'a', 'b'}->union(Set{'c', 'd'})");
		assertQueryResults(null, "Bag{'a', 'b', 'c', 'd'}", "Set{'a', 'b'}->union(Bag{'c', 'd'})");
		assertQueryResults(null, "Bag{'a', 'b', 'c', 'd'}", "Bag{'a', 'b'}->union(Bag{'c', 'd'})");
		assertQueryResults(null, "Bag{'a', 'b', 'c', 'd'}", "Bag{'a', 'b'}->union(Set{'c', 'd'})");

		assertQueryResults(null, "Sequence{'a', 'b', 'c', 'd'}", "Sequence{'a', 'b'}->union(Sequence{'c', 'd'})");
	}

	public void testCollectionUnionNull() {
		assertQueryInvalid(null, "let s : Set(String) = null in s->union(Set{'a'})");
		assertQueryInvalid(null, "let s : Set(String) = null in s->union(Bag{'a'})");
		assertQueryInvalid(null, "let b : Bag(String) = null in b->union(Bag{'a'})");
		assertQueryInvalid(null, "let b : Bag(String) = null in b->union(Set{'a'})");
		assertQueryInvalid(null, "let s : Sequence(String) = null in s->union(Sequence{'a'})");

		assertQueryInvalid(null, "let s : Set(String) = null in Set{'a'}->union(s)");
		assertQueryInvalid(null, "let s : Set(String) = null in Bag{'a'}->union(s)");
		assertQueryInvalid(null, "let b : Bag(String) = null in Bag{'a'}->union(b)");
		assertQueryInvalid(null, "let b : Bag(String) = null in Set{'a'}->union(b)");
		assertQueryInvalid(null, "let s : Sequence(String) = null in Sequence{'a'}->union(s)");
	}

	public void testCollectionUnionNullValue() {
		assertQueryResults(null, "Set{'a', null, 'b'}", "Set{'a', null}->union(Set{'b', null})");
		assertQueryResults(null, "Bag{'a', null, 'b', null}", "Set{'a', null}->union(Bag{'b', null})");
		assertQueryResults(null, "Bag{'a', null, 'b', null}", "Bag{'a', null}->union(Bag{'b', null})");
		assertQueryResults(null, "Bag{'a', null, 'b', null}", "Bag{'a', null}->union(Set{'b', null})");
		assertQueryResults(null, "Sequence{'a', null, 'b', null}", "Sequence{'a', null}->union(Sequence{'b', null})");
	}
}
