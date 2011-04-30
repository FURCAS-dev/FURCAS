package com.sap.furcas.referenceresolving.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.ParserException;
import org.junit.Test;


import com.sap.emf.ocl.trigger.TriggerManager;
import com.sap.furcas.example.bibtex.dsl.editor.Activator;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.runtime.referenceresolving.SyntaxRegistry;
import com.sap.furcas.runtime.syntaxprovider.SyntaxProvider;

public class TestSyntaxRegistry {
    @Test
    public void simpleEMFResourceContainmentTest() {
        ResourceSet rs1 = new ResourceSetImpl();
        ResourceSet rs2 = new ResourceSetImpl();
        Resource r = rs1.createResource(URI.createURI("http://something/r1"));
        assertEquals(rs1, r.getResourceSet());
        rs2.getResources().add(r);
        assertEquals(rs2, r.getResourceSet());
        assertFalse(rs1.getResources().contains(r)); // assuming that assigning resource to rs2 removed it from rs1 implicitly
    }
    
    @Test
    public void testGetSyntax() throws IOException, ParserException {
        SyntaxProvider bibtexProvider = Activator.getDefault();
        ConcreteSyntax syntax = bibtexProvider.getSyntax(null);
        assertNotNull(syntax);
        assertEquals("Bibtex", syntax.getName());
    }

    @Test
    public void testTriggerManagerRegisteredForResourceSet() throws IOException, ParserException {
        SyntaxProvider bibtexProvider = Activator.getDefault();
        TriggerManager tm = bibtexProvider.getTriggerManager(SyntaxRegistry.getInstance());
        assertNotNull(tm);
    }
}
