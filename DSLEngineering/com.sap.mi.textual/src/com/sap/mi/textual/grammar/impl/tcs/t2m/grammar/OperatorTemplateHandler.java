/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-09-18 14:13:44 +0200 (Fr, 18 Sep 2009) $
 * @version $Revision: 7886 $
 * @author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar;

import static com.sap.mi.textual.util.StringConcatUtil.concat;

import java.util.Collection;
import java.util.Iterator;

import com.sap.furcas.metamodel.TCS.ContextTags;
import com.sap.furcas.metamodel.TCS.Operator;
import com.sap.furcas.metamodel.TCS.OperatorTemplate;
import com.sap.furcas.metamodel.TCS.PropertyReference;
import com.sap.furcas.metamodel.TCS.Sequence;
import com.sap.furcas.textual.common.exceptions.MetaModelLookupException;
import com.sap.furcas.textual.common.exceptions.NameResolutionFailedException;
import com.sap.furcas.textual.common.exceptions.SyntaxElementException;
import com.sap.furcas.textual.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.furcas.textual.tcs.MessageHelper;
import com.sap.furcas.textual.tcs.MetaModelElementResolutionHelper;
import com.sap.furcas.textual.tcs.SyntaxLookup;
import com.sap.mi.textual.grammar.exceptions.SyntaxParsingException;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.rules.OperatorTemplateProductionRule;
import com.sap.mi.textual.moinlookup.util.TemplateNamingHelper;
import com.sap.mi.textual.util.VarStringBuffer;

/**
 * The Class OperatorTemplateHandler.
 */
public class OperatorTemplateHandler<Type extends Object> {

	/** The writer. */
	ANTLR3GrammarWriter writer;
	
	SyntaxLookup syntaxLookup;

	
    private TemplateNamingHelper<Type> namingHelper;
    private MetaModelElementResolutionHelper<Type> resolutionHelper;
    
	/**
	 * Instantiates a new operator template handler.
	 * 
	 * @param writer the writer
	 * @param lookup 
	 * @param metaLookup 
	 * @param namingHelper 
	 * @param resHelper 
	 * @param errorBucket 
	 */
	OperatorTemplateHandler(ANTLR3GrammarWriter writer, SyntaxLookup lookup,TemplateNamingHelper<Type> namingHelper, MetaModelElementResolutionHelper<Type> resHelper) {
		this.writer = writer;
		this.syntaxLookup = lookup;
		this.namingHelper = namingHelper;
		this.resolutionHelper = resHelper;
	}

	/**
     * @param handlerConfig
     */
    public OperatorTemplateHandler(
            SyntaxElementHandlerConfigurationBean<Type> handlerConfig) {
        this(handlerConfig.getWriter(), 
                handlerConfig.getSyntaxLookup(), 
                handlerConfig.getNamingHelper(), 
                handlerConfig.getResolutionHelper());
    }

    /**
	 * Adds the template.
	 * 
	 * @param template the template
	 * @throws SyntaxParsingException 
	 * @throws MetaModelLookupException 
	 */
	public void addTemplate(OperatorTemplate template, RuleBodyBufferFactory ruleBodyBufferFactory) throws MetaModelLookupException, SyntaxElementException {
		
		VarStringBuffer rulebody = new VarStringBuffer(); // first add ANTLR rule to Rulebody, then Java elements
		
		Collection<Operator> ops = template.getOperators();
		boolean allOperatorsPostFix = true;
		for (Iterator<Operator> iterator = ops.iterator(); iterator.hasNext();) {
			Operator operator = iterator.next();
            if (!operator.isIsPostfix()) {
                allOperatorsPostFix = false;
            }
		}
		if (allOperatorsPostFix) {
			// TODO: Understand and Support specific operator templates
			//throw new RuntimeException("Operator Template with all operators being postfix not supported yet");
		} 
		try {
		ResolvedNameAndReferenceBean<Type> refbean = resolutionHelper.resolve(template);
		
		String returnDeclaration = concat( 
		        "java.lang.String opName, Object left, org.antlr.runtime.Token firstToken");

		String metaObjectListParam = namingHelper.getMetaTypeListParameter(refbean);
		StringBuilder initString = new StringBuilder(); // TODO cleanup string construction
		if (template.isIsReferenceOnly()) {
		    initString.append(concat(
		            "List<String> metaType=", metaObjectListParam, ";\n",
		            ObservationDirectivesHelper.getEnterTemplateNotification(),
		    "IModelElementProxy ret=(getBacktrackingLevel()==0) ?  createReferenceProxy(metaType) : null;\n\n") );
		} else {
		    initString.append(concat(
		            "List<String> metaType=", metaObjectListParam, ";\n",
		            ObservationDirectivesHelper.getEnterTemplateNotification(),
		            "IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, ",
		            template.isIsContext(),
		    ", false"));
		    ContextTags tags = template.getContextTags();
            if (tags != null && tags.getTags() != null && tags.getTags().size() > 0) {
                initString.append(", new String[]{");
                for (Iterator<String> iterator = tags.getTags().iterator(); iterator
                        .hasNext();) {
                    String tag = iterator.next();
                    initString.append("\"").append(tag).append("\"");
                    if (iterator.hasNext()) {
                        initString.append(", ");
                    }
                }
                initString.append("}");
            }
		    initString.append(") : null;\n\n");
		}

        if( template.getOtSequence() != null) {
            Sequence sequence = template.getOtSequence();
            String rulefragment = ruleBodyBufferFactory.getNewRuleBodyFragment(sequence);
            rulebody.append(rulefragment);
        }
        
        rulebody.append("{\n");
        
        String operatorStorageName = getOperatorStorageName(template);
		if (operatorStorageName != null ) {
			rulebody.append("setProperty(ret,\"", operatorStorageName, "\" , opName);\n");
		} else {
		    rulebody.append("// discarding operator name instead of storing it here\n");
		}
		rulebody.append("setProperty(ret,\"", getSourceStorageName(template), "\" , left);\n");
		rulebody.append("ret2 = createOrResolve(ret, firstToken);\n");
		rulebody.append("onRuleElementCreationCommited(ret2);\n");
		if (template.isIsContext()) {
			rulebody.append("leaveContext();\n"); 
			// leave context after sub-elements are done with add to context
		}
		rulebody.append("\n}");
		
		writer.addRule(new OperatorTemplateProductionRule(namingHelper.getRuleName(template), returnDeclaration,
                "Object ret2", initString.toString(), rulebody.toString()));
		} catch (NameResolutionFailedException e) {
		    throw new SyntaxElementException("OperatorTemplate name could not be resolved: " + MessageHelper.getTemplateName(template), template, e);
        } 
    }

    /**
     * @param template
     * @return
     */
    private static String getOperatorStorageName(OperatorTemplate template) {
        if (template != null) {
            PropertyReference propRef = template.getStoreOperatorTo();
            if ( propRef != null) {
                if (propRef.getStrucfeature() != null) {
                    return propRef.getStrucfeature().getName();
                } else {
                    return propRef.getName();
                }
            }
        }
        return null;
    }
    
    /**
     * @param template
     * @return
     */
    private static String getSourceStorageName(OperatorTemplate template) {
        if (template != null) {
            PropertyReference propRef = template.getStoreLeftSideTo();

            if (propRef.getStrucfeature() != null) {
                return propRef.getStrucfeature().getName();
            } else {
                return propRef.getName();
            }

        }
        return null;
    }
	
//	TODO findout why TCS does this and whether we need it.
//	/**
//	 * Checks if is specific.
//	 * 
//	 * @param template the template
//	 * 
//	 * @return true, if is specific
//	 */
//	private static boolean isSpecific(OperatorTemplate template) {
////		not self.otSequence.oclIsUndefined();
////		----	self.storeRightTo.oclIsUndefined();
//        // -- 20070724: if storeRightTo is specified then otSequence may be
//        // defined as a complex operator
//        if (template.getStoreOpTo() == null
//                && (template.getOtSequence() != null)) {
//            List<Operator> ops = template.getOperators();
//            for (Iterator<Operator> iterator = ops.iterator(); iterator
//                    .hasNext();) {
//                Operator operator = (Operator) iterator.next();
//                if (operator.getArity() <= 1) {
//                    return false;
//                }
//            }
//			return true;
//		}
//		return false;
//	}
	
}
