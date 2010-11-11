/**
 * 
 */
package com.sap.furcas.metamodel.FURCAS.TCS.stubs;

import static org.junit.Assert.fail;

import org.eclipse.emf.common.util.EList;

import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ContextTags;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorList;
import com.sap.furcas.metamodel.FURCAS.TCS.ScopeArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.TemplateModifiers;

/**
 *
 */
public class ClassTemplateStub extends TemplateStub implements ClassTemplate {

    public boolean isContext, isDeep, isMain, isAbstract, isOperatored;
    public OperatorList operatorList;
    public Sequence sequence;
    public boolean isAddToContext;
    public String mode;
    public boolean isMulti;
    public boolean isNonPrimary;
    public boolean referenceOnly;
    public ContextTagsStub contextTags = new ContextTagsStub() {
    };
	public String semDisambiguate;

    @Override
    public boolean isIsContext() {
	return isContext;
    }

    @Override
    public void setIsContext(boolean isContext) {
	this.isContext = isContext;
    }

    @Override
    public boolean isIsDeep() {
	return isDeep;
    }

    @Override
    public void setIsDeep(boolean isDeep) {
	this.isDeep = isDeep;
    }

    @Override
    public boolean isIsMain() {
	return isMain;
    }

    @Override
    public void setIsMain(boolean isMain) {
	this.isMain = isMain;
    }

    @Override
    public boolean isIsAbstract() {
	return isAbstract;
    }

    @Override
    public void setIsAbstract(boolean isAbstract) {
	this.isAbstract = isAbstract;
    }

    @Override
    public boolean isIsOperatored() {
	return isOperatored;
    }

    @Override
    public void setIsOperatored(boolean isOperatored) {
	this.isOperatored = isOperatored;
    }

    /*
     * (non-Javadoc)
     * 
     * @see TCS.ClassTemplate#getMode()
     */
    @Override
    public String getMode() {
	return mode;
    }

    /*
     * (non-Javadoc)
     * 
     * @see TCS.ClassTemplate#getOperatorList()
     */
    @Override
    public OperatorList getOperatorList() {
	return operatorList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see TCS.ClassTemplate#getPrefixSequence()
     */
    @Override
    public Sequence getPrefixSequence() {
	return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see TCS.ClassTemplate#getTemplateSequence()
     */
    @Override
    public Sequence getTemplateSequence() {
	return sequence;
    }

    /*
     * (non-Javadoc)
     * 
     * @see TCS.ClassTemplate#isAddToContext()
     */
    @Override
    public boolean isIsAddToContext() {

	return isAddToContext;
    }

    /*
     * (non-Javadoc)
     * 
     * @see TCS.ClassTemplate#isMulti()
     */
    @Override
    public boolean isIsMulti() {
	return isMulti;
    }

    /*
     * (non-Javadoc)
     * 
     * @see TCS.ClassTemplate#isNonPrimary()
     */
    @Override
    public boolean isIsNonPrimary() {
	return isNonPrimary;
    }

    /*
     * (non-Javadoc)
     * 
     * @see TCS.ClassTemplate#setAddToContext(boolean)
     */
    @Override
    public void setIsAddToContext(boolean value) {
	fail("not implemented yet");

    }

    /*
     * (non-Javadoc)
     * 
     * @see TCS.ClassTemplate#setMulti(boolean)
     */
    @Override
    public void setIsMulti(boolean value) {
	fail("not implemented yet");

    }

    /*
     * (non-Javadoc)
     * 
     * @see TCS.ClassTemplate#setNonPrimary(boolean)
     */
    @Override
    public void setIsNonPrimary(boolean value) {
	fail("not implemented yet");

    }

    /*
     * (non-Javadoc)
     * 
     * @see TCS.ClassTemplate#setMode(java.lang.String)
     */
    @Override
    public void setMode(String value) {
	fail("not implemented yet");

    }

    /*
     * (non-Javadoc)
     * 
     * @see TCS.ClassTemplate#setOperatorList(TCS.OperatorList)
     */
    @Override
    public void setOperatorList(OperatorList value) {
	operatorList = value;
    }

    /*
     * (non-Javadoc)
     * 
     * @see TCS.ClassTemplate#setPrefixSequence(TCS.Sequence)
     */
    @Override
    public void setPrefixSequence(Sequence value) {
	fail("not implemented yet");

    }

    /*
     * (non-Javadoc)
     * 
     * @see TCS.ClassTemplate#setTemplateSequence(TCS.Sequence)
     */
    @Override
    public void setTemplateSequence(Sequence value) {
	fail("not implemented yet");

    }

    /*
     * (non-Javadoc)
     * 
     * @see tcs.ClassTemplate#isReferenceOnly()
     */
    @Override
    public boolean isIsReferenceOnly() {
	return referenceOnly;
    }

    /*
     * (non-Javadoc)
     * 
     * @see tcs.ClassTemplate#setReferenceOnly(boolean)
     */
    @Override
    public void setIsReferenceOnly(boolean newValue) {
	fail("not implemented yet");
    }

    /*
     * (non-Javadoc)
     * 
     * @see tcs.ClassTemplate#getContextTags()
     */
    @Override
    public ContextTags getContextTags() {
	return contextTags;
    }

    /*
     * (non-Javadoc)
     * 
     * @see tcs.ClassTemplate#setContextTags(tcs.ContextTags)
     */
    @Override
    public void setContextTags(ContextTags newValue) {
	fail("not implemented yet");

    }

    @Override
    public ScopeArg getScope() {
	fail("not implemented yet");
	return null;
    }

    @Override
    public void setScope(ScopeArg value) {
	fail("not implemented yet");

    }

    @Override
    public EList<TemplateModifiers> getModifiers() {
	fail("not implemented yet");
	return null;
    }

	@Override
	public String getSemDisambiguate() {
		return semDisambiguate;
	}

	@Override
	public void setSemDisambiguate(String value) {
		semDisambiguate = value;
	}

}
