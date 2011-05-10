package com.sap.furcas.parser.tcs.syntaxmodel;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parser.tcs.TCSSyntaxDefinition;
import com.sap.furcas.parsergenerator.GrammarGenerationSourceConfiguration;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.test.testutils.ResourceTestHelper;

/**
 * This class tests if the containment settings are set correctly in the TCS metamodel.
 * If set correctly, the transient parsing resource should only contain one element,
 * namely the ConreteSyntax. This means, that the concrete syntax model forms a tree with
 * just one root element. 
 * 
 * @author Sebastian Schlag (D049672)
 * 
 */
public class TestContainmentTree extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "TCS";
    private static final File TCS = TCSSyntaxDefinition.TCS_TCS;
    private static final File[] METAMODELS = {};

    private static TCSSyntaxContainerBean syntaxBean;
    private static Resource resource; // The transient parsing resource that contains all model elements.



    @BeforeClass
    public static void setupParser() throws Exception {
        final Set<URI> ref = ResourceTestHelper.createFURCASReferenceScope();
        ref.addAll(ResourceTestHelper.createEcoreReferenceScope());
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS) {
            @Override
            public GrammarGenerationSourceConfiguration getSourceConfiguration() {
                return new GrammarGenerationSourceConfiguration(ResourceTestHelper.createResourceSet(), ref);
            }
        };
        syntaxBean = parseSyntax(testConfig);
    }

    @Test
    public void testContainment() throws Exception {
        resource = syntaxBean.getSyntax().eResource();
        List<EObject> roots= new ArrayList<EObject>(1);
        for (EObject eo : resource.getContents()) {
        	if (eo.eContainer() == null) {
        		roots.add(eo);
        	}
        }
        assertEquals("Resource contains more uncontained elements than the ConcreteSyntax", roots.size(), 1);
    }
}
