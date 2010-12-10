/**
 * 
 */
package com.sap.furcas.parsergenerator.tcs.t2m;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.ConcreteSyntaxStub;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;


/**
 *
 */
public class TestAbstractGrammarGenerator {

    /**
     * Test method for
     * {@link com.sap.furcas.parsergenerator.tcs.t2m.AbstractTCSGrammarGenerator#generateGrammar()}
     * .
     */
    @Test
    public void testGenerateGrammar() {
	// TODO

    }

    /**
     * Test method for
     * {@link com.sap.furcas.parsergenerator.TCSSyntaxContainerBean}.
     */
    @Test
    public void testBean() {
	TCSSyntaxContainerBean bean = new TCSSyntaxContainerBean();
	assertNull(bean.getSyntax());

	ConcreteSyntax syntax = new ConcreteSyntaxStub();

	bean.setSyntax(syntax);
	assertEquals(syntax, bean.getSyntax());
    }

}
