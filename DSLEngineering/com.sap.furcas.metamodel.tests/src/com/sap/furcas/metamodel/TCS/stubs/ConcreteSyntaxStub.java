/**
 * 
 */
package com.sap.furcas.metamodel.TCS.stubs;

import static org.junit.Assert.fail;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import com.sap.furcas.metamodel.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.TCS.Keyword;
import com.sap.furcas.metamodel.TCS.OperatorList;
import com.sap.furcas.metamodel.TCS.Symbol;
import com.sap.furcas.metamodel.TCS.Template;
import com.sap.furcas.metamodel.TCS.Token;

/**
 *
 */
public class ConcreteSyntaxStub extends LocatedElementStub implements ConcreteSyntax {

    public EList<Template> templates  = new BasicEList<Template>();
    public EList<Symbol> symbols = new BasicEList<Symbol>();
    public EList<OperatorList> operatorListList = new BasicEList<OperatorList>();
    public EList<Keyword> keywords = new BasicEList<Keyword>();
    public String name;
    public String lexer;
    public int syntaxK = 1;
    public EList<Token> tokens = new BasicEList<Token>();

    /* (non-Javadoc)
     * @see TCS.ConcreteSyntax#getK()
     */
    @Override
    public Integer getK() {
    	if(syntaxK == -1) {
    		return null;
    	}
        return new Integer(syntaxK);
    }

    /* (non-Javadoc)
     * @see TCS.ConcreteSyntax#getKeywords()
     */
    @Override
    public EList<Keyword> getKeywords() {
        return keywords;
    }

    /* (non-Javadoc)
     * @see TCS.ConcreteSyntax#getLexer()
     */
    @Override
    public String getLexer() {
        return lexer;
    }

    /* (non-Javadoc)
     * @see TCS.ConcreteSyntax#getOperatorLists()
     */
    @Override
    public EList<OperatorList> getOperatorLists() {
        return operatorListList;
    }

    /* (non-Javadoc)
     * @see TCS.ConcreteSyntax#getSymbols()
     */
    @Override
    public EList<Symbol> getSymbols() {
        return symbols;
    }

    /* (non-Javadoc)
     * @see TCS.ConcreteSyntax#getTemplates()
     */
    @Override
    public EList<Template> getTemplates() {
        return templates;
    }

    /* (non-Javadoc)
     * @see TCS.ConcreteSyntax#getTokens()
     */
    @Override
    public EList<Token> getTokens() {
        return tokens;
    }

    /* (non-Javadoc)
     * @see TCS.ConcreteSyntax#setK(int)
     */
    @Override
    public void setK(Integer value) {
        fail("not implemented yet");
        
    }

    /* (non-Javadoc)
     * @see TCS.ConcreteSyntax#setLexer(java.lang.String)
     */
    @Override
    public void setLexer(String value) {
        fail("not implemented yet");
        
    }

    /* (non-Javadoc)
     * @see TCS.NamedElement#getName()
     */
    @Override
    public String getName() {
        return name;
    }

    /* (non-Javadoc)
     * @see TCS.NamedElement#setName(java.lang.String)
     */
    @Override
    public void setName(String value) {
        fail("not implemented yet");
    }

    @Override
    public void unsetK() {
	// TODO Auto-generated method stub
    }

    @Override
    public boolean isSetK() {
	// TODO Auto-generated method stub
	return false;
    }


}
