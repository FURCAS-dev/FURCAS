/**
 * 
 */
package com.sap.furcas.parsergenerator.tcs.t2m.grammar.constraints;

/**
 *
 */
public class PropertyQuantityConstraint extends RuleBodyPropertyConstraint {
    public static final int ISDEFINED_KEY = 0;
    public static final int ONE_KEY = 1;
    
    
    private int key;
    private boolean value;
    
    public PropertyQuantityConstraint(String propertyName, int key,
            boolean value) {
        super(propertyName);

        this.key = key;
        this.value = value;
    }



    public int getKey() {
        return key;
    }

    public boolean isValue() {
        return value;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "(" + getPropertyName() + ":" + getKey() + "=" + isValue() + ")";
    }



    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.RuleBodyPropertyConstraint#getInverseConstraint()
     */
    @Override
    public RuleBodyPropertyConstraint getInverseConstraint() {
        // invert the value with !
        return new PropertyQuantityConstraint(getPropertyName(), getKey(), ! isValue());
    }
    
}
