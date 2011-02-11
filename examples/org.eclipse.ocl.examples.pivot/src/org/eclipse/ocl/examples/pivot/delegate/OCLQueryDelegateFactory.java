/**
 * <copyright>
 * 
 * Copyright (c) 2010,2011 Kenn Hussey and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Kenn Hussey - Initial API and implementation
 * 
 * </copyright>
 *
 * $Id: OCLQueryDelegateFactory.java,v 1.2 2011/02/11 20:00:29 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.delegate;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.QueryDelegate;
import org.eclipse.ocl.examples.pivot.CompleteType;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.utilities.PivotConstants;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;

/**
 * Factory for OCL query delegates.
 * <p>
 * The factory may be obtained by:
 * <pre>
 * QueryDelegate.Factory factory = QueryDelegate.Factory.Registry.INSTANCE
 *		.getFactory(OCLDelegateDomain.OCL_DELEGATE_URI);
 * </pre>
 * from which a query delegate may be created by: 
 * <pre>
 * QueryDelegate delegate = factory.createQueryDelegate(
 * 		classifier,                 // the context type
 * 		map-of-name-to-classifier,  // the external variable names and types
 * 		string);                    // the OCL expression text
 * </pre>
 * and (repeatedly) invoked by: 
 * <pre>
 * Object result = delegate.execute(
 * 		target,                     // the context instance
 * 		map-of-name-to-object);     // the external variable bindings
 * </pre>
 * 
 * @since 3.1
 */
public class OCLQueryDelegateFactory
		extends AbstractOCLDelegateFactory
		implements QueryDelegate.Factory {

	public OCLQueryDelegateFactory() {
	}

	public OCLQueryDelegateFactory(OCLDelegateDomain delegateDomain) {
		super(delegateDomain);
	}

	public QueryDelegate createQueryDelegate(EClassifier context,
			Map<String, EClassifier> parameters, String expression) {
		OCLDelegateDomain delegateDomain = getDelegateDomain(context.getEPackage());
		OCL ocl = delegateDomain.getOCL();
		TypeManager typeManager = ocl.getEnvironment().getTypeManager();
		Resource ecoreMetaModel = context.eResource();
		Ecore2Pivot ecore2Pivot = Ecore2Pivot.getAdapter(ecoreMetaModel, typeManager);
		Type type = ecore2Pivot.getCreated(Type.class, context);
		CompleteType completeType = typeManager.getCompleteType(type);
//		completeType.setModel(type);
//		completeType.setName(type.getName());
//		typeManager.addOrphanType(completeType);
		Operation query = PivotFactory.eINSTANCE.createOperation();
		query.setName("queryDelegate");
		completeType.getOwnedOperations().add(query);
		List<Parameter> pivotParameters = query.getOwnedParameters();
		if (parameters != null) {
			for (Map.Entry<String, EClassifier> entry : parameters.entrySet()) {
				Parameter pivotParameter = PivotFactory.eINSTANCE.createParameter();
				pivotParameter.setName(entry.getKey());
				pivotParameter.setType(ecore2Pivot.getCreated(Type.class, entry.getValue()));
				pivotParameters.add(pivotParameter);
			}
		}
		Constraint constraint = PivotFactory.eINSTANCE.createConstraint();
		constraint.setStereotype("body");
		query.getOwnedRules().add(constraint);
		OpaqueExpression specification = PivotFactory.eINSTANCE.createOpaqueExpression();
		specification.getBodies().add(expression);
		specification.getLanguages().add(PivotConstants.OCL_LANGUAGE);
		constraint.setSpecification(specification);
		return new OCLQueryDelegate(delegateDomain, query);
	}
	
	/**
	 * The Global variant of the Factory delegates to a local ResourceSet factory if one
	 * can be located at the QueryDelegate.Factory.Registry
	 * by the DelegateResourceSetAdapter.
	 */
	public static class Global extends OCLQueryDelegateFactory
	{
		@Override
		public QueryDelegate createQueryDelegate(EClassifier context,
				Map<String, EClassifier> parameters, String expression) {
			QueryDelegate.Factory.Registry localRegistry = DelegateResourceSetAdapter.getRegistry(
				context, QueryDelegate.Factory.Registry.class, null);
			if (localRegistry != null) {
				QueryDelegate.Factory factory = localRegistry.getFactory(delegateURI);
				if (factory != null) {
					return factory.createQueryDelegate(context, parameters, expression);
				}
			}
			return super.createQueryDelegate(context, parameters, expression);
		}	
	}
}
