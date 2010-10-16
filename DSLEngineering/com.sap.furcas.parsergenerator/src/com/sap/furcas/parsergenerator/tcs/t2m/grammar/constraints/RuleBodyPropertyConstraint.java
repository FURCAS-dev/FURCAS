/**
 * 
 */
package com.sap.furcas.parsergenerator.tcs.t2m.grammar.constraints;

/**
 * if isDefined or one() is being used, then the propertyHandler needs to override it's usual behavior.
 * This is an indirect communication between the conditionalElementhandler and the PropertyHandler.
 * The list of constraints should in practice behave like a Stack, meaning remove should always happen 
 * on the last element.
 */

public abstract class RuleBodyPropertyConstraint {
    

    private String propertyName;


    /**
     * @param propertyName2
     */
    public RuleBodyPropertyConstraint(String propertyName2) {
        this.propertyName = propertyName2;
    }
    
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * @return the inverse constraint, or null if none is possible
     */
    public abstract RuleBodyPropertyConstraint getInverseConstraint();
    
}
