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
import static com.sap.furcas.prettyprinter.SyntaxCreationHelper.createProperty;
import static com.sap.furcas.prettyprinter.SyntaxCreationHelper.createSequence;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.Test;

import com.sap.furcas.emf.stubs.EcoreAnyStub;
import com.sap.furcas.metamodel.FURCAS.TCS.Block;
import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.CustomSeparator;
import com.sap.furcas.metamodel.FURCAS.TCS.EndNLBArg;
import com.sap.furcas.metamodel.FURCAS.TCS.ForcedLowerPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.IndentIncrBArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Literal;
import com.sap.furcas.metamodel.FURCAS.TCS.LiteralRef;
import com.sap.furcas.metamodel.FURCAS.TCS.NbNLBArg;
import com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.TCS.SeparatorPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.SpaceKind;
import com.sap.furcas.metamodel.FURCAS.TCS.StartNLBArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Symbol;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSFactory;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.prettyprinter.context.InitialPrintContext;
import com.sap.furcas.prettyprinter.context.PrintResult;
import com.sap.furcas.prettyprinter.exceptions.ForcedBoundMismatchException;
import com.sap.furcas.prettyprinter.exceptions.SyntaxMismatchException;
import com.sap.furcas.prettyprinter.stubs.MockContextTemplateFinder;
import com.sap.furcas.prettyprinter.stubs.MockContextTemplateHandler;

/**
 * @author Stephan Erb
 *
 */
public class TestSequenceHandler {

    
    private static TCSFactory tcsFactory = TCSFactory.eINSTANCE;
    
    private static TextBlocksFactory tbfactory = new TextBlocksFactory();
    private static Formatter formatter = new Formatter(tbfactory);
    
    /**
     * Print two literals and assert the correspondingly created lexed tokens.
     */
    @Test
    public void testSerializeLiteralRefSymbol() throws SyntaxMismatchException {
        LiteralRef litRef1 = tcsFactory.createLiteralRef();
        Symbol lit1 = tcsFactory.createSymbol();
        lit1.getSpaces().add(SpaceKind.RIGHT_NONE);
        litRef1.setReferredLiteral(lit1);
        lit1.setValue("first");
        
        LiteralRef litRef2 = tcsFactory.createLiteralRef();
        Symbol lit2 = tcsFactory.createSymbol();
        lit1.getSpaces().add(SpaceKind.LEFT_NONE);
        litRef2.setReferredLiteral(lit2);
        lit2.setValue("second");
        
        SequenceHandler handler = createSequenceHandlerForLiteralRef();
        PrintResult result = handler.serializeSequence(new EcoreAnyStub(), createSequence(litRef1, litRef2), new InitialPrintContext(), new PrintPolicy());
        
        assertEquals(2, result.getNodes().size());
        LexedToken first = (LexedToken) result.getNodes().get(0);
        LexedToken second = (LexedToken) result.getNodes().get(1);

        assertEquals("first", first.getValue());
        assertEquals("first".length(), first.getLength());
        assertEquals("Should start at the beginning", 0, first.getOffset());
        assertSame(litRef1, first.getSequenceElement());
        
        assertEquals("second", second.getValue());
        assertEquals("second".length(), second.getLength());
        assertEquals("Should follow the first token", first.getOffset()+first.getLength(), second.getOffset());
        assertSame(litRef2, second.getSequenceElement());
    }

    /**
     * Same as {@link #testSerializeLiteralRefSymbol()} but this time the symbols have been configured 
     * to add a space in between them
     */
    @Test
    public void testSerializeLiteralRefSymbolWithSimbolConfiguredSpace() throws SyntaxMismatchException {
        LiteralRef litRef1 = tcsFactory.createLiteralRef();
        Symbol lit1 = tcsFactory.createSymbol();
        lit1.getSpaces().add(SpaceKind.RIGHT_SPACE);
        litRef1.setReferredLiteral(lit1);
        lit1.setValue("first");
        
        LiteralRef litRef2 = tcsFactory.createLiteralRef();
        Symbol lit2 = tcsFactory.createSymbol();
        lit2.getSpaces().add(SpaceKind.LEFT_SPACE);
        litRef2.setReferredLiteral(lit2);
        lit2.setValue("second");
        
        Sequence sequence = createSequence(litRef1, litRef2);
        
        SequenceHandler handler = createSequenceHandlerForLiteralRef();
        PrintResult result = handler.serializeSequence(new EcoreAnyStub(), sequence, new InitialPrintContext(), new PrintPolicy());
        
        // Check for correct overall text
        StringBuilder content = new StringBuilder();
        for (DocumentNode node : result.getNodes()) {
            content.append(((AbstractToken)node).getValue());
        }
        assertEquals("first second", content.toString());
        
        // Check for correct offset handling
        assertEquals(2+1, result.getNodes().size());
        for (DocumentNode node : result.getNodes()) {
            AbstractToken token = (AbstractToken) node;
            assertEquals(token.getValue(), content.substring(token.getOffset(), token.getOffset()+ token.getLength()));
        }
    }
    
    /**
     * Same as {@link #testSerializeLiteralRefSymbol()} but this time force that a space, a tab and a newline
     * are added between those two literals.
     */
    @Test
    public void testSerializeLiteralRefSymbolWithCustomSpace() throws SyntaxMismatchException {
        LiteralRef litRef1 = tcsFactory.createLiteralRef();
        Symbol lit1 = tcsFactory.createSymbol();
        lit1.getSpaces().add(SpaceKind.RIGHT_NONE);
        litRef1.setReferredLiteral(lit1);
        lit1.setValue("first");
        
        LiteralRef litRef2 = tcsFactory.createLiteralRef();
        Symbol lit2 = tcsFactory.createSymbol();
        lit2.getSpaces().add(SpaceKind.LEFT_NONE);
        litRef2.setReferredLiteral(lit2);
        lit2.setValue("second");
        
        // the custom spacing between the two literals
        CustomSeparator spaceSep = tcsFactory.createCustomSeparator();
        spaceSep.setName("space");
        CustomSeparator tabSep = tcsFactory.createCustomSeparator();
        tabSep.setName("tab");        
        CustomSeparator newlineSep = tcsFactory.createCustomSeparator();
        newlineSep.setName("newline");
        
        Sequence sequence = createSequence(litRef1, spaceSep, tabSep, newlineSep, litRef2);
        
        SequenceHandler handler = createSequenceHandlerForLiteralRef();
        PrintResult result = handler.serializeSequence(new EcoreAnyStub(), sequence, new InitialPrintContext(), new PrintPolicy());
        
        // Check for correct overall text
        StringBuilder content = new StringBuilder();
        for (DocumentNode node : result.getNodes()) {
            content.append(((AbstractToken)node).getValue());
        }
        assertEquals("first \t\nsecond", content.toString());
        
        // Check for correct offset handling
        assertEquals(2+3, result.getNodes().size());
        for (DocumentNode node : result.getNodes()) {
            AbstractToken token = (AbstractToken) node;
            assertEquals(token.getValue(), content.substring(token.getOffset(), token.getOffset()+ token.getLength()));
        }
    }
    
    /**
     * Similar to {@link #testSerializeLiteralRefSymbolWithCustomSpace()} but using keywords, which require auto-added
     * spacing for disambiguation. 
     */
    @Test
    public void testSerializeLiteralRefKeywordWithAutoSpace() throws SyntaxMismatchException {
        LiteralRef litRef1 = createKeyword("first");
        LiteralRef litRef2 = createKeyword("second");
        Sequence sequence = createSequence(litRef1, litRef2);
        
        SequenceHandler handler = createSequenceHandlerForLiteralRef();
        PrintResult result = handler.serializeSequence(new EcoreAnyStub(), sequence, new InitialPrintContext(), new PrintPolicy());
        
        // Check for correct overall text
        StringBuilder content = new StringBuilder();
        for (DocumentNode node : result.getNodes()) {
            content.append(((AbstractToken)node).getValue());
        }
        assertEquals("first second", content.toString());
        
        // Check for correct offset handling
        assertEquals(3, result.getNodes().size());
        for (DocumentNode node : result.getNodes()) {
            AbstractToken token = (AbstractToken) node;
            assertEquals(token.getValue(), content.substring(token.getOffset(), token.getOffset()+ token.getLength()));
        }
    }
    
    /**
     * Print a property with a primitive type, which should result in a lexed token.
     */
    @Test
    public void testSerializePropertyPrimitive() throws SyntaxMismatchException {
        // Hardwire a template finder to always return a specific template.
        // Then later, expect the string property to be serialized according to this template.
        final PrimitiveTemplate template = tcsFactory.createPrimitiveTemplate();
        template.setTemplateName("MyStringTemplate");
        template.setSerializer("\"%value%\"");
        
        TemplateFinder templateFinder = new TemplateFinder(/*syntax lookup*/ null, /*metamodel lookup*/ null) {
            @Override
            public PrimitiveTemplate findPrimitiveTemplate(Property seqElem) {
                return template;
            };
        };
        SequenceHandler handler = createSequenceHandlerForProperty(templateFinder, new TemplateHandler(tbfactory, formatter));
        
        // The model elment to be printed
        ENamedElement modelElement = EcoreFactory.eINSTANCE.createEClass();
        modelElement.setName("MyModelElementName");
        
        // The property pointing to the name feature configured above
        Property property = createProperty(EcorePackage.eINSTANCE.getENamedElement_Name());
        
        PrintResult result = handler.serializeSequence(modelElement, createSequence(property), new InitialPrintContext(), new PrintPolicy());
        
        assertEquals(1, result.getNodes().size());
        LexedToken token = (LexedToken) result.getNodes().get(0);
        
        assertEquals("Should be name with quotes", "\"MyModelElementName\"", token.getValue());
        assertEquals("\"MyModelElementName\"".length(), token.getLength());
        assertEquals("Should start at the beginning", 0, token.getOffset());
        assertSame(property, token.getSequenceElement());
    }
    
    /**
     * Print a property with an EObject type, which should result in a call to
     * the template handler.
     */
    @Test
    public void testSerializePropertyEObject() throws SyntaxMismatchException {
        ClassTemplate templateForTypeOfParameter = tcsFactory.createClassTemplate();
        templateForTypeOfParameter.setMetaReference(EcorePackage.Literals.ECLASSIFIER); 
        
        // Hardwire a template finder to always return a specific template.
        TemplateFinder templateFinder = new MockContextTemplateFinder(templateForTypeOfParameter);
        // Hardwire the template handler to behave as if it has just serialized the given template
        TemplateHandler templatehandler = new MockContextTemplateHandler(tbfactory, templateForTypeOfParameter);
        
        // The model elment to be printed: A EParameter, it has a EType
        EParameter modelElement = EcoreFactory.eINSTANCE.createEParameter();
        modelElement.setName("MyParameterWithAType");
        modelElement.setEType(EcoreFactory.eINSTANCE.createEClass());
                
        // The property pointing to the eType feature of the eParameter created above.
        Property property = createProperty(EcorePackage.eINSTANCE.getETypedElement_EType());

        SequenceHandler handler = createSequenceHandlerForProperty(templateFinder, templatehandler);
        PrintResult result = handler.serializeSequence(modelElement, createSequence(property), new InitialPrintContext(), new PrintPolicy());
        
        assertEquals(1, result.getNodes().size());
        TextBlock textBlock = (TextBlock) result.getNodes().get(0);
        assertNotNull(textBlock);
    }
    
    /**
     * Print a property with a Collection<EAttribute> type, which should result in a call to
     * the template handler for each element in this collection.
     */
    @Test
    public void testSerializePropertyCollection() throws SyntaxMismatchException {
        ClassTemplate templateForEAttribute = tcsFactory.createClassTemplate();
        templateForEAttribute.setMetaReference(EcorePackage.Literals.EATTRIBUTE); 
        
        // Hardwire a template finder to always return a specific template.
        TemplateFinder templateFinder = new MockContextTemplateFinder(templateForEAttribute);
        // Hardwire the template handler to behave as if it has just serialized the given template
        TemplateHandler templatehandler = new MockContextTemplateHandler(tbfactory, templateForEAttribute);
        
        // The model elment to be printed: A EClass, it holds EAttributes. 
        EClass modelElement = EcoreFactory.eINSTANCE.createEClass();
        modelElement.setName("MyClassWithAttributes");
        for (int i=0; i<10; i++) {
            modelElement.getEAttributes().add(EcoreFactory.eINSTANCE.createEAttribute());
        }
        // The property pointing to the attribute feature of the eClass above.
        Property property = createProperty(EcorePackage.eINSTANCE.getEClass_EAttributes());
        
        SequenceHandler handler = createSequenceHandlerForProperty(templateFinder, templatehandler);
        PrintResult result = handler.serializeSequence(modelElement, createSequence(property), new InitialPrintContext(), new PrintPolicy());
        assertEquals("One for each attribute", 10, result.getNodes().size());
    }

    /**
     * Same as {@link #testSerializePropertyCollection()} but with a separator between
     * individual collection items
     */
    @Test
    public void testSerializePropertyCollectionWithSeparator() throws SyntaxMismatchException {
        ClassTemplate templateForEAttribute = tcsFactory.createClassTemplate();
        templateForEAttribute.setMetaReference(EcorePackage.Literals.EATTRIBUTE); 
        
        // Hardwire a template finder to always return a specific template.
        TemplateFinder templateFinder = new MockContextTemplateFinder(templateForEAttribute);
        // Hardwire the template handler to behave as if it has just serialized the given template
        TemplateHandler templatehandler = new MockContextTemplateHandler(tbfactory, templateForEAttribute);
        
        // The model elment to be printed: A EClass, it holds EAttributes. 
        EClass modelElement = EcoreFactory.eINSTANCE.createEClass();
        modelElement.setName("MyClassWithAttributes");
        for (int i=0; i<10; i++) {
            modelElement.getEAttributes().add(EcoreFactory.eINSTANCE.createEAttribute());
        }
        // The property pointing to the attribute feature of the eClass above.
        Property property = createProperty(EcorePackage.eINSTANCE.getEClass_EAttributes());
        
        // Create the separator and add it to the property created above
        LiteralRef litRef = tcsFactory.createLiteralRef();
        Literal separator = tcsFactory.createSymbol();
        litRef.setReferredLiteral(separator);
        separator.setValue(";");
        SeparatorPArg pArg = tcsFactory.createSeparatorPArg();
        pArg.setSeparatorSequence(createSequence(litRef));
        property.getPropertyArgs().add(pArg);
        
        SequenceHandler handler = createSequenceHandlerForProperty(templateFinder, templatehandler);
        PrintResult result = handler.serializeSequence(modelElement, createSequence(property), new InitialPrintContext(), new PrintPolicy());
        assertEquals("One for each attribute and the seaprators between them, which is size-1",
                2*modelElement.getEAttributes().size()-1, result.getNodes().size());
    }
    
    /**
     * Same as {@link #testSerializePropertyCollection()} but with a forcedLowerPArg missmatch,
     * forcing the serialization to be aborted
     */
    @Test(expected=ForcedBoundMismatchException.class)
    public void testSerializePropertyCollectionWithBoundMismatch() throws SyntaxMismatchException {
        ClassTemplate templateForEAttribute = tcsFactory.createClassTemplate();
        templateForEAttribute.setMetaReference(EcorePackage.Literals.EATTRIBUTE); 
        
        // Hardwire a template finder to always return a specific template.
        TemplateFinder templateFinder = new MockContextTemplateFinder(templateForEAttribute);
        // Hardwire the template handler to behave as if it has just serialized the given template
        TemplateHandler templatehandler = new MockContextTemplateHandler(tbfactory, templateForEAttribute);
        
        // The model elment to be printed: A EClass, it holds EAttributes. 
        EClass modelElement = EcoreFactory.eINSTANCE.createEClass();
        modelElement.setName("MyClassWithAttributes");
        for (int i=0; i<2; i++) {
            modelElement.getEAttributes().add(EcoreFactory.eINSTANCE.createEAttribute());
        }
        // The property pointing to the attribute feature of the eClass above.
        Property property = createProperty(EcorePackage.eINSTANCE.getEClass_EAttributes());
        ForcedLowerPArg pArg = tcsFactory.createForcedLowerPArg();
        pArg.setValue(3);
        property.getPropertyArgs().add(pArg);
                
        SequenceHandler handler = createSequenceHandlerForProperty(templateFinder, templatehandler);
        handler.serializeSequence(modelElement, createSequence(property), new InitialPrintContext(), new PrintPolicy());
        // Expected are 3, but the collection has only 2 elements.
        fail("Should never come this far");
    }
    
    /**
     * Same as {@link #testSerializePropertyCollectionWithBoundMismatch()} but this time the
     * property is partial and does not lead to subsequent errors.
     */
    @Test
    public void testSerializePropertyCollectionWithIgnoredBoundMismatch() throws SyntaxMismatchException {
        ClassTemplate templateForEAttribute = tcsFactory.createClassTemplate();
        templateForEAttribute.setMetaReference(EcorePackage.Literals.EATTRIBUTE); 
        
        // Hardwire a template finder to always return a specific template.
        TemplateFinder templateFinder = new MockContextTemplateFinder(templateForEAttribute);
        // Hardwire the template handler to behave as if it has just serialized the given template
        TemplateHandler templatehandler = new MockContextTemplateHandler(tbfactory, templateForEAttribute);
        
        // The model elment to be printed: A EClass, it holds EAttributes. 
        EClass modelElement = EcoreFactory.eINSTANCE.createEClass();
        modelElement.setName("MyClassWithAttributes");
        for (int i=0; i<2; i++) {
            modelElement.getEAttributes().add(EcoreFactory.eINSTANCE.createEAttribute());
        }
        // The property pointing to the attribute feature of the eClass above.
        Property property = createProperty(EcorePackage.eINSTANCE.getEClass_EAttributes());
        ForcedLowerPArg pArg = tcsFactory.createForcedLowerPArg();
        pArg.setValue(3);
        property.getPropertyArgs().add(pArg);
        property.getPropertyArgs().add(tcsFactory.createPartialPArg());
                
        SequenceHandler handler = createSequenceHandlerForProperty(templateFinder, templatehandler);
        PrintResult result = handler.serializeSequence(modelElement, createSequence(property), new InitialPrintContext(), new PrintPolicy());
        assertEquals("No excption, but still nothing should have been created", 0, result.getNodes().size());
    }
    
    /**
     * Serialize keywords within a block, thus each should be on its own line. 
     */
    @Test
    public void testSerializeBlock() throws SyntaxMismatchException {
        LiteralRef litRefBefore = createKeyword("beforeBlock");
        LiteralRef litRef1 = createKeyword("firstInBlock");
        LiteralRef litRef2 = createKeyword("secondInBlock");
        LiteralRef litRefAfter = createKeyword("afterBlock");
                
        Block block = tcsFactory.createBlock();
        block.setBlockSequence(createSequence(litRef1, litRef2));
        Sequence sequence = createSequence(litRefBefore, block, litRefAfter);
        
        SequenceHandler handler = createSequenceHandlerForLiteralRef();
        PrintResult result = handler.serializeSequence(new EcoreAnyStub(), sequence, new InitialPrintContext(), new PrintPolicy());
        
        // Check for correct overall text
        StringBuilder content = new StringBuilder();
        for (DocumentNode node : result.getNodes()) {
            content.append(((AbstractToken)node).getValue());
        }
        assertEquals(
                "beforeBlock\n" +
                "    firstInBlock\n" +
                "    secondInBlock\n" +
                "afterBlock", content.toString());
    }
    
    /**
     * Like {@link #testSerializeBlock()} but use some special block formatting features
     */
    @Test
    public void testSerializeBlockWithFormatting() throws SyntaxMismatchException {
        LiteralRef litRefBefore = createKeyword("beforeBlock");
        LiteralRef litRef1 = createKeyword("firstInBlock");
        LiteralRef litRef2 = createKeyword("secondInBlock");
        LiteralRef litRefAfter = createKeyword("afterBlock");
                
        Block block = tcsFactory.createBlock();
        block.setBlockSequence(createSequence(litRef1, litRef2));
        Sequence sequence = createSequence(litRefBefore, block, litRefAfter);

        // indent inner blocks twice
        IndentIncrBArg indentInc = tcsFactory.createIndentIncrBArg();
        indentInc.setValue(2);
        block.getBlockArgs().add(indentInc);
        // don't start the block with a newline
        StartNLBArg startWithNewLine = tcsFactory.createStartNLBArg();
        startWithNewLine.setValue(false);
        block.getBlockArgs().add(startWithNewLine);
        // don't end the block with a newline
        EndNLBArg endWithNewLine = tcsFactory.createEndNLBArg();
        endWithNewLine.setValue(false);
        block.getBlockArgs().add(endWithNewLine);
        // between inner block elements, always add two newlines
        NbNLBArg numOfNewlinesWithinTheBlock = tcsFactory.createNbNLBArg();
        numOfNewlinesWithinTheBlock.setValue(2);
        block.getBlockArgs().add(numOfNewlinesWithinTheBlock);
        
        SequenceHandler handler = createSequenceHandlerForLiteralRef();
        PrintResult result = handler.serializeSequence(new EcoreAnyStub(), sequence, new InitialPrintContext(), new PrintPolicy());
        
        // Check for correct overall text
        StringBuilder content = new StringBuilder();
        for (DocumentNode node : result.getNodes()) {
            content.append(((AbstractToken)node).getValue());
        }
        assertEquals(
                "beforeBlock firstInBlock\n" +
                "        \n" +
                "        secondInBlock afterBlock", content.toString());
    }
    
    private static SequenceHandler createSequenceHandlerForLiteralRef() {
        SequenceHandler handler = new SequenceHandler(tbfactory, /* tempate finder*/ null, /*template handler*/ null,
                /* ocl evaluator*/ null, new SequenceElementValidator(/*ocl evaluator*/ null), formatter);
        return handler;
    }
    
    private static SequenceHandler createSequenceHandlerForProperty(TemplateFinder templateFinder, TemplateHandler templatehandler) {
        SequenceHandler handler = new SequenceHandler(tbfactory, templateFinder, templatehandler,
                /* ocl evaluator*/ null, new SequenceElementValidator(/*ocl evaluator*/ null), formatter);
        return handler;
    }

}
