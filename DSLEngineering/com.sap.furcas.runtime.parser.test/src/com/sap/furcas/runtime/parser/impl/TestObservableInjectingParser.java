/**
 * 
 */
package com.sap.furcas.runtime.parser.impl;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.TokenStream;
import org.junit.Test;

import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.interfaces.IModelElementInvestigator;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;
import com.sap.furcas.runtime.parser.impl.context.AmbiguousLookupException;
import com.sap.furcas.runtime.parser.impl.context.ContextManager;
import com.sap.furcas.test.testutils.StringListHelper;
import com.sap.furcas.test.testutils.StubTokenStream;


/**
 *
 */
public class TestObservableInjectingParser {

    @Test
    public void testCreateModelElementProxyNoContext() throws Exception {
        GeneratedParser testParser = new GeneratedParser(new StubTokenStream(), null);
        
        testParser.createModelElementProxy(StringListHelper.list("test", "class"), false, false);
    }
    
    @Test
    public void testCreateModelElementProxyAddToContextException() throws Exception {
        GeneratedParser testParser = new GeneratedParser(new StubTokenStream(), null);
        
        
        boolean caught = false;
        try {
            testParser.createModelElementProxy(StringListHelper.list("test", "class"), false, true);
        } catch (RuntimeException e) {
            caught = true;
        }
        assertTrue("No exception despite entering context without root context", caught);    
    }
    
    @Test
    public void testCreateModelElementProxyAddToContext() throws Exception {
        GeneratedParser testParser = new GeneratedParser(new StubTokenStream(), null);

        IModelElementProxy rootProxy = testParser.createModelElementProxy(StringListHelper.list("test", "class"), true, false);
        IModelElementProxy addedProxy = testParser.createModelElementProxy(StringListHelper.list("test", "class2"), false, true);

        assertNotNull(rootProxy);
        assertEquals(1, testParser.contextMock.rootElements.size());
        assertEquals(rootProxy, testParser.contextMock.rootElements.get(0));
        
        assertEquals(0, testParser.contextMock.subcontextLinks.size());
        
        assertEquals(1, testParser.contextMock.inContextLinks.size());
        assertEquals(rootProxy, testParser.contextMock.inContextLinks.get(0).contextElement);
        assertEquals(addedProxy, testParser.contextMock.inContextLinks.get(0).newElement);
    }
    
    @Test
    public void testCreateModelElementProxyIsRootContext() throws Exception {
        GeneratedParser testParser = new GeneratedParser(new StubTokenStream(), null);
        
        IModelElementProxy proxy = testParser.createModelElementProxy(StringListHelper.list("test", "class"), true, false);
        assertNotNull(proxy);
        assertEquals(1, testParser.contextMock.rootElements.size());
        assertEquals(proxy, testParser.contextMock.rootElements.get(0));
        
        
    }
    
    @Test
    public void testCreateModelElementProxyIsSubContext() throws Exception {
        GeneratedParser testParser = new GeneratedParser(new StubTokenStream(), null);
        
        IModelElementProxy proxy = testParser.createModelElementProxy(StringListHelper.list("test", "class"), true, false);
        IModelElementProxy subproxy = testParser.createModelElementProxy(StringListHelper.list("test", "class"), true, false);
        assertNotNull(subproxy);
        assertEquals(1, testParser.contextMock.rootElements.size());
        assertEquals(proxy, testParser.contextMock.rootElements.get(0));
     
        assertEquals(0, testParser.contextMock.inContextLinks.size());
        
        assertEquals(1, testParser.contextMock.subcontextLinks.size());
        assertEquals(proxy, testParser.contextMock.subcontextLinks.get(0).supercontextElement);
        assertEquals(subproxy, testParser.contextMock.subcontextLinks.get(0).subContextElement);
    }
    
    
    
    
    private class GeneratedParser extends ObservableInjectingParser {

        public ContextManagerMock contextMock;

        /**
         * @param input
         * @param newState 
         */
        public GeneratedParser(TokenStream input, RecognizerSharedState newState) {
            super(input, newState);
        }

        /* (non-Javadoc)
         * @see com.sap.mi.textual.grammar.impl.ObservableInjectingParser#main()
         */
        @Override
        public Object main() throws RecognitionException {
            return null;
        }

        @Override
        protected ContextManager initContextManager() {
            contextMock = new ContextManagerMock();
            return contextMock;
        }
        
        @Override
        public  final IModelElementProxy createModelElementProxy(
                List<String> name, boolean context, boolean addToContext) {
                return super.createModelElementProxy(name, context, addToContext);
        }
        
    }
    
    class ContextManagerMock extends ContextManager {

        public List<IModelElementProxy> rootElements = new ArrayList<IModelElementProxy>();
        public ArrayList<SimpleContextLink> inContextLinks = new ArrayList<SimpleContextLink>();
        public ArrayList<SubContextLink> subcontextLinks = new ArrayList<SubContextLink>();

        @Override
        public void addContextChildFor(IModelElementProxy parentContextElement,
                IModelElementProxy newChildElement, String[] tags) {
            SubContextLink contextLink = new SubContextLink(parentContextElement, newChildElement);
            subcontextLinks.add(contextLink);
        }

        @Override
        public void addRootContext(IModelElementProxy newChildElement, String[] tags) {
            rootElements.add(newChildElement);
//            super.addRootContext(newChildElement);
        }

        @Override
        public void addToContext(Object contextElement, Object newElement) {
            SimpleContextLink context = new SimpleContextLink(contextElement, newElement);
            inContextLinks.add(context);
        }

 
        @Override
        public void discardProxy(Object proxy,
                IModelElementProxy creationContextElement) {
            fail("not implemented yet.");
            super.discardProxy(proxy, creationContextElement);
        }

        @Override
        public Object findCandidatesInContext(IModelElementInvestigator modelAdapter,
                Object contextElement, List<String> valueTypeName, String keyName,
                Object keyValue) throws ModelAdapterException,
                AmbiguousLookupException {
            fail("not implemented yet.");
            return super.findCandidatesInContext(modelAdapter, contextElement,
                    valueTypeName, keyName, keyValue);
        }

        @Override
        public Object getContextForElement(Object navigatedObject) {
            fail("not implemented yet.");
            return super.getContextForElement(navigatedObject);
        }

        @Override
        public Object getContextParent(Object contextElement) {
            fail("not implemented yet.");
            return super.getContextParent(contextElement);
        }

        @Override
        public Object getTaggedContext(Object contextElement, String tag) {
            fail("not implemented yet.");
            return super.getTaggedContext(contextElement, tag);
        }

        @Override
        public boolean hasInTextContext(Object navigatedContext) {
            fail("not implemented yet.");
            return super.hasInTextContext(navigatedContext);
        }

        @Override
        public void notifyProxyResolvedWith(IModelElementProxy proxy,
                Object realElement, IModelElementProxy creationContextElement) {
            fail("not implemented yet.");
            super.notifyProxyResolvedWith(proxy, realElement, creationContextElement);
        }

        @Override
        public void setContextImport(Object modelElement, Object realValue) {
            fail("not implemented yet.");
            super.setContextImport(modelElement, realValue);
        }
        
    }
    
    class SimpleContextLink {

        public Object contextElement;
        public Object newElement;

        /**
         * @param contextElement
         * @param newElement
         */
        public SimpleContextLink(Object contextElement, Object newElement) {
           this.contextElement = contextElement;
           this.newElement = newElement;
        }
        
    }
    
    class SubContextLink {

        public Object supercontextElement;
        public Object subContextElement;

        /**
         * @param contextElement
         * @param newElement
         */
        public SubContextLink(Object contextElement, Object newElement) {
           this.supercontextElement = contextElement;
           this.subContextElement = newElement;
        }
        
    }
}
