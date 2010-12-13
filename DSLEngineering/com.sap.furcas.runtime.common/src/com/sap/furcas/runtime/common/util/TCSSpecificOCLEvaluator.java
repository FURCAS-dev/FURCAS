/*******************************************************************************
 * Copyright (c) 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.furcas.runtime.common.util;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;

import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.ocl.oppositefinder.query2.Query2OppositeEndFinder;

import de.hpi.sam.bp2009.solution.queryContextScopeProvider.QueryContextProvider;
import de.hpi.sam.bp2009.solution.queryContextScopeProvider.impl.ProjectDependencyQueryContextProvider;

/**
 * Helper class allowing to evaluate OCL expressions as used within TCS.
 * 
 * OCL expressions may contain #context or #foreach references. The queries may furthermore contain "?" placeholders.
 * Those will be replaced by the provided keyValue when the query is executed.
 *  
 * @author Stephan Erb (d049157)
 *
 */
public class TCSSpecificOCLEvaluator {
    
    private final OCL ocl;
    private final Helper oclHelper;

    public TCSSpecificOCLEvaluator() {
        this(new ProjectDependencyQueryContextProvider());
    }
    
    public TCSSpecificOCLEvaluator(QueryContextProvider queryContext) {
        ocl = org.eclipse.ocl.examples.impactanalyzer.util.OCL.newInstance(new Query2OppositeEndFinder(queryContext));
        oclHelper = ocl.createOCLHelper();
    }

    /**
     * Returns all model elements found by the given OCL query.
     */
    public Collection<?> findElementsWithOCLQuery(EObject sourceModelElement, Object keyValue,
            String oclQuery) throws ModelAdapterException {
        return findElementsWithOCLQuery(sourceModelElement, keyValue, oclQuery, /*contextObject*/ null, /*foreachObject*/ null);
    }

    /**
     * Returns all model elements found by the given OCL query.
     */
    public Collection<?> findElementsWithOCLQuery(EObject sourceModelElement, Object keyValue,
            String oclQuery, EObject contextObject) throws ModelAdapterException {
        return findElementsWithOCLQuery(sourceModelElement, keyValue, oclQuery, contextObject, /*foreachObject*/ null);
    }

    /**
     * Returns all model elements found by the given OCL query.
     */
    public Collection<?> findElementsWithOCLQuery(EObject sourceModelElement, Object keyValue,
            String queryToExecute, EObject contextObject, EObject foreachObject) throws ModelAdapterException {

        EObject objectForSelf = determineObjectForSelf(sourceModelElement, queryToExecute, foreachObject, contextObject);
        queryToExecute = ContextAndForeachHelper.prepareOclQuery(queryToExecute, keyValue);
        try {
            oclHelper.setContext(objectForSelf.eClass());
            OCLExpression exp = oclHelper.createQuery(queryToExecute);

            Object result = ocl.evaluate(objectForSelf, exp);
            if (ocl.isInvalid(result)) {
                throw new ModelAdapterException("Cannot evaluate OCLExpression:" + queryToExecute + " Reason: "
                        + (ocl.getEvaluationProblems() == null ? "" : ocl.getEvaluationProblems().getMessage()));
            }
            if (result instanceof Collection<?>) {
                return (Collection<?>) result;
            } else {
                return Collections.singleton(result);
            }

        } catch (ParserException e) {
            throw new ModelAdapterException("Cannot evaluate OCLExpression:" + queryToExecute + " Reason: "
                    + e.getDiagnostic().getMessage(), e);
        }
    }

    private EObject determineObjectForSelf(EObject sourceModelElement, String oclQuery, EObject foreachObject, EObject contextRefObject) throws ModelAdapterException {
        EObject objectForSelf;
        if (ContextAndForeachHelper.usesContext(oclQuery)) {
            objectForSelf = contextRefObject;
        } else if (ContextAndForeachHelper.usesForeach(oclQuery)) {
            objectForSelf = foreachObject;
        } else {
            objectForSelf = sourceModelElement;
        }
        if (objectForSelf == null) {
            throw new ModelAdapterException("Cannot find suitable self object for OCL expression " + oclQuery);
        }
        return objectForSelf;
    }
        
}
