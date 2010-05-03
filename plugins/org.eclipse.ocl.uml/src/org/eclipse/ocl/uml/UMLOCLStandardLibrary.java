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
 * $Id: UMLOCLStandardLibrary.java,v 1.4 2010/05/03 09:32:43 ewillink Exp $
 */
package org.eclipse.ocl.uml;

import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.uml.internal.OCLStandardLibraryImpl;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Package;

/**
 * <p>
 * An extensible implementation of the {@link OCLStandardLibrary} which provides the 
 * OCL Standard Library predefined M1 types and the associated operations related to them.
 * </p>
 * 
 * <p>
 * The UML-based OCL standard library represents a {@link Package} which owns all the predefined
 * OCL types defined by the specification. The library itself is built by the the internal internal 
 * {@link OCLStandardLibraryImpl} singleton. 
 * </p> 
 * 
 * @see OCLStandardLibraryImpl
 * @author Adolfo Sanchez-Barbudo Herrera (adolfosbh)
 * @since 2.0
 */
public class UMLOCLStandardLibrary implements OCLStandardLibrary<Classifier>{

	/**
	 * The OCL Standard library builder.
	 */
	private final static OCLStandardLibraryImpl stdLibBuilder = OCLStandardLibraryImpl.INSTANCE;
	
	public UMLOCLStandardLibrary() {
		super();
	}
	
	public Classifier getBag() {		
		return stdLibBuilder.getBag();
	}

	public Classifier getBoolean() {
		return stdLibBuilder.getBoolean();
	}

	public Classifier getCollection() {		
		return stdLibBuilder.getCollection();
	}

	public Classifier getInteger() { 
		return stdLibBuilder.getInteger();
	}

	/**
	 * @since 3.0
	 */
	public Classifier getOclInvalid() {		
		return stdLibBuilder.getOclInvalid();
	}

	public Classifier getOclAny() {		
		return stdLibBuilder.getOclAny();
	}

	public Classifier getOclElement() {
		return stdLibBuilder.getOclElement();
	}

	public Classifier getOclExpression() {
		return stdLibBuilder.getOclExpression();
	}

	public Object getInvalid() {		
		return stdLibBuilder.getInvalid();
	}

	public Classifier getOclMessage() {		
		return stdLibBuilder.getOclMessage();
	}

	public Classifier getOclType() {
		return stdLibBuilder.getOclType();
	}

	public Classifier getOclVoid() {
		return stdLibBuilder.getOclVoid();
	}

	public Classifier getOrderedSet() {
		return stdLibBuilder.getOrderedSet();
	}

	public Classifier getReal() { 
		return stdLibBuilder.getReal();
	}

	public Classifier getSequence() {
		return stdLibBuilder.getSequence();
	}

	public Classifier getSet() {		
		return stdLibBuilder.getSet();
	}

	public Classifier getState() {	
		return stdLibBuilder.getState();
	}

	public Classifier getString() {
		return stdLibBuilder.getString();
	}

	public Classifier getT() {
		return stdLibBuilder.getT();
	}

	public Classifier getT2() {
		return stdLibBuilder.getT2();
	}

	public Classifier getUnlimitedNatural() {
		return stdLibBuilder.getUnlimitedNatural();
	}
	
	/**
	 * @return the {@link Package} which contains the OCL predefined types.
	 */
	public Package getOCLStdLibPackage() {
		return OCLStandardLibraryImpl.stdlibPackage;
	}
}