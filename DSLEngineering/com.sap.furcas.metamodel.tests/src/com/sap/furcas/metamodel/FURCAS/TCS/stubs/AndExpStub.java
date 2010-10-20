/**
 * 
 */
package com.sap.furcas.metamodel.FURCAS.TCS.stubs;

import static org.junit.Assert.fail;

import org.eclipse.emf.common.util.EList;

import com.sap.furcas.metamodel.FURCAS.TCS.AndExp;
import com.sap.furcas.metamodel.FURCAS.TCS.AtomExp;
import com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement;

/**
 *
 */
public class AndExpStub extends LocatedElementStub implements AndExp {

    public EList<AtomExp> atomExpList;

    /* (non-Javadoc)
     * @see TCS.AndExp#getExpressions()
     */
    @Override
    public EList<AtomExp> getExpressions() {
        return atomExpList;
    }

    /* (non-Javadoc)
     * @see TCS.Expression#getConditionalElement()
     */
    @Override
    public ConditionalElement getConditionalElement() {
        fail("not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see TCS.Expression#setConditionalElement(TCS.ConditionalElement)
     */
    @Override
    public void setConditionalElement(ConditionalElement value) {
        fail("not implemented");
    }

}
