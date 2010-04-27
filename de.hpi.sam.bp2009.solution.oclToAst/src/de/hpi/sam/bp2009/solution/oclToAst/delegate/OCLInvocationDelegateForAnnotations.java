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
package de.hpi.sam.bp2009.solution.oclToAst.delegate;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.delegate.OCLDelegateDomain;
import org.eclipse.ocl.ecore.delegate.OCLDelegateException;
import org.eclipse.ocl.ecore.delegate.OCLInvocationDelegate;
import org.eclipse.osgi.util.NLS;

import de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser;
import de.hpi.sam.bp2009.solution.scopeProvider.ProjectDependencyQueryContextProvider;

/**
 * An implementation of an operation-invocation delegate for OCL body
 * expressions.
 * 
 * @since 3.0
 */
public class OCLInvocationDelegateForAnnotations extends OCLInvocationDelegate
{
	private OCLExpression body;
	private ValueConverter converter;

	public OCLInvocationDelegateForAnnotations(
			OCLDelegateDomain delegateDomain, EOperation operation) {
		super(delegateDomain, operation);
		this.converter = operation.isMany()
		? ValueConverter.LIST
		: ValueConverter.VERBATIM;
	}


	@Override
	public Object dynamicInvoke(InternalEObject target, EList<?> arguments)
			throws InvocationTargetException {
		OCL ocl = delegateDomain.getOCL();
		new ProjectDependencyQueryContextProvider().apply(ocl);
		if (body == null) {
			body = InvocationBehaviorForAnnotations.INSTANCE.getOperationBody(ocl, eOperation);
		}
		/*
		 * call super behaviour if not able to resolve annotation 
		 * 
		 */
		if(body == null)
			throw new IllegalArgumentException(EAnnotationOCLParser.MISSING_BODY_FOR_INVOCATION_DELEGATE + eOperation.getName() +" . "+ EAnnotationOCLParser.EXPRESSION_NOT_FOUND);

		
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
			String message = NLS.bind("OCL evaluation result of ''{0}'' is invalid", getOperationName());
			throw new OCLDelegateException(message);
		}
		return converter.convert(ocl, result);
	}
	
}
