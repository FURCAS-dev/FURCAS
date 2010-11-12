/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: ElementCSImpl.java,v 1.4 2010/05/24 08:59:31 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.base.baseCST.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.ocl.examples.xtext.base.util.ElementUtil;
import org.eclipse.ocl.examples.xtext.base.util.Signature;
import org.eclipse.xtext.parsetree.CompositeNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class ElementCSImpl extends EObjectImpl implements ElementCS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BaseCSTPackage.Literals.ELEMENT_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public final String getSignature() {
		Signature s = new Signature();
		try {
			getSignature(s, null);
			return s.toString();
		}
		catch (Throwable e) {
			return e.getMessage();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract void getSignature(Signature signature, TypeBindingsCS typeBindings);

	@Override
	public String toString() {
		CompositeNode parserNode = ElementUtil.getParserNode(this);
		if (parserNode != null) {
			return parserNode.serialize().trim();
		}
		return getSignature();
	}
} //ElementCSImpl
