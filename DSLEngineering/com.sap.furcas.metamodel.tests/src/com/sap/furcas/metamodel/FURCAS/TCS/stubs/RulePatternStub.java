/**
 * 
 */
package com.sap.furcas.metamodel.FURCAS.TCS.stubs;

import org.eclipse.emf.ecore.EClass;

import com.sap.furcas.metamodel.FURCAS.TCS.Rule;
import com.sap.furcas.metamodel.FURCAS.TCS.RulePattern;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

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

    @Override
    public EClass eClass() {
        return TCSPackage.eINSTANCE.getRulePattern();
    }

}
