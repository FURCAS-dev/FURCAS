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
package de.hpi.sam.bp2009.solution.oclToAst.delegate;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.delegate.OCLDelegateDomain;
import org.eclipse.ocl.ecore.delegate.OCLValidationDelegate;

import de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser;
import de.hpi.sam.bp2009.solution.oclToAst.OclToAstFactory;

/**
 * An implementation of the dynamic validation delegate API, maintaining a cache
 * of compiled constraints and invariants.
 * 
 * @since 3.0
 */
public class OCLValidationDelegateForAnnotations extends OCLValidationDelegate
{	
    EAnnotationOCLParser parser= OclToAstFactory.eINSTANCE.createEAnnotationOCLParser();
    public OCLValidationDelegateForAnnotations(
            OCLDelegateDomain delegateDomain, EClassifier classifier) {
        super(delegateDomain, classifier);
    }

    public boolean validate(EClass eClass, EObject eObject,
            Map<Object, Object> context, EOperation invariant, String expression) {

        OCLExpression query = parser.getExpressionFromAnnotationsOf(eClass,invariant.getName());
        if(query!=null)
            return check(eObject, invariant.getName(), query);

        throw new IllegalArgumentException(EAnnotationOCLParser.EXPRESSION_NOT_FOUND);
    }



    public boolean validate(EClass eClass, EObject eObject,
            Map<Object, Object> context, String constraint, String expression) {
        OCLExpression query = parser.getExpressionFromAnnotationsOf(eClass,constraint);
        if(query!=null)
            return check(eObject, constraint, query);
        throw new IllegalArgumentException(EAnnotationOCLParser.EXPRESSION_NOT_FOUND);
    }

    public boolean validate(EDataType eDataType, Object value,
            Map<Object, Object> context, String constraint, String expression) {

        OCLExpression query =  parser.getExpressionFromAnnotationsOf(eDataType,constraint);
        if(query!=null)
            return check(value, constraint, query);
        throw new IllegalArgumentException(EAnnotationOCLParser.EXPRESSION_NOT_FOUND);
    }
}
