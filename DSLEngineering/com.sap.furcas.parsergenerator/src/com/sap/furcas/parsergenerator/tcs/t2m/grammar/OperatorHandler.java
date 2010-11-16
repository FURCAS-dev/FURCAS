/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2010-05-20 15:12:26 +0200 (Do, 20 Mai 2010) $
 * @version $Revision: 9718 $
 * @author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.furcas.parsergenerator.tcs.t2m.grammar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.sap.furcas.metamodel.FURCAS.TCS.Associativity;
import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Keyword;
import com.sap.furcas.metamodel.FURCAS.TCS.Literal;
import com.sap.furcas.metamodel.FURCAS.TCS.Operator;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorList;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Priority;
import com.sap.furcas.metamodel.FURCAS.TCS.PropertyReference;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.rules.ClassProductionRule;
import com.sap.furcas.parsergenerator.util.VarStringBuffer;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.common.exceptions.SyntaxElementException;
import com.sap.furcas.runtime.parser.exceptions.SyntaxParsingException;
import com.sap.furcas.runtime.tcs.TemplateNamingHelper;



/**
 * The Class OperatorHandler.
 */
public class OperatorHandler {

    /** The writer. */
    ANTLR3GrammarWriter writer;


    private final TemplateNamingHelper<?> namingHelper;


    private final SemanticErrorBucket errorBucket;

    /**
     * Instantiates a new operator handler.
     * 
     * @param writer the writer
     * @param syntaxLookup the syntax lookup
     * @param metaLookup 
     * @param namingHelper 
     * @param errorBucket 
     */
    protected OperatorHandler(ANTLR3GrammarWriter writer, TemplateNamingHelper<?> namingHelper, SemanticErrorBucket errorBucket) {
        super();
        this.writer = writer;
        this.namingHelper = namingHelper;
        this.errorBucket = errorBucket;
    }

    /**
     * @param handlerConfig
     */
    public OperatorHandler(SyntaxElementHandlerConfigurationBean<?> handlerConfig) {
        this(handlerConfig.getWriter(),
                handlerConfig.getNamingHelper(),
                handlerConfig.getErrorBucket());
    }

    /**
     * Adds production rules to the grammar for this classtemplate and the given operatorList.
     * Adding operator lists is complex, because operators in grammars are complex. For each operator,
     * we need to consider
     * priority (i.e. * higher than +),
     * arity (i.e. NOT(x) is unary, (x OR y) is binary,
     * associativity ((8/2)/2=2) vs (8/(2/2)=8), while 8/2/2 is ambiguous without associativity
     * 
     * The general idea is that for each priority a production rule ({prefix}_)?priority_{value} is created, where the
     * highest vale means highest priority, and this production rule is called first during parsing. Any production rule
     * then either is present by means of the operator symbol, or it calls the next priority operator rule. Only after no
     * operator in this chain is present does the production rule for the operatored class production rule get called. So
     * as an example, parsing "3" with 3 being of operatored class integer having 4 priorities of operators would invoke these rules:
     * integer -> priority_3 -> priority_2 -> priority_1 -> priority_0 -> primary_integer
     * 
     *  Priority rules for binary operators will look like this
 ( 
( ret=primary_element
-- first element to be parsed, can be recursive operatored expression (in brackets) or atomic expression without operator
((SYMBOL {opName = "*";} ((ret=atomicElement[opName, ret, firstToken]))))*
-- Loop (implicit recursion over variable ret!): Any next element will have the previous "ret" as left side
)
)
     * 
     * 
     * 
     * Apart from that there are technical concerns about TCS to consider here, i.e. references between operators and OperatorTemplates.
     * 
     * @param opList the op list
     * @param classTemplateName the class template name
     * @param hasPrimaries 
     * @param ruleBodyBufferFactory 
     * @param template 
     * @throws SyntaxParsingException 
     */
    public void addOperatorList(OperatorList opList, String classTemplateName, boolean hasPrimaries, RuleBodyBufferFactory ruleBodyBufferFactory, ClassTemplate template) {

        Collection<Priority> prios = opList.getPriorities();
        if (prios == null) {
            throw new IllegalArgumentException("OperatorList has null as Priorities List");
        } 

        String prefix = getPriorityPrefix(opList);
        // we can assume the following (need to check validity for better errors?)
        // Priorities begin with 0 and go up always +1. We cannot assume the order here, but there won't be missing numbers,
        // else the TCS definition is invalid.

        // add one rule per priority in list
        for (Priority priority : prios) {
            VarStringBuffer rulebody = new VarStringBuffer();
            String calledRule = null;
            if (priority.getValue() > 0) {
                calledRule = prefix + "priority_" + (priority.getValue() - 1);
            } else {
        	if(hasPrimaries) {
                    calledRule = "primary_";
                    if (classTemplateName != null) { 
                    	calledRule += classTemplateName.toLowerCase();
                    } else {
                    	// the syntax is invalid in that case, but we dealt with that earlier, so let is pass here
                    }
        	}
            }

            String associatedCallRule;
            boolean isLeftAssociative;
            if (priority.getAssociativity() == null || priority.getAssociativity() == Associativity.LEFT) {
                isLeftAssociative = true;
                associatedCallRule = calledRule;
            } else {
                isLeftAssociative = false;
                associatedCallRule = prefix + "priority_" + (priority.getValue()); // call same priority again
            }

            

            appendOperatorAlternatives(rulebody, priority, calledRule, associatedCallRule, isLeftAssociative, ruleBodyBufferFactory, template);

            rulebody.append("\n{\n")
            .append("this.setLocationAndComment(ret, firstToken);\n")
            .append("ret2=ret;\n }");


            String initString = "java.lang.String opName=null;\norg.antlr.runtime.Token firstToken=input.LT(1);" +
    			"\nObject semRef=null;";


            ClassProductionRule rule = ClassProductionRule.getClassTemplateProductionRule(prefix + "priority_" + priority.getValue(), "Object ret2", initString, rulebody.toString(), false, true);
            writer.addRule(rule);
        }
    }

    /**
     * negotiates the same usage of prefixes between classTemplateHandler and operatorHandler
     * @param opList
     * @return
     */
    public static String getPriorityPrefix(OperatorList opList) {
        String prefix;

        if (opList != null && opList.getName() != null) {
            prefix = opList.getName().toLowerCase() + '_';
        } else {
            prefix = ""; 
        }
        return prefix;
    }

    /**
     * within the priority production rule, operators rule calls and injector calls are required, this method deals with that.
     * 
     * @param rulebody the rulebody
     * @param priority the priority
     * @param nextCalledRule the rule to call in case there is no operator of this priority (fall through)
     * @param associatedCalledRule the rule to call to allow for associativity (a + b + c +  ...)
     * @param isLeftAssociative the is left associative
     * @param ruleBodyBufferFactory 
     * @param template 
     * @throws SyntaxParsingException 
     */
    private void appendOperatorAlternatives(VarStringBuffer rulebody,
    		 Priority priority, String nextCalledRule, String associatedCalledRule, boolean isLeftAssociative, RuleBodyBufferFactory ruleBodyBufferFactory, ClassTemplate template ) {

        rulebody.append(" ("); // b1
        Collection<Operator> operators = priority.getOperators();
        if (operators == null || operators.size() == 0) {
            rulebody.append("ret=").append(nextCalledRule); // fallthrough for priorities without operators
        } else {

            // sort operators according to their arity, first treat arity=1, then arity=2 (ignore other arities as done in ATL)
            List<Operator> unaryOperators = new ArrayList<Operator>(operators.size());
            List<Operator> binaryOperators = new ArrayList<Operator>(operators.size());
            splitOperators(operators, unaryOperators, binaryOperators);

            // binary operators have a different rulebody than unary ones, as they can repeat (a + b + c + d...)
            
            if (unaryOperators.size() > 0) {
            	List<Operator> nonPostFixUnaryOperators = new ArrayList<Operator>(operators.size());
            	for (Operator operator : unaryOperators) {
					if(!operator.isPostfix()) {
						nonPostFixUnaryOperators.add(operator);
					}
				}
            	if(nonPostFixUnaryOperators.size() > 0) {
            		appendOperatorsList(rulebody, nonPostFixUnaryOperators, associatedCalledRule, isLeftAssociative, 1, ruleBodyBufferFactory, template);
            		rulebody.append("\n|\n");
            	}
            }
            // in any case we need a reference to the nextCalled Rule.
            // In case of unary operators, this is an alternative in itself,
            // in case of binary operators, this would be the left side.

            rulebody.append(" ( ret=", nextCalledRule); // b2
            
            //now all postfix unary operators
            if (unaryOperators.size() > 0) {
            	List<Operator> postFixUnaryOperators = new ArrayList<Operator>(operators.size());
            	for (Operator operator : unaryOperators) {
					if(operator.isPostfix()) {
						postFixUnaryOperators.add(operator);
					}
				}
            	if(postFixUnaryOperators.size() > 0) {
            		rulebody.append("\n)(\n"); //b2
            		appendOperatorsList(rulebody, postFixUnaryOperators, associatedCalledRule, isLeftAssociative, 1, ruleBodyBufferFactory, template);
                	rulebody.append("\n|\n");
            	}
            }
            
            // now append all the possible operators + right sides to rule body, if any
            if (binaryOperators.size() > 0) {

                appendOperatorsList(rulebody, binaryOperators, associatedCalledRule, isLeftAssociative, 2, ruleBodyBufferFactory, template);
                // '*' or '?' depends on associativity of Priority

            }
            rulebody.append(')'); // b2

        } // end if more than zero operators in priority
        rulebody.append(')'); // b1

    }

    /**
     * splits operators in two lists according to their arity
     * @param operators
     * @param unaryOperators
     * @param binaryOperators
     */
    private void splitOperators(Collection<Operator> operators,
            List<Operator> unaryOperators, List<Operator> binaryOperators) {
        for (Operator operator : operators) {
            if (operator.getArity() == 1) {
                unaryOperators.add(operator);
            } else if (operator.getArity() == 2) {
                binaryOperators.add(operator);
            } else {
                errorBucket.addError("Operator with illegal arity: "
                        + operator.getName() + " has arity "
                        + operator.getArity(), operator);
            }
            if (operator.isPostfix() && operator.getArity() > 1) {
                errorBucket.addError("Postfix notation for arity > 1 not implemented yet.", operator);
            }
        }
    }

    /**
     * this method adds to the rulebody for each operator in the given list.
     * 
     * @param rulebody the rulebody
     * @param operators the operators
     * @param associativityCalledRule the associativity called rule
     * @param isLeftAssociative 
     * @param ruleBodyBufferFactory 
     * @param template
     * @throws SyntaxParsingException 
     */
    private void appendOperatorsList(VarStringBuffer targetrulebody,
    		 List<Operator> operators, String associativityCalledRule, boolean isLeftAssociative, int arity, RuleBodyBufferFactory ruleBodyBufferFactory, ClassTemplate template) {
        try {
            VarStringBuffer rulebody = new VarStringBuffer();
            boolean hasAddedOperator = false; // used to decide about parentheses, none if nothing is added

            for (Operator operator : operators) {
                // don't create anything if operator has no operator Template (non critical case? Maybe warning would be good.)
                Collection<OperatorTemplate> opTemplateList //= (Collection<OperatorTemplate>) operator.refGetValue("templates");
                                = operator.getTemplates();
                
                if (opTemplateList.size() == 0) {
                    // operator is in list, but never used in any operatorTemplate, so ignore it
                    errorBucket.addWarning("Operator not used by any template.", operator);
                    continue;
                }
                
                if (hasAddedOperator) {
                    rulebody.append("\n| ");
                }
                
                hasAddedOperator = true;

                Literal literal = operator.getLiteral();
                if (literal == null) { 
                    throw new SyntaxElementException("Operator does not have a literal " + operator, operator);
//                  literal = syntaxLookup.getLiteralForOperator(operator);
                }

                if (arity == 2 || isLeftAssociative) { // don't add here if unary and right associative
                    String literalValue = null;
                	if (literal instanceof Keyword) {
                        // Keywords being used by their value, as they are not declared as named symbols
                    	//add synpred to cope with recursion and the empty alternative
                	 literalValue = "'" + literal.getValue() + "'";
                    	
                    	
                    	
                    } else {
                    	//add synpred to cope with recursion and the empty alternative
                        literalValue = literal.getName().toUpperCase();
                    }
                	rulebody.append("((", literalValue, ")(");
                        boolean first = true;
                        List<String> synpreds = new ArrayList<String>(opTemplateList.size());
                        for (OperatorTemplate operatorTemplate : opTemplateList) {
                            
                            if(operatorTemplate.getDisambiguateV3() != null && !synpreds.contains(operatorTemplate.getDisambiguateV3())) {
                                synpreds.add(operatorTemplate.getDisambiguateV3());
                                if(!first) {
                                    rulebody.append("|");
                                } else {
                                    first = false;
                                }
                                rulebody.append("(", operatorTemplate.getDisambiguateV3(), ")");
                            }   
                        }
                        rulebody.append("))=>");
                }
                
                rulebody.append('('); // b2  required to separate operators, if many
                rulebody.append(ObservationDirectivesHelper.getEnterOperatorSequenceNotification(operator.getLiteral().getValue(), arity, operator.isPostfix()));
                
                if (arity == 2 || isLeftAssociative) { // don't add here if unary and right associative
                	//FIXME: have a seperate notification for operators? Or is OperatorSequence enough?
                	rulebody.append(ObservationDirectivesHelper.getEnterSequenceElementNotification(null));
                    appendOperatorLiteralBit(rulebody, literal);
                    rulebody.append(ObservationDirectivesHelper.getExitSequenceElementNotification());
                }
                
                rulebody.append('('); // b3  / required to separate templates if many
                
                SemanticDisambiguateHandler semanticHandler = new SemanticDisambiguateHandler(opTemplateList,
                		errorBucket, namingHelper);
                boolean addedSemanticDisambiguateRule = false;
                
                for (Iterator<OperatorTemplate> iterator2 = opTemplateList.iterator(); iterator2.hasNext();) {
                    OperatorTemplate opTemplate = iterator2.next();

//                  if (opTemplate == null || opTemplate.getNames() == null || namingHelper.getRuleName(opTemplate) == null) {
//                  // TODO: Can this ever happen after parsing the syntax? Probably not.
//                  throw new RuntimeException("Inconsistent OperatorTemplate either null or name == null " + opTemplate);
//                  }
                    /*
                     * if there are 2 operands (arity = 2), the expression for both operands is first created with 
                     * the first operand, then the second operand is parsed and set. For unary operators, there 
                     * is just one operand, so the containig expression is created with null as first operand, and 
                     * then the operand is set.
                     */
                    if (arity == 2) {
                    	if (semanticHandler
                                .shouldUseSemanticDisambiguate(opTemplate)) {
                            addedSemanticDisambiguateRule = semanticHandler
                                    .addSemanticDisambiguateRule(
                                            opTemplate,
                                            rulebody,
                                            ruleBodyBufferFactory,
                                            template,
                                            namingHelper
                                                    .getMetaTypeListParameter(template), addedSemanticDisambiguateRule);
                            if (iterator2.hasNext()) {
                                rulebody.append("\n| ");
                            }
                        } else {
                            if (opTemplate.getDisambiguateV3() != null) {
                                // add disambiguation rule
                                rulebody.append("("
                                        + opTemplate.getDisambiguateV3()
                                        + ")=>");
                            }
                            rulebody.append("(ret=", namingHelper
                                    .getRuleName(opTemplate),
                                    "[opName, ret, firstToken]");
                            // auch f�r sem pr�dikat am ende erzeugen
                            String storeRightTo = getRightSideStorageName(opTemplate);
                            if (storeRightTo != null) { // is this ever
                                                        // possible?
                                rulebody.append("right=",
                                        associativityCalledRule);
                                rulebody
                                        .append(
                                                " {setProperty(ret, \"",
                                                storeRightTo,
                                                "\", right);\n",
                                                "this.setLocationAndComment(ret, firstToken);\n",
                                                "}");
                            }
                            rulebody.append(')');
                            if (iterator2.hasNext()) {
                                rulebody.append("\n| ");
                            }
                        }
                    } else { 
                        // arity == 1, unary templates don't have a StoreRightTo attribute, because they are unary.
                        if (opTemplate.getDisambiguateV3() != null) {
                            // add disambiguation rule
                            rulebody.append("("
                                    + opTemplate.getDisambiguateV3() + ")=>");
                        }
                        if (operator.isPostfix()) {
                            rulebody.append("(ret=", namingHelper
                                    .getRuleName(opTemplate),
                                    "[opName, ret, firstToken]");
                        } else {
                            rulebody.append("(ret=", namingHelper
                                    .getRuleName(opTemplate),
                                    "[opName, null, firstToken]");
                        }
                        if (!isLeftAssociative) { // add here if unary and right
                                                  // associative
                            rulebody.append(ObservationDirectivesHelper
                                    .getEnterSequenceElementNotification(null));
                            appendOperatorLiteralBit(rulebody, literal);
                            rulebody.append(ObservationDirectivesHelper
                                    .getExitSequenceElementNotification());
                        }
                    	 if(operator.isPostfix()) {
                    		 rulebody.append("(ret=", namingHelper.getRuleName(opTemplate), "[opName, ret, firstToken]");
                    	 } else {
                    		 rulebody.append("(ret=", namingHelper.getRuleName(opTemplate), "[opName, null, firstToken]");
                    	 }
                        if ( ! isLeftAssociative) { // add here if unary and right associative
                            rulebody.append(ObservationDirectivesHelper.getEnterSequenceElementNotification(null));
                            appendOperatorLiteralBit(rulebody, literal);
                            rulebody.append(ObservationDirectivesHelper.getExitSequenceElementNotification());
                        }
                        if ( ! operator.isPostfix()) {
                            rulebody.append("right=", associativityCalledRule);				    
                            rulebody.append(" {setProperty(ret, \"", getSourceStorageName(opTemplate), "\", right);\n");
                        } else {
                            rulebody.append("{");
                        }
                        rulebody.append("this.setLocationAndComment(ret, firstToken);\n",
                        "})");
                    }


                    if (iterator2.hasNext()) {
                        rulebody.append("\n| ");
                    }
                } // end for operatorTemplates of operator
                rulebody.append(')'); // b3

                rulebody.append(ObservationDirectivesHelper.getExitOperatorSequenceNotification());
                rulebody.append(')'); // b2
//                if (iterator.hasNext()) {
//                    rulebody.append("\n| ");
//                }			
            } // end for operators



            if (hasAddedOperator) {
                targetrulebody.append('('); // bx

                targetrulebody.append(rulebody);

                if (arity == 2) {
                    if (isLeftAssociative) {
                        targetrulebody.append(")*"); // bx
                    } else {
                        targetrulebody.append(")?"); // bx
                    }
                } else {
                    targetrulebody.append(")"); // bx
                }
            } // end if added anything
        } catch (SyntaxElementException e) {
            errorBucket.addException(e);
        } catch (MetaModelLookupException e) {
            errorBucket.addException(new SyntaxElementException(e.getMessage(),
                    null, e));
        }
    }

    private static void appendOperatorLiteralBit(VarStringBuffer rulebody,
            Literal literal) {
        if (literal instanceof Keyword) {
            // Keywords being used by their value, as they are not declared as named symbols
            rulebody.append('\'', literal.getValue(), '\'');
        } else {
            rulebody.append(literal.getName().toUpperCase(), ' ');
        }
        rulebody.append("{opName = \"", literal.getValue(), "\";}");
    }


    /**
     * @param template
     * @return
     */
    private static String getRightSideStorageName(OperatorTemplate template) {
        if (template != null) {
            PropertyReference propRef = template.getStoreRightSideTo();
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
            if (propRef != null) { // may happen with stubs
                if (propRef.getStrucfeature() != null) {
                    return propRef.getStrucfeature().getName();
                } else {
                    return propRef.getName();
                }
            }
        }
        return null;
    }
}
