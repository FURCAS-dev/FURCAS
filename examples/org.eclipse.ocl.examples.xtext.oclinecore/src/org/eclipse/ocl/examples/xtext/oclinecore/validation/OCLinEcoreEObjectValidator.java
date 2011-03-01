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
 * $Id: OCLinEcoreEObjectValidator.java,v 1.1 2011/03/01 08:46:34 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.validation;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.ocl.examples.pivot.delegate.ValidationDelegateExtension;

/**
 * A OCLinEcoreEObjectValidator enhances the standard EObjectValidator to allow validation failures
 * to obtain a corresponding diagnostic from the validation delegate rather using the default
 * delegate exception message.
 * 
 * This class may go obsolete once Bug 337792 resolved.
 */
public class OCLinEcoreEObjectValidator extends EObjectValidator
{	
	@Override
	public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context,
			String validationDelegate, String constraint, String expression, int severity, String source, int code) {
	    ValidationDelegate delegate = getValidationDelegateRegistry(context).getValidationDelegate(validationDelegate);
	    if (delegate instanceof ValidationDelegateExtension) {
	      try
	      {
	        return ((ValidationDelegateExtension)delegate).validate(eClass, eObject, diagnostics, context, constraint, expression, severity, source, code);
	      }
	      catch (Throwable throwable)
	      {
	        if (diagnostics != null)
	          reportConstraintDelegateException(eClass, eObject, diagnostics, context, constraint, severity, source, code, throwable);
	      }
	    }
	    else if (delegate != null)
	    {
	      try
	      {
	        if (!delegate.validate(eClass, eObject, context, constraint, expression))
	        {
	          if (diagnostics != null)
	            reportConstraintDelegateViolation(eClass, eObject, diagnostics, context, constraint, severity, source, code);
	          return false;
	        }
	      }
	      catch (Throwable throwable)
	      {
	        if (diagnostics != null)
	          reportConstraintDelegateException(eClass, eObject, diagnostics, context, constraint, severity, source, code, throwable);
	      }
	    }
	    else
	    {
	      if (diagnostics != null)
	        reportConstraintDelegateNotFound(eClass, eObject, diagnostics, context, constraint, severity, source, code, validationDelegate);
	    }
	    return true;
	}

	@Override
	public boolean validate(EDataType eDataType, Object value, DiagnosticChain diagnostics,
			Map<Object, Object> context, String validationDelegate, String constraint, String expression, int severity,
			String source, int code) {
	    ValidationDelegate delegate = getValidationDelegateRegistry(context).getValidationDelegate(validationDelegate);
	    if (delegate instanceof ValidationDelegateExtension) {
		      try
		      {
		        return ((ValidationDelegateExtension)delegate).validate(eDataType, value, diagnostics, context, constraint, expression, severity, source, code);
		      }
		      catch (Throwable throwable)
		      {
		        if (diagnostics != null)
		          reportConstraintDelegateException(eDataType, value, diagnostics, context, constraint, severity, source, code, throwable);
		      }
		    }
		    else if (delegate != null)
	    {
	      try
	      {
	        if (!delegate.validate(eDataType, value, context, constraint, expression))
	        {
	          if (diagnostics != null)
	            reportConstraintDelegateViolation(eDataType, value, diagnostics, context, constraint, severity, source, code);
	          return false;
	        }
	      }
	      catch (Throwable throwable)
	      {
	        if (diagnostics != null)
	          reportConstraintDelegateException(eDataType, value, diagnostics, context, constraint, severity, source, code, throwable);
	      }
	    }
	    else
	    {
	      if (diagnostics != null)
	        reportConstraintDelegateNotFound(eDataType, value, diagnostics, context, constraint, severity, source, code, validationDelegate);
	    }
	    return true;
	}
}
