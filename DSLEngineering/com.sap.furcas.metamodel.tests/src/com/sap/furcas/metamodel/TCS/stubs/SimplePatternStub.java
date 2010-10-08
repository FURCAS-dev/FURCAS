/**
 * 
 */
package com.sap.furcas.metamodel.TCS.stubs;

import com.sap.furcas.metamodel.TCS.SimplePattern;

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
