/**
 * Generated by the MOIN Generator Version 3.0
 **/

package com.sap.tc.moin.textverticalization.__impl;

public final class TranslatableTextFragmentImpl extends com.sap.tc.moin.repository.core.jmi.reflect.RefStructImpl implements com.sap.tc.moin.textverticalization.TranslatableTextFragment
{
    private static final long serialVersionUID = 1L;

    private static final java.util.List<String> QUALIFIED_NAME = java.util.Collections.unmodifiableList(java.util.Arrays.asList(new String[] { "textverticalization", "TranslatableTextFragment" })); //$NON-NLS-1$ //$NON-NLS-2$
    
    private static final java.util.List<String> STRUCTURE_FIELD_NAMES = java.util.Collections.unmodifiableList(java.util.Arrays.asList(new String[] { "maxWidth", "originalText", "resType", "translate", "transUnitId" })); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$

        
    public static final java.util.Map<java.lang.String, java.lang.Integer> FEATURE_IDS;
    
    static {
        
        FEATURE_IDS = new java.util.HashMap<java.lang.String, java.lang.Integer>();
        FEATURE_IDS.put("maxWidth", Integer.valueOf(0)); //$NON-NLS-1$
        FEATURE_IDS.put("originalText", Integer.valueOf(1)); //$NON-NLS-1$
        FEATURE_IDS.put("resType", Integer.valueOf(2)); //$NON-NLS-1$
        FEATURE_IDS.put("translate", Integer.valueOf(3)); //$NON-NLS-1$
        FEATURE_IDS.put("transUnitId", Integer.valueOf(4)); //$NON-NLS-1$
    }

    // default constructor
    public TranslatableTextFragmentImpl() {
        super();
    }
    // JMI constructor
    public TranslatableTextFragmentImpl(java.lang.Object workspace, com.sap.tc.moin.repository.mmi.reflect.RefObject metaObject) {
        super(workspace, metaObject);
    }

    protected java.util.List<String> ___getTypeName() {
        return QUALIFIED_NAME;
    }

    protected java.util.List<String> ___getFieldNames() {
        return STRUCTURE_FIELD_NAMES;
    }

    // variable declarations
    private int __maxWidth;
    private java.lang.String __originalText;
    private java.lang.String __resType;
    private boolean __translate;
    private java.lang.String __transUnitId;
    // fields
    public int getMaxWidth() throws com.sap.tc.moin.repository.mmi.reflect.JmiException 
    {
        return __maxWidth;
    }
    public java.lang.String getOriginalText() throws com.sap.tc.moin.repository.mmi.reflect.JmiException 
    {
        return __originalText;
    }
    public java.lang.String getResType() throws com.sap.tc.moin.repository.mmi.reflect.JmiException 
    {
        return __resType;
    }
    public boolean isTranslate() throws com.sap.tc.moin.repository.mmi.reflect.JmiException 
    {
        return __translate;
    }
    public java.lang.String getTransUnitId() throws com.sap.tc.moin.repository.mmi.reflect.JmiException 
    {
        return __transUnitId;
    }

    // get a value
    public Object refGetValue(String featureName) {
        Object result = null;
        java.lang.Integer featureId = FEATURE_IDS.get(featureName);
        if (featureId == null) {
            throw new com.sap.tc.moin.repository.mmi.reflect.InvalidCallException(featureName, get___MetaObject(), "refGetValue(String)"); //$NON-NLS-1$
        }
        switch (featureId) {
            case 0: 
                result = getMaxWidth();
                break;
            case 1: 
                result = getOriginalText();
                break;
            case 2: 
                result = getResType();
                break;
            case 3: 
                result = isTranslate();
                break;
            case 4: 
                result = getTransUnitId();
                break;
            default:
                throw new com.sap.tc.moin.repository.mmi.reflect.InvalidCallException(featureName, null, "refGetValue(String)"); //$NON-NLS-1$
        }
        return result;}
    
    public void initialize___Values(com.sap.tc.moin.repository.core.CoreConnection connection) {
        set__MaxWidth(255);
        set__Translate(true);
    }

    public void set__MaxWidth(int newValue) {
        __maxWidth = newValue;
    }
    public void set__OriginalText(java.lang.String newValue) {
        __originalText = newValue;
    }
    public void set__ResType(java.lang.String newValue) {
        __resType = newValue;
    }
    public void set__Translate(boolean newValue) {
        __translate = newValue;
    }
    public void set__TransUnitId(java.lang.String newValue) {
        __transUnitId = newValue;
    }
    // set the value internally
    public void set___Value(String featureName, Object value) {
        switch (FEATURE_IDS.get(featureName)) {
            case 0:
                set__MaxWidth((java.lang.Integer) value);     
                break;
            case 1:
                set__OriginalText((java.lang.String) value);     
                break;
            case 2:
                set__ResType((java.lang.String) value);     
                break;
            case 3:
                set__Translate((java.lang.Boolean) value);     
                break;
            case 4:
                set__TransUnitId((java.lang.String) value);     
                break;
            default:
                throw new com.sap.tc.moin.repository.mmi.reflect.InvalidCallException(featureName, null, "set___Value(String)"); //$NON-NLS-1$
        }}
}