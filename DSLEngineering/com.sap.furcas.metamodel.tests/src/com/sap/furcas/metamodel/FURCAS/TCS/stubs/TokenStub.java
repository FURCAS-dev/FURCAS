/**
 * 
 */
package com.sap.furcas.metamodel.FURCAS.TCS.stubs;

import com.sap.furcas.metamodel.FURCAS.TCS.OrPattern;
import com.sap.furcas.metamodel.FURCAS.TCS.Token;

/**
 *
 */
public class TokenStub extends LocatedElementStub implements Token {

    public String name;
    public OrPattern orPattern;
    public boolean isOmitted = false;

    @Override
    public String getName() {
	return name;
    }

    @Override
    public void setName(String name) {
	this.name = name;
    }

    /**
     * @return the orPattern
     */
    @Override
    public OrPattern getPattern() {
	return orPattern;
    }

    /**
     * @param orPattern
     *            the orPattern to set
     */
    @Override
    public void setPattern(OrPattern orPattern) {
	this.orPattern = orPattern;
    }

    @Override
    public boolean isOmitted() {
	return isOmitted;
    }

    @Override
    public void setOmitted(boolean newValue) {

    }

}
