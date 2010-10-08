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

import org.eclipse.emf.common.util.EList;
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
	    public Integer getK() {

		return 0;
	    }

	    @Override
	    public List<Keyword> getKeywords() {

		return null;
	    }

	    @Override
	    public String getLexer() {

		return null;
	    }

	    @Override
	    public List<OperatorList> getOperatorLists() {

		return null;
	    }

	    @Override
	    public List<Symbol> getSymbols() {

		return null;
	    }

	    @Override
	    public List<Template> getTemplates() {

		return null;
	    }

	    @Override
	    public List<Token> getTokens() {

		return null;
	    }

	    @Override
	    public void setLexer(String value) {

	    }

	    @Override
	    public String getName() {

		return null;
	    }

	    @Override
	    public void setName(String value) {

	    }

	    @Override
	    public EList<String> getCommentsAfter() {

		return null;
	    }

	    @Override
	    public EList<String> getCommentsBefore() {

		return null;
	    }

	    @Override
	    public String getLocation() {

		return null;
	    }

	    @Override
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
