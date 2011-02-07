/**
 * <copyright>
 * 
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: OCLInvocationDelegate.java,v 1.1 2011/01/30 11:16:29 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.delegate;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.BasicInvocationDelegate;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;
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
	private Operation operation;
	private ExpressionInOcl specification;
//	private ValueConverter converter;

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
//		this.converter = operation.isMany()
//			? ValueConverter.LIST
//			: ValueConverter.VERBATIM;
	}

	@Override
	public Object dynamicInvoke(InternalEObject target, EList<?> arguments)
			throws InvocationTargetException {
		OCL ocl = delegateDomain.getOCL();
		TypeManager typeManager = ocl.getEnvironment().getTypeManager();
		ValueFactory valueFactory = typeManager.getValueFactory();
		if (specification == null) {
			if (operation == null) {
				Resource ecoreMetaModel = eOperation.eResource();
				Ecore2Pivot ecore2Pivot = Ecore2Pivot.getAdapter(ecoreMetaModel, typeManager);
				operation = ecore2Pivot.getCreated(Operation.class, eOperation);
			}
			specification = InvocationBehavior.INSTANCE.getSpecification(typeManager, operation);
			if (specification == null) {
				String message = NLS.bind(OCLMessages.MissingBodyForInvocationDelegate_ERROR_, getOperationName());
				throw new OCLDelegateException(message);
//				expression = ocl.getTypeManager().createInvalidExpression(target, message);
//				return null;
			}
//			else {
//				expression = specification.getBodyExpression();
//				if (expression == null) {
//					String message = NLS.bind(OCLMessages.MissingBodyForInvocationDelegate_ERROR_, getOperationName());
//					expression = ocl.getTypeManager().createInvalidExpression(specification, message);
//				}
//			}
		}
		OCL.Query query = ocl.createQuery(specification);
		EvaluationEnvironment env = query.getEvaluationEnvironment();
		List<Parameter> parms = operation.getOwnedParameters();
		if (!parms.isEmpty()) {
			// bind arguments to parameter names
			for (int i = 0; i < parms.size(); i++) {
				Object object = arguments.get(i);
				Value value = valueFactory.valueOf(object);
				env.add(parms.get(i), value);
//				env.add(parms.get(i).getName(), value);
			}
		}
		Value result = query.evaluate(target);
		if (result.isInvalid()) {
			String message = NLS.bind(OCLMessages.EvaluationResultIsInvalid_ERROR_, getOperationName());
			throw new OCLDelegateException(message);
		}
//		if ((result == null) /* || ocl.isInvalid(result) */) {
//			String message = NLS.bind(OCLMessages.EvaluationResultIsNull_ERROR_, getOperationName());
//			throw new OCLDelegateException(message);
//		}
//		return converter.convert(ocl, result);
		return valueFactory.getEcoreValueOf(result);
	}
	
	public String getOperationName() {
		return eOperation.getEContainingClass().getEPackage().getName() + "::" + eOperation.getEContainingClass().getName() + "." + eOperation.getName();  //$NON-NLS-1$//$NON-NLS-2$
	}
	
	public String toString() {
		return "<" + delegateDomain.getURI() + ":setting> " + getOperationName(); //$NON-NLS-1$ //$NON-NLS-2$
	}

}
