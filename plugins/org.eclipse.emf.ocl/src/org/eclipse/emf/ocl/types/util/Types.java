/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
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
 * $Id$
 */

package org.eclipse.emf.ocl.types.util;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ocl.parser.EcoreEnvironment;
import org.eclipse.emf.ocl.parser.SemanticException;
import org.eclipse.emf.ocl.types.AnyType;
import org.eclipse.emf.ocl.types.ElementType;
import org.eclipse.emf.ocl.types.InvalidType;
import org.eclipse.emf.ocl.types.MessageType;
import org.eclipse.emf.ocl.types.PrimitiveBoolean;
import org.eclipse.emf.ocl.types.PrimitiveInteger;
import org.eclipse.emf.ocl.types.PrimitiveString;
import org.eclipse.emf.ocl.types.PrimitiveType;
import org.eclipse.emf.ocl.types.TypeType;
import org.eclipse.emf.ocl.types.VoidType;
import org.eclipse.emf.ocl.types.impl.AnyTypeImpl;
import org.eclipse.emf.ocl.types.impl.CollectionTypeImpl;
import org.eclipse.emf.ocl.types.impl.ElementTypeImpl;
import org.eclipse.emf.ocl.types.impl.InvalidTypeImpl;
import org.eclipse.emf.ocl.types.impl.MessageTypeImpl;
import org.eclipse.emf.ocl.types.impl.PrimitiveBooleanImpl;
import org.eclipse.emf.ocl.types.impl.PrimitiveIntegerImpl;
import org.eclipse.emf.ocl.types.impl.PrimitiveRealImpl;
import org.eclipse.emf.ocl.types.impl.PrimitiveStringImpl;
import org.eclipse.emf.ocl.types.impl.TypeTypeImpl;
import org.eclipse.emf.ocl.types.impl.VoidTypeImpl;
import org.eclipse.emf.ocl.utilities.PredefinedType;

/**
 * A collection of global static types.
 */
public class Types {
	/**
	 * The shared type object representing OclVoid (the single instance of
	 * the OclVoidType metatype).
	 */
	public static VoidType OCL_VOID = new VoidTypeImpl("OclVoid"); //$NON-NLS-1$

	/**
	 * The single value of the {@link #OCL_VOID OclVoid} type,
	 * <code>null</code>.
	 */
	public static Object NULL = null;

	/**
	 * The shared type object representing Invalid (the single instance of
	 * the OclInvalidType metatype).
	 */
	public static InvalidType INVALID = new Invalid("Invalid"); //$NON-NLS-1$

	/**
	 * The single value of the {@link #INVALID Invalid} type,
	 * <code>OclInvalid</code>.
	 */
	public static Object OCL_INVALID = InvalidTypeImpl.OCL_INVALID;
	
	/**
	 * Representation of the OclAny type.
	 */
	public static AnyType OCL_ANY_TYPE = AnyTypeImpl.INSTANCE;

	/**
	 * Representation of the OCL predefined Boolean type.
	 */
	public static PrimitiveBoolean OCL_BOOLEAN = PrimitiveBooleanImpl.INSTANCE;

	/**
	 * Representation of the OCL predefined Integer type.
	 */
	public static PrimitiveInteger OCL_INTEGER = PrimitiveIntegerImpl.INSTANCE;

	/**
	 * Representation of the OCL predefined Real type.
	 */
	public static PrimitiveType OCL_REAL = PrimitiveRealImpl.INSTANCE;

	/**
	 * Representation of the OCL predefined String type.
	 */
	public static PrimitiveString OCL_STRING = PrimitiveStringImpl.INSTANCE;

	/**
	 * Representation of the OCL predefined OclType type.
	 */
	public static final TypeType OCL_TYPE = TypeTypeImpl.INSTANCE;

	/**
	 * Representation of the OCL predefined OclMessage type.
	 */
	public static final MessageType OCL_MESSAGE = MessageTypeImpl.INSTANCE;

	/**
	 * Representation of the OCL predefined OclElement type.
	 */
	public static final ElementType OCL_ELEMENT = ElementTypeImpl.INSTANCE;
	
	/**
	 * Representation of the OCL/UML predefined State type.
	 */
	public static final EClass STATE = ElementTypeImpl.STATE_INSTANCE;

	private static EPackage standardLibrary;
	
	private Types() {
		super();
	}
	
	public static EPackage init() {
		if (standardLibrary != null) {
			return standardLibrary;
		}
		
		standardLibrary = new EPackageImpl() {
			public String eURIFragmentSegment(EStructuralFeature eStructuralFeature, EObject eObject) {
				String result = super.eURIFragmentSegment(eStructuralFeature, eObject);
				return URI.encodeFragment(result, false);
			}};
		standardLibrary.setName("oclstdlib"); //$NON-NLS-1$
		standardLibrary.setNsPrefix("oclstdlib"); //$NON-NLS-1$
		standardLibrary.setNsURI("http://www.eclipse.org/OCL2/1.0.0/oclstdlib"); //$NON-NLS-1$
		
		Resource res = new ResourceImpl(URI.createURI(standardLibrary.getNsURI())){
			public EObject getEObject(String uriFragment) {
				// our stdlib package implementation encodes type names because
				//    they may contain spaces or other bad characters
				return super.getEObject(URI.decode(uriFragment));
			}};
		res.getContents().add(standardLibrary);
		
		register(OCL_ANY_TYPE);
		register(OCL_VOID);
		register(INVALID);
		register(OCL_BOOLEAN);
		register(OCL_INTEGER);
		register(OCL_REAL);
		register(OCL_STRING);
		register(OCL_TYPE);
		register(OCL_MESSAGE);
		register(OCL_ELEMENT);
		register(STATE);
		
		register(CollectionTypeImpl.OCL_COLLECTION);
		register(CollectionTypeImpl.OCL_SET);
		register(CollectionTypeImpl.OCL_ORDERED_SET);
		register(CollectionTypeImpl.OCL_BAG);
		register(CollectionTypeImpl.OCL_SEQUENCE);
		
		register(AnyTypeImpl.OCL_T);
		register(AnyTypeImpl.OCL_T2);
		
		EPackage.Registry.INSTANCE.put(standardLibrary.getNsURI(), standardLibrary);
		
		// ensure that the environment resource is registered on the oclenv: protocol
		new EcoreEnvironment(standardLibrary);
		
		return standardLibrary;
	}
	
	private static void register(EClassifier stdType) {
		// add the type to the standard library package
		standardLibrary.getEClassifiers().add(stdType);
		
		if (stdType instanceof PredefinedType) {
			EClass eclass;
			
			if (stdType instanceof EClass) {
				// this type can store its own operations
				eclass = (EClass) stdType;
			} else {
				// create the shadow class to store the operations
				eclass = new EClassImpl() {
					public String eURIFragmentSegment(EStructuralFeature eStructuralFeature, EObject eObject) {
						String result = super.eURIFragmentSegment(eStructuralFeature, eObject);
						return URI.encodeFragment(result, false);
					}};
			}
			
			eclass.setName(stdType.getName() + "_Class"); //$NON-NLS-1$
			eclass.getEOperations().addAll(((PredefinedType) stdType).getOperations());
			standardLibrary.getEClassifiers().add(eclass);
		}
	}
	
	private static class Invalid extends EClassImpl implements EDataType, EEnum, InvalidType {
		private final InvalidType delegate;
		
		Invalid(String name) {
			super();
			setName(name);
			delegate = new InvalidTypeImpl(name);
		}
		
		public boolean isSerializable() {
			return false;
		}

		public void setSerializable(boolean value) {
			// do nothing
		}

		public EList getELiterals() {
			return ECollections.EMPTY_ELIST;
		}

		public EEnumLiteral getEEnumLiteral(String name) {
			return null;
		}

		public EEnumLiteral getEEnumLiteral(int value) {
			return null;
		}

		public EEnumLiteral getEEnumLiteralByLiteral(String literal) {
			return null;
		}

		public EList getOperations() {
			return delegate.getOperations();
		}

		public String getOperationNameFor(int code) {
			return delegate.getOperationNameFor(code);
		}

		public int getOperationCodeFor(String operName) {
			return delegate.getOperationCodeFor(operName);
		}

		public EClassifier getResultTypeFor(EClassifier ownerType, int opcode, EList args) throws SemanticException {
			return delegate.getResultTypeFor(ownerType, opcode, args);
		}

		public int getRelationshipTo(EClassifier type) {
			return delegate.getRelationshipTo(type);
		}

		public EClassifier getCommonSupertype(EClassifier type) throws SemanticException {
			return delegate.getCommonSupertype(type);
		}
		
	}
}
