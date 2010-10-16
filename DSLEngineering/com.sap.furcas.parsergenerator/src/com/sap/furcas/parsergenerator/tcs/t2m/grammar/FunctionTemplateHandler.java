/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2008-04-03 16:11:26 +0200 (Do, 03 Apr 2008) $
 * @version $Revision: 767 $
 * @author: $Author: c5107456 $
 *******************************************************************************/
package com.sap.furcas.parsergenerator.tcs.t2m.grammar;


import com.sap.furcas.metamodel.TCS.FunctionTemplate;
import com.sap.furcas.metamodel.TCS.Sequence;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.rules.FunctionProductionRule;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.common.exceptions.SyntaxElementException;
import com.sap.furcas.runtime.parser.exceptions.SyntaxParsingException;
import com.sap.furcas.runtime.tcs.TemplateNamingHelper;


/**
 * The Class PrimitiveTemplateHandler.
 */
public class FunctionTemplateHandler<Type extends Object> {

    
    /** The writer. */
	private ANTLR3GrammarWriter writer;

	
    private TemplateNamingHelper<Type> namingHelper;


    
	/**
	 * Instantiates a new primitive template handler.
	 * 
	 * @param writer the writer
	 * @param syntaxLookup 
	 * @param metaLookup 
	 * @param namingHelper 
	 * @param errorBucket 
	 */
	protected FunctionTemplateHandler(ANTLR3GrammarWriter writer, TemplateNamingHelper<Type> namingHelper) {
		this.writer = writer;
		this.namingHelper = namingHelper;
	}

	/**
     * @param handlerConfig
     */
    public FunctionTemplateHandler(
            SyntaxElementHandlerConfigurationBean<Type> handlerConfig) {
        this(handlerConfig.getWriter(),
                handlerConfig.getNamingHelper());
    }

    /**
	 * Adds the template.
	 * 
	 * @param funcTemplate the function template in the syntax
	 * @throws SyntaxParsingException 
	 * @throws MetaModelLookupException 
	 */
	public void addTemplate(FunctionTemplate funcTemplate, RuleBodyBufferFactory ruleBodyBufferFactory) throws SyntaxElementException, MetaModelLookupException {

		Sequence sequence = funcTemplate.getFunctionSequence();
        String rulefragment = ruleBodyBufferFactory.getNewRuleBodyFragment(sequence);
        rulefragment = rulefragment + "\n{\n  }\n";
        writer.addRule(new FunctionProductionRule(namingHelper.getRuleName(funcTemplate), rulefragment));
    }

}
