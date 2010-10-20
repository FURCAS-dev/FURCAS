/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-04-23 14:54:43 +0200 (Do, 23 Apr 2009) $
 * @version $Revision: 6272 $
 * @author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.furcas.parsergenerator.tcs.t2m.grammar;

import java.util.Collection;
import java.util.Iterator;

import com.sap.furcas.metamodel.FURCAS.TCS.ClassPattern;
import com.sap.furcas.metamodel.FURCAS.TCS.EndOfLineRule;
import com.sap.furcas.metamodel.FURCAS.TCS.MultiLineRule;
import com.sap.furcas.metamodel.FURCAS.TCS.OrPattern;
import com.sap.furcas.metamodel.FURCAS.TCS.Rule;
import com.sap.furcas.metamodel.FURCAS.TCS.RulePattern;
import com.sap.furcas.metamodel.FURCAS.TCS.SimplePattern;
import com.sap.furcas.metamodel.FURCAS.TCS.StringPattern;
import com.sap.furcas.metamodel.FURCAS.TCS.Token;
import com.sap.furcas.metamodel.FURCAS.TCS.WordRule;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.rules.SimpleProductionRule;


/**
 * The Class TokenHandler.
 */
public class TokenHandler {

	/** The writer. */
	private final ANTLR3GrammarWriter writer;
	
    private final SemanticErrorBucket errorBucket;
	
    /**
     * Instantiates a new token handler.
     * 
     * @param writer the writer
     */
    TokenHandler(ANTLR3GrammarWriter writer, SemanticErrorBucket errorBucket) {
        super();
        this.writer = writer;
        this.errorBucket = errorBucket;
    }


	/**
     * @param handlerConfig
     */
    public TokenHandler(SyntaxElementHandlerConfigurationBean<?> handlerConfig) {
        this(handlerConfig.getWriter(), handlerConfig.getErrorBucket());
    }


    /**
	 * Adds a rule for the token.
	 * 
	 * @param token the token
	 */
	public void addToken(Token token) {
		OrPattern pat = token.getPattern();
		
		StringBuilder rulebody = new StringBuilder();
        rulebody.append("   ");
        
		Collection<SimplePattern> simPatList = pat.getSimplePatterns();
		
		
		addSimplePatterns(rulebody, simPatList);
		if(token.isOmitted()){
			rulebody.append("{$channel=HIDDEN;}");
		}

		writer.addRule(new SimpleProductionRule(token.getName(), rulebody.toString()));
	}


    /**
     * adds simple patterns, can be called recursively.
     * @param rulebody
     * @param simPatList
     */
    private void addSimplePatterns(StringBuilder rulebody,
            Collection<SimplePattern> simPatList) {
        if (simPatList == null) {
            return;
        }
        rulebody.append('(');
        for (Iterator<SimplePattern> patternIterator = simPatList.iterator(); patternIterator.hasNext();) 
		{
			SimplePattern simplePattern = patternIterator.next();
			if (simplePattern instanceof RulePattern) {
				RulePattern rulePat = (RulePattern) simplePattern;
				
				addRulePattern(rulebody, rulePat);
				
			} else if (simplePattern instanceof ClassPattern) {
                ClassPattern cPat = (ClassPattern) simplePattern;
                String name = cPat.getName();
                if ("alnum".equals(name)) {
                    rulebody.append("('A' .. 'Z'| 'a' .. 'z'| '0' .. '9')");
                } else if ("alpha".equals(name)) {
                    rulebody.append("('A' .. 'Z'| 'a' .. 'z')");
                } else {
                    errorBucket.addError("ClassPattern name unknown: " + name, simplePattern);
                }
                
			} else if (simplePattern instanceof StringPattern) {
			    StringPattern sPat = (StringPattern) simplePattern;
			    String name = sPat.getName();
			    if (name == null ) {
			        errorBucket.addError("Name cannot be null", simplePattern);                
			    }
                rulebody.append('\'').append(escapeString(name)).append('\'');
			    
            } else {
				errorBucket.addError(simplePattern.getClass() + " is unknown SimplePattern instance", simplePattern);				
			}
			if (patternIterator.hasNext()) {
			    rulebody.append(" | ");
			}
		} // end for patterns
        rulebody.append(')');
    }


    /**
     * adds to the antlr Grammar rulebody regarding any known rule type in TCS
     * @param rulebody
     * @param rulePat
     */
    private void addRulePattern(StringBuilder rulebody, RulePattern rulePat) {
        Rule rule = rulePat.getRule();
        
        if (rule instanceof EndOfLineRule) {
        	EndOfLineRule eolRule = (EndOfLineRule) rule;
        	if (eolRule.isDropStart()) {
        	    throw new RuntimeException(rule.getClass() + " dropStart to grammar not implemented yet");
        	}
        	StringPattern startPat = eolRule.getStart();
            rulebody.append("(('" + escapeString(startPat.getName())
                    + "' (~('\\r'| '\\n'))*))");
            // TODO: Create Regex Pattern from model?
            
        } else if (rule instanceof MultiLineRule) {
            MultiLineRule eolRule = (MultiLineRule) rule;
            if (eolRule.isDropStart()) {
                throw new RuntimeException(rule.getClass() + " dropStart to grammar not implemented yet");
            }
            if (eolRule.isDropEnd()) {
                throw new RuntimeException(rule.getClass() + " dropEnd to grammar not implemented yet");
            }
            if (eolRule.getEsc() != null) {
                throw new RuntimeException(rule.getClass() + " Esc to grammar not implemented yet");
            }
            if (eolRule.getEscMappings() != null && eolRule.getEscMappings().size() > 0) {
                throw new RuntimeException(rule.getClass() + " EscMappings to grammar not implemented yet");
            }
            StringPattern startPat = eolRule.getStart();
            StringPattern endPat = eolRule.getEnd();
            rulebody.append("(('" + escapeString(startPat.getName())
                  + "' (options {greedy = false;} : (\'\\n\'| ~ \'\\n\'))* '" + escapeString(endPat.getName()) + "'))");
            
        } else if (rule instanceof WordRule) { 
            // word rules have a beginning patter, a middle "part" pattern that can be repeated * times, and an end pattern
            WordRule wRule = (WordRule) rule;
            OrPattern start = wRule.getStart();
            OrPattern part = wRule.getPart();
            OrPattern end = wRule.getEnd();				    

            
            if (start == null && end == null) {
                errorBucket.addError("Either start or end must be defined for word() rule", rule);
            }
            
         // recursive calls
            if (start != null && start.getSimplePatterns() != null && start.getSimplePatterns().size() != 0) {
                addSimplePatterns(rulebody, start.getSimplePatterns());
                if (part != null || end != null ) {
                    rulebody.append("   \n");
                }
            }
            
            if (part != null && part.getSimplePatterns() != null && part.getSimplePatterns().size() != 0) {
                rulebody.append('(');
                addSimplePatterns(rulebody, part.getSimplePatterns());
                rulebody.append(")*");
                if (end != null) {
                    rulebody.append("   \n");
                }
            }
            if (end != null) {
                addSimplePatterns(rulebody, end.getSimplePatterns());
            }
            
        } else {
        	// should never happen, as TCS only defines EOL, Multiline and word rules
        	throw new RuntimeException(rule.getClass() + " to grammar not implemented yet");
        }
    }
    
    private static String escapeString(String source) {
        if (source != null) {
            return source.replaceAll("\\'", "\\\\\'");
        }
        return null;
    }
	
}
