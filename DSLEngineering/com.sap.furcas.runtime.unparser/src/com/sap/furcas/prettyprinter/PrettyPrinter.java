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

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.prettyprinter.context.InitialPrintContext;
import com.sap.furcas.prettyprinter.context.PrintResult;
import com.sap.furcas.prettyprinter.exceptions.SyntaxMismatchException;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.common.util.TCSSpecificOCLEvaluator;
import com.sap.furcas.runtime.tcs.MetaModelElementResolutionHelper;
import com.sap.furcas.runtime.tcs.SyntaxLookup;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.furcas.runtime.textblocks.TbDebugUtil;
import com.sap.furcas.runtime.textblocks.validation.TbValidationUtil;



/**
 * 
 * 
 * @author Stephan Erb
 *
 */
public class PrettyPrinter {
    
    private final TemplateHandler templateHandler;
    private final ConcreteSyntax syntax;
    private final Formatter formatter;
    private final TextBlocksFactory tbfactory;

    public PrettyPrinter(ConcreteSyntax syntax, IMetaModelLookup<EObject> metamodelLookup,
            TCSSpecificOCLEvaluator oclEvaluator) {
        
        this.tbfactory = new TextBlocksFactory();
        this.syntax = syntax;
        this.formatter = new Formatter(tbfactory);
        SequenceElementValidator validator = new SequenceElementValidator(oclEvaluator);
        
        MetaModelElementResolutionHelper<EObject> resolutionHelper = new MetaModelElementResolutionHelper<EObject>(metamodelLookup);
        SyntaxLookup syntaxLookup = new SyntaxLookup(syntax, resolutionHelper);
        
        this.templateHandler = new TemplateHandler(tbfactory, formatter);
        
        TemplateFinder templateFinder = new TemplateFinder(syntaxLookup, metamodelLookup);
        SequenceHandler sequenceHandler = new SequenceHandler(tbfactory, templateFinder, templateHandler,
                oclEvaluator, validator, formatter);
        
        this.templateHandler.setSequenceHandler(sequenceHandler);
    }
    
    public TextBlock prettyPrint(EObject modelElement) throws SyntaxMismatchException {
        PrintPolicy policy = new PrintPolicy();
        
        ClassTemplate template = TcsUtil.getMainClassTemplate(syntax);
        PrintResult result = templateHandler.serializeContextTemplate(modelElement, template, /*seqElem*/ null,
                new InitialPrintContext(), policy);
        
        assert result.getNodes().size() == 1;
        TextBlock resultBlock = (TextBlock) result.getNodes().get(0);
        resultBlock.setCachedString(TbDebugUtil.getDocumentNodeAsPlainString(resultBlock));
        
        
        resultBlock.getSubNodes().add(0, tbfactory.createBOSToken());
        resultBlock.getSubNodes().add(resultBlock.getSubNodes().size(),
                tbfactory.createEOSToken(resultBlock.getLength()));
        
        TbValidationUtil.assertTextBlockConsistencyRecursive(resultBlock);
        TbValidationUtil.assertCacheIsUpToDate(resultBlock);
        
        return resultBlock;
    }

}
