/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2010-02-26 09:30:11 +0100 (Fr, 26 Feb 2010) $
 * @version $Revision: 9485 $
 * @author: $Author: d043530 $
 *******************************************************************************/
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import tcs.ClassTemplate;
import tcs.ContextTags;
import tcs.OperatorList;
import tcs.OperatorTemplate;
import tcs.Priority;
import tcs.Sequence;
import tcs.Template;

import com.sap.mi.textual.common.exceptions.MetaModelLookupException;
import com.sap.mi.textual.common.exceptions.NameResolutionFailedException;
import com.sap.mi.textual.common.exceptions.SyntaxElementException;
import com.sap.mi.textual.common.interfaces.IMetaModelLookup;
import com.sap.mi.textual.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.mi.textual.grammar.exceptions.SyntaxParsingException;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.rules.ClassProductionRule;
import com.sap.mi.textual.moinlookup.util.MetamodelNameResolvingException;
import com.sap.mi.textual.moinlookup.util.TemplateNamingHelper;
import com.sap.mi.textual.tcs.util.MetaModelElementResolutionHelper;
import com.sap.mi.textual.tcs.util.SyntaxLookup;
import com.sap.mi.textual.tcs.util.TcsUtil;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;


/**
 * The Class ClassTemplateHandler.
 */
public class ClassTemplateHandler<Type extends Object> {

    /** The writer. */
    private ANTLR3GrammarWriter writer;

    /** The meta lookup. */
    private IMetaModelLookup<Type> metaLookup;

    /** The operator handler. */
    private OperatorHandler operatorHandler;

    /** The syntax lookup. */
    private SyntaxLookup syntaxLookup;

    private TemplateNamingHelper<Type> namingHelper;

    private SemanticErrorBucket errorBucket;

    private MetaModelElementResolutionHelper<Type> resolutionHelper;

    /**
     * Instantiates a new class template handler.
     * 
     * @param writer the writer
     * @param operatorHandler the operator handler
     * @param metaLookup the meta lookup
     * @param syntaxLookup the syntax lookup
     * @param namingHelper 
     * @param errorBucket 
     * @param resHelper 
     */
    protected ClassTemplateHandler(ANTLR3GrammarWriter writer,
            OperatorHandler operatorHandler, IMetaModelLookup<Type> metaLookup,
            SyntaxLookup syntaxLookup, TemplateNamingHelper<Type> namingHelper, SemanticErrorBucket errorBucket, MetaModelElementResolutionHelper<Type> resHelper) {
        super();
        this.writer = writer;
        this.operatorHandler = operatorHandler;
        this.metaLookup = metaLookup;
        this.namingHelper = namingHelper;
        this.syntaxLookup = syntaxLookup;
        this.errorBucket = errorBucket;
        this.resolutionHelper = resHelper;
    }

    /**
     * @param operatorHandler2
     * @param handlerConfig
     */
    protected ClassTemplateHandler(OperatorHandler operatorHandler,
            SyntaxElementHandlerConfigurationBean<Type> handlerConfig) {
        this(handlerConfig.getWriter(),
                operatorHandler,
                handlerConfig.getMetaLookup(),
                handlerConfig.getSyntaxLookup(),
                handlerConfig.getNamingHelper(),                
                handlerConfig.getErrorBucket(),
                handlerConfig.getResolutionHelper()
                );
    }

    /**
     * Adds the template.
     * 
     * @param template
     *            the template
     * @param ruleBodyBufferFactory
     *            the rule body buffer factory
     * 
     * @throws SyntaxParsingException
     *             the syntax parsing exception
     * @throws MetaModelLookupException
     *             the meta model lookup exception
     * @throws SyntaxElementException 
     */
    public void addTemplate(ClassTemplate template,
            RuleBodyBufferFactory ruleBodyBufferFactory)
    throws MetaModelLookupException, SyntaxElementException {

        if (template.getPrefixSequence() != null) {
            errorBucket.addError("ClassTemplate prefixSequence not implemented yet.", template);
        }
        if (template.isMulti() && ! template.isMain()) {
            errorBucket.addWarning("Multi keyword can only be applied to main template, else it will be ignored.", template);
        }
        if (template.isAbstract() && template.isContext() && template.getTemplateSequence() == null) {
            errorBucket.addWarning("Context keyword can only be applied to non-abstract or non-empty template, else it will be ignored.", template);
        }
        if (! template.isAbstract() && template.isOperatored()) {
            errorBucket.addError("Only abstract templates can be made operatored.", template);
        }

        if (template.isDeep() ) {
            throw new RuntimeException("Deep not implemented yet");
        }

        String templateRulename = null;
        try {
            templateRulename = namingHelper.getRuleNameForMode(template, template.getMode());
            if (templateRulename == null) {
                errorBucket.addError("Template name could not be resolved.", template);
            } 
        } catch (SyntaxElementException e) {
            errorBucket.addException(e);
        }
        if (templateRulename != null) {

            if (template.isMain() ) {
                // adds the ANTLR rule main : ... ;
                addMainRule(template, templateRulename);
            }

            String initString = null;
            StringBuilder rulebody = new StringBuilder(); // first add ANTLR rule to Rulebody, then Java elements
            
            boolean isAbstractRule = false;
            
            if (template.isAbstract()) {
                initString = getInitString(template, false, false, false);
                addAbstractRuleBody(template, templateRulename, rulebody, ruleBodyBufferFactory);
                isAbstractRule = true;
            } else { // not abstract
                
                
                try {
                    List<ResolvedNameAndReferenceBean<Type>> subtypes = null;
                    ResolvedNameAndReferenceBean<Type> resolvedBean = resolutionHelper.resolve(template);
                    subtypes = metaLookup.getDirectSubTypes(resolvedBean);
                    if(TcsUtil.areSubTypesWithTemplates(subtypes, template.getMode(), syntaxLookup) &&
                	    !template.isReferenceOnly()) {
                	//We have a concrete class with additional subclasses
                	//first we need to create a rule for the concrete classes case
                	initString = getInitString(template, false, false, false);
                	String templateRulenameImpl = namingHelper.getConcreteRuleNameForTemplate(template, syntaxLookup);
                	StringBuilder implRuleBody = new StringBuilder();
                	String implRuleInitString = getInitString(template, false, true, true);
                	addTemplateSequenceToRuleBody(template, ruleBodyBufferFactory, implRuleBody);
                	addPostActions(template, implRuleBody);
                	writer.addRule(ClassProductionRule.getClassTemplateProductionRule(templateRulenameImpl, "Object ret2", implRuleInitString, implRuleBody.toString(), false, true));
                	
                	//Now create an abstract rule that has alternatives for the 
                	//implementation rule as well as all subtypes.
                	rulebody.append("(");
                	rulebody.append("ret=" + templateRulenameImpl);
                	rulebody.append("|");
                	addAbstractRuleBody(template, templateRulename, rulebody, ruleBodyBufferFactory);
                	rulebody.append("){ret2 = ret;}");
                	isAbstractRule = true;
                    } else {
                	initString = getInitString(template, false, true, true);
                	addTemplateSequenceToRuleBody(template, ruleBodyBufferFactory,
                                rulebody);
                        addPostActions(template, rulebody);
                        isAbstractRule = false;
                    }
                } catch (NameResolutionFailedException e) {
            	    errorBucket.addError(e.getMessage(), template);
            	}
            }
            // templateRulename is not null
            writer.addRule(ClassProductionRule.getClassTemplateProductionRule(templateRulename, "Object ret2", initString, rulebody.toString(), !isAbstractRule, !isAbstractRule));
        }

    }



    /**
     * @param template
     * @param templateRulename
     */
    private void addMainRule(ClassTemplate template, String templateRulename) {
        String rulebody = "((ret=" + templateRulename
        + ")";
        if (template.isMulti()) {
            rulebody += '+'; // add '+' to indicate that this main element may repeat in the syntax    
        }
        rulebody += " EOF)" + " \n  {\n" + "ret2=ret;\n" + "}";
        writer.addRule(new ClassProductionRule("main","Object ret2", null, rulebody, null));
    }

    private void addTemplateSequenceToRuleBody(ClassTemplate template,
            RuleBodyBufferFactory ruleBodyBufferFactory, StringBuilder rulebody)
    throws MetaModelLookupException {
        Sequence sequence = template.getTemplateSequence();
        String rulefragment = ruleBodyBufferFactory.getNewRuleBodyFragment(sequence);

        rulebody.append(rulefragment);
    }

    private void addPostActions(ClassTemplate template, StringBuilder rulebody) {
        rulebody.append("\n  {\n"); // code action here

        // set location command
        rulebody.append("ret2 = commitCreation(ret, firstToken, "+template.isContext()+");\n");
        
        rulebody.append("\n }");
    }

    /**
     * creates the initString, addToCurrentContext may be overridden, used for abstract templates with body.
     * @param template
     * @param addObjectCreation 
     * @param withEnterNotification 
     * @param overRideAddtoContext
     * @return
     * @throws JmiException 
     */
    private String getInitString(ClassTemplate template, boolean forceAddToContextFalse, boolean addObjectCreation, boolean withEnterNotification) {

        StringBuilder initString = new StringBuilder(128);
        try {
            if (withEnterNotification) {
                String metaObjectListParam = namingHelper.getMetaTypeListParameter(template);
                initString.append("List<String> metaType=").append( metaObjectListParam).append( ";\n");
                ObservationDirectivesHelper.appendEnterTemplateNotification(initString, template);            
            }
            
            if (addObjectCreation) {
                if (template.isReferenceOnly()) { // determine the type of proxy to create
                    initString.append("IModelElementProxy ret=(getBacktrackingLevel()==0) ? createReferenceProxy(metaType) : null;\n");
                } else {
                    initString.append("IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, ");
                    initString.append(template.isContext()).append(", ").append(
                            ( template.isAddToContext() && (! forceAddToContextFalse)));
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
                    initString.append(") : null;\n");
                }
               initString.append("org.antlr.runtime.Token firstToken=input.LT(1);\n");
            }
        } catch (SyntaxElementException e) {
            errorBucket.addException(e);
        }
        return initString.toString();
    }

    /**
     * utility method wrapping functionality for abstract template bodies
     * @param template
     * @param rulebody
     * @param ruleBodyBufferFactory 
     * @throws SyntaxParsingException
     * @throws MetaModelLookupException
     * @throws MetamodelNameResolvingException
     */
    private void addAbstractRuleBody(ClassTemplate template, String templateRulename, StringBuilder rulebody, RuleBodyBufferFactory ruleBodyBufferFactory) throws MetaModelLookupException {
        boolean hasAddedSubTemplates = false; // drives writing "ret2=ret;"
        String templateMode = template.getMode();
        
        if (template.isOperatored()) {
            if (templateMode != null) {
                // TODO implement this by adding mode wherever subtemplates are being invoked
                throw new RuntimeException("Operatored classtemplates with mode not implemented yet");
            }
            hasAddedSubTemplates = addOperatoredRules(template,
                    templateRulename, rulebody);

        } else { // not operatored
            List<ResolvedNameAndReferenceBean<Type>> subtypes = null;
            try {
                ResolvedNameAndReferenceBean<Type> resolvedBean = resolutionHelper.resolve(template);
                subtypes = metaLookup.getDirectSubTypes(resolvedBean);
            } catch (NameResolutionFailedException e) {
                errorBucket.addError(e.getMessage(), template);
            }

            // rulebody is one of the subtypes of the abstract template
            rulebody.append("("); // b1

            boolean isFirstAlternative = true;

            //get the templates for the direct subtypes
            if (subtypes != null) {
            	List<Template> templates = new ArrayList<Template>(subtypes.size());
                for (Iterator<ResolvedNameAndReferenceBean<Type>> iterator = subtypes.iterator(); iterator.hasNext();) {
                    try {
                        ResolvedNameAndReferenceBean<Type> subTypeName = iterator.next();
                        Template subtemp = null;

                        subtemp = syntaxLookup.getTCSTemplate(subTypeName, templateMode);

                        if (subtemp != null) {
                            templates.add(subtemp);
                        } else {
                            errorBucket.addWarning("No template present for subtype " + subTypeName.getNames() +" with mode #"+templateMode+" of type " + resolutionHelper.resolve(template), template);
                        }
                    } catch (SyntaxElementException e) {
						errorBucket.addException(e);
					} catch (NameResolutionFailedException e) {
                        errorBucket.addException(new SyntaxElementException(e.getMessage(), template, e));
                    }
                }
                //first sort the templates according to their occurrence in the syntax
                Collections.sort(templates, new Comparator<Template>(){

					@Override
					public int compare(Template o1, Template o2) {
						if(o1.equals(o2)) {
						    return 0;
						} else {
							return o1.getConcretesyntax().getTemplates().indexOf(o1) -
							o2.getConcretesyntax().getTemplates().indexOf(o2);
						}
					}
                	
                });
                //add (ret = xyz | ret = abc | ...) for all templates xyz, abc, ... extending this one
                for(Template subtemp : templates){
                	try {
						if (subtemp instanceof OperatorTemplate) {
							continue; // ignore operatorTemplates, as they
										// need to be invoked from Operator
										// rules
						}
						if (!isFirstAlternative) {
							rulebody.append("\n  | ");
						}
						if (subtemp.getDisambiguateV3() != null) {
							// add disambiguation rule
							rulebody.append("(" + subtemp.getDisambiguateV3() + ")=>("); // b2
						}
						rulebody.append("ret="
								+ namingHelper.getRuleNameForMode(subtemp, templateMode));

						isFirstAlternative = false;
						hasAddedSubTemplates = true;
						if (subtemp.getDisambiguateV3() != null) {
							// add disambiguation rule
							rulebody.append(")"); // b2
						}
					} catch (SyntaxElementException e) {
						errorBucket.addException(e);
					}
                }
            }

            // call abstractContentsrule if sequence is not empty
            Sequence sequence = template.getTemplateSequence();
            if (template.isAbstract() && sequence != null ) {
                if (! isFirstAlternative) {
                    rulebody.append("\n  | ");
                }
                rulebody.append("ret="+templateRulename + TemplateNamingHelper.ABSTRACT_CONTENTS_SUFFIX);
                // add a separate supporting rule for the abstract contents
                addAbstractContentsRule(template, templateRulename + TemplateNamingHelper.ABSTRACT_CONTENTS_SUFFIX, ruleBodyBufferFactory);
            }

            rulebody.append(")"); // b1

        }
        rulebody.append("\n  {\n");
        // don't need to add To context, as this will be done in 
        if (template.isAddToContext()) {
            rulebody.append("addToCurrentContext(ret);\n"); 
        }
        if (hasAddedSubTemplates) {
            rulebody.append("ret2=ret;");
        }
        rulebody.append("\n }");
    }

    /**
     * adds a separate rule to the grammar which creates the given template element (cannot work if abstract template refers to abstract modelElement)
     * @param template
     * @param ruleBodyBufferFactory 
     * @throws MetaModelLookupException 
     */
    private void addAbstractContentsRule(ClassTemplate template, String templateAbstractRulename, RuleBodyBufferFactory ruleBodyBufferFactory) throws MetaModelLookupException {
        String initString = getInitString(template, true, true, true);
        StringBuilder rulebody = new StringBuilder(); 
        addTemplateSequenceToRuleBody(template, ruleBodyBufferFactory,
                rulebody);
        addPostActions(template, rulebody);

        if (templateAbstractRulename != null) {
            writer.addRule(
                    ClassProductionRule.getClassTemplateProductionRule(
                            templateAbstractRulename, 
                            "Object ret2", 
                            initString, 
                            rulebody.toString(), 
                            true, true  // ! is not abstract, this is the case where the abstract template refers to a non-abstract model element
            ));
        }
    }

    /**
     * special case of operatored class template
     * @param template
     * @param templateRulename
     * @param rulebody
     * @return true if subtemplate rules have been added
     * @throws MetaModelLookupException
     */
    private boolean addOperatoredRules(ClassTemplate template,
            String templateRulename, StringBuilder rulebody)
    throws MetaModelLookupException {
        boolean hasAddedSubTemplates = false;
        // need to create 2 production rules in this case, one for 
        //<templateName>, one with primary_<templateName>

        // need to create production rules for the given OperatorList, need to get that list first
        OperatorList operatorList = template.getOperatorList();

        if (operatorList == null) {
            // since class is operatored, it needs an operatored list, so try to find and use anonymous one
            OperatorList anonymousOperatorList = syntaxLookup.getAnonymousOperatorList();
            if (anonymousOperatorList == null) {
                // Should never happen?
                throw new RuntimeException("Anonymous Operator List required but not defined.");
            } else {
                operatorList = anonymousOperatorList;
            }

        } else {
            String operatorListName = template.getOperatorList().getName();
            if (operatorListName == null) {
                throw new RuntimeException("Syntax model inconsistent. Contains non-anonymous Operator List without name.");
            }
        }
      
        try {

            List<ResolvedNameAndReferenceBean<Type>> subtypes = null;
            subtypes = metaLookup.getDirectSubTypes(resolutionHelper.resolve(template));
            
            List<ClassTemplate> nonPrimaries = writePrimaryRule(template,
                    templateRulename);
            
            List<ClassTemplate> primaries = syntaxLookup.getPrimaries(subtypes, metaLookup);
            
            boolean hasPrimaries = subtypes != null && primaries.size() > 0;
            
            
            operatorHandler.addOperatorList(operatorList, templateRulename, hasPrimaries);

            // add "primary_"+name rule alternating over primary subtemplates

            // production rule calling the priority with the highest index

            int highestIndex = getHighestPriorityIndex(operatorList);
            if (nonPrimaries.size() > 0) {
                rulebody.append('(');
            }
            rulebody.append("ret=" + OperatorHandler.getPriorityPrefix(operatorList) + "priority_" + highestIndex);
            for (ClassTemplate nonPrimarySubTemplate : nonPrimaries) {
                rulebody.append("\n  | ");
                rulebody.append("ret=" + namingHelper.getRuleName(nonPrimarySubTemplate));
            }
            if (nonPrimaries.size() > 0) {
                rulebody.append(')');
            }

            hasAddedSubTemplates = true;
        } catch (NameResolutionFailedException e1) {
            errorBucket.addError(e1.getMessage(), template);
        } catch (SyntaxElementException e) {
            errorBucket.addException(e);
        }
        return hasAddedSubTemplates;
    }

    /**
     * creates primary_xyz rule and returns list of all nonprimary subtemplates, 
     * that need to be added to the non primary rule of the template
     * @param template
     * @param templateRulename
     * @return
     * @throws MetaModelLookupException
     * @throws SyntaxElementException
     */
    private List<ClassTemplate> writePrimaryRule(ClassTemplate template,
            String templateRulename) throws MetaModelLookupException,
            SyntaxElementException {
        
        List<ResolvedNameAndReferenceBean<Type>> subtypes = null;
        try {
            subtypes = metaLookup.getDirectSubTypes(resolutionHelper.resolve(template));
        } catch (NameResolutionFailedException e1) {
            errorBucket.addError(e1.getMessage(), template);
        }
        
        List<ClassTemplate> nonPrimaries = syntaxLookup.getNonPrimaries(subtypes);
        try {
            List<ClassTemplate> primaries = syntaxLookup.getPrimaries(subtypes, metaLookup);
            if(primaries.size() == 0){
                errorBucket.addError("No template for concrete subclass found to be able to terminate operator this template", template);
            }
            if (subtypes != null && primaries.size() > 0) {
                StringBuilder rulebody = new StringBuilder();
                rulebody.append('(');

                // drives setting of '|'s, because iterator might have next but no valid ones
                boolean previousExists = false; 
               
                if (previousExists) {
                    rulebody.append("\n  | ");
                }

                for (Template subtemp : primaries) {

//                    if (subtemp == null) {
//                        errorBucket.addWarning("No Template exists in syntax for SubType " + subType.getNames(), template);
//                        continue;
//                    }
                    if (subtemp instanceof OperatorTemplate) {
                        // excluding TCS!OperatorTemplate from subtypes, because they can only be called 
                        // from priority rules where the required parameters (opName, left, Token) are known
                        continue;
                    }
                    if (subtemp instanceof ClassTemplate) {
                        ClassTemplate classSubTemp = (ClassTemplate) subtemp;
                        if (classSubTemp.isNonPrimary()) { // Non Primaries not added to primary rule
                            nonPrimaries.add(classSubTemp);
                            continue;
                        }
                    }
                    if (previousExists) {
                        rulebody.append("\n  | ");
                    }
                    if (subtemp instanceof ClassTemplate) {
                        ClassTemplate classSubTemp = (ClassTemplate) subtemp;
                        if(classSubTemp.getDisambiguateV3() != null) {
                        	rulebody.append("(");
                        	rulebody.append(classSubTemp.getDisambiguateV3());
                        	rulebody.append(")=>");
                        }
                    }
                    rulebody.append("ret=" + namingHelper.getRuleName(subtemp));
                    previousExists = true;
                }
                if (previousExists) {
                    rulebody.append("\n  | ");
                }
                // TODO parametrize bracket notation, use template sequence instead maybe
                rulebody.append("(");
                rulebody.append(ObservationDirectivesHelper.getEnterOperatoredBracketsSequenceNotification());
                rulebody.append(ObservationDirectivesHelper.getEnterSequenceElementNotification(null));
                rulebody.append("LPAREN ");
                rulebody.append(ObservationDirectivesHelper.getExitSequenceElementNotification());
                
                rulebody.append(ObservationDirectivesHelper.getEnterSequenceElementNotification(null));
                rulebody.append("ret=" + templateRulename);
                rulebody.append(ObservationDirectivesHelper.getExitSequenceElementNotification());
                
                rulebody.append(ObservationDirectivesHelper.getEnterSequenceElementNotification(null));
                rulebody.append(" RPAREN");
                rulebody.append(ObservationDirectivesHelper.getExitSequenceElementNotification());
                
                rulebody.append(")");
                rulebody.append(ObservationDirectivesHelper.getExitOperatoredBracketsSequenceNotification());
               
                rulebody.append(')');
                rulebody.append("\n  {\n  ret2=ret;\n}");
                writer.addRule(new ClassProductionRule("primary_" + templateRulename,
                        "Object ret2", null, rulebody.toString(), null));
            } // end if subtypes != null 
        } catch (NameResolutionFailedException e1) {
            errorBucket.addError(e1.getMessage(), template);
        }
        

        
        return nonPrimaries;
    }

    

    /**
     * Gets the highest priority index.
     * 
     * @return the highest priority index
     */
    protected static int getHighestPriorityIndex(OperatorList opList) {

        int max = 0;
        Collection<Priority> prios = opList.getPriorities();
        for (Iterator<Priority> iterator2 = prios.iterator(); iterator2.hasNext();) {
            Priority priority = iterator2.next();
            if (priority.getValue() > max) {
                max = priority.getValue();
            }   
        }
        return max;
    }
}
