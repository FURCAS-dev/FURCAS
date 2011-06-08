package com.sap.furcas.ide.editor.contentassist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.antlr.runtime.ClassicToken;
import org.antlr.runtime.Token;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Before;
import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.parser.tcs.TCSParserFactory;

public class TestCtsContentAssistParsingHandler {

    CtsContentAssistParsingHandler handler;

    @Before
    public void initParsingHandler() {
        ResourceSet resourceSet = new ResourceSetImpl();
        TCSParserFactory factory = new TCSParserFactory();
        ConcreteSyntax tcsSyntax = (ConcreteSyntax) resourceSet.getEObject(URI.createURI(factory.getSyntaxUUID()), /*load*/true);
        assertNotNull(tcsSyntax);
        handler = new CtsContentAssistParsingHandler(tcsSyntax, resourceSet);
    }

    @Test
    public void testGetFloorTokenNull() {
        Token token = new ClassicToken(0, "a");
        CtsContentAssistContext context = new CtsContentAssistContext();
        context.setToken(token);

        handler.getPositionMap().put(new TextPosition(1, 0), context);

        assertEquals(null, handler.getFloorContext(0, 0));
    }

    @Test
    public void testGetFloorTokenDifferentLine() {

        Token token = new ClassicToken(0, "a");
        CtsContentAssistContext contextA = new CtsContentAssistContext();
        contextA.setToken(token);

        handler.getPositionMap().put(new TextPosition(0, 0), contextA);

        token = new ClassicToken(0, "b");
        CtsContentAssistContext contextB = new CtsContentAssistContext();
        contextB.setToken(token);

        handler.getPositionMap().put(new TextPosition(1, 10), contextB);

        assertEquals(contextA, handler.getFloorContext(0, 0));
        assertEquals(contextA, handler.getFloorContext(0, 15));
        assertEquals(contextA, handler.getFloorContext(1, 0));
        assertEquals(contextB, handler.getFloorContext(1, 10));
        assertEquals(contextB, handler.getFloorContext(1, 15));

    }

    @Test
    public void testGetFloorTokenSameLine() {
        Token token = new ClassicToken(0, "a");
        CtsContentAssistContext contextA = new CtsContentAssistContext();
        contextA.setToken(token);

        handler.getPositionMap().put(new TextPosition(0, 0), contextA);

        token = new ClassicToken(0, "b");
        CtsContentAssistContext contextB = new CtsContentAssistContext();
        contextB.setToken(token);

        handler.getPositionMap().put(new TextPosition(0, 10), contextB);

        assertEquals(contextA, handler.getFloorContext(0, 0));
        assertEquals(contextA, handler.getFloorContext(0, 9));
        assertEquals(contextB, handler.getFloorContext(0, 10));
        assertEquals(contextB, handler.getFloorContext(1, 0));
        assertEquals(contextB, handler.getFloorContext(1, 15));
    }
}
