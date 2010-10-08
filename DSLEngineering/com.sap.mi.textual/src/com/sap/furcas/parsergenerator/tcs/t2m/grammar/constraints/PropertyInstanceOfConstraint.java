/**
 * 
 */
package com.sap.furcas.parsergenerator.tcs.t2m.grammar.constraints;

import java.util.List;

/**
 *
 */
public class PropertyInstanceOfConstraint extends RuleBodyPropertyConstraint {

    

    
    private List<String> typename;



    public PropertyInstanceOfConstraint(String propertyName, List<String> typename) {
        super(propertyName);
        this.typename = typename;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "(" + getPropertyName() + " instanceof " + getTypename() + ")";
    }



    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.RuleBodyPropertyConstraint#getInverseConstraint()
     */
    @Override
    public RuleBodyPropertyConstraint getInverseConstraint() {
        // has no inverse, even though we could try "not instance of", but tis would not help with anything
        return null;
    }

    public List<String> getTypename() {
        return typename;
    }
    
}
