/**
 * <copyright>
 * 
 * Copyright (c) 2008 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 241426
 *
 * </copyright>
 *
 * $Id: TypesValidatorTest.java,v 1.7 2009/11/28 17:52:46 ewillink Exp $
 */

package org.eclipse.ocl.ecore.tests;

import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreValidator;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.types.util.TypesValidator;


/**
 * Tests the generated validator constraints for the Types package.
 *
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class TypesValidatorTest extends AbstractTestSuite {

	private final EcoreFactory factory = EcoreFactory.eINSTANCE;
	
	public void test_CollectionType_checkCollectionTypeName() {
		CollectionType type = factory.createCollectionType();
		type.setElementType(fruit);
		
		assertOK(type, TypesValidator.COLLECTION_TYPE__COLLECTION_TYPE_NAME);
		
		type.setName("Collection(Integer)");
		
		assertProblem(type, TypesValidator.COLLECTION_TYPE__COLLECTION_TYPE_NAME);
		
		type.setName("Sequence(Fruit)");
		
		assertProblem(type, TypesValidator.COLLECTION_TYPE__COLLECTION_TYPE_NAME);
		
		assertOK(getOCLStandardLibrary().getCollection(), TypesValidator.COLLECTION_TYPE__COLLECTION_TYPE_NAME);
	}
	
	public void test_BagType_checkCollectionTypeName() {
		CollectionType type = factory.createBagType();
		type.setElementType(fruit);
		
		assertOK(type, TypesValidator.BAG_TYPE__COLLECTION_TYPE_NAME);
		
		type.setName("Bag(Integer)");
		
		assertProblem(type, TypesValidator.BAG_TYPE__COLLECTION_TYPE_NAME);
		
		type.setName("Collection(Fruit)");
		
		assertProblem(type, TypesValidator.BAG_TYPE__COLLECTION_TYPE_NAME);
		
		assertOK(getOCLStandardLibrary().getBag(), TypesValidator.BAG_TYPE__COLLECTION_TYPE_NAME);
	}
	
	public void test_SetType_checkCollectionTypeName() {
		CollectionType type = factory.createSetType();
		type.setElementType(fruit);
		
		assertOK(type, TypesValidator.SET_TYPE__COLLECTION_TYPE_NAME);
		
		type.setName("Set(Integer)");
		
		assertProblem(type, TypesValidator.SET_TYPE__COLLECTION_TYPE_NAME);
		
		type.setName("Collection(Fruit)");
		
		assertProblem(type, TypesValidator.SET_TYPE__COLLECTION_TYPE_NAME);
		
		assertOK(getOCLStandardLibrary().getSet(), TypesValidator.SET_TYPE__COLLECTION_TYPE_NAME);
	}
	
	public void test_SequenceType_checkCollectionTypeName() {
		CollectionType type = factory.createSequenceType();
		type.setElementType(fruit);
		
		assertOK(type, TypesValidator.SEQUENCE_TYPE__COLLECTION_TYPE_NAME);
		
		type.setName("Sequence(Integer)");
		
		assertProblem(type, TypesValidator.SEQUENCE_TYPE__COLLECTION_TYPE_NAME);
		
		type.setName("Collection(Fruit)");
		
		assertProblem(type, TypesValidator.SEQUENCE_TYPE__COLLECTION_TYPE_NAME);
		
		assertOK(getOCLStandardLibrary().getSequence(), TypesValidator.SEQUENCE_TYPE__COLLECTION_TYPE_NAME);
	}
	
	public void test_OrderedSetType_checkCollectionTypeName() {
		CollectionType type = factory.createOrderedSetType();
		type.setElementType(fruit);
		
		assertOK(type, TypesValidator.ORDERED_SET_TYPE__COLLECTION_TYPE_NAME);
		
		type.setName("OrderedSet(Integer)");
		
		assertProblem(type, TypesValidator.ORDERED_SET_TYPE__COLLECTION_TYPE_NAME);
		
		type.setName("Collection(Fruit)");
		
		assertProblem(type, TypesValidator.ORDERED_SET_TYPE__COLLECTION_TYPE_NAME);
		
		assertOK(getOCLStandardLibrary().getOrderedSet(), TypesValidator.ORDERED_SET_TYPE__COLLECTION_TYPE_NAME);
	}
	
	/**
	 * Test that the default name of the collection type of an empty collection
	 * shows <tt>OclVoid</tt> as the element type.
	 */
	public void test_emptyCollectionType_196972() {
		// load our test resource
		URI uri = getTestModelURI("/model/VoidCollectionTypes.ecore");
		Resource res = resourceSet.getResource(uri, true);
		EPackage epackage = (EPackage) res.getContents().get(0);
		
		// this one is ill-named
		CollectionType setType = (CollectionType) epackage.getEClassifier("Set(T)");
		assertSame(getOCLStandardLibrary().getOclVoid(), setType.getElementType());
		assertProblem(setType, TypesValidator.SET_TYPE__COLLECTION_TYPE_NAME);
		
		// this one is well-named
		CollectionType bagType = (CollectionType) epackage.getEClassifier("Bag(OclVoid)");
		assertSame(getOCLStandardLibrary().getOclVoid(), bagType.getElementType());
		assertOK(setType, TypesValidator.BAG_TYPE__COLLECTION_TYPE_NAME);
		
		// create a new void collection type
		CollectionType collectionType = factory.createCollectionType();
		collectionType.setElementType(getOCLStandardLibrary().getOclVoid());
		assertOK(collectionType, TypesValidator.COLLECTION_TYPE__COLLECTION_TYPE_NAME);
		setType = factory.createSetType();
		setType.setElementType(getOCLStandardLibrary().getOclVoid());
		assertOK(setType, TypesValidator.SET_TYPE__COLLECTION_TYPE_NAME);
		CollectionType orderedSetType = factory.createOrderedSetType();
		orderedSetType.setElementType(getOCLStandardLibrary().getOclVoid());
		assertOK(orderedSetType, TypesValidator.ORDERED_SET_TYPE__COLLECTION_TYPE_NAME);
		bagType = factory.createBagType();
		bagType.setElementType(getOCLStandardLibrary().getOclVoid());
		assertOK(bagType, TypesValidator.BAG_TYPE__COLLECTION_TYPE_NAME);
		CollectionType sequenceType = factory.createSequenceType();
		sequenceType.setElementType(getOCLStandardLibrary().getOclVoid());
		assertOK(sequenceType, TypesValidator.SEQUENCE_TYPE__COLLECTION_TYPE_NAME);
	}
	
	/**
	 * Tests that the well-formed name constraint from Ecore is
	 * disinherited for OCL types.
	 */
	public void test_wellFormedName() {
		// collection types don't have Ecore-ish names
		assertWellFormedName(oclFactory.createCollectionType(fruit));
		assertWellFormedName(oclFactory.createSetType(fruit));
		assertWellFormedName(oclFactory.createOrderedSetType(fruit));
		assertWellFormedName(oclFactory.createBagType(fruit));
		assertWellFormedName(oclFactory.createSequenceType(fruit));

		// neither do some other demand-created types
		Variable<EClassifier, EParameter> v = oclFactory.createVariable();
		v.setName("a");
		v.setType(fruit);
		assertWellFormedName(oclFactory.createTupleType(Collections
			.singletonList(v)));
		assertWellFormedName(oclFactory.createOperationMessageType(fruit_ripen));
		assertWellFormedName(oclFactory.createTypeType(fruit));
	}
	
	private void assertWellFormedName(EObject type) {
		assertOK(type, EcoreValidator.WELL_FORMED_NAME,
			EcoreValidator.DIAGNOSTIC_SOURCE);
	}
	
	/**
	 * Tests that the well-formed instance type name constraint from Ecore is
	 * disinherited for OCL types.
	 */
	public void test_wellFormedInstanceTypeName_241426() {
		assertWellFormedInstanceTypeName(oclFactory.createCollectionType(fruit));
		assertWellFormedInstanceTypeName(oclFactory.createSetType(fruit));
		assertWellFormedInstanceTypeName(oclFactory.createOrderedSetType(fruit));
		assertWellFormedInstanceTypeName(oclFactory.createBagType(fruit));
		assertWellFormedInstanceTypeName(oclFactory.createSequenceType(fruit));

		// neither do some other demand-created types
		Variable<EClassifier, EParameter> v = oclFactory.createVariable();
		v.setName("a");
		v.setType(fruit);
		assertWellFormedInstanceTypeName(oclFactory.createTupleType(Collections
			.singletonList(v)));
		assertWellFormedInstanceTypeName(oclFactory.createOperationMessageType(fruit_ripen));
		assertWellFormedInstanceTypeName(oclFactory.createTypeType(fruit));
	}
	
	private void assertWellFormedInstanceTypeName(EObject type) {
		assertOK(type, EcoreValidator.WELL_FORMED_INSTANCE_TYPE_NAME,
			EcoreValidator.DIAGNOSTIC_SOURCE);
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
		assertNotNull("Problem not found", problem);
		System.out.println("Found expected problem: " + problem.getMessage());
	}
	
	protected Diagnostic findProblem(Diagnostic diagnostic, EObject target,
			int code, String source) {
		
		if (source.equals(diagnostic
				.getSource())
				&& (diagnostic.getSeverity() != Diagnostic.OK)
				&& diagnostic.getData().contains(target)
				&& (diagnostic.getCode() == code)) {
			return diagnostic;
		}
		
		for (Diagnostic child : diagnostic.getChildren()) {
			Diagnostic result = findProblem(child, target, code, source);
			
			if (result != null) {
				return result;
			}
		}
		
		return null;
	}
	
	protected Diagnostic findProblem(Diagnostic diagnostic, EObject target, int code) {
		return findProblem(diagnostic, target, code, TypesValidator.DIAGNOSTIC_SOURCE);
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
	
	protected void assertOK(EObject target, int code, String source) {
		assertOK(validate(target), target, code, source);
	}
	
	protected void assertOK(Diagnostic diagnostic, EObject target, int code) {
		assertNull("Problem found", findProblem(diagnostic, target, code));
	}
	
	protected void assertOK(Diagnostic diagnostic, EObject target, int code,
			String source) {
		
		assertNull(
			"Problem found", findProblem(diagnostic, target, code, source));
	}
	
	protected void assertOK(EObject target) {
		assertOK(validate(target), target);
	}
	
	protected void assertOK(Diagnostic diagnostic, EObject target) {
		assertNull("Problem found", findProblem(diagnostic, target));
	}
}
