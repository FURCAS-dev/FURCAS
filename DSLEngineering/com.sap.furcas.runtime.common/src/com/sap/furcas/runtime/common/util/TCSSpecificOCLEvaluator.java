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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;

import com.sap.emf.ocl.prepared.PreparedOCLExpression;
import com.sap.emf.ocl.prepared.PreparedOCLExpression.ParameterValue;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.ocl.oppositefinder.query2.Query2OppositeEndFinder;

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
    
    private static class CacheKey {

        private final String queryToExecute;
        private final EClass context;

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + context.hashCode();
            result = prime * result + queryToExecute.hashCode();
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CacheKey)) {
                return false;
            }
            CacheKey other = (CacheKey) obj;
            return other.context.equals(this.context) &&
                other.queryToExecute.equals(this.queryToExecute);
        }

        public CacheKey(String queryToExecute, EClass context) {
            this.queryToExecute = queryToExecute;
            this.context = context;
        }
    }
    
    private static final String LEGACY_QUERY_PARAMETER = "?";
    
    private final OCL ocl;
    private final Helper oclHelper;
    private final OppositeEndFinder oppositeEndFinder;
    private final Map<CacheKey, PreparedOCLExpression> queryCache = new HashMap<CacheKey, PreparedOCLExpression>();

    public TCSSpecificOCLEvaluator() {
        this(new Query2OppositeEndFinder(new ProjectDependencyQueryContextProvider()));
    }
    
    public TCSSpecificOCLEvaluator(OppositeEndFinder oppositeEndFinder) {
        this.oppositeEndFinder = oppositeEndFinder;
        this.ocl = org.eclipse.ocl.examples.impactanalyzer.util.OCL.newInstance(oppositeEndFinder);
        this.oclHelper = ocl.createOCLHelper();
        this.oclHelper.setValidating(true);
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
        try {
            PreparedOCLExpression preparedExp = getOCLExpressionToExecute(objectForSelf, keyValue, queryToExecute);
            Object result = evaluate(objectForSelf, keyValue, preparedExp);
            
            if (ocl.isInvalid(result)) {
                throw new ModelAdapterException("Cannot evaluate OCLExpression:" + queryToExecute + " Reason: Result is invalid "
                        + (ocl.getEvaluationProblems() == null ? "" : ocl.getEvaluationProblems().getMessage()));
            }
            if (result instanceof Collection<?>) {
                return (Collection<?>) result;
            } else {
                return Collections.singleton(result);
            }

        } catch (ParserException e) {
            throw new ModelAdapterException("Cannot evaluate) OCLExpression:" + queryToExecute + " Reason: "
                    + e.getDiagnostic().getMessage(), e);
        }
    }

    private Object evaluate( EObject objectForSelf, Object keyValue, PreparedOCLExpression exp) {
        if (keyValue != null) {
            ParameterValue<Object> parameter = exp.createParameterValue(LEGACY_QUERY_PARAMETER, keyValue);
            return exp.evaluate(objectForSelf, parameter);
        } else {
            return exp.evaluate(objectForSelf);
        }
    }
    
    private PreparedOCLExpression getOCLExpressionToExecute(EObject objectForSelf, Object keyValue, String queryToExecute) throws ParserException {
        CacheKey key = new CacheKey(queryToExecute, objectForSelf.eClass());
        if (queryCache.containsKey(key)) {
            return queryCache.get(key);
        }
        // FIXME: Workaround because prepared statements require '?' but our generator
        // only produces queries with a plain ?. 
        // Once the parser generator is migrated this additional replacing can go away.
        queryToExecute = ContextAndForeachHelper.prepareOclQuery(queryToExecute, LEGACY_QUERY_PARAMETER);
        
        oclHelper.setContext(objectForSelf.eClass());
        OCLExpression exp = oclHelper.createQuery(queryToExecute);
        
        PreparedOCLExpression preparedExp = null;
        if (keyValue != null) {
            // FIXME: ? is the legacy parameter. We have to replace it with something less problematic.
            preparedExp = new PreparedOCLExpression(oppositeEndFinder, exp, LEGACY_QUERY_PARAMETER);
        } else {
            preparedExp = new PreparedOCLExpression(oppositeEndFinder, exp);
        }
        queryCache.put(key, preparedExp);
        return preparedExp;
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
    
    public List<Diagnostic> validateOclQuery(Template template, String queryToValidate) {
        try {
             EClassifier parsingContext = ContextAndForeachHelper.getParsingContext(queryToValidate, template, oppositeEndFinder);
            return validateOclQuery(parsingContext, queryToValidate);
        } catch (ParserException e) {
            return Collections.singletonList((Diagnostic) new BasicDiagnostic(getClass().getName(), Diagnostic.ERROR, e.getMessage(), null));
        }
    }

    public List<Diagnostic> validateOclQuery(EClassifier parsingContext, String queryToValidate) {
        queryToValidate = ContextAndForeachHelper.prepareOclQuery(queryToValidate, "__DUMMY__");
        try {
            oclHelper.setContext(parsingContext);
            oclHelper.createQuery(queryToValidate);

            //TODO distinguish between errors and warnings
            Diagnostic diagnostic = oclHelper.getProblems();
            if (diagnostic == null) {
                return Collections.emptyList();
            } else {
                
                return Collections.singletonList(diagnostic);
            }
        } catch (ParserException e) {
            return Collections.singletonList(e.getDiagnostic());
        } catch (RuntimeException e) {
            return Collections.singletonList((Diagnostic) new BasicDiagnostic(getClass().getName(), Diagnostic.ERROR, e.getMessage(), null));
        }
    }

    public EObject getOclReturnType(EClassifier parsingContext, String oclQuery) throws ParserException {
        oclQuery = ContextAndForeachHelper.prepareOclQuery(oclQuery, "__DUMMY__");
        oclHelper.setContext(parsingContext);
        return oclHelper.createQuery(oclQuery).getType();
    }
}
