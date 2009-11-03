/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import tcs.ConcreteSyntax;
import tcs.Keyword;
import tcs.OperatorList;
import tcs.Symbol;
import tcs.Template;
import tcs.Token;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefException;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

/**
 *
 */
public class TestAbstractGrammarGenerator {

    /**
     * Test method for
     * {@link com.sap.mi.textual.grammar.impl.tcs.t2m.AbstractTCSGrammarGenerator#generateGrammar()}
     * .
     */
    @Test
    public void testGenerateGrammar() {
	// TODO

    }

    /**
     * Test method for
     * {@link com.sap.mi.textual.grammar.impl.tcs.t2m.TCSSyntaxContainerBean}.
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

	    public Integer getK() {

		return 0;
	    }

	    public List<Keyword> getKeywords() {

		return null;
	    }

	    public String getLexer() {

		return null;
	    }

	    public List<OperatorList> getOperatorLists() {

		return null;
	    }

	    public List<Symbol> getSymbols() {

		return null;
	    }

	    public List<Template> getTemplates() {

		return null;
	    }

	    public List<Token> getTokens() {

		return null;
	    }

	    public void setLexer(String value) {

	    }

	    public String getName() {

		return null;
	    }

	    public void setName(String value) {

	    }

	    public List<String> getCommentsAfter() {

		return null;
	    }

	    public List<String> getCommentsBefore() {

		return null;
	    }

	    public String getLocation() {

		return null;
	    }

	    public void setLocation(String value) {
	    }

	    public Collection<ConcreteSyntax> getImports() {
		return null;
	    }

	    @Override
	    public void setK(Integer newValue) throws JmiException {
	    }

	    @Override
	    public RefClass refClass() {
		return null;
	    }

	    @Override
	    public void refDelete() {
	    }

	    @Override
	    public RefFeatured refImmediateComposite() {
		return null;
	    }

	    @Override
	    public boolean refIsInstanceOf(RefObject objType, boolean considerSubtypes) {
		return false;
	    }

	    @Override
	    public RefFeatured refOutermostComposite() {
		return null;
	    }

	    @Override
	    public Object refGetValue(RefObject feature) {
		return null;
	    }

	    @Override
	    public Object refGetValue(String featureName) {
		return null;
	    }

	    @Override
	    public Object refInvokeOperation(RefObject requestedOperation, List<? extends Object> args) throws RefException {
		return null;
	    }

	    @Override
	    public Object refInvokeOperation(String requestedOperation, List<? extends Object> args) throws RefException {
		return null;
	    }

	    @Override
	    public void refSetValue(RefObject feature, Object value) {
	    }

	    @Override
	    public void refSetValue(String featureName, Object value) {
	    }

	    @Override
	    public RefPackage refImmediatePackage() {
		return null;
	    }

	    @Override
	    public RefObject refMetaObject() {
		return null;
	    }

	    @Override
	    public String refMofId() {
		return null;
	    }

	    @Override
	    public RefPackage refOutermostPackage() {
		return null;
	    }

	    @Override
	    public Collection<JmiException> refVerifyConstraints(boolean deepVerify) {
		return null;
	    }

	    @Override
	    public void assign___Partition(ModelPartition mp) {
	    }

	    @Override
	    public void assign___PartitionIncludingChildren(ModelPartition mp) {
	    }

	    @Override
	    public Connection get___Connection() {
		return null;
	    }

	    @Override
	    public <T extends RefBaseObject> Class<T> get___JmiInterface() {
		return null;
	    }

	    @Override
	    public MRI get___Mri() {
		return null;
	    }

	    @Override
	    public ModelPartition get___Partition() {
		return null;
	    }

	    @Override
	    public boolean is___Alive() {
		return false;
	    }
	};

	bean.setSyntax(syntax);
	assertEquals(syntax, bean.getSyntax());
    }

}
