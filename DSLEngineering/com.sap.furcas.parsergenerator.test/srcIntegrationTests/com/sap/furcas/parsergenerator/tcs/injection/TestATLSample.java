package com.sap.furcas.parsergenerator.tcs.injection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.TCS.Associativity;
import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.EnumerationTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorList;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Priority;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.TCS.Token;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.test.fixture.ScenarioFixtureData;

public class TestATLSample extends AbstractTCSInjectionTest {

    @BeforeClass
    public static void doSetUp() throws Exception {
        setup(ScenarioFixtureData.ATL_TCS, ScenarioFixtureData.ATL_METAMODEL);
    }

    @Test
    public void testSyntax() {
        // now check the generated model is okay
        assertNotNull(syntax);
        assertEquals("ATL", syntax.getName());
        assertEquals(0, modelParsingResult.getErrors().size());
    }

    @Test
    public void testTemplates() {
        List<Template> templates = syntax.getTemplates();
        assertNotNull(templates);
        assertEquals(85, templates.size());

        int operatoredCount = 0;
        int enumerationCount = 0;
        int classCount = 0;

        for (Template template : templates) {
            if (template instanceof ClassTemplate) {
                // ClassTemplate new_name = (ClassTemplate) template;
                classCount++;
            } else if (template instanceof EnumerationTemplate) {
                // ClassTemplate new_name = (ClassTemplate) template;
                enumerationCount++;
            } else if (template instanceof OperatorTemplate) {
                // ClassTemplate new_name = (ClassTemplate) template;
                operatoredCount++;
            }
        }
        assertEquals(74, classCount);
        assertEquals(0, enumerationCount);
        assertEquals(6, operatoredCount);
    }

    /**
     * test against bugs in operator List parsing
     */
    @Test
    public void testOperatorList() {
        List<OperatorList> opListList = syntax.getOperatorLists();
        assertNotNull(opListList);
        assertEquals(1, opListList.size());

        OperatorList opList = opListList.get(0);
        assertNotNull(opList);
        assertNull(opList.getName());

        List<Priority> prioList = opList.getPriorities();
        assertNotNull(prioList);
        assertEquals(6, prioList.size());

        Priority prio0 = prioList.get(0);
        assertNotNull(prio0);
        assertEquals(new Integer(0), prio0.getValue());
        assertEquals(Associativity.LEFT, prio0.getAssociativity());
        assertEquals(2, prio0.getOperators().size());
        assertEquals(new Integer(2), prio0.getOperators().get(0).getArity());
        assertEquals(new Integer(2), prio0.getOperators().get(1).getArity());

        Priority prio1 = prioList.get(1);
        assertNotNull(prio1);
        assertEquals(new Integer(1), prio1.getValue());
        assertEquals(Associativity.LEFT, prio1.getAssociativity());
        assertEquals(2, prio1.getOperators().size());
        assertEquals(new Integer(1), prio1.getOperators().get(0).getArity());
        assertEquals(new Integer(1), prio1.getOperators().get(1).getArity());

    }
    
    /**
     * Expects: <TCS:Keyword location="26:5-26:14" literalRefs="/0/@templates.3/@templateSequence/@elements.0" value="article"/>
     * <TCS:Keyword location="36:5-36:13" literalRefs="/0/@templates.5/@templateSequence/@elements.0" value="author"/>
     * <TCS:Keyword location="36:14-36:17"
     * literalRefs="/0/@templates.5/@templateSequence/@elements.1 /0/@templates.6/@templateSequence/@elements.1" value="="/>
     * <TCS:Keyword location="36:23-36:26" literalRefs="/0/@templates.5/@templateSequence/@elements.3" value="."/> <TCS:Keyword
     * location="40:5-40:11" literalRefs="/0/@templates.6/@templateSequence/@elements.0" value="year"/>
     * 
     * @throws ModelAdapterException
     */
    @Test
    public void testKeywords() throws ModelAdapterException {
        assertEquals(57, syntax.getKeywords().size());
    }

    @Test
    public void testTokens() {

        List<Token> tokens = syntax.getTokens();
        assertNotNull(tokens);
        assertEquals(1, tokens.size());
    }

}
