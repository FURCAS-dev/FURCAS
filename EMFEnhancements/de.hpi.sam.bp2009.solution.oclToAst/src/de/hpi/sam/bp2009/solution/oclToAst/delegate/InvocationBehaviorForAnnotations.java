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
package de.hpi.sam.bp2009.solution.oclToAst.delegate;

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.delegate.InvocationBehavior;

import de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser;
import de.hpi.sam.bp2009.solution.oclToAst.OclToAstFactory;

/**
 * @since 3.0
 */
public class InvocationBehaviorForAnnotations extends InvocationBehavior
{
    public static final InvocationBehaviorForAnnotations INSTANCE = new InvocationBehaviorForAnnotations();
    EAnnotationOCLParser parser= OclToAstFactory.eINSTANCE.createEAnnotationOCLParser();

    public OCLExpression getOperationBody(OCL ocl, EOperation operation) {
        OCLExpression expr= parser.getExpressionFromAnnotationsOf(operation,BODY_CONSTRAINT_KEY);
        if(expr!=null)
            return expr;
        return super.getOperationBody(ocl,operation);
    }

}