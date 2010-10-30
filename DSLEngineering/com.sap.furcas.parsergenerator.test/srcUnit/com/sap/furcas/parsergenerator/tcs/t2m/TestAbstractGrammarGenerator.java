/**
 * 
 */
package com.sap.furcas.parsergenerator.tcs.t2m;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.Keyword;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.ConcreteSyntaxStub;


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
     * {@link com.sap.furcas.parsergenerator.tcs.t2m.TCSSyntaxContainerBean}.
     */
    @Test
    public void testBean() {
	TCSSyntaxContainerBean bean = new TCSSyntaxContainerBean();
	assertNull(bean.getKeywords());
	assertNull(bean.getSyntax());

	Set<Keyword> keywords = null;
	bean.setKeywords(keywords);
	assertNull(bean.getKeywords());

	keywords = new HashSet<Keyword>();
	bean.setKeywords(keywords);
	assertEquals(keywords, bean.getKeywords());

	ConcreteSyntax syntax = new ConcreteSyntaxStub();

	bean.setSyntax(syntax);
	assertEquals(syntax, bean.getSyntax());
    }

}
