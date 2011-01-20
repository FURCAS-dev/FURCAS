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
 *   C.Damus, K.Hussey, E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 *
 * $Id: OCLInvocationDelegate.java,v 1.2 2010/04/08 06:27:21 ewillink Exp $
 */
package org.eclipse.ocl.ecore.delegate;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.BasicInvocationDelegate;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.osgi.util.NLS;

/**
 * An implementation of an operation-invocation delegate for OCL body
 * expressions.
 * 
 * @since 3.0
 */
public class OCLInvocationDelegate extends BasicInvocationDelegate
{
	protected final OCLDelegateDomain delegateDomain;
	private OCLExpression body;
	private ValueConverter converter;

	/**
	 * Initializes me with my operation.
	 * 
	 * @param operation
	 *            the operation that I handle
	 * 
	 * @throws ParserException
	 *             if the operation's OCL body expression is invalid
	 */
	public OCLInvocationDelegate(OCLDelegateDomain delegateDomain, EOperation operation) {
		super(operation);
		this.delegateDomain = delegateDomain;
		this.converter = operation.isMany()
			? ValueConverter.LIST
			: ValueConverter.VERBATIM;
	}

	@Override
	public Object dynamicInvoke(InternalEObject target, EList<?> arguments)
			throws InvocationTargetException {
		OCL ocl = delegateDomain.getOCL();
		if (body == null) {
			body = InvocationBehavior.INSTANCE.getOperationBody(ocl, eOperation);
		}
		if (body == null) {
			String message = NLS.bind(OCLMessages.MissingBodyForInvocationDelegate_ERROR_, getOperationName());
			throw new OCLDelegateException(message);
		}
		OCL.Query query = ocl.createQuery(body);
		EList<EParameter> parms = eOperation.getEParameters();

		if (!parms.isEmpty()) {
			// bind arguments to parameter names
			EvaluationEnvironment<EClassifier, ?, ?, ?, ?> env = query
				.getEvaluationEnvironment();

			for (int i = 0; i < parms.size(); i++) {
				env.add(parms.get(i).getName(), arguments.get(i));
			}
		}
		Object result = query.evaluate(target);
		if (ocl.isInvalid(result)) {
			String message = NLS.bind(OCLMessages.EvaluationResultIsInvalid_ERROR_, getOperationName());
			throw new OCLDelegateException(message);
		}
//		if ((result == null) /* || ocl.isInvalid(result) */) {
//			String message = NLS.bind(OCLMessages.EvaluationResultIsNull_ERROR_, getOperationName());
//			throw new OCLDelegateException(message);
//		}
		return converter.convert(ocl, result);
	}
	
	public String getOperationName() {
		return eOperation.getEContainingClass().getEPackage().getName() + "::" + eOperation.getEContainingClass().getName() + "." + eOperation.getName();  //$NON-NLS-1$//$NON-NLS-2$
	}
	
	public String toString() {
		return "<" + delegateDomain.getURI() + ":setting> " + getOperationName(); //$NON-NLS-1$ //$NON-NLS-2$
	}

}
