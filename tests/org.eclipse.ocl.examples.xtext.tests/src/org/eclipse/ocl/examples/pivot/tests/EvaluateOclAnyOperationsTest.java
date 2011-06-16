/**
 * <copyright>
 * 
 * Copyright (c) 2009,2011 E.D.Willink and others.
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
 * $Id: EvaluateOclAnyOperationsTest.java,v 1.13 2011/05/20 15:27:16 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.tests;

import java.util.Collections;

import org.eclipse.ocl.examples.pivot.ClassifierType;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.utilities.PivotConstants;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;

/**
 * Tests for OclAny operations.
 */
@SuppressWarnings("nls")
public class EvaluateOclAnyOperationsTest extends PivotSimpleTestSuite
{
    @Override
    protected void setUp() {
        super.setUp();
        helper.setContext(getMetaclass("OclAny"));
    }

    public void testEqualInvalid() {
		assertQueryInvalid(null, "invalid = 3");
		assertQueryInvalid(null, "3 = invalid");
		assertQueryInvalid(null, "invalid = 3.0");
		assertQueryInvalid(null, "3.0 = invalid");

		assertQueryInvalid(null, "invalid = 'test'");
		assertQueryInvalid(null, "'test' = invalid");
		assertQueryInvalid(null, "invalid = true");
		assertQueryInvalid(null, "false = invalid");
		assertQueryInvalid(null, "invalid = Sequence{}");
		assertQueryInvalid(null, "Sequence{} = invalid");

		assertQueryInvalid(null, "invalid = invalid");
	}

	public void testEqualNull() {
		assertQueryFalse(null, "null = 3");
		assertQueryFalse(null, "3 = null");
		assertQueryFalse(null, "null = 3.0");
		assertQueryFalse(null, "3.0 = null");

		assertQueryFalse(null, "null = 'test'");
		assertQueryFalse(null, "'test' = null");
		assertQueryFalse(null, "null = true");
		assertQueryFalse(null, "false = null");
		assertQueryFalse(null, "null = Sequence{}");
		assertQueryFalse(null, "Sequence{} = null");

		assertQueryTrue(null, "null = null");
	}

	public void testEqualType() {
		assertQueryTrue(null, "Boolean = Boolean");
		assertQueryFalse(null, "Boolean = Integer");
		assertQueryTrue(null, "OclVoid = OclVoid");
		assertQueryTrue(null, "OclInvalid = OclInvalid");
		assertQueryFalse(null, "OclInvalid = OclVoid");
		assertQueryTrue(null, "Set(String) = Set(String)");
		assertQueryFalse(null, "Set(String) = Set(Integer)");
		assertQueryFalse(null, "Set(String) = Sequence(String)");
	}

	public void testEqualEnumeration() {
		assertQueryTrue(null, "ocl::CollectionKind::_'Collection' = ocl::CollectionKind::_'Collection'");
		assertQueryFalse(null, "ocl::CollectionKind::_'Collection' = ocl::CollectionKind::_'Set'");
	}
	
	public void testGreaterThanInvalid() {
		// FIXME Analyzer-extraOperation OclAny::< should not be defined
		assertQueryInvalid(null, "invalid > 0");
//		assertSemanticErrorQuery("0 > invalid", OCLMessages.OperationCallNotFound_ERROR_, PivotConstants.GREATER_THAN_OPERATOR);
		assertQueryInvalid(null, "0 > invalid");
		assertSemanticErrorQuery("invalid > invalid", OCLMessages.UnresolvedOperationCall_ERROR_, PivotConstants.GREATER_THAN_OPERATOR, typeManager.getOclInvalidType(), typeManager.getOclInvalidType());
	}
//    protected void assertBadQuery(Class<?> exception, int severity,
//   		 String expression, String messageTemplate, String... bindings) {

	public void testGreaterThanNull() {
		// FIXME Analyzer-extraOperation OclAny::< should not be defined
		assertQueryInvalid(null, "null > 0");
//		assertSemanticErrorQuery("0 > null", OCLMessages.OperationCallNotFound_ERROR_, PivotConstants.GREATER_THAN_OPERATOR);
		assertQueryInvalid(null, "0 > null");
		assertSemanticErrorQuery("null > null", OCLMessages.UnresolvedOperationCall_ERROR_, PivotConstants.GREATER_THAN_OPERATOR, typeManager.getOclVoidType(), typeManager.getOclVoidType());
	}

	public void testGreaterThanOrEqualInvalid() {
		// FIXME Analyzer-extraOperation OclAny::< should not be defined
		assertQueryInvalid(null, "invalid >= 0");
//		assertSemanticErrorQuery("0 >= invalid", OCLMessages.OperationCallNotFound_ERROR_, PivotConstants.GREATER_THAN_OR_EQUAL_OPERATOR);
		assertQueryInvalid(null, "0 >= invalid");
		assertSemanticErrorQuery("invalid >= invalid", OCLMessages.UnresolvedOperationCall_ERROR_, PivotConstants.GREATER_THAN_OR_EQUAL_OPERATOR, typeManager.getOclInvalidType(), typeManager.getOclInvalidType());
	}

	public void testGreaterThanOrEqualNull() {
		// FIXME Analyzer-extraOperation OclAny::< should not be defined
		assertQueryInvalid(null, "null >= 0");
//		assertSemanticErrorQuery("0 >= null", OCLMessages.OperationCallNotFound_ERROR_, PivotConstants.GREATER_THAN_OR_EQUAL_OPERATOR);
		assertQueryInvalid(null, "0 >= null");
		assertSemanticErrorQuery("null >= null", OCLMessages.UnresolvedOperationCall_ERROR_, PivotConstants.GREATER_THAN_OR_EQUAL_OPERATOR, typeManager.getOclVoidType(), typeManager.getOclVoidType());
	}

	public void testLessThanInvalid() {
		// FIXME Analyzer-extraOperation OclAny::< should not be defined
		assertQueryInvalid(null, "invalid < 0");
//		assertSemanticErrorQuery("0 < invalid", OCLMessages.OperationCallNotFound_ERROR_, PivotConstants.LESS_THAN_OPERATOR);
		assertQueryInvalid(null, "0 < invalid");
		assertSemanticErrorQuery("invalid < invalid", OCLMessages.UnresolvedOperationCall_ERROR_, PivotConstants.LESS_THAN_OPERATOR, typeManager.getOclInvalidType(), typeManager.getOclInvalidType());
	}

	public void testLessThanNull() {
		// FIXME Analyzer-extraOperation OclAny::< should not be defined
		assertQueryInvalid(null, "null < 0");
//		assertSemanticErrorQuery("0 < null", OCLMessages.OperationCallNotFound_ERROR_, PivotConstants.LESS_THAN_OPERATOR);
		assertQueryInvalid(null, "0 < null");
		assertSemanticErrorQuery("null < null", OCLMessages.UnresolvedOperationCall_ERROR_, PivotConstants.LESS_THAN_OPERATOR, typeManager.getOclVoidType(), typeManager.getOclVoidType());
	}

	public void testLessThanOrEqualInvalid() {
		// FIXME Analyzer-extraOperation OclAny::< should not be defined
		assertQueryInvalid(null, "invalid <= 0");
//		assertSemanticErrorQuery("0 <= invalid", OCLMessages.OperationCallNotFound_ERROR_, PivotConstants.LESS_THAN_OR_EQUAL_OPERATOR);
		assertQueryInvalid(null, "0 <= invalid");
		assertSemanticErrorQuery("invalid <= invalid", OCLMessages.UnresolvedOperationCall_ERROR_, PivotConstants.LESS_THAN_OR_EQUAL_OPERATOR, typeManager.getOclInvalidType(), typeManager.getOclInvalidType());
	}

	public void testLessThanOrEqualNull() {
		// FIXME Analyzer-extraOperation OclAny::< should not be defined
		assertQueryInvalid(null, "null <= 0");
//		assertSemanticErrorQuery("0 <= null", OCLMessages.OperationCallNotFound_ERROR_, PivotConstants.LESS_THAN_OR_EQUAL_OPERATOR);
		assertQueryInvalid(null, "0 <= null");
		assertSemanticErrorQuery("null <= null", OCLMessages.UnresolvedOperationCall_ERROR_, PivotConstants.LESS_THAN_OR_EQUAL_OPERATOR, typeManager.getOclVoidType(), typeManager.getOclVoidType());
	}

	public void testNotEqualInvalid() {
		assertQueryInvalid(null, "invalid <> 3");
		assertQueryInvalid(null, "3 <> invalid");
		assertQueryInvalid(null, "invalid <> 3.0");
		assertQueryInvalid(null, "3.0 <> invalid");

		assertQueryInvalid(null, "invalid <> 'test'");
		assertQueryInvalid(null, "'test' <> invalid");
		assertQueryInvalid(null, "invalid <> true");
		assertQueryInvalid(null, "false <> invalid");
		assertQueryInvalid(null, "invalid <> Sequence{}");
		assertQueryInvalid(null, "Sequence{} <> invalid");

		assertQueryInvalid(null, "invalid <> invalid");
	}

	public void testNotEqualNull() {
		assertQueryTrue(null, "null <> 3");
		assertQueryTrue(null, "3 <> null");
		assertQueryTrue(null, "null <> 3.0");
		assertQueryTrue(null, "3.0 <> null");

		assertQueryTrue(null, "null <> 'test'");
		assertQueryTrue(null, "'test' <> null");
		assertQueryTrue(null, "null <> true");
		assertQueryTrue(null, "false <> null");
		assertQueryTrue(null, "null <> Sequence{}");
		assertQueryTrue(null, "Sequence{} <> null");

		assertQueryFalse(null, "null <> null");
	}

	public void testNotEqualEnumeration() {
		assertQueryFalse(null, "ocl::CollectionKind::_'Collection' <> ocl::CollectionKind::_'Collection'");
		assertQueryTrue(null, "ocl::CollectionKind::_'Collection' <> ocl::CollectionKind::_'Set'");
	}
	
    /**
     * Tests the explicit oclAsSet() operator.
     */
	public void test_oclAsSet_explicit() {
		assertQueryResults(null, "Set{true}", "true.oclAsSet()");
		assertQueryResults(null, "Set{}", "null.oclAsSet()");
		assertQueryInvalid(null, "invalid.oclAsSet()");
		assertQueryResults(null, "Set{Set{1..4}}", "Set{1..4}->oclAsSet()");
	}
	
    /**
     * Tests the implicit oclAsSet() operator.
     */
	public void test_oclAsSet_implicit() {
		assertQueryResults(null, "Set{true}", "true->select(true)");
		assertQueryResults(null, "Set{true}", "Set{true}->select(true)");
		assertQueryResults(null, "Set{}", "null->select(true)");
		assertQueryResults(null, "Set{}", "Set{}->select(true)");
		assertQueryResults(null, "Set{null}", "Set{null}->select(true)");
		assertQueryInvalid(null, "invalid->select(true)");
		//
		assertQueryResults(null, "false", "true.oclIsUndefined()");
		assertQueryResults(null, "false", "true->oclIsUndefined()");	// Set{true}
		assertQueryResults(null, "true", "null.oclIsUndefined()");
		assertQueryResults(null, "false", "null->oclIsUndefined()");	// Set{}
		assertQueryResults(null, "true", "invalid.oclIsUndefined()");
		assertQueryResults(null, "true", "invalid->oclIsUndefined()");	// invalid
		//
		assertQueryEquals(null, 4, "'1234'.size()");
		assertQueryEquals(null, 1, "'1234'->size()");
		//
		PrimitiveType booleanType = typeManager.getBooleanType();
		assertQueryEquals(null, getClassifierType(booleanType), "true.oclType()");
		Type collectionType = getCollectionType("Set", booleanType);
		assertQueryEquals(null, getClassifierType(collectionType), "true->oclType()");		// Set{true}
	}
	
    /**
     * Tests the oclAsType() operator.
     */
	public void test_oclAsType() {
		assertQueryInvalid(null, "invalid.oclAsType(String)");
		assertQueryInvalid(null, "invalid.oclAsType(Integer)");
		assertQueryInvalid(null, "invalid.oclAsType(Classifier)");
		assertQueryInvalid(null, "invalid.oclAsType(OclVoid)");
		assertQueryInvalid(null, "invalid.oclAsType(OclInvalid)");
		assertQueryInvalid(null, "invalid.oclAsType(Classifier)");
		assertQueryInvalid(null, "invalid.oclAsType(Set<String>)");
		assertQueryInvalid(null, "invalid.oclAsType(Tuple<a:String>)");
		assertQueryInvalid(null, "invalid.oclAsType(ocl::Package)");
		//
		assertQueryNull(null, "null.oclAsType(String)");
		assertQueryNull(null, "null.oclAsType(Integer)");
		assertQueryNull(null, "null.oclAsType(Classifier)");
		assertQueryNull(null, "null.oclAsType(OclVoid)");
		assertQueryInvalid(null, "null.oclAsType(OclInvalid)");
		assertQueryNull(null, "null.oclAsType(Classifier)");
		assertQueryNull(null, "null.oclAsType(Set<String>)");
		assertQueryNull(null, "null.oclAsType(Tuple<a:String>)");
		assertQueryNull(null, "null.oclAsType(ocl::Package)");
		//
		assertQueryInvalid(null, "true.oclAsType(Integer)");
		assertQueryInvalid(null, "true.oclAsType(String)");
		assertQueryTrue(null, "true.oclAsType(Boolean)");
		assertQueryTrue(null, "true.oclAsType(OclAny)");
		assertQueryInvalid(null, "true.oclAsType(OclVoid)");
		assertQueryInvalid(null, "true.oclAsType(OclInvalid)");
		//
		assertQueryEquals(null, 3, "3.oclAsType(Integer)");
		assertQueryEquals(null, 3.0, "3.oclAsType(Real)");
		assertQueryEquals(null, 3, "3.0.oclAsType(Integer)");
		assertQueryEquals(null, 3.0, "3.0.oclAsType(Real)");
		assertQueryInvalid(null, "3.oclAsType(String)");
		assertQueryEquals(null, 3, "3.oclAsType(OclAny)");
		assertQueryInvalid(null, "3.oclAsType(OclVoid)");
		assertQueryInvalid(null, "3.oclAsType(OclInvalid)");
		//
		assertQueryInvalid(null, "3.14.oclAsType(Integer)");
		assertQueryEquals(null, 3.14, "3.14.oclAsType(Real)");
		assertQueryInvalid(null, "3.14.oclAsType(String)");
		assertQueryEquals(null, 3.14, "3.14.oclAsType(OclAny)");
		assertQueryInvalid(null, "3.14.oclAsType(OclVoid)");
		assertQueryInvalid(null, "3.14.oclAsType(OclInvalid)");
		//
		assertQueryInvalid(null, "*.oclAsType(Integer)");
		assertQueryInvalid(null, "*.oclAsType(Real)");
		assertQueryUnlimited(null, "*.oclAsType(UnlimitedNatural)");
		assertQueryInvalid(null, "*.oclAsType(String)");
		assertQueryUnlimited(null, "*.oclAsType(OclAny)");
		assertQueryInvalid(null, "*.oclAsType(OclVoid)");
		assertQueryInvalid(null, "*.oclAsType(OclInvalid)");
		//
		assertQueryResults(null, "Set{1,2}", "Set{1,2}->oclAsType(Set<UnlimitedNatural>)");
		assertQueryResults(null, "Set{1,2}", "Set{1,2}->oclAsType(Set<Integer>)");
		assertQueryResults(null, "Set{1,2}", "Set{1,2}->oclAsType(Collection<UnlimitedNatural>)");
//BUG 344931		assertQueryResults(null, "Set{1,2}", "Set{1.0,2}->oclAsType(Collection<UnlimitedNatural>)");
//BUG 344931		assertQueryResults(null, "Set{1,2}", "Set{1.0,2.0}->oclAsType(Collection<UnlimitedNatural>)");
		assertQueryInvalid(null, "Set{1,2}->oclAsType(Sequence<UnlimitedNatural>)");
		assertQueryInvalid(null, "Set{1,2}.oclAsType(Set<UnlimitedNatural>)");
		assertQueryResults(null, "Bag{1,2}", "Set{1,2}.oclAsType(UnlimitedNatural)");
		assertQueryInvalid(null, "Set{1,2}.oclAsType(Set<Integer>)");
		assertQueryResults(null, "Bag{1,2}", "Set{1,2}.oclAsType(Integer)");
		assertQueryResults(null, "Set{Set{1,2},Set{3,4}}", "Set{Set{1,2},Set{3,4}}->oclAsType(Set<Set<UnlimitedNatural>>)");
		assertQueryResults(null, "Set{Set{1,2},Set{3,4}}", "Set{Set{1,2},Set{3,4}}->oclAsType(Set<Collection<UnlimitedNatural>>)");
		assertQueryResults(null, "Set{Set{1,2},Set{3,4}}", "Set{Set{1,2},Set{3,4}}->oclAsType(Collection<Set<UnlimitedNatural>>)");
		assertQueryResults(null, "Set{Set{1,2},Set{3,4}}", "Set{Set{1,2},Set{3,4}}->oclAsType(Set<Set<Integer>>)");
		assertQueryInvalid(null, "Set{Set{1,2},Set{3,4}}->oclAsType(Set<Sequence<UnlimitedNatural>>)");
		assertQueryInvalid(null, "Set{Set{1,2},Set{3,4}}->oclAsType(Sequence<Set<UnlimitedNatural>>)");
		//
		assertSemanticErrorQuery("3.oclAsType(OclAny).abs()", OCLMessages.UnresolvedOperation_ERROR_, "abs", "OclAny");
		assertSemanticErrorQuery("let v : OclAny = 3 in v.abs()", OCLMessages.UnresolvedOperation_ERROR_, "abs", "OclAny");
		assertQueryEquals(null, 3, "let v : OclAny = 3 in v.oclAsType(Integer).abs()");
		assertQueryInvalid(null, "Integer.oclAsType(Real)");
	}

    /**
     * Tests the oclIsInvalid() operator.
     */
    public void test_oclIsInvalid() {
        assertQueryTrue(null, "invalid.oclIsInvalid()");
        assertQueryFalse(null, "null.oclIsInvalid()");
        assertQueryFalse(null, "true.oclIsInvalid()");
        assertQueryFalse(null, "false.oclIsInvalid()");
        assertQueryFalse(null, "3.14.oclIsInvalid()");
        assertQueryFalse(null, "1.oclIsInvalid()");
        assertQueryFalse(null, "*.oclIsInvalid()");
        assertQueryFalse(null, "'invalid'.oclIsInvalid()");
        assertQueryFalse(pkg1, "self.oclIsInvalid()");
		assertQueryTrue(null, "invalid.oclIsInvalid()");
		assertQueryTrue(null, "('123a'.toInteger()).oclIsInvalid()");	// Bug 342561 for old evaluator
		assertQueryTrue(null, "let a:Integer='123a'.toInteger() in a.oclIsInvalid()");	// Bug 342561 for old evaluator
    }

    /**
     * Tests the oclIsKindOf() operator.
     */
    public void test_oclIsKindOf() {
        assertQueryTrue(null, "invalid.oclIsKindOf(OclInvalid)");
        assertQueryTrue(null, "invalid.oclIsKindOf(OclVoid)");
        assertQueryTrue(null, "invalid.oclIsKindOf(OclAny)");
		assertQueryTrue(null, "invalid.oclIsKindOf(String)");
		assertQueryTrue(null, "invalid.oclIsKindOf(Integer)");
		assertQueryTrue(null, "invalid.oclIsKindOf(Classifier)");
		assertQueryTrue(null, "invalid.oclIsKindOf(Bag<Boolean>)");
		assertQueryTrue(null, "invalid.oclIsKindOf(Tuple(a:Integer))");
        assertQueryTrue(null, "invalid.oclIsKindOf(ocl::Package)");
        //
        assertQueryFalse(null, "null.oclIsKindOf(OclInvalid)");
        assertQueryTrue(null, "null.oclIsKindOf(OclVoid)");
        assertQueryTrue(null, "null.oclIsKindOf(OclAny)");
		assertQueryTrue(null, "null.oclIsKindOf(String)");
		assertQueryTrue(null, "null.oclIsKindOf(Integer)");
		assertQueryTrue(null, "null.oclIsKindOf(Classifier)");
		assertQueryTrue(null, "null.oclIsKindOf(Bag<Boolean>)");
		assertQueryTrue(null, "null.oclIsKindOf(Tuple(a:Integer))");
        assertQueryTrue(null, "null.oclIsKindOf(ocl::Package)");
        //
        assertQueryFalse(null, "true.oclIsKindOf(OclInvalid)");
        assertQueryFalse(null, "true.oclIsKindOf(OclVoid)");
        assertQueryTrue(null, "true.oclIsKindOf(Boolean)");
        assertQueryFalse(null, "true.oclIsKindOf(Integer)");
        assertQueryFalse(null, "true.oclIsKindOf(String)");
        assertQueryTrue(null, "true.oclIsKindOf(OclAny)");
        assertQueryFalse(null, "true.oclIsKindOf(ocl::Package)");
        //
        assertQueryFalse(null, "3.14.oclIsKindOf(OclInvalid)");
        assertQueryFalse(null, "3.14.oclIsKindOf(OclVoid)");
        assertQueryFalse(null, "3.14.oclIsKindOf(Boolean)");
        assertQueryTrue(null, "3.14.oclIsKindOf(Real)");
        assertQueryFalse(null, "3.14.oclIsKindOf(Integer)");
        assertQueryFalse(null, "3.14.oclIsKindOf(String)");
        assertQueryTrue(null, "3.14.oclIsKindOf(OclAny)");
        assertQueryFalse(null, "3.14.oclIsKindOf(ocl::Package)");
        //
        assertQueryFalse(null, "1.oclIsKindOf(OclInvalid)");
        assertQueryFalse(null, "1.oclIsKindOf(OclVoid)");
        assertQueryFalse(null, "1.oclIsKindOf(Boolean)");
        assertQueryTrue(null, "1.oclIsKindOf(Real)");
        assertQueryTrue(null, "1.oclIsKindOf(Integer)");
        assertQueryTrue(null, "(-1).oclIsKindOf(Integer)");
        assertQueryTrue(null, "1.oclIsKindOf(UnlimitedNatural)");
        assertQueryFalse(null, "1.oclIsKindOf(String)");
        assertQueryTrue(null, "1.oclIsKindOf(OclAny)");
        assertQueryFalse(null, "1.oclIsKindOf(ocl::Package)");
        //
        assertQueryFalse(null, "*.oclIsKindOf(OclInvalid)");
        assertQueryFalse(null, "*.oclIsKindOf(OclVoid)");
        assertQueryFalse(null, "*.oclIsKindOf(Boolean)");
        assertQueryTrue(null, "*.oclIsKindOf(Real)");
        assertQueryTrue(null, "*.oclIsKindOf(Integer)");
        assertQueryTrue(null, "*.oclIsKindOf(UnlimitedNatural)");
        assertQueryFalse(null, "*.oclIsKindOf(String)");
        assertQueryTrue(null, "*.oclIsKindOf(OclAny)");
        assertQueryFalse(null, "*.oclIsKindOf(ocl::Package)");
        //
        assertQueryFalse(null, "'invalid'.oclIsKindOf(OclInvalid)");
        assertQueryFalse(null, "'null'.oclIsKindOf(OclVoid)");
        assertQueryFalse(null, "'true'.oclIsKindOf(Boolean)");
        assertQueryFalse(null, "'3.14'.oclIsKindOf(Real)");
        assertQueryFalse(null, "'1'.oclIsKindOf(Integer)");
        assertQueryFalse(null, "'*'.oclIsKindOf(UnlimitedNatural)");
        assertQueryTrue(null, "'string'.oclIsKindOf(String)");
        assertQueryTrue(null, "'any'.oclIsKindOf(OclAny)");
        assertQueryFalse(pkg1, "'self'.oclIsKindOf(ocl::Package)");
        //
        assertQueryFalse(pkg1, "self.oclIsKindOf(OclInvalid)");
        assertQueryFalse(pkg1, "self.oclIsKindOf(OclVoid)");
        assertQueryFalse(pkg1, "self.oclIsKindOf(Boolean)");
        assertQueryFalse(pkg1, "self.oclIsKindOf(Real)");
        assertQueryFalse(pkg1, "self.oclIsKindOf(Integer)");
        assertQueryFalse(pkg1, "self.oclIsKindOf(UnlimitedNatural)");
        assertQueryFalse(pkg1, "self.oclIsKindOf(String)");
        assertQueryTrue(pkg1, "self.oclIsKindOf(OclAny)");
        assertQueryTrue(pkg1, "self.oclIsKindOf(ocl::Package)");
    }

	/**
     * Tests the oclIsTypeOf() operator.
     */
    public void test_oclIsTypeOf() {
        assertQueryTrue(null, "invalid.oclIsTypeOf(OclInvalid)");
        assertQueryFalse(null, "invalid.oclIsTypeOf(OclVoid)");
        assertQueryFalse(null, "invalid.oclIsTypeOf(OclAny)");
		assertQueryFalse(null, "invalid.oclIsTypeOf(Integer)");
		assertQueryFalse(null, "invalid.oclIsTypeOf(String)");
		assertQueryFalse(null, "invalid.oclIsTypeOf(Classifier)");
		assertQueryFalse(null, "invalid.oclIsTypeOf(Set<String>)");
        assertQueryFalse(null, "invalid.oclIsTypeOf(ocl::Package)");
        //
        assertQueryFalse(null, "null.oclIsTypeOf(OclInvalid)");
        assertQueryTrue(null, "null.oclIsTypeOf(OclVoid)");
        assertQueryFalse(null, "null.oclIsTypeOf(OclAny)");
		assertQueryFalse(null, "null.oclIsTypeOf(Integer)");
		assertQueryFalse(null, "null.oclIsTypeOf(String)");
		assertQueryFalse(null, "null.oclIsTypeOf(Classifier)");
		assertQueryFalse(null, "null.oclIsTypeOf(Set<String>)");
        assertQueryFalse(null, "null.oclIsTypeOf(ocl::Package)");
        //
        assertQueryFalse(null, "true.oclIsTypeOf(OclInvalid)");
        assertQueryFalse(null, "true.oclIsTypeOf(OclVoid)");
        assertQueryTrue(null, "true.oclIsTypeOf(Boolean)");
        assertQueryFalse(null, "true.oclIsTypeOf(String)");
        assertQueryFalse(null, "true.oclIsTypeOf(OclAny)");
        assertQueryFalse(null, "true.oclIsTypeOf(ocl::Package)");
        //
        assertQueryFalse(null, "3.14.oclIsTypeOf(OclInvalid)");
        assertQueryFalse(null, "3.14.oclIsTypeOf(OclVoid)");
        assertQueryFalse(null, "3.14.oclIsTypeOf(Boolean)");
        assertQueryTrue(null, "3.14.oclIsTypeOf(Real)");
        assertQueryFalse(null, "3.14.oclIsTypeOf(Integer)");
        assertQueryFalse(null, "3.14.oclIsTypeOf(String)");
        assertQueryFalse(null, "3.14.oclIsTypeOf(OclAny)");
        assertQueryFalse(null, "3.14.oclIsTypeOf(ocl::Package)");
        //
        assertQueryFalse(null, "1.oclIsTypeOf(OclInvalid)");
        assertQueryFalse(null, "1.oclIsTypeOf(OclVoid)");
        assertQueryFalse(null, "1.oclIsTypeOf(Boolean)");
        assertQueryFalse(null, "1.oclIsTypeOf(Real)");
        assertQueryFalse(null, "1.oclIsTypeOf(Integer)");
        assertQueryTrue(null, "(-1).oclIsTypeOf(Integer)");
        assertQueryTrue(null, "1.oclIsTypeOf(UnlimitedNatural)");
        assertQueryFalse(null, "1.oclIsTypeOf(String)");
        assertQueryFalse(null, "1.oclIsTypeOf(OclAny)");
        assertQueryFalse(null, "1.oclIsTypeOf(ocl::Package)");
        //
        assertQueryFalse(null, "*.oclIsTypeOf(OclInvalid)");
        assertQueryFalse(null, "*.oclIsTypeOf(OclVoid)");
        assertQueryFalse(null, "*.oclIsTypeOf(Boolean)");
        assertQueryFalse(null, "*.oclIsTypeOf(Real)");
        assertQueryFalse(null, "*.oclIsTypeOf(Integer)");
        assertQueryTrue(null, "*.oclIsTypeOf(UnlimitedNatural)");
        assertQueryFalse(null, "*.oclIsTypeOf(String)");
        assertQueryFalse(null, "*.oclIsTypeOf(OclAny)");
        assertQueryFalse(null, "*.oclIsTypeOf(ocl::Package)");
        //
        assertQueryFalse(null, "'invalid'.oclIsTypeOf(OclInvalid)");
        assertQueryFalse(null, "'null'.oclIsTypeOf(OclVoid)");
        assertQueryFalse(null, "'true'.oclIsTypeOf(Boolean)");
        assertQueryFalse(null, "'3.14'.oclIsTypeOf(Real)");
        assertQueryFalse(null, "'1'.oclIsTypeOf(Integer)");
        assertQueryFalse(null, "'*'.oclIsTypeOf(UnlimitedNatural)");
        assertQueryTrue(null, "'string'.oclIsTypeOf(String)");
        assertQueryFalse(null, "'any'.oclIsTypeOf(OclAny)");
        assertQueryFalse(pkg1, "'self'.oclIsTypeOf(ocl::Package)");
        //
        assertQueryFalse(pkg1, "self.oclIsTypeOf(OclInvalid)");
        assertQueryFalse(pkg1, "self.oclIsTypeOf(OclVoid)");
        assertQueryFalse(pkg1, "self.oclIsTypeOf(Boolean)");
        assertQueryFalse(pkg1, "self.oclIsTypeOf(Real)");
        assertQueryFalse(pkg1, "self.oclIsTypeOf(Integer)");
        assertQueryFalse(pkg1, "self.oclIsTypeOf(UnlimitedNatural)");
        assertQueryFalse(pkg1, "self.oclIsTypeOf(String)");
        assertQueryFalse(pkg1, "self.oclIsTypeOf(OclAny)");
        assertQueryTrue(pkg1, "self.oclIsTypeOf(ocl::Package)");
    }

    /**
     * Tests the oclIsUndefined() operator.
     */
    public void test_oclIsUndefined() {
        assertQueryTrue(null, "invalid.oclIsUndefined()");
        assertQueryTrue(null, "null.oclIsUndefined()");
        assertQueryFalse(null, "true.oclIsUndefined()");
        assertQueryFalse(null, "false.oclIsUndefined()");
        assertQueryFalse(null, "3.14.oclIsUndefined()");
        assertQueryFalse(null, "1.oclIsUndefined()");
        assertQueryFalse(null, "*.oclIsUndefined()");
        assertQueryFalse(null, "'null'.oclIsUndefined()");
        assertQueryFalse(pkg1, "self.oclIsUndefined()");
    }

    /**
     * Tests the oclType() operator for Booleans.
     */
    public void test_oclType_Boolean() {
    	ClassifierType classifierType = getClassifierType(typeManager.getBooleanType());
    	assertQueryEquals(null, classifierType, "true.oclType()");
    	assertQueryEquals(null, "Boolean", "true.oclType().name");
		assertQueryEquals(null, classifierType, "Boolean");
    	assertQueryEquals(null, "Boolean", "Boolean.name");
    	assertQueryEquals(null, getClassifierType(classifierType), "Boolean.oclType()");
    	assertQueryResults(null, "Set{false,true}", "Boolean.allInstances()");
    	assertQueryResults(null, "Set{false,true}", "true.oclType().allInstances()");
    	assertQueryResults(null, "Set{}", "Boolean.oclType().allInstances()");
    	assertQueryEquals(null, 1, "true.oclType().ownedOperation->select(name = 'xor')->any(true).ownedParameter->size()");
    }

    /**
     * Tests the oclType() operator for Classifiers.
     */
    public void test_oclType_Classifier() {
    	ClassifierType classifierType = getClassifierType(typeManager.getPivotType("Package"));
       	assertQueryEquals(pkg1, classifierType, "self.oclType()");
    	assertQueryEquals(pkg1, "Package", "self.oclType().name");
		assertQueryEquals(null, classifierType, "Package");
    	assertQueryEquals(null, "Package", "Package.name");
    	assertQueryEquals(null, getClassifierType(classifierType), "Package.oclType()");
    	assertQueryResults(null, "Set{}", "Package.allInstances()");
    	assertQueryEquals(pkg1, 8, "Package.allInstances()->size()");
       	assertQueryResults(pkg1, "self->closure(nestedPackage)->including(self)", "Package.allInstances()");
       	assertQueryEquals(pkg1, 8, "self.oclType().allInstances()->size()");
       	assertQueryEquals(pkg1, 0, "Package.oclType().allInstances()->size()");
    }

    /**
     * Tests the oclType() operator for Collections.
     */
    public void test_oclType_Collection() {   	
    	assertQueryEquals(null, 1, "Set{1}->oclType().ownedOperation->select(name = 'flatten')->size()");
    	assertQueryEquals(null, getClassifierType(typeManager.getSetType(typeManager.getOclAnyType())), "Set{}->oclType()");
    	assertQueryEquals(null, getClassifierType(typeManager.getSetType(typeManager.getUnlimitedNaturalType())), "Set{1}->oclType()");
    	assertQueryResults(null, "Bag{'UnlimitedNatural'}", "Set{1}.oclType().name");
    	assertQueryEquals(null, "Set", "Set{1}->oclType().name");
    	assertSemanticErrorQuery("Set{1}.allInstances()", OCLMessages.UnresolvedOperation_ERROR_, "allInstances", "Set<UnlimitedNatural>");
    	assertSemanticErrorQuery("Set{1}->allInstances()", OCLMessages.UnresolvedOperation_ERROR_, "allInstances", "Set<UnlimitedNatural>");
    	assertSemanticErrorQuery("Set{1}.oclType().allInstances()", OCLMessages.UnresolvedOperation_ERROR_, "allInstances", "Bag<Classifier<UnlimitedNatural>>");
    	assertSemanticErrorQuery("Set{1}->oclType().allInstances()", OCLMessages.UnresolvedOperation_ERROR_, "allInstances", "Classifier<Set<UnlimitedNatural>>");
    	assertQueryResults(null, "Set{}", "Set.oclType().allInstances()");
    	assertQueryEquals(null, typeManager.getUnlimitedNaturalType(), "Set{1}->oclType().elementType");
    }

    /**
     * Tests the oclType() operator for Enumerations.
     */
    public void test_oclType_Enumeration() {
    	ClassifierType classifierType = getClassifierType(typeManager.getPivotType("CollectionKind"));
    	assertQueryEquals(null, getClassifierType(typeManager.getPivotType("EnumerationLiteral")), "CollectionKind::Set.oclType()");
    	assertQueryEquals(null, "EnumerationLiteral", "CollectionKind::Set.oclType().name");
    	assertQueryEquals(null, classifierType, "CollectionKind");
    	assertQueryEquals(null, "CollectionKind", "CollectionKind.name");
    	assertQueryEquals(null, getClassifierType(classifierType), "CollectionKind.oclType()");
    	assertQueryEquals(null, 5, "CollectionKind.ownedLiteral->size()");
    	assertSemanticErrorQuery("CollectionKind.oclType().ownedLiteral", OCLMessages.UnresolvedProperty_ERROR_, "ownedLiteral", "Classifier<Classifier<CollectionKind>>");
    	assertQueryResults(null, "Set{CollectionKind::Bag,CollectionKind::Collection,CollectionKind::_'OrderedSet',CollectionKind::_'Sequence',CollectionKind::_'Set'}", "CollectionKind.allInstances()");
    	assertQueryResults(null, "Set{}", "CollectionKind::Set.oclType().allInstances()");
    	assertQueryResults(null, "Set{}", "CollectionKind.oclType().allInstances()");
    }

    /**
     * Tests the oclType() operator for Numerics.
     */
    public void test_oclType_Numeric() {
//
    	ClassifierType classifierType = getClassifierType(typeManager.getIntegerType());
    	assertQueryEquals(null, getClassifierType(typeManager.getUnlimitedNaturalType()), "3.oclType()");
    	assertQueryEquals(null, getClassifierType(typeManager.getRealType()), "3.0.oclType()");
    	assertQueryEquals(null, getClassifierType(typeManager.getUnlimitedNaturalType()), "*.oclType()");
		assertQueryEquals(null, getClassifierType(classifierType), "Integer.oclType()");
    	assertQueryEquals(null, classifierType, "Integer");
    	assertSemanticErrorQuery("Integer.allInstances()", OCLMessages.UnresolvedOperation_ERROR_, "allInstances", "Classifier<Integer>");
    	assertSemanticErrorQuery("3.oclType().allInstances()", OCLMessages.UnresolvedOperation_ERROR_, "allInstances", "Classifier<UnlimitedNatural>");
    	assertQueryResults(null, "Set{}", "Integer.oclType().allInstances()");
     }

    /**
     * Tests the oclType() operator for OclAny.
     */
    public void test_oclType_OclAny() {
    	ClassifierType classifierType = getClassifierType(typeManager.getOclAnyType());
    	assertQueryEquals(null, classifierType, "null.oclAsType(OclAny).oclType()");
//    	assertQueryEquals(null, "OclAny", "null.oclAsType(OclAny).name");
		assertQueryEquals(null, classifierType, "OclAny");
    	assertQueryEquals(null, "OclAny", "OclAny.name");
    	assertQueryEquals(null, getClassifierType(classifierType), "OclAny.oclType()");
    	assertSemanticErrorQuery("OclAny.allInstances()", OCLMessages.UnresolvedOperation_ERROR_, "allInstances", "Classifier<OclAny>");
    	assertSemanticErrorQuery("null.oclAsType(OclAny).oclType().allInstances()", OCLMessages.UnresolvedOperation_ERROR_, "allInstances", "Classifier<OclAny>");
    	assertQueryResults(null, "Set{}", "OclAny.oclType().allInstances()");
    }

    /**
     * Tests the oclType() operator for OclInvalid.
     */
    public void test_oclType_OclInvalid() {
    	ClassifierType classifierType = getClassifierType(typeManager.getOclInvalidType());
    	assertQueryEquals(null, classifierType, "invalid.oclType()");
    	assertQueryEquals(null, "OclInvalid", "invalid.oclType().name");
		assertQueryEquals(null, classifierType, "OclInvalid");
    	assertQueryEquals(null, "OclInvalid", "OclInvalid.name");
    	assertQueryEquals(null, getClassifierType(classifierType), "OclInvalid.oclType()");
    	assertQueryInvalid(null, "OclInvalid.allInstances()");
    	assertQueryInvalid(null, "invalid.oclType().allInstances()");
    	assertQueryResults(null, "Set{}", "OclInvalid.oclType().allInstances()");
    	assertQueryEquals(null, 1, "invalid.oclType().ownedOperation->select(name = '=')->any(true).ownedParameter->size()");
    }

    /**
     * Tests the oclType() operator for OclVoid.
     */
    public void test_oclType_OclVoid() {
    	ClassifierType classifierType = getClassifierType(typeManager.getOclVoidType());
    	assertQueryEquals(null, classifierType, "null.oclType()");
    	assertQueryEquals(null, "OclVoid", "null.oclType().name");
		assertQueryEquals(null, classifierType, "OclVoid");
    	assertQueryEquals(null, "OclVoid", "OclVoid.name");
    	assertQueryEquals(null, getClassifierType(classifierType), "OclVoid.oclType()");
    	assertQueryResults(null, "Set{null}", "OclVoid.allInstances()");
    	assertQueryResults(null, "Set{null}", "null.oclType().allInstances()");
    	assertQueryResults(null, "Set{}", "OclVoid.oclType().allInstances()");
    	assertQueryEquals(null, 1, "null.oclType().ownedOperation->select(name = '=')->any(true).ownedParameter->size()");
    }

    /**
     * Tests the oclType() operator for Tuples.
     */
    public void test_oclType_Tuple() {
    	TypeManager.TuplePart part = new TypeManager.TuplePart("a", typeManager.getIntegerType());
    	TupleType tupleType = typeManager.getTupleType("Tuple", Collections.singletonList(part), null, null);
    	ClassifierType tupleClassifierType = getClassifierType(tupleType);
		assertQueryEquals(null, tupleClassifierType, "Tuple{a:Integer=3}.oclType()");
    	assertQueryEquals(null, tupleClassifierType, "Tuple(a:Integer)");
		assertQueryEquals(null, getClassifierType(tupleClassifierType), "Tuple(a:Integer).oclType()");
    	assertSemanticErrorQuery("Tuple(a:Integer).allInstances()", OCLMessages.UnresolvedOperation_ERROR_, "allInstances", "Classifier<Tuple(a:Integer)>");
    	assertSemanticErrorQuery("Tuple{a:Integer=3}.oclType().allInstances()", OCLMessages.UnresolvedOperation_ERROR_, "allInstances", "Classifier<Tuple(a:Integer)>");	// FIXME
    	assertQueryResults(null, "Set{}", "Tuple(a:Integer).oclType().allInstances()");
     }

    /**
     * Tests the oclType() operator.
     */
    public void test_oclType() {
		assertQueryEquals(null, getClassifierType(typeManager.getStringType()), "'string'.oclType()");
		assertQueryEquals(null, getClassifierType(typeManager.getOclAnyType()), "self.oclType()");
    	assertQueryEquals(null, getClassifierType(getClassifierType(typeManager.getUnlimitedNaturalType())), "3.oclType().oclType()");
    	assertQueryEquals(null, getClassifierType(getClassifierType(getClassifierType(typeManager.getUnlimitedNaturalType()))), "3.oclType().oclType().oclType()");
    	assertQueryEquals(null, getClassifierType(getClassifierType(typeManager.getBooleanType())), "Boolean.oclType()");
    	assertQueryEquals(null, "Classifier", "Boolean.oclType().name");
    	assertSemanticErrorQuery("3.oclType(OclAny)", OCLMessages.UnresolvedOperationCall_ERROR_, "oclType", "UnlimitedNatural", "Classifier<OclAny>");
    }

	public Type getCollectionType(String collectionName, Type type) {
		Type collectionType = typeManager.getCollectionType(collectionName, type);
		typeManager.addLockedElement(collectionType);
		return collectionType;
	}

}
