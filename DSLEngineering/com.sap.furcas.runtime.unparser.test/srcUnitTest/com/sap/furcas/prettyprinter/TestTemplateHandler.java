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
package com.sap.furcas.prettyprinter;

import static com.sap.furcas.prettyprinter.SyntaxCreationHelper.createKeyword;
import static com.sap.furcas.prettyprinter.SyntaxCreationHelper.createSequence;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.ecore.EObject;
import org.junit.Test;

import com.sap.furcas.emf.stubs.EcoreAnyStub;
import com.sap.furcas.metamodel.FURCAS.TCS.Alternative;
import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.InjectorActionsBlock;
import com.sap.furcas.metamodel.FURCAS.TCS.LiteralRef;
import com.sap.furcas.metamodel.FURCAS.TCS.LookupPropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.PrimitivePropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.PropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceInAlternative;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSFactory;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.parser.tcs.TCSParserFactory;
import com.sap.furcas.prettyprinter.context.InitialPrintContext;
import com.sap.furcas.prettyprinter.context.PrintContext;
import com.sap.furcas.prettyprinter.context.PrintResult;
import com.sap.furcas.prettyprinter.exceptions.PropertyInitMismatchException;
import com.sap.furcas.prettyprinter.exceptions.SyntaxMismatchException;
import com.sap.furcas.prettyprinter.policy.DefaultPrintPolicy;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.furcas.runtime.textblocks.TbDebugUtil;
import com.sap.furcas.runtime.textblocks.validation.TbValidationUtil;

/**
 * @author Stephan Erb
 *
 */
public class TestTemplateHandler {

    private static TCSFactory tcsFactory = TCSFactory.eINSTANCE;
    
    private static TextBlocksFactory tbfactory = new TextBlocksFactory(new TCSParserFactory());
    private static Formatter formatter = new Formatter(tbfactory);
    
    /**
     * Serialize a empty ClassTemplate leading to the creation of an empty TextBlock
     */
    @Test
    public void testSerializeClassTemplate() throws Exception {
        ClassTemplate template = tcsFactory.createClassTemplate();
        template.setTemplateSequence(createSequence());
        
        TemplateHandler handler = createTemplateHandler();
        PrintResult result = handler.serializeContextTemplate(new EcoreAnyStub(), template, /*seqElem*/ null, new InitialPrintContext(), new DefaultPrintPolicy());
        
        assertEquals("Expect one block", 1, result.getNodes().size());
        TextBlock textBlock = (TextBlock) result.getNodes().get(0);
        
        assertEquals(0, textBlock.getOffset());
        assertEquals(0, textBlock.getLength());
        assertSame(template, textBlock.getType());
        
        TbValidationUtil.assertTextBlockConsistencyRecursive(textBlock);
    }
    
    /**
     * Serialize a ClassTemplate which consists of two keywords, leading to the
     * creation of a non-empty TextBlock.
     */
    @Test
    public void testSerializeClassTemplateWithContent() throws Exception {
        LiteralRef litRef1 = createKeyword("first");
        LiteralRef litRef2 = createKeyword("second");
        
        ClassTemplate template = tcsFactory.createClassTemplate();
        template.setTemplateSequence(createSequence(litRef1, litRef2));
        
        TemplateHandler handler = createTemplateHandler();
        PrintResult result = handler.serializeContextTemplate(new EcoreAnyStub(), template, /*seqElem*/ null, new InitialPrintContext(), new DefaultPrintPolicy());
        
        assertEquals("Expect one block", 1, result.getNodes().size());
        TextBlock textBlock = (TextBlock) result.getNodes().get(0);
        
        // Check for correct overall text
        assertEquals("first second", TbDebugUtil.getDocumentNodeAsPlainString(textBlock));
        
        // Check for correct offset/length handling
        assertEquals(0, textBlock.getOffset());
        assertEquals("first second".length(), textBlock.getLength());
                
        TbValidationUtil.assertTextBlockConsistencyRecursive(textBlock);
    }

    private TemplateHandler createTemplateHandler() {
        TemplateHandler handler = new TemplateHandler(tbfactory, formatter, /*syntax lookuk*/ null);
        handler.setSequenceHandler(new SequenceHandler(tbfactory, /*templateFinder*/ null, handler,
                /*oclEvaluator*/ null, /*validator*/ null, formatter));
        return handler;
    }
    
    /**
     * Serialize two nested alternative with two sequences containing property inits:
     * [[ 
     *    [[ {{propInit1}} | {{propInit2}} ]]
     *  | 
     *    [[ {{propInit3}} |  {{propInit3}} ]]
     * ]]
     *    
     * Assert that the create textblock is correct, in the sense that the correct
     * property inits are considered executed. This is to make sure that the
     * {@link TextBlock#getParentAltChoices()} contains the right values.
     */
    @Test
    public void testTemplateWithAlternatives() throws Exception {
        PropertyInit propInit1 = tcsFactory.createLookupPropertyInit();
        PropertyInit propInit2 = tcsFactory.createLookupPropertyInit();
        PropertyInit propInit3 = tcsFactory.createPrimitivePropertyInit(); // the one that we consider executed
        PropertyInit propInit4 = tcsFactory.createLookupPropertyInit();

        Alternative firstInnerAlt = createAlternativeWithTwoChoicesContaining(createBlock(propInit1), createBlock(propInit2));
        Alternative secondInnerAlt = createAlternativeWithTwoChoicesContaining(createBlock(propInit3), createBlock(propInit4));
        
        Alternative outerAlt = createAlternativeWithTwoChoicesContaining(firstInnerAlt, secondInnerAlt);
        
        ClassTemplate template = tcsFactory.createClassTemplate();
        template.setTemplateSequence(createSequence(outerAlt));
        
        // Create a specific validator that considers:
        //    PrimitivePropertyInit executed/matching
        //    LookupPropertyInits not executed/invalid
        //     
        SequenceElementValidator validator =  new SequenceElementValidator(/*oclEvaluator*/ null) {
            @Override
            public void validateLookupPropertyInit(EObject modelElement, LookupPropertyInit propInit, PrintContext context) throws SyntaxMismatchException {
                throw new PropertyInitMismatchException();
            }
            @Override
            public void validatePrimitivePropertyInit(Object element, PrimitivePropertyInit propInit) throws SyntaxMismatchException {
               
            }
        };
        
        TemplateHandler handler = new TemplateHandler(tbfactory, formatter, /*syntax lookuk*/ null);
        handler.setSequenceHandler(new SequenceHandler(tbfactory, /*templateFinder*/ null, handler,
                /*oclEvaluator*/ null, validator, formatter));
        
        PrintContext context = new InitialPrintContext();
        PrintResult result = handler.serializeContextTemplate(new EcoreAnyStub(), template, /*seqElem*/ null, context, new DefaultPrintPolicy());
        
        assertEquals("Expect one block", 1, result.getNodes().size());
        TextBlock textBlock = (TextBlock) result.getNodes().get(0);
        
        // Prop inits have no syntactic contribution
        assertEquals(0, textBlock.getOffset());
        assertEquals(0, textBlock.getLength());
        assertSame(template, textBlock.getType());
        
        // Check the actual execution state
        assertFalse(TcsUtil.wasExecuted(template, textBlock.getParentAltChoices(), propInit1.getInjectorActionsBlock()));
        assertFalse(TcsUtil.wasExecuted(template, textBlock.getParentAltChoices(), propInit2.getInjectorActionsBlock()));
        assertTrue(TcsUtil.wasExecuted(template, textBlock.getParentAltChoices(), propInit3.getInjectorActionsBlock()));
        assertFalse(TcsUtil.wasExecuted(template, textBlock.getParentAltChoices(), propInit4.getInjectorActionsBlock()));
        
        TbValidationUtil.assertTextBlockConsistencyRecursive(textBlock);
    }

    private SequenceElement createBlock(PropertyInit propInit1) {
        InjectorActionsBlock block = tcsFactory.createInjectorActionsBlock();
        block.getInjectorActions().add(propInit1);
        return block;
    }

    private Alternative createAlternativeWithTwoChoicesContaining(SequenceElement inFirst, SequenceElement inSecond) {
        Alternative alternative = tcsFactory.createAlternative();
        SequenceInAlternative firstChoice = tcsFactory.createSequenceInAlternative();
        SequenceInAlternative secondChoice = tcsFactory.createSequenceInAlternative();
        alternative.getSequences().add(firstChoice);
        alternative.getSequences().add(secondChoice);
        firstChoice.getElements().add(inFirst);
        secondChoice.getElements().add(inSecond);
        return alternative;
    }
    
}
