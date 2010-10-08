/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sap.furcas.metamodel.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.TCS.Keyword;
import com.sap.furcas.metamodel.TCS.OperatorList;

/**
 *
 */
public class ConcreteSyntaxStub extends LocatedElementStub implements ConcreteSyntax {

    public List<Template> templates  = new ArrayList<Template>();
    public List<Symbol> symbols = new ArrayList<Symbol>();
    public List<OperatorList> operatorListList = new ArrayList<OperatorList>();
    public List<Keyword> keywords = new ArrayList<Keyword>();
    public String name;
    public String lexer;
    public int syntaxK = 1;
    public List<Token> tokens = new ArrayList<Token>();

    /* (non-Javadoc)
     * @see TCS.ConcreteSyntax#getK()
     */
    public Integer getK() {
    	if(syntaxK == -1) {
    		return null;
    	}
        return new Integer(syntaxK);
    }

    /* (non-Javadoc)
     * @see TCS.ConcreteSyntax#getKeywords()
     */
    public List<Keyword> getKeywords() {
        return keywords;
    }

    /* (non-Javadoc)
     * @see TCS.ConcreteSyntax#getLexer()
     */
    public String getLexer() {
        return lexer;
    }

    /* (non-Javadoc)
     * @see TCS.ConcreteSyntax#getOperatorLists()
     */
    public List<OperatorList> getOperatorLists() {
        return operatorListList;
    }

    /* (non-Javadoc)
     * @see TCS.ConcreteSyntax#getSymbols()
     */
    public List<Symbol> getSymbols() {
        return symbols;
    }

    /* (non-Javadoc)
     * @see TCS.ConcreteSyntax#getTemplates()
     */
    public List<Template> getTemplates() {
        return templates;
    }

    /* (non-Javadoc)
     * @see TCS.ConcreteSyntax#getTokens()
     */
    public List<Token> getTokens() {
        return tokens;
    }

    /* (non-Javadoc)
     * @see TCS.ConcreteSyntax#setK(int)
     */
    public void setK(Integer value) {
        fail("not implemented yet");
        
    }

    /* (non-Javadoc)
     * @see TCS.ConcreteSyntax#setLexer(java.lang.String)
     */
    public void setLexer(String value) {
        fail("not implemented yet");
        
    }

    /* (non-Javadoc)
     * @see TCS.NamedElement#getName()
     */
    public String getName() {
        return name;
    }

    /* (non-Javadoc)
     * @see TCS.NamedElement#setName(java.lang.String)
     */
    public void setName(String value) {
        fail("not implemented yet");
        
    }

    @Override
    public Collection<ConcreteSyntax> getImports() throws JmiException {
        fail("not implemented yet");
        return null;
    }


}
