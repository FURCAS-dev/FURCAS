/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub;

import static org.junit.Assert.fail;

import org.eclipse.emf.common.util.EList;

import com.sap.furcas.metamodel.TCS.ContextTags;
import com.sap.furcas.metamodel.TCS.Operator;
import com.sap.furcas.metamodel.TCS.OperatorList;
import com.sap.furcas.metamodel.TCS.OperatorTemplate;
import com.sap.furcas.metamodel.TCS.PropertyReference;
import com.sap.furcas.metamodel.TCS.Sequence;

/**
 *
 */
public class OperatorTemplateStub extends TemplateStub implements OperatorTemplate {

    public boolean isContext, isDeep, isMain, isAbstract, isOperatored;
    public OperatorList operatorList;
    public boolean referenceOnly;
    private final PropertyReference leftSideRef = null;

    public boolean isContext() {
        return isContext;
    }

    public void setContext(boolean isContext) {
        this.isContext = isContext;
    }

    /* (non-Javadoc)
     * @see TCS.OperatorTemplate#getOperators()
     */
    @Override
    public EList<Operator> getOperators() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see TCS.OperatorTemplate#getOtSequence()
     */
    @Override
    public Sequence getOtSequence() {
        // TODO Auto-generated method stub
        return null;
    }

 

    /* (non-Javadoc)
     * @see TCS.OperatorTemplate#setOtSequence(TCS.Sequence)
     */
    @Override
    public void setOtSequence(Sequence value) {
        // TODO Auto-generated method stub
        
    }

  

    /* (non-Javadoc)
     * @see tcs.OperatorTemplate#isReferenceOnly()
     */
    @Override
    public boolean isReferenceOnly() throws JmiException {
        return referenceOnly;
    }

    /* (non-Javadoc)
     * @see tcs.OperatorTemplate#setReferenceOnly(boolean)
     */
    @Override
    public void setReferenceOnly(boolean newValue) throws JmiException {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see tcs.OperatorTemplate#getStoreOperatorTo()
     */
    @Override
    public PropertyReference getStoreOperatorTo() throws JmiException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see tcs.OperatorTemplate#getStoreRightSideTo()
     */
    @Override
    public PropertyReference getStoreRightSideTo() throws JmiException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see tcs.OperatorTemplate#setStoreOperatorTo(tcs.PropertyReference)
     */
    @Override
    public void setStoreOperatorTo(PropertyReference newValue)
            throws JmiException {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see tcs.OperatorTemplate#setStoreRightSideTo(tcs.PropertyReference)
     */
    @Override
    public void setStoreRightSideTo(PropertyReference newValue)
            throws JmiException {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see tcs.OperatorTemplate#getContextTags()
     */
    @Override
    public ContextTags getContextTags() throws JmiException {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see tcs.OperatorTemplate#setContextTags(tcs.ContextTags)
     */
    @Override
    public void setContextTags(ContextTags newValue) throws JmiException {
        fail("not implemented yet");
    }

    /* (non-Javadoc)
     * @see tcs.OperatorTemplate#getStoreLeftSideTo()
     */
    @Override
    public PropertyReference getStoreLeftSideTo() throws JmiException {
        return leftSideRef;
    }

    /* (non-Javadoc)
     * @see tcs.OperatorTemplate#setStoreLeftSideTo(tcs.PropertyReference)
     */
    @Override
    public void setStoreLeftSideTo(PropertyReference newValue)
            throws JmiException {
        fail("not implemented yet");
        
    }

  

}
