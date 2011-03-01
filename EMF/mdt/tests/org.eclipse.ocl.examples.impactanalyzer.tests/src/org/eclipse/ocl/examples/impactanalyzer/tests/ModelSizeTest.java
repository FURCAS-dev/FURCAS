package org.eclipse.ocl.examples.impactanalyzer.tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Test;


public class ModelSizeTest {
    @Test
    public void testModelSizeForNgpmStdlibXmi() {
        Resource r = new ResourceSetImpl().createResource(
                URI.createFileURI("C:\\Users\\d043530\\git\\EMF\\mdt\\tests\\org.eclipse.ocl.examples.impactanalyzer.testutils\\src\\org\\eclipse\\ocl\\examples\\impactanalyzer\\benchmark\\preparation\\notifications\\fixtures\\models\\NgpmModel.xmi"));
        computeAndPrintModelSize(r);
    }

    public void computeAndPrintModelSize(Resource r) {
        Set<EObject> objects = new HashSet<EObject>();
        int resourceSize = 0;
        int proxies = 0;
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
                } else {
                    System.err.println(eo+" visited twice");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Distinct elements: "+objects.size());
        System.out.println("Elements in allContents iterator: " + resourceSize);
        System.out.println("Proxies: " + proxies);
    }

    @Test
    public void testModelSizeForNgpmStdlibWithCtsEditorTestsXmi() {
        Resource r = new ResourceSetImpl().createResource(
                URI.createFileURI("C:\\Users\\d043530\\git\\EMF\\mdt\\tests\\org.eclipse.ocl.examples.impactanalyzer.testutils\\src\\org\\eclipse\\ocl\\examples\\impactanalyzer\\benchmark\\preparation\\notifications\\fixtures\\models\\NgpmModelWithCtsEditorTest.xmi"));
        computeAndPrintModelSize(r);
    }
}
