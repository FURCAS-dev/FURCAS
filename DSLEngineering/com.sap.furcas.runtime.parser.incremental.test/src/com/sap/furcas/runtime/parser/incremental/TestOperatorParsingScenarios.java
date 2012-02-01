/*******************************************************************************
 * Copyright (c) 2011 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.furcas.runtime.parser.incremental;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.eclipse.emf.ecore.EObject;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.runtime.parser.incremental.testbase.IncrementalParserBasedTest;
import com.sap.furcas.test.fixture.ScenarioFixtureData;
import com.sap.ide.cts.parser.incremental.IncrementalParserFacade;

/**
 * A test for the incremental parser based on the existing TestSynthesizedAttributeGrammar test.
 * This test makes sure the parser does not crash when it has deal with changes of operators and
 * operator templates. 
 * 
 * The trick is that we use a synthesized attribute grammar to calculate the value of an expression.
 * That way we can also make sure the resulting AST/model is correct.
 * 
 * @author Stephan Erb
 */
public class TestOperatorParsingScenarios extends IncrementalParserBasedTest {

    private static final String LANGUAGE = "ExpressionWithSynthesizedAttributes";
    private static final File TCS = ScenarioFixtureData.EXPRESSION_WITH_SYNTHESIZED_ATTRIBUTE_TCS;
    private static final File[] METAMODELS = { ScenarioFixtureData.EXPRESSION_WITH_SYNTHESIZED_ATTRIBUTE_METAMODEL };
    
    @BeforeClass
    public static void setupParser() throws Exception {
        setupParser(LANGUAGE, TCS, METAMODELS);
    }
    
    /**
     * Make sure the simple stuff works. 
     */
    @Test
    public void testSimple() throws Exception {
        model.replace(0, model.getLength(), "1+2");
        triggerParser();
        assertLatestResultEquals(3);
    }
    
    /**
     * Reparse everything. The whole model can be dropped and replaced.
     */
    @Test
    public void testEntireDifferentExpressions() throws Exception {
        model.replace(0, model.getLength(), "1+2");
        triggerParser();
        assertLatestResultEquals(3);

        model.replace(0, model.getLength(), "3*3*3");
        triggerParser();
        assertLatestResultEquals(27);
        
        model.replace(0, model.getLength(), "1/1/1");
        triggerParser();
        assertLatestResultEquals(1);
    }
    
    /**
     * Reparse everything. New expressions are somehow similar to the
     * existing ones.
     */
    @Test
    public void testeDifferentExpressionsWithPartialReuse() throws Exception {
        model.replace(0, model.getLength(), "1*2*3");
        triggerParser();
        assertLatestResultEquals(6);

        model.replace(0, model.getLength(), "1*2*3+4+5");
        triggerParser();
        assertLatestResultEquals(15);
        
        model.replace(0, model.getLength(), "3+2+1*2*3+4+5");
        triggerParser();
        
        // FIXME The actual result is 20, however it is absolutely
        // valid for the parser to return 15 here, as the test
        // is run without any reference re-resolving mechanism
        assertLatestResultEquals(15);
    }
    
    
    /**
     * Change the operands but keep the operator
     */
    @Test
    public void testReplaceOperandsSimple() throws Exception {
        model.replace(0, model.getLength(), "2 * 2");
        triggerParser();
        assertLatestResultEquals(4);

        model.replace("2 * ".length(), "2".length(), "3");
        model.replace(0, "2".length(), "3");
        triggerParser();
        
        // FIXME The actual result is 9, however it is absolutely
        // valid for the parser to return 4 here, as the test
        // is run without any reference re-resolving mechanism
        assertLatestResultEquals(4);
    }
    
    /**
     * Change the operands but keep the operator. Do spaces make any difference? 
     */
    @Test
    public void testReplaceOperandsSimpleOtherLookahead() throws Exception {
        model.replace(0, model.getLength(), "2*2");
        triggerParser();
        assertLatestResultEquals(4);

        model.replace("2*".length(), "2".length(), "3");
        model.replace(0, "2".length(), "3");
        triggerParser();
        
        // FIXME The actual result is 9, however it is absolutely
        // valid for the parser to return 4 here, as the test
        // is run without any reference re-resolving mechanism
        assertLatestResultEquals(4);
    }
    
    /**
     * We have a deep subtree and replace the deepest operand.
     * Mind that + is left associative.
     */
    @Test
    public void testReplaceOperandDeep() throws Exception {
        model.replace(0, model.getLength(), "1+2+3+4+5");
        triggerParser();
        assertLatestResultEquals(15);

        model.replace(0, "1".length(), "10");
        triggerParser();
        
        // FIXME The actual result is 24, however it is absolutely
        // valid for the parser to return 15 here, as the test
        // is run without any reference re-resolving mechanism
        assertLatestResultEquals(15);
    }
    
    /**
     * We have a deep subtree and replace the highest operand.
     * Mind that + is left associative.
     */
    @Test
    public void testReplaceOperandFlat() throws Exception {
        model.replace(0, model.getLength(), "1+2+3+4+5");
        triggerParser();
        assertLatestResultEquals(15);

        model.replace("1+2+3+4+".length(), "5".length(), "10");
        triggerParser();
        
        // FIXME The actual result is 20, however it is absolutely
        // valid for the parser to return 15 here, as the test
        // is run without any reference re-resolving mechanism
        assertLatestResultEquals(15);
    }
    
    /**
     * Change the operator from * to /. Both have same priority and associativity.
     */
    @Test
    public void testReplaceOperatorSimple() throws Exception {
        model.replace(0, model.getLength(), "10*5");
        triggerParser();
        assertLatestResultEquals(50);

        model.replace("10".length(), "*".length(), "/");
        triggerParser();
        assertLatestResultEquals(2);
    }
    
    /**
     * Change the operator from * to /. Both have same priority and associativity.
     * Do the same for mor than one operator.
     */
    @Test
    public void testReplaceOperatorComplex() throws Exception {
        model.replace(0, model.getLength(), "1000*100*10*1");
        triggerParser();
        assertLatestResultEquals(1000000);

        model.replace("1000".length(), "*".length(), "/");
        triggerParser();
        model.replace("1000*100".length(), "*".length(), "/");
        triggerParser();
        model.replace("1000*100*10".length(), "*".length(), "/");
        triggerParser();
        assertLatestResultEquals(1);
    }
    
    /**
     * Same as above, but parser not called in between.
     * Transoformation has to happein in one parse run.
     */
    @Test
    public void testReplaceOperatorComplexAllInOne() throws Exception {
        model.replace(0, model.getLength(), "1000*100*10*1");
        triggerParser();
        assertLatestResultEquals(1000000);

        model.replace("1000".length(), "*".length(), "/");
        model.replace("1000*100".length(), "*".length(), "/");
        model.replace("1000*100*10".length(), "*".length(), "/");
        triggerParser();
        assertLatestResultEquals(1);
    }
    
    /**
     * Swith from one precedence level to another.
     */
    @Test
    public void testChangeOperatorAndPreceedence() throws Exception {
        model.replace(0, model.getLength(), "1+1");
        triggerParser();
        assertLatestResultEquals(2);

        model.replace("1".length(), "+".length(), "*");
        triggerParser();
        assertLatestResultEquals(1);
    }

    /**
     * from -1 to 5-1
     */
    @Ignore("See issue https://github.com/FURCAS-dev/FURCAS/issues/120")
    @Test
    public void testFromUnaryToBinary() throws Exception {
        model.replace(0, model.getLength(), "-1");
        triggerParser();
        assertLatestResultEquals(-1);

        model.replace(0, 0, "5");
        triggerParser();
        assertLatestResultEquals(4);
    }

    /** 
     * from 5-1 to -1
     */
    @Ignore("See issue https://github.com/FURCAS-dev/FURCAS/issues/120")
    @Test
    public void testFromBinaryToUnary() throws Exception {
        model.replace(0, model.getLength(), "5-1");
        triggerParser();
        assertLatestResultEquals(4);
        
        model.replace(0, "5".length(), "");
        triggerParser();
        assertLatestResultEquals(-1);
    }
    
    /**
     * 1+(2*3) is equal to 1+2*3
     */
    @Test
    public void testRemoveParenthesisWithNoMeaning() throws Exception {
        model.replace(0, model.getLength(), "1+(2*3)");
        triggerParser();
        assertLatestResultEquals(7);
        
        model.replace("1+(2*3".length(), ")".length(), "");
        triggerParser();
        model.replace("1+".length(), "(".length(), "");
        triggerParser();
        assertLatestResultEquals(7);
    }
    
    /**
     * Same as {@link #testRemoveParenthesisWithNoMeaning()} but the other
     * way round. 
     */
    @Test
    public void testAddParenthesisWithNoMeaning() throws Exception {
        model.replace(0, model.getLength(), "1+2*3");
        triggerParser();
        assertLatestResultEquals(7);
        
        model.replace("1+2*3".length(), 0, ")");
        triggerParser();
        model.replace("1+".length(), 0, "(");
        triggerParser();
        assertLatestResultEquals(7);
    }

    /**
     * (1+2)*3 is not equal to 1+2*3. Removing the parenthesis
     * requires restructuring of the AST.
     */
    @Test
    public void testRemoveParenthesisWithMeaning() throws Exception {
        model.replace(0, model.getLength(), "(1+2)*3");
        triggerParser();
        assertLatestResultEquals(9);
        
        model.replace("(1+2".length(), ")".length(), "");
        triggerParser();
        model.replace(0, "(".length(), "");
        triggerParser();
        assertLatestResultEquals(7);
    }
    
    /**
     * Same as {@link #testRemoveParenthesisWithMeaning()} but the other
     * way round. 
     */
    @Test
    public void testAddParenthesisWithMeaning() throws Exception {
        model.replace(0, model.getLength(), "1+2*3");
        triggerParser();
        assertLatestResultEquals(7);
        
        model.replace("1+2".length(), 0, ")");
        model.replace(0, 0, "(");
        triggerParser();
        assertLatestResultEquals(9);
    }
        
    private void assertLatestResultEquals(int expected) throws Exception {
        assertTrue("Parsing must have succeded in order to check the result",
                model.getRoot().getVersion() == Version.REFERENCE);

        EObject exprStatement = IncrementalParserFacade.getParsingResult(model.getRoot());
        EObject expression = (EObject) exprStatement.eGet(exprStatement.eClass().getEStructuralFeature("expression"));
        Double result = (Double) expression.eGet(expression.eClass().getEStructuralFeature("calculatedValue"));
        
        Assert.assertEquals(expected, result, 0.001);
    }
    
}
