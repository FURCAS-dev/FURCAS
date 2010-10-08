/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub;


/**
 *
 */
public class TokenStub extends LocatedElementStub implements Token {

    public String  name;
    public OrPattern orPattern;
    public boolean isOmitted = false;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the orPattern
     */
    public OrPattern getPattern() {
        return orPattern;
    }

    /**
     * @param orPattern the orPattern to set
     */
    public void setPattern(OrPattern orPattern) {
        this.orPattern = orPattern;
    }

	@Override
	public boolean isOmitted() throws JmiException {
		return isOmitted;
	}

	@Override
	public void setOmitted(boolean newValue) throws JmiException {
		// TODO Auto-generated method stub
		
	}
  
}
