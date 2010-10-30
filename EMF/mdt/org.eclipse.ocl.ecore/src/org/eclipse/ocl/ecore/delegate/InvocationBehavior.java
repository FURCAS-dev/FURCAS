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
 * $Id: InvocationBehavior.java,v 1.2 2010/04/08 06:27:20 ewillink Exp $
 */
package org.eclipse.ocl.ecore.delegate;

import java.util.Map;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EOperation.Internal.InvocationDelegate;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.ExpressionInOCL;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;

/**
 * @since 3.0
 */
public class InvocationBehavior extends AbstractDelegatedBehavior<EOperation, InvocationDelegate.Factory.Registry, InvocationDelegate.Factory>
{
	public static final InvocationBehavior INSTANCE = new InvocationBehavior();
	public static final String BODY_CONSTRAINT_KEY = "body"; //$NON-NLS-1$
	public static final String NAME = "invocationDelegates"; //$NON-NLS-1$

	public boolean appliesTo(EOperation operation) {
      	String annotation = EcoreUtil.getAnnotation(operation, OCLDelegateDomain.OCL_DELEGATE_URI, BODY_CONSTRAINT_KEY);
		return annotation != null;
	}

	public InvocationDelegate.Factory getDefaultFactory() {
		return InvocationDelegate.Factory.Registry.INSTANCE.getFactory(getName());
	}

	public InvocationDelegate.Factory.Registry getDefaultRegistry() {
		return InvocationDelegate.Factory.Registry.INSTANCE;
	}

	public EPackage getEPackage(EOperation eOperation) {
		return eOperation.getEContainingClass().getEPackage();
	}

	public InvocationDelegate.Factory getFactory(DelegateDomain delegateDomain, EOperation eOperation) {
		InvocationDelegate.Factory.Registry registry = DelegateResourceSetAdapter.getRegistry(
			eOperation, getRegistryClass(), getDefaultRegistry());
	    return registry.getFactory(delegateDomain.getURI());
	}

	public Class<InvocationDelegate.Factory> getFactoryClass() {
		return InvocationDelegate.Factory.class;
	}
	
	public String getName() {
		return NAME;
	}

	public OCLExpression getOperationBody(OCL ocl, EOperation operation) {
		OCLExpression result = getExpressionFromAnnotationsOf(operation, BODY_CONSTRAINT_KEY);
		if(result != null){
			return result;
		}
		EClass context = operation.getEContainingClass();
		OCL.Helper helper = ocl.createOCLHelper();
		helper.setOperationContext(context, operation);
		//to deal with hidden opposites
		helper.setValidating(false);
		String expr = EcoreUtil.getAnnotation(operation, OCLDelegateDomain.OCL_DELEGATE_URI, BODY_CONSTRAINT_KEY);
		if (expr == null) {
			return null;
		}
		Constraint constraint;
		try {
			constraint = helper.createBodyCondition(expr);
		} catch (ParserException e) {
			throw new OCLDelegateException(e.getLocalizedMessage(), e);
		}
		if (constraint == null) {
			return null;
		}
		ExpressionInOCL specification = (ExpressionInOCL) constraint.getSpecification();
		if (specification == null) {
			return null;
		}
		saveExpressionInAnnotation(operation, constraint);
		return (OCLExpression) specification.getBodyExpression();
	}
	
	public OCLExpression getInvariant(EModelElement cls, String constraintName, OCL ocl){
		OCLExpression result = getExpressionFromAnnotationsOf(cls, constraintName);
		if (result != null){
			return result;
		}
		OCL.Helper helper = ocl.createOCLHelper();
		if (!(cls instanceof EClassifier)){
			return null;
		}
		helper.setContext((EClassifier)cls);
		String expr = EcoreUtil.getAnnotation(cls, OCLDelegateDomain.OCL_DELEGATE_URI, constraintName);
		if (expr == null){
			return null;
		}
		Constraint constraint;
		try {
			constraint = helper.createInvariant(expr);
		} catch (ParserException e) {
			throw new OCLDelegateException(e.getLocalizedMessage(), e);
		}
		if (constraint == null) {
			return null;
		}
		ExpressionInOCL specification = (ExpressionInOCL) constraint.getSpecification();
		if (specification == null) {
			return null;
		}
		saveExpressionInAnnotation(cls, constraint);
		return (OCLExpression) specification.getBodyExpression();
	}

	private void saveExpressionInAnnotation(EModelElement modelElement, Constraint constraint) {
		EAnnotation a = modelElement.getEAnnotation(Environment.OCL_NAMESPACE_URI);
		if (a == null){
			a = EcoreFactory.eINSTANCE.createEAnnotation();
			a.setEModelElement(modelElement);
			a.setSource(Environment.OCL_NAMESPACE_URI);
		}
		a.getContents().add(constraint);
	}

	private OCLExpression getExpressionFromAnnotationsOf(EModelElement modelElement, String constraintKey) {
		EAnnotation anno = modelElement.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
		EAnnotation ast = modelElement.getEAnnotation(Environment.OCL_NAMESPACE_URI);
		if (anno != null && ast != null){
			int pos = -1;
			int count = 0;
			for (Map.Entry<String, String> constraint : anno.getDetails()) {
				if (constraint.getKey().equals(constraintKey)) {
					pos = count;
					break;
				}
				count++;
			}
			if (pos != -1) {
				if (ast.getContents().size() > pos) {
					return (OCLExpression) ((Constraint)ast.getContents().get(pos)).getSpecification().getBodyExpression();
				}
			}
		}
		return null;
	}

	public Class<InvocationDelegate.Factory.Registry> getRegistryClass() {
		return InvocationDelegate.Factory.Registry.class;
	}
}