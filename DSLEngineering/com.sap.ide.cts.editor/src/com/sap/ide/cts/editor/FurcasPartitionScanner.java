package com.sap.ide.cts.editor;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jface.text.rules.IPredicateRule;




import com.sap.furcas.metamodel.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.TCS.MultiLineRule;
import com.sap.furcas.metamodel.TCS.RulePattern;
import com.sap.furcas.metamodel.TCS.Token;

public class FurcasPartitionScanner extends RuleBasedPartitionScanner {

    public final static String COMMENT = "__furcas_comment"; //$NON-NLS-1$

    public static final String[] PARTITIONS = new String[] { COMMENT };

    public FurcasPartitionScanner(ConcreteSyntax syntax) {
	Collection<IPredicateRule> rules = new ArrayList<IPredicateRule>();
	for (Token tok : syntax.getTokens()) {
	    if(tok.getPattern() != null && tok.getPattern().getSimplePatterns().size() >0 &&
 		    tok.getPattern().getSimplePatterns().iterator().next() instanceof RulePattern) {
		RulePattern ruleP = (RulePattern) tok.getPattern().getSimplePatterns().iterator().next();
		if(ruleP.getRule() instanceof MultiLineRule) {
		    MultiLineRule tcsRule = (MultiLineRule) ruleP.getRule();
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
