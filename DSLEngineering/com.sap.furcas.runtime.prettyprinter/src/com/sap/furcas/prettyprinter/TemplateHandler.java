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

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.EnumLiteralMapping;
import com.sap.furcas.metamodel.FURCAS.TCS.EnumerationTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Literal;
import com.sap.furcas.metamodel.FURCAS.TCS.Operator;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Priority;
import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.prettyprinter.Formatter.FormatRequest;
import com.sap.furcas.prettyprinter.Formatter.Type;
import com.sap.furcas.prettyprinter.context.PrintContext;
import com.sap.furcas.prettyprinter.context.PrintResult;
import com.sap.furcas.prettyprinter.context.PrintResult.LeafResult;
import com.sap.furcas.prettyprinter.context.PrintResult.NullResult;
import com.sap.furcas.prettyprinter.context.PrintResult.ResultContainer;
import com.sap.furcas.prettyprinter.context.TemplatePrintContext;
import com.sap.furcas.prettyprinter.exceptions.SyntaxMismatchException;
import com.sap.furcas.prettyprinter.policy.PrintPolicy;
import com.sap.furcas.prettyprinter.utils.EMFModelInspector;
import com.sap.furcas.runtime.tcs.SyntaxLookup;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.furcas.runtime.textblocks.shortprettyprint.PrettyPrinterUtil;

/**
 * Serializes a model element according to a given {@link Template}. Most of the actual
 * serialization work is performed by a {@link SequenceHandler}.
 * 
 * @author Stephan Erb
 *
 */
public class TemplateHandler {
    
    private static DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
    static {
        decimalFormatSymbols.setDecimalSeparator('.');
    }
    private final DecimalFormat decilmalFormat = new DecimalFormat("0.##############", decimalFormatSymbols);
    
    private final TextBlocksFactory tbFactory;
    private final Formatter formatter;
    private final SyntaxLookup syntaxLookup;
    private SequenceHandler sequenceHandler;

    public TemplateHandler(TextBlocksFactory factory, Formatter formatter, SyntaxLookup syntaxLookup) {
        this.tbFactory = factory;
        this.formatter = formatter;
        this.syntaxLookup = syntaxLookup;
    }
    
    public void setSequenceHandler(SequenceHandler handler) {
        sequenceHandler = handler;
    }
    
    public LeafResult serializePrimitiveTemplate(Object value, SequenceElement seqElem, PrimitiveTemplate template,
            PrintContext context, PrintPolicy policy) {
        
        String content = PrettyPrinterUtil.escapeUsingSerializer(primitiveToString(value), template);
        return createFormattedTokenWithContent(content, seqElem, context, policy);
    }
    
    private String primitiveToString(Object value) {
        if (value instanceof Double) {
            return decilmalFormat.format(value);
        } else {
            return value.toString();
        }
    }

    public PrintResult serializeEnumerationTemplate(EObject modelElement, Property seqElem, Enum<?> value,
            EnumerationTemplate template, PrintContext context, PrintPolicy policy) throws SyntaxMismatchException {
        
        String enumLiteral = value.toString();
        for (EnumLiteralMapping mapping : template.getMappings()) {
            if (mapping.getLiteral().getName().equals(enumLiteral)) {
                return sequenceHandler.serializeSequenceElement(modelElement, mapping.getElement(), context, policy);
            }
        }
        // as fallback or if the template is automatic, print as is 
        return createFormattedTokenWithContent(enumLiteral, seqElem, context, policy);
    }

    private LeafResult createFormattedTokenWithContent(String content, SequenceElement seqElem, PrintContext context,
            PrintPolicy policy) {
        List<FormatRequest> formatRequests = new ArrayList<FormatRequest>(context.getPendingFormattingRequest());
        formatRequests.add(FormatRequest.create(Type.ADD_OPTIONAL_SPACE));
        
        formatRequests = policy.getOverruledFormattingBetween(formatRequests, context.getLastSequenceElement(), seqElem);
        List<DocumentNode> formatting = formatter.translateToTokens(formatRequests, context);
          
        formatting.add(tbFactory.createLexedToken(content, seqElem, getLengthOf(formatting, context.getNextOffset())));
        
        return new LeafResult(formatting);
    }

    public PrintResult serializeContextTemplate(EObject modelElement, ContextTemplate template, SequenceElement seqElem,
            PrintContext context, PrintPolicy policy) throws SyntaxMismatchException {
       
        switch (template.eClass().getClassifierID()) {
        case TCSPackage.CLASS_TEMPLATE:
            return serializeClassTemplate(modelElement, (ClassTemplate) template, seqElem, context, policy);
        case TCSPackage.OPERATOR_TEMPLATE:
            return serializeOperatorTemplate(modelElement, (OperatorTemplate) template, seqElem, context, policy);
        default:
            Activator.logger.logError("Unable to serialize unknwon context template of type "
                    + EMFModelInspector.getTypeName(template) + ". Skipping.");
            return new NullResult();
        }
    }

    private PrintResult serializeClassTemplate(EObject modelElement, ClassTemplate template, SequenceElement seqElem,
            PrintContext context, PrintPolicy policy) throws SyntaxMismatchException {
        PrintContext templateContext = new TemplatePrintContext(context, modelElement, template); 
        ResultContainer result = sequenceHandler.serializeSequence(modelElement, template.getTemplateSequence(), templateContext, policy);
       
        TextBlock node = tbFactory.createTextBlock(modelElement, result.getNodes(), template, seqElem, context.getNextOffset());
        return new LeafResult(node, result, result.asSubContext(context).getPendingFormattingRequest());
    }

    private PrintResult serializeOperatorTemplate(EObject modelElement, OperatorTemplate template, SequenceElement seqElem,
            PrintContext context, PrintPolicy policy) throws SyntaxMismatchException {

        String opPropName = TcsUtil.getPropertyName(template.getStoreOperatorTo());
        String rightPropName = TcsUtil.getPropertyName(template.getStoreRightSideTo());

        Object r = null;
        boolean isPostfix = false; // only valid for unary operators
        boolean isUnary = false;
        if (rightPropName != null) {
            r = EMFModelInspector.get(modelElement, rightPropName);
            if (r instanceof Collection<?>) {
                isUnary = (((Collection<?>) r).size() == 0);
            } else {
                isUnary = r == null;
            }
        } else {
            isUnary = true;
        }

        Operator operator = null;
        if (opPropName != null) {
            String op = EMFModelInspector.getString(modelElement, opPropName);
            if (op == null) {
                throw new RuntimeException("Property " + opPropName + " has not been set in " + modelElement);
            }
            for (Iterator<Operator> i = template.getOperators().iterator(); i.hasNext() && (operator == null);) {
                Operator opme = i.next();
                Literal literal = opme.getLiteral();
                String opmes = null;
                if (literal == null) {
                    opmes = "";
                } else {
                    opmes = literal.getValue();
                }
                int arity = opme.getArity();
                if (op.equals(opmes)) {
                    if (rightPropName != null) {
                        if ((isUnary && (arity == 1)) || ((!isUnary) && (arity == 2))) {
                            operator = opme;
                        }
                    } else {
                        operator = opme;
                        isPostfix = opme.isPostfix();
                    }
                }
            }
            if (operator == null) {
                throw new RuntimeException();
                //throw new OperatorTemplateOperatorMissmatchException(currentContext, op, template);
            }
        } else {
            operator = template.getOperators().iterator().next();
            isUnary = operator.getArity() == 1;
            if (isUnary) {
                isPostfix = operator.isPostfix();
            }
        }
        int curPrio = context.getPriority();
        
        int priority = ((Priority) operator.eContainer()).getValue();
        boolean paren = priority > curPrio;
        
        Literal literal = operator.getLiteral();
        
        PrintContext templateContext = new TemplatePrintContext(context, modelElement, template, priority);
        ResultContainer result = new ResultContainer(templateContext.getPendingFormattingRequest()); 

        if (paren) {
            result.merge(sequenceHandler.serializeLiteral(syntaxLookup.getSymbolByValue("("), seqElem,
                    result.asSubContext(templateContext), policy));
        }

        EObject source = (EObject) TcsUtil.getPropertyValue(modelElement, template.getStoreLeftSideTo());
        if (isUnary) {
            if (isPostfix) {
                result.merge(sequenceHandler.serializeEObjectViaTemplateCall(modelElement, seqElem, source, /*mode*/ null,
                        result.asSubContext(templateContext), policy));
                if (literal != null) {
                    result.merge(sequenceHandler.serializeLiteral(literal, seqElem,
                            result.asSubContext(templateContext), policy));
                }
            } else {
                if (literal != null) {
                    result.merge(sequenceHandler.serializeLiteral(literal, seqElem,
                            result.asSubContext(templateContext), policy));
                }
                result.merge(sequenceHandler.serializeEObjectViaTemplateCall(modelElement, seqElem, source, /*mode*/ null,
                        result.asSubContext(templateContext), policy));            }
        } else {
            result.merge(sequenceHandler.serializeEObjectViaTemplateCall(modelElement, seqElem, source, /*mode*/ null,
                    result.asSubContext(templateContext), policy));
            if (literal != null) {
                result.merge(sequenceHandler.serializeLiteral(literal, seqElem,
                        result.asSubContext(templateContext), policy));
            }
        }

        Sequence seq = template.getTemplateSequence();
        if (rightPropName == null) {
            PrintContext mainTemplateContext = new TemplatePrintContext(result.asSubContext(templateContext), modelElement, template, Integer.MAX_VALUE);
            result.merge(sequenceHandler.serializeSequence(modelElement, seq, mainTemplateContext, policy));
        } else {
            if (seq != null) {
                result.merge(sequenceHandler.serializeSequence(modelElement, seq, result.asSubContext(templateContext), policy));
            }
            if (r instanceof Collection<?>) {
                for (Iterator<?> i = ((Collection<?>) r).iterator(); i.hasNext();) {
                    result.merge(sequenceHandler.serializeEObjectViaTemplateCall(modelElement, seqElem, ((EObject) i.next()),
                            /*mode*/ null, result.asSubContext(templateContext), policy));
                }
            } else {
                if (!isUnary) {
                    result.merge(sequenceHandler.serializeEObjectViaTemplateCall(modelElement, seqElem, ((EObject) r),
                            /*mode*/ null, result.asSubContext(templateContext), policy));                
                    }
            }
        }
        if (paren) {
            result.merge(sequenceHandler.serializeLiteral(syntaxLookup.getSymbolByValue(")"), seqElem, result.asSubContext(templateContext), policy));
        }
        TextBlock node = tbFactory.createTextBlock(modelElement, result.getNodes(), template, seqElem, context.getNextOffset());
        return new LeafResult(node, result, result.asSubContext(templateContext).getPendingFormattingRequest());
    }
    
}
