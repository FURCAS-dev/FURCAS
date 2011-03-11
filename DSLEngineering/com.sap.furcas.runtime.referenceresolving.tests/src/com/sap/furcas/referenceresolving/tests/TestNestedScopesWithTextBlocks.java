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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import java.io.File;
import java.util.Collection;

import javax.management.InstanceAlreadyExistsException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.ecore.opposites.DefaultOppositeEndFinder;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage;
import com.sap.furcas.metamodel.FURCAS.textblocks.impl.LexedTokenImpl;
import com.sap.furcas.metamodel.FURCAS.textblocks.impl.TextBlockImpl;
import com.sap.furcas.runtime.parser.textblocks.TbParsingUtil;
import com.sap.furcas.runtime.textblocks.TbUtil;
import com.sap.furcas.runtime.textblocks.model.TextBlocksModel;
import com.sap.furcas.runtime.textblocks.modifcation.TbChangeUtil;
import com.sap.furcas.runtime.textblocks.modifcation.TbMarkingUtil;
import com.sap.furcas.runtime.textblocks.modifcation.TbReplacingHelper;
import com.sap.furcas.runtime.textblocks.modifcation.TbVersionUtil;
import com.sap.furcas.runtime.textblocks.testutils.TestSourceTextBlockCreator;

/**
 * Tests NestedScopes TCS and metamodel and impact analysis behavior on renames using the NestedScopes language.
 * 
 * @author Sebastian Schlag (D049672)
 * 
 */

public class TestNestedScopesWithTextBlocks extends AbstractReferenceResolvingTestWithTextBlocks {

    private static final String LANGUAGE = "NestedScopesTestSyntax";
    private static final File TCS = new File("fixtures/NestedScopes.tcs");
    private static final File METAMODEL = new File("fixtures/NestedScopes.ecore");
    private static final String MM_PACKAGE_URI = "http://www.furcas.org/TCS/referenceresolving/tests/nestedScopes";

    private enum RenameOn { MODEL, TEXTBLOCK };

    @BeforeClass
    public static void setupParser() throws Exception {
        setupParser(TCS, LANGUAGE, MM_PACKAGE_URI, METAMODEL);
    }

    @After
    public void removeModelFromResourceSet() {
        rootElement.eResource().getContents().remove(rootElement);
        resourceSet.getResources().remove(transientParsingResource);
        // make sure the next parser run isn't obstructed by an already subscribed trigger manager:
        triggerManager.removeFromObservedResourceSets(resourceSet);
    }

    /**
     * TCS and metamodel test: Usages should be bound to the corresponding definition.
     */
    @Test
    public void testResolvableBindingsBasicExample() throws Exception {
        String sample = "{ def a; use a;" + "{ def b; use b; }" + "}";
        setupModelFromTextToParse(sample);
        assertNotNull(rootElement);

        EObject defA = getStatementNonNestingLevelM(1, 0);
        assertEquals("Definition", defA.eClass().getName());
        assertEquals("a", defA.eGet(defA.eClass().getEStructuralFeature("name")));

        EObject useA = getStatementNonNestingLevelM(2, 0);
        assertEquals("Usage", useA.eClass().getName());
        assertSame(useA.eGet(useA.eClass().getEStructuralFeature("boundDefinition")), defA);

        EObject defB = getStatementNonNestingLevelM(1, 1);
        assertEquals("Definition", defB.eClass().getName());
        assertEquals("b", defB.eGet(defB.eClass().getEStructuralFeature("name")));

        EObject useB = getStatementNonNestingLevelM(2, 1);
        assertEquals("Usage", useB.eClass().getName());
        assertSame(useB.eGet(useB.eClass().getEStructuralFeature("boundDefinition")), defB);

    }

    /**
     * TCS and metamodel test: Definition of a should not be visible outside the inner scope. Therefore the boundDefinition
     * property of Usage "a" should not be set.
     */
    @Test
    public void testDefinitionNotVisibleOutsideOfScope() {
        String sample = "{" + "{ def a; }" + "use a; }";
        setupModelFromTextToParse(sample);
        assertNotNull(rootElement);

        EObject useA = getStatementNonNestingLevelM(2, 0);
        assertEquals("Usage", useA.eClass().getName());
        assertFalse(useA.eIsSet((useA.eClass().getEStructuralFeature("boundDefinition"))));

    }

    /**
     * TCS and metamodel test: "Use before declaration" should not be possible.
     */
    @Test
    public void testUseBeforeDeclaration() {
        String sample = "{use a; def a;}";
        setupModelFromTextToParse(sample);
        assertNotNull(rootElement);

        EObject useA = getStatementNonNestingLevelM(1, 0);
        assertEquals("Usage", useA.eClass().getName());
        assertFalse(useA.eIsSet((useA.eClass().getEStructuralFeature("boundDefinition"))));

    }

    /**
     * TCS and metamodel test: Usage should be bound to the innermost definition of a.
     */
    @Test
    public void testShadowing() {
        String sample = "{ def a;" + "{def a; use a;}" + "}";
        setupModelFromTextToParse(sample);
        assertNotNull(rootElement);

        EObject firstDefA = getStatementNonNestingLevelM(1, 0);
        assertEquals("Definition", firstDefA.eClass().getName());
        assertEquals("a", firstDefA.eGet(firstDefA.eClass().getEStructuralFeature("name")));

        EObject secondDefA = getStatementNonNestingLevelM(1, 1);
        assertEquals("Definition", secondDefA.eClass().getName());
        assertEquals("a", secondDefA.eGet(secondDefA.eClass().getEStructuralFeature("name")));

        EObject useA = getStatementNonNestingLevelM(2, 1);
        assertEquals("Usage", useA.eClass().getName());
        assertSame(useA.eGet(useA.eClass().getEStructuralFeature("boundDefinition")), secondDefA);
        assertNotSame(useA.eGet(useA.eClass().getEStructuralFeature("boundDefinition")), firstDefA);

    }

    /**
     * After renaming the definition of "a" to "b", the usage's boundDefinition attribute should be bound to the new definition of
     * "b" inside the inner scope instead of being bound to the definition in the outer scope.
     */
    @Test
    public void testRebindingToDefinitionInInnerScope() {
        String sample = "{ def b;" + "{ def a; use b; }" + "}";
        setupModelFromTextToParse(sample);
        assertNotNull(rootElement);

        EObject bDefinitionOuterScope = getStatementNonNestingLevelM(1, 0);
        EObject definitionInnerScope = getStatementNonNestingLevelM(1, 1);
        EObject bUsageInnerScope = getStatementNonNestingLevelM(2, 1);

        assertEquals("Definition", definitionInnerScope.eClass().getName());
        assertEquals("a", definitionInnerScope.eGet(definitionInnerScope.eClass().getEStructuralFeature("name")));
        assertEquals("Usage", bUsageInnerScope.eClass().getName());
        assertSame(bUsageInnerScope.eGet(bUsageInnerScope.eClass().getEStructuralFeature("boundDefinition")),bDefinitionOuterScope);

        renameDefinition(definitionInnerScope, "b", RenameOn.MODEL);
        assertEquals("b", definitionInnerScope.eGet(definitionInnerScope.eClass().getEStructuralFeature("name")));

        assertSame(bUsageInnerScope.eGet(bUsageInnerScope.eClass().getEStructuralFeature("boundDefinition")),definitionInnerScope);

    }

    /**
     * Tests explicitly that Impact Analysis chooses the correct element to which the usage is bound out of all elements contained
     * in the lookup scope. Thus after renaming the definition of "b" to "d" the usage should still be bound to this definition.
     */
    @Test
    public void testChoosingOfcorrectLookupScopeElemen() {
        String sample = "{ def a; def b; def c; use b; }";
        setupModelFromTextToParse(sample);

        EObject bDefinition = getStatementNonNestingLevelM(2, 0);
        EObject bUsage = getStatementNonNestingLevelM(4, 0);

        assertSame(bDefinition, bUsage.eGet(bUsage.eClass().getEStructuralFeature("boundDefinition")));
        renameDefinition(bDefinition, "d", RenameOn.MODEL);
        assertSame(bDefinition, bUsage.eGet(bUsage.eClass().getEStructuralFeature("boundDefinition")));

    }

    /**
     * Tests that if a usage is bound and it's bound definition is in the current lookup scope, Impact Analysis updates the
     * reference according to the result of referenceBy on the bound element. Thus after renaming the definition of "b" to "a" the
     * usage should still be bound to this definition (meaning that the usage is also renamed since it was directly bound to this
     * definition).
     */
    @Test
    public void testCorrectBindingIfBoundElementIsStillInLookupScopeAfterRename() {
        String sample = "{ def b; use b; }";
        setupModelFromTextToParse(sample);
        assertNotNull(rootElement);

        EObject bDefinition = getStatementNonNestingLevelM(1, 0);
        EObject bUsage = getStatementNonNestingLevelM(2, 1);

        assertEquals("Definition", bDefinition.eClass().getName());
        assertEquals("b", bDefinition.eGet(bDefinition.eClass().getEStructuralFeature("name")));
        assertEquals("Usage", bUsage.eClass().getName());
        assertSame(bUsage.eGet(bUsage.eClass().getEStructuralFeature("boundDefinition")), bDefinition);

        renameDefinition(bDefinition, "a", RenameOn.MODEL);

        assertSame(bUsage.eGet(bUsage.eClass().getEStructuralFeature("boundDefinition")), bDefinition);

    }

    /**
     * Tests that if a usage was bound, but the definition to which it was bound ("def a") is no longer contained in the lookup
     * scope, Impact Analysis uses the name of this previously bound definition to perform a fresh lookup and sets the reference
     * based on the lookup result.
     */
    @Test
    public void testCorrectBindingIfBoundElementIsNoLongerInLookupScopeAfterRenameWithShadowing() {
        String sample = "{ def a;" + "{ def b; use a;}" + "}";
        setupModelFromTextToParse(sample);

        EObject aDefinition = getStatementNonNestingLevelM(1, 0);
        EObject bDefinition = getStatementNonNestingLevelM(1, 1);
        EObject aUsage = getStatementNonNestingLevelM(2, 1);

        assertSame(aDefinition, aUsage.eGet(aUsage.eClass().getEStructuralFeature("boundDefinition")));
        renameDefinition(bDefinition, "a", RenameOn.MODEL);
        assertSame(bDefinition, aUsage.eGet(aUsage.eClass().getEStructuralFeature("boundDefinition")));

    }
    
    @Test
    @Ignore("IA doesn't seem to break the boundDefinition reference after the usage is changed textually.")
    public void testCorrectBindingIfBoundElementIsNoLongerInLookupScopeAfterRenameWithoutShadowing() {
        String sample = "{ def a; { def b; use a;} }";
        setupModelFromTextToParse(sample);
        
        EObject aDefinition = getStatementNonNestingLevelM(1, 0);
        EObject bDefinition = getStatementNonNestingLevelM(1, 1);
        EObject aUsage = getStatementNonNestingLevelM(2, 1);
        assertSame(aDefinition, aUsage.eGet(aUsage.eClass().getEStructuralFeature("boundDefinition")));
        
        OppositeEndFinder oppositeEndFinder = DefaultOppositeEndFinder.getInstance();
        LexedTokenImpl lexedTokenOfUsage = (LexedTokenImpl) oppositeEndFinder.navigateOppositePropertyWithBackwardScope(TextblocksPackage.eINSTANCE.getDocumentNode_ReferencedElements(), aDefinition).iterator().next();
        
        TextBlock workingCopy = TbReplacingHelper.getWorkingCopy(rootTextBlock);
        lexedTokenOfUsage.setValue("d");
        TbMarkingUtil.mark(lexedTokenOfUsage);
        TextBlock currentVersionTb = incrementalParserFacade.parseIncrementally(workingCopy);
        TbChangeUtil.cleanUp(currentVersionTb);
        
        LexedTokenImpl newLexedTokenOfUsage = (LexedTokenImpl) oppositeEndFinder.navigateOppositePropertyWithBackwardScope(TextblocksPackage.eINSTANCE.getDocumentNode_ReferencedElements(), aDefinition).iterator().next();
        assertEquals("d", newLexedTokenOfUsage.getValue());
        assertEquals("a", aDefinition.eGet(aDefinition.eClass().getEStructuralFeature("name")));
        assertFalse("boundDefinition should not be set",aUsage.eIsSet((aUsage.eClass().getEStructuralFeature("boundDefinition"))));

    }
     
    /**
     * Tests that if a usage was not bound to a definition before a rename, Impact analysis performs a
     * fresh lookup. It then should set the reference based on the lookup result.
     */
    @Test
    public void testCorrectBindingIfElementWasNotBoundBeforeRenameVariant1() {
        String sample = "{ def a;" + "{ def b; use a; }" + "}";
        setupModelFromTextToParse(sample);

        EObject aDefinition = getStatementNonNestingLevelM(1, 0);
        EObject bDefinition = getStatementNonNestingLevelM(1, 1);
        EObject aUsage = getStatementNonNestingLevelM(2, 1);

        assertEquals("Definition", aDefinition.eClass().getName());

        EcoreUtil.delete(aDefinition);
        assertFalse(aUsage.eIsSet(aUsage.eClass().getEStructuralFeature("boundDefinition")));
        
        renameDefinition(bDefinition, "a", RenameOn.MODEL);
        assertSame(bDefinition, aUsage.eGet(aUsage.eClass().getEStructuralFeature("boundDefinition")));
        
    }
    
    /**
     * Variant of testCorrectBindingIfElementWasNotBoundBeforeRename1 that
     * check that a rename operation does not accidentally trigger the binding
     * of a usage to a wrong definition.
     */
    @Test
    public void testCorrectBindingIfElementWasNotBoundBeforeRenameVariant2() {
        String sample = "{ def a;" + "{ def b; use a; }" + "}";
        setupModelFromTextToParse(sample);

        EObject aDefinition = getStatementNonNestingLevelM(1, 0);
        EObject bDefinition = getStatementNonNestingLevelM(1, 1);
        EObject aUsage = getStatementNonNestingLevelM(2, 1);

        assertEquals("Definition", aDefinition.eClass().getName());

        EcoreUtil.delete(aDefinition);
        assertFalse(aUsage.eIsSet(aUsage.eClass().getEStructuralFeature("boundDefinition")));
        
        renameDefinition(bDefinition, "c", RenameOn.MODEL);
        assertFalse(aUsage.eIsSet(aUsage.eClass().getEStructuralFeature("boundDefinition")));
        
    }

    private EObject getStatementNonNestingLevelM(int n, int m) {
        EObject currentBlock = rootElement;
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
        return (EObject) statmentsInBlockM.toArray()[n - 1];
    }

    private void renameDefinition(EObject definition, String newValue, RenameOn method) {
        if (method == RenameOn.MODEL) {
            definition.eSet(definition.eClass().getEStructuralFeature("name"), newValue);
        }else if (method == RenameOn.TEXTBLOCK){
            OppositeEndFinder oppositeEndFinder = DefaultOppositeEndFinder.getInstance();
            Collection<EObject> textBlocks = oppositeEndFinder.navigateOppositePropertyWithBackwardScope(TextblocksPackage.eINSTANCE.getDocumentNode_CorrespondingModelElements(), definition);
            assertEquals(1,textBlocks.size());
            TextBlock textBlock = (TextBlock) textBlocks.iterator().next();
            System.out.println(textBlock.getReferencedElements());
            for (AbstractToken abstractToken : textBlock.getTokens()) {
                if (abstractToken instanceof LexedTokenImpl) {
                    LexedToken lexedToken = (LexedToken) abstractToken;
                }
            }
        }
    }

}
