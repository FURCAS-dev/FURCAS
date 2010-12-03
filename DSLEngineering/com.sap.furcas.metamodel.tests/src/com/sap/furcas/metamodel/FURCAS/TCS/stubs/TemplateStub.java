/**
 * 
 */
package com.sap.furcas.metamodel.FURCAS.TCS.stubs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextBlockDefinition;

/**
 *
 */
public class TemplateStub extends LocatedElementStub implements Template {

    public EList<String> names;
    public String disambiguateV3;
	public String semDisambiguate;    
    public EClass metaReference;
	public TextBlockDefinition textBlockDefinition;
    
    public TemplateStub() {
        
    }
    
    public TemplateStub(EList<String> names) {
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
    @Override
    public String getDisambiguate() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see TCS.Template#getDisambiguateV3()
     */
    @Override
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
    @Override
    public void setDisambiguate(String value) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see TCS.Template#setDisambiguateV3(java.lang.String)
     */
    @Override
    public void setDisambiguateV3(String value) {
       disambiguateV3 = value;

    }

    /* (non-Javadoc)
     * @see TCS.QualifiedNamedElement#getNames()
     */
    @Override
    public EList<String> getNames() {
        return names;
    }

    /* (non-Javadoc)
     * @see tcs.QualifiedNamedElement#getMetaReference()
     */
    @Override
    public EClass getMetaReference() {
        return metaReference;
    }

    /* (non-Javadoc)
     * @see tcs.QualifiedNamedElement#setMetaReference(com.sap.tc.moin.repository.mmi.reflect.RefObject)
     */
    @Override
    public void setMetaReference(EClassifier newValue) {
        // TODO Auto-generated method stub
    }

    @Override
    public ConcreteSyntax getConcreteSyntax() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void setConcreteSyntax(ConcreteSyntax value) {
	// TODO Auto-generated method stub
    }

//    @Override
//    public Collection<Template> getCalledTemplates() throws JmiException {
//    	// TODO Auto-generated method stub
//    	return null;
//    }
    
    @Override
	public String getSemDisambiguate() {
		return semDisambiguate;
	}

	@Override
	public void setSemDisambiguate(String newValue) {
		semDisambiguate = newValue;
	}

	@Override
	public TextBlockDefinition getTextBlockDefinition() {
		return textBlockDefinition;
	}

	@Override
	public void setTextBlockDefinition(TextBlockDefinition value) {
		textBlockDefinition = value;
	}

}
