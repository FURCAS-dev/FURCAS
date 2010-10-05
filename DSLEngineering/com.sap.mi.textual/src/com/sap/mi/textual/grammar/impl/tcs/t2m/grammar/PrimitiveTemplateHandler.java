/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-09-18 14:13:44 +0200 (Fr, 18 Sep 2009) $
 * @version $Revision: 7886 $
 * @author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar;


import java.util.Set;

import com.sap.furcas.metamodel.TCS.Keyword;
import com.sap.furcas.metamodel.TCS.PrimitiveTemplate;
import com.sap.furcas.textual.common.exceptions.NameResolutionFailedException;
import com.sap.furcas.textual.common.exceptions.SyntaxElementException;
import com.sap.furcas.textual.tcs.MessageHelper;
import com.sap.furcas.textual.tcs.MetaModelElementResolutionHelper;
import com.sap.furcas.textual.tcs.SyntaxLookup;
import com.sap.mi.textual.grammar.exceptions.SyntaxParsingException;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.rules.ClassProductionRule;
import com.sap.mi.textual.moinlookup.util.TemplateNamingHelper;


/**
 * The Class PrimitiveTemplateHandler. Creates rules such as
 * identifier returns[Object ret2] @init{java.lang.Object ret=null;}
 *  :
 *    (ast=NAME {ret =  ast.getText();}) 
 *    {
 *      ret2=ret;
 *    }
 *  ;
 */
public class PrimitiveTemplateHandler {

	private static final String ASTSTRING = "(ast=";
    private static final String RESTBODY_STRING_START = " {ret = ";
    private static final String RESTBODY_STRING_GETTEXT = " ast.getText()";
    private static final String RESTBODY_STRING_MIDDLE = ";\n}";
    private static final String RESTBODY_STRING_END = ")\n{\nret2=ret;\n}";
    
    /** The writer. */
	private ANTLR3GrammarWriter writer;

	private SyntaxLookup syntaxLookup;
	
    private TemplateNamingHelper<?> namingHelper;
    private SemanticErrorBucket errorBucket;
    private MetaModelElementResolutionHelper<?> resolutionHelper;
    
	/**
	 * keeping this constructor for testing.
	 * 
	 * @param writer the writer
	 * @param syntaxLookup 
	 * @param metaLookup 
	 * @param namingHelper 
	 * @param syntaxLookup 
	 * @param errorBucket 
	 * @param metaModelElementResolutionHelper 
	 */
	protected PrimitiveTemplateHandler(ANTLR3GrammarWriter writer, TemplateNamingHelper<?> namingHelper, SyntaxLookup syntaxLookup, SemanticErrorBucket errorBucket, MetaModelElementResolutionHelper<?> metaModelElementResolutionHelper) {
		this.writer = writer;
		this.namingHelper = namingHelper;
		this.syntaxLookup = syntaxLookup;
		this.errorBucket = errorBucket;
		this.resolutionHelper = metaModelElementResolutionHelper;
	}

	/**
     * @param handlerConfig
     */
    public PrimitiveTemplateHandler(
            SyntaxElementHandlerConfigurationBean<?> handlerConfig) {
        this(handlerConfig.getWriter(),
                handlerConfig.getNamingHelper(),
                handlerConfig.getSyntaxLookup(),
                handlerConfig.getErrorBucket(),
                handlerConfig.getResolutionHelper());
    }

    /**
	 * Adds the template.
	 * 
	 * @param prim the prim
	 * @throws SyntaxParsingException 
	 */
	public void addTemplate(PrimitiveTemplate prim) {
 
	    String content;
	    if (prim.getValue() != null) {
	        content = prim.getValue().replaceAll("%token%", RESTBODY_STRING_GETTEXT);
	    } else {
	        content = RESTBODY_STRING_GETTEXT;
	    }

	    StringBuilder rulebody = new StringBuilder();
	    rulebody.append(ASTSTRING)
	    .append(prim.getTokenName())
	    .append(RESTBODY_STRING_START);
	    rulebody.append(content);
	    rulebody.append(RESTBODY_STRING_MIDDLE);

        // add all keywords if allowed explicitly
        if (prim.isOrKeyword() ) {
            Set<Keyword> keywords = syntaxLookup.getAllKeywords();
            for (Keyword keyword : keywords) {
                rulebody.append("\n  | '");
                if (keyword.getName() != null) {
                    rulebody.append(keyword.getName());
                } else {
                    rulebody.append(keyword.getValue());
                }
                rulebody.append("' {ret = \"").append(keyword.getValue()).append("\";}");
            }
        }
        rulebody.append(RESTBODY_STRING_END);

        
        try {
            if (resolutionHelper.resolve(prim) == null) {
                errorBucket.addError("Metamodel could not resolve primitive type " + MessageHelper.getTemplateName(prim), prim);
            }
        } catch (NameResolutionFailedException e) {
            errorBucket.addError("Metamodel could not resolve primitive type " + MessageHelper.getTemplateName(prim) + " " + e.getMessage(), prim);
        } 
        
        try {
            String rulename = namingHelper.getRuleName(prim);
            writer.addRule(new ClassProductionRule(rulename , "Object ret2",
                    "java.lang.Object ret=null;", rulebody.toString(), null));
        } catch (SyntaxElementException e) {
            errorBucket.addException(e);
        }
	}

}
