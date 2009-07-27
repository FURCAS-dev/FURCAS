/**
 * <copyright>
 *
 * Copyright (c) 2006 IBM Corporation and others.
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
 * $Id: SerializationTest.java,v 1.5 2009/07/27 15:28:52 ewillink Exp $
 */

package org.eclipse.emf.ocl.tests;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Collections;
import java.util.Iterator;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.helper.HelperUtil;
import org.eclipse.emf.ocl.helper.IOCLHelper;
import org.eclipse.emf.ocl.parser.PersistentEnvironment;
import org.eclipse.emf.ocl.types.impl.TypeUtil;
import org.eclipse.emf.ocl.uml.Constraint;

/**
 * Tests for serialization of OCL constraints and expressions.
 *
 * @author Christian W. Damus (cdamus)
 */
public class SerializationTest
	extends AbstractTestSuite {

	private ResourceSet rset;
	private Resource res;
	
	public SerializationTest(String name) {
		super(name);
	}
	
	public static Test suite() {
		return new TestSuite(SerializationTest.class, "Serialization Tests"); //$NON-NLS-1$
	}
	
	/**
	 * Tests the serialization of an expression that uses no standard library types.
	 */
	public void test_basicSerialization() {
		OCLExpression expr = parseExpression(
				EcorePackage.Literals.EPACKAGE,
				"self.eSuperPackage"); //$NON-NLS-1$

		String toStringForm = expr.toString();
		String serialForm = serialize(expr);
		
		expr = loadExpression(serialForm);
		validate(expr);  // ensure that it is structurally valid
		assertEquals(toStringForm, expr.toString());  // should "look" the same
	}
	
	/**
	 * Tests the serialization of an expression that uses OCL primitive types.
	 */
	public void test_primitiveTypeSerialization() {
		OCLExpression expr = parseExpression(
				EcorePackage.Literals.EPACKAGE,
				"self.eSubpackages->size() > 2"); //$NON-NLS-1$

		String toStringForm = expr.toString();
		String serialForm = serialize(expr);
		
		expr = loadExpression(serialForm);
		validate(expr);  // ensure that it is structurally valid
		assertEquals(toStringForm, expr.toString());  // should "look" the same
	}
	
	/**
	 * Tests the serialization of an expression that uses collections of
	 * primitive types.
	 */
	public void test_primitiveCollectionTypeSerialization() {
		OCLExpression expr = parseExpression(
				EcorePackage.Literals.EPACKAGE,
				"self.eSubpackages->collect(eClassifiers->size())"); //$NON-NLS-1$

		String toStringForm = expr.toString();
		String serialForm = serialize(expr);
		
		expr = loadExpression(serialForm);
		validate(expr);  // ensure that it is structurally valid
		assertEquals(toStringForm, expr.toString());  // should "look" the same
	}
	
	/**
	 * Tests the serialization of an expression that uses collections of
	 * model types.  Incidentally tests variable serialization via a let expression.
	 */
	public void test_modelCollectionTypeSerialization() {
		OCLExpression expr = parseExpression(
				EcorePackage.Literals.EPACKAGE,
				"let subs : Collection(EPackage) = self.eSubpackages in subs->size() > 2"); //$NON-NLS-1$

		String toStringForm = expr.toString();
		String serialForm = serialize(expr);
		
		expr = loadExpression(serialForm);
		validate(expr);  // ensure that it is structurally valid
		assertEquals(toStringForm, expr.toString());  // should "look" the same
	}
	
	/**
	 * Tests the serialization of an expression that references model types in
	 * type expressions.
	 */
	public void test_typeExpSerialization() {
		OCLExpression expr = parseExpression(
				EcorePackage.Literals.EPACKAGE,
				"self.eClassifiers->forAll(c | " + //$NON-NLS-1$
				"c.oclIsKindOf(EClass) implies EClass.allInstances()->includes(c.oclAsType(EClass)))"); //$NON-NLS-1$

		String toStringForm = expr.toString();
		String serialForm = serialize(expr);
		
		expr = loadExpression(serialForm);
		validate(expr);  // ensure that it is structurally valid
		assertEquals(toStringForm, expr.toString());  // should "look" the same
	}
	
	/**
	 * Tests the serialization of an expression containing a tuple literal.
	 */
	public void test_tupleSerialization() {
		OCLExpression expr = parseExpression(
				EcorePackage.Literals.EPACKAGE,
				"self.eSubpackages->collect(" + //$NON-NLS-1$
				"Tuple{pkg = name, size = eClassifiers->size()})"); //$NON-NLS-1$

		String toStringForm = expr.toString();
		String serialForm = serialize(expr);
		
		expr = loadExpression(serialForm);
		validate(expr);  // ensure that it is structurally valid
		assertEquals(toStringForm, expr.toString());  // should "look" the same
	}
	
	/**
	 * Tests the serialization of an expression containing an operation message
	 * expression.
	 */
	public void test_operationMessageSerialization() {
		OCLExpression expr = parseExpression(
				fruit,
				"let msgs : Sequence(OclMessage) = self^^ripen(?) in " + //$NON-NLS-1$
				"msgs->forAll(m | m.hasReturned() implies m.color <> Color::black)"); //$NON-NLS-1$

		String toStringForm = expr.toString();
		String serialForm = serialize(expr);
		
		expr = loadExpression(serialForm);
		validate(expr);  // ensure that it is structurally valid
		assertEquals(toStringForm, expr.toString());  // should "look" the same
	}
	
	/**
	 * Tests the serialization of an expression containing an operation message
	 * expression.
	 */
	public void test_signalMessageSerialization() {
		IOCLHelper helper = HelperUtil.createOCLHelper(
			new MessagesTest.MessagingFruitEnvironmentFactory());
		helper.setContext(fruit);
		
		OCLExpression expr = parseExpression(
				helper,
				"let msgs : Sequence(OclMessage) = self^^Drop(?, ?) in " + //$NON-NLS-1$
				"msgs->forAll(m | m.delay = 0 implies m.stem.oclIsUndefined())"); //$NON-NLS-1$

		String toStringForm = expr.toString();
		String serialForm = serialize(expr);
		
		expr = loadExpression(serialForm);
		validate(expr);  // ensure that it is structurally valid
		assertEquals(toStringForm, expr.toString());  // should "look" the same
	}
	
	/**
	 * Tests the serialization of an expression referencing an additional operation.
	 */
	public void test_additionalOperationSerialization() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.EPACKAGE);
		PersistentEnvironment env = (PersistentEnvironment) helper.getEnvironment();
		
		try {
			EOperation eoper = (EOperation) helper.define(
					"getUniqueClassifierNames() : Set(String) = " + //$NON-NLS-1$
					"self.eClassifiers->collect(name)->asSet()"); //$NON-NLS-1$
			
			env.getTypeResolver().resolveAdditionalOperation(
					EcorePackage.Literals.EPACKAGE, eoper);
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		OCLExpression expr = parseExpression(
				helper,
				"self.getUniqueClassifierNames()->size()"); //$NON-NLS-1$

		String toStringForm = expr.toString();
		String serialForm = serialize(expr);
		
		expr = loadExpression(serialForm);
		TypeUtil.resolveAdditionalFeatures(EcorePackage.Literals.EPACKAGE, env);
		
		validate(expr);  // ensure that it is structurally valid
		assertEquals(toStringForm, expr.toString());  // should "look" the same
	}
	
	/**
	 * Tests the serialization of an expression referencing an additional property.
	 */
	public void test_additionalPropertySerialization() {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(EcorePackage.Literals.EPACKAGE);
		PersistentEnvironment env = (PersistentEnvironment) helper.getEnvironment();
		
		try {
			EStructuralFeature esf = (EStructuralFeature) helper.define(
					"uniqueClassifierNames : Set(String) = " + //$NON-NLS-1$
					"self.eClassifiers->collect(name)->asSet()"); //$NON-NLS-1$
			
			env.getTypeResolver().resolveAdditionalProperty(
					EcorePackage.Literals.EPACKAGE, esf);
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		OCLExpression expr = parseExpression(
				helper,
				"self.uniqueClassifierNames->size()"); //$NON-NLS-1$

		String toStringForm = expr.toString();
		String serialForm = serialize(expr);
		
		expr = loadExpression(serialForm);
		TypeUtil.resolveAdditionalFeatures(EcorePackage.Literals.EPACKAGE, env);
		
		validate(expr);  // ensure that it is structurally valid
		assertEquals(toStringForm, expr.toString());  // should "look" the same
	}
	
	//
	// Framework methods
	//
	
	@Override
    protected void setUp()
		throws Exception {
		
		super.setUp();
		
		rset = new ResourceSetImpl();
		res = new XMIResourceImpl();
		res.setURI(URI.createFileURI("/tmp/ocltest.xmi")); //$NON-NLS-1$
		((XMLResource) res).setEncoding("UTF-8"); //$NON-NLS-1$
		
		rset.getResources().add(res);
		rset.getResources().add(fruitPackage.eResource());
	}
	
	@Override
    protected void tearDown()
		throws Exception {
		
		res.unload();
		res = null;
		
		// let the next test re-initialize the fruit package to eliminate the
		//    Drop signal
		rset.getResources().remove(fruitPackage);
		fruitPackage = null;
		
		rset = null;
		
		super.tearDown();
	}
	
	protected OCLExpression parseExpression(Object context, String expr) {
		IOCLHelper helper = HelperUtil.createOCLHelper();
		helper.setContext(context);
		
		return parseExpression(helper, expr);
	}
	
	protected OCLExpression parseExpression(IOCLHelper helper, String expr) {
		PersistentEnvironment env = (PersistentEnvironment) helper.getEnvironment();
		rset.getResources().add(env.getTypeResolver().getResource());
		
		OCLExpression result = null;
		
		try {
			result = helper.createQuery(expr);
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		assertNotNull(result);
		return result;
	}
	
	protected String serialize(EObject eobject) {
		String result = null;
		
		try {
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			res.getContents().add(eobject);
			res.save(output, Collections.EMPTY_MAP);
			result = output.toString("UTF-8"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Exception serializing AST: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		assertNotNull(result);
		
		return result;
	}
	
	protected EObject deserialize(String serial) {
		EObject result = null;
		
		try {
			ByteArrayInputStream input = new ByteArrayInputStream(serial.getBytes());
			res.unload();
			res.load(input, Collections.EMPTY_MAP);
			
			assertFalse("No contents in serial data", res.getContents().isEmpty()); //$NON-NLS-1$
			assertNoProxies(res);
			
			result = res.getContents().get(0);
		} catch (Exception e) {
			fail("Exception serializing AST: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		assertNotNull(result);
		
		return result;
	}
	
	protected OCLExpression loadExpression(String serial) {
		EObject result = deserialize(serial);
		assertTrue(result instanceof OCLExpression);
		return (OCLExpression) result;
	}
	
	protected Constraint loadConstraint(String serial) {
		EObject result = deserialize(serial);
		assertTrue(result instanceof Constraint);
		return (Constraint) result;
	}
	
	protected void assertNoProxies(Resource res) {
		for (Iterator iter = res.getAllContents(); iter.hasNext();) {
			EObject next = (EObject) iter.next();
			
			for (Iterator cross = next.eCrossReferences().iterator(); cross.hasNext();) {
				EObject xref = (EObject) cross.next();
				
				assertFalse("Unresolved reference: " + xref, xref.eIsProxy()); //$NON-NLS-1$
			}
		}
	}
}
