/**
 * Generated by the MOIN Generator Version 3.0
 **/

package com.sap.tc.moin.testcases.case019.translatabletexts.__impl;

public final class TranslatabletextsPackageImpl extends com.sap.tc.moin.repository.core.jmi.reflect.RefPackageImpl
{
    
    static {
    }

    // constructors    
    public TranslatabletextsPackageImpl()
    {
        super();
    }
    public TranslatabletextsPackageImpl(java.lang.Object workspace, java.lang.String mofId, com.sap.tc.moin.repository.mmi.reflect.RefPackage immediatePackage, com.sap.tc.moin.repository.mmi.reflect.RefObject metaObject)
    {
        super(workspace, mofId, immediatePackage, metaObject);
    }
    // internal enumeration creators
    // internal structure type creators
    public com.sap.tc.moin.repository.mmi.reflect.RefStruct create___RefStruct(Object workspace, com.sap.tc.moin.repository.mmi.model.StructureType structType) {
        com.sap.tc.moin.repository.mmi.reflect.RefStruct result = null;
        String structName = structType.getName();
        try {
                if (structName.equals("A19TranslatableTextFragment")) { //$NON-NLS-1$
                  result = new com.sap.tc.moin.testcases.case019.translatabletexts.__impl.A19TranslatableTextFragmentImpl(workspace, structType);
                }
                else if (structName.equals("A19TranslatableText")) { //$NON-NLS-1$
                  result = new com.sap.tc.moin.testcases.case019.translatabletexts.__impl.A19TranslatableTextImpl(workspace, structType);
                }
        return result;
        }
        catch(java.lang.Exception ex) {
           throw new com.sap.tc.moin.repository.mmi.reflect.JmiException(ex);
        }
    }
    // nested packages
    // classes
    // associations
    // structure type creators
    public com.sap.tc.moin.testcases.case019.translatabletexts.A19TranslatableTextFragment createA19TranslatableTextFragment(com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer<? super com.sap.tc.moin.testcases.case019.translatabletexts.A19TranslatableTextFragment> structureFieldContainer) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        com.sap.tc.moin.testcases.case019.translatabletexts.__impl.A19TranslatableTextFragmentImpl result = new com.sap.tc.moin.testcases.case019.translatabletexts.__impl.A19TranslatableTextFragmentImpl(get___CurrentConnection().getSession().getWorkspace(), (com.sap.tc.moin.repository.mmi.model.ModelElement) get___MetamodelElement("48DA2D8A6172FFA58A3111DD9A800019993BAD15")); //$NON-NLS-1$
        result.initialize___Values(get___CurrentConnection());
        result.set___Value(com.sap.tc.moin.testcases.case019.translatabletexts.A19TranslatableTextFragment.DESCRIPTORS.TRANS_UNIT_ID().getName(), com.sap.tc.moin.repository.core.jmi.util.MoinMetamodelCode.createGUID());
        if (structureFieldContainer != null) {
            java.util.Map<?, Object> fields = structureFieldContainer.getFields();
            for (java.util.Map.Entry<?, Object> field : fields.entrySet()) {
                java.lang.String fieldName = ((com.sap.tc.moin.repository.mmi.descriptors.StructureFieldDescriptor<?, ? super com.sap.tc.moin.testcases.case019.translatabletexts.A19TranslatableTextFragment, ?>)field.getKey()).getName();
                if (com.sap.tc.moin.testcases.case019.translatabletexts.__impl.A19TranslatableTextFragmentImpl.FEATURE_IDS.containsKey(fieldName)) {
                    result.set___Value(fieldName, field.getValue());
                }
            }
        }
        return result;
    }
    public com.sap.tc.moin.testcases.case019.translatabletexts.A19TranslatableTextFragment createA19TranslatableTextFragment(com.sap.tc.moin.repository.core.CoreConnection connection, com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer<? super com.sap.tc.moin.testcases.case019.translatabletexts.A19TranslatableTextFragment> structureFieldContainer) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        com.sap.tc.moin.testcases.case019.translatabletexts.__impl.A19TranslatableTextFragmentImpl result = new com.sap.tc.moin.testcases.case019.translatabletexts.__impl.A19TranslatableTextFragmentImpl(connection.getSession().getWorkspace(), (com.sap.tc.moin.repository.mmi.model.ModelElement) get___MetamodelElement("48DA2D8A6172FFA58A3111DD9A800019993BAD15")); //$NON-NLS-1$
        result.initialize___Values(connection);
        result.set___Value(com.sap.tc.moin.testcases.case019.translatabletexts.A19TranslatableTextFragment.DESCRIPTORS.TRANS_UNIT_ID().getName(), com.sap.tc.moin.repository.core.jmi.util.MoinMetamodelCode.createGUID());
        if (structureFieldContainer != null) {
            java.util.Map<?, Object> fields = structureFieldContainer.getFields();
            for (java.util.Map.Entry<?, Object> field : fields.entrySet()) {
                java.lang.String fieldName = ((com.sap.tc.moin.repository.mmi.descriptors.StructureFieldDescriptor<?, ? super com.sap.tc.moin.testcases.case019.translatabletexts.A19TranslatableTextFragment, ?>)field.getKey()).getName();
                if (com.sap.tc.moin.testcases.case019.translatabletexts.__impl.A19TranslatableTextFragmentImpl.FEATURE_IDS.containsKey(fieldName)) {
                    result.set___Value(fieldName, field.getValue());
                }
            }
        }
        return result;
    }
    public com.sap.tc.moin.testcases.case019.translatabletexts.A19TranslatableText createA19TranslatableText(com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer<? super com.sap.tc.moin.testcases.case019.translatabletexts.A19TranslatableText> structureFieldContainer) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        com.sap.tc.moin.testcases.case019.translatabletexts.__impl.A19TranslatableTextImpl result = new com.sap.tc.moin.testcases.case019.translatabletexts.__impl.A19TranslatableTextImpl(get___CurrentConnection().getSession().getWorkspace(), (com.sap.tc.moin.repository.mmi.model.ModelElement) get___MetamodelElement("48DA2D8A6172FFA78A3111DDAE760019993BAD15")); //$NON-NLS-1$
        result.initialize___Values(get___CurrentConnection());
        result.set___Value(com.sap.tc.moin.testcases.case019.translatabletexts.A19TranslatableText.DESCRIPTORS.TRANS_UNIT_ID().getName(), com.sap.tc.moin.repository.core.jmi.util.MoinMetamodelCode.createGUID());
        if (structureFieldContainer != null) {
            java.util.Map<?, Object> fields = structureFieldContainer.getFields();
            for (java.util.Map.Entry<?, Object> field : fields.entrySet()) {
                java.lang.String fieldName = ((com.sap.tc.moin.repository.mmi.descriptors.StructureFieldDescriptor<?, ? super com.sap.tc.moin.testcases.case019.translatabletexts.A19TranslatableText, ?>)field.getKey()).getName();
                if (com.sap.tc.moin.testcases.case019.translatabletexts.__impl.A19TranslatableTextImpl.FEATURE_IDS.containsKey(fieldName)) {
                    result.set___Value(fieldName, field.getValue());
                }
            }
        }
        return result;
    }
    public com.sap.tc.moin.testcases.case019.translatabletexts.A19TranslatableText createA19TranslatableText(com.sap.tc.moin.repository.core.CoreConnection connection, com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer<? super com.sap.tc.moin.testcases.case019.translatabletexts.A19TranslatableText> structureFieldContainer) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        com.sap.tc.moin.testcases.case019.translatabletexts.__impl.A19TranslatableTextImpl result = new com.sap.tc.moin.testcases.case019.translatabletexts.__impl.A19TranslatableTextImpl(connection.getSession().getWorkspace(), (com.sap.tc.moin.repository.mmi.model.ModelElement) get___MetamodelElement("48DA2D8A6172FFA78A3111DDAE760019993BAD15")); //$NON-NLS-1$
        result.initialize___Values(connection);
        result.set___Value(com.sap.tc.moin.testcases.case019.translatabletexts.A19TranslatableText.DESCRIPTORS.TRANS_UNIT_ID().getName(), com.sap.tc.moin.repository.core.jmi.util.MoinMetamodelCode.createGUID());
        if (structureFieldContainer != null) {
            java.util.Map<?, Object> fields = structureFieldContainer.getFields();
            for (java.util.Map.Entry<?, Object> field : fields.entrySet()) {
                java.lang.String fieldName = ((com.sap.tc.moin.repository.mmi.descriptors.StructureFieldDescriptor<?, ? super com.sap.tc.moin.testcases.case019.translatabletexts.A19TranslatableText, ?>)field.getKey()).getName();
                if (com.sap.tc.moin.testcases.case019.translatabletexts.__impl.A19TranslatableTextImpl.FEATURE_IDS.containsKey(fieldName)) {
                    result.set___Value(fieldName, field.getValue());
                }
            }
        }
        return result;
    }

    protected java.lang.Object create___Extent(java.lang.Object workspace, java.lang.String mofId, com.sap.tc.moin.repository.mmi.reflect.RefPackage immediatePackage, com.sap.tc.moin.repository.mmi.reflect.RefObject metaObject) {
        java.lang.String name = ((com.sap.tc.moin.repository.mmi.model.ModelElement) metaObject).getName();
        throw new com.sap.tc.moin.repository.mmi.reflect.InvalidCallException(name, null, "create___Extent()"); //$NON-NLS-1$        
    }

    public java.lang.Class<com.sap.tc.moin.testcases.case019.translatabletexts.TranslatabletextsPackage> get___JmiInterface() {
        return com.sap.tc.moin.testcases.case019.translatabletexts.TranslatabletextsPackage.class;
    }
    
    protected void initialize() {
        if (___refPackages == null) {
            ___refPackages = new java.util.ArrayList<RefPackageAndName>(0);
            ___refPackagesByName = new java.util.HashMap<String, RefPackageAndName>();
            java.lang.String name = ""; //$NON-NLS-1$
            RefPackageAndName rpan = null;
        }
  
        if (___refClasses == null) {
            ___refClasses = new java.util.ArrayList<RefClassAndName>(0);
            ___refClassesByName = new java.util.HashMap<String, RefClassAndName>();
            java.lang.String name = ""; //$NON-NLS-1$
            RefClassAndName rcan = null;
        }
  
        if (___refAssociations == null) {
            ___refAssociations = new java.util.ArrayList<RefAssociationAndName>(0);
            ___refAssociationsByName = new java.util.HashMap<String, RefAssociationAndName>();
            java.lang.String name = ""; //$NON-NLS-1$
            RefAssociationAndName raan = null;
        }
    }
    
    @Override
    public com.sap.tc.moin.repository.spi.core.Wrapper<com.sap.tc.moin.testcases.case019.translatabletexts.__impl.TranslatabletextsPackageImpl> createWrapper(com.sap.tc.moin.repository.core.CoreConnection conn, boolean synchronize) {
        return new com.sap.tc.moin.testcases.case019.translatabletexts.__impl.TranslatabletextsPackageWrapper(conn, this, synchronize);
    }

}