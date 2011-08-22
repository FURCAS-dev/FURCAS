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

import static com.sap.furcas.prettyprinter.TextBlocksFactory.getLengthOf;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.EnumerationTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.metamodel.FURCAS.textblocks.OmittedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.prettyprinter.Formatter.FormatRequest;
import com.sap.furcas.prettyprinter.Formatter.Type;
import com.sap.furcas.prettyprinter.context.PrintContext;
import com.sap.furcas.prettyprinter.context.PrintResult;
import com.sap.furcas.prettyprinter.context.PrintResult.LeafResult;
import com.sap.furcas.prettyprinter.context.PrintResult.ResultContainer;
import com.sap.furcas.prettyprinter.context.TemplatePrintContext;
import com.sap.furcas.prettyprinter.exceptions.SyntaxMismatchException;
import com.sap.furcas.runtime.textblocks.shortprettyprint.PrettyPrinterUtil;

/**
 * Called by the  {@link PrettyPrinter} to serialize {@link Sequence}s using a
 * {@link SequenceHandler}.
 * 
 * @author Stephan Erb
 *
 */
public class TemplateHandler {
    
    private final TextBlocksFactory tbFactory;
    private final Formatter formatter;
    private SequenceHandler sequenceHandler;

    public TemplateHandler(TextBlocksFactory factory, Formatter formatter) {
        this.tbFactory = factory;
        this.formatter = formatter;
    }
    
    public void setSequenceHandler(SequenceHandler handler) {
        sequenceHandler = handler;
    }
    
    public LeafResult serializePrimitiveTemplate(Object value, SequenceElement seqElem, PrimitiveTemplate template, PrintContext context, PrintPolicy policy) {
        String content = PrettyPrinterUtil.escapeUsingSerializer(value.toString(), template);
        return createFormattedTokenWithContent(content, seqElem, context, policy);
    }
    
    public PrintResult serializeEnumerationTemplate(Enum<?> value, EnumerationTemplate findEnumerationTemplate) {
        // TODO Auto-generated method stub
        return null;
    }

    private LeafResult createFormattedTokenWithContent(String content, SequenceElement seqElem, PrintContext context,
            PrintPolicy policy) {
        List<FormatRequest> formatRequests = new ArrayList<FormatRequest>(context.getPendingFormattingRequest());
        formatRequests = policy.getOverruledFormattingOf(formatRequests);
        
        formatRequests.add(FormatRequest.create(Type.ADD_OPTIONAL_SPACE));
        List<OmittedToken> formatting = formatter.translateToTokens(formatRequests, context);
          
        List<DocumentNode> tokens = new ArrayList<DocumentNode>(formatting);
        tokens.add(tbFactory.createLexedToken(content, seqElem, getLengthOf(formatting, context.getNextOffset())));
        
        return new LeafResult(tokens);
    }

    public PrintResult serializeContextTemplate(EObject modelElement, ContextTemplate template, SequenceElement seqElem,
            PrintContext context, PrintPolicy policy) throws SyntaxMismatchException {
       
        PrintContext templateContext = new TemplatePrintContext(context, modelElement, template); 
        ResultContainer result = sequenceHandler.serializeSequence(modelElement, template.getTemplateSequence(), templateContext, policy);
       
        TextBlock node = tbFactory.createTextBlock(modelElement, result.getNodes(), template, seqElem,
                context.getNextOffset(), result.getChosenAlternatives());
        
        return new LeafResult(node, result.asSubContext(context).getPendingFormattingRequest(),
                result.hasSyntacticContribution());
    }
    
    
}
