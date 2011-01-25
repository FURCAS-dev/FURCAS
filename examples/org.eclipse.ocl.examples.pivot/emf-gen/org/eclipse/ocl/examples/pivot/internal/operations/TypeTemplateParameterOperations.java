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
 * $Id: TypeTemplateParameterOperations.java,v 1.2 2011/01/24 20:42:33 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.internal.operations;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.ocl.examples.pivot.TypeTemplateParameter;
import org.eclipse.ocl.examples.pivot.util.PivotValidator;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Type Template Parameter</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.TypeTemplateParameter#validateHasConstrainingType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Has Constraining Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeTemplateParameterOperations
		extends TemplateParameterOperations {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeTemplateParameterOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If "allowSubstitutable" is true, then there must be a constrainingClassifier.
	 * allowSubstitutable implies constrainingClassifier->notEmpty()
	 * @param typeTemplateParameter The receiving '<em><b>Type Template Parameter</b></em>' model object.
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean validateHasConstrainingType(
			TypeTemplateParameter typeTemplateParameter,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 PivotValidator.TYPE_TEMPLATE_PARAMETER__HAS_CONSTRAINING_TYPE,
						 org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "validateHasConstrainingType", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(typeTemplateParameter, context) }), //$NON-NLS-1$ //$NON-NLS-2$
						 new Object [] { typeTemplateParameter }));
			}
			return false;
		}
		return true;
	}

} // TypeTemplateParameterOperations