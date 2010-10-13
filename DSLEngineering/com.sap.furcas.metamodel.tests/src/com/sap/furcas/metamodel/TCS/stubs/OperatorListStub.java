/**
 * 
 */
package com.sap.furcas.metamodel.TCS.stubs;

import org.eclipse.emf.common.util.EList;

import com.sap.furcas.metamodel.TCS.OperatorList;
import com.sap.furcas.metamodel.TCS.Priority;

/**
 *
 */
public class OperatorListStub extends LocatedElementStub implements OperatorList {

    public String name;
    public EList<Priority> priorities;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    /* (non-Javadoc)
     * @see TCS.OperatorList#getPriorities()
     */
    @Override
    public EList<Priority> getPriorities() {
        return priorities;
    }

  

    
}
