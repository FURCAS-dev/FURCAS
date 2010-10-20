/**
 * 
 */
package com.sap.furcas.metamodel.FURCAS.TCS.stubs;

import static org.junit.Assert.fail;

import org.eclipse.emf.common.util.EList;

import com.sap.furcas.metamodel.FURCAS.TCS.ContextTags;
import com.sap.furcas.metamodel.FURCAS.TCS.Operator;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorList;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.PropertyReference;
import com.sap.furcas.metamodel.FURCAS.TCS.ScopeArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;

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
    public boolean isIsReferenceOnly() {
        return referenceOnly;
    }

    /* (non-Javadoc)
     * @see tcs.OperatorTemplate#setReferenceOnly(boolean)
     */
    @Override
    public void setIsReferenceOnly(boolean newValue) {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see tcs.OperatorTemplate#getStoreOperatorTo()
     */
    @Override
    public PropertyReference getStoreOperatorTo() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see tcs.OperatorTemplate#getStoreRightSideTo()
     */
    @Override
    public PropertyReference getStoreRightSideTo() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see tcs.OperatorTemplate#setStoreOperatorTo(tcs.PropertyReference)
     */
    @Override
    public void setStoreOperatorTo(PropertyReference newValue) {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see tcs.OperatorTemplate#setStoreRightSideTo(tcs.PropertyReference)
     */
    @Override
    public void setStoreRightSideTo(PropertyReference newValue) {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see tcs.OperatorTemplate#getContextTags()
     */
    @Override
    public ContextTags getContextTags() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see tcs.OperatorTemplate#setContextTags(tcs.ContextTags)
     */
    @Override
    public void setContextTags(ContextTags newValue) {
        fail("not implemented yet");
    }

    /* (non-Javadoc)
     * @see tcs.OperatorTemplate#getStoreLeftSideTo()
     */
    @Override
    public PropertyReference getStoreLeftSideTo() {
        return leftSideRef;
    }

    /* (non-Javadoc)
     * @see tcs.OperatorTemplate#setStoreLeftSideTo(tcs.PropertyReference)
     */
    @Override
    public void setStoreLeftSideTo(PropertyReference newValue) {
        fail("not implemented yet");
        
    }

    @Override
    public boolean isIsContext() {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public void setIsContext(boolean value) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public boolean isIsAddToContext() {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public void setIsAddToContext(boolean value) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public ScopeArg getScope() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void setScope(ScopeArg value) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public String getSource() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void setSource(String value) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public String getStoreOpTo() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void setStoreOpTo(String value) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public String getStoreRightTo() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void setStoreRightTo(String value) {
	// TODO Auto-generated method stub
	
    }


}
