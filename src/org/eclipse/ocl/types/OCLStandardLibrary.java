/**
 * <copyright> 
 *
 * Copyright (c) 2006, 2007 IBM Corporation and others.
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
 * $Id: OCLStandardLibrary.java,v 1.2 2007/05/17 17:06:22 cdamus Exp $
 */
package org.eclipse.ocl.types;

import org.eclipse.ocl.Environment;



/**
 * A representation of the OCL Standard Library, which is the set of singleton
 * instances of the OCL-defined metatypes, including the generic collection
 * types (e.g., <tt>Set(T)</tt>).
 * <p>
 * See the {@link Environment} class for a description of the
 * generic type parameters of this class. 
 * </p>
 * 
 * @author Christian W. Damus (cdamus)
 */
public interface OCLStandardLibrary<C> {
	
    /**
     * Obtains the single instance of the {@link AnyType} metatype, named
     * <tt>OclAny</tt>.
     * 
     * @return the <tt>OclAny</tt> type (an instance of {@link AnyType})
     */
	C getOclAny();
	
    /**
     * Obtains the single instance of the {@link VoidType} metatype, named
     * <tt>OclVoid</tt>.
     * 
     * @return the <tt>OclVoid</tt> type (an instance of {@link VoidType})
     */
	C getOclVoid();
	
    /**
     * Obtains the single instance of the {@link InvalidType} metatype, named
     * <tt>Invalid</tt>.
     * 
     * @return the <tt>Invalid</tt> type (an instance of {@link InvalidType})
     */
	C getInvalid();
	
    /**
     * Obtains the single instance of the {@link #getInvalid() Invalid} type,
     * identified by the token <tt>OclInvalid</tt>.
     * 
     * @return the <tt>OclInvalid</tt> instance
     *     (an instance of {@link #getInvalid() Invalid})
     */
	Object getOclInvalid();
	
    /**
     * Obtains the instance of the {@link PrimitiveType} metatype, named
     * <tt>Boolean</tt>.
     * 
     * @return the <tt>Boolean</tt> type (an instance of {@link PrimitiveType})
     */
	C getBoolean();
	
    /**
     * Obtains the instance of the {@link PrimitiveType} metatype, named
     * <tt>String</tt>.
     * 
     * @return the <tt>String</tt> type (an instance of {@link PrimitiveType})
     */
	C getString();
	
    /**
     * Obtains the instance of the {@link PrimitiveType} metatype, named
     * <tt>Real</tt>.
     * 
     * @return the <tt>Real</tt> type (an instance of {@link PrimitiveType})
     */
	C getReal();
	
    /**
     * Obtains the instance of the {@link PrimitiveType} metatype, named
     * <tt>Integer</tt>.
     * 
     * @return the <tt>Integer</tt> type (an instance of {@link PrimitiveType})
     */
	C getInteger();
    
    /**
     * Obtains the instance of the {@link PrimitiveType} metatype,
     * named <tt>UnlimitedNatural</tt>.
     * 
     * @return the <tt>UnlimitedNatural</tt> type (an instance of
     *     {@link PrimitiveType})
     */
    C getUnlimitedNatural();
	
    /**
     * Obtains the generic instance of the {@link TypeType} metatype, named
     * <tt>OclType</tt>.
     * 
     * @return the <tt>OclType</tt> type (an instance of {@link TypeType})
     */
	C getOclType();
	
    /**
     * Obtains the generic instance of the {@link ElementType} metatype, named
     * <tt>OclElement</tt>.
     * 
     * @return the <tt>OclElement</tt> type (an instance of {@link ElementType})
     */
	C getOclElement();
	
    /**
     * Obtains the generic instance of the {@link MessageType} metatype, named
     * <tt>OclMessage</tt>.
     * 
     * @return the <tt>OclMessage</tt> type (an instance of {@link MessageType})
     */
	C getOclMessage();
	
    /**
     * Obtains the generic instance of the {@link SetType} metatype, named
     * <tt>Set(T)</tt>.
     * 
     * @return the <tt>Set(T)</tt> type (an instance of {@link SetType})
     */
	C getSet();
	
    /**
     * Obtains the generic instance of the {@link OrderedSetType} metatype, named
     * <tt>OrderedSet(T)</tt>.
     * 
     * @return the <tt>OrderedSet(T)</tt> type (an instance of {@link OrderedSetType})
     */
	C getOrderedSet();
	
    /**
     * Obtains the generic instance of the {@link BagType} metatype, named
     * <tt>Bag(T)</tt>.
     * 
     * @return the <tt>Bag(T)</tt> type (an instance of {@link BagType})
     */
	C getBag();
	
    /**
     * Obtains the generic instance of the {@link SequenceType} metatype, named
     * <tt>Sequence(T)</tt>.
     * 
     * @return the <tt>Sequence(T)</tt> type (an instance of {@link SequenceType})
     */
	C getSequence();
	
    /**
     * Obtains the generic instance of the {@link CollectionType} metatype, named
     * <tt>Collection(T)</tt>.
     * 
     * @return the <tt>Collection(T)</tt> type (an instance of {@link CollectionType})
     */
	C getCollection();
    
    /**
     * Obtains the instance of the {@link ElementType} metatype that represents
     * the type of states in the model, named <tt>State</tt>.
     * 
     * @return the <tt>State</tt> type (an instance of {@link ElementType})
     */
    C getState();
    
    /**
     * Obtains the instance of the {@link ElementType} metatype that represents
     * the type of OCL expressions in the model, named <tt>OclExpression</tt>.
     * 
     * @return the <tt>OclExpression</tt> type (an instance of {@link ElementType})
     */
    C getOclExpression();
    
    /**
     * Obtains a generic instance of the {@link AnyType} metatype that represents
     * the type parameter of generic types and operations, named <tt>T</tt>.
     * 
     * @return the <tt>T</tt> type parameter (an instance of {@link AnyType})
     */
    C getT();
    
    /**
     * Obtains a generic instance of the {@link AnyType} metatype that represents
     * another type parameter of generic operations (particularly certain
     * OCL {@link #getCollection() Collection} operations), named <tt>T2</tt>.
     * 
     * @return the <tt>T2</tt> type parameter (an instance of {@link AnyType})
     */
    C getT2();
}
