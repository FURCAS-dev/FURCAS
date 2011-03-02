/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
 * $Id: OCLinEcoreSpecificationCSImpl.java,v 1.1 2011/03/01 08:46:35 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.ExpSpecificationCSImpl;

import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreSpecificationCS;
import org.eclipse.ocl.examples.xtext.oclinecore.util.OCLinEcoreCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>OC Lin Ecore Specification CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class OCLinEcoreSpecificationCSImpl extends ExpSpecificationCSImpl implements OCLinEcoreSpecificationCS
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OCLinEcoreSpecificationCSImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return OCLinEcoreCSTPackage.Literals.OC_LIN_ECORE_SPECIFICATION_CS;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <R, C> R accept(BaseCSVisitor<R, C> visitor) {
		return (R) visitor.getAdapter(OCLinEcoreCSVisitor.class).visitOCLinEcoreSpecificationCS(this);
	}
} //OCLinEcoreSpecificationCSImpl
