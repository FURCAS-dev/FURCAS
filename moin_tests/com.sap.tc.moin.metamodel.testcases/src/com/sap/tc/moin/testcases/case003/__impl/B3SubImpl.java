/**
 * Generated by the MOIN Generator Version 3.0
 **/

package com.sap.tc.moin.testcases.case003.__impl;

public final class B3SubImpl extends com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl {

        
    public static final java.util.Map<java.lang.String, java.lang.Integer> FEATURE_IDS;
    
    static {
        
        FEATURE_IDS = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
        FEATURE_IDS.put("Z", Integer.valueOf(0)); //$NON-NLS-1$
    }
    
    // default constructor
    public B3SubImpl() {
        super();
    }
    
    // specific constructor
    public B3SubImpl(java.lang.Object workspace, String mofId, com.sap.tc.moin.repository.mmi.reflect.RefPackage immediatePackage, com.sap.tc.moin.repository.mmi.reflect.RefObject metaObject, com.sap.tc.moin.repository.mmi.reflect.RefClass refClass) {
        super(workspace, mofId, immediatePackage, metaObject, refClass);
    }
    
    // methods for references
    public com.sap.tc.moin.repository.mmi.reflect.RefBaseObject getZ() throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        com.sap.tc.moin.repository.core.EndAndMetaObject endAndMetaObject = get___EndAndMetaObject( "45F120A511DCF8957F674BCA1874EEC8A71CBFF1" /* attribute or association */, 0 ); //$NON-NLS-1$
        return (com.sap.tc.moin.repository.mmi.reflect.RefBaseObject) ___queryElementAtOtherLinkEnd( get___CurrentConnection(), this, endAndMetaObject );
       
    }
    public com.sap.tc.moin.repository.mmi.reflect.RefBaseObject getZ(com.sap.tc.moin.repository.core.CoreConnection connection) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        com.sap.tc.moin.repository.core.EndAndMetaObject endAndMetaObject = get___EndAndMetaObject( "45F120A511DCF8957F674BCA1874EEC8A71CBFF1" /* attribute or association */, 0 ); //$NON-NLS-1$
        return (com.sap.tc.moin.repository.mmi.reflect.RefBaseObject) ___queryElementAtOtherLinkEnd( connection, this, endAndMetaObject );
       
    }
    public void setZ(com.sap.tc.moin.repository.mmi.reflect.RefBaseObject newValue) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
          ___changeReference(get___CurrentConnection(), /* mofId of association */ "45F120A511DCF8957F674BCA1874EEC8A71CBFF1", /* mofId of reference */ "45F120A515CEC5F7FDC043CA2E90B739487A7DB7" , newValue, 0); //$NON-NLS-1$ //$NON-NLS-2$
    
    }
    public void setZ(com.sap.tc.moin.repository.core.CoreConnection connection, com.sap.tc.moin.repository.mmi.reflect.RefBaseObject newValue) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
          ___changeReference(connection, /* mofId of association */ "45F120A511DCF8957F674BCA1874EEC8A71CBFF1", /* mofId of reference */ "45F120A515CEC5F7FDC043CA2E90B739487A7DB7" , newValue, 0); //$NON-NLS-1$ //$NON-NLS-2$
    
    }

    // methods for internal attribute setter

    // reflective methods
    public java.lang.Object refGetValue(com.sap.tc.moin.repository.core.CoreConnection connection, java.lang.String featureName) {
        if (featureName == null) {
            throw new com.sap.tc.moin.repository.mmi.reflect.InvalidNameException(featureName);
        }
        java.lang.Object result = null;
        java.lang.Integer featureId = FEATURE_IDS.get(featureName);
        if (featureId == null) {
            throw new com.sap.tc.moin.repository.mmi.reflect.InvalidCallException(featureName, refMetaObject(), "refGetValue(String)"); //$NON-NLS-1$
        }
        switch (featureId) {
            case 0: 
                result = getZ(connection);
                break;
        default:
            throw new com.sap.tc.moin.repository.mmi.reflect.InvalidCallException(featureName, refMetaObject(), "refGetValue(String)"); //$NON-NLS-1$
        }
        return result;
    }
    
    public void refSetValue(com.sap.tc.moin.repository.core.CoreConnection connection, java.lang.String featureName, java.lang.Object value) {
        if (featureName == null) {
            throw new com.sap.tc.moin.repository.mmi.reflect.InvalidNameException(featureName);
        }
        java.lang.Integer featureId = FEATURE_IDS.get(featureName);
        if (featureId == null) {
            throw new com.sap.tc.moin.repository.mmi.reflect.InvalidCallException(featureName, refMetaObject(), "refSetValue(String)"); //$NON-NLS-1$
        }
        switch (featureId) {
            case 0:
                ___changeReference(connection, "45F120A511DCF8957F674BCA1874EEC8A71CBFF1" /* mofId of association */, "45F120A515CEC5F7FDC043CA2E90B739487A7DB7" /* mofId of reference */, value, 0); //$NON-NLS-1$ //$NON-NLS-2$     
                break;
                    
        default:
            throw new com.sap.tc.moin.repository.mmi.reflect.InvalidCallException(featureName, null, "refSetValue(String)"); //$NON-NLS-1$
        }
    }
    
    public void set___Value(com.sap.tc.moin.repository.core.CoreSession session, java.lang.String featureName, java.lang.Object value) {
        switch (FEATURE_IDS.get(featureName)) {
            default:
                throw new com.sap.tc.moin.repository.mmi.reflect.InvalidCallException(featureName, refMetaObject(), "set___Value(String)"); //$NON-NLS-1$
        }
    }
    
    public void set___Value(com.sap.tc.moin.repository.core.CoreSession session, int featureId, java.lang.Object value) {
        switch (featureId) {
            default:
                throw new com.sap.tc.moin.repository.mmi.reflect.InvalidCallException(featureId, refMetaObject(), "set___Value(int)"); //$NON-NLS-1$
        }
    }
    
    public void addOrSet___Value(com.sap.tc.moin.repository.core.CoreSession session, java.lang.String featureName, java.lang.Object value) {
        switch (FEATURE_IDS.get(featureName)) {
            default:
                throw new com.sap.tc.moin.repository.mmi.reflect.InvalidCallException(featureName, refMetaObject(), "addOrSet___Value(String)"); //$NON-NLS-1$
        }
    }    
    


    // get the JMI interface
    public java.lang.Class<com.sap.tc.moin.testcases.case003.B3Sub> get___JmiInterface() {
        return com.sap.tc.moin.testcases.case003.B3Sub.class;
    }

    // create the wrapper
    @Override
    public com.sap.tc.moin.repository.spi.core.Wrapper<com.sap.tc.moin.testcases.case003.__impl.B3SubImpl> createWrapper(com.sap.tc.moin.repository.core.CoreConnection conn, boolean synchronize) {
        return new com.sap.tc.moin.testcases.case003.__impl.B3SubWrapper(conn, this, synchronize);
    }
    
}