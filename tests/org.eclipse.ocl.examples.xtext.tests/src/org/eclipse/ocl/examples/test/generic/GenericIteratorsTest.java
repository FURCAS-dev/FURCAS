/**
 * <copyright>
 * 
 * Copyright (c) 2006,2011 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Bug 296409, 297541
 *
 * </copyright>
 *
 * $Id: GenericIteratorsTest.java,v 1.3 2011/02/11 20:10:13 ewillink Exp $
 */

package org.eclipse.ocl.examples.test.generic;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.SemanticException;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.utilities.PivotConstants;
import org.eclipse.ocl.examples.pivot.values.BagValue;
import org.eclipse.ocl.examples.pivot.values.CollectionValue;
import org.eclipse.ocl.examples.pivot.values.OrderedSetValue;
import org.eclipse.ocl.examples.pivot.values.SequenceValue;
import org.eclipse.ocl.examples.pivot.values.SetValue;
import org.eclipse.ocl.examples.pivot.values.Value;

/**
 * Tests for iterator expressions.
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public abstract class GenericIteratorsTest
	extends GenericTestSuite {

	org.eclipse.ocl.examples.pivot.Package pkg1;
	org.eclipse.ocl.examples.pivot.Package pkg2;
	org.eclipse.ocl.examples.pivot.Package pkg3;
	org.eclipse.ocl.examples.pivot.Package pkg4;
	org.eclipse.ocl.examples.pivot.Package pkg5;
	org.eclipse.ocl.examples.pivot.Package jim;
	org.eclipse.ocl.examples.pivot.Package bob;
	org.eclipse.ocl.examples.pivot.Package george;

    @Override
    protected void setUp() {
        super.setUp();
		typeManager.addGlobalNamespace("pivot", typeManager.getPivotPackage());

        // need a metamodel that has a reflexive EReference.
        // Ecore will do nicely. Create the following structure:
        // pkg1
        // pkg1::pkg2
        // pkg1::pkg2::jim
        // pkg1::bob
        // pkg1::pkg3
        // pkg1::pkg3::pkg4
        // pkg1::pkg3::pkg5
        // pkg1::pkg3::pkg5::george

        pkg1 = reflection.createPackage("pkg1");
        pkg2 = reflection.createNestedPackage(pkg1, "pkg2");
        jim = reflection.createNestedPackage(pkg2, "jim");
        bob = reflection.createNestedPackage(pkg1, "bob");
        pkg3 = reflection.createNestedPackage(pkg1, "pkg3");
        pkg4 = reflection.createNestedPackage(pkg3, "pkg4");
        pkg5 = reflection.createNestedPackage(pkg3, "pkg5");
        george = reflection.createNestedPackage(pkg5, "george");
        helper.setContext(typeManager.getPivotType("Package"));
    }

    /**
     * Tests the generic iterate() iterator.
     */
    public void test_iterate_143996() {
    	SetValue expected = valueFactory.createSetOf("pkg2", "bob", "pkg3");

        // complete form
        assertQueryEquals(pkg1, expected, "nestedPackage->iterate(p; s : Set(String) = Set{} | s->including(p.name))");

        // shorter form
        assertQueryEquals(pkg1, expected, "nestedPackage->iterate(p; s : Set(String) = Set{} | s->including(p.name))");

        // shortest form
        assertQueryEquals(pkg1, expected, "nestedPackage->iterate(s : Set(String) = Set{} | s->including(name))");
    }
    
    /**
     * Tests the select() iterator.
     */
	public void test_select() {
		CollectionValue expected = valueFactory.createSetOf(pkg2, pkg3);

        // complete form
        assertQueryEquals(pkg1, expected, "nestedPackage->select(p : pivot::Package | p.name <> 'bob')");

        // shorter form
        assertQueryEquals(pkg1, expected, "nestedPackage->select(p | p.name <> 'bob')");

        // shortest form
        assertQueryEquals(pkg1, expected, "nestedPackage->select(name <> 'bob')");

        Value expected2 = valueFactory.createSetOf(bob, pkg2, pkg3);
        assertQueryEquals(pkg1, expected2, "nestedPackage->select(true)");
    }

    /**
     * Tests the reject() iterator.
     */
    public void test_reject() {
		CollectionValue expected = valueFactory.createSetOf(pkg2, pkg3);

        // complete form
        assertQueryEquals(pkg1, expected, "nestedPackage->reject(p : pivot::Package | p.name = 'bob')");

        // shorter form
        assertQueryEquals(pkg1, expected, "nestedPackage->reject(p | p.name = 'bob')");

        // shortest form
        assertQueryEquals(pkg1, expected, "nestedPackage->reject(name = 'bob')");

        expected = valueFactory.getEmptySetValue();
        assertQueryEquals(pkg1, expected, "nestedPackage->reject(true)");
    }

    /**
     * Tests the any() iterator.
     */
    public void test_any() {
        // complete form
    	assertQueryEquals(pkg1, bob, "nestedPackage->any(p : pivot::Package | p.name = 'bob')");

        // shorter form
    	assertQueryEquals(pkg1, bob, "nestedPackage->any(p | p.name = 'bob')");

        // shortest form
    	assertQueryEquals(pkg1, bob, "nestedPackage->any(name = 'bob')");

        // negative
        assertQueryNotSame(pkg1, bob, "nestedPackage->any(name = 'pkg2')");

        assertQueryDefined(pkg1, "nestedPackage->any(true)");
        assertQueryNull(pkg1, "nestedPackage->any(false)");
    }

    /**
     * Tests the isUnique() iterator.
     */
    public void test_isUnique_126861() {
//    	Abstract2Moniker.TRACE_MONIKERS.setState(true);
        assertQueryTrue(pkg1, "Sequence{'a', 'b', 'c', 'd', 'e'}->isUnique(e | e)");

        assertQueryFalse(pkg1, "Sequence{'a', 'b', 'c', 'c', 'e'}->isUnique(e | e)");

        // when there are no values, they implicitly all evaluate to a
        // different result
        assertQueryTrue(pkg1, "Sequence{}->isUnique(e | e)");

        assertQueryTrue(pkg1, "%nestedPackage->isUnique(name)");
    }

    /**
     * Tests the exists() iterator.
     */
    public void test_exists() {
        assertQueryTrue(pkg1, "Sequence{'a', 'b', 'c', 'd', 'e'}->exists(e | e = 'c')");

        assertQueryTrue(pkg1, "Sequence{'a', 'b', 'c', 'c', 'e'}->exists(e | e = 'c')");

        assertQueryFalse(pkg1, "Sequence{'a', 'b', 'd', 'e'}->exists(e | e = 'c')");

        // when there are no values, they the desired result implictly
        // does not occur
        assertQueryFalse(pkg1, "Sequence{}->exists(e | e = 'c')");

        assertQueryTrue(pkg1, "%nestedPackage->exists(true)");
    }

    /**
     * Tests the forAll() iterator.
     */
    public void test_forAll() {
        assertQueryFalse(pkg1, "Sequence{'a', 'b', 'c', 'd', 'e'}->forAll(e | e = 'c')");

        assertQueryFalse(pkg1, "Sequence{'a', 'b', 'd', 'e'}->forAll(e | e = 'c')");

        assertQueryTrue(pkg1, "Sequence{'c', 'c', 'c', 'c'}->forAll(e | e = 'c')");

        assertQueryTrue(pkg1, "Sequence{'c'}->forAll(e | e = 'c')");

        // when there are no values, they implicitly all evaluate to the
        // desired result
        assertQueryTrue(pkg1, "Sequence{}->forAll(e | e = 'c')");

        assertQueryTrue(pkg1, "%nestedPackage->forAll(true)");
    }

    /**
     * Tests the one() iterator.
     */
    public void test_one() {
        assertQueryTrue(pkg1, "Sequence{'a', 'b', 'c', 'd', 'e'}->one(e | e = 'c')");

        assertQueryFalse(pkg1, "Sequence{'a', 'b', 'c', 'c', 'e'}->one(e | e = 'c')");

        assertQueryFalse(pkg1, "Sequence{'a', 'b', 'd', 'e'}->one(e | e = 'c')");

        assertQueryTrue(pkg1, "Sequence{'a'}->one(true)");
    }
    
    /**
     * Tests the collect() iterator.
     */
    public void test_collect() {
//    	Abstract2Moniker.TRACE_MONIKERS.setState(true);
        CollectionValue expected1 = valueFactory.createBagOf("pkg2", "bob", "pkg3");

        // complete form
        assertQueryEquals(pkg1, expected1, "nestedPackage->collect(p : pivot::Package | p.name)");

        // shorter form
        assertQueryEquals(pkg1, expected1, "nestedPackage->collect(p | p.name)");

        // yet shorter form
        assertQueryEquals(pkg1, expected1, "nestedPackage->collect(name)");

        // shortest form
        assertQueryEquals(pkg1, expected1, "nestedPackage.name");

        // flattening of nested collections
        CollectionValue expected2 = valueFactory.createBagOf(jim, pkg4, pkg5);

        assertQueryEquals(pkg1, expected2, "nestedPackage.nestedPackage");
    }

	/**
     * Tests that parsing fails, in the case of an unknown property in a
     * collection navigation, with an appropriate parse failure, not a
     * <code>ClassCastException</code>.
     */
    public void test_implicitCollect_unknownAttribute_232669() {
        assertBadInvariant(SemanticException.class, Diagnostic.ERROR,
    		"nestedPackage.unknownAttribute",
        	OCLMessages.ErrorUnresolvedPropertyName, "unknownAttribute");
   }

    /**
     * Tests that parsing fails, in the case of an unknown operation in a
     * collection navigation, with an appropriate parse failure, not a
     * <code>ClassCastException</code>.
     */
    public void test_implicitCollect_unknownOperation_232669() {
    	assertBadInvariant(SemanticException.class, Diagnostic.ERROR,
    		"nestedPackage.unknownOperation(self)",
        	OCLMessages.ErrorUnresolvedOperationName, "unknownOperation");
   }

    /**
     * Tests that the collect() iterator correctly flattens its result.
     */
    public void test_collect_flattens_217461() {
        String self = "foo";
        SequenceValue expected = valueFactory.createSequenceOf("THIS AND", "THAT", "THE OTHER");

        assertQueryEquals(self, expected, "Sequence{Sequence{'this and', 'that'}, Sequence{'the other'}}->collect(s : Sequence(String) | s.toUpperCase())");
    }

    /**
     * Tests that the collect() iterator correctly deals with empty collections.
     */
    public void test_collect_empty_217461() {
        String self = "foo";
        List<String> expected = Collections.emptyList();

        assertQueryEquals(self, expected, "let c : Sequence(OrderedSet(String)) = Sequence{} in c->collect(s : OrderedSet(String) | s.toUpperCase())");
    }

    /**
     * Tests the collectNested() iterator.
     */
    public void test_collectNested() {
        CollectionValue expected1 = valueFactory.createBagOf("pkg2", "bob", "pkg3");

        // complete form
        assertQueryEquals(pkg1, expected1, "nestedPackage->collectNested(p : pivot::Package | p.name)");

        // shorter form
        assertQueryEquals(pkg1, expected1, "nestedPackage->collectNested(p | p.name)");

        // shortest form
        assertQueryEquals(pkg1, expected1, "nestedPackage->collectNested(name)");

        // nested collections not flattened
		Set<org.eclipse.ocl.examples.pivot.Package> e1 = Collections.singleton(jim);
        Set<?> e2 = Collections.EMPTY_SET;
        HashSet<Object> e3 = new HashSet<Object>(Arrays.asList(new Object[] {pkg4, pkg5}));
		CollectionValue expected2 = valueFactory.createBagOf(e1, e2, e3);

        assertQueryEquals(pkg1, expected2, "nestedPackage->collectNested(nestedPackage)");
    }

    /**
     * Tests the sortedBy() iterator.
     */
    public void test_sortedBy() {
    	OrderedSetValue expectedSet = valueFactory.createOrderedSetOf(bob, pkg2, pkg3);

        // complete form
        assertQueryEquals(pkg1, expectedSet, "nestedPackage->sortedBy(p : pivot::Package | p.name)");

        // shorter form
        assertQueryEquals(pkg1, expectedSet, "nestedPackage->sortedBy(p | p.name)");

        // shortest form
        assertQueryEquals(pkg1, expectedSet, "nestedPackage->sortedBy(name)");

        SequenceValue expected = valueFactory.createSequenceOf("a", "b", "c", "d", "e");
        assertQueryEquals(pkg1, expected, "Bag{'d', 'b', 'e', 'a', 'c'}->sortedBy(e | e)");
    }

    /**
     * Tests the closure() iterator.
     */
    // pkg1
    // pkg1::pkg2
    // pkg1::pkg2::jim
    // pkg1::bob
    // pkg1::pkg3
    // pkg1::pkg3::pkg4
    // pkg1::pkg3::pkg5
    // pkg1::pkg3::pkg5::george
    public void test_closure() {
    	CollectionValue expected1 = valueFactory.createSetOf(pkg1, pkg3, pkg5); // closure does not include self (george)
        assertQueryEquals(george, expected1, "self->closure(nestingPackage)");

        CollectionValue expected2 = valueFactory.createSetOf(pkg2, jim, bob, pkg3, pkg4, pkg5, george);
//        CollectionValue expected2a = valueFactory.createOrderedSetOf(pkg2, jim, bob, pkg3, pkg4, pkg5, george);
        assertQueryEquals(pkg1, expected2, "self->closure(nestedPackage)");
// FIXME not a valid test for UML's unordered nested packages
//        assertQueryEquals(pkg1, expected2a, "self->asSequence()->closure(nestedPackage)");
        assertQueryEquals(pkg1, expected2, "self->closure(nestedPackage->asSequence())");
	    SetValue expected3 = valueFactory.createSetOf(pkg2, jim, bob, pkg3, pkg4, pkg5, george);
        assertQueryEquals(pkg1, expected3, "self->asBag()->closure(nestedPackage)");
        assertQueryEquals(pkg1, expected3, "self->closure(nestedPackage->asBag())");

        // empty closure
        assertQueryEquals(pkg1, valueFactory.getEmptySetValue(), "self->closure(nestingPackage)");
        // empty closure
        assertQueryEquals(pkg1, valueFactory.getEmptyOrderedSetValue(), "self->asSequence()->closure(nestingPackage)");
    }

    /**
     * Tests that the closure() iterator handles cycles.
     */
    public void test_closure_cycles() {
        Type packageMetaclass = typeManager.getPivotType("Package");
        Property nestedPackage = reflection.getAttribute(packageMetaclass, "nestedPackage", packageMetaclass);
        Property nestingPackage = reflection.getAttribute(packageMetaclass, "nestingPackage", packageMetaclass);

        helper.setContext(typeManager.getPivotType("Property"));

        SetValue expected = valueFactory.createSetOf(nestedPackage, nestingPackage); // cyclic closure *does* include self
        assertQueryEquals(nestingPackage, expected, "self->closure(opposite)");
        assertQueryEquals(nestedPackage, expected, "self->closure(opposite)");
    }

    /**
     * Tests parsing the closure of operation calls.
     */
    public void test_closure_operations() {
    	org.eclipse.ocl.examples.pivot.Package fakePkg = reflection.createPackage("fake");
        org.eclipse.ocl.examples.pivot.Class fake = reflection.createOwnedClass(fakePkg, "Fake", false);
        Operation getFakes = reflection.createOwnedOperation(fake, "getFakes", null, null, fake, true);
        reflection.setOperationUpper(getFakes, reflection.getUnlimitedValue());

        assertQuery(fake, "self->closure(getFakes())");
    }

    /**
     * Tests the validation of the closure() iterator.
     *
    public void test_closureValidation() {
        // non-recursive reference
        assertQueryInvalid(pkg1, "self->closure(xyzzy)");
        assertBadQuery(SemanticException.class, Diagnostic.ERROR,
        	"self->closure(ownedType)",
        	OCLMessages.NonStd_Iterator_, "closure");
    } */

    /**
     * Tests the validation of the closure() iterator for conformance of the
     * body type with the iterator variable (source element) type.
     */
    public void test_closureValidation_typeConformance_154695() {
    	org.eclipse.ocl.examples.pivot.Package fakePkg = reflection.createPackage("fake");
        org.eclipse.ocl.examples.pivot.Class fake = reflection.createOwnedClass(fakePkg, "Fake", false);
        Operation getFakes = reflection.createOwnedOperation(fake, "getFakes", null, null, fake, true);
        reflection.setOperationUpper(getFakes, reflection.getUnlimitedValue());

        // subclass the Fake class
        org.eclipse.ocl.examples.pivot.Class subFake = reflection.createOwnedClass(fakePkg, "Subfake", false);
        reflection.createGeneralization(subFake, fake);

        // get sub-fakes from a fake
        Operation getSubFakes = reflection.createOwnedOperation(fake, "getSubFakes", null, null, subFake, true);
        reflection.setOperationUpper(getSubFakes, reflection.getUnlimitedValue());

        helper.setContext(subFake);

        // this should not parse because the result of the closure
        // expression
        // is more general than the iterator variable, so cannot be
        // assigned recursively
        assertBadQuery(SemanticException.class, Diagnostic.ERROR,
        	"self->closure(getFakes())",
        	OCLMessages.WarningNonConformingBodyType, fake, subFake);

        // this should parse OK because the result of the closure expression
        // is more specific than the iterator variable, so it can be
        // assigned recursively
        assertQuery(fake, "self->closure(getSubFakes())");
    }

    /**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
    public void test_forAll_invalidBody_142518() {
        assertQueryInvalid(EcorePackage.eINSTANCE,
            "let b:Boolean = null in Bag{1, 2, 3}->forAll(b and b)");

        // check that the "check" API interprets invalid as a constraint
        // violation
        assertInvariantFalse(EcorePackage.eINSTANCE,
            "let b:Boolean = null in Bag{1}->forAll(b and b)");

        // same deal for a null value (in the forAll case)
        assertQueryInvalid(EcorePackage.eINSTANCE,
            "Bag{1, 2, 3}->forAll(null.oclAsType(Boolean))");
    }

    /**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
    public void test_exists_invalidBody_142518() {
    	assertQueryInvalid(EcorePackage.eINSTANCE,
            "let b:Boolean = null in Bag{1, 2, 3}->exists(b and b)");

        // same deal for a null value (in the exists case)
    	assertQueryInvalid(EcorePackage.eINSTANCE,
            "Bag{1, 2, 3}->exists(null.oclAsType(Boolean))");
    }

    /**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
    public void test_one_invalidBody_142518() {
    	assertQueryInvalid(EcorePackage.eINSTANCE,
            "let b:Boolean = null in Bag{1, 2, 3}->one(b and b)");

        // same deal for a null value (in the one case)
        assertQueryInvalid(EcorePackage.eINSTANCE,
            "Bag{1, 2, 3}->one(null.oclAsType(Boolean))");
    }

    /**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
    public void test_any_invalidBody_142518() {
        assertQueryInvalid(EcorePackage.eINSTANCE,
            "let b:Boolean = null in Bag{1, 2, 3}->any(b and b)");

        // same deal for a null value (in the any case)
        assertQueryInvalid(EcorePackage.eINSTANCE,
            "Bag{1, 2, 3}->any(null.oclAsType(Boolean))");
    }

    /**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
    public void test_select_invalidBody_142518() {
        assertQueryInvalid(EcorePackage.eINSTANCE,
            "let b:Boolean = null in Bag{1, 2, 3}->select(b and b)");

        // same deal for a null value (in the exists case)
        assertQueryInvalid(EcorePackage.eINSTANCE,
            "Bag{1, 2, 3}->select(null.oclAsType(Boolean))");
    }

    /**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
    public void test_reject_invalidBody_142518() {
        assertQueryInvalid(EcorePackage.eINSTANCE,
            "let b:Boolean = null in Bag{1, 2, 3}->reject(b and b)");

        // same deal for a null value (in the exists case)
        assertQueryInvalid(EcorePackage.eINSTANCE,
            "Bag{1, 2, 3}->reject(null.oclAsType(Boolean))");
    }

    /**
     * Tests that when the body of an iterator results in invalid, the
     * isUnique iterator expression treats it like any other value.
     */
    public void test_isUnique_invalidBody_142518() {
    	assertQueryInvalid(EcorePackage.eINSTANCE,
            "let b:Boolean = null in Bag{1, 2, 3}->isUnique(b and b)");

        assertQueryFalse(EcorePackage.eINSTANCE,
            "let b:Boolean = null in Bag{1, 2, 3}->isUnique(null)");
    }

    /**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
    public void test_collect_invalidBody_142518() {
        assertQueryInvalid(EcorePackage.eINSTANCE,
            "let b:Boolean = null in Bag{1, 2, 3}->collect(b and b)");

        // in the case of a null value, null is allowed in a collection, so
        // it does not result in invalid
        BagValue expected = valueFactory.createBagOf(getNull(), getNull(), getNull());
        assertQueryEquals(EcorePackage.eINSTANCE, expected,
            "let b:Boolean = null in Bag{1, 2, 3}->collect(null)");
    }

    /**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
	public void test_collectNested_invalidBody_142518() {
        assertQueryInvalid(EcorePackage.eINSTANCE,
            "let b:Boolean = null in Bag{1, 2, 3}->collectNested(b and b)");

        // in the case of a null value, null is allowed in a collection, so
        // it does not result in invalid
    	Set<BigInteger> e1 = Collections.singleton(BigInteger.valueOf(1));
    	Object e2 = getNull();
    	Set<BigInteger> e3 = Collections.singleton(BigInteger.valueOf(3));
        BagValue expected = valueFactory.createBagOf(e1, e2, e3);
        assertQueryEquals(EcorePackage.eINSTANCE, expected,
            "let b:Boolean = null in Bag{1, 2, 3}->collectNested(e | if e = 2 then null else Set{e} endif)");
    }

    /**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
    public void test_closure_invalidBody_142518() {
        assertQueryInvalid(getUMLMetamodel(),
            "let c : pivot::Type = invalid in ownedType->closure(c)");

        // in the case of a null value, null is allowed in a collection, so
        // it does not result in invalid
        assertQueryResults(getUMLMetamodel(), "Set{null}",
    		"let c : Set(pivot::Type) = Set{null} in ownedType->closure(c)");
 
//        Set<Object> expected = Collections.singleton(getNull());
//        assertQueryEquals(EcorePackage.eINSTANCE, expected,
//        	"let c : Set(pivot::Type) = Set{null} in ownedType->closure(c)");
    }

	/**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
    public void test_sortedBy_invalidBody_142518() {
        assertQueryInvalid(EcorePackage.eINSTANCE,
            "let s : String = null in Bag{1, 2, 3}->sortedBy(s.size())");

        // same deal for null values
//        assertQueryInvalid(EcorePackage.eINSTANCE,
//            "Bag{1, 2, 3}->sortedBy(null.oclAsType(Integer))");
        assertBadQuery(SemanticException.class, Diagnostic.ERROR,
        	"Bag{1, 2, 3}->sortedBy(null.oclAsType(Integer))",
        	OCLMessages.WarningUndefinedOperation, PivotConstants.LESS_THAN_OPERATOR, "null");

    }

    /**
     * Tests that the generic iterate() iterator returns invalid when the
     * source collection is null or invalid.
     */
    public void test_iterateWithNullSource_143996() {
        assertQueryInvalid(pkg1,
            "let e : Collection(pivot::Package) = null in e->iterate(" +
                "p : pivot::Package; s : String = '' | s.concat(p.name))");

        assertQueryInvalid(pkg1,
            "let e : Collection(pivot::Package) = invalid in e->iterate(" +
                "p : pivot::Package; s : String = '' | s.concat(p.name))");
    }

    /**
     * Tests that the exists() iterator return invalid when the source
     * collection is null or invalid.
     */
    public void test_existsWithNullSource_143996() {
    	assertQueryInvalid(pkg1,
            "let e : Collection(pivot::Package) = null in e->exists(" +
                "p : pivot::Package | p.name = 'bob')");

    	assertQueryInvalid(pkg1,
            "let e : Collection(pivot::Package) = invalid in e->exists(" +
                "p : pivot::Package | p.name = 'bob')");
    }

    /**
     * Tests the exists iterator with multiple iterator variables.
     */
    public void test_exists_multipleIteratorVariables() {
        assertInvariantTrue(pkg1, "Sequence{1, 2, 3, 4}->exists(e1, e2 | e1 = e2)");

        assertInvariantFalse(pkg1, "Sequence{1, 2, 3, 4}->exists(e1, e2 | (e1 + e2) = 0)");

        // when there are no values, the the desired result implictly
        // does not occur
        assertInvariantFalse(pkg1, "Sequence{}->exists(e1, e2 | e1 = e2)");
    }

    /**
     * Tests the forAll iterator with multiple iterator variables.
     */
    public void test_forAll_multipleIteratorVariables() {
    	assertInvariantFalse(pkg1, "Sequence{1, 2, 3, 4}->forAll(e1, e2 | e1 = e2)");

        assertInvariantTrue(pkg1, "Sequence{1, 2, 3, 4}->forAll(e1, e2 | (e1 + e2) > e1)");

	    // when there are no values, the the desired result implictly occurs
	    assertInvariantTrue(pkg1, "Sequence{}->forAll(e1, e2 | e1 = e2)");
    }

    /**
     * Tests the validation the number of iterator variables for iterators that
     * do not support multiple variables.
     */
    public void test_invalidMultipleIteratorVariables() {
        assertBadQuery(SemanticException.class, Diagnostic.ERROR,		// FIXME Bug 296990
        	"Sequence{'a', 'b', 'c'}->exists(e1, e2, e3 | e1 = e2)",
        	OCLMessages.ErrorUnresolvedOperationName, "exists");

        assertBadQuery(SemanticException.class, Diagnostic.ERROR,		// FIXME Bug 296990
        	"Sequence{'a', 'b', 'c'}->forAll(e1, e2, e3 | e1 = e2)",
        	OCLMessages.ErrorUnresolvedOperationName, "forAll");

        assertBadQuery(SemanticException.class, Diagnostic.ERROR,
        	"Sequence{'a', 'b', 'c'}->collect(e1, e2 | Tuple{a : String = e1, b : String = e2})",
        	OCLMessages.ErrorUnresolvedOperationName, "collect");

        assertBadQuery(SemanticException.class, Diagnostic.ERROR,
        	"Sequence{'a', 'b', 'c'}->any(e1, e2 | e1 = e2)",
        	OCLMessages.ErrorUnresolvedOperationName, "any");

        assertBadQuery(SemanticException.class, Diagnostic.ERROR,
        	"Sequence{'a', 'b', 'c'}->one(e1, e2 | e1 = e2)",
        	OCLMessages.ErrorUnresolvedOperationName, "one");

        assertBadQuery(SemanticException.class, Diagnostic.ERROR,
        	"Sequence{'a', 'b', 'c'}->select(e1, e2 | e1 = e2)",
        	OCLMessages.ErrorUnresolvedOperationName, "select");

        assertBadQuery(SemanticException.class, Diagnostic.ERROR,
        	"Sequence{'a', 'b', 'c'}->reject(e1, e2 | e1 = e2)",
        	OCLMessages.ErrorUnresolvedOperationName, "reject");

        assertBadQuery(SemanticException.class, Diagnostic.ERROR,
        	"Sequence{'a', 'b', 'c'}->isUnique(e1, e2 | e1 = e2)",
        	OCLMessages.ErrorUnresolvedOperationName, "isUnique");
    }

	/**
     * Test to check the validation of the <tt>sortedBy</tt> iterator, that
     * the body expression type has a <tt>&lt;</tt> operation.
     */
    public void test_sortedByRequiresComparability_192729() {
    	Type context = typeManager.getPivotType("Package");
    	Type type = typeManager.getPivotType("Type");
     	assertBadQuery(SemanticException.class, Diagnostic.ERROR,
    		"ownedType->sortedBy(e | e)",
        	OCLMessages.WarningUndefinedOperation, PivotConstants.LESS_THAN_OPERATOR, type.toString());
       
    	assertQuery(context, "%ownedType->sortedBy(e | e.name)");
    }
}
