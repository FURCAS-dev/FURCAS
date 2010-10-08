/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub;

import java.util.List;

import com.sap.furcas.metamodel.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.TCS.Template;

/**
 *
 */
public class TemplateStub extends LocatedElementStub implements Template {

    public List<String> names;
    public String disambiguateV3;
    public Classifier metaReference;
    
    public TemplateStub() {
        
    }
    
    public TemplateStub(List<String> names) {
       this.names = names; 
    }

    /* (non-Javadoc)
     * @see TCS.Template#getConcreteSyntax()
     */
    public ConcreteSyntax getConcretesyntax() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see TCS.Template#getDisambiguate()
     */
    public String getDisambiguate() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see TCS.Template#getDisambiguateV3()
     */
    public String getDisambiguateV3() {
        return disambiguateV3;
    }

    /* (non-Javadoc)
     * @see TCS.Template#setConcreteSyntax(TCS.ConcreteSyntax)
     */
    public void setConcretesyntax(ConcreteSyntax value) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see TCS.Template#setDisambiguate(java.lang.String)
     */
    public void setDisambiguate(String value) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see TCS.Template#setDisambiguateV3(java.lang.String)
     */
    public void setDisambiguateV3(String value) {
       disambiguateV3 = value;

    }

    /* (non-Javadoc)
     * @see TCS.QualifiedNamedElement#getNames()
     */
    public List<String> getNames() {
        return names;
    }

    /* (non-Javadoc)
     * @see tcs.QualifiedNamedElement#getMetaReference()
     */
    @Override
    public Classifier getMetaReference() throws JmiException {
        return metaReference;
    }

    /* (non-Javadoc)
     * @see tcs.QualifiedNamedElement#setMetaReference(com.sap.tc.moin.repository.mmi.reflect.RefObject)
     */
    @Override
    public void setMetaReference(Classifier newValue) throws JmiException {
        // TODO Auto-generated method stub
        
    }

//    @Override
//    public Collection<Template> getCalledTemplates() throws JmiException {
//    	// TODO Auto-generated method stub
//    	return null;
//    }
    
    @Override
    public boolean hasSyntaxContributions() throws JmiException {
    	// TODO Auto-generated method stub
    	return false;
    }

    @Override
    public String getSemDisambiguate() throws JmiException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void setSemDisambiguate(String newValue) throws JmiException {
	// TODO Auto-generated method stub
	
    }  

}
