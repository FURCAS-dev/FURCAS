package com.sap.ide.cts.editor;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.Token;

import tcs.ConcreteSyntax;
import tcs.RulePattern;

public class FurcasPartitionScanner extends RuleBasedPartitionScanner {

    public final static String COMMENT = "__furcas_comment"; //$NON-NLS-1$

    public static final String[] PARTITIONS = new String[] { COMMENT };

    public FurcasPartitionScanner(ConcreteSyntax syntax) {
	Collection<IPredicateRule> rules = new ArrayList<IPredicateRule>();
	for (tcs.Token tok : syntax.getTokens()) {
	    if(tok.getPattern() != null && tok.getPattern().getSimplePatterns().size() >0 &&
 		    tok.getPattern().getSimplePatterns().iterator().next() instanceof RulePattern) {
		RulePattern ruleP = (RulePattern) tok.getPattern().getSimplePatterns().iterator().next();
		if(ruleP.getRule() instanceof tcs.MultiLineRule) {
		    tcs.MultiLineRule tcsRule = (tcs.MultiLineRule) ruleP.getRule();
		    char esc = 0;
		    if(tcsRule.getEsc() != null) {
			esc = tcsRule.getEsc().getName().charAt(0);
		    }
		    IPredicateRule pr = new MultiLineRule(tcsRule.getStart().getName(),
			    tcsRule.getEnd().getName(),
			    new Token(COMMENT),
			    esc,
			    false);
		    rules.add(pr);
		}
	    }
	}
	setPredicateRules(rules.toArray(new IPredicateRule[0]));
    }

}
