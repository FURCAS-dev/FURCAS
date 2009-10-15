/**
 * <copyright>
 *
 * Copyright (c) 2005, 2009 IBM Corporation, Zeligsoft Inc., Borland Software Corp., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 253252
 *   Borland - Bug 242880
 *
 * </copyright>
 *
 * $Id: BasicOCLTest.java,v 1.13 2009/10/15 19:46:28 ewillink Exp $
 */

package org.eclipse.ocl.ecore.tests;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.options.EvaluationOptions;
import org.eclipse.ocl.options.ParsingOptions;
import org.eclipse.ocl.types.CollectionType;

/**
 * Basic tests for OCL engine.
 *
 */
public class BasicOCLTest
	extends AbstractTestSuite {
    
    public void hide_test_createStandardLibrary() {
        Resource res = ocl.getEnvironment().getOCLStandardLibrary().getOclAny().eResource();
        URI oldURI = res.getURI();
        
        res.setURI(URI.createFileURI("c:/temp/oclstdlib.ecore")); //$NON-NLS-1$
        try {
            res.save(Collections.EMPTY_MAP);
        } catch (IOException e) {
            fail(e.getLocalizedMessage());
        } finally {
            // restore the correct URI
            res.setURI(oldURI);
        }
    }
    
    /**
     * Tests that the results of the <tt>oclOperations()</tt> and <tt>oclIterators()</tt>
     * methods are the same regardless of which is invoked first.
     */
    public void test_collectionsAndIteratorsAccess_222747() {
        CollectionType<EClassifier, EOperation> type = ocl.getEnvironment().getOCLFactory().createSetType(
                (EClassifier) EcorePackage.Literals.ERESOURCE);
        
        Set<EOperation> iterators = new java.util.HashSet<EOperation>(type.oclIterators());
        Set<EOperation> operations = new java.util.HashSet<EOperation>(type.oclOperations());
        
        // compute the set difference
        Set<EOperation> difference = new java.util.HashSet<EOperation>(operations);
        difference.removeAll(iterators);
        
        assertEquals(difference.size(), operations.size());
        assertTrue(operations.size() > 0);
        assertTrue(iterators.size() > 0);
    }
	
	public void testTrivialExpressions() {
		OCLExpression<EClassifier> constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: true " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		Object result = evaluate(constraint);
		assertEquals(Boolean.TRUE, result);
		
		constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: false " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(constraint);
		assertEquals(Boolean.FALSE, result);
	}
	
	public void testLogicalConnectives() {
		OCLExpression<EClassifier> constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: true and true " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		Object result = evaluate(constraint);
		assertEquals(Boolean.TRUE, result);
		
		constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: false or false " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(constraint);
		assertEquals(Boolean.FALSE, result);
		
		constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: true and false " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(constraint);
		assertEquals(Boolean.FALSE, result);
		
		constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: true or false " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(constraint);
		assertEquals(Boolean.TRUE, result);
		
		constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: not true " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(constraint);
		assertEquals(Boolean.FALSE, result);
		
		constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: true implies true " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(constraint);
		assertEquals(Boolean.TRUE, result);
		
		constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: true implies false " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(constraint);
		assertEquals(Boolean.FALSE, result);
		
		constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: false implies true " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(constraint);
		assertEquals(Boolean.TRUE, result);
		
		constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: false implies false " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(constraint);
		assertEquals(Boolean.TRUE, result);
	}
	
	public void testSimpleAttributeExpressions() {
		EClass eCls = EcoreFactory.eINSTANCE.createEClass();
		eCls.setName("bar"); //$NON-NLS-1$
		
		OCLExpression<EClassifier> constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: self.name <> 'foo' " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		assertTrue(check(constraint, eCls));
		
		eCls.setName("foo"); //$NON-NLS-1$
		assertFalse(check(constraint, eCls));
	}
	
	public void testCollectionExpressions() {
		EClass eCls = EcoreFactory.eINSTANCE.createEClass();
		eCls.setName("bar"); //$NON-NLS-1$
		
		EAttribute eAttr = EcoreFactory.eINSTANCE.createEAttribute();
		eAttr.setName("att1"); //$NON-NLS-1$
		eCls.getEStructuralFeatures().add(eAttr);
		eAttr = EcoreFactory.eINSTANCE.createEAttribute();
		eAttr.setName("att2"); //$NON-NLS-1$
		eCls.getEStructuralFeatures().add(eAttr);
		
		assertEquals(eCls.getEAttributes().size(),2);
		
		OCLExpression<EClassifier> constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: self.eAttributes->size() = 2 " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		assertTrue(check(constraint, eCls));
		
		constraint = parseConstraint(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: self.eAttributes->forAll(a: EAttribute | not a.derived) " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		assertTrue(check(constraint, eCls));
	}
	
	public void testNonBooleansExpressions() {
		EClass eCls = EcoreFactory.eINSTANCE.createEClass();
		eCls.setName("bar"); //$NON-NLS-1$
		
		OCLExpression<EClassifier> expr = parse(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: self.name " + //$NON-NLS-1$
			"endpackage "); //$NON-NLS-1$
		
		Object result = evaluate(expr, eCls);
		assertEquals("bar", result); //$NON-NLS-1$
		
		expr = parse(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: self " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
		
		result = evaluate(expr, eCls);
		assertSame(eCls, result);
	}
	
	public void testIfExpressions() {
		EClass eCls = EcoreFactory.eINSTANCE.createEClass();
		eCls.setName("bar"); //$NON-NLS-1$
		
		OCLExpression<EClassifier> expr = parse(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: if self.abstract then name = 'bar' else name <> 'bar' endif " + //$NON-NLS-1$
			"endpackage "); //$NON-NLS-1$
		
		assertFalse(check(expr, eCls));
		
		eCls.setAbstract(true);
		
		assertTrue(check(expr, eCls));
		
		eCls.setName("foo"); //$NON-NLS-1$
		
		assertFalse(check(expr, eCls));
	}
	
	public void testIfExpressions_184048() {
		EClass eCls = EcoreFactory.eINSTANCE.createEClass();
		eCls.setName("bar"); //$NON-NLS-1$
		
		OCLExpression<EClassifier> expr = parse(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: if self.abstract then name = 'bar' else name <> 'bar' endif ->asSequence()->at(1)" + //$NON-NLS-1$
			"endpackage "); //$NON-NLS-1$
		
		assertFalse(check(expr, eCls));
		
		eCls.setAbstract(true);
		
		assertTrue(check(expr, eCls));
		
		eCls.setName("foo"); //$NON-NLS-1$
		
		assertFalse(check(expr, eCls));
		
		OCLExpression<EClassifier> expr2 = parse(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: 7 = 1 + let a : String = invalid in 1 + if self.oclIsUndefined() then 1 else 5 endif " + //$NON-NLS-1$
			"endpackage "); //$NON-NLS-1$
		assertTrue(check(expr2, eCls));
	}
	
	public void testLetExpressions() {
		EClass eCls = EcoreFactory.eINSTANCE.createEClass();
		eCls.setName("foo"); //$NON-NLS-1$
		
		OCLExpression<EClassifier> expr = parse(
			"package ecore context EClass " + //$NON-NLS-1$
			"inv: let feats : OrderedSet(EStructuralFeature) = self.eAllStructuralFeatures in " + //$NON-NLS-1$
			"  feats->isEmpty() implies name <> 'bar' " + //$NON-NLS-1$
			"endpackage "); //$NON-NLS-1$
		
		assertTrue(check(expr, eCls));
		
		eCls.setName("bar"); //$NON-NLS-1$
		
		assertFalse(check(expr, eCls));
		
		eCls.getEStructuralFeatures().add(EcoreFactory.eINSTANCE.createEAttribute());
		
		assertTrue(check(expr, eCls));
		
		eCls.setName("foo"); //$NON-NLS-1$
		
		assertTrue(check(expr, eCls));
	}
	
	/**
	 * Tests the support for data types as context classifiers, rather than
	 * EClasses.  The parser now supports arbitrary EClassifiers.
	 */
	public void test_dataTypeAsContext() {
		OCLExpression<EClassifier> expr = parse(
			"package ecore context EString " + //$NON-NLS-1$
			"inv: self.toUpper() <> self.toLower() " + //$NON-NLS-1$
			"endpackage "); //$NON-NLS-1$
		
		assertTrue(check(expr, "anything")); //$NON-NLS-1$
		assertTrue(check(expr, "ANYTHING")); //$NON-NLS-1$
		
		expr = parse(
			"package ecore context EString " + //$NON-NLS-1$
			"inv: self.toUpper() " + //$NON-NLS-1$
			"endpackage "); //$NON-NLS-1$
		
		assertEquals("ANYTHING", evaluate(expr, "anything")); //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	/**
	 * Tests the overrides for equality of primitive values.  In OCL, reals
	 * can equal integers, but not in Java.
	 */
	public void test_equals_primitives() {
		assertTrue(check("1 = 1")); //$NON-NLS-1$
		assertTrue(check("1 = 1.0")); //$NON-NLS-1$
		assertTrue(check("1.0 = 1")); //$NON-NLS-1$
		assertTrue(check("1.0 = 1.0")); //$NON-NLS-1$
		
		assertTrue(check("'foo' = 'foo'")); //$NON-NLS-1$
		
		assertTrue(check("ocltest::Color::red = ocltest::Color::red")); //$NON-NLS-1$
		assertFalse(check("ocltest::Color::red = ocltest::Color::black")); //$NON-NLS-1$
	}
    
	/**
	 * Tests backslashes in strings and the non-standard escape for
	 * double-quotes in the double-quote syntax that is non-standard, anyway.
	 */
    public void test_backslashes_184948() {
        helper.setContext(EcorePackage.Literals.ESTRING);
        String self = ""; //$NON-NLS-1$
        
        try {
            assertEquals("str\\ning", //$NON-NLS-1$
                evaluate(helper, self, "'str\\ning'")); //$NON-NLS-1$
            
            assertEquals("str\\(ing", //$NON-NLS-1$
                evaluate(helper, self, "'str\\(ing'")); //$NON-NLS-1$
            
            assertEquals("string", //$NON-NLS-1$
                evaluate(helper, self, "let \"s\\\"g\" : String = 'string' in " + //$NON-NLS-1$
                    "\"s\\\"g\"")); //$NON-NLS-1$
        } catch (ParserException e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
    
	/**
	 * Tests backslash escaping in string literals.
	 */
	public void test_escapeSequences_242880() {
		helper.setContext(EcorePackage.Literals.ESTRING);

		Boolean oldBackslashProcessingEnabled = ParsingOptions.getValue(ocl
			.getEnvironment(), ParsingOptions.USE_BACKSLASH_ESCAPE_PROCESSING);
		ParsingOptions.setOption(ocl.getEnvironment(),
			ParsingOptions.USE_BACKSLASH_ESCAPE_PROCESSING, true);

		String self = ""; //$NON-NLS-1$

		try {
			assertInvalidString("'\\\\\\ '"); //$NON-NLS-1$
			assertInvalidString("'str\\(ing'"); //$NON-NLS-1$
			// a comment
			assertInvalidString("'string\\'"); //$NON-NLS-1$
			assertInvalidString("'string\\9'"); //$NON-NLS-1$

			assertEquals("\\", //$NON-NLS-1$
				evaluate(helper, self, "'\\\\'")); //$NON-NLS-1$

			assertEquals("str\ning", //$NON-NLS-1$
				evaluate(helper, self, "'str\\ning'")); //$NON-NLS-1$

			assertEquals("str\\(ing", //$NON-NLS-1$
				evaluate(helper, self, "'str\\\\(ing'")); //$NON-NLS-1$

			assertEquals("string", //$NON-NLS-1$
				evaluate(helper, self,
					"let \"s\\\"g\" : String = 'string' in " + //$NON-NLS-1$
						"\"s\\\"g\"")); //$NON-NLS-1$

			assertEquals("str\b \t \n \f \r \" \' \\ing", //$NON-NLS-1$
				evaluate(helper, self,
					"'str\\b \\t \\n \\f \\r \\\" \\\' \\\\ing'")); //$NON-NLS-1$

			assertEquals("\123tring", //$NON-NLS-1$
				evaluate(helper, self, "'\\123tring'")); //$NON-NLS-1$

			assertEquals("\0123tring", //$NON-NLS-1$
				evaluate(helper, self, "'\\0123tring'")); //$NON-NLS-1$

			assertEquals("\70123tring", //$NON-NLS-1$
				evaluate(helper, self, "'\\70123tring'")); //$NON-NLS-1$

			assertEquals("\70\123tring", //$NON-NLS-1$
				evaluate(helper, self, "'\\70\\123tring'")); //$NON-NLS-1$

			assertEquals("\70\123tring", //$NON-NLS-1$
				evaluate(helper, self, "'\\70\\123tring'")); //$NON-NLS-1$

			assertEquals("\345string", //$NON-NLS-1$
				evaluate(helper, self, "'\\345string'")); //$NON-NLS-1$

			assertEquals("\456string", //$NON-NLS-1$
				evaluate(helper, self, "'\\456string'")); //$NON-NLS-1$

			assertEquals("\12", //$NON-NLS-1$
				evaluate(helper, self, "'\\12'")); //$NON-NLS-1$

			assertEquals("string\12", //$NON-NLS-1$
				evaluate(helper, self, "'string\\12'")); //$NON-NLS-1$

			assertEquals("string\377", //$NON-NLS-1$
				evaluate(helper, self, "'string\\377'")); //$NON-NLS-1$

			assertEquals("string\t\378", //$NON-NLS-1$
				evaluate(helper, self, "'string\\t\\378'")); //$NON-NLS-1$
		} catch (ParserException e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		} finally {
			ParsingOptions.setOption(ocl.getEnvironment(),
				ParsingOptions.USE_BACKSLASH_ESCAPE_PROCESSING,
				oldBackslashProcessingEnabled);
		}
	}
    
    public void test_stringEscapes_184948() {
        helper.setContext(EcorePackage.Literals.ESTRING);
        String self = ""; //$NON-NLS-1$
        
        try {
            assertEquals("str'ing", //$NON-NLS-1$
                evaluate(helper, self, "'str''ing'")); //$NON-NLS-1$
            
            assertEquals("", //$NON-NLS-1$
                evaluate(helper, self, "''")); //$NON-NLS-1$
            
            assertEquals("'", //$NON-NLS-1$
                evaluate(helper, self, "''''")); //$NON-NLS-1$
        } catch (ParserException e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
    
    /**
     * Tests that the value of an enumeration literal expression is the Java
     * enumerated type instance, not the <tt>EEnumLiteral</tt> model element.
     */
    public void test_enumerationLiteralValue_198945() {
    	helper.setContext(ExpressionsPackage.Literals.COLLECTION_KIND);
        
        try {
            assertSame(CollectionKind.SEQUENCE_LITERAL,
                evaluate(helper, CollectionKind.BAG_LITERAL, "CollectionKind::Sequence")); //$NON-NLS-1$
        } catch (ParserException e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
    
    /**
     * Tests the lax null-handling option for <tt>null</tt> values.
     */
    public void test_laxNullHandling_null() {
        helper.setContext(EcorePackage.Literals.EANNOTATION);
        EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
        
        try {
            // lax null handling on for literal nulls (which are handled
            // separately from null values in non-OclVoid expressions)
            assertEquals(Boolean.TRUE,
                evaluate(helper, annotation, "null.oclIsTypeOf(OclVoid)")); //$NON-NLS-1$
            assertEquals(Boolean.TRUE,
                evaluate(helper, annotation, "null.oclIsKindOf(OclVoid)")); //$NON-NLS-1$
            assertNull(
                evaluate(helper, annotation, "null.oclAsType(OclVoid)")); //$NON-NLS-1$
            assertNull(
                evaluate(helper, annotation, "null.oclAsType(EAnnotation)")); //$NON-NLS-1$
            assertNull(
                evaluate(helper, annotation, "null.oclAsType(String)")); //$NON-NLS-1$
            
            // lax null handling on for null values in non-OclVoid expressions)
            assertEquals(Boolean.TRUE,
                evaluate(helper, annotation, "source.oclIsTypeOf(OclVoid)")); //$NON-NLS-1$
            assertEquals(Boolean.TRUE,
                evaluate(helper, annotation, "source.oclIsKindOf(OclVoid)")); //$NON-NLS-1$
            assertNull(
                evaluate(helper, annotation, "source.oclAsType(OclVoid)")); //$NON-NLS-1$
            assertNull(
                evaluate(helper, annotation, "source.oclAsType(EAnnotation)")); //$NON-NLS-1$
            assertNull(
                evaluate(helper, annotation, "source.oclAsType(String)")); //$NON-NLS-1$
            
            
            EvaluationOptions.setOption(ocl.getEvaluationEnvironment(),
                EvaluationOptions.LAX_NULL_HANDLING, false);
            
            // strict null handling on for literal nulls (which are handled
            // separately from null values in non-OclVoid expressions)
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "null.oclIsTypeOf(OclVoid)")); //$NON-NLS-1$
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "null.oclIsKindOf(OclVoid)")); //$NON-NLS-1$
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "null.oclAsType(OclVoid)")); //$NON-NLS-1$
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "null.oclAsType(EAnnotation)")); //$NON-NLS-1$
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "null.oclAsType(String)")); //$NON-NLS-1$
            
            // strict null handling on for null values in non-OclVoid expressions)
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "source.oclIsTypeOf(OclVoid)")); //$NON-NLS-1$
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "source.oclIsKindOf(OclVoid)")); //$NON-NLS-1$
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "source.oclAsType(OclVoid)")); //$NON-NLS-1$
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "source.oclAsType(EAnnotation)")); //$NON-NLS-1$
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "source.oclAsType(String)")); //$NON-NLS-1$
        } catch (ParserException e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
    
    /**
     * Tests the lax null-handling option for <tt>OclInvalid</tt> values.
     */
    public void test_laxNullHandling_OclInvalid() {
        helper.setContext(EcorePackage.Literals.EANNOTATION);
        EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
        
        try {
            // lax null handling on for literal invalids (which are handled
            // separately from invalid values in non-OclInvalid expressions)
            assertEquals(Boolean.TRUE,
                evaluate(helper, annotation, "invalid.oclIsTypeOf(OclInvalid)")); //$NON-NLS-1$
            assertEquals(Boolean.TRUE,
                evaluate(helper, annotation, "invalid.oclIsKindOf(OclInvalid)")); //$NON-NLS-1$
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "invalid.oclAsType(OclInvalid)")); //$NON-NLS-1$
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "invalid.oclAsType(EAnnotation)")); //$NON-NLS-1$
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "invalid.oclAsType(String)")); //$NON-NLS-1$
            
            // lax null handling on for invalid values in non-OclInvalid expressions)
            assertEquals(Boolean.TRUE,
                evaluate(helper, annotation, "source.substring(1, 1).oclIsTypeOf(OclInvalid)")); //$NON-NLS-1$
            assertEquals(Boolean.TRUE,
                evaluate(helper, annotation, "source.substring(1, 1).oclIsKindOf(OclInvalid)")); //$NON-NLS-1$
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "source.substring(1, 1).oclAsType(OclInvalid)")); //$NON-NLS-1$
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "source.substring(1, 1).oclAsType(EAnnotation)")); //$NON-NLS-1$
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "source.substring(1, 1).oclAsType(String)")); //$NON-NLS-1$
            
            
            EvaluationOptions.setOption(ocl.getEvaluationEnvironment(),
                EvaluationOptions.LAX_NULL_HANDLING, false);
            
            // strict null handling on for literal invalids (which are handled
            // separately from invalid values in non-OclInvalid expressions)
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "invalid.oclIsTypeOf(OclInvalid)")); //$NON-NLS-1$
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "invalid.oclIsKindOf(OclInvalid)")); //$NON-NLS-1$
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "invalid.oclAsType(OclInvalid)")); //$NON-NLS-1$
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "invalid.oclAsType(EAnnotation)")); //$NON-NLS-1$
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "invalid.oclAsType(String)")); //$NON-NLS-1$
            
            // strict null handling on for invalid values in non-OclInvalid expressions)
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "source.substring(1, 1).oclIsTypeOf(OclInvalid)")); //$NON-NLS-1$
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "source.substring(1, 1).oclIsKindOf(OclInvalid)")); //$NON-NLS-1$
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "source.substring(1, 1).oclAsType(OclInvalid)")); //$NON-NLS-1$
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "source.substring(1, 1).oclAsType(EAnnotation)")); //$NON-NLS-1$
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "source.substring(1, 1).oclAsType(String)")); //$NON-NLS-1$
        } catch (ParserException e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
    
    /**
     * Tests that lax null handling works with oclAsType in the EClass context,
     * as well (in the Ecore metamodel).
     */
    public void test_lax_null_handling_on_EcoreModel_253252() {
        helper.setContext(EcorePackage.Literals.ECLASSIFIER);
        EClassifier eclassifier = null;
        
        try {
            // lax null handling on for invalid values in non-OclInvalid expressions)
            assertEquals(null,
                evaluate(helper, eclassifier, "self.oclAsType(EClass)")); //$NON-NLS-1$
            
            EvaluationOptions.setOption(ocl.getEvaluationEnvironment(),
                EvaluationOptions.LAX_NULL_HANDLING, false);
            
            // strict null handling on for invalid values in non-OclInvalid expressions)
            assertEquals(getInvalid(),
                evaluate(helper, eclassifier, "self.oclAsType(EClass)")); //$NON-NLS-1$
        } catch (ParserException e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
    
    /**
     * Tests that the null type conforms to all others, and supports
     * equality comparison with all other types.
     */
    public void test_null_typeConformance_191041() {
        helper.setContext(EcorePackage.Literals.ESTRING);
        
        try {
            assertTrue(
                check(helper, EcorePackage.eNS_URI, "null <> Set{'foo'}")); //$NON-NLS-1$
            assertFalse(
                check(helper, EcorePackage.eNS_URI, "null = Set{'foo'}")); //$NON-NLS-1$
            assertTrue(
                check(helper, EcorePackage.eNS_URI, "null <> Sequence{'foo'}")); //$NON-NLS-1$
            assertFalse(
                check(helper, EcorePackage.eNS_URI, "null = Sequence{'foo'}")); //$NON-NLS-1$
            assertTrue(
                check(helper, EcorePackage.eNS_URI, "null <> OrderedSet{'foo'}")); //$NON-NLS-1$
            assertFalse(
                check(helper, EcorePackage.eNS_URI, "null = OrderedSet{'foo'}")); //$NON-NLS-1$
            assertTrue(
                check(helper, EcorePackage.eNS_URI, "null <> Bag{'foo'}")); //$NON-NLS-1$
            assertFalse(
                check(helper, EcorePackage.eNS_URI, "null = Bag{'foo'}")); //$NON-NLS-1$
        } catch (ParserException e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
    
    /**
     * Tests that the OclInvalid type conforms to all others, and supports
     * equality comparison with all other types.
     */
    public void test_OclInvalid_typeConformance_191041() {
        helper.setContext(EcorePackage.Literals.ESTRING);
        
        try {
            assertTrue(
                check(helper, EcorePackage.eNS_URI, "invalid <> Set{'foo'}")); //$NON-NLS-1$
            assertFalse(
                check(helper, EcorePackage.eNS_URI, "invalid = Set{'foo'}")); //$NON-NLS-1$
            assertTrue(
                check(helper, EcorePackage.eNS_URI, "invalid <> Sequence{'foo'}")); //$NON-NLS-1$
            assertFalse(
                check(helper, EcorePackage.eNS_URI, "invalid = Sequence{'foo'}")); //$NON-NLS-1$
            assertTrue(
                check(helper, EcorePackage.eNS_URI, "invalid <> OrderedSet{'foo'}")); //$NON-NLS-1$
            assertFalse(
                check(helper, EcorePackage.eNS_URI, "invalid = OrderedSet{'foo'}")); //$NON-NLS-1$
            assertTrue(
                check(helper, EcorePackage.eNS_URI, "invalid <> Bag{'foo'}")); //$NON-NLS-1$
            assertFalse(
                check(helper, EcorePackage.eNS_URI, "invalid = Bag{'foo'}")); //$NON-NLS-1$
        } catch (ParserException e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
    
	private void assertInvalidString(String input) {
		boolean isParserError = false;
		try {
			evaluate(helper, "", input); //$NON-NLS-1$
		} catch (ParserException e) {
			isParserError = true;
		}
		assertTrue(isParserError);
	}
}
