/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub;

import java.util.Collection;

import tcs.OrPattern;
import tcs.SimplePattern;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

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
