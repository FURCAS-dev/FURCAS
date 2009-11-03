/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub;

import java.util.List;

import tcs.LocatedElement;
import tcs.Value;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefException;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.spi.core.Wrapper;

/**
 *
 */
public class LocatedElementStub extends com.sap.tc.moin.repository.core.jmi.reflect.RefClassImpl implements LocatedElement, Value {

    public String representation;
    
    private String loc;
    private List<String> cb;
    private List<String> ca;

    
    
    /**
     * 
     */
    public LocatedElementStub() {
        super();
        String id = this.toString() + Math.random();
        set___MofId(id);
    }

    /* (non-Javadoc)
     * @see TCS.LocatedElement#getCommentsAfter()
     */
    public List<String> getCommentsAfter() {
        return ca;
    }

    /* (non-Javadoc)
     * @see TCS.LocatedElement#getCommentsBefore()
     */
    public List<String> getCommentsBefore() {
        // TODO Auto-generated method stub
        return cb;
    }

    /* (non-Javadoc)
     * @see TCS.LocatedElement#getLocation()
     */
    public String getLocation() {
        // TODO Auto-generated method stub
        return loc;
    }

    /* (non-Javadoc)
     * @see TCS.LocatedElement#setLocation(java.lang.String)
     */
    public void setLocation(String value) {
        loc = value;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.core.jmi.reflect.RefClassImpl#get___Instance()
     */
    @Override
    public RefObject get___Instance() throws JmiException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.core.jmi.reflect.RefFeaturedImpl#invoke___Operation(com.sap.tc.moin.repository.core.CoreConnection, int, java.util.List)
     */
    @Override
    public Object invoke___Operation(CoreConnection connection,
            int operationNumber, List<? extends Object> args)
            throws RefException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.core.jmi.reflect.RefFeaturedImpl#refGetValue(java.lang.String)
     */
    @Override
    public Object refGetValue(String featureName) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.core.jmi.reflect.RefFeaturedImpl#refInvokeOperation(com.sap.tc.moin.repository.core.CoreConnection, java.lang.String, java.util.List)
     */
    @Override
    public Object refInvokeOperation(CoreConnection connection,
            String requestedOperation, List<? extends Object> args)
            throws RefException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.core.jmi.reflect.RefBaseObjectImpl#createWrapper(com.sap.tc.moin.repository.core.CoreConnection, boolean)
     */
    @Override
    public Wrapper<? extends RefBaseObject> createWrapper(CoreConnection conn,
            boolean synchronize) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefObject#refClass()
     */
    @Override
    public RefClass refClass() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefObject#refDelete()
     */
    @Override
    public void refDelete() {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefObject#refImmediateComposite()
     */
    @Override
    public RefFeatured refImmediateComposite() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefObject#refIsInstanceOf(com.sap.tc.moin.repository.mmi.reflect.RefObject, boolean)
     */
    @Override
    public boolean refIsInstanceOf(RefObject objType, boolean considerSubtypes) {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.reflect.RefObject#refOutermostComposite()
     */
    @Override
    public RefFeatured refOutermostComposite() {
        // TODO Auto-generated method stub
        return null;
    }


   
    

}
