package org.eclipse.ocl.examples.impactanalyzer.benchmark;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Test;


public class AssertBenchmarkModelSizes {
    @Test
    public void testModelSizeForNgpmStdlibXmi() {
        Resource r = new ResourceSetImpl().createResource(
                URI.createPlatformPluginURI("/org.eclipse.ocl.examples.impactanalyzer.testutils/bin/org/eclipse/ocl/examples/impactanalyzer/benchmark/preparation/notifications/fixtures/models/NgpmModel.xmi",
                        /* encode */ false));
        computeAndAssertModelSize(r, 3803, 10176);
    }

    public void computeAndAssertModelSize(Resource r, int expectedNumberOfElements, int expectedNumberOfReferences) {
        Set<EObject> objects = new HashSet<EObject>();
        int resourceSize = 0;
        int proxies = 0;
        int refs = 0;
        try {
            r.load(null);
            TreeIterator<EObject> iterator = r.getAllContents();
            while(iterator.hasNext()){
                EObject eo = iterator.next();
                resourceSize++;
                assertEquals(r, eo.eResource());
                if (eo.eIsProxy()) {
                    proxies++;
                }
                if (!objects.contains(eo)) {
                    objects.add(eo);
                    refs += getNumberOfReferences(eo);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Distinct elements: "+objects.size());
        assertEquals(expectedNumberOfElements, objects.size());
        System.out.println("References: "+refs);
        assertEquals(expectedNumberOfReferences, refs);
        System.out.println("Elements in allContents iterator: " + resourceSize);
        System.out.println("Proxies: " + proxies);
    }
    
    private int getNumberOfReferences(EObject eo) {
        int result = 0;
        for (EReference r : eo.eClass().getEAllReferences()) {
            Object refValue = eo.eGet(r);
            if (refValue != null) {
                if (refValue instanceof Collection<?>) {
                    result += ((Collection<?>) refValue).size();
                } else {
                    result++;
                }
            }
        }
        return result;
    }

    @Test
    public void testModelSizeForNgpmStdlibWithCtsEditorTestsXmi() {
        Resource r = new ResourceSetImpl().createResource(
                URI.createPlatformPluginURI("/org.eclipse.ocl.examples.impactanalyzer.testutils/bin/org/eclipse/ocl/examples/impactanalyzer/benchmark/preparation/notifications/fixtures/models/NgpmModelWithCtsEditorTest.xmi",
                        /* encode */ false));
        computeAndAssertModelSize(r, 3979, 10699);
    }
}
