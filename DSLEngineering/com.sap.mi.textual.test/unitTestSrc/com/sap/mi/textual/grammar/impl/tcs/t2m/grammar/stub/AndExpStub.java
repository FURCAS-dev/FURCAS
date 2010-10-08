/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub;

import static org.junit.Assert.fail;

import java.util.List;

import com.sap.furcas.metamodel.TCS.AndExp;
import com.sap.furcas.metamodel.TCS.AtomExp;
import com.sap.furcas.metamodel.TCS.ConditionalElement;

/**
 *
 */
public class AndExpStub extends LocatedElementStub implements AndExp {

    public List<AtomExp> atomExpList;

    /* (non-Javadoc)
     * @see TCS.AndExp#getExpressions()
     */
    public List<AtomExp> getExpressions() {
        return atomExpList;
    }

    /* (non-Javadoc)
     * @see TCS.Expression#getConditionalElement()
     */
    public ConditionalElement getConditionalElement() {
        fail("not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see TCS.Expression#setConditionalElement(TCS.ConditionalElement)
     */
    public void setConditionalElement(ConditionalElement value) {
        fail("not implemented");
    }

}
