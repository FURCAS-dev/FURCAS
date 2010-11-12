/**
 * <copyright>
 *
 * Copyright (c) 2009 Open Canarias S.L. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     A. Sanchez-Barbudo Herrera - initial API and implementation
 *
 * </copyright>
 *
 * $Id: EcoreOCLStandardLibrary.java,v 1.3 2010/04/08 06:27:21 ewillink Exp $
 */
package org.eclipse.ocl.ecore;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.ecore.internal.OCLStandardLibraryImpl;
import org.eclipse.ocl.types.OCLStandardLibrary;

/**
 * <p>
 * An extensible implementation of the {@link OCLStandardLibrary} which provides the 
 * OCL Standard Library predefined M1 types and the associated operations related to them.
 * </p> 
 * 
 * <p>
 * The Ecore-based OCL Standard library represents an {@link EPackage} which owns all the predefined
 * OCL types defined by the specification. The library itself is built by the the internal internal 
 * {@link OCLStandardLibraryImpl} singleton. 
 * </p> 
 * 
 * @see OCLStandardLibraryImpl
 * @author Adolfo Sanchez-Barbudo Herrera (adolfosbh)
 * @since 1.3
 */
public class EcoreOCLStandardLibrary implements OCLStandardLibrary<EClassifier>{

	/**
	 * The OCL Standard library builder.
	 */
	private final static OCLStandardLibraryImpl stdLibBuilder = OCLStandardLibraryImpl.INSTANCE;
	
	public EcoreOCLStandardLibrary() {
		super();
	}
	
	public EClassifier getBag() {		
		return stdLibBuilder.getBag();
	}

	public EClassifier getBoolean() {
		return stdLibBuilder.getBoolean();
	}

	public EClassifier getCollection() {		
		return stdLibBuilder.getCollection();
	}

	public EClassifier getInteger() { 
		return stdLibBuilder.getInteger();
	}

	/**
	 * @since 3.0
	 */
	public EClassifier getOclInvalid() {		
		return stdLibBuilder.getOclInvalid();
	}

	public EClassifier getOclAny() {		
		return stdLibBuilder.getOclAny();
	}

	public EClassifier getOclElement() {
		return stdLibBuilder.getOclElement();
	}

	public EClassifier getOclExpression() {
		return stdLibBuilder.getOclExpression();
	}

	public Object getInvalid() {		
		return stdLibBuilder.getInvalid();
	}

	public EClassifier getOclMessage() {		
		return stdLibBuilder.getOclMessage();
	}

	public EClassifier getOclType() {
		return stdLibBuilder.getOclType();
	}

	public EClassifier getOclVoid() {
		return stdLibBuilder.getOclVoid();
	}

	public EClassifier getOrderedSet() {
		return stdLibBuilder.getOrderedSet();
	}

	public EClassifier getReal() { 
		return stdLibBuilder.getReal();
	}

	public EClassifier getSequence() {
		return stdLibBuilder.getSequence();
	}

	public EClassifier getSet() {		
		return stdLibBuilder.getSet();
	}

	public EClassifier getState() {	
		return stdLibBuilder.getState();
	}

	public EClassifier getString() {
		return stdLibBuilder.getString();
	}

	public EClassifier getT() {
		return stdLibBuilder.getT();
	}

	public EClassifier getT2() {
		return stdLibBuilder.getT2();
	}

	public EClassifier getUnlimitedNatural() {
		return stdLibBuilder.getUnlimitedNatural();
	}
	
	/**
	 * @return the {@link EPackage} which contains the OCL predefined types.
	 */
	public EPackage getOCLStdLibPackage() {
		return OCLStandardLibraryImpl.stdlibPackage;
	}
}