/**
 * <copyright>
 *
 * Copyright (c) 2005, 2008 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: BasicOCLTest.java,v 1.5 2008/03/14 19:59:27 cdamus Exp $
 */

package org.eclipse.ocl.ecore.tests;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

import junit.framework.Test;
import junit.framework.TestSuite;

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
import org.eclipse.ocl.types.CollectionType;

/**
 * Basic tests for OCL engine.
 *
 * @author Chris McGee (cbmcgee)
 * @author Christian W. Damus (cwdamus)
 */
public class BasicOCLTest
	extends AbstractTestSuite {

	public BasicOCLTest(String name) {
		super(name);
	}
	
	public static Test suite() {
		return new TestSuite(BasicOCLTest.class, "Basic Tests"); //$NON-NLS-1$
	}
    
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
     * Test non-standard doubled single-quote syntax for embedding single-quotes
     * in string literals.
     */
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
            assertEquals(getOclInvalid(),
                evaluate(helper, annotation, "null.oclIsTypeOf(OclVoid)")); //$NON-NLS-1$
            assertEquals(getOclInvalid(),
                evaluate(helper, annotation, "null.oclIsKindOf(OclVoid)")); //$NON-NLS-1$
            assertEquals(getOclInvalid(),
                evaluate(helper, annotation, "null.oclAsType(OclVoid)")); //$NON-NLS-1$
            assertEquals(getOclInvalid(),
                evaluate(helper, annotation, "null.oclAsType(EAnnotation)")); //$NON-NLS-1$
            assertEquals(getOclInvalid(),
                evaluate(helper, annotation, "null.oclAsType(String)")); //$NON-NLS-1$
            
            // strict null handling on for null values in non-OclVoid expressions)
            assertEquals(getOclInvalid(),
                evaluate(helper, annotation, "source.oclIsTypeOf(OclVoid)")); //$NON-NLS-1$
            assertEquals(getOclInvalid(),
                evaluate(helper, annotation, "source.oclIsKindOf(OclVoid)")); //$NON-NLS-1$
            assertEquals(getOclInvalid(),
                evaluate(helper, annotation, "source.oclAsType(OclVoid)")); //$NON-NLS-1$
            assertEquals(getOclInvalid(),
                evaluate(helper, annotation, "source.oclAsType(EAnnotation)")); //$NON-NLS-1$
            assertEquals(getOclInvalid(),
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
            // lax null handling on for literal OclInvalids (which are handled
            // separately from OclInvalid values in non-Invalid expressions)
            assertEquals(Boolean.TRUE,
                evaluate(helper, annotation, "OclInvalid.oclIsTypeOf(Invalid)")); //$NON-NLS-1$
            assertEquals(Boolean.TRUE,
                evaluate(helper, annotation, "OclInvalid.oclIsKindOf(Invalid)")); //$NON-NLS-1$
            assertEquals(getOclInvalid(),
                evaluate(helper, annotation, "OclInvalid.oclAsType(Invalid)")); //$NON-NLS-1$
            assertEquals(getOclInvalid(),
                evaluate(helper, annotation, "OclInvalid.oclAsType(EAnnotation)")); //$NON-NLS-1$
            assertEquals(getOclInvalid(),
                evaluate(helper, annotation, "OclInvalid.oclAsType(String)")); //$NON-NLS-1$
            
            // lax null handling on for OclInvalid values in non-Invalid expressions)
            assertEquals(Boolean.TRUE,
                evaluate(helper, annotation, "source.substring(1, 1).oclIsTypeOf(Invalid)")); //$NON-NLS-1$
            assertEquals(Boolean.TRUE,
                evaluate(helper, annotation, "source.substring(1, 1).oclIsKindOf(Invalid)")); //$NON-NLS-1$
            assertEquals(getOclInvalid(),
                evaluate(helper, annotation, "source.substring(1, 1).oclAsType(Invalid)")); //$NON-NLS-1$
            assertEquals(getOclInvalid(),
                evaluate(helper, annotation, "source.substring(1, 1).oclAsType(EAnnotation)")); //$NON-NLS-1$
            assertEquals(getOclInvalid(),
                evaluate(helper, annotation, "source.substring(1, 1).oclAsType(String)")); //$NON-NLS-1$
            
            
            EvaluationOptions.setOption(ocl.getEvaluationEnvironment(),
                EvaluationOptions.LAX_NULL_HANDLING, false);
            
            // strict null handling on for literal OclInvalids (which are handled
            // separately from OclInvalid values in non-Invalid expressions)
            assertEquals(getOclInvalid(),
                evaluate(helper, annotation, "OclInvalid.oclIsTypeOf(Invalid)")); //$NON-NLS-1$
            assertEquals(getOclInvalid(),
                evaluate(helper, annotation, "OclInvalid.oclIsKindOf(Invalid)")); //$NON-NLS-1$
            assertEquals(getOclInvalid(),
                evaluate(helper, annotation, "OclInvalid.oclAsType(Invalid)")); //$NON-NLS-1$
            assertEquals(getOclInvalid(),
                evaluate(helper, annotation, "OclInvalid.oclAsType(EAnnotation)")); //$NON-NLS-1$
            assertEquals(getOclInvalid(),
                evaluate(helper, annotation, "OclInvalid.oclAsType(String)")); //$NON-NLS-1$
            
            // strict null handling on for OclInvalid values in non-Invalid expressions)
            assertEquals(getOclInvalid(),
                evaluate(helper, annotation, "source.substring(1, 1).oclIsTypeOf(Invalid)")); //$NON-NLS-1$
            assertEquals(getOclInvalid(),
                evaluate(helper, annotation, "source.substring(1, 1).oclIsKindOf(Invalid)")); //$NON-NLS-1$
            assertEquals(getOclInvalid(),
                evaluate(helper, annotation, "source.substring(1, 1).oclAsType(Invalid)")); //$NON-NLS-1$
            assertEquals(getOclInvalid(),
                evaluate(helper, annotation, "source.substring(1, 1).oclAsType(EAnnotation)")); //$NON-NLS-1$
            assertEquals(getOclInvalid(),
                evaluate(helper, annotation, "source.substring(1, 1).oclAsType(String)")); //$NON-NLS-1$
        } catch (ParserException e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
}
