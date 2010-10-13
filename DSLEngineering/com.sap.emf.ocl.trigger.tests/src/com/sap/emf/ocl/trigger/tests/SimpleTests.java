package com.sap.emf.ocl.trigger.tests;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Before;
import org.junit.Test;

public class SimpleTests extends TestCase {
    private ResourceSet resourceSet;
    private Resource resource;
    
    @Before
    public void setUp() {
        resourceSet = new ResourceSetImpl();
        resource = resourceSet.createResource(URI.createURI("http://com.sap.emf.ocl.trigger.tests/Resource.xmi"));
    }
    
    @Test
    public void testTrivialTrigger() {
        
    }
}
