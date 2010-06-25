package com.sap.ocl.oppositefinder.query2;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.query2.QueryContext;

/**
 * Can provide an EMF query2 context that describes what's visible for a query,
 * starting at a given element. The provider implementation may use the element
 * to determine, based on visibility and modularization rules, what can be seen
 * by the query.
 * 
 * @author Axel Uhl
 *
 */
public interface QueryContextProvider {
        QueryContext getQueryContext(EObject eObject);
}
