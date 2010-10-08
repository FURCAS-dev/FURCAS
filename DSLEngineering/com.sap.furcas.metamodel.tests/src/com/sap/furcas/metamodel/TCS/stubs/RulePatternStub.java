/**
 * 
 */
package com.sap.furcas.metamodel.TCS.stubs;

import com.sap.furcas.metamodel.TCS.Rule;
import com.sap.furcas.metamodel.TCS.RulePattern;

/**
 *
 */
public class RulePatternStub extends SimplePatternStub implements RulePattern {

    public Rule rule;

    /**
     * @return the rule
     */
    @Override
    public Rule getRule() {
        return rule;
    }

    /**
     * @param rule the rule to set
     */
    @Override
    public void setRule(Rule rule) {
        this.rule = rule;
    }

  
}
