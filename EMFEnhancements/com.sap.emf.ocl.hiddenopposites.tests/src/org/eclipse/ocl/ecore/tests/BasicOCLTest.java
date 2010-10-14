/**
 * <copyright>
 *
 * Copyright (c) 2005, 2010 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 253252
 *   Borland - Bug 242880
 *   E.D.Willink - Bug 295166
 *
 * </copyright>
 *
 * $Id: BasicOCLTest.java,v 1.16 2010/02/09 21:04:27 ewillink Exp $
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
@SuppressWarnings("nls")
public class BasicOCLTest
	extends AbstractTestSuite {
    
    public void hide_test_createStandardLibrary() {
        Resource res = ocl.getEnvironment().getOCLStandardLibrary().getOclAny().eResource();
        URI oldURI = res.getURI();
        
        res.setURI(URI.createFileURI("c:/temp/oclstdlib.ecore"));
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
			"package ecore context EClass " +
			"inv: true " +
			"endpackage");
		
		Object result = evaluate(constraint);
		assertEquals(Boolean.TRUE, result);
		
		constraint = parseConstraint(
			"package ecore context EClass " +
			"inv: false " +
			"endpackage");
		
		result = evaluate(constraint);
		assertEquals(Boolean.FALSE, result);
	}
	
	public void testLogicalConnectives() {
		OCLExpression<EClassifier> constraint = parseConstraint(
			"package ecore context EClass " +
			"inv: true and true " +
			"endpackage");
		
		Object result = evaluate(constraint);
		assertEquals(Boolean.TRUE, result);
		
		constraint = parseConstraint(
			"package ecore context EClass " +
			"inv: false or false " +
			"endpackage");
		
		result = evaluate(constraint);
		assertEquals(Boolean.FALSE, result);
		
		constraint = parseConstraint(
			"package ecore context EClass " +
			"inv: true and false " +
			"endpackage");
		
		result = evaluate(constraint);
		assertEquals(Boolean.FALSE, result);
		
		constraint = parseConstraint(
			"package ecore context EClass " +
			"inv: true or false " +
			"endpackage");
		
		result = evaluate(constraint);
		assertEquals(Boolean.TRUE, result);
		
		constraint = parseConstraint(
			"package ecore context EClass " +
			"inv: not true " +
			"endpackage");
		
		result = evaluate(constraint);
		assertEquals(Boolean.FALSE, result);
		
		constraint = parseConstraint(
			"package ecore context EClass " +
			"inv: true implies true " +
			"endpackage");
		
		result = evaluate(constraint);
		assertEquals(Boolean.TRUE, result);
		
		constraint = parseConstraint(
			"package ecore context EClass " +
			"inv: true implies false " +
			"endpackage");
		
		result = evaluate(constraint);
		assertEquals(Boolean.FALSE, result);
		
		constraint = parseConstraint(
			"package ecore context EClass " +
			"inv: false implies true " +
			"endpackage");
		
		result = evaluate(constraint);
		assertEquals(Boolean.TRUE, result);
		
		constraint = parseConstraint(
			"package ecore context EClass " +
			"inv: false implies false " +
			"endpackage");
		
		result = evaluate(constraint);
		assertEquals(Boolean.TRUE, result);
	}
	
	public void testSimpleAttributeExpressions() {
		EClass eCls = EcoreFactory.eINSTANCE.createEClass();
		eCls.setName("bar");
		
		OCLExpression<EClassifier> constraint = parseConstraint(
			"package ecore context EClass " +
			"inv: self.name <> 'foo' " +
			"endpackage");
		
		assertTrue(check(constraint, eCls));
		
		eCls.setName("foo");
		assertFalse(check(constraint, eCls));
	}
	
	public void testCollectionExpressions() {
		EClass eCls = EcoreFactory.eINSTANCE.createEClass();
		eCls.setName("bar");
		
		EAttribute eAttr = EcoreFactory.eINSTANCE.createEAttribute();
		eAttr.setName("att1");
		eCls.getEStructuralFeatures().add(eAttr);
		eAttr = EcoreFactory.eINSTANCE.createEAttribute();
		eAttr.setName("att2");
		eCls.getEStructuralFeatures().add(eAttr);
		
		assertEquals(eCls.getEAttributes().size(),2);
		
		OCLExpression<EClassifier> constraint = parseConstraint(
			"package ecore context EClass " +
			"inv: self.eAttributes->size() = 2 " +
			"endpackage");
		
		assertTrue(check(constraint, eCls));
		
		constraint = parseConstraint(
			"package ecore context EClass " +
			"inv: self.eAttributes->forAll(a: EAttribute | not a.derived) " +
			"endpackage");
		
		assertTrue(check(constraint, eCls));
	}
	
	public void testNonBooleansExpressions() {
		EClass eCls = EcoreFactory.eINSTANCE.createEClass();
		eCls.setName("bar");
		
		OCLExpression<EClassifier> expr = parse(
			"package ecore context EClass " +
			"inv: self.name " +
			"endpackage ");
		
		Object result = evaluate(expr, eCls);
		assertEquals("bar", result);
		
		expr = parse(
			"package ecore context EClass " +
			"inv: self " +
			"endpackage");
		
		result = evaluate(expr, eCls);
		assertSame(eCls, result);
	}
	
	public void testIfExpressions() {
		EClass eCls = EcoreFactory.eINSTANCE.createEClass();
		eCls.setName("bar");
		
		OCLExpression<EClassifier> expr = parse(
			"package ecore context EClass " +
			"inv: if self.abstract then name = 'bar' else name <> 'bar' endif " +
			"endpackage ");
		
		assertFalse(check(expr, eCls));
		
		eCls.setAbstract(true);
		
		assertTrue(check(expr, eCls));
		
		eCls.setName("foo");
		
		assertFalse(check(expr, eCls));
	}
	
	public void testIfExpressions_184048() {
		EClass eCls = EcoreFactory.eINSTANCE.createEClass();
		eCls.setName("bar");
		
		OCLExpression<EClassifier> expr = parse(
			"package ecore context EClass " +
			"inv: if self.abstract then name = 'bar' else name <> 'bar' endif ->asSequence()->at(1)" +
			"endpackage ");
		
		assertFalse(check(expr, eCls));
		
		eCls.setAbstract(true);
		
		assertTrue(check(expr, eCls));
		
		eCls.setName("foo");
		
		assertFalse(check(expr, eCls));
		
		OCLExpression<EClassifier> expr2 = parse(
			"package ecore context EClass " +
			"inv: 7 = 1 + let a : String = invalid in 1 + if self.oclIsUndefined() then 1 else 5 endif " +
			"endpackage ");
		assertTrue(check(expr2, eCls));
	}
	
	public void testLetExpressions() {
		EClass eCls = EcoreFactory.eINSTANCE.createEClass();
		eCls.setName("foo");
		
		OCLExpression<EClassifier> expr = parse(
			"package ecore context EClass " +
			"inv: let feats : OrderedSet(EStructuralFeature) = self.eAllStructuralFeatures in " +
			"  feats->isEmpty() implies name <> 'bar' " +
			"endpackage ");
		
		assertTrue(check(expr, eCls));
		
		eCls.setName("bar");
		
		assertFalse(check(expr, eCls));
		
		eCls.getEStructuralFeatures().add(EcoreFactory.eINSTANCE.createEAttribute());
		
		assertTrue(check(expr, eCls));
		
		eCls.setName("foo");
		
		assertTrue(check(expr, eCls));
	}
	
	/**
	 * Tests the support for data types as context classifiers, rather than
	 * EClasses.  The parser now supports arbitrary EClassifiers.
	 */
	public void test_dataTypeAsContext() {
		OCLExpression<EClassifier> expr = parse(
			"package ecore context EString " +
			"inv: self.toUpper() <> self.toLower() " +
			"endpackage ");
		
		assertTrue(check(expr, "anything"));
		assertTrue(check(expr, "ANYTHING"));
		
		expr = parse(
			"package ecore context EString " +
			"inv: self.toUpper() " +
			"endpackage ");
		
		assertEquals("ANYTHING", evaluate(expr, "anything"));
	}
	
	/**
	 * Tests the overrides for equality of primitive values.  In OCL, reals
	 * can equal integers, but not in Java.
	 */
	public void test_equals_primitives() {
		assertTrue(check("1 = 1"));
		assertTrue(check("1 = 1.0"));
		assertTrue(check("1.0 = 1"));
		assertTrue(check("1.0 = 1.0"));
		
		assertTrue(check("'foo' = 'foo'"));
		
		assertTrue(check("ocltest::Color::red = ocltest::Color::red"));
		assertFalse(check("ocltest::Color::red = ocltest::Color::black"));
	}
    
	/**
	 * Tests backslashes in strings and the non-standard escape for
	 * double-quotes in the double-quote syntax that is non-standard, anyway.
	 */
    public void test_backslashes_184948() {
        helper.setContext(EcorePackage.Literals.ESTRING);

		Boolean oldBackslashProcessingEnabled = ParsingOptions.getValue(ocl
			.getEnvironment(), ParsingOptions.USE_BACKSLASH_ESCAPE_PROCESSING);
		ParsingOptions.setOption(ocl.getEnvironment(),
			ParsingOptions.USE_BACKSLASH_ESCAPE_PROCESSING, false);

		String self = "";
        
        try {
            assertEquals("str\\ning",
                evaluate(helper, self, "'str\\ning'"));
            
            assertEquals("str\\(ing",
                evaluate(helper, self, "'str\\(ing'"));
            
            assertEquals("string",
                evaluate(helper, self, "let \"s\\\"g\" : String = 'string' in " +
                    "\"s\\\"g\""));
        } catch (ParserException e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
		} finally {
			ParsingOptions.setOption(ocl.getEnvironment(),
				ParsingOptions.USE_BACKSLASH_ESCAPE_PROCESSING,
				oldBackslashProcessingEnabled);
        }
    }
    
	/**
	 * Tests backslash escaping in string literals.
	 */
	public void test_escapeSequences_242880() {
		helper.setContext(EcorePackage.Literals.ESTRING);
		String self = "";

		try {
			assertInvalidString("'\\\\\\ '");
			assertInvalidString("'str\\(ing'");
			// a comment
			assertInvalidString("'string\\'");
			assertInvalidString("'string\\9'");

			assertEquals("\\",
				evaluate(helper, self, "'\\\\'"));

			assertEquals("str\ning",
				evaluate(helper, self, "'str\\ning'"));

			assertEquals("str\\(ing",
				evaluate(helper, self, "'str\\\\(ing'"));

			assertEquals("string",
				evaluate(helper, self,
					"let \"s\\\"g\" : String = 'string' in " +
						"\"s\\\"g\""));

			assertEquals("str\b \t \n \f \r \" \' \\ing",
				evaluate(helper, self,
					"'str\\b \\t \\n \\f \\r \\\" \\\' \\\\ing'"));

			assertEquals("\123tring",
				evaluate(helper, self, "'\\123tring'"));

			assertEquals("\0123tring",
				evaluate(helper, self, "'\\0123tring'"));

			assertEquals("\70123tring",
				evaluate(helper, self, "'\\70123tring'"));

			assertEquals("\70\123tring",
				evaluate(helper, self, "'\\70\\123tring'"));

			assertEquals("\70\123tring",
				evaluate(helper, self, "'\\70\\123tring'"));

			assertEquals("\345string",
				evaluate(helper, self, "'\\345string'"));

			assertEquals("\456string",
				evaluate(helper, self, "'\\456string'"));

			assertEquals("\12",
				evaluate(helper, self, "'\\12'"));

			assertEquals("string\12",
				evaluate(helper, self, "'string\\12'"));

			assertEquals("string\377",
				evaluate(helper, self, "'string\\377'"));

			assertEquals("string\t\378",
				evaluate(helper, self, "'string\\t\\378'"));
		} catch (ParserException e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
		}
	}
    
    public void test_stringEscapes_184948() {
        helper.setContext(EcorePackage.Literals.ESTRING);
        String self = "";
        
        try {
//            assertEquals("str'ing",
//                evaluate(helper, self, "'str''ing'"));
            
            assertEquals("",
                evaluate(helper, self, "''"));
            
            assertEquals("",
                evaluate(helper, self, "''''"));
            assertEquals("",
                evaluate(helper, self, "'' ''"));
            assertEquals("string",
                evaluate(helper, self, "'str' 'ing'"));
        } catch (ParserException e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
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
                evaluate(helper, CollectionKind.BAG_LITERAL, "CollectionKind::Sequence"));
        } catch (ParserException e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
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
                evaluate(helper, annotation, "null.oclIsTypeOf(OclVoid)"));
            assertEquals(Boolean.TRUE,
                evaluate(helper, annotation, "null.oclIsKindOf(OclVoid)"));
            assertNull(
                evaluate(helper, annotation, "null.oclAsType(OclVoid)"));
            assertNull(
                evaluate(helper, annotation, "null.oclAsType(EAnnotation)"));
            assertNull(
                evaluate(helper, annotation, "null.oclAsType(String)"));
            
            // lax null handling on for null values in non-OclVoid expressions)
            assertEquals(Boolean.TRUE,
                evaluate(helper, annotation, "source.oclIsTypeOf(OclVoid)"));
            assertEquals(Boolean.TRUE,
                evaluate(helper, annotation, "source.oclIsKindOf(OclVoid)"));
            assertNull(
                evaluate(helper, annotation, "source.oclAsType(OclVoid)"));
            assertNull(
                evaluate(helper, annotation, "source.oclAsType(EAnnotation)"));
            assertNull(
                evaluate(helper, annotation, "source.oclAsType(String)"));
            
            
            EvaluationOptions.setOption(ocl.getEvaluationEnvironment(),
                EvaluationOptions.LAX_NULL_HANDLING, false);
            
            // strict null handling on for literal nulls (which are handled
            // separately from null values in non-OclVoid expressions)
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "null.oclIsTypeOf(OclVoid)"));
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "null.oclIsKindOf(OclVoid)"));
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "null.oclAsType(OclVoid)"));
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "null.oclAsType(EAnnotation)"));
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "null.oclAsType(String)"));
            
            // strict null handling on for null values in non-OclVoid expressions)
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "source.oclIsTypeOf(OclVoid)"));
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "source.oclIsKindOf(OclVoid)"));
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "source.oclAsType(OclVoid)"));
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "source.oclAsType(EAnnotation)"));
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "source.oclAsType(String)"));
        } catch (ParserException e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
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
                evaluate(helper, annotation, "invalid.oclIsTypeOf(OclInvalid)"));
            assertEquals(Boolean.TRUE,
                evaluate(helper, annotation, "invalid.oclIsKindOf(OclInvalid)"));
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "invalid.oclAsType(OclInvalid)"));
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "invalid.oclAsType(EAnnotation)"));
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "invalid.oclAsType(String)"));
            
            // lax null handling on for invalid values in non-OclInvalid expressions)
            assertEquals(Boolean.TRUE,
                evaluate(helper, annotation, "source.substring(1, 1).oclIsTypeOf(OclInvalid)"));
            assertEquals(Boolean.TRUE,
                evaluate(helper, annotation, "source.substring(1, 1).oclIsKindOf(OclInvalid)"));
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "source.substring(1, 1).oclAsType(OclInvalid)"));
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "source.substring(1, 1).oclAsType(EAnnotation)"));
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "source.substring(1, 1).oclAsType(String)"));
            
            
            EvaluationOptions.setOption(ocl.getEvaluationEnvironment(),
                EvaluationOptions.LAX_NULL_HANDLING, false);
            
            // strict null handling on for literal invalids (which are handled
            // separately from invalid values in non-OclInvalid expressions)
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "invalid.oclIsTypeOf(OclInvalid)"));
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "invalid.oclIsKindOf(OclInvalid)"));
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "invalid.oclAsType(OclInvalid)"));
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "invalid.oclAsType(EAnnotation)"));
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "invalid.oclAsType(String)"));
            
            // strict null handling on for invalid values in non-OclInvalid expressions)
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "source.substring(1, 1).oclIsTypeOf(OclInvalid)"));
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "source.substring(1, 1).oclIsKindOf(OclInvalid)"));
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "source.substring(1, 1).oclAsType(OclInvalid)"));
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "source.substring(1, 1).oclAsType(EAnnotation)"));
            assertEquals(getInvalid(),
                evaluate(helper, annotation, "source.substring(1, 1).oclAsType(String)"));
        } catch (ParserException e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
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
                evaluate(helper, eclassifier, "self.oclAsType(EClass)"));
            
            EvaluationOptions.setOption(ocl.getEvaluationEnvironment(),
                EvaluationOptions.LAX_NULL_HANDLING, false);
            
            // strict null handling on for invalid values in non-OclInvalid expressions)
            assertEquals(getInvalid(),
                evaluate(helper, eclassifier, "self.oclAsType(EClass)"));
        } catch (ParserException e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
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
                check(helper, EcorePackage.eNS_URI, "null <> Set{'foo'}"));
            assertFalse(
                check(helper, EcorePackage.eNS_URI, "null = Set{'foo'}"));
            assertTrue(
                check(helper, EcorePackage.eNS_URI, "null <> Sequence{'foo'}"));
            assertFalse(
                check(helper, EcorePackage.eNS_URI, "null = Sequence{'foo'}"));
            assertTrue(
                check(helper, EcorePackage.eNS_URI, "null <> OrderedSet{'foo'}"));
            assertFalse(
                check(helper, EcorePackage.eNS_URI, "null = OrderedSet{'foo'}"));
            assertTrue(
                check(helper, EcorePackage.eNS_URI, "null <> Bag{'foo'}"));
            assertFalse(
                check(helper, EcorePackage.eNS_URI, "null = Bag{'foo'}"));
        } catch (ParserException e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
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
                check(helper, EcorePackage.eNS_URI, "invalid <> Set{'foo'}"));
            assertFalse(
                check(helper, EcorePackage.eNS_URI, "invalid = Set{'foo'}"));
            assertTrue(
                check(helper, EcorePackage.eNS_URI, "invalid <> Sequence{'foo'}"));
            assertFalse(
                check(helper, EcorePackage.eNS_URI, "invalid = Sequence{'foo'}"));
            assertTrue(
                check(helper, EcorePackage.eNS_URI, "invalid <> OrderedSet{'foo'}"));
            assertFalse(
                check(helper, EcorePackage.eNS_URI, "invalid = OrderedSet{'foo'}"));
            assertTrue(
                check(helper, EcorePackage.eNS_URI, "invalid <> Bag{'foo'}"));
            assertFalse(
                check(helper, EcorePackage.eNS_URI, "invalid = Bag{'foo'}"));
        } catch (ParserException e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }
    
	private void assertInvalidString(String input) {
		boolean isParserError = false;
		try {
			evaluate(helper, "", input);
		} catch (ParserException e) {
			isParserError = true;
		}
		assertTrue(isParserError);
	}
}
