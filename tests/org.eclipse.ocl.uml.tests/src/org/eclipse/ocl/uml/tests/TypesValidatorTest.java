/**
 * <copyright>
 * 
 * Copyright (c) 2008 IBM Corporation, Zeligsoft Inc. and others.
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
 * $Id: TypesValidatorTest.java,v 1.4 2009/10/07 20:41:46 ewillink Exp $
 */

package org.eclipse.ocl.uml.tests;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.types.util.TypesValidator;
import org.eclipse.ocl.uml.CollectionType;
import org.eclipse.ocl.uml.UMLFactory;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Package;


/**
 * Tests the generated validator constraints for the Types package.
 *
 * @author Christian W. Damus (cdamus)
 */
public class TypesValidatorTest extends AbstractTestSuite {

	UMLFactory factory = UMLFactory.eINSTANCE;
	
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
	
	/**
	 * Test that the default name of the collection type of an empty collection
	 * shows <tt>OclVoid</tt> as the element type.
	 */
	public void test_emptyCollectionType_196972() {
		// load our test resource
		URI uri = getTestModelURI("/model/VoidCollectionTypes.uml"); //$NON-NLS-1$
		Resource res = resourceSet.getResource(uri, true);
		Package epackage = (Package) res.getContents().get(0);
		
		// this one is ill-named
		CollectionType setType = (CollectionType) epackage.getOwnedType("Set(T)"); //$NON-NLS-1$
		Classifier oclVoid = getOCLStandardLibrary().getOclVoid();
		Classifier elementType = setType.getElementType();
		assertSame(oclVoid, elementType);
		assertProblem(setType, TypesValidator.SET_TYPE__COLLECTION_TYPE_NAME);
		
		// this one is well-named
		CollectionType bagType = (CollectionType) epackage.getOwnedType("Bag(OclVoid)"); //$NON-NLS-1$
		assertSame(oclVoid, bagType.getElementType());
		assertOK(setType, TypesValidator.BAG_TYPE__COLLECTION_TYPE_NAME);
		
		// create a new void collection type
		CollectionType collectionType = factory.createCollectionType();
		collectionType.setElementType(oclVoid);
		assertOK(collectionType, TypesValidator.COLLECTION_TYPE__COLLECTION_TYPE_NAME);
		setType = factory.createSetType();
		setType.setElementType(oclVoid);
		assertOK(setType, TypesValidator.SET_TYPE__COLLECTION_TYPE_NAME);
		CollectionType orderedSetType = factory.createOrderedSetType();
		orderedSetType.setElementType(oclVoid);
		assertOK(orderedSetType, TypesValidator.ORDERED_SET_TYPE__COLLECTION_TYPE_NAME);
		bagType = factory.createBagType();
		bagType.setElementType(oclVoid);
		assertOK(bagType, TypesValidator.BAG_TYPE__COLLECTION_TYPE_NAME);
		CollectionType sequenceType = factory.createSequenceType();
		sequenceType.setElementType(oclVoid);
		assertOK(sequenceType, TypesValidator.SEQUENCE_TYPE__COLLECTION_TYPE_NAME);
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
