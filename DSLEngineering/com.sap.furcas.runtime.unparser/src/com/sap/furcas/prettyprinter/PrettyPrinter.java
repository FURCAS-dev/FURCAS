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

import org.antlr.runtime.Lexer;
import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.prettyprinter.context.InitialPrintContext;
import com.sap.furcas.prettyprinter.context.PrintResult;
import com.sap.furcas.prettyprinter.exceptions.SyntaxMismatchException;
import com.sap.furcas.prettyprinter.policy.DefaultPrintPolicy;
import com.sap.furcas.prettyprinter.policy.PrintPolicy;
import com.sap.furcas.prettyprinter.policy.TextBlockBasedPrintPolicy;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.common.util.TCSSpecificOCLEvaluator;
import com.sap.furcas.runtime.parser.ParserFactory;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.tcs.MetaModelElementResolutionHelper;
import com.sap.furcas.runtime.tcs.SyntaxLookup;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.furcas.runtime.textblocks.TbDebugUtil;
import com.sap.furcas.runtime.textblocks.validation.TbValidationUtil;

/**
 * A {@link PrettyPrinter} translates a domain model into a textual representation.
 * The type and style of such a textual representation is given in form of a {@link ConcreteSyntax}.
 * 
 * The {@link PrettyPrinter} resembles a backtracking, recursive descent parser.
 * In contrast to matching parse rules against text fragments, the {@link PrettyPrinter} has to
 * pattern match {@link Template}s against domain model elements. It does this by simultaneously
 * inspecting and walking both the domain model and the syntax definition.
 * 
 * During recursive descend (realized via recursive method calls), the {@link PrettyPrinter} tries
 * to determine and apply the best matching template for a model element.
 * A successfull application of a complete {@link Template} then leads to the instantiation of a {@link TextBlock}.
 * {@link TextBlock}s are a structured representation of text and serve as the input for FURCAS text editors
 * and the incremental parser infrastructure.
 * 
 * This implementation is based on earier work by Frédéric Jouault and Mikaël Barbero, with contributions
 * by Philipp Meier and Andreas Landerer.
 * 
 * @author Stephan Erb
 */
public class PrettyPrinter {
    
    private final TemplateHandler templateHandler;
    private final ConcreteSyntax syntax;
    private final Formatter formatter;
    private final TextBlocksFactory tbfactory;

    public PrettyPrinter(ConcreteSyntax syntax, IMetaModelLookup<EObject> metamodelLookup,
            TCSSpecificOCLEvaluator oclEvaluator, ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory) {
        
        this.tbfactory = new TextBlocksFactory(parserFactory);
        this.syntax = syntax;
        this.formatter = new Formatter(tbfactory);
        SequenceElementValidator validator = new SequenceElementValidator(oclEvaluator);
        
        MetaModelElementResolutionHelper<EObject> resolutionHelper = new MetaModelElementResolutionHelper<EObject>(metamodelLookup);
        SyntaxLookup syntaxLookup = new SyntaxLookup(syntax, resolutionHelper);
        
        this.templateHandler = new TemplateHandler(tbfactory, formatter, syntaxLookup);
        
        TemplateFinder templateFinder = new TemplateFinder(syntaxLookup, metamodelLookup);
        SequenceHandler sequenceHandler = new SequenceHandler(tbfactory, templateFinder, templateHandler,
                oclEvaluator, validator, formatter);
        
        this.templateHandler.setSequenceHandler(sequenceHandler);
    }
    
    /**
     * Print a model element from scratch.
     */
    public TextBlock prettyPrint(EObject modelElement) throws SyntaxMismatchException {
        PrintPolicy policy = new DefaultPrintPolicy();
        ClassTemplate template = TcsUtil.getMainClassTemplate(syntax);
        
        return prettyPrintInternal(modelElement, template, policy);
    }
    
    /**
     * Print a model element from scratch, but re-use information from an
     * existing/old {@link TextBlock} of this element.
     */
    public TextBlock prettyPrint(EObject modelElement, TextBlock oldBlock) throws SyntaxMismatchException {
        assert oldBlock.getCorrespondingModelElements().contains(modelElement);
        
        PrintPolicy policy = new TextBlockBasedPrintPolicy(oldBlock);
        ClassTemplate template = TcsUtil.getMainClassTemplate(syntax);
        
        return prettyPrintInternal(modelElement, template, policy);
    }

    private TextBlock prettyPrintInternal(EObject modelElement, ClassTemplate template, PrintPolicy policy) throws SyntaxMismatchException {
        PrintResult result = templateHandler.serializeContextTemplate(modelElement, template, /*seqElem*/ null,
                new InitialPrintContext(), policy);
        
        assert result.getNodes().size() == 1;
        TextBlock resultBlock = (TextBlock) result.getNodes().get(0);
        resultBlock.setCachedString(TbDebugUtil.getDocumentNodeAsPlainString(resultBlock));
        
        resultBlock.getSubNodes().add(0, tbfactory.createBOSToken());
        resultBlock.getSubNodes().add(resultBlock.getSubNodes().size(),
                tbfactory.createEOSToken(resultBlock.getLength()));
        
        TbValidationUtil.assertTextBlockConsistencyRecursive(resultBlock);
        
        return resultBlock;
    }
}
