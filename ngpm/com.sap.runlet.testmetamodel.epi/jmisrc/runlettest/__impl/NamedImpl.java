/**
 * Generated by the MOIN Generator Version 3.0
 **/

package runlettest.__impl;

public final class NamedImpl extends com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl {

        
    public static final java.util.Map<java.lang.String, java.lang.Integer> FEATURE_IDS;

    static {
        
        FEATURE_IDS = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
        FEATURE_IDS.put("name", Integer.valueOf(0)); //$NON-NLS-1$
    }
    
    
    // variable declarations
    private java.lang.String __name = null;

    // default constructor
    public NamedImpl() {
        super();
    }
    
    // specific constructor
    public NamedImpl(java.lang.Object workspace, String mofId, com.sap.tc.moin.repository.mmi.reflect.RefPackage immediatePackage, com.sap.tc.moin.repository.mmi.reflect.RefObject metaObject, com.sap.tc.moin.repository.mmi.reflect.RefClass refClass) {
        super(workspace, mofId, immediatePackage, metaObject, refClass);
    }
    
    // methods for attributes
    public java.lang.String getName() throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        return __name;
    }
    public void setName(java.lang.String newValue) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
          ___changeDataTypeAttribute(get___CurrentConnection(), 0, "E0BF480E8BFD96418B2011DECAC400155883529C", __name, newValue); //$NON-NLS-1$
    }
    public void setName(com.sap.tc.moin.repository.core.CoreConnection connection, java.lang.String newValue) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
          ___changeDataTypeAttribute(connection, 0, "E0BF480E8BFD96418B2011DECAC400155883529C", __name, newValue); //$NON-NLS-1$
    }

    // methods for internal attribute setter
    private void set__Name(java.lang.String newValue) {
            __name = newValue;
    }


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
                result = getName();
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
                ___changeDataTypeAttribute(connection, 0, "E0BF480E8BFD96418B2011DECAC400155883529C", __name, value); //$NON-NLS-1$
                break;
                    
        default:
            throw new com.sap.tc.moin.repository.mmi.reflect.InvalidCallException(featureName, null, "refSetValue(String)"); //$NON-NLS-1$
        }
    }

    public void set___Value(com.sap.tc.moin.repository.core.CoreSession session, java.lang.String featureName, java.lang.Object value) {
        switch (FEATURE_IDS.get(featureName)) {
            case 0:
                set__Name((java.lang.String) value);     
                break;
            default:
                throw new com.sap.tc.moin.repository.mmi.reflect.InvalidCallException(featureName, refMetaObject(), "set___Value(String)"); //$NON-NLS-1$
        }
    }

    public void set___Value(com.sap.tc.moin.repository.core.CoreSession session, int featureId, java.lang.Object value) {
        switch (featureId) {
            case 0:
                set__Name((java.lang.String) value);     
                break;
            default:
                throw new com.sap.tc.moin.repository.mmi.reflect.InvalidCallException(featureId, refMetaObject(), "set___Value(int)"); //$NON-NLS-1$
        }
    }

    public void addOrSet___Value(com.sap.tc.moin.repository.core.CoreSession session, java.lang.String featureName, java.lang.Object value) {
        switch (FEATURE_IDS.get(featureName)) {
            case 0:
                set__Name((java.lang.String) value);     
                break;
            default:
                throw new com.sap.tc.moin.repository.mmi.reflect.InvalidCallException(featureName, refMetaObject(), "addOrSet___Value(String)"); //$NON-NLS-1$
        }
    }    



    // get the JMI interface
    @SuppressWarnings("unchecked")
    public java.lang.Class<runlettest.Named> get___JmiInterface() {
        return runlettest.Named.class;
    }

    // create the wrapper
    @Override
    public com.sap.tc.moin.repository.spi.core.Wrapper<runlettest.__impl.NamedImpl> createWrapper(com.sap.tc.moin.repository.core.CoreConnection conn, boolean synchronize) {
        return new runlettest.__impl.NamedWrapper(conn, this, synchronize);
    }
    
}