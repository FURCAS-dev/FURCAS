/**
 * 
 */
package com.sap.furcas.metamodel.FURCAS.TCS.stubs;

import org.eclipse.emf.common.util.EList;

import com.sap.furcas.metamodel.FURCAS.TCS.OrPattern;
import com.sap.furcas.metamodel.FURCAS.TCS.SimplePattern;

/**
 *
 */
public class OrPatternStub extends LocatedElementStub implements OrPattern {
    
    public EList<SimplePattern> simplePatterns;

    /* (non-Javadoc)
     * @see tcs.OrPattern#getSimplePatterns()
     */
    @Override
    public EList<SimplePattern> getSimplePatterns() {
        return simplePatterns;
    }



 

  
}
