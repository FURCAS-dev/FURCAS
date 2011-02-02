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
 
package com.sap.furcas.referenceresolving.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.io.File;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Tests impact analysis behavior on renames using a simple language with nested scopes.
 * 
 * @author Sebastian Schlag (D049672)
 * 
 */

public class TestNestedScopesWithTextBlocks extends AbstractReferenceResolvingTestWithTextBlocks {
    
    private static final String LANGUAGE = "NestedScopesTestSyntax";
    private static final File TCS =  new File("fixtures/NestedScopes.tcs");
    private static final File METAMODEL = new File("fixtures/NestedScopes.ecore");
    private static final String MM_PACKAGE_URI = "http://www.furcas.org/TCS/referenceresolving/tests/nestedScopes";
    
    @BeforeClass
    public static void setupParser() throws Exception {
        setupParser(TCS, LANGUAGE, MM_PACKAGE_URI, METAMODEL);
    }
    
    @After
    public void removeModelFromResourceSet() {
        file.eResource().getContents().remove(file);
        resourceSet.getResources().remove(transientParsingResource);
        // make sure the next parser run isn't obstructed by an already subscribed trigger manager:
        triggerManager.removeFromObservedResourceSets(resourceSet);
    }
    
    /**
     * After renaming the innermost definition of "b" to "a", the usage should still be bound to this definition
     * (meaning that the usage is also renamed since it was directly bound to this definition).
     */
    @Test
    @Ignore("Does not seem to work at the moment.")
    public void  testUpateOfUsageAccordingToChangeOfDefinitionInInnerScope(){
        String sample = "{ def b;" + "{ def b; use b; }" + "}";
        setupFileFromTextToParse(sample);
        
        EObject bDefinitionInnerScope = getStatementNinBlockM(1, 1);
        EObject bUsageInnerScope = getStatementNinBlockM(2, 1);
        
        assertEquals("Definition", bDefinitionInnerScope.eClass().getName());
        assertEquals("b", bDefinitionInnerScope.eGet(bDefinitionInnerScope.eClass().getEStructuralFeature("name")));
        assertEquals("Usage", bUsageInnerScope.eClass().getName());
        assertSame(bUsageInnerScope.eGet(bUsageInnerScope.eClass().getEStructuralFeature("boundDefinition")),bDefinitionInnerScope);
        
        bDefinitionInnerScope.eSet(bDefinitionInnerScope.eClass().getEStructuralFeature("name"), "a");
       
        //TODO:
        //assertSame(bUsageInnerScope.eGet(bUsageInnerScope.eClass().getEStructuralFeature("boundDefinition")),bDefinitionInnerScope);
       
    }
    
    /**
     * After renaming the definition of "a" to "b", the usage's boundDefinition attribute
     * should be bound to the new definition of "b" inside the inner scope instead of being bound to 
     * the definition in the outer scope.
     */
    @Test
    public void testRebindingToDefinitionInInnerScope(){
        String sample = "{ def b;" + "{ def a; use b; }" + "}";
        setupFileFromTextToParse(sample);
        
        EObject bDefinitionOuterScope = getStatementNinBlockM(1, 0);
        EObject definitionInnerScope = getStatementNinBlockM(1, 1);
        EObject bUsageInnerScope = getStatementNinBlockM(2, 1);
        
        assertEquals("Definition", definitionInnerScope.eClass().getName());
        assertEquals("a", definitionInnerScope.eGet(definitionInnerScope.eClass().getEStructuralFeature("name")));
        assertEquals("Usage", bUsageInnerScope.eClass().getName());
        assertSame(bUsageInnerScope.eGet(bUsageInnerScope.eClass().getEStructuralFeature("boundDefinition")),bDefinitionOuterScope);
        
        definitionInnerScope.eSet(definitionInnerScope.eClass().getEStructuralFeature("name"), "b");
        assertEquals("b", definitionInnerScope.eGet(definitionInnerScope.eClass().getEStructuralFeature("name")));
        
        assertSame(bUsageInnerScope.eGet(bUsageInnerScope.eClass().getEStructuralFeature("boundDefinition")),definitionInnerScope);
       
    }
    
    public EObject getStatementNinBlockM(int n, int m) {
        EObject currentBlock = file;
        for (int nestingLevel = 0; nestingLevel < m; nestingLevel++) {
            @SuppressWarnings("unchecked")
            Collection<EObject> statements = (Collection<EObject>) currentBlock.eGet(currentBlock.eClass().getEStructuralFeature("statementsInBlock"));
            for (EObject statement : statements) {
                if (statement.eClass().getName().equals("Block")) {
                    currentBlock = statement;
                }
            }
        }
        @SuppressWarnings("unchecked")
        Collection<EObject> statmentsInBlockM = (Collection<EObject>) currentBlock.eGet(currentBlock.eClass().getEStructuralFeature("statementsInBlock"));
        return (EObject) statmentsInBlockM.toArray()[n-1];
    }

}
