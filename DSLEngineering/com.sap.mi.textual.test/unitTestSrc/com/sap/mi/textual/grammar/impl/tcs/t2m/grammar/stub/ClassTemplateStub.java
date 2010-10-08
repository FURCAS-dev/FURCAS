/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub;

import static org.junit.Assert.fail;

import com.sap.furcas.metamodel.TCS.ClassTemplate;
import com.sap.furcas.metamodel.TCS.ContextTags;
import com.sap.furcas.metamodel.TCS.OperatorList;

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
    public ContextTagsStub contextTags = new ContextTagsStub() {};

    public boolean isContext() {
        return isContext;
    }

    public void setContext(boolean isContext) {
        this.isContext = isContext;
    }

    public boolean isDeep() {
        return isDeep;
    }

    public void setDeep(boolean isDeep) {
        this.isDeep = isDeep;
    }

    public boolean isMain() {
        return isMain;
    }

    public void setMain(boolean isMain) {
        this.isMain = isMain;
    }

    public boolean isAbstract() {
        return isAbstract;
    }

    public void setAbstract(boolean isAbstract) {
        this.isAbstract = isAbstract;
    }

    public boolean isOperatored() {
        return isOperatored;
    }

    public void setOperatored(boolean isOperatored) {
        this.isOperatored = isOperatored;
    }

    /* (non-Javadoc)
     * @see TCS.ClassTemplate#getMode()
     */
    public String getMode() {
        return mode;
    }


    /* (non-Javadoc)
     * @see TCS.ClassTemplate#getOperatorList()
     */
    public OperatorList getOperatorList() {
        return operatorList;
    }

    /* (non-Javadoc)
     * @see TCS.ClassTemplate#getPrefixSequence()
     */
    public Sequence getPrefixSequence() {
        return null;
    }

    /* (non-Javadoc)
     * @see TCS.ClassTemplate#getTemplateSequence()
     */
    public Sequence getTemplateSequence() {
        return sequence;
    }

    /* (non-Javadoc)
     * @see TCS.ClassTemplate#isAddToContext()
     */
    public boolean isAddToContext() {
        
        return isAddToContext;
    }

    /* (non-Javadoc)
     * @see TCS.ClassTemplate#isMulti()
     */
    public boolean isMulti() {
        return isMulti;
    }

    /* (non-Javadoc)
     * @see TCS.ClassTemplate#isNonPrimary()
     */
    public boolean isNonPrimary() {
        return isNonPrimary;
    }

    /* (non-Javadoc)
     * @see TCS.ClassTemplate#setAddToContext(boolean)
     */
    public void setAddToContext(boolean value) {
        fail("not implemented yet");
        
    }

    /* (non-Javadoc)
     * @see TCS.ClassTemplate#setMulti(boolean)
     */
    public void setMulti(boolean value) {
        fail("not implemented yet");
        
    }

    /* (non-Javadoc)
     * @see TCS.ClassTemplate#setNonPrimary(boolean)
     */
    public void setNonPrimary(boolean value) {
        fail("not implemented yet");
        
    }

    /* (non-Javadoc)
     * @see TCS.ClassTemplate#setMode(java.lang.String)
     */
    public void setMode(String value) {
        fail("not implemented yet");
        
    }

    /* (non-Javadoc)
     * @see TCS.ClassTemplate#setOperatorList(TCS.OperatorList)
     */
    public void setOperatorList(OperatorList value) {
        operatorList = value;
    }

    /* (non-Javadoc)
     * @see TCS.ClassTemplate#setPrefixSequence(TCS.Sequence)
     */
    public void setPrefixSequence(Sequence value) {
        fail("not implemented yet");
        
    }

    /* (non-Javadoc)
     * @see TCS.ClassTemplate#setTemplateSequence(TCS.Sequence)
     */
    public void setTemplateSequence(Sequence value) {
        fail("not implemented yet");
        
    }

    /* (non-Javadoc)
     * @see tcs.ClassTemplate#isReferenceOnly()
     */
    @Override
    public boolean isReferenceOnly() throws JmiException {
        return referenceOnly;
    }

    /* (non-Javadoc)
     * @see tcs.ClassTemplate#setReferenceOnly(boolean)
     */
    @Override
    public void setReferenceOnly(boolean newValue) throws JmiException {
        fail("not implemented yet");
    }

    /* (non-Javadoc)
     * @see tcs.ClassTemplate#getContextTags()
     */
    @Override
    public ContextTags getContextTags() throws JmiException {
        return contextTags;
    }

    /* (non-Javadoc)
     * @see tcs.ClassTemplate#setContextTags(tcs.ContextTags)
     */
    @Override
    public void setContextTags(ContextTags newValue) throws JmiException {
        fail("not implemented yet");
        
    }

    


}
