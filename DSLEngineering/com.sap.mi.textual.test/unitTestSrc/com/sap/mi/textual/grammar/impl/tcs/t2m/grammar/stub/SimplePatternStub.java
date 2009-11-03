/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub;

import tcs.SimplePattern;

/**
 *
 */
public class SimplePatternStub extends LocatedElementStub implements SimplePattern {

    public String  name;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  
}
