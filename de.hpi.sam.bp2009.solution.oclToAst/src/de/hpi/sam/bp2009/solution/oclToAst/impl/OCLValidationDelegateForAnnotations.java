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
 * $Id: OCLValidationDelegate.java,v 1.2 2010/04/08 06:27:21 ewillink Exp $
 */
package de.hpi.sam.bp2009.solution.oclToAst.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.delegate.OCLDelegateDomain;
import org.eclipse.ocl.ecore.delegate.OCLDelegateException;
import org.eclipse.ocl.ecore.delegate.OCLValidationDelegate;

import de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser;

/**
 * An implementation of the dynamic validation delegate API, maintaining a cache
 * of compiled constraints and invariants.
 * 
 * @since 3.0
 */
public class OCLValidationDelegateForAnnotations extends OCLValidationDelegate
{	



	private Map<EOperation, OCLExpression> invariantOperationMap;
	private Map<String, OCLExpression> constraintNameMap;

	public OCLValidationDelegateForAnnotations(
			OCLDelegateDomain delegateDomain, EClassifier classifier) {
		super(delegateDomain, classifier);
		// TODO Auto-generated constructor stub
	}


	protected OCLExpression createQuery(String expression) {
		OCL ocl = delegateDomain.getOCL();
		Helper helper = ocl.createOCLHelper();
		helper.setContext(eClassifier);
		try {
			return helper.createQuery(/*(String)*/expression);
		} catch (ParserException e) {
			throw new OCLDelegateException(e.getLocalizedMessage(), e);
		}
	}

	public String toString() {
		return "<" + delegateDomain.getURI() + ":validate> " + eClassifier.getEPackage().getName() + "::" + eClassifier.getName(); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	public boolean validate(EClass eClass, EObject eObject,
			Map<Object, Object> context, EOperation invariant, String expression) {
		if (invariantOperationMap == null) {
			invariantOperationMap = new HashMap<EOperation, OCLExpression>();
		}
		OCLExpression query = invariantOperationMap.get(invariant);
		if ((query == null) && (constraintNameMap != null)) {
			query = constraintNameMap.get(invariant.getName());
		}
		if ((query == null) & !invariantOperationMap.containsKey(invariant)) {
			try {
				query = createQuery(expression);
			} finally {
				invariantOperationMap.put(invariant, query);
			}
		}
		return check(eObject, invariant.getName(), query);
	}

	public boolean validate(EClass eClass, EObject eObject,
			Map<Object, Object> context, String constraint, String expression) {
		if (constraintNameMap == null) {
			constraintNameMap = new HashMap<String, OCLExpression>();
		}
		OCLExpression query = constraintNameMap.get(constraint);
		if ((query == null) & !constraintNameMap.containsKey(constraint)) {
			try {
				query = createQuery(expression);
			} finally {
				constraintNameMap.put(constraint, query);
			}
		}
		return check(eObject, constraint, query);
	}

	public boolean validate(EDataType eDataType, Object value,
			Map<Object, Object> context, String constraint, String expression) {
		if (constraintNameMap == null) {
			constraintNameMap = new HashMap<String, OCLExpression>();
		}
		OCLExpression query = constraintNameMap.get(constraint);
		if ((query == null) & !constraintNameMap.containsKey(constraint)) {
			try {
				if(value instanceof EObject){
					EAnnotation anno=((EObject)value).eClass().getEAnnotation(EAnnotationOCLParser.ANNOTATION_SOURCE);
					int pos=-1;
					int count=0;
					for(String constraint1:anno.getDetails().values()){
						if(constraint1.equals(constraint)){
							pos=count;
							break;
						}
						count++;
					}
					if(pos!=-1)
						if(anno.eContents().size()>pos)
							query= (OCLExpression)anno.eContents().get(pos);
				}
				if(query == null)
					query = createQuery(expression);
			} finally {
				constraintNameMap.put(constraint, query);
			}
		}
		return check(value, constraint, query);
	}
}
