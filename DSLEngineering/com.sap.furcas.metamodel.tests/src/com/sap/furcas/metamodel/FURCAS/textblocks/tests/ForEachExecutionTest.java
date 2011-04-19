/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.textblocks.tests;

import junit.textui.TestRunner;

import com.sap.furcas.metamodel.FURCAS.textblocks.ForEachExecution;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>For Each Execution</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ForEachExecutionTest extends TextBlockTest {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main(String[] args) {
        TestRunner.run(ForEachExecutionTest.class);
    }

    /**
     * Constructs a new For Each Execution test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ForEachExecutionTest(String name) {
        super(name);
    }

    /**
     * Returns the fixture for this For Each Execution test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected ForEachExecution getFixture() {
        return (ForEachExecution)fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        setFixture(TextblocksFactory.eINSTANCE.createForEachExecution());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#tearDown()
     * @generated
     */
    @Override
    protected void tearDown() throws Exception {
        setFixture(null);
    }

} //ForEachExecutionTest
