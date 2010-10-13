/**
 * 
 */
package com.sap.furcas.parsergenerator.tcs.t2m;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import com.sap.furcas.metamodel.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.TCS.Keyword;
import com.sap.furcas.metamodel.TCS.OperatorList;
import com.sap.furcas.metamodel.TCS.Symbol;
import com.sap.furcas.metamodel.TCS.Template;
import com.sap.furcas.metamodel.TCS.Token;
import com.sap.furcas.parsergenerator.tcs.t2m.TCSSyntaxContainerBean;


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

	ConcreteSyntax syntax = new ConcreteSyntax() {

	    @Override
	    public String getName() {
		return null;
	    }

	    @Override
	    public void setName(String value) {
		
	    }

	    @Override
	    public String getLocation() {
		return null;
	    }

	    @Override
	    public void setLocation(String value) {
		
	    }

	    @Override
	    public EList<String> getCommentsBefore() {
		return null;
	    }

	    @Override
	    public EList<String> getCommentsAfter() {
		return null;
	    }

	    @Override
	    public EClass eClass() {
		return null;
	    }

	    @Override
	    public Resource eResource() {
		return null;
	    }

	    @Override
	    public EObject eContainer() {
		return null;
	    }

	    @Override
	    public EStructuralFeature eContainingFeature() {
		return null;
	    }

	    @Override
	    public EReference eContainmentFeature() {
		return null;
	    }

	    @Override
	    public EList<EObject> eContents() {
		return null;
	    }

	    @Override
	    public TreeIterator<EObject> eAllContents() {
		return null;
	    }

	    @Override
	    public boolean eIsProxy() {
		return false;
	    }

	    @Override
	    public EList<EObject> eCrossReferences() {
		return null;
	    }

	    @Override
	    public Object eGet(EStructuralFeature feature) {
		return null;
	    }

	    @Override
	    public Object eGet(EStructuralFeature feature, boolean resolve) {
		return null;
	    }

	    @Override
	    public void eSet(EStructuralFeature feature, Object newValue) {
		
	    }

	    @Override
	    public boolean eIsSet(EStructuralFeature feature) {
		return false;
	    }

	    @Override
	    public void eUnset(EStructuralFeature feature) {
		
	    }

	    @Override
	    public Object eInvoke(EOperation operation, EList<?> arguments) throws InvocationTargetException {
		return null;
	    }

	    @Override
	    public EList<Adapter> eAdapters() {
		return null;
	    }

	    @Override
	    public boolean eDeliver() {
		return false;
	    }

	    @Override
	    public void eSetDeliver(boolean deliver) {
		
	    }

	    @Override
	    public void eNotify(Notification notification) {
		
	    }

	    @Override
	    public Integer getK() {
		return null;
	    }

	    @Override
	    public void setK(Integer value) {
		
	    }

	    @Override
	    public void unsetK() {
		
	    }

	    @Override
	    public boolean isSetK() {
		return false;
	    }

	    @Override
	    public EList<Template> getTemplates() {
		return null;
	    }

	    @Override
	    public EList<Keyword> getKeywords() {
		return null;
	    }

	    @Override
	    public EList<Symbol> getSymbols() {
		return null;
	    }

	    @Override
	    public EList<OperatorList> getOperatorLists() {
		return null;
	    }

	    @Override
	    public EList<Token> getTokens() {
		return null;
	    }

	    @Override
	    public String getLexer() {
		return null;
	    }

	    @Override
	    public void setLexer(String value) {
		
	    }

	};

	bean.setSyntax(syntax);
	assertEquals(syntax, bean.getSyntax());
    }

}
