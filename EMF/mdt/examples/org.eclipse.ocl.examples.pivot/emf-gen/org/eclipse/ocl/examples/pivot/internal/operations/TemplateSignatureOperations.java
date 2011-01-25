/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: TemplateSignatureOperations.java,v 1.2 2011/01/24 20:42:33 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.internal.operations;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.util.PivotValidator;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Template Signature</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.TemplateSignature#validateOwnElements(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Own Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TemplateSignatureOperations
		extends MonikeredElementOperations {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplateSignatureOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Parameters must own the elements they parameter or those elements must be owned by the element being templated.
	 * templatedElement.ownedElement->includesAll(parameter.parameteredElement - parameter.ownedParameteredElement)
	 * @param templateSignature The receiving '<em><b>Template Signature</b></em>' model object.
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean validateOwnElements(
			TemplateSignature templateSignature, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false)
		{
			if (diagnostics != null)
			{
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 PivotValidator.DIAGNOSTIC_SOURCE,
						 PivotValidator.TEMPLATE_SIGNATURE__OWN_ELEMENTS,
						 org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "validateOwnElements", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(templateSignature, context) }), //$NON-NLS-1$ //$NON-NLS-2$
						 new Object [] { templateSignature }));
			}
			return false;
		}
		return true;
	}

} // TemplateSignatureOperations