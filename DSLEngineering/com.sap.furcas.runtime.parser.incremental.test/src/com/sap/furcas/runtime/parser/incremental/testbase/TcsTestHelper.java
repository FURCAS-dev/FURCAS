package com.sap.furcas.runtime.parser.incremental.testbase;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import org.antlr.runtime.Lexer;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;

import com.sap.furcas.parser.tcs.TCSParserFactory;
import com.sap.furcas.runtime.common.exceptions.ParserInstantiationException;
import com.sap.furcas.runtime.parser.ParserFactory;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.test.testutils.ResourceTestHelper;
import com.sap.ide.cts.parser.incremental.IncrementalParserFacade;

public class TcsTestHelper {

    public static String getStreamContents(InputStream in) {
        assertNotNull(in);

        try {
            StringBuffer out = new StringBuffer();
            byte[] b = new byte[4096];
            for (int n; (n = in.read(b)) != -1;) {
                out.append(new String(b, 0, n));
            }
            return out.toString();
        } catch (IOException e) {
            e.printStackTrace();
            fail("error reading fixture");
            return null;
        }
    }

    public static IncrementalParserFacade createTCSIncrementalParserFacade() throws ParserInstantiationException {
        ResourceSet resourceSet = ResourceTestHelper.createResourceSet();
        Resource transientParsingResource = ResourceTestHelper.createTransientResource(resourceSet);

        ECrossReferenceAdapter crossRefAdapter = new ECrossReferenceAdapter();
        resourceSet.eAdapters().add(crossRefAdapter);
        crossRefAdapter.setTarget(resourceSet);
        
        ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory = new TCSParserFactory() {
            /**
             * We must be able to reference the metamodels to which the different TCS
             * languages that we parse refer to. In this case this is TCS itself.
             */
            @Override
            public Set<URI> getAdditionalQueryScope() {
                return this.getMetamodelURIs();
            }
        };

        return new IncrementalParserFacade(parserFactory, resourceSet,
                new MockPartitionAssignmentHandler(transientParsingResource));
    }

}
