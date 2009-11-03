/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub;

import java.util.List;

import tcs.OperatorList;
import tcs.Priority;

/**
 *
 */
public class OperatorListStub extends LocatedElementStub implements OperatorList {

    public String name;
    public List<Priority> priorities;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /* (non-Javadoc)
     * @see TCS.OperatorList#getPriorities()
     */
    public List<Priority> getPriorities() {

        return priorities;
    }

  

    
}
