/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub;

import java.util.Collection;

import com.sap.furcas.metamodel.TCS.OrPattern;
import com.sap.furcas.metamodel.TCS.SimplePattern;

/**
 *
 */
public class OrPatternStub extends LocatedElementStub implements OrPattern {
    
    public Collection<SimplePattern> simplePatterns;

    /* (non-Javadoc)
     * @see tcs.OrPattern#getSimplePatterns()
     */
    @Override
    public Collection<SimplePattern> getSimplePatterns() throws JmiException {
        return simplePatterns;
    }



 

  
}
