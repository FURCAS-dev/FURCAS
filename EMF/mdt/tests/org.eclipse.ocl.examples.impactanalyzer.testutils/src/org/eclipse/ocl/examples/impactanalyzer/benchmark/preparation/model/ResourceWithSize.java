package org.eclipse.ocl.examples.impactanalyzer.benchmark.preparation.model;

import org.eclipse.emf.ecore.xmi.XMLResource;

public interface ResourceWithSize extends XMLResource {
    /**
     * Returns the number of model elements contained in this resource; the resource class
     * implementing this interface should contemplate caching the results
     */
    int getSize();
}
