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

import org.eclipse.emf.ecore.EClass;
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
import org.eclipse.emf.ocl.types.impl.ElementTypeImpl;
import org.eclipse.emf.ocl.types.impl.InvalidTypeImpl;
import org.eclipse.emf.ocl.types.impl.MessageTypeImpl;
import org.eclipse.emf.ocl.types.impl.PrimitiveBooleanImpl;
import org.eclipse.emf.ocl.types.impl.PrimitiveIntegerImpl;
import org.eclipse.emf.ocl.types.impl.PrimitiveRealImpl;
import org.eclipse.emf.ocl.types.impl.PrimitiveStringImpl;
import org.eclipse.emf.ocl.types.impl.TypeTypeImpl;
import org.eclipse.emf.ocl.types.impl.VoidTypeImpl;

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
	 * The shared type object representing Invalid (the single instance of
	 * the OclInvalidType metatype).
	 */
	public static InvalidType INVALID = new InvalidTypeImpl("Invalid"); //$NON-NLS-1$

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

	private Types() {
		super();
	}
}
