/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
 * $Id: ValidationDelegateExtension.java,v 1.1 2011/03/01 08:47:20 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.delegate;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;

/**
 * An extended interface allowing validators to generate custom diagnostics.
 * 
 * @since 3.1
 */
//FIXME this class will be obsoleted by Bug 337792 resolution 
public interface ValidationDelegateExtension extends EValidator.ValidationDelegate //, EValidator.ValidationDelegate.Extension
{
    /**
     * Evaluates the given constraint expression against the object in the given context.
     * @return the result of the expression evaluation.
     */
    boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context, String constraint, String expression, int severity, String source, int code);

    /**
     * Evaluates the given constraint expression against the value in the given context.
     * @return the result of the expression evaluation.
     */
    boolean validate(EDataType eDataType, Object value, DiagnosticChain diagnostics, Map<Object, Object> context, String constraint, String expression, int severity, String source, int code);
}