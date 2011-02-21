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
 * $Id: OCLInvocationDelegate.java,v 1.3 2011/02/21 08:37:53 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.delegate;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.BasicInvocationDelegate;
import org.eclipse.ocl.examples.pivot.EvaluationException;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;
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

	/**
	 * Initializes me with my operation.
	 * 
	 * @param operation
	 *            the operation that I handle
	 */
	public OCLInvocationDelegate(OCLDelegateDomain delegateDomain, EOperation operation) {
		super(operation);
		this.delegateDomain = delegateDomain;
	}

	@Override
	public Object dynamicInvoke(InternalEObject target, EList<?> arguments)
			throws InvocationTargetException {
		try {
			OCL ocl = delegateDomain.getOCL();
			TypeManager typeManager = ocl.getTypeManager();
			ValueFactory valueFactory = typeManager.getValueFactory();
			if (specification == null) {
				if (operation == null) {
					operation = typeManager.getPivotOfEcore(Operation.class, eOperation);
				}
				specification = InvocationBehavior.INSTANCE.getExpressionInOcl(typeManager, operation);
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
				}
			}
			Value result = query.evaluate(target);
			return valueFactory.getEcoreValueOf(result);
		}
		catch (EvaluationException e) {
			String message = NLS.bind(OCLMessages.EvaluationResultIsInvalid_ERROR_, operation);
			throw new InvocationTargetException(new OCLDelegateException(message));
		}
		catch (OCLDelegateException e) {
			throw new InvocationTargetException(e);
		}
	}
	
	@Override
	public String toString() {
		if (operation != null) {
			return "<" + delegateDomain.getURI() + ":invocation> " + operation; //$NON-NLS-1$ //$NON-NLS-2$
		}
		else {
			String name = eOperation.getEContainingClass().getEPackage().getName()
			+ "::" + eOperation.getEContainingClass().getName()
			+ "." + eOperation.getName();
			return "<" + delegateDomain.getURI() + ":invocation> " + name; //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

}
