package com.sap.furcas.referenceresolving.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.ParserException;
import org.junit.Test;

import bibtex.dsl.editor.Activator;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.runtime.syntaxprovider.SyntaxProvider;

public class TestSyntaxRegistry {
    @Test
    public void testGetSyntax() throws IOException, ParserException {
        SyntaxProvider bibtexProvider = Activator.getDefault();
        ConcreteSyntax syntax = bibtexProvider.getSyntax();
        assertNotNull(syntax);
        assertEquals("Bibtex", syntax.getName());
    }

    @Test
    public void testTriggerManagerRegisteredForResourceSet() throws IOException, ParserException {
        SyntaxProvider bibtexProvider = Activator.getDefault();
        ResourceSet rs = bibtexProvider.getResourceSet();
        assertNotNull(rs);
    }
}
