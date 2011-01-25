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
 * $Id: GenericEvaluateOclAnyOperationsTest.java,v 1.2 2011/01/24 23:31:52 ewillink Exp $
 */

package org.eclipse.ocl.examples.test.generic;

import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.options.EvaluationOptions;
import org.eclipse.ocl.examples.pivot.utilities.PivotConstants;

/**
 * Tests for OclAny operations.
 */
@SuppressWarnings("nls")
public abstract class GenericEvaluateOclAnyOperationsTest
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
        //  pkg2
        //   jim
        //  bob
        //  pkg3
        //   pkg4
        //   pkg5
        //    george

        pkg1 = reflection.createPackage("pkg1");
/*        pkg2 = reflection.createNestedPackage(pkg1, "pkg2");
        jim = reflection.createNestedPackage(pkg2, "jim");
        bob = reflection.createNestedPackage(pkg1, "bob");
        pkg3 = reflection.createNestedPackage(pkg1, "pkg3");
        pkg4 = reflection.createNestedPackage(pkg3, "pkg4");
        pkg5 = reflection.createNestedPackage(pkg3, "pkg5");
        george = reflection.createNestedPackage(pkg5, "george"); */
//        helper.setContext(getMetaclass(denormalize("%Package")));
        helper.setContext(getMetaclass(denormalize("OclAny")));
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
	
	public void testGreaterThanInvalid() {
		// FIXME Analyzer-extraOperation OclAny::< should not be defined
		assertSemanticErrorQuery("invalid > 0", OCLMessages.ErrorUnresolvedOperationCall, ">");
//		assertSemanticErrorQuery("0 > invalid", OCLMessages.ErrorUnresolvedOperationCall, ">");
		assertQueryInvalid(null, "0 > invalid");
		assertSemanticErrorQuery("invalid > invalid", OCLMessages.ErrorUnresolvedOperationCall, ">");
	}
//    protected void assertBadQuery(Class<?> exception, int severity,
//   		 String expression, String messageTemplate, String... bindings) {

	public void testGreaterThanNull() {
		// FIXME Analyzer-extraOperation OclAny::< should not be defined
		assertSemanticErrorQuery("null > 0", OCLMessages.ErrorUnresolvedOperationCall, ">");
//		assertSemanticErrorQuery("0 > null", OCLMessages.ErrorUnresolvedOperationCall, ">");
		assertQueryInvalid(null, "0 > null");
		assertSemanticErrorQuery("null > null", OCLMessages.ErrorUnresolvedOperationCall, ">");
	}

	public void testGreaterThanOrEqualInvalid() {
		// FIXME Analyzer-extraOperation OclAny::< should not be defined
		assertSemanticErrorQuery("invalid >= 0", OCLMessages.ErrorUnresolvedOperationCall, ">=");
//		assertSemanticErrorQuery("0 >= invalid", OCLMessages.ErrorUnresolvedOperationCall, ">=");
		assertQueryInvalid(null, "0 >= invalid");
		assertSemanticErrorQuery("invalid >= invalid", OCLMessages.ErrorUnresolvedOperationCall, ">=");
	}

	public void testGreaterThanOrEqualNull() {
		// FIXME Analyzer-extraOperation OclAny::< should not be defined
		assertSemanticErrorQuery("null >= 0", OCLMessages.ErrorUnresolvedOperationCall, ">=");
//		assertSemanticErrorQuery("0 >= null", OCLMessages.ErrorUnresolvedOperationCall, ">=");
		assertQueryInvalid(null, "0 >= null");
		assertSemanticErrorQuery("null >= null", OCLMessages.ErrorUnresolvedOperationCall, ">=");
	}

	public void testLessThanInvalid() {
		// FIXME Analyzer-extraOperation OclAny::< should not be defined
		assertSemanticErrorQuery("invalid < 0", OCLMessages.ErrorUnresolvedOperationCall, PivotConstants.LESS_THAN_OPERATOR);
//		assertSemanticErrorQuery("0 < invalid", OCLMessages.ErrorUnresolvedOperationCall, PivotConstants.LESS_THAN_OPERATOR);
		assertQueryInvalid(null, "0 < invalid");
		assertSemanticErrorQuery("invalid < invalid", OCLMessages.ErrorUnresolvedOperationCall, PivotConstants.LESS_THAN_OPERATOR);
	}

	public void testLessThanNull() {
		// FIXME Analyzer-extraOperation OclAny::< should not be defined
		assertSemanticErrorQuery("null < 0", OCLMessages.ErrorUnresolvedOperationCall, PivotConstants.LESS_THAN_OPERATOR);
//		assertSemanticErrorQuery("0 < null", OCLMessages.ErrorUnresolvedOperationCall, PivotConstants.LESS_THAN_OPERATOR);
		assertQueryInvalid(null, "0 < null");
		assertSemanticErrorQuery("null < null", OCLMessages.ErrorUnresolvedOperationCall, PivotConstants.LESS_THAN_OPERATOR);
	}

	public void testLessThanOrEqualInvalid() {
		// FIXME Analyzer-extraOperation OclAny::< should not be defined
		assertSemanticErrorQuery("invalid <= 0", OCLMessages.ErrorUnresolvedOperationCall, "<=");
//		assertSemanticErrorQuery("0 <= invalid", OCLMessages.ErrorUnresolvedOperationCall, "<=");
		assertQueryInvalid(null, "0 <= invalid");
		assertSemanticErrorQuery("invalid <= invalid", OCLMessages.ErrorUnresolvedOperationCall, "<=");
	}

	public void testLessThanOrEqualNull() {
		// FIXME Analyzer-extraOperation OclAny::< should not be defined
		assertSemanticErrorQuery("null <= 0", OCLMessages.ErrorUnresolvedOperationCall, "<=");
//		assertSemanticErrorQuery("0 <= null", OCLMessages.ErrorUnresolvedOperationCall, "<=");
		assertQueryInvalid(null, "0 <= null");
		assertSemanticErrorQuery("null <= null", OCLMessages.ErrorUnresolvedOperationCall, "<=");
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

	public void testOclAsTypeInvalidLaxNullHandlingInvalid() {
		assertQueryInvalid(null, "invalid.oclAsType(String)");
		assertQueryInvalid(null, "invalid.oclAsType(Classifier)");
//		assertQueryInvalid(null, "invalid.oclAsType(Class)");
		assertQueryInvalid(null, "invalid.oclAsType(OclVoid)");
		assertQueryInvalid(null, "invalid.oclAsType(OclInvalid)");
	}

/* FIXME EvaluationOptions.LAX_NULL_HANDLING
	public void testOclAsTypeLaxNullHandlingNull() {
		/ *
		 * EvaluationOptions.LAX_NULL_HANDLING is on, its javadoc tells us
		 * "null" is the expected result whatever the given type. We should
		 * either fix the evaluation or the javadoc.
		 * /
		assertQueryNull(null, "null.oclAsType(String)");
		assertQueryNull(null, "null.oclAsType(Integer)");
		assertQueryNull(null, "null.oclAsType(EClass)");
		assertQueryNull(null, "null.oclAsType(OclVoid)");
		assertQueryNull(null, "null.oclAsType(OclInvalid)");
	} */

	public void testOclAsTypeNoLaxNullHandlingInvalid() {
		Boolean oldNullHandling = EvaluationOptions.getValue(ocl
			.getEvaluationEnvironment(), EvaluationOptions.LAX_NULL_HANDLING);
		// If this assert ever fails, LAX_NULL_HANDLING's default changed
		assertEquals(Boolean.TRUE, oldNullHandling);
		EvaluationOptions.setOption(ocl.getEvaluationEnvironment(),
			EvaluationOptions.LAX_NULL_HANDLING, Boolean.FALSE);

		assertQueryInvalid(null, "invalid.oclAsType(String)");
		assertQueryInvalid(null, "invalid.oclAsType(Integer)");
		assertQueryInvalid(null, "invalid.oclAsType(Classifier)");
//		assertQueryInvalid(null, "invalid.oclAsType(EClass)");
		assertQueryInvalid(null, "invalid.oclAsType(OclVoid)");
		assertQueryInvalid(null, "invalid.oclAsType(OclInvalid)");

		EvaluationOptions.setOption(ocl.getEvaluationEnvironment(),
			EvaluationOptions.LAX_NULL_HANDLING, Boolean.TRUE);
	}

/* FIXME EvaluationOptions.LAX_NULL_HANDLING
	public void testOclAsTypeNoLaxNullHandlingNull() {
		Boolean oldNullHandling = EvaluationOptions.getValue(ocl
			.getEvaluationEnvironment(), EvaluationOptions.LAX_NULL_HANDLING);
		// If this assert ever fails, LAX_NULL_HANDLING's default changed
		assertEquals(Boolean.TRUE, oldNullHandling);
		EvaluationOptions.setOption(ocl.getEvaluationEnvironment(),
			EvaluationOptions.LAX_NULL_HANDLING, Boolean.FALSE);

		assertQueryInvalid(null, "null.oclAsType(String)");
		assertQueryInvalid(null, "null.oclAsType(Integer)");
		assertQueryInvalid(null, "null.oclAsType(EClass)");
		assertQueryInvalid(null, "null.oclAsType(OclVoid)");
		assertQueryInvalid(null, "null.oclAsType(OclInvalid)");

		EvaluationOptions.setOption(ocl.getEvaluationEnvironment(),
			EvaluationOptions.LAX_NULL_HANDLING, Boolean.TRUE);
	} */

	public void testOclIsInvalidInvalid() {
		assertQueryTrue(null, "invalid.oclIsInvalid()");
	}

	public void testOclIsInvalidNull() {
		assertQueryFalse(null, "null.oclIsInvalid()");
	}

/* FIXME FIXME EvaluationOptions.LAX_NULL_HANDLING
	public void testOclIsKindOfInvalidLaxNullHandling() {
		/ *
		 * why is the evaluation of oclIsKindOf altered for invalid
		 * with LAX_NULL_HANDLING off? That is no documented behavior.
		 * /
		assertQueryInvalid(null, "invalid.oclIsKindOf(String)");
		assertQueryInvalid(null, "invalid.oclIsKindOf(EClass)");
		assertQueryInvalid(null, "invalid.oclIsKindOf(OclVoid)");
		assertQueryInvalid(null, "invalid.oclIsKindOf(OclInvalid)");
	} */

/* FIXME FIXME EvaluationOptions.LAX_NULL_HANDLING
	public void testOclIsKindOfInvalidNoLaxHandling() {
		Boolean oldNullHandling = EvaluationOptions.getValue(ocl
			.getEvaluationEnvironment(), EvaluationOptions.LAX_NULL_HANDLING);
		// If this assert ever fails, LAX_NULL_HANDLING's default changed
		assertEquals(Boolean.TRUE, oldNullHandling);
		EvaluationOptions.setOption(ocl.getEvaluationEnvironment(),
			EvaluationOptions.LAX_NULL_HANDLING, Boolean.FALSE);

		assertQueryInvalid(null, "invalid.oclIsKindOf(String)");
		assertQueryInvalid(null, "invalid.oclIsKindOf(Integer)");
		assertQueryInvalid(null, "invalid.oclIsKindOf(EClass)");
		assertQueryInvalid(null, "invalid.oclIsKindOf(OclVoid)");
		assertQueryInvalid(null, "invalid.oclIsKindOf(OclInvalid)");

		EvaluationOptions.setOption(ocl.getEvaluationEnvironment(),
			EvaluationOptions.LAX_NULL_HANDLING, Boolean.TRUE);
	} */

	public void testOclIsKindOfNullLaxNullHandling() {
		/*
		 * FIXME EvaluationOptions.LAX_NULL_HANDLING
		 * is on, its javadoc tells us
		 * "true" is the expected result whatever the given type. We should
		 * either fix the evaluation or the javadoc.
		 */
		assertQueryTrue(null, "null.oclIsKindOf(String)");
		assertQueryTrue(null, "null.oclIsKindOf(Integer)");
		assertQueryTrue(null, "null.oclIsKindOf(OclVoid)");
		assertQueryFalse(null, "null.oclIsKindOf(OclInvalid)");
		assertQueryTrue(null, "null.oclIsKindOf(Classifier)");
//		assertQueryTrue(null, "null.oclIsKindOf(Class)");
	}

/* FIXME EvaluationOptions.LAX_NULL_HANDLING
 	public void testOclIsKindOfNullNoLaxHandling() {
		Boolean oldNullHandling = EvaluationOptions.getValue(ocl
			.getEvaluationEnvironment(), EvaluationOptions.LAX_NULL_HANDLING);
		// If this assert ever fails, LAX_NULL_HANDLING's default changed
		assertEquals(Boolean.TRUE, oldNullHandling);
		EvaluationOptions.setOption(ocl.getEvaluationEnvironment(),
			EvaluationOptions.LAX_NULL_HANDLING, Boolean.FALSE);

		assertQueryInvalid(null, "null.oclIsKindOf(String)");
		assertQueryInvalid(null, "null.oclIsKindOf(Integer)");
		assertQueryInvalid(null, "null.oclIsKindOf(EClass)");
		assertQueryInvalid(null, "null.oclIsKindOf(OclVoid)");
		assertQueryInvalid(null, "null.oclIsKindOf(OclInvalid)");

		EvaluationOptions.setOption(ocl.getEvaluationEnvironment(),
			EvaluationOptions.LAX_NULL_HANDLING, Boolean.TRUE);
	} */

	public void testOclIsTypeOfInvalidLaxNullHandling() {
		/*
		 * FIXME EvaluationOptions.LAX_NULL_HANDLING
		 * why is the evaluation of oclIsTypeOf altered for invalid
		 * with LAX_NULL_HANDLING off? That is no documented behavior.
		 */
		assertQueryFalse(null, "invalid.oclIsTypeOf(String)");
		assertQueryFalse(null, "invalid.oclIsTypeOf(Classifier)");
//		assertQueryFalse(null, "invalid.oclIsTypeOf(EClass)");
		assertQueryFalse(null, "invalid.oclIsTypeOf(OclVoid)");
		assertQueryTrue(null, "invalid.oclIsTypeOf(OclInvalid)");
	}

/* FIXME EvaluationOptions.LAX_NULL_HANDLING
	public void testOclIsTypeOfInvalidNoLaxNullHandling() {
		Boolean oldNullHandling = EvaluationOptions.getValue(ocl
			.getEvaluationEnvironment(), EvaluationOptions.LAX_NULL_HANDLING);
		// If this assert ever fails, LAX_NULL_HANDLING's default changed
		assertEquals(Boolean.TRUE, oldNullHandling);
		EvaluationOptions.setOption(ocl.getEvaluationEnvironment(),
			EvaluationOptions.LAX_NULL_HANDLING, Boolean.FALSE);

		assertQueryInvalid(null, "invalid.oclIsTypeOf(String)");
		assertQueryInvalid(null, "invalid.oclIsTypeOf(Integer)");
		assertQueryInvalid(null, "invalid.oclIsTypeOf(EClass)");
		assertQueryInvalid(null, "invalid.oclIsTypeOf(OclVoid)");
		assertQueryInvalid(null, "invalid.oclIsTypeOf(OclInvalid)");

		EvaluationOptions.setOption(ocl.getEvaluationEnvironment(),
			EvaluationOptions.LAX_NULL_HANDLING, Boolean.TRUE);
	} */

	public void testOclIsTypeOfNullLaxNullHandling() {
		/*
		 * FIXME EvaluationOptions.LAX_NULL_HANDLING
		 * is on, its javadoc tells us
		 * "true" is the expected result whatever the given type. We should
		 * either fix the evaluation or the javadoc.
		 */
		assertQueryFalse(null, "null.oclIsTypeOf(String)");
		assertQueryFalse(null, "null.oclIsTypeOf(Integer)");
		assertQueryFalse(null, "null.oclIsTypeOf(Classifier)");
//		assertQueryFalse(null, "null.oclIsTypeOf(EClass)");
		assertQueryTrue(null, "null.oclIsTypeOf(OclVoid)");
		assertQueryFalse(null, "null.oclIsTypeOf(OclInvalid)");
	}

/* FIXME EvaluationOptions.LAX_NULL_HANDLING
	public void testOclIsTypeOfNullNoLaxNullHandling() {
		Boolean oldNullHandling = EvaluationOptions.getValue(ocl
			.getEvaluationEnvironment(), EvaluationOptions.LAX_NULL_HANDLING);
		// If this assert ever fails, LAX_NULL_HANDLING's default changed
		assertEquals(Boolean.TRUE, oldNullHandling);
		EvaluationOptions.setOption(ocl.getEvaluationEnvironment(),
			EvaluationOptions.LAX_NULL_HANDLING, Boolean.FALSE);

		assertQueryInvalid(null, "null.oclIsTypeOf(String)");
		assertQueryInvalid(null, "null.oclIsTypeOf(Integer)");
		assertQueryInvalid(null, "null.oclIsTypeOf(EClass)");
		assertQueryInvalid(null, "null.oclIsTypeOf(OclVoid)");
		assertQueryInvalid(null, "null.oclIsTypeOf(OclInvalid)");

		EvaluationOptions.setOption(ocl.getEvaluationEnvironment(),
			EvaluationOptions.LAX_NULL_HANDLING, Boolean.TRUE);
	} */

	public void testOclIsUndefinedInvalid() {
		assertQueryTrue(null, "invalid.oclIsUndefined()");
	}

	public void testOclIsUndefinedNull() {
		assertQueryTrue(null, "null.oclIsUndefined()");
	}
    /**
     * Tests the oclAsType() operator.
     */
	public void test_oclAsType() {
		assertQueryInvalid(null, "true.oclAsType(Integer)");
		assertQueryInvalid(null, "true.oclAsType(String)");
		assertQueryTrue(null, "true.oclAsType(Boolean)");
		assertQueryTrue(null, "true.oclAsType(OclAny)");
		assertQueryInvalid(null, "true.oclAsType(OclVoid)");
		assertQueryInvalid(null, "true.oclAsType(OclInvalid)");
		assertQueryEquals(null, 3, "3.oclAsType(Integer)");
		assertQueryEquals(null, 3.0, "3.oclAsType(Real)");
		assertQueryEquals(null, 3, "3.0.oclAsType(Integer)");
		assertQueryEquals(null, 3.0, "3.0.oclAsType(Real)");
		assertQueryInvalid(null, "3.oclAsType(String)");
		assertQueryEquals(null, 3, "3.oclAsType(OclAny)");
		assertQueryInvalid(null, "3.oclAsType(OclVoid)");
		assertQueryInvalid(null, "3.oclAsType(OclInvalid)");

		assertQueryInvalid(null, "3.14.oclAsType(Integer)");
		assertQueryEquals(null, 3.14, "3.14.oclAsType(Real)");
		assertQueryInvalid(null, "3.14.oclAsType(String)");
		assertQueryEquals(null, 3.14, "3.14.oclAsType(OclAny)");
		assertQueryInvalid(null, "3.14.oclAsType(OclVoid)");
		assertQueryInvalid(null, "3.14.oclAsType(OclInvalid)");

		assertQueryInvalid(null, "*.oclAsType(Integer)");
		assertQueryInvalid(null, "*.oclAsType(Real)");
		assertQueryUnlimited(null, "*.oclAsType(UnlimitedNatural)");
		assertQueryInvalid(null, "*.oclAsType(String)");
		assertQueryUnlimited(null, "*.oclAsType(OclAny)");
		assertQueryInvalid(null, "*.oclAsType(OclVoid)");
		assertQueryInvalid(null, "*.oclAsType(OclInvalid)");
	}

    /**
     * Tests the oclIsInvalid() operator.
     */
    public void test_oclIsInvalid() {
        assertQueryFalse(pkg1, "self.oclIsInvalid()");

        assertQueryTrue(pkg1, "invalid.oclIsInvalid()");
        assertQueryFalse(pkg1, "null.oclIsInvalid()");
        assertQueryFalse(pkg1, "true.oclIsInvalid()");
        assertQueryFalse(pkg1, "false.oclIsInvalid()");
        assertQueryFalse(pkg1, "3.14.oclIsInvalid()");
        assertQueryFalse(pkg1, "1.oclIsInvalid()");
        assertQueryFalse(pkg1, "*.oclIsInvalid()");
        assertQueryFalse(pkg1, "'invalid'.oclIsInvalid()");
        assertQueryFalse(pkg1, "self.oclIsInvalid()");
    }

    /**
     * Tests the oclIsKindOf() operator.
     */
    public void test_oclIsKindOf() {
        assertQueryTrue(pkg1, "invalid.oclIsKindOf(OclInvalid)");
        assertQueryTrue(pkg1, "invalid.oclIsKindOf(OclVoid)");
        assertQueryTrue(pkg1, "invalid.oclIsKindOf(OclAny)");
        assertQueryTrue(pkg1, "invalid.oclIsKindOf(pivot::Package)");
        assertQueryFalse(pkg1, "null.oclIsKindOf(OclInvalid)");
        assertQueryTrue(pkg1, "null.oclIsKindOf(OclVoid)");
        assertQueryTrue(pkg1, "null.oclIsKindOf(OclAny)");
        assertQueryTrue(pkg1, "null.oclIsKindOf(pivot::Package)");
        assertQueryFalse(pkg1, "true.oclIsKindOf(OclInvalid)");
        assertQueryFalse(pkg1, "true.oclIsKindOf(OclVoid)");
        assertQueryTrue(pkg1, "true.oclIsKindOf(Boolean)");
        assertQueryFalse(pkg1, "true.oclIsKindOf(Integer)");
        assertQueryFalse(pkg1, "true.oclIsKindOf(String)");
        assertQueryTrue(pkg1, "true.oclIsKindOf(OclAny)");
        assertQueryFalse(pkg1, "true.oclIsKindOf(pivot::Package)");
        assertQueryFalse(pkg1, "3.14.oclIsKindOf(OclInvalid)");
        assertQueryFalse(pkg1, "3.14.oclIsKindOf(OclVoid)");
        assertQueryFalse(pkg1, "3.14.oclIsKindOf(Boolean)");
        assertQueryTrue(pkg1, "3.14.oclIsKindOf(Real)");
        assertQueryFalse(pkg1, "3.14.oclIsKindOf(Integer)");
        assertQueryFalse(pkg1, "3.14.oclIsKindOf(String)");
        assertQueryTrue(pkg1, "3.14.oclIsKindOf(OclAny)");
        assertQueryFalse(pkg1, "3.14.oclIsKindOf(pivot::Package)");
        assertQueryFalse(pkg1, "1.oclIsKindOf(OclInvalid)");
        assertQueryFalse(pkg1, "1.oclIsKindOf(OclVoid)");
        assertQueryFalse(pkg1, "1.oclIsKindOf(Boolean)");
        assertQueryTrue(pkg1, "1.oclIsKindOf(Real)");
        assertQueryTrue(pkg1, "1.oclIsKindOf(Integer)");
        assertQueryTrue(pkg1, "(-1).oclIsKindOf(Integer)");
        assertQueryTrue(pkg1, "1.oclIsKindOf(UnlimitedNatural)");
        assertQueryFalse(pkg1, "1.oclIsKindOf(String)");
        assertQueryTrue(pkg1, "1.oclIsKindOf(OclAny)");
        assertQueryFalse(pkg1, "1.oclIsKindOf(pivot::Package)");
        assertQueryFalse(pkg1, "*.oclIsKindOf(OclInvalid)");
        assertQueryFalse(pkg1, "*.oclIsKindOf(OclVoid)");
        assertQueryFalse(pkg1, "*.oclIsKindOf(Boolean)");
        assertQueryTrue(pkg1, "*.oclIsKindOf(Real)");
        assertQueryTrue(pkg1, "*.oclIsKindOf(Integer)");
        assertQueryTrue(pkg1, "*.oclIsKindOf(UnlimitedNatural)");
        assertQueryFalse(pkg1, "*.oclIsKindOf(String)");
        assertQueryTrue(pkg1, "*.oclIsKindOf(OclAny)");
        assertQueryFalse(pkg1, "*.oclIsKindOf(pivot::Package)");
        assertQueryFalse(pkg1, "'invalid'.oclIsKindOf(OclInvalid)");
        assertQueryFalse(pkg1, "'null'.oclIsKindOf(OclVoid)");
        assertQueryFalse(pkg1, "'true'.oclIsKindOf(Boolean)");
        assertQueryFalse(pkg1, "'3.14'.oclIsKindOf(Real)");
        assertQueryFalse(pkg1, "'1'.oclIsKindOf(Integer)");
        assertQueryFalse(pkg1, "'*'.oclIsKindOf(UnlimitedNatural)");
        assertQueryTrue(pkg1, "'string'.oclIsKindOf(String)");
        assertQueryTrue(pkg1, "'any'.oclIsKindOf(OclAny)");
        assertQueryFalse(pkg1, "'self'.oclIsKindOf(pivot::Package)");
        assertQueryFalse(pkg1, "self.oclIsKindOf(OclInvalid)");
        assertQueryFalse(pkg1, "self.oclIsKindOf(OclVoid)");
        assertQueryFalse(pkg1, "self.oclIsKindOf(Boolean)");
        assertQueryFalse(pkg1, "self.oclIsKindOf(Real)");
        assertQueryFalse(pkg1, "self.oclIsKindOf(Integer)");
        assertQueryFalse(pkg1, "self.oclIsKindOf(UnlimitedNatural)");
        assertQueryFalse(pkg1, "self.oclIsKindOf(String)");
        assertQueryTrue(pkg1, "self.oclIsKindOf(OclAny)");
        assertQueryTrue(pkg1, "self.oclIsKindOf(pivot::Package)");
    }

	/**
     * Tests the oclIsTypeOf() operator.
     */
    public void test_oclIsTypeOf() {
        assertQueryTrue(pkg1, "invalid.oclIsTypeOf(OclInvalid)");
        assertQueryFalse(pkg1, "invalid.oclIsTypeOf(OclVoid)");
        assertQueryFalse(pkg1, "invalid.oclIsTypeOf(OclAny)");
        assertQueryFalse(pkg1, "invalid.oclIsTypeOf(pivot::Package)");
        assertQueryFalse(pkg1, "null.oclIsTypeOf(OclInvalid)");
        assertQueryTrue(pkg1, "null.oclIsTypeOf(OclVoid)");
        assertQueryFalse(pkg1, "null.oclIsTypeOf(OclAny)");
        assertQueryFalse(pkg1, "null.oclIsTypeOf(pivot::Package)");
        assertQueryFalse(pkg1, "true.oclIsTypeOf(OclInvalid)");
        assertQueryFalse(pkg1, "true.oclIsTypeOf(OclVoid)");
        assertQueryTrue(pkg1, "true.oclIsTypeOf(Boolean)");
        assertQueryFalse(pkg1, "true.oclIsTypeOf(String)");
        assertQueryFalse(pkg1, "true.oclIsTypeOf(OclAny)");
        assertQueryFalse(pkg1, "true.oclIsTypeOf(pivot::Package)");
        assertQueryFalse(pkg1, "3.14.oclIsTypeOf(OclInvalid)");
        assertQueryFalse(pkg1, "3.14.oclIsTypeOf(OclVoid)");
        assertQueryFalse(pkg1, "3.14.oclIsTypeOf(Boolean)");
        assertQueryTrue(pkg1, "3.14.oclIsTypeOf(Real)");
        assertQueryFalse(pkg1, "3.14.oclIsTypeOf(Integer)");
        assertQueryFalse(pkg1, "3.14.oclIsTypeOf(String)");
        assertQueryFalse(pkg1, "3.14.oclIsTypeOf(OclAny)");
        assertQueryFalse(pkg1, "3.14.oclIsTypeOf(pivot::Package)");
        assertQueryFalse(pkg1, "1.oclIsTypeOf(OclInvalid)");
        assertQueryFalse(pkg1, "1.oclIsTypeOf(OclVoid)");
        assertQueryFalse(pkg1, "1.oclIsTypeOf(Boolean)");
        assertQueryFalse(pkg1, "1.oclIsTypeOf(Real)");
        assertQueryFalse(pkg1, "1.oclIsTypeOf(Integer)");
        assertQueryTrue(pkg1, "(-1).oclIsTypeOf(Integer)");
        assertQueryTrue(pkg1, "1.oclIsTypeOf(UnlimitedNatural)");
        assertQueryFalse(pkg1, "1.oclIsTypeOf(String)");
        assertQueryFalse(pkg1, "1.oclIsTypeOf(OclAny)");
        assertQueryFalse(pkg1, "1.oclIsTypeOf(pivot::Package)");
        assertQueryFalse(pkg1, "*.oclIsTypeOf(OclInvalid)");
        assertQueryFalse(pkg1, "*.oclIsTypeOf(OclVoid)");
        assertQueryFalse(pkg1, "*.oclIsTypeOf(Boolean)");
        assertQueryFalse(pkg1, "*.oclIsTypeOf(Real)");
        assertQueryFalse(pkg1, "*.oclIsTypeOf(Integer)");
        assertQueryTrue(pkg1, "*.oclIsTypeOf(UnlimitedNatural)");
        assertQueryFalse(pkg1, "*.oclIsTypeOf(String)");
        assertQueryFalse(pkg1, "*.oclIsTypeOf(OclAny)");
        assertQueryFalse(pkg1, "*.oclIsTypeOf(pivot::Package)");
        assertQueryFalse(pkg1, "'invalid'.oclIsTypeOf(OclInvalid)");
        assertQueryFalse(pkg1, "'null'.oclIsTypeOf(OclVoid)");
        assertQueryFalse(pkg1, "'true'.oclIsTypeOf(Boolean)");
        assertQueryFalse(pkg1, "'3.14'.oclIsTypeOf(Real)");
        assertQueryFalse(pkg1, "'1'.oclIsTypeOf(Integer)");
        assertQueryFalse(pkg1, "'*'.oclIsTypeOf(UnlimitedNatural)");
        assertQueryTrue(pkg1, "'string'.oclIsTypeOf(String)");
        assertQueryFalse(pkg1, "'any'.oclIsTypeOf(OclAny)");
        assertQueryFalse(pkg1, "'self'.oclIsTypeOf(pivot::Package)");
        assertQueryFalse(pkg1, "self.oclIsTypeOf(OclInvalid)");
        assertQueryFalse(pkg1, "self.oclIsTypeOf(OclVoid)");
        assertQueryFalse(pkg1, "self.oclIsTypeOf(Boolean)");
        assertQueryFalse(pkg1, "self.oclIsTypeOf(Real)");
        assertQueryFalse(pkg1, "self.oclIsTypeOf(Integer)");
        assertQueryFalse(pkg1, "self.oclIsTypeOf(UnlimitedNatural)");
        assertQueryFalse(pkg1, "self.oclIsTypeOf(String)");
        assertQueryFalse(pkg1, "self.oclIsTypeOf(OclAny)");
        assertQueryTrue(pkg1, "self.oclIsTypeOf(pivot::Package)");
    }

    /**
     * Tests the oclIsUndefined() operator.
     */
    public void test_oclIsUndefined() {
        assertQueryTrue(pkg1, "invalid.oclIsUndefined()");
        assertQueryTrue(pkg1, "null.oclIsUndefined()");
        assertQueryFalse(pkg1, "true.oclIsUndefined()");
        assertQueryFalse(pkg1, "false.oclIsUndefined()");
        assertQueryFalse(pkg1, "3.14.oclIsUndefined()");
        assertQueryFalse(pkg1, "1.oclIsUndefined()");
        assertQueryFalse(pkg1, "*.oclIsUndefined()");
        assertQueryFalse(pkg1, "'null'.oclIsUndefined()");
        assertQueryFalse(pkg1, "self.oclIsUndefined()");
    }
	
	/**
	 * Tests the allInstances() operator.
	 */
	public void test_allInstances() {
		assertQueryEquals(pkg1, 1, "pivot::Package.allInstances()->size()");
		assertQueryResults(null, "Set{true,false}", "Boolean.allInstances()");
		assertQueryResults(null, "Set{null}", "OclVoid.allInstances()");
		assertQueryResults(null, "Set{}", "pivot::Package.allInstances()");
		assertQueryEquals(pkg1, 1, "pivot::Package.allInstances()->size()");
		assertSemanticErrorQuery("Integer.allInstances()", OCLMessages.ErrorUnresolvedOperationName, "allInstances");
		assertSemanticErrorQuery("String.allInstances()", OCLMessages.ErrorUnresolvedOperationName, "allInstances");
		assertSemanticErrorQuery("Set(Integer).allInstances()", OCLMessages.ErrorUnresolvedOperationName, "allInstances");
		assertSemanticErrorQuery("OclAny.allInstances()", OCLMessages.ErrorUnresolvedOperationName, "allInstances");
		assertQueryInvalid(null, "OclInvalid.allInstances()");
		// FIXME Subtest-not-implemented Enumeration
	}
}
