/**
 * <copyright>
 * 
 * Copyright (c) 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: TypesValidatorTest.java,v 1.1 2008/05/05 16:47:39 cdamus Exp $
 */

package org.eclipse.ocl.uml.tests;

import java.util.Map;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.types.util.TypesValidator;
import org.eclipse.ocl.uml.CollectionType;
import org.eclipse.ocl.uml.UMLFactory;


/**
 * Tests the generated validator constraints for the Types package.
 *
 * @author Christian W. Damus (cdamus)
 */
public class TypesValidatorTest extends AbstractTestSuite {

	private UMLFactory factory = UMLFactory.eINSTANCE;
	
	public TypesValidatorTest(String name) {
		super(name);
	}

	public static Test suite() {
		return new TestSuite(TypesValidatorTest.class,
			"Types Validator Tests"); //$NON-NLS-1$
	}
	
	public void test_CollectionType_checkCollectionTypeName() {
		CollectionType type = factory.createCollectionType();
		type.setElementType(fruit);
		
		assertOK(type, TypesValidator.COLLECTION_TYPE__COLLECTION_TYPE_NAME);
		
		type.setName("Collection(Integer)"); //$NON-NLS-1$
		
		assertProblem(type, TypesValidator.COLLECTION_TYPE__COLLECTION_TYPE_NAME);
		
		type.setName("Sequence(Fruit)"); //$NON-NLS-1$
		
		assertProblem(type, TypesValidator.COLLECTION_TYPE__COLLECTION_TYPE_NAME);
	}
	
	public void test_BagType_checkCollectionTypeName() {
		CollectionType type = factory.createBagType();
		type.setElementType(fruit);
		
		assertOK(type, TypesValidator.BAG_TYPE__COLLECTION_TYPE_NAME);
		
		type.setName("Bag(Integer)"); //$NON-NLS-1$
		
		assertProblem(type, TypesValidator.BAG_TYPE__COLLECTION_TYPE_NAME);
		
		type.setName("Collection(Fruit)"); //$NON-NLS-1$
		
		assertProblem(type, TypesValidator.BAG_TYPE__COLLECTION_TYPE_NAME);
	}
	
	public void test_SetType_checkCollectionTypeName() {
		CollectionType type = factory.createSetType();
		type.setElementType(fruit);
		
		assertOK(type, TypesValidator.SET_TYPE__COLLECTION_TYPE_NAME);
		
		type.setName("Set(Integer)"); //$NON-NLS-1$
		
		assertProblem(type, TypesValidator.SET_TYPE__COLLECTION_TYPE_NAME);
		
		type.setName("Collection(Fruit)"); //$NON-NLS-1$
		
		assertProblem(type, TypesValidator.SET_TYPE__COLLECTION_TYPE_NAME);
	}
	
	public void test_SequenceType_checkCollectionTypeName() {
		CollectionType type = factory.createSequenceType();
		type.setElementType(fruit);
		
		assertOK(type, TypesValidator.SEQUENCE_TYPE__COLLECTION_TYPE_NAME);
		
		type.setName("Sequence(Integer)"); //$NON-NLS-1$
		
		assertProblem(type, TypesValidator.SEQUENCE_TYPE__COLLECTION_TYPE_NAME);
		
		type.setName("Collection(Fruit)"); //$NON-NLS-1$
		
		assertProblem(type, TypesValidator.SEQUENCE_TYPE__COLLECTION_TYPE_NAME);
	}
	
	public void test_OrderedSetType_checkCollectionTypeName() {
		CollectionType type = factory.createOrderedSetType();
		type.setElementType(fruit);
		
		assertOK(type, TypesValidator.ORDERED_SET_TYPE__COLLECTION_TYPE_NAME);
		
		type.setName("OrderedSet(Integer)"); //$NON-NLS-1$
		
		assertProblem(type, TypesValidator.ORDERED_SET_TYPE__COLLECTION_TYPE_NAME);
		
		type.setName("Collection(Fruit)"); //$NON-NLS-1$
		
		assertProblem(type, TypesValidator.ORDERED_SET_TYPE__COLLECTION_TYPE_NAME);
	}

	//
	// Fixture methods
	//
	
	protected Diagnostic validate(EObject target) {
		Map<Object, Object> ctx = new java.util.HashMap<Object, Object>();
		ctx.put(Environment.class, ocl.getEnvironment());
		return Diagnostician.INSTANCE.validate(target, ctx);
	}
	
	protected void assertProblem(EObject target, int code) {
		assertProblem(validate(target), target, code);
	}
	
	protected void assertProblem(Diagnostic diagnostic, EObject target, int code) {
		Diagnostic problem = findProblem(diagnostic, target, code);
		assertNotNull("Problem not found", problem); //$NON-NLS-1$
		System.out.println("Found expected problem: " + problem.getMessage()); //$NON-NLS-1$
	}
	
	protected Diagnostic findProblem(Diagnostic diagnostic, EObject target, int code) {
		if (TypesValidator.DIAGNOSTIC_SOURCE.equals(diagnostic
				.getSource())
				&& (diagnostic.getSeverity() != Diagnostic.OK)
				&& diagnostic.getData().contains(target)
				&& (diagnostic.getCode() == code)) {
			return diagnostic;
		}
		
		for (Diagnostic child : diagnostic.getChildren()) {
			Diagnostic result = findProblem(child, target, code);
			
			if (result != null) {
				return result;
			}
		}
		
		return null;
	}
	
	protected Diagnostic findProblem(Diagnostic diagnostic, EObject target) {
		if (TypesValidator.DIAGNOSTIC_SOURCE.equals(diagnostic
				.getSource())
				&& (diagnostic.getSeverity() != Diagnostic.OK)
				&& diagnostic.getData().contains(target)) {
			return diagnostic;
		}
		
		for (Diagnostic child : diagnostic.getChildren()) {
			Diagnostic result = findProblem(child, target);
			
			if (result != null) {
				return result;
			}
		}
		
		return null;
	}
	
	protected void assertOK(EObject target, int code) {
		assertOK(validate(target), target, code);
	}
	
	protected void assertOK(Diagnostic diagnostic, EObject target, int code) {
		assertNull("Problem found", findProblem(diagnostic, target, code)); //$NON-NLS-1$
	}
	
	protected void assertOK(EObject target) {
		assertOK(validate(target), target);
	}
	
	protected void assertOK(Diagnostic diagnostic, EObject target) {
		assertNull("Problem found", findProblem(diagnostic, target)); //$NON-NLS-1$
	}
}
