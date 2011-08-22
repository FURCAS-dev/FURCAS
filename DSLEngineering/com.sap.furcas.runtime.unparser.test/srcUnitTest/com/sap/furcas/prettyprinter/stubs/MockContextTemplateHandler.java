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
package com.sap.furcas.prettyprinter.stubs;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Collections;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksFactory;
import com.sap.furcas.prettyprinter.Formatter;
import com.sap.furcas.prettyprinter.Formatter.FormatRequest;
import com.sap.furcas.prettyprinter.PrintPolicy;
import com.sap.furcas.prettyprinter.TemplateHandler;
import com.sap.furcas.prettyprinter.TextBlocksFactory;
import com.sap.furcas.prettyprinter.context.PrintContext;
import com.sap.furcas.prettyprinter.context.PrintResult;
import com.sap.furcas.prettyprinter.context.PrintResult.LeafResult;
import com.sap.furcas.prettyprinter.exceptions.SyntaxMismatchException;

/**
 * @author Stephan Erb
 *
 */
public class MockContextTemplateHandler extends TemplateHandler {
    
    private final Template hardcodedTemplate;

    public MockContextTemplateHandler(TextBlocksFactory factory, Template hardcodedTemplate) {
        super(factory, new Formatter(factory));
        this.hardcodedTemplate = hardcodedTemplate;
    }
    
    @Override
    public PrintResult serializeContextTemplate(EObject modelElement, ContextTemplate template, SequenceElement seqElem,
            PrintContext context, PrintPolicy policy) throws SyntaxMismatchException {
        assertNotNull(modelElement);
        assertSame("Template returned by the template finder expected", hardcodedTemplate, template);
        assertTrue("Template should match", template.getMetaReference().isInstance(modelElement));
        return new LeafResult(TextblocksFactory.eINSTANCE.createTextBlock(),
                Collections.<FormatRequest>emptyList(), true);
    }
}
